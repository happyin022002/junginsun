/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CostStructureDBDAOCoaBkgCostCalcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.19 
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

public class CostStructureDBDAOCoaBkgCostCalcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Year Month를 조회한다.
	  * </pre>
	  */
	public CostStructureDBDAOCoaBkgCostCalcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOCoaBkgCostCalcVORSQL").append("\n"); 
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
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("  FROM COA_BKG_COST_CALC " ).append("\n"); 
		query.append(" WHERE COA_BAT_CD = 'A'" ).append("\n"); 

	}
}