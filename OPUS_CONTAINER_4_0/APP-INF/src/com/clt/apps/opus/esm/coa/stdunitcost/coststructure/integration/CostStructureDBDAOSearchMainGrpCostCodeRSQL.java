/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAOSearchMainGrpCostCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.20
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.20 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-Sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchMainGrpCostCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Main group cost code 조회
	  * </pre>
	  */
	public CostStructureDBDAOSearchMainGrpCostCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_profitLevelCombo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchMainGrpCostCodeRSQL").append("\n"); 
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
		query.append("SELECT STND_COST_TP_CD" ).append("\n"); 
		query.append("      ,MGRP_COST_CD" ).append("\n"); 
		query.append("      ,MGRP_COST_CD_DESC" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("  FROM COA_MN_GRP_COST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_profitLevelCombo} != 'All') " ).append("\n"); 
		query.append(" WHERE STND_COST_TP_CD = @[f_profitLevelCombo]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ORDER BY STND_COST_TP_CD, MGRP_COST_CD" ).append("\n"); 

	}
}