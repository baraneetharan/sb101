package com.kgisl.sb101.entity;

import org.springframework.data.annotation.Id;

public record Person(@Id int id, String uname, String email) {
}