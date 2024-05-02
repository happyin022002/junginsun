/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAOMultiCostCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.14 
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

public class CostStructureDBDAOMultiCostCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT
	  * </pre>
	  */
	public CostStructureDBDAOMultiCostCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_mn_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgrp_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_stnd_cost_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_sgrp_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgrp_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_perf_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("perf_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_scp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOMultiCostCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_STND_ACCT (" ).append("\n"); 
		query.append("    STND_COST_CD" ).append("\n"); 
		query.append("   ,STND_COST_NM" ).append("\n"); 
		query.append("   ,MGRP_COST_CD" ).append("\n"); 
		query.append("   ,SGRP_COST_CD" ).append("\n"); 
		query.append("   ,PERF_VW_CD" ).append("\n"); 
		query.append("   ,RA_STND_COST_DESC " ).append("\n"); 
		query.append("   ,RA_ACCT_CD" ).append("\n"); 
		query.append("   ,RA_MN_COST_CD" ).append("\n"); 
		query.append("   ,RA_SGRP_COST_CD" ).append("\n"); 
		query.append("   ,RA_PERF_VW_CD" ).append("\n"); 
		query.append("   ,HIR_SCP_FLG" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT " ).append("\n"); 
		query.append("   ,ACCT_DP_SEQ" ).append("\n"); 
		query.append("   ,DELT_FLG" ).append("\n"); 
		query.append("   ,COA_COST_SRC_PRT_CD" ).append("\n"); 
		query.append(")VALUES (" ).append("\n"); 
		query.append("    @[stnd_cost_cd]" ).append("\n"); 
		query.append("   ,@[stnd_cost_nm]" ).append("\n"); 
		query.append("   ,@[mgrp_cost_cd]" ).append("\n"); 
		query.append("   ,@[sgrp_cost_cd]" ).append("\n"); 
		query.append("   ,@[perf_vw_cd]" ).append("\n"); 
		query.append("   ,@[ra_stnd_cost_desc]" ).append("\n"); 
		query.append("   ,@[ra_acct_cd]" ).append("\n"); 
		query.append("   ,@[ra_mn_cost_cd]" ).append("\n"); 
		query.append("   ,@[ra_sgrp_cost_cd]" ).append("\n"); 
		query.append("   ,@[ra_perf_vw_cd]" ).append("\n"); 
		query.append("   ,@[hir_scp_flg]" ).append("\n"); 
		query.append("   ,@[upd_usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[upd_usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[acct_dp_seq]" ).append("\n"); 
		query.append("   ,'N'" ).append("\n"); 
		query.append("   ,'PA'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}