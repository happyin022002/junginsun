/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ApprovalDBDAOsearchInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOsearchInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ApprovalDBDAOsearchInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOsearchInvoiceRSQL").append("\n"); 
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
		query.append("SELECT COUNT(INV_NO) CNT" ).append("\n"); 
		query.append("  FROM TRS_TRSP_INV_WRK_HIS" ).append("\n"); 
		query.append(" WHERE USR_EVNT_TP_CD ='D'" ).append("\n"); 
		query.append("   AND HJL_INV_AUD_STS_CD='SV'" ).append("\n"); 
		query.append("   AND INV_NO IN (SELECT ATTR_CTNT1 FROM AP_INV_DTRB WHERE CSR_NO = (@[csr_no]))" ).append("\n"); 

	}
}