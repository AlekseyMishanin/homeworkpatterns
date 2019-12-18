package architectural.dao;

import architectural.model.License;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LicenseDataImpl implements LicenseData {

    private static volatile LicenseDataImpl instance;
    private static ConcurrentHashMap<String, License> identityMap = new ConcurrentHashMap<>();
    private Connection connection;

    private LicenseDataImpl(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","test","test");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public LicenseDataImpl getInstance(){

        if(instance == null) {
            synchronized (LicenseDataImpl.class){
                if (instance == null){
                    instance = new LicenseDataImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void insert(License license) {

        try{
            LicensePrepareStatement.INSERT.setInt(1,license.getDeviceCount());
            LicensePrepareStatement.INSERT.setString(2,license.getDuration());
            LicensePrepareStatement.INSERT.setString(3,license.getType());
            LicensePrepareStatement.INSERT.executeUpdate();
            identityMap.put(license.getSerialId(), license);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(License license) {

        try{
            LicensePrepareStatement.UPDATE.setInt(1,license.getDeviceCount());
            LicensePrepareStatement.UPDATE.setString(2,license.getDuration());
            LicensePrepareStatement.UPDATE.setString(3,license.getType());
            LicensePrepareStatement.UPDATE.setString(4,license.getSerialId());
            LicensePrepareStatement.UPDATE.executeUpdate();
            identityMap.put(license.getSerialId(), license);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(License license) {

        try{
            LicensePrepareStatement.DELETE.setString(1,license.getSerialId());
            LicensePrepareStatement.DELETE.executeUpdate();
            identityMap.remove(license.getSerialId());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public License selectById(String id) {

        License result;

        if ((result = identityMap.get(id)) != null) {
            return result;
        }

        try{
            LicensePrepareStatement.SELECT_ONE.setString(1,id);
            ResultSet resultSet = LicensePrepareStatement.SELECT_ONE.executeQuery();
            if (resultSet.next()){
                result = new License(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @Override
    public List<License> selectAll() {

        List<License> result = new ArrayList<>();

        if (!identityMap.isEmpty()) {
            return (List<License>) identityMap.values();
        }

        try{
            ResultSet resultSet = LicensePrepareStatement.SELECT_ALL.executeQuery();
            if (resultSet.next()){
                result.add(new License(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    public void close(){

        LicensePrepareStatement.close();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        LicensePrepareStatement.close();
    }

    private static class LicensePrepareStatement{

        public static PreparedStatement INSERT;
        public static PreparedStatement UPDATE;
        public static PreparedStatement DELETE;
        public static PreparedStatement SELECT_ONE;
        public static PreparedStatement SELECT_ALL;

        public static void init(Connection connection){

            try{
                INSERT = connection.prepareStatement(SqlText.INSERT);
                UPDATE = connection.prepareStatement(SqlText.UPDATE);
                DELETE = connection.prepareStatement(SqlText.DELETE);
                SELECT_ONE = connection.prepareStatement(SqlText.SELECT_ONE);
                SELECT_ALL = connection.prepareStatement(SqlText.SELECT_ALL);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        public static void close(){
            try{
                INSERT.close();
                UPDATE.close();
                DELETE.close();
                SELECT_ALL.close();
                SELECT_ONE.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    private static class SqlText{

        public static final String INSERT = "INSERT INTO test.license(deviceCount, duration, `type`) values(?, ?, ?);";
        public static final String UPDATE = "UPDATE test.license SET deviceCount = ?, duration = ?, `type` = ? WHERE serialId = ?;";
        public static final String DELETE = "DELETE FROM test.license WHERE serialId = ?;";
        public static final String SELECT_ONE = "SELECT * FROM test.license WHERE serialId = ?;";
        public static final String SELECT_ALL = "SELECT * FROM test.license;";
    }
}
