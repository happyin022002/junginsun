/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAODisaproAuthApprovalUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.05 
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

public class ApprovalDBDAODisaproAuthApprovalUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization Disapprove 처리
	  * </pre>
	  */
	public ApprovalDBDAODisaproAuthApprovalUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAODisaproAuthApprovalUSQL").append("\n"); 
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
		query.append("UPDATE COM_AUTH_APRO_RQST Q" ).append("\n"); 
		query.append("SET Q.AUTH_APSTS_CD = 'R'" ).append("\n"); 
		query.append("    , Q.RQST_END_DT = SYSDATE --GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(Q.RQST_OFC_CD)" ).append("\n"); 
		query.append("	, Q.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	, Q.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE Q.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no] " ).append("\n"); 

	}
}