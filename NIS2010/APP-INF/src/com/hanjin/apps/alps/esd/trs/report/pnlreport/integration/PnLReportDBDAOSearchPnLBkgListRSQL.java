/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnLReportDBDAOSearchPnLBkgListRSQL.java
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

public class PnLReportDBDAOSearchPnLBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.20 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 신규 개발
	  * </pre>
	  */
	public PnLReportDBDAOSearchPnLBkgListRSQL(){
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
		query.append("FileName : PnLReportDBDAOSearchPnLBkgListRSQL").append("\n"); 
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
		query.append("SELECT  COST_YEAR" ).append("\n"); 
		query.append("      , COST_MONTH" ).append("\n"); 
		query.append("      , COST_WEEK" ).append("\n"); 
		query.append("      , BKG_NO" ).append("\n"); 
		query.append("      , SPLIT_FLG" ).append("\n"); 
		query.append("      , BKG_MRG_FLG" ).append("\n"); 
		query.append("      , CTRT_OFC_CD" ).append("\n"); 
		query.append("      , RHQ_CD" ).append("\n"); 
		query.append("      , SVC_SCP_CD" ).append("\n"); 
		query.append("      , WO_OFC_CD" ).append("\n"); 
		query.append("      , IO_BND_CD" ).append("\n"); 
		query.append("      , IO_BND_NM" ).append("\n"); 
		query.append("      , POR_CD" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 
		query.append("      , DEL_CD" ).append("\n"); 
		query.append("      , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("      , RFA_NO" ).append("\n"); 
		query.append("      , RT_APLY_DT" ).append("\n"); 
		query.append("      , PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("      , PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("      , CUST_CD" ).append("\n"); 
		query.append("      , CUST_NM" ).append("\n"); 
		query.append("      , INLND_REV_TP_CD" ).append("\n"); 
		query.append("      , INLND_REV_TP_NM" ).append("\n"); 
		query.append("      , WO_OFC_CD" ).append("\n"); 
		query.append("      , BKG_CNTR_QTY" ).append("\n"); 
		query.append("      , BKG_20FT_CNTR_QTY" ).append("\n"); 
		query.append("      , BKG_40FT_CNTR_QTY" ).append("\n"); 
		query.append("      , WO_CNTR_QTY" ).append("\n"); 
		query.append("      , WO_20FT_CNTR_QTY" ).append("\n"); 
		query.append("      , WO_40FT_CNTR_QTY" ).append("\n"); 
		query.append("      , BKG_TEU_QTY" ).append("\n"); 
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
		query.append("      , CMDT_CD" ).append("\n"); 
		query.append("      , CMDT_NM" ).append("\n"); 
		query.append("      , IHC_PL_RSLT_CD" ).append("\n"); 
		query.append("      , IHC_PL_RSLT_NM" ).append("\n"); 
		query.append("      , COST_TTL_PL_RSLT_CD" ).append("\n"); 
		query.append("      , COST_TTL_PL_RSLT_NM" ).append("\n"); 
		query.append("      , COST_FULL_PL_RSLT_CD" ).append("\n"); 
		query.append("      , COST_FULL_PL_RSLT_NM" ).append("\n"); 
		query.append("      , WO_PL_RSLT_CD" ).append("\n"); 
		query.append("      , WO_PL_RSLT_NM" ).append("\n"); 
		query.append("      , TOT_KNT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("          SELECT  SUBSTR(M.COST_YRMON,1,4) COST_YEAR" ).append("\n"); 
		query.append("                , SUBSTR(M.COST_YRMON,5,2) COST_MONTH" ).append("\n"); 
		query.append("                , SUBSTR(M.COST_YRWK,5,2) COST_WEEK" ).append("\n"); 
		query.append("                , M.BKG_NO" ).append("\n"); 
		query.append("                , M.SPLIT_FLG" ).append("\n"); 
		query.append("                , M.BKG_MRG_FLG" ).append("\n"); 
		query.append("                , M.CTRT_OFC_CD" ).append("\n"); 
		query.append("                , M.RHQ_CD" ).append("\n"); 
		query.append("                , M.SVC_SCP_CD" ).append("\n"); 
		query.append("                , M.WO_OFC_CD" ).append("\n"); 
		query.append("                , M.IO_BND_CD" ).append("\n"); 
		query.append("                , DECODE(M.IO_BND_CD,'I','IN','OUT') IO_BND_NM" ).append("\n"); 
		query.append("                , M.POR_CD" ).append("\n"); 
		query.append("                , M.POL_CD" ).append("\n"); 
		query.append("                , M.POD_CD" ).append("\n"); 
		query.append("                , M.DEL_CD" ).append("\n"); 
		query.append("                , ( SELECT RCV_TERM_CD||'/'||DE_TERM_CD FROM BKG_BOOKING WHERE BKG_NO = M.BKG_NO AND ROWNUM <= 1 ) RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                , M.RFA_NO" ).append("\n"); 
		query.append("                , TO_CHAR(M.RT_APLY_DT,'YYYY-MM-DD') RT_APLY_DT" ).append("\n"); 
		query.append("                , M.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00697' AND INTG_CD_VAL_CTNT = M.PRC_CTRT_CUST_TP_CD ) PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("                , M.CTRT_CUST_CNT_CD||LPAD(M.CTRT_CUST_SEQ,6,'0') CUST_CD" ).append("\n"); 
		query.append("                , ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = M.CTRT_CUST_CNT_CD AND CUST_SEQ = M.CTRT_CUST_SEQ ) CUST_NM" ).append("\n"); 
		query.append("                , M.INLND_REV_TP_CD" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03089' AND INTG_CD_VAL_CTNT = M.INLND_REV_TP_CD ) INLND_REV_TP_NM" ).append("\n"); 
		query.append("                , NVL(M.BKG_20FT_CNTR_QTY,0) + NVL(M.BKG_40FT_CNTR_QTY,0) BKG_CNTR_QTY" ).append("\n"); 
		query.append("                , NVL(M.BKG_20FT_CNTR_QTY,0) BKG_20FT_CNTR_QTY" ).append("\n"); 
		query.append("                , NVL(M.BKG_40FT_CNTR_QTY,0) BKG_40FT_CNTR_QTY" ).append("\n"); 
		query.append("                , NVL(M.WO_20FT_CNTR_QTY,0) + NVL(M.WO_40FT_CNTR_QTY,0) WO_CNTR_QTY" ).append("\n"); 
		query.append("                , NVL(M.WO_20FT_CNTR_QTY,0) WO_20FT_CNTR_QTY" ).append("\n"); 
		query.append("                , NVL(M.WO_40FT_CNTR_QTY,0) WO_40FT_CNTR_QTY" ).append("\n"); 
		query.append("                , NVL(M.BKG_TEU_QTY,0) BKG_TEU_QTY" ).append("\n"); 
		query.append("                , NVL(M.WO_TEU_QTY,0) WO_TEU_QTY" ).append("\n"); 
		query.append("                , NVL(M.BKG_INLND_CHG_AMT,0) BKG_INLND_CHG_AMT" ).append("\n"); 
		query.append("                , NVL(M.GLINE_FRT_RT_AMT,0) GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                , NVL(M.INLND_COST_USD_AMT,0) INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                , NVL(M.INLND_COST_TRSP_USD_AMT,0) INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                , NVL(M.WO_USD_AMT,0) WO_USD_AMT" ).append("\n"); 
		query.append("                , NVL(M.BKG_INLND_CHG_AMT,0) - NVL(M.GLINE_FRT_RT_AMT,0)        PL_GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                , NVL(M.BKG_INLND_CHG_AMT,0) - NVL(M.INLND_COST_USD_AMT,0)      PL_INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                , NVL(M.BKG_INLND_CHG_AMT,0) - NVL(M.INLND_COST_TRSP_USD_AMT,0) PL_INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                , NVL(M.BKG_INLND_CHG_AMT,0) - NVL(M.WO_USD_AMT,0)              PL_WO_USD_AMT" ).append("\n"); 
		query.append("                , M.CMDT_CD" ).append("\n"); 
		query.append("                , ( SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = M.CMDT_CD ) CMDT_NM" ).append("\n"); 
		query.append("                , M.IHC_PL_RSLT_CD" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03090' AND INTG_CD_VAL_CTNT = M.IHC_PL_RSLT_CD ) IHC_PL_RSLT_NM" ).append("\n"); 
		query.append("                , M.COST_TTL_PL_RSLT_CD" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03090' AND INTG_CD_VAL_CTNT = M.COST_TTL_PL_RSLT_CD ) COST_TTL_PL_RSLT_NM" ).append("\n"); 
		query.append("                , M.COST_FULL_PL_RSLT_CD" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03090' AND INTG_CD_VAL_CTNT = M.COST_FULL_PL_RSLT_CD ) COST_FULL_PL_RSLT_NM" ).append("\n"); 
		query.append("                , M.WO_PL_RSLT_CD" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03090' AND INTG_CD_VAL_CTNT = M.WO_PL_RSLT_CD ) WO_PL_RSLT_NM" ).append("\n"); 
		query.append("                , ROWNUM SEQ" ).append("\n"); 
		query.append("                , COUNT(1) OVER() TOT_KNT" ).append("\n"); 
		query.append("          FROM    TRS_EUR_INLND_PFIT_LSS M" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("#if (${s_cond} != '') " ).append("\n"); 
		query.append("    #if (${s_view} == 'S') " ).append("\n"); 
		query.append("          AND     ( M.CTRT_OFC_CD, M.WO_OFC_CD, M.PRC_CTRT_CUST_TP_CD, M.INLND_REV_TP_CD, M.SVC_SCP_CD ) IN (${s_cond})" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          AND     ( M.CTRT_OFC_CD, M.WO_OFC_CD, M.PRC_CTRT_CUST_TP_CD, M.INLND_REV_TP_CD, M.IO_BND_CD ) IN (${s_cond})" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("    #if (${c_xcld_ofc} != '') " ).append("\n"); 
		query.append("                    AND     CTRT_OFC_CD <> 'AARBA'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
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
		query.append("        )" ).append("\n"); 

	}
}