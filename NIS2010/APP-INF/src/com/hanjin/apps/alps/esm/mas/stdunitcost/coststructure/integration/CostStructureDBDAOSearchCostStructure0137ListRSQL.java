/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostStructureDBDAOSearchCostStructure0137ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.04.20 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration").append("\n"); 
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
		query.append("       'R' IBFLAG" ).append("\n"); 
		query.append("      ,COLUMN_NAME COLNAME" ).append("\n"); 
		query.append("      ,'=' INEQUALITY" ).append("\n"); 
		query.append("      ,NULL VALUE" ).append("\n"); 
		query.append("  FROM ALL_TAB_COLUMNS" ).append("\n"); 
		query.append(" WHERE" ).append("\n"); 
		query.append("#if (${f_table_name} != 'MAS_LNK_AVG_STND_COST')" ).append("\n"); 
		query.append("   TABLE_NAME = 'MAS_NOD_AVG_STND_COST'" ).append("\n"); 
		query.append("ORDER BY DECODE(COLUMN_NAME,'COST_ACT_GRP_CD', 5, COLUMN_ID)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    TABLE_NAME = 'MAS_LNK_AVG_STND_COST'" ).append("\n"); 
		query.append("   AND COLUMN_NAME <> 'CO_CD'" ).append("\n"); 
		query.append("ORDER BY DECODE(COLUMN_NAME,'VNDR_SEQ', 6.1,'COST_ACT_GRP_CD', 6.2, COLUMN_ID)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}