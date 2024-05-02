/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAOCheckCaCodeFromSubRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.30
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.30 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-Sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOCheckCaCodeFromSubRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check child C/A code data before delete sub group cost code 
	  * ESM_COA_2002
	  * </pre>
	  */
	public CostStructureDBDAOCheckCaCodeFromSubRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgrp_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration ").append("\n"); 
		query.append("FileName : CostStructureDBDAOCheckCaCodeFromSubRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM COA_STND_ACCT" ).append("\n"); 
		query.append(" WHERE SGRP_COST_CD = @[sgrp_cost_cd]" ).append("\n"); 

	}
}