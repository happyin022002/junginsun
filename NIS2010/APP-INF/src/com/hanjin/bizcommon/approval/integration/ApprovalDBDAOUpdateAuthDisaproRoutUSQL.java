/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOUpdateAuthDisaproRoutUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.02 
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

public class ApprovalDBDAOUpdateAuthDisaproRoutUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization Disapprove시 Rout Update
	  * </pre>
	  */
	public ApprovalDBDAOUpdateAuthDisaproRoutUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ApprovalDBDAOUpdateAuthDisaproRoutUSQL").append("\n"); 
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
		query.append("UPDATE COM_AUTH_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("SET R.AUTH_APSTS_CD = 'R', " ).append("\n"); 
		query.append("R.AUTH_APRO_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT Q.RQST_OFC_CD FROM COM_AUTH_APRO_RQST Q WHERE Q.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO AND ROWNUM=1))," ).append("\n"); 
		query.append("R.UPD_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("R.UPD_DT = SYSDATE," ).append("\n"); 
		query.append("R.AUTH_APRO_RMK = SUBSTRB(@[auth_apro_rmk],1,999)" ).append("\n"); 
		query.append("WHERE R.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no] " ).append("\n"); 
		query.append("AND R.AUTH_APRO_RQST_ROUT_SEQ = (   SELECT Q.CRNT_AUTH_APRO_RQST_SEQ " ).append("\n"); 
		query.append("                                    FROM COM_AUTH_APRO_RQST Q" ).append("\n"); 
		query.append("                                    WHERE Q.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO     )" ).append("\n"); 
		query.append("AND R.AUTH_APRO_USR_ID = @[usr_id]" ).append("\n"); 

	}
}