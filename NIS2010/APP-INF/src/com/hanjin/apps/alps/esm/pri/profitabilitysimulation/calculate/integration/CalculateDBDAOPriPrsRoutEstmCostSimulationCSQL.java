/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CalculateDBDAOPriPrsRoutEstmCostSimulationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.24 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CalculateDBDAOPriPrsRoutEstmCostSimulationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *   Insert
	  * </pre>
	  */
	public CalculateDBDAOPriPrsRoutEstmCostSimulationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("div_meas_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_clss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_calc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_bx_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_trns_prc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ass_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration").append("\n"); 
		query.append("FileName : CalculateDBDAOPriPrsRoutEstmCostSimulationCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_PRS_ROUT_ESTM_COST (" ).append("\n"); 
		query.append("		ROUT_CS_NO" ).append("\n"); 
		query.append("		, ROUT_CS_CLSS_NO" ).append("\n"); 
		query.append("		, COA_COST_SRC_CD" ).append("\n"); 
		query.append("		, COM_ROUT_SEQ" ).append("\n"); 
		query.append("		, LOC_CD" ).append("\n"); 
		query.append("		, COND_OFC_CD" ).append("\n"); 
		query.append("		, DIV_MEAS_CD" ).append("\n"); 
		query.append("		, OFC_CLSS_CD" ).append("\n"); 
		query.append("		, SLS_ACT_CD" ).append("\n"); 
		query.append("		, RA_ACCT_CD" ).append("\n"); 
		query.append("		, STND_COST_CD" ).append("\n"); 
		query.append("		, COST_ASS_BSE_CD" ).append("\n"); 
		query.append("		, SVC_TRNS_PRC_AMT" ).append("\n"); 
		query.append("		, BKG_KNT" ).append("\n"); 
		query.append("		, CNTR_BX_KNT" ).append("\n"); 
		query.append("		, CNTR_TEU_QTY" ).append("\n"); 
		query.append("		, VSL_DYS" ).append("\n"); 
		query.append("		, COM_FLG" ).append("\n"); 
		query.append("		, COST_CALC_RMK" ).append("\n"); 
		query.append("		, CRE_USR_ID" ).append("\n"); 
		query.append("		, CRE_DT" ).append("\n"); 
		query.append("		, UPD_USR_ID" ).append("\n"); 
		query.append("		, UPD_DT" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("		@[rout_cs_no]" ).append("\n"); 
		query.append("		, @[rout_cs_clss_no]" ).append("\n"); 
		query.append("		, @[coa_cost_src_cd]" ).append("\n"); 
		query.append("		, @[com_rout_seq]" ).append("\n"); 
		query.append("		, @[loc_cd]" ).append("\n"); 
		query.append("		, @[cond_ofc_cd]" ).append("\n"); 
		query.append("		, @[div_meas_cd]" ).append("\n"); 
		query.append("		, @[ofc_clss_cd]" ).append("\n"); 
		query.append("		, @[sls_act_cd]" ).append("\n"); 
		query.append("		, @[ra_acct_cd]" ).append("\n"); 
		query.append("		, @[stnd_cost_cd]" ).append("\n"); 
		query.append("		, @[cost_ass_bse_cd]" ).append("\n"); 
		query.append("		, @[svc_trns_prc_amt]" ).append("\n"); 
		query.append("		, @[bkg_knt]" ).append("\n"); 
		query.append("		, @[cntr_bx_knt]" ).append("\n"); 
		query.append("		, @[cntr_teu_qty]" ).append("\n"); 
		query.append("		, @[vsl_dys]" ).append("\n"); 
		query.append("		, @[com_flg]" ).append("\n"); 
		query.append("		, @[cost_calc_rmk]" ).append("\n"); 
		query.append("		, 'CALC'" ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, 'CALC'" ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}