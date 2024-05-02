/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TurnTimePerformanceMgtDAOTTMonthlyWeeklyPeriodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.06.05 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TurnTimePerformanceMgtDAOTTMonthlyWeeklyPeriodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기간을 조회한다
	  * </pre>
	  */
	public TurnTimePerformanceMgtDAOTTMonthlyWeeklyPeriodRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("#if (${period} == 'W')" ).append("\n"); 
		query.append("SELECT  /*+ INDEX ( XPKEQR_WK_PRD ) */" ).append("\n"); 
		query.append("PLN_YR||'-'||PLN_WK  period," ).append("\n"); 
		query.append("ROWNUM			sequence" ).append("\n"); 
		query.append("FROM    EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE   PLN_YR||PLN_WK >= @[from]" ).append("\n"); 
		query.append("AND     PLN_YR||PLN_WK <= @[to]" ).append("\n"); 
		query.append("#elseif (${period} == 'M')" ).append("\n"); 
		query.append("SELECT	DAY_UNIT    period," ).append("\n"); 
		query.append("ROWNUM      sequence" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  DISTINCT PLN_YR||'-'||PLN_MON  DAY_UNIT" ).append("\n"); 
		query.append("FROM    EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE   PLN_YR||PLN_MON >= SUBSTR(@[from],0,6)" ).append("\n"); 
		query.append("AND     PLN_YR||PLN_MON <= SUBSTR(@[to],0,6)" ).append("\n"); 
		query.append("ORDER BY PLN_YR||'-'||PLN_MON" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration").append("\n"); 
		query.append("FileName : TurnTimePerformanceMgtDAOTTMonthlyWeeklyPeriodRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}