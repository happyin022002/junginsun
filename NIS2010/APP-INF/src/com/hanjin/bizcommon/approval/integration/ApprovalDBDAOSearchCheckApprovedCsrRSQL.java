/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalDBDAOSearchCheckApprovedCsrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.29
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.07.29 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOSearchCheckApprovedCsrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add버튼시 Appoved인 건은 결재라인 추가 못하도록 함.
	  * </pre>
	  */
	public ApprovalDBDAOSearchCheckApprovedCsrRSQL(){
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
		query.append("FileName : ApprovalDBDAOSearchCheckApprovedCsrRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN C.APSTS_CD IN ('R','C','D') THEN 'Y' --R: DISAPPROVAL, C:APPROVAL,D:PAID,X:CSR CANCEL" ).append("\n"); 
		query.append("            WHEN NVL(A.IF_FLG,'N') = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("            ELSE NVL(A.IF_FLG,'N') " ).append("\n"); 
		query.append("        END AS IF_FLG" ).append("\n"); 
		query.append("  FROM AP_INV_HDR A" ).append("\n"); 
		query.append("      ,COM_APRO_CSR_DTL B" ).append("\n"); 
		query.append("      ,COM_APRO_RQST_HDR C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("   AND B.APRO_RQST_NO = C.APRO_RQST_NO" ).append("\n"); 
		query.append("   AND A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}