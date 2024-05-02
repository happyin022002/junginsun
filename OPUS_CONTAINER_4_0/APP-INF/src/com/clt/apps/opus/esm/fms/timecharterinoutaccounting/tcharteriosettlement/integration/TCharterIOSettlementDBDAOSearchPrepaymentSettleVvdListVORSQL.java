/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미 정리된 선급금 전표를 항차별로 분리한다
	  * </pre>
	  */
	public TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slip_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration").append("\n"); 
		query.append("FileName : TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdListVORSQL").append("\n"); 
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
		query.append("WITH V_FMS_VVD AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT V.*" ).append("\n"); 
		query.append("    FROM (SELECT V.*" ).append("\n"); 
		query.append("             , (SELECT DECODE(M.REP_TRD_CD,'COM','Y','N')" ).append("\n"); 
		query.append("                  FROM MDM_REV_LANE M" ).append("\n"); 
		query.append("                 WHERE M.RLANE_CD = V.RLANE_CD) AS COM_VVD_FLG" ).append("\n"); 
		query.append("          FROM FMS_VVD V" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND V.VSL_CD IN (SELECT @[vsl_cd]" ).append("\n"); 
		query.append("                              FROM DUAL" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                            SELECT VSL_CD" ).append("\n"); 
		query.append("                              FROM FMS_ID_VSL" ).append("\n"); 
		query.append("                             WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                               AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("           AND V.VST_DT <= REPLACE(@[vvd_exp_dt],'-')" ).append("\n"); 
		query.append("           AND V.VED_DT >= REPLACE(@[vvd_eff_dt],'-') " ).append("\n"); 
		query.append("       ) V" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND V.COM_VVD_FLG = 'N'       " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", V_PARAM AS (" ).append("\n"); 
		query.append("    SELECT @[flet_ctrt_no] AS FLET_CTRT_NO" ).append("\n"); 
		query.append("         , @[acct_cd] AS ACCT_CD" ).append("\n"); 
		query.append("         , @[vndr_seq] AS VNDR_SEQ" ).append("\n"); 
		query.append("         , @[ctr_cd] AS CTR_CD" ).append("\n"); 
		query.append("         , @[slp_loc_cd] AS SLP_LOC_CD" ).append("\n"); 
		query.append("         , REPLACE(@[eff_dt],'-','') AS EFF_DT" ).append("\n"); 
		query.append("         , @[slp_desc] AS CSR_DESC" ).append("\n"); 
		query.append("         , NULL AS PPAY_HIR_NO" ).append("\n"); 
		query.append("         , TO_NUMBER(@[inv_seq]) AS INV_SEQ" ).append("\n"); 
		query.append("         , '' AS VSL_CD" ).append("\n"); 
		query.append("         , '' AS SKD_VOY_NO" ).append("\n"); 
		query.append("         , '' AS SKD_DIR_CD" ).append("\n"); 
		query.append("         , '' AS REV_DIR_CD" ).append("\n"); 
		query.append("         , @[org_slip_no] AS SLP_KEY_NO" ).append("\n"); 
		query.append("         , @[org_slp_tp_cd] AS ORG_SLP_TP_CD" ).append("\n"); 
		query.append("         , @[org_slp_func_cd] AS ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("         , @[org_slp_ofc_cd] AS ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("         , @[org_slp_iss_dt] AS ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("         , @[org_slp_ser_no] AS ORG_SLP_SER_NO" ).append("\n"); 
		query.append("         , @[org_slp_seq_no] AS ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("         , @[csr_curr_cd] AS CSR_CURR_CD" ).append("\n"); 
		query.append("         , TO_CHAR(TO_DATE(REPLACE(@[vvd_eff_dt],'-'),'YYYYMMDD'),'YYYY-MM-DD') AS START_DT" ).append("\n"); 
		query.append("         , TO_CHAR(TO_DATE(REPLACE(@[vvd_exp_dt],'-'),'YYYYMMDD'),'YYYY-MM-DD') AS END_DT" ).append("\n"); 
		query.append("         , TO_NUMBER(@[slp_amt])*-1 AS CSR_AMT" ).append("\n"); 
		query.append("         , TO_NUMBER(@[slp_amt])*-1 / DECODE(@[csr_curr_cd], 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1)" ).append("\n"); 
		query.append("                                                              FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                                                             WHERE EX1.CURR_CD = @[csr_curr_cd]" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[eff_dt],'-',''),1,6)" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_LVL = '1')) AS TRNS_AMT" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_PARAM;" ).append("\n"); 
		query.append("SELECT P.ACCT_CD" ).append("\n"); 
		query.append("     , P.VNDR_SEQ" ).append("\n"); 
		query.append("     , P.CTR_CD" ).append("\n"); 
		query.append("     , P.SLP_LOC_CD" ).append("\n"); 
		query.append("     , P.EFF_DT" ).append("\n"); 
		query.append("     , P.CSR_DESC" ).append("\n"); 
		query.append("     , P.PPAY_HIR_NO" ).append("\n"); 
		query.append("     , P.INV_SEQ" ).append("\n"); 
		query.append("     , P.VSL_CD" ).append("\n"); 
		query.append("     , P.SKD_VOY_NO" ).append("\n"); 
		query.append("     , P.SKD_DIR_CD" ).append("\n"); 
		query.append("     , P.REV_DIR_CD" ).append("\n"); 
		query.append("     , P.SLP_KEY_NO" ).append("\n"); 
		query.append("     , P.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("     , P.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("     , P.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("     , P.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("     , P.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("     , P.ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("     , P.START_DT" ).append("\n"); 
		query.append("     , P.END_DT" ).append("\n"); 
		query.append("     , P.CSR_AMT" ).append("\n"); 
		query.append("     , P.TRNS_AMT" ).append("\n"); 
		query.append("     , CASE WHEN A.VED_DT IS NULL THEN 'NOVVD'" ).append("\n"); 
		query.append("            WHEN A.VED_DT < A.EXP_DT THEN 'NOVVD'" ).append("\n"); 
		query.append("            WHEN B.DISCNT > 0 THEN 'DISVVD'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS VVD_CD" ).append("\n"); 
		query.append("  FROM V_PARAM P" ).append("\n"); 
		query.append("     , (SELECT MIN(A.VST_DT) AS VST_DT" ).append("\n"); 
		query.append("             , TO_CHAR(MIN(B.EFF_DT),'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("             , MAX(A.VED_DT) AS VED_DT" ).append("\n"); 
		query.append("             , TO_CHAR(MAX(DECODE(B.EXP_DT,TRUNC(B.EXP_DT),B.EXP_DT-1,B.EXP_DT)),'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("          FROM V_FMS_VVD A" ).append("\n"); 
		query.append("             , FMS_INV_DTL B" ).append("\n"); 
		query.append("             , V_PARAM P" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND B.FLET_CTRT_NO = P.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND A.VST_DT <= TO_CHAR(B.EXP_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("           AND A.VED_DT >= TO_CHAR(B.EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("           AND B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("           AND B.SLP_TP_CD = P.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("           AND B.SLP_FUNC_CD= P.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND B.SLP_OFC_CD = P.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("           AND B.SLP_ISS_DT = P.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("           AND B.SLP_SER_NO = P.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("           -- AND 	B.ACCT_CD = '510911'" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("     , (SELECT SUM(CASE WHEN A.VED_DT <> TO_CHAR(TO_DATE(B.VST_DT,'YYYYMMDD')-1,'YYYYMMDD') THEN 1" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END) DISCNT" ).append("\n"); 
		query.append("          FROM (SELECT A.VST_DT" ).append("\n"); 
		query.append("                     , A.VED_DT" ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER(PARTITION BY VSL_CD ORDER BY VST_DT DESC) ROW_NUM" ).append("\n"); 
		query.append("                  FROM V_FMS_VVD A" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("             , (SELECT A.VST_DT" ).append("\n"); 
		query.append("                     , A.VED_DT" ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER(PARTITION BY VSL_CD ORDER BY VST_DT DESC) ROW_NUM" ).append("\n"); 
		query.append("                  FROM V_FMS_VVD A" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("         WHERE A.ROW_NUM =B.ROW_NUM+1" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT A.ACCT_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.CTR_CD" ).append("\n"); 
		query.append("     , A.SLP_LOC_CD" ).append("\n"); 
		query.append("     , A.EFF_DT" ).append("\n"); 
		query.append("     , A.CSR_DESC" ).append("\n"); 
		query.append("     , A.PPAY_HIR_NO" ).append("\n"); 
		query.append("     , A.INV_SEQ" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , '' SLP_KEY_NO" ).append("\n"); 
		query.append("     , '' ORG_SLP_TP_CD" ).append("\n"); 
		query.append("     , '' ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("     , '' ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("     , '' ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("     , '' ORG_SLP_SER_NO" ).append("\n"); 
		query.append("     , '' ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("     , TO_CHAR(A.START_DT, 'YYYY-MM-DD') START_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.END_DT, 'YYYY-MM-DD') END_DT" ).append("\n"); 
		query.append("     , ROUND(A.TTL_AMT, 2) CSR_AMT" ).append("\n"); 
		query.append("     , TRUNC(A.TTL_AMT / DECODE(P.CSR_CURR_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1)" ).append("\n"); 
		query.append("                                                  FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                                                 WHERE EX1.CURR_CD = P.CSR_CURR_CD" ).append("\n"); 
		query.append("                                                   AND EX1.ACCT_XCH_RT_YRMON = SUBSTR(P.EFF_DT,1,6)" ).append("\n"); 
		query.append("                                                   AND EX1.ACCT_XCH_RT_LVL = '1')), 2) TRNS_AMT" ).append("\n"); 
		query.append("     , A.VVD_CD                                                   " ).append("\n"); 
		query.append("  FROM (SELECT SEQ_DT" ).append("\n"); 
		query.append("             , DT_AMT" ).append("\n"); 
		query.append("             , MI_AMT" ).append("\n"); 
		query.append("             , SUM(DT_AMT) OVER (PARTITION BY START_DT, END_DT) TTL_AMT" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER (PARTITION BY START_DT, END_DT ORDER BY SEQ_DT) AS MAX_SEQ" ).append("\n"); 
		query.append("             , START_DT" ).append("\n"); 
		query.append("             , END_DT" ).append("\n"); 
		query.append("             , ACCT_CD" ).append("\n"); 
		query.append("             , VNDR_SEQ" ).append("\n"); 
		query.append("             , CTR_CD" ).append("\n"); 
		query.append("             , SLP_LOC_CD" ).append("\n"); 
		query.append("             , EFF_DT" ).append("\n"); 
		query.append("             , CSR_DESC" ).append("\n"); 
		query.append("             , PPAY_HIR_NO" ).append("\n"); 
		query.append("             , INV_SEQ" ).append("\n"); 
		query.append("             , VVD_CD" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , REV_DIR_CD" ).append("\n"); 
		query.append("          FROM ( -- HAP" ).append("\n"); 
		query.append("                SELECT SEQ_DT" ).append("\n"); 
		query.append("                     , DT_AMT" ).append("\n"); 
		query.append("                     , MI_AMT" ).append("\n"); 
		query.append("                     , DT" ).append("\n"); 
		query.append("                     , MIN(DT) OVER () AS MIN_DT" ).append("\n"); 
		query.append("                     , MAX(DT) OVER () AS MAX_DT" ).append("\n"); 
		query.append("                     , NVL(START_DT, MAX(START_DT) OVER (ORDER BY SEQ_DT)) AS START_DT" ).append("\n"); 
		query.append("                     , NVL(END_DT , MAX(END_DT ) OVER (ORDER BY SEQ_DT)) AS END_DT" ).append("\n"); 
		query.append("                     , ACCT_CD" ).append("\n"); 
		query.append("                     , VNDR_SEQ" ).append("\n"); 
		query.append("                     , CTR_CD" ).append("\n"); 
		query.append("                     , SLP_LOC_CD" ).append("\n"); 
		query.append("                     , EFF_DT" ).append("\n"); 
		query.append("                     , CSR_DESC" ).append("\n"); 
		query.append("                     , PPAY_HIR_NO" ).append("\n"); 
		query.append("                     , INV_SEQ" ).append("\n"); 
		query.append("                     , VVD_CD" ).append("\n"); 
		query.append("                     , VSL_CD" ).append("\n"); 
		query.append("                     , SKD_VOY_NO" ).append("\n"); 
		query.append("                     , SKD_DIR_CD" ).append("\n"); 
		query.append("                     , REV_DIR_CD" ).append("\n"); 
		query.append("                  FROM ( --T11" ).append("\n"); 
		query.append("                        SELECT START_DT" ).append("\n"); 
		query.append("                             , END_DT" ).append("\n"); 
		query.append("                             , DT" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , VNDR_SEQ" ).append("\n"); 
		query.append("                             , CTR_CD" ).append("\n"); 
		query.append("                             , SLP_LOC_CD" ).append("\n"); 
		query.append("                             , EFF_DT" ).append("\n"); 
		query.append("                             , CSR_DESC" ).append("\n"); 
		query.append("                             , PPAY_HIR_NO" ).append("\n"); 
		query.append("                             , INV_SEQ" ).append("\n"); 
		query.append("                             , VVD_CD" ).append("\n"); 
		query.append("                             , VSL_CD" ).append("\n"); 
		query.append("                             , SKD_VOY_NO" ).append("\n"); 
		query.append("                             , SKD_DIR_CD" ).append("\n"); 
		query.append("                             , REV_DIR_CD" ).append("\n"); 
		query.append("                          FROM ( --AA" ).append("\n"); 
		query.append("                                SELECT START_DT" ).append("\n"); 
		query.append("                                     , END_DT" ).append("\n"); 
		query.append("                                     , MAX(DECODE(NO, 1, START_DT, END_DT)) AS DT" ).append("\n"); 
		query.append("                                     , ACCT_CD" ).append("\n"); 
		query.append("                                     , VNDR_SEQ" ).append("\n"); 
		query.append("                                     , CTR_CD" ).append("\n"); 
		query.append("                                     , SLP_LOC_CD" ).append("\n"); 
		query.append("                                     , EFF_DT" ).append("\n"); 
		query.append("                                     , CSR_DESC" ).append("\n"); 
		query.append("                                     , PPAY_HIR_NO" ).append("\n"); 
		query.append("                                     , INV_SEQ" ).append("\n"); 
		query.append("                                     , VVD_CD" ).append("\n"); 
		query.append("                                     , VSL_CD" ).append("\n"); 
		query.append("                                     , SKD_VOY_NO" ).append("\n"); 
		query.append("                                     , SKD_DIR_CD" ).append("\n"); 
		query.append("                                     , REV_DIR_CD" ).append("\n"); 
		query.append("                                  FROM ( --T01" ).append("\n"); 
		query.append("                                        SELECT CASE WHEN A.VST_DT <= TO_CHAR(B.EFF_DT, 'YYYYMMDD') THEN TO_DATE(TO_CHAR(B.EFF_DT, 'YYYYMMDD'), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                    ELSE TO_DATE(A.VST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                               END AS START_DT" ).append("\n"); 
		query.append("                                             , CASE WHEN A.VED_DT >= TO_CHAR(B.EXP_DT, 'YYYYMMDD') THEN TO_DATE(TO_CHAR(DECODE(B.EXP_DT, TRUNC(B.EXP_DT), B.EXP_DT, DECODE(B.INV_USD_DYS / DECODE(TRUNC(B.INV_USD_DYS), 0, 1), 1, B.EXP_DT-1, B.EXP_DT )), 'YYYYMMDD'), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                    ELSE TO_DATE(A.VED_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                               END AS END_DT" ).append("\n"); 
		query.append("                                             , B.ACCT_CD" ).append("\n"); 
		query.append("                                             , P.VNDR_SEQ" ).append("\n"); 
		query.append("                                             , P.CTR_CD" ).append("\n"); 
		query.append("                                             , P.SLP_LOC_CD" ).append("\n"); 
		query.append("                                             , P.EFF_DT" ).append("\n"); 
		query.append("                                             , (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                                                  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("                                                 WHERE ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("                                                   AND ACCT_ITM_SEQ = B.ACCT_ITM_SEQ) CSR_DESC" ).append("\n"); 
		query.append("                                             , F.PPAY_HIR_NO" ).append("\n"); 
		query.append("                                             , F.INV_SEQ" ).append("\n"); 
		query.append("                                             , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("                                             , A.VSL_CD" ).append("\n"); 
		query.append("                                             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             , A.REV_DIR_CD" ).append("\n"); 
		query.append("                                          FROM V_FMS_VVD A" ).append("\n"); 
		query.append("                                             , FMS_INVOICE F" ).append("\n"); 
		query.append("                                             , FMS_INV_DTL B" ).append("\n"); 
		query.append("                                             , V_PARAM P" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND F.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND F.FLET_ISS_TP_CD = B.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("                                           AND F.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("                                           AND B.FLET_CTRT_NO = P.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("                                           AND B.SLP_TP_CD = P.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("                                           AND B.SLP_FUNC_CD= P.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("                                           AND B.SLP_OFC_CD = P.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("                                           AND B.SLP_ISS_DT = P.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("                                           AND B.SLP_SER_NO = P.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("                                           AND B.ACCT_CD = '510911'" ).append("\n"); 
		query.append("                                           AND B.ACCT_ITM_SEQ NOT IN (  SELECT ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                                                          FROM FMS_ACCT_CATE" ).append("\n"); 
		query.append("                                                                         WHERE FLET_ACCT_CATE_CD = 'AD')" ).append("\n"); 
		query.append("                                           AND A.VST_DT < TO_CHAR(B.EXP_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                                           AND A.VED_DT >= TO_CHAR(B.EFF_DT, 'YYYYMMDD') ) T01" ).append("\n"); 
		query.append("                                     , (SELECT 1 NO" ).append("\n"); 
		query.append("                                          FROM DUAL" ).append("\n"); 
		query.append("                                         UNION ALL" ).append("\n"); 
		query.append("                                        SELECT 2" ).append("\n"); 
		query.append("                                          FROM DUAL ) T02" ).append("\n"); 
		query.append("                                 GROUP BY START_DT" ).append("\n"); 
		query.append("                                     , END_DT" ).append("\n"); 
		query.append("                                     , NO" ).append("\n"); 
		query.append("                                     , ACCT_CD" ).append("\n"); 
		query.append("                                     , VNDR_SEQ" ).append("\n"); 
		query.append("                                     , CTR_CD" ).append("\n"); 
		query.append("                                     , SLP_LOC_CD" ).append("\n"); 
		query.append("                                     , EFF_DT" ).append("\n"); 
		query.append("                                     , CSR_DESC" ).append("\n"); 
		query.append("                                     , PPAY_HIR_NO" ).append("\n"); 
		query.append("                                     , INV_SEQ" ).append("\n"); 
		query.append("                                     , VVD_CD" ).append("\n"); 
		query.append("                                     , VSL_CD" ).append("\n"); 
		query.append("                                     , SKD_VOY_NO" ).append("\n"); 
		query.append("                                     , SKD_DIR_CD" ).append("\n"); 
		query.append("                                     , REV_DIR_CD ) --AA" ).append("\n"); 
		query.append("                         WHERE START_DT <= END_DT" ).append("\n"); 
		query.append("                         GROUP BY START_DT" ).append("\n"); 
		query.append("                             , END_DT" ).append("\n"); 
		query.append("                             , dt" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , VNDR_SEQ" ).append("\n"); 
		query.append("                             , CTR_CD" ).append("\n"); 
		query.append("                             , SLP_LOC_CD" ).append("\n"); 
		query.append("                             , EFF_DT" ).append("\n"); 
		query.append("                             , CSR_DESC" ).append("\n"); 
		query.append("                             , PPAY_HIR_NO" ).append("\n"); 
		query.append("                             , INV_SEQ" ).append("\n"); 
		query.append("                             , VVD_CD" ).append("\n"); 
		query.append("                             , VSL_CD" ).append("\n"); 
		query.append("                             , SKD_VOY_NO" ).append("\n"); 
		query.append("                             , SKD_DIR_CD" ).append("\n"); 
		query.append("                             , REV_DIR_CD " ).append("\n"); 
		query.append("                       ) T11" ).append("\n"); 
		query.append("                     , ( --T12" ).append("\n"); 
		query.append("                    SELECT SEQ_DT" ).append("\n"); 
		query.append("                             , ORG_DT_AMT" ).append("\n"); 
		query.append("                             , MI_AMT" ).append("\n"); 
		query.append("                             , SEQ_DT2" ).append("\n"); 
		query.append("                             , MI_AMT * (END_DT - SEQ_DT) * (24*60) AS DT_AMT" ).append("\n"); 
		query.append("                          FROM ( -- BB" ).append("\n"); 
		query.append("                                SELECT DT_AMT AS ORG_DT_AMT" ).append("\n"); 
		query.append("                                     , MI_AMT" ).append("\n"); 
		query.append("                                     , EFF_DT + SEQ AS SEQ_DT" ).append("\n"); 
		query.append("                                     , TO_DATE(TO_CHAR(EFF_DT + SEQ, 'YYYYMMDD'), 'YYYYMMDD') SEQ_DT2" ).append("\n"); 
		query.append("                                     , NVL(LEAD(EFF_DT + SEQ) OVER (ORDER BY EXP_DT, SEQ), EXP_DT) AS END_DT" ).append("\n"); 
		query.append("                                  FROM ( --T01" ).append("\n"); 
		query.append("                                        SELECT CASE WHEN F.EFF_DT > H.EFF_DT THEN F.EFF_DT" ).append("\n"); 
		query.append("                                                    ELSE H.EFF_DT" ).append("\n"); 
		query.append("                                               END AS EFF_DT" ).append("\n"); 
		query.append("                                             , CASE WHEN F.EXP_DT > H.EXP_DT THEN H.EXP_DT" ).append("\n"); 
		query.append("                                                    ELSE F.EXP_DT" ).append("\n"); 
		query.append("                                               END AS EXP_DT" ).append("\n"); 
		query.append("                                             , CASE WHEN 'USD' = H.HIR_CURR_N1ST_CD THEN H.HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                                    ELSE H.HIR_RT_N2ND_AMT" ).append("\n"); 
		query.append("                                               END AS DT_AMT" ).append("\n"); 
		query.append("                                             , CASE WHEN 'USD' = H.HIR_CURR_N1ST_CD THEN H.HIR_RT_N1ST_AMT / (24 * 60)" ).append("\n"); 
		query.append("                                                    ELSE H.HIR_RT_N2ND_AMT / (24 * 60)" ).append("\n"); 
		query.append("                                               END AS MI_AMT" ).append("\n"); 
		query.append("                                             , (H.EXP_DT - H.EFF_DT) AS TM" ).append("\n"); 
		query.append("                                          FROM FMS_HIRE H" ).append("\n"); 
		query.append("                                             , FMS_INVOICE F" ).append("\n"); 
		query.append("                                             , FMS_INV_DTL B" ).append("\n"); 
		query.append("                                             , V_PARAM P" ).append("\n"); 
		query.append("                                         WHERE H.FLET_CTRT_NO = P.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND (H.HIR_CURR_N1ST_CD = P.CSR_CURR_CD OR H.HIR_CURR_N2ND_CD = P.CSR_CURR_CD )" ).append("\n"); 
		query.append("                                           AND H.FLET_CTRT_NO = F.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND F.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND F.FLET_ISS_TP_CD = B.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("                                           AND F.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("                                           AND B.FLET_CTRT_NO = P.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("                                           AND B.SLP_TP_CD = P.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("                                           AND B.SLP_FUNC_CD= P.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("                                           AND B.SLP_OFC_CD = P.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("                                           AND B.SLP_ISS_DT = P.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("                                           AND B.SLP_SER_NO = P.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("                                           AND B.ACCT_CD = '510911'" ).append("\n"); 
		query.append("                                           AND B.ACCT_ITM_SEQ NOT IN (  SELECT ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                                                          FROM FMS_ACCT_CATE" ).append("\n"); 
		query.append("                                                                         WHERE FLET_ACCT_CATE_CD = 'AD') ) T01" ).append("\n"); 
		query.append("                                     , (SELECT ROWNUM - 1 AS SEQ" ).append("\n"); 
		query.append("                                          FROM MDM_VENDOR" ).append("\n"); 
		query.append("                                         WHERE ROWNUM <= 5000 ) T02" ).append("\n"); 
		query.append("                                 WHERE SEQ BETWEEN 0 AND TM" ).append("\n"); 
		query.append("                                   AND EFF_DT + SEQ <= EXP_DT" ).append("\n"); 
		query.append("                                   AND EFF_DT <> EXP_DT ) -- BB" ).append("\n"); 
		query.append("                               ) T12" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   --AND T11.DT(+) = T12.SEQ_DT2" ).append("\n"); 
		query.append("                   AND TO_DATE(TO_CHAR(T11.DT(+), 'YYYYMMDD'), 'YYYYMMDD') = T12.SEQ_DT2" ).append("\n"); 
		query.append("                 ORDER BY T12.SEQ_DT " ).append("\n"); 
		query.append("               ) --HAP" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           --AND TO_DATE(TO_CHAR(SEQ_DT, 'YYYYMMDD'), 'YYYYMMDD') BETWEEN MIN_DT AND MAX_DT " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("       , V_PARAM P" ).append("\n"); 
		query.append(" WHERE A.MAX_SEQ = 1" ).append("\n"); 
		query.append("   AND ROUND(A.TTL_AMT, 2) > 0" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT A.ACCT_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.CTR_CD" ).append("\n"); 
		query.append("     , A.SLP_LOC_CD" ).append("\n"); 
		query.append("     , A.EFF_DT" ).append("\n"); 
		query.append("     , A.CSR_DESC" ).append("\n"); 
		query.append("     , A.PPAY_HIR_NO" ).append("\n"); 
		query.append("     , A.INV_SEQ" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.SLP_KEY_NO" ).append("\n"); 
		query.append("     , A.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("     , A.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("     , A.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("     , A.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("     , A.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("     , A.ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("     , A.START_DT" ).append("\n"); 
		query.append("     , A.END_DT" ).append("\n"); 
		query.append("     , A.CSR_AMT" ).append("\n"); 
		query.append("     , A.TRNS_AMT" ).append("\n"); 
		query.append("     , A.VVD_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT B.ACCT_CD" ).append("\n"); 
		query.append("             , P.VNDR_SEQ" ).append("\n"); 
		query.append("             , P.CTR_CD" ).append("\n"); 
		query.append("             , P.SLP_LOC_CD" ).append("\n"); 
		query.append("             , P.EFF_DT" ).append("\n"); 
		query.append("             , (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("                 WHERE ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("                   AND ACCT_ITM_SEQ = B.ACCT_ITM_SEQ) CSR_DESC" ).append("\n"); 
		query.append("             , F.PPAY_HIR_NO" ).append("\n"); 
		query.append("             , F.INV_SEQ" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.REV_DIR_CD" ).append("\n"); 
		query.append("             , '' SLP_KEY_NO" ).append("\n"); 
		query.append("             , '' ORG_SLP_TP_CD" ).append("\n"); 
		query.append("             , '' ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("             , '' ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("             , '' ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("             , '' ORG_SLP_SER_NO" ).append("\n"); 
		query.append("             , '' ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("             , TO_CHAR(CASE WHEN A.VST_DT <= TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN B.EFF_DT" ).append("\n"); 
		query.append("                            ELSE TO_DATE(A.VST_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                       END,'YYYY-MM-DD') START_DT" ).append("\n"); 
		query.append("             , TO_CHAR(CASE WHEN A.VED_DT >= TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN DECODE(B.EXP_DT,TRUNC(B.EXP_DT),B.EXP_DT,B.EXP_DT)" ).append("\n"); 
		query.append("                            ELSE TO_DATE(A.VED_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                       END,'YYYY-MM-DD') END_DT" ).append("\n"); 
		query.append("             , TRUNC(B.INV_AMT*(CASE WHEN A.VED_DT < TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN TO_DATE(A.VED_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                     ELSE B.EXP_DT-1" ).append("\n"); 
		query.append("                                END - " ).append("\n"); 
		query.append("                                CASE WHEN A.VST_DT > TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                     ELSE B.EFF_DT" ).append("\n"); 
		query.append("                                END +1)/B.INV_USD_DYS,2) CSR_AMT" ).append("\n"); 
		query.append("             , TRUNC(B.INV_AMT*(CASE WHEN A.VED_DT < TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN TO_DATE(A.VED_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                     ELSE B.EXP_DT-1" ).append("\n"); 
		query.append("                                END - " ).append("\n"); 
		query.append("                                CASE WHEN A.VST_DT > TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                     ELSE B.EFF_DT" ).append("\n"); 
		query.append("                                END +1)/B.INV_USD_DYS /DECODE(P.CSR_CURR_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1)" ).append("\n"); 
		query.append("                                                                                  FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                                                                                 WHERE EX1.CURR_CD = P.CSR_CURR_CD" ).append("\n"); 
		query.append("                                                                                   AND EX1.ACCT_XCH_RT_YRMON = SUBSTR(P.EFF_DT,1,6)" ).append("\n"); 
		query.append("                                                                                   AND EX1.ACCT_XCH_RT_LVL = '1')),2) TRNS_AMT" ).append("\n"); 
		query.append("             , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("          FROM V_FMS_VVD A" ).append("\n"); 
		query.append("             , FMS_INVOICE F" ).append("\n"); 
		query.append("             , FMS_INV_DTL B" ).append("\n"); 
		query.append("             , V_PARAM P" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND F.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND F.FLET_ISS_TP_CD = B.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("           AND F.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("           AND B.FLET_CTRT_NO = P.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("           AND B.SLP_TP_CD = P.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("           AND B.SLP_FUNC_CD= P.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND B.SLP_OFC_CD = P.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("           AND B.SLP_ISS_DT = P.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("           AND B.SLP_SER_NO = P.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("           AND B.ACCT_CD NOT IN ('510911')" ).append("\n"); 
		query.append("           AND A.VST_DT < TO_CHAR(B.EXP_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("           AND A.VED_DT >= TO_CHAR(B.EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       ) A                        " ).append("\n"); 
		query.append(" WHERE A.CSR_AMT > 0   " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT A.ACCT_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.CTR_CD" ).append("\n"); 
		query.append("     , A.SLP_LOC_CD" ).append("\n"); 
		query.append("     , A.EFF_DT" ).append("\n"); 
		query.append("     , A.CSR_DESC" ).append("\n"); 
		query.append("     , A.PPAY_HIR_NO" ).append("\n"); 
		query.append("     , A.INV_SEQ" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.SLP_KEY_NO" ).append("\n"); 
		query.append("     , A.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("     , A.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("     , A.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("     , A.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("     , A.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("     , A.ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("     , A.START_DT" ).append("\n"); 
		query.append("     , A.END_DT" ).append("\n"); 
		query.append("     , A.CSR_AMT" ).append("\n"); 
		query.append("     , A.TRNS_AMT" ).append("\n"); 
		query.append("     , A.VVD_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT B.ACCT_CD" ).append("\n"); 
		query.append("             , P.VNDR_SEQ" ).append("\n"); 
		query.append("             , P.CTR_CD" ).append("\n"); 
		query.append("             , P.SLP_LOC_CD" ).append("\n"); 
		query.append("             , P.EFF_DT" ).append("\n"); 
		query.append("             , (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("                 WHERE ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("                   AND ACCT_ITM_SEQ = B.ACCT_ITM_SEQ) CSR_DESC" ).append("\n"); 
		query.append("             , F.PPAY_HIR_NO" ).append("\n"); 
		query.append("             , F.INV_SEQ" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.REV_DIR_CD" ).append("\n"); 
		query.append("             , '' SLP_KEY_NO" ).append("\n"); 
		query.append("             , '' ORG_SLP_TP_CD" ).append("\n"); 
		query.append("             , '' ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("             , '' ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("             , '' ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("             , '' ORG_SLP_SER_NO" ).append("\n"); 
		query.append("             , '' ORG_SLP_SEQ_NO" ).append("\n"); 
		query.append("             , TO_CHAR(CASE WHEN A.VST_DT <= TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN B.EFF_DT" ).append("\n"); 
		query.append("                            ELSE TO_DATE(A.VST_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                       END,'YYYY-MM-DD') START_DT" ).append("\n"); 
		query.append("             , TO_CHAR(CASE WHEN A.VED_DT >= TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN DECODE(B.EXP_DT,TRUNC(B.EXP_DT),B.EXP_DT,B.EXP_DT)" ).append("\n"); 
		query.append("                            ELSE TO_DATE(A.VED_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                       END,'YYYY-MM-DD') END_DT" ).append("\n"); 
		query.append("             , TRUNC(B.INV_AMT*(CASE WHEN A.VED_DT < TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN TO_DATE(A.VED_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                     ELSE B.EXP_DT-1" ).append("\n"); 
		query.append("                                END - " ).append("\n"); 
		query.append("                                CASE WHEN A.VST_DT > TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                     ELSE B.EFF_DT" ).append("\n"); 
		query.append("                                END +1)/B.INV_USD_DYS,2) CSR_AMT" ).append("\n"); 
		query.append("             , TRUNC(B.INV_AMT*(CASE WHEN A.VED_DT < TO_CHAR(B.EXP_DT,'YYYYMMDD') THEN TO_DATE(A.VED_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                     ELSE B.EXP_DT-1" ).append("\n"); 
		query.append("                                END - " ).append("\n"); 
		query.append("                                CASE WHEN A.VST_DT > TO_CHAR(B.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                     ELSE B.EFF_DT" ).append("\n"); 
		query.append("                                END +1)/B.INV_USD_DYS /DECODE(P.CSR_CURR_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1)" ).append("\n"); 
		query.append("                                                                                  FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                                                                                 WHERE EX1.CURR_CD = P.CSR_CURR_CD" ).append("\n"); 
		query.append("                                                                                   AND EX1.ACCT_XCH_RT_YRMON = SUBSTR(P.EFF_DT,1,6)" ).append("\n"); 
		query.append("                                                                                   AND EX1.ACCT_XCH_RT_LVL = '1')),2) TRNS_AMT" ).append("\n"); 
		query.append("             , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("          FROM V_FMS_VVD A" ).append("\n"); 
		query.append("             , FMS_INVOICE F" ).append("\n"); 
		query.append("             , FMS_INV_DTL B" ).append("\n"); 
		query.append("             , V_PARAM P" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND F.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND F.FLET_ISS_TP_CD = B.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("           AND F.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("           AND B.FLET_CTRT_NO = P.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND B.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("           AND B.SLP_TP_CD = P.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("           AND B.SLP_FUNC_CD= P.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND B.SLP_OFC_CD = P.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("           AND B.SLP_ISS_DT = P.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("           AND B.SLP_SER_NO = P.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("           AND B.ACCT_CD IN ('510911')" ).append("\n"); 
		query.append("           AND B.ACCT_ITM_SEQ IN (  SELECT ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                      FROM FMS_ACCT_CATE" ).append("\n"); 
		query.append("                                     WHERE FLET_ACCT_CATE_CD = 'AD')" ).append("\n"); 
		query.append("           AND A.VST_DT < TO_CHAR(B.EXP_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("           AND A.VED_DT >= TO_CHAR(B.EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append(" WHERE A.CSR_AMT <> 0    " ).append("\n"); 
		query.append(" ORDER BY ACCT_CD, START_DT " ).append("\n"); 

	}
}