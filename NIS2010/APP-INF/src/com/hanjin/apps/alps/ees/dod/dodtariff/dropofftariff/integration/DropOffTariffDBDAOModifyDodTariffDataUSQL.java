/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffDBDAOModifyDodTariffDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2015.11.24 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffTariffDBDAOModifyDodTariffDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DodTariff 정보 수정
	  * </pre>
	  */
	public DropOffTariffDBDAOModifyDodTariffDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drp_off_chg_trf_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drp_off_chg_trf_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_exp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drp_off_chg_trf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration").append("\n"); 
		query.append("FileName : DropOffTariffDBDAOModifyDodTariffDataUSQL").append("\n"); 
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
		query.append("update DOD_DRP_OFF_CHG_TRF d" ).append("\n"); 
		query.append("   set" ).append("\n"); 
		query.append("  d.CURR_CD = @[curr_cd]," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_AMT = @[drp_off_chg_trf_amt]," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_EFF_DT = @[drp_off_chg_trf_eff_dt]," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_EXPT_FLG = DECODE(    @[drp_off_chg_trf_expt_flg], '1', 'Y','0', 'N', 'Y', 'Y', 'N', 'N', 'N')," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_EXP_DT = @[drp_off_chg_trf_exp_dt]," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_EXP_FLG = DECODE(     @[drp_off_chg_trf_exp_flg], '1', 'Y'," ).append("\n"); 
		query.append("                                                                      '0', 'N'," ).append("\n"); 
		query.append("																	  'Y', 'Y'," ).append("\n"); 
		query.append("                                                                      'N', 'N', 'N')," ).append("\n"); 
		query.append("  d.DRP_OFF_CHG_TRF_RMK = @[drp_off_chg_trf_rmk]," ).append("\n"); 
		query.append("  d.RFA_NO = @[rfa_no]," ).append("\n"); 
		query.append("  d.SC_NO = @[sc_no]," ).append("\n"); 
		query.append("  d.UPD_DT = SYSDATE," ).append("\n"); 
		query.append("  d.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("  d.DEL_CD = @[del_cd]," ).append("\n"); 
		query.append("  d.CNTR_TPSZ_CD = @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("  d.CNTR_RTN_LOC_CD = @[cntr_rtn_loc_cd]," ).append("\n"); 
		query.append("  d.CNTR_RTN_YD_SFX_CD = DECODE(@[cntr_rtn_yd_sfx_cd], 'ALL', '',  @[cntr_rtn_yd_sfx_cd])," ).append("\n"); 
		query.append(" d.POL_CONTI_CD = @[pol_conti_cd]," ).append("\n"); 
		query.append(" d.DRP_OFF_CHG_TRF_CNT_CD = @[drp_off_chg_trf_cnt_cd]," ).append("\n"); 
		query.append("d.SPCL_CUST_CNT_CD  =  substr(@[spcl_cust_cnt_seq], 0, 2)," ).append("\n"); 
		query.append("d.SPCL_CUST_SEQ     =  substr(@[spcl_cust_cnt_seq], 3)" ).append("\n"); 
		query.append(" where 1=1" ).append("\n"); 
		query.append("   and d.DRP_OFF_CHG_TRF_SEQ = @[drp_off_chg_trf_seq]" ).append("\n"); 
		query.append("   and NOT EXISTS (select 'X' from DOD_DRP_OFF_CHG where DRP_OFF_CHG_TRF_SEQ = @[drp_off_chg_trf_seq]" ).append("\n"); 
		query.append("                       or DRP_OFF_CHG_TRF_SPCL_SEQ = @[drp_off_chg_trf_seq])" ).append("\n"); 

	}
}