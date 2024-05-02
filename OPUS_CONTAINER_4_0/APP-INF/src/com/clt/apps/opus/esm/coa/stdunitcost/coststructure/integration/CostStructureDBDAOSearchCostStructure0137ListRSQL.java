/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostStructureDBDAOSearchCostStructure0137ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.19 
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

public class CostStructureDBDAOSearchCostStructure0137ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CostStructureDBDAOSearchCostStructure0137ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchCostStructure0137ListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'R' IBFLAG" ).append("\n"); 
		query.append(", COLUMN_NAME COLNAME" ).append("\n"); 
		query.append(", '=' INEQUALITY" ).append("\n"); 
		query.append(", NULL VALUE" ).append("\n"); 
		query.append("FROM ALL_TAB_COLUMNS" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if (${f_table_name} != 'COA_LNK_AVG_STND_COST')" ).append("\n"); 
		query.append("TABLE_NAME = 'COA_NOD_AVG_STND_COST'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("TABLE_NAME = 'COA_LNK_AVG_STND_COST'" ).append("\n"); 
		query.append("AND COLUMN_NAME <> 'CO_CD'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY COLUMN_ID" ).append("\n"); 

	}
}