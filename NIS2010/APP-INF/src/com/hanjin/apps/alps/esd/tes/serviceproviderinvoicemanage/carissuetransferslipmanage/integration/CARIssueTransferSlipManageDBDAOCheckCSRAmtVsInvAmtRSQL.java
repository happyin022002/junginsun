/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCheckCSRAmtVsInvAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCheckCSRAmtVsInvAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckCSRAmtVsInvAmt
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCheckCSRAmtVsInvAmtRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCheckCSRAmtVsInvAmtRSQL").append("\n"); 
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
		query.append("SELECT DECODE(SIGN(H.CSR_AMT - SUM(ROUND(D.INV_AMT,2))),0,'Y','N') RETVAL" ).append("\n"); 
		query.append("FROM AP_INV_HDR H, AP_INV_DTRB D" ).append("\n"); 
		query.append("WHERE H.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND H.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("GROUP BY H.CSR_AMT " ).append("\n"); 

	}
}