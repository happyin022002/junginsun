/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserRoleApprovalDBDAOSuperUserRoleModRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
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

public class UserRoleApprovalDBDAOSuperUserRoleModRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Super User Role Module을 Select
	  * </pre>
	  */
	public UserRoleApprovalDBDAOSuperUserRoleModRSQL(){
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
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration").append("\n"); 
		query.append("FileName : UserRoleApprovalDBDAOSuperUserRoleModRSQL").append("\n"); 
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
		query.append("select role_module" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    select distinct substr(b.pgm_no, 0, 3) role_module" ).append("\n"); 
		query.append("    from com_user a," ).append("\n"); 
		query.append("      com_usr_pgm_mtch b" ).append("\n"); 
		query.append("    where a.usr_id = b.usr_id" ).append("\n"); 
		query.append("      and a.usr_auth_tp_cd = 'S'" ).append("\n"); 
		query.append("      and NVL(a.use_flg, 'Y') = 'Y'" ).append("\n"); 
		query.append("      and length(b.pgm_no) = 3" ).append("\n"); 
		query.append("      and a.usr_id = @[usr_id]" ).append("\n"); 
		query.append(")a" ).append("\n"); 
		query.append("group by a.role_module" ).append("\n"); 

	}
}