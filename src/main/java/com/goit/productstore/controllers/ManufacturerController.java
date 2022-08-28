package com.goit.productstore.controllers;

import com.goit.productstore.models.manufacturer.Manufacturer;
import com.goit.productstore.models.manufacturer.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @RequestMapping("/manufacturer")
    public ModelAndView viewManufacturerPage(){
        List<Manufacturer> listManufacturers = manufacturerService.getAll();
        ModelAndView result = new ModelAndView("manufacturer");
        result.addObject("listManufacturers", listManufacturers);
        return result;
    }

    @RequestMapping("/createManufacturer")
    public ModelAndView viewCreateManufacturerPage(){
        Manufacturer manufacturer = new Manufacturer();
        ModelAndView result = new ModelAndView("createManufacturer");
        result.addObject("manufacturer", manufacturer);
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveNewManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        ModelAndView result = new ModelAndView("manufacturer");
        List<Manufacturer> listManufacturers = manufacturerService.getAll();
        result.addObject("listManufacturers", listManufacturers);
        return result;
    }

    @RequestMapping("/update/{uuid}")
    public ModelAndView showUpdateManufacturerPage(@PathVariable(name = "uuid") UUID uuid) {
        ModelAndView result = new ModelAndView("updateManufacturer");
        Manufacturer manufacturer = manufacturerService.getByUuid(uuid);
        result.addObject("manufacturer", manufacturer);

        return result;
    }

    @RequestMapping("/delete/{uuid}")
    public ModelAndView deleteManufacturer(@PathVariable(name = "uuid") UUID uuid){
        manufacturerService.deleteById(uuid);
        ModelAndView result = new ModelAndView("manufacturer");
        List<Manufacturer> listManufacturers = manufacturerService.getAll();
        result.addObject("listManufacturers", listManufacturers);
        return result;
    }


}
