/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ApprovalDBDAOApprovalStepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.12
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.07.12 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOApprovalStepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval Step의 목록을 조회합니다
	  * </pre>
	  */
	public ApprovalDBDAOApprovalStepRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOApprovalStepRSQL").append("\n"); 
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
		query.append("SELECT APRO_RQST_SEQ" ).append("\n"); 
		query.append(", APRO_USR_NM" ).append("\n"); 
		query.append(", APRO_OFC_CD" ).append("\n"); 
		query.append(", '' TITLE" ).append("\n"); 
		query.append(", APRO_CD" ).append("\n"); 
		query.append(", APRO_DT" ).append("\n"); 
		query.append(", APRO_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER (ORDER BY APRO_RQST_SEQ DESC) NO" ).append("\n"); 
		query.append(", APRO_RQST_SEQ" ).append("\n"); 
		query.append(", APRO_USR_NM" ).append("\n"); 
		query.append(", APRO_OFC_CD" ).append("\n"); 
		query.append(", DECODE(NVL(APSTS_CD, ''), 'C', 'Approved', 'R', 'Disapproved', '') APRO_CD" ).append("\n"); 
		query.append(", TO_CHAR(APRO_DT, 'yyyy-mm-dd hh24:mi') APRO_DT" ).append("\n"); 
		query.append(", APRO_RMK" ).append("\n"); 
		query.append("FROM COM_APRO_RQST_ROUT" ).append("\n"); 
		query.append("WHERE APRO_RQST_NO = @[apro_rqst_no]" ).append("\n"); 
		query.append("ORDER BY APRO_RQST_SEQ DESC" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}