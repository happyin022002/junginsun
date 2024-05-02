/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOChkFontStyleVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.20
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.06.20 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOChkFontStyleVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFARateProposalDBDAORsltPriSurchargeLastAccessDateVORSQL
	  * </pre>
	  */
	public RFARateProposalDBDAOChkFontStyleVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOChkFontStyleVORSQL").append("\n"); 
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
		query.append("WITH G1 AS" ).append("\n"); 
		query.append(" (SELECT 'G' INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT 'A' INTG_CD_VAL_CTNT FROM DUAL)" ).append("\n"); 
		query.append("SELECT INTG_CD_VAL_CTNT," ).append("\n"); 
		query.append("       TOT_CNT," ).append("\n"); 
		query.append("       decode(INTG_CD_VAL_CTNT, 'G', CASE" ).append("\n"); 
		query.append("                 WHEN AMDT_CNT = ACPT_CNT AND AMDT_CNT > 0 THEN" ).append("\n"); 
		query.append("                  'blue'" ).append("\n"); 
		query.append("                 when AMDT_CNT <> ACPT_CNT AND @[amdt_seq] > 0THEN 'red' when TOT_CNT > 0 then" ).append("\n"); 
		query.append("                  'bold'" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                  'nothing'" ).append("\n"); 
		query.append("               end, CASE" ).append("\n"); 
		query.append("                 WHEN AMDT_CNT = ACPT_CNT AND AMDT_CNT > 0 THEN" ).append("\n"); 
		query.append("                  'blue'" ).append("\n"); 
		query.append("                 when AMDT_CNT <> ACPT_CNT AND @[amdt_seq] > 0 THEN" ).append("\n"); 
		query.append("                  'red'" ).append("\n"); 
		query.append("                 when TOT_CNT > 0 then" ).append("\n"); 
		query.append("                  'bold'" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                  'nothing'" ).append("\n"); 
		query.append("               end) FONT_STYLE" ).append("\n"); 
		query.append("  FROM (SELECT G1.INTG_CD_VAL_CTNT," ).append("\n"); 
		query.append("               NVL(C.ACPT_CNT, 0) + NVL(C.NOT_ACPT_CNT, 0) AS RATE_CNT," ).append("\n"); 
		query.append("               NVL(C.AMDT_CNT, 0) AS AMDT_CNT," ).append("\n"); 
		query.append("               NVL(ACPT_CNT, 0) AS ACPT_CNT," ).append("\n"); 
		query.append("               NVL(NOT_ACPT_CNT, 0) AS NOT_ACPT_CNT," ).append("\n"); 
		query.append("               CASE" ).append("\n"); 
		query.append("                 WHEN C.AMDT_CNT > 0 THEN" ).append("\n"); 
		query.append("                  'Y'" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                  'N'" ).append("\n"); 
		query.append("               END AS AMDT_FLG," ).append("\n"); 
		query.append("               DECODE(NOT_ACPT_CNT, 0, 'Y', 'N') AS ACPT_FLG," ).append("\n"); 
		query.append("               (SELECT COUNT(*)" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_CMDT_HDR H" ).append("\n"); 
		query.append("                 WHERE H.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                       AND H.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                       AND H.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                       AND NVL(H.FIC_RT_TP_CD, 'G') = G1.INTG_CD_VAL_CTNT) TOT_CNT" ).append("\n"); 
		query.append("          FROM (SELECT FIC_RT_TP_CD," ).append("\n"); 
		query.append("                       COUNT(N1ST_CMNC_AMDT_SEQ) AS AMDT_CNT," ).append("\n"); 
		query.append("                       SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS ACPT_CNT," ).append("\n"); 
		query.append("                       SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NOT_ACPT_CNT" ).append("\n"); 
		query.append("                  FROM (SELECT B.PROP_NO," ).append("\n"); 
		query.append("                               B.AMDT_SEQ," ).append("\n"); 
		query.append("                               B.SVC_SCP_CD," ).append("\n"); 
		query.append("                               NVL(A.FIC_RT_TP_CD, 'G') FIC_RT_TP_CD," ).append("\n"); 
		query.append("                               B.N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("                               B.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_RT_CMDT_HDR A," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_CMDT     B" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                               AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND B.N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT B.PROP_NO," ).append("\n"); 
		query.append("                               B.AMDT_SEQ," ).append("\n"); 
		query.append("                               B.SVC_SCP_CD," ).append("\n"); 
		query.append("                               NVL(A.FIC_RT_TP_CD, 'G') FIC_RT_TP_CD," ).append("\n"); 
		query.append("                               B.N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("                               B.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_RT_CMDT_HDR A," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_CNOTE    B" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                               AND B.N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT B.PROP_NO," ).append("\n"); 
		query.append("                               B.AMDT_SEQ," ).append("\n"); 
		query.append("                               B.SVC_SCP_CD," ).append("\n"); 
		query.append("                               NVL(A.FIC_RT_TP_CD, 'G') FIC_RT_TP_CD," ).append("\n"); 
		query.append("                               B.N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("                               B.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_RT_CMDT_HDR A," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_ACT_CUST B" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                               AND B.N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT B.PROP_NO," ).append("\n"); 
		query.append("                               B.AMDT_SEQ," ).append("\n"); 
		query.append("                               B.SVC_SCP_CD," ).append("\n"); 
		query.append("                               NVL(A.FIC_RT_TP_CD, 'G') FIC_RT_TP_CD," ).append("\n"); 
		query.append("                               C.N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("                               C.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_RT_CMDT_HDR  A," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_CMDT_ROUT B," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_ROUT_PNT  C" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND B.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                               AND B.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND B.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND B.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("                               AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                               AND C.N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT B.PROP_NO," ).append("\n"); 
		query.append("                               B.AMDT_SEQ," ).append("\n"); 
		query.append("                               B.SVC_SCP_CD," ).append("\n"); 
		query.append("                               NVL(A.FIC_RT_TP_CD, 'G') FIC_RT_TP_CD," ).append("\n"); 
		query.append("                               C.N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("                               C.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_RT_CMDT_HDR  A," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_CMDT_ROUT B," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_ROUT_VIA  C" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND B.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                               AND B.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND B.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND B.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("                               AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                               AND C.N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT B.PROP_NO," ).append("\n"); 
		query.append("                               B.AMDT_SEQ," ).append("\n"); 
		query.append("                               B.SVC_SCP_CD," ).append("\n"); 
		query.append("                               NVL(A.FIC_RT_TP_CD, 'G') FIC_RT_TP_CD," ).append("\n"); 
		query.append("                               C.N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("                               C.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_RT_CMDT_HDR  A," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_CMDT_ROUT B," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT           C" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND B.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                               AND B.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND B.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND B.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("                               AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                               AND C.N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT B.PROP_NO," ).append("\n"); 
		query.append("                               B.AMDT_SEQ," ).append("\n"); 
		query.append("                               B.SVC_SCP_CD," ).append("\n"); 
		query.append("                               NVL(A.FIC_RT_TP_CD, 'G') FIC_RT_TP_CD," ).append("\n"); 
		query.append("                               C.N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("                               C.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_RT_CMDT_HDR   A," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_CMDT_ROUT  B," ).append("\n"); 
		query.append("                               PRI_RP_SCP_RT_CMDT_RNOTE C" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND B.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                               AND B.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                               AND B.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND B.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("                               AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                               AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                               AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                               AND C.N1ST_CMNC_AMDT_SEQ = @[amdt_seq]) G" ).append("\n"); 
		query.append("                 GROUP BY PROP_NO," ).append("\n"); 
		query.append("                          AMDT_SEQ," ).append("\n"); 
		query.append("                          SVC_SCP_CD," ).append("\n"); 
		query.append("                          FIC_RT_TP_CD) C," ).append("\n"); 
		query.append("               G1" ).append("\n"); 
		query.append("         WHERE G1.INTG_CD_VAL_CTNT = C.FIC_RT_TP_CD(+)" ).append("\n"); 
		query.append("         ORDER BY FIC_RT_TP_CD)" ).append("\n"); 

	}
}