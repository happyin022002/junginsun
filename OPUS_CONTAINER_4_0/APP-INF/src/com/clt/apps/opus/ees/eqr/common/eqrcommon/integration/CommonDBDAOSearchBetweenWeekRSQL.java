/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchBetweenWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.31 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchBetweenWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주차를 넣어서 해당되는 일주일 년월일을 가져온다.
	  * </pre>
	  */
	public CommonDBDAOSearchBetweenWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("weekly_searchWord",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOSearchBetweenWeekRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_ST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR|| PLN_WK = @[weekly_searchWord]" ).append("\n"); 
		query.append("), 'YYYY-MM-DD') + NUM-1, 'YYYYMMDD') DAY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM NUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DICTIONARY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("ROWNUM <=   (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_DATE(WK_END_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR|| PLN_WK = @[weekly_searchWord]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-  (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_DATE(WK_ST_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR|| PLN_WK = @[weekly_searchWord]" ).append("\n"); 
		query.append(")  + 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}