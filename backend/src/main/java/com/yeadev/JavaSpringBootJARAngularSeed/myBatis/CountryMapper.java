package com.yeadev.JavaSpringBootJARAngularSeed.myBatis;

import com.yeadev.JavaSpringBootJARAngularSeed.jdbc.models.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CountryMapper {

    @Select("select * from country where id= #{id}")
    Country findById(@Param("id") long id);

    @Select("select * from country")
    List<Country> findAll();


}
