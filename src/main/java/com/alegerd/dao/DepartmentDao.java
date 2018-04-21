package com.alegerd.dao;

import com.alegerd.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao extends GenericDao<Department, Long>{

    public DepartmentDao() {
        super(Department.class);
    }

}
