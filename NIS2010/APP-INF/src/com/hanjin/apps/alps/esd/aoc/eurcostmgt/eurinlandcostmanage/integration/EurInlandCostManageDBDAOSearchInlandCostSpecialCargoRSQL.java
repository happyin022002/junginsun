/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EurInlandCostManageDBDAOSearchInlandCostSpecialCargoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurInlandCostManageDBDAOSearchInlandCostSpecialCargoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlandCostSpecialCargo
	  * </pre>
	  */
	public EurInlandCostManageDBDAOSearchInlandCostSpecialCargoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.integration").append("\n"); 
		query.append("FileName : EurInlandCostManageDBDAOSearchInlandCostSpecialCargoRSQL").append("\n"); 
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
		query.append("SELECT TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(",CNTR_SZ_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",DCGO_SVC_FLG" ).append("\n"); 
		query.append(",DG_FX_RT" ).append("\n"); 
		query.append(",DG_FX_RTO" ).append("\n"); 
		query.append(",OVWT_CGO_SVC_FLG" ).append("\n"); 
		query.append(",MIN_CGO_WGT" ).append("\n"); 
		query.append(",MAX_CGO_WGT" ).append("\n"); 
		query.append(",OVR_WGT_FX_RT" ).append("\n"); 
		query.append(",OVR_WGT_FX_RTO" ).append("\n"); 
		query.append(",COST_TRF_NO" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append("FROM AOC_EUR_INLND_SPCL_TRF_DTL" ).append("\n"); 
		query.append("WHERE COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("AND TRSP_CRR_MOD_CD IN (" ).append("\n"); 
		query.append("SELECT  D.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("FROM    AOC_EUR_INLND_TRF_HDR H" ).append("\n"); 
		query.append(", AOC_EUR_INLND_TRF_DTL D" ).append("\n"); 
		query.append("WHERE   H.COST_TRF_NO = D.COST_TRF_NO" ).append("\n"); 
		query.append("AND     H.COST_TRF_STS_CD IN ('B','U','C')" ).append("\n"); 
		query.append("AND     D.COST_SEL_ROUT_FLG = 'Y'" ).append("\n"); 
		query.append("AND     D.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND     H.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("AND     H.CNT_CD      = @[in_cnt_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CNTR_SZ_CD,TRSP_CRR_MOD_CD,CURR_CD" ).append("\n"); 

	}
}