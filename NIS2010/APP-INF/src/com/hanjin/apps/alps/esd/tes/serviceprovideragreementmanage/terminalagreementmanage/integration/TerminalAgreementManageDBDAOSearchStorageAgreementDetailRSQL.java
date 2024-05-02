/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchStorageAgreementDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchStorageAgreementDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Storage Agreement Rate Detail List Inquiry
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchStorageAgreementDetailRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchStorageAgreementDetailRSQL").append("\n"); 
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
		query.append("SELECT	A.LGS_COST_CD" ).append("\n"); 
		query.append("		, NVL((SELECT LGS_COST_ABBR_NM FROM TES_LGS_COST T WHERE T.LGS_COST_CD = A.LGS_COST_CD), '') AS LGS_COST_ABBR_NM" ).append("\n"); 
		query.append("		, A.TML_AGMT_VOL_UT_CD, A.CURR_CD, A.TML_STO_AGMT_TP_CD                    								" ).append("\n"); 
		query.append("		, SUBSTR(a.CMNC_HRMNT,1,2) || ':' ||SUBSTR(a.CMNC_HRMNT,3,2) CMNC_HRMNT                        						" ).append("\n"); 
		query.append("		, a.io_bnd_cd, DECODE(a.tml_free_dys_tp_cd, 'D','F','R','' ) FT_DYS" ).append("\n"); 
		query.append("		, DECODE(a.tml_free_dys_tp_cd,'D', DECODE(a.DCGO_APLY_TP_CD,'N','Y'),'') DG_NONE_FD" ).append("\n"); 
		query.append("		, CASE WHEN DECODE(c.dcgo_aply_tp_cd,'D', a.dcgo_aply_tp_cd,'') = 'A' THEN  										" ).append("\n"); 
		query.append("				CASE WHEN DECODE(c.dcgo_aply_tp_cd,'D', c.dcgo_non_clss_flg,'') = 'Y' THEN 'Y'	END  																								" ).append("\n"); 
		query.append("		END AS SAME_DG_NONE_FD" ).append("\n"); 
		query.append("		, CASE WHEN DECODE(c.dcgo_aply_tp_cd,'D', a.dcgo_aply_tp_cd,'') = 'A' THEN  										" ).append("\n"); 
		query.append("				CASE WHEN DECODE(c.dcgo_aply_tp_cd,'D', c.dcgo_sam_clss_flg,'') = 'Y' THEN 'Y' END  																								" ).append("\n"); 
		query.append("		END AS same_dg_FD" ).append("\n"); 
		query.append("		, CASE WHEN DECODE(c.dcgo_aply_tp_cd,'D', a.dcgo_aply_tp_cd,'') = 'S' THEN  										" ).append("\n"); 
		query.append("				CASE WHEN DECODE(c.dcgo_aply_tp_cd,'D', c.dcgo_non_clss_flg,'') = 'Y' THEN 'Y' END  																								" ).append("\n"); 
		query.append("		END AS SEP_DG_NONE_FD  																						" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'D',c.dcgo_n1st_clss_flg,'')   dcgo_n1st_clss_flg_FD                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'D',c.dcgo_n2nd_clss_flg,'')   dcgo_n2nd_clss_flg_FD                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'D',c.dcgo_n3rd_clss_flg,'')   dcgo_n3rd_clss_flg_FD                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'D',c.dcgo_n4th_clss_flg,'')   dcgo_n4th_clss_flg_FD                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'D',c.dcgo_n5th_clss_flg,'')   dcgo_n5th_clss_flg_FD                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'D',c.dcgo_n6th_clss_flg,'')   dcgo_n6th_clss_flg_FD                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'D',c.dcgo_n7th_clss_flg,'')   dcgo_n7th_clss_flg_FD                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'D',c.dcgo_n8th_clss_flg,'')   dcgo_n8th_clss_flg_FD                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'D',c.dcgo_n9th_clss_flg,'')   dcgo_n9th_clss_flg_FD                                    	" ).append("\n"); 
		query.append("		,b.sat_flg sat_flg_fd, b.sun_flg sun_flg_fd, b.hol_flg hol_flg_fd" ).append("\n"); 
		query.append("		, DECODE(a.tml_free_dys_tp_cd,'R', DECODE(a.DCGO_APLY_TP_CD,'N','Y'),'') DG_NONE_R" ).append("\n"); 
		query.append("		, CASE WHEN DECODE(c.dcgo_aply_tp_cd,'R', a.dcgo_aply_tp_cd,'') = 'A' THEN  										" ).append("\n"); 
		query.append("				CASE WHEN DECODE(c.dcgo_aply_tp_cd,'R', c.dcgo_non_clss_flg,'') = 'Y' THEN 'Y' END  																								" ).append("\n"); 
		query.append("		END AS SAME_DG_NONE_R" ).append("\n"); 
		query.append("		, CASE WHEN DECODE(c.dcgo_aply_tp_cd,'R', a.dcgo_aply_tp_cd,'') = 'A' THEN  										" ).append("\n"); 
		query.append("				CASE WHEN DECODE(c.dcgo_aply_tp_cd,'R', c.dcgo_sam_clss_flg, '') = 'Y' THEN 'Y' END  																								" ).append("\n"); 
		query.append("		END AS SAME_DG_R" ).append("\n"); 
		query.append("		, CASE WHEN DECODE(c.dcgo_aply_tp_cd,'R', a.dcgo_aply_tp_cd,'') = 'S' THEN  										" ).append("\n"); 
		query.append("				CASE WHEN DECODE(c.dcgo_aply_tp_cd,'R', c.dcgo_non_clss_flg,'') = 'Y' THEN 'Y' END  																								" ).append("\n"); 
		query.append("		END AS SEP_DG_NONE_R" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'R',c.dcgo_n1st_clss_flg,'')   dcgo_n1st_clss_flg_R                                   	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'R',c.dcgo_n2nd_clss_flg,'')   dcgo_n2nd_clss_flg_R                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'R',c.dcgo_n3rd_clss_flg,'')   dcgo_n3rd_clss_flg_R                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'R',c.dcgo_n4th_clss_flg,'')   dcgo_n4th_clss_flg_R                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'R',c.dcgo_n5th_clss_flg,'')   dcgo_n5th_clss_flg_R                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'R',c.dcgo_n6th_clss_flg,'')   dcgo_n6th_clss_flg_R                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'R',c.dcgo_n7th_clss_flg,'')   dcgo_n7th_clss_flg_R                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'R',c.dcgo_n8th_clss_flg,'')   dcgo_n8th_clss_flg_R                                    	" ).append("\n"); 
		query.append("		, DECODE(c.dcgo_aply_tp_cd,'R',c.dcgo_n9th_clss_flg,'')   dcgo_n9th_clss_flg_R                                    	" ).append("\n"); 
		query.append("		, a.fm_tr_dys, a.to_tr_dys, a.FP_CALC_PRD_CD, a.fp_teu_qty" ).append("\n"); 
		query.append("		, D2_FD, D4_FD, D5_FD, D7_FD, D8_FD, D9_FD                                                            											" ).append("\n"); 
		query.append("		, DW_FD, DX_FD                                                            											" ).append("\n"); 
		query.append("		, R2_FD, R4_FD, R5_FD, R7_FD, R8_FD, R9_FD                                                            											" ).append("\n"); 
		query.append("		, F2_FD, F4_FD                                                            											" ).append("\n"); 
		query.append("		, O2_FD, O4_FD, O5_FD, O7_FD  " ).append("\n"); 
		query.append("		, S2_FD, S4_FD, T2_FD                                                            											" ).append("\n"); 
		query.append("		, T4_FD, A2_FD                                                            											" ).append("\n"); 
		query.append("		, A4_FD, A5_FD, P2_FD                                                            											" ).append("\n"); 
		query.append("		, P4_FD, C2_FD" ).append("\n"); 
		query.append("		, C4_FD, F5_FD" ).append("\n"); 
		query.append("		, D2_R,  D4_R, D5_R, D7_R, D8_R, D9_R                                                             											" ).append("\n"); 
		query.append("		, DW_R,  DX_R                                                             											" ).append("\n"); 
		query.append("		, R2_R,  R4_R, R5_R, R7_R, R8_R, R9_R                                                             											" ).append("\n"); 
		query.append("		, F2_R,  F4_R                                                             											" ).append("\n"); 
		query.append("		, O2_R,  O4_R, O5_R, O7_R" ).append("\n"); 
		query.append("		, S2_R,  S4_R, T2_R                                                             											" ).append("\n"); 
		query.append("		, T4_R,  A2_R                                                             											" ).append("\n"); 
		query.append("		, A4_R,  A5_R, P2_R                                                             											" ).append("\n"); 
		query.append("		, P4_R,  C2_R    " ).append("\n"); 
		query.append("		, C4_R,  F5_R" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'T',a.agmt_ut_rt,'0') teu_rate" ).append("\n"); 
		query.append("		-- // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'B',a.agmt_ut_rt,'0') box_rate" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'M',a.agmt_ut_rt,'0') move_rate" ).append("\n"); 
		query.append("		, DECODE(a.tml_agmt_vol_ut_cd,'W',a.agmt_ut_rt,'0') ton_rate" ).append("\n"); 
		query.append("		, DECODE(a.tml_free_dys_tp_cd" ).append("\n"); 
		query.append("				,'D'" ).append("\n"); 
		query.append("					, '#'|| D2_FD||'#'||D4_FD                                                               								" ).append("\n"); 
		query.append("					||'#'||D5_FD||'#'||D7_FD                                                            								" ).append("\n"); 
		query.append("					||'#'||D8_FD||'#'||D9_FD                                                            								" ).append("\n"); 
		query.append("					||'#'||DW_FD||'#'||DX_FD                                                            								" ).append("\n"); 
		query.append("					||'#'||R2_FD||'#'||R4_FD                                                            								" ).append("\n"); 
		query.append("					||'#'||R5_FD||'#'||R7_FD " ).append("\n"); 
		query.append("					||'#'||R8_FD||'#'||R9_FD                                                           								" ).append("\n"); 
		query.append("					||'#'||F2_FD||'#'||F4_FD                                                            								" ).append("\n"); 
		query.append("					||'#'||F5_FD                                                            											" ).append("\n"); 
		query.append("					||'#'||O2_FD||'#'||O4_FD" ).append("\n"); 
		query.append("              	    ||'#'||O5_FD||'#'||O7_FD                                                            								" ).append("\n"); 
		query.append("					||'#'||S2_FD||'#'||S4_FD                                                            								" ).append("\n"); 
		query.append("					||'#'||T2_FD||'#'||T4_FD                                                            								" ).append("\n"); 
		query.append("					||'#'||A2_FD||'#'||A4_FD||'#'||A5_FD                                                            								" ).append("\n"); 
		query.append("					||'#'||P2_FD||'#'||P4_FD" ).append("\n"); 
		query.append("					||'#'||C2_FD||'#'||C4_FD" ).append("\n"); 
		query.append("				, 'R'										" ).append("\n"); 
		query.append("					, '#'||D2_R||'#'||D4_R                                                               								" ).append("\n"); 
		query.append("					||'#'||D5_R||'#'||D7_R                                                              								" ).append("\n"); 
		query.append("					||'#'||D8_R||'#'||D9_R                                                             									" ).append("\n"); 
		query.append("					||'#'||DW_R||'#'||DX_R                                                             									" ).append("\n"); 
		query.append("					||'#'||R2_R||'#'||R4_R                                                             									" ).append("\n"); 
		query.append("					||'#'||R5_R||'#'||R7_R  " ).append("\n"); 
		query.append("					||'#'||R8_R||'#'||R9_R                                                           									" ).append("\n"); 
		query.append("					||'#'||F2_R||'#'||F4_R                                                             									" ).append("\n"); 
		query.append("					||'#'||F5_R                                                            									" ).append("\n"); 
		query.append("					||'#'||O2_R||'#'||O4_R                                                             									" ).append("\n"); 
		query.append("					||'#'||O5_R||'#'||O7_R" ).append("\n"); 
		query.append("					||'#'||S2_R||'#'||S4_R                                                             									" ).append("\n"); 
		query.append("					||'#'||T2_R||'#'||T4_R                                                             									" ).append("\n"); 
		query.append("					||'#'||A2_R||'#'||A4_R||'#'||A5_R                                                             									" ).append("\n"); 
		query.append("					||'#'||P2_R||'#'||P4_R" ).append("\n"); 
		query.append("					||'#'||C2_R||'#'||C4_R                                                             									" ).append("\n"); 
		query.append("		) TS_RT                                                                                          " ).append("\n"); 
		query.append("		, a.agmt_dtl_rmk remark                                                                    " ).append("\n"); 
		query.append("		, a.agmt_dtl_rmk agmt_dtl_rmk                                                              " ).append("\n"); 
		query.append("		, a.tml_agmt_dtl_seq tml_agmt_dtl_seq                                                                                 " ).append("\n"); 
		query.append("		, (SELECT	com_auto_calc_flg                         																			" ).append("\n"); 
		query.append("				||'|'||tml_thrp_cost_cd_flg     																			" ).append("\n"); 
		query.append("				||'|'||tml_io_bnd_flg           																			" ).append("\n"); 
		query.append("				||'|'||tml_ioc_flg              																			" ).append("\n"); 
		query.append("				||'|'||tml_aply_dt_flg          																			" ).append("\n"); 
		query.append("				||'|'||tml_lane_flg             																			" ).append("\n"); 
		query.append("				||'|'||tml_dcgo_aply_flg        																			" ).append("\n"); 
		query.append("				||'|'||tml_tr_vol_flg           																			" ).append("\n"); 
		query.append("				||'|'||tml_ovt_shft_flg         																			" ).append("\n"); 
		query.append("				||'|'||tml_thc_flg              																			" ).append("\n"); 
		query.append("				||'|'||sto_com_agmt_tp_flg      																			" ).append("\n"); 
		query.append("				||'|'||sto_com_cmnc_tm_flg      																			" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_io_bnd_flg   																			" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_flg          																			" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_dcgo_tm_flg  																			" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_xcld_dt_flg  																			" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_dcgo_rt_flg             																			" ).append("\n"); 
		query.append("				||'|'||sto_free_dy_tr_dy_flg               																			" ).append("\n"); 
		query.append("				||'|'||sto_fp_calc_prd_flg                 																			" ).append("\n"); 
		query.append("				||'|'||sto_fp_teu_flg                      																			" ).append("\n"); 
		query.append("				||'|'||rt_cntr_tpsz_flg                    																			" ).append("\n"); 
		query.append("				||'|'||rt_teu_flg                          																			" ).append("\n"); 
		query.append("				||'|'||rt_bx_flg                           																			" ).append("\n"); 
		query.append("				||'|'||rt_mv_flg                           																			" ).append("\n"); 
		query.append("				||'|'||free_dy_cntr_tpsz_flg  vrfy_string  																			" ).append("\n"); 
		query.append("		FROM TES_TML_AGMT_VRFY_MZD                        																			" ).append("\n"); 
		query.append("		WHERE lgs_cost_cd = a.lgs_cost_cd ) vrfyFlg																					" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_DTL A, TES_TML_AGMT_APLY_DY B, TES_TML_AGMT_DG_CGO_CLSS C, 		                                " ).append("\n"); 
		query.append("       	(SELECT	TML_AGMT_OFC_CTY_CD,TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_AGMT_DTL_SEQ, CNTR_APLY_TP_CD                                " ).append("\n"); 
		query.append("			    , MAX(D2_FD) D2_FD, MAX(D4_FD) D4_FD, MAX(D5_FD) D5_FD ,MAX(D7_FD) D7_FD ,MAX(D8_FD) D8_FD,MAX(D9_FD) D9_FD, MAX(DW_FD) DW_FD, MAX(DX_FD) DX_FD  " ).append("\n"); 
		query.append("			    , MAX(R2_FD) R2_FD, MAX(R4_FD) R4_FD, MAX(R5_FD) R5_FD ,MAX(R7_FD) R7_FD ,MAX(R8_FD) R8_FD,MAX(R9_FD) R9_FD                                           " ).append("\n"); 
		query.append("			    , MAX(F2_FD) F2_FD, MAX(F4_FD) F4_FD                                                                                 " ).append("\n"); 
		query.append("			    , MAX(O2_FD) O2_FD, MAX(O4_FD) O4_FD, MAX(O5_FD) O5_FD, MAX(O7_FD) O7_FD                                                                                 " ).append("\n"); 
		query.append("			    , MAX(S2_FD) S2_FD, MAX(S4_FD) S4_FD                                                                                 " ).append("\n"); 
		query.append("			    , MAX(T2_FD) T2_FD, MAX(T4_FD) T4_FD                                                                                 " ).append("\n"); 
		query.append("			    , MAX(A2_FD) A2_FD, MAX(A4_FD) A4_FD, MAX(A5_FD) A5_FD                                                                                 " ).append("\n"); 
		query.append("			    , MAX(P2_FD) P2_FD, MAX(P4_FD) P4_FD" ).append("\n"); 
		query.append("				, MAX(C2_FD) C2_FD, MAX(C4_FD) C4_FD                                                                                 " ).append("\n"); 
		query.append("			    , MAX(F5_FD) F5_FD																									" ).append("\n"); 
		query.append("			    , MAX(D2_R) D2_R ,MAX(D4_R) D4_R ,MAX(D5_R) D5_R ,MAX(D7_R) D7_R ,MAX(D8_R) D8_R ,MAX(D9_R) D9_R , MAX(DW_R) DW_R , MAX(DX_R) DX_R " ).append("\n"); 
		query.append("			    , MAX(R2_R) R2_R ,MAX(R4_R) R4_R ,MAX(R5_R) R5_R ,MAX(R7_R) R7_R ,MAX(R8_R) R8_R ,MAX(R9_R) R9_R                                                    " ).append("\n"); 
		query.append("			    , MAX(F2_R) F2_R ,MAX(F4_R) F4_R                                                                                     " ).append("\n"); 
		query.append("			    , MAX(O2_R) O2_R ,MAX(O4_R) O4_R ,MAX(O5_R) O5_R, MAX(O7_R) O7_R                                                                                     " ).append("\n"); 
		query.append("			    , MAX(S2_R) S2_R ,MAX(S4_R) S4_R                                                                                     " ).append("\n"); 
		query.append("			    , MAX(T2_R) T2_R ,MAX(T4_R) T4_R                                                                                     " ).append("\n"); 
		query.append("			    , MAX(A2_R) A2_R ,MAX(A4_R) A4_R ,MAX(A5_R) A5_R                                                                                     " ).append("\n"); 
		query.append("			    , MAX(P2_R) P2_R ,MAX(P4_R) P4_R " ).append("\n"); 
		query.append("				, MAX(C2_R) C2_R ,MAX(C4_R) C4_R                                                                                     " ).append("\n"); 
		query.append("			    , MAX(F5_R) F5_R 																									" ).append("\n"); 
		query.append("		FROM	(SELECT A.TML_AGMT_OFC_CTY_CD, A.TML_AGMT_SEQ, A.TML_AGMT_VER_NO, A.TML_AGMT_DTL_SEQ, B.CNTR_APLY_TP_CD,     " ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'D2',AGMT_DYS,0), 0)  D2_FD,    					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'D4',AGMT_DYS,0), 0)  D4_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'D5',AGMT_DYS,0), 0)  D5_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'D7',AGMT_DYS,0), 0)  D7_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'D8',AGMT_DYS,0), 0)  D8_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'D9',AGMT_DYS,0), 0)  D9_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'DW',AGMT_DYS,0), 0)  DW_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'DX',AGMT_DYS,0), 0)  DX_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'R2',AGMT_DYS,0), 0)  R2_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'R4',AGMT_DYS,0), 0)  R4_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'R5',AGMT_DYS,0), 0)  R5_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'R7',AGMT_DYS,0), 0)  R7_FD, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'R8',AGMT_DYS,0), 0)  R8_FD," ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'R9',AGMT_DYS,0), 0)  R9_FD,    					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'F2',AGMT_DYS,0), 0)  F2_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'F4',AGMT_DYS,0), 0)  F4_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'O2',AGMT_DYS,0), 0)  O2_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'O4',AGMT_DYS,0), 0)  O4_FD, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'O5',AGMT_DYS,0), 0)  O5_FD," ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'O7',AGMT_DYS,0), 0)  O7_FD,    					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'S2',AGMT_DYS,0), 0)  S2_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'SG',AGMT_DYS,0), 0)  S4_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'T2',AGMT_DYS,0), 0)  T2_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'T4',AGMT_DYS,0), 0)  T4_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'A2',AGMT_DYS,0), 0)  A2_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'A4',AGMT_DYS,0), 0)  A4_FD, " ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'A5',AGMT_DYS,0), 0)  A5_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'P2',AGMT_DYS,0), 0)  P2_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'P4',AGMT_DYS,0), 0)  P4_FD,  " ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'C2',AGMT_DYS,0), 0)  C2_FD,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'C4',AGMT_DYS,0), 0)  C4_FD,   					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'D', DECODE(B.CNTR_TPSZ_CD,'F5',AGMT_DYS,0), 0)  F5_FD,      					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'D2',AGMT_RT,0), 0)  D2_R,    						" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'D4',AGMT_RT,0), 0)  D4_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'D5',AGMT_RT,0), 0)  D5_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'D7',AGMT_RT,0), 0)  D7_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'D8',AGMT_RT,0), 0)  D8_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'D9',AGMT_RT,0), 0)  D9_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'DW',AGMT_RT,0), 0)  DW_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'DX',AGMT_RT,0), 0)  DX_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'R2',AGMT_RT,0), 0)  R2_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'R4',AGMT_RT,0), 0)  R4_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'R5',AGMT_RT,0), 0)  R5_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'R7',AGMT_RT,0), 0)  R7_R," ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'R8',AGMT_RT,0), 0)  R8_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'R9',AGMT_RT,0), 0)  R9_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'F2',AGMT_RT,0), 0)  F2_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'F4',AGMT_RT,0), 0)  F4_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'O2',AGMT_RT,0), 0)  O2_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'O4',AGMT_RT,0), 0)  O4_R,     					" ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'O5',AGMT_RT,0), 0)  O5_R," ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'O7',AGMT_RT,0), 0)  O7_R," ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'S2',AGMT_RT,0), 0)  S2_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'S4',AGMT_RT,0), 0)  S4_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'T2',AGMT_RT,0), 0)  T2_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'T4',AGMT_RT,0), 0)  T4_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'A2',AGMT_RT,0), 0)  A2_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'A4',AGMT_RT,0), 0)  A4_R,   " ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'A5',AGMT_RT,0), 0)  A5_R,   					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'P2',AGMT_RT,0), 0)  P2_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'P4',AGMT_RT,0), 0)  P4_R,  " ).append("\n"); 
		query.append("						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'C2',AGMT_RT,0), 0)  C2_R,     					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'C4',AGMT_RT,0), 0)  C4_R,   					" ).append("\n"); 
		query.append(" 						DECODE(B.CNTR_APLY_TP_CD, 'R', DECODE(B.CNTR_TPSZ_CD,'F5',AGMT_RT,0), 0)  F5_R      					" ).append("\n"); 
		query.append("       	        FROM	TES_TML_AGMT_DTL A, TES_TML_AGMT_TP_SZ B                                                            	" ).append("\n"); 
		query.append("       	        WHERE	A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD                                                         " ).append("\n"); 
		query.append("       	        AND		A.TML_AGMT_SEQ = B.TML_AGMT_SEQ                                                                       " ).append("\n"); 
		query.append("       	        AND		A.TML_AGMT_VER_NO = B.TML_AGMT_VER_NO                                                                 " ).append("\n"); 
		query.append("       	        AND		A.TML_AGMT_DTL_SEQ = B.TML_AGMT_DTL_SEQ )                                                             " ).append("\n"); 
		query.append("       	GROUP BY TML_AGMT_OFC_CTY_CD,TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_AGMT_DTL_SEQ, CNTR_APLY_TP_CD) D                    " ).append("\n"); 
		query.append("WHERE	A.TML_AGMT_OFC_CTY_CD	= @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ			= @[tml_agmt_seq]" ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO		= @[tml_agmt_ver_no] " ).append("\n"); 
		query.append("AND		A.TML_AGMT_TP_CD = 'S' " ).append("\n"); 
		query.append("AND		A.TMP_SAV_FLG IS NULL " ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD(+)                                                                " ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD = C.TML_AGMT_OFC_CTY_CD(+)                                                                " ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD(+)                                                                " ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ = B.TML_AGMT_SEQ(+)                                                                              " ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ = C.TML_AGMT_SEQ(+)                                                                              " ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ = D.TML_AGMT_SEQ(+)                                                                              " ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO = B.TML_AGMT_VER_NO(+)                                                                        " ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO = C.TML_AGMT_VER_NO(+)                                                                        " ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO = D.TML_AGMT_VER_NO(+)                                                                        " ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ = B.TML_AGMT_DTL_SEQ(+)                                                                      " ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ = C.TML_AGMT_DTL_SEQ(+)                                                                      " ).append("\n"); 
		query.append("AND A.TML_AGMT_DTL_SEQ = D.TML_AGMT_DTL_SEQ(+)                                                                      " ).append("\n"); 
		query.append("ORDER BY A.TML_AGMT_DTL_SEQ" ).append("\n"); 

	}
}