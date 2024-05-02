/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOSaveInvoiceAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.26 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSaveInvoiceAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRANSPORTATION S/O OFFICE CITY CODE 조회
	  * </pre>
	  */
	public InvoiceAuditDBDAOSaveInvoiceAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration ").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSaveInvoiceAuditRSQL").append("\n"); 
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
		query.append("SELECT TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD                             = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TRSP_SO_SEQ                                      = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND TRSP_WO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}