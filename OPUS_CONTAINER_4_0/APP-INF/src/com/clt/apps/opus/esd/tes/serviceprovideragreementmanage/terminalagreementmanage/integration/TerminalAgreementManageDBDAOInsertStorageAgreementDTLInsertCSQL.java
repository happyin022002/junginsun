/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOInsertStorageAgreementDTLInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOInsertStorageAgreementDTLInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * storage detail insert
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOInsertStorageAgreementDTLInsertCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_dys_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_vol_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_calc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ut_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("thrp_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_ovt_shft_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_tr_vol_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_sav_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_tr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cntr_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("thrp_cost_cd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ft_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_tr_vol_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_dtl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_dy_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_sto_agmt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_vol_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmnc_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("thc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fp_calc_prd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_tr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_free_dys_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fp_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_dy_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOInsertStorageAgreementDTLInsertCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_AGMT_DTL (      " ).append("\n"); 
		query.append("		  tml_agmt_ofc_cty_cd                 " ).append("\n"); 
		query.append("		, tml_agmt_seq                        " ).append("\n"); 
		query.append("		, tml_agmt_ver_no                     " ).append("\n"); 
		query.append("		, tml_agmt_dtl_seq                    " ).append("\n"); 
		query.append("		, tml_agmt_tp_cd                      " ).append("\n"); 
		query.append("		, lgs_cost_cd                         " ).append("\n"); 
		query.append("		, auto_calc_flg                       " ).append("\n"); 
		query.append("		, thrp_cost_cd_flg                    " ).append("\n"); 
		query.append("		, tml_agmt_vol_ut_cd                  " ).append("\n"); 
		query.append("		, curr_cd                             " ).append("\n"); 
		query.append("		, io_bnd_cd                           " ).append("\n"); 
		query.append("		, tml_dy_aply_tp_cd                   " ).append("\n"); 
		query.append("		, lane_cd                             " ).append("\n"); 
		query.append("		, dcgo_aply_tp_cd                     " ).append("\n"); 
		query.append("		, tml_sto_agmt_tp_cd                  " ).append("\n"); 
		query.append("		, tml_vol_aply_tp_cd                  " ).append("\n"); 
		query.append("		, fm_tr_vol_val                       " ).append("\n"); 
		query.append("		, to_tr_vol_val                       " ).append("\n"); 
		query.append("		, tml_free_dys_tp_cd                  " ).append("\n"); 
		query.append("		, tml_dys_aply_tp_cd                  " ).append("\n"); 
		query.append("		, fm_tr_dys                           " ).append("\n"); 
		query.append("		, to_tr_dys                           " ).append("\n"); 
		query.append("		, xcld_dy_aply_tp_cd                  " ).append("\n"); 
		query.append("		, cmnc_hrmnt                          " ).append("\n"); 
		query.append("		, tml_ovt_shft_cd                     " ).append("\n"); 
		query.append("		, thc_tp_cd                           " ).append("\n"); 
		query.append("		, ioc_cd                              " ).append("\n"); 
		query.append("		, agmt_ut_rt                          " ).append("\n"); 
		query.append("		, fp_calc_prd_cd                      " ).append("\n"); 
		query.append("		, ft_dys                              " ).append("\n"); 
		query.append("		, fp_teu_qty                          " ).append("\n"); 
		query.append("		, agmt_dtl_rmk                        " ).append("\n"); 
		query.append("		, thrp_lgs_cost_cd                    " ).append("\n"); 
		query.append("		, tmp_sav_flg                         " ).append("\n"); 
		query.append("		, cre_usr_id                          " ).append("\n"); 
		query.append("		, cre_dt                              " ).append("\n"); 
		query.append("		, upd_usr_id                          " ).append("\n"); 
		query.append("		, upd_dt                              " ).append("\n"); 
		query.append("		, locl_cre_dt" ).append("\n"); 
		query.append("		,tml_cntr_sty_cd                              " ).append("\n"); 
		query.append(") VALUES (                         " ).append("\n"); 
		query.append("		  @[tml_agmt_ofc_cty_cd]                 " ).append("\n"); 
		query.append("		, @[tml_agmt_seq]                        " ).append("\n"); 
		query.append("		, @[tml_agmt_ver_no]                     " ).append("\n"); 
		query.append("		, @[tml_agmt_dtl_seq]                    " ).append("\n"); 
		query.append("		, @[tml_agmt_tp_cd]                      " ).append("\n"); 
		query.append("		, @[lgs_cost_cd]                         " ).append("\n"); 
		query.append("		, @[auto_calc_flg]                       " ).append("\n"); 
		query.append("		, @[thrp_cost_cd_flg]                    " ).append("\n"); 
		query.append("		, @[tml_agmt_vol_ut_cd]                  " ).append("\n"); 
		query.append("		, @[curr_cd]                             " ).append("\n"); 
		query.append("		, @[io_bnd_cd]                           " ).append("\n"); 
		query.append("		, @[tml_dy_aply_tp_cd]                   " ).append("\n"); 
		query.append("		, @[lane_cd]                             " ).append("\n"); 
		query.append("		, @[dcgo_aply_tp_cd]                     " ).append("\n"); 
		query.append("		, @[tml_sto_agmt_tp_cd]                  " ).append("\n"); 
		query.append("		, @[tml_vol_aply_tp_cd]                  " ).append("\n"); 
		query.append("		, @[fm_tr_vol_val]                       " ).append("\n"); 
		query.append("		, @[to_tr_vol_val]                       " ).append("\n"); 
		query.append("		, @[tml_free_dys_tp_cd]                  " ).append("\n"); 
		query.append("		, @[tml_dys_aply_tp_cd]                  " ).append("\n"); 
		query.append("		, @[fm_tr_dys]                           " ).append("\n"); 
		query.append("		, @[to_tr_dys]                           " ).append("\n"); 
		query.append("		, @[xcld_dy_aply_tp_cd]                  " ).append("\n"); 
		query.append("		, @[cmnc_hrmnt]                          " ).append("\n"); 
		query.append("		, @[tml_ovt_shft_cd]                     " ).append("\n"); 
		query.append("		, @[thc_tp_cd]                           " ).append("\n"); 
		query.append("		, @[ioc_cd]                              " ).append("\n"); 
		query.append("		, @[agmt_ut_rt]                          " ).append("\n"); 
		query.append("		, @[fp_calc_prd_cd]                      " ).append("\n"); 
		query.append("		, @[ft_dys]                              " ).append("\n"); 
		query.append("		, @[fp_teu_qty]                          " ).append("\n"); 
		query.append("		, @[agmt_dtl_rmk]                        " ).append("\n"); 
		query.append("		, @[thrp_lgs_cost_cd]                    " ).append("\n"); 
		query.append("		, @[tmp_sav_flg]                         " ).append("\n"); 
		query.append("		, @[cre_usr_id]                          " ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, @[cre_usr_id]                          " ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("		, @[tml_cntr_sty_cd]" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}