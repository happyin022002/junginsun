/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EurOceanFeederCostManageDBDAOMultiFeederRfCostUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.09
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.08.09 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurOceanFeederCostManageDBDAOMultiFeederRfCostUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.04 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
	  * </pre>
	  */
	public EurOceanFeederCostManageDBDAOMultiFeederRfCostUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_20ft_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_20ft_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_40ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_20ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_40ft_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_40ft_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_40ft_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_trsp_20ft_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_20ft_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_trsp_40ft_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_20ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : EurOceanFeederCostManageDBDAOMultiFeederRfCostUSQL").append("\n"); 
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
		query.append("UPDATE  AOC_EUR_FDR_RF_TRF_DTL" ).append("\n"); 
		query.append("SET     TRSP_20FT_ADJ_COST_AMT  = @[trsp_20ft_adj_cost_amt]" ).append("\n"); 
		query.append("      , TRSP_20FT_TTL_COST_AMT  = @[trsp_20ft_ttl_cost_amt]" ).append("\n"); 
		query.append("      , TRSP_40FT_ADJ_COST_AMT  = @[trsp_40ft_adj_cost_amt]" ).append("\n"); 
		query.append("      , TRSP_40FT_TTL_COST_AMT  = @[trsp_40ft_ttl_cost_amt]" ).append("\n"); 
		query.append("      , TML_20FT_ADJ_COST_AMT   = @[tml_20ft_adj_cost_amt]" ).append("\n"); 
		query.append("      , TML_20FT_TTL_COST_AMT   = @[tml_20ft_ttl_cost_amt]" ).append("\n"); 
		query.append("      , TML_40FT_ADJ_COST_AMT   = @[tml_40ft_adj_cost_amt]" ).append("\n"); 
		query.append("      , TML_40FT_TTL_COST_AMT   = @[tml_40ft_ttl_cost_amt]" ).append("\n"); 
		query.append("      , FDR_20FT_TTL_AMT        = @[fdr_20ft_ttl_amt]" ).append("\n"); 
		query.append("      , FDR_40FT_TTL_AMT        = @[fdr_40ft_ttl_amt]" ).append("\n"); 
		query.append("      , MTY_TRSP_20FT_ADJ_COST_AMT  = @[mty_trsp_20ft_adj_cost_amt]" ).append("\n"); 
		query.append("      , MTY_TRSP_20FT_TTL_COST_AMT  = @[mty_trsp_20ft_ttl_cost_amt]" ).append("\n"); 
		query.append("      , MTY_TRSP_40FT_ADJ_COST_AMT  = @[mty_trsp_40ft_adj_cost_amt]" ).append("\n"); 
		query.append("      , MTY_TRSP_40FT_TTL_COST_AMT  = @[mty_trsp_40ft_ttl_cost_amt]" ).append("\n"); 
		query.append("      , UPD_USR_ID              = @[upd_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT                  = SYSDATE" ).append("\n"); 
		query.append("WHERE   COST_TRF_NO             = @[cost_trf_no]" ).append("\n"); 
		query.append("AND     COST_TRF_ROUT_SEQ       = @[cost_trf_rout_seq]" ).append("\n"); 

	}
}