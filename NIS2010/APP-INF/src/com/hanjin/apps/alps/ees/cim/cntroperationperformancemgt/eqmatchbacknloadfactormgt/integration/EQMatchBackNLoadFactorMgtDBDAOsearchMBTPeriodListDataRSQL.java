/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOsearchMBTPeriodListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.30
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.30 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOsearchMBTPeriodListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMBTPeriodListData
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOsearchMBTPeriodListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tos",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("froms",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOsearchMBTPeriodListDataRSQL").append("\n"); 
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
		query.append("#if (${period} == 'M')" ).append("\n"); 
		query.append("SELECT DAY_UNIT DAY_UNIT, ROWNUM DAY_SEQ" ).append("\n"); 
		query.append("FROM (SELECT DISTINCT PLN_YR || '-' || PLN_MON DAY_UNIT" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR || PLN_MON || '01' >= @[from_dt]" ).append("\n"); 
		query.append("AND PLN_YR || PLN_MON || SUBSTR(@[to_dt], 7, 2) <= @[to_dt]" ).append("\n"); 
		query.append("ORDER BY PLN_YR || '-' || PLN_MON)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT PLN_YR || '-' ||PLN_WK DAY_UNIT, ROWNUM DAY_SEQ" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR || PLN_WK BETWEEN REPLACE(@[froms], '-', '') AND REPLACE(@[tos], '-', '')" ).append("\n"); 
		query.append("ORDER BY PLN_YR, PLN_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}