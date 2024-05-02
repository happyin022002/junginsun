/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCRateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27 
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

public class SCRateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Commodity 조회
	  * * 2013.10.25 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
	  * * 2015.01.19 송호진 [CHM-201533722] SYS_CONNECT_BY_PATH 항목 관련 수정
	  * * 2015.04.06 송호진 [CHM-201534007] Fixed index 개발
	  * * 2016.01.27 현성길 [CHM-201639978] S/C note 상 글자수 제한 해제 _ BKG Module 과 연계 Module에서도 제한 해제
	  * </pre>
	  */
	public SCRateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL(){
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
		query.append("FileName : SCRateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL").append("\n"); 
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
		query.append("      ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("      ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ,B.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      --,REPLACE(C.CUST_LGL_ENG_NM, '^|^', ' / ') AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      --,SUBSTR(REGEXP_SUBSTR(D.NOTE_CLSS_NM, ', GRI') ||" ).append("\n"); 
		query.append("      --        REGEXP_SUBSTR(D.NOTE_CLSS_NM, ', Surcharge') ||" ).append("\n"); 
		query.append("      --        REGEXP_SUBSTR(D.NOTE_CLSS_NM, ', DEM/DET') ||" ).append("\n"); 
		query.append("      --        REGEXP_SUBSTR(D.NOTE_CLSS_NM, ', Chassis') ||" ).append("\n"); 
		query.append("      --        REGEXP_SUBSTR(D.NOTE_CLSS_NM, ', Others')" ).append("\n"); 
		query.append("      --       ,3) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append("      --,REPLACE(D.NOTE_TOOLTIP, '^|^', CHR(13) || CHR(13)) AS NOTE_CLSS_NM_TOOLTIP" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,D.NOTE_CLSS_NM" ).append("\n"); 
		query.append("      ,D.NOTE_TOOLTIP AS NOTE_CLSS_NM_TOOLTIP" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,A.BLET_DP_SEQ" ).append("\n"); 
		query.append("      ,A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("      ,DECODE ( A.FX_RT_FLG, 'Y', '1', 'N', '0', '0' ) AS FX_RT_FLG" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_RT_CMDT_HDR A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,PRC_CMDT_DEF_NM_A||DECODE(PRC_CMDT_DEF_NM_B,'','',' / ')||PRC_CMDT_DEF_NM_B PRC_CMDT_DEF_NM        " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT PROP_NO" ).append("\n"); 
		query.append("                  ,AMDT_SEQ" ).append("\n"); 
		query.append("                  ,SVC_SCP_CD" ).append("\n"); 
		query.append("                  ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                  ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                  ,MAX(CASE WHEN PART_SEQ = 'A' THEN PRC_CMDT_DEF_NM ELSE NULL END) AS PRC_CMDT_DEF_NM_A" ).append("\n"); 
		query.append("                  ,MAX(CASE WHEN PART_SEQ = 'B' THEN PRC_CMDT_DEF_NM ELSE NULL END) AS PRC_CMDT_DEF_NM_B" ).append("\n"); 
		query.append("            FROM (      " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                    SELECT PROP_NO" ).append("\n"); 
		query.append("                          ,AMDT_SEQ" ).append("\n"); 
		query.append("                          ,SVC_SCP_CD" ).append("\n"); 
		query.append("                          ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                          ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                          ,PART_SEQ" ).append("\n"); 
		query.append("                          ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, ' / ')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                              SELECT PROP_NO " ).append("\n"); 
		query.append("                                    ,AMDT_SEQ" ).append("\n"); 
		query.append("                                    ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                    ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                    ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                    ,PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                                    ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                                    ,SRC_INFO_CD" ).append("\n"); 
		query.append("                                   ,CASE WHEN RN <= 100 THEN 'A'" ).append("\n"); 
		query.append("                                        WHEN RN <= 200 THEN 'B'" ).append("\n"); 
		query.append("                                   ELSE 'C'" ).append("\n"); 
		query.append("                                   END AS PART_SEQ" ).append("\n"); 
		query.append("                                   ,CASE WHEN RN <= 100 THEN RN" ).append("\n"); 
		query.append("                                        WHEN RN <= 200 THEN RN - 100" ).append("\n"); 
		query.append("                                   ELSE RN - 200" ).append("\n"); 
		query.append("                                   END AS RN   " ).append("\n"); 
		query.append("                              FROM (               " ).append("\n"); 
		query.append("                                    SELECT PROP_NO" ).append("\n"); 
		query.append("                                          ,AMDT_SEQ" ).append("\n"); 
		query.append("                                          ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                          ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                          ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                          ,DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                                                 ,'G'" ).append("\n"); 
		query.append("                                                 ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                                    FROM PRI_SP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("                                                   WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                                     AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                                                     AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                     AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                                 ,'C'" ).append("\n"); 
		query.append("                                                 ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("                                                    FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                                                   WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                                     AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                                          ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                                          ,SRC_INFO_CD" ).append("\n"); 
		query.append("                                          ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', '1', 'C', '2'), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                                      FROM PRI_SP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("                                     WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                       AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                       AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                                       AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                                       AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                     START WITH RN = 1" ).append("\n"); 
		query.append("                    CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ " ).append("\n"); 
		query.append("                           AND PRIOR RN = RN - 1 AND PRIOR PART_SEQ = PART_SEQ" ).append("\n"); 
		query.append("                     GROUP BY PROP_NO" ).append("\n"); 
		query.append("                             ,AMDT_SEQ" ).append("\n"); 
		query.append("                             ,SVC_SCP_CD" ).append("\n"); 
		query.append("                             ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                             ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                             ,PART_SEQ" ).append("\n"); 
		query.append("             )  " ).append("\n"); 
		query.append("             GROUP BY" ).append("\n"); 
		query.append("                   PROP_NO" ).append("\n"); 
		query.append("                  ,AMDT_SEQ" ).append("\n"); 
		query.append("                  ,SVC_SCP_CD" ).append("\n"); 
		query.append("                  ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                  ,CMDT_HDR_SEQ             " ).append("\n"); 
		query.append("       )) B" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              -- ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_LGL_ENG_NM, '^|^')), 4) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              ,PRI_UTILS_PKG.JOIN_ROWS_CLOB_FUNC( CURSOR( " ).append("\n"); 
		query.append("                                                         SELECT B.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("                                                           FROM PRI_SP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("                                                            ,   MDM_CUSTOMER B" ).append("\n"); 
		query.append("                                                          WHERE A.PROP_NO           = K.PROP_NO " ).append("\n"); 
		query.append("                                                            AND A.AMDT_SEQ          = K.AMDT_SEQ " ).append("\n"); 
		query.append("                                                            AND A.SVC_SCP_CD        = K.SVC_SCP_CD " ).append("\n"); 
		query.append("                                                            AND A.GEN_SPCL_RT_TP_CD = K.GEN_SPCL_RT_TP_CD  " ).append("\n"); 
		query.append("                                                            AND A.CMDT_HDR_SEQ      = K.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("                                                            AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                            AND A.CUST_SEQ = B.CUST_SEQ   " ).append("\n"); 
		query.append("                                                            AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                                                          ORDER BY A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                                                      ,' / ' ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                         WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                           AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD') K" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ) C" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              -- ,MAX(SYS_CONNECT_BY_PATH(NOTE_CLSS_NM, ', ')) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append("              ,PRI_UTILS_PKG.JOIN_ROWS_CLOB_FUNC( CURSOR(" ).append("\n"); 
		query.append("                                                         SELECT B.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                                           FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                                          WHERE B.INTG_CD_VAL_CTNT IN (" ).append("\n"); 
		query.append("                                                                SELECT  A.NOTE_CLSS_CD " ).append("\n"); 
		query.append("                                                                FROM    PRI_SP_SCP_RT_CNOTE A" ).append("\n"); 
		query.append("                                                                WHERE   A.PROP_NO           = K.PROP_NO" ).append("\n"); 
		query.append("                                                                AND     A.AMDT_SEQ          = K.AMDT_SEQ" ).append("\n"); 
		query.append("                                                                AND     A.SVC_SCP_CD        = K.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                                AND     A.GEN_SPCL_RT_TP_CD = K.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                                                AND     A.CMDT_HDR_SEQ      = K.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("                                                                AND     A.SRC_INFO_CD       <> 'AD' ) " ).append("\n"); 
		query.append("                                                            AND B.INTG_CD_ID        = 'CD01711'" ).append("\n"); 
		query.append("                                                          ORDER BY B.INTG_CD_VAL_DP_SEQ " ).append("\n"); 
		query.append("                                                          )" ).append("\n"); 
		query.append("                                                    ,', ' ) AS NOTE_CLSS_NM " ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(decode(sign(length(NOTE_TOOLTIP)-500),1,substr(NOTE_TOOLTIP,1,497)||'...',NOTE_TOOLTIP) , '^|^')), 4) AS NOTE_TOOLTIP " ).append("\n"); 
		query.append("--              ,PRI_UTILS_PKG.JOIN_ROWS_CLOB_FUNC( CURSOR(" ).append("\n"); 
		query.append("--                                                         SELECT SUBSTRB( '<' ||B.INTG_CD_VAL_DP_DESC||'>'|| CHR(13) ||A.NOTE_CTNT ,0,497)" ).append("\n"); 
		query.append("--                                                                ||CASE WHEN LENGTHB( '<' ||B.INTG_CD_VAL_DP_DESC||'>'|| CHR(13) ||A.NOTE_CTNT ) < 497 THEN '' ELSE '...' END" ).append("\n"); 
		query.append("--                                                           FROM PRI_SP_SCP_RT_CNOTE A" ).append("\n"); 
		query.append("--                                                            ,   COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("--                                                          WHERE A.PROP_NO           = K.PROP_NO " ).append("\n"); 
		query.append("--                                                            AND A.AMDT_SEQ          = K.AMDT_SEQ " ).append("\n"); 
		query.append("--                                                            AND A.SVC_SCP_CD        = K.SVC_SCP_CD " ).append("\n"); 
		query.append("--                                                            AND A.GEN_SPCL_RT_TP_CD = K.GEN_SPCL_RT_TP_CD  " ).append("\n"); 
		query.append("--                                                            AND A.CMDT_HDR_SEQ      = K.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("--                                                            AND A.SRC_INFO_CD       <> 'AD'                                                                                     " ).append("\n"); 
		query.append("--                                                            AND A.NOTE_CLSS_CD      = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("--                                                            AND B.INTG_CD_ID        = 'CD01711'" ).append("\n"); 
		query.append("--                                                          ORDER BY B.INTG_CD_VAL_DP_SEQ, A.CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("--                                                          )" ).append("\n"); 
		query.append("--                                                    , CHR(13) || CHR(13) ) AS NOTE_TOOLTIP" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE INTG_CD_ID = 'CD01711'" ).append("\n"); 
		query.append("                           AND INTG_CD_VAL_CTNT = NOTE_CLSS_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append("                      ,'<' || (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                 FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                WHERE INTG_CD_ID = 'CD01711'" ).append("\n"); 
		query.append("                                  AND INTG_CD_VAL_CTNT = NOTE_CLSS_CD" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1) || '>' || CHR(13) ||" ).append("\n"); 
		query.append("                       TO_CLOB(NOTE_CTNT) AS NOTE_TOOLTIP" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, DECODE(NOTE_CLSS_CD, 'G', '1', 'S', '2', 'D', '3', 'C', '4', 'O', '5')) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD') K" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ) D" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = C.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = D.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append(" ORDER BY A.BLET_DP_SEQ" ).append("\n"); 

	}
}