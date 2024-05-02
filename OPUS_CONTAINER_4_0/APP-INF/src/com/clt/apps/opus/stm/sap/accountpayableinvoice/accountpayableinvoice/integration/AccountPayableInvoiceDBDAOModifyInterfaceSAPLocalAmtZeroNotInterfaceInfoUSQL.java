/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyInterfaceSAPLocalAmtZeroNotInterfaceInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOModifyInterfaceSAPLocalAmtZeroNotInterfaceInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAKURA로 I/F 처리 할 내역중 Entered 금액이 작아 환율 적용한 Local Amount가 0이 되는 경우에는 해당 Row을 Sakura로 I/F 처리 할 수 없도록 하기 위해서 I/F Flag을 변경 처리
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyInterfaceSAPLocalAmtZeroNotInterfaceInfoUSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyInterfaceSAPLocalAmtZeroNotInterfaceInfoUSQL").append("\n"); 
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
		query.append("UPDATE SAP_AP_IF SAI" ).append("\n"); 
		query.append("SET    SAI.IF_FLG = 'T'" ).append("\n"); 
		query.append("     , SAI.IF_FILE_ID = 'THIS IS PASS DATA OF ZERO LOCAL AMOUNT'" ).append("\n"); 
		query.append("WHERE  SAI.REF_DOC_NO = @[csr_no]" ).append("\n"); 
		query.append("AND    SAI.DOC_AMT <> 0" ).append("\n"); 
		query.append("AND    SAI.LOCL_AMT = 0" ).append("\n"); 

	}
}