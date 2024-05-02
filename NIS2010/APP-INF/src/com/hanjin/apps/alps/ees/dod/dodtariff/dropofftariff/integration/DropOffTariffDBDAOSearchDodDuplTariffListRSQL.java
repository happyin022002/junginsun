/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffDBDAOSearchDodDuplTariffListRSQL.java
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

public class DropOffTariffDBDAOSearchDodDuplTariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDodDuplTariffList
	  * </pre>
	  */
	public DropOffTariffDBDAOSearchDodDuplTariffListRSQL(){
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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drp_off_chg_trf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration").append("\n"); 
		query.append("FileName : DropOffTariffDBDAOSearchDodDuplTariffListRSQL").append("\n"); 
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
		query.append("select DDT.DRP_OFF_CHG_TRF_SEQ," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_DIV_CD," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_CNT_CD," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_EFF_DT," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_EXP_DT," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_EXP_FLG," ).append("\n"); 
		query.append("       DDT.DEL_CD," ).append("\n"); 
		query.append("       DDT.CNTR_RTN_LOC_CD," ).append("\n"); 
		query.append("       NVL(DDT.CNTR_RTN_YD_SFX_CD, 'ALL') as CNTR_RTN_YD_SFX_CD," ).append("\n"); 
		query.append("       DDT.POL_CONTI_CD," ).append("\n"); 
		query.append("       DDT.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       DDT.CURR_CD," ).append("\n"); 
		query.append("       DDT.SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("       DDT.SPCL_CUST_SEQ," ).append("\n"); 
		query.append("#if(${drp_off_chg_trf_div_cd} != 'G')" ).append("\n"); 
		query.append("	   DDT.SPCL_CUST_CNT_CD||LPAD(DDT.SPCL_CUST_SEQ,6,'0') AS SPCL_CUST_CNT_SEQ," ).append("\n"); 
		query.append("	   (select CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("		  from MDM_CUSTOMER" ).append("\n"); 
		query.append("		 where 1=1" ).append("\n"); 
		query.append("		   AND DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("		   AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		  AND CUST_CNT_CD = DDT.SPCL_CUST_CNT_CD " ).append("\n"); 
		query.append("           AND CUST_SEQ = DDT.SPCL_CUST_SEQ) AS SPCL_CUST_NM," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   DDT.DRP_OFF_CHG_TRF_AMT," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_EXPT_FLG," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_CFM_USR_ID," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_CFM_DT," ).append("\n"); 
		query.append("	   TO_CHAR(       DDT.DRP_OFF_CHG_TRF_CFM_DT,'YYYY-MM-DD HH24:MI') as DRP_OFF_CHG_TRF_CFM_DT," ).append("\n"); 
		query.append("	   DECODE(       DDT.DRP_OFF_CHG_TRF_CFM_FLG, 'Y', 'C', 'S') as DRP_OFF_CHG_TRF_CFM_FLG, " ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_RMK," ).append("\n"); 
		query.append("       DDT.DELT_FLG," ).append("\n"); 
		query.append("       DDT.CRE_USR_ID," ).append("\n"); 
		query.append("	  DDT.RFA_NO," ).append("\n"); 
		query.append("	  DDT.SC_NO," ).append("\n"); 
		query.append("	   TO_CHAR(       DDT.CRE_DT,'YYYY-MM-DD HH24:MI') as CRE_DT," ).append("\n"); 
		query.append("       DDT.UPD_USR_ID," ).append("\n"); 
		query.append("	   TO_CHAR(       DDT.UPD_DT,'YYYY-MM-DD HH24:MI') as UPD_DT" ).append("\n"); 
		query.append("from DOD_DRP_OFF_CHG_TRF DDT" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("#if( ${del_cd} != '' )" ).append("\n"); 
		query.append("  and DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  and cntr_rtn_loc_cd = @[cntr_rtn_loc_cd]" ).append("\n"); 
		query.append("  and cntr_tpsz_cd = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#if ( ${cntr_rtn_yd_sfx_cd} != '' && ${cntr_rtn_yd_sfx_cd} != 'ALL' )" ).append("\n"); 
		query.append("  and cntr_rtn_yd_sfx_cd = @[cntr_rtn_yd_sfx_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  and drp_off_chg_trf_cnt_cd = @[drp_off_chg_trf_cnt_cd]" ).append("\n"); 
		query.append("#if ( ${pol_conti_cd} != '' && ${pol_conti_cd} != 'ALL' )" ).append("\n"); 
		query.append("  and pol_conti_cd = @[pol_conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${drp_off_chg_trf_div_cd} != 'G')" ).append("\n"); 
		query.append("  #if ( ${rfa_no} != '')" ).append("\n"); 
		query.append("    and RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if ( ${sc_no} != '')" ).append("\n"); 
		query.append("    and SC_NO = @[sc_no]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${spcl_cust_cnt_seq} != '')" ).append("\n"); 
		query.append("   and SPCL_CUST_CNT_CD = SUBSTR(@[spcl_cust_cnt_seq], 0, 2)" ).append("\n"); 
		query.append("   and SPCL_CUST_SEQ = SUBSTR(@[spcl_cust_cnt_seq], 3)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   and SPCL_CUST_CNT_CD is null" ).append("\n"); 
		query.append("   and SPCL_CUST_SEQ is null" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and DDT.DRP_OFF_CHG_TRF_AMT = @[drp_off_chg_trf_amt]" ).append("\n"); 
		query.append("AND DRP_OFF_CHG_TRF_DIV_CD = @[drp_off_chg_trf_div_cd]" ).append("\n"); 
		query.append("and DRP_OFF_CHG_TRF_EXP_FLG != 'Y'" ).append("\n"); 
		query.append("and delt_flg = 'N'" ).append("\n"); 

	}
}