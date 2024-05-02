/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCRateProposalDBDAORsltRtDtlListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.28
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.28 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltRtDtlListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate - rate조회
	  * 2013.03.11 전윤주 [CHM-201323464] FRC Surcgarge 추가
	  * 2015.04.28 송호진 [CHM-201535688] LSF Surcgarge 추가
	  * </pre>
	  */
	public SCRateProposalDBDAORsltRtDtlListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltRtDtlListVORSQL").append("\n"); 
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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("      ,AMDT_SEQ" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ,ROUT_SEQ" ).append("\n"); 
		query.append("      ,RT_SEQ" ).append("\n"); 
		query.append("      ,RAT_UT_CD" ).append("\n"); 
		query.append("      ,PRC_CGO_TP_CD" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("      ,PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("	  ,BUC_SCG_AMT" ).append("\n"); 
		query.append("      ,PSC_SCG_AMT" ).append("\n"); 
		query.append("      ,FRC_SCG_AMT" ).append("\n"); 
		query.append("      ,LSF_SCG_AMT" ).append("\n"); 
		query.append("      ,(PROP_FRT_RT_AMT + NVL(BUC_SCG_AMT,0) + NVL(FRC_SCG_AMT,0)) AS TOTAL_RT" ).append("\n"); 
		query.append("--      ,(PROP_FRT_RT_AMT + NVL(BUC_SCG_AMT,0) + NVL(PSC_SCG_AMT,0)) AS TOTAL_RT" ).append("\n"); 
		query.append("--      ,(PROP_FRT_RT_AMT + NVL(BUC_SCG_AMT,0) ) AS TOTAL_RT" ).append("\n"); 
		query.append("      ,LSF_SCG_AMT" ).append("\n"); 
		query.append("      ,(PROP_FRT_RT_AMT + NVL(BUC_SCG_AMT,0) + NVL(FRC_SCG_AMT,0) + NVL(LSF_SCG_AMT,0)) AS TOTAL_LSF_RT " ).append("\n"); 
		query.append("      ,COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("      ,FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("      ,PRS_SCG_AMT" ).append("\n"); 
		query.append("      ,PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append("      ,PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append("      ,PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("      ,PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append("      ,PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("      ,PRS_RESPB_CMPB_AMT - PRS_GID_CMPB_AMT AS DIFF" ).append("\n"); 
		query.append("      ,PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append("      ,PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("      ,PRS_UPD_DT" ).append("\n"); 
		query.append("      ,DECODE(GRI_APPL_TP_CD, 'N', '', GRI_APPL_TP_CD) AS GRI_APPL_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(GRI_APPL_TP_CD, 'N', '', GRI_APPL_AMT) AS GRI_APPL_AMT" ).append("\n"); 
		query.append("      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01719'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = PRC_PROG_STS_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS PRC_PROG_STS_NM" ).append("\n"); 
		query.append("      ,SRC_INFO_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD02064'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = SRC_INFO_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS SRC_INFO_NM" ).append("\n"); 
		query.append("      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_MN" ).append("\n"); 
		query.append("         WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = A.SVC_SCP_CD) AS EFF_DT" ).append("\n"); 
		query.append("      ,(SELECT CASE" ).append("\n"); 
		query.append("                 WHEN M.AMDT_SEQ = A.AMDT_SEQ THEN" ).append("\n"); 
		query.append("                  TO_CHAR(M.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                 WHEN M.EFF_DT <= N.EXP_DT THEN" ).append("\n"); 
		query.append("                  TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                  TO_CHAR(N.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_MN M, PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("         WHERE M.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND N.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND N.AMDT_SEQ = M.AMDT_SEQ - DECODE(@[amdt_seq], A.AMDT_SEQ, 0, 0, 0, 1)" ).append("\n"); 
		query.append("           AND M.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND N.SVC_SCP_CD = A.SVC_SCP_CD) AS EXP_DT" ).append("\n"); 
		query.append("      ,ACPT_USR_ID" ).append("\n"); 
		query.append("      ,ACPT_OFC_CD" ).append("\n"); 
		query.append("      ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID AND ROWNUM = 1) || ' / ' || A.ACPT_OFC_CD AS ACPT_USR_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(A.ACPT_DT, 'YYYYMMDD') AS ACPT_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,FIRST_VALUE(DECODE(PRC_CGO_TP_CD, 'DR', 1, 'RF', 2, 'DG', 3, 'AK', 4, 99)) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ ORDER BY AMDT_SEQ) AS N1ST_ORD_REF" ).append("\n"); 
		query.append("      ,FIRST_VALUE(RAT_UT_CD) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ ORDER BY AMDT_SEQ) AS N2ND_ORD_REF" ).append("\n"); 
		query.append("  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,RT_SEQ" ).append("\n"); 
		query.append("              ,RAT_UT_CD" ).append("\n"); 
		query.append("              ,PRC_CGO_TP_CD" ).append("\n"); 
		query.append("              ,CURR_CD" ).append("\n"); 
		query.append("              ,PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("              ,COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("              ,FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("              ,PRS_SCG_AMT" ).append("\n"); 
		query.append("              ,PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append("              ,PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append("              ,PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("              ,PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append("              ,PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("              ,PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append("              ,PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("              ,PRS_UPD_DT" ).append("\n"); 
		query.append("              ,GRI_APPL_TP_CD" ).append("\n"); 
		query.append("              ,GRI_APPL_AMT" ).append("\n"); 
		query.append("              ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("              ,SRC_INFO_CD" ).append("\n"); 
		query.append("              ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("              ,LEAD(N1ST_CMNC_AMDT_SEQ) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ ORDER BY AMDT_SEQ) AS NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("              ,ACPT_USR_ID" ).append("\n"); 
		query.append("              ,ACPT_OFC_CD" ).append("\n"); 
		query.append("              ,ACPT_DT" ).append("\n"); 
		query.append("              ,CRE_USR_ID" ).append("\n"); 
		query.append("              ,CRE_DT" ).append("\n"); 
		query.append("              ,UPD_USR_ID" ).append("\n"); 
		query.append("              ,UPD_DT" ).append("\n"); 
		query.append("              ,(  SELECT TRF_SCG_AMT" ).append("\n"); 
		query.append("                      FROM PRI_SP_SCP_RT_SCG SCG " ).append("\n"); 
		query.append("                      WHERE SCG.PROP_NO = RT.PROP_NO " ).append("\n"); 
		query.append("                      AND SCG.AMDT_SEQ = RT.AMDT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.SVC_SCP_CD = RT.SVC_SCP_CD " ).append("\n"); 
		query.append("                      AND SCG.GEN_SPCL_RT_TP_CD = RT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("                      AND SCG.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("                      AND SCG.ROUT_SEQ = RT.ROUT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.RT_SEQ = RT.RT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.CHG_CD = 'BUC' ) AS BUC_SCG_AMT" ).append("\n"); 
		query.append("              ,(  SELECT TRF_SCG_AMT" ).append("\n"); 
		query.append("                      FROM PRI_SP_SCP_RT_SCG SCG " ).append("\n"); 
		query.append("                      WHERE SCG.PROP_NO = RT.PROP_NO " ).append("\n"); 
		query.append("                      AND SCG.AMDT_SEQ = RT.AMDT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.SVC_SCP_CD = RT.SVC_SCP_CD " ).append("\n"); 
		query.append("                      AND SCG.GEN_SPCL_RT_TP_CD = RT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("                      AND SCG.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("                      AND SCG.ROUT_SEQ = RT.ROUT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.RT_SEQ = RT.RT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.CHG_CD = 'PSC' ) AS PSC_SCG_AMT  " ).append("\n"); 
		query.append("              ,(  SELECT TRF_SCG_AMT" ).append("\n"); 
		query.append("                      FROM PRI_SP_SCP_RT_SCG SCG " ).append("\n"); 
		query.append("                      WHERE SCG.PROP_NO = RT.PROP_NO " ).append("\n"); 
		query.append("                      AND SCG.AMDT_SEQ = RT.AMDT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.SVC_SCP_CD = RT.SVC_SCP_CD " ).append("\n"); 
		query.append("                      AND SCG.GEN_SPCL_RT_TP_CD = RT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("                      AND SCG.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("                      AND SCG.ROUT_SEQ = RT.ROUT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.RT_SEQ = RT.RT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.CHG_CD = 'FRC' ) AS FRC_SCG_AMT " ).append("\n"); 
		query.append("              ,(  SELECT TRF_SCG_AMT" ).append("\n"); 
		query.append("                      FROM PRI_SP_SCP_RT_SCG SCG " ).append("\n"); 
		query.append("                      WHERE SCG.PROP_NO = RT.PROP_NO " ).append("\n"); 
		query.append("                      AND SCG.AMDT_SEQ = RT.AMDT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.SVC_SCP_CD = RT.SVC_SCP_CD " ).append("\n"); 
		query.append("                      AND SCG.GEN_SPCL_RT_TP_CD = RT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("                      AND SCG.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("                      AND SCG.ROUT_SEQ = RT.ROUT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.RT_SEQ = RT.RT_SEQ " ).append("\n"); 
		query.append("                      AND SCG.CHG_CD = 'LSF' ) AS LSF_SCG_AMT " ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_RT RT" ).append("\n"); 
		query.append("              ,(SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1)" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND ((LGCY_IF_FLG = 'N' AND (AMDT_SEQ = @[amdt_seq] OR (AMDT_SEQ = @[amdt_seq] - 1 AND SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM'))))" ).append("\n"); 
		query.append("               OR (LGCY_IF_FLG = 'Y' AND (AMDT_SEQ = @[amdt_seq] AND SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM'))))" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("           AND ROUT_SEQ = @[rout_seq]) A" ).append("\n"); 
		query.append(" WHERE NEXT_N1ST_CMNC_AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("    OR N1ST_CMNC_AMDT_SEQ <> NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(" ORDER BY N1ST_ORD_REF, N2ND_ORD_REF, RT_SEQ, AMDT_SEQ" ).append("\n"); 

	}
}