/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffDBDAOAddDodTariffDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.12.03 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffTariffDBDAOAddDodTariffDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DodTariff 정보 수정
	  * ---------------------------------------------------------------------------------------------------
	  * 2015.12.04 박정민 : 기존 조건에서 Customer정보에 Customer Code가 다르게 입력될수도 있음
	  * ---------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public DropOffTariffDBDAOAddDodTariffDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drp_off_chg_trf_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rtn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rtn_yd_sfx_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drp_off_chg_trf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration").append("\n"); 
		query.append("FileName : DropOffTariffDBDAOAddDodTariffDataCSQL").append("\n"); 
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
		query.append("MERGE INTO DOD_DRP_OFF_CHG_TRF d" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("  select" ).append("\n"); 
		query.append("    @[cntr_rtn_loc_cd] as CNTR_RTN_LOC_CD," ).append("\n"); 
		query.append("    DECODE(@[cntr_rtn_yd_sfx_cd], 'ALL', '', @[cntr_rtn_yd_sfx_cd]) as CNTR_RTN_YD_SFX_CD," ).append("\n"); 
		query.append("    @[cntr_tpsz_cd] as CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    SYSDATE as CRE_DT," ).append("\n"); 
		query.append("    @[cre_usr_id] as CRE_USR_ID," ).append("\n"); 
		query.append("    @[curr_cd] as CURR_CD," ).append("\n"); 
		query.append("    @[del_cd] as DEL_CD," ).append("\n"); 
		query.append("    NVL(@[delt_flg], 'N') as DELT_FLG," ).append("\n"); 
		query.append("    @[drp_off_chg_trf_amt] as DRP_OFF_CHG_TRF_AMT," ).append("\n"); 
		query.append("    @[drp_off_chg_trf_cnt_cd] as DRP_OFF_CHG_TRF_CNT_CD," ).append("\n"); 
		query.append("    NVL(@[drp_off_chg_trf_div_cd], 'G') as DRP_OFF_CHG_TRF_DIV_CD," ).append("\n"); 
		query.append("    @[drp_off_chg_trf_eff_dt] as DRP_OFF_CHG_TRF_EFF_DT," ).append("\n"); 
		query.append("	DECODE(    @[drp_off_chg_trf_expt_flg], '1', 'Y', " ).append("\n"); 
		query.append("	DECODE(    @[drp_off_chg_trf_expt_flg], '0', 'N', " ).append("\n"); 
		query.append("	DECODE(    @[drp_off_chg_trf_expt_flg], 'Y', 'Y', " ).append("\n"); 
		query.append("	DECODE(    @[drp_off_chg_trf_expt_flg], 'N', 'N', 'N')))) as DRP_OFF_CHG_TRF_EXPT_FLG," ).append("\n"); 
		query.append("    @[drp_off_chg_trf_exp_dt] as DRP_OFF_CHG_TRF_EXP_DT," ).append("\n"); 
		query.append("    'N' as DRP_OFF_CHG_TRF_EXP_FLG," ).append("\n"); 
		query.append("    @[drp_off_chg_trf_rmk] as DRP_OFF_CHG_TRF_RMK," ).append("\n"); 
		query.append("    @[drp_off_chg_trf_seq] as DRP_OFF_CHG_TRF_SEQ," ).append("\n"); 
		query.append("    @[pol_conti_cd] as POL_CONTI_CD," ).append("\n"); 
		query.append("    @[rfa_no] as RFA_NO," ).append("\n"); 
		query.append("    @[sc_no] as SC_NO," ).append("\n"); 
		query.append("    substr(@[spcl_cust_cnt_seq], 0, 2) as SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("    substr(@[spcl_cust_cnt_seq], 3) as SPCL_CUST_SEQ," ).append("\n"); 
		query.append("    @[spcl_cust_cnt_seq] as SPCL_CUSTOMER," ).append("\n"); 
		query.append("    SYSDATE as UPD_DT," ).append("\n"); 
		query.append("    @[upd_usr_id] as UPD_USR_ID" ).append("\n"); 
		query.append("  From Dual) s" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("  --(d.DRP_OFF_CHG_TRF_SEQ = s.DRP_OFF_CHG_TRF_SEQ)" ).append("\n"); 
		query.append("  --cnt_cd del_cd rtn_loc_cd yd_cd or_cd tpsz_cd" ).append("\n"); 
		query.append("  (d.DRP_OFF_CHG_TRF_SEQ = s.DRP_OFF_CHG_TRF_SEQ and d.DRP_OFF_CHG_TRF_CNT_CD = s.DRP_OFF_CHG_TRF_CNT_CD" ).append("\n"); 
		query.append("  and d.DEL_CD = s.DEL_CD" ).append("\n"); 
		query.append("  and d.CNTR_RTN_LOC_CD = s.CNTR_RTN_LOC_CD" ).append("\n"); 
		query.append("  and d.CNTR_RTN_YD_SFX_CD = s.CNTR_RTN_YD_SFX_CD" ).append("\n"); 
		query.append("  and d.POL_CONTI_CD = s.POL_CONTI_CD" ).append("\n"); 
		query.append("  and d.CNTR_TPSZ_CD = s.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  and d.DELT_FLG = s.DELT_FLG" ).append("\n"); 
		query.append("  and d.SPCL_CUST_CNT_CD || LPAD(d.SPCL_CUST_SEQ, 6, '0') = s.SPCL_CUSTOMER)" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("  d.UPD_DT = s.UPD_DT," ).append("\n"); 
		query.append("  d.UPD_USR_ID = s.UPD_USR_ID" ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_SEQ, " ).append("\n"); 
		query.append("  d.CNTR_RTN_LOC_CD, d.CNTR_RTN_YD_SFX_CD, d.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  d.CRE_DT, d.CRE_USR_ID, d.CURR_CD," ).append("\n"); 
		query.append("  d.DELT_FLG, d.DEL_CD, d.DRP_OFF_CHG_TRF_AMT," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_CFM_DT, d.DRP_OFF_CHG_TRF_CFM_FLG, d.DRP_OFF_CHG_TRF_CFM_USR_ID," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_CNT_CD, d.DRP_OFF_CHG_TRF_DIV_CD, d.DRP_OFF_CHG_TRF_EFF_DT," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_EXPT_FLG, d.DRP_OFF_CHG_TRF_EXP_DT, d.DRP_OFF_CHG_TRF_EXP_FLG," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_RMK, d.POL_CONTI_CD," ).append("\n"); 
		query.append("  d.RFA_NO, d.SC_NO, d.SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("  d.SPCL_CUST_SEQ, d.UPD_DT, d.UPD_USR_ID)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("  (SELECT NVL(MAX(DRP_OFF_CHG_TRF_SEQ),0) + 1 FROM DOD_DRP_OFF_CHG_TRF)," ).append("\n"); 
		query.append("  s.CNTR_RTN_LOC_CD, s.CNTR_RTN_YD_SFX_CD, s.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  s.CRE_DT, s.CRE_USR_ID, s.CURR_CD," ).append("\n"); 
		query.append("  s.DELT_FLG, s.DEL_CD, s.DRP_OFF_CHG_TRF_AMT," ).append("\n"); 
		query.append("  null, 'N', null, --s.DRP_OFF_CHG_TRF_CFM_DT, s.DRP_OFF_CHG_TRF_CFM_FLG, s.DRP_OFF_CHG_TRF_CFM_USR_ID," ).append("\n"); 
		query.append("  s.DRP_OFF_CHG_TRF_CNT_CD, s.DRP_OFF_CHG_TRF_DIV_CD, s.DRP_OFF_CHG_TRF_EFF_DT," ).append("\n"); 
		query.append("  s.DRP_OFF_CHG_TRF_EXPT_FLG, s.DRP_OFF_CHG_TRF_EXP_DT, s.DRP_OFF_CHG_TRF_EXP_FLG," ).append("\n"); 
		query.append("  s.DRP_OFF_CHG_TRF_RMK, s.POL_CONTI_CD," ).append("\n"); 
		query.append("  s.RFA_NO, s.SC_NO, s.SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("  s.SPCL_CUST_SEQ, s.UPD_DT, s.UPD_USR_ID)" ).append("\n"); 

	}
}