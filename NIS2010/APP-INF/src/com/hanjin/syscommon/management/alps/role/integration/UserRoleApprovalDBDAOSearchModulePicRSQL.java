/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserRoleApprovalDBDAOSearchModulePicRSQL.java
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

public class UserRoleApprovalDBDAOSearchModulePicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 모듈별 SuperUser의 메일을 가져온다
	  * </pre>
	  */
	public UserRoleApprovalDBDAOSearchModulePicRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("role_module",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration").append("\n"); 
		query.append("FileName : UserRoleApprovalDBDAOSearchModulePicRSQL").append("\n"); 
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
		query.append("select a.role_module," ).append("\n"); 
		query.append("  a.usr_id," ).append("\n"); 
		query.append("  a.usr_nm," ).append("\n"); 
		query.append("  a.usr_eml" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    select distinct substr(b.pgm_no, 0, 3) role_module," ).append("\n"); 
		query.append("      a.usr_id," ).append("\n"); 
		query.append("      a.usr_nm," ).append("\n"); 
		query.append("      a.usr_eml" ).append("\n"); 
		query.append("    from com_user a," ).append("\n"); 
		query.append("      com_usr_pgm_mtch b" ).append("\n"); 
		query.append("    where a.usr_id = b.usr_id" ).append("\n"); 
		query.append("      and a.usr_auth_tp_cd = 'S'" ).append("\n"); 
		query.append("      and NVL(a.use_flg, 'Y') = 'Y'" ).append("\n"); 
		query.append("      and length(b.pgm_no) = 3" ).append("\n"); 
		query.append("    order by role_module ) a" ).append("\n"); 
		query.append("where role_module = @[role_module]" ).append("\n"); 

	}
}