/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOSearchAuthApprovalByAuthAproRoutSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOSearchAuthApprovalByAuthAproRoutSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth Approval 결재 라인 조회
	  * </pre>
	  */
	public ApprovalDBDAOSearchAuthApprovalByAuthAproRoutSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchAuthApprovalByAuthAproRoutSeqRSQL").append("\n"); 
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
		query.append("SELECT AUTH_APRO_ROUT_USR_SEQ," ).append("\n"); 
		query.append("AUTH_APRO_USR_ID," ).append("\n"); 
		query.append("AUTH_APRO_USR_NM," ).append("\n"); 
		query.append("AUTH_APRO_OFC_CD," ).append("\n"); 
		query.append("AUTH_APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append(" 	SELECT ROW_NUMBER() OVER (ORDER BY A.AUTH_APRO_ROUT_SEQ DESC) no," ).append("\n"); 
		query.append("	A.AUTH_APRO_ROUT_USR_SEQ," ).append("\n"); 
		query.append("	A.AUTH_APRO_USR_ID," ).append("\n"); 
		query.append(" 	A.AUTH_APRO_USR_NM," ).append("\n"); 
		query.append(" 	B.OFC_CD AUTH_APRO_OFC_CD," ).append("\n"); 
		query.append(" 	A.AUTH_APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append(" 	FROM COM_AUTH_APRO_DFLT_ROUT_USR A, COM_USER B" ).append("\n"); 
		query.append(" 	WHERE B.USE_FLG = 'Y'" ).append("\n"); 
		query.append(" 	--AND A.APRO_USR_ID = B.USR_ID" ).append("\n"); 
		query.append(" 	AND A.AUTH_APRO_USR_ID IN (B.USR_ID, B.EP_ID)" ).append("\n"); 
		query.append(" 	AND A.AUTH_APRO_ROUT_SEQ = @[auth_apro_rout_seq]" ).append("\n"); 
		query.append(" 	ORDER BY A.AUTH_APRO_ROUT_USR_SEQ DESC" ).append("\n"); 
		query.append(")A" ).append("\n"); 

	}
}