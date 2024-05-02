/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOSearchCustCtrlGrpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.07
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2014.02.07 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchCustCtrlGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade, 조회주차에 해당하는 Season의 Yield Group 정보를 조회합니다.
	  * 
	  * 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
	  * </pre>
	  */
	public ModelManageDBDAOSearchCustCtrlGrpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("season",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchCustCtrlGrpRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD," ).append("\n"); 
		query.append("       COST_YRWK," ).append("\n"); 
		query.append("       SUBSTR(CUST_CTRL_CD,1,1) AS CUST_CTRL_CD," ).append("\n"); 
		query.append("       SUBSTR(CUST_CTRL_CD,2)   AS CUST_CTRL_SUB_CD," ).append("\n"); 
		query.append("       CUST_CTRL_DESC" ).append("\n"); 
		query.append("  FROM SPC_MDL_CUST_CTRL_GRP G" ).append("\n"); 
		query.append(" WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("   AND COST_YRWK = NVL(@[season], (SELECT /*+INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                          M.COST_YRWK" ).append("\n"); 
		query.append("                                     FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                    WHERE @[week] BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                      AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                      AND M.TRD_CD  = G.TRD_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM    = 1" ).append("\n"); 
		query.append("                                  ))" ).append("\n"); 

	}
}