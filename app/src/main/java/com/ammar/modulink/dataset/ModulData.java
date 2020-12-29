package com.ammar.modulink.dataset;

import java.util.ArrayList;

public class ModulData {

    private static String[] modul={


            "Pertemuan-10",
            "Pertemuan-09",
            "Pertemuan-08",
            "Pertemuan-07",
            "Pertemuan-06",
            "Pertemuan-05",
            "Pertemuan-04",
            "Pertemuan-03",
            "Pertemuan-02",
            "Pertemuan-01"
    };

    private  static String[] tanggal={

            "04-06-2020",
            "27-05-2020",
            "20-05-2020",
            "13-05-2020",
            "06-05-2020",
            "30-04-2020",
            "23-04-2020",
            "16-04-2020",
            "08-04-2020",
            "01-04-2020"
    };



    static ArrayList<DataModul> getlisData() {
        ArrayList<DataModul> list = new ArrayList<>();

        for (int position = 0; position < modul.length; position++) {
            DataModul dataModul = new DataModul();

            dataModul.setModulke(modul[position]);
            dataModul.setTanggal(tanggal[position]);

            list.add(dataModul);

        }
        return list;
    }
}
