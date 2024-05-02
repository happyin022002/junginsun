/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CanadaCCTManageDBDAOSearchCCTIntervalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCCTManageDBDAOSearchCCTIntervalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.05.03 sat/sun 에도 fri 사용 안하고 그대로 표기
	  * 
	  * CanadaCCTManageDBDAOSearchCCTInterval
	  * </pre>
	  */
	public CanadaCCTManageDBDAOSearchCCTIntervalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration").append("\n"); 
		query.append("FileName : CanadaCCTManageDBDAOSearchCCTIntervalRSQL").append("\n"); 
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
		query.append("SELECT LTST_RCV_DY_CD,ADJ_LTST_RCV_DY_CD, ERY_RCV_DY_CD, RCV_ITVAL_DYS,US_LTST_RCV_DY_CD,US_ADJ_LTST_RCV_DY_CD,US_ERY_RCV_DY_CD,US_RCV_ITVAL_DYS" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               --CASE" ).append("\n"); 
		query.append("               --  WHEN LTST_RCV_DY_CD ='SAT' THEN '* '||LTST_RCV_DY_CD||' -> FRI'" ).append("\n"); 
		query.append("               --  WHEN LTST_RCV_DY_CD ='SUN' THEN '* '||LTST_RCV_DY_CD||' -> FRI'" ).append("\n"); 
		query.append("               --  ELSE LTST_RCV_DY_CD" ).append("\n"); 
		query.append("               --END LTST_RCV_DY_CD ," ).append("\n"); 
		query.append("			   ca.LTST_RCV_DY_CD ," ).append("\n"); 
		query.append("               ca.ERY_RCV_DY_CD ," ).append("\n"); 
		query.append("               --ca.RCV_ITVAL_DYS || DECODE(ca.RCV_ITVAL_DESC, NULL, '', ' ('||ca.RCV_ITVAL_DESC||')') RCV_ITVAL_DYS," ).append("\n"); 
		query.append("			   ca.RCV_ITVAL_DYS RCV_ITVAL_DYS," ).append("\n"); 
		query.append("               ca.ADJ_LTST_RCV_DY_CD," ).append("\n"); 
		query.append("               DECODE(ca.LTST_RCV_DY_CD, 'MON', 1, 'TUE', 2, 'WED', 3, 'THU', 4, 'FRI', 5, 'SAT', 6, 'SUN', 7) SORT," ).append("\n"); 
		query.append("			   us.LTST_RCV_DY_CD us_LTST_RCV_DY_CD," ).append("\n"); 
		query.append("               us.ERY_RCV_DY_CD us_ERY_RCV_DY_CD ," ).append("\n"); 
		query.append("               --us.RCV_ITVAL_DYS || DECODE(us.RCV_ITVAL_DESC, NULL, '', ' ('||us.RCV_ITVAL_DESC||')') us_RCV_ITVAL_DYS," ).append("\n"); 
		query.append("               us.RCV_ITVAL_DYS us_RCV_ITVAL_DYS," ).append("\n"); 
		query.append("               us.ADJ_LTST_RCV_DY_CD US_ADJ_LTST_RCV_DY_CD" ).append("\n"); 
		query.append("--               DECODE(ca.LTST_RCV_DY_CD, 'MON', 1, 'TUE', 2, 'WED', 3, 'THU', 4, 'FRI', 5, 'SAT', 6, 'SUN', 7) SORT               " ).append("\n"); 
		query.append("          FROM PRD_CND_CCT_ITVAL_MGMT ca," ).append("\n"); 
		query.append("               PRD_USA_CCT_ITVAL_MGMT us" ).append("\n"); 
		query.append("          where ca.LTST_RCV_DY_CD = us.LTST_RCV_DY_CD               " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("ORDER BY SORT" ).append("\n"); 

	}
}