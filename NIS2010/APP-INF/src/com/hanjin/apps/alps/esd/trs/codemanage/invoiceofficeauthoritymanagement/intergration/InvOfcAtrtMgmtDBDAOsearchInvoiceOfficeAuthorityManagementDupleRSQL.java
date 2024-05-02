/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvOfcAtrtMgmtDBDAOsearchInvoiceOfficeAuthorityManagementDupleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.09
*@LastModifier : YOO Sunoh
*@LastVersion : 1.0
* 2011.11.09 YOO Sunoh
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.invoiceofficeauthoritymanagement.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOO Sunoh
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvOfcAtrtMgmtDBDAOsearchInvoiceOfficeAuthorityManagementDupleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Primay Key 중복체크 처리하는  sql
	  * </pre>
	  */
	public InvOfcAtrtMgmtDBDAOsearchInvoiceOfficeAuthorityManagementDupleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.invoiceofficeauthoritymanagement.intergration").append("\n"); 
		query.append("FileName : InvOfcAtrtMgmtDBDAOsearchInvoiceOfficeAuthorityManagementDupleRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_OFC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND inv_ofc_cd = @[inv_ofc_cd]" ).append("\n"); 
		query.append("AND ofc_cd = @[ofc_cd]" ).append("\n"); 

	}
}