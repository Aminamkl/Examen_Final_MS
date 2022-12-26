package com.example.inventoryquerysid.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Category {
    @Id
    private String id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
