/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOAddSarDistributionReceivableListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOAddSarDistributionReceivableListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAR_CLT_DTRB  테이블에 insert Receivable
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOAddSarDistributionReceivableListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rec_acct_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_crs_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_crs_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOAddSarDistributionReceivableListCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_CLT_DTRB" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	CLT_DTRB_SEQ," ).append("\n"); 
		query.append("	DTRB_SRC_SEQ," ).append("\n"); 
		query.append("	DTRB_SRC_TBL_CD," ).append("\n"); 
		query.append("	DTRB_SRC_TP_CD," ).append("\n"); 
		query.append("	DTRB_CD_CMB_SEQ," ).append("\n"); 
		query.append("	INP_DR_AMT," ).append("\n"); 
		query.append("	INP_CR_AMT," ).append("\n"); 
		query.append("	ACCT_DR_AMT," ).append("\n"); 
		query.append("	ACCT_CR_AMT," ).append("\n"); 
		query.append("	ORZ_SEQ," ).append("\n"); 
		query.append("	FM_DTRB_SRC_SEQ," ).append("\n"); 
		query.append("	CURR_CD," ).append("\n"); 
		query.append("	CONV_XCH_RT," ).append("\n"); 
		query.append("	ACCT_XCH_RT_LVL," ).append("\n"); 
		query.append("	ACCT_XCH_RT_DT," ).append("\n"); 
		query.append("	CUST_CNT_CD," ).append("\n"); 
		query.append("	CUST_SEQ," ).append("\n"); 
		query.append("	RVS_SRC_SEQ," ).append("\n"); 
		query.append("	FM_INP_DR_AMT," ).append("\n"); 
		query.append("	FM_INP_CR_AMT," ).append("\n"); 
		query.append("	FM_ACCT_DR_AMT," ).append("\n"); 
		query.append("	FM_ACCT_CR_AMT," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT, " ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	AR_IF_SEQ," ).append("\n"); 
		query.append("	AR_IF_STS_CD," ).append("\n"); 
		query.append("	AR_IF_ERR_DESC," ).append("\n"); 
		query.append("    GL_CURR_CD," ).append("\n"); 
		query.append("	GL_INP_DR_AMT," ).append("\n"); 
		query.append("	GL_INP_CR_AMT," ).append("\n"); 
		query.append("	GL_CONV_XCH_RT," ).append("\n"); 
		query.append("	GL_ACCT_DR_AMT," ).append("\n"); 
		query.append("	GL_ACCT_CR_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SAR_CLT_DTRB_SEQ.NEXTVAL    AS CLT_DTRB_SEQ" ).append("\n"); 
		query.append("     , @[adj_his_seq] AS DTRB_SRC_SEQ" ).append("\n"); 
		query.append("     , 'ADJ'          AS DTRB_SRC_TBL_CD" ).append("\n"); 
		query.append("     , SODR.ACCT_CLSS_CD   AS DTRB_SRC_TP_CD" ).append("\n"); 
		query.append("     , SODR.OTS_CD_CMB_SEQ AS DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("     , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') >= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[adj_amt], ',', ''))" ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') < 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS INP_DR_AMT" ).append("\n"); 
		query.append("     , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') > 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') <= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[adj_amt], ',', ''))" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS INP_CR_AMT" ).append("\n"); 
		query.append("     , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') >= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[rec_acct_amt], ',', ''))" ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') < 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS ACCT_DR_AMT" ).append("\n"); 
		query.append("     , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') > 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') <= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[rec_acct_amt], ',', ''))" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS ACCT_CR_AMT     " ).append("\n"); 
		query.append("     , -1                  AS ORZ_SEQ" ).append("\n"); 
		query.append("     , NULL                AS FM_DTRB_SRC_SEQ" ).append("\n"); 
		query.append("     , SODR.CURR_CD        AS CURR_CD" ).append("\n"); 
		query.append("     , ROUND(SODR.CONV_XCH_RT, 6)    AS CONV_XCH_RT" ).append("\n"); 
		query.append("     , SODR.ACCT_XCH_RT_LVL AS ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("     , SODR.ACCT_XCH_RT_DT  AS ACCT_XCH_RT_DT" ).append("\n"); 
		query.append("     , SOH.BIL_TO_CUST_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append("     , SOH.BIL_TO_CUST_SEQ    AS CUST_SEQ" ).append("\n"); 
		query.append("     , NULL                   AS RVS_SRC_SEQ" ).append("\n"); 
		query.append("     , NULL                   AS FM_INP_DR_AMT" ).append("\n"); 
		query.append("     , NULL                   AS FM_INP_CR_AMT" ).append("\n"); 
		query.append("     , NULL                   AS FM_ACCT_DR_AMT" ).append("\n"); 
		query.append("     , NULL                   AS FM_ACCT_CR_AMT" ).append("\n"); 
		query.append("     , @[cre_usr_id]          AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE                AS CRE_DT " ).append("\n"); 
		query.append("     , @[upd_usr_id]          AS UPD_USR_ID " ).append("\n"); 
		query.append("     , SYSDATE                AS UPD_DT" ).append("\n"); 
		query.append("	 , NULL" ).append("\n"); 
		query.append("     , 'P'" ).append("\n"); 
		query.append("     , NULL" ).append("\n"); 
		query.append("#if(${gl_crs_curr_cd} !=  '')  " ).append("\n"); 
		query.append("	 , @[gl_crs_curr_cd] AS GL_CURR_CD" ).append("\n"); 
		query.append("	 , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[gl_crs_curr_amt], ',', '') >= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[gl_crs_curr_amt], ',', ''))" ).append("\n"); 
		query.append("           WHEN REPLACE(@[gl_crs_curr_amt], ',', '') < 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("       END AS INP_DR_AMT" ).append("\n"); 
		query.append("     , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[gl_crs_curr_amt], ',', '') > 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("           WHEN REPLACE(@[gl_crs_curr_amt], ',', '') <= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[gl_crs_curr_amt], ',', ''))" ).append("\n"); 
		query.append("       END AS INP_CR_AMT" ).append("\n"); 
		query.append("     , ROUND(ABS(REPLACE(@[rec_acct_amt], ',', '')/@[gl_crs_curr_amt]), 6) AS GL_CONV_XCH_RT" ).append("\n"); 
		query.append("     , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[gl_crs_curr_amt], ',', '') >= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[rec_acct_amt], ',', ''))" ).append("\n"); 
		query.append("           WHEN REPLACE(@[gl_crs_curr_amt], ',', '') < 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS GL_ACCT_DR_AMT" ).append("\n"); 
		query.append("     , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[gl_crs_curr_amt], ',', '') > 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("           WHEN REPLACE(@[gl_crs_curr_amt], ',', '') <= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[rec_acct_amt], ',', ''))" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS GL_ACCT_CR_AMT       " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 , SODR.CURR_CD        AS GL_CURR_CD" ).append("\n"); 
		query.append("	 , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') >= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[adj_amt], ',', ''))" ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') < 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS GL_INP_DR_AMT" ).append("\n"); 
		query.append("     , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') > 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') <= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[adj_amt], ',', ''))" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS GL_INP_CR_AMT" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , ROUND(SODR.CONV_XCH_RT, 6) AS GL_CONV_XCH_RT    " ).append("\n"); 
		query.append("	 , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') >= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[rec_acct_amt], ',', ''))" ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') < 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS GL_ACCT_DR_AMT" ).append("\n"); 
		query.append("     , CASE " ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') > 0 THEN" ).append("\n"); 
		query.append("               NULL" ).append("\n"); 
		query.append("           WHEN REPLACE(@[adj_amt], ',', '') <= 0 THEN" ).append("\n"); 
		query.append("               ABS(REPLACE(@[rec_acct_amt], ',', ''))" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("         AS GL_ACCT_CR_AMT   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   SAR_OTS_HIS SOH," ).append("\n"); 
		query.append("       SAR_OTS_CHG SOC," ).append("\n"); 
		query.append("       SAR_OTS_DTRB SODR" ).append("\n"); 
		query.append("WHERE  SOH.OTS_HIS_SEQ = SOC.OTS_HIS_SEQ" ).append("\n"); 
		query.append("AND    SOC.OTS_HIS_SEQ = SODR.OTS_HIS_SEQ" ).append("\n"); 
		query.append("AND    SOC.CHG_TP_CD = SODR.CHG_TP_CD" ).append("\n"); 
		query.append("AND    SOC.OTS_HIS_SEQ = @[ots_his_seq]" ).append("\n"); 
		query.append("AND    SOC.CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("AND    SODR.ACCT_CLSS_CD = 'REC'" ).append("\n"); 

	}
}