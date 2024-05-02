/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchIHCGuidelineDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOSearchIHCGuidelineDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve IHC Guideline Detail  ( IHCGuidelineDetailVO 생성 쿼리)
	  * 2013.02.07 [CHM-201322859] 서미진 over weight svc flag에 따라 weight를 조회하여 보여줌
	  * 2013.03.16 [CHM-201534279] 전지예 Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchIHCGuidelineDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_cost_trf_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOSearchIHCGuidelineDetailRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("     , SUB.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , SUB.IHC_TRF_NO" ).append("\n"); 
		query.append("     , SUB.AMDT_SEQ" ).append("\n"); 
		query.append("     , SUB.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("     , SUB.RT_SEQ" ).append("\n"); 
		query.append("     , SUB.PNT_LOC_CD" ).append("\n"); 
		query.append("     , SUB.PNT_NOD_CD" ).append("\n"); 
		query.append("     , (SELECT LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION" ).append("\n"); 
		query.append("         WHERE LOC_CD = SUB.PNT_LOC_CD" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS PNT_LOC_NM" ).append("\n"); 
		query.append("     , SUB.HUB_LOC_CD" ).append("\n"); 
		query.append("     , SUB.HUB_NOD_CD" ).append("\n"); 
		query.append("     , SUB.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("     , SUB.BSE_PORT_NOD_CD" ).append("\n"); 
		query.append("     , SUB.IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("     , SUB.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , SUB.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , SUB.GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.GLINE_45FT_FRT_RT_AMT, SUB.GLINE_40FT_FRT_RT_AMT) GLINE_45FT_FRT_RT_AMT-- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.COST_45FT_FRT_RT_AMT, SUB.COST_40FT_FRT_RT_AMT) COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_20FT_FRT_RT_AMT, 0) - NVL(SUB.COST_20FT_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) DIFF_20FT" ).append("\n"); 
		query.append("     , DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_40FT_FRT_RT_AMT, 0) - NVL(SUB.COST_40FT_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) DIFF_40FT" ).append("\n"); 
		query.append("	  -- 45' Cost 추가" ).append("\n"); 
		query.append("     , CASE WHEN RHQ_CD = 'HAMRU'" ).append("\n"); 
		query.append("            THEN DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_45FT_FRT_RT_AMT, 0) - NVL(SUB.COST_45FT_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) " ).append("\n"); 
		query.append("            ELSE DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_40FT_FRT_RT_AMT, 0) - NVL(SUB.COST_40FT_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) " ).append("\n"); 
		query.append("        END DIFF_45FT" ).append("\n"); 
		query.append("     , DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_20FT_RAIL_FRT_RT_AMT, 0) - NVL(SUB.COST_20FT_RAIL_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) DIFF_RAIL_20FT" ).append("\n"); 
		query.append("     , DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_40FT_RAIL_FRT_RT_AMT, 0) - NVL(SUB.COST_40FT_RAIL_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) DIFF_RAIL_40FT" ).append("\n"); 
		query.append("	  -- 45' Cost 추가" ).append("\n"); 
		query.append("     , CASE WHEN RHQ_CD = 'HAMRU'" ).append("\n"); 
		query.append("            THEN DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_45FT_RAIL_FRT_RT_AMT, 0) - NVL(SUB.COST_45FT_RAIL_FRT_RT_AMT, 0), 'FM9,999,999,990.90'))" ).append("\n"); 
		query.append("            ELSE DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_40FT_RAIL_FRT_RT_AMT, 0) - NVL(SUB.COST_40FT_RAIL_FRT_RT_AMT, 0), 'FM9,999,999,990.90'))" ).append("\n"); 
		query.append("        END DIFF_RAIL_45FT" ).append("\n"); 
		query.append("     , DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_20FT_TRK_FRT_RT_AMT, 0) - NVL(SUB.COST_20FT_TRK_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) DIFF_TRK_20FT" ).append("\n"); 
		query.append("     , DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_40FT_TRK_FRT_RT_AMT, 0) - NVL(SUB.COST_40FT_TRK_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) DIFF_TRK_40FT" ).append("\n"); 
		query.append("	  -- 45' Cost 추가" ).append("\n"); 
		query.append("     , CASE WHEN RHQ_CD = 'HAMRU'" ).append("\n"); 
		query.append("            THEN DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_45FT_TRK_FRT_RT_AMT, 0) - NVL(SUB.COST_45FT_TRK_FRT_RT_AMT, 0), 'FM9,999,999,990.90'))" ).append("\n"); 
		query.append("            ELSE DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_40FT_TRK_FRT_RT_AMT, 0) - NVL(SUB.COST_40FT_TRK_FRT_RT_AMT, 0), 'FM9,999,999,990.90'))" ).append("\n"); 
		query.append("        END DIFF_TRK_45FT" ).append("\n"); 
		query.append("     , SUB.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , SUB.LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.LOCL_CURR_COST_45FT_FRT_RT_AMT, SUB.LOCL_CURR_COST_40FT_FRT_RT_AMT) LOCL_CURR_COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("     , SUB.TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.TRSP_45FT_COST_AMT, SUB.TRSP_40FT_COST_AMT) TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("     , SUB.MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.MTY_TRSP_45FT_COST_AMT, SUB.MTY_TRSP_40FT_COST_AMT) MTY_TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.TML_20FT_COST_AMT" ).append("\n"); 
		query.append("     , SUB.TML_40FT_COST_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.TML_45FT_COST_AMT, SUB.TML_40FT_COST_AMT) TML_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.MB_20FT_RTO" ).append("\n"); 
		query.append("     , SUB.MB_40FT_RTO" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.MB_45FT_RTO, SUB.MB_40FT_RTO) MB_45FT_RTO -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , SUB.NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          FROM PRI_TRF_IHC_MN" ).append("\n"); 
		query.append("         WHERE SVC_SCP_CD = SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND IHC_TRF_NO = SUB.IHC_TRF_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = SUB.N1ST_CMNC_AMDT_SEQ) AS EFF_DT" ).append("\n"); 
		query.append("     , (SELECT CASE" ).append("\n"); 
		query.append("          WHEN M.AMDT_SEQ = SUB.AMDT_SEQ THEN DECODE(TO_CHAR(M.EXP_DT, 'YYYYMMDD'),'99991231', NULL , TO_CHAR(M.EXP_DT, 'YYYYMMDD'))" ).append("\n"); 
		query.append("          WHEN M.AMDT_SEQ <> SUB.AMDT_SEQ THEN TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("          WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE DECODE(TO_CHAR(N.EXP_DT, 'YYYYMMDD'),'99991231', NULL , TO_CHAR(N.EXP_DT, 'YYYYMMDD')) END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_TRF_IHC_MN M, PRI_TRF_IHC_MN N" ).append("\n"); 
		query.append("         WHERE M.IHC_TRF_NO = SUB.IHC_TRF_NO" ).append("\n"); 
		query.append("           AND N.IHC_TRF_NO = SUB.IHC_TRF_NO" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ = '0'" ).append("\n"); 
		query.append("           AND N.AMDT_SEQ = M.AMDT_SEQ - DECODE('1', SUB.AMDT_SEQ, 0, 0, 0, 1)" ).append("\n"); 
		query.append("           AND M.SVC_SCP_CD = SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND N.SVC_SCP_CD = SUB.SVC_SCP_CD) AS EXP_DT" ).append("\n"); 
		query.append("   	 , SUB.OPTM_TRSP_MOD_FLG  " ).append("\n"); 
		query.append("     , SUB.SRC_INFO_CD" ).append("\n"); 
		query.append("     , SUB.IHC_RT_RMK" ).append("\n"); 
		query.append("     , SUB.DCGO_SVC_FLG" ).append("\n"); 
		query.append("     , SUB.PRC_TRF_CRE_TP_CD" ).append("\n"); 
		query.append("     , SUB.USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("     , SUB.GLINE_20FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.GLINE_40FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.GLINE_45FT_RAIL_FRT_RT_AMT, SUB.GLINE_40FT_RAIL_FRT_RT_AMT) GLINE_45FT_RAIL_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.GLINE_20FT_TRK_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.GLINE_40FT_TRK_FRT_RT_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.GLINE_45FT_TRK_FRT_RT_AMT, SUB.GLINE_40FT_TRK_FRT_RT_AMT) GLINE_45FT_TRK_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.COST_20FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.COST_40FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.COST_45FT_RAIL_FRT_RT_AMT, SUB.COST_40FT_RAIL_FRT_RT_AMT) COST_45FT_RAIL_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.COST_20FT_TRK_FRT_RT_AMT" ).append("\n"); 
		query.append("     , SUB.COST_40FT_TRK_FRT_RT_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.COST_45FT_TRK_FRT_RT_AMT, SUB.COST_40FT_TRK_FRT_RT_AMT) COST_45FT_TRK_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.TRSP_20FT_RAIL_COST_AMT" ).append("\n"); 
		query.append("     , SUB.TRSP_40FT_RAIL_COST_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.TRSP_45FT_RAIL_COST_AMT, SUB.TRSP_40FT_RAIL_COST_AMT) TRSP_45FT_RAIL_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.TRSP_20FT_TRK_COST_AMT" ).append("\n"); 
		query.append("     , SUB.TRSP_40FT_TRK_COST_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.TRSP_45FT_TRK_COST_AMT, SUB.TRSP_40FT_TRK_COST_AMT) TRSP_45FT_TRK_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MIN_CGO_WGT, '')" ).append("\n"); 
		query.append("          , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MAX_CGO_WGT, '')) ) " ).append("\n"); 
		query.append("       OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) " ).append("\n"); 
		query.append("       AS TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("     , MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MIN_CGO_WGT, '')" ).append("\n"); 
		query.append("          , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MAX_CGO_WGT, '') ) )" ).append("\n"); 
		query.append("       OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) " ).append("\n"); 
		query.append("       AS TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("     , MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, DECODE(RHQ_CD, 'HAMRU', '45', '40'), SPCL.MIN_CGO_WGT, '')" ).append("\n"); 
		query.append("          , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, DECODE(RHQ_CD, 'HAMRU', '45', '40'), SPCL.MAX_CGO_WGT, '') ) )" ).append("\n"); 
		query.append("       OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) " ).append("\n"); 
		query.append("       AS TRSP_45FT_AGMT_WGT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , SUB.GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("     , SUB.GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("     , DECODE(RHQ_CD, 'HAMRU', SUB.GLINE_LOCL_CURR_45FT_AMT, SUB.GLINE_LOCL_CURR_40FT_AMT) GLINE_LOCL_CURR_45FT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("     , DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_LOCL_CURR_20FT_AMT, 0) - NVL(SUB.LOCL_CURR_COST_20FT_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) DIFF_LOCL_20FT" ).append("\n"); 
		query.append("     , DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_LOCL_CURR_40FT_AMT, 0) - NVL(SUB.LOCL_CURR_COST_40FT_FRT_RT_AMT, 0), 'FM9,999,999,990.90')) DIFF_LOCL_40FT" ).append("\n"); 
		query.append("	  -- 45' Cost 추가" ).append("\n"); 
		query.append("     , CASE WHEN RHQ_CD = 'HAMRU'" ).append("\n"); 
		query.append("            THEN DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_LOCL_CURR_45FT_AMT, 0) - NVL(SUB.LOCL_CURR_COST_45FT_FRT_RT_AMT, 0), 'FM9,999,999,990.90'))" ).append("\n"); 
		query.append("            ELSE DECODE(SUB.PRC_TRF_CRE_TP_CD, 'G', 'N/A', TO_CHAR(NVL(SUB.GLINE_LOCL_CURR_40FT_AMT, 0) - NVL(SUB.LOCL_CURR_COST_40FT_FRT_RT_AMT, 0), 'FM9,999,999,990.90'))" ).append("\n"); 
		query.append("        END DIFF_LOCL_45FT" ).append("\n"); 
		query.append("     , SUB.CRE_USR_ID" ).append("\n"); 
		query.append("     , SUB.CRE_DT" ).append("\n"); 
		query.append("     , SUB.UPD_USR_ID" ).append("\n"); 
		query.append("     , SUB.UPD_DT" ).append("\n"); 
		query.append("     , RHQ_CD" ).append("\n"); 
		query.append("  FROM ( SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("             , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("             , IHC_TRF_NO" ).append("\n"); 
		query.append("             , AMDT_SEQ" ).append("\n"); 
		query.append("             , IHC_CGO_TP_CD" ).append("\n"); 
		query.append("             , RT_SEQ" ).append("\n"); 
		query.append("             , PNT_LOC_CD" ).append("\n"); 
		query.append("             , PNT_NOD_CD" ).append("\n"); 
		query.append("             , HUB_LOC_CD" ).append("\n"); 
		query.append("             , HUB_NOD_CD" ).append("\n"); 
		query.append("             , BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("             , BSE_PORT_NOD_CD" ).append("\n"); 
		query.append("             , IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("             , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("             , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("             , GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , LOCL_CURR_CD" ).append("\n"); 
		query.append("             , LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , LOCL_CURR_COST_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("             , TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("             , TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("             , MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("             , MTY_TRSP_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , TML_20FT_COST_AMT" ).append("\n"); 
		query.append("             , TML_40FT_COST_AMT" ).append("\n"); 
		query.append("             , TML_45FT_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , MB_20FT_RTO" ).append("\n"); 
		query.append("             , MB_40FT_RTO" ).append("\n"); 
		query.append("             , MB_45FT_RTO -- 45' Cost 추가" ).append("\n"); 
		query.append("             , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("             , LEAD(N1ST_CMNC_AMDT_SEQ) OVER(PARTITION BY SVC_SCP_CD, IHC_TRF_NO, RT_SEQ ORDER BY AMDT_SEQ) AS NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("             , OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("             , SRC_INFO_CD" ).append("\n"); 
		query.append("             , IHC_RT_RMK" ).append("\n"); 
		query.append("             , DCGO_SVC_FLG" ).append("\n"); 
		query.append("             , PRC_TRF_CRE_TP_CD" ).append("\n"); 
		query.append("             , USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("             , GLINE_20FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_40FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_45FT_RAIL_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , GLINE_20FT_TRK_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_40FT_TRK_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_45FT_TRK_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , COST_20FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_40FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_45FT_RAIL_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , COST_20FT_TRK_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_40FT_TRK_FRT_RT_AMT" ).append("\n"); 
		query.append("             , COST_45FT_TRK_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , TRSP_20FT_RAIL_COST_AMT" ).append("\n"); 
		query.append("             , TRSP_40FT_RAIL_COST_AMT" ).append("\n"); 
		query.append("             , TRSP_45FT_RAIL_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , TRSP_20FT_TRK_COST_AMT" ).append("\n"); 
		query.append("             , TRSP_40FT_TRK_COST_AMT" ).append("\n"); 
		query.append("             , TRSP_45FT_TRK_COST_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("             , GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("             , GLINE_LOCL_CURR_45FT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , CRE_USR_ID" ).append("\n"); 
		query.append("             , CRE_DT" ).append("\n"); 
		query.append("             , UPD_USR_ID" ).append("\n"); 
		query.append("             , UPD_DT" ).append("\n"); 
		query.append("          FROM PRI_TRF_IHC_RT" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND SVC_SCP_CD     = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("           AND IHC_TRF_NO     = @[ihc_trf_no]" ).append("\n"); 
		query.append("           AND (AMDT_SEQ = @[amdt_seq] OR" ).append("\n"); 
		query.append("               (AMDT_SEQ = @[amdt_seq] - 1 AND" ).append("\n"); 
		query.append("               SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("           AND IHC_CGO_TP_CD  = @[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("      #if(${usa_cost_trf_svc_mod_cd} != '')" ).append("\n"); 
		query.append("           AND USA_COST_TRF_SVC_MOD_CD = @[usa_cost_trf_svc_mod_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("           AND OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("      ) SUB" ).append("\n"); 
		query.append("      , PRI_TRF_IHC_SPCL_CGO_RT SPCL" ).append("\n"); 
		query.append("      , PRI_TRF_IHC_HDR HDR" ).append("\n"); 
		query.append(" WHERE (SUB.NEXT_N1ST_CMNC_AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("    OR SUB.N1ST_CMNC_AMDT_SEQ <> SUB.NEXT_N1ST_CMNC_AMDT_SEQ)" ).append("\n"); 
		query.append("   AND SUB.SVC_SCP_CD = HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND SUB.ORG_DEST_TP_CD = HDR.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("   AND SUB.IHC_TRF_NO = HDR.IHC_TRF_NO" ).append("\n"); 
		query.append("   AND SUB.SVC_SCP_CD = SPCL.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND SUB.ORG_DEST_TP_CD = SPCL.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("   AND SUB.IHC_TRF_NO = SPCL.IHC_TRF_NO" ).append("\n"); 
		query.append("   AND SUB.PRC_TRSP_MOD_CD = SPCL.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(" ORDER BY SUB.RT_SEQ , SUB.AMDT_SEQ" ).append("\n"); 

	}
}