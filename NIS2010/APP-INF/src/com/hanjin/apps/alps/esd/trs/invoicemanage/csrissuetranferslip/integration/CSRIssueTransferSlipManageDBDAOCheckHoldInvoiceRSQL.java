/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCheckHoldInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2011.12.26 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCheckHoldInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckHoldInvoice
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCheckHoldInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCheckHoldInvoiceRSQL").append("\n"); 
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
		query.append("SELECT NVL(TRS_JOIN_FNC(CURSOR(SELECT INV_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($inv_no.size() > 0)" ).append("\n"); 
		query.append("AND INV_NO IN (" ).append("\n"); 
		query.append("#foreach($key IN ${inv_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($inv_vndr_seq.size() > 0)" ).append("\n"); 
		query.append("AND INV_VNDR_SEQ IN (" ).append("\n"); 
		query.append("#foreach($key IN ${inv_vndr_seq})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NVL(INV_HLD_FLG,'N') = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("),'N') AS HOLD_INV_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}