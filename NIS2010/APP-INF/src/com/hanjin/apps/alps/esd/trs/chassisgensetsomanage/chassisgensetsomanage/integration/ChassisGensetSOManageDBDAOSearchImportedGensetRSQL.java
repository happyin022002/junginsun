/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOSearchImportedGensetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOSearchImportedGensetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Imported Genset List Inquiry
	  * f_cmd ; SEARCH07
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOSearchImportedGensetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOSearchImportedGensetRSQL").append("\n"); 
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
		query.append("SELECT   a.eq_no" ).append("\n"); 
		query.append(",a.eq_tpsz_cd" ).append("\n"); 
		query.append(",a.eq_tpsz_cd chss_tpsz_desc" ).append("\n"); 
		query.append(",SUBSTR (a.onh_yd_cd, 1, 5) fm_loc_value" ).append("\n"); 
		query.append(",SUBSTR (a.onh_yd_cd, 6, 2) fm_yard_value" ).append("\n"); 
		query.append(",a.vndr_seq" ).append("\n"); 
		query.append(",c.vndr_abbr_nm" ).append("\n"); 
		query.append(",a.agmt_lstm_cd" ).append("\n"); 
		query.append("FROM cgm_equipment a" ).append("\n"); 
		query.append(",mdm_vendor c" ).append("\n"); 
		query.append("WHERE a.vndr_seq = c.vndr_seq(+)" ).append("\n"); 
		query.append("AND a.eq_knd_cd = 'G'" ).append("\n"); 
		query.append("AND a.eq_no IN (" ).append("\n"); 
		query.append("#foreach(${key} in ${eq_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY a.eq_no" ).append("\n"); 

	}
}