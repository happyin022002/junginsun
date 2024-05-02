/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChargeCalculationDBDAODmtChgPreCalcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.07
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.10.07 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAODmtChgPreCalcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAODmtChgPreCalcCSQL.Query
	  * </pre>
	  */
	public ChargeCalculationDBDAODmtChgPreCalcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_expt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ft_end_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_adj_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_trf_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_rfa_expt_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_expt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_expt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_ft_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_expt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_ft_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("web_mty_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_expt_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_rqst_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_cmnc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODmtChgPreCalcUSQL").append("\n"); 
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
		query.append("UPDATE	DMT_CHG_PRE_CALC" ).append("\n"); 
		query.append("SET     (" ).append("\n"); 
		query.append("          FM_MVMT_STS_CD" ).append("\n"); 
		query.append("        , FM_MVMT_DT" ).append("\n"); 
		query.append("        , FM_MVMT_YD_CD" ).append("\n"); 
		query.append("        , TO_MVMT_STS_CD" ).append("\n"); 
		query.append("        , TO_MVMT_DT" ).append("\n"); 
		query.append("        , TO_MVMT_YD_CD" ).append("\n"); 
		query.append("        , NOT_CRE_BAL_FLG" ).append("\n"); 
		query.append("        , FT_DYS" ).append("\n"); 
		query.append("        , FT_CMNC_DT" ).append("\n"); 
		query.append("        , FT_END_DT" ).append("\n"); 
		query.append("        , FX_FT_OVR_DYS" ).append("\n"); 
		query.append("        , ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("        , SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append("        , AFT_EXPT_OVR_DYS" ).append("\n"); 
		query.append("        , BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("        , DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("        , ORG_CHG_AMT" ).append("\n"); 
		query.append("        , SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("        , AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("        , BIL_AMT" ).append("\n"); 
		query.append("        , DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("        , SC_RFA_AMT" ).append("\n"); 
		query.append("        , AFT_EXPT_AMT" ).append("\n"); 
		query.append("        , BZC_TRF_SEQ" ).append("\n"); 
		query.append("        , BZC_DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        , BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("        , BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("        , RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append("        , RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("        , RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("        , RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("        , AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append("        , AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("        , AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("        , SC_NO" ).append("\n"); 
		query.append("        , SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("        , SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("        , CORR_RMK" ).append("\n"); 
		query.append("        , OFC_CD" ).append("\n"); 
		query.append("        , OFC_RHQ_CD" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_OFC_CD" ).append("\n"); 
		query.append("        , CMDT_CD" ).append("\n"); 
		query.append("        , CMDT_TRF_SEQ" ).append("\n"); 
		query.append("        , CMDT_EXPT_APLY_DT" ).append("\n"); 
		query.append("        , CMDT_OVR_DYS" ).append("\n"); 
		query.append("        , CMDT_EXPT_AMT" ).append("\n"); 
		query.append("        , WEB_MTY_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        =" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT    @[fm_mvmt_sts_cd]" ).append("\n"); 
		query.append("                , TO_DATE(@[fm_mvmt_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                , @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("                , @[to_mvmt_sts_cd]" ).append("\n"); 
		query.append("                , TO_DATE(@[to_mvmt_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                , @[to_mvmt_yd_cd]" ).append("\n"); 
		query.append("                , 'N'" ).append("\n"); 
		query.append("                , @[ft_dys]" ).append("\n"); 
		query.append("                , TO_DATE(@[ft_cmnc_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                , TO_DATE(@[ft_end_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                , @[fx_ft_ovr_dys]" ).append("\n"); 
		query.append("                , @[org_ft_ovr_dys]" ).append("\n"); 
		query.append("                , @[sc_rfa_expt_ovr_dys]" ).append("\n"); 
		query.append("                , @[aft_expt_ovr_dys]" ).append("\n"); 
		query.append("                , @[bzc_trf_curr_cd]" ).append("\n"); 
		query.append("                , @[dmdt_trf_aply_tp_cd]" ).append("\n"); 
		query.append("                , @[org_chg_amt]" ).append("\n"); 
		query.append("                , @[sc_rfa_expt_amt]" ).append("\n"); 
		query.append("                , @[aft_expt_dc_amt]" ).append("\n"); 
		query.append("                , @[bil_amt]" ).append("\n"); 
		query.append("                , @[dmdt_chg_sts_cd]" ).append("\n"); 
		query.append("                , @[sc_rfa_amt]" ).append("\n"); 
		query.append("                , @[aft_expt_amt]" ).append("\n"); 
		query.append("                , @[bzc_trf_seq]" ).append("\n"); 
		query.append("                , NVL(@[bzc_dmdt_de_term_cd], 'N')" ).append("\n"); 
		query.append("                , @[bzc_trf_grp_seq]" ).append("\n"); 
		query.append("                , TO_DATE(@[bzc_trf_aply_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("                , @[rfa_expt_apro_no]" ).append("\n"); 
		query.append("                , @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("                , @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("                , @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("                , @[rfa_rqst_dtl_seq]" ).append("\n"); 
		query.append("                , @[aft_expt_apro_no]" ).append("\n"); 
		query.append("                , @[aft_expt_dar_no]" ).append("\n"); 
		query.append("                , @[aft_expt_adj_seq]" ).append("\n"); 
		query.append("                , @[sc_no]" ).append("\n"); 
		query.append("                , @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("                , @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("                , TO_DATE(@[sc_rfa_expt_aply_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("                , @[corr_rmk]" ).append("\n"); 
		query.append("                , @[ofc_cd]" ).append("\n"); 
		query.append("                , @[ofc_rhq_cd]" ).append("\n"); 
		query.append("                , NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("                , @[upd_usr_id]" ).append("\n"); 
		query.append("                , @[upd_ofc_cd]" ).append("\n"); 
		query.append("                , @[cmdt_cd]" ).append("\n"); 
		query.append("                , @[cmdt_trf_seq]" ).append("\n"); 
		query.append("                , TO_DATE(@[cmdt_expt_aply_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("                , @[cmdt_ovr_dys]" ).append("\n"); 
		query.append("                , @[cmdt_expt_amt]" ).append("\n"); 
		query.append("                , TO_DATE(@[web_mty_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("        FROM	DUAL" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID     = @[svr_id]" ).append("\n"); 
		query.append("AND     CNTR_NO             = @[cntr_no]" ).append("\n"); 
		query.append("AND     CNTR_CYC_NO         = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD         = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND     CHG_SEQ             = @[chg_seq]" ).append("\n"); 

	}
}