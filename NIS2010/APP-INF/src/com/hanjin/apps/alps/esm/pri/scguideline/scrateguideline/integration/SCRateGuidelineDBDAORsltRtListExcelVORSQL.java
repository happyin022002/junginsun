/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateGuidelineDBDAORsltRtListExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateGuidelineDBDAORsltRtListExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate 엑셀 조회
	  * </pre>
	  */
	public SCRateGuidelineDBDAORsltRtListExcelVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration").append("\n"); 
		query.append("FileName : SCRateGuidelineDBDAORsltRtListExcelVORSQL").append("\n"); 
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
		query.append("WITH OT AS (" ).append("\n"); 
		query.append("  SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("        ,GLINE_SEQ" ).append("\n"); 
		query.append("        ,PRC_CUST_TP_CD" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,DECODE(MAX(PRC_CMDT_TP_CD), 'G', 1, 'C', 2, 99) || MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD, '|')) AS CMDT_ORD_KEY" ).append("\n"); 
		query.append("        ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || '00001' AS CMDT_ROWKEY" ).append("\n"); 
		query.append("    FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                ,GLINE_SEQ" ).append("\n"); 
		query.append("                ,PRC_CUST_TP_CD" ).append("\n"); 
		query.append("                ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                ,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                ,ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ ORDER BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', '1', 'C', '2'), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("            FROM PRI_SG_RT_CMDT" ).append("\n"); 
		query.append("           WHERE 1 = 1" ).append("\n"); 
		query.append("             AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("             AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("             AND PRC_CUST_TP_CD = @[prc_cust_tp_cd])" ).append("\n"); 
		query.append("   START WITH RN = 1" ).append("\n"); 
		query.append("  CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("   GROUP BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   ORDER BY CMDT_ORD_KEY" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.CMDT_DP_SEQ" ).append("\n"); 
		query.append("      ,B.ROUT_DP_SEQ" ).append("\n"); 
		query.append("      ,A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("      ,A.PRC_CMDT_DEF_NM" ).append("\n"); 
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
		query.append("      ,B.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append("      ,B.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append("      ,B.RAT_UT_CD" ).append("\n"); 
		query.append("      ,B.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("      ,B.CURR_CD" ).append("\n"); 
		query.append("      ,B.FRT_RT_AMT" ).append("\n"); 
		query.append("  FROM (SELECT S.CMDT_ROWKEY, A.CMDT_DP_SEQ, B.PRC_CMDT_DEF_CD, B.PRC_CMDT_DEF_NM, OT.CMDT_ORD_KEY" ).append("\n"); 
		query.append("          FROM (SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                       LPAD(ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ ORDER BY NULL), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_SG_RT_CMDT" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                   AND PRC_CUST_TP_CD = @[prc_cust_tp_cd]) S" ).append("\n"); 
		query.append("              ,OT" ).append("\n"); 
		query.append("              ,(SELECT CMDT_ROWKEY, ROWNUM AS CMDT_DP_SEQ FROM OT) A" ).append("\n"); 
		query.append("              ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                      ,DECODE(T.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                             ,'G'" ).append("\n"); 
		query.append("                             ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                FROM PRI_SG_GRP_CMDT" ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("                                 AND SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                 AND GLINE_SEQ = T.GLINE_SEQ" ).append("\n"); 
		query.append("                                 AND PRC_CUST_TP_CD = T.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("                                 AND PRC_GRP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'C'" ).append("\n"); 
		query.append("                             ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                               WHERE CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                      ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                       LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.GLINE_SEQ, T.PRC_CUST_TP_CD, T.CMDT_HDR_SEQ ORDER BY DECODE(T.PRC_CMDT_TP_CD, 'G', 1, 'C', 2, 99), T.PRC_CMDT_DEF_CD), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_SG_RT_CMDT T" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                   AND T.PRC_CUST_TP_CD = @[prc_cust_tp_cd]) B" ).append("\n"); 
		query.append("         WHERE S.CMDT_ROWKEY = A.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("           AND S.CMDT_ROWKEY = B.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("           AND S.CMDT_HDR_SEQ = OT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         ORDER BY S.CMDT_ROWKEY) A" ).append("\n"); 
		query.append("  FULL OUTER JOIN (SELECT LPAD(S.CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
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
		query.append("                         ,F.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append("                         ,F.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append("                         ,F.RAT_UT_CD" ).append("\n"); 
		query.append("                         ,F.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                         ,F.CURR_CD" ).append("\n"); 
		query.append("                         ,F.FRT_RT_AMT" ).append("\n"); 
		query.append("                         ,OT.CMDT_ORD_KEY" ).append("\n"); 
		query.append("                     FROM (SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT_ROUT_PNT" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT_ROUT_VIA" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT_ROUT_VIA" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT_ROUT_PNT" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, PRC_CUST_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND PRC_CUST_TP_CD = @[prc_cust_tp_cd]) S" ).append("\n"); 
		query.append("                         ,OT" ).append("\n"); 
		query.append("                         ,(SELECT ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.GLINE_SEQ, T.PRC_CUST_TP_CD, T.CMDT_HDR_SEQ ORDER BY T.ROUT_SEQ) AS ROUT_DP_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' || '00001' AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                                 ,DIR_CALL_FLG" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT_CMDT_ROUT T" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND PRC_CUST_TP_CD = @[prc_cust_tp_cd]) A" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                 ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                        ,'G'" ).append("\n"); 
		query.append("                                        ,(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                           FROM PRI_SG_GRP_LOC" ).append("\n"); 
		query.append("                                          WHERE 1 = 1" ).append("\n"); 
		query.append("                                            AND SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                            AND GLINE_SEQ = T.GLINE_SEQ" ).append("\n"); 
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
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.GLINE_SEQ, T.PRC_CUST_TP_CD, T.CMDT_HDR_SEQ, T.ROUT_SEQ ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'G', 1, 'L', 2, 99), T.ROUT_PNT_LOC_DEF_CD), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT_ROUT_PNT T" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND T.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'O') B" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.GLINE_SEQ, T.PRC_CUST_TP_CD, T.CMDT_HDR_SEQ, T.ROUT_SEQ ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'G', 1, 'L', 2, 99), T.ROUT_VIA_PORT_DEF_CD), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT_ROUT_VIA T" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND T.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'O') C" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.GLINE_SEQ, T.PRC_CUST_TP_CD, T.CMDT_HDR_SEQ, T.ROUT_SEQ ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'G', 1, 'L', 2, 99), T.ROUT_VIA_PORT_DEF_CD), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT_ROUT_VIA T" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND T.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'D') D" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                 ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                        ,'G'" ).append("\n"); 
		query.append("                                        ,(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                           FROM PRI_SG_GRP_LOC" ).append("\n"); 
		query.append("                                          WHERE 1 = 1" ).append("\n"); 
		query.append("                                            AND SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("                                            AND GLINE_SEQ = T.GLINE_SEQ" ).append("\n"); 
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
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.GLINE_SEQ, T.PRC_CUST_TP_CD, T.CMDT_HDR_SEQ, T.ROUT_SEQ ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'G', 1, 'L', 2, 99), T.ROUT_PNT_LOC_DEF_CD), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT_ROUT_PNT T" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND T.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'D') E" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append("                                 ,T.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append("                                 ,T.RAT_UT_CD" ).append("\n"); 
		query.append("                                 ,T.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                                 ,T.CURR_CD" ).append("\n"); 
		query.append("                                 ,T.FRT_RT_AMT" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.GLINE_SEQ, T.PRC_CUST_TP_CD, T.CMDT_HDR_SEQ, T.ROUT_SEQ ORDER BY T.PRC_CGO_TP_CD, T.RAT_UT_CD, T.CURR_CD), 5, '0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_SG_RT T" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("                              AND T.PRC_CUST_TP_CD = @[prc_cust_tp_cd]) F" ).append("\n"); 
		query.append("                    WHERE S.ROUT_ROWKEY = A.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = B.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = C.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = D.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = E.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = F.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.CMDT_HDR_SEQ = OT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    ORDER BY S.ROUT_ROWKEY) B ON A.CMDT_ROWKEY = B.CMDT_ROWKEY" ).append("\n"); 
		query.append(" ORDER BY COALESCE(A.CMDT_ORD_KEY, B.CMDT_ORD_KEY), COALESCE(A.CMDT_ROWKEY, B.CMDT_ROWKEY)" ).append("\n"); 

	}
}