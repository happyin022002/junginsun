/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceASACloseStatusCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.21 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceASACloseStatusCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceASACloseStatusCheck - Cancel처리시 ASA Close여부 체크
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceASACloseStatusCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceASACloseStatusCheckRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN SIH.INV_AMT = 0 AND SIH.ATTR_CATE_NM = 'INVOICES' AND SIH.INV_CXL_DT IS NULL AND SAM.ASA_FSH_DT IS NULL THEN 'Y' " ).append("\n"); 
		query.append("             WHEN SIH.INV_AMT = 0 AND SIH.ATTR_CATE_NM = 'INVOICES' AND SIH.INV_CXL_DT IS NULL AND SAM.ASA_FSH_DT IS NOT NULL THEN 'N' " ).append("\n"); 
		query.append("             ELSE 'Y' " ).append("\n"); 
		query.append("        END AS ASA_STATUS_FLAG" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAR_ASA_MST SAM" ).append("\n"); 
		query.append("WHERE   SIH.ATTR_CTNT2 = SAM.ASA_NO(+)" ).append("\n"); 
		query.append("AND     SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}