/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeInfoDBDAOAgtChnLaneAgnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeInfoDBDAOAgtChnLaneAgnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTOfficeInfoDBDAOAgtChnLaneAgnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_finc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeInfoDBDAOAgtChnLaneAgnVORSQL").append("\n"); 
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
		query.append("POD_CD," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("AGN_FINC_OFC_CD," ).append("\n"); 
		query.append("AGN_VNDR_CNT_CD," ).append("\n"); 
		query.append("LTRIM(TO_CHAR(AGN_VNDR_SEQ,'000000')) AS AGN_VNDR_SEQ," ).append("\n"); 
		query.append("NVL((SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.AGN_VNDR_SEQ),'') AS VNDR_NM," ).append("\n"); 
		query.append("AGN_CUST_CNT_CD || LTRIM(TO_CHAR(AGN_CUST_SEQ,'000000')) AS CUST_CD," ).append("\n"); 
		query.append("NVL(DELT_FLG,'N') AS DELT_FLG," ).append("\n"); 
		query.append("POD_CD AS OLD_POD_CD," ).append("\n"); 
		query.append("SLAN_CD AS OLD_SLAN_CD" ).append("\n"); 
		query.append("FROM AGT_CHN_LANE_AGN A" ).append("\n"); 
		query.append("WHERE AGN_FINC_OFC_CD = @[agn_finc_ofc_cd]" ).append("\n"); 
		query.append("ORDER BY 1,2" ).append("\n"); 

	}
}