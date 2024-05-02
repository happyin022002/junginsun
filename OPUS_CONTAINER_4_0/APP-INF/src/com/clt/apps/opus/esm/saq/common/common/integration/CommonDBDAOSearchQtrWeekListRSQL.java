/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchQtrWeekListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchQtrWeekListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당년도, 분기의 주차 가져오기
	  * </pre>
	  */
	public CommonDBDAOSearchQtrWeekListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bseMon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchQtrWeekListRSQL").append("\n"); 
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
		query.append("SELECT COST_WK AS CODE, " ).append("\n"); 
		query.append("       COST_WK AS TEXT  " ).append("\n"); 
		query.append("FROM   COA_WK_PRD " ).append("\n"); 
		query.append("WHERE  COST_YR    = @[year] " ).append("\n"); 
		query.append("AND    ( " ).append("\n"); 
		query.append("        (SLS_FM_DT >= @[year]||DECODE(@[quarter], '1Q', '01', '2Q', '04', '3Q', '07', '4Q', '10')||'01' AND " ).append("\n"); 
		query.append("         SLS_FM_DT <= TO_CHAR(LAST_DAY(TO_DATE(@[year]||DECODE(@[quarter], '1Q', '03', '2Q', '06', '3Q', '09', '4Q', '12'), 'YYYYMM')), 'YYYYMMDD')) OR " ).append("\n"); 
		query.append("        (SLS_TO_DT >= @[year]||DECODE(@[quarter], '1Q', '01', '2Q', '04', '3Q', '07', '4Q', '10')||'01' AND " ).append("\n"); 
		query.append("         SLS_TO_DT <= TO_CHAR(LAST_DAY(TO_DATE(@[year]||DECODE(@[quarter], '1Q', '03', '2Q', '06', '3Q', '09', '4Q', '12'), 'YYYYMM')), 'YYYYMMDD'))    " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("AND    NVL(@[bseMon], '00') BETWEEN DECODE(NVL(@[bseMon], '00'), '00', '00', SUBSTR(SLS_FM_DT, 5, 2))  " ).append("\n"); 
		query.append("                    AND     DECODE(NVL(@[bseMon], '00'), '00', '00', SUBSTR(SLS_TO_DT, 5, 2))  " ).append("\n"); 

	}
}