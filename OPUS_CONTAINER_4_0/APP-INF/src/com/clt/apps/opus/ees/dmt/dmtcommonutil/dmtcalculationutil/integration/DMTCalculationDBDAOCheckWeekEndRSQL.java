/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOCheckWeekEndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.02 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOCheckWeekEndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckWeekEnd
	  * </pre>
	  */
	public DMTCalculationDBDAOCheckWeekEndRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("excl_sun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week_of_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("excl_sat",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT 'Y' EXIST" ).append("\n"); 
		query.append("FROM DMT_WEEKEND" ).append("\n"); 
		query.append("WHERE (    CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND (   (    WKND_TP_CD = 'TF'" ).append("\n"); 
		query.append("AND (   (    'THU' = @[week_of_day]" ).append("\n"); 
		query.append("AND 'Y' = @[excl_sat])" ).append("\n"); 
		query.append("OR (    'FRI' = @[week_of_day]" ).append("\n"); 
		query.append("AND 'Y' = @[excl_sun])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR (    WKND_TP_CD = 'FS'" ).append("\n"); 
		query.append("AND (   (    'FRI' = @[week_of_day]" ).append("\n"); 
		query.append("AND 'Y' = @[excl_sat])" ).append("\n"); 
		query.append("OR (    'SAT' = @[week_of_day]" ).append("\n"); 
		query.append("AND 'Y' = @[excl_sun])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR (    0 = (SELECT COUNT (CNT_CD)" ).append("\n"); 
		query.append("FROM DMT_WEEKEND" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cnt_cd])" ).append("\n"); 
		query.append("AND (   (    'SAT' = @[week_of_day]" ).append("\n"); 
		query.append("AND 'Y' = @[excl_sat])" ).append("\n"); 
		query.append("OR (    'SUN' = @[week_of_day]" ).append("\n"); 
		query.append("AND 'Y' = @[excl_sun])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOCheckWeekEndRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}