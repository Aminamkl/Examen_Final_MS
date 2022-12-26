package com.example.inventoryquerysid.respositories;



import com.example.inventoryquerysid.entites.Category;
import com.example.inventoryquerysid.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
}
