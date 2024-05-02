/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetworkCostDBDAOUnitCostCreationStatusUSQL.java
*@FileTitle : Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.10.22 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOUnitCostCreationStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create
	  * </pre>
	  */
	public NetworkCostDBDAOUnitCostCreationStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOUnitCostCreationStatusUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_UT_COST_CRE_STS A1 USING (" ).append("\n"); 
		query.append(" SELECT REPLACE(@[f_cost_yrmon],'-','') COST_YRMON " ).append("\n"); 
		query.append("      , '00' COST_WK" ).append("\n"); 
		query.append("      , @[f_type_cd] CM_UC_CD" ).append("\n"); 
		query.append("      , 'C' COST_CRE_STS_CD" ).append("\n"); 
		query.append("   FROM DUAL" ).append("\n"); 
		query.append(") A2 ON ( A1.COST_YRMON = A2.COST_YRMON " ).append("\n"); 
		query.append("        AND A1.COST_WK = A2.COST_WK " ).append("\n"); 
		query.append("        AND A1.CM_UC_CD = A2.CM_UC_CD )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("         INSERT" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        A1.COST_YRMON" ).append("\n"); 
		query.append("                      , A1.COST_WK" ).append("\n"); 
		query.append("                      , A1.CM_UC_CD" ).append("\n"); 
		query.append("                      , A1.COST_CRE_STS_CD" ).append("\n"); 
		query.append("                      , A1.COST_IF_STS_CD" ).append("\n"); 
		query.append("                      , A1.COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("                      , A1.COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("                      , A1.CRE_USR_ID" ).append("\n"); 
		query.append("                      , A1.CRE_DT" ).append("\n"); 
		query.append("                      , A1.UPD_USR_ID" ).append("\n"); 
		query.append("                      , A1.UPD_DT" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                VALUES" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        A2.COST_YRMON" ).append("\n"); 
		query.append("                      , A2.COST_WK" ).append("\n"); 
		query.append("                      , A2.CM_UC_CD" ).append("\n"); 
		query.append("                      , A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("                      , ''" ).append("\n"); 
		query.append("                      , REPLACE(@[f_fm_wk],'-','')" ).append("\n"); 
		query.append("                      , REPLACE(@[f_to_wk],'-','')" ).append("\n"); 
		query.append("                      , @[user_id]" ).append("\n"); 
		query.append("                      , SYSDATE" ).append("\n"); 
		query.append("                      , @[user_id]" ).append("\n"); 
		query.append("                      , SYSDATE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("        SET A1.COST_CRE_STS_CD       = A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("              , A1.COST_SRC_FM_YRMON = REPLACE(@[f_fm_wk],'-','')" ).append("\n"); 
		query.append("              , A1.COST_SRC_TO_YRMON = REPLACE(@[f_to_wk],'-','')" ).append("\n"); 
		query.append("              , A1.UPD_USR_ID        = @[user_id]" ).append("\n"); 
		query.append("              , A1.UPD_DT            = SYSDATE" ).append("\n"); 

	}
}