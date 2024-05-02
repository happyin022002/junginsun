/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalDBDAOSearchCsrSubSystemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.30
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.07.30 DONG- IL, SHIN
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

public class ApprovalDBDAOSearchCsrSubSystemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMS, JOO분기위한 조회
	  * </pre>
	  */
	public ApprovalDBDAOSearchCsrSubSystemRSQL(){
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
		query.append("FileName : ApprovalDBDAOSearchCsrSubSystemRSQL").append("\n"); 
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
		query.append("SELECT SUB_SYS_CD AS SYS_CD" ).append("\n"); 
		query.append("  FROM COM_APRO_RQST_HDR A" ).append("\n"); 
		query.append(" WHERE A.APRO_RQST_NO = ( SELECT APRO_RQST_NO" ).append("\n"); 
		query.append("                            FROM COM_APRO_CSR_DTL" ).append("\n"); 
		query.append("                           WHERE CSR_NO = @[csr_no] )" ).append("\n"); 

	}
}