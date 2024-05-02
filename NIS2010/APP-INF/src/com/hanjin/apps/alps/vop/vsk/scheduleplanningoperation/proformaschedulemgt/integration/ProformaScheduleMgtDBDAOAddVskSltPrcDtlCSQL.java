/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOAddVskSltPrcDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2010.01.26 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOAddVskSltPrcDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddVskSltPrcDtl
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOAddVskSltPrcDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtx_foil_port_dy_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_hir_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_hir_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_wrk_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtx_foil_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chrg_hir_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chrg_hir_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dzn_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pe_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_expn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtx_foil_sea_dy_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dly_bnk_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtx_foil_sea_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_one_wy_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_ownr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtx_foil_port_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtx_foil_mnvr_dy_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtx_foil_mnvr_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_rnd_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOAddVskSltPrcDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_SLT_PRC_DTL(" ).append("\n"); 
		query.append("VSL_SLAN_CD," ).append("\n"); 
		query.append("PF_SVC_TP_CD," ).append("\n"); 
		query.append("SLT_PRC_WRK_YR," ).append("\n"); 
		query.append("BSE_QTR_CD," ).append("\n"); 
		query.append("VSL_CLSS_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VSL_CLSS_KNT," ).append("\n"); 
		query.append("CNTR_DZN_CAPA," ).append("\n"); 
		query.append("PE_AMT," ).append("\n"); 
		query.append("DLY_BNK_CSM_QTY," ).append("\n"); 
		query.append("MTX_FOIL_SEA_DY_QTY," ).append("\n"); 
		query.append("MTX_FOIL_SEA_TTL_QTY," ).append("\n"); 
		query.append("MTX_FOIL_MNVR_DY_QTY," ).append("\n"); 
		query.append("MTX_FOIL_MNVR_TTL_QTY," ).append("\n"); 
		query.append("MTX_FOIL_PORT_DY_QTY," ).append("\n"); 
		query.append("MTX_FOIL_PORT_TTL_QTY," ).append("\n"); 
		query.append("MTX_FOIL_TTL_QTY," ).append("\n"); 
		query.append("BNK_EXPN_AMT," ).append("\n"); 
		query.append("VSL_OWNR_FLG," ).append("\n"); 
		query.append("OWNR_HIR_TEU_AMT," ).append("\n"); 
		query.append("OWNR_HIR_TTL_AMT," ).append("\n"); 
		query.append("CHRG_HIR_TEU_AMT," ).append("\n"); 
		query.append("CHRG_HIR_TTL_AMT," ).append("\n"); 
		query.append("SLT_PRC_TTL_AMT," ).append("\n"); 
		query.append("SLT_PRC_RND_AMT," ).append("\n"); 
		query.append("SLT_PRC_ONE_WY_AMT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[vsl_slan_cd]," ).append("\n"); 
		query.append("@[pf_svc_tp_cd]," ).append("\n"); 
		query.append("@[slt_prc_wrk_yr]," ).append("\n"); 
		query.append("@[bse_qtr_cd]," ).append("\n"); 
		query.append("@[vsl_clss_cd]," ).append("\n"); 
		query.append("@[vsl_clss_knt]," ).append("\n"); 
		query.append("@[cntr_dzn_capa]," ).append("\n"); 
		query.append("@[pe_amt]," ).append("\n"); 
		query.append("@[dly_bnk_csm_qty]," ).append("\n"); 
		query.append("@[mtx_foil_sea_dy_qty]," ).append("\n"); 
		query.append("@[mtx_foil_sea_ttl_qty]," ).append("\n"); 
		query.append("@[mtx_foil_mnvr_dy_qty]," ).append("\n"); 
		query.append("@[mtx_foil_mnvr_ttl_qty]," ).append("\n"); 
		query.append("@[mtx_foil_port_dy_qty]," ).append("\n"); 
		query.append("@[mtx_foil_port_ttl_qty]," ).append("\n"); 
		query.append("@[mtx_foil_ttl_qty]," ).append("\n"); 
		query.append("@[bnk_expn_amt]," ).append("\n"); 
		query.append("@[vsl_ownr_flg]," ).append("\n"); 
		query.append("@[ownr_hir_teu_amt]," ).append("\n"); 
		query.append("@[ownr_hir_ttl_amt]," ).append("\n"); 
		query.append("@[chrg_hir_teu_amt]," ).append("\n"); 
		query.append("@[chrg_hir_ttl_amt]," ).append("\n"); 
		query.append("@[slt_prc_ttl_amt]," ).append("\n"); 
		query.append("@[slt_prc_rnd_amt]," ).append("\n"); 
		query.append("@[slt_prc_one_wy_amt]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}