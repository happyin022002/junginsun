/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComCsrApprovalDBDAOSearchCsrApAproInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ComCsrApprovalDBDAOSearchCsrApAproInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ..
	  * </pre>
	  */
	public ComCsrApprovalDBDAOSearchCsrApAproInfoRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.csr.csrapproval.integration ").append("\n"); 
		query.append("FileName : ComCsrApprovalDBDAOSearchCsrApAproInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("X.APRO_USR_ID, " ).append("\n"); 
		query.append("X.APRO_USR_NM, " ).append("\n"); 
		query.append("X.APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("DENSE_RANK() OVER (PARTITION BY A.APRO_RQST_NO ORDER BY APRO_RQST_SEQ DESC) RNK," ).append("\n"); 
		query.append("B.*" ).append("\n"); 
		query.append("FROM COM_APRO_CSR_DTL A, COM_APRO_RQST_HDR H, COM_APRO_RQST_ROUT B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.APRO_RQST_NO = H.APRO_RQST_NO" ).append("\n"); 
		query.append("AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND A.APRO_RQST_NO = B.APRO_RQST_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE X.RNK = 1" ).append("\n"); 

	}
}