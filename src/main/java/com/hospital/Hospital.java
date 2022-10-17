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

    public String getId() {
        return id.replaceAll("\'", "");
    }

    public String getAddress() {
        return address.replaceAll("\'", "");
    }

    public String getDistrict() {
        return district.replaceAll("\'", "");
    }

    public String getCategory() {
        return category.replaceAll("\'", "");
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name.replaceAll("\'", "");
    }

    public String getSubdivision() {
        return subdivision.replaceAll("\'", "");
    }
}
