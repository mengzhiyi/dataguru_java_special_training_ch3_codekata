package agiledon.codekata.refactoring.templatemethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao extends AbstractDao{
  
    private static final String SQL_SELECT_VEHICLE = "select * from part";
    
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

    public void populate() throws Exception {
    	Connection c = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
    	try {
           	c = super.getConnection();
           	stmt = c.prepareStatement(SQL_SELECT_VEHICLE);
           	rs = stmt.executeQuery();
           	
           	while (rs.next()) {
        	   Vehicle p = new Vehicle();
        	   p.setName(rs.getString("name"));
        	   p.setBrand(rs.getString("brand"));
        	   p.setRetailPrice(rs.getDouble("retail_price"));
        	   vehicleList.add(p);
           	}
           	
        } finally {
            super.closeAll(rs, stmt, c);
        }
    }
}