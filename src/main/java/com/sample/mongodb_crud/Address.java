package com.sample.mongodb_crud;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    public String country;
    public String city;
    public String postCode;
}
