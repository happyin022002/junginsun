/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataBatchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.22 
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

public class AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataBatchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP에서 SO 에 지불/취소된 정보를 전달하기 위한 정보 select (payment batch 에서 사용)
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataBatchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataBatchRSQL").append("\n"); 
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
		query.append("SELECT  SSI.INV_NO" ).append("\n"); 
		query.append("FROM    SAP_SEL_INV SSI" ).append("\n"); 
		query.append("      , SAP_INV_SEL_CRTE SISC" ).append("\n"); 
		query.append("WHERE   SSI.PAY_BAT_SEQ = SISC.PAY_BAT_SEQ" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_NM = SISC.PAY_BAT_NM " ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_SEQ = @[pay_bat_seq]" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_NM = @[pay_bat_nm]" ).append("\n"); 
		query.append("AND     SSI.VNDR_NO = @[vndr_no]                     " ).append("\n"); 
		query.append("    " ).append("\n"); 

	}
}