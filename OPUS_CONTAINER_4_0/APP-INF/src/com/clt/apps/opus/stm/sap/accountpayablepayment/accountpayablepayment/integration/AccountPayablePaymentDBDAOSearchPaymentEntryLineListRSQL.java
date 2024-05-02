/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentEntryLineListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.25 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchPaymentEntryLineListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayablePaymentDBDAOSearchPaymentEntryLineListRSQL
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentEntryLineListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentEntryLineListRSQL").append("\n"); 
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
		query.append("SELECT SPD.INV_PAY_SEQ," ).append("\n"); 
		query.append("       SPD.PAY_SEQ," ).append("\n"); 
		query.append("       SIH.INV_NO," ).append("\n"); 
		query.append("       TO_CHAR(SIH.INV_DT,'YYYYMMDD') AS INV_DT," ).append("\n"); 
		query.append("       TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SIH.INV_AMT)) AS INV_AMT," ).append("\n"); 
		query.append("       TO_CHAR(SPD.ACCTG_DT,'YYYYMMDD') AS ACCTG_DT," ).append("\n"); 
		query.append("       SIH.INV_DESC," ).append("\n"); 
		query.append("       TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_PAY_CURR_CD, SPD.PAY_AMT)) AS PAY_AMT," ).append("\n"); 
		query.append("	   	SPD.PAY_FUNC_AMT," ).append("\n"); 
		query.append("        SPD.LIAB_CD_CMB_SEQ," ).append("\n"); 
		query.append("		SPD.XTER_BANK_ACCT_SEQ," ).append("\n"); 
		query.append("		SPD.REMIT_VNDR_NO," ).append("\n"); 
		query.append("		SPD.PAY_SKD_NO," ).append("\n"); 
		query.append("		SIH.INV_SEQ," ).append("\n"); 
		query.append("	   	'' AS USR_ID" ).append("\n"); 
		query.append("FROM SAP_INV_HDR SIH," ).append("\n"); 
		query.append("     SAP_PAY_HDR SPH, " ).append("\n"); 
		query.append("     SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("WHERE SPH.PAY_SEQ = SPD.PAY_SEQ" ).append("\n"); 
		query.append("AND  SIH.INV_SEQ = SPD.INV_SEQ" ).append("\n"); 
		query.append("AND SPD.PAY_SEQ = @[pay_seq]" ).append("\n"); 
		query.append("ORDER BY SPD.INV_PAY_SEQ ASC, SPD.PAY_SKD_NO ASC" ).append("\n"); 

	}
}