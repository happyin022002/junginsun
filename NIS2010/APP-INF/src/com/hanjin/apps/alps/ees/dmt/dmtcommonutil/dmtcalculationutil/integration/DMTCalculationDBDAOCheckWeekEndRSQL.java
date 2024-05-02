/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCalculationDBDAOCheckWeekEndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("term_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOCheckWeekEndRSQL").append("\n"); 
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
		query.append("#if (${loc_cd} != 'X')" ).append("\n"); 
		query.append("#if (${exp_type} != 'SC')" ).append("\n"); 
		query.append("OR ( @[loc_cd] IN ('USSFO', 'USOAK', 'USLGB', 'USLAX', 'USGAC')" ).append("\n"); 
		query.append("AND @[term_cd] = 'Y'" ).append("\n"); 
		query.append("AND SUBSTR(@[trf_cd], 2, 1) = 'T'" ).append("\n"); 
		query.append("AND ( 'SAT' = @[week_of_day]" ).append("\n"); 
		query.append("OR 'SUN' = @[week_of_day]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("OR ( @[loc_cd] IN ('USSFO', 'USOAK', 'USLGB', 'USLAX', 'USGAC')" ).append("\n"); 
		query.append("AND @[term_cd] = 'Y'" ).append("\n"); 
		query.append("AND SUBSTR(@[trf_cd], 2, 1) = 'T'" ).append("\n"); 
		query.append("AND (( 'SAT' = @[week_of_day] AND  'Y' = @[excl_sat])" ).append("\n"); 
		query.append("OR ('SUN' = @[week_of_day] AND  'Y' = @[excl_sun])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}