/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MTCostDBDAOEqRepoCostVO02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOEqRepoCostVO02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @SJH.20141001 : COA_FULL_SCC_IMBAL 조회
	  * @SJH.20141106 : 필드, 조건절, 변수명 수정
	  * </pre>
	  */
	public MTCostDBDAOEqRepoCostVO02RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_src_to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_src_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOEqRepoCostVO02RSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,SCC_CD" ).append("\n"); 
		query.append("      ,COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("      ,COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("      ,ORG_NOD_CD" ).append("\n"); 
		query.append("      ,DEST_NOD_CD" ).append("\n"); 
		query.append("      ,TRSP_MTY_COST_MOD_NM			--SJH.20141127.MOD" ).append("\n"); 
		query.append("      ,MTY_QTY" ).append("\n"); 
		query.append("      ,MTY_UT_AMT" ).append("\n"); 
		query.append("  FROM COA_MTY_COST_HIS" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   --SJH.20141106.MOD" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD       	= @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("   AND SCC_CD             	= @[f_scc_cd]" ).append("\n"); 
		query.append("   AND COST_SRC_FM_YRMON  	= @[f_cost_src_fm_yrmon]" ).append("\n"); 
		query.append("   AND COST_SRC_TO_YRMON  	= @[f_cost_src_to_yrmon]" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD, SCC_CD, COST_SRC_FM_YRMON, COST_SRC_TO_YRMON, ORG_NOD_CD, DEST_NOD_CD, TRSP_MTY_COST_MOD_NM" ).append("\n"); 

	}
}