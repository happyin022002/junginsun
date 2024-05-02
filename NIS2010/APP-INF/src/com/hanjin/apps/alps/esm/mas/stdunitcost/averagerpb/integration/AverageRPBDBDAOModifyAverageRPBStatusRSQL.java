/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AverageRPBDBDAOModifyAverageRPBStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AverageRPBDBDAOModifyAverageRPBStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAverageRPBStatus
	  * </pre>
	  */
	public AverageRPBDBDAOModifyAverageRPBStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_target_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.integration").append("\n"); 
		query.append("FileName : AverageRPBDBDAOModifyAverageRPBStatusRSQL").append("\n"); 
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
		query.append("        SELECT REPLACE(@[f_target_yrmon],'-','') AS COST_YRMON" ).append("\n"); 
		query.append("               , COST_WK" ).append("\n"); 
		query.append("               , 'RPBC' AS CM_UC_CD" ).append("\n"); 
		query.append("               , 'P' AS COST_CRE_STS_CD" ).append("\n"); 
		query.append("			   , REPLACE(@[f_fm_yrwk],'-','') AS COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("			   , REPLACE(@[f_to_yrwk],'-','') AS COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("           FROM MAS_WK_PRD" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("           AND COST_YR = SUBSTR(@[f_target_yrmon],0,4)" ).append("\n"); 
		query.append("           AND TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT        " ).append("\n"); 
		query.append("      ) A2" ).append("\n"); 
		query.append("  ON (    A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("      AND A1.COST_WK    = A2.COST_WK" ).append("\n"); 
		query.append("      AND A1.CM_UC_CD   = A2.CM_UC_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT(A1.COST_YRMON, A1.COST_WK, A1.CM_UC_CD, A1.COST_CRE_STS_CD, A1.COST_IF_STS_CD" ).append("\n"); 
		query.append("           ,A1.COST_SRC_FM_YRMON, A1.COST_SRC_TO_YRMON, A1.CRE_USR_ID, A1.CRE_DT, A1.UPD_USR_ID, A1.UPD_DT)" ).append("\n"); 
		query.append("     VALUES(A2.COST_YRMON, A2.COST_WK, A2.CM_UC_CD, A2.COST_CRE_STS_CD, ''" ).append("\n"); 
		query.append("           ,A2.COST_SRC_FM_YRMON, A2.COST_SRC_TO_YRMON, @[usr_id] , SYSDATE  , @[usr_id] , SYSDATE )         " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET A1.COST_CRE_STS_CD = A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("           ,A1.UPD_USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("           ,A1.UPD_DT          = SYSDATE" ).append("\n"); 

	}
}