/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComCsrApprovalDBDAOSearchCheckIfFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ComCsrApprovalDBDAOSearchCheckIfFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dd
	  * </pre>
	  */
	public ComCsrApprovalDBDAOSearchCheckIfFlgRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.csr.csrapproval.integration").append("\n"); 
		query.append("FileName : ComCsrApprovalDBDAOSearchCheckIfFlgRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE " ).append("\n"); 
		query.append("WHEN NVL(A.RQST_APRO_STEP_FLG,'N') = 'Y' --기안대기" ).append("\n"); 
		query.append("THEN 'N2'" ).append("\n"); 
		query.append("WHEN A.AFT_ACT_FLG IS NOT NULL --> csr cancel" ).append("\n"); 
		query.append("THEN 'NX'" ).append("\n"); 
		query.append("WHEN A.RCV_ERR_FLG IS NOT NULL --> a/p reject" ).append("\n"); 
		query.append("THEN 'N1'" ).append("\n"); 
		query.append("WHEN A.IF_FLG = 'Y' --ERP I/F 완료" ).append("\n"); 
		query.append("THEN 'N2'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}