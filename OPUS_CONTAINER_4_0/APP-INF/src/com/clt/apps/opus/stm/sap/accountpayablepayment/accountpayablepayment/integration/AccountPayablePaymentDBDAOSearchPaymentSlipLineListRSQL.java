/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentSlipLineListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchPaymentSlipLineListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0070 (Payments Slip) - inquiry Query
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentSlipLineListRSQL(){
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
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentSlipLineListRSQL").append("\n"); 
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
		query.append("SELECT SPD.PAY_SEQ, " ).append("\n"); 
		query.append("       TO_CHAR(SPD.ACCTG_DT,'YYYY-MM-DD') AS GL_DT," ).append("\n"); 
		query.append("       NVL(ACCTG_PST_FLG,'N') AS POST," ).append("\n"); 
		query.append("       TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_PAY_CURR_CD, SPD.PAY_AMT)) AS PAY_AMT," ).append("\n"); 
		query.append("       SIH.INV_NO," ).append("\n"); 
		query.append("       SIH.INV_TP_LU_CD," ).append("\n"); 
		query.append("       TO_CHAR(SIH.INV_DT,'YYYY-MM-DD') AS INV_DT," ).append("\n"); 
		query.append("       SPH.CURR_CD," ).append("\n"); 
		query.append("       TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SIH.INV_AMT)) AS INV_AMT," ).append("\n"); 
		query.append("       SIH.INV_DESC" ).append("\n"); 
		query.append("FROM SAP_INV_HDR SIH," ).append("\n"); 
		query.append("     SAP_PAY_HDR SPH, " ).append("\n"); 
		query.append("     SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("WHERE SPH.PAY_SEQ = SPD.PAY_SEQ" ).append("\n"); 
		query.append("AND SIH.INV_SEQ = SPD.INV_SEQ" ).append("\n"); 
		query.append("AND SPD.PAY_SEQ = @[pay_seq]" ).append("\n"); 

	}
}