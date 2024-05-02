/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostSetUpDBDAOModifyCoaUtCostCreStsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2015.05.28 이윤정
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

public class CostSetUpDBDAOModifyCoaUtCostCreStsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CostSetUpDBDAOModifyCoaUtCostCreStsUSQL
	  * </pre>
	  */
	public CostSetUpDBDAOModifyCoaUtCostCreStsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOModifyCoaUtCostCreStsUSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_UT_COST_CRE_STS A1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT REPLACE(@[cost_yrmon],'-','') AS COST_YRMON" ).append("\n"); 
		query.append("               , '00' COST_WK" ).append("\n"); 
		query.append("               , 'MRCD' AS CM_UC_CD" ).append("\n"); 
		query.append("           FROM DUAL       " ).append("\n"); 
		query.append("      ) A2" ).append("\n"); 
		query.append("  ON (    A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("      AND A1.COST_WK    = A2.COST_WK" ).append("\n"); 
		query.append("      AND A1.CM_UC_CD   = A2.CM_UC_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT(A1.COST_YRMON, A1.COST_WK, A1.CM_UC_CD, A1.COST_CRE_STS_CD, A1.CRE_USR_ID, A1.CRE_DT, A1.UPD_USR_ID, A1.UPD_DT)" ).append("\n"); 
		query.append("     VALUES(REPLACE(@[cost_yrmon],'-',''), '00', 'MRCD', 'C', @[user_id], SYSDATE, @[user_id], SYSDATE )         " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET A1.UPD_USR_ID      = @[user_id]" ).append("\n"); 
		query.append("           ,A1.UPD_DT          = SYSDATE" ).append("\n"); 

	}
}