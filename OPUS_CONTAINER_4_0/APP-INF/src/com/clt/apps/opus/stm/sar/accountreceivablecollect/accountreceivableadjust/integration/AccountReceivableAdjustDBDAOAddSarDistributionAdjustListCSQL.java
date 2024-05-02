/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOAddSarDistributionAdjustListCSQL.java
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

public class AccountReceivableAdjustDBDAOAddSarDistributionAdjustListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAR_CLT_DTRB  테이블에 insert Adjust
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOAddSarDistributionAdjustListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_prcs_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("func_curr_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOAddSarDistributionAdjustListCSQL").append("\n"); 
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
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	AR_IF_SEQ," ).append("\n"); 
		query.append("	AR_IF_STS_CD," ).append("\n"); 
		query.append("	AR_IF_ERR_DESC," ).append("\n"); 
		query.append("	GL_INP_DR_AMT," ).append("\n"); 
		query.append("    GL_INP_CR_AMT," ).append("\n"); 
		query.append("	GL_CONV_XCH_RT," ).append("\n"); 
		query.append(" 	GL_ACCT_DR_AMT,	" ).append("\n"); 
		query.append("	GL_ACCT_CR_AMT," ).append("\n"); 
		query.append("    GL_CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    SAR_CLT_DTRB_SEQ.NEXTVAL    AS CLT_DTRB_SEQ," ).append("\n"); 
		query.append("    DTRB_SRC_SEQ," ).append("\n"); 
		query.append("    DTRB_SRC_TBL_CD," ).append("\n"); 
		query.append("    DTRB_SRC_TP_CD," ).append("\n"); 
		query.append("    DTRB_CD_CMB_SEQ," ).append("\n"); 
		query.append("    INP_DR_AMT," ).append("\n"); 
		query.append("    INP_CR_AMT," ).append("\n"); 
		query.append("    ACCT_DR_AMT," ).append("\n"); 
		query.append("    ACCT_CR_AMT," ).append("\n"); 
		query.append("    ORZ_SEQ," ).append("\n"); 
		query.append("    FM_DTRB_SRC_SEQ," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    CONV_XCH_RT," ).append("\n"); 
		query.append("    ACCT_XCH_RT_LVL," ).append("\n"); 
		query.append("    ACCT_XCH_RT_DT," ).append("\n"); 
		query.append("    CUST_CNT_CD," ).append("\n"); 
		query.append("    CUST_SEQ," ).append("\n"); 
		query.append("    RVS_SRC_SEQ," ).append("\n"); 
		query.append("    FM_INP_DR_AMT," ).append("\n"); 
		query.append("    FM_INP_CR_AMT," ).append("\n"); 
		query.append("    FM_ACCT_DR_AMT," ).append("\n"); 
		query.append("    FM_ACCT_CR_AMT," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    NULL," ).append("\n"); 
		query.append("    'P'," ).append("\n"); 
		query.append("    NULL," ).append("\n"); 
		query.append("    GL_INP_DR_AMT," ).append("\n"); 
		query.append("    GL_INP_CR_AMT," ).append("\n"); 
		query.append("    GL_CONV_XCH_RT," ).append("\n"); 
		query.append("    GL_ACCT_DR_AMT," ).append("\n"); 
		query.append("    GL_ACCT_CR_AMT," ).append("\n"); 
		query.append("    GL_CURR_CD" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    @[adj_his_seq]  AS DTRB_SRC_SEQ," ).append("\n"); 
		query.append("    'ADJ' AS DTRB_SRC_TBL_CD," ).append("\n"); 
		query.append("    'ADJ' AS DTRB_SRC_TP_CD," ).append("\n"); 
		query.append("    @[cd_cmb_seq] AS DTRB_CD_CMB_SEQ," ).append("\n"); 
		query.append("    CASE WHEN A.ADJ_AMT < 0 THEN ABS(A.ADJ_AMT)" ).append("\n"); 
		query.append("    END AS INP_DR_AMT," ).append("\n"); 
		query.append("    CASE WHEN A.ADJ_AMT > 0 THEN ABS(A.ADJ_AMT)" ).append("\n"); 
		query.append("    END AS INP_CR_AMT," ).append("\n"); 
		query.append("    CASE WHEN A.ADJ_AMT < 0 THEN ROUND(ABS(A.ADJ_AMT) * @[func_curr_rt], @[dp_prcs_knt])" ).append("\n"); 
		query.append("    END AS ACCT_DR_AMT," ).append("\n"); 
		query.append("    CASE WHEN A.ADJ_AMT > 0 THEN ROUND(ABS(A.ADJ_AMT) * @[func_curr_rt], @[dp_prcs_knt])" ).append("\n"); 
		query.append("    END AS ACCT_CR_AMT," ).append("\n"); 
		query.append("    '-1' AS ORZ_SEQ," ).append("\n"); 
		query.append("    '' AS FM_DTRB_SRC_SEQ," ).append("\n"); 
		query.append("    @[bl_curr_cd] AS CURR_CD," ).append("\n"); 
		query.append("    @[func_curr_rt] AS CONV_XCH_RT," ).append("\n"); 
		query.append("    '1' AS ACCT_XCH_RT_LVL," ).append("\n"); 
		query.append("    REPLACE(@[adj_dt], '-', '') AS ACCT_XCH_RT_DT," ).append("\n"); 
		query.append("    SOH.BIL_TO_CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("    SOH.BIL_TO_CUST_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("     CASE WHEN A.ADJ_STS_CD = 'REVERSE' THEN (SELECT B.ADJ_HIS_SEQ FROM SAR_ADJ_HIS B WHERE A.ADJ_NO = B.ADJ_NO AND A.ADJ_HIS_SEQ <> B.ADJ_HIS_SEQ AND A.CHG_TP_CD = @[chg_tp_cd])" ).append("\n"); 
		query.append("     END AS RVS_SRC_SEQ," ).append("\n"); 
		query.append("     '' AS FM_INP_DR_AMT," ).append("\n"); 
		query.append("     '' AS FM_INP_CR_AMT," ).append("\n"); 
		query.append("     '' AS FM_ACCT_DR_AMT," ).append("\n"); 
		query.append("     '' AS FM_ACCT_CR_AMT," ).append("\n"); 
		query.append("     A.CRE_USR_ID AS CRE_USR_ID," ).append("\n"); 
		query.append("     SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("     A.UPD_USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("     SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("#if(${gl_curr_cd} !=  '')  " ).append("\n"); 
		query.append("     CASE WHEN A.GL_CRS_CURR_AMT < 0 THEN ABS(A.GL_CRS_CURR_AMT)" ).append("\n"); 
		query.append("        END AS GL_INP_DR_AMT," ).append("\n"); 
		query.append("     CASE WHEN A.GL_CRS_CURR_AMT > 0 THEN ABS(A.GL_CRS_CURR_AMT)" ).append("\n"); 
		query.append("        END AS GL_INP_CR_AMT,  " ).append("\n"); 
		query.append("     A.GL_CRS_EX_RATE AS GL_CONV_XCH_RT," ).append("\n"); 
		query.append("     CASE WHEN A.GL_CRS_CURR_AMT < 0 THEN " ).append("\n"); 
		query.append("    	ROUND(ABS(A.GL_CRS_CURR_AMT) * A.GL_CRS_EX_RATE, @[dp_prcs_knt])" ).append("\n"); 
		query.append("     END AS GL_ACCT_DR_AMT," ).append("\n"); 
		query.append("     CASE WHEN A.GL_CRS_CURR_AMT > 0 THEN " ).append("\n"); 
		query.append("        ROUND(ABS(A.GL_CRS_CURR_AMT) * A.GL_CRS_EX_RATE, @[dp_prcs_knt])" ).append("\n"); 
		query.append("     END AS GL_ACCT_CR_AMT," ).append("\n"); 
		query.append("     A.GL_CRS_CURR_CD AS GL_CURR_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    CASE WHEN A.ADJ_AMT < 0 THEN ABS(A.ADJ_AMT)" ).append("\n"); 
		query.append("    END AS GL_INP_DR_AMT," ).append("\n"); 
		query.append("    CASE WHEN A.ADJ_AMT > 0 THEN ABS(A.ADJ_AMT)" ).append("\n"); 
		query.append("    END AS GL_INP_CR_AMT," ).append("\n"); 
		query.append("    @[func_curr_rt] AS GL_CONV_XCH_RT," ).append("\n"); 
		query.append("	CASE WHEN A.ADJ_AMT < 0 THEN ROUND(ABS(A.ADJ_AMT) * @[func_curr_rt], @[dp_prcs_knt])" ).append("\n"); 
		query.append("    END AS GL_ACCT_DR_AMT," ).append("\n"); 
		query.append("    CASE WHEN A.ADJ_AMT > 0 THEN ROUND(ABS(A.ADJ_AMT) * @[func_curr_rt], @[dp_prcs_knt])" ).append("\n"); 
		query.append("    END AS GL_ACCT_CR_AMT," ).append("\n"); 
		query.append("    @[bl_curr_cd] AS GL_CURR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    SAR_ADJ_HIS A" ).append("\n"); 
		query.append("    , SAR_OTS_HIS SOH" ).append("\n"); 
		query.append("    , SAR_OTS_CHG SOC" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND ADJ_HIS_SEQ = @[adj_his_seq]" ).append("\n"); 
		query.append("AND SOC.CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("AND A.OTS_HIS_SEQ = SOC.OTS_HIS_SEQ" ).append("\n"); 
		query.append("AND SOH.OTS_HIS_SEQ = SOC.OTS_HIS_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}