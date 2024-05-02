/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOsearchVendorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.21 
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

public class ChassisGensetSOManageDBDAOsearchVendorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vendor list조회
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOsearchVendorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOsearchVendorListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("LPAD(VNDR_SEQ, 6, '0') VNDR_NO," ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM VNDR_NM_ENG" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if (${vndr_combo_search_bound} == ''|| ${vndr_combo_search_bound} != 'ALL')" ).append("\n"); 
		query.append("SUBSTR(LOC_CD,1,2) =" ).append("\n"); 
		query.append("(SELECT SUBSTR(LOC_CD,1,2)" ).append("\n"); 
		query.append("FROM COM_USER A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND   USR_ID =	@[user_id] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_cnt_cd} != '' && ${vndr_cnt_cd}=='Y')" ).append("\n"); 
		query.append("and vndr_cnt_cd in ('US','CA')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VNDR_SEQ" ).append("\n"); 

	}
}