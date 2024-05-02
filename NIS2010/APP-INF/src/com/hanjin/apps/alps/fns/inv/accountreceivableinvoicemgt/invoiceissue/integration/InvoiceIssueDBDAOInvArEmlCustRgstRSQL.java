/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvArEmlCustRgstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvArEmlCustRgstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Seelect InvArEmlCustRgst
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvArEmlCustRgstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvArEmlCustRgstRSQL").append("\n"); 
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
		query.append("    A.AR_OFC_CD AR_OFC_CD," ).append("\n"); 
		query.append("    A.CUST_CNT_CD CUST_CNT_CD," ).append("\n"); 
		query.append("	LPAD(A.CUST_SEQ,6,0) CUST_SEQ," ).append("\n"); 
		query.append("    A.INV_EML_SPLIT_FLG INV_EML_SPLIT_FLG," ).append("\n"); 
		query.append("    A.CUST_RMK CUST_RMK," ).append("\n"); 
		query.append("    A.UPD_USR_ID UPD_USR_ID," ).append("\n"); 
		query.append("    B.CUST_LGL_ENG_NM CUST_NM " ).append("\n"); 
		query.append("FROM     " ).append("\n"); 
		query.append("(SELECT " ).append("\n"); 
		query.append("	AR_OFC_CD," ).append("\n"); 
		query.append("	CUST_CNT_CD," ).append("\n"); 
		query.append("	CUST_SEQ," ).append("\n"); 
		query.append("	INV_EML_SPLIT_FLG," ).append("\n"); 
		query.append("	CUST_RMK," ).append("\n"); 
		query.append("	UPD_USR_ID" ).append("\n"); 
		query.append("FROM  INV_AR_EML_CUST_RGST " ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("	WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")A ,MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 

	}
}