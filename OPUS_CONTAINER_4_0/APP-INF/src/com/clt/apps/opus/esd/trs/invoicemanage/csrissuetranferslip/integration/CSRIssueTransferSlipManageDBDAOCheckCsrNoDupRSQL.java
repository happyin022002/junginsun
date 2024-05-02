/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCheckCsrNoDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.19 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCheckCsrNoDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR NO 중복 체크
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCheckCsrNoDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCheckCsrNoDupRSQL").append("\n"); 
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
		query.append("SELECT SUM(1)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 1 CHK" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0)" ).append("\n"); 
		query.append("AND ((INV_NO, INV_VNDR_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${INV_NO})" ).append("\n"); 
		query.append("#if($velocityCount < $INV_NO.size())" ).append("\n"); 
		query.append("('$key.field1', '$key.field2')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("('$key.field1', '$key.field2')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND LENGTH(CSR_NO) > 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2 CHK" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0)" ).append("\n"); 
		query.append("AND ((INV_NO, INV_VNDR_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${INV_NO})" ).append("\n"); 
		query.append("#if($velocityCount < $INV_NO.size())" ).append("\n"); 
		query.append("('$key.field1', '$key.field2')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("('$key.field1', '$key.field2')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND LENGTH(CSR_NO) > 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY CHK" ).append("\n"); 

	}
}