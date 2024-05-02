/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchVskVslPortSkdByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchVskVslPortSkdByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_VSL_PORT_SKD조회
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchVskVslPortSkdByVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchVskVslPortSkdByVVDRSQL").append("\n"); 
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
		query.append("SELECT ACT_INP_FLG" ).append("\n"); 
		query.append(",ADD_CALL_FLG" ).append("\n"); 
		query.append(",AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append(",CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(CGO_CLZ_DT,'YYYYMMDDHH24MI') CGO_CLZ_DT" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append(",CLPT_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(CRE_DT,'YYYYMMDDHH24MI') CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CSSM_VOY_INIT_CRE_FLG" ).append("\n"); 
		query.append(",TO_CHAR(DCGO_CLZ_DT,'YYYYMMDDHH24MI') DCGO_CLZ_DT" ).append("\n"); 
		query.append(",DEP_RPT_INP_FLG" ).append("\n"); 
		query.append(",EDI_SND_KNT" ).append("\n"); 
		query.append(",TO_CHAR(EDW_UPD_DT,'YYYYMMDDHH24MI') EDW_UPD_DT" ).append("\n"); 
		query.append(",TO_CHAR(FT_DT,'YYYYMMDDHH24MI') FT_DT" ).append("\n"); 
		query.append(",IB_CGO_QTY" ).append("\n"); 
		query.append(",IB_CSSM_VOY_NO" ).append("\n"); 
		query.append(",TO_CHAR(INIT_ETA_DT,'YYYYMMDDHH24MI') INIT_ETA_DT" ).append("\n"); 
		query.append(",TO_CHAR(INIT_ETB_DT,'YYYYMMDDHH24MI') INIT_ETB_DT" ).append("\n"); 
		query.append(",TO_CHAR(INIT_ETD_DT,'YYYYMMDDHH24MI') INIT_ETD_DT" ).append("\n"); 
		query.append(",INIT_SKD_INP_FLG" ).append("\n"); 
		query.append(",LNK_DIST" ).append("\n"); 
		query.append(",LNK_SPD" ).append("\n"); 
		query.append(",MNVR_IN_HRS" ).append("\n"); 
		query.append(",MNVR_OUT_HRS" ).append("\n"); 
		query.append(",NOON_RPT_INP_FLG" ).append("\n"); 
		query.append(",OB_CGO_QTY" ).append("\n"); 
		query.append(",OB_CSSM_VOY_NO" ).append("\n"); 
		query.append(",OFC_INP_FLG" ).append("\n"); 
		query.append(",TO_CHAR(PF_ETA_DT,'YYYYMMDDHH24MI') PF_ETA_DT" ).append("\n"); 
		query.append(",TO_CHAR(PF_ETB_DT,'YYYYMMDDHH24MI') PF_ETB_DT" ).append("\n"); 
		query.append(",TO_CHAR(PF_ETD_DT,'YYYYMMDDHH24MI') PF_ETD_DT" ).append("\n"); 
		query.append(",PHS_IO_RMK" ).append("\n"); 
		query.append(",PHS_IO_RSN_CD" ).append("\n"); 
		query.append(",PLISM_VOY_NO" ).append("\n"); 
		query.append(",PLISM_VSL_CD" ).append("\n"); 
		query.append(",PLISM_YD_CD" ).append("\n"); 
		query.append(",PORT_BUF_HRS" ).append("\n"); 
		query.append(",PORT_SKD_STS_CD" ).append("\n"); 
		query.append(",PORT_SKP_RSN_CD" ).append("\n"); 
		query.append(",PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append(",PORT_SKP_TP_CD" ).append("\n"); 
		query.append(",PORT_WRK_HRS" ).append("\n"); 
		query.append(",PRT_CHK_FLG" ).append("\n"); 
		query.append(",TO_CHAR(RC_CLZ_DT,'YYYYMMDDHH24MI') RC_CLZ_DT" ).append("\n"); 
		query.append(",SEA_BUF_HRS" ).append("\n"); 
		query.append(",SHP_CALL_NO" ).append("\n"); 
		query.append(",TO_CHAR(SHP_CALL_NO_UPD_DT,'YYYYMMDDHH24MI') SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append(",SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append(",SKD_AUTO_UPD_FLG" ).append("\n"); 
		query.append(",SKD_BRTH_NO" ).append("\n"); 
		query.append(",SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKP_CALL_FLG" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",TML_VOY_NO" ).append("\n"); 
		query.append(",TML_VSL_CD" ).append("\n"); 
		query.append(",TS_PORT_CD" ).append("\n"); 
		query.append(",TTL_DLAY_HRS" ).append("\n"); 
		query.append(",TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",TURN_PORT_FLG" ).append("\n"); 
		query.append(",TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(",TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(",TZTM_HRS" ).append("\n"); 
		query.append(",TO_CHAR(UPD_DT,'YYYYMMDDHH24MI') UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",USD_FLG" ).append("\n"); 
		query.append(",TO_CHAR(VPS_ETA_DT,'YYYYMMDDHH24MI') VPS_ETA_DT" ).append("\n"); 
		query.append(",TO_CHAR(VPS_ETB_DT,'YYYYMMDDHH24MI') VPS_ETB_DT" ).append("\n"); 
		query.append(",TO_CHAR(VPS_ETD_DT,'YYYYMMDDHH24MI') VPS_ETD_DT" ).append("\n"); 
		query.append(",VPS_PORT_CD" ).append("\n"); 
		query.append(",VPS_RMK" ).append("\n"); 
		query.append(",VSLD_WKS" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append(",VSL_RENM_NEW_VSL_CD" ).append("\n"); 
		query.append(",VSL_RENM_NEW_VSL_ENG_NM" ).append("\n"); 
		query.append(",VSL_RENM_OLD_VSL_CD" ).append("\n"); 
		query.append(",VSL_RENM_OLD_VSL_ENG_NM" ).append("\n"); 
		query.append(",VT_ADD_CALL_FLG" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CLPT_IND_SEQ" ).append("\n"); 

	}
}