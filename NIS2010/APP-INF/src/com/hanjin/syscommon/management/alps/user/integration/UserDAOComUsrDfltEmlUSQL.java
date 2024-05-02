/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UserDAOComUsrDfltEmlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : 노형춘
*@LastVersion : 1.0
* 2012.02.22 노형춘
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.user.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ROHHYUNGCHOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserDAOComUsrDfltEmlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DFLT_EML update
	  * </pre>
	  */
	public UserDAOComUsrDfltEmlUSQL(){
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
		params.put("dflt_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.user.integration").append("\n"); 
		query.append("FileName : UserDAOComUsrDfltEmlUSQL").append("\n"); 
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
		query.append("UPDATE com_user SET                                                   " ).append("\n"); 
		query.append(" dflt_eml   = @[dflt_eml] ," ).append("\n"); 
		query.append(" upd_usr_id          = @[usr_id] ," ).append("\n"); 
		query.append(" upd_dt                = sysdate" ).append("\n"); 
		query.append("WHERE usr_id = @[usr_id]" ).append("\n"); 

	}
}