/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOAddInlandCostReeferCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.17 
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

public class UsaInlandCostManageDBDAOAddInlandCostReeferCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EUR Inland Cost Reefer Insert
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOAddInlandCostReeferCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_20ft_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_rout_grp_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_40ft_ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOAddInlandCostReeferCSQL").append("\n"); 
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
		query.append("INSERT INTO AOC_USA_INLND_RF_TRF_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      COST_TRF_NO" ).append("\n"); 
		query.append("    , COST_TRF_RF_SEQ" ).append("\n"); 
		query.append("    , COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("    , PORT_NOD_CD" ).append("\n"); 
		query.append("    , HUB_NOD_CD" ).append("\n"); 
		query.append("    , LOC_NOD_CD" ).append("\n"); 
		query.append("    , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("    , COST_ROUT_GRP_NO" ).append("\n"); 
		query.append("    , TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("    , RF_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("    , RF_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , DELT_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      @[cost_trf_no]" ).append("\n"); 
		query.append("    , AOC_USA_INLND_RF_TRF_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("    , @[cost_trf_rout_seq]" ).append("\n"); 
		query.append("    , @[port_nod_cd]" ).append("\n"); 
		query.append("    , @[hub_nod_cd]" ).append("\n"); 
		query.append("    , @[loc_nod_cd]" ).append("\n"); 
		query.append("    , @[rcv_de_term_cd]" ).append("\n"); 
		query.append("    , @[cost_rout_grp_no]" ).append("\n"); 
		query.append("    , @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("    , @[rf_20ft_ttl_cost_amt]" ).append("\n"); 
		query.append("    , @[rf_40ft_ttl_cost_amt]" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}