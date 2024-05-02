/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookmarkManagementDAOcomBookmarkRoleCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.bookmark.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookmarkManagementDAOcomBookmarkRoleCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 북마크 권한 체크
	  * </pre>
	  */
	public BookmarkManagementDAOcomBookmarkRoleCheckRSQL(){
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
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.bookmark.integration").append("\n"); 
		query.append("FileName : BookmarkManagementDAOcomBookmarkRoleCheckRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'Y' AS FLG" ).append("\n"); 
		query.append("FROM COM_USR_ROLE_MTCH R, COM_PGM_ROLE B, COM_OFC_PGM_MTCH C" ).append("\n"); 
		query.append("WHERE R.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND R.USR_ROLE_CD = B.USR_ROLE_CD" ).append("\n"); 
		query.append("AND B.PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}