/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchLineVendorPaymentNoDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.09
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.09 차상영
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

public class AccountPayablePaymentDBDAOSearchLineVendorPaymentNoDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayablePaymentDBDAOSearchLineVendorPaymentNoDupCheckRSQL
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchLineVendorPaymentNoDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchLineVendorPaymentNoDupCheckRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    COUNT(*) AS VALUE0" ).append("\n"); 
		query.append("FROM  SAP_INV_HDR SIH," ).append("\n"); 
		query.append("      SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("WHERE SIH.INV_SEQ = SPS.INV_SEQ" ).append("\n"); 
		query.append("AND SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND NVL(SIH.PAY_STS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(SPS.PAY_STS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(SPS.INV_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND SPS.PAY_BAT_RUN_SEQ IS NULL" ).append("\n"); 
		query.append("AND SIH.AP_APSTS_CD IN ('WFAPPROVED', 'NOT REQUIRED', 'MANUALLY APPROVED')" ).append("\n"); 
		query.append("AND SIH.INV_NO = @[inv_no]" ).append("\n"); 

	}
}