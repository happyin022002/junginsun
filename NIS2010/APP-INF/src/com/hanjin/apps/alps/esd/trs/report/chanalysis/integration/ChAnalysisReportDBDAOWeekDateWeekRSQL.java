/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChAnalysisReportDBDAOWeekDateWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.09.09 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.chanalysis.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChAnalysisReportDBDAOWeekDateWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 주의 첫날과 마지막 날짜를 조회한다.
	  * </pre>
	  */
	public ChAnalysisReportDBDAOWeekDateWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WEEK",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.chanalysis.integration ").append("\n"); 
		query.append("FileName : ChAnalysisReportDBDAOWeekDateWeekRSQL").append("\n"); 
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
		query.append("WK_ST_DT FM_DT," ).append("\n"); 
		query.append("WK_END_DT TO_DT" ).append("\n"); 
		query.append("FROM  	EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE 	PLN_YR||PLN_WK = @[WEEK]" ).append("\n"); 

	}
}