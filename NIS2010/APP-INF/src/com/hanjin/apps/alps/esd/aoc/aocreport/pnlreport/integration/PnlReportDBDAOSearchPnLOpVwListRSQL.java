/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PnlReportDBDAOSearchPnLOpVwListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PnlReportDBDAOSearchPnLOpVwListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.18 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 신규 개발 - Operation View
	  * 2014.10.07 최성환 [CHM-201432223] Week 조회 조건 오류 개선
	  * 2016.06.29 이민경 [CHM-201642128] [AOC] Profit & Loss Report for inland BIZ 변경
	  * </pre>
	  */
	public PnlReportDBDAOSearchPnLOpVwListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_fm_wm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pnl_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rev_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_to_wm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_svc_scp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rd_term",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration").append("\n"); 
		query.append("FileName : PnlReportDBDAOSearchPnLOpVwListRSQL").append("\n"); 
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
		query.append("SELECT  DIV" ).append("\n"); 
		query.append("      , ROWNUM SEQ" ).append("\n"); 
		query.append("      , GRP_NO" ).append("\n"); 
		query.append("      , WO_OFC_CD" ).append("\n"); 
		query.append("      , '' SVC_SCP_CD" ).append("\n"); 
		query.append("      , IO_BND_CD" ).append("\n"); 
		query.append("      , IO_BND_NM" ).append("\n"); 
		query.append("      , CTRT_OFC_CD" ).append("\n"); 
		query.append("      , PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("      , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00697' AND INTG_CD_VAL_CTNT = PRC_CTRT_CUST_TP_CD ) PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("      , INLND_REV_TP_CD" ).append("\n"); 
		query.append("      , INLND_REV_TP_NM" ).append("\n"); 
		query.append("      ----------------------------------------" ).append("\n"); 
		query.append("      , FM_NOD_CD" ).append("\n"); 
		query.append("      , TO_NOD_CD" ).append("\n"); 
		query.append("      , VIA_NOD_CD" ).append("\n"); 
		query.append("      , DOR_NOD_CD" ).append("\n"); 
		query.append("      , TTL_DIST" ).append("\n"); 
		query.append("      , LNK_DIST_DIV_CD" ).append("\n"); 
		query.append("      , TTL_PVNDR_SEQ" ).append("\n"); 
		query.append("      , TTL_PVNDR_NM" ).append("\n"); 
		query.append("      ----------------------------------------" ).append("\n"); 
		query.append("      , TTL_NO_OF_BKG" ).append("\n"); 
		query.append("      , BKG_CNTR_QTY" ).append("\n"); 
		query.append("      , WO_CNTR_QTY" ).append("\n"); 
		query.append("      , WO_TEU_QTY" ).append("\n"); 
		query.append("      , BKG_INLND_CHG_AMT" ).append("\n"); 
		query.append("      , GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("      , INLND_COST_USD_AMT" ).append("\n"); 
		query.append("      , INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("      , INV_USD_AMT" ).append("\n"); 
		query.append("      , Y_INV_USD_AMT" ).append("\n"); 
		query.append("      , X_INV_USD_AMT" ).append("\n"); 
		query.append("      , PL_GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("      , PL_INLND_COST_USD_AMT" ).append("\n"); 
		query.append("      , PL_INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("      , PL_INV_USD_AMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("          SELECT  DIV" ).append("\n"); 
		query.append("                , DECODE(DIV, '3', IO_BND_CD, WO_OFC_CD||'-'||IO_BND_CD)        GRP_NO" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', WO_OFC_CD, '2', WO_OFC_CD, 'ALL')            WO_OFC_CD" ).append("\n"); 
		query.append("                , IO_BND_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', DECODE(IO_BND_CD,'I','IN','OUT'), DECODE(IO_BND_CD,'I','IN','OUT')||' TTL')            IO_BND_NM" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', CTRT_OFC_CD, NULL)                           CTRT_OFC_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', PRC_CTRT_CUST_TP_CD, NULL)                   PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', INLND_REV_TP_CD, NULL)                       INLND_REV_TP_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', INLND_REV_TP_NM, NULL)                       INLND_REV_TP_NM" ).append("\n"); 
		query.append("                ----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', MAX(FM_NOD_CD), NULL)                             FM_NOD_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', MAX(TO_NOD_CD), NULL)                             TO_NOD_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', MAX(VIA_NOD_CD), NULL)                            VIA_NOD_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', MAX(DOR_NOD_CD), NULL)                            DOR_NOD_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', MAX(TTL_DIST), NULL)                              TTL_DIST" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', MAX(LNK_DIST_DIV_CD), NULL)                       LNK_DIST_DIV_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', MAX(TTL_PVNDR_SEQ), NULL)                         TTL_PVNDR_SEQ" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', MAX(TTL_PVNDR_NM), NULL)                          TTL_PVNDR_NM" ).append("\n"); 
		query.append("                ----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                , SUM(TTL_NO_OF_BKG)                                            TTL_NO_OF_BKG" ).append("\n"); 
		query.append("                , SUM(BKG_CNTR_QTY)                                             BKG_CNTR_QTY" ).append("\n"); 
		query.append("                , SUM(WO_CNTR_QTY)                                              WO_CNTR_QTY" ).append("\n"); 
		query.append("                , SUM(WO_TEU_QTY)                                               WO_TEU_QTY" ).append("\n"); 
		query.append("                , SUM(BKG_INLND_CHG_AMT)                                        BKG_INLND_CHG_AMT" ).append("\n"); 
		query.append("                , SUM(GLINE_FRT_RT_AMT)                                         GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                , SUM(INLND_COST_USD_AMT)                                       INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                , SUM(INLND_COST_TRSP_USD_AMT)                                  INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                , SUM(INV_USD_AMT)                                              INV_USD_AMT" ).append("\n"); 
		query.append("                , SUM(Y_INV_USD_AMT)                                            Y_INV_USD_AMT" ).append("\n"); 
		query.append("                , SUM(X_INV_USD_AMT)                                            X_INV_USD_AMT" ).append("\n"); 
		query.append("                , SUM(PL_GLINE_FRT_RT_AMT)                                      PL_GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                , SUM(PL_INLND_COST_USD_AMT)                                    PL_INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                , SUM(PL_INLND_COST_TRSP_USD_AMT)                               PL_INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                , SUM(PL_INV_USD_AMT)                                           PL_INV_USD_AMT" ).append("\n"); 
		query.append("          FROM    (" ).append("\n"); 
		query.append("                    SELECT  WO_OFC_CD" ).append("\n"); 
		query.append("                          , IO_BND_CD" ).append("\n"); 
		query.append("                          , CTRT_OFC_CD" ).append("\n"); 
		query.append("                          , PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("                          , INLND_REV_TP_CD" ).append("\n"); 
		query.append("                          ----------------------------------------" ).append("\n"); 
		query.append("                          , FM_NOD_CD" ).append("\n"); 
		query.append("                          , TO_NOD_CD" ).append("\n"); 
		query.append("                          , VIA_NOD_CD" ).append("\n"); 
		query.append("                          , DOR_NOD_CD" ).append("\n"); 
		query.append("                          , TTL_DIST" ).append("\n"); 
		query.append("                          , LNK_DIST_DIV_CD" ).append("\n"); 
		query.append("                          , CASE WHEN SUBSTR(TTL_PVNDR_SEQ, 1, 6) = SUBSTR(TTL_PVNDR_SEQ, 8, 6) THEN SUBSTR(TTL_PVNDR_SEQ, 1, 6)" ).append("\n"); 
		query.append("                                 ELSE TTL_PVNDR_SEQ" ).append("\n"); 
		query.append("                                 END TTL_PVNDR_SEQ" ).append("\n"); 
		query.append("                          , (SELECT NVL(WM_CONCAT(VNDR.VNDR_ABBR_NM),'')" ).append("\n"); 
		query.append("                                         FROM MDM_VENDOR VNDR" ).append("\n"); 
		query.append("                                        WHERE VNDR.VNDR_SEQ IN(SUBSTR(TTL_PVNDR_SEQ, 1, 6),SUBSTR(TTL_PVNDR_SEQ, 8, 6)))    TTL_PVNDR_NM" ).append("\n"); 
		query.append("                          ----------------------------------------" ).append("\n"); 
		query.append("                          , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03089' AND INTG_CD_VAL_CTNT = INLND_REV_TP_CD AND ROWNUM <= 1 ) INLND_REV_TP_NM" ).append("\n"); 
		query.append("                          , COUNT(1)                                                             TTL_NO_OF_BKG" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_20FT_CNTR_QTY,0)) + SUM(NVL(BKG_40FT_CNTR_QTY,0))           BKG_CNTR_QTY" ).append("\n"); 
		query.append("                          , SUM(NVL(WO_20FT_CNTR_QTY,0)) + SUM(NVL(WO_40FT_CNTR_QTY,0))             WO_CNTR_QTY" ).append("\n"); 
		query.append("                          , SUM(NVL(WO_TEU_QTY,0))                                                  WO_TEU_QTY" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0))                                           BKG_INLND_CHG_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(GLINE_FRT_RT_AMT,0))                                            GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(INLND_COST_USD_AMT,0))                                          INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(INLND_COST_TRSP_USD_AMT,0))                                     INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(INV_USD_AMT,0))                                                 INV_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL((SELECT SUM(INV_USD_AMT) FROM AOC_EUR_INLND_PFIT_LSS_DTL D " ).append("\n"); 
		query.append("							WHERE M.BKG_NO = D.BKG_NO AND M.IO_BND_CD = D.IO_BND_CD AND M.RHQ_CD = D.RHQ_CD AND D.TRSP_SO_TP_CD = 'Y'),0)) Y_INV_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL((SELECT SUM(INV_USD_AMT) FROM AOC_EUR_INLND_PFIT_LSS_DTL D " ).append("\n"); 
		query.append("							WHERE M.BKG_NO = D.BKG_NO AND M.IO_BND_CD = D.IO_BND_CD AND M.RHQ_CD = D.RHQ_CD AND D.TRSP_SO_TP_CD IN ('S','O')),0)) X_INV_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0)) - SUM(NVL(GLINE_FRT_RT_AMT,0))            PL_GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0)) - SUM(NVL(INLND_COST_USD_AMT,0))          PL_INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0)) - SUM(NVL(INLND_COST_TRSP_USD_AMT,0))     PL_INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0)) - SUM(NVL(INV_USD_AMT,0))                 PL_INV_USD_AMT" ).append("\n"); 
		query.append("                    FROM    AOC_EUR_INLND_PFIT_LSS M" ).append("\n"); 
		query.append("                    WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${r_prd_bkg_div} == 'P') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_chkprd} == 'W') " ).append("\n"); 
		query.append("                    AND     COST_YRWK >= @[f_year]||@[i_fm_wm]" ).append("\n"); 
		query.append("                    AND     COST_YRWK <= @[f_year]||@[i_to_wm]" ).append("\n"); 
		query.append("    #elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("                    AND     COST_YRMON >= @[f_year]||@[i_fm_wm]" ).append("\n"); 
		query.append("                    AND     COST_YRMON <= @[f_year]||@[i_to_wm]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${s_xcld_svc_scp} == 'Y') " ).append("\n"); 
		query.append("                    AND     SVC_SCP_CD NOT IN ('TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS','ISA') " ).append("\n"); 
		query.append("    #elseif (${s_xcld_svc_scp} == 'N') " ).append("\n"); 
		query.append("                    AND     SVC_SCP_CD IN ('TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS','ISA') " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${r_view} == 'S') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${s_rhq_cd} != '') " ).append("\n"); 
		query.append("                    AND     RHQ_CD = @[s_rhq_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${s_ctrt_ofc_cd1} != '') " ).append("\n"); 
		query.append("                    AND     CTRT_OFC_CD IN ( ${s_ctrt_ofc_cd1} )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${s_svc_scp} != '') " ).append("\n"); 
		query.append("                    AND     SVC_SCP_CD = @[s_svc_scp]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${s_wo_ofc_cd1} != '') " ).append("\n"); 
		query.append("                    AND     WO_OFC_CD IN ( ${s_wo_ofc_cd1} )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif (${r_view} == 'O')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${s_wo_ofc_cd2} != '') " ).append("\n"); 
		query.append("                    AND     WO_OFC_CD IN ( ${s_wo_ofc_cd2} )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${s_io_bnd_cd} != '') " ).append("\n"); 
		query.append("                    AND     IO_BND_CD = @[s_io_bnd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${s_ctrt_ofc_cd2} != '') " ).append("\n"); 
		query.append("                    AND     CTRT_OFC_CD IN ( ${s_ctrt_ofc_cd2} )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${c_xcld_ofc} != '') " ).append("\n"); 
		query.append("                    AND     WO_OFC_CD <> 'AARBA'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${s_cust_tp} != '') " ).append("\n"); 
		query.append("                    AND     PRC_CTRT_CUST_TP_CD = @[s_cust_tp]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${s_cust_cd} != '') " ).append("\n"); 
		query.append("                    AND     CTRT_CUST_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("                    AND     CTRT_CUST_SEQ = TO_NUMBER(SUBSTR(@[s_cust_cd],3,6))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${s_pnl_tp} == 'A')" ).append("\n"); 
		query.append("    #elseif(${s_pnl_tp} == '')" ).append("\n"); 
		query.append("        #if (${s_pnl_div} == 'I') " ).append("\n"); 
		query.append("                    AND     IHC_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'C')" ).append("\n"); 
		query.append("                    AND     COST_TTL_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'T')" ).append("\n"); 
		query.append("                    AND     COST_FULL_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'W')" ).append("\n"); 
		query.append("                    AND     WO_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'A')" ).append("\n"); 
		query.append("                    AND     IHC_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("                    AND     COST_TTL_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("                    AND     COST_FULL_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("                    AND     WO_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("	    #if (${s_pnl_div} == 'I') " ).append("\n"); 
		query.append("                    AND     IHC_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'C')" ).append("\n"); 
		query.append("                    AND     COST_TTL_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'T')" ).append("\n"); 
		query.append("                    AND     COST_FULL_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'W')" ).append("\n"); 
		query.append("                    AND     WO_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'A')" ).append("\n"); 
		query.append("                    AND(   IHC_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("                        OR   COST_TTL_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("                        OR   COST_FULL_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("                        OR   WO_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${s_rev_tp} != '')" ).append("\n"); 
		query.append("                    AND     INLND_REV_TP_CD = @[s_rev_tp]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${s_rd_term} != '')" ).append("\n"); 
		query.append("                    AND     RCV_DE_TERM_CD = @[s_rd_term]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${r_prd_bkg_div} == 'B') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${s_bkg_no} != '') " ).append("\n"); 
		query.append("                    AND     BKG_NO = @[s_bkg_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${s_ctrt_no} != '') " ).append("\n"); 
		query.append("                    AND     CTRT_NO = @[s_ctrt_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    GROUP BY" ).append("\n"); 
		query.append("                            WO_OFC_CD" ).append("\n"); 
		query.append("                          , IO_BND_CD" ).append("\n"); 
		query.append("                          , CTRT_OFC_CD" ).append("\n"); 
		query.append("                          , BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("                          , CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                          , CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                          , PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("                          , INLND_REV_TP_CD" ).append("\n"); 
		query.append("                          -----------------------------------------" ).append("\n"); 
		query.append("                          , FM_NOD_CD" ).append("\n"); 
		query.append("                          , TO_NOD_CD" ).append("\n"); 
		query.append("                          , VIA_NOD_CD" ).append("\n"); 
		query.append("                          , DOR_NOD_CD" ).append("\n"); 
		query.append("                          , TTL_DIST" ).append("\n"); 
		query.append("                          , LNK_DIST_DIV_CD" ).append("\n"); 
		query.append("                          , TTL_PVNDR_SEQ" ).append("\n"); 
		query.append("                          -----------------------------------------" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                    SELECT  '1' DIV" ).append("\n"); 
		query.append("                    FROM    DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  '2' DIV" ).append("\n"); 
		query.append("                    FROM    DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  '3' DIV" ).append("\n"); 
		query.append("                    FROM    DUAL" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("          GROUP BY" ).append("\n"); 
		query.append("                  DIV" ).append("\n"); 
		query.append("                , DECODE(DIV, '3', IO_BND_CD, WO_OFC_CD||'-'||IO_BND_CD)" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', WO_OFC_CD, '2', WO_OFC_CD, 'ALL')" ).append("\n"); 
		query.append("                , IO_BND_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', DECODE(IO_BND_CD,'I','IN','OUT'), DECODE(IO_BND_CD,'I','IN','OUT')||' TTL')" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', CTRT_OFC_CD, NULL)" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', PRC_CTRT_CUST_TP_CD, NULL)" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', INLND_REV_TP_CD, NULL)" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', INLND_REV_TP_NM, NULL)" ).append("\n"); 
		query.append("                ----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', FM_NOD_CD, NULL)                  " ).append("\n"); 
		query.append("                , DECODE(DIV, '1', TO_NOD_CD, NULL)                " ).append("\n"); 
		query.append("                , DECODE(DIV, '1', VIA_NOD_CD, NULL)             " ).append("\n"); 
		query.append("                , DECODE(DIV, '1', DOR_NOD_CD, NULL)                   " ).append("\n"); 
		query.append("                , DECODE(DIV, '1', TTL_DIST, NULL)                          " ).append("\n"); 
		query.append("                , DECODE(DIV, '1', LNK_DIST_DIV_CD, NULL)                     " ).append("\n"); 
		query.append("                , DECODE(DIV, '1', TTL_PVNDR_SEQ, NULL)                         " ).append("\n"); 
		query.append("                , DECODE(DIV, '1', TTL_PVNDR_NM, NULL)                          " ).append("\n"); 
		query.append("                ----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("          ORDER BY" ).append("\n"); 
		query.append("                  DECODE(DIV, '3', 'ZZZZZ', WO_OFC_CD)" ).append("\n"); 
		query.append("                , IO_BND_NM" ).append("\n"); 
		query.append("                , CTRT_OFC_CD" ).append("\n"); 
		query.append("                , PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("                , INLND_REV_TP_NM" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}