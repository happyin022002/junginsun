/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueDBDAOModifyIDAGstAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOModifyIDAGstAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify IDA Gst Amt
	  * </pre>
	  */
	public InvoiceIssueDBDAOModifyIDAGstAmtUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOModifyIDAGstAmtUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_SPLIT_ISS_CHG   " ).append("\n"); 
		query.append("SET IDA_CGST_AMT = ROUND(ROUND(CHG_AMT * INV_XCH_RT, 2) * IDA_CGST_RTO / 100, 2)" ).append("\n"); 
		query.append("  , IDA_SGST_AMT = ROUND(ROUND(CHG_AMT * INV_XCH_RT, 2) * IDA_SGST_RTO / 100, 2)" ).append("\n"); 
		query.append("  , IDA_IGST_AMT = ROUND(ROUND(CHG_AMT * INV_XCH_RT, 2) * IDA_IGST_RTO / 100, 2)" ).append("\n"); 
		query.append("  , IDA_UGST_AMT = ROUND(ROUND(CHG_AMT * INV_XCH_RT, 2) * IDA_UGST_RTO / 100, 2)" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}