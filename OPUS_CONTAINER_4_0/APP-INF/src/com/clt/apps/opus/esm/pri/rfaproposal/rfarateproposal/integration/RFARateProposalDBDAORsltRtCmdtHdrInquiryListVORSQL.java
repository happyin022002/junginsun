/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Commodity 조회
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL").append("\n"); 
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
		query.append("      ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ,B.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("      ,REPLACE(C.CUST_LGL_ENG_NM, '^|^', ' / ') AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,REPLACE(D.NOTE_CTNT, '^|^', CHR(13)) AS NOTE_CTNT" ).append("\n"); 
		query.append("      ,REPLACE(D.NOTE_CTNT, '^|^', CHR(13) || CHR(13)) AS NOTE_CTNT_TOOLTIP" ).append("\n"); 
		query.append("      ,A.BLET_DP_SEQ" ).append("\n"); 
		query.append("      ,A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_CMDT_HDR A" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, ' / ')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                             ,'G'" ).append("\n"); 
		query.append("                             ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("                               WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                 AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                                 AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                 AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'R'" ).append("\n"); 
		query.append("                             ,(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("                               WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'C'" ).append("\n"); 
		query.append("                             ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                               WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', 1, 'R', 2, 'C', 3, 99), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ) B" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_LGL_ENG_NM, '^|^')), 4) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                         WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                           AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ) C" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOTE_CTNT, '^|^')), 4) AS NOTE_CTNT" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,NOTE_CTNT" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, CMDT_NOTE_SEQ) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ) D" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append(" ORDER BY A.BLET_DP_SEQ" ).append("\n"); 

	}
}