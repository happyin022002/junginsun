/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFARateProposalDBDAORsltRtDtlListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltRtDtlListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate - rate조회
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRtDtlListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltRtDtlListVORSQL").append("\n"); 
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
		query.append("      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ,ROUT_SEQ" ).append("\n"); 
		query.append("      ,RT_SEQ" ).append("\n"); 
		query.append("      ,RAT_UT_CD" ).append("\n"); 
		query.append("      ,PRC_CGO_TP_CD" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("      ,PROP_FRT_RT_AMT" ).append("\n"); 
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
		query.append("         WHERE INTG_CD_ID = 'CD02198'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = SRC_INFO_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS SRC_INFO_NM" ).append("\n"); 
		query.append("      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_MN" ).append("\n"); 
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
		query.append("          FROM PRI_RP_SCP_MN M, PRI_RP_SCP_MN N" ).append("\n"); 
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
		query.append("      ,(SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_CGO_SPEC" ).append("\n"); 
		query.append("         WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           AND ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("           AND RT_SEQ = A.RT_SEQ) AS SPEC_CNT" ).append("\n"); 
		query.append("      ,FIRST_VALUE(DECODE(PRC_CGO_TP_CD, 'DR', 1, 'RF', 2, 'DG', 3, 'AK', 4, 99)) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ ORDER BY AMDT_SEQ) AS N1ST_ORD_REF" ).append("\n"); 
		query.append("      ,FIRST_VALUE(RAT_UT_CD) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ ORDER BY AMDT_SEQ) AS N2ND_ORD_REF" ).append("\n"); 
		query.append("      ,FIC_PROP_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_COFFR_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_FNL_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_GLINE_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_GLINE_UPD_DT" ).append("\n"); 
		query.append("      ,OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("      ,FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append("      ,FIC_ORG_PROP_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_ORG_COFFR_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_ORG_FNL_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_ORG_GLINE_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_ORG_GLINE_UPD_DT" ).append("\n"); 
		query.append("      ,ORG_OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("      ,FIC_ORG_RT_USE_STS_CD" ).append("\n"); 
		query.append("      ,FIC_DEST_PROP_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_DEST_COFFR_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_DEST_FNL_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_DEST_GLINE_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_DEST_GLINE_UPD_DT" ).append("\n"); 
		query.append("      ,DEST_OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("      ,FIC_DEST_RT_USE_STS_CD" ).append("\n"); 
		query.append("	  ,MST_RFA_ROUT_ID    --------------RFA 효율화를 위한 요청 (1차) (CHM-201640671)" ).append("\n"); 
		query.append("  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
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
		query.append("              ,LEAD(N1ST_CMNC_AMDT_SEQ) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ ORDER BY AMDT_SEQ) AS NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("              ,ACPT_USR_ID" ).append("\n"); 
		query.append("              ,ACPT_OFC_CD" ).append("\n"); 
		query.append("              ,ACPT_DT" ).append("\n"); 
		query.append("              ,CRE_USR_ID" ).append("\n"); 
		query.append("              ,CRE_DT" ).append("\n"); 
		query.append("              ,UPD_USR_ID" ).append("\n"); 
		query.append("              ,UPD_DT" ).append("\n"); 
		query.append("              ,FIC_PROP_RT_AMT" ).append("\n"); 
		query.append("              ,FIC_COFFR_RT_AMT" ).append("\n"); 
		query.append("              ,FIC_FNL_RT_AMT" ).append("\n"); 
		query.append("              ,FIC_GLINE_RT_AMT" ).append("\n"); 
		query.append("              ,FIC_GLINE_UPD_DT" ).append("\n"); 
		query.append("              ,OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("              ,FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append("      	      ,FIC_ORG_PROP_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_ORG_COFFR_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_ORG_FNL_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_ORG_GLINE_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_ORG_GLINE_UPD_DT" ).append("\n"); 
		query.append("      ,ORG_OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("      ,FIC_ORG_RT_USE_STS_CD" ).append("\n"); 
		query.append("      ,FIC_DEST_PROP_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_DEST_COFFR_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_DEST_FNL_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_DEST_GLINE_RT_AMT" ).append("\n"); 
		query.append("      ,FIC_DEST_GLINE_UPD_DT" ).append("\n"); 
		query.append("      ,DEST_OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("      ,FIC_DEST_RT_USE_STS_CD" ).append("\n"); 
		query.append("      ,MST_RFA_ROUT_ID    --------------RFA 효율화를 위한 요청 (1차) (CHM-201640671)" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND (AMDT_SEQ = @[amdt_seq] OR" ).append("\n"); 
		query.append("               (AMDT_SEQ = @[amdt_seq] - 1 AND" ).append("\n"); 
		query.append("               SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if(${cmdt_hdr_seq} != 'null')" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND ROUT_SEQ = @[rout_seq]) A" ).append("\n"); 
		query.append(" WHERE NEXT_N1ST_CMNC_AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("    OR N1ST_CMNC_AMDT_SEQ <> NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(" ORDER BY N1ST_ORD_REF, N2ND_ORD_REF, RT_SEQ, AMDT_SEQ" ).append("\n"); 

	}
}