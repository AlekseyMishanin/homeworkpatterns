package architectural.dao;

import architectural.model.License;

import java.util.List;

public interface LicenseData {

    void insert (License license);
    void update (License license);
    void delete (License license);
    License selectById (String id);
    List<License> selectAll ();
}
