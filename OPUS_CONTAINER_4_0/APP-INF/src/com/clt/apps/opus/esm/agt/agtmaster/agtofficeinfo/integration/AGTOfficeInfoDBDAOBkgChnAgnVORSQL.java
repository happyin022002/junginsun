/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeInfoDBDAOBkgChnAgnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeInfoDBDAOBkgChnAgnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_chn_agn select
	  * </pre>
	  */
	public AGTOfficeInfoDBDAOBkgChnAgnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeInfoDBDAOBkgChnAgnVORSQL").append("\n"); 
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
		query.append("SUBSTR(FINC_OFC_CD,1,3) || CHN_AGN_CD AS FINC_OFC_CHN_BKG_AGN_CD," ).append("\n"); 
		query.append("LTRIM(TO_CHAR(VNDR_SEQ,'000000')) AS VNDR_SEQ," ).append("\n"); 
		query.append("NVL(DELT_FLG,'N') AS DELT_FLG," ).append("\n"); 
		query.append("CHN_AGN_CD AS OLD_CHN_AGN_CD," ).append("\n"); 
		query.append("CHN_AGN_CD," ).append("\n"); 
		query.append("AGN_NM," ).append("\n"); 
		query.append("DIFF_RMK," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("AUTO_DP_CHK_FLG," ).append("\n"); 
		query.append("AGN_EML," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("FINC_OFC_CD," ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("DIR_PAY_OFC_CD," ).append("\n"); 
		query.append("BKG_BLCK_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CHN_AGN" ).append("\n"); 
		query.append("WHERE FINC_OFC_CD = @[finc_ofc_cd]" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}