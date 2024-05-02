/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCRateProposalDBDAORsltRateTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.05.04 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltRateTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate - Customer Type 재조회
	  * </pre>
	  */
	public SCRateProposalDBDAORsltRateTpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_cmnc_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltRateTpRSQL").append("\n"); 
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
		query.append("SELECT A.INTG_CD_VAL_CTNT AS CD" ).append("\n"); 
		query.append("      ,A.INTG_CD_VAL_DP_DESC NM" ).append("\n"); 
		query.append("      ,NVL(C.ACPT_CNT, 0) + NVL(C.NOT_ACPT_CNT, 0) AS RATE_CNT" ).append("\n"); 
		query.append("      ,NVL(C.AMDT_CNT, 0) AS AMDT_CNT" ).append("\n"); 
		query.append("      ,NVL(ACPT_CNT, 0) AS ACPT_CNT" ).append("\n"); 
		query.append("      ,NVL(NOT_ACPT_CNT, 0) AS NOT_ACPT_CNT" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("         WHEN C.AMDT_CNT > 0 THEN" ).append("\n"); 
		query.append("          'Y'" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("          'N'" ).append("\n"); 
		query.append("       END AS AMDT_FLG" ).append("\n"); 
		query.append("      ,DECODE(NOT_ACPT_CNT, 0, 'Y', 'N') AS ACPT_FLG" ).append("\n"); 
		query.append("  FROM NISADM.COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("      ,(SELECT GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,SUM(DECODE(N1ST_CMNC_AMDT_SEQ, @[n1st_cmnc_amdt_seq], 1, 0)) AS AMDT_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS ACPT_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NOT_ACPT_CNT" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CMDT" ).append("\n"); 
		query.append("                      ,(SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1) M" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(M.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ACT_CUST" ).append("\n"); 
		query.append("                      ,(SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1) M" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(M.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                      ,(SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1) M" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(M.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                      ,(SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1) M" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(M.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                      ,(SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1) M" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(M.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_DIR" ).append("\n"); 
		query.append("                      ,(SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1) M" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(M.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("                      ,(SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1) M" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(M.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, N1ST_CMNC_AMDT_SEQ, PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("                      ,(SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1) M" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(M.LGCY_IF_FLG, 'Y', 'AD', 'X'))" ).append("\n"); 
		query.append("         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD) C" ).append("\n"); 
		query.append(" WHERE A.INTG_CD_VAL_CTNT = C.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("   AND A.INTG_CD_ID = 'CD01705' AND A.INTG_CD_VAL_CTNT IN ('G','S') " ).append("\n"); 
		query.append(" ORDER BY A.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}