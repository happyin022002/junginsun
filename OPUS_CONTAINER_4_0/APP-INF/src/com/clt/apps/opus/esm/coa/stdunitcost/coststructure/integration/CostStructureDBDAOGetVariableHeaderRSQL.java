/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOGetVariableHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.11.06 김기식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki-Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOGetVariableHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Register Cost Item
	  * </pre>
	  */
	public CostStructureDBDAOGetVariableHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOGetVariableHeaderRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.COST_ACT_GRP_CD CODE" ).append("\n"); 
		query.append(",A.COST_ACT_GRP_NM  NAME" ).append("\n"); 
		query.append("FROM PRD_COST_ACT_GRP A" ).append("\n"); 
		query.append(",COA_ACT_GRP_COST_MAPG B" ).append("\n"); 
		query.append("WHERE B.COST_ACT_GRP_CD IS NOT NULL" ).append("\n"); 
		query.append("AND A.COST_ACT_GRP_CD = B.COST_ACT_GRP_CD(+)" ).append("\n"); 
		query.append("ORDER BY CODE" ).append("\n"); 

	}
}