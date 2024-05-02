/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastManageDBDAOSearchDayDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastManageDBDAOSearchDayDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_WK_PRD  테이블에서 그주의 월요일 날짜를 가져온다.(주만 넘겨주면 그주의 월요일을 날짜를 리턴해준다.)
	  * 
	  * <Change History>
	  * 1	2009.08.12	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrForecastManageDBDAOSearchDayDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yyyywk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration").append("\n"); 
		query.append("FileName : CntrForecastManageDBDAOSearchDayDateRSQL").append("\n"); 
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
		query.append("TO_CHAR(TRUNC(TO_DATE(WK_END_DT,'yyyymmdd') +2) - TO_CHAR(TO_DATE(WK_END_DT,'yyyymmdd'),'D'),'yyyymmdd') RETURNDAY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT WK_END_DT" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK =@[yyyywk]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}