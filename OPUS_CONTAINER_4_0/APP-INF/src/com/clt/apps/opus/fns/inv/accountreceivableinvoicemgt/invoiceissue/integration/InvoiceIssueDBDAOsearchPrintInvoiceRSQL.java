/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchPrintInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearchPrintInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchPrintInvoiceRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchPrintInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_inv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_inv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchPrintInvoiceRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.INV_NO" ).append("\n"); 
		query.append("     , NVL(A.INV_ISS_CMB_FLG, 'N') INV_ISS_CMB_FLG" ).append("\n"); 
		query.append("     , C.IO_BND_CD IO_BND_CD" ).append("\n"); 
		query.append("     , A.ISS_GRP_TP_CD ISS_GRP_TP_CD" ).append("\n"); 
		query.append("  FROM INV_AR_ISS A" ).append("\n"); 
		query.append("     , INV_AR_ISS_DTL B" ).append("\n"); 
		query.append("     , INV_AR_MN C  " ).append("\n"); 
		query.append("#if (${flag} == 'S') " ).append("\n"); 
		query.append(" WHERE A.INV_NO IN (${invs})" ).append("\n"); 
		query.append("#elseif (${flag} == 'M') " ).append("\n"); 
		query.append(" WHERE A.INV_NO BETWEEN @[f_inv] AND @[t_inv]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   AND A.INV_SEQ = 1" ).append("\n"); 
		query.append("   AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("   AND B.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("   AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("   AND C.AR_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append(" ORDER BY A.INV_NO DESC" ).append("\n"); 

	}
}