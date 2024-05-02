/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkCostDBDAOSearchAverageCM2ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.12.22 최성민
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

public class NetworkCostDBDAOSearchAverageCM2ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average U/C (CM2) 조회
	  * </pre>
	  */
	public NetworkCostDBDAOSearchAverageCM2ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_use_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchAverageCM2ListRSQL").append("\n"); 
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
		query.append("      '' 									 IBFLAG " ).append("\n"); 
		query.append("    , '' 									 F_COST_YRMON" ).append("\n"); 
		query.append("    , TRIM(B.TRD_CD)  						 TRD_CD  	" ).append("\n"); 
		query.append("    , TRIM(B.RLANE_CD) 						 RLANE_CD " ).append("\n"); 
		query.append("    , TRIM(B.DIR_CD) 						 DIR_CD" ).append("\n"); 
		query.append(" 	, A.STND_COST_CD 						 STND_COST_CD" ).append("\n"); 
		query.append(" 	, A.STND_COST_NM 						 STND_COST_NM " ).append("\n"); 
		query.append(" 	, B.OP_COST_AMT 					     OP_COST_AMT  	" ).append("\n"); 
		query.append(" 	, B.BSA_CAPA 							 BSA_CAPA 	" ).append("\n"); 
		query.append(" 	, ROUND(DECODE(B.BSA_CAPA, 0, 0, B.OP_COST_AMT/B.BSA_CAPA),3) 	 BSA_CAPA_CAL 	" ).append("\n"); 
		query.append(" 	, B.OP_UC_AMT 				             OP_UC_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM MAS_OP_AVG_UT_COST B , MAS_STND_ACCT A " ).append("\n"); 
		query.append(" WHERE B.COST_YRMON= @[f_cost_yrmon]	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${f_trd_cd} != '')  	  " ).append("\n"); 
		query.append("   AND B.TRD_CD	    = @[f_trd_cd] " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${f_rlane_cd} != '') " ).append("\n"); 
		query.append("   AND B.RLANE_CD     = @[f_rlane_cd] " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("   AND A.STND_COST_CD = B.STND_COST_CD  " ).append("\n"); 
		query.append("   AND B.COST_USE_TP_CD = @[f_cost_use_tp_cd]" ).append("\n"); 
		query.append(" ORDER BY B.TRD_CD,  B.RLANE_CD" ).append("\n"); 

	}
}