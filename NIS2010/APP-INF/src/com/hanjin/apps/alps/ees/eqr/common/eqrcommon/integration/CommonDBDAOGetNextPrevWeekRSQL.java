/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOGetNextPrevWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.30 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOGetNextPrevWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기준 week의 다음주(nextNum) 정보를 가져옵니다.
	  * </pre>
	  */
	public CommonDBDAOGetNextPrevWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yyyyww",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nextNum",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOGetNextPrevWeekRSQL").append("\n"); 
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
		query.append("PLN_YR||PLN_WK WEEK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(ROWNUM)SEQ, PLN_YR, PLN_WK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${direction} == 'NEXT')" ).append("\n"); 
		query.append("-- NEXT : 미래주차" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK > @[yyyyww]" ).append("\n"); 
		query.append("ORDER BY SEQ ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM <= @[nextNum]" ).append("\n"); 
		query.append("ORDER BY WEEK DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("-- PREV : 과거주차" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK < @[yyyyww]" ).append("\n"); 
		query.append("ORDER BY SEQ DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM <= @[nextNum]" ).append("\n"); 
		query.append("ORDER BY SEQ ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}