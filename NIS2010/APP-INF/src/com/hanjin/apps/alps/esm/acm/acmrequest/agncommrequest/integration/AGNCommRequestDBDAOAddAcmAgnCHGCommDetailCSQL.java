/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnCHGCommDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnCHGCommDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Acm Agn CHG Comm Detail
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnCHGCommDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_comm_pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_comm_otr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_comm_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_comm_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnCHGCommDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM_DTL_CHG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BKG_NO" ).append("\n"); 
		query.append("  , AGN_CD" ).append("\n"); 
		query.append("  , IO_BND_CD" ).append("\n"); 
		query.append("  , AC_TP_CD" ).append("\n"); 
		query.append("  , AC_SEQ" ).append("\n"); 
		query.append("  , AC_CHG_SEQ" ).append("\n"); 
		query.append("  , CHG_CD" ).append("\n"); 
		query.append("  , CURR_CD" ).append("\n"); 
		query.append("  , RAT_UT_CD" ).append("\n"); 
		query.append("  , CHG_UT_AMT" ).append("\n"); 
		query.append("  , CHG_AMT" ).append("\n"); 
		query.append("  , CHG_COMM_RT" ).append("\n"); 
		query.append("  , CHG_COMM_OTR_AMT" ).append("\n"); 
		query.append("  , CHG_COMM_CURR_CD" ).append("\n"); 
		query.append("  , COMM_AMT" ).append("\n"); 
		query.append("  , PAY_COMM_AMT" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${chg_comm_div_cd} == 'M')" ).append("\n"); 
		query.append("    #if(${chg_comm_rt} != '')" ).append("\n"); 
		query.append("        SELECT @[bkg_no]" ).append("\n"); 
		query.append("             , @[agn_cd]" ).append("\n"); 
		query.append("             , @[io_bnd_cd]" ).append("\n"); 
		query.append("             , @[ac_tp_cd]" ).append("\n"); 
		query.append("             , @[max_ac_seq]" ).append("\n"); 
		query.append("             , @[comm_chg_seq] + ROWNUM AS AC_CHG_SEQ" ).append("\n"); 
		query.append("             , P.CHG_CD" ).append("\n"); 
		query.append("             , P.CURR_CD" ).append("\n"); 
		query.append("             , P.RAT_UT_CD" ).append("\n"); 
		query.append("             , P.CHG_UT_AMT" ).append("\n"); 
		query.append("             , P.CHG_AMT" ).append("\n"); 
		query.append("             , @[chg_comm_rt]" ).append("\n"); 
		query.append("             , @[chg_comm_otr_amt]" ).append("\n"); 
		query.append("             , @[chg_comm_curr_cd]" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(P.CURR_CD, @[ofc_curr_cd], DECODE(@[pay_xch_rt], 0, 0, (P.CHG_AMT * @[chg_comm_rt] / 100) / @[pay_xch_rt]) " ).append("\n"); 
		query.append("                                                         , (P.CHG_AMT / DECODE(P.CURR_CD, 'USD', 1, NVL(Q.USD_LOCL_XCH_RT, 0))) * @[chg_comm_rt] / 100), 2), 0) AS COMM_AMT" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(P.CURR_CD, @[ofc_curr_cd], (P.CHG_AMT * @[chg_comm_rt] / 100) " ).append("\n"); 
		query.append("                                                         , ((P.CHG_AMT / DECODE(P.CURR_CD, 'USD', 1, NVL(Q.USD_LOCL_XCH_RT, 0))) * @[chg_comm_rt] / 100) * @[pay_xch_rt]), 2), 0) AS PAY_COMM_AMT" ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT P, " ).append("\n"); 
		query.append("             GL_MON_XCH_RT Q" ).append("\n"); 
		query.append("        WHERE P.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND P.CHG_CD = @[comm_chg_cd] " ).append("\n"); 
		query.append("        AND P.FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("        AND P.FRT_TERM_CD = DECODE(@[chg_comm_pay_term_cd], 'T', P.FRT_TERM_CD, '', P.FRT_TERM_CD, @[chg_comm_pay_term_cd])" ).append("\n"); 
		query.append("        AND P.CURR_CD = Q.CURR_CD" ).append("\n"); 
		query.append("        AND Q.ACCT_XCH_RT_YRMON = DECODE(SIGN(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMM')) - TO_NUMBER(SUBSTR (@[sa_dt], 1, 6))), 1, SUBSTR (@[sa_dt], 1, 6),TO_CHAR(SYSDATE, 'YYYYMM')) " ).append("\n"); 
		query.append("        AND Q.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("    #elseif(${chg_comm_otr_amt} != '')" ).append("\n"); 
		query.append("        SELECT @[bkg_no]" ).append("\n"); 
		query.append("             , @[agn_cd]" ).append("\n"); 
		query.append("             , @[io_bnd_cd]" ).append("\n"); 
		query.append("             , @[ac_tp_cd]" ).append("\n"); 
		query.append("             , @[max_ac_seq]" ).append("\n"); 
		query.append("             , @[comm_chg_seq] + ROWNUM AS AC_CHG_SEQ" ).append("\n"); 
		query.append("             , CHG_CD" ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("             , RAT_UT_CD" ).append("\n"); 
		query.append("             , CHG_UT_AMT" ).append("\n"); 
		query.append("             , CHG_AMT" ).append("\n"); 
		query.append("             , @[chg_comm_rt]" ).append("\n"); 
		query.append("             , @[chg_comm_otr_amt]" ).append("\n"); 
		query.append("             , @[chg_comm_curr_cd]" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(@[chg_comm_curr_cd], @[ofc_curr_cd], DECODE(@[pay_xch_rt] ,0, 0, (@[chg_comm_otr_amt] / @[pay_xch_rt]))" ).append("\n"); 
		query.append("                                                                   , (@[chg_comm_otr_amt] / DECODE(@[chg_comm_curr_cd], 'USD', 1, @[usd_xch_rt]))), 2), 0) AS COMM_AMT" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(@[chg_comm_curr_cd], @[ofc_curr_cd], @[chg_comm_otr_amt]" ).append("\n"); 
		query.append("                                                                   , (@[chg_comm_otr_amt] / DECODE(@[chg_comm_curr_cd], 'USD', 1, @[usd_xch_rt])) * @[pay_xch_rt]), 2), 0) AS PAY_COMM_AMT  " ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("        AND CHG_CD = @[comm_chg_cd] " ).append("\n"); 
		query.append("        AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("        AND FRT_TERM_CD = DECODE(@[chg_comm_pay_term_cd], 'T', FRT_TERM_CD, '', FRT_TERM_CD, @[chg_comm_pay_term_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif(${chg_comm_div_cd} == 'T')" ).append("\n"); 
		query.append("    #if(${chg_comm_rt} != '')" ).append("\n"); 
		query.append("        SELECT @[bkg_no]" ).append("\n"); 
		query.append("             , @[agn_cd]" ).append("\n"); 
		query.append("             , @[io_bnd_cd]" ).append("\n"); 
		query.append("             , @[ac_tp_cd]" ).append("\n"); 
		query.append("             , @[max_ac_seq]" ).append("\n"); 
		query.append("             , @[comm_chg_seq] + ROWNUM AS AC_CHG_SEQ" ).append("\n"); 
		query.append("             , CHG_CD" ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("             , RAT_UT_CD" ).append("\n"); 
		query.append("             , CHG_UT_AMT" ).append("\n"); 
		query.append("             , CHG_AMT" ).append("\n"); 
		query.append("             , @[chg_comm_rt]" ).append("\n"); 
		query.append("             , @[chg_comm_otr_amt]" ).append("\n"); 
		query.append("             , @[chg_comm_curr_cd]" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(TRF_CURR_CD, @[ofc_curr_cd], DECODE(@[pay_xch_rt] ,0, 0, (DECODE(CHG_AMT, 0, TRF_CHG_AMT, CHG_AMT) * @[chg_comm_rt] / 100) / @[pay_xch_rt]) " ).append("\n"); 
		query.append("                                                         , (DECODE(CHG_AMT, 0, TRF_CHG_AMT, CHG_AMT) / DECODE(TRF_CURR_CD, 'USD', 1, NVL(USD_LOCL_XCH_RT, 0))) * @[chg_comm_rt] / 100), 2), 0) AS COMM_AMT" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(TRF_CURR_CD, @[ofc_curr_cd], (DECODE(CHG_AMT, 0, TRF_CHG_AMT, CHG_AMT) * @[chg_comm_rt] / 100)" ).append("\n"); 
		query.append("                                                         , ((DECODE(CHG_AMT, 0, TRF_CHG_AMT, CHG_AMT) / DECODE(TRF_CURR_CD, 'USD', 1, NVL(USD_LOCL_XCH_RT, 0))) * @[chg_comm_rt] / 100) * @[pay_xch_rt]), 2), 0) AS PAY_COMM_AMT   " ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT P.CHG_CD" ).append("\n"); 
		query.append("                     , P.CURR_CD AS TRF_CURR_CD" ).append("\n"); 
		query.append("                     , P.CHG_AMT AS TRF_CHG_AMT" ).append("\n"); 
		query.append("                     , Q.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                     , (SELECT CURR_CD " ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                        WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                        AND CHG_CD = P.CHG_CD" ).append("\n"); 
		query.append("                        AND CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("                        AND RAT_UT_CD = P.RAT_UT_CD" ).append("\n"); 
		query.append("                        AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                        AND FRT_TERM_CD = P.FRT_TERM_CD" ).append("\n"); 
		query.append("                        GROUP BY CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("                     , (SELECT RAT_UT_CD " ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                        WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                        AND CHG_CD = P.CHG_CD" ).append("\n"); 
		query.append("                        AND CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("                        AND RAT_UT_CD = P.RAT_UT_CD" ).append("\n"); 
		query.append("                        AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                        AND FRT_TERM_CD = P.FRT_TERM_CD" ).append("\n"); 
		query.append("                        GROUP BY RAT_UT_CD) AS RAT_UT_CD" ).append("\n"); 
		query.append("                     , (SELECT NVL(SUM(CHG_UT_AMT), 0) " ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                        WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                        AND CHG_CD = P.CHG_CD" ).append("\n"); 
		query.append("                        AND CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("                        AND RAT_UT_CD = P.RAT_UT_CD" ).append("\n"); 
		query.append("                        AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                        AND FRT_TERM_CD = P.FRT_TERM_CD) AS CHG_UT_AMT" ).append("\n"); 
		query.append("                     , (SELECT NVL(SUM(CHG_AMT), 0) " ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                        WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                        AND CHG_CD = P.CHG_CD" ).append("\n"); 
		query.append("                        AND CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("                        AND RAT_UT_CD = P.RAT_UT_CD" ).append("\n"); 
		query.append("                        AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                        AND FRT_TERM_CD = P.FRT_TERM_CD) AS CHG_AMT" ).append("\n"); 
		query.append("                FROM BKG_TRF_SCG_RT P, " ).append("\n"); 
		query.append("                     GL_MON_XCH_RT Q" ).append("\n"); 
		query.append("                WHERE P.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                AND P.CHG_CD = @[comm_chg_cd] " ).append("\n"); 
		query.append("                AND P.FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                AND P.FRT_TERM_CD = DECODE(@[chg_comm_pay_term_cd], 'T', P.FRT_TERM_CD, '', P.FRT_TERM_CD, @[chg_comm_pay_term_cd])" ).append("\n"); 
		query.append("                AND P.CURR_CD = Q.CURR_CD" ).append("\n"); 
		query.append("                AND Q.ACCT_XCH_RT_YRMON = DECODE(SIGN(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMM')) - TO_NUMBER(SUBSTR (@[sa_dt], 1, 6))), 1, SUBSTR (@[sa_dt], 1, 6),TO_CHAR(SYSDATE, 'YYYYMM')) " ).append("\n"); 
		query.append("                AND Q.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #elseif(${chg_comm_otr_amt} != '')" ).append("\n"); 
		query.append("        SELECT @[bkg_no]" ).append("\n"); 
		query.append("             , @[agn_cd]" ).append("\n"); 
		query.append("             , @[io_bnd_cd]" ).append("\n"); 
		query.append("             , @[ac_tp_cd]" ).append("\n"); 
		query.append("             , @[max_ac_seq]" ).append("\n"); 
		query.append("             , @[comm_chg_seq] + ROWNUM AS AC_CHG_SEQ" ).append("\n"); 
		query.append("             , @[comm_chg_cd] " ).append("\n"); 
		query.append("             , (SELECT CURR_CD " ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                AND CHG_CD = P.CHG_CD" ).append("\n"); 
		query.append("                AND CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("                AND RAT_UT_CD = P.RAT_UT_CD" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                AND FRT_TERM_CD = P.FRT_TERM_CD" ).append("\n"); 
		query.append("                GROUP BY CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("             , (SELECT RAT_UT_CD " ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                AND CHG_CD = P.CHG_CD" ).append("\n"); 
		query.append("                AND CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("                AND RAT_UT_CD = P.RAT_UT_CD" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                AND FRT_TERM_CD = P.FRT_TERM_CD" ).append("\n"); 
		query.append("                GROUP BY RAT_UT_CD) AS RAT_UT_CD" ).append("\n"); 
		query.append("             , (SELECT NVL(SUM(CHG_UT_AMT), 0) " ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                AND CHG_CD = P.CHG_CD" ).append("\n"); 
		query.append("                AND CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("                AND RAT_UT_CD = P.RAT_UT_CD" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                AND FRT_TERM_CD = P.FRT_TERM_CD) AS CHG_UT_AMT" ).append("\n"); 
		query.append("             , (SELECT NVL(SUM(CHG_AMT), 0) " ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                AND CHG_CD = P.CHG_CD" ).append("\n"); 
		query.append("                AND CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("                AND RAT_UT_CD = P.RAT_UT_CD" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                AND FRT_TERM_CD = P.FRT_TERM_CD) AS CHG_AMT" ).append("\n"); 
		query.append("             , @[chg_comm_rt]" ).append("\n"); 
		query.append("             , @[chg_comm_otr_amt]" ).append("\n"); 
		query.append("             , @[chg_comm_curr_cd]" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(@[chg_comm_curr_cd], @[ofc_curr_cd], DECODE(@[pay_xch_rt] ,0, 0, (@[chg_comm_otr_amt] / @[pay_xch_rt]))" ).append("\n"); 
		query.append("                                                                   , (@[chg_comm_otr_amt] / DECODE(@[chg_comm_curr_cd], 'USD', 1, @[usd_xch_rt]))), 2), 0) AS COMM_AMT" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(@[chg_comm_curr_cd], @[ofc_curr_cd], @[chg_comm_otr_amt]" ).append("\n"); 
		query.append("                                                                   , (@[chg_comm_otr_amt] / DECODE(@[chg_comm_curr_cd], 'USD', 1, @[usd_xch_rt])) * @[pay_xch_rt]), 2), 0) AS PAY_COMM_AMT      " ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("        FROM BKG_TRF_SCG_RT P" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("        AND CHG_CD = @[comm_chg_cd] " ).append("\n"); 
		query.append("        AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("        AND FRT_TERM_CD = DECODE(@[chg_comm_pay_term_cd], 'T', FRT_TERM_CD, '', FRT_TERM_CD, @[chg_comm_pay_term_cd])" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif(${chg_comm_div_cd} == 'R')" ).append("\n"); 
		query.append("    #if(${chg_comm_rt} != '')" ).append("\n"); 
		query.append("        SELECT @[bkg_no]" ).append("\n"); 
		query.append("             , @[agn_cd]" ).append("\n"); 
		query.append("             , @[io_bnd_cd]" ).append("\n"); 
		query.append("             , @[ac_tp_cd]" ).append("\n"); 
		query.append("             , @[max_ac_seq]" ).append("\n"); 
		query.append("             , @[comm_chg_seq] + ROWNUM AS AC_CHG_SEQ" ).append("\n"); 
		query.append("             , Q.CHG_CD" ).append("\n"); 
		query.append("             , (SELECT CURR_CD " ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                AND CHG_CD = Q.CHG_CD" ).append("\n"); 
		query.append("                AND CURR_CD = Q.CURR_CD" ).append("\n"); 
		query.append("                AND RAT_UT_CD = Q.PER_TP_CD" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                AND FRT_TERM_CD = DECODE(P.IO_BND_CD, 'O', 'P', 'C')" ).append("\n"); 
		query.append("                GROUP BY CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("             , (SELECT RAT_UT_CD " ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                AND CHG_CD = Q.CHG_CD" ).append("\n"); 
		query.append("                AND CURR_CD = Q.CURR_CD" ).append("\n"); 
		query.append("                AND RAT_UT_CD = Q.PER_TP_CD" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                AND FRT_TERM_CD = DECODE(P.IO_BND_CD, 'O', 'P', 'C')" ).append("\n"); 
		query.append("                GROUP BY RAT_UT_CD) AS RAT_UT_CD" ).append("\n"); 
		query.append("             , (SELECT NVL(SUM(CHG_UT_AMT), 0) " ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                AND CHG_CD = Q.CHG_CD" ).append("\n"); 
		query.append("                AND CURR_CD = Q.CURR_CD" ).append("\n"); 
		query.append("                AND RAT_UT_CD = Q.PER_TP_CD" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                AND FRT_TERM_CD = DECODE(P.IO_BND_CD, 'O', 'P', 'C')) AS CHG_UT_AMT" ).append("\n"); 
		query.append("             , (SELECT NVL(SUM(CHG_AMT), 0) " ).append("\n"); 
		query.append("                FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                WHERE BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("                AND CHG_CD = Q.CHG_CD" ).append("\n"); 
		query.append("                AND CURR_CD = Q.CURR_CD" ).append("\n"); 
		query.append("                AND RAT_UT_CD = Q.PER_TP_CD" ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("                AND FRT_TERM_CD = DECODE(P.IO_BND_CD, 'O', 'P', 'C')) AS CHG_AMT" ).append("\n"); 
		query.append("             , @[chg_comm_rt]" ).append("\n"); 
		query.append("             , @[chg_comm_otr_amt]" ).append("\n"); 
		query.append("             , @[chg_comm_curr_cd]" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(Q.CURR_CD, @[ofc_curr_cd], DECODE(@[pay_xch_rt] ,0, 0, (Q.CHG_AMT * @[chg_comm_rt] / 100) / @[pay_xch_rt]) " ).append("\n"); 
		query.append("                                                         , (Q.CHG_AMT / DECODE(Q.CURR_CD, 'USD', 1, NVL(R.USD_LOCL_XCH_RT, 0))) * @[chg_comm_rt] / 100), 2), 0) AS COMM_AMT" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(Q.CURR_CD, @[ofc_curr_cd], (Q.CHG_AMT * @[chg_comm_rt] / 100)" ).append("\n"); 
		query.append("                                                         , ((Q.CHG_AMT / DECODE(Q.CURR_CD, 'USD', 1, NVL(R.USD_LOCL_XCH_RT, 0))) * @[chg_comm_rt] / 100) * @[pay_xch_rt]), 2), 0) AS PAY_COMM_AMT    " ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("        FROM INV_AR_MN P, " ).append("\n"); 
		query.append("             INV_AR_CHG Q," ).append("\n"); 
		query.append("             GL_MON_XCH_RT R" ).append("\n"); 
		query.append("        WHERE P.AR_IF_NO = Q.AR_IF_NO " ).append("\n"); 
		query.append("        AND P.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("        AND Q.CHG_CD = @[comm_chg_cd] " ).append("\n"); 
		query.append("        AND P.REV_TP_CD = 'M' " ).append("\n"); 
		query.append("        AND P.IO_BND_CD = DECODE(@[chg_comm_pay_term_cd], 'T', P.IO_BND_CD, '', P.IO_BND_CD, DECODE(@[chg_comm_pay_term_cd], 'P', 'O', 'I'))" ).append("\n"); 
		query.append("        AND Q.CURR_CD = R.CURR_CD" ).append("\n"); 
		query.append("        AND R.ACCT_XCH_RT_YRMON = DECODE(SIGN(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMM')) - TO_NUMBER(SUBSTR (@[sa_dt], 1, 6))), 1, SUBSTR (@[sa_dt], 1, 6),TO_CHAR(SYSDATE, 'YYYYMM')) " ).append("\n"); 
		query.append("        AND R.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("    #elseif(${chg_comm_otr_amt} != '')" ).append("\n"); 
		query.append("        SELECT @[bkg_no]" ).append("\n"); 
		query.append("             , @[agn_cd]" ).append("\n"); 
		query.append("             , @[io_bnd_cd]" ).append("\n"); 
		query.append("             , @[ac_tp_cd]" ).append("\n"); 
		query.append("             , @[max_ac_seq]" ).append("\n"); 
		query.append("             , @[comm_chg_seq] + ROWNUM AS AC_CHG_SEQ" ).append("\n"); 
		query.append("             , Q.CHG_CD" ).append("\n"); 
		query.append("             , Q.CURR_CD" ).append("\n"); 
		query.append("             , Q.PER_TP_CD" ).append("\n"); 
		query.append("             , Q.TRF_RT_AMT" ).append("\n"); 
		query.append("             , Q.CHG_AMT" ).append("\n"); 
		query.append("             , @[chg_comm_rt]" ).append("\n"); 
		query.append("             , @[chg_comm_otr_amt]" ).append("\n"); 
		query.append("             , @[chg_comm_curr_cd]" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(@[chg_comm_curr_cd], @[ofc_curr_cd], DECODE(@[pay_xch_rt] ,0, 0, (@[chg_comm_otr_amt] / @[pay_xch_rt]))" ).append("\n"); 
		query.append("                                                                   , (@[chg_comm_otr_amt] / DECODE(@[chg_comm_curr_cd], 'USD', 1, @[usd_xch_rt]))), 2), 0) AS COMM_AMT" ).append("\n"); 
		query.append("             , NVL(ROUND(DECODE(@[chg_comm_curr_cd], @[ofc_curr_cd], @[chg_comm_otr_amt]" ).append("\n"); 
		query.append("                                                                   , (@[chg_comm_otr_amt] / DECODE(@[chg_comm_curr_cd], 'USD', 1, @[usd_xch_rt])) * @[pay_xch_rt]), 2), 0) AS PAY_COMM_AMT   " ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("             , @[usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("        FROM INV_AR_MN P, " ).append("\n"); 
		query.append("             INV_AR_CHG Q" ).append("\n"); 
		query.append("        WHERE P.AR_IF_NO = Q.AR_IF_NO " ).append("\n"); 
		query.append("        AND P.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("        AND Q.CHG_CD = @[comm_chg_cd] " ).append("\n"); 
		query.append("        AND P.REV_TP_CD = 'M' " ).append("\n"); 
		query.append("        AND P.IO_BND_CD = DECODE(@[chg_comm_pay_term_cd], 'T', P.IO_BND_CD, '', P.IO_BND_CD, DECODE(@[chg_comm_pay_term_cd], 'P', 'O', 'I'))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}