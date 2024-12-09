package com.io.gson;

public class User {
  int id;
  String name;
  String username;
  String email;
  String phone;
  String website;
  Address address;

  public class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;

    public class Geo {
      String lat;
      String lng;
    }
  }

  public class Company {
    String name;
    String catchPhrase;
    String bs;
  }
}
