/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserRoleApprovalDBDAOModuleRoleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.11 
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

public class UserRoleApprovalDBDAOModuleRoleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 모듈의 role을 가져온다
	  * </pre>
	  */
	public UserRoleApprovalDBDAOModuleRoleRSQL(){
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
		params.put("sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration").append("\n"); 
		query.append("FileName : UserRoleApprovalDBDAOModuleRoleRSQL").append("\n"); 
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
		query.append("select a.usr_role_cd," ).append("\n"); 
		query.append("  a.usr_role_cd || ' - ' ||usr_role_nm as usr_role_nm" ).append("\n"); 
		query.append("from com_usr_role a," ).append("\n"); 
		query.append("  (select usr_role_cd" ).append("\n"); 
		query.append("    from com_usr_role_mtch" ).append("\n"); 
		query.append("    where usr_id = @[usr_id]" ).append("\n"); 
		query.append("    and substr(usr_role_cd, 1, 3) = @[sub_sys_cd] )b," ).append("\n"); 
		query.append("  (select a.apro_rqst_no," ).append("\n"); 
		query.append("      a.rqst_usr_id," ).append("\n"); 
		query.append("      b.usr_role_cd," ).append("\n"); 
		query.append("      c.apsts_cd" ).append("\n"); 
		query.append("    from com_apro_role_rqst_hdr a," ).append("\n"); 
		query.append("      com_apro_role_dtl b," ).append("\n"); 
		query.append("      com_apro_role_rqst_rout c" ).append("\n"); 
		query.append("    where 1 =1" ).append("\n"); 
		query.append("      and a.apro_rqst_no = b.apro_rqst_no" ).append("\n"); 
		query.append("      and a.apro_rqst_no = c.apro_rqst_no" ).append("\n"); 
		query.append("      and a.rqst_usr_id = @[usr_id]" ).append("\n"); 
		query.append("      and c.apsts_cd = 'P') c" ).append("\n"); 
		query.append("where a.usr_role_cd = b.usr_role_cd (+)" ).append("\n"); 
		query.append("  and a.usr_role_cd = c.usr_role_cd (+)" ).append("\n"); 
		query.append("  and (a.usr_role_tp_cd is null or a.usr_role_tp_cd <> 'J')" ).append("\n"); 
		query.append("  and substr(a.usr_role_cd, 1, 3) = @[sub_sys_cd]" ).append("\n"); 
		query.append("  and (b.usr_role_cd is null and c.usr_role_cd is null)" ).append("\n"); 
		query.append("order by a.usr_role_cd " ).append("\n"); 

	}
}