/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAONetworkCostExceptionListCdNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.05.06 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAONetworkCostExceptionListCdNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Network Cost Exception List 의 Cost Name 을 구한다.
	  * </pre>
	  */
	public NetworkCostDBDAONetworkCostExceptionListCdNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAONetworkCostExceptionListCdNmRSQL").append("\n"); 
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
		query.append("SELECT STND_COST_CD AS CODE " ).append("\n"); 
		query.append("      ,STND_COST_NM AS F_STND_COST_NM" ).append("\n"); 
		query.append("FROM   MAS_STND_ACCT " ).append("\n"); 
		query.append("WHERE MGRP_COST_CD IN ('OV','OF','VF') -- 2015.03.18 VF 추가" ).append("\n"); 
		query.append("AND   NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND   STND_COST_CD != '54600000' " ).append("\n"); 
		query.append("AND   STND_COST_CD = @[f_stnd_cost_cd]" ).append("\n"); 
		query.append("AND   SUBSTR(STND_COST_CD,-1) != '9' -- 2015.03.18 추가" ).append("\n"); 
		query.append("ORDER BY  ACCT_DP_SEQ" ).append("\n"); 

	}
}