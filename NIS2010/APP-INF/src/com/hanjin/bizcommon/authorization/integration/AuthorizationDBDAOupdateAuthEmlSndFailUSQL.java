/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOupdateAuthEmlSndFailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.authorization.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationDBDAOupdateAuthEmlSndFailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 메일 전송 실패시 로그 기록
	  * </pre>
	  */
	public AuthorizationDBDAOupdateAuthEmlSndFailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration ").append("\n"); 
		query.append("FileName : AuthorizationDBDAOupdateAuthEmlSndFailUSQL").append("\n"); 
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
		query.append("UPDATE COM_AUTH_EML_SND" ).append("\n"); 
		query.append("SET EML_SND_RSLT_FLG = 'N'" ).append("\n"); 
		query.append("	,AUTH_EML_SND_RSLT_CD = 'F'" ).append("\n"); 
		query.append("	,EML_SND_DT = SYSDATE" ).append("\n"); 
		query.append("	,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE AUTH_EML_SND_NO = @[auth_eml_snd_no]" ).append("\n"); 

	}
}