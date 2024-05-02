/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SCRateProposalDBDAORsltRtListHorizontalExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltRtListHorizontalExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Excel - Horizontal
	  * 2013.03.11 전윤주 [CHM-201323464] FRC Surcgarge 추가
	  * </pre>
	  */
	public SCRateProposalDBDAORsltRtListHorizontalExcelVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltRtListHorizontalExcelVORSQL").append("\n"); 
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
		query.append("      ,B.DIR_CALL_FLG" ).append("\n"); 
		query.append("      ,B.RATE_DRY20" ).append("\n"); 
		query.append("      ,B.RATE_DRY40" ).append("\n"); 
		query.append("      ,B.RATE_DRY40HC" ).append("\n"); 
		query.append("      ,B.RATE_DRY45" ).append("\n"); 
		query.append("      ,B.RATE_RF40HC" ).append("\n"); 
		query.append("      ,B.RATE_RD40HC" ).append("\n"); 
		query.append("      ,B.BUC_DRY20" ).append("\n"); 
		query.append("      ,B.BUC_DRY40" ).append("\n"); 
		query.append("      ,B.BUC_DRY40HC" ).append("\n"); 
		query.append("      ,B.BUC_DRY45" ).append("\n"); 
		query.append("      ,B.BUC_RF40HC" ).append("\n"); 
		query.append("      ,B.BUC_RD40HC" ).append("\n"); 
		query.append("      ,B.IFC_DRY20" ).append("\n"); 
		query.append("      ,B.IFC_DRY40" ).append("\n"); 
		query.append("      ,B.IFC_DRY40HC" ).append("\n"); 
		query.append("      ,B.IFC_DRY45" ).append("\n"); 
		query.append("      ,B.IFC_RF40HC" ).append("\n"); 
		query.append("      ,B.IFC_RD40HC" ).append("\n"); 
		query.append("      ,B.PSC_DRY20" ).append("\n"); 
		query.append("      ,B.PSC_DRY40" ).append("\n"); 
		query.append("      ,B.PSC_DRY40HC" ).append("\n"); 
		query.append("      ,B.PSC_DRY45" ).append("\n"); 
		query.append("      ,B.PSC_RF40HC" ).append("\n"); 
		query.append("      ,B.PSC_RD40HC" ).append("\n"); 
		query.append("      ,B.FRC_DRY20" ).append("\n"); 
		query.append("      ,B.FRC_DRY40" ).append("\n"); 
		query.append("      ,B.FRC_DRY40HC" ).append("\n"); 
		query.append("      ,B.FRC_DRY45" ).append("\n"); 
		query.append("      ,B.FRC_RF40HC" ).append("\n"); 
		query.append("      ,B.FRC_RD40HC" ).append("\n"); 
		query.append("  FROM (SELECT R.BLET_DP_SEQ, S.CMDT_ROWKEY, B.PRC_CMDT_DEF_CD, B.PRC_CMDT_DEF_NM, C.CUST_SEQ, C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                       LPAD(ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY NULL), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CMDT" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                       LPAD(ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY NULL), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ACT_CUST" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD') S" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_RT_CMDT_HDR R" ).append("\n"); 
		query.append("              ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                      ,DECODE(T.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                             ,'G'" ).append("\n"); 
		query.append("                             ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                FROM PRI_SP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("                               WHERE PROP_NO = T.PROP_NO" ).append("\n"); 
		query.append("                                 AND AMDT_SEQ = T.AMDT_SEQ" ).append("\n"); 
		query.append("                                 AND SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                 AND PRC_GRP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
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
		query.append("                                ,T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                ,T.CMDT_HDR_SEQ ORDER BY DECODE(T.PRC_CMDT_TP_CD, 'G', 1, 'C', 2, 99)" ).append("\n"); 
		query.append("                                ,T.PRC_CMDT_DEF_CD)" ).append("\n"); 
		query.append("                           ,5" ).append("\n"); 
		query.append("                           ,'0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CMDT T" ).append("\n"); 
		query.append("                 WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
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
		query.append("                                                                       ,T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                                                       ,T.CMDT_HDR_SEQ ORDER BY ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                                                                  ,5" ).append("\n"); 
		query.append("                                                                  ,'0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ACT_CUST T" ).append("\n"); 
		query.append("                 WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND T.SRC_INFO_CD <> 'AD') C" ).append("\n"); 
		query.append("         WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("           AND S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("           AND S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND S.GEN_SPCL_RT_TP_CD = R.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("           AND S.CMDT_HDR_SEQ = R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           AND S.CMDT_ROWKEY = B.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("           AND S.CMDT_ROWKEY = C.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("           AND EXISTS(SELECT 'OK'" ).append("\n"); 
		query.append("                        FROM PRI_SP_SCP_RT Q" ).append("\n"); 
		query.append("                       WHERE Q.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("                         AND Q.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("                         AND Q.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("                         AND Q.GEN_SPCL_RT_TP_CD = R.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                         AND Q.CMDT_HDR_SEQ = R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                         AND ((Q.PRC_CGO_TP_CD = 'DR' AND" ).append("\n"); 
		query.append("                             Q.RAT_UT_CD IN ('D2', 'D4', 'D5', 'D7', 'R5', '20', '40', '45')) OR" ).append("\n"); 
		query.append("                             (Q.PRC_CGO_TP_CD = 'RF' AND Q.RAT_UT_CD IN ('R5', '40')))" ).append("\n"); 
		query.append("                       GROUP BY Q.PROP_NO, Q.AMDT_SEQ, Q.SVC_SCP_CD, Q.CMDT_HDR_SEQ)" ).append("\n"); 
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
		query.append("                         ,A.DIR_CALL_FLG" ).append("\n"); 
		query.append("                         ,F.RATE_DRY20" ).append("\n"); 
		query.append("                         ,F.RATE_DRY40" ).append("\n"); 
		query.append("                         ,F.RATE_DRY40HC" ).append("\n"); 
		query.append("                         ,F.RATE_DRY45" ).append("\n"); 
		query.append("                         ,F.RATE_RF40HC" ).append("\n"); 
		query.append("                         ,F.RATE_RD40HC" ).append("\n"); 
		query.append("                         ,G.BUC_DRY20" ).append("\n"); 
		query.append("                         ,G.BUC_DRY40" ).append("\n"); 
		query.append("                         ,G.BUC_DRY40HC" ).append("\n"); 
		query.append("                         ,G.BUC_DRY45" ).append("\n"); 
		query.append("                         ,G.BUC_RF40HC" ).append("\n"); 
		query.append("                         ,G.BUC_RD40HC" ).append("\n"); 
		query.append("                         ,G.IFC_DRY20" ).append("\n"); 
		query.append("                         ,G.IFC_DRY40" ).append("\n"); 
		query.append("                         ,G.IFC_DRY40HC" ).append("\n"); 
		query.append("                         ,G.IFC_DRY45" ).append("\n"); 
		query.append("                         ,G.IFC_RF40HC" ).append("\n"); 
		query.append("                         ,G.IFC_RD40HC" ).append("\n"); 
		query.append("                         ,G.PSC_DRY20" ).append("\n"); 
		query.append("                         ,G.PSC_DRY40" ).append("\n"); 
		query.append("                         ,G.PSC_DRY40HC" ).append("\n"); 
		query.append("                         ,G.PSC_DRY45" ).append("\n"); 
		query.append("                         ,G.PSC_RF40HC" ).append("\n"); 
		query.append("                         ,G.PSC_RD40HC" ).append("\n"); 
		query.append("                         ,G.FRC_DRY20" ).append("\n"); 
		query.append("                         ,G.FRC_DRY40" ).append("\n"); 
		query.append("                         ,G.FRC_DRY40HC" ).append("\n"); 
		query.append("                         ,G.FRC_DRY45" ).append("\n"); 
		query.append("                         ,G.FRC_RF40HC" ).append("\n"); 
		query.append("                         ,G.FRC_RD40HC" ).append("\n"); 
		query.append("                     FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                              AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                              AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                              AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                              AND SRC_INFO_CD <> 'AD') S" ).append("\n"); 
		query.append("                         ,PRI_SP_SCP_RT_CMDT_HDR R" ).append("\n"); 
		query.append("                         ,(SELECT S.DIR_CALL_FLG" ).append("\n"); 
		query.append("                                 ,ROW_NUMBER() OVER(PARTITION BY T.PROP_NO, T.AMDT_SEQ, T.SVC_SCP_CD, T.GEN_SPCL_RT_TP_CD, T.CMDT_HDR_SEQ ORDER BY T.ROUT_SEQ) AS ROUT_DP_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' || '00001' AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT_CMDT_ROUT T, PRI_SP_SCP_RT_ROUT_DIR S" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = S.PROP_NO(+)" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = S.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = S.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                              AND T.GEN_SPCL_RT_TP_CD = S.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("                              AND T.CMDT_HDR_SEQ = S.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                              AND T.ROUT_SEQ = S.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                              AND T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]) A" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                 ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                        ,'G'" ).append("\n"); 
		query.append("                                        ,(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                           FROM PRI_SP_SCP_GRP_LOC" ).append("\n"); 
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
		query.append("                                           ,T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'G', 1, 'L', 2, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT_ROUT_PNT T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD') B" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.PROP_NO" ).append("\n"); 
		query.append("                                           ,T.AMDT_SEQ" ).append("\n"); 
		query.append("                                           ,T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                           ,T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'G', 1, 'L', 2, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT_ROUT_VIA T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD') C" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.PROP_NO" ).append("\n"); 
		query.append("                                           ,T.AMDT_SEQ" ).append("\n"); 
		query.append("                                           ,T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                           ,T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'G', 1, 'L', 2, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT_ROUT_VIA T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD') D" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                 ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                        ,'G'" ).append("\n"); 
		query.append("                                        ,(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                           FROM PRI_SP_SCP_GRP_LOC" ).append("\n"); 
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
		query.append("                                           ,T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'G', 1, 'L', 2, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT_ROUT_PNT T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD') E" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D2' OR T.RAT_UT_CD = '20') AND T.PRC_CGO_TP_CD = 'DR' THEN T.PROP_FRT_RT_AMT END) AS RATE_DRY20" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D4' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'DR' THEN T.PROP_FRT_RT_AMT END) AS RATE_DRY40" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'D5' AND T.PRC_CGO_TP_CD = 'DR' THEN T.PROP_FRT_RT_AMT END) AS RATE_DRY40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D7' OR T.RAT_UT_CD = '45') AND T.PRC_CGO_TP_CD = 'DR' THEN T.PROP_FRT_RT_AMT END) AS RATE_DRY45" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'R5' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'RF' THEN T.PROP_FRT_RT_AMT END) AS RATE_RF40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'R5' AND T.PRC_CGO_TP_CD = 'DR' THEN T.PROP_FRT_RT_AMT END) AS RATE_RD40HC" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' || '00001' AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT T" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           GROUP BY T.PROP_NO, T.AMDT_SEQ, T.SVC_SCP_CD, T.GEN_SPCL_RT_TP_CD, T.CMDT_HDR_SEQ, T.ROUT_SEQ) F" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D2' OR T.RAT_UT_CD = '20') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'BUC' THEN G.ADJ_SCG_USD_AMT END) AS BUC_DRY20" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D4' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'BUC' THEN G.ADJ_SCG_USD_AMT END) AS BUC_DRY40" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'D5' AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'BUC' THEN G.ADJ_SCG_USD_AMT END) AS BUC_DRY40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D7' OR T.RAT_UT_CD = '45') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'BUC' THEN G.ADJ_SCG_USD_AMT END) AS BUC_DRY45" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'R5' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'RF' AND G.CHG_CD = 'BUC' THEN G.ADJ_SCG_USD_AMT END) AS BUC_RF40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'R5' AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'BUC' THEN G.ADJ_SCG_USD_AMT END) AS BUC_RD40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D2' OR T.RAT_UT_CD = '20') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'IFC' THEN G.ADJ_SCG_USD_AMT END) AS IFC_DRY20" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D4' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'IFC' THEN G.ADJ_SCG_USD_AMT END) AS IFC_DRY40" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'D5' AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'IFC' THEN G.ADJ_SCG_USD_AMT END) AS IFC_DRY40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D7' OR T.RAT_UT_CD = '45') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'IFC' THEN G.ADJ_SCG_USD_AMT END) AS IFC_DRY45" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'R5' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'RF' AND G.CHG_CD = 'IFC' THEN G.ADJ_SCG_USD_AMT END) AS IFC_RF40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'R5' AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'IFC' THEN G.ADJ_SCG_USD_AMT END) AS IFC_RD40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D2' OR T.RAT_UT_CD = '20') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'PSC' THEN G.ADJ_SCG_USD_AMT END) AS PSC_DRY20" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D4' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'PSC' THEN G.ADJ_SCG_USD_AMT END) AS PSC_DRY40" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'D5' AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'PSC' THEN G.ADJ_SCG_USD_AMT END) AS PSC_DRY40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D7' OR T.RAT_UT_CD = '45') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'PSC' THEN G.ADJ_SCG_USD_AMT END) AS PSC_DRY45" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'R5' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'RF' AND G.CHG_CD = 'PSC' THEN G.ADJ_SCG_USD_AMT END) AS PSC_RF40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'R5' AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'PSC' THEN G.ADJ_SCG_USD_AMT END) AS PSC_RD40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D2' OR T.RAT_UT_CD = '20') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'FRC' THEN G.ADJ_SCG_USD_AMT END) AS FRC_DRY20" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D4' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'FRC' THEN G.ADJ_SCG_USD_AMT END) AS FRC_DRY40" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'D5' AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'FRC' THEN G.ADJ_SCG_USD_AMT END) AS FRC_DRY40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D7' OR T.RAT_UT_CD = '45') AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'FRC' THEN G.ADJ_SCG_USD_AMT END) AS FRC_DRY45" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'R5' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'RF' AND G.CHG_CD = 'FRC' THEN G.ADJ_SCG_USD_AMT END) AS FRC_RF40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'R5' AND T.PRC_CGO_TP_CD = 'DR' AND G.CHG_CD = 'FRC' THEN G.ADJ_SCG_USD_AMT END) AS FRC_RD40HC" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' || '00001' AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SP_SCP_RT T, PRI_SP_SCP_RT_SCG G" ).append("\n"); 
		query.append("                            WHERE T.PROP_NO = G.PROP_NO(+)" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = G.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                              AND T.GEN_SPCL_RT_TP_CD = G.GEN_SPCL_RT_TP_CD(+) " ).append("\n"); 
		query.append("                              AND T.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                              AND T.ROUT_SEQ = G.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                              AND T.RT_SEQ = G.RT_SEQ(+)" ).append("\n"); 
		query.append("                              AND T.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                              AND T.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                              AND T.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           GROUP BY T.PROP_NO, T.AMDT_SEQ, T.SVC_SCP_CD, T.GEN_SPCL_RT_TP_CD, T.CMDT_HDR_SEQ, T.ROUT_SEQ) G" ).append("\n"); 
		query.append("                    WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("                      AND S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("                      AND S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("                      AND S.GEN_SPCL_RT_TP_CD = R.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      AND S.CMDT_HDR_SEQ = R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = A.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = B.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = C.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = D.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = E.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = F.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = G.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND (A.ROUT_DP_SEQ IS NULL OR" ).append("\n"); 
		query.append("                          COALESCE(F.RATE_DRY20, F.RATE_DRY40, F.RATE_DRY40HC, F.RATE_DRY45, F.RATE_RF40HC, F.RATE_RD40HC) IS NOT NULL)" ).append("\n"); 
		query.append("                    ORDER BY S.ROUT_ROWKEY) B ON A.CMDT_ROWKEY = B.CMDT_ROWKEY" ).append("\n"); 
		query.append(" ORDER BY COALESCE(A.BLET_DP_SEQ, B.BLET_DP_SEQ), COALESCE(A.CMDT_ROWKEY, B.CMDT_ROWKEY)" ).append("\n"); 

	}
}