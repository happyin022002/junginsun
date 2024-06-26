/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRDetailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOModifyFFCmpnCSRDetailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyFFCmpnDetail
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOModifyFFCmpnCSRDetailUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n"); 
		query.append("FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRDetailUSQL").append("\n"); 
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
		query.append("/* HDR_AMT VS DTRB_AMT */" ).append("\n"); 
		query.append("UPDATE AP_INV_DTRB A " ).append("\n"); 
		query.append("SET INV_AMT = ROUND(INV_AMT + (SELECT X.CSR_AMT - SUM(Y.INV_AMT) " ).append("\n"); 
		query.append("                           FROM AP_INV_HDR X, AP_INV_DTRB Y " ).append("\n"); 
		query.append("                          WHERE X.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                            AND X.CSR_NO = Y.CSR_NO " ).append("\n"); 
		query.append("                          GROUP BY X.CSR_AMT),2)" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND (LINE_SEQ,LINE_NO) IN (SELECT LINE_SEQ, LINE_NO " ).append("\n"); 
		query.append("                             FROM AP_INV_DTRB " ).append("\n"); 
		query.append("                            WHERE CSR_NO = A.CSR_NO " ).append("\n"); 
		query.append("                              AND ROWNUM = 1)" ).append("\n"); 

	}
}