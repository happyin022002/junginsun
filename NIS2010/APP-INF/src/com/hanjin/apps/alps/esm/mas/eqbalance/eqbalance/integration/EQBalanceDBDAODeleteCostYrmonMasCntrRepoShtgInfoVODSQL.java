/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EQBalanceDBDAODeleteCostYrmonMasCntrRepoShtgInfoVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAODeleteCostYrmonMasCntrRepoShtgInfoVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -MAS_CNTR_REPO_SHTG_INFO 해당연월 삭제
	  * </pre>
	  */
	public EQBalanceDBDAODeleteCostYrmonMasCntrRepoShtgInfoVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAODeleteCostYrmonMasCntrRepoShtgInfoVODSQL").append("\n"); 
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
		query.append("DELETE MAS_CNTR_REPO_SHTG_INFO" ).append("\n"); 
		query.append(" WHERE COST_YRMON    = @[f_cost_yrmon]" ).append("\n"); 

	}
}