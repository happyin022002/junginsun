/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : USARailPerformanceDBDAOSearchENISInvRailPerformanceByLaneVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.02
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2017.02.02 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.usarailperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USARailPerformanceDBDAOSearchENISInvRailPerformanceByLaneVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchENISInvRailPerformance SELECT by Lane VVD
	  * </pre>
	  */
	public USARailPerformanceDBDAOSearchENISInvRailPerformanceByLaneVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("io_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_on",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_fm_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.usarailperformance.integration").append("\n"); 
		query.append("FileName : USARailPerformanceDBDAOSearchENISInvRailPerformanceByLaneVvdRSQL").append("\n"); 
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
		query.append("#if( ${loc_on} == 'L' )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' INV_CFM_YRMON," ).append("\n"); 
		query.append("'' WEEK," ).append("\n"); 
		query.append("TRSP_INV_CO_IND_CD," ).append("\n"); 
		query.append("INV_VNDR_SEQ      ," ).append("\n"); 
		query.append("INV_VNDR_ENG_NM," ).append("\n"); 
		query.append("CGO_TP_CD  ," ).append("\n"); 
		query.append("TRSP_BND_CD," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("AGMT_REF_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'' AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SLAN_CD  ," ).append("\n"); 
		query.append("VVD      ," ).append("\n"); 
		query.append("FM_NOD_CD," ).append("\n"); 
		query.append("TO_NOD_CD," ).append("\n"); 
		query.append("INV_CURR_CD," ).append("\n"); 
		query.append("SUM(VOL_20)  VOL_20," ).append("\n"); 
		query.append("SUM(LOC_AMT_20)  LOC_AMT_20," ).append("\n"); 
		query.append("SUM(USD_AMT_20) USD_AMT_20," ).append("\n"); 
		query.append("SUM(VOL_40)  VOL_40," ).append("\n"); 
		query.append("SUM(LOC_AMT_40)  LOC_AMT_40," ).append("\n"); 
		query.append("SUM(USD_AMT_40) USD_AMT_40," ).append("\n"); 
		query.append("SUM(VOL_40HC)  VOL_40HC," ).append("\n"); 
		query.append("SUM(LOC_AMT_40HC) LOC_AMT_40HC," ).append("\n"); 
		query.append("SUM(USD_AMT_40HC) USD_AMT_40HC," ).append("\n"); 
		query.append("SUM(VOL_40_HC)  VOL_40_HC," ).append("\n"); 
		query.append("SUM(LOC_AMT_40_HC) LOC_AMT_40_HC," ).append("\n"); 
		query.append("SUM(USD_AMT_40_HC) USD_AMT_40_HC," ).append("\n"); 
		query.append("SUM(VOL_45) VOL_45," ).append("\n"); 
		query.append("SUM(LOC_AMT_45) LOC_AMT_45," ).append("\n"); 
		query.append("SUM(USD_AMT_45) USD_AMT_45," ).append("\n"); 
		query.append("SUM(TOT_VOL) TOT_VOL," ).append("\n"); 
		query.append("SUM(TOT_LOC_AMT) TOT_LOC_AMT," ).append("\n"); 
		query.append("SUM(TOT_USD_AMT) TOT_USD_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      INV_CFM_YRMON     ," ).append("\n"); 
		query.append("      WEEK WEEK," ).append("\n"); 
		query.append("      TRSP_INV_CO_IND_CD," ).append("\n"); 
		query.append("      INV_VNDR_SEQ      ," ).append("\n"); 
		query.append("      TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(INV_VNDR_SEQ) INV_VNDR_ENG_NM," ).append("\n"); 
		query.append("      DECODE(CGO_TP_CD  , 'F', 'Full', 'M', 'Empty', CGO_TP_CD  ) CGO_TP_CD," ).append("\n"); 
		query.append("      DECODE(TRSP_BND_CD, 'I', 'In'  , 'O', 'Out'  , TRSP_BND_CD) TRSP_BND_CD," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("	  AGMT_REF_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  '' AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	  SLAN_CD  ," ).append("\n"); 
		query.append("      VVD      ," ).append("\n"); 
		query.append("      FM_NOD_CD," ).append("\n"); 
		query.append("      TO_NOD_CD," ).append("\n"); 
		query.append("      INV_CURR_CD," ).append("\n"); 
		query.append("      SUM(CNTR_20_CNT)  VOL_20," ).append("\n"); 
		query.append("      SUM(CNTR_20_AMT)  LOC_AMT_20," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_20_AMT), INV_CFM_YRMON),2) USD_AMT_20," ).append("\n"); 
		query.append("      SUM(CNTR_40_CNT)  VOL_40," ).append("\n"); 
		query.append("      SUM(CNTR_40_AMT)  LOC_AMT_40," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_40_AMT), INV_CFM_YRMON),2) USD_AMT_40," ).append("\n"); 
		query.append("      SUM(CNTR_40HC_CNT)  VOL_40HC," ).append("\n"); 
		query.append("      SUM(CNTR_40HC_AMT)  LOC_AMT_40HC," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_40HC_AMT), INV_CFM_YRMON),2) USD_AMT_40HC," ).append("\n"); 
		query.append("      SUM(CNTR_40_CNT) + SUM(CNTR_40HC_CNT) VOL_40_HC," ).append("\n"); 
		query.append("      SUM(CNTR_40_AMT) + SUM(CNTR_40HC_AMT) LOC_AMT_40_HC," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_40_AMT), INV_CFM_YRMON),2) +" ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_40HC_AMT), INV_CFM_YRMON),2) USD_AMT_40_HC," ).append("\n"); 
		query.append("      SUM(CNTR_45_CNT) VOL_45," ).append("\n"); 
		query.append("      SUM(CNTR_45_AMT) LOC_AMT_45," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_45_AMT), INV_CFM_YRMON),2) USD_AMT_45," ).append("\n"); 
		query.append("      SUM(CNTR_20_CNT) + SUM(CNTR_40_CNT) + SUM(CNTR_40HC_CNT) + SUM(CNTR_45_CNT) TOT_VOL," ).append("\n"); 
		query.append("      SUM(CNTR_20_AMT) + SUM(CNTR_40_AMT) + SUM(CNTR_40HC_AMT) + SUM(CNTR_45_AMT) TOT_LOC_AMT," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_20_AMT), INV_CFM_YRMON),2) +" ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_45_AMT), INV_CFM_YRMON),2) +" ).append("\n"); 
		query.append("	  ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_40HC_AMT), INV_CFM_YRMON),2) +" ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(INV_CURR_CD,SUM(CNTR_40_AMT), INV_CFM_YRMON),2) TOT_USD_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("      SELECT /*+ USE_NL(XX YY) */ DISTINCT" ).append("\n"); 
		query.append("            TO_CHAR(X.INV_CFM_DT, 'YYYYMM') INV_CFM_YRMON," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("            '' WEEK," ).append("\n"); 
		query.append("#elseif( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("			X.WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            X.INV_VNDR_SEQ," ).append("\n"); 
		query.append("			Y.EQ_NO," ).append("\n"); 
		query.append("            NVL(Y.TRSP_INV_CO_IND_CD, 'None Rail Billing') COMPANY," ).append("\n"); 
		query.append("            XX.TRSP_BND_CD," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("			AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			XX.SLAN_CD," ).append("\n"); 
		query.append("            XX.VSL_CD||XX.SKD_VOY_NO||XX.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("            Y.CGO_TP_CD," ).append("\n"); 
		query.append("            DECODE(@[loc_on], 'L', SUBSTR(Y.FM_NOD_CD,1,5), Y.FM_NOD_CD) FM_NOD_CD," ).append("\n"); 
		query.append("            DECODE(@[loc_on], 'L', SUBSTR(Y.TO_NOD_CD,1,5), Y.TO_NOD_CD) TO_NOD_CD," ).append("\n"); 
		query.append("            LOCTO.LOC_CD," ).append("\n"); 
		query.append("            LOCTO.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("            LOCFM.LOC_CD," ).append("\n"); 
		query.append("            LOCFM.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("            X.INV_CURR_CD," ).append("\n"); 
		query.append("            DECODE(Y.TRSP_INV_CO_IND_CD, null, DECODE(Y.TRSP_SO_OFC_CTY_CD, null, 'Invoice Only','SML'), 'NIS', 'SML',Y.TRSP_INV_CO_IND_CD) TRSP_INV_CO_IND_CD," ).append("\n"); 
		query.append("            DECODE(SUBSTR(Y.EQ_TPSZ_CD,2,1), '2', 1, 0)               CNTR_20_CNT," ).append("\n"); 
		query.append("            DECODE(SUBSTR(Y.EQ_TPSZ_CD,2,1), '2', Y.INV_BZC_AMT, 0)   CNTR_20_AMT," ).append("\n"); 
		query.append("            DECODE(SUBSTR(Y.EQ_TPSZ_CD,2,1), '4', 1, 0)               CNTR_40_CNT," ).append("\n"); 
		query.append("            DECODE(SUBSTR(Y.EQ_TPSZ_CD,2,1), '4', Y.INV_BZC_AMT, 0)   CNTR_40_AMT," ).append("\n"); 
		query.append("            DECODE(SUBSTR(Y.EQ_TPSZ_CD,2,1), '5', 1, 0)               CNTR_40HC_CNT," ).append("\n"); 
		query.append("            DECODE(SUBSTR(Y.EQ_TPSZ_CD,2,1), '5', Y.INV_BZC_AMT, 0)   CNTR_40HC_AMT," ).append("\n"); 
		query.append("            DECODE( Y.EQ_TPSZ_CD, 'D7', 1, 0)   CNTR_45_CNT," ).append("\n"); 
		query.append("            DECODE( Y.EQ_TPSZ_CD, 'D7', Y.INV_BZC_AMT ,0 )     CNTR_45_AMT" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("            TRS_TRSP_RAIL_INV_WRK       X," ).append("\n"); 
		query.append("#elseif( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("			  (SELECT INV_NO, INV_VNDR_SEQ, INV_CURR_CD,INV_CFM_DT" ).append("\n"); 
		query.append("					--, TO_CHAR(TRUNC(INV_CFM_DT,'DY'),'WW') WEEK" ).append("\n"); 
		query.append("                    ,B.COST_WK WEEK" ).append("\n"); 
		query.append("				FROM TRS_TRSP_RAIL_INV_WRK A" ).append("\n"); 
		query.append("                    ,MAS_WK_PRD B" ).append("\n"); 
		query.append("                WHERE A.INV_CFM_DT BETWEEN TO_DATE(B.SLS_FM_DT,'YYYYMMDD') AND TO_DATE(B.SLS_TO_DT,'YYYYMMDD')+0.99999)   X," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            TRS_TRSP_RAIL_INV_DTL    Y," ).append("\n"); 
		query.append("            TRS_TRSP_RAIL_BIL_ORD   XX," ).append("\n"); 
		query.append("            (SELECT LOC_CD, EQ_CTRL_OFC_CD FROM MDM_LOCATION ) LOCTO," ).append("\n"); 
		query.append("            (SELECT LOC_CD, EQ_CTRL_OFC_CD FROM MDM_LOCATION ) LOCFM," ).append("\n"); 
		query.append("			TRS_TRSP_RAIL_BIL_VNDR_SET VNDR," ).append("\n"); 
		query.append("			TRS_AGMT_HDR AH -- add Agmt. Ref. No. " ).append("\n"); 
		query.append("      WHERE 1 = 1" ).append("\n"); 
		query.append("      AND   X.INV_NO             = Y.INV_NO" ).append("\n"); 
		query.append("      AND   X.INV_VNDR_SEQ       = Y.INV_VNDR_SEQ" ).append("\n"); 
		query.append("      AND   Y.TRSP_SO_OFC_CTY_CD = XX.TRSP_SO_OFC_CTY_CD (+)" ).append("\n"); 
		query.append("      AND   Y.TRSP_SO_SEQ        = XX.TRSP_SO_SEQ        (+)" ).append("\n"); 
		query.append("      AND   Y.PAY_FLG            = 'Y'" ).append("\n"); 
		query.append("      AND   LOCTO.LOC_CD = SUBSTR(Y.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("      AND   LOCFM.LOC_CD = SUBSTR(Y.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("      AND   Y.TRSP_SO_OFC_CTY_CD = VNDR.TRSP_SO_OFC_CTY_CD(+) -- add Agmt. Ref. No. " ).append("\n"); 
		query.append("      AND   Y.TRSP_SO_SEQ       = VNDR.TRSP_SO_SEQ(+) -- add Agmt. Ref. No. " ).append("\n"); 
		query.append("      AND   VNDR.TRSP_AGMT_OFC_CTY_CD = AH.TRSP_AGMT_OFC_CTY_CD(+) -- add Agmt. Ref. No. " ).append("\n"); 
		query.append("      AND   VNDR.TRSP_AGMT_SEQ = AH.TRSP_AGMT_SEQ(+) -- add Agmt. Ref. No. " ).append("\n"); 
		query.append("#if ( ${agmt_ref_no} != '' )" ).append("\n"); 
		query.append("	AND AH.AGMT_REF_NO = @[agmt_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${vndr_seq} != '' )" ).append("\n"); 
		query.append("      AND   X.INV_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cgo_tp_cd} != 'A' )" ).append("\n"); 
		query.append("	#if ( ${cgo_tp_cd} != 'X')" ).append("\n"); 
		query.append("      AND   Y.CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("      AND   (XX.TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("             OR Y.CGO_TP_CD = 'M')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${io_bound} != 'A' )" ).append("\n"); 
		query.append("	#if ( ${cgo_tp_cd} != 'X')" ).append("\n"); 
		query.append("      AND   XX.TRSP_BND_CD = @[io_bound]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${ctrl_ofc} != '' )" ).append("\n"); 
		query.append("      AND   DECODE(XX.TRSP_BND_CD , 'I',  LOCTO.EQ_CTRL_OFC_CD, 'O', LOCFM.EQ_CTRL_OFC_CD , LOCFM.EQ_CTRL_OFC_CD) =  @[ctrl_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_node_length} == '7')" ).append("\n"); 
		query.append("      AND   Y.FM_NOD_CD = @[input_fm_node]" ).append("\n"); 
		query.append("#elseif (${fm_node_length} == '5')" ).append("\n"); 
		query.append("      AND   Y.FM_NOD_CD LIKE @[input_fm_node] || '%'" ).append("\n"); 
		query.append("#elseif (${fm_node_length} != '0')" ).append("\n"); 
		query.append("      AND   Y.FM_NOD_CD LIKE @[input_fm_node] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${to_node_length} == '7')" ).append("\n"); 
		query.append("	    AND   Y.TO_NOD_CD = @[input_to_node]" ).append("\n"); 
		query.append("#elseif (${to_node_length} == '5')" ).append("\n"); 
		query.append("	    AND   Y.TO_NOD_CD LIKE @[input_to_node] || '%'" ).append("\n"); 
		query.append("#elseif (${to_node_length} != '0')" ).append("\n"); 
		query.append("	    AND   Y.TO_NOD_CD LIKE @[input_to_node] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${fm_month} != '' && ${to_month} != '')" ).append("\n"); 
		query.append("      AND X.INV_CFM_DT  BETWEEN TO_DATE(@[fm_month],'YYYYMMDD') AND TO_DATE(@[to_month],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${comp_cd} != 'A' )" ).append("\n"); 
		query.append("    #if ( ${comp_cd} == 'I' )" ).append("\n"); 
		query.append("     AND   Y.CRNT_TRSP_RAIL_INV_AUD_CD = 'I'    " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cntr_tpsz} != '' )" ).append("\n"); 
		query.append("      AND Y.EQ_TPSZ_CD IN (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                            WHERE INTG_CD_ID = 'CD01860'" ).append("\n"); 
		query.append("                              AND (INSTR(@[cntr_tpsz], INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("                               OR @[cntr_tpsz] = 'ALL'" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ORDER BY" ).append("\n"); 
		query.append("              TO_CHAR(X.INV_CFM_DT, 'YYYYMM')   ASC," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("		      X.WEEK                            ASC," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              Y.FM_NOD_CD                       ASC," ).append("\n"); 
		query.append("              Y.TO_NOD_CD                       ASC," ).append("\n"); 
		query.append("              Y.CGO_TP_CD                       ASC" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if ( ${comp_cd} != 'A' )" ).append("\n"); 
		query.append("    #if ( ${comp_cd} == 'H' )" ).append("\n"); 
		query.append("     AND   TRSP_INV_CO_IND_CD = 'HJS'" ).append("\n"); 
		query.append("    #elseif ( ${comp_cd} == 'T' )" ).append("\n"); 
		query.append("     AND   TRSP_INV_CO_IND_CD = 'DOM'" ).append("\n"); 
		query.append("	#elseif ( ${comp_cd} == 'S' )" ).append("\n"); 
		query.append("     AND   TRSP_INV_CO_IND_CD = 'SEN'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("        INV_CFM_YRMON," ).append("\n"); 
		query.append("		WEEK," ).append("\n"); 
		query.append("        INV_VNDR_SEQ ," ).append("\n"); 
		query.append("        TRSP_BND_CD  ," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("		AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		SLAN_CD		 ," ).append("\n"); 
		query.append("        VVD          ," ).append("\n"); 
		query.append("        CGO_TP_CD    ," ).append("\n"); 
		query.append("        FM_NOD_CD    ," ).append("\n"); 
		query.append("        TO_NOD_CD    ," ).append("\n"); 
		query.append("        INV_CURR_CD  ," ).append("\n"); 
		query.append("        TRSP_INV_CO_IND_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        INV_CFM_YRMON," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("		WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        TRSP_INV_CO_IND_CD," ).append("\n"); 
		query.append("        INV_VNDR_SEQ ," ).append("\n"); 
		query.append("        TRSP_BND_CD  ," ).append("\n"); 
		query.append("        CGO_TP_CD    ," ).append("\n"); 
		query.append("        FM_NOD_CD    ," ).append("\n"); 
		query.append("        TO_NOD_CD" ).append("\n"); 
		query.append("#if( ${loc_on} == 'L' )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("        INV_VNDR_SEQ ," ).append("\n"); 
		query.append("        TRSP_BND_CD  ," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("		AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		SLAN_CD		 ," ).append("\n"); 
		query.append("        VVD          ," ).append("\n"); 
		query.append("		INV_VNDR_ENG_NM," ).append("\n"); 
		query.append("        CGO_TP_CD    ," ).append("\n"); 
		query.append("        FM_NOD_CD    ," ).append("\n"); 
		query.append("        TO_NOD_CD    ," ).append("\n"); 
		query.append("        INV_CURR_CD  ," ).append("\n"); 
		query.append("        TRSP_INV_CO_IND_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        TRSP_INV_CO_IND_CD," ).append("\n"); 
		query.append("        INV_VNDR_SEQ ," ).append("\n"); 
		query.append("        TRSP_BND_CD  ," ).append("\n"); 
		query.append("        CGO_TP_CD    ," ).append("\n"); 
		query.append("        FM_NOD_CD    ," ).append("\n"); 
		query.append("        TO_NOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}