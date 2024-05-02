/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoTrackingDBDAOSearchCustomerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.09.17 전병석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.integraion;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Byoung Suk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoTrackingDBDAOSearchCustomerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for Selection searchCustomerName
	  * </pre>
	  */
	public CargoTrackingDBDAOSearchCustomerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_value1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_value2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.integraion").append("\n"); 
		query.append("FileName : CargoTrackingDBDAOSearchCustomerNameRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT  cust_lgl_eng_nm  FROM    mdm_customer" ).append("\n"); 
		query.append("where   1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_value1} != '')" ).append("\n"); 
		query.append("AND cust_cnt_cd = @[cust_value1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_value2} != '')" ).append("\n"); 
		query.append("AND     cust_seq    = @[cust_value2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}