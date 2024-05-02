/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookmarkManagementDAOcomBookmarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.11 
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

public class BookmarkManagementDAOcomBookmarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select bookmark
	  * </pre>
	  */
	public BookmarkManagementDAOcomBookmarkRSQL(){
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
		query.append("Path : com.hanjin.syscommon.management.alps.bookmark.integration").append("\n"); 
		query.append("FileName : BookmarkManagementDAOcomBookmarkRSQL").append("\n"); 
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
		query.append("	LEVEL," ).append("\n"); 
		query.append("	A.DP_NM," ).append("\n"); 
		query.append("	A.FOL_FLG," ).append("\n"); 
		query.append("	A.PGM_NO, " ).append("\n"); 
		query.append("	A.DP_SEQ," ).append("\n"); 
		query.append("	A.PRNT_PGM_NO, " ).append("\n"); 
		query.append("	B.PGM_NM, " ).append("\n"); 
		query.append("	B.PGM_URL, " ).append("\n"); 
		query.append("	A.USR_ID" ).append("\n"); 
		query.append("FROM COM_BOOKMARK A, COM_PROGRAM B" ).append("\n"); 
		query.append("WHERE A.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND A.PGM_NO = B.PGM_NO(+) " ).append("\n"); 
		query.append("AND 'Y' = CASE " ).append("\n"); 
		query.append("          WHEN A.FOL_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("          WHEN A.FOL_FLG = 'N' THEN ( SELECT 'Y'" ).append("\n"); 
		query.append("                                      FROM COM_USR_ROLE_MTCH A" ).append("\n"); 
		query.append("                                      WHERE A.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                                      AND A.USR_ROLE_CD IN (select USR_ROLE_CD from COM_PGM_ROLE where pgm_no = A.PGM_NO)" ).append("\n"); 
		query.append("                                      UNION" ).append("\n"); 
		query.append("                                      SELECT 'Y' FROM com_usr_pgm_mtch WHERE USR_ID = @[usr_id] AND PGM_NO = A.PGM_NO" ).append("\n"); 
		query.append("									  UNION" ).append("\n"); 
		query.append("                                      SELECT 'Y' FROM COM_PGM_ROLE WHERE USR_ROLE_CD LIKE '%99' AND PGM_NO = A.PGM_NO" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("          END " ).append("\n"); 
		query.append("CONNECT BY PRIOR A.PGM_NO = A.PRNT_PGM_NO" ).append("\n"); 
		query.append("START WITH A.PRNT_PGM_NO IS NULL AND A.USR_ID= @[usr_id]" ).append("\n"); 
		query.append("ORDER SIBLINGS BY A.DP_SEQ DESC" ).append("\n"); 

	}
}