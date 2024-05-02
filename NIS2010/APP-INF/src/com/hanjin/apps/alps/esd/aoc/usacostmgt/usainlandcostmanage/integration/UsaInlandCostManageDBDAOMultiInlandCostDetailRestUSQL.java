/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOMultiInlandCostDetailRestUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAOMultiInlandCostDetailRestUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiInlandCostDetailRest
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOMultiInlandCostDetailRestUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_rout_grp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOMultiInlandCostDetailRestUSQL").append("\n"); 
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
		query.append("UPDATE AOC_USA_INLND_TRF_DTL" ).append("\n"); 
		query.append("   SET INLND_20FT_TTL_AMT = INLND_20FT_ORG_TTL_AMT" ).append("\n"); 
		query.append("      ,INLND_40FT_TTL_AMT = INLND_40FT_ORG_TTL_AMT" ).append("\n"); 
		query.append("	  ,RAIL_20FT_BZC_COST_TTL_AMT = RAIL_20FT_BZC_COST_AMT" ).append("\n"); 
		query.append(" 	  ,RAIL_20FT_BZC_COST_ADJ_AMT = 0" ).append("\n"); 
		query.append("	  ,RAIL_40FT_BZC_COST_TTL_AMT = RAIL_40FT_BZC_COST_AMT" ).append("\n"); 
		query.append("	  ,RAIL_40FT_BZC_COST_ADJ_AMT = 0" ).append("\n"); 
		query.append("	  ,RAIL_20FT_FUEL_SCG_TTL_AMT = RAIL_20FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("	  ,RAIL_20FT_FUEL_SCG_ADJ_AMT = 0" ).append("\n"); 
		query.append("	  ,RAIL_40FT_FUEL_SCG_TTL_AMT = RAIL_40FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("	  ,RAIL_40FT_FUEL_SCG_ADJ_AMT = 0" ).append("\n"); 
		query.append("	  ,TRK_20FT_BZC_COST_TTL_AMT  = TRK_20FT_BZC_COST_AMT" ).append("\n"); 
		query.append("	  ,TRK_20FT_BZC_COST_ADJ_AMT  = 0" ).append("\n"); 
		query.append("	  ,TRK_40FT_BZC_COST_TTL_AMT  = TRK_40FT_BZC_COST_AMT" ).append("\n"); 
		query.append("	  ,TRK_40FT_BZC_COST_ADJ_AMT  = 0" ).append("\n"); 
		query.append("	  ,TRK_20FT_FUEL_SCG_TTL_AMT  = TRK_20FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("	  ,TRK_20FT_FUEL_SCG_ADJ_AMT  = 0" ).append("\n"); 
		query.append("	  ,TRK_40FT_FUEL_SCG_TTL_AMT  = TRK_40FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("	  ,TRK_40FT_FUEL_SCG_ADJ_AMT  = 0" ).append("\n"); 
		query.append("      ,MTY_TRSP_20FT_TTL_COST_AMT = MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      ,MTY_TRSP_40FT_TTL_COST_AMT = MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      ,MTY_TRSP_20FT_ADJ_COST_AMT = 0" ).append("\n"); 
		query.append("      ,MTY_TRSP_40FT_ADJ_COST_AMT = 0" ).append("\n"); 
		query.append("	  ,DMST_20FT_TTL_COST_AMT = DMST_20FT_COST_AMT" ).append("\n"); 
		query.append("	  ,DMST_20FT_ADJ_COST_AMT = 0" ).append("\n"); 
		query.append("	  ,DMST_40FT_TTL_COST_AMT = DMST_40FT_COST_AMT" ).append("\n"); 
		query.append("	  ,DMST_40FT_ADJ_COST_AMT =0" ).append("\n"); 
		query.append("      ,TML_20FT_TTL_COST_AMT = TML_20FT_COST_AMT" ).append("\n"); 
		query.append("      ,TML_40FT_TTL_COST_AMT = TML_40FT_COST_AMT" ).append("\n"); 
		query.append("      ,TML_20FT_ADJ_COST_AMT = 0" ).append("\n"); 
		query.append("      ,TML_40FT_ADJ_COST_AMT = 0" ).append("\n"); 
		query.append("      ,UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(" WHERE COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append("   AND COST_ROUT_GRP_NO = @[cost_rout_grp_no]" ).append("\n"); 
		query.append("   AND COST_SEL_ROUT_FLG <> 'Y'" ).append("\n"); 

	}
}