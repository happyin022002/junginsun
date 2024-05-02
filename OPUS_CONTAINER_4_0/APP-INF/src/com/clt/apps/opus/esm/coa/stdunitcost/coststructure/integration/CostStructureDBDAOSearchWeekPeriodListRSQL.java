/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAOSearchWeekPeriodListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchWeekPeriodListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchWeekPeriodList
	  * </pre>
	  */
	public CostStructureDBDAOSearchWeekPeriodListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchWeekPeriodListRSQL").append("\n"); 
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
		query.append("SELECT /*+ index_asc(COA_WK_PRD XPKCOA_WK_PRD)*/ " ).append("\n"); 
		query.append("	COST_YR," ).append("\n"); 
		query.append("	COST_WK," ).append("\n"); 
		query.append("	SLS_FM_DT," ).append("\n"); 
		query.append("	SLS_TO_DT" ).append("\n"); 
		query.append("FROM COA_WK_PRD" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${cost_yr} != '')" ).append("\n"); 
		query.append("	AND COST_YR = @[cost_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cost_wk_fm} != '')" ).append("\n"); 
		query.append("	AND COST_WK >= @[cost_wk_fm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cost_wk_to} != '')" ).append("\n"); 
		query.append("	AND COST_WK <= @[cost_wk_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}