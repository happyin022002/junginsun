/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOSearchCostStructure0140ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.10.13 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchCostStructure0140ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Feeder Term Ratio 조회   
	  * </pre>
	  */
	public CostStructureDBDAOSearchCostStructure0140ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_wtr_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_calc_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchCostStructure0140ListVORSQL").append("\n"); 
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
		query.append("SELECT  COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",CALC_TERM_CD" ).append("\n"); 
		query.append(",WTR_TERM_CD" ).append("\n"); 
		query.append(",WTR_MOD_FLG" ).append("\n"); 
		query.append(",NVL(NOD_STVG_RTO, 0) NOD_STVG_RTO" ).append("\n"); 
		query.append(",NVL(NOD_THRP_RTO, 0) NOD_THRP_RTO" ).append("\n"); 
		query.append(",NVL(NOD_TML_RTO, 0) NOD_TML_RTO" ).append("\n"); 
		query.append(",NVL(NXT_NOD_STVG_RTO, 0) NXT_NOD_STVG_RTO" ).append("\n"); 
		query.append(",NVL(NXT_NOD_THRP_RTO, 0) NXT_NOD_THRP_RTO" ).append("\n"); 
		query.append(",NVL(NXT_NOD_TML_RTO, 0) NXT_NOD_TML_RTO" ).append("\n"); 
		query.append("FROM  COA_TRNS_TERM_CALC" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${f_calc_term_cd} != '')" ).append("\n"); 
		query.append("AND  CALC_TERM_CD = @[f_calc_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_wtr_term_cd} != '')" ).append("\n"); 
		query.append("AND  WTR_TERM_CD  = @[f_wtr_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}