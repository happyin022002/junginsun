/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalDBDAOSearchAproUsrIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21 
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

public class ApprovalDBDAOSearchAproUsrIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 결재자가 Approval Step에 정보가 있는지, EP_ID를 사용할 경우 USR ID보다 EP ID를 사용한다.
	  * </pre>
	  */
	public ApprovalDBDAOSearchAproUsrIdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchAproUsrIdRSQL").append("\n"); 
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
		query.append("    CASE" ).append("\n"); 
		query.append("    WHEN EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                 FROM COM_USER A" ).append("\n"); 
		query.append("                 WHERE A.USR_ID = @[usr_id] AND A.USE_FLG = 'Y')" ).append("\n"); 
		query.append("    THEN (SELECT A.USR_ID FROM COM_USER A WHERE A.USR_ID = @[usr_id] AND A.USE_FLG = 'Y')" ).append("\n"); 
		query.append("    ELSE (SELECT A.USR_ID FROM COM_USER A WHERE A.EP_ID = @[usr_id] AND A.USE_FLG = 'Y' AND ROWNUM = 1)" ).append("\n"); 
		query.append("    END USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}