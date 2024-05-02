/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingPaymentCancelLineCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : ORKIM
*@LastVersion : 1.0
* 2014.05.20 ORKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ORKIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchAccountingPaymentCancelLineCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccountingPaymentCancelLineCheck
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingPaymentCancelLineCheckRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingPaymentCancelLineCheckRSQL").append("\n"); 
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
		query.append("      SELECT  SPD.INV_PAY_SEQ AS INV_PAY_SEQ" ).append("\n"); 
		query.append("            , SPD.INV_SEQ     AS INV_SEQ" ).append("\n"); 
		query.append("      FROM    SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("      WHERE   NVL(SPD.ACCTG_PST_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND     SPD.PRNT_RVS_INV_PAY_SEQ IS NOT NULL" ).append("\n"); 
		query.append("      AND     NVL(SPD.RVS_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("      AND     SPD.PAY_SEQ = @[pay_seq]" ).append("\n"); 
		query.append("      ORDER   BY SPD.INV_PAY_SEQ " ).append("\n"); 

	}
}