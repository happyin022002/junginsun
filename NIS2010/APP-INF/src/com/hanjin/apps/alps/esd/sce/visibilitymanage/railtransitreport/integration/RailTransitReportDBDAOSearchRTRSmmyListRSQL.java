/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RailTransitReportDBDAOSearchRTRSmmyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOSearchRTRSmmyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RTR Report Summary List 조회
	  * </pre>
	  */
	public RailTransitReportDBDAOSearchRTRSmmyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rank_prefix",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOSearchRTRSmmyListRSQL").append("\n"); 
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
		query.append("#if(${chk_period} == 'M')" ).append("\n"); 
		query.append("    DECODE(GROUPING_ID(MNTH, CGO_TP_CD, TRSP_BND_CD, FM_NOD_CD, TO_NOD_CD), 0, MNTH, 'Total') AS MNTH" ).append("\n"); 
		query.append(",   '' AS WEEK" ).append("\n"); 
		query.append(",   DECODE(GROUPING_ID(MNTH, CGO_TP_CD, TRSP_BND_CD, FM_NOD_CD, TO_NOD_CD), 0, CGO_TP_CD, '') AS CGO_TP_CD" ).append("\n"); 
		query.append(",   DECODE(GROUPING_ID(MNTH, CGO_TP_CD, TRSP_BND_CD, FM_NOD_CD, TO_NOD_CD), 0, TRSP_BND_CD, '') AS TRSP_BND_CD" ).append("\n"); 
		query.append("#elseif(${chk_period} == 'W')" ).append("\n"); 
		query.append("    DECODE(GROUPING_ID(WEEK, CGO_TP_CD, TRSP_BND_CD, FM_NOD_CD, TO_NOD_CD, SLS_FM_DT, SLS_TO_DT), 0, '', 'Total') AS MNTH" ).append("\n"); 
		query.append(",   DECODE(GROUPING_ID(WEEK, CGO_TP_CD, TRSP_BND_CD, FM_NOD_CD, TO_NOD_CD, SLS_FM_DT, SLS_TO_DT), 0, WEEK, '') AS WEEK" ).append("\n"); 
		query.append(",   DECODE(GROUPING_ID(WEEK, CGO_TP_CD, TRSP_BND_CD, FM_NOD_CD, TO_NOD_CD, SLS_FM_DT, SLS_TO_DT), 0, CGO_TP_CD, '') AS CGO_TP_CD" ).append("\n"); 
		query.append(",   DECODE(GROUPING_ID(WEEK, CGO_TP_CD, TRSP_BND_CD, FM_NOD_CD, TO_NOD_CD, SLS_FM_DT, SLS_TO_DT), 0, TRSP_BND_CD, '') AS TRSP_BND_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",   @[rank_prefix]||DENSE_RANK() OVER (ORDER BY FM_NOD_CD, TO_NOD_CD) AS RANK_CD" ).append("\n"); 
		query.append(",   FM_NOD_CD" ).append("\n"); 
		query.append(",   TO_NOD_CD" ).append("\n"); 
		query.append(",   COUNT(*) BOX_CNT" ).append("\n"); 
		query.append(",   DECODE(SUM(DECODE(TML_DEP_FLG,'Y',1,0)),0,0, ROUND(SUM(DECODE(TML_DEP_FLG,'Y',TML_DWLL_TM_HRS,0))/SUM(DECODE(TML_DEP_FLG,'Y',1,0)),1)) TML_DWLL_TM_HRS" ).append("\n"); 
		query.append(",   DECODE(SUM(DECODE(ORG_DEP_FLG,'Y',1,0)),0,0, ROUND(SUM(DECODE(ORG_DEP_FLG,'Y',ORG_DWLL_TM_HRS,0))/SUM(DECODE(ORG_DEP_FLG,'Y',1,0)),1)) ORG_DWLL_TM_HRS" ).append("\n"); 
		query.append(",   ROUND(AVG(RAIL_RUN_TM_HRS),1) AS RAIL_RUN_TM_HRS" ).append("\n"); 
		query.append(",   DECODE(SUM(DECODE(ITCHG_N1ST_DEP_FLG,'Y',1,0)),0,0, ROUND(SUM(DECODE(ITCHG_N1ST_DEP_FLG,'Y',ITCHG_N1ST_DWLL_TM_HRS,0))/SUM(DECODE(ITCHG_N1ST_DEP_FLG,'Y',1,0)),1)) ITCHG_N1ST_DWLL_TM_HRS" ).append("\n"); 
		query.append(",   DECODE(SUM(DECODE(ITCHG_N2ND_DEP_FLG,'Y',1,0)),0,0, ROUND(SUM(DECODE(ITCHG_N2ND_DEP_FLG,'Y',ITCHG_N2ND_DWLL_TM_HRS,0))/SUM(DECODE(ITCHG_N2ND_DEP_FLG,'Y',1,0)),1)) ITCHG_N2ND_DWLL_TM_HRS" ).append("\n"); 
		query.append(",   DECODE(SUM(DECODE(DEST_N1ST_DEP_FLG,'Y',1,0)),0,0, ROUND(SUM(DECODE(DEST_N1ST_DEP_FLG,'Y',DEST_N1ST_DWLL_TM_HRS,0))/SUM(DECODE(DEST_N1ST_DEP_FLG,'Y',1,0)),1)) DEST_N1ST_DWLL_TM_HRS" ).append("\n"); 
		query.append(",   DECODE(SUM(DECODE(DEST_N2ND_DEP_FLG,'Y',1,0)),0,0, ROUND(SUM(DECODE(DEST_N2ND_DEP_FLG,'Y',DEST_N2ND_DWLL_TM_HRS,0))/SUM(DECODE(DEST_N2ND_DEP_FLG,'Y',1,0)),1)) DEST_N2ND_DWLL_TM_HRS" ).append("\n"); 
		query.append(",   ROUND(AVG(RAIL_TZTM_HRS),1) AS RAIL_TZTM_HRS" ).append("\n"); 
		query.append(",   ROUND(AVG(TTL_TZTM_HRS),1) AS TTL_TZTM_HRS" ).append("\n"); 
		query.append("#if(${chk_period} == 'M')" ).append("\n"); 
		query.append(",   MNTH||NVL2(MNTH,'01','') SLS_FM_DT" ).append("\n"); 
		query.append(",   TO_CHAR(LAST_DAY(TO_DATE(MNTH, 'YYYYMM')),'YYYYMMDD') SLS_TO_DT" ).append("\n"); 
		query.append("#elseif(${chk_period} == 'W')" ).append("\n"); 
		query.append(",   SLS_FM_DT" ).append("\n"); 
		query.append(",   SLS_TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     (SELECT CP.COST_YR||CP.COST_WK WEEK FROM MAS_WK_PRD CP WHERE " ).append("\n"); 
		query.append("     CASE WHEN @[date_kind] = 'S' THEN RPT.SO_CRE_DT" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'A' THEN RPT.DEST_AVAL_DT" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'O' THEN (CASE WHEN(SELECT MAX(CASE WHEN (T.TRSP_BND_CD = 'O' AND T.POR_CD = T.POL_CD) OR (T.TRSP_BND_CD = 'I' AND T.POD_CD = T.DEL_CD)" ).append("\n"); 
		query.append("                                                                   THEN 'ON' ELSE 'OFF' END) CHKDOCK FROM TRS_TRSP_RAIL_BIL_ORD T" ).append("\n"); 
		query.append("                                                    WHERE T.TRSP_SO_OFC_CTY_CD = RPT.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                                    AND T.TRSP_SO_SEQ = RPT.TRSP_SO_SEQ) = 'ON' " ).append("\n"); 
		query.append("                                              THEN RPT.DEST_AVAL_DT" ).append("\n"); 
		query.append("                                        ELSE RPT.DEST_GATE_OUT_DT END)" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'I' THEN RPT.ORG_GATE_IN_DT" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'D' THEN RPT.VD_DT" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'P' THEN RPT.ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("     END" ).append("\n"); 
		query.append("     BETWEEN TO_DATE(CP.SLS_FM_DT,'YYYYMMDD') AND TO_DATE(CP.SLS_TO_DT,'YYYYMMDD')+0.99999) WEEK" ).append("\n"); 
		query.append("    ,CASE WHEN @[date_kind] = 'S' THEN TO_CHAR(RPT.SO_CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'A' THEN TO_CHAR(RPT.DEST_AVAL_DT, 'YYYYMM')" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'O' THEN TO_CHAR((CASE WHEN(SELECT MAX(CASE WHEN (T.TRSP_BND_CD = 'O' AND T.POR_CD = T.POL_CD) OR (T.TRSP_BND_CD = 'I' AND T.POD_CD = T.DEL_CD)" ).append("\n"); 
		query.append("                                                                   THEN 'ON' ELSE 'OFF' END) CHKDOCK FROM TRS_TRSP_RAIL_BIL_ORD T" ).append("\n"); 
		query.append("                                                    WHERE T.TRSP_SO_OFC_CTY_CD = RPT.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                                    AND T.TRSP_SO_SEQ = RPT.TRSP_SO_SEQ) = 'ON' " ).append("\n"); 
		query.append("                                              THEN RPT.DEST_AVAL_DT" ).append("\n"); 
		query.append("                                        ELSE RPT.DEST_GATE_OUT_DT END), 'YYYYMM')" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'I' THEN TO_CHAR(RPT.ORG_GATE_IN_DT, 'YYYYMM')" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'D' THEN TO_CHAR(RPT.VD_DT, 'YYYYMM')" ).append("\n"); 
		query.append("          WHEN @[date_kind] = 'P' THEN TO_CHAR(RPT.ORG_GATE_OUT_DT, 'YYYYMM')" ).append("\n"); 
		query.append("     END MNTH" ).append("\n"); 
		query.append("    ,CGO_TP_CD" ).append("\n"); 
		query.append("    ,NVL(TRSP_BND_CD, 'ALL') AS TRSP_BND_CD" ).append("\n"); 
		query.append("    ,SUBSTR(FM_NOD_CD, 1, LENGTH(@[fm_nod_cd])) AS FM_NOD_CD" ).append("\n"); 
		query.append("    ,SUBSTR(TO_NOD_CD, 1, LENGTH(@[to_nod_cd])) AS TO_NOD_CD" ).append("\n"); 
		query.append("    ,        (CASE WHEN NOD_CD = 'USLGBPT' AND RHS.BKG_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("              CASE WHEN RHS.LST_RLSE_DT IS NULL THEN NULL" ).append("\n"); 
		query.append("                   WHEN RPT.VD_DT IS NULL THEN NULL" ).append("\n"); 
		query.append("                   WHEN RPT.VD_DT > RHS.LST_RLSE_DT THEN (ROUND(DECODE(VD_DT, NULL, 0," ).append("\n"); 
		query.append("                        DECODE(TRSP_BND_CD, 'I'," ).append("\n"); 
		query.append("                        DECODE(ORG_GATE_IN_DT, NULL, (CASE" ).append("\n"); 
		query.append("                        WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT >= AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        (CASE WHEN TML_DEP_FLG = 'Y' THEN ORG_GATE_IN_DT" ).append("\n"); 
		query.append("                        WHEN ORG_DEP_FLG        = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(TO_NOD_CD, RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("                        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("                        END  - VD_DT)*24" ).append("\n"); 
		query.append("                        WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT < AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        (CASE WHEN TML_DEP_FLG = 'Y' THEN ORG_GATE_IN_DT" ).append("\n"); 
		query.append("                        WHEN ORG_DEP_FLG        = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(TO_NOD_CD, RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("                        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("                        END  - AMS_UPD_DT)*24" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        (CASE WHEN TML_DEP_FLG = 'Y' THEN ORG_GATE_IN_DT" ).append("\n"); 
		query.append("                        WHEN ORG_DEP_FLG      = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(TO_NOD_CD, RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("                        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("                        END  - VD_DT)*24" ).append("\n"); 
		query.append("                        END) ," ).append("\n"); 
		query.append("                        (CASE WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT >= AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - VD_DT)*24" ).append("\n"); 
		query.append("                        WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT < AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        CASE WHEN (ORG_GATE_IN_DT - AMS_UPD_DT)<0 THEN" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - VD_DT)*24" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - AMS_UPD_DT)*24" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - VD_DT)*24 END)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        ,'O', 0)),1))" ).append("\n"); 
		query.append("                   WHEN RPT.VD_DT <= RHS.LST_RLSE_DT THEN (ROUND(DECODE(RHS.LST_RLSE_DT, NULL, 0," ).append("\n"); 
		query.append("                        DECODE(TRSP_BND_CD, 'I'," ).append("\n"); 
		query.append("                        DECODE(ORG_GATE_IN_DT, NULL, (CASE" ).append("\n"); 
		query.append("                        WHEN IB_IPI_LOCL_IND_CD = 'L' AND RHS.LST_RLSE_DT >= AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        (CASE WHEN TML_DEP_FLG = 'Y' THEN ORG_GATE_IN_DT" ).append("\n"); 
		query.append("                        WHEN ORG_DEP_FLG        = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(TO_NOD_CD, RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("                        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("                        END  - RHS.LST_RLSE_DT)*24" ).append("\n"); 
		query.append("                        WHEN IB_IPI_LOCL_IND_CD = 'L' AND RHS.LST_RLSE_DT < AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        (CASE WHEN TML_DEP_FLG = 'Y' THEN ORG_GATE_IN_DT" ).append("\n"); 
		query.append("                        WHEN ORG_DEP_FLG        = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(TO_NOD_CD, RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("                        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("                        END  - AMS_UPD_DT)*24" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        (CASE WHEN TML_DEP_FLG = 'Y' THEN ORG_GATE_IN_DT" ).append("\n"); 
		query.append("                        WHEN ORG_DEP_FLG      = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(TO_NOD_CD, RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("                        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("                        END  - RHS.LST_RLSE_DT)*24" ).append("\n"); 
		query.append("                        END) ," ).append("\n"); 
		query.append("                        (CASE WHEN IB_IPI_LOCL_IND_CD = 'L' AND RHS.LST_RLSE_DT >= AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - RHS.LST_RLSE_DT)*24" ).append("\n"); 
		query.append("                        WHEN IB_IPI_LOCL_IND_CD = 'L' AND RHS.LST_RLSE_DT < AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        CASE WHEN (ORG_GATE_IN_DT - AMS_UPD_DT)<0 THEN" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - RHS.LST_RLSE_DT)*24" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - AMS_UPD_DT)*24" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - RHS.LST_RLSE_DT)*24 END)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        ,'O', 0)),1))" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("              ELSE " ).append("\n"); 
		query.append("              	(ROUND(DECODE(VD_DT, NULL, 0," ).append("\n"); 
		query.append("                        DECODE(TRSP_BND_CD, 'I'," ).append("\n"); 
		query.append("                        DECODE(ORG_GATE_IN_DT, NULL, (CASE" ).append("\n"); 
		query.append("                        WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT >= AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        (CASE WHEN TML_DEP_FLG = 'Y' THEN ORG_GATE_IN_DT" ).append("\n"); 
		query.append("                        WHEN ORG_DEP_FLG        = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N1ST_DEP_FLG = 'Y'  THEN ITCHG_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(TO_NOD_CD, RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("                        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("                        END  - VD_DT)*24" ).append("\n"); 
		query.append("                        WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT < AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        (CASE WHEN TML_DEP_FLG = 'Y' THEN ORG_GATE_IN_DT" ).append("\n"); 
		query.append("                        WHEN ORG_DEP_FLG        = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(TO_NOD_CD, RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("                        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("                        END  - AMS_UPD_DT)*24" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        (CASE WHEN TML_DEP_FLG = 'Y' THEN ORG_GATE_IN_DT" ).append("\n"); 
		query.append("                        WHEN ORG_DEP_FLG      = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("                        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("                        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(TO_NOD_CD, RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("                        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("                        END  - VD_DT)*24" ).append("\n"); 
		query.append("                        END) ," ).append("\n"); 
		query.append("                        (CASE WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT >= AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - VD_DT)*24" ).append("\n"); 
		query.append("                        WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT < AMS_UPD_DT THEN" ).append("\n"); 
		query.append("                        CASE WHEN (ORG_GATE_IN_DT - AMS_UPD_DT)<0 THEN" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - VD_DT)*24" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - AMS_UPD_DT)*24" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        (ORG_GATE_IN_DT - VD_DT)*24 END)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        ,'O', 0)),1))" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("             ) TML_DWLL_TM_HRS" ).append("\n"); 
		query.append("    ,NVL(ROUND(DECODE( ORG_GATE_IN_DT, NULL, 0," ).append("\n"); 
		query.append("        DECODE(ORG_GATE_OUT_DT, NULL," ).append("\n"); 
		query.append("        (CASE WHEN ORG_DEP_FLG = 'Y' THEN ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("        WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("        WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("        WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("        WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(RPT.TO_NOD_CD, MR_TML.RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("        ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("    END - ORG_GATE_IN_DT)*24, (ORG_GATE_OUT_DT - ORG_GATE_IN_DT)*24)),1), 0) ORG_DWLL_TM_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,DECODE(ROUND(((DEST_GATE_IN_DT - ORG_GATE_OUT_DT)*24),1), NULL, '', 0, ''," ).append("\n"); 
		query.append("    ROUND(((DEST_GATE_IN_DT - ORG_GATE_OUT_DT)*24),1)) RAIL_RUN_TM_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,ROUND(DECODE(ITCHG_GATE_IN_DT, NULL, 0," ).append("\n"); 
		query.append("    DECODE(ITCHG_DT, NULL," ).append("\n"); 
		query.append("    (CASE WHEN ITCHG_N1ST_DEP_FLG = 'Y' THEN ITCHG_DT" ).append("\n"); 
		query.append("    WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("    WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("    WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(RPT.TO_NOD_CD, MR_TML.RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("    ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("    END - ITCHG_GATE_IN_DT)*24, (ITCHG_DT - ITCHG_GATE_IN_DT)*24)),1) ITCHG_N1ST_DWLL_TM_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,ROUND(DECODE(ITCHG_DT, NULL, 0," ).append("\n"); 
		query.append("    DECODE(ITCHG_GATE_OUT_DT, NULL," ).append("\n"); 
		query.append("    (CASE WHEN ITCHG_N2ND_DEP_FLG = 'Y' THEN ITCHG_GATE_OUT_DT" ).append("\n"); 
		query.append("    WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("    WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(RPT.TO_NOD_CD, MR_TML.RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("    ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("    END - ITCHG_DT)*24, (ITCHG_GATE_OUT_DT - ITCHG_DT)*24)),1) ITCHG_N2ND_DWLL_TM_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,ROUND(DECODE(DEST_GATE_IN_DT, NULL, 0," ).append("\n"); 
		query.append("    DECODE(DEST_AVAL_DT, NULL," ).append("\n"); 
		query.append("    (CASE WHEN DEST_N1ST_DEP_FLG  = 'Y' THEN DEST_AVAL_DT" ).append("\n"); 
		query.append("    WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DECODE(RPT.TO_NOD_CD, MR_TML.RAIL_NOD, DEST_AVAL_DT, DEST_GATE_OUT_DT)" ).append("\n"); 
		query.append("    ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("    END - DEST_GATE_IN_DT)*24, (DEST_AVAL_DT - DEST_GATE_IN_DT)*24)),1) DEST_N1ST_DWLL_TM_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,ROUND(DECODE(DEST_AVAL_DT, NULL, 0," ).append("\n"); 
		query.append("    DECODE(RPT.TO_NOD_CD, MR_TML.RAIL_NOD, '0'," ).append("\n"); 
		query.append("    DECODE(DEST_GATE_OUT_DT, NULL," ).append("\n"); 
		query.append("    (CASE WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DEST_GATE_OUT_DT" ).append("\n"); 
		query.append("    ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("    END - DEST_AVAL_DT)*24," ).append("\n"); 
		query.append("    (DEST_GATE_OUT_DT - DEST_AVAL_DT)*24))),1) DEST_N2ND_DWLL_TM_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,DECODE(TRSP_BND_CD, 'O'," ).append("\n"); 
		query.append("    DECODE(ROUND(((DEST_AVAL_DT - ORG_GATE_IN_DT )*24),1), NULL, '', 0, ''," ).append("\n"); 
		query.append("    ROUND(((DEST_AVAL_DT - ORG_GATE_IN_DT)*24),1))," ).append("\n"); 
		query.append("    DECODE(ROUND(((DEST_AVAL_DT - VD_DT)*24),1), NULL, '', 0, ''," ).append("\n"); 
		query.append("    (CASE WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT < AMS_UPD_DT THEN" ).append("\n"); 
		query.append("    ROUND(((DEST_AVAL_DT - AMS_UPD_DT)*24),1)" ).append("\n"); 
		query.append("    WHEN IB_IPI_LOCL_IND_CD = 'L' OR IB_IPI_LOCL_IND_CD = 'I' THEN" ).append("\n"); 
		query.append("    ROUND(((DEST_AVAL_DT - VD_DT)*24),1)" ).append("\n"); 
		query.append("    ELSE ROUND(((DEST_AVAL_DT - VD_DT)*24),1)" ).append("\n"); 
		query.append("    END )" ).append("\n"); 
		query.append("    )) RAIL_TZTM_HRS" ).append("\n"); 
		query.append("    ,DECODE(TRSP_BND_CD, 'O'," ).append("\n"); 
		query.append("    DECODE(ROUND(((DEST_GATE_OUT_DT - ORG_GATE_IN_DT )*24),1), NULL, '', 0, ''," ).append("\n"); 
		query.append("    ROUND(((DEST_GATE_OUT_DT - ORG_GATE_IN_DT)*24),1))," ).append("\n"); 
		query.append("    DECODE(ROUND(((DEST_AVAL_DT - VD_DT)*24),1), NULL, '', 0, ''," ).append("\n"); 
		query.append("    (CASE WHEN IB_IPI_LOCL_IND_CD = 'L' AND VD_DT < AMS_UPD_DT THEN" ).append("\n"); 
		query.append("    ROUND(((DEST_AVAL_DT - AMS_UPD_DT)*24),1)" ).append("\n"); 
		query.append("    WHEN IB_IPI_LOCL_IND_CD = 'L' OR IB_IPI_LOCL_IND_CD = 'I' THEN" ).append("\n"); 
		query.append("    ROUND(((DEST_AVAL_DT - VD_DT)*24),1)" ).append("\n"); 
		query.append("    ELSE ROUND(((DEST_AVAL_DT - VD_DT)*24),1)" ).append("\n"); 
		query.append("    END )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    +" ).append("\n"); 
		query.append("    DECODE(DEST_N2ND_DEP_FLG, 'Y'," ).append("\n"); 
		query.append("    ROUND(DECODE(DEST_AVAL_DT, NULL, 0," ).append("\n"); 
		query.append("    DECODE(RPT.TO_NOD_CD, MR_TML.RAIL_NOD, '0'," ).append("\n"); 
		query.append("    DECODE(DEST_GATE_OUT_DT, NULL," ).append("\n"); 
		query.append("    (CASE WHEN DEST_N2ND_DEP_FLG  = 'Y' THEN DEST_GATE_OUT_DT" ).append("\n"); 
		query.append("    ELSE (GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, 'USNYC'))" ).append("\n"); 
		query.append("    END - DEST_AVAL_DT)*24," ).append("\n"); 
		query.append("    (DEST_GATE_OUT_DT - DEST_AVAL_DT)*24))),1))" ).append("\n"); 
		query.append("    ) AS TTL_TZTM_HRS, " ).append("\n"); 
		query.append("    TML_DEP_FLG," ).append("\n"); 
		query.append("    ORG_DEP_FLG," ).append("\n"); 
		query.append("    ITCHG_N1ST_DEP_FLG," ).append("\n"); 
		query.append("    ITCHG_N2ND_DEP_FLG," ).append("\n"); 
		query.append("    DEST_N1ST_DEP_FLG," ).append("\n"); 
		query.append("    DEST_N2ND_DEP_FLG" ).append("\n"); 
		query.append("FROM    SCE_RAIL_TZ_RPT         RPT" ).append("\n"); 
		query.append(",       BKG_BOOKING             BKG" ).append("\n"); 
		query.append(",       BKG_CGO_RLSE            CR" ).append("\n"); 
		query.append(",       SCE_RAIL_HLD_STS        RHS" ).append("\n"); 
		query.append(",       (" ).append("\n"); 
		query.append("        SELECT 'CAVANM2' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USLGBPT' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USORFM2' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USPDXM1' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USSAVM1' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USTIWM1' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USLGBM5' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USLGBM6' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USLAXYM' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USLAXM2' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USORFM5' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USTIWYM' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'CAPRRM1' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'CAMTRC2' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT 'USLAXM3' RAIL_NOD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'USLAXM4' RAIL_NOD FROM DUAL" ).append("\n"); 
		query.append("        ) MR_TML" ).append("\n"); 
		query.append("WHERE   RPT.BKG_NO              = BKG.BKG_NO (+)" ).append("\n"); 
		query.append("AND     NVL(RPT.DELT_FLG, 'N')  = 'N'" ).append("\n"); 
		query.append("AND     CR.BL_NO (+)            = BKG.BL_NO" ).append("\n"); 
		query.append("AND     RPT.TO_NOD_CD           = MR_TML.RAIL_NOD(+)" ).append("\n"); 
		query.append("AND     RPT.BKG_NO		        = RHS.BKG_NO(+)" ).append("\n"); 
		query.append("AND     RPT.EQ_NO	        	= RHS.CNTR_NO(+)" ).append("\n"); 
		query.append("#if(${date_kind} != '')" ).append("\n"); 
		query.append("    #if(${date_kind} == 'S')" ).append("\n"); 
		query.append("        #if(${fm_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND RPT.SO_CRE_DT BETWEEN TO_DATE(@[fm_date]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_date]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        #end	" ).append("\n"); 
		query.append("    #elseif(${date_kind} == 'A')" ).append("\n"); 
		query.append("        #if(${fm_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND RPT.DEST_AVAL_DT BETWEEN  TO_DATE(@[fm_date]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_date]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #elseif(${date_kind} == 'O')" ).append("\n"); 
		query.append("        #if(${fm_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND (CASE WHEN(SELECT MAX(CASE WHEN (T.TRSP_BND_CD = 'O' AND T.POR_CD = T.POL_CD) OR (T.TRSP_BND_CD = 'I' AND T.POD_CD = T.DEL_CD)" ).append("\n"); 
		query.append("                               THEN 'ON' ELSE 'OFF' END) CHKDOCK" ).append("\n"); 
		query.append("                 FROM TRS_TRSP_RAIL_BIL_ORD T" ).append("\n"); 
		query.append("                WHERE T.TRSP_SO_OFC_CTY_CD = RPT.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                  AND T.TRSP_SO_SEQ = RPT.TRSP_SO_SEQ) = 'ON' THEN RPT.DEST_AVAL_DT" ).append("\n"); 
		query.append("          ELSE RPT.DEST_GATE_OUT_DT" ).append("\n"); 
		query.append("      END) BETWEEN  TO_DATE(@[fm_date]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_date]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #elseif(${date_kind} == 'I')" ).append("\n"); 
		query.append("        #if(${fm_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND RPT.ORG_GATE_IN_DT BETWEEN  TO_DATE(@[fm_date]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_date]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #elseif(${date_kind} == 'D')" ).append("\n"); 
		query.append("        #if(${fm_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND RPT.VD_DT BETWEEN  TO_DATE(@[fm_date]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_date]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #elseif(${date_kind} == 'P')" ).append("\n"); 
		query.append("        #if(${fm_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND RPT.ORG_GATE_OUT_DT BETWEEN  TO_DATE(@[fm_date]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_date]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end			" ).append("\n"); 
		query.append("#if(${fm_nod_cd} != '')" ).append("\n"); 
		query.append("AND FM_NOD_CD LIKE @[fm_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${to_nod_cd} != '')" ).append("\n"); 
		query.append("AND TO_NOD_CD LIKE @[to_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trsp_bnd_cd} != '')" ).append("\n"); 
		query.append("AND TRSP_BND_CD = @[trsp_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sc_no} != '')" ).append("\n"); 
		query.append("AND RPT.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") I" ).append("\n"); 
		query.append("#if(${chk_period} == 'W')" ).append("\n"); 
		query.append(", MAS_WK_PRD J" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${chk_period} == 'W')" ).append("\n"); 
		query.append("AND SUBSTR(I.WEEK,1,4) = COST_YR" ).append("\n"); 
		query.append("AND SUBSTR(I.WEEK,5,2) = COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("GROUPING SETS(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#if(${chk_period} == 'W')" ).append("\n"); 
		query.append("    WEEK" ).append("\n"); 
		query.append("#elseif(${chk_period} == 'M')" ).append("\n"); 
		query.append("    MNTH" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",   CGO_TP_CD" ).append("\n"); 
		query.append(",   TRSP_BND_CD" ).append("\n"); 
		query.append(",   FM_NOD_CD" ).append("\n"); 
		query.append(",   TO_NOD_CD" ).append("\n"); 
		query.append("#if(${chk_period} == 'W')" ).append("\n"); 
		query.append(",   SLS_FM_DT" ).append("\n"); 
		query.append(",   SLS_TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("(   FM_NOD_CD" ).append("\n"); 
		query.append(",   TO_NOD_CD )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}