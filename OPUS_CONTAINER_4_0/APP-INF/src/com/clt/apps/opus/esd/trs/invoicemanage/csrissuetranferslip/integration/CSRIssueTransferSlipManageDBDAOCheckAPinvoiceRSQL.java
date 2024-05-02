/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCheckAPinvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.03.03 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCheckAPinvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Office의 AP Office 존재유무를 조회하는 SQL
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCheckAPinvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCheckAPinvoiceRSQL").append("\n"); 
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
		query.append("SELECT NVL(AP_OFC_CD, 'N') AS AP_OFC_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append(" WHERE OFC_CD = @[cost_ofc_cd]" ).append("\n"); 

	}
}