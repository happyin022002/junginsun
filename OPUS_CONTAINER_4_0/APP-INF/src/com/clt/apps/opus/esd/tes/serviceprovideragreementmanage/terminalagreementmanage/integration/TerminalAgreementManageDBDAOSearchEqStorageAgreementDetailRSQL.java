/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchEqStorageAgreementDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
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

public class TerminalAgreementManageDBDAOSearchEqStorageAgreementDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEqStorageAgreementDetail
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchEqStorageAgreementDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchEqStorageAgreementDetailRSQL").append("\n"); 
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
		query.append("SELECT	a.lgs_cost_cd, a.tml_agmt_vol_ut_cd, a.curr_cd, a.TML_STO_AGMT_TP_CD" ).append("\n"); 
		query.append("		, DECODE(a.CMNC_HRMNT, null, a.CMNC_HRMNT, SUBSTR(a.CMNC_HRMNT,1,2) || ':' ||SUBSTR(a.CMNC_HRMNT,3,2))  CMNC_HRMNT" ).append("\n"); 
		query.append("		, a.io_bnd_cd, DECODE(a.tml_free_dys_tp_cd, 'D','F','R','' ) FT_DYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,b.sat_flg sat_flg_fd, b.sun_flg sun_flg_fd, b.hol_flg hol_flg_fd" ).append("\n"); 
		query.append("		, a.fm_tr_dys, a.to_tr_dys, a.FP_CALC_PRD_CD, a.fp_teu_qty" ).append("\n"); 
		query.append("		, SL2_D,  TA2_D" ).append("\n"); 
		query.append("		, GN4_D,  EG5_D" ).append("\n"); 
		query.append("		, CH2_D,  CH4_D" ).append("\n"); 
		query.append("		, CLG_D,  UMG_D" ).append("\n"); 
		query.append("		, COM_D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, SL2_R,  TA2_R" ).append("\n"); 
		query.append("		, GN4_R,  EG5_R" ).append("\n"); 
		query.append("		, CH2_R,  CH4_R" ).append("\n"); 
		query.append("		, CLG_R,  UMG_R" ).append("\n"); 
		query.append("		, COM_R" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'T',a.agmt_ut_rt,'0') teu_rate" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'U',a.agmt_ut_rt,'0') box_rate" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'M',a.agmt_ut_rt,'0') move_rate" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'W',a.agmt_ut_rt,'0') tonne_rate" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , '#'||SL2_D||'#'||TA2_D" ).append("\n"); 
		query.append("        ||'#'||GN4_D||'#'||EG5_D" ).append("\n"); 
		query.append("        ||'#'||CH2_D||'#'||CH4_D" ).append("\n"); 
		query.append("        ||'#'||CLG_D||'#'||UMG_D" ).append("\n"); 
		query.append("		||'#'||COM_D" ).append("\n"); 
		query.append("        ||'#'||SL2_R||'#'||TA2_R" ).append("\n"); 
		query.append("        ||'#'||GN4_R||'#'||EG5_R" ).append("\n"); 
		query.append("        ||'#'||CH2_R||'#'||CH4_R" ).append("\n"); 
		query.append("        ||'#'||CLG_R||'#'||UMG_R " ).append("\n"); 
		query.append("		||'#'||COM_R AS TS_RT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, a.agmt_dtl_rmk remark" ).append("\n"); 
		query.append("		, a.agmt_dtl_rmk agmt_dtl_rmk" ).append("\n"); 
		query.append("		, a.tml_agmt_dtl_seq tml_agmt_dtl_seq" ).append("\n"); 
		query.append("		, (SELECT	com_auto_calc_flg" ).append("\n"); 
		query.append("				||'|'||tml_thrp_cost_cd_flg" ).append("\n"); 
		query.append("				||'|'||tml_io_bnd_flg" ).append("\n"); 
		query.append("				||'|'||tml_ioc_flg" ).append("\n"); 
		query.append("				||'|'||tml_aply_dt_flg" ).append("\n"); 
		query.append("				||'|'||tml_lane_flg" ).append("\n"); 
		query.append("				||'|'||tml_dcgo_aply_flg" ).append("\n"); 
		query.append("				||'|'||tml_tr_vol_flg" ).append("\n"); 
		query.append("				||'|'||tml_ovt_shft_flg" ).append("\n"); 
		query.append("				||'|'||tml_thc_flg" ).append("\n"); 
		query.append("				||'|'||sto_com_agmt_tp_flg" ).append("\n"); 
		query.append("				||'|'||sto_com_cmnc_tm_flg" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_io_bnd_flg" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_flg" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_dcgo_tm_flg" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_xcld_dt_flg" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_dcgo_rt_flg" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_tr_dy_flg" ).append("\n"); 
		query.append("				||'|'||sto_fp_calc_prd_flg" ).append("\n"); 
		query.append("				||'|'||sto_fp_teu_flg" ).append("\n"); 
		query.append("				||'|'||rt_cntr_tpsz_flg" ).append("\n"); 
		query.append("				||'|'||rt_teu_flg" ).append("\n"); 
		query.append("				||'|'||rt_bx_flg" ).append("\n"); 
		query.append("				||'|'||rt_mv_flg" ).append("\n"); 
		query.append("				||'|'||free_dy_cntr_tpsz_flg" ).append("\n"); 
		query.append("				||'|'||tml_trns_mod_flg" ).append("\n"); 
		query.append("				||'|'||tml_cntr_full_mty_flg" ).append("\n"); 
		query.append("				||'|'||sto_cntr_full_mty_flg" ).append("\n"); 
		query.append("				||'|'||tml_sub_trd_flg   vrfy_string" ).append("\n"); 
		query.append("		FROM TES_TML_AGMT_VRFY_MZD" ).append("\n"); 
		query.append("		WHERE lgs_cost_cd = a.lgs_cost_cd ) vrfyFlg" ).append("\n"); 
		query.append("		, tml_cntr_sty_cd" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_DTL A, TES_TML_AGMT_APLY_DY B, TES_TML_AGMT_DG_CGO_CLSS C," ).append("\n"); 
		query.append("       	(SELECT	TML_AGMT_OFC_CTY_CD,TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_AGMT_DTL_SEQ, LGS_COST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			    , MAX(SL2_D) SL2_D, MAX(TA2_D) TA2_D, MAX(GN4_D) GN4_D ,MAX(EG5_D) EG5_D ,MAX(CH2_D) CH2_D, MAX(CH4_D) CH4_D, MAX(CLG_D) CLG_D, MAX(UMG_D) UMG_D, MAX(COM_D) COM_D" ).append("\n"); 
		query.append("				, MAX(SL2_R) SL2_R, MAX(TA2_R) TA2_R, MAX(GN4_R) GN4_R ,MAX(EG5_R) EG5_R ,MAX(CH2_R) CH2_R, MAX(CH4_R) CH4_R, MAX(CLG_R) CLG_R, MAX(UMG_R) UMG_R, MAX(COM_R) COM_R" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM	(SELECT A.TML_AGMT_OFC_CTY_CD, A.TML_AGMT_SEQ, A.TML_AGMT_VER_NO, A.TML_AGMT_DTL_SEQ, A.LGS_COST_CD," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'D', DECODE(B.EQ_TPSZ_CD,'SL2',AGMT_DYS,0), 0)  SL2_D," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'D', DECODE(B.EQ_TPSZ_CD,'TA2',AGMT_DYS,0), 0)  TA2_D," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'D', DECODE(B.EQ_TPSZ_CD,'GN4',AGMT_DYS,0), 0)  GN4_D," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'D', DECODE(B.EQ_TPSZ_CD,'EG5',AGMT_DYS,0), 0)  EG5_D," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'D', DECODE(B.EQ_TPSZ_CD,'CH2',AGMT_DYS,0), 0)  CH2_D," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'D', DECODE(B.EQ_TPSZ_CD,'CH4',AGMT_DYS,0), 0)  CH4_D," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'D', DECODE(B.EQ_TPSZ_CD,'CLG',AGMT_DYS,0), 0)  CLG_D," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'D', DECODE(B.EQ_TPSZ_CD,'UMG',AGMT_DYS,0), 0)  UMG_D," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'D', DECODE(B.EQ_TPSZ_CD,'COM',AGMT_DYS,0), 0)  COM_D," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'R', DECODE(B.EQ_TPSZ_CD,'SL2',AGMT_RT,0), 0)  SL2_R," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'R', DECODE(B.EQ_TPSZ_CD,'TA2',AGMT_RT,0), 0)  TA2_R," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'R', DECODE(B.EQ_TPSZ_CD,'GN4',AGMT_RT,0), 0)  GN4_R," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'R', DECODE(B.EQ_TPSZ_CD,'EG5',AGMT_RT,0), 0)  EG5_R," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'R', DECODE(B.EQ_TPSZ_CD,'CH2',AGMT_RT,0), 0)  CH2_R," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'R', DECODE(B.EQ_TPSZ_CD,'CH4',AGMT_RT,0), 0)  CH4_R," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'R', DECODE(B.EQ_TPSZ_CD,'CLG',AGMT_RT,0), 0)  CLG_R," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'R', DECODE(B.EQ_TPSZ_CD,'UMG',AGMT_RT,0), 0)  UMG_R," ).append("\n"); 
		query.append(" 						DECODE(B.EQ_APLY_TP_CD, 'R', DECODE(B.EQ_TPSZ_CD,'COM',AGMT_RT,0), 0)  COM_R" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       	        FROM	TES_TML_AGMT_DTL A, TES_TML_AGMT_EQ_TP_SZ B" ).append("\n"); 
		query.append("       	        WHERE	A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       	        AND		A.TML_AGMT_SEQ = B.TML_AGMT_SEQ" ).append("\n"); 
		query.append("       	        AND		A.TML_AGMT_VER_NO = B.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("       	        AND		A.TML_AGMT_DTL_SEQ = B.TML_AGMT_DTL_SEQ )" ).append("\n"); 
		query.append("       	GROUP BY TML_AGMT_OFC_CTY_CD,TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_AGMT_DTL_SEQ, LGS_COST_CD) D" ).append("\n"); 
		query.append("WHERE	A.TML_AGMT_OFC_CTY_CD	= @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ			= @[tml_agmt_seq]" ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO		= @[tml_agmt_ver_no]" ).append("\n"); 
		query.append("AND		A.TML_AGMT_TP_CD = 'E'" ).append("\n"); 
		query.append("AND		A.TMP_SAV_FLG IS NULL" ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD = C.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ = B.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ = C.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ = D.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO = B.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO = C.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO = D.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ = B.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ = C.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND A.TML_AGMT_DTL_SEQ = D.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY A.TML_AGMT_DTL_SEQ" ).append("\n"); 

	}
}