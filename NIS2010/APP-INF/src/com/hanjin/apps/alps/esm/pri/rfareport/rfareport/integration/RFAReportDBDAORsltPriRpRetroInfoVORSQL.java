/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFAReportDBDAORsltPriRpRetroInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.12.19 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAReportDBDAORsltPriRpRetroInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.11.25 [CHM-201432700] 최성환 Retroactive RFA Minimization관련 시스템 개발요청(Month/Creation Date를 기준으로 Retroactive RFA 승인건수 Monitoring을 위한 Report)
	  * </pre>
	  */
	public RFAReportDBDAORsltPriRpRetroInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_apro_staff_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtro_note_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration").append("\n"); 
		query.append("FileName : RFAReportDBDAORsltPriRpRetroInfoVORSQL").append("\n"); 
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
		query.append("SELECT  HDR.RFA_NO                                                                           AS RFA_NO" ).append("\n"); 
		query.append("      , MN.PROP_NO                                                                           AS PROP_NO" ).append("\n"); 
		query.append("      , MN.AMDT_SEQ                                                                          AS AMDT_SEQ" ).append("\n"); 
		query.append("      ---------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("      , TO_CHAR (MN.EFF_DT, 'YYYYMMDD')                                                      AS EFF_DT" ).append("\n"); 
		query.append("      , TO_CHAR (MN.EXP_DT, 'YYYYMMDD')                                                      AS EXP_DT" ).append("\n"); 
		query.append("      , TO_CHAR (MN.CRE_DT, 'YYYYMMDD')                                                      AS CRE_DT" ).append("\n"); 
		query.append("      ----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("      , MN.PROP_OFC_CD                                                                       AS PROP_OFC_CD" ).append("\n"); 
		query.append("      , MN.PROP_SREP_CD                                                                      AS PROP_SREP_CD" ).append("\n"); 
		query.append("      ,(SELECT USR_NM" ).append("\n"); 
		query.append("          FROM COM_USER" ).append("\n"); 
		query.append("         WHERE USR_ID = (SELECT EMPE_CD" ).append("\n"); 
		query.append("                  FROM MDM_SLS_REP" ).append("\n"); 
		query.append("                 WHERE SREP_CD = MN.PROP_SREP_CD ))                                          AS PROP_SREP_NM" ).append("\n"); 
		query.append("      ----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("     , PROG.PROG_USR_ID                                                                      AS PROP_APRO_STAFF_CD" ).append("\n"); 
		query.append("     , (SELECT C.USR_NM" ).append("\n"); 
		query.append("          FROM COM_USER C" ).append("\n"); 
		query.append("         WHERE C.USR_ID = PROG.PROG_USR_ID)                                                  AS PROP_APRO_STAFF_NM" ).append("\n"); 
		query.append("     , PROG.PROG_OFC_CD                                                                      AS PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR (PROG.PROG_DT, 'YYYYMMDD')                                                    AS PROP_APRO_DT       " ).append("\n"); 
		query.append("      ----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("    -- , SCP.SVC_SCP_CD                                                                        AS SVC_SCP_CD" ).append("\n"); 
		query.append("	 , PRI_UTILS_PKG.JOIN_ROWS_VAR_FUNC (CURSOR(SELECT DISTINCT SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  				  FROM PRI_RP_SCP_MN SCP" ).append("\n"); 
		query.append("                                 				 WHERE SCP.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("  								   				   AND SCP.AMDT_SEQ = MN.AMDT_SEQ  ) , ', ') AS SVC_SCP_CD " ).append("\n"); 
		query.append("      ----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("      , (SELECT INTG_CD_VAL_DESC " ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("          WHERE INTG_CD_VAL_CTNT = MN.PRC_CTRT_CUST_TP_CD " ).append("\n"); 
		query.append("            AND INTG_CD_ID = 'CD00697') 													 AS PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("	  , MN.CTRT_CUST_CNT_CD																	 AS CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("      , MN.CTRT_CUST_SEQ											                         AS CTRT_CUST_SEQ" ).append("\n"); 
		query.append("      , MN.CTRT_CUST_CNT_CD||LPAD(TO_CHAR(MN.CTRT_CUST_SEQ),6,'0')                           AS CTRT_CUST_CD" ).append("\n"); 
		query.append("      , (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("         WHERE CUST_CNT_CD = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ = MN.CTRT_CUST_SEQ )                                                 AS CTRT_CUST_NM" ).append("\n"); 
		query.append("      ----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("      , MN.RFA_CTRT_TP_CD                                                                    AS RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("      , (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("          WHERE INTG_CD_ID = 'CD03264' " ).append("\n"); 
		query.append("            AND INTG_CD_VAL_CTNT = MN.RFA_CTRT_TP_CD)                                        AS RFA_CTRT_TP_NM      " ).append("\n"); 
		query.append("      ----------------------------------------------------------------------------------------------------      " ).append("\n"); 
		query.append("      , RTRO.RTRO_NOTE_CD																	 AS RTRO_NOTE_CD" ).append("\n"); 
		query.append("      , (SELECT INTG_CD_VAL_DESC " ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("          WHERE INTG_CD_VAL_CTNT = RTRO.RTRO_NOTE_CD " ).append("\n"); 
		query.append("            AND INTG_CD_ID = 'CD03344')													 	 AS RTRO_NOTE_NM" ).append("\n"); 
		query.append("      , RTRO.RTRO_NOTE_CTNT 																 AS RTRO_NOTE_CTNT" ).append("\n"); 
		query.append("	  ----------------------------------------------------------------------------------------------------  " ).append("\n"); 
		query.append("	  ,'' AS APRO_FROM_DT   -- PARAM VO " ).append("\n"); 
		query.append("	  ,'' AS APRO_TO_DT		-- PARAM VO " ).append("\n"); 
		query.append("	  ,'' AS DT_TYPE		-- PARAM VO " ).append("\n"); 
		query.append("	  ---------------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("  FROM PRI_RP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_RP_MN MN	  " ).append("\n"); 
		query.append("--      ,(" ).append("\n"); 
		query.append("--        SELECT T1.*" ).append("\n"); 
		query.append("--          FROM PRI_RP_PROG T1" ).append("\n"); 
		query.append("--             , (SELECT PROP_NO" ).append("\n"); 
		query.append("--                     , AMDT_SEQ" ).append("\n"); 
		query.append("--                     , MAX(PROP_PROG_SEQ) MAX_PROP_PROG_SEQ" ).append("\n"); 
		query.append("--                  FROM PRI_RP_PROG" ).append("\n"); 
		query.append("--                 WHERE PROP_STS_CD = 'A' " ).append("\n"); 
		query.append("--                 GROUP BY PROP_NO" ).append("\n"); 
		query.append("--                     , AMDT_SEQ) T2" ).append("\n"); 
		query.append("--         WHERE T1.PROP_NO = T2.PROP_NO" ).append("\n"); 
		query.append("--           AND T1.AMDT_SEQ = T2.AMDT_SEQ" ).append("\n"); 
		query.append("--           AND T1.PROP_PROG_SEQ = T2.MAX_PROP_PROG_SEQ    " ).append("\n"); 
		query.append("--       ) PROG   " ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT T.*" ).append("\n"); 
		query.append("                     , ROW_NUMBER () OVER(PARTITION BY PROP_NO, AMDT_SEQ" ).append("\n"); 
		query.append("                         ORDER BY PROP_NO, AMDT_SEQ, PROP_PROG_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("                  FROM PRI_RP_PROG T" ).append("\n"); 
		query.append("                 WHERE PROP_STS_CD = 'A' ) PROG_MAX" ).append("\n"); 
		query.append("         WHERE RNUM < 2" ).append("\n"); 
		query.append("       ) PROG        " ).append("\n"); 
		query.append("      ,PRI_RP_RTRO_NOTE RTRO" ).append("\n"); 
		query.append("WHERE HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("  AND MN.PROP_NO = PROG.PROP_NO " ).append("\n"); 
		query.append("  AND MN.AMDT_SEQ = PROG.AMDT_SEQ " ).append("\n"); 
		query.append("  AND PROG.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("  AND MN.PROP_STS_CD = 'A'  			-- 현재 Approve 대상만 조회" ).append("\n"); 
		query.append("  AND MN.PROP_APRO_DT IS NOT NULL" ).append("\n"); 
		query.append("  AND MN.RFA_CTRT_TP_CD IN ('C','S')	-- G (Guideline 제외)" ).append("\n"); 
		query.append("  AND MN.PROP_NO = RTRO.PROP_NO" ).append("\n"); 
		query.append("  AND MN.AMDT_SEQ = RTRO.AMDT_SEQ" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------------  조회 조건 추가 시작" ).append("\n"); 
		query.append("#if (${dt_type} == 'APRO')" ).append("\n"); 
		query.append("	AND PROG.PROG_DT           <= TO_DATE(@[exp_dt], 'YYYY-MM-DD') + 0.99999 -- Approval Date(To:235959) " ).append("\n"); 
		query.append("	AND PROG.PROG_DT           >= TO_DATE(@[eff_dt], 'YYYY-MM-DD') -- Approval Date(From)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	AND MN.EFF_DT              <= TO_DATE(@[exp_dt], 'YYYY-MM-DD') -- Effective Date(To) " ).append("\n"); 
		query.append("	AND MN.EXP_DT              >= TO_DATE(@[eff_dt], 'YYYY-MM-DD') -- Effective Date(From)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rfa_no} != '')" ).append("\n"); 
		query.append("	AND   HDR.RFA_NO = @[rfa_no]						-- RFA No" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND MN.PROP_OFC_CD = @[prop_ofc_cd]					-- Request Office" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_srep_cd} != '')" ).append("\n"); 
		query.append("	AND MN.PROP_SREP_CD = @[prop_srep_cd]				-- Sales Rep." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_apro_staff_cd} != '')" ).append("\n"); 
		query.append("	AND PROG.PROG_USR_ID IN (SELECT USR_ID FROM COM_USER WHERE UPPER(USR_NM) LIKE UPPER('%'||@[prop_apro_staff_cd]||'%'))		-- PROP_APRO_STAFF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_apro_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND PROG.PROG_OFC_CD = @[prop_apro_ofc_cd]			-- PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_cust_cnt_cd} != '' && ${ctrt_cust_seq} != '') " ).append("\n"); 
		query.append("	AND MN.CTRT_CUST_CNT_CD = @[ctrt_cust_cnt_cd] 		-- Customer" ).append("\n"); 
		query.append("	AND MN.CTRT_CUST_SEQ    = @[ctrt_cust_seq]    		-- Customer" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rfa_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("	AND MN.RFA_CTRT_TP_CD = @[rfa_ctrt_tp_cd]			-- RFA Type" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rtro_note_cd} != '')" ).append("\n"); 
		query.append("	AND RTRO.RTRO_NOTE_CD = @[rtro_note_cd]				-- NOTE code" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------------  조회 조건 추가 끝" ).append("\n"); 
		query.append("  ORDER BY PROG.PROG_DT DESC" ).append("\n"); 

	}
}