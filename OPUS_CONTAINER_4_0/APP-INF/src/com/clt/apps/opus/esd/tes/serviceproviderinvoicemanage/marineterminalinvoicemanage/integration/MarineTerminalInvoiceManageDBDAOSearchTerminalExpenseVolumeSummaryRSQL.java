/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseVolumeSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
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
		query.append("SELECT A.HQ_OFC_CD" ).append("\n"); 
		query.append("     , A.RHQ_OFC_CD" ).append("\n"); 
		query.append("     , A.INV_OFC_CD" ).append("\n"); 
		query.append("     , A.COST_OFC_CD" ).append("\n"); 
		query.append("     , A.YD_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.INV_NO" ).append("\n"); 
		query.append("     , H.CSR_NO" ).append("\n"); 
		query.append("     , TO_CHAR(H.IF_DT,'YYYY-MM-DD') IF_DT" ).append("\n"); 
		query.append("     , CASE WHEN H.RCV_ERR_FLG = 'E' THEN 'A/P Rejected'" ).append("\n"); 
		query.append("            WHEN H.IF_FLG = 'E' THEN 'I/F Error'" ).append("\n"); 
		query.append("            WHEN NVL(H.APRO_FLG,'N') = 'N' AND H.IF_FLG IS NULL  AND H.AFT_ACT_FLG = 'X' THEN 'Canceled'" ).append("\n"); 
		query.append("            WHEN H.IF_FLG = 'Y' AND H.RCV_ERR_FLG IS NULL THEN 'I/F Success'" ).append("\n"); 
		query.append("            --WHEN dddd.TML_INV_RJCT_STS_CD IN ('RJ') THEN 'Disapproved'" ).append("\n"); 
		query.append("            WHEN H.IF_FLG IS NULL THEN DECODE(H.APRO_FLG,'Y','Sending','Approval Requested')" ).append("\n"); 
		query.append("         ELSE 'ALL'" ).append("\n"); 
		query.append("       END IF_STATUS" ).append("\n"); 
		query.append("     , A.ISS_DT" ).append("\n"); 
		query.append("     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , A.ATB_DT" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.LGS_COST_CD" ).append("\n"); 
		query.append("     , A.LGS_COST_ABBR_NM" ).append("\n"); 
		query.append("     , A.VOL_TR_UT_CD" ).append("\n"); 
		query.append("     , A.VOL_D2" ).append("\n"); 
		query.append("     , A.VOL_D4" ).append("\n"); 
		query.append("     , A.VOL_D5" ).append("\n"); 
		query.append("     , A.VOL_D7" ).append("\n"); 
		query.append("     , A.VOL_D8" ).append("\n"); 
		query.append("     , A.VOL_D9" ).append("\n"); 
		query.append("     , A.VOL_DW" ).append("\n"); 
		query.append("     , A.VOL_DX" ).append("\n"); 
		query.append("     , A.VOL_R2" ).append("\n"); 
		query.append("     , A.VOL_R4" ).append("\n"); 
		query.append("     , A.VOL_R5" ).append("\n"); 
		query.append("     , A.VOL_R7" ).append("\n"); 
		query.append("     , A.VOL_F2" ).append("\n"); 
		query.append("     , A.VOL_F4" ).append("\n"); 
		query.append("     , A.VOL_F5" ).append("\n"); 
		query.append("     , A.VOL_O2" ).append("\n"); 
		query.append("     , A.VOL_O4" ).append("\n"); 
		query.append("     , A.VOL_S2" ).append("\n"); 
		query.append("     , A.VOL_S4" ).append("\n"); 
		query.append("     , A.VOL_T2" ).append("\n"); 
		query.append("     , A.VOL_T4" ).append("\n"); 
		query.append("     , A.VOL_A2" ).append("\n"); 
		query.append("     , A.VOL_A4" ).append("\n"); 
		query.append("     , A.VOL_P2" ).append("\n"); 
		query.append("     , A.VOL_P4" ).append("\n"); 
		query.append("     , A.VOL_DAY" ).append("\n"); 
		query.append("     , A.VOL_MOVE" ).append("\n"); 
		query.append("     , A.VOL_GH" ).append("\n"); 
		query.append("     , A.VOL_BOX" ).append("\n"); 
		query.append("     , A.VOL_TEU" ).append("\n"); 
		query.append("     , A.VOL_D2+A.VOL_R2+A.VOL_F2+A.VOL_O2+A.VOL_S2+A.VOL_T2+A.VOL_A2+A.VOL_P2 TTL_20" ).append("\n"); 
		query.append("     , A.VOL_D4+A.VOL_R4+A.VOL_F4+A.VOL_O4+A.VOL_S4+A.VOL_T4+A.VOL_A4+A.VOL_P4 + A.VOL_D5 +A.VOL_D7+A.VOL_D8+A.VOL_D9+A.VOL_DW+A.VOL_DX+A.VOL_R5+A.VOL_R7+A.VOL_F5 TTL_40" ).append("\n"); 
		query.append("     , A.VOL_D2+A.VOL_D4+A.VOL_D5+A.VOL_D7+A.VOL_D8+A.VOL_D9+A.VOL_DW+A.VOL_DX+A.VOL_R2 +A.VOL_R4+A.VOL_R5+A.VOL_R7+A.VOL_F2+A.VOL_F4+A.VOL_F5+A.VOL_O2+A.VOL_O4+A.VOL_S2 +A.VOL_S4+A.VOL_T2+A.VOL_T4+A.VOL_A2+A.VOL_A4+A.VOL_P2+A.VOL_P4 TTL_BOX" ).append("\n"); 
		query.append("     , A.VOL_D2+A.VOL_D4*2+A.VOL_D5*2+A.VOL_D7*2.25+A.VOL_D8*2.4+A.VOL_D9*2.4+A.VOL_DW*2.65 +A.VOL_DX*2.65+A.VOL_R2+A.VOL_R4*2+A.VOL_R5*2+A.VOL_R7*2.25+A.VOL_F2+A.VOL_F4*2 +A.VOL_F5*2+A.VOL_O2+A.VOL_O4*2+A.VOL_S2+A.VOL_S4*2+A.VOL_T2+A.VOL_T4*2+A.VOL_A2 +A.VOL_A4*2+A.VOL_P2+A.VOL_P4*2 TTL_TEU" ).append("\n"); 
		query.append("     , A.INV_AMT" ).append("\n"); 
		query.append("     , NVL(A.LANE_CD,A.SLAN_CD) AS LANE_CD" ).append("\n"); 
		query.append("     , NVL(ROUND( (SELECT A.INV_AMT/G.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                     FROM GL_MON_XCH_RT G" ).append("\n"); 
		query.append("                    WHERE G.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("                      AND G.ACCT_XCH_RT_YRMON = A.ISS_DT" ).append("\n"); 
		query.append("                      AND G.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                ,2),0) USD_AMT" ).append("\n"); 
		query.append("  FROM(SELECT A.*" ).append("\n"); 
		query.append("             , (SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                 WHERE OFC_CD = A.INV_OFC_CD) RHQ_OFC_CD" ).append("\n"); 
		query.append("             , (SELECT DECODE(V.VNDR_CNT_CD,'KR',V.VNDR_LOCL_LANG_NM,V.VNDR_LGL_ENG_NM)" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR V" ).append("\n"); 
		query.append("                 WHERE V.VNDR_SEQ = A.VNDR_SEQ ) VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM (SELECT 'SINHO' HQ_OFC_CD" ).append("\n"); 
		query.append("                     --, O.AR_HD_QTR_OFC_CD RHQ_OFC_CD,   " ).append("\n"); 
		query.append("                     , H.INV_OFC_CD" ).append("\n"); 
		query.append("                     , H.COST_OFC_CD" ).append("\n"); 
		query.append("                     , H.YD_CD" ).append("\n"); 
		query.append("                     , LPAD(H.VNDR_SEQ, 6, '0') VNDR_SEQ" ).append("\n"); 
		query.append("                     --, DECODE(V.VNDR_CNT_CD,'KR',V.VNDR_LOCL_LANG_NM,V.VNDR_LGL_ENG_NM) VNDR_LGL_ENG_NM,                                                                                  " ).append("\n"); 
		query.append("                     , H.INV_NO" ).append("\n"); 
		query.append("                     , H.CSR_NO" ).append("\n"); 
		query.append("                     , TO_CHAR(H.ISS_DT, 'YYYYMM') ISS_DT" ).append("\n"); 
		query.append("                     , D.VSL_CD" ).append("\n"); 
		query.append("                     , D.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , D.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , (SELECT DISTINCT SLAN_CD" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                         WHERE VSL_CD=D.VSL_CD" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO=D.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD=D.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) SLAN_CD" ).append("\n"); 
		query.append("                     , TO_CHAR(D.ATB_DT, 'YYYYMMDD') ATB_DT" ).append("\n"); 
		query.append("                     , H.CURR_CD" ).append("\n"); 
		query.append("                     , D.LGS_COST_CD" ).append("\n"); 
		query.append("                     , LC.LGS_COST_ABBR_NM" ).append("\n"); 
		query.append("                     , D.VOL_TR_UT_CD" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'D2',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_D2" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'D4',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_D4" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'D5',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_D5" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'D7',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_D7" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'D8',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_D8" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'D9',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_D9" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'DW',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_DW" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'DX',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_DX" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'R2',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_R2" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'R4',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_R4" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'R5',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_R5" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'R7',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_R7" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'F2',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_F2" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'F4',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_F4" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'F5',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_F5" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'O2',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_O2" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'O4',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_O4" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'S2',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_S2" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'S4',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_S4" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'T2',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_T2" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'T4',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_T4" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'A2',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_A2" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'A4',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_A4" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'P2',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_P2" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0,DECODE(D.CNTR_TPSZ_CD,'P4',NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0))) VOL_P4" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',DECODE(NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0,OVR_DYS,0),0)) VOL_DAY" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0, DECODE(D.VOL_TR_UT_CD,'M',DECODE(NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0,NVL(D.OVR_DYS,0),D.RVIS_VOL_QTY),0))) VOL_MOVE" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0, DECODE(D.VOL_TR_UT_CD,'G',DECODE(NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0,NVL(D.OVR_DYS,0),D.RVIS_VOL_QTY),0))) VOL_GH" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0, DECODE(D.VOL_TR_UT_CD,'U',DECODE(NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0,NVL(D.OVR_DYS,0),D.RVIS_VOL_QTY),0))) VOL_BOX" ).append("\n"); 
		query.append("                     , SUM(DECODE(LC.LGS_COST_SUBJ_CD,'SR',0, DECODE(D.VOL_TR_UT_CD,'T',DECODE(NVL(NVL(D.RVIS_VOL_QTY,D.CALC_VOL_QTY),0),0,NVL(D.OVR_DYS,0),D.RVIS_VOL_QTY),0))) VOL_TEU" ).append("\n"); 
		query.append("                     , SUM(D.INV_AMT) INV_AMT" ).append("\n"); 
		query.append("                     , D.LANE_CD																												" ).append("\n"); 
		query.append("	        FROM TES_TML_SO_HDR H" ).append("\n"); 
		query.append("                     , TES_TML_SO_DTL D" ).append("\n"); 
		query.append("                     , (SELECT LC.LGS_COST_CD" ).append("\n"); 
		query.append("                             , LC.LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("                             , LC.LGS_COST_ABBR_NM" ).append("\n"); 
		query.append("                             , SC.CNTR_STY_CD" ).append("\n"); 
		query.append("                          FROM TES_LGS_COST LC" ).append("\n"); 
		query.append("                             , TES_TML_SO_COST SC" ).append("\n"); 
		query.append("                         WHERE LC.LGS_COST_CD = SC.LGS_COST_CD ) LC     " ).append("\n"); 
		query.append("            WHERE 1=1                                        " ).append("\n"); 
		query.append("	        AND H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD                                                                                                                            " ).append("\n"); 
		query.append("	        AND H.TML_SO_SEQ = D.TML_SO_SEQ                                                                                                                                            " ).append("\n"); 
		query.append("	        AND H.DELT_FLG IS NULL                                                                                                                                                     " ).append("\n"); 
		query.append("	        AND H.TML_INV_STS_CD <> 'R'                                                                                                                                                " ).append("\n"); 
		query.append("	        AND H.TML_INV_RJCT_STS_CD <> 'RJ'                                                                                                                                          " ).append("\n"); 
		query.append("	        AND H.TTL_INV_AMT <> 0" ).append("\n"); 
		query.append("            AND D.LGS_COST_CD = LC.LGS_COST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane_cd} != '') " ).append("\n"); 
		query.append("and D.LANE_CD = @[lane_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("and h.yd_cd = @[yd_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("and h.vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '') " ).append("\n"); 
		query.append("and cost_ofc_cd in (" ).append("\n"); 
		query.append("#foreach($cost_ofc_cd_num IN ${cost_ofc_cd})" ).append("\n"); 
		query.append("	#if($velocityCount < $cost_ofc_cd.size()) " ).append("\n"); 
		query.append("	'$cost_ofc_cd_num', " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	'$cost_ofc_cd_num' " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_ofc_cd} != '') " ).append("\n"); 
		query.append("AND H.inv_ofc_cd IN (" ).append("\n"); 
		query.append("#foreach($inv_ofc_cd_num IN ${inv_ofc_cd})" ).append("\n"); 
		query.append("	#if($velocityCount < $inv_ofc_cd.size()) " ).append("\n"); 
		query.append("	'$inv_ofc_cd_num', " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	'$inv_ofc_cd_num' " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_date_type} == 'I') " ).append("\n"); 
		query.append("			AND h.iss_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'R') " ).append("\n"); 
		query.append("			AND H.rcv_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'P') " ).append("\n"); 
		query.append("			AND h.locl_upd_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'A') " ).append("\n"); 
		query.append("			AND d.atb_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999 " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("AND D.vsl_cd = SUBSTR(@[vvd],1,4)    " ).append("\n"); 
		query.append("AND D.skd_voy_no = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND D.skd_dir_cd = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lgs_cost_subj_cd} != '') " ).append("\n"); 
		query.append("AND LC.lgs_cost_subj_cd IN (" ).append("\n"); 
		query.append("#foreach($lgs_cost_subj_cd_num IN ${lgs_cost_subj_cd})" ).append("\n"); 
		query.append("	#if($velocityCount < $lgs_cost_subj_cd.size()) " ).append("\n"); 
		query.append("	'$lgs_cost_subj_cd_num', " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	'$lgs_cost_subj_cd_num' " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_sty_cd} != '') " ).append("\n"); 
		query.append("AND LC.cntr_sty_cd IN (" ).append("\n"); 
		query.append("#foreach($cntr_sty_cd_num IN ${cntr_sty_cd})" ).append("\n"); 
		query.append("	#if($velocityCount < $cntr_sty_cd.size()) " ).append("\n"); 
		query.append("	'$cntr_sty_cd_num', " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	'$cntr_sty_cd_num' " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        GROUP BY H.INV_OFC_CD" ).append("\n"); 
		query.append("                     , H.COST_OFC_CD" ).append("\n"); 
		query.append("                     , H.YD_CD" ).append("\n"); 
		query.append("                     , H.VNDR_SEQ" ).append("\n"); 
		query.append("                     , H.INV_NO" ).append("\n"); 
		query.append("                     , H.CSR_NO" ).append("\n"); 
		query.append("                     , D.VSL_CD" ).append("\n"); 
		query.append("                     , D.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , D.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , D.ATB_DT" ).append("\n"); 
		query.append("                     , D.LGS_COST_CD" ).append("\n"); 
		query.append("                     , H.CURR_CD" ).append("\n"); 
		query.append("                     , LC.LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("                     , D.VOL_TR_UT_CD" ).append("\n"); 
		query.append("                     --, L.CONTI_CD" ).append("\n"); 
		query.append("                     --, O.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                     , H.ISS_DT" ).append("\n"); 
		query.append("                     , LC.LGS_COST_ABBR_NM" ).append("\n"); 
		query.append("                     --, V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                      --, V.VNDR_CNT_CD" ).append("\n"); 
		query.append("                      --, V.VNDR_LOCL_LANG_NM" ).append("\n"); 
		query.append("                     , D.LANE_CD ) A" ).append("\n"); 
		query.append("         ORDER BY A.INV_OFC_CD" ).append("\n"); 
		query.append("             , A.COST_OFC_CD" ).append("\n"); 
		query.append("             , A.YD_CD" ).append("\n"); 
		query.append("             , A.VNDR_SEQ" ).append("\n"); 
		query.append("             , A.LGS_COST_CD ) A" ).append("\n"); 
		query.append("     , AP_INV_HDR H                                                                                " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND A.CSR_NO = H.CSR_NO(+)" ).append("\n"); 

	}
}