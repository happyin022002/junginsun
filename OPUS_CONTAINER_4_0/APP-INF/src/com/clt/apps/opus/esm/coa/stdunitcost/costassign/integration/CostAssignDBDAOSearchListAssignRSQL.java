/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CostAssignDBDAOSearchListAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOSearchListAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BATCH Code별 개수 구하기
	  * </pre>
	  */
	public CostAssignDBDAOSearchListAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOSearchListAssignRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       COA_BAT_CD " ).append("\n"); 
		query.append("       ,COUNT(*) CNT " ).append("\n"); 
		query.append("FROM COA_BKG_COST_CALC" ).append("\n"); 
		query.append("#if (${f_coa_bat_cd} != '') " ).append("\n"); 
		query.append("WHERE COA_BAT_CD IN ('${f_coa_bat_cd}')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY COA_BAT_CD" ).append("\n"); 

	}
}