package com.example.sht.homework;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

//
public class User extends BmobUser {

        private String name;
        private String address;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }



}
