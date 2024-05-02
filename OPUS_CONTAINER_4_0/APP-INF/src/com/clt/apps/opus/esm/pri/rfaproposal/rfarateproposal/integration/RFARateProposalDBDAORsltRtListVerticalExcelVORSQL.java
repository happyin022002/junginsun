/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RFARateProposalDBDAORsltRtListVerticalExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2011.02.28 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltRtListVerticalExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate 엑셀 조회
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRtListVerticalExcelVORSQL(){
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
		query.append("FileName : RFARateProposalDBDAORsltRtListVerticalExcelVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(B.ROUT_DP_SEQ, 1, A.BLET_DP_SEQ, NULL) AS CMDT_DP_SEQ" ).append("\n"); 
		query.append("      ,A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("      ,A.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("      ,A.CUST_SEQ" ).append("\n"); 
		query.append("      ,A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,B.ROUT_DP_SEQ" ).append("\n"); 
		query.append("      ,B.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,B.ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("      ,B.ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("      ,B.ORG_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("      ,B.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,B.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,B.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,B.DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("      ,B.DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("      ,B.DEST_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("      ,B.RAT_UT_CD" ).append("\n"); 
		query.append("      ,B.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("      ,B.CURR_CD" ).append("\n"); 
		query.append("      ,B.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("      ,0 BUC_USD_AMT" ).append("\n"); 
		query.append("      ,0 IFC_USD_AMT" ).append("\n"); 
		query.append("      ,0 PSC_USD_AMT" ).append("\n"); 
		query.append("  FROM (SELECT R.BLET_DP_SEQ, S.CMDT_ROWKEY, B.PRC_CMDT_DEF_CD, B.PRC_CMDT_DEF_NM, C.CUST_SEQ, C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                       LPAD(ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY NULL), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_CMDT" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                       LPAD(ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY NULL), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_ACT_CUST" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD') S" ).append("\n"); 
		query.append("              ,PRI_RP_SCP_RT_CMDT_HDR R" ).append("\n"); 
		query.append("              ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                      ,DECODE(T.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                             ,'G'" ).append("\n"); 
		query.append("                             ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("                               WHERE PROP_NO = T.PROP_NO" ).append("\n"); 
		query.append("                                 AND AMDT_SEQ = T.AMDT_SEQ" ).append("\n"); 
		query.append("                                 AND SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                 AND PRC_GRP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'R'" ).append("\n"); 
		query.append("                             ,(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("                               WHERE REP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'C'" ).append("\n"); 
		query.append("                             ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                               WHERE CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                      ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                       LPAD(ROW_NUMBER() OVER(PARTITION BY T.PROP_NO" ).append("\n"); 
		query.append("                                ,T.AMDT_SEQ" ).append("\n"); 
		query.append("                                ,T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                ,T.CMDT_HDR_SEQ ORDER BY DECODE(T.PRC_CMDT_TP_CD, 'G', 1, 'R', 2, 'C', 3, 99)" ).append("\n"); 
		query.append("                                ,T.PRC_CMDT_DEF_CD)" ).append("\n"); 
		query.append("                           ,5" ).append("\n"); 
		query.append("                           ,'0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_CMDT T" ).append("\n"); 
		query.append("                 WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND T.SRC_INFO_CD <> 'AD') B" ).append("\n"); 
		query.append("              ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,T.CUST_CNT_CD || LPAD(T.CUST_SEQ, 6, '0') AS CUST_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                         WHERE CUST_CNT_CD = T.CUST_CNT_CD" ).append("\n"); 
		query.append("                           AND CUST_SEQ = T.CUST_SEQ" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROW_NUMBER() OVER(PARTITION BY T.PROP_NO" ).append("\n"); 
		query.append("                                                                       ,T.AMDT_SEQ" ).append("\n"); 
		query.append("                                                                       ,T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                       ,T.CMDT_HDR_SEQ ORDER BY ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                                                                  ,5" ).append("\n"); 
		query.append("                                                                  ,'0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_ACT_CUST T" ).append("\n"); 
		query.append("                 WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND T.SRC_INFO_CD <> 'AD') C" ).append("\n"); 
		query.append("         WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("           AND S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("           AND S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND S.CMDT_HDR_SEQ = R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           AND S.CMDT_ROWKEY = B.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("           AND S.CMDT_ROWKEY = C.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("         ORDER BY S.CMDT_ROWKEY) A" ).append("\n"); 
		query.append("  FULL OUTER JOIN (SELECT R.BLET_DP_SEQ" ).append("\n"); 
		query.append("                         ,LPAD(S.CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                          LPAD(ROW_NUMBER() OVER(PARTITION BY S.CMDT_HDR_SEQ ORDER BY S.ROUT_ROWKEY), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                         ,A.ROUT_DP_SEQ" ).append("\n"); 
		query.append("                         ,B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                         ,B.ROUT_PNT_LOC_DEF_NM AS ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("                         ,B.RCV_DE_TERM_NM AS ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                         ,B.PRC_TRSP_MOD_NM AS ORG_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                         ,C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                         ,D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                         ,E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                         ,E.ROUT_PNT_LOC_DEF_NM AS DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("                         ,E.RCV_DE_TERM_NM AS DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                         ,E.PRC_TRSP_MOD_NM AS DEST_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                         ,F.RAT_UT_CD" ).append("\n"); 
		query.append("                         ,F.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                         ,F.CURR_CD" ).append("\n"); 
		query.append("                         ,F.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("                     FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                              AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                              AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                              AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                              AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT" ).append("\n"); 
		query.append("                            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND SRC_INFO_CD <> 'AD') S" ).append("\n"); 
		query.append("                         ,PRI_RP_SCP_RT_CMDT_HDR R" ).append("\n"); 
		query.append("                         ,(SELECT ROW_NUMBER() OVER(PARTITION BY T.PROP_NO, T.AMDT_SEQ, T.SVC_SCP_CD, T.CMDT_HDR_SEQ ORDER BY T.ROUT_SEQ) AS ROUT_DP_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' || '00001' AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT_CMDT_ROUT T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]) A" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                 ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                        ,'G'" ).append("\n"); 
		query.append("                                        ,(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                           FROM PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append("                                          WHERE PROP_NO = T.PROP_NO" ).append("\n"); 
		query.append("                                            AND AMDT_SEQ = T.AMDT_SEQ" ).append("\n"); 
		query.append("                                            AND SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                            AND PRC_GRP_LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                            AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                        ,'L'" ).append("\n"); 
		query.append("                                        ,(SELECT LOC_NM" ).append("\n"); 
		query.append("                                           FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                          WHERE LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                            AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = T.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.PROP_NO" ).append("\n"); 
		query.append("                                           ,T.AMDT_SEQ" ).append("\n"); 
		query.append("                                           ,T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'G', 1, 'L', 2, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT_ROUT_PNT T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD') B" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.PROP_NO" ).append("\n"); 
		query.append("                                           ,T.AMDT_SEQ" ).append("\n"); 
		query.append("                                           ,T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'G', 1, 'L', 2, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT_ROUT_VIA T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD') C" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.PROP_NO" ).append("\n"); 
		query.append("                                           ,T.AMDT_SEQ" ).append("\n"); 
		query.append("                                           ,T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'G', 1, 'L', 2, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT_ROUT_VIA T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD') D" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                 ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                        ,'G'" ).append("\n"); 
		query.append("                                        ,(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                           FROM PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append("                                          WHERE PROP_NO = T.PROP_NO" ).append("\n"); 
		query.append("                                            AND AMDT_SEQ = T.AMDT_SEQ" ).append("\n"); 
		query.append("                                            AND SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                            AND PRC_GRP_LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                            AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                        ,'L'" ).append("\n"); 
		query.append("                                        ,(SELECT LOC_NM" ).append("\n"); 
		query.append("                                           FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                          WHERE LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                            AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = T.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.PROP_NO" ).append("\n"); 
		query.append("                                           ,T.AMDT_SEQ" ).append("\n"); 
		query.append("                                           ,T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'G', 1, 'L', 2, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT_ROUT_PNT T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD') E" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.RAT_UT_CD" ).append("\n"); 
		query.append("                                 ,T.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                                 ,T.CURR_CD" ).append("\n"); 
		query.append("                                 ,T.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("                                 ,0 BUC_USD_AMT" ).append("\n"); 
		query.append("                                 ,0 IFC_USD_AMT" ).append("\n"); 
		query.append("                                 ,0 PSC_USD_AMT" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.PROP_NO, T.AMDT_SEQ, T.SVC_SCP_CD, T.CMDT_HDR_SEQ, T.ROUT_SEQ" ).append("\n"); 
		query.append("                                                         ORDER BY DECODE(T.PRC_CGO_TP_CD, 'DR', 1, 'RF', 2, 'DG', 3, 'AK', 4, 99), T.RAT_UT_CD, T.CURR_CD)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RP_SCP_RT T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD') F" ).append("\n"); 
		query.append("                    WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("                      AND S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("                      AND S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("                      AND S.CMDT_HDR_SEQ = R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = A.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = B.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = C.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = D.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = E.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = F.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                    ORDER BY S.ROUT_ROWKEY) B ON A.CMDT_ROWKEY = B.CMDT_ROWKEY" ).append("\n"); 
		query.append(" ORDER BY COALESCE(A.BLET_DP_SEQ, B.BLET_DP_SEQ), COALESCE(A.CMDT_ROWKEY, B.CMDT_ROWKEY)" ).append("\n"); 

	}
}