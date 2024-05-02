/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchChkAutoInvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
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

public class InvoiceIssueDBDAOsearchChkAutoInvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchChkAutoInvRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchChkAutoInvRSQL(){
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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchChkAutoInvRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(AR_IF_NO), 0, 'N', 'Y') CHK_AUTOINV" ).append("\n"); 
		query.append("fROM   INV_AR_MN" ).append("\n"); 
		query.append("WHERE  AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND    BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("AND    BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND    INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("AND    INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("AND    REV_TP_CD = 'M'" ).append("\n"); 
		query.append("AND    REV_SRC_CD IN ('IV','IC')" ).append("\n"); 
		query.append("AND    USD_XCH_RT <> 0" ).append("\n"); 

	}
}