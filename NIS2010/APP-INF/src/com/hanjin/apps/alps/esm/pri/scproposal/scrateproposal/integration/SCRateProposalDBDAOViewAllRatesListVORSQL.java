/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCRateProposalDBDAOViewAllRatesListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.18
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.01.18 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOViewAllRatesListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * View All Rates
	  * </pre>
	  */
	public SCRateProposalDBDAOViewAllRatesListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOViewAllRatesListVORSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               A.PROP_NO" ).append("\n"); 
		query.append("              ,A.AMDT_SEQ" ).append("\n"); 
		query.append("              ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,REPLACE(B.PRC_CMDT_DEF_NM, '|||', ' / ' || CHR(13))           AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("              ,NVL(REPLACE(C.CUST_LGL_ENG_NM, '|||', ' / ' || CHR(13)), ' ') AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              ,E.ROUT_SEQ              " ).append("\n"); 
		query.append("              ,REPLACE(F.ROUT_PNT_LOC_DEF_CD, '|||', CHR(13))   AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("              ,REPLACE(F.ROUT_PNT_LOC_CNT_CD, '|||', CHR(13))   AS ORG_ROUT_PNT_LOC_CNT_CD" ).append("\n"); 
		query.append("              ,REPLACE(F.ROUT_PNT_LOC_STE_CD, '|||', CHR(13))   AS ORG_ROUT_PNT_LOC_STE_CD" ).append("\n"); 
		query.append("              ,REPLACE(G.ROUT_VIA_PORT_DEF_CD, '|||', CHR(13))  AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,REPLACE(H.ROUT_VIA_PORT_DEF_CD, '|||', CHR(13))  AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,REPLACE(I.ROUT_PNT_LOC_DEF_CD, '|||', CHR(13))   AS DEST_ROUT_PNT_LOC_DEF_CD  " ).append("\n"); 
		query.append("              ,REPLACE(I.ROUT_PNT_LOC_CNT_CD, '|||', CHR(13))   AS DEST_ROUT_PNT_LOC_CNT_CD               " ).append("\n"); 
		query.append("              ,REPLACE(I.ROUT_PNT_LOC_STE_CD, '|||', CHR(13))   AS DEST_ROUT_PNT_LOC_STE_CD" ).append("\n"); 
		query.append("              ,K.RT_SEQ             " ).append("\n"); 
		query.append("              ,K.RAT_UT_CD          " ).append("\n"); 
		query.append("              ,K.PRC_CGO_TP_CD     " ).append("\n"); 
		query.append("              ,K.CURR_CD             " ).append("\n"); 
		query.append("              ,TRIM(TO_CHAR(DECODE(NVL(K.FNL_FRT_RT_AMT,0),0,K.PROP_FRT_RT_AMT,K.FNL_FRT_RT_AMT), '999,999,999,999,999.00')) AS PROP_FRT_RT_AMT        " ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_RT_CMDT_HDR A" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("                SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,PRC_CMDT_DEF_NM_A||DECODE(PRC_CMDT_DEF_NM_B,'','','|||')||PRC_CMDT_DEF_NM_B PRC_CMDT_DEF_NM        " ).append("\n"); 
		query.append("                FROM (      " ).append("\n"); 
		query.append("                        SELECT PROP_NO" ).append("\n"); 
		query.append("                              ,AMDT_SEQ" ).append("\n"); 
		query.append("                              ,SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,MAX(CASE WHEN PART_SEQ = 'A' THEN PRC_CMDT_DEF_NM ELSE NULL END) AS PRC_CMDT_DEF_NM_A" ).append("\n"); 
		query.append("                              ,MAX(CASE WHEN PART_SEQ = 'B' THEN PRC_CMDT_DEF_NM ELSE NULL END) AS PRC_CMDT_DEF_NM_B" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                                SELECT PROP_NO" ).append("\n"); 
		query.append("                                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                      ,PART_SEQ" ).append("\n"); 
		query.append("                                      ,SUBSTR(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM || SRC_INFO_CD, '|||'), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                      SELECT PROP_NO " ).append("\n"); 
		query.append("                                            ,AMDT_SEQ" ).append("\n"); 
		query.append("                                            ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                            ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                            ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                            ,PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                                            ,SRC_INFO_CD" ).append("\n"); 
		query.append("                                           ,CASE WHEN RN <= 100 THEN 'A'" ).append("\n"); 
		query.append("                                                WHEN RN <= 200 THEN 'B'" ).append("\n"); 
		query.append("                                           ELSE 'C'" ).append("\n"); 
		query.append("                                           END AS PART_SEQ" ).append("\n"); 
		query.append("                                           ,CASE WHEN RN <= 100 THEN RN" ).append("\n"); 
		query.append("                                                WHEN RN <= 200 THEN RN - 100" ).append("\n"); 
		query.append("                                           ELSE RN - 200" ).append("\n"); 
		query.append("                                           END AS RN," ).append("\n"); 
		query.append("                                           CNT   " ).append("\n"); 
		query.append("                                           FROM (                  " ).append("\n"); 
		query.append("                                                SELECT /*+ LEADING(K) */" ).append("\n"); 
		query.append("                                                       A.PROP_NO" ).append("\n"); 
		query.append("                                                      ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                                                      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                      ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                                      ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                                      ,DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                                                             ,'G'" ).append("\n"); 
		query.append("                                                             ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                                                FROM PRI_SP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("                                                               WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                                                 AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                                                                 AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                 AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                                             ,'C'" ).append("\n"); 
		query.append("                                                             ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("                                                                FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                                                               WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                                                 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                                                      ,CASE" ).append("\n"); 
		query.append("                                                         WHEN A.AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ AND A.AMDT_SEQ > 0 THEN" ).append("\n"); 
		query.append("                                                          (SELECT '(' || INTG_CD_VAL_DP_DESC || ')'" ).append("\n"); 
		query.append("                                                             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                            WHERE INTG_CD_ID = 'CD02064'" ).append("\n"); 
		query.append("                                                              AND INTG_CD_VAL_CTNT = SRC_INFO_CD" ).append("\n"); 
		query.append("                                                              AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                                         ELSE" ).append("\n"); 
		query.append("                                                          ''" ).append("\n"); 
		query.append("                                                       END AS SRC_INFO_CD" ).append("\n"); 
		query.append("                                                      ,ROW_NUMBER() OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                                            ORDER BY DECODE(A.PRC_CMDT_TP_CD, 'G', '1', 'C', '2'), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                                                      ,COUNT(*) OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ) AS CNT" ).append("\n"); 
		query.append("                                                  FROM PRI_SP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("                                                 WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                                   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                                   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                                                   AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                                                   AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                                         ))" ).append("\n"); 
		query.append("                                 WHERE LEVEL = CNT" ).append("\n"); 
		query.append("                                CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ AND PART_SEQ = PART_SEQ" ).append("\n"); 
		query.append("                                       AND PRIOR RN = RN - 1 " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                       GROUP BY " ).append("\n"); 
		query.append("                               PROP_NO" ).append("\n"); 
		query.append("                              ,AMDT_SEQ" ).append("\n"); 
		query.append("                              ,SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                              ,CMDT_HDR_SEQ                       " ).append("\n"); 
		query.append("               )) B" ).append("\n"); 
		query.append("              ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      -- ,SUBSTR(SYS_CONNECT_BY_PATH(CUST_LGL_ENG_NM || SRC_INFO_CD, '|||'), 4) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      ,PRI_UTILS_PKG.JOIN_ROWS_CLOB_FUNC( CURSOR( " ).append("\n"); 
		query.append("                                                         SELECT B.CUST_LGL_ENG_NM ||  O.SRC_INFO_CD" ).append("\n"); 
		query.append("                                                           FROM PRI_SP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("                                                            ,   MDM_CUSTOMER B" ).append("\n"); 
		query.append("                                                          WHERE A.PROP_NO           = O.PROP_NO " ).append("\n"); 
		query.append("                                                            AND A.AMDT_SEQ          = O.AMDT_SEQ " ).append("\n"); 
		query.append("                                                            AND A.SVC_SCP_CD        = O.SVC_SCP_CD " ).append("\n"); 
		query.append("                                                            AND A.GEN_SPCL_RT_TP_CD = O.GEN_SPCL_RT_TP_CD  " ).append("\n"); 
		query.append("                                                            AND A.CMDT_HDR_SEQ      = O.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("                                                            AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                            AND A.CUST_SEQ = B.CUST_SEQ  " ).append("\n"); 
		query.append("                                                            AND A.SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("                                                          ORDER BY A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                                                      ,'|||' ) AS CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("                  FROM (SELECT /*+ LEADING(K) */" ).append("\n"); 
		query.append("                               A.PROP_NO" ).append("\n"); 
		query.append("                              ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                              ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                              ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                  FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                                 WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                                   AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                              ,CASE" ).append("\n"); 
		query.append("                                 WHEN A.AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ AND A.AMDT_SEQ > 0 THEN" ).append("\n"); 
		query.append("                                  (SELECT '(' || INTG_CD_VAL_DP_DESC || ')'" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD02064'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = SRC_INFO_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                 ELSE" ).append("\n"); 
		query.append("                                  ''" ).append("\n"); 
		query.append("                               END AS SRC_INFO_CD" ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                    ORDER BY A.ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("                              ,COUNT(*) OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ) AS CNT" ).append("\n"); 
		query.append("                          FROM PRI_SP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                           AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                           AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                           AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                           AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                         ) O" ).append("\n"); 
		query.append("                 WHERE LEVEL = CNT" ).append("\n"); 
		query.append("                CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                       AND PRIOR RN = RN - 1 ) C" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("              ,PRI_SP_SCP_RT_CMDT_ROUT E " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("              ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,SUBSTR(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || NVL2(RCV_DE_TERM_CD, '(' || RCV_DE_TERM_CD || ')', ''), '|||'), 4) AS ROUT_PNT_LOC_DEF_CD                      " ).append("\n"); 
		query.append("                      ,SUBSTR(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CNT_CD, '|||'), 4) AS ROUT_PNT_LOC_CNT_CD" ).append("\n"); 
		query.append("                      ,SUBSTR(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_STE_CD, '|||'), 4) AS ROUT_PNT_LOC_STE_CD" ).append("\n"); 
		query.append("                  FROM (SELECT /*+ LEADING(K) */" ).append("\n"); 
		query.append("                               A.PROP_NO" ).append("\n"); 
		query.append("                              ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                              ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                              ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,A.ROUT_SEQ" ).append("\n"); 
		query.append("                              ,A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                              ,A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                              ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                     ,'G'" ).append("\n"); 
		query.append("                                     ,''" ).append("\n"); 
		query.append("                                     ,'L'" ).append("\n"); 
		query.append("                                    ,(SELECT CNT_CD" ).append("\n"); 
		query.append("                                        FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                        WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1)) AS ROUT_PNT_LOC_CNT_CD" ).append("\n"); 
		query.append("                              ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                     ,'G'" ).append("\n"); 
		query.append("                                     ,''" ).append("\n"); 
		query.append("                                     ,'L'" ).append("\n"); 
		query.append("                                     ,(SELECT STE_CD" ).append("\n"); 
		query.append("                                         FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                        WHERE LOC_CD = DECODE(SUBSTR(A.ROUT_PNT_LOC_DEF_CD,1,2),'US',A.ROUT_PNT_LOC_DEF_CD,'')" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1)) AS ROUT_PNT_LOC_STE_CD" ).append("\n"); 
		query.append("                              ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                 WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("                                   AND INTG_CD_VAL_CTNT = A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1) AS RCV_DE_TERM_CD                            " ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                    ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), A.ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                              ,COUNT(*) OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD) AS CNT" ).append("\n"); 
		query.append("                          FROM PRI_SP_SCP_RT_ROUT_PNT A" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                           AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                           AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                           AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                           AND A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                           AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                 WHERE LEVEL = CNT" ).append("\n"); 
		query.append("                CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                       AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                       AND PRIOR RN = RN - 1 ) F" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("              ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,SUBSTR(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD || SRC_INFO_CD, '|||'), 4) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                  FROM (SELECT /*+ LEADING(K) */" ).append("\n"); 
		query.append("                               A.PROP_NO" ).append("\n"); 
		query.append("                              ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                              ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                              ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,A.ROUT_SEQ" ).append("\n"); 
		query.append("                              ,A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                              ,A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                              ,CASE" ).append("\n"); 
		query.append("                                 WHEN A.AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ AND A.AMDT_SEQ > 0 THEN" ).append("\n"); 
		query.append("                                  (SELECT '(' || INTG_CD_VAL_DP_DESC || ')'" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD02064'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = A.SRC_INFO_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                 ELSE" ).append("\n"); 
		query.append("                                  ''" ).append("\n"); 
		query.append("                               END AS SRC_INFO_CD" ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                    ORDER BY DECODE(A.ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), A.ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                              ,COUNT(*) OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD) AS CNT" ).append("\n"); 
		query.append("                          FROM PRI_SP_SCP_RT_ROUT_VIA A" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                           AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                           AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                           AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                           AND A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                           AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                 WHERE LEVEL = CNT" ).append("\n"); 
		query.append("                CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                       AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                       AND PRIOR RN = RN - 1) G" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("              ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,SUBSTR(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD || SRC_INFO_CD, '|||'), 4) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                  FROM (SELECT /*+ LEADING(K) */" ).append("\n"); 
		query.append("                               A.PROP_NO" ).append("\n"); 
		query.append("                              ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                              ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                              ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,A.ROUT_SEQ" ).append("\n"); 
		query.append("                              ,A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                              ,A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                              ,CASE" ).append("\n"); 
		query.append("                                 WHEN A.AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ AND A.AMDT_SEQ > 0 THEN" ).append("\n"); 
		query.append("                                  (SELECT '(' || INTG_CD_VAL_DP_DESC || ')'" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD02064'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = A.SRC_INFO_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                 ELSE" ).append("\n"); 
		query.append("                                  ''" ).append("\n"); 
		query.append("                               END AS SRC_INFO_CD" ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                    ORDER BY DECODE(A.ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), A.ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                              ,COUNT(*) OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD) AS CNT" ).append("\n"); 
		query.append("                          FROM PRI_SP_SCP_RT_ROUT_VIA A" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                           AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                           AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                           AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                           AND A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                           AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                 WHERE LEVEL = CNT" ).append("\n"); 
		query.append("                CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                       AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                       AND PRIOR RN = RN - 1 ) H" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("              ,(SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,SUBSTR(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || NVL2(RCV_DE_TERM_CD, '(' || RCV_DE_TERM_CD || ')', ''), '|||'), 4) AS ROUT_PNT_LOC_DEF_CD          " ).append("\n"); 
		query.append("                      ,SUBSTR(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CNT_CD, '|||'), 4) AS ROUT_PNT_LOC_CNT_CD         " ).append("\n"); 
		query.append("                      ,SUBSTR(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_STE_CD, '|||'), 4) AS ROUT_PNT_LOC_STE_CD                                               " ).append("\n"); 
		query.append("                  FROM (SELECT /*+ LEADING(K) */" ).append("\n"); 
		query.append("                               A.PROP_NO" ).append("\n"); 
		query.append("                              ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                              ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                              ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ,A.ROUT_SEQ" ).append("\n"); 
		query.append("                              ,A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                              ,A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                              ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                     ,'G'" ).append("\n"); 
		query.append("                                     ,''" ).append("\n"); 
		query.append("                                     ,'L'" ).append("\n"); 
		query.append("                                     ,(SELECT CNT_CD" ).append("\n"); 
		query.append("                                        FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                        WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1)) AS ROUT_PNT_LOC_CNT_CD                                                            " ).append("\n"); 
		query.append("                              ,DECODE(A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                     ,'G'" ).append("\n"); 
		query.append("                                     ,''" ).append("\n"); 
		query.append("                                     ,'L'" ).append("\n"); 
		query.append("                                     ,(SELECT STE_CD" ).append("\n"); 
		query.append("                                        FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                        WHERE LOC_CD = DECODE(SUBSTR(A.ROUT_PNT_LOC_DEF_CD,1,2),'US',A.ROUT_PNT_LOC_DEF_CD,'')" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1)) AS ROUT_PNT_LOC_STE_CD                                                                                 " ).append("\n"); 
		query.append("                              ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                 WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("                                   AND INTG_CD_VAL_CTNT = A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1) AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                    ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), A.ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                              ,COUNT(*) OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD) AS CNT" ).append("\n"); 
		query.append("                          FROM PRI_SP_SCP_RT_ROUT_PNT A" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                           AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                           AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                           AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                           AND A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                           AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                 WHERE LEVEL = CNT" ).append("\n"); 
		query.append("                CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                       AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("                       AND PRIOR RN = RN - 1 ) I" ).append("\n"); 
		query.append("                                                                     " ).append("\n"); 
		query.append("              ,PRI_SP_SCP_RT K" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("         WHERE A.PROP_NO           = B.PROP_NO(+)" ).append("\n"); 
		query.append("           AND A.AMDT_SEQ          = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND A.SVC_SCP_CD        = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("           AND A.CMDT_HDR_SEQ      = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND A.PROP_NO           = C.PROP_NO(+)" ).append("\n"); 
		query.append("           AND A.AMDT_SEQ          = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND A.SVC_SCP_CD        = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND A.GEN_SPCL_RT_TP_CD = C.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("           AND A.CMDT_HDR_SEQ      = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("           AND A.PROP_NO           = E.PROP_NO(+)" ).append("\n"); 
		query.append("           AND A.AMDT_SEQ          = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND A.SVC_SCP_CD        = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND A.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("           AND A.CMDT_HDR_SEQ      = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND E.PROP_NO           = F.PROP_NO(+)" ).append("\n"); 
		query.append("           AND E.AMDT_SEQ          = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND E.SVC_SCP_CD        = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND E.GEN_SPCL_RT_TP_CD = F.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("           AND E.CMDT_HDR_SEQ      = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("           AND E.ROUT_SEQ          = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND E.PROP_NO           = G.PROP_NO(+)" ).append("\n"); 
		query.append("           AND E.AMDT_SEQ          = G.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND E.SVC_SCP_CD        = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND E.GEN_SPCL_RT_TP_CD = G.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("           AND E.CMDT_HDR_SEQ      = G.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("           AND E.ROUT_SEQ          = G.ROUT_SEQ(+)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND E.PROP_NO           = H.PROP_NO(+)" ).append("\n"); 
		query.append("           AND E.AMDT_SEQ          = H.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND E.SVC_SCP_CD        = H.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND E.GEN_SPCL_RT_TP_CD = H.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("           AND E.CMDT_HDR_SEQ      = H.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("           AND E.ROUT_SEQ          = H.ROUT_SEQ(+)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND E.PROP_NO           = I.PROP_NO(+)" ).append("\n"); 
		query.append("           AND E.AMDT_SEQ          = I.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND E.SVC_SCP_CD        = I.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND E.GEN_SPCL_RT_TP_CD = I.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("           AND E.CMDT_HDR_SEQ      = I.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("           AND E.ROUT_SEQ          = I.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("           AND E.PROP_NO           = K.PROP_NO(+)" ).append("\n"); 
		query.append("           AND E.AMDT_SEQ          = K.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND E.SVC_SCP_CD        = K.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND E.GEN_SPCL_RT_TP_CD = K.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("           AND E.CMDT_HDR_SEQ      = K.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("           AND E.ROUT_SEQ          = K.ROUT_SEQ(+)" ).append("\n"); 
		query.append("           AND K.SRC_INFO_CD       <> 'AD'           " ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("           AND A.PROP_NO           = @[prop_no]" ).append("\n"); 
		query.append("           AND A.AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("           AND A.SVC_SCP_CD        = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("    ORDER BY A.BLET_DP_SEQ" ).append("\n"); 
		query.append("    ,F.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("    ,G.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("    ,H.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("    ,I.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 

	}
}