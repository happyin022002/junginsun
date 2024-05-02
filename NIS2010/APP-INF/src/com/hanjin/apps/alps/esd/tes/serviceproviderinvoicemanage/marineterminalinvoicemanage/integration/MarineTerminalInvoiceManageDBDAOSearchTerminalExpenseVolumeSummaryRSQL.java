/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseVolumeSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseVolumeSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalExpenseVolumeSummary
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseVolumeSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseVolumeSummaryRSQL").append("\n"); 
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
		query.append("SELECT	HQ_OFC_CD," ).append("\n"); 
		query.append("		RHQ_OFC_CD," ).append("\n"); 
		query.append("		INV_OFC_CD," ).append("\n"); 
		query.append("		COST_OFC_CD," ).append("\n"); 
		query.append("		YD_CD," ).append("\n"); 
		query.append("		VNDR_SEQ," ).append("\n"); 
		query.append("		VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("		INV_NO," ).append("\n"); 
		query.append("		ISS_DT," ).append("\n"); 
		query.append("		LOCL_UPD_DT," ).append("\n"); 
		query.append("		VVD," ).append("\n"); 
		query.append("		LANE_CD," ).append("\n"); 
		query.append("		ATB_DT," ).append("\n"); 
		query.append("		CURR_CD," ).append("\n"); 
		query.append("		LGS_COST_CD," ).append("\n"); 
		query.append("		LGS_COST_ABBR_NM," ).append("\n"); 
		query.append("		VOL_TR_UT_CD," ).append("\n"); 
		query.append("		VOL_D2, VOL_D4, VOL_D5, VOL_D7, VOL_D8, VOL_D9, VOL_DW, VOL_DX," ).append("\n"); 
		query.append("		VOL_R2, VOL_R4, VOL_R5, VOL_R7, VOL_R8, VOL_R9, " ).append("\n"); 
		query.append("		VOL_F2, VOL_F4, VOL_F5," ).append("\n"); 
		query.append("		VOL_O2, VOL_O4, VOL_O5, VOL_O7," ).append("\n"); 
		query.append("		VOL_S2, VOL_S4, " ).append("\n"); 
		query.append("		VOL_T2, VOL_T4, " ).append("\n"); 
		query.append("		VOL_A2, VOL_A4, VOL_A5," ).append("\n"); 
		query.append("		VOL_P2, VOL_P4, " ).append("\n"); 
		query.append("		VOL_C2, VOL_C4, " ).append("\n"); 
		query.append("		VOL_DAY, VOL_MOVE, OVER_DAYS, VOL_GH, VOL_BOX, VOL_TEU, VOL_TON," ).append("\n"); 
		query.append("		TTL_20," ).append("\n"); 
		query.append("		TTL_40," ).append("\n"); 
		query.append("		TTL_BOX," ).append("\n"); 
		query.append("		TTL_TEU," ).append("\n"); 
		query.append("		INV_AMT," ).append("\n"); 
		query.append("		USD_AMT," ).append("\n"); 
		query.append("		TML_INV_STS_CD," ).append("\n"); 
		query.append("		TML_INV_STS_CD_DESC," ).append("\n"); 
		query.append("		AUTO_CALC_AMT," ).append("\n"); 
		query.append("		SEMI_AUTO_AMT," ).append("\n"); 
		query.append("		MANUAL_AMT" ).append("\n"); 
		query.append("FROM	( " ).append("\n"); 
		query.append("		SELECT	A.HQ_OFC_CD," ).append("\n"); 
		query.append("				A.RHQ_OFC_CD," ).append("\n"); 
		query.append("				A.INV_OFC_CD," ).append("\n"); 
		query.append("				A.COST_OFC_CD," ).append("\n"); 
		query.append("				A.YD_CD,   " ).append("\n"); 
		query.append("				A.VNDR_SEQ," ).append("\n"); 
		query.append("				A.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("				A.INV_NO,  " ).append("\n"); 
		query.append("				A.ISS_DT,  " ).append("\n"); 
		query.append("				A.LOCL_UPD_DT,    " ).append("\n"); 
		query.append("				A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("				A.LANE_CD," ).append("\n"); 
		query.append("				A.ATB_DT,  " ).append("\n"); 
		query.append("				A.CURR_CD, " ).append("\n"); 
		query.append("				A.LGS_COST_CD," ).append("\n"); 
		query.append("				A.LGS_COST_ABBR_NM," ).append("\n"); 
		query.append("				A.VOL_TR_UT_CD," ).append("\n"); 
		query.append("				A.VOL_D2, A.VOL_D4, A.VOL_D5, A.VOL_D7, A.VOL_D8, A.VOL_D9, A.VOL_DW, A.VOL_DX," ).append("\n"); 
		query.append("				A.VOL_R2, A.VOL_R4, A.VOL_R5, A.VOL_R7, A.VOL_R8, A.VOL_R9, A.VOL_F2, A.VOL_F4, A.VOL_F5," ).append("\n"); 
		query.append("				A.VOL_O2, A.VOL_O4, A.VOL_O5, A.VOL_O7," ).append("\n"); 
		query.append("				A.VOL_S2, A.VOL_S4, A.VOL_T2, A.VOL_T4, A.VOL_A2, A.VOL_A4, A.VOL_A5," ).append("\n"); 
		query.append("				A.VOL_P2, A.VOL_P4, A.VOL_C2, A.VOL_C4, A.VOL_DAY, A.VOL_MOVE, A.OVER_DAYS, A.VOL_GH, A.VOL_BOX, A.VOL_TEU, A.VOL_TON," ).append("\n"); 
		query.append("				A.VOL_D2+A.VOL_R2+A.VOL_F2+A.VOL_O2+A.VOL_S2+A.VOL_T2+A.VOL_A2+A.VOL_P2+A.VOL_C2 TTL_20," ).append("\n"); 
		query.append("				A.VOL_D4+A.VOL_R4+A.VOL_F4+A.VOL_O4+A.VOL_O5+A.VOL_S4+A.VOL_T4+A.VOL_A4+A.VOL_P4+A.VOL_D5+A.VOL_A5" ).append("\n"); 
		query.append("				+A.VOL_D7+A.VOL_D8+A.VOL_D9+A.VOL_DW+A.VOL_DX+A.VOL_O7+A.VOL_R5+A.VOL_R7+A.VOL_R8+A.VOL_R9+A.VOL_F5+A.VOL_C4 TTL_40," ).append("\n"); 
		query.append("				A.VOL_D2+A.VOL_D4+A.VOL_D5+A.VOL_D7+A.VOL_D8+A.VOL_D9+A.VOL_DW+A.VOL_DX+A.VOL_R2" ).append("\n"); 
		query.append("				+A.VOL_R4+A.VOL_R5+A.VOL_R7+A.VOL_R8+A.VOL_R9+A.VOL_F2+A.VOL_F4+A.VOL_F5+A.VOL_O2+A.VOL_O4+A.VOL_O5+A.VOL_O7+A.VOL_S2" ).append("\n"); 
		query.append("				+A.VOL_S4+A.VOL_T2+A.VOL_T4+A.VOL_A2+A.VOL_A4+A.VOL_A5+A.VOL_P2+A.VOL_P4+A.VOL_C2+A.VOL_C4 TTL_BOX," ).append("\n"); 
		query.append("				A.VOL_D2+A.VOL_D4*2+A.VOL_D5*2+A.VOL_D7*2.25+A.VOL_D8*2.4+A.VOL_D9*2.4+A.VOL_DW*2.65" ).append("\n"); 
		query.append("				+A.VOL_DX*2.65+A.VOL_R2+A.VOL_R4*2+A.VOL_R5*2+A.VOL_R7*2.25+A.VOL_R8*2.4+A.VOL_R9*2.4+A.VOL_F2+A.VOL_F4*2" ).append("\n"); 
		query.append("				+A.VOL_F5*2+A.VOL_O2+A.VOL_O4*2+A.VOL_O5*2+A.VOL_O7*2.25+A.VOL_S2+A.VOL_S4*2+A.VOL_T2+A.VOL_T4*2+A.VOL_A2" ).append("\n"); 
		query.append("				+A.VOL_A4*2+A.VOL_A5*2+A.VOL_P2+A.VOL_P4*2+A.VOL_C2+A.VOL_C4*2 TTL_TEU," ).append("\n"); 
		query.append("				A.INV_AMT, " ).append("\n"); 
		query.append("				NVL(ROUND(A.INV_AMT/G.USD_LOCL_XCH_RT,2),0) USD_AMT," ).append("\n"); 
		query.append("				DECODE(A.TML_INV_STS_CD,'R','RC','C','CF','A','AR','P','AP','D','PD') TML_INV_STS_CD," ).append("\n"); 
		query.append("				NVL(( SELECT D.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("				      FROM COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("			          WHERE D.INTG_CD_ID = 'CD00172' AND D.INTG_CD_VAL_CTNT = A.TML_INV_STS_CD AND ROWNUM = 1),'') TML_INV_STS_CD_DESC," ).append("\n"); 
		query.append("				A.AUTO_CALC_AMT," ).append("\n"); 
		query.append("				A.SEMI_AUTO_AMT," ).append("\n"); 
		query.append("				A.MANUAL_AMT," ).append("\n"); 
		query.append("				NO" ).append("\n"); 
		query.append("		FROM(   SELECT  'SELHQ' HQ_OFC_CD,          " ).append("\n"); 
		query.append("						-- 2015-08-03 그룹사 조직 코드 변경 (HAMUR->HAMRU,NYCNA->NYCRA)                                                                                                                                       " ).append("\n"); 
		query.append("		                DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, 'DARBA', O.AR_HD_QTR_OFC_CD, 'MBABA', O.AR_HD_QTR_OFC_CD, 'AISBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMRU', 'E', 'HAMRU', 'M', 'NYCRA', 'A', O.AR_HD_QTR_OFC_CD)) RHQ_OFC_CD,                                                                      " ).append("\n"); 
		query.append("		                H.INV_OFC_CD,                                                                                                                                                      " ).append("\n"); 
		query.append("		                H.COST_OFC_CD,                                                                                                                                                     " ).append("\n"); 
		query.append("		                H.YD_CD,                                                                                                                                                           " ).append("\n"); 
		query.append("		                LPAD(H.VNDR_SEQ, 6, '0') VNDR_SEQ,                                                                                                                                 " ).append("\n"); 
		query.append("		                DECODE(V.VNDR_CNT_CD,'KR',V.VNDR_LOCL_LANG_NM,V.VNDR_LGL_ENG_NM) VNDR_LGL_ENG_NM,                                                                                  " ).append("\n"); 
		query.append("		                H.INV_NO,                                                                                                                                                          " ).append("\n"); 
		query.append("		                TO_CHAR(H.ISS_DT, 'YYYYMMDD') ISS_DT,    " ).append("\n"); 
		query.append("	                    TO_CHAR(H.LOCL_UPD_DT, 'YYYYMMDD') LOCL_UPD_DT,                                                                                                                            " ).append("\n"); 
		query.append("		                D.VSL_CD,                                                                                                                                                        	" ).append("\n"); 
		query.append("		                D.SKD_VOY_NO,                                                                                                                                                      " ).append("\n"); 
		query.append("		                D.SKD_DIR_CD, " ).append("\n"); 
		query.append("	                    D.LANE_CD,                                                                                                                   " ).append("\n"); 
		query.append("		                TO_CHAR(D.ATB_DT,'yyyymmdd') ATB_DT,                                                                                                                              " ).append("\n"); 
		query.append("		                H.CURR_CD,                                                                                                                                                         " ).append("\n"); 
		query.append("		                D.LGS_COST_CD,                                                                                                                                                     " ).append("\n"); 
		query.append("		                LC.LGS_COST_ABBR_NM,                                                                                                                                               " ).append("\n"); 
		query.append("		                D.VOL_TR_UT_CD,                                                                                                                                " ).append("\n"); 
		query.append("		                SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'D2', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'D2', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_D2," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'D4', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'D4', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_D4," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'D5', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'D5', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_D5," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'D7', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'D7', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_D7," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'D8', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'D8', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_D8," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'D9', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'D9', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_D9," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'DW', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'DW', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_DW," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'DX', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'DX', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_DX," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'R2', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'R2', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_R2," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'R4', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'R4', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_R4," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'R5', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'R5', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_R5," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'R7', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'R7', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_R7," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'R8', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'R8', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_R8," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'R9', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'R9', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_R9," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'F2', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'F2', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_F2," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'F4', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'F4', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_F4," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'F5', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'F5', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_F5," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'O2', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'O2', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_O2," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'O4', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'O4', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_O4," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'O5', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'O5', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_O5," ).append("\n"); 
		query.append("						SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'O7', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'O7', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_O7," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'S2', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'S2', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_S2," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'S4', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'S4', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_S4," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'T2', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'T2', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_T2," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'T4', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'T4', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_T4," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'A2', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'A2', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_A2," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'A4', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'A4', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_A4," ).append("\n"); 
		query.append("						SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'A5', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'A5', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_A5," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'P2', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'P2', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_P2," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'P4', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'P4', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_P4," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'C2', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'C2', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_C2," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(CNTR_TPSZ_CD, 'C4', 1, 0) , DECODE(D.CNTR_TPSZ_CD, 'C4', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0))) VOL_C4," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0, OVR_DYS, 0), 0)) VOL_DAY," ).append("\n"); 
		query.append("						SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', NVL(OVR_DYS, 0),0)) OVER_DAYS," ).append("\n"); 
		query.append("						-- CHM-201431720 TES Semi-Updated된 Invoice의 Vol정보 반영(ExpenseVolume Summary) (YYS B : 4347-09-16)" ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(D.VOL_TR_UT_CD, 'M', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0) , DECODE(D.VOL_TR_UT_CD, 'M', DECODE(NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0, D.CALC_VOL_QTY, D.RVIS_VOL_QTY), 0))) VOL_MOVE," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(D.VOL_TR_UT_CD, 'G', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0) , DECODE(D.VOL_TR_UT_CD, 'G', DECODE(NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0, D.CALC_VOL_QTY, D.RVIS_VOL_QTY), 0))) VOL_GH," ).append("\n"); 
		query.append("						--// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)" ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(D.VOL_TR_UT_CD, 'B', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0) , DECODE(D.VOL_TR_UT_CD, 'B', DECODE(NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0, D.CALC_VOL_QTY, D.RVIS_VOL_QTY), 0))) VOL_BOX," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(D.VOL_TR_UT_CD, 'T', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0) , DECODE(D.VOL_TR_UT_CD, 'T', DECODE(NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0, D.CALC_VOL_QTY, D.RVIS_VOL_QTY), 0))) VOL_TEU," ).append("\n"); 
		query.append("	      				SUM(DECODE(LC.LGS_COST_SUBJ_CD, 'SR', DECODE(D.VOL_TR_UT_CD, 'W', NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0) , DECODE(D.VOL_TR_UT_CD, 'W', DECODE(NVL(NVL(D.RVIS_VOL_QTY, D.CALC_VOL_QTY), 0), 0, D.CALC_VOL_QTY, D.RVIS_VOL_QTY), 0))) VOL_TON," ).append("\n"); 
		query.append("						SUM(D.INV_AMT) INV_AMT," ).append("\n"); 
		query.append("	                    H.TML_INV_STS_CD," ).append("\n"); 
		query.append("	                    SUM(D.AUTO_CALC_AMT) AUTO_CALC_AMT," ).append("\n"); 
		query.append("	                    SUM(D.SEMI_AUTO_AMT) SEMI_AUTO_AMT," ).append("\n"); 
		query.append("	                    SUM(D.MANUAL_AMT) MANUAL_AMT" ).append("\n"); 
		query.append("	                    , ROW_NUMBER() OVER (ORDER BY H.INV_OFC_CD, H.COST_OFC_CD, H.YD_CD, H.VNDR_SEQ, D.LGS_COST_CD ) AS NO" ).append("\n"); 
		query.append("		        FROM TES_TML_SO_HDR H, TES_LGS_COST LC, TES_TML_SO_COST SC, MDM_ORGANIZATION O, MDM_LOCATION L, MDM_VENDOR V," ).append("\n"); 
		query.append("	            (SELECT DTL.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("	              DTL.TML_SO_SEQ," ).append("\n"); 
		query.append("	              DTL.LGS_COST_CD," ).append("\n"); 
		query.append("	              DTL.cntr_no," ).append("\n"); 
		query.append("	              DTL.VSL_CD," ).append("\n"); 
		query.append("	              DTL.SKD_VOY_NO," ).append("\n"); 
		query.append("	              DTL.SKD_DIR_CD," ).append("\n"); 
		query.append("	              DTL.LANE_CD," ).append("\n"); 
		query.append("	              SUM(DTL.OVR_DYS) OVR_DYS," ).append("\n"); 
		query.append("	              DTL.ATB_DT ATB_DT," ).append("\n"); 
		query.append("	              DTL.VOL_TR_UT_CD," ).append("\n"); 
		query.append("	              DTL.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	              SUM(DTL.RVIS_VOL_QTY) RVIS_VOL_QTY," ).append("\n"); 
		query.append("	              SUM(DTL.CALC_VOL_QTY) CALC_VOL_QTY," ).append("\n"); 
		query.append("	              SUM(DTL.INV_AMT) INV_AMT," ).append("\n"); 
		query.append("	              DECODE(DTL.CALC_TP_CD,'A',SUM(DTL.INV_AMT),0) AUTO_CALC_AMT," ).append("\n"); 
		query.append("	  			  DECODE(DTL.CALC_TP_CD,'M',DECODE(DTL.SEMI_AUTO_CALC_FLG,'Y',SUM(DTL.INV_AMT)),0) SEMI_AUTO_AMT," ).append("\n"); 
		query.append("	  			  DECODE(DTL.CALC_TP_CD,'M',DECODE(DTL.SEMI_AUTO_CALC_FLG,NULL,SUM(DTL.INV_AMT)),0) MANUAL_AMT" ).append("\n"); 
		query.append("	            FROM TES_TML_SO_HDR HDR, TES_TML_SO_DTL DTL" ).append("\n"); 
		query.append("	            WHERE HDR.TML_SO_OFC_CTY_CD = DTL.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	              AND HDR.TML_SO_SEQ = DTL.TML_SO_SEQ" ).append("\n"); 
		query.append("	              AND HDR.DELT_FLG IS NULL" ).append("\n"); 
		query.append("	              AND HDR.TML_INV_STS_CD <> 'R'" ).append("\n"); 
		query.append("	              AND HDR.TML_INV_RJCT_STS_CD <> 'RJ'            " ).append("\n"); 
		query.append("	            " ).append("\n"); 
		query.append("	            #if (${yd_cd} != '') " ).append("\n"); 
		query.append("	              AND HDR.yd_cd = @[yd_cd]" ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("	            #end " ).append("\n"); 
		query.append("	            " ).append("\n"); 
		query.append("	            #if (${vndr_seq} != '') " ).append("\n"); 
		query.append("	              AND HDR.vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("	            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("				#if($sub_ofc_cd1.size() > 0)" ).append("\n"); 
		query.append("					AND     HDR.cost_ofc_cd IN (" ).append("\n"); 
		query.append("					#foreach($sub_ofc_cd1_num IN ${sub_ofc_cd1})" ).append("\n"); 
		query.append("						#if($velocityCount < $sub_ofc_cd1.size()) " ).append("\n"); 
		query.append("							'$sub_ofc_cd1_num', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$sub_ofc_cd1_num' " ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND		HDR.cost_ofc_cd = @[cost_ofc_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("				#if($sub_ofc_cd2.size() > 0)" ).append("\n"); 
		query.append("					AND     HDR.inv_ofc_cd IN (" ).append("\n"); 
		query.append("					#foreach($sub_ofc_cd2_num IN ${sub_ofc_cd2})" ).append("\n"); 
		query.append("						#if($velocityCount < $sub_ofc_cd2.size()) " ).append("\n"); 
		query.append("							'$sub_ofc_cd2_num', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$sub_ofc_cd2_num' " ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND		HDR.inv_ofc_cd = @[inv_ofc_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	            " ).append("\n"); 
		query.append("	            #if (${inv_date_type} == 'I') " ).append("\n"); 
		query.append("	            			AND HDR.iss_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	            #elseif (${inv_date_type} == 'R') " ).append("\n"); 
		query.append("	            			AND HDR.rcv_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	            #elseif (${inv_date_type} == 'P') " ).append("\n"); 
		query.append("	            			AND HDR.locl_upd_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	            #elseif (${inv_date_type} == 'A') " ).append("\n"); 
		query.append("	            			AND DTL.atb_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999 " ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("	            #end" ).append("\n"); 
		query.append("	            " ).append("\n"); 
		query.append("	            #if (${vvd} != '') " ).append("\n"); 
		query.append("	              AND DTL.vsl_cd = SUBSTR(@[vvd],1,4)    " ).append("\n"); 
		query.append("	              AND DTL.skd_voy_no = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	              AND DTL.skd_dir_cd = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	            #else " ).append("\n"); 
		query.append("	            #end" ).append("\n"); 
		query.append("	            " ).append("\n"); 
		query.append("	            #if (${tml_inv_sts_cd} != '') " ).append("\n"); 
		query.append("	              AND	HDR.tml_inv_sts_cd	=	@[tml_inv_sts_cd]" ).append("\n"); 
		query.append("	            #else" ).append("\n"); 
		query.append("	            #end             " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	            GROUP BY DTL.TML_SO_OFC_CTY_CD, DTL.TML_SO_SEQ, DTL.LGS_COST_CD, DTL.CNTR_NO, DTL.VSL_CD, DTL.SKD_VOY_NO, DTL.SKD_DIR_CD, DTL.LANE_CD, DTL.ATB_DT, DTL.VOL_TR_UT_CD, DTL.CNTR_TPSZ_CD, DTL.RVIS_VOL_QTY, DTL.CALC_VOL_QTY, DTL.CALC_TP_CD, DTL.SEMI_AUTO_CALC_FLG) D                                             " ).append("\n"); 
		query.append("		        WHERE H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD                                                                                                                            " ).append("\n"); 
		query.append("		        AND H.TML_SO_SEQ = D.TML_SO_SEQ                                                                                                                                            " ).append("\n"); 
		query.append("		        AND H.DELT_FLG IS NULL                                                                                                                                                     " ).append("\n"); 
		query.append("		        AND H.TML_INV_STS_CD <> 'R'                                                                                                                                                " ).append("\n"); 
		query.append("		        AND H.TML_INV_RJCT_STS_CD <> 'RJ'                                                                                                                                          " ).append("\n"); 
		query.append("		        --AND H.TTL_INV_AMT <> 0 --2011.04.12 KSM D요청" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${yd_cd} != '') " ).append("\n"); 
		query.append("	AND h.yd_cd = @[yd_cd]" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("	AND h.vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("	#if($sub_ofc_cd1.size() > 0)" ).append("\n"); 
		query.append("		AND     h.cost_ofc_cd IN (" ).append("\n"); 
		query.append("		#foreach($sub_ofc_cd1_num IN ${sub_ofc_cd1})" ).append("\n"); 
		query.append("			#if($velocityCount < $sub_ofc_cd1.size()) " ).append("\n"); 
		query.append("				'$sub_ofc_cd1_num', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$sub_ofc_cd1_num' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND		h.cost_ofc_cd = @[cost_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("	#if($sub_ofc_cd2.size() > 0)" ).append("\n"); 
		query.append("		AND     h.inv_ofc_cd IN (" ).append("\n"); 
		query.append("		#foreach($sub_ofc_cd2_num IN ${sub_ofc_cd2})" ).append("\n"); 
		query.append("			#if($velocityCount < $sub_ofc_cd2.size()) " ).append("\n"); 
		query.append("				'$sub_ofc_cd2_num', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$sub_ofc_cd2_num' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND		h.inv_ofc_cd = @[inv_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${inv_date_type} == 'I') " ).append("\n"); 
		query.append("				AND h.iss_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#elseif (${inv_date_type} == 'R') " ).append("\n"); 
		query.append("				AND H.rcv_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#elseif (${inv_date_type} == 'P') " ).append("\n"); 
		query.append("				AND h.locl_upd_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#elseif (${inv_date_type} == 'A') " ).append("\n"); 
		query.append("				AND d.atb_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999 " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${vvd} != '') " ).append("\n"); 
		query.append("	AND D.vsl_cd = SUBSTR(@[vvd],1,4)    " ).append("\n"); 
		query.append("	AND D.skd_voy_no = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND D.skd_dir_cd = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	AND H.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("	AND H.INV_OFC_CD = O.OFC_CD(+)" ).append("\n"); 
		query.append("	AND O.LOC_CD     = L.LOC_CD(+)  " ).append("\n"); 
		query.append("	AND D.LGS_COST_CD = LC.LGS_COST_CD                                                                                                                                         " ).append("\n"); 
		query.append("	AND D.LGS_COST_CD = SC.LGS_COST_CD                                                                                                                                         " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${lgs_cost_subj_cd} != '') " ).append("\n"); 
		query.append("	AND LC.lgs_cost_subj_cd IN (" ).append("\n"); 
		query.append("	#foreach($lgs_cost_subj_cd_num IN ${lgs_cost_subj_cd})" ).append("\n"); 
		query.append("		#if($velocityCount < $lgs_cost_subj_cd.size()) " ).append("\n"); 
		query.append("		'$lgs_cost_subj_cd_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("		'$lgs_cost_subj_cd_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${cntr_sty_cd} != '') " ).append("\n"); 
		query.append("	AND SC.cntr_sty_cd IN (" ).append("\n"); 
		query.append("	#foreach($cntr_sty_cd_num IN ${cntr_sty_cd})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_sty_cd.size()) " ).append("\n"); 
		query.append("		'$cntr_sty_cd_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("		'$cntr_sty_cd_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${tml_inv_sts_cd} != '') " ).append("\n"); 
		query.append("	AND	H.tml_inv_sts_cd	=	@[tml_inv_sts_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	        GROUP BY H.INV_OFC_CD, H.COST_OFC_CD, H.YD_CD, H.VNDR_SEQ, H.INV_NO, D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.LANE_CD, D.ATB_DT, D.LGS_COST_CD,  H.CURR_CD,                            " ).append("\n"); 
		query.append("	            LC.LGS_COST_SUBJ_CD, D.VOL_TR_UT_CD,  L.CONTI_CD, O.AR_HD_QTR_OFC_CD, H.ISS_DT, H.LOCL_UPD_DT, LC.LGS_COST_ABBR_NM, V.VNDR_LGL_ENG_NM, V.VNDR_CNT_CD ,V.VNDR_LOCL_LANG_NM, O.OFC_CD, H.TML_INV_STS_CD             " ).append("\n"); 
		query.append("	        ORDER BY H.INV_OFC_CD, H.COST_OFC_CD, H.YD_CD, H.VNDR_SEQ, D.LGS_COST_CD) A, GL_MON_XCH_RT G                                                                               " ).append("\n"); 
		query.append("	WHERE  A.CURR_CD = G.CURR_CD                                                                                                                                                       " ).append("\n"); 
		query.append("	AND SUBSTR(A.ISS_DT,1,6) = G.ACCT_XCH_RT_YRMON                                                                                                                              " ).append("\n"); 
		query.append("	AND G.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	/**2013.02.26 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정 FDRCIV201301 ~ FDRCIV201312 **/" ).append("\n"); 
		query.append("	/**2013.06.03 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정..Rebate Invoice 처리 : 2012년 8월 ~ 2013년 12월..APP201208 ~ APP201312 **/" ).append("\n"); 
		query.append("	/**2013.06.03 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...2014년 용..APP201401, APP201402, APP201403 **/" ).append("\n"); 
		query.append("	#if (${cre_ofc_cd} != 'HAMSEL') " ).append("\n"); 
		query.append("	AND	A.INV_NO NOT IN ('FDRCIV201301','FDRCIV201302','FDRCIV201303','FDRCIV201304','FDRCIV201305','FDRCIV201306','FDRCIV201307','FDRCIV201308','FDRCIV201309','FDRCIV201310','FDRCIV201311','FDRCIV201312'," ).append("\n"); 
		query.append("						 'APP201208','APP201209','APP201210','APP201211','APP201212','APP201301','APP201302','APP201303','APP201304','APP201305','APP201306','APP201307','APP201308','APP201309','APP201310','APP201311','APP201312'," ).append("\n"); 
		query.append("						 'APP201401','APP201402','APP201403'" ).append("\n"); 
		query.append("						 ,'BEST201401Q','BEST201402Q','BEST201403Q','BEST201404Q','BEST201501Q','BEST201502Q','BEST201503Q','BEST201504Q' --// 2014-06-18 추가" ).append("\n"); 
		query.append("						 ,'UOM201406-001' --// 2014-07-08 추가" ).append("\n"); 
		query.append("						 )" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("WHERE	NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}