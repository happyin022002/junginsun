/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchFindPrepaymentLineCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchFindPrepaymentLineCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFindPrepaymentLineCheck
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchFindPrepaymentLineCheckRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchFindPrepaymentLineCheckRSQL").append("\n"); 
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
		query.append("SELECT  SID.INV_SEQ, SID.DTRB_LINE_NO, SID.DTRB_AMT, NVL(SID.PPAY_RMN_AMT, SID.DTRB_AMT) APPLY_AMT" ).append("\n"); 
		query.append("FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("WHERE   SID.INV_SEQ = TO_NUMBER(@[inv_seq])" ).append("\n"); 
		query.append("AND     SID.LINE_TP_LU_CD IN ('ITEM', 'ACCRUAL', 'REC_TAX', 'NONREC_TAX')" ).append("\n"); 
		query.append("AND     NVL(SID.RVS_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("ORDER   BY SID.DTRB_LINE_NO" ).append("\n"); 

	}
}