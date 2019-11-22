package com.handen.SpringExercise;

import com.handen.SpringExercise.model.Advertiser;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdvertiserMapper {
    @Insert("INSERT into advertisers (name, contact_name, credit_limit) VALUES (#{name}, #{contactName}, #{creditLimit})")
     void insertAdvertiser(Advertiser advertiser);

    @Update("UPDATE advertisers " +
            "SET name = #{name}, contact_name = #{contactName}, credit_limit = #{credit_limit} WHERE id = #{id}")
    void updateAdvertiser(Advertiser advertiser);

    @Delete("DELETE FROM advertisers WHERE id = #{id}")
    void deleteAdvertiser(Integer id);

    @Select("SELECT * FROM advertisers WHERE id = #{id}")
    Advertiser getAdvertiser(Integer id);

    @Select("SELECT advertisers.credit_limit from advertisers WHERE id = #{id}")
    Integer getCredits(Integer id);

    @Select("SELECT * FROM advertisers")
    List<Advertiser> getAllAdvertisers();
}
