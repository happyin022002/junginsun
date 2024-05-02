/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOAddSarDtrbForRvsListCSQL.java
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

public class AccountReceivableAdjustDBDAOAddSarDtrbForRvsListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Save SAR Distribution For REVERSE
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOAddSarDtrbForRvsListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("adj_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_adj_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOAddSarDtrbForRvsListCSQL").append("\n"); 
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
		query.append("    GL_INP_DR_AMT," ).append("\n"); 
		query.append("    GL_INP_CR_AMT," ).append("\n"); 
		query.append("    GL_CONV_XCH_RT," ).append("\n"); 
		query.append("    GL_ACCT_DR_AMT," ).append("\n"); 
		query.append("    GL_ACCT_CR_AMT," ).append("\n"); 
		query.append("    GL_CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    SAR_CLT_DTRB_SEQ.NEXTVAL    AS CLT_DTRB_SEQ," ).append("\n"); 
		query.append("    @[adj_his_seq] AS DTRB_SRC_SEQ," ).append("\n"); 
		query.append("    DTRB_SRC_TBL_CD," ).append("\n"); 
		query.append("    DTRB_SRC_TP_CD," ).append("\n"); 
		query.append("    DTRB_CD_CMB_SEQ," ).append("\n"); 
		query.append("    INP_CR_AMT AS INP_DR_AMT," ).append("\n"); 
		query.append("    INP_DR_AMT AS INP_CR_AMT,  " ).append("\n"); 
		query.append("    ACCT_CR_AMT AS ACCT_DR_AMT,  " ).append("\n"); 
		query.append("    ACCT_DR_AMT AS ACCT_CR_AMT,    " ).append("\n"); 
		query.append("    ORZ_SEQ," ).append("\n"); 
		query.append("    FM_DTRB_SRC_SEQ," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    CONV_XCH_RT," ).append("\n"); 
		query.append("    ACCT_XCH_RT_LVL," ).append("\n"); 
		query.append("    ACCT_XCH_RT_DT," ).append("\n"); 
		query.append("    CUST_CNT_CD," ).append("\n"); 
		query.append("    CUST_SEQ," ).append("\n"); 
		query.append("    @[org_adj_his_seq] AS RVS_SRC_SEQ," ).append("\n"); 
		query.append("    FM_INP_DR_AMT," ).append("\n"); 
		query.append("    FM_INP_CR_AMT," ).append("\n"); 
		query.append("    FM_ACCT_DR_AMT," ).append("\n"); 
		query.append("    FM_ACCT_CR_AMT," ).append("\n"); 
		query.append("    @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    @[upd_usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("	NULL," ).append("\n"); 
		query.append("    'P'," ).append("\n"); 
		query.append("    NULL," ).append("\n"); 
		query.append("    GL_INP_CR_AMT AS GL_INP_DR_AMT," ).append("\n"); 
		query.append("    GL_INP_DR_AMT AS GL_INP_CR_AMT," ).append("\n"); 
		query.append("    GL_CONV_XCH_RT," ).append("\n"); 
		query.append("    GL_ACCT_CR_AMT AS GL_ACCT_DR_AMT," ).append("\n"); 
		query.append("    GL_ACCT_DR_AMT AS GL_ACCT_CR_AMT," ).append("\n"); 
		query.append("    GL_CURR_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    SAR_CLT_DTRB" ).append("\n"); 
		query.append("WHERE DTRB_SRC_SEQ = @[org_adj_his_seq]" ).append("\n"); 
		query.append("AND   DTRB_SRC_TBL_CD = 'ADJ'  " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}