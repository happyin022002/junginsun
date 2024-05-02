/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LocationDBDAOsearchLocCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOsearchLocCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location을 조회합니다.
	  * </pre>
	  */
	public LocationDBDAOsearchLocCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOsearchLocCodeRSQL").append("\n"); 
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
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , MODI_LOC_CD2" ).append("\n"); 
		query.append("    , NEW_LOC_LAT" ).append("\n"); 
		query.append("    , NEW_LOC_LON" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = @[loc_cd]" ).append("\n"); 

	}
}