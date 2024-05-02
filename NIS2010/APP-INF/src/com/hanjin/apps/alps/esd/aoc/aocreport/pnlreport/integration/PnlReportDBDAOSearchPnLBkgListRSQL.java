/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PnlReportDBDAOSearchPnLBkgListRSQL.java
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

public class PnlReportDBDAOSearchPnLBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PnLBkgListVO 생성 Query : PnlReportDBDAOPnLBkgListVORSQL
	  * 2014.10.07 최성환 [CHM-201432223] Week 조회 조건 오류 개선
	  * </pre>
	  */
	public PnlReportDBDAOSearchPnLBkgListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration").append("\n"); 
		query.append("FileName : PnlReportDBDAOSearchPnLBkgListRSQL").append("\n"); 
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
		query.append("      , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("      , CTRT_TP_NM" ).append("\n"); 
		query.append("      , CTRT_NO" ).append("\n"); 
		query.append("      , RT_APLY_DT" ).append("\n"); 
		query.append("      , PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("      , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00697' AND INTG_CD_VAL_CTNT = PRC_CTRT_CUST_TP_CD ) PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("      , CUST_SEGM_CD" ).append("\n"); 
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
		query.append("      , INV_USD_AMT" ).append("\n"); 
		query.append("      , Y_INV_USD_AMT" ).append("\n"); 
		query.append("      , X_INV_USD_AMT" ).append("\n"); 
		query.append("      , PL_GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("      , PL_INLND_COST_USD_AMT" ).append("\n"); 
		query.append("      , PL_INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("      , PL_INV_USD_AMT" ).append("\n"); 
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
		query.append("      , VSL_SLAN_CD" ).append("\n"); 
		query.append("      , CTRT_EFF_DT" ).append("\n"); 
		query.append("      , CTRT_EXP_DT" ).append("\n"); 
		query.append("      , RFA_AMDT_CRE_DT" ).append("\n"); 
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
		query.append("                          ----------------------------------------" ).append("\n"); 
		query.append("                          , M.FM_NOD_CD" ).append("\n"); 
		query.append("                          , M.TO_NOD_CD" ).append("\n"); 
		query.append("                          , M.VIA_NOD_CD" ).append("\n"); 
		query.append("                          , M.DOR_NOD_CD" ).append("\n"); 
		query.append("                          , M.TTL_DIST" ).append("\n"); 
		query.append("                          , M.LNK_DIST_DIV_CD" ).append("\n"); 
		query.append("                          , CASE WHEN SUBSTR(TTL_PVNDR_SEQ, 1, 6) = SUBSTR(TTL_PVNDR_SEQ, 8, 6) THEN SUBSTR(TTL_PVNDR_SEQ, 1, 6)" ).append("\n"); 
		query.append("                                 ELSE TTL_PVNDR_SEQ" ).append("\n"); 
		query.append("                                 END TTL_PVNDR_SEQ" ).append("\n"); 
		query.append("                          , (SELECT NVL(WM_CONCAT(VNDR.VNDR_ABBR_NM),'')" ).append("\n"); 
		query.append("                                         FROM MDM_VENDOR VNDR" ).append("\n"); 
		query.append("                                        WHERE VNDR.VNDR_SEQ IN(SUBSTR(TTL_PVNDR_SEQ, 1, 6),SUBSTR(TTL_PVNDR_SEQ, 8, 6)))    TTL_PVNDR_NM" ).append("\n"); 
		query.append("                          ----------------------------------------" ).append("\n"); 
		query.append("                , ( SELECT RCV_TERM_CD||'/'||DE_TERM_CD FROM BKG_BOOKING WHERE BKG_NO = M.BKG_NO AND ROWNUM <= 1 ) RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01652',M.BKG_CTRT_TP_CD) CTRT_TP_NM" ).append("\n"); 
		query.append("                , M.CTRT_NO" ).append("\n"); 
		query.append("                , TO_CHAR(M.RT_APLY_DT,'YYYY-MM-DD') RT_APLY_DT" ).append("\n"); 
		query.append("                , DECODE(M.BKG_CTRT_TP_CD,'S',(SELECT RVIS_CNTR_CUST_TP_CD FROM MDM_CUSTOMER WHERE CUST_CNT_CD = M.CTRT_CUST_CNT_CD AND CUST_SEQ = M.CTRT_CUST_SEQ),M.PRC_CTRT_CUST_TP_CD) PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("                , CASE WHEN CUST.NEW_KEY_ACCT_FLG =  'Y' THEN 'CC'" ).append("\n"); 
		query.append("                       WHEN CUST.RGN_ACCT_FLG =  'Y' THEN 'RC'" ).append("\n"); 
		query.append("                       ELSE 'LC'" ).append("\n"); 
		query.append("                  END CUST_SEGM_CD" ).append("\n"); 
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
		query.append("                , NVL(M.INV_USD_AMT,0) INV_USD_AMT" ).append("\n"); 
		query.append("                , NVL((SELECT SUM(INV_USD_AMT) FROM AOC_EUR_INLND_PFIT_LSS_DTL D " ).append("\n"); 
		query.append("						WHERE M.BKG_NO = D.BKG_NO AND M.IO_BND_CD = D.IO_BND_CD AND M.RHQ_CD = D.RHQ_CD AND D.TRSP_SO_TP_CD = 'Y'),0) Y_INV_USD_AMT" ).append("\n"); 
		query.append("                , NVL((SELECT SUM(INV_USD_AMT) FROM AOC_EUR_INLND_PFIT_LSS_DTL D " ).append("\n"); 
		query.append("						WHERE M.BKG_NO = D.BKG_NO AND M.IO_BND_CD = D.IO_BND_CD AND M.RHQ_CD = D.RHQ_CD AND D.TRSP_SO_TP_CD IN ('S','O')),0) X_INV_USD_AMT" ).append("\n"); 
		query.append("                , NVL(M.BKG_INLND_CHG_AMT,0) - NVL(M.GLINE_FRT_RT_AMT,0)        PL_GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append("                , NVL(M.BKG_INLND_CHG_AMT,0) - NVL(M.INLND_COST_USD_AMT,0)      PL_INLND_COST_USD_AMT" ).append("\n"); 
		query.append("                , NVL(M.BKG_INLND_CHG_AMT,0) - NVL(M.INLND_COST_TRSP_USD_AMT,0) PL_INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append("                , NVL(M.BKG_INLND_CHG_AMT,0) - NVL(M.INV_USD_AMT,0)             PL_INV_USD_AMT" ).append("\n"); 
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
		query.append("                , M.VSL_SLAN_CD" ).append("\n"); 
		query.append("                , TO_CHAR(M.CTRT_EFF_DT,'YYYY-MM-DD') CTRT_EFF_DT" ).append("\n"); 
		query.append("                , TO_CHAR(M.CTRT_EXP_DT,'YYYY-MM-DD') CTRT_EXP_DT" ).append("\n"); 
		query.append("                , TO_CHAR(M.RFA_AMDT_CRE_DT,'YYYY-MM-DD') RFA_AMDT_CRE_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM    AOC_EUR_INLND_PFIT_LSS M" ).append("\n"); 
		query.append("                , MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("            AND   CUST.CUST_CNT_CD = M.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("            AND   CUST.CUST_SEQ = M.CTRT_CUST_SEQ" ).append("\n"); 
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
		query.append("    #if (${r_view} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("                    AND     WO_OFC_CD <> 'AARBA'" ).append("\n"); 
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
		query.append("     #if (${s_pnl_tp} == 'A')" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("        )" ).append("\n"); 

	}
}