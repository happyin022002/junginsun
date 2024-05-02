/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOlastWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOlastWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Period로 부터 넘어온 week("YYYYWW")의 last_week("YYYYWW")를 구한다.
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOlastWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOlastWeekRSQL").append("\n"); 
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
		query.append("SELECT W.PLN_YR||W.PLN_WK as LAST_PERIOD_WEEK" ).append("\n"); 
		query.append("  FROM EQR_WK_PRD W" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND TO_CHAR" ).append("\n"); 
		query.append("    ((" ).append("\n"); 
		query.append("	  select to_date(WK_ST_DT, 'YYYYMMDD')-7 " ).append("\n"); 
		query.append("	  from EQR_WK_PRD X" ).append("\n"); 
		query.append("	  where X.PLN_YR = substr(@[period_week],1, instr(@[period_week], '-', 1) -1 ) -- year" ).append("\n"); 
		query.append("	  and X.PLN_WK = substr(@[period_week], instr(@[period_week], '-', 1) +1, length(@[period_week]) -- week " ).append("\n"); 
		query.append("	 )), 'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT" ).append("\n"); 

	}
}