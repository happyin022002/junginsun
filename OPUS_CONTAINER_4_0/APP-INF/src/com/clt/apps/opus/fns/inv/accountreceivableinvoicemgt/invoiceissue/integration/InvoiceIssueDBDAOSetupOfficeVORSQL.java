/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOSetupOfficeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.01.07 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Han Dong Hoon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSetupOfficeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SetupOfficeVO
	  * </pre>
	  */
	public InvoiceIssueDBDAOSetupOfficeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSetupOfficeVORSQL").append("\n"); 
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
		query.append("SELECT  INV_MLT_BL_ISS_FLG" ).append("\n"); 
		query.append(",INV_DUP_FLG" ).append("\n"); 
		query.append(",OTS_SMRY_CD" ).append("\n"); 
		query.append(",INV_ISS_TP_CD" ).append("\n"); 
		query.append("FROM	INV_AR_STUP_OFC" ).append("\n"); 
		query.append("WHERE	AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}