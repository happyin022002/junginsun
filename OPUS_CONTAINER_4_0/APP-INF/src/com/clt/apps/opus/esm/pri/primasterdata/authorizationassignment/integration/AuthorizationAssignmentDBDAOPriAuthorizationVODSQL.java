/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuthorizationAssignmentDBDAOPriAuthorizationVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.03 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationAssignmentDBDAOPriAuthorizationVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAOPriAuthorizationVODSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAOPriAuthorizationVODSQL").append("\n"); 
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
		query.append("UPDATE PRI_AUTHORIZATION SET" ).append("\n"); 
		query.append("EXP_DT = TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD')" ).append("\n"); 
		query.append(",   UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",   UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	PRC_CTRT_TP_CD = @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("AND	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	USR_ID = @[usr_id]" ).append("\n"); 

	}
}