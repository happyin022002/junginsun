/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOMultiInlandCostUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : Chloe Mijin SEO
*@LastVersion : 1.0
* 2014.04.30 Chloe Mijin SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAOMultiInlandCostUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiInlandCost
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOMultiInlandCostUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_20ft_bzc_cost_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_40ft_bzc_cost_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trk_20ft_fuel_scg_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_trsp_20ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_20ft_fuel_scg_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trk_20ft_bzc_cost_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_40ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmst_20ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmst_40ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trk_40ft_bzc_cost_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trk_40ft_fuel_scg_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_trsp_40ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_40ft_fuel_scg_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_20ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOMultiInlandCostUSQL").append("\n"); 
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
		query.append("UPDATE  AOC_USA_INLND_TRF_DTL" ).append("\n"); 
		query.append("SET     INLND_20FT_TTL_AMT              = INLND_20FT_ORG_TTL_AMT" ).append("\n"); 
		query.append("                                        + NVL(@[rail_20ft_bzc_cost_adj_amt],0) + NVL(@[rail_20ft_fuel_scg_adj_amt],0) + NVL(@[trk_20ft_bzc_cost_adj_amt],0) + NVL(@[trk_20ft_fuel_scg_adj_amt],0) + NVL(@[mty_trsp_20ft_adj_cost_amt],0) + NVL(@[dmst_20ft_adj_cost_amt],0) + NVL(@[tml_20ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , INLND_40FT_TTL_AMT              = INLND_40FT_ORG_TTL_AMT" ).append("\n"); 
		query.append("                                        + NVL(@[rail_40ft_bzc_cost_adj_amt],0) + NVL(@[rail_40ft_fuel_scg_adj_amt],0) + NVL(@[trk_40ft_bzc_cost_adj_amt],0) + NVL(@[trk_40ft_fuel_scg_adj_amt],0) + NVL(@[mty_trsp_40ft_adj_cost_amt],0) + NVL(@[dmst_40ft_adj_cost_amt],0) + NVL(@[tml_40ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , INLND_RAIL_20FT_TTL_AMT         = RAIL_20FT_BZC_COST_AMT + RAIL_20FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("                                        + NVL(@[rail_20ft_bzc_cost_adj_amt],0) + NVL(@[rail_20ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , INLND_RAIL_40FT_TTL_AMT         = RAIL_40FT_BZC_COST_AMT + RAIL_40FT_FUEL_SCG_AMT" ).append("\n"); 
		query.append("                                        + NVL(@[rail_40ft_bzc_cost_adj_amt],0) + NVL(@[rail_40ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , INLND_TRK_20FT_TTL_AMT          = TRK_20FT_BZC_COST_AMT + TRK_20FT_FUEL_SCG_AMT + TOLL_FEE_AMT + NVL(@[trk_20ft_bzc_cost_adj_amt],0) + NVL(@[trk_20ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , INLND_TRK_40FT_TTL_AMT          = TRK_40FT_BZC_COST_AMT + TRK_40FT_FUEL_SCG_AMT + TOLL_FEE_AMT + NVL(@[trk_40ft_bzc_cost_adj_amt],0) + NVL(@[trk_40ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , RAIL_20FT_BZC_COST_ADJ_AMT      = NVL(@[rail_20ft_bzc_cost_adj_amt],0)" ).append("\n"); 
		query.append("      , RAIL_20FT_BZC_COST_TTL_AMT      = RAIL_20FT_BZC_COST_AMT + NVL(@[rail_20ft_bzc_cost_adj_amt],0)" ).append("\n"); 
		query.append("      , RAIL_40FT_BZC_COST_ADJ_AMT      = NVL(@[rail_40ft_bzc_cost_adj_amt],0)" ).append("\n"); 
		query.append("      , RAIL_40FT_BZC_COST_TTL_AMT      = RAIL_40FT_BZC_COST_AMT + NVL(@[rail_40ft_bzc_cost_adj_amt],0)" ).append("\n"); 
		query.append("      , RAIL_20FT_FUEL_SCG_ADJ_AMT      = NVL(@[rail_20ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , RAIL_20FT_FUEL_SCG_TTL_AMT      = RAIL_20FT_FUEL_SCG_AMT + NVL(@[rail_20ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , RAIL_40FT_FUEL_SCG_ADJ_AMT      = NVL(@[rail_40ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , RAIL_40FT_FUEL_SCG_TTL_AMT      = RAIL_40FT_FUEL_SCG_AMT + NVL(@[rail_40ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , TRK_20FT_BZC_COST_ADJ_AMT       = NVL(@[trk_20ft_bzc_cost_adj_amt],0)" ).append("\n"); 
		query.append("      , TRK_20FT_BZC_COST_TTL_AMT       = TRK_20FT_BZC_COST_AMT + NVL(@[trk_20ft_bzc_cost_adj_amt],0)" ).append("\n"); 
		query.append("      , TRK_40FT_BZC_COST_ADJ_AMT       = NVL(@[trk_40ft_bzc_cost_adj_amt],0)" ).append("\n"); 
		query.append("      , TRK_40FT_BZC_COST_TTL_AMT       = TRK_40FT_BZC_COST_AMT + NVL(@[trk_40ft_bzc_cost_adj_amt],0)" ).append("\n"); 
		query.append("      , TRK_20FT_FUEL_SCG_ADJ_AMT       = NVL(@[trk_20ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , TRK_20FT_FUEL_SCG_TTL_AMT       = TRK_20FT_FUEL_SCG_AMT + NVL(@[trk_20ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , TRK_40FT_FUEL_SCG_ADJ_AMT       = NVL(@[trk_40ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , TRK_40FT_FUEL_SCG_TTL_AMT       = TRK_40FT_FUEL_SCG_AMT + NVL(@[trk_40ft_fuel_scg_adj_amt],0)" ).append("\n"); 
		query.append("      , MTY_TRSP_20FT_ADJ_COST_AMT      = NVL(@[mty_trsp_20ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , MTY_TRSP_20FT_TTL_COST_AMT      = MTY_TRSP_20FT_COST_AMT + NVL(@[mty_trsp_20ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , MTY_TRSP_40FT_ADJ_COST_AMT      = NVL(@[mty_trsp_40ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , MTY_TRSP_40FT_TTL_COST_AMT      = MTY_TRSP_40FT_COST_AMT + NVL(@[mty_trsp_40ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , DMST_20FT_ADJ_COST_AMT          = NVL(@[dmst_20ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , DMST_20FT_TTL_COST_AMT          = DMST_20FT_COST_AMT + NVL(@[dmst_20ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , DMST_40FT_ADJ_COST_AMT          = NVL(@[dmst_40ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , DMST_40FT_TTL_COST_AMT          = DMST_40FT_COST_AMT + NVL(@[dmst_40ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , TML_20FT_ADJ_COST_AMT           = NVL(@[tml_20ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , TML_20FT_TTL_COST_AMT           = TML_20FT_COST_AMT + NVL(@[tml_20ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , TML_40FT_ADJ_COST_AMT           = NVL(@[tml_40ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , TML_40FT_TTL_COST_AMT           = TML_40FT_COST_AMT + NVL(@[tml_40ft_adj_cost_amt],0)" ).append("\n"); 
		query.append("      , UPD_DT                          = SYSDATE" ).append("\n"); 
		query.append("      , UPD_USR_ID                      = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE   COST_TRF_NO                     = @[cost_trf_no]" ).append("\n"); 
		query.append("AND     COST_TRF_ROUT_SEQ               = @[cost_trf_rout_seq]" ).append("\n"); 

	}
}