/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.21 
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

public class TerminalAgreementManageDBDAOSearchTerminalAgreementDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Rate List Detail Select
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchTerminalAgreementDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementDetailRSQL").append("\n"); 
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
		query.append("SELECT	a.lgs_cost_cd" ).append("\n"); 
		query.append("		, a.auto_calc_flg" ).append("\n"); 
		query.append("		, a.tml_agmt_vol_ut_cd" ).append("\n"); 
		query.append("		, a.curr_cd" ).append("\n"); 
		query.append("		, a.thrp_lgs_cost_cd" ).append("\n"); 
		query.append("		, decode(a.sub_trd_cd,'S','Same','O','OTH',a.sub_trd_cd) as SUB_TRD_CD" ).append("\n"); 
		query.append("		, a.tml_cntr_sty_cd" ).append("\n"); 
		query.append("		, decode(a.ioc_cd,'I','IPC','O','OCN','S','Same',a.ioc_cd) as IOC_CD" ).append("\n"); 
		query.append("		, decode(a.io_bnd_cd,'I','IB','O','OB','S','Same',a.io_bnd_cd) as IO_BND_CD" ).append("\n"); 
		query.append("		, decode(a.tml_trns_mod_cd,'S','Same','O','Other','T','Truck','B','Barge','R','Rail','F','Feeder','V','Mother',a.tml_trns_mod_cd) as TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("		, b.wkdy_flg" ).append("\n"); 
		query.append("		, b.sat_flg" ).append("\n"); 
		query.append("		, b.sun_flg" ).append("\n"); 
		query.append("		, b.hol_flg" ).append("\n"); 
		query.append("		, decode(a.lane_cd,'Sam','Same',a.lane_cd) as LANE_CD" ).append("\n"); 
		query.append("		, DECODE(a.DCGO_APLY_TP_CD,'N','Y') dg_none" ).append("\n"); 
		query.append("		, CASE  WHEN a.dcgo_aply_tp_cd = 'A' THEN  " ).append("\n"); 
		query.append("				CASE  WHEN c.dcgo_non_clss_flg = 'Y' THEN 'Y'	END  " ).append("\n"); 
		query.append("		END AS same_dg_none" ).append("\n"); 
		query.append("		, CASE WHEN a.dcgo_aply_tp_cd = 'A' THEN  " ).append("\n"); 
		query.append("			CASE WHEN c.dcgo_sam_clss_flg = 'Y' THEN 'Y' END " ).append("\n"); 
		query.append("		END AS same_dg" ).append("\n"); 
		query.append("		, CASE WHEN a.dcgo_aply_tp_cd = 'S' THEN  " ).append("\n"); 
		query.append("			CASE WHEN c.dcgo_non_clss_flg = 'Y' THEN 'Y' END " ).append("\n"); 
		query.append("		END AS sep_dg_none" ).append("\n"); 
		query.append("		, c.dcgo_n1st_clss_flg" ).append("\n"); 
		query.append("		, c.dcgo_n2nd_clss_flg" ).append("\n"); 
		query.append("		, c.dcgo_n3rd_clss_flg" ).append("\n"); 
		query.append("		, c.dcgo_n4th_clss_flg" ).append("\n"); 
		query.append("		, c.dcgo_n5th_clss_flg" ).append("\n"); 
		query.append("		, c.dcgo_n6th_clss_flg" ).append("\n"); 
		query.append("		, c.dcgo_n7th_clss_flg" ).append("\n"); 
		query.append("		, c.dcgo_n8th_clss_flg" ).append("\n"); 
		query.append("		, c.dcgo_n9th_clss_flg" ).append("\n"); 
		query.append("		, a.tml_ovt_shft_cd" ).append("\n"); 
		query.append("        , a.thc_tp_cd" ).append("\n"); 
		query.append("		--, decode(a.thc_tp_cd,'T','BOTH','L','LIFT','G','GIO',a.thc_tp_cd) as THC_TP_CD" ).append("\n"); 
		query.append("		, a.fm_tr_vol_val, a.to_tr_vol_val" ).append("\n"); 
		query.append("		, d.D2, d.D4, d.D5, d.D7, d.D8, d.D9, d.DW, d.DX" ).append("\n"); 
		query.append("		, d.R2, d.R4, d.R5, d.R7 " ).append("\n"); 
		query.append("		, d.F2, d.F4 " ).append("\n"); 
		query.append("		, d.O2, d.O4 " ).append("\n"); 
		query.append("		, d.S2, d.S4 " ).append("\n"); 
		query.append("		, d.T2, d.T4 " ).append("\n"); 
		query.append("		, d.A2, d.A4 " ).append("\n"); 
		query.append("		, d.P2, d.P4 " ).append("\n"); 
		query.append("		, d.F5 " ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'T',a.agmt_ut_rt,'0') teu_rate " ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'U',a.agmt_ut_rt,'0') box_rate" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'M',a.agmt_ut_rt,'0') move_rate " ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'G',a.agmt_ut_rt,'0') gang_hour_rate" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'W',a.agmt_ut_rt,'0') tonne_rate " ).append("\n"); 
		query.append("		, '#'||d.D2||'#'||d.D4||'#'||d.D5||'#'||d.D7||'#'||d.D8||'#'||d.D9||'#'||d.DW||'#'||d.DX||'#'||d.R2||'#'||d.R4||'#'||d.R5||'#'||d.R7||'#'|| " ).append("\n"); 
		query.append("		d.F2||'#'||d.F4||'#'||d.F5||'#'||d.O2||'#'||d.O4||'#'||d.S2||'#'||d.S4||'#'||d.T2||'#'||d.T4||'#'||d.A2||'#'||d.A4||'#'||d.P2||'#'||d.P4 	TS_RT" ).append("\n"); 
		query.append("		, a.tml_agmt_dtl_seq " ).append("\n"); 
		query.append("		, a.agmt_dtl_rmk remark " ).append("\n"); 
		query.append("		, a.agmt_dtl_rmk " ).append("\n"); 
		query.append("		,(SELECT com_auto_calc_flg                          " ).append("\n"); 
		query.append("				||'|'||tml_thrp_cost_cd_flg     																																																																																														" ).append("\n"); 
		query.append("				||'|'||tml_io_bnd_flg           																																																																																														" ).append("\n"); 
		query.append("				||'|'||tml_ioc_flg              																																																																																														" ).append("\n"); 
		query.append("				||'|'||tml_aply_dt_flg          																																																																																														" ).append("\n"); 
		query.append("				||'|'||tml_lane_flg             																																																																																														" ).append("\n"); 
		query.append("				||'|'||tml_dcgo_aply_flg        																																																																																														" ).append("\n"); 
		query.append("				||'|'||tml_tr_vol_flg           																																																																																														" ).append("\n"); 
		query.append("				||'|'||tml_ovt_shft_flg         																																																																																														" ).append("\n"); 
		query.append("				||'|'||tml_thc_flg              																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_com_agmt_tp_flg      																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_com_cmnc_tm_flg      																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_io_bnd_flg   																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_flg          																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_dcgo_tm_flg  																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_xcld_dt_flg  																																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_dcgo_rt_flg             																																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_tr_dy_flg               																																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_fp_calc_prd_flg                 																																																																																																														" ).append("\n"); 
		query.append("				||'|'||sto_fp_teu_flg                      																																																																																																														" ).append("\n"); 
		query.append("				||'|'||rt_cntr_tpsz_flg                    																																																																																																														" ).append("\n"); 
		query.append("				||'|'||rt_teu_flg                          																																																																																																														" ).append("\n"); 
		query.append("				||'|'||rt_bx_flg                           																																																																																																														" ).append("\n"); 
		query.append("				||'|'||rt_mv_flg                           																																																																																																														" ).append("\n"); 
		query.append("				||'|'||free_dy_cntr_tpsz_flg" ).append("\n"); 
		query.append("				||'|'|| tml_trns_mod_flg" ).append("\n"); 
		query.append("				||'|'|| tml_cntr_full_mty_flg" ).append("\n"); 
		query.append("				||'|'|| sto_cntr_full_mty_flg" ).append("\n"); 
		query.append("				||'|'|| tml_sub_trd_flg vrfy_string  																																																																																																														" ).append("\n"); 
		query.append("		FROM	TES_TML_AGMT_VRFY_MZD                        " ).append("\n"); 
		query.append("		WHERE lgs_cost_cd = a.lgs_cost_cd ) vrfyFlg				" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_DTL A, TES_TML_AGMT_APLY_DY B, TES_TML_AGMT_DG_CGO_CLSS C, " ).append("\n"); 
		query.append("		(SELECT TML_AGMT_OFC_CTY_CD,TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_AGMT_DTL_SEQ, CNTR_APLY_TP_CD, LGS_COST_CD,  				" ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(D2),'TPXXDC',SUM(D2),'SVXXDC',SUM(D2),'CGXXDC',SUM(D2),'ETXXDC',SUM(D2),'SVDRFL',SUM(D2),'SVDRMT',SUM(D2),'SVDRTS',SUM(D2),MAX(D2)) D2," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(D4),'TPXXDC',SUM(D4),'SVXXDC',SUM(D4),'CGXXDC',SUM(D4),'ETXXDC',SUM(D4),'SVDRFL',SUM(D4),'SVDRMT',SUM(D4),'SVDRTS',SUM(D4),MAX(D4)) D4," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(D5),'TPXXDC',SUM(D5),'SVXXDC',SUM(D5),'CGXXDC',SUM(D5),'ETXXDC',SUM(D5),'SVDRFL',SUM(D5),'SVDRMT',SUM(D5),'SVDRTS',SUM(D5),MAX(D5)) D5," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(D7),'TPXXDC',SUM(D7),'SVXXDC',SUM(D7),'CGXXDC',SUM(D7),'ETXXDC',SUM(D7),'SVDRFL',SUM(D7),'SVDRMT',SUM(D7),'SVDRTS',SUM(D7),MAX(D7)) D7," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(D8),'TPXXDC',SUM(D8),'SVXXDC',SUM(D8),'CGXXDC',SUM(D8),'ETXXDC',SUM(D8),'SVDRFL',SUM(D8),'SVDRMT',SUM(D8),'SVDRTS',SUM(D8),MAX(D8)) D8," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(D9),'TPXXDC',SUM(D9),'SVXXDC',SUM(D9),'CGXXDC',SUM(D9),'ETXXDC',SUM(D9),'SVDRFL',SUM(D9),'SVDRMT',SUM(D9),'SVDRTS',SUM(D9),MAX(D9)) D9," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(DW),'TPXXDC',SUM(DW),'SVXXDC',SUM(DW),'CGXXDC',SUM(DW),'ETXXDC',SUM(DW),'SVDRFL',SUM(DW),'SVDRMT',SUM(DW),'SVDRTS',SUM(DW),MAX(DW)) DW," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(DX),'TPXXDC',SUM(DX),'SVXXDC',SUM(DX),'CGXXDC',SUM(DX),'ETXXDC',SUM(DX),'SVDRFL',SUM(DX),'SVDRMT',SUM(DX),'SVDRTS',SUM(DX),MAX(DX)) DX," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(R2),'TPXXDC',SUM(R2),'SVXXDC',SUM(R2),'CGXXDC',SUM(R2),'ETXXDC',SUM(R2),'SVDRFL',SUM(R2),'SVDRMT',SUM(R2),'SVDRTS',SUM(R2),MAX(R2)) R2," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(R4),'TPXXDC',SUM(R4),'SVXXDC',SUM(R4),'CGXXDC',SUM(R4),'ETXXDC',SUM(R4),'SVDRFL',SUM(R4),'SVDRMT',SUM(R4),'SVDRTS',SUM(R4),MAX(R4)) R4," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(R5),'TPXXDC',SUM(R5),'SVXXDC',SUM(R5),'CGXXDC',SUM(R5),'ETXXDC',SUM(R5),'SVDRFL',SUM(R5),'SVDRMT',SUM(R5),'SVDRTS',SUM(R5),MAX(R5)) R5," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(R7),'TPXXDC',SUM(R7),'SVXXDC',SUM(R7),'CGXXDC',SUM(R7),'ETXXDC',SUM(R7),'SVDRFL',SUM(R7),'SVDRMT',SUM(R7),'SVDRTS',SUM(R7),MAX(R7)) R7," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(F2),'TPXXDC',SUM(F2),'SVXXDC',SUM(F2),'CGXXDC',SUM(F2),'ETXXDC',SUM(F2),'SVDRFL',SUM(F2),'SVDRMT',SUM(F2),'SVDRTS',SUM(F2),MAX(F2)) F2," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(F4),'TPXXDC',SUM(F4),'SVXXDC',SUM(F4),'CGXXDC',SUM(F4),'ETXXDC',SUM(F4),'SVDRFL',SUM(F4),'SVDRMT',SUM(F4),'SVDRTS',SUM(F4),MAX(F4)) F4," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(O2),'TPXXDC',SUM(O2),'SVXXDC',SUM(O2),'CGXXDC',SUM(O2),'ETXXDC',SUM(O2),'SVDRFL',SUM(O2),'SVDRMT',SUM(O2),'SVDRTS',SUM(O2),MAX(O2)) O2," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(O4),'TPXXDC',SUM(O4),'SVXXDC',SUM(O4),'CGXXDC',SUM(O4),'ETXXDC',SUM(O4),'SVDRFL',SUM(O4),'SVDRMT',SUM(O4),'SVDRTS',SUM(O4),MAX(O4)) O4," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(S2),'TPXXDC',SUM(S2),'SVXXDC',SUM(S2),'CGXXDC',SUM(S2),'ETXXDC',SUM(S2),'SVDRFL',SUM(S2),'SVDRMT',SUM(S2),'SVDRTS',SUM(S2),MAX(S2)) S2," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(S4),'TPXXDC',SUM(S4),'SVXXDC',SUM(S4),'CGXXDC',SUM(S4),'ETXXDC',SUM(S4),'SVDRFL',SUM(S4),'SVDRMT',SUM(S4),'SVDRTS',SUM(S4),MAX(S4)) S4," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(T2),'TPXXDC',SUM(T2),'SVXXDC',SUM(T2),'CGXXDC',SUM(T2),'ETXXDC',SUM(T2),'SVDRFL',SUM(T2),'SVDRMT',SUM(T2),'SVDRTS',SUM(T2),MAX(T2)) T2," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(T4),'TPXXDC',SUM(T4),'SVXXDC',SUM(T4),'CGXXDC',SUM(T4),'ETXXDC',SUM(T4),'SVDRFL',SUM(T4),'SVDRMT',SUM(T4),'SVDRTS',SUM(T4),MAX(T4)) T4," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(A2),'TPXXDC',SUM(A2),'SVXXDC',SUM(A2),'CGXXDC',SUM(A2),'ETXXDC',SUM(A2),'SVDRFL',SUM(A2),'SVDRMT',SUM(A2),'SVDRTS',SUM(A2),MAX(A2)) A2," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(A4),'TPXXDC',SUM(A4),'SVXXDC',SUM(A4),'CGXXDC',SUM(A4),'ETXXDC',SUM(A4),'SVDRFL',SUM(A4),'SVDRMT',SUM(A4),'SVDRTS',SUM(A4),MAX(A4)) A4," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(P2),'TPXXDC',SUM(P2),'SVXXDC',SUM(P2),'CGXXDC',SUM(P2),'ETXXDC',SUM(P2),'SVDRFL',SUM(P2),'SVDRMT',SUM(P2),'SVDRTS',SUM(P2),MAX(P2)) P2," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(P4),'TPXXDC',SUM(P4),'SVXXDC',SUM(P4),'CGXXDC',SUM(P4),'ETXXDC',SUM(P4),'SVDRFL',SUM(P4),'SVDRMT',SUM(P4),'SVDRTS',SUM(P4),MAX(P4)) P4," ).append("\n"); 
		query.append("				DECODE(LGS_COST_CD,'TMXXDC',SUM(F5),'TPXXDC',SUM(F5),'SVXXDC',SUM(F5),'CGXXDC',SUM(F5),'ETXXDC',SUM(F5),'SVDRFL',SUM(F5),'SVDRMT',SUM(F5),'SVDRTS',SUM(F5),MAX(F5)) F5 " ).append("\n"); 
		query.append("		FROM  ( SELECT	A.TML_AGMT_OFC_CTY_CD, A.TML_AGMT_SEQ, A.TML_AGMT_VER_NO, A.TML_AGMT_DTL_SEQ, B.CNTR_APLY_TP_CD, A.LGS_COST_CD," ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'D2',AGMT_RT,0) D2, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'D4',AGMT_RT,0) D4, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'D5',AGMT_RT,0) D5, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'D7',AGMT_RT,0) D7, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'D8',AGMT_RT,0) D8, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'D9',AGMT_RT,0) D9, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'DW',AGMT_RT,0) DW, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'DX',AGMT_RT,0) DX, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'R2',AGMT_RT,0) R2, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'R4',AGMT_RT,0) R4, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'R5',AGMT_RT,0) R5, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'R7',AGMT_RT,0) R7, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'F2',AGMT_RT,0) F2, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'F4',AGMT_RT,0) F4, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'O2',AGMT_RT,0) O2, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'O4',AGMT_RT,0) O4, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'S2',AGMT_RT,0) S2, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'S4',AGMT_RT,0) S4, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'T2',AGMT_RT,0) T2, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'T4',AGMT_RT,0) T4, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'A2',AGMT_RT,0) A2, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'A4',AGMT_RT,0) A4, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'P2',AGMT_RT,0) P2, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'P4',AGMT_RT,0) P4, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_TPSZ_CD,'F5',AGMT_RT,0) F5  " ).append("\n"); 
		query.append("				FROM	TES_TML_AGMT_DTL A, TES_TML_AGMT_TP_SZ B  " ).append("\n"); 
		query.append("				WHERE	A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD " ).append("\n"); 
		query.append("				AND		A.TML_AGMT_SEQ = B.TML_AGMT_SEQ " ).append("\n"); 
		query.append("				AND		A.TML_AGMT_VER_NO = B.TML_AGMT_VER_NO " ).append("\n"); 
		query.append("				AND		A.TML_AGMT_DTL_SEQ = B.TML_AGMT_DTL_SEQ ) " ).append("\n"); 
		query.append("		GROUP BY TML_AGMT_OFC_CTY_CD,TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_AGMT_DTL_SEQ, CNTR_APLY_TP_CD, LGS_COST_CD) D  " ).append("\n"); 
		query.append("WHERE	A.TML_AGMT_OFC_CTY_CD	= @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ			= @[tml_agmt_seq]" ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO		= @[tml_agmt_ver_no]" ).append("\n"); 
		query.append("AND		A.TML_AGMT_TP_CD = 'T'  " ).append("\n"); 
		query.append("AND		A.TMP_SAV_FLG IS NULL" ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD(+)  " ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD = C.TML_AGMT_OFC_CTY_CD(+)  " ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ = B.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ = C.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ = D.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO = B.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO = C.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO = D.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ = B.TML_AGMT_DTL_SEQ(+) " ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ = C.TML_AGMT_DTL_SEQ(+) " ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ = D.TML_AGMT_DTL_SEQ(+) " ).append("\n"); 
		query.append("ORDER BY A.LGS_COST_CD DESC" ).append("\n"); 

	}
}