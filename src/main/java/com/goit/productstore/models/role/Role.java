package com.goit.productstore.models.role;

import com.goit.productstore.models.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "role_name")
    private String roleName;


    @Override
    public String toString(){
        return roleName;
    }
}
