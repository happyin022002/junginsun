/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostStructureDBDAOSearchCostStructure0137List2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchCostStructure0137List2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NODE, LINK 컬럼 혹은 LIST 조회
	  * </pre>
	  */
	public CostStructureDBDAOSearchCostStructure0137List2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchCostStructure0137List2RSQL").append("\n"); 
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
		query.append("#if (${f_table_name} != 'COA_NOD_AVG_STND_COST')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${f_row_count} != 'Y')" ).append("\n"); 
		query.append("A.COST_YRMON 							" ).append("\n"); 
		query.append("	   ,A.FULL_MTY_CD						" ).append("\n"); 
		query.append("	   ,A.CNTR_TPSZ_CD						" ).append("\n"); 
		query.append("	   ,A.COST_LOC_GRP_CD 					" ).append("\n"); 
		query.append("	   ,A.LNK_FM_NOD_CD						" ).append("\n"); 
		query.append("	   ,A.LNK_TO_NOD_CD		" ).append("\n"); 
		query.append("	   ,A.CO_CD								" ).append("\n"); 
		query.append("	   ,B.STND_COST_CD						" ).append("\n"); 
		query.append("	   ,A.COA_COST_SRC_CD AS COA_COST_SRC_CD_V 					" ).append("\n"); 
		query.append("	   ,A.COA_COST_SRC_CD						 										" ).append("\n"); 
		query.append("	   ,A.LOCL_CURR_CD						" ).append("\n"); 
		query.append("	   ,A.COST_FX_FLG					" ).append("\n"); 
		query.append("	   ,A.STND_COST_USD_AMT			" ).append("\n"); 
		query.append("	   ,A.LNK_TTL_QTY 						" ).append("\n"); 
		query.append("	   ,A.LNK_TTL_AMT 						" ).append("\n"); 
		query.append("	   ,A.COST_VOL_CD						" ).append("\n"); 
		query.append("	  ,(	SELECT DECODE(SUM(DECODE(SUBSTR(COA_COST_SRC_CD, 1, 1), 'S', 0, LNK_TTL_QTY))" ).append("\n"); 
		query.append("	                     , 0, null " ).append("\n"); 
		query.append("	                     ,ROUND(SUM(LNK_TTL_AMT)/SUM(DECODE(SUBSTR(COA_COST_SRC_CD, 1, 1), 'S', 0, LNK_TTL_QTY)), 3))" ).append("\n"); 
		query.append("			FROM   COA_LNK_AVG_STND_COST 							" ).append("\n"); 
		query.append("			WHERE  COST_YRMON       =  A.COST_YRMON 					" ).append("\n"); 
		query.append("			AND    LNK_FM_NOD_CD    =  A.LNK_FM_NOD_CD 				" ).append("\n"); 
		query.append("			AND    LNK_TO_NOD_CD    =  A.LNK_TO_NOD_CD 				" ).append("\n"); 
		query.append("			AND    CO_CD            =  A.CO_CD 						" ).append("\n"); 
		query.append("			AND    CNTR_TPSZ_CD     =  A.CNTR_TPSZ_CD 				" ).append("\n"); 
		query.append("			AND    FULL_MTY_CD      =  A.FULL_MTY_CD 				" ).append("\n"); 
		query.append("			AND    COST_LOC_GRP_CD  = A.COST_LOC_GRP_CD )  AS MTY_UC_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("COUNT(*) ROWCNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM COA_LNK_AVG_STND_COST A, COA_COST_SRC_ACCT B" ).append("\n"); 
		query.append("WHERE A.COA_COST_SRC_CD = B.COA_COST_SRC_CD" ).append("\n"); 
		query.append("AND A.CO_CD = 'N'" ).append("\n"); 
		query.append("	#foreach( ${condition} in ${conditionArr})" ).append("\n"); 
		query.append("	AND A.${condition.colName} ${condition.inEquality} ${condition.value}" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("#if (${f_row_count} != 'Y')	" ).append("\n"); 
		query.append("A.COST_YRMON 									" ).append("\n"); 
		query.append("		,A.FULL_MTY_CD								" ).append("\n"); 
		query.append("		,A.CNTR_TPSZ_CD								" ).append("\n"); 
		query.append("		,A.COST_LOC_GRP_CD						" ).append("\n"); 
		query.append("		,A.NOD_CD										" ).append("\n"); 
		query.append("		,A.TRD_CD" ).append("\n"); 
		query.append("		,A.COST_ACT_GRP_CD								        " ).append("\n"); 
		query.append("		,B.STND_COST_CD 												" ).append("\n"); 
		query.append("		,A.COA_COST_SRC_CD AS COA_COST_SRC_CD_V 							" ).append("\n"); 
		query.append("		,A.COA_COST_SRC_CD 							" ).append("\n"); 
		query.append("		,A.LOCL_CURR_CD          LOCL_CURR_CD 								" ).append("\n"); 
		query.append("		,A.COST_FX_FLG           COST_FX_FLG 								" ).append("\n"); 
		query.append("		,A.STND_COST_USD_AMT     STND_COST_USD_AMT 							" ).append("\n"); 
		query.append("		,A.NOD_TTL_QTY           NOD_TTL_QTY 								" ).append("\n"); 
		query.append("		,A.NOD_TTL_AMT           NOD_TTL_AMT 								" ).append("\n"); 
		query.append("		,A.COST_VOL_CD           COST_VOL_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("COUNT(*) ROWCNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM COA_NOD_AVG_STND_COST A, COA_COST_SRC_ACCT B" ).append("\n"); 
		query.append("WHERE A.COA_COST_SRC_CD = B.COA_COST_SRC_CD" ).append("\n"); 
		query.append("	#foreach( ${condition} in ${conditionArr})" ).append("\n"); 
		query.append("	AND A.${condition.colName} ${condition.inEquality} ${condition.value}" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}