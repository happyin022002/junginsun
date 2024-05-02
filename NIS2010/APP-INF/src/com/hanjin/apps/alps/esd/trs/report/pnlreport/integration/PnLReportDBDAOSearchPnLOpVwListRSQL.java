/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnLReportDBDAOSearchPnLOpVwListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.pnlreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PnLReportDBDAOSearchPnLOpVwListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.18 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 신규 개발 - Operation View
	  * </pre>
	  */
	public PnLReportDBDAOSearchPnLOpVwListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("i_fm_wm",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pnl_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.pnlreport.integration").append("\n"); 
		query.append("FileName : PnLReportDBDAOSearchPnLOpVwListRSQL").append("\n"); 
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
		query.append("      , PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("      , INLND_REV_TP_CD" ).append("\n"); 
		query.append("      , INLND_REV_TP_NM" ).append("\n"); 
		query.append("      , TTL_NO_OF_BKG" ).append("\n"); 
		query.append("      , BKG_CNTR_QTY" ).append("\n"); 
		query.append("      , WO_CNTR_QTY" ).append("\n"); 
		query.append("      , WO_TEU_QTY" ).append("\n"); 
		query.append("      , BKG_INLND_CHG_AMT" ).append("\n"); 
		query.append("      , GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("      , INLND_COST_USD_AMT" ).append("\n"); 
		query.append("      , INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("      , WO_USD_AMT" ).append("\n"); 
		query.append("      , PL_GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("      , PL_INLND_COST_USD_AMT" ).append("\n"); 
		query.append("      , PL_INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("      , PL_WO_USD_AMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("          SELECT  DIV" ).append("\n"); 
		query.append("                , DECODE(DIV, '3', IO_BND_CD, WO_OFC_CD||'-'||IO_BND_CD)        GRP_NO" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', WO_OFC_CD, '2', WO_OFC_CD, 'ALL')            WO_OFC_CD" ).append("\n"); 
		query.append("                , IO_BND_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', DECODE(IO_BND_CD,'I','IN','OUT'), DECODE(IO_BND_CD,'I','IN','OUT')||' TTL')            IO_BND_NM" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', CTRT_OFC_CD, NULL)                           CTRT_OFC_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', PRC_CTRT_CUST_TP_CD, NULL)                   PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', PRC_CTRT_CUST_TP_NM, NULL)                   PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', INLND_REV_TP_CD, NULL)                       INLND_REV_TP_CD" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', INLND_REV_TP_NM, NULL)                       INLND_REV_TP_NM" ).append("\n"); 
		query.append("                , SUM(TTL_NO_OF_BKG)                                            TTL_NO_OF_BKG" ).append("\n"); 
		query.append("                , SUM(BKG_CNTR_QTY)                                             BKG_CNTR_QTY" ).append("\n"); 
		query.append("                , SUM(WO_CNTR_QTY)                                              WO_CNTR_QTY" ).append("\n"); 
		query.append("                , SUM(WO_TEU_QTY)                                               WO_TEU_QTY" ).append("\n"); 
		query.append("                , SUM(BKG_INLND_CHG_AMT)                                        BKG_INLND_CHG_AMT" ).append("\n"); 
		query.append("                , SUM(GLINE_FRT_RT_AMT)                                         GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                , SUM(INLND_COST_USD_AMT)                                       INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                , SUM(INLND_COST_TRSP_USD_AMT)                                  INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                , SUM(WO_USD_AMT)                                               WO_USD_AMT" ).append("\n"); 
		query.append("                , SUM(PL_GLINE_FRT_RT_AMT)                                      PL_GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                , SUM(PL_INLND_COST_USD_AMT)                                    PL_INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                , SUM(PL_INLND_COST_TRSP_USD_AMT)                               PL_INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                , SUM(PL_WO_USD_AMT)                                            PL_WO_USD_AMT" ).append("\n"); 
		query.append("          FROM    (" ).append("\n"); 
		query.append("                    SELECT  WO_OFC_CD" ).append("\n"); 
		query.append("                          , IO_BND_CD" ).append("\n"); 
		query.append("                          , CTRT_OFC_CD" ).append("\n"); 
		query.append("                          , PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("                          , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00697' AND INTG_CD_VAL_CTNT = PRC_CTRT_CUST_TP_CD AND ROWNUM <= 1 ) PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("                          , INLND_REV_TP_CD" ).append("\n"); 
		query.append("                          , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03089' AND INTG_CD_VAL_CTNT = INLND_REV_TP_CD AND ROWNUM <= 1 ) INLND_REV_TP_NM" ).append("\n"); 
		query.append("                          , COUNT(1)                                                             TTL_NO_OF_BKG" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_20FT_CNTR_QTY,0)) + SUM(NVL(BKG_40FT_CNTR_QTY,0))           BKG_CNTR_QTY" ).append("\n"); 
		query.append("                          , SUM(NVL(WO_20FT_CNTR_QTY,0)) + SUM(NVL(WO_40FT_CNTR_QTY,0))             WO_CNTR_QTY" ).append("\n"); 
		query.append("                          , SUM(NVL(WO_TEU_QTY,0))                                                  WO_TEU_QTY" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0))                                           BKG_INLND_CHG_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(GLINE_FRT_RT_AMT,0))                                            GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(INLND_COST_USD_AMT,0))                                          INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(INLND_COST_TRSP_USD_AMT,0))                                     INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(WO_USD_AMT,0))                                                  WO_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0)) - SUM(NVL(GLINE_FRT_RT_AMT,0))            PL_GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0)) - SUM(NVL(INLND_COST_USD_AMT,0))          PL_INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0)) - SUM(NVL(INLND_COST_TRSP_USD_AMT,0))     PL_INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                          , SUM(NVL(BKG_INLND_CHG_AMT,0)) - SUM(NVL(WO_USD_AMT,0))                  PL_WO_USD_AMT" ).append("\n"); 
		query.append("                    FROM    TRS_EUR_INLND_PFIT_LSS" ).append("\n"); 
		query.append("                    WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${r_prd_bkg_div} == 'P') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_chkprd} == 'W') " ).append("\n"); 
		query.append("                    AND     COST_YRWK >= @[f_year]||@[i_fm_wm]" ).append("\n"); 
		query.append("                    AND     COST_YRWK <= @[f_year]||@[i_fm_wm]" ).append("\n"); 
		query.append("    #elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("                    AND     COST_YRMON >= @[f_year]||@[i_fm_wm]" ).append("\n"); 
		query.append("                    AND     COST_YRMON <= @[f_year]||@[i_to_wm]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${r_view} == 'S') " ).append("\n"); 
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
		query.append("                    AND     CTRT_OFC_CD <> 'AARBA'" ).append("\n"); 
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
		query.append("    #if (${s_pnl_tp} != '')" ).append("\n"); 
		query.append("        #if (${s_pnl_div} == 'I') " ).append("\n"); 
		query.append("                    AND     IHC_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'C')" ).append("\n"); 
		query.append("                    AND     COST_TTL_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'T')" ).append("\n"); 
		query.append("                    AND     COST_FULL_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'W')" ).append("\n"); 
		query.append("                    AND     WO_PL_RSLT_CD = @[s_pnl_tp]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        #if (${s_pnl_div} == 'I') " ).append("\n"); 
		query.append("                    AND     IHC_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'C')" ).append("\n"); 
		query.append("                    AND     COST_TTL_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'T')" ).append("\n"); 
		query.append("                    AND     COST_FULL_PL_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("        #elseif (${s_pnl_div} == 'W')" ).append("\n"); 
		query.append("                    AND     WO_PL_RSLT_CD <> 'N'" ).append("\n"); 
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
		query.append("    #if (${s_rfa_no} != '') " ).append("\n"); 
		query.append("                    AND     RFA_NO = @[s_rfa_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    GROUP BY" ).append("\n"); 
		query.append("                            WO_OFC_CD" ).append("\n"); 
		query.append("                          , IO_BND_CD" ).append("\n"); 
		query.append("                          , CTRT_OFC_CD" ).append("\n"); 
		query.append("                          , PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("                          , INLND_REV_TP_CD" ).append("\n"); 
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
		query.append("                , DECODE(DIV, '1', PRC_CTRT_CUST_TP_NM, NULL)" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', INLND_REV_TP_CD, NULL)" ).append("\n"); 
		query.append("                , DECODE(DIV, '1', INLND_REV_TP_NM, NULL)" ).append("\n"); 
		query.append("          ORDER BY" ).append("\n"); 
		query.append("                  DECODE(DIV, '3', 'ZZZZZ', WO_OFC_CD)" ).append("\n"); 
		query.append("                , IO_BND_NM" ).append("\n"); 
		query.append("                , CTRT_OFC_CD" ).append("\n"); 
		query.append("                , PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("                , INLND_REV_TP_NM" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}