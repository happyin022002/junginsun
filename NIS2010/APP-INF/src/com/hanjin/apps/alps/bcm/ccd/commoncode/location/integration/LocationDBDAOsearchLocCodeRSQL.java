/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOsearchLocCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.09
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
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
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
		query.append("SELECT A.LOC_NM " ).append("\n"); 
		query.append("	 , A.LOC_CD" ).append("\n"); 
		query.append("	 , A.LOC_LOCL_LANG_NM" ).append("\n"); 
		query.append("	 , A.LOC_CHR_CD" ).append("\n"); 
		query.append("	 , A.CALL_PORT_FLG" ).append("\n"); 
		query.append("	 , A.PORT_INLND_CD AS PORT_INLND_FLG" ).append("\n"); 
		query.append("	 , A.PORT_INLND_CD" ).append("\n"); 
		query.append("	 , A.LOC_TP_CD" ).append("\n"); 
		query.append("	 , A.CONTI_CD" ).append("\n"); 
		query.append("	 , A.SCONTI_CD" ).append("\n"); 
		query.append("	 , A.CNT_CD" ).append("\n"); 
		query.append("	 , A.RGN_CD" ).append("\n"); 
		query.append("	 , A.STE_CD" ).append("\n"); 
		query.append("	 , A.SCC_CD" ).append("\n"); 
		query.append("     , B.ECC_CD" ).append("\n"); 
		query.append("     , B.LCC_CD" ).append("\n"); 
		query.append("     , B.RCC_CD" ).append("\n"); 
		query.append("   	 , A.REP_ZN_CD" ).append("\n"); 
		query.append("	 , A.UN_LOC_IND_CD" ).append("\n"); 
		query.append("	 , A.UN_LOC_CD" ).append("\n"); 
		query.append("	 , A.SLS_OFC_CD" ).append("\n"); 
		query.append("	 , A.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	 , A.FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("	 , A.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("	 , A.EQ_RTN_YD_CD" ).append("\n"); 
		query.append("	 , A.HUB_LOC_CD" ).append("\n"); 
		query.append("	 , A.LOC_GRD_NO" ).append("\n"); 
		query.append("	 , A.ZIP_CD" ).append("\n"); 
		query.append("	 , A.GMT_HRS" ).append("\n"); 
		query.append("--	 , A.UTC_GAP_HR_CTNT" ).append("\n"); 
		query.append("	 , A.LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("	 , A.CSTMS_CD" ).append("\n"); 
		query.append("	 , A.CML_ZN_FLG" ).append("\n"); 
		query.append("	 , A.LOC_LAT" ).append("\n"); 
		query.append("	 , A.LAT_UT_CD" ).append("\n"); 
		query.append("	 , A.LOC_LON" ).append("\n"); 
		query.append("	 , A.LON_UT_CD" ).append("\n"); 
		query.append("	 , A.DELT_FLG" ).append("\n"); 
		query.append("--     , MODI_LOC_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("	 , A.BLK_PORT_FLG" ).append("\n"); 
		query.append("	 , A.BKG_BL_PFX_CD" ).append("\n"); 
		query.append("	 , A.SEN_EQ_OFC_CD" ).append("\n"); 
		query.append("	 , A.BFR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("	 , A.BFR_EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	 , A.BFR_SLS_OFC_CD" ).append("\n"); 
		query.append("	 , A.BFR_OFC_CNG_DT" ).append("\n"); 
		query.append("--    , MODI_LOC_CD2" ).append("\n"); 
		query.append("--    , NEW_LOC_LAT" ).append("\n"); 
		query.append("--    , NEW_LOC_LON" ).append("\n"); 
		query.append("FROM MDM_LOCATION A" ).append("\n"); 
		query.append("   , MDM_EQ_ORZ_CHT B " ).append("\n"); 
		query.append("WHERE LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("  AND A.SCC_CD = B.SCC_CD(+)   " ).append("\n"); 

	}
}