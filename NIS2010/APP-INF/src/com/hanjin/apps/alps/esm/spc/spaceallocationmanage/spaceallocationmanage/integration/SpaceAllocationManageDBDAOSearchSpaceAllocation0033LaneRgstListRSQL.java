/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0033LaneRgstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocation0033LaneRgstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpaceAllocation0033LaneRgstList
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocation0033LaneRgstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0033LaneRgstListRSQL").append("\n"); 
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
		query.append("SELECT REP_TRD_CD" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , DIR_CD" ).append("\n"); 
		query.append("     , EFF_FM_DT" ).append("\n"); 
		query.append("     , EFF_TO_DT" ).append("\n"); 
		query.append("     , BSA_CAPA" ).append("\n"); 
		query.append("     , ALOC_HC_CALC_QTY" ).append("\n"); 
		query.append("     , ALOC_HC_BZC_BX_QTY" ).append("\n"); 
		query.append("     , ALOC_HC_APLY_FLG" ).append("\n"); 
		query.append("     , ALOC_HC_OVR_CALC_QTY" ).append("\n"); 
		query.append("     , ALOC_45FT_CALC_QTY" ).append("\n"); 
		query.append("     , ALOC_45FT_BZC_BX_QTY" ).append("\n"); 
		query.append("     , ALOC_45FT_APLY_FLG" ).append("\n"); 
		query.append("     , ALOC_45FT_OVR_CALC_QTY" ).append("\n"); 
		query.append("FROM SPC_LANE_RGST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_trade} != '') " ).append("\n"); 
		query.append("AND REP_TRD_CD = @[f_trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trade} != '') " ).append("\n"); 
		query.append("AND SUB_TRD_CD = @[f_sub_trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_lane} != '') " ).append("\n"); 
		query.append("AND RLANE_CD = @[f_lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bound} != '') " ).append("\n"); 
		query.append("AND DIR_CD = @[f_bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY REP_TRD_CD" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , DIR_CD" ).append("\n"); 
		query.append("     , EFF_FM_DT" ).append("\n"); 
		query.append("     , EFF_TO_DT" ).append("\n"); 
		query.append("     , BSA_CAPA" ).append("\n"); 

	}
}