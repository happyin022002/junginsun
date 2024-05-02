/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAORemoveWeekPeriodDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.04.25 김창헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang Hun Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAORemoveWeekPeriodDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveWeekPeriod
	  * </pre>
	  */
	public CostStructureDBDAORemoveWeekPeriodDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration ").append("\n"); 
		query.append("FileName : CostStructureDBDAORemoveWeekPeriodDSQL").append("\n"); 
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
		query.append("DELETE FROM COA_WK_PRD" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("	AND COST_YR = @[cost_yr]" ).append("\n"); 
		query.append("	AND COST_WK = @[cost_wk]" ).append("\n"); 

	}
}