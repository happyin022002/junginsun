/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MenuAccessDBDAORemoveAuthDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mobile.hansap.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MenuAccessDBDAORemoveAuthDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Menu별 접근 권한 삭제
	  * </pre>
	  */
	public MenuAccessDBDAORemoveAuthDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnu_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mobile.hansap.integration ").append("\n"); 
		query.append("FileName : MenuAccessDBDAORemoveAuthDSQL").append("\n"); 
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
		query.append("DELETE FROM MOB_AUTHORITY" ).append("\n"); 
		query.append("WHERE MNU_ID = @[mnu_id]" ).append("\n"); 
		query.append("  AND USR_ID = @[usr_id]" ).append("\n"); 

	}
}