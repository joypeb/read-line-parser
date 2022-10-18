package com.hospital;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private Integer emergencyRoom;
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String district, String category, Integer emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    public String getSqlInsertQuery() {
        String sql = String.format("INSERT INTO `likelion-db`.`seoul_hospital`\n" +
                "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                "VALUES\n" +
                "(\"%s\",\n" +
                "\"%s\",\n" +
                "\"%s\",\n" +
                "\"%s\",\n" +
                "%d,\n" +
                "\"%s\",\n" +
                "\"%s\");", this.id, this.address, this.district, this.category, this.emergencyRoom, this.name, this.subdivision);
        return sql;
    }

    public String getSqlQuery() {
        return String.format("INSERT INTO `likelionDB`.`seoul_hospital`\n" +
                "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                "VALUES\n");
    }

    public String getSqlQueryValue() {
        return String.format("(" + this.id + "," + this.address + "," + this.district + "," + this.category + "," + this.emergencyRoom + "," + this.name + "," + this.subdivision + ")");
    }

    public String getId2() {
        return id.replaceAll("\'", "");
    }

    public String getAddress2() {
        return address.replaceAll("\'", "");
    }

    public String getDistrict2() {
        return district.replaceAll("\'", "");
    }

    public String getCategory2() {
        return category.replaceAll("\'", "");
    }

    public Integer getEmergencyRoom2() {
        return emergencyRoom;
    }

    public String getName2() {
        return name.replaceAll("\'", "");
    }

    public String getSubdivision2() {
        return subdivision.replaceAll("\'", "");
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }
}
