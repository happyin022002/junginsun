/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OceanFeederCostManageDBDAOmultiFeederCostUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.21
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.05.21 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanFeederCostManageDBDAOmultiFeederCostUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiFeederCost
	  * </pre>
	  */
	public OceanFeederCostManageDBDAOmultiFeederCostUSQL(){
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
		params.put("tml_20ft_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_20ft_adj_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.integration ").append("\n"); 
		query.append("FileName : OceanFeederCostManageDBDAOmultiFeederCostUSQL").append("\n"); 
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
		query.append("UPDATE TRS_FDR_COST_TRF" ).append("\n"); 
		query.append("SET TRSP_20FT_ADJ_COST_AMT      = @[trsp_20ft_adj_cost_amt]" ).append("\n"); 
		query.append(",TRSP_20FT_TTL_COST_AMT      = @[trsp_20ft_ttl_cost_amt]" ).append("\n"); 
		query.append(",TRSP_40FT_ADJ_COST_AMT      = @[trsp_40ft_adj_cost_amt]" ).append("\n"); 
		query.append(",TRSP_40FT_TTL_COST_AMT      = @[trsp_40ft_ttl_cost_amt]" ).append("\n"); 
		query.append(",TML_20FT_ADJ_COST_AMT       = @[tml_20ft_adj_cost_amt]" ).append("\n"); 
		query.append(",TML_20FT_TTL_COST_AMT       = @[tml_20ft_ttl_cost_amt]" ).append("\n"); 
		query.append(",TML_40FT_ADJ_COST_AMT       = @[tml_40ft_adj_cost_amt]" ).append("\n"); 
		query.append(",TML_40FT_TTL_COST_AMT       = @[tml_40ft_ttl_cost_amt]" ).append("\n"); 
		query.append(",FDR_20FT_TTL_AMT            = @[fdr_20ft_ttl_amt]" ).append("\n"); 
		query.append(",FDR_40FT_TTL_AMT            = @[fdr_40ft_ttl_amt]" ).append("\n"); 
		query.append(",UPD_USR_ID                  = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT                      = SYSDATE" ).append("\n"); 
		query.append("WHERE COST_TRF_NO       = @[cost_trf_no]" ).append("\n"); 
		query.append("AND COST_TRF_ROUT_SEQ = @[cost_trf_rout_seq]" ).append("\n"); 

	}
}