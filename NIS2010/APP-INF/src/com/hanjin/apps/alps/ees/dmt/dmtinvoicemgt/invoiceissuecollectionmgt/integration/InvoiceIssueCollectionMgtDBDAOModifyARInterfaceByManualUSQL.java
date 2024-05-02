/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOModifyARInterfaceByManualUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOModifyARInterfaceByManualUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOModifyARInterfaceByManualUSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOModifyARInterfaceByManualUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOModifyARInterfaceByManualUSQL").append("\n"); 
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
		query.append("UPDATE  DMT_INV_MN" ).append("\n"); 
		query.append("   SET  AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("       ,AR_IF_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD), SYSDATE)" ).append("\n"); 
		query.append(" WHERE  DMDT_INV_NO = @[invoice_no]" ).append("\n"); 

	}
}