/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOGNAExpCreByOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOGNAExpCreByOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G&A Expense Creation By Office 를 조회한다.
	  * </pre>
	  */
	public NetworkCostDBDAOGNAExpCreByOfcRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOGNAExpCreByOfcRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("	, OFC_CD" ).append("\n"); 
		query.append("	, LOCL_CURR_CD" ).append("\n"); 
		query.append("	, OFC_GRP_NO" ).append("\n"); 
		query.append("	, BUD_LOCL_AMT" ).append("\n"); 
		query.append("	, BUD_USD_AMT" ).append("\n"); 
		query.append("	, EXPN_USD_AMT" ).append("\n"); 
		query.append("	, USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT " ).append("\n"); 
		query.append("  FROM MAS_GEN_EXPN_OFC_STUP" ).append("\n"); 
		query.append(" WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append(" ORDER BY OFC_GRP_NO, OFC_CD" ).append("\n"); 

	}
}