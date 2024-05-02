/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostSetUpDBDAOChkCostSetupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOChkCostSetupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAS_MNL_COST_STUP에 해당 데이터 존재여부 확인
	  * </pre>
	  */
	public CostSetUpDBDAOChkCostSetupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOChkCostSetupRSQL").append("\n"); 
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
		query.append("SELECT COUNT(COST_YRMON) AS CNT FROM MAS_MNL_COST_STUP" ).append("\n"); 
		query.append("WHERE COST_YRMON = (SELECT COST_YR||EQ_WK FROM MAS_WK_PRD WHERE COST_YR = SUBSTR(REPLACE(@[cost_yrmon],'-',''),1,4) AND COST_WK = SUBSTR(REPLACE(@[cost_yrmon],'-',''),5,2))" ).append("\n"); 
		query.append("    AND COST_WK = SUBSTR(REPLACE(@[cost_yrmon],'-',''),5,2)" ).append("\n"); 
		query.append("	AND RLANE_CD = @[rlane_cd]" ).append("\n"); 

	}
}