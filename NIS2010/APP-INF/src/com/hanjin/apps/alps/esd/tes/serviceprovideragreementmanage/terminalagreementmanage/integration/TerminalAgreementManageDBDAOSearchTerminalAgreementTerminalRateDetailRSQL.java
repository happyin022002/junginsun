/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementTerminalRateDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.11 
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

public class TerminalAgreementManageDBDAOSearchTerminalAgreementTerminalRateDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Agreement Rate List Detail Inquiry
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchTerminalAgreementTerminalRateDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : TerminalAgreementManageDBDAOSearchTerminalAgreementTerminalRateDetailRSQL").append("\n"); 
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
		query.append("SELECT	A.lgs_cost_cd,                                                                   " ).append("\n"); 
		query.append("		A.auto_calc_flg,                                                                 " ).append("\n"); 
		query.append("		A.tml_agmt_vol_ut_cd,                                                            " ).append("\n"); 
		query.append("		A.curr_cd,                                                                       " ).append("\n"); 
		query.append("		A.thrp_cost_cd_flg,                                                              " ).append("\n"); 
		query.append("		A.io_bnd_cd,                                                                     " ).append("\n"); 
		query.append("		A.ioc_cd,                                                                        " ).append("\n"); 
		query.append("		DECODE(B.tml_rt_dy_aply_tp_cd,'A',DECODE(B.wkdy_flg,'Y','Y',''),'') wkdy_flg,    " ).append("\n"); 
		query.append("		DECODE(B.tml_rt_dy_aply_tp_cd,'A',DECODE(B.sat_flg,'Y','Y',''),'') sat_flg,      " ).append("\n"); 
		query.append("		DECODE(B.tml_rt_dy_aply_tp_cd,'A',DECODE(B.sun_flg,'Y','Y',''),'') sun_flg,      " ).append("\n"); 
		query.append("		DECODE(B.tml_rt_dy_aply_tp_cd,'A',DECODE(B.hol_flg,'Y','Y',''),'') hol_flg,      " ).append("\n"); 
		query.append("		A.lane_cd,                                                                       " ).append("\n"); 
		query.append("		DECODE(A.dcgo_aply_tp_cd,'N','Y','') dg_none,                                    " ).append("\n"); 
		query.append("		DECODE(A.dcgo_aply_tp_cd,'A',DECODE(C.dcgo_non_clss_flg,'Y','Y',''),'') dg_sm_no," ).append("\n"); 
		query.append("		DECODE(A.dcgo_aply_tp_cd,'A',DECODE(C.dcgo_sam_clss_flg,'Y','Y',''),'') dg_sm_dg," ).append("\n"); 
		query.append("		DECODE(A.dcgo_aply_tp_cd,'S','Y','') dg_sep,                                     " ).append("\n"); 
		query.append("		C.dcgo_non_clss_flg,                                                             " ).append("\n"); 
		query.append("		C.dcgo_n1st_clss_flg,                                                            " ).append("\n"); 
		query.append("		C.dcgo_n2nd_clss_flg,                                                            " ).append("\n"); 
		query.append("		C.dcgo_n3rd_clss_flg,                                                            " ).append("\n"); 
		query.append("		C.dcgo_n4th_clss_flg,                                                            " ).append("\n"); 
		query.append("		C.dcgo_n5th_clss_flg,                                                            " ).append("\n"); 
		query.append("		C.dcgo_n6th_clss_flg,                                                            " ).append("\n"); 
		query.append("		C.dcgo_n7th_clss_flg,                                                            " ).append("\n"); 
		query.append("		C.dcgo_n8th_clss_flg,                                                            " ).append("\n"); 
		query.append("		C.dcgo_n9th_clss_flg,                                                            " ).append("\n"); 
		query.append("		A.fm_tr_vol_val,                                                                 " ).append("\n"); 
		query.append("		DECODE(A.to_tr_vol_val,9999999,'MAX',A.to_tr_vol_val) to_tr_vol_val,               " ).append("\n"); 
		query.append("		A.tml_ovt_shft_cd,                                                               " ).append("\n"); 
		query.append("		A.thc_tp_cd,                                                                     " ).append("\n"); 
		query.append("		D.D2, D.D4, D.D5, D.D7, D.D8, D.D9, D.DW, D.DX, D.R2,                            " ).append("\n"); 
		query.append("		D.R4, D.R5, D.R7, D.R8, D.R9, D.F2, D.F4, D.O2, D.O4, " ).append("\n"); 
		query.append("		D.O5, D.S2, D.S4, D.T2, D.T4, D.A2, D.A4, D.A5, D.P2, D.P4, " ).append("\n"); 
		query.append("		D.C2, D.C4, D.F5, 		                                        " ).append("\n"); 
		query.append("		DECODE(A.tml_agmt_vol_ut_cd,'T',A.agmt_ut_rt,'0'),                                " ).append("\n"); 
		query.append("		DECODE(A.tml_agmt_vol_ut_cd,'B',A.agmt_ut_rt,'0'),                                " ).append("\n"); 
		query.append("		DECODE(A.tml_agmt_vol_ut_cd,'M',A.agmt_ut_rt,'0'),                                " ).append("\n"); 
		query.append("		A.tml_agmt_dtl_seq,                                                               " ).append("\n"); 
		query.append("		A.agmt_dtl_rmk  				                                                     " ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_DTL A, TES_TML_AGMT_APLY_DY B, TES_TML_AGMT_DG_CGO_CLSS C,            " ).append("\n"); 
		query.append("		(SELECT                                                                          " ).append("\n"); 
		query.append("				TML_AGMT_OFC_CTY_CD,TML_AGMT_SEQ, TML_AGMT_VER_NO, TML_AGMT_DTL_SEQ              " ).append("\n"); 
		query.append("				,MAX(D2) D2, MAX(D4) D4, MAX(D5) D5, MAX(D7) D7, MAX(D8) D8, MAX(D9) D9          " ).append("\n"); 
		query.append("				,MAX(DW) DW, MAX(DX) DX, MAX(R2) R2, MAX(R4) R4, MAX(R5) R5, MAX(R7) R7          " ).append("\n"); 
		query.append("				,MAX(R8) R8, MAX(R9) R9, MAX(F2) F2, MAX(F4) F4 ,MAX(O2) O2, MAX(O4) O4 " ).append("\n"); 
		query.append("				,MAX(O5) O5, MAX(S2) S2, MAX(S4) S4, MAX(T2) T2, MAX(T4) T4, MAX(A2) A2 " ).append("\n"); 
		query.append("				,MAX(A4) A4, MAX(A5) A5, MAX(P2) P2, MAX(P4) P4, MAX(C2) C2, MAX(C4) C4, MAX(F5) F5				                                                                      " ).append("\n"); 
		query.append("		FROM(SELECT	A.TML_AGMT_OFC_CTY_CD, A.TML_AGMT_SEQ,                               " ).append("\n"); 
		query.append("					A.TML_AGMT_VER_NO, A.TML_AGMT_DTL_SEQ,                                " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'D2',AGMT_RT,0) D2,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'D4',AGMT_RT,0) D4,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'D5',AGMT_RT,0) D5,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'D7',AGMT_RT,0) D7,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'D8',AGMT_RT,0) D8,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'D9',AGMT_RT,0) D9,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'DW',AGMT_RT,0) DW,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'DX',AGMT_RT,0) DX,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'R2',AGMT_RT,0) R2,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'R4',AGMT_RT,0) R4,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'R5',AGMT_RT,0) R5,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'R7',AGMT_RT,0) R7, " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'R8',AGMT_RT,0) R8,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'R9',AGMT_RT,0) R9,                            " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'F2',AGMT_RT,0) F2,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'F4',AGMT_RT,0) F4,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'O2',AGMT_RT,0) O2,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'O4',AGMT_RT,0) O4, " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'O5',AGMT_RT,0) O5,                            " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'S2',AGMT_RT,0) S2,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'S4',AGMT_RT,0) S4,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'T2',AGMT_RT,0) T2,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'T4',AGMT_RT,0) T4,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'A2',AGMT_RT,0) A2,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'A4',AGMT_RT,0) A4,   " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'A5',AGMT_RT,0) A5,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'P2',AGMT_RT,0) P2,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'P4',AGMT_RT,0) P4, " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'C2',AGMT_RT,0) C2,                             " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'C4',AGMT_RT,0) C4,                            " ).append("\n"); 
		query.append("					DECODE(B.CNTR_TPSZ_CD,'F5',AGMT_RT,0) F5                              " ).append("\n"); 
		query.append("	        FROM	TES_TML_AGMT_DTL A, TES_TML_AGMT_TP_SZ B                              " ).append("\n"); 
		query.append("	        WHERE	A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD                          " ).append("\n"); 
		query.append("	        AND		A.TML_AGMT_SEQ		= B.TML_AGMT_SEQ                                        " ).append("\n"); 
		query.append("	        AND		A.TML_AGMT_VER_NO	= B.TML_AGMT_VER_NO                                  " ).append("\n"); 
		query.append("	        AND		A.TML_AGMT_DTL_SEQ	= B.TML_AGMT_DTL_SEQ )                              " ).append("\n"); 
		query.append("		GROUP BY TML_AGMT_OFC_CTY_CD,TML_AGMT_SEQ,                                       " ).append("\n"); 
		query.append("		         TML_AGMT_VER_NO, TML_AGMT_DTL_SEQ) D  				                     " ).append("\n"); 
		query.append("WHERE	A.TML_AGMT_OFC_CTY_CD	= SUBSTR(@[tml_agmt_ofc_cty_cd],1,3)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ			= SUBSTR(@[tml_agmt_ofc_cty_cd],4,8)" ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO		= @[tml_agmt_ver_no]                                                             " ).append("\n"); 
		query.append("AND		A.TML_AGMT_TP_CD	= 'T'                                                            " ).append("\n"); 
		query.append("AND		A.TMP_SAV_FLG IS NULL                                                         	 " ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD	= B.TML_AGMT_OFC_CTY_CD(+)                                  " ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD	= C.TML_AGMT_OFC_CTY_CD(+)                                  " ).append("\n"); 
		query.append("AND		A.TML_AGMT_OFC_CTY_CD	= D.TML_AGMT_OFC_CTY_CD(+)                                  " ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ			= B.TML_AGMT_SEQ (+)                                               " ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ			= C.TML_AGMT_SEQ(+)                                                " ).append("\n"); 
		query.append("AND		A.TML_AGMT_SEQ			= D.TML_AGMT_SEQ(+)                                                " ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO		= B.TML_AGMT_VER_NO(+)                                          " ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO		= C.TML_AGMT_VER_NO(+)                                          " ).append("\n"); 
		query.append("AND		A.TML_AGMT_VER_NO		= D.TML_AGMT_VER_NO(+)                                          " ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ		= B.TML_AGMT_DTL_SEQ(+)                                        " ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ		= C.TML_AGMT_DTL_SEQ(+)                                        " ).append("\n"); 
		query.append("AND		A.TML_AGMT_DTL_SEQ		= D.TML_AGMT_DTL_SEQ(+)                                        " ).append("\n"); 
		query.append("ORDER BY A.TML_AGMT_DTL_SEQ" ).append("\n"); 

	}
}