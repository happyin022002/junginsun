/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrnsModCompDBDAOsearchTrnsModCompRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.transmodecomp.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrnsModCompDBDAOsearchTrnsModCompRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland Transmode Comparison 를 조회한다.
	  * </pre>
	  */
	public TrnsModCompDBDAOsearchTrnsModCompRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_bkg_trns_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_so_trns_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_fm_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_door_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_wo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_via_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.transmodecomp.integration").append("\n"); 
		query.append("FileName : TrnsModCompDBDAOsearchTrnsModCompRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN Y.SO_TRNS_MOD = Y.CHG_TRNS_MOD THEN 'Match'" ).append("\n"); 
		query.append("       ELSE 'Mismatch'" ).append("\n"); 
		query.append("       END COMP_RESULT" ).append("\n"); 
		query.append("      ,CASE WHEN NVL(Y.SO_TOT_AMT, 0) = 0 OR (CHG_CD IS NULL AND RAT_UT_CD IS NULL) THEN 'Unqualified'" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("        CASE WHEN NVL(Y.CHG_RT_USD, 0) > NVL(Y.SO_TOT_AMT_USD, 0) THEN 'Profit'" ).append("\n"); 
		query.append("         WHEN NVL(Y.CHG_RT_USD, 0) = NVL(Y.SO_TOT_AMT_USD, 0) THEN 'Same'" ).append("\n"); 
		query.append("         WHEN NVL(Y.CHG_RT_USD, 0) < NVL(Y.SO_TOT_AMT_USD, 0) THEN 'Loss'" ).append("\n"); 
		query.append("        ELSE 'Unqualified' END" ).append("\n"); 
		query.append("       END INLAND_PNL" ).append("\n"); 
		query.append("      , Y.SO_NO, Y.TRSP_BND_CD, Y.TRSP_COST_DTL_MOD_CD, Y.FM_NOD_CD, Y.VIA_NOD_CD, Y.TO_NOD_CD, Y.DOR_NOD_CD" ).append("\n"); 
		query.append("      , Y.SO_OFC_CD, Y.SO_CRE_DT, Y.WO_OFC_CD, Y.WO_NO, Y.WO_ISS_DT, Y.EQ_NO, Y.EQ_TPSZ_CD, Y.BKG_NO, Y.SO_TRNS_MOD" ).append("\n"); 
		query.append("      , Y.SO_CURR_CD, Y.SO_TOT_AMT, Y.SO_TOT_AMT_USD, Y.SO_BKG_SUM_USD, Y.TRO_TRNS_MOD, Y.TRO_OFC_CD, Y.TRO_CNFM" ).append("\n"); 
		query.append("      , Y.CHG_CD, Y.CHG_TRNS_MOD, Y.CHG_CURR_CD, DECODE(Y.CHG_CD, NULL, '', TO_CHAR(Y.CHG_UT_AMT, '999,999,999,999.99')) CHG_UT_AMT" ).append("\n"); 
		query.append("      , DECODE(Y.CHG_CD, NULL, '', TO_CHAR(Y.CHG_RT_USD, '999,999,999,999.99')) CHG_RT_USD, TO_CHAR(Y.RAT_AS_QTY, '999,999,999,999.999') RAT_AS_QTY, Y.RAT_UT_CD" ).append("\n"); 
		query.append("      , DECODE(Y.CHG_CD, NULL, '', TO_CHAR(Y.CHG_AMT, '999,999,999,999.99')) CHG_AMT" ).append("\n"); 
		query.append("      , DECODE(Y.CHG_CD, NULL, '', TO_CHAR(Y.CHG_AMT_USD, '999,999,999,999.99')) CHG_AMT_USD, Y.ROW_CNT, Y.INCL_OFT_FLG, Y.AUTO_RAT_CD, Y.IHC_SUM_USD, Y.RFA_NO, Y.SC_NO, Y.TAA_NO, Y.CNG_RSN_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT X.SO_NO,X.TRSP_BND_CD,X.TRSP_COST_DTL_MOD_CD,X.FM_NOD_CD,X.VIA_NOD_CD,X.TO_NOD_CD,X.DOR_NOD_CD,X.SO_OFC_CD,X.SO_CRE_DT" ).append("\n"); 
		query.append("      ,X.WO_OFC_CD,X.WO_NO,X.WO_ISS_DT,X.EQ_NO,X.EQ_TPSZ_CD,X.BKG_NO,X.SO_TRNS_MOD,X.SO_CURR_CD,X.SO_TOT_AMT,X.SO_TOT_AMT_USD" ).append("\n"); 
		query.append("      ,SUM(X.SO_TOT_AMT_USD) OVER (PARTITION BY X.BKG_NO, X.TRSP_BND_CD, X.CHG_CD, X.CHG_CURR_CD, X.CHG_UT_AMT, X.RAT_AS_QTY, X.RAT_UT_CD, X.CHG_AMT, X.INCL_OFT_FLG, X.AUTO_RAT_CD) SO_BKG_SUM_USD" ).append("\n"); 
		query.append("      ,X.TRO_TRNS_MOD,X.TRO_OFC_CD,X.TRO_CNFM,X.CHG_CD,X.CHG_TRNS_MOD,X.CHG_CURR_CD,X.CHG_UT_AMT,X.CHG_RT_USD" ).append("\n"); 
		query.append("      ,X.RAT_AS_QTY,X.RAT_UT_CD,X.CHG_AMT,X.CHG_AMT_USD,X.ROW_CNT,X.INCL_OFT_FLG,X.AUTO_RAT_CD" ).append("\n"); 
		query.append("      ,DECODE(X.CHG_CD,NULL,''," ).append("\n"); 
		query.append("              SUM(X.CHG_AMT_USD) OVER (PARTITION BY X.SO_NO, X.TRSP_BND_CD)) IHC_SUM_USD" ).append("\n"); 
		query.append("      ,X.RFA_NO,X.SC_NO,X.TAA_NO,X.CNG_RSN_DESC" ).append("\n"); 
		query.append("      ,X.EQ_TP1" ).append("\n"); 
		query.append("      ,ROW_NUMBER() OVER (PARTITION BY X.SO_NO ORDER BY X.SO_NO, X.EQ_TP1 desc) RON" ).append("\n"); 
		query.append("      ,LENGTH(X.EQ_TP1) AS LEN_TP1" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SO.TRSP_SO_OFC_CTY_CD||SO.TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("      ,SO.TRSP_BND_CD" ).append("\n"); 
		query.append("      ,SO.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("      ,SO.FM_NOD_CD" ).append("\n"); 
		query.append("      ,SO.VIA_NOD_CD" ).append("\n"); 
		query.append("      ,SO.TO_NOD_CD" ).append("\n"); 
		query.append("      ,SO.DOR_NOD_CD" ).append("\n"); 
		query.append("      ,SO.CRE_OFC_CD AS SO_OFC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(SO.LOCL_CRE_DT,'YYYY-MM-DD') AS SO_CRE_DT" ).append("\n"); 
		query.append("      ,WO.CRE_OFC_CD AS WO_OFC_CD" ).append("\n"); 
		query.append("      ,SO.TRSP_WO_OFC_CTY_CD||SO.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(WO.LOCL_CRE_DT,'YYYY-MM-DD') AS WO_ISS_DT" ).append("\n"); 
		query.append("      ,SO.EQ_NO" ).append("\n"); 
		query.append("      ,SO.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,SO.BKG_NO" ).append("\n"); 
		query.append("      ,SO.TRSP_CRR_MOD_CD AS SO_TRNS_MOD" ).append("\n"); 
		query.append("      ,SO.CURR_CD AS SO_CURR_CD" ).append("\n"); 
		query.append("      ,SO.BZC_AMT + NVL (SO.FUEL_SCG_AMT, 0)+ NVL (SO.SCG_VAT_AMT, 0) + NVL (SO.NEGO_AMT, 0) + NVL (SO.ETC_ADD_AMT, 0)+NVL (SO.HJL_HNDL_AMT, 0) AS SO_TOT_AMT      " ).append("\n"); 
		query.append("      ,ROUND ((NVL (SO.BZC_AMT, 0) + NVL (SO.FUEL_SCG_AMT, 0) + NVL (SO.NEGO_AMT, 0) + NVL (SO.ETC_ADD_AMT, 0) + NVL (SO.HJL_HNDL_AMT, 0) + NVL (SO.SCG_VAT_AMT, 0)) / " ).append("\n"); 
		query.append("						 CASE WHEN NVL(SO.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("						 ELSE	" ).append("\n"); 
		query.append("                         (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                            FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("             		         WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("			                   AND XCH.CURR_CD           = SO.CURR_CD" ).append("\n"); 
		query.append("			                   AND XCH.ACCT_XCH_RT_YRMON = NVL(TO_CHAR(WO.LOCL_CRE_DT,'YYYYMM'),TO_CHAR (SO.LOCL_CRE_DT, 'YYYYMM')))" ).append("\n"); 
		query.append("					     END" ).append("\n"); 
		query.append("							   , 2) SO_TOT_AMT_USD" ).append("\n"); 
		query.append("      ,DECODE (SO.TRSP_COST_DTL_MOD_CD,'DR'" ).append("\n"); 
		query.append("               ,(SELECT DECODE(SO.TRSP_BND_CD,'O', DECODE(TRO.BKG_TRSP_MZD_CD,'T','TD','R','RD','B','WD','A','TR','U','TW','E','TF')" ).append("\n"); 
		query.append("                              ,'I',DECODE(TRO.BKG_TRSP_MZD_CD,'T','TD','R','RD','B','WD','A','RT','U','WT','E','FT'))" ).append("\n"); 
		query.append("                   FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("                  WHERE TRO.BKG_NO = SO.BKG_NO AND TRO.IO_BND_CD = SO.TRSP_BND_CD AND TRO.TRO_SEQ = SO.TRO_SEQ)" ).append("\n"); 
		query.append("               ,'') TRO_TRNS_MOD" ).append("\n"); 
		query.append("      ,DECODE(SO.TRSP_COST_DTL_MOD_CD,'DR'" ).append("\n"); 
		query.append("               ,(SELECT CFM_OFC_CD FROM BKG_EUR_TRO TRO WHERE TRO.BKG_NO = SO.BKG_NO AND TRO.IO_BND_CD = SO.TRSP_BND_CD AND TRO.TRO_SEQ = SO.TRO_SEQ)" ).append("\n"); 
		query.append("               ,'') TRO_OFC_CD" ).append("\n"); 
		query.append("      ,DECODE(SO.TRSP_COST_DTL_MOD_CD,'DR'" ).append("\n"); 
		query.append("               , DECODE (NVL (SO.TRO_SEQ, ''),'', 'No','Yes')" ).append("\n"); 
		query.append("               ,'') TRO_CNFM" ).append("\n"); 
		query.append("      ,DECODE(SO.TRSP_BND_CD,'O'" ).append("\n"); 
		query.append("               ,DECODE(BKG.ORG_TRNS_MOD_CD,'T','TD','R','RD','B','WD','A','TR','U','TW','E','TF','F','F','FT','FT')" ).append("\n"); 
		query.append("               ,'I',DECODE(BKG.DEST_TRNS_MOD_CD,'T','TD','R','RD','B','WD','A','RT','U','WT','E','FT','F','F','FT','FT')" ).append("\n"); 
		query.append("               ,'') CHG_TRNS_MOD" ).append("\n"); 
		query.append("      ,CH.CHG_CD" ).append("\n"); 
		query.append("      ,CH.CURR_CD AS CHG_CURR_CD" ).append("\n"); 
		query.append("      ,CH.CHG_UT_AMT" ).append("\n"); 
		query.append("      ,ROUND ((NVL (CH.CHG_UT_AMT, 0)) / " ).append("\n"); 
		query.append("						 CASE WHEN NVL(CH.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("						 ELSE	" ).append("\n"); 
		query.append("                         (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                            FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("             		         WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("			                   AND XCH.CURR_CD           = CH.CURR_CD" ).append("\n"); 
		query.append("			                   AND XCH.ACCT_XCH_RT_YRMON = NVL(TO_CHAR(WO.LOCL_CRE_DT,'YYYYMM'),TO_CHAR (SO.LOCL_CRE_DT, 'YYYYMM')))" ).append("\n"); 
		query.append("					     END" ).append("\n"); 
		query.append("							   , 2) CHG_RT_USD" ).append("\n"); 
		query.append("      ,CH.RAT_AS_QTY" ).append("\n"); 
		query.append("      ,CH.RAT_UT_CD" ).append("\n"); 
		query.append("      ,CH.CHG_AMT" ).append("\n"); 
		query.append("      ,ROUND ((NVL (CH.CHG_AMT, 0)) / " ).append("\n"); 
		query.append("						 CASE WHEN NVL(CH.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("						 ELSE	" ).append("\n"); 
		query.append("                         (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                            FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("             		         WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("			                   AND XCH.CURR_CD           = CH.CURR_CD" ).append("\n"); 
		query.append("			                   AND XCH.ACCT_XCH_RT_YRMON = NVL(TO_CHAR(WO.LOCL_CRE_DT,'YYYYMM'),TO_CHAR (SO.LOCL_CRE_DT, 'YYYYMM')))" ).append("\n"); 
		query.append("					     END" ).append("\n"); 
		query.append("							   , 2) CHG_AMT_USD" ).append("\n"); 
		query.append("      ,DECODE(CH.CHG_CD,NULL,''," ).append("\n"); 
		query.append("              COUNT(*) OVER (PARTITION BY SO.TRSP_SO_OFC_CTY_CD, SO.TRSP_SO_SEQ, CH.CHG_CD, CH.CURR_CD, CH.CHG_UT_AMT, CH.RAT_AS_QTY, CH.RAT_UT_CD, CH.CHG_AMT, CH.FRT_INCL_XCLD_DIV_CD, CH.AUTO_RAT_CD)) ROW_CNT" ).append("\n"); 
		query.append("      ,CH.FRT_INCL_XCLD_DIV_CD AS INCL_OFT_FLG" ).append("\n"); 
		query.append("      ,CH.AUTO_RAT_CD" ).append("\n"); 
		query.append("      ,BKG.RFA_NO" ).append("\n"); 
		query.append("      ,BKG.SC_NO" ).append("\n"); 
		query.append("      ,BKG.TAA_NO" ).append("\n"); 
		query.append("      ,SO.CNG_RSN_DESC" ).append("\n"); 
		query.append("      ,RANK() OVER (PARTITION BY SO.TRSP_SO_OFC_CTY_CD, SO.TRSP_SO_SEQ ORDER BY DECODE(SUBSTR(CH.CHG_CD,2,2),'IH',1,'AR',2)) RANKING " ).append("\n"); 
		query.append("      ,DECODE(SO.EQ_TPSZ_CD, CH.RAT_UT_CD, SO.EQ_TPSZ_CD, (SELECT CNTR_SZ_CD FROM PRI_RAT_UT WHERE RAT_UT_CD = SO.EQ_TPSZ_CD)) AS EQ_TP1" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG INNER JOIN TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("       ON SO.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("       LEFT OUTER JOIN TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("       ON SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("       LEFT OUTER JOIN BKG_CHG_RT CH" ).append("\n"); 
		query.append("       ON SO.BKG_NO = CH.BKG_NO " ).append("\n"); 
		query.append("       AND (SELECT CNTR_SZ_CD FROM PRI_RAT_UT WHERE RAT_UT_CD = SO.EQ_TPSZ_CD) = (SELECT CNTR_SZ_CD FROM PRI_RAT_UT WHERE RAT_UT_CD = CH.RAT_UT_CD)" ).append("\n"); 
		query.append("       AND CH.CHG_CD IN ('OIH','DIH','OAR','DAR')" ).append("\n"); 
		query.append("       AND SUBSTR(CH.CHG_CD,1,1) = DECODE(SO.TRSP_BND_CD, 'O', 'O', 'I', 'D')" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND SO.TRSP_COST_DTL_MOD_CD IN ('CY','DR')" ).append("\n"); 
		query.append("   AND SO.TRSP_BND_CD IN ('I','O')" ).append("\n"); 
		query.append("#if(${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("   AND SO.LOCL_CRE_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''), 'rrrrmmddhh24') AND TO_DATE(REPLACE(@[to_date],'-',''),'rrrrmmddhh24')+0.99999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${input_office} != '')" ).append("\n"); 
		query.append("   AND SO.CRE_OFC_CD IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(@[input_office], ',')))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${io_bound} == 'A')" ).append("\n"); 
		query.append("   AND SO.TRSP_BND_CD IN ('I','O')" ).append("\n"); 
		query.append("#elseif(${io_bound} == 'I')" ).append("\n"); 
		query.append("   AND SO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("#elseif(${io_bound} == 'O')" ).append("\n"); 
		query.append("   AND SO.TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_wo} == 'I')" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_STS_CD NOT IN ('C','R')" ).append("\n"); 
		query.append("#elseif(${sel_wo} == 'N')" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_STS_CD IN ('C','R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_so_wo} == 'so')" ).append("\n"); 
		query.append("	#if(${so_wo_no} != '')" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_OFC_CTY_CD = SUBSTR(@[so_wo_no], 1, 3) AND SO.TRSP_SO_SEQ = SUBSTR(@[so_wo_no], 4)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif(${sel_so_wo} == 'wo')" ).append("\n"); 
		query.append("	#if(${so_wo_no} != '')" ).append("\n"); 
		query.append("   AND SO.TRSP_WO_OFC_CTY_CD = SUBSTR(@[so_wo_no], 1, 3) AND SO.TRSP_WO_SEQ = SUBSTR(@[so_wo_no], 4)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_ctrt_no} != '')" ).append("\n"); 
		query.append("   AND NVL(NVL(RFA_NO,SC_NO),TAA_NO) = @[sel_ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_bkg_no} != '')" ).append("\n"); 
		query.append("   AND SO.BKG_NO = @[sel_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_cntr_no} != '')" ).append("\n"); 
		query.append("   AND SO.EQ_NO = @[sel_cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_fm_node} != '')" ).append("\n"); 
		query.append("   AND SO.FM_NOD_CD LIKE @[search_fm_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_via_node} != '')" ).append("\n"); 
		query.append("   AND SO.VIA_NOD_CD LIKE @[search_via_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_to_node} != '')" ).append("\n"); 
		query.append("   AND SO.TO_NOD_CD LIKE @[search_to_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_door_node} != '')" ).append("\n"); 
		query.append("   AND SO.DOR_NOD_CD LIKE @[search_door_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${sel_so_trns_mod} != '' )" ).append("\n"); 
		query.append("   AND SO.TRSP_CRR_MOD_CD IN (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                               WHERE INTG_CD_ID = 'CD00794'" ).append("\n"); 
		query.append("                                 AND (INSTR(@[sel_so_trns_mod], INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("                                  OR @[sel_so_trns_mod] = 'ALL'" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND RANKING =1" ).append("\n"); 
		query.append("#if ( ${sel_bkg_trns_mod} != '' )" ).append("\n"); 
		query.append("   AND X.CHG_TRNS_MOD IN (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                               WHERE INTG_CD_ID = 'CD00794'" ).append("\n"); 
		query.append("                                 AND (INSTR(@[sel_bkg_trns_mod], INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("                                  OR @[sel_bkg_trns_mod] = 'ALL'" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("       X.SO_NO" ).append("\n"); 
		query.append("      ,X.TRSP_BND_CD" ).append("\n"); 
		query.append("      ,X.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("      ,X.FM_NOD_CD" ).append("\n"); 
		query.append("      ,X.VIA_NOD_CD" ).append("\n"); 
		query.append("      ,X.TO_NOD_CD" ).append("\n"); 
		query.append("      ,X.DOR_NOD_CD" ).append("\n"); 
		query.append("      ,X.SO_OFC_CD" ).append("\n"); 
		query.append("      ,X.SO_CRE_DT" ).append("\n"); 
		query.append("      ,X.WO_OFC_CD" ).append("\n"); 
		query.append("      ,X.WO_NO" ).append("\n"); 
		query.append("      ,X.WO_ISS_DT" ).append("\n"); 
		query.append("      ,X.EQ_NO" ).append("\n"); 
		query.append("      ,X.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,X.BKG_NO" ).append("\n"); 
		query.append("      ,X.SO_TRNS_MOD" ).append("\n"); 
		query.append("      ,X.SO_CURR_CD" ).append("\n"); 
		query.append("      ,X.SO_TOT_AMT" ).append("\n"); 
		query.append("      ,X.SO_TOT_AMT_USD" ).append("\n"); 
		query.append("      ,X.TRO_TRNS_MOD" ).append("\n"); 
		query.append("      ,X.TRO_OFC_CD" ).append("\n"); 
		query.append("      ,X.TRO_CNFM" ).append("\n"); 
		query.append("      ,X.CHG_CD" ).append("\n"); 
		query.append("      ,X.CHG_TRNS_MOD" ).append("\n"); 
		query.append("      ,X.CHG_CURR_CD" ).append("\n"); 
		query.append("      ,X.CHG_UT_AMT" ).append("\n"); 
		query.append("      ,X.CHG_RT_USD" ).append("\n"); 
		query.append("      ,X.RAT_AS_QTY" ).append("\n"); 
		query.append("      ,X.RAT_UT_CD" ).append("\n"); 
		query.append("      ,X.CHG_AMT" ).append("\n"); 
		query.append("      ,X.CHG_AMT_USD" ).append("\n"); 
		query.append("      ,X.ROW_CNT" ).append("\n"); 
		query.append("      ,X.INCL_OFT_FLG" ).append("\n"); 
		query.append("      ,X.AUTO_RAT_CD" ).append("\n"); 
		query.append("      ,X.RFA_NO" ).append("\n"); 
		query.append("      ,X.SC_NO" ).append("\n"); 
		query.append("      ,X.TAA_NO" ).append("\n"); 
		query.append("      ,X.CNG_RSN_DESC" ).append("\n"); 
		query.append("      ,X.EQ_TP1" ).append("\n"); 
		query.append("ORDER BY X.SO_OFC_CD" ).append("\n"); 
		query.append("        ,X.BKG_NO" ).append("\n"); 
		query.append("        ,X.SO_NO" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND (Y.RON = 1 OR Y.LEN_TP1 = 2)" ).append("\n"); 
		query.append("#if(${sel_result} == 'M')" ).append("\n"); 
		query.append("   AND Y.SO_TRNS_MOD = Y.CHG_TRNS_MOD" ).append("\n"); 
		query.append("#elseif(${sel_result} == 'I')" ).append("\n"); 
		query.append("   AND Y.SO_TRNS_MOD <> Y.CHG_TRNS_MOD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_pnl} == 'P')" ).append("\n"); 
		query.append("   AND NVL(Y.CHG_RT_USD, 0) > NVL(Y.SO_TOT_AMT_USD, 0)" ).append("\n"); 
		query.append("#elseif(${sel_pnl} == 'S')" ).append("\n"); 
		query.append("   AND NVL(Y.CHG_RT_USD, 0) = NVL(Y.SO_TOT_AMT_USD, 0)" ).append("\n"); 
		query.append("#elseif(${sel_pnl} == 'L')" ).append("\n"); 
		query.append("   AND NVL(Y.CHG_RT_USD, 0) < NVL(Y.SO_TOT_AMT_USD, 0)" ).append("\n"); 
		query.append("#elseif(${sel_pnl} == 'U')" ).append("\n"); 
		query.append("   AND NVL(Y.SO_TOT_AMT, 0) = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY Y.BKG_NO, Y.SO_NO, Y.RON" ).append("\n"); 

	}
}