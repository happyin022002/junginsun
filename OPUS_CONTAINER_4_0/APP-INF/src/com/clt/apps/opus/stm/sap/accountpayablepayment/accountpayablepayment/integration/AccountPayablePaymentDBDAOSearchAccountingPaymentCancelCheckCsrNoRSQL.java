/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingPaymentCancelCheckCsrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchAccountingPaymentCancelCheckCsrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccountingPaymentCancelCheckCsrNo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingPaymentCancelCheckCsrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingPaymentCancelCheckCsrNoRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT SPH.PAY_SEQ   AS PAY_SEQ" ).append("\n"); 
		query.append("FROM    SAP_PAY_HDR SPH" ).append("\n"); 
		query.append("      , SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("      , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("WHERE   SPH.PAY_SEQ = SPD.PAY_SEQ" ).append("\n"); 
		query.append("AND     SPD.INV_SEQ = SIH.INV_SEQ" ).append("\n"); 
		query.append("AND     SIH.INV_NO  = @[csr_no]" ).append("\n"); 
		query.append("AND     NVL(SPD.ACCTG_PST_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND     NVL(SPD.RVS_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("AND     SPD.PRNT_RVS_INV_PAY_SEQ IS NOT NULL" ).append("\n"); 

	}
}