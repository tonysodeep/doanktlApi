package com.hutech.doananktl.repositories;

import com.hutech.doananktl.models.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<Example,Long> {
}
