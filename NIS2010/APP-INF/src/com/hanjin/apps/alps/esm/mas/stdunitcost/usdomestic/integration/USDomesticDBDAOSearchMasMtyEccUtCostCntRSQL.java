/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOSearchMasMtyEccUtCostCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.11.26 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song HoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOSearchMasMtyEccUtCostCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMasMtyEccUtCostCnt
	  * </pre>
	  */
	public USDomesticDBDAOSearchMasMtyEccUtCostCntRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOSearchMasMtyEccUtCostCntRSQL").append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("SELECT 	COUNT(1) AS CNT FROM MAS_MTY_ECC_UT_COST" ).append("\n"); 
		query.append("WHERE 	COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("||'|'||" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	COUNT(1) AS CNT FROM MAS_UT_COST_CRE_STS" ).append("\n"); 
		query.append("WHERE	COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '') " ).append("\n"); 
		query.append("AND		COST_WK = (SELECT MIN(COST_WK) FROM MAS_WK_PRD WHERE SLS_FM_DT LIKE REPLACE(@[f_cost_yrmon], '-', '')||'%' ) " ).append("\n"); 
		query.append("AND		CM_UC_CD = 'USDM' " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 

	}
}