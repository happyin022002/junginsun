/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOSearchGensetSOManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2009.08.14 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN DONG IL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOSearchGensetSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GenSet List Retrieve
	  * f_cmd : SEARCH02
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOSearchGensetSOManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOSearchGensetSOManageRSQL").append("\n"); 
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
		query.append("SELECT a.eq_no" ).append("\n"); 
		query.append(",a.eq_tpsz_cd eq_tpsz_cd" ).append("\n"); 
		query.append(",a.eq_tpsz_cd chss_tpsz_desc" ).append("\n"); 
		query.append(",SUBSTR (a.onh_yd_cd,1,5) fm_loc_value" ).append("\n"); 
		query.append(",SUBSTR (a.onh_yd_cd,6,2) fm_yard_value" ).append("\n"); 
		query.append(",a.vndr_seq" ).append("\n"); 
		query.append(",c.vndr_abbr_nm" ).append("\n"); 
		query.append(",a.agmt_lstm_cd" ).append("\n"); 
		query.append("FROM cgm_equipment a" ).append("\n"); 
		query.append(",mdm_vendor c" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND a.eq_knd_cd = 'G' --Equipment Kind Code : G(MGSet)" ).append("\n"); 
		query.append("AND a.vndr_seq = c.vndr_seq(+)" ).append("\n"); 
		query.append("AND a.eq_no = @[eq_no]" ).append("\n"); 

	}
}