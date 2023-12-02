package com.example.schoolstock.dtos;


import lombok.Data;

import java.util.UUID;

@Data
public class RefreshTokenDTO {
    private UUID token;
}
