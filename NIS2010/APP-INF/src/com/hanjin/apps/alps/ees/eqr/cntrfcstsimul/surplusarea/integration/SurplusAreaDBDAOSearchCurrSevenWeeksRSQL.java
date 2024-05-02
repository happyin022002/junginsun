/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SurplusAreaDBDAOSearchCurrSevenWeeksRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.09.04 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurplusAreaDBDAOSearchCurrSevenWeeksRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현재시각 기준으로 기본 주차 ( 과거 3주 ~ 미래 3주 , 총 7주차 )가져오기
	  * </pre>
	  */
	public SurplusAreaDBDAOSearchCurrSevenWeeksRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.integration").append("\n"); 
		query.append("FileName : SurplusAreaDBDAOSearchCurrSevenWeeksRSQL").append("\n"); 
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
		query.append("WITH ALL_WK AS (" ).append("\n"); 
		query.append("SELECT ROWNUM RN, W.PLN_YR, W.PLN_WK, W.WK_ST_DT, W.WK_END_DT" ).append("\n"); 
		query.append("FROM EQR_WK_PRD W" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CURR_WK_SEQ AS (" ).append("\n"); 
		query.append("SELECT W.*" ).append("\n"); 
		query.append("FROM ALL_WK W" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (W.PLN_YR, W.PLN_WK) = (SELECT W.PLN_YR, W.PLN_WK FROM EQR_WK_PRD W" ).append("\n"); 
		query.append("            WHERE 1=1 " ).append("\n"); 
		query.append("            AND TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT W.PLN_YR||W.PLN_WK WEEK" ).append("\n"); 
		query.append("FROM ALL_WK W" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND W.RN BETWEEN (SELECT C.RN-3 FROM CURR_WK_SEQ C) AND (SELECT C.RN+3 FROM CURR_WK_SEQ C)" ).append("\n"); 

	}
}