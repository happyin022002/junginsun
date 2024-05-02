/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonDBDAOTodayWeeklyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.07.09 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOTodayWeeklyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_wk_prd 에서 현재 일자에 대한 주차정보를 조회한다.
	  * </pre>
	  */
	public CommonDBDAOTodayWeeklyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOTodayWeeklyRSQL").append("\n"); 
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
		query.append("    PLN_YR||PLN_WK                           					" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    EQR_WK_PRD                               					" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT" ).append("\n"); 

	}
}