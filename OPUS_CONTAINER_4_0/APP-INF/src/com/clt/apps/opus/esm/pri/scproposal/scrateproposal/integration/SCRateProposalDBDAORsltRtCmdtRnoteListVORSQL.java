/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCRateProposalDBDAORsltRtCmdtRnoteListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltRtCmdtRnoteListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rnote조회
	  * </pre>
	  */
	public SCRateProposalDBDAORsltRtCmdtRnoteListVORSQL(){
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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltRtCmdtRnoteListVORSQL").append("\n"); 
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
		query.append("      ,ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("      ,NOTE_CLSS_CD" ).append("\n"); 
		query.append("      ,CHG_CD" ).append("\n"); 
		query.append("      ,NOTE_CTNT" ).append("\n"); 
		query.append("      ,DECODE((SELECT NOTE_CONV_SEQ" ).append("\n"); 
		query.append("                FROM PRI_SC_NOTE_CONV" ).append("\n"); 
		query.append("               WHERE NOTE_CONV_MAPG_ID = A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("             ,NULL" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,1) AS NOTE_CONV_MAPG_ID_CHK" ).append("\n"); 
		query.append("      ,NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("      ,NVL(PREV_NOTE_CONV_MAPG_ID, NOTE_CONV_MAPG_ID) AS PREV_NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("      ,NOTE_CHG_TP_CD" ).append("\n"); 
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
		query.append("  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("              ,NOTE_CLSS_CD" ).append("\n"); 
		query.append("              ,CHG_CD" ).append("\n"); 
		query.append("              ,NOTE_CTNT" ).append("\n"); 
		query.append("              ,NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("              ,NOTE_CHG_TP_CD" ).append("\n"); 
		query.append("              ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("              ,SRC_INFO_CD" ).append("\n"); 
		query.append("              ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("              ,LEAD(N1ST_CMNC_AMDT_SEQ) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_NOTE_SEQ ORDER BY AMDT_SEQ) AS NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("              ,LAG(NOTE_CONV_MAPG_ID) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_NOTE_SEQ ORDER BY AMDT_SEQ) AS PREV_NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("              ,ACPT_USR_ID" ).append("\n"); 
		query.append("              ,ACPT_OFC_CD" ).append("\n"); 
		query.append("              ,ACPT_DT" ).append("\n"); 
		query.append("              ,CRE_USR_ID" ).append("\n"); 
		query.append("              ,CRE_DT" ).append("\n"); 
		query.append("              ,UPD_USR_ID" ).append("\n"); 
		query.append("              ,UPD_DT" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND (  (AMDT_SEQ = @[amdt_seq] OR (AMDT_SEQ = @[amdt_seq] - 1 AND SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("               OR (AMDT_SEQ = @[amdt_seq] AND SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM'))" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("           AND ROUT_SEQ = @[rout_seq]) A" ).append("\n"); 
		query.append(" WHERE NEXT_N1ST_CMNC_AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("    OR N1ST_CMNC_AMDT_SEQ <> NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(" ORDER BY CMDT_HDR_SEQ, ROUT_NOTE_SEQ, AMDT_SEQ" ).append("\n"); 

	}
}