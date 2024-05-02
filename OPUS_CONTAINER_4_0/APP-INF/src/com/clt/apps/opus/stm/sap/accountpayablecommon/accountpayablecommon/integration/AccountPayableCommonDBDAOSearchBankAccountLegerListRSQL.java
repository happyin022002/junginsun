/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchBankAccountLegerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.21
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.21 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchBankAccountLegerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableCommonDBDAOSearchBankAccountLegerListRSQL
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchBankAccountLegerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchBankAccountLegerListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    A.BANK_ACCT_SEQ," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.ASET_CD_CMB_SEQ THEN A.ASET_CD_CMB_SEQ END) AS ASET_CD_CMB_SEQ," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.CHG_CD_CMB_SEQ THEN A.CHG_CD_CMB_SEQ END) AS CHG_CD_CMB_SEQ," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.GAIN_CD_CMB_SEQ THEN A.GAIN_CD_CMB_SEQ END) AS GAIN_CD_CMB_SEQ," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.LSS_CD_CMB_SEQ THEN A.LSS_CD_CMB_SEQ END) AS LSS_CD_CMB_SEQ," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.ASET_CD_CMB_SEQ THEN SGM_CTNT1 END) AS ASET_COA_CO_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.ASET_CD_CMB_SEQ THEN SGM_CTNT2 END) AS ASET_COA_RGN_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.ASET_CD_CMB_SEQ THEN SGM_CTNT3 END) AS ASET_COA_CTR_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.ASET_CD_CMB_SEQ THEN SGM_CTNT4 END) AS ASET_COA_ACCT_NO," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.ASET_CD_CMB_SEQ THEN SGM_CTNT5 END) AS ASET_COA_INTER_CO_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.ASET_CD_CMB_SEQ THEN SGM_CTNT6 END) AS ASET_COA_VVD_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.CHG_CD_CMB_SEQ THEN SGM_CTNT1 END) AS CHG_COA_CO_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.CHG_CD_CMB_SEQ THEN SGM_CTNT2 END) AS CHG_COA_RGN_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.CHG_CD_CMB_SEQ THEN SGM_CTNT3 END) AS CHG_COA_CTR_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.CHG_CD_CMB_SEQ THEN SGM_CTNT4 END) AS CHG_COA_ACCT_NO," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.CHG_CD_CMB_SEQ THEN SGM_CTNT5 END) AS CHG_COA_INTER_CO_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.CHG_CD_CMB_SEQ THEN SGM_CTNT6 END) AS CHG_COA_VVD_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.GAIN_CD_CMB_SEQ THEN SGM_CTNT1 END) AS GAIN_COA_CO_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.GAIN_CD_CMB_SEQ THEN SGM_CTNT2 END) AS GAIN_COA_RGN_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.GAIN_CD_CMB_SEQ THEN SGM_CTNT3 END) AS GAIN_COA_CTR_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.GAIN_CD_CMB_SEQ THEN SGM_CTNT4 END) AS GAIN_COA_ACCT_NO," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.GAIN_CD_CMB_SEQ THEN SGM_CTNT5 END) AS GAIN_COA_INTER_CO_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.GAIN_CD_CMB_SEQ THEN SGM_CTNT6 END) AS GAIN_COA_VVD_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.LSS_CD_CMB_SEQ THEN SGM_CTNT1 END) AS LSS_COA_CO_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.LSS_CD_CMB_SEQ THEN SGM_CTNT2 END) AS LSS_COA_RGN_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.LSS_CD_CMB_SEQ THEN SGM_CTNT3 END) AS LSS_COA_CTR_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.LSS_CD_CMB_SEQ THEN SGM_CTNT4 END) AS LSS_COA_ACCT_NO," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.LSS_CD_CMB_SEQ THEN SGM_CTNT5 END) AS LSS_COA_INTER_CO_CD," ).append("\n"); 
		query.append("    MAX(CASE WHEN B.CD_CMB_SEQ = A.LSS_CD_CMB_SEQ THEN SGM_CTNT6 END) AS LSS_COA_VVD_CD" ).append("\n"); 
		query.append("FROM SAP_BANK_ACCT A, SCO_LEGR_CD_CMB B" ).append("\n"); 
		query.append("WHERE A.BANK_ACCT_SEQ = @[bank_acct_seq]" ).append("\n"); 
		query.append("    AND B.CD_CMB_SEQ IN (A.ASET_CD_CMB_SEQ, A.CHG_CD_CMB_SEQ, A.GAIN_CD_CMB_SEQ, A.LSS_CD_CMB_SEQ)" ).append("\n"); 
		query.append("GROUP BY A.BANK_ACCT_SEQ" ).append("\n"); 

	}
}