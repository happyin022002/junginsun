/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LocationDBDAOYardVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
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

public class LocationDBDAOYardVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public LocationDBDAOYardVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOYardVORSQL").append("\n"); 
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
		query.append("SELECT 'YD_CD' YD_CD," ).append("\n"); 
		query.append("       'YD_NM' YD_NM," ).append("\n"); 
		query.append("       'YD_CHR_CD' YD_CHR_CD," ).append("\n"); 
		query.append("       'YD_FCTY_TP_CY_FLG' YD_FCTY_TP_CY_FLG," ).append("\n"); 
		query.append("       'YD_FCTY_TP_RAIL_RMP_FLG' YD_FCTY_TP_RAIL_RMP_FLG," ).append("\n"); 
		query.append("       'YD_FCTY_TP_MRN_TML_FLG' YD_FCTY_TP_MRN_TML_FLG," ).append("\n"); 
		query.append("       'YD_FCTY_TP_CFS_FLG' YD_FCTY_TP_CFS_FLG," ).append("\n"); 
		query.append("       'YD_FCTY_TP_BRG_RMP_FLG' YD_FCTY_TP_BRG_RMP_FLG," ).append("\n"); 
		query.append("       'YD_FCTY_TP_PSDO_YD_FLG' YD_FCTY_TP_PSDO_YD_FLG," ).append("\n"); 
		query.append("       'N1ST_VNDR_SEQ' N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("       'N2ND_VNDR_SEQ' N2ND_VNDR_SEQ," ).append("\n"); 
		query.append("       'N3RD_VNDR_SEQ' N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("       'OFC_CD' OFC_CD," ).append("\n"); 
		query.append("       'DMDT_OFC_CD' DMDT_OFC_CD," ).append("\n"); 
		query.append("       'DEM_IB_CLT_FLG' DEM_IB_CLT_FLG," ).append("\n"); 
		query.append("       'DEM_OB_CLT_FLG' DEM_OB_CLT_FLG," ).append("\n"); 
		query.append("       'REP_ZN_CD' REP_ZN_CD," ).append("\n"); 
		query.append("       'YD_OSHP_CD' YD_OSHP_CD," ).append("\n"); 
		query.append("       'BD_YD_FLG' BD_YD_FLG," ).append("\n"); 
		query.append("       'MNR_SHOP_FLG' MNR_SHOP_FLG," ).append("\n"); 
		query.append("       'EIR_SVC_FLG' EIR_SVC_FLG," ).append("\n"); 
		query.append("       'HUB_YD_FLG' HUB_YD_FLG," ).append("\n"); 
		query.append("       'YD_ADDR' YD_ADDR," ).append("\n"); 
		query.append("       'YD_CSTMS_NO' YD_CSTMS_NO," ).append("\n"); 
		query.append("       'YD_CEO_NM' YD_CEO_NM," ).append("\n"); 
		query.append("       'YD_PIC_NM' YD_PIC_NM," ).append("\n"); 
		query.append("       'YD_EML' YD_EML," ).append("\n"); 
		query.append("       'ZIP_CD' ZIP_CD," ).append("\n"); 
		query.append("       'INTL_PHN_NO' INTL_PHN_NO," ).append("\n"); 
		query.append("       'PHN_NO' PHN_NO," ).append("\n"); 
		query.append("       'FAX_NO' FAX_NO," ).append("\n"); 
		query.append("       'GATE_OPN_HRMNT' GATE_OPN_HRMNT," ).append("\n"); 
		query.append("       'GATE_CLZ_HRMNT' GATE_CLZ_HRMNT," ).append("\n"); 
		query.append("       'SAT_GATE_OPN_HRMNT' SAT_GATE_OPN_HRMNT," ).append("\n"); 
		query.append("       'SAT_GATE_CLZ_HRMNT' SAT_GATE_CLZ_HRMNT," ).append("\n"); 
		query.append("       'SUN_GATE_OPN_HRMNT' SUN_GATE_OPN_HRMNT," ).append("\n"); 
		query.append("       'SUN_GATE_CLZ_HRMNT' SUN_GATE_CLZ_HRMNT," ).append("\n"); 
		query.append("       'HOL_GATE_OPN_HRMNT' HOL_GATE_OPN_HRMNT," ).append("\n"); 
		query.append("       'HOL_GATE_CLZ_HRMNT' HOL_GATE_CLZ_HRMNT," ).append("\n"); 
		query.append("       'YD_INRL_FLG' YD_INRL_FLG," ).append("\n"); 
		query.append("       'YD_CGO_CLZ_HRMNT_MSG' YD_CGO_CLZ_HRMNT_MSG," ).append("\n"); 
		query.append("       'BRTH_NO' BRTH_NO," ).append("\n"); 
		query.append("       'YD_BRTH_LEN' YD_BRTH_LEN," ).append("\n"); 
		query.append("       'YD_BRTH_ALNG_SD_DESC' YD_BRTH_ALNG_SD_DESC," ).append("\n"); 
		query.append("       'YD_BRTH_DPTH_CHNL_KNT' YD_BRTH_DPTH_CHNL_KNT," ).append("\n"); 
		query.append("       'YD_TTL_SPC' YD_TTL_SPC," ).append("\n"); 
		query.append("       'YD_ACT_SPC' YD_ACT_SPC," ).append("\n"); 
		query.append("       'YD_CO_SPC' YD_CO_SPC," ).append("\n"); 
		query.append("       'YD_CFS_SPC' YD_CFS_SPC," ).append("\n"); 
		query.append("       'YD_RF_RCPT_440V_KNT' YD_RF_RCPT_440V_KNT," ).append("\n"); 
		query.append("       'YD_RF_RCPT_220V_KNT' YD_RF_RCPT_220V_KNT," ).append("\n"); 
		query.append("       'YD_RF_RCPT_DUL_KNT' YD_RF_RCPT_DUL_KNT," ).append("\n"); 
		query.append("       'YD_OP_SYS_CD' YD_OP_SYS_CD," ).append("\n"); 
		query.append("       'YD_PST_PGC_KNT' YD_PST_PGC_KNT," ).append("\n"); 
		query.append("       'YD_PGC_KNT' YD_PGC_KNT," ).append("\n"); 
		query.append("       'TRSTR_KNT' TRSTR_KNT," ).append("\n"); 
		query.append("       'FRK_KNT' FRK_KNT," ).append("\n"); 
		query.append("       'YD_STRDL_CRR_KNT' YD_STRDL_CRR_KNT," ).append("\n"); 
		query.append("       'YD_TRCT_KNT' YD_TRCT_KNT," ).append("\n"); 
		query.append("       'YD_TOP_LFT_KNT' YD_TOP_LFT_KNT," ).append("\n"); 
		query.append("       'TML_CHSS_KNT' TML_CHSS_KNT," ).append("\n"); 
		query.append("       'YD_HNDL_YR' YD_HNDL_YR," ).append("\n"); 
		query.append("       'YD_HNDL_CAPA' YD_HNDL_CAPA," ).append("\n"); 
		query.append("       'TML_PROD_KNT' TML_PROD_KNT," ).append("\n"); 
		query.append("       'YD_TTL_VOL_TEU_KNT' YD_TTL_VOL_TEU_KNT," ).append("\n"); 
		query.append("       'YD_TTL_VOL_BX_KNT' YD_TTL_VOL_BX_KNT," ).append("\n"); 
		query.append("       'YD_CO_VOL_TEU_KNT' YD_CO_VOL_TEU_KNT," ).append("\n"); 
		query.append("       'YD_CO_VOL_BX_KNT' YD_CO_VOL_BX_KNT," ).append("\n"); 
		query.append("       'YD_RMK' YD_RMK," ).append("\n"); 
		query.append("       'DELT_FLG' DELT_FLG," ).append("\n"); 
		query.append("       'USR_ID' USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}