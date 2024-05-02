/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.08
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.05.08 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Awk Cargo Basic Tariff를 조회한다.
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_awk_cgo_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfRSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(W.TML_ACT_COST_SEQ,0) > 0 AND NVL(W.TML_ACT_COST_SEQ,0) <> NVL(Q.TML_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN 'U'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END IBFLAG" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN NVL(W.TML_ACT_COST_SEQ,0) > 0 AND NVL(W.TML_ACT_COST_SEQ,0) <> NVL(Q.TML_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN W.TML_ACT_COST_SEQ" ).append("\n"); 
		query.append("ELSE Q.TML_ACT_COST_SEQ" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE Q.TML_ACT_COST_SEQ" ).append("\n"); 
		query.append("END TML_ACT_COST_SEQ" ).append("\n"); 
		query.append(", Q.YD_CD" ).append("\n"); 
		query.append(", Q.PORT_CD" ).append("\n"); 
		query.append(", Q.TML_CD" ).append("\n"); 
		query.append(", Q.MN_YD_FLG" ).append("\n"); 
		query.append(", Q.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", Q.IO_BND_CD" ).append("\n"); 
		query.append(", Q.IO_GA_CD" ).append("\n"); 
		query.append(", Q.TML_AWK_TS_CD" ).append("\n"); 
		query.append(", Q.COND_NO" ).append("\n"); 
		query.append(", Q.COND_DESC" ).append("\n"); 
		query.append(", Q.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(", Q.MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", Q.MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", Q.MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", Q.MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", Q.MAN_USD_AMT_40FT" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(W.TML_ACT_COST_SEQ,0) > 0 AND NVL(W.TML_ACT_COST_SEQ,0) <> NVL(Q.TML_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0)" ).append("\n"); 
		query.append("ELSE NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)" ).append("\n"); 
		query.append("END AUTO_USD_AMT_20FT" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(W.TML_ACT_COST_SEQ,0) > 0 AND NVL(W.TML_ACT_COST_SEQ,0) <> NVL(Q.TML_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0)" ).append("\n"); 
		query.append("ELSE NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0)" ).append("\n"); 
		query.append("END AUTO_USD_AMT_40FT" ).append("\n"); 
		query.append(", Q.TTL_LOCL_CURR_CD" ).append("\n"); 
		query.append(", Q.TTL_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", Q.TTL_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", Q.TTL_USD_AMT_20FT" ).append("\n"); 
		query.append(", Q.TTL_USD_AMT_40FT" ).append("\n"); 
		query.append(", Q.APLY_RTO" ).append("\n"); 
		query.append(", Q.FML_LOCL_CURR_CD" ).append("\n"); 
		query.append(", Q.FML_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", Q.FML_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", Q.FML_USD_AMT_20FT" ).append("\n"); 
		query.append(", Q.FML_USD_AMT_40FT" ).append("\n"); 
		query.append(", Q.CALC_USD_AMT_20FT" ).append("\n"); 
		query.append(", Q.CALC_USD_AMT_40FT" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN NVL(W.TML_ACT_COST_SEQ,0) > 0 AND NVL(W.TML_ACT_COST_SEQ,0) <> NVL(Q.TML_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN TO_NUMBER('')" ).append("\n"); 
		query.append("ELSE Q.SUM_USD_AMT_20FT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE Q.SUM_USD_AMT_20FT" ).append("\n"); 
		query.append("END SUM_USD_AMT_20FT" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN NVL(W.TML_ACT_COST_SEQ,0) > 0 AND NVL(W.TML_ACT_COST_SEQ,0) <> NVL(Q.TML_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN TO_NUMBER('')" ).append("\n"); 
		query.append("ELSE Q.SUM_USD_AMT_40FT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE Q.SUM_USD_AMT_40FT" ).append("\n"); 
		query.append("END SUM_USD_AMT_40FT" ).append("\n"); 
		query.append("-- , Q.SUM_USD_AMT_20FT" ).append("\n"); 
		query.append("-- , Q.SUM_USD_AMT_40FT" ).append("\n"); 
		query.append(", Q.CALC_RMK" ).append("\n"); 
		query.append(", Q.LST_UPD_USR_ID" ).append("\n"); 
		query.append(", Q.LST_UPD_DT" ).append("\n"); 
		query.append(", Q.CRE_USR_OFC_CD" ).append("\n"); 
		query.append(", Q.UPD_USR_OFC_CD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN Q.CRE_USR_OFC_AUTH_YN IS NOT NULL AND Q.CRE_USR_OFC_AUTH_YN = 'Y'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("WHEN Q.UPD_USR_OFC_AUTH_YN IS NOT NULL AND Q.UPD_USR_OFC_AUTH_YN = 'Y'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_AUTH_YN" ).append("\n"); 
		query.append(", Q.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN W.ACT_YD_OFC_AUTH_YN = 'Y'" ).append("\n"); 
		query.append("THEN W.ACT_YD_OFC_AUTH_YN" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN Q.CRE_USR_OFC_AUTH_YN = 'Y' OR Q.UPD_USR_OFC_AUTH_YN = 'Y'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END ACT_YD_OFC_AUTH_YN" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("AD.TML_ACT_COST_SEQ" ).append("\n"); 
		query.append(", AD.YD_CD" ).append("\n"); 
		query.append(", SUBSTR(AD.YD_CD,1,5) PORT_CD" ).append("\n"); 
		query.append(", SUBSTR(AD.YD_CD,6) TML_CD" ).append("\n"); 
		query.append(", DECODE(AH.MN_YD_FLG,'Y','1','0') MN_YD_FLG" ).append("\n"); 
		query.append(", X.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", X.IO_BND_CD, X.IO_GA_CD" ).append("\n"); 
		query.append(", X.TML_AWK_TS_CD" ).append("\n"); 
		query.append(", X.COND_NO" ).append("\n"); 
		query.append(",(SELECT C.COND_DESC" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = X.COND_NO) COND_DESC" ).append("\n"); 
		query.append(", X.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(", X.MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", X.MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", X.MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", X.MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.MAN_USD_AMT_40FT" ).append("\n"); 
		query.append(", X.AUTO_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.AUTO_USD_AMT_40FT" ).append("\n"); 
		query.append(", X.TTL_LOCL_CURR_CD" ).append("\n"); 
		query.append(", X.TTL_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", X.TTL_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", X.TTL_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.TTL_USD_AMT_40FT" ).append("\n"); 
		query.append(", AD.APLY_RTO" ).append("\n"); 
		query.append(", X.FML_LOCL_CURR_CD" ).append("\n"); 
		query.append(", X.FML_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", X.FML_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", X.FML_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.FML_USD_AMT_40FT" ).append("\n"); 
		query.append(", X.CALC_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.CALC_USD_AMT_40FT" ).append("\n"); 
		query.append(", X.SUM_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.SUM_USD_AMT_40FT" ).append("\n"); 
		query.append(", AD.CALC_RMK" ).append("\n"); 
		query.append(", AD.LST_UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(AD.LST_UPD_DT,'YYYY-MM-DD') LST_UPD_DT" ).append("\n"); 
		query.append(", AD.CRE_USR_ID" ).append("\n"); 
		query.append(", (SELECT Y.OFC_CD FROM MDM_YARD Y WHERE Y.YD_CD = AD.YD_CD) CRE_USR_OFC_CD" ).append("\n"); 
		query.append(", UU.OFC_CD UPD_USR_OFC_CD" ).append("\n"); 
		query.append(", TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], (SELECT Y.OFC_CD FROM MDM_YARD Y WHERE Y.YD_CD = AD.YD_CD)) CRE_USR_OFC_AUTH_YN  --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append(", TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], UU.OFC_CD) UPD_USR_OFC_AUTH_YN  --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN X.SPCL_CGO_REF_SEQ IS NOT NULL" ).append("\n"); 
		query.append("THEN X.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("WHEN X.SPCL_CGO_REF_SEQ_PM IS NOT NULL" ).append("\n"); 
		query.append("THEN X.SPCL_CGO_REF_SEQ_PM" ).append("\n"); 
		query.append("ELSE TO_NUMBER('')" ).append("\n"); 
		query.append("END SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_HDR AH, TES_AWK_CGO_TRF_DTL AD, (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/** HDR + DTL **/" ).append("\n"); 
		query.append("T.YD_CD, T.TML_AWK_CGO_TRF_TP_CD, T.IO_BND_CD, T.IO_GA_CD, T.TML_AWK_TS_CD, T.COND_NO, MAX(T.TML_AWK_TRF_VER_NO) TML_AWK_TRF_VER_NO," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN T.LOCL_CURR_CD" ).append("\n"); 
		query.append("END) MAN_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.LOCL_CURR_AMT,'')" ).append("\n"); 
		query.append("END) MAN_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.LOCL_CURR_AMT,'')" ).append("\n"); 
		query.append("END) MAN_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (USD) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) MAN_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) MAN_USD_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST AUTO (USD) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'A'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) AUTO_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'A'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) AUTO_USD_AMT_40FT," ).append("\n"); 
		query.append("/** TOTAL (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'T'" ).append("\n"); 
		query.append("THEN T.LOCL_CURR_CD" ).append("\n"); 
		query.append("END) TTL_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'T'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.LOCL_CURR_AMT,'')" ).append("\n"); 
		query.append("END) TTL_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'T'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.LOCL_CURR_AMT,'')" ).append("\n"); 
		query.append("END) TTL_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** TOTAL (USD) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'T'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) TTL_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'T'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) TTL_USD_AMT_40FT," ).append("\n"); 
		query.append("/** FORMULA (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'F'" ).append("\n"); 
		query.append("THEN T.LOCL_CURR_CD" ).append("\n"); 
		query.append("END) FML_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'F'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.LOCL_CURR_AMT,'')" ).append("\n"); 
		query.append("END) FML_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'F'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.LOCL_CURR_AMT,'')" ).append("\n"); 
		query.append("END) FML_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** FORMULA (USD) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'F'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) FML_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'F'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) FML_USD_AMT_40FT," ).append("\n"); 
		query.append("/** APPLIED EXTRA COST (USD) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'C'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) CALC_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'C'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) CALC_USD_AMT_40FT," ).append("\n"); 
		query.append("/** TOTAL HANDLING COST (USD) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'S'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) SUM_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TML_AWK_UC_CALC_TP_CD = 'S'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) SUM_USD_AMT_40FT" ).append("\n"); 
		query.append(", MAX(PD.SPCL_CGO_REF_SEQ) SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(", MAX(PM.SPCL_CGO_REF_SEQ) SPCL_CGO_REF_SEQ_PM" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_HDR H, TES_AWK_CGO_TRF_DTL D, TES_AWK_CGO_TRF_TP_SZ T, PRI_SCQ_AWK_YD_DTL PD, PRI_SCQ_AWK_YD_DTL_TMP PM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.YD_CD = D.YD_CD" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND D.YD_CD = T.YD_CD" ).append("\n"); 
		query.append("AND D.TML_AWK_CGO_TRF_TP_CD = T.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND D.IO_BND_CD = T.IO_BND_CD" ).append("\n"); 
		query.append("AND D.IO_GA_CD = T.IO_GA_CD" ).append("\n"); 
		query.append("AND D.TML_AWK_TS_CD = T.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND D.COND_NO = T.COND_NO" ).append("\n"); 
		query.append("AND D.TML_AWK_TRF_VER_NO = T.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND D.TML_AWK_TRF_VER_NO = (" ).append("\n"); 
		query.append("SELECT MAX(XD.TML_AWK_TRF_VER_NO)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_HDR XH, TES_AWK_CGO_TRF_DTL XD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND XH.YD_CD = XD.YD_CD" ).append("\n"); 
		query.append("AND NVL(XH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND XD.YD_CD = D.YD_CD" ).append("\n"); 
		query.append("AND XD.TML_AWK_CGO_TRF_TP_CD = D.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND XD.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("AND XD.IO_GA_CD = D.IO_GA_CD" ).append("\n"); 
		query.append("AND XD.TML_AWK_TS_CD = D.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND XD.COND_NO = D.COND_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PD.SPCL_CGO_REF_SEQ(+)" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PM.SPCL_CGO_REF_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY T.YD_CD, T.TML_AWK_CGO_TRF_TP_CD, T.IO_BND_CD, T.IO_GA_CD, T.TML_AWK_TS_CD, T.COND_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(", COM_USER CU, COM_USER UU" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AH.YD_CD = AD.YD_CD" ).append("\n"); 
		query.append("AND NVL(AH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("#if(${yd_cd} != '' )" ).append("\n"); 
		query.append("AND AH.YD_CD LIKE @[yd_cd]||'%'  --// PORT 조회조건으로 받는다" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND AD.TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd] --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND AD.TML_AWK_TRF_VER_NO = (" ).append("\n"); 
		query.append("SELECT MAX(XD.TML_AWK_TRF_VER_NO)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_HDR XH, TES_AWK_CGO_TRF_DTL XD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND XH.YD_CD = XD.YD_CD" ).append("\n"); 
		query.append("AND NVL(XH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND XD.YD_CD = AD.YD_CD" ).append("\n"); 
		query.append("AND XD.TML_AWK_CGO_TRF_TP_CD = AD.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND XD.IO_BND_CD = AD.IO_BND_CD" ).append("\n"); 
		query.append("AND XD.IO_GA_CD = AD.IO_GA_CD" ).append("\n"); 
		query.append("AND XD.TML_AWK_TS_CD = AD.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND XD.COND_NO = AD.COND_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND AD.YD_CD = X.YD_CD" ).append("\n"); 
		query.append("AND AD.TML_AWK_CGO_TRF_TP_CD = X.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND AD.IO_BND_CD = X.IO_BND_CD" ).append("\n"); 
		query.append("AND AD.IO_GA_CD = X.IO_GA_CD" ).append("\n"); 
		query.append("AND AD.TML_AWK_TS_CD = X.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND AD.COND_NO = X.COND_NO" ).append("\n"); 
		query.append("AND AD.CRE_USR_ID = CU.USR_ID(+)" ).append("\n"); 
		query.append("AND NVL(CU.USE_FLG(+),'N') = 'Y'" ).append("\n"); 
		query.append("AND AD.LST_UPD_USR_ID = UU.USR_ID(+)" ).append("\n"); 
		query.append("AND NVL(UU.USE_FLG(+),'N') = 'Y'" ).append("\n"); 
		query.append(") Q" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TD.TML_ACT_COST_SEQ, TD.YD_CD, TD.TML_AWK_CGO_TRF_TP_CD, TD.IO_BND_CD, TD.IO_GA_CD, TD.TML_AWK_TS_CD," ).append("\n"); 
		query.append("MAX(DECODE(TT.CNTR_SZ_CD,'2',TT.USD_AMT,'')) ACT_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(DECODE(TT.CNTR_SZ_CD,'4',TT.USD_AMT,'')) ACT_USD_AMT_40FT, Y.OFC_CD ACT_YD_OFC_CD" ).append("\n"); 
		query.append(", TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], Y.OFC_CD) ACT_YD_OFC_AUTH_YN  --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append("FROM TES_ACT_COST_HDR TH, TES_ACT_COST_DTL TD, TES_ACT_COST_TP_SZ TT, MDM_YARD Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TH.TML_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND NVL(TH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND TH.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("#if( ${year_month} != '' )" ).append("\n"); 
		query.append("AND TO_CHAR(TH.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TH.TML_ACT_COST_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(X.TML_ACT_COST_SEQ) TML_ACT_COST_SEQ" ).append("\n"); 
		query.append("FROM TES_ACT_COST_HDR X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.TML_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND NVL(X.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND X.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("#if( ${year_month} != '' )" ).append("\n"); 
		query.append("AND TO_CHAR(X.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TH.TML_ACT_COST_SEQ = TD.TML_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]  --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND TD.TML_ACT_COST_SEQ = TT.TML_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.YD_CD = TT.YD_CD" ).append("\n"); 
		query.append("AND TD.TML_AWK_CGO_TRF_TP_CD = TT.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TD.IO_BND_CD = TT.IO_BND_CD" ).append("\n"); 
		query.append("AND TD.IO_GA_CD = TT.IO_GA_CD" ).append("\n"); 
		query.append("AND TD.TML_AWK_TS_CD = TT.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND TD.YD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("GROUP BY TD.TML_ACT_COST_SEQ, TD.YD_CD, TD.TML_AWK_CGO_TRF_TP_CD, TD.IO_BND_CD, TD.IO_GA_CD, TD.TML_AWK_TS_CD, Y.OFC_CD" ).append("\n"); 
		query.append(") W" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND Q.YD_CD  = W.YD_CD(+)" ).append("\n"); 
		query.append("AND Q.TML_AWK_CGO_TRF_TP_CD  = W.TML_AWK_CGO_TRF_TP_CD(+)" ).append("\n"); 
		query.append("AND Q.IO_BND_CD  = W.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND Q.IO_GA_CD  = W.IO_GA_CD(+)" ).append("\n"); 
		query.append("AND Q.TML_AWK_TS_CD  = W.TML_AWK_TS_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'I' IBFLAG" ).append("\n"); 
		query.append(", TD.TML_ACT_COST_SEQ" ).append("\n"); 
		query.append(", TD.YD_CD" ).append("\n"); 
		query.append(", SUBSTR(TD.YD_CD,1,5) PORT_CD" ).append("\n"); 
		query.append(", SUBSTR(TD.YD_CD,6) TML_CD" ).append("\n"); 
		query.append(", '0' MN_YD_FLG" ).append("\n"); 
		query.append(", TD.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", TD.IO_BND_CD" ).append("\n"); 
		query.append(", TD.IO_GA_CD" ).append("\n"); 
		query.append(", TD.TML_AWK_TS_CD" ).append("\n"); 
		query.append(", TO_NUMBER('0') COND_NO" ).append("\n"); 
		query.append(", '' COND_DESC" ).append("\n"); 
		query.append(", TO_NUMBER('') TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(", '' MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_USD_AMT_40FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'2',NVL(TT.USD_AMT,''),'')) AUTO_USD_AMT_20FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'4',NVL(TT.USD_AMT,''),'')) AUTO_USD_AMT_40FT" ).append("\n"); 
		query.append(", '' TTL_LOCL_CURR_CD" ).append("\n"); 
		query.append(", TO_NUMBER('') TTL_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') TTL_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", TO_NUMBER('') TTL_USD_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') TTL_USD_AMT_40FT" ).append("\n"); 
		query.append(", TO_NUMBER('') APLY_RTO" ).append("\n"); 
		query.append(", '' FML_LOCL_CURR_CD" ).append("\n"); 
		query.append(", TO_NUMBER('') FML_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') FML_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", TO_NUMBER('') FML_USD_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') FML_USD_AMT_40FT" ).append("\n"); 
		query.append(", TO_NUMBER('') CALC_USD_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') CALC_USD_AMT_40FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'2',NVL(TT.USD_AMT,''),'')) SUM_USD_AMT_20FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'4',NVL(TT.USD_AMT,''),'')) SUM_USD_AMT_40FT" ).append("\n"); 
		query.append(", '' CALC_RMK" ).append("\n"); 
		query.append(", TD.UPD_USR_ID LST_UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(TD.UPD_DT,'YYYY-MM-DD') LST_UPD_DT" ).append("\n"); 
		query.append(", '' CRE_USR_OFC_CD" ).append("\n"); 
		query.append(", '' UPD_USR_OFC_CD" ).append("\n"); 
		query.append(", 'Y' CHK_AUTH_YN" ).append("\n"); 
		query.append(", TO_NUMBER('') SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(", TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], Y.OFC_CD) ACT_YD_OFC_AUTH_YN  --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append("FROM TES_ACT_COST_HDR TH, TES_ACT_COST_DTL TD, TES_ACT_COST_TP_SZ TT, MDM_YARD Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(TH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND TH.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("AND TO_CHAR(TH.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append("AND TH.TML_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND TH.TML_ACT_COST_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(X.TML_ACT_COST_SEQ) TML_ACT_COST_SEQ" ).append("\n"); 
		query.append("FROM TES_ACT_COST_HDR X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.TML_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND NVL(X.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND X.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("AND TO_CHAR(X.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${yd_cd} != '' )" ).append("\n"); 
		query.append("AND TD.YD_CD LIKE @[yd_cd]||'%'  --// PORT 조회조건으로 받는다" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TH.TML_ACT_COST_SEQ = TD.TML_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]  --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND TT.TML_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND TD.TML_ACT_COST_SEQ = TT.TML_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.YD_CD = TT.YD_CD" ).append("\n"); 
		query.append("AND TD.TML_AWK_CGO_TRF_TP_CD = TT.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TD.IO_BND_CD = TT.IO_BND_CD" ).append("\n"); 
		query.append("AND TD.IO_GA_CD = TT.IO_GA_CD" ).append("\n"); 
		query.append("AND TD.TML_AWK_TS_CD = TT.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT D.YD_CD" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_HDR H, TES_AWK_CGO_TRF_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.YD_CD = D.YD_CD" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND D.TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd] --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND H.YD_CD = TD.YD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TD.YD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("GROUP BY TD.TML_ACT_COST_SEQ, TD.YD_CD, TD.TML_AWK_CGO_TRF_TP_CD, TD.IO_BND_CD, TD.IO_GA_CD, TD.TML_AWK_TS_CD, TD.UPD_USR_ID, TO_CHAR(TD.UPD_DT,'YYYY-MM-DD'), Y.OFC_CD" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append("#if(${cond_no} != '' )" ).append("\n"); 
		query.append("WHERE P.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY P.YD_CD, P.TML_AWK_CGO_TRF_TP_CD, P.IO_BND_CD, P.IO_GA_CD, P.TML_AWK_TS_CD, P.COND_NO" ).append("\n"); 

	}
}