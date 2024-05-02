/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOsearchYardCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.25
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

public class LocationDBDAOsearchYardCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard를 조회합니다.
	  * </pre>
	  */
	public LocationDBDAOsearchYardCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOsearchYardCodeRSQL").append("\n"); 
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
		query.append("SELECT YD_CD,  " ).append("\n"); 
		query.append("	   YD_NM," ).append("\n"); 
		query.append("       YD_CHR_CD," ).append("\n"); 
		query.append("       YD_FCTY_TP_CY_FLG," ).append("\n"); 
		query.append("       YD_FCTY_TP_RAIL_RMP_FLG," ).append("\n"); 
		query.append("       YD_FCTY_TP_MRN_TML_FLG," ).append("\n"); 
		query.append("       YD_FCTY_TP_CFS_FLG," ).append("\n"); 
		query.append("       YD_FCTY_TP_BRG_RMP_FLG," ).append("\n"); 
		query.append("       YD_FCTY_TP_PSDO_YD_FLG," ).append("\n"); 
		query.append("       N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT VNDR_LGL_ENG_NM FROM  MDM_VENDOR WHERE VNDR_SEQ = N1ST_VNDR_SEQ) AS N1ST_VNDR_NM," ).append("\n"); 
		query.append("       N2ND_VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT VNDR_LGL_ENG_NM FROM  MDM_VENDOR WHERE VNDR_SEQ = N2ND_VNDR_SEQ) AS N2ND_VNDR_NM," ).append("\n"); 
		query.append("       N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT VNDR_LGL_ENG_NM FROM  MDM_VENDOR WHERE VNDR_SEQ = N3RD_VNDR_SEQ) AS N3RD_VNDR_NM," ).append("\n"); 
		query.append("       OFC_CD," ).append("\n"); 
		query.append("       DMDT_OFC_CD," ).append("\n"); 
		query.append("       DEM_IB_CLT_FLG," ).append("\n"); 
		query.append("       DEM_OB_CLT_FLG," ).append("\n"); 
		query.append("       REP_ZN_CD," ).append("\n"); 
		query.append("       YD_OSHP_CD," ).append("\n"); 
		query.append("       BD_YD_FLG," ).append("\n"); 
		query.append("       MNR_SHOP_FLG," ).append("\n"); 
		query.append("       EIR_SVC_FLG," ).append("\n"); 
		query.append("       HUB_YD_FLG," ).append("\n"); 
		query.append("       YD_ADDR," ).append("\n"); 
		query.append("       YD_CSTMS_NO," ).append("\n"); 
		query.append("       YD_CEO_NM," ).append("\n"); 
		query.append("       YD_PIC_NM," ).append("\n"); 
		query.append("       YD_EML," ).append("\n"); 
		query.append("       ZIP_CD," ).append("\n"); 
		query.append("       INTL_PHN_NO," ).append("\n"); 
		query.append("       PHN_NO," ).append("\n"); 
		query.append("       FAX_NO," ).append("\n"); 
		query.append("	   DRY_AVG_DWLL_HRS," ).append("\n"); 
		query.append("	   DRY_MIN_DWLL_HRS," ).append("\n"); 
		query.append("	   RF_AVG_DWLL_HRS," ).append("\n"); 
		query.append("	   RF_MIN_DWLL_HRS," ).append("\n"); 
		query.append("       GATE_OPN_HRMNT," ).append("\n"); 
		query.append("       GATE_CLZ_HRMNT," ).append("\n"); 
		query.append("       SAT_GATE_OPN_HRMNT," ).append("\n"); 
		query.append("       SAT_GATE_CLZ_HRMNT," ).append("\n"); 
		query.append("       SUN_GATE_OPN_HRMNT," ).append("\n"); 
		query.append("       SUN_GATE_CLZ_HRMNT," ).append("\n"); 
		query.append("       HOL_GATE_OPN_HRMNT," ).append("\n"); 
		query.append("       HOL_GATE_CLZ_HRMNT," ).append("\n"); 
		query.append("       YD_INRL_FLG," ).append("\n"); 
		query.append("       YD_CGO_CLZ_HRMNT_MSG," ).append("\n"); 
		query.append("       BRTH_NO," ).append("\n"); 
		query.append("       YD_BRTH_LEN," ).append("\n"); 
		query.append("       YD_BRTH_ALNG_SD_DESC," ).append("\n"); 
		query.append("       YD_BRTH_DPTH_CHNL_KNT," ).append("\n"); 
		query.append("       YD_TTL_SPC," ).append("\n"); 
		query.append("       YD_ACT_SPC," ).append("\n"); 
		query.append("       YD_HJS_SPC," ).append("\n"); 
		query.append("       YD_CFS_SPC," ).append("\n"); 
		query.append("       YD_RF_RCPT_440V_KNT," ).append("\n"); 
		query.append("       YD_RF_RCPT_220V_KNT," ).append("\n"); 
		query.append("       YD_RF_RCPT_DUL_KNT," ).append("\n"); 
		query.append("       YD_OP_SYS_CD," ).append("\n"); 
		query.append("       YD_PST_PGC_KNT," ).append("\n"); 
		query.append("       YD_PGC_KNT," ).append("\n"); 
		query.append("       TRSTR_KNT," ).append("\n"); 
		query.append("       FRK_KNT," ).append("\n"); 
		query.append("       YD_STRDL_CRR_KNT," ).append("\n"); 
		query.append("       YD_TRCT_KNT," ).append("\n"); 
		query.append("       YD_TOP_LFT_KNT," ).append("\n"); 
		query.append("       TML_CHSS_KNT," ).append("\n"); 
		query.append("       YD_HNDL_YR," ).append("\n"); 
		query.append("       YD_HNDL_CAPA," ).append("\n"); 
		query.append("       TML_PROD_KNT," ).append("\n"); 
		query.append("       YD_TTL_VOL_TEU_KNT," ).append("\n"); 
		query.append("       YD_TTL_VOL_BX_KNT," ).append("\n"); 
		query.append("       YD_HJS_VOL_TEU_KNT," ).append("\n"); 
		query.append("       YD_HJS_VOL_BX_KNT," ).append("\n"); 
		query.append("       YD_RMK," ).append("\n"); 
		query.append("       DELT_FLG," ).append("\n"); 
		query.append("       YD_LOCL_LANG_NM," ).append("\n"); 
		query.append("       YD_LOCL_LANG_ADDR," ).append("\n"); 
		query.append("       BKG_POD_YD_FLG," ).append("\n"); 
		query.append("--       EQ_SCC_CD," ).append("\n"); 
		query.append("--	   RAIL_ARR_NTFC_FLG," ).append("\n"); 
		query.append("       MODI_YD_CD," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("--       , YD_LAT," ).append("\n"); 
		query.append("--       YD_LON" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 

	}
}