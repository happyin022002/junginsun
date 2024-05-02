/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchMaxInfoRSQL.java
*@FileTitle : EQR공통모듈
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.13 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchMaxInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *      각 테이블의 UPDATE된 최근  아이디와 UPDATE 날짜를 구해오는 로직 
	  * </pre>
	  */
	public CommonDBDAOSearchMaxInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchMaxInfoRSQL").append("\n"); 
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
		query.append("SELECT 	MAX_USRID" ).append("\n"); 
		query.append(",MAX_UPDATE" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(   SELECT NVL(UPD_USR_ID,' ') MAX_USRID" ).append("\n"); 
		query.append(",TO_CHAR(MAX(NVL(UPD_DT,'')),'YYYY-MM-DD') MAX_UPDATE" ).append("\n"); 
		query.append(",MAX(NVL(UPD_DT,'')) UPD_DT" ).append("\n"); 
		query.append("FROM  ${table_name}" ).append("\n"); 
		query.append("WHERE UPD_DT IS NOT NULL" ).append("\n"); 
		query.append("#if (${condition} != '')" ).append("\n"); 
		query.append("AND ${condition}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY UPD_USR_ID" ).append("\n"); 
		query.append("ORDER BY UPD_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}
