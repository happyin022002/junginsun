/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UserMappingDAOComUsrJobMtchDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserMappingDAOComUsrJobMtchDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public UserMappingDAOComUsrJobMtchDSQL(){
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
		params.put("usr_job_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration ").append("\n"); 
		query.append("FileName : UserMappingDAOComUsrJobMtchDSQL").append("\n"); 
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
		query.append("#if(${usr_role_adm_mtch}==\"Y\")" ).append("\n"); 
		query.append("delete from com_usr_role_adm_mtch" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("delete from com_usr_role_mtch" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("where	usr_id = @[usr_id]" ).append("\n"); 
		query.append("and	usr_role_cd = @[usr_job_cd]" ).append("\n"); 

	}
}