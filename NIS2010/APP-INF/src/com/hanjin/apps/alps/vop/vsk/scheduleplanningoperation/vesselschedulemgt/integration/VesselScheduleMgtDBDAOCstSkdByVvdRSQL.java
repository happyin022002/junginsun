/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCstSkdByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCstSkdByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCstSkdByVvdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCstSkdByVvdRSQL").append("\n"); 
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
		query.append("SELECT T1.VSL_CD" ).append("\n"); 
		query.append("       , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("       , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("       , T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("	   , T1.SKD_STS_CD" ).append("\n"); 
		query.append("	   , T1.SKD_VOY_TP_CD" ).append("\n"); 
		query.append("	   , T1.SKD_USD_IND_CD" ).append("\n"); 
		query.append("       , T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("       , T1.ST_PORT_CD" ).append("\n"); 
		query.append("       , TO_CHAR(T1.N1ST_PORT_BRTH_DT, 'YYYYMMDDHH24MI') AS N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("	   , T1.PSDO_VVD_CD" ).append("\n"); 
		query.append("	   , T1.CO_CD" ).append("\n"); 
		query.append("       , T1.SKD_RMK" ).append("\n"); 
		query.append("       , T1.CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(T1.CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("       , T1.UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(T1.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("       , T1.VPS_PORT_CD" ).append("\n"); 
		query.append("	   , T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	   , T1.CLPT_SEQ" ).append("\n"); 
		query.append("	   , T1.SLAN_CD" ).append("\n"); 
		query.append("	   , T1.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("	   , (" ).append("\n"); 
		query.append("	       SELECT DECODE(INTG_CD_VAL_DP_DESC, NULL, INTG_CD_VAL_DESC, INTG_CD_VAL_DP_DESC) AS CODE_DESC" ).append("\n"); 
		query.append("             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE INTG_CD_ID = 'CD01821'" ).append("\n"); 
		query.append("              AND INTG_CD_VAL_CTNT = T1.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("	     ) AS PORT_SKD_STS_DESC" ).append("\n"); 
		query.append("	   , T1.YD_CD" ).append("\n"); 
		query.append("	   , (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = T1.YD_CD) AS YD_NM" ).append("\n"); 
		query.append("       , DECODE(T1.YD_CD, NULL, '', SUBSTR(T1.YD_CD, 6, 2)) AS TML_CD" ).append("\n"); 
		query.append("	   , T1.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("       , TO_CHAR(T1.PF_ETA_DT, 'YYYYMMDDHH24MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.PF_ETB_DT, 'YYYYMMDDHH24MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.PF_ETD_DT, 'YYYYMMDDHH24MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.INIT_ETA_DT, 'YYYYMMDDHH24MI') AS INIT_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.INIT_ETB_DT, 'YYYYMMDDHH24MI') AS INIT_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.INIT_ETD_DT, 'YYYYMMDDHH24MI') AS INIT_ETD_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("       , T1.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("       , T1.VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("       , T1.VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append("	   , T1.SHP_CALL_NO" ).append("\n"); 
		query.append("	   , T1.SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append("	   , TO_CHAR(T1.SHP_CALL_NO_UPD_DT, 'YYYYMMDDHH24MI') AS SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append("	   , T1.TML_VSL_CD" ).append("\n"); 
		query.append("	   , T1.TML_VOY_NO" ).append("\n"); 
		query.append("	   , TO_CHAR(T1.FT_DT, 'YYYYMMDDHH24MI') AS FT_DT" ).append("\n"); 
		query.append("	   , T1.PLISM_YD_CD" ).append("\n"); 
		query.append("	   , T1.PLISM_VSL_CD" ).append("\n"); 
		query.append("	   , T1.PLISM_VOY_NO" ).append("\n"); 
		query.append("	   , T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("	   , (" ).append("\n"); 
		query.append("	       SELECT DECODE(INTG_CD_VAL_DP_DESC, NULL, INTG_CD_VAL_DESC, INTG_CD_VAL_DP_DESC) AS CODE_DESC" ).append("\n"); 
		query.append("             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE INTG_CD_ID = 'CD01825'" ).append("\n"); 
		query.append("              AND INTG_CD_VAL_CTNT = T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("	     ) AS SKD_CNG_STS_DESC" ).append("\n"); 
		query.append("       , T1.TURN_PORT_FLG" ).append("\n"); 
		query.append("	   , T1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	   , T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("	   , T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	   , T1.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	   , T1.IB_CGO_QTY" ).append("\n"); 
		query.append("	   , T1.OB_CGO_QTY" ).append("\n"); 
		query.append("	   , T1.VPS_RMK" ).append("\n"); 
		query.append("	   , RTRIM(REPLACE(T1.VPS_RMK, CHR(13)||CHR(10),' ')) AS WIN_RMK 	/* 화면 조회 용 */" ).append("\n"); 
		query.append("	   , T1.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("	   , T1.PHS_IO_RMK" ).append("\n"); 
		query.append("	   , T1.SKD_BRTH_NO" ).append("\n"); 
		query.append("	   , T1.INIT_SKD_INP_FLG" ).append("\n"); 
		query.append("	   , T1.OFC_INP_FLG" ).append("\n"); 
		query.append("	   , T1.NOON_RPT_INP_FLG" ).append("\n"); 
		query.append("	   , T1.DEP_RPT_INP_FLG" ).append("\n"); 
		query.append("	   , T1.ACT_INP_FLG" ).append("\n"); 
		query.append("	   , T1.PRT_CHK_FLG" ).append("\n"); 
		query.append("	   , T1.EDI_SND_KNT" ).append("\n"); 
		query.append("	   , T1.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("	   , T1.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("	   , T1.PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append("	   , T1.TTL_DLAY_HRS" ).append("\n"); 
		query.append("	   , T1.TS_PORT_CD" ).append("\n"); 
		query.append("	   , T1.USD_FLG" ).append("\n"); 
		query.append("	   , DECODE(T1.AUTO_SKD_CNG_FLG, 'Y', '1', 'N', '0', T1.AUTO_SKD_CNG_FLG) AS AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("	   , NVL(T1.LNK_DIST, NVL(T2.LNK_DIST, 0)) AS LNK_DIST" ).append("\n"); 
		query.append("       , NVL(T1.LNK_SPD, NVL(T2.LNK_SPD, 0)) AS LNK_SPD" ).append("\n"); 
		query.append("	   , NVL(T1.SEA_BUF_HRS, NVL(T2.SEA_BUF_HRS, 0)) AS SEA_BUF_HRS" ).append("\n"); 
		query.append("	   , NVL(T1.PORT_BUF_HRS, NVL(T2.PORT_BUF_HRS, 0)) AS PORT_BUF_HRS" ).append("\n"); 
		query.append("	   , NVL(T1.TZTM_HRS, NVL(T2.TZTM_HRS, 0)) AS TZTM_HRS" ).append("\n"); 
		query.append("	   , NVL(T1.PORT_WRK_HRS, NVL(T2.ACT_WRK_HRS, 0)) AS ACT_WRK_HRS" ).append("\n"); 
		query.append("	   , NVL(T1.MNVR_OUT_HRS, NVL(T2.MNVR_OUT_HRS, 0)) AS MNVR_OUT_HRS" ).append("\n"); 
		query.append("	   , NVL(T1.MNVR_IN_HRS, NVL(T2.MNVR_IN_HRS, 0)) AS MNVR_IN_HRS" ).append("\n"); 
		query.append("	   , T2.ETB_DY_CD" ).append("\n"); 
		query.append("	   , T2.ETD_DY_CD" ).append("\n"); 
		query.append("       , T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("       , T2.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("	   , (" ).append("\n"); 
		query.append("			SELECT VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("    		  FROM MDM_VSL_SVC_LANE_DIR" ).append("\n"); 
		query.append("    		 WHERE VSL_SLAN_CD = T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("    		   AND VSL_SLAN_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("    		   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("		 ) AS DIR_SEQ" ).append("\n"); 
		query.append("	   , '' AS CNG_LANE_CD" ).append("\n"); 
		query.append("	   , '' AS CNG_VSL_CD" ).append("\n"); 
		query.append("	   , '' AS CNG_SKD_VOY_NO" ).append("\n"); 
		query.append("	   , '' AS CNG_SKD_DIR_CD" ).append("\n"); 
		query.append("	   , '' AS USR_HDN_FLG" ).append("\n"); 
		query.append("	   /*, (" ).append("\n"); 
		query.append("			SELECT VSL_SVC_TP_CD " ).append("\n"); 
		query.append("			FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("			WHERE VSL_SLAN_CD = T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("            AND VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("			AND ROWNUM = 1" ).append("\n"); 
		query.append("		 ) AS VSL_SVC_TP_CD*/" ).append("\n"); 
		query.append("	   , T1.CLPT_IND_SEQ AS NEW_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT T1.VSL_CD" ).append("\n"); 
		query.append("               , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        	   , T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("			   , T1.SKD_STS_CD" ).append("\n"); 
		query.append("			   , T1.SKD_VOY_TP_CD" ).append("\n"); 
		query.append("			   , T1.SKD_USD_IND_CD" ).append("\n"); 
		query.append("        	   , T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("        	   , T1.ST_PORT_CD" ).append("\n"); 
		query.append("        	   , T1.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("			   , T1.PSDO_VVD_CD" ).append("\n"); 
		query.append("			   , T1.CO_CD" ).append("\n"); 
		query.append("        	   , T1.SKD_RMK" ).append("\n"); 
		query.append("	           , T1.CRE_USR_ID AS SKD_CRE_USR_ID" ).append("\n"); 
		query.append("	           , T1.CRE_DT AS SKD_CRE_DT" ).append("\n"); 
		query.append("	           , T1.UPD_USR_ID AS SKD_UPD_USR_ID" ).append("\n"); 
		query.append("	           , T1.UPD_DT AS SKD_UPD_DT" ).append("\n"); 
		query.append("               , T2.VPS_PORT_CD" ).append("\n"); 
		query.append("        	   , T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        	   , T2.CLPT_SEQ" ).append("\n"); 
		query.append("			   , T2.SLAN_CD" ).append("\n"); 
		query.append("        	   , T2.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("        	   , T2.YD_CD" ).append("\n"); 
		query.append("			   , T2.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("               , T2.PF_ETA_DT" ).append("\n"); 
		query.append("               , T2.PF_ETB_DT" ).append("\n"); 
		query.append("               , T2.PF_ETD_DT" ).append("\n"); 
		query.append("               , T2.INIT_ETA_DT" ).append("\n"); 
		query.append("               , T2.INIT_ETB_DT" ).append("\n"); 
		query.append("               , T2.INIT_ETD_DT" ).append("\n"); 
		query.append("        	   , T2.VPS_ETA_DT" ).append("\n"); 
		query.append("        	   , T2.VPS_ETB_DT" ).append("\n"); 
		query.append("        	   , T2.VPS_ETD_DT" ).append("\n"); 
		query.append("        	   , T2.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("        	   , T2.VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("        	   , T2.VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append("			   , T2.SHP_CALL_NO" ).append("\n"); 
		query.append("			   , T2.SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append("			   , T2.SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append("			   , T2.TML_VSL_CD" ).append("\n"); 
		query.append("			   , T2.TML_VOY_NO" ).append("\n"); 
		query.append("			   , T2.FT_DT" ).append("\n"); 
		query.append("			   , T2.PLISM_YD_CD" ).append("\n"); 
		query.append("			   , T2.PLISM_VSL_CD" ).append("\n"); 
		query.append("			   , T2.PLISM_VOY_NO" ).append("\n"); 
		query.append("        	   , T2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("               , T2.TURN_PORT_FLG" ).append("\n"); 
		query.append("        	   , T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	           , T2.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("	           , T2.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	           , T2.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("			   , T2.IB_CGO_QTY" ).append("\n"); 
		query.append("			   , T2.OB_CGO_QTY" ).append("\n"); 
		query.append("        	   , T2.VPS_RMK" ).append("\n"); 
		query.append("			   , T2.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("			   , T2.PHS_IO_RMK" ).append("\n"); 
		query.append("			   , T2.SKD_BRTH_NO" ).append("\n"); 
		query.append("			   , T2.INIT_SKD_INP_FLG" ).append("\n"); 
		query.append("			   , T2.OFC_INP_FLG" ).append("\n"); 
		query.append("			   , T2.NOON_RPT_INP_FLG" ).append("\n"); 
		query.append("			   , T2.DEP_RPT_INP_FLG" ).append("\n"); 
		query.append("			   , T2.ACT_INP_FLG" ).append("\n"); 
		query.append("			   , T2.PRT_CHK_FLG" ).append("\n"); 
		query.append("	           , T2.CRE_USR_ID" ).append("\n"); 
		query.append("	           , T2.CRE_DT" ).append("\n"); 
		query.append("	           , T2.UPD_USR_ID" ).append("\n"); 
		query.append("	           , T2.UPD_DT" ).append("\n"); 
		query.append("			   , T2.EDI_SND_KNT" ).append("\n"); 
		query.append("			   , T2.SKD_AUTO_UPD_FLG" ).append("\n"); 
		query.append("			   , T2.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("			   , T2.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("			   , T2.PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append("			   , T2.TTL_DLAY_HRS" ).append("\n"); 
		query.append("			   , T2.TS_PORT_CD" ).append("\n"); 
		query.append("			   , T2.USD_FLG" ).append("\n"); 
		query.append("			   , T2.AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("        	   , T2.LNK_SPD" ).append("\n"); 
		query.append("			   , T2.SEA_BUF_HRS" ).append("\n"); 
		query.append("			   , T2.PORT_BUF_HRS" ).append("\n"); 
		query.append("			   , T2.TZTM_HRS" ).append("\n"); 
		query.append("			   , T2.PORT_WRK_HRS" ).append("\n"); 
		query.append("			   , T2.LNK_DIST" ).append("\n"); 
		query.append("			   , T2.MNVR_OUT_HRS" ).append("\n"); 
		query.append("			   , T2.MNVR_IN_HRS" ).append("\n"); 
		query.append("          FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("         WHERE T1.VSL_CD        = T2.VSL_CD" ).append("\n"); 
		query.append("           AND T1.SKD_VOY_NO    = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND T1.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND T1.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("           AND T1.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND T1.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("       ) T1, (" ).append("\n"); 
		query.append("			SELECT	T1.VSL_SLAN_CD, T1.PF_SVC_TP_CD, T1.PORT_CD, DECODE(VIRT_FLG, 'V', T1.DIR_CD2, T2.SKD_DIR_CD) AS SKD_DIR_CD," ).append("\n"); 
		query.append("					T1.CLPT_SEQ, T2.PORT_ROTN_SEQ, T2.YD_CD, CALL_YD_IND_SEQ,TURN_PORT_FLG,TURN_PORT_IND_CD,ETB_DY_CD,ETB_DY_NO" ).append("\n"); 
		query.append("					,ETB_TM_HRMNT,ETD_DY_CD,ETD_DY_NO,ETD_TM_HRMNT,LNK_DIST,LNK_SPD,TZTM_HRS" ).append("\n"); 
		query.append("					,SEA_BUF_HRS,SEA_BUF_SPD,MNVR_IN_HRS,MNVR_OUT_HRS" ).append("\n"); 
		query.append("					,IB_IPCGO_QTY,IB_OCN_CGO_QTY,OB_IPCGO_QTY" ).append("\n"); 
		query.append("					,OB_OCN_CGO_QTY,TML_PROD_QTY,CRN_KNT,ACT_WRK_HRS,PORT_BUF_HRS,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("			FROM	(" ).append("\n"); 
		query.append("					SELECT 	NVL(T3.VSL_SLAN_CD	, T1.VSL_SLAN_CD	) AS VSL_SLAN_CD," ).append("\n"); 
		query.append("							NVL(T3.PF_SVC_TP_CD	, T1.PF_SVC_TP_CD	) AS PF_SVC_TP_CD," ).append("\n"); 
		query.append("							NVL(T3.PORT_CD		, T1.PORT_CD		) AS PORT_CD," ).append("\n"); 
		query.append("							DECODE(T3.SKD_DIR_CD, NULL," ).append("\n"); 
		query.append("								(	SELECT	S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("									FROM	MDM_VSL_SVC_LANE_DIR S" ).append("\n"); 
		query.append("									WHERE	1 = 1" ).append("\n"); 
		query.append("									AND		T1.VSL_SLAN_CD	= S.VSL_SLAN_CD" ).append("\n"); 
		query.append("									AND		T1.SKD_DIR_CD	!= S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("									AND		S.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("									AND		ROWNUM			= 1" ).append("\n"); 
		query.append("								), " ).append("\n"); 
		query.append("								T1.SKD_DIR_CD) AS SKD_DIR_CD,						" ).append("\n"); 
		query.append("							DECODE(T3.CLPT_SEQ, NULL, " ).append("\n"); 
		query.append("								(SELECT	T1.CLPT_SEQ" ).append("\n"); 
		query.append("									FROM	VSK_PF_SKD_DTL M" ).append("\n"); 
		query.append("									WHERE	1 = 1" ).append("\n"); 
		query.append("									AND		T1.VSL_SLAN_CD	= M.VSL_SLAN_CD" ).append("\n"); 
		query.append("									AND		T1.PF_SVC_TP_CD	= M.PF_SVC_TP_CD" ).append("\n"); 
		query.append("									AND		T1.SKD_DIR_CD	= " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT	S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("									FROM	MDM_VSL_SVC_LANE_DIR S" ).append("\n"); 
		query.append("									WHERE	1 = 1" ).append("\n"); 
		query.append("									AND		T1.VSL_SLAN_CD	= S.VSL_SLAN_CD" ).append("\n"); 
		query.append("									AND		T1.SKD_DIR_CD	=S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("									AND		S.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("								AND		T1.PORT_CD		= M.PORT_CD" ).append("\n"); 
		query.append("								AND		T1.CLPT_SEQ		= M.CLPT_SEQ" ).append("\n"); 
		query.append("								AND     M.TURN_PORT_IND_CD != 'F'" ).append("\n"); 
		query.append("								), T1.CLPT_SEQ) AS CLPT_SEQ," ).append("\n"); 
		query.append("							DECODE(T3.SKD_DIR_CD, NULL, 'V', 'N') AS VIRT_FLG," ).append("\n"); 
		query.append("							T1.SKD_DIR_CD AS DIR_CD2" ).append("\n"); 
		query.append("					FROM  	VSK_PF_CALL_PORT T1, MDM_VSL_SVC_LANE_DIR T2, VSK_PF_SKD_DTL T3" ).append("\n"); 
		query.append("					WHERE  	1	= 1" ).append("\n"); 
		query.append("					AND		T1.VSL_SLAN_CD	= T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("					AND		T1.SKD_DIR_CD	= T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("					AND		T1.VSL_SLAN_CD	= T3.VSL_SLAN_CD 	(+)" ).append("\n"); 
		query.append("					AND		T1.PF_SVC_TP_CD	= T3.PF_SVC_TP_CD	(+)" ).append("\n"); 
		query.append("					AND		T1.SKD_DIR_CD	= T3.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("					AND		T1.PORT_CD		= T3.PORT_CD		(+)" ).append("\n"); 
		query.append("					AND		T1.CLPT_SEQ		= T3.CLPT_SEQ		(+)" ).append("\n"); 
		query.append("					AND     T3.TURN_PORT_IND_CD(+) != 'F'" ).append("\n"); 
		query.append("--					AND		T1.VSL_SLAN_CD 	= 'CNX'" ).append("\n"); 
		query.append("--					AND		T1.PF_SVC_TP_CD = '4002'" ).append("\n"); 
		query.append("					) T1, VSK_PF_SKD_DTL T2" ).append("\n"); 
		query.append("			WHERE 1 = 1" ).append("\n"); 
		query.append("			AND  T1.VSL_SLAN_CD = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("			AND  T1.PF_SVC_TP_CD = T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("			AND  T1.PORT_CD  = T2.PORT_CD" ).append("\n"); 
		query.append("			AND  T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND  T1.CLPT_SEQ  = T2.CLPT_SEQ" ).append("\n"); 
		query.append("		) T2" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND T1.VSL_SLAN_CD   = T2.VSL_SLAN_CD    (+)" ).append("\n"); 
		query.append("   AND T1.PF_SKD_TP_CD  = T2.PF_SVC_TP_CD   (+)" ).append("\n"); 
		query.append("   AND T1.SKD_DIR_CD    = T2.SKD_DIR_CD     (+)" ).append("\n"); 
		query.append("   AND T1.VPS_PORT_CD   = T2.PORT_CD        (+)" ).append("\n"); 
		query.append("   AND T1.CLPT_IND_SEQ  = T2.CLPT_SEQ       (+)" ).append("\n"); 
		query.append(" ORDER BY T1.CLPT_SEQ" ).append("\n"); 

	}
}