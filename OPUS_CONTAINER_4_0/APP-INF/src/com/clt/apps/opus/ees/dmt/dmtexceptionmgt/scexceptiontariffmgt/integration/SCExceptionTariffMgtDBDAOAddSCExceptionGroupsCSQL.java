/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOAddSCExceptionGroupsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOAddSCExceptionGroupsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception Terms Entry Group 정보 입력을 위한 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOAddSCExceptionGroupsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_hol_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_add_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_trf_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_sat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_sun_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_to_pair_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_adj_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rt_adj_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_cntr_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_add_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ft_adj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOAddSCExceptionGroupsCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_SC_EXPT_GRP (" ).append("\n"); 
		query.append("	PROP_NO" ).append("\n"); 
		query.append(",	SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	CMDT_FLG" ).append("\n"); 
		query.append(",	REP_CMDT_CD" ).append("\n"); 
		query.append(",	REP_CMDT_FLG" ).append("\n"); 
		query.append(",	ACT_CUST_FLG" ).append("\n"); 
		query.append(",	FM_TO_PAIR_FLG" ).append("\n"); 
		query.append(",	SC_EXPT_FM_CONTI_CD" ).append("\n"); 
		query.append(",	SC_EXPT_FM_CNT_CD" ).append("\n"); 
		query.append(",	SC_EXPT_FM_RGN_CD" ).append("\n"); 
		query.append(",	SC_EXPT_FM_STE_CD" ).append("\n"); 
		query.append(",	SC_EXPT_FM_LOC_CD" ).append("\n"); 
		query.append(",	FNL_DEST_CNT_CD" ).append("\n"); 
		query.append(",	FNL_DEST_RGN_CD" ).append("\n"); 
		query.append(",	FNL_DEST_STE_CD" ).append("\n"); 
		query.append(",	FNL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	FT_FLG" ).append("\n"); 
		query.append(",	XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	DMDT_FT_ADJ_TP_CD" ).append("\n"); 
		query.append(",	FT_ADD_FLG" ).append("\n"); 
		query.append(",	FT_ADD_DYS" ).append("\n"); 
		query.append(",	FT_ADJ_FLG" ).append("\n"); 
		query.append(",	RT_ADJ_FLG" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	EXPT_TRF_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	RT_CHK_FLG" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[prop_no]" ).append("\n"); 
		query.append(",	@[sc_expt_ver_seq]" ).append("\n"); 
		query.append(",	@[sc_expt_grp_seq]" ).append("\n"); 
		query.append(",	TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[dmdt_trf_cd]" ).append("\n"); 
		query.append(",	@[dmdt_cntr_cgo_tp_cd]" ).append("\n"); 
		query.append(",	@[cmdt_flg]" ).append("\n"); 
		query.append(",	@[rep_cmdt_cd]" ).append("\n"); 
		query.append(",	@[rep_cmdt_flg]" ).append("\n"); 
		query.append(",	@[act_cust_flg]" ).append("\n"); 
		query.append(",	@[fm_to_pair_flg]" ).append("\n"); 
		query.append(",	NVL(@[sc_expt_fm_conti_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[sc_expt_fm_cnt_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[sc_expt_fm_rgn_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[sc_expt_fm_ste_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[sc_expt_fm_loc_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[fnl_dest_cnt_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[fnl_dest_rgn_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[fnl_dest_ste_cd], ' ')" ).append("\n"); 
		query.append(",	NVL(@[fnl_dest_loc_cd], ' ')" ).append("\n"); 
		query.append(",	@[rcv_de_term_cd]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	DECODE(@[ft_flg],'1','Y','N')" ).append("\n"); 
		query.append(",	DECODE(@[xcld_sat_flg],'1','Y','N')" ).append("\n"); 
		query.append(",	DECODE(@[xcld_sun_flg],'1','Y','N')" ).append("\n"); 
		query.append(",	DECODE(@[xcld_hol_flg],'1','Y','N')" ).append("\n"); 
		query.append(",	@[dmdt_ft_adj_tp_cd]" ).append("\n"); 
		query.append(",	@[ft_add_flg]" ).append("\n"); 
		query.append(",	@[ft_add_dys]" ).append("\n"); 
		query.append(",	@[ft_adj_flg]" ).append("\n"); 
		query.append(",	@[rt_adj_flg]" ).append("\n"); 
		query.append(",	@[curr_cd]" ).append("\n"); 
		query.append(",	@[expt_trf_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append(",	@[rt_chk_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}