package com.example.zerobase.book.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopInfo {

    private String userName;

    private String shopName;

    private String shopPosition;

    private String description;

}
