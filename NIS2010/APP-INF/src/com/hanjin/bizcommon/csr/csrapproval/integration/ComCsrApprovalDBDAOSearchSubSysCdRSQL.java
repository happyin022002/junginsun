/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComCsrApprovalDBDAOSearchSubSysCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19 
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

public class ComCsrApprovalDBDAOSearchSubSysCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Csr_No로 SUB_SYS_CD 정보를 조회한다.
	  * </pre>
	  */
	public ComCsrApprovalDBDAOSearchSubSysCdRSQL(){
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
		query.append("FileName : ComCsrApprovalDBDAOSearchSubSysCdRSQL").append("\n"); 
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
		query.append("SELECT R.SUB_SYS_ID" ).append("\n"); 
		query.append("FROM AP_INV_HDR A, COM_APRO_SND_MN_RULE R" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND A.SRC_CTNT = R.SRC_CTNT(+)" ).append("\n"); 
		query.append("AND A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}