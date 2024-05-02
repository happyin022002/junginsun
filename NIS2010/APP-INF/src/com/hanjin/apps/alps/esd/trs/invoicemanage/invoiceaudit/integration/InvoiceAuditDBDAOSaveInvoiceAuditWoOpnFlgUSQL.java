/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InvoiceAuditDBDAOSaveInvoiceAuditWoOpnFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSaveInvoiceAuditWoOpnFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPP에서 조회 가능하도록 WORK ORDER OPEN FLAG를 'Y'로 수정
	  * </pre>
	  */
	public InvoiceAuditDBDAOSaveInvoiceAuditWoOpnFlgUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSaveInvoiceAuditWoOpnFlgUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD SET		           " ).append("\n"); 
		query.append("WO_OPN_FLG= 'Y'," ).append("\n"); 
		query.append("UPD_USR_ID = @[FORM_CRE_USR_ID]                             " ).append("\n"); 
		query.append("WHERE                                             " ).append("\n"); 
		query.append("TRSP_WO_SEQ	= 	                           " ).append("\n"); 
		query.append("( SELECT 			                   " ).append("\n"); 
		query.append("	TRSP_WO_SEQ	                           " ).append("\n"); 
		query.append("  FROM                                            " ).append("\n"); 
		query.append("	TRS_TRSP_SVC_ORD			   " ).append("\n"); 
		query.append("  WHERE 			                   " ).append("\n"); 
		query.append("	TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] " ).append("\n"); 
		query.append("  AND 	TRSP_SO_SEQ	   = @[trsp_so_seq]	   " ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}