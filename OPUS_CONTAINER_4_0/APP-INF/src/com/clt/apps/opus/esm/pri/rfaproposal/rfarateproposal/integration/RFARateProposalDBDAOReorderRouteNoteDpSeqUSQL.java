/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAOReorderRouteNoteDpSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.02 
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

public class RFARateProposalDBDAOReorderRouteNoteDpSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route정보 수정시 NOTE_DP_SEQ를 재배열한다
	  * </pre>
	  */
	public RFARateProposalDBDAOReorderRouteNoteDpSeqUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOReorderRouteNoteDpSeqUSQL").append("\n"); 
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
		query.append("UPDATE /*+ bypass_ujvc */" ).append("\n"); 
		query.append("       (SELECT A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("              ,T.NEW_NOTE_DP_SEQ" ).append("\n"); 
		query.append("              ,NVL(T.P_CNT, 0) AS P_CNT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("              ,(SELECT A.PROP_NO" ).append("\n"); 
		query.append("                      ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,A.ROUT_SEQ" ).append("\n"); 
		query.append("                      ,NVL(S.SEQ_GAP, 0) + ROW_NUMBER() OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.CMDT_HDR_SEQ ORDER BY F.P_CNT, A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.CMDT_HDR_SEQ, B.SORT_KEY, E.SORT_KEY, C.SORT_KEY, D.SORT_KEY) AS NEW_NOTE_DP_SEQ" ).append("\n"); 
		query.append("                      ,F.P_CNT" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("                      ,(SELECT PROP_NO, (AMDT_SEQ + 1) AS AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, MAX(NOTE_DP_SEQ) AS SEQ_GAP" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_RT_CMDT_ROUT" ).append("\n"); 
		query.append("                          WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                           AND AMDT_SEQ = @[amdt_seq] - 1" ).append("\n"); 
		query.append("                           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ) S" ).append("\n"); 
		query.append("                      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                              ,AMDT_SEQ" ).append("\n"); 
		query.append("                              ,SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,ROUT_SEQ" ).append("\n"); 
		query.append("                              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("                          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                      ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                                  FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} != '0') " ).append("\n"); 
		query.append("                                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("                         START WITH RN = 1" ).append("\n"); 
		query.append("                        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("                         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) B" ).append("\n"); 
		query.append("                      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                              ,AMDT_SEQ" ).append("\n"); 
		query.append("                              ,SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,ROUT_SEQ" ).append("\n"); 
		query.append("                              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("                          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                                      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                                  FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} != '0') " ).append("\n"); 
		query.append("                                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("                         START WITH RN = 1" ).append("\n"); 
		query.append("                        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("                         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) C" ).append("\n"); 
		query.append("                      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                              ,AMDT_SEQ" ).append("\n"); 
		query.append("                              ,SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,ROUT_SEQ" ).append("\n"); 
		query.append("                              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("                          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                                      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                                  FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} != '0') " ).append("\n"); 
		query.append("                                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("                         START WITH RN = 1" ).append("\n"); 
		query.append("                        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("                         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) D" ).append("\n"); 
		query.append("                      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                              ,AMDT_SEQ" ).append("\n"); 
		query.append("                              ,SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,ROUT_SEQ" ).append("\n"); 
		query.append("                              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("                          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                      ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                                  FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} != '0') " ).append("\n"); 
		query.append("                                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("                         START WITH RN = 1" ).append("\n"); 
		query.append("                        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                               AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("                         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) E" ).append("\n"); 
		query.append("                      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                              ,AMDT_SEQ" ).append("\n"); 
		query.append("                              ,SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,ROUT_SEQ" ).append("\n"); 
		query.append("                              ,SUM(CASE WHEN AMDT_SEQ = N1ST_CMNC_AMDT_SEQ AND SRC_INFO_CD <> 'AM' AND SRC_INFO_CD <> 'AD' THEN 0 ELSE 1 END) AS P_CNT" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("                         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} != '0') " ).append("\n"); 
		query.append("                           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ) F" ).append("\n"); 
		query.append("                 WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("                   AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.ROUT_SEQ = B.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("                   AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                   AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.ROUT_SEQ = C.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("                   AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                   AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("                   AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                   AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.PROP_NO = F.PROP_NO" ).append("\n"); 
		query.append("                   AND A.AMDT_SEQ = F.AMDT_SEQ" ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD = F.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                   AND A.ROUT_SEQ = F.ROUT_SEQ" ).append("\n"); 
		query.append("                   AND A.PROP_NO = S.PROP_NO(+)" ).append("\n"); 
		query.append("                   AND A.AMDT_SEQ = S.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD = S.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                   AND A.CMDT_HDR_SEQ = S.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} != '0') " ).append("\n"); 
		query.append("                   AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ) T" ).append("\n"); 
		query.append("         WHERE A.PROP_NO = T.PROP_NO(+)" ).append("\n"); 
		query.append("           AND A.AMDT_SEQ = T.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND A.SVC_SCP_CD = T.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND A.CMDT_HDR_SEQ = T.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("           AND A.ROUT_SEQ = T.ROUT_SEQ(+)" ).append("\n"); 
		query.append("           AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} != '0') " ).append("\n"); 
		query.append("           AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("   SET NOTE_DP_SEQ = DECODE(P_CNT, 0, NEW_NOTE_DP_SEQ, NOTE_DP_SEQ)" ).append("\n"); 

	}
}