/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComCsrApprovalDBDAOsearchCheckAproStepFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
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

public class ComCsrApprovalDBDAOsearchCheckAproStepFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --기안정보 확인
	  * </pre>
	  */
	public ComCsrApprovalDBDAOsearchCheckAproStepFlgRSQL(){
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
		query.append("FileName : ComCsrApprovalDBDAOsearchCheckAproStepFlgRSQL").append("\n"); 
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
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(A.RQST_APRO_STEP_FLG,'N') = 'Y' AND A.CSR_APRO_TP_CD = 'AL'" ).append("\n"); 
		query.append("THEN CASE WHEN A.AFT_ACT_FLG IS NULL --> csr cancel" ).append("\n"); 
		query.append("            AND A.RCV_ERR_FLG IS NULL --> a/p reject" ).append("\n"); 
		query.append("            AND A.IF_FLG IS NULL --ERP I/F 완료" ).append("\n"); 
		query.append("     THEN 'Y'" ).append("\n"); 
		query.append("     ELSE 'N'" ).append("\n"); 
		query.append("     END" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}