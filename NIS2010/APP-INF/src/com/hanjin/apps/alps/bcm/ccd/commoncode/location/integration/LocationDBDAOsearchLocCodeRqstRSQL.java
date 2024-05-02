/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOsearchLocCodeRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOsearchLocCodeRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request Location을 조회합니다.
	  * </pre>
	  */
	public LocationDBDAOsearchLocCodeRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOsearchLocCodeRqstRSQL").append("\n"); 
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
		query.append("SELECT LOC_NM " ).append("\n"); 
		query.append("	, LOC_CD" ).append("\n"); 
		query.append("	, LOC_LOCL_LANG_NM" ).append("\n"); 
		query.append("	, LOC_CHR_CD" ).append("\n"); 
		query.append("	, CALL_PORT_FLG" ).append("\n"); 
		query.append("	, PORT_INLND_FLG" ).append("\n"); 
		query.append("	, LOC_TP_CD" ).append("\n"); 
		query.append("	, CONTI_CD" ).append("\n"); 
		query.append("	, SCONTI_CD" ).append("\n"); 
		query.append("	, CNT_CD" ).append("\n"); 
		query.append("	, RGN_CD" ).append("\n"); 
		query.append("	, STE_CD" ).append("\n"); 
		query.append("	, SCC_CD" ).append("\n"); 
		query.append("	, REP_ZN_CD" ).append("\n"); 
		query.append("	, UN_LOC_IND_CD" ).append("\n"); 
		query.append("	, UN_LOC_CD" ).append("\n"); 
		query.append("	, SLS_OFC_CD" ).append("\n"); 
		query.append("	, EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	, FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("	, MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("	, EQ_RTN_YD_CD" ).append("\n"); 
		query.append("	, HUB_LOC_CD" ).append("\n"); 
		query.append("	, LOC_GRD_NO" ).append("\n"); 
		query.append("	, ZIP_CD" ).append("\n"); 
		query.append("	, GMT_HRS" ).append("\n"); 
		query.append("	, UTC_GAP_HR_CTNT" ).append("\n"); 
		query.append("	, LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("	, CSTMS_CD" ).append("\n"); 
		query.append("	, CML_ZN_FLG" ).append("\n"); 
		query.append("	, LOC_LAT" ).append("\n"); 
		query.append("	, LAT_UT_CD" ).append("\n"); 
		query.append("	, LOC_LON" ).append("\n"); 
		query.append("	, LON_UT_CD" ).append("\n"); 
		query.append("	, DELT_FLG" ).append("\n"); 
		query.append("    , MODI_LOC_CD" ).append("\n"); 
		query.append("    , NEW_LOC_LAT" ).append("\n"); 
		query.append("    , NEW_LOC_LON" ).append("\n"); 
		query.append("FROM MDM_LOC_RQST" ).append("\n"); 
		query.append("WHERE RQST_NO = @[rqst_no]  " ).append("\n"); 

	}
}