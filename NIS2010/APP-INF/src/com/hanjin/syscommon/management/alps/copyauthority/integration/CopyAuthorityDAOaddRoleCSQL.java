/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopyAuthorityDAOaddRoleCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.04.19 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.copyauthority.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kyungbum kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopyAuthorityDAOaddRoleCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert role from other user
	  * </pre>
	  */
	public CopyAuthorityDAOaddRoleCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.copyauthority.integration").append("\n"); 
		query.append("FileName : CopyAuthorityDAOaddRoleCSQL").append("\n"); 
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
		query.append("#if (${opt} == 'add') " ).append("\n"); 
		query.append("insert into com_usr_role_mtch" ).append("\n"); 
		query.append("select usr_id, usr_role_cd, 'authcopy', sysdate, 'authcopy', sysdate" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select @[to_usr_id] usr_id, usr_role_cd from com_usr_role_mtch where usr_id = @[from_usr_id]" ).append("\n"); 
		query.append("minus" ).append("\n"); 
		query.append("select @[to_usr_id] usr_id, usr_role_cd from com_usr_role_mtch where usr_id = @[to_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("insert into com_usr_role_mtch" ).append("\n"); 
		query.append("select @[to_usr_id], usr_role_cd, 'authcopy', sysdate, 'authcopy', sysdate" ).append("\n"); 
		query.append("from com_usr_role_mtch" ).append("\n"); 
		query.append("where usr_id = @[from_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}