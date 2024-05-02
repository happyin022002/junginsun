/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAProposalMainDBDAOSearchProposalEffectiveListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.02.03 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOSearchProposalEffectiveListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAO + SearchProposalEffectiveListVORSQL
	  * </pre>
	  */
	public RFAProposalMainDBDAOSearchProposalEffectiveListVORSQL(){
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
		params.put("dt_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOSearchProposalEffectiveListVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("     -- RFA NO " ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------  " ).append("\n"); 
		query.append("		HDR.RFA_NO                                                                           AS RFA_NO" ).append("\n"); 
		query.append("      , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI')												 AS SRCH_DT				--조회 시점" ).append("\n"); 
		query.append("      , MN.AMDT_SEQ                                                                          AS AMDT_SEQ" ).append("\n"); 
		query.append("      , MN.PROP_NO                                                                           AS PROP_NO" ).append("\n"); 
		query.append("	  , ''																					 AS PROP_PROG_SEQ" ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("     -- Status" ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------  " ).append("\n"); 
		query.append("      , MN.PROP_STS_CD                                                      			 	 AS PROP_STS_CD" ).append("\n"); 
		query.append("      , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE INTG_CD_VAL_CTNT = MN.PROP_STS_CD" ).append("\n"); 
		query.append("            AND INTG_CD_ID = 'CD01722')                                                      AS PROP_STS_NM" ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("     -- Customer" ).append("\n"); 
		query.append("     ----------------------------------------------------------------------------------------------------------------------- " ).append("\n"); 
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
		query.append(" " ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("     -- Request" ).append("\n"); 
		query.append("     ----------------------------------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("       , (SELECT SREP_CD" ).append("\n"); 
		query.append("          FROM MDM_SLS_REP" ).append("\n"); 
		query.append("         WHERE EMPE_CD = (" ).append("\n"); 
		query.append("                SELECT MAX(PROG_USR_ID)" ).append("\n"); 
		query.append("                  FROM PRI_RP_PROG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("				   AND PROP_STS_CD = 'Q')" ).append("\n"); 
		query.append("           AND SREP_STS_CD = 'N' " ).append("\n"); 
		query.append("           AND ROWNUM = 1)                                                                   AS PROP_SREP_CD" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("         SELECT MAX(PROG_OFC_CD)" ).append("\n"); 
		query.append("           FROM PRI_RP_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("			AND PROP_STS_CD = 'Q')                                       					AS PROP_OFC_CD " ).append("\n"); 
		query.append("     ,TO_CHAR( (" ).append("\n"); 
		query.append("         SELECT MAX(PROG_DT)" ).append("\n"); 
		query.append("           FROM PRI_RP_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("			AND PROP_STS_CD = 'Q'                                                      " ).append("\n"); 
		query.append("                )  ,'YYYYMMDD')                                                              AS PROP_RQST_DT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("     -- Approval" ).append("\n"); 
		query.append("     ----------------------------------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("     , (SELECT MAX(PROG_USR_ID)" ).append("\n"); 
		query.append("                  FROM PRI_RP_PROG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("                   AND PROP_STS_CD = 'A')                                                   AS PROP_APRO_STAFF_CD" ).append("\n"); 
		query.append("     , (SELECT C.USR_NM" ).append("\n"); 
		query.append("          FROM COM_USER C" ).append("\n"); 
		query.append("         WHERE C.USR_ID = (" ).append("\n"); 
		query.append("                SELECT MAX(PROG_USR_ID)" ).append("\n"); 
		query.append("                  FROM PRI_RP_PROG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("                   AND PROP_STS_CD = 'A'))                            						AS PROP_APRO_STAFF_NM" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("         SELECT MAX(PROG_OFC_CD)" ).append("\n"); 
		query.append("           FROM PRI_RP_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("            AND PROP_STS_CD = 'A')                                     						AS PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR( (" ).append("\n"); 
		query.append("         SELECT MAX(PROG_DT)" ).append("\n"); 
		query.append("           FROM PRI_RP_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("            AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                )  ,'YYYYMMDD')                                                             AS PROP_APRO_DT             " ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("     -- SVC Scope" ).append("\n"); 
		query.append("     ----------------------------------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , PRI_UTILS_PKG.JOIN_ROWS_VAR_FUNC (CURSOR(SELECT DISTINCT SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  				  FROM PRI_RP_SCP_MN SCP" ).append("\n"); 
		query.append("                                 				 WHERE SCP.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("  								   				   AND SCP.AMDT_SEQ = MN.AMDT_SEQ  ) , ', ') AS SVC_SCP_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("     -- Date" ).append("\n"); 
		query.append("     -----------------------------------------------------------------------------------------------------------------------   " ).append("\n"); 
		query.append("      , TO_CHAR (MN.EFF_DT, 'YYYYMMDD')                                                   	 AS EFF_DT" ).append("\n"); 
		query.append("      , TO_CHAR (MN.EXP_DT, 'YYYYMMDD')                                                      AS EXP_DT" ).append("\n"); 
		query.append("      , TO_CHAR (MN.CRE_DT, 'YYYYMMDD')                                                      AS CRE_DT" ).append("\n"); 
		query.append("	  ----------------------------------------------------------------------------------------------------  " ).append("\n"); 
		query.append("	  -- PARAM VO " ).append("\n"); 
		query.append("	  ----------------------------------------------------------------------------------------------------  " ).append("\n"); 
		query.append("	  ,@[dt_type] 																			 AS DT_TYPE		-- PARAM VO " ).append("\n"); 
		query.append("	  ----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("  FROM  PRI_RP_HDR HDR     " ).append("\n"); 
		query.append("       ,PRI_RP_MN MN" ).append("\n"); 
		query.append(" WHERE  HDR.PROP_NO    = MN.PROP_NO" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------------  기간 조회 시작" ).append("\n"); 
		query.append("  AND MN.EFF_DT       <= TO_DATE(@[exp_dt], 'YYYY-MM-DD') -- Effective Date(To) " ).append("\n"); 
		query.append("  AND MN.EXP_DT       >= TO_DATE(@[eff_dt], 'YYYY-MM-DD') -- Effective Date(From)" ).append("\n"); 
		query.append("  AND MN.RFA_CTRT_TP_CD IN ('C','S')			-- G (Guideline 제외)" ).append("\n"); 
		query.append("  AND MN.PROP_STS_CD IN ('Q', 'A' ,'R')		-- I (Iinitial 제외)" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------------  기간 조회 종료" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rfa_no} != '')" ).append("\n"); 
		query.append("	AND   HDR.RFA_NO = @[rfa_no]						-- RFA No" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_no} != '')" ).append("\n"); 
		query.append("	AND   MN.PROP_NO = @[prop_no]						-- Proposal No" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_sts_cd} != '')" ).append("\n"); 
		query.append("	AND MN.PROP_STS_CD = @[prop_sts_cd]					-- Status code" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND (SELECT MAX(PROG_OFC_CD)" ).append("\n"); 
		query.append("           FROM PRI_RP_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("            AND PROP_STS_CD = 'Q' ) = @[prop_ofc_cd]		-- Request Office" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_srep_cd} != '')" ).append("\n"); 
		query.append("    AND (SELECT SREP_CD" ).append("\n"); 
		query.append("           FROM MDM_SLS_REP" ).append("\n"); 
		query.append("          WHERE EMPE_CD = " ).append("\n"); 
		query.append("               (SELECT MAX(PROG_USR_ID)" ).append("\n"); 
		query.append("                  FROM PRI_RP_PROG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("                   AND PROP_STS_CD = 'Q' ) " ).append("\n"); 
		query.append("            AND SREP_STS_CD = 'N'" ).append("\n"); 
		query.append("            AND ROWNUM = 1)  = @[prop_srep_cd]        						-- Sales Rep." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_apro_staff_cd} != '')" ).append("\n"); 
		query.append("	AND (SELECT MAX(PROG_USR_ID)" ).append("\n"); 
		query.append("                  FROM PRI_RP_PROG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("                   AND PROP_STS_CD = 'A') IN (SELECT USR_ID " ).append("\n"); 
		query.append("                                                FROM COM_USER " ).append("\n"); 
		query.append("                                               WHERE UPPER(USR_NM) LIKE UPPER('%'||@[prop_apro_staff_cd]||'%'))		-- PROP_APRO_STAFF_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_apro_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND	(SELECT MAX(PROG_OFC_CD)" ).append("\n"); 
		query.append("           FROM PRI_RP_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("            AND PROP_STS_CD = 'A') = @[prop_apro_ofc_cd]			-- Approval Office" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_cust_cnt_cd} != '' && ${ctrt_cust_seq} != '') " ).append("\n"); 
		query.append("	AND MN.CTRT_CUST_CNT_CD = @[ctrt_cust_cnt_cd] 		-- Customer" ).append("\n"); 
		query.append("	AND MN.CTRT_CUST_SEQ    = @[ctrt_cust_seq]    		-- Customer" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------------  조회 조건 추가 끝" ).append("\n"); 
		query.append("  ORDER BY MN.PROP_NO" ).append("\n"); 
		query.append("         , MN.AMDT_SEQ" ).append("\n"); 

	}
}