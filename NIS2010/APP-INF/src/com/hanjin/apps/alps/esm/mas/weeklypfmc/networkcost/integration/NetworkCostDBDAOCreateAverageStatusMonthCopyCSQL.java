/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetworkCostDBDAOCreateAverageStatusMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.10.30 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreateAverageStatusMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average UC 월단가를 복사해서 생성한다.
	  * </pre>
	  */
	public NetworkCostDBDAOCreateAverageStatusMonthCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreateAverageStatusMonthCopyCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_UT_COST_CRE_STS A1 USING (" ).append("\n"); 
		query.append(" SELECT @[f_tar_mon] COST_YRMON" ).append("\n"); 
		query.append("      , COST_WK" ).append("\n"); 
		query.append("      , CM_UC_CD" ).append("\n"); 
		query.append("      , COST_CRE_STS_CD" ).append("\n"); 
		query.append("      , COST_IF_STS_CD" ).append("\n"); 
		query.append("      , COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("      , COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("   FROM MAS_UT_COST_CRE_STS" ).append("\n"); 
		query.append("  WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 
		query.append("    AND COST_WK = '00'" ).append("\n"); 
		query.append("    AND CM_UC_CD = 'OP04'" ).append("\n"); 
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
		query.append("                      , A2.COST_IF_STS_CD" ).append("\n"); 
		query.append("                      , A2.COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("                      , A2.COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("                      , @[user_id]" ).append("\n"); 
		query.append("                      , SYSDATE" ).append("\n"); 
		query.append("                      , @[user_id]" ).append("\n"); 
		query.append("                      , SYSDATE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("        SET A1.COST_CRE_STS_CD       = A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("              , A1.COST_SRC_FM_YRMON = A2.COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("              , A1.COST_SRC_TO_YRMON = A2.COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("              , A1.UPD_USR_ID        = @[user_id]" ).append("\n"); 
		query.append("              , A1.UPD_DT            = SYSDATE" ).append("\n"); 

	}
}