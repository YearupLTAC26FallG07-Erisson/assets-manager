package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> myAssets = new ArrayList<>();

        // Regular Assets
        myAssets.add(new Asset("cash in wallet", "2026-01-01", new BigDecimal("320.00")));
        myAssets.add(new Asset("cash under bed", "2023-01-01", new BigDecimal("1000.00")));

        // At least two Houses
        myAssets.add(new House("main house", "2026-02-01", new BigDecimal("250000.00"),
                "123 Main St", 1, 2300, 10000));
        myAssets.add(new House("vacation home", "2010-02-01", new BigDecimal("150000.00"),
                "456 Lake Rd", 2, 2000, 43000));

        // At least two Vehicles
        myAssets.add(new Vehicle("my daily driver", "2024-03-01", new BigDecimal("28000.00"),
                "Honda Civic", 2024, 115000));
        myAssets.add(new Vehicle("Tom's truck", "2016-03-01", new BigDecimal("15000.00"),
                "Ford Focus", 2016, 120000));

        BigDecimal netWorth = BigDecimal.ZERO;

        for (int i = 0; i < myAssets.size(); i++) {
            Asset asset = myAssets.get(i);
            String message = "";

            if (asset instanceof House) {
                House house = (House) asset;
                message = " -> House at " + house.getAddress();
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                message = " -> Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel();
            }

            System.out.println(asset + message);
            netWorth = netWorth.add(asset.getValue());
        }

        System.out.println("\nYour net worth: $" + netWorth);
    }
}
