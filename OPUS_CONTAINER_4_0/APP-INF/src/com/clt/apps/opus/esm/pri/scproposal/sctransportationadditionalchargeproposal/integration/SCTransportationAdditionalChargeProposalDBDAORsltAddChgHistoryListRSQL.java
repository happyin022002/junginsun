/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAORsltAddChgHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAORsltAddChgHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Arbitrary Amend History List 조회
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAORsltAddChgHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAORsltAddChgHistoryListRSQL").append("\n"); 
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
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.ADD_CHG_TP_CD" ).append("\n"); 
		query.append("     , A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , A.ADD_CHG_SEQ" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , (SELECT LOC_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION " ).append("\n"); 
		query.append("         WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("     , A.LOC_GRD_CNT_CD" ).append("\n"); 
		query.append("     , A.LOC_GRD_CD" ).append("\n"); 
		query.append("     , A.BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.VIA_PORT_TP_CD" ).append("\n"); 
		query.append("     , A.VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("     , DECODE(A.DIR_CALL_FLG, 'Y', '1', '0') AS DIR_CALL_FLG" ).append("\n"); 
		query.append("     , A.RAT_UT_CD" ).append("\n"); 
		query.append("     , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("     , PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("     , DECODE(A.GRI_APPL_TP_CD, 'N', '', A.GRI_APPL_TP_CD) AS GRI_APPL_TP_CD" ).append("\n"); 
		query.append("     , DECODE(A.GRI_APPL_AMT, 0, NULL, A.GRI_APPL_AMT) AS GRI_APPL_AMT" ).append("\n"); 
		query.append("     , A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , A.SRC_INFO_CD" ).append("\n"); 
		query.append("     , A.ACPT_USR_ID" ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID)||' / '||A.ACPT_OFC_CD ACPT_USR_NM" ).append("\n"); 
		query.append("     , A.ACPT_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.ACPT_DT, 'YYYYMMDD') ACPT_DT" ).append("\n"); 
		query.append("     , A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_SP_SCP_MN WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("             AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ AND SVC_SCP_CD = A.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("     , CASE WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(B.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("     		ELSE (SELECT CASE WHEN A.AMDT_SEQ <= N.AMDT_SEQ THEN TO_CHAR(B.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                         END AS EXP_DT" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("                   WHERE PROP_NO = B.PROP_NO AND AMDT_SEQ = B.AMDT_SEQ-1 AND SVC_SCP_CD = B.SVC_SCP_CD)    " ).append("\n"); 
		query.append("       END EXP_DT" ).append("\n"); 
		query.append("     , A.ADD_CHG_NOTE_CTNT" ).append("\n"); 
		query.append("     , A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("     , A.MIN_CGO_WGT" ).append("\n"); 
		query.append("     , A.MAX_CGO_WGT" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_TRSP_ADD_CHG A" ).append("\n"); 
		query.append("     , PRI_SP_SCP_MN B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ IN (@[amdt_seq],@[amdt_seq]-1)  " ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND ((A.AMDT_SEQ = @[amdt_seq] AND A.N1ST_CMNC_AMDT_SEQ =  @[amdt_seq]" ).append("\n"); 
		query.append("		AND A.SRC_INFO_CD <> 'ZZ')" ).append("\n"); 
		query.append("	OR (A.AMDT_SEQ = @[amdt_seq]-1 " ).append("\n"); 
		query.append("		AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("		AND NOT EXISTS(SELECT 'X' FROM PRI_SP_SCP_TRSP_ADD_CHG C" ).append("\n"); 
		query.append("                        WHERE C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                          AND C.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                          AND C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("						  AND C.ADD_CHG_TP_CD = A.ADD_CHG_TP_CD" ).append("\n"); 
		query.append("                          AND C.ORG_DEST_TP_CD = A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                          AND C.ADD_CHG_SEQ = A.ADD_CHG_SEQ" ).append("\n"); 
		query.append("                          AND C.N1ST_CMNC_AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ)" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("ORDER BY LAST_VALUE(A.ROUT_PNT_LOC_DEF_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST " ).append("\n"); 
		query.append("     , LAST_VALUE(A.BSE_PORT_DEF_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("     , LAST_VALUE(A.DIR_CALL_FLG) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) DESC" ).append("\n"); 
		query.append("     , LAST_VALUE(A.VIA_PORT_DEF_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("     , LAST_VALUE(A.PRC_TRSP_MOD_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("     , LAST_VALUE(A.RCV_DE_TERM_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("     , LAST_VALUE(A.PRC_CGO_TP_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("     , LAST_VALUE(A.RAT_UT_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("     , LAST_VALUE(A.CURR_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("     , A.ADD_CHG_SEQ, A.AMDT_SEQ" ).append("\n"); 

	}
}