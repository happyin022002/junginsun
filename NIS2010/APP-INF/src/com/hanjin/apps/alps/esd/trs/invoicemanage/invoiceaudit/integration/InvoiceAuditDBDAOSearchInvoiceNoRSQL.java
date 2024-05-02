/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.07.28 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceNo 조회
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceNoRSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_svc_provider",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(A.INV_NO) INV_FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT INV_NO" ).append("\n"); 
		query.append(", INV_VNDR_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("WHERE HJL_NO IS NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT INV_NO" ).append("\n"); 
		query.append(", INV_VNDR_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.INV_NO  = @[inv_no]" ).append("\n"); 
		query.append("AND A.INV_VNDR_SEQ = @[combo_svc_provider]" ).append("\n"); 

	}
}