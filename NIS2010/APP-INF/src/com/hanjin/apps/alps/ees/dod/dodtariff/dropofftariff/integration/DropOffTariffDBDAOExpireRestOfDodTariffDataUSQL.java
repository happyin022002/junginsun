/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffDBDAOExpireRestOfDodTariffDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2015.12.29 윤용상
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

public class DropOffTariffDBDAOExpireRestOfDodTariffDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DodTariff 만료 수정
	  * -------------------------------------------------------------------------------------------------------
	  * 2015.12.04 박정민 : 기존 조건에서 Customer정보에 Customer Code가 다르게 입력될수도 있음
	  * -------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public DropOffTariffDBDAOExpireRestOfDodTariffDataUSQL(){
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
		params.put("drp_off_chg_trf_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drp_off_chg_trf_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration").append("\n"); 
		query.append("FileName : DropOffTariffDBDAOExpireRestOfDodTariffDataUSQL").append("\n"); 
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
		query.append("update DOD_DRP_OFF_CHG_TRF" ).append("\n"); 
		query.append("   set " ).append("\n"); 
		query.append("       DRP_OFF_CHG_TRF_EXP_FLG = 'N'," ).append("\n"); 
		query.append("	   DRP_OFF_CHG_TRF_EXP_DT = TO_CHAR(TO_DATE(@[drp_off_chg_trf_eff_dt], 'YYYYMMDD') - 1, 'YYYYMMDD')," ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" where 1=1" ).append("\n"); 
		query.append("   and DRP_OFF_CHG_TRF_CNT_CD = @[drp_off_chg_trf_cnt_cd]" ).append("\n"); 
		query.append("#if( ${del_cd} == '' )" ).append("\n"); 
		query.append("   and DEL_CD is null" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   and DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and CNTR_RTN_LOC_CD = @[cntr_rtn_loc_cd]" ).append("\n"); 
		query.append("#if( ${cntr_rtn_yd_sfx_cd} == '' || ${cntr_rtn_yd_sfx_cd} == 'ALL')" ).append("\n"); 
		query.append("   and CNTR_RTN_YD_SFX_CD is null" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   and CNTR_RTN_YD_SFX_CD = @[cntr_rtn_yd_sfx_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${pol_conti_cd} == '' || ${pol_conti_cd} == 'ALL')" ).append("\n"); 
		query.append("	   and POL_CONTI_CD is null" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	   and POL_CONTI_CD = @[pol_conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and DRP_OFF_CHG_TRF_DIV_CD = @[drp_off_chg_trf_div_cd]" ).append("\n"); 
		query.append("#if(${drp_off_chg_trf_div_cd} != 'G')" ).append("\n"); 
		query.append("#if ( ${rfa_no} != '')" ).append("\n"); 
		query.append("and RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${sc_no} != '')" ).append("\n"); 
		query.append("and SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("   and drp_off_chg_trf_exp_flg != 'Y'" ).append("\n"); 
		query.append("   and DRP_OFF_CHG_TRF_SEQ = (select  DRP_OFF_CHG_TRF_SEQ  from (" ).append("\n"); 
		query.append("  SELECT DRP_OFF_CHG_TRF_SEQ, " ).append("\n"); 
		query.append("         row_number() over (ORDER BY B.DRP_OFF_CHG_TRF_EFF_DT desc, B.DRP_OFF_CHG_TRF_EXP_DT desc, B.DRP_OFF_CHG_TRF_CNT_CD desc, B.DEL_CD, B.CNTR_RTN_LOC_CD desc, B.DRP_OFF_CHG_TRF_SEQ DESC) as row_rank FROM DOD_DRP_OFF_CHG_TRF B" ).append("\n"); 
		query.append("									where 1=1" ).append("\n"); 
		query.append("									and DRP_OFF_CHG_TRF_CNT_CD = @[drp_off_chg_trf_cnt_cd]" ).append("\n"); 
		query.append("                                #if( ${del_cd} == '' )" ).append("\n"); 
		query.append("								   and DEL_CD is null" ).append("\n"); 
		query.append("								#else" ).append("\n"); 
		query.append("								   and DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								   and CNTR_RTN_LOC_CD = @[cntr_rtn_loc_cd]" ).append("\n"); 
		query.append("                                   and DRP_OFF_CHG_TRF_DIV_CD = @[drp_off_chg_trf_div_cd]" ).append("\n"); 
		query.append("								#if( ${cntr_rtn_yd_sfx_cd} == '' || ${cntr_rtn_yd_sfx_cd} == 'ALL')" ).append("\n"); 
		query.append("								   and CNTR_RTN_YD_SFX_CD is null" ).append("\n"); 
		query.append("								#else " ).append("\n"); 
		query.append("								   and CNTR_RTN_YD_SFX_CD = @[cntr_rtn_yd_sfx_cd]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if( ${pol_conti_cd} == '' || ${pol_conti_cd} == 'ALL')" ).append("\n"); 
		query.append("								   and POL_CONTI_CD is null" ).append("\n"); 
		query.append("								#else" ).append("\n"); 
		query.append("								   and POL_CONTI_CD = @[pol_conti_cd]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								   and CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("                               ) t" ).append("\n"); 
		query.append("WHERE row_rank = 2" ).append("\n"); 
		query.append("and rownum = 1)" ).append("\n"); 
		query.append("#if(${spcl_cust_cnt_seq} != '')" ).append("\n"); 
		query.append("   and SPCL_CUST_CNT_CD = SUBSTR(@[spcl_cust_cnt_seq], 0, 2)" ).append("\n"); 
		query.append("   and SPCL_CUST_SEQ = SUBSTR(@[spcl_cust_cnt_seq], 3)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   and SPCL_CUST_CNT_CD is null" ).append("\n"); 
		query.append("   and SPCL_CUST_SEQ is null" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}