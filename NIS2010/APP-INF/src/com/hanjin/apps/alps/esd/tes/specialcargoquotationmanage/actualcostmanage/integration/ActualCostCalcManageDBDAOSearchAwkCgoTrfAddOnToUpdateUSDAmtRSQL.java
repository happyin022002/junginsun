/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualCostCalcManageDBDAOSearchAwkCgoTrfAddOnToUpdateUSDAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCalcManageDBDAOSearchAwkCgoTrfAddOnToUpdateUSDAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상 조회
	  * </pre>
	  */
	public ActualCostCalcManageDBDAOSearchAwkCgoTrfAddOnToUpdateUSDAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCalcManageDBDAOSearchAwkCgoTrfAddOnToUpdateUSDAmtRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'A' TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", P.FM_LOC_CD" ).append("\n"); 
		query.append(", P.FM_NOD_YD_NO" ).append("\n"); 
		query.append(", P.TO_LOC_CD" ).append("\n"); 
		query.append(", P.TO_NOD_YD_NO" ).append("\n"); 
		query.append(", P.COND_NO" ).append("\n"); 
		query.append(", P.TML_AWK_ADON_VER_NO" ).append("\n"); 
		query.append(", P.CHK_DIFF_MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", P.CHK_DIFF_MAN_USD_AMT_40FT" ).append("\n"); 
		query.append(", P.MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", P.MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", P.MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", P.MAN_USD_AMT_20FT MAN_USD_AMT_20FT_OLD" ).append("\n"); 
		query.append(", P.MAN_USD_AMT_40FT MAN_USD_AMT_40FT_OLD" ).append("\n"); 
		query.append(", P.MAN_USD_AMT_20FT_NEW" ).append("\n"); 
		query.append(", P.MAN_USD_AMT_40FT_NEW" ).append("\n"); 
		query.append(", DECODE(P.CHK_DIFF_MAN_USD_AMT_20FT,'Y',P.MAN_USD_AMT_20FT_NEW,P.MAN_USD_AMT_20FT) MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", DECODE(P.CHK_DIFF_MAN_USD_AMT_40FT,'Y',P.MAN_USD_AMT_40FT_NEW,P.MAN_USD_AMT_40FT) MAN_USD_AMT_40FT" ).append("\n"); 
		query.append(", TO_CHAR(SYSDATE,'YYYYMM') USD_XCH_DT" ).append("\n"); 
		query.append(", P.VNDR_SEQ" ).append("\n"); 
		query.append(", P.VNDR_NM" ).append("\n"); 
		query.append(", P.CALC_RMK" ).append("\n"); 
		query.append(", P.LST_UPD_USR_ID" ).append("\n"); 
		query.append(", P.CRE_USR_ID" ).append("\n"); 
		query.append(", P.CRE_DT" ).append("\n"); 
		query.append(", P.UPD_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.MAN_LOCL_CURR_CD IS NOT NULL AND NVL(X.MAN_LOCL_AMT_20FT,0) <> 0 AND NVL(X.MAN_USD_AMT_20FT,0) <> 0 AND NVL(TES_GET_USD_XCH_AMT_FNC(X.MAN_LOCL_CURR_CD,X.MAN_LOCL_AMT_20FT),0) <> NVL(X.MAN_USD_AMT_20FT,0)" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_DIFF_MAN_USD_AMT_20FT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.MAN_LOCL_CURR_CD IS NOT NULL AND NVL(X.MAN_LOCL_AMT_40FT,0) <> 0 AND NVL(X.MAN_USD_AMT_40FT,0) <> 0 AND NVL(TES_GET_USD_XCH_AMT_FNC(X.MAN_LOCL_CURR_CD,X.MAN_LOCL_AMT_40FT),0) <> NVL(X.MAN_USD_AMT_40FT,0)" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_DIFF_MAN_USD_AMT_40FT," ).append("\n"); 
		query.append("AH.FM_LOC_CD ," ).append("\n"); 
		query.append("AH.FM_NOD_YD_NO ," ).append("\n"); 
		query.append("AH.TO_LOC_CD ," ).append("\n"); 
		query.append("AH.TO_NOD_YD_NO ," ).append("\n"); 
		query.append("AH.COND_NO ," ).append("\n"); 
		query.append("AH.TML_AWK_ADON_VER_NO ," ).append("\n"); 
		query.append("X.MAN_LOCL_CURR_CD ," ).append("\n"); 
		query.append("X.MAN_LOCL_AMT_20FT ," ).append("\n"); 
		query.append("X.MAN_LOCL_AMT_40FT ," ).append("\n"); 
		query.append("X.MAN_USD_AMT_20FT ," ).append("\n"); 
		query.append("X.MAN_USD_AMT_40FT ," ).append("\n"); 
		query.append("TES_GET_USD_XCH_AMT_FNC(X.MAN_LOCL_CURR_CD,X.MAN_LOCL_AMT_20FT) MAN_USD_AMT_20FT_NEW," ).append("\n"); 
		query.append("TES_GET_USD_XCH_AMT_FNC(X.MAN_LOCL_CURR_CD,X.MAN_LOCL_AMT_40FT) MAN_USD_AMT_40FT_NEW," ).append("\n"); 
		query.append("AH.VNDR_SEQ ," ).append("\n"); 
		query.append("AH.VNDR_NM ," ).append("\n"); 
		query.append("AH.CALC_RMK ," ).append("\n"); 
		query.append("AH.LST_UPD_USR_ID ," ).append("\n"); 
		query.append("AH.CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(AH.CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT," ).append("\n"); 
		query.append("AH.UPD_USR_ID" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR AH," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T.FM_LOC_CD," ).append("\n"); 
		query.append("T.FM_NOD_YD_NO," ).append("\n"); 
		query.append("T.TO_LOC_CD," ).append("\n"); 
		query.append("T.TO_NOD_YD_NO," ).append("\n"); 
		query.append("T.COND_NO," ).append("\n"); 
		query.append("MAX(T.TML_AWK_ADON_VER_NO) TML_AWK_ADON_VER_NO," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX(LOCL_CURR_CD) MAN_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX(DECODE(T.CNTR_SZ_CD, '2', T.LOCL_CURR_AMT, '')) MAN_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX(DECODE(T.CNTR_SZ_CD, '4', T.LOCL_CURR_AMT, '')) MAN_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (USD) **/" ).append("\n"); 
		query.append("MAX(DECODE(T.CNTR_SZ_CD, '2', T.USD_AMT, '')) MAN_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(DECODE(T.CNTR_SZ_CD, '4', T.USD_AMT, '')) MAN_USD_AMT_40FT" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR D, TES_AWK_CGO_ADON_TP_SZ T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.FM_LOC_CD = T.FM_LOC_CD" ).append("\n"); 
		query.append("AND D.FM_NOD_YD_NO = T.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND D.TO_LOC_CD = T.TO_LOC_CD" ).append("\n"); 
		query.append("AND D.TO_NOD_YD_NO = T.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND D.COND_NO = T.COND_NO" ).append("\n"); 
		query.append("AND D.TML_AWK_ADON_VER_NO = T.TML_AWK_ADON_VER_NO" ).append("\n"); 
		query.append("AND D.TML_AWK_ADON_VER_NO = (" ).append("\n"); 
		query.append("SELECT MAX(XD.TML_AWK_ADON_VER_NO)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR XD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND XD.FM_LOC_CD = T.FM_LOC_CD" ).append("\n"); 
		query.append("AND XD.FM_NOD_YD_NO = T.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND XD.TO_LOC_CD = T.TO_LOC_CD" ).append("\n"); 
		query.append("AND XD.TO_NOD_YD_NO = T.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND XD.COND_NO = T.COND_NO )" ).append("\n"); 
		query.append("GROUP BY T.FM_LOC_CD, T.FM_NOD_YD_NO, T.TO_LOC_CD, T.TO_NOD_YD_NO, T.COND_NO ) X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("--AND AH.FM_LOC_CD = 'DEHAM' --// test" ).append("\n"); 
		query.append("--AND AH.TO_LOC_CD = 'DKAAR' --// test" ).append("\n"); 
		query.append("AND AH.FM_LOC_CD = X.FM_LOC_CD" ).append("\n"); 
		query.append("AND AH.FM_NOD_YD_NO = X.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND AH.TO_LOC_CD = X.TO_LOC_CD" ).append("\n"); 
		query.append("AND AH.TO_NOD_YD_NO = X.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND AH.COND_NO = X.COND_NO" ).append("\n"); 
		query.append("AND AH.TML_AWK_ADON_VER_NO = (" ).append("\n"); 
		query.append("SELECT MAX(XD.TML_AWK_ADON_VER_NO)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR XD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND XD.FM_LOC_CD = AH.FM_LOC_CD" ).append("\n"); 
		query.append("AND XD.FM_NOD_YD_NO = AH.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND XD.TO_LOC_CD = AH.TO_LOC_CD" ).append("\n"); 
		query.append("AND XD.TO_NOD_YD_NO = AH.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND XD.COND_NO = AH.COND_NO )" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("WHEN P.CHK_DIFF_MAN_USD_AMT_20FT = 'Y' OR P.CHK_DIFF_MAN_USD_AMT_40FT = 'Y'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END = 'Y'" ).append("\n"); 
		query.append("ORDER BY P.FM_LOC_CD, P.FM_NOD_YD_NO, P.TO_LOC_CD, P.TO_NOD_YD_NO, P.COND_NO, P.TML_AWK_ADON_VER_NO DESC" ).append("\n"); 

	}
}