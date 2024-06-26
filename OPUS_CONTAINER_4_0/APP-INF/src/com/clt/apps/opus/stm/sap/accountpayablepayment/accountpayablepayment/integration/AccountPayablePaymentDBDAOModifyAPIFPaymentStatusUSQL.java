/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOModifyAPIFPaymentStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
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

public class AccountPayablePaymentDBDAOModifyAPIFPaymentStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAPIFPaymentStatus
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOModifyAPIFPaymentStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dat_rslt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOModifyAPIFPaymentStatusUSQL").append("\n"); 
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
		query.append("UPDATE  SAP_AP_PAY_IF" ).append("\n"); 
		query.append("SET     DAT_PROC_FLG = 'Y'" ).append("\n"); 
		query.append("      , DAT_SLCT_FLG = 'Y'" ).append("\n"); 
		query.append("      , DAT_SLCT_DT = SYSDATE" ).append("\n"); 
		query.append("      , DAT_RSLT_FLG = @[dat_rslt_flg]" ).append("\n"); 
		query.append("      , DAT_RSLT_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE   REF_DOC_NO = @[csr_no]" ).append("\n"); 
		query.append("AND     PAY_STS_IF_SEQ = @[pay_if_seq]" ).append("\n"); 

	}
}