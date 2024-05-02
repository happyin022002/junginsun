/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorSacIfDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.08.25 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorSacIfDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR cancel시 AP_REJECTED일 경우에 SAC_TRSP_ESTM_ACT_IF  delete
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorSacIfDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorSacIfDSQL").append("\n"); 
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
		query.append("DELETE FROM SAC_TRSP_ESTM_ACT_IF" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CSR_NO = @[CSR_NO]" ).append("\n"); 
		query.append("   AND ESTM_ACT_DIV_CD = 'A'" ).append("\n"); 
		query.append("   AND EXISTS (SELECT * " ).append("\n"); 
		query.append("                 FROM AP_INV_HDR " ).append("\n"); 
		query.append("                WHERE CSR_NO = @[CSR_NO] " ).append("\n"); 
		query.append("                  AND IF_FLG = 'Y' " ).append("\n"); 
		query.append("                  AND RCV_ERR_FLG = 'E')" ).append("\n"); 

	}
}