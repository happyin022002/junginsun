/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RoleMappingDAORoleInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RoleMappingDAORoleInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Role Inquiry
	  * </pre>
	  */
	public RoleMappingDAORoleInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_role_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_role_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration").append("\n"); 
		query.append("FileName : RoleMappingDAORoleInquiryRSQL").append("\n"); 
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
		query.append("SELECT 	USR_ROLE_CD, " ).append("\n"); 
		query.append("		USR_ROLE_NM, " ).append("\n"); 
		query.append("		USR_ROLE_DESC" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("FROM 	COM_USR_ROLE " ).append("\n"); 
		query.append("WHERE 1=1		" ).append("\n"); 
		query.append("		#if (${usr_role_cd} != '')" ).append("\n"); 
		query.append("			AND USR_ROLE_CD LIKE @[usr_role_cd]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${usr_role_nm} != '')" ).append("\n"); 
		query.append("			AND upper(USR_ROLE_NM) LIKE '%'||upper(@[usr_role_nm])||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("ORDER BY USR_ROLE_CD" ).append("\n"); 

	}
}