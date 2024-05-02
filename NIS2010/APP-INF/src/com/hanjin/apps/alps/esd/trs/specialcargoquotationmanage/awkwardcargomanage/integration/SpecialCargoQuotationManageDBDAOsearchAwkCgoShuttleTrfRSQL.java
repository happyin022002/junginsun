/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.31
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.05.31 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAwkCgoShuttleTrf
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_awk_cgo_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfRSQL").append("\n"); 
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
		query.append("WHEN NVL(W.TRSP_ACT_COST_SEQ,0) > 0 AND NVL(W.TRSP_ACT_COST_SEQ,0) <> NVL(Q.TRSP_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN 'U'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END IBFLAG" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN NVL(W.TRSP_ACT_COST_SEQ,0) > 0 AND NVL(W.TRSP_ACT_COST_SEQ,0) <> NVL(Q.TRSP_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN W.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("ELSE Q.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE Q.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("END TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append(", SUBSTR(Q.FM_YD_CD,1,5) FM_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(Q.FM_YD_CD,6,2) FM_NOD_YD_NO" ).append("\n"); 
		query.append(", SUBSTR(Q.TO_YD_CD,1,5) TO_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(Q.TO_YD_CD,6,2) TO_NOD_YD_NO" ).append("\n"); 
		query.append(", Q.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", Q.IO_GA_CD" ).append("\n"); 
		query.append(", Q.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", Q.COND_NO" ).append("\n"); 
		query.append(", Q.COND_DESC" ).append("\n"); 
		query.append(", Q.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(", Q.MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", Q.MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", Q.MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", Q.MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", Q.MAN_USD_AMT_40FT" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(W.TRSP_ACT_COST_SEQ,0) > 0 AND NVL(W.TRSP_ACT_COST_SEQ,0) <> NVL(Q.TRSP_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0)" ).append("\n"); 
		query.append("ELSE NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)" ).append("\n"); 
		query.append("END AUTO_USD_AMT_20FT" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(W.TRSP_ACT_COST_SEQ,0) > 0 AND NVL(W.TRSP_ACT_COST_SEQ,0) <> NVL(Q.TRSP_ACT_COST_SEQ,0)" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN (NVL(TO_NUMBER(W.ACT_USD_AMT_20FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_20FT),0)) OR (NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0) <> NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0))" ).append("\n"); 
		query.append("THEN NVL(TO_NUMBER(W.ACT_USD_AMT_40FT),0)" ).append("\n"); 
		query.append("ELSE NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE NVL(TO_NUMBER(Q.AUTO_USD_AMT_40FT),0)" ).append("\n"); 
		query.append("END AUTO_USD_AMT_40FT" ).append("\n"); 
		query.append(", Q.SUM_USD_AMT_20FT" ).append("\n"); 
		query.append(", Q.SUM_USD_AMT_40FT" ).append("\n"); 
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
		query.append("AD.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append(", AD.FM_YD_CD" ).append("\n"); 
		query.append(", AD.TO_YD_CD" ).append("\n"); 
		query.append(", X.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", X.IO_GA_CD" ).append("\n"); 
		query.append(", X.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", X.COND_NO" ).append("\n"); 
		query.append(",(SELECT C.COND_DESC" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = X.COND_NO) COND_DESC" ).append("\n"); 
		query.append(", X.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(", X.MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", X.MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", X.MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", X.MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.MAN_USD_AMT_40FT" ).append("\n"); 
		query.append(", X.AUTO_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.AUTO_USD_AMT_40FT" ).append("\n"); 
		query.append(", X.SUM_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.SUM_USD_AMT_40FT" ).append("\n"); 
		query.append(", AD.CALC_RMK" ).append("\n"); 
		query.append(", AD.LST_UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(AD.LST_UPD_DT,'YYYY-MM-DD') LST_UPD_DT" ).append("\n"); 
		query.append(", AD.CRE_USR_ID" ).append("\n"); 
		query.append(", (SELECT Y.OFC_CD FROM MDM_YARD Y WHERE Y.YD_CD = AD.FM_YD_CD) CRE_USR_OFC_CD" ).append("\n"); 
		query.append(", UU.OFC_CD UPD_USR_OFC_CD" ).append("\n"); 
		query.append(", TRS_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], (SELECT Y.OFC_CD FROM MDM_YARD Y WHERE Y.YD_CD = AD.FM_YD_CD)) CRE_USR_OFC_AUTH_YN  --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append(", TRS_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], UU.OFC_CD) UPD_USR_OFC_AUTH_YN  --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN X.SPCL_CGO_REF_SEQ IS NOT NULL" ).append("\n"); 
		query.append("THEN X.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("WHEN X.SPCL_CGO_REF_SEQ_PM IS NOT NULL" ).append("\n"); 
		query.append("THEN X.SPCL_CGO_REF_SEQ_PM" ).append("\n"); 
		query.append("ELSE TO_NUMBER('')" ).append("\n"); 
		query.append("END SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR AD, (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/** HDR + DTL **/" ).append("\n"); 
		query.append("T.FM_YD_CD, T.TO_YD_CD, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO, MAX(T.TRSP_AWK_TRF_VER_NO) TRSP_AWK_TRF_VER_NO," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN T.LOCL_CURR_CD" ).append("\n"); 
		query.append("END) MAN_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.LOCL_CURR_AMT,'')" ).append("\n"); 
		query.append("END) MAN_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.LOCL_CURR_AMT,'')" ).append("\n"); 
		query.append("END) MAN_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (USD) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) MAN_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) MAN_USD_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST AUTO (USD) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'A'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) AUTO_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'A'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) AUTO_USD_AMT_40FT," ).append("\n"); 
		query.append("/** TOTAL HANDLING COST (USD) **/" ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'S'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) SUM_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'S'" ).append("\n"); 
		query.append("THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')" ).append("\n"); 
		query.append("END) SUM_USD_AMT_40FT" ).append("\n"); 
		query.append(", MAX(PD.SPCL_CGO_REF_SEQ) SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(", MAX(PM.SPCL_CGO_REF_SEQ) SPCL_CGO_REF_SEQ_PM" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR D, TRS_AWK_CGO_TRF_TP_SZ T, PRI_SCQ_AWK_ROUT_DTL PD, PRI_SCQ_AWK_ROUT_DTL_TMP PM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.FM_YD_CD = T.FM_YD_CD" ).append("\n"); 
		query.append("AND D.TO_YD_CD  = T.TO_YD_CD" ).append("\n"); 
		query.append("AND D.TRSP_AWK_CGO_TRF_TP_CD = T.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND D.IO_GA_CD = T.IO_GA_CD" ).append("\n"); 
		query.append("AND D.TRSP_CRR_MOD_CD = T.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND D.COND_NO = T.COND_NO" ).append("\n"); 
		query.append("AND D.TRSP_AWK_TRF_VER_NO = T.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND D.TRSP_AWK_TRF_VER_NO = (" ).append("\n"); 
		query.append("SELECT MAX(XD.TRSP_AWK_TRF_VER_NO)" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR XD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND XD.FM_YD_CD = D.FM_YD_CD" ).append("\n"); 
		query.append("AND XD.TO_YD_CD = D.TO_YD_CD" ).append("\n"); 
		query.append("AND XD.TRSP_AWK_CGO_TRF_TP_CD = D.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND XD.IO_GA_CD = D.IO_GA_CD" ).append("\n"); 
		query.append("AND XD.TRSP_CRR_MOD_CD = D.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND XD.COND_NO = D.COND_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PD.SPCL_CGO_REF_SEQ(+)" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PM.SPCL_CGO_REF_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY T.FM_YD_CD, T.TO_YD_CD, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(", COM_USER CU, COM_USER UU" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${yd_cd} != '' )" ).append("\n"); 
		query.append("AND (AD.FM_YD_CD LIKE @[yd_cd]||'%' OR AD.TO_YD_CD LIKE @[yd_cd]||'%')  --// PORT 조회조건으로 받는다" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND AD.TRSP_AWK_CGO_TRF_TP_CD = @[trsp_awk_cgo_trf_tp_cd] --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND AD.TRSP_AWK_TRF_VER_NO = (" ).append("\n"); 
		query.append("SELECT MAX(XD.TRSP_AWK_TRF_VER_NO)" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR XD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND XD.FM_YD_CD = AD.FM_YD_CD" ).append("\n"); 
		query.append("AND XD.TO_YD_CD = AD.TO_YD_CD" ).append("\n"); 
		query.append("AND XD.TRSP_AWK_CGO_TRF_TP_CD = AD.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND XD.IO_GA_CD = AD.IO_GA_CD" ).append("\n"); 
		query.append("AND XD.TRSP_CRR_MOD_CD = AD.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND XD.COND_NO = AD.COND_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND AD.FM_YD_CD = X.FM_YD_CD" ).append("\n"); 
		query.append("AND AD.TO_YD_CD = X.TO_YD_CD" ).append("\n"); 
		query.append("AND AD.TRSP_AWK_CGO_TRF_TP_CD = X.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND AD.IO_GA_CD = X.IO_GA_CD" ).append("\n"); 
		query.append("AND AD.TRSP_CRR_MOD_CD = X.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND AD.COND_NO = X.COND_NO" ).append("\n"); 
		query.append("AND AD.CRE_USR_ID = CU.USR_ID(+)" ).append("\n"); 
		query.append("AND NVL(CU.USE_FLG(+),'N') = 'Y'" ).append("\n"); 
		query.append("AND AD.LST_UPD_USR_ID = UU.USR_ID(+)" ).append("\n"); 
		query.append("AND NVL(UU.USE_FLG(+),'N') = 'Y'" ).append("\n"); 
		query.append(")Q" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TD.TRSP_ACT_COST_SEQ, TD.FM_YD_CD, TD.TO_YD_CD, TD.TRSP_AWK_CGO_TRF_TP_CD, TD.IO_GA_CD, TD.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("MAX(DECODE(TT.CNTR_SZ_CD,'2',TT.USD_AMT,'')) ACT_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(DECODE(TT.CNTR_SZ_CD,'4',TT.USD_AMT,'')) ACT_USD_AMT_40FT, Y.OFC_CD ACT_YD_OFC_CD" ).append("\n"); 
		query.append(", TRS_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], Y.OFC_CD) ACT_YD_OFC_AUTH_YN  --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append("FROM TRS_ACT_COST_HDR TH, TRS_ACT_COST_DTL TD, TRS_ACT_COST_TP_SZ TT, MDM_YARD Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TH.TRSP_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND NVL(TH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND TH.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("#if( ${year_month} != '' )" ).append("\n"); 
		query.append("AND TO_CHAR(TH.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TH.TRSP_ACT_COST_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(X.TRSP_ACT_COST_SEQ) TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("FROM TRS_ACT_COST_HDR X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.TRSP_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND NVL(X.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND X.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("#if( ${year_month} != '' )" ).append("\n"); 
		query.append("AND TO_CHAR(X.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TH.TRSP_ACT_COST_SEQ = TD.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.TRSP_AWK_CGO_TRF_TP_CD = @[trsp_awk_cgo_trf_tp_cd]  --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND TD.TRSP_ACT_COST_SEQ = TT.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.FM_YD_CD = TT.FM_YD_CD" ).append("\n"); 
		query.append("AND TD.TO_YD_CD = TT.TO_YD_CD" ).append("\n"); 
		query.append("AND TD.TRSP_AWK_CGO_TRF_TP_CD = TT.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TD.IO_GA_CD = TT.IO_GA_CD" ).append("\n"); 
		query.append("AND TD.TRSP_CRR_MOD_CD = TT.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND TD.FM_YD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("GROUP BY TD.TRSP_ACT_COST_SEQ, TD.FM_YD_CD, TD.TO_YD_CD, TD.TRSP_AWK_CGO_TRF_TP_CD, TD.IO_GA_CD, TD.TRSP_CRR_MOD_CD, Y.OFC_CD" ).append("\n"); 
		query.append(") W" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND Q.FM_YD_CD  = W.FM_YD_CD(+)" ).append("\n"); 
		query.append("AND Q.TO_YD_CD  = W.TO_YD_CD(+)" ).append("\n"); 
		query.append("AND Q.TRSP_AWK_CGO_TRF_TP_CD  = W.TRSP_AWK_CGO_TRF_TP_CD(+)" ).append("\n"); 
		query.append("AND Q.IO_GA_CD  = W.IO_GA_CD(+)" ).append("\n"); 
		query.append("AND Q.TRSP_CRR_MOD_CD  = W.TRSP_CRR_MOD_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'I' IBFLAG" ).append("\n"); 
		query.append(", TD.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append(", SUBSTR(TD.FM_YD_CD,1,5) FM_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(TD.FM_YD_CD,6,2) FM_NOD_YD_NO" ).append("\n"); 
		query.append(", SUBSTR(TD.TO_YD_CD,1,5) TO_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(TD.TO_YD_CD,6,2) TO_NOD_YD_NO" ).append("\n"); 
		query.append(", TD.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", TD.IO_GA_CD" ).append("\n"); 
		query.append(", TD.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", DECODE(TD.IO_GA_CD,'I',TO_NUMBER('1'),'O',TO_NUMBER('2')) COND_NO" ).append("\n"); 
		query.append(", DECODE(TD.IO_GA_CD,'I',(SELECT C.COND_DESC" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = '1')," ).append("\n"); 
		query.append("'O',(SELECT C.COND_DESC" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = '2')) COND_DESC" ).append("\n"); 
		query.append(", TO_NUMBER('') TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(", '' MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_USD_AMT_40FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'2',NVL(TT.USD_AMT,''),'')) AUTO_USD_AMT_20FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'4',NVL(TT.USD_AMT,''),'')) AUTO_USD_AMT_40FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'2',NVL(TT.USD_AMT,''),'')) SUM_USD_AMT_20FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'4',NVL(TT.USD_AMT,''),'')) SUM_USD_AMT_40FT" ).append("\n"); 
		query.append(", '' CALC_RMK" ).append("\n"); 
		query.append(", TD.UPD_USR_ID LST_UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(TD.UPD_DT,'YYYY-MM-DD') LST_UPD_DT" ).append("\n"); 
		query.append(", '' CRE_USR_OFC_CD" ).append("\n"); 
		query.append(", '' UPD_USR_OFC_CD" ).append("\n"); 
		query.append(", 'Y' CHK_AUTH_YN" ).append("\n"); 
		query.append(", TO_NUMBER('') SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(", TRS_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], Y.OFC_CD) ACT_YD_OFC_AUTH_YN  --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append("FROM TRS_ACT_COST_HDR TH, TRS_ACT_COST_DTL TD, TRS_ACT_COST_TP_SZ TT, MDM_YARD Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(TH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND TH.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("AND TO_CHAR(TH.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append("AND TH.TRSP_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND TH.TRSP_ACT_COST_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(X.TRSP_ACT_COST_SEQ) TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("FROM TRS_ACT_COST_HDR X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.TRSP_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND NVL(X.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND X.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("AND TO_CHAR(X.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${yd_cd} != '' )" ).append("\n"); 
		query.append("AND (TD.FM_YD_CD LIKE  @[yd_cd]||'%' OR TD.TO_YD_CD LIKE @[yd_cd]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TH.TRSP_ACT_COST_SEQ = TD.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.TRSP_AWK_CGO_TRF_TP_CD = @[trsp_awk_cgo_trf_tp_cd]  --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND TT.TRSP_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND TD.TRSP_ACT_COST_SEQ = TT.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.FM_YD_CD = TT.FM_YD_CD" ).append("\n"); 
		query.append("AND TD.TO_YD_CD = TT.TO_YD_CD" ).append("\n"); 
		query.append("AND TD.TRSP_AWK_CGO_TRF_TP_CD = TT.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TD.IO_GA_CD = TT.IO_GA_CD" ).append("\n"); 
		query.append("AND TD.TRSP_CRR_MOD_CD = TT.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT D.FM_YD_CD" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.TRSP_AWK_CGO_TRF_TP_CD = @[trsp_awk_cgo_trf_tp_cd] --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND D.FM_YD_CD = TD.FM_YD_CD" ).append("\n"); 
		query.append("AND D.TO_YD_CD = TD.TO_YD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TD.FM_YD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("GROUP BY TD.TRSP_ACT_COST_SEQ, TD.FM_YD_CD, TD.TO_YD_CD, TD.TRSP_AWK_CGO_TRF_TP_CD, TD.IO_GA_CD, TD.TRSP_CRR_MOD_CD, TD.UPD_USR_ID, TO_CHAR(TD.UPD_DT,'YYYY-MM-DD'), Y.OFC_CD" ).append("\n"); 
		query.append("--// DEFAULT 추가 -- 시작 ----------------------------------------" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.IBFLAG" ).append("\n"); 
		query.append(", X.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append(", X.FM_LOC_CD" ).append("\n"); 
		query.append(", X.FM_NOD_YD_NO" ).append("\n"); 
		query.append(", X.TO_LOC_CD" ).append("\n"); 
		query.append(", X.TO_NOD_YD_NO" ).append("\n"); 
		query.append(", X.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", 'A' IO_GA_CD" ).append("\n"); 
		query.append(", 'TD' TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", 0 COND_NO" ).append("\n"); 
		query.append(", '' COND_DESC" ).append("\n"); 
		query.append(", TO_NUMBER('') TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(", '' MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_USD_AMT_40FT" ).append("\n"); 
		query.append(", AVG(X.AUTO_USD_AMT_20FT) AUTO_USD_AMT_20FT" ).append("\n"); 
		query.append(", AVG(X.AUTO_USD_AMT_40FT) AUTO_USD_AMT_40FT" ).append("\n"); 
		query.append(", AVG(X.SUM_USD_AMT_20FT) SUM_USD_AMT_20FT" ).append("\n"); 
		query.append(", AVG(X.SUM_USD_AMT_40FT) SUM_USD_AMT_40FT" ).append("\n"); 
		query.append(", '' CALC_RMK" ).append("\n"); 
		query.append(", X.LST_UPD_USR_ID" ).append("\n"); 
		query.append(", X.LST_UPD_DT" ).append("\n"); 
		query.append(", X.CRE_USR_OFC_CD" ).append("\n"); 
		query.append(", X.UPD_USR_OFC_CD" ).append("\n"); 
		query.append(", X.CHK_AUTH_YN" ).append("\n"); 
		query.append(", X.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(", X.ACT_YD_OFC_AUTH_YN" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'I' IBFLAG" ).append("\n"); 
		query.append(", TD.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append(", SUBSTR(TD.FM_YD_CD,1,5) FM_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(TD.FM_YD_CD,6,2) FM_NOD_YD_NO" ).append("\n"); 
		query.append(", SUBSTR(TD.TO_YD_CD,1,5) TO_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(TD.TO_YD_CD,6,2) TO_NOD_YD_NO" ).append("\n"); 
		query.append(", TD.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", TD.IO_GA_CD" ).append("\n"); 
		query.append(", TD.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", DECODE(TD.IO_GA_CD,'I',TO_NUMBER('1'),'O',TO_NUMBER('2')) COND_NO" ).append("\n"); 
		query.append(", DECODE(TD.IO_GA_CD,'I',(SELECT C.COND_DESC" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = '1')," ).append("\n"); 
		query.append("'O',(SELECT C.COND_DESC" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = '2')) COND_DESC" ).append("\n"); 
		query.append(", TO_NUMBER('') TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(", '' MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", TO_NUMBER('') MAN_USD_AMT_40FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'2',NVL(TT.USD_AMT,''),'')) AUTO_USD_AMT_20FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'4',NVL(TT.USD_AMT,''),'')) AUTO_USD_AMT_40FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'2',NVL(TT.USD_AMT,''),'')) SUM_USD_AMT_20FT" ).append("\n"); 
		query.append(", MAX(DECODE(TT.CNTR_SZ_CD,'4',NVL(TT.USD_AMT,''),'')) SUM_USD_AMT_40FT" ).append("\n"); 
		query.append(", '' CALC_RMK" ).append("\n"); 
		query.append(", TD.UPD_USR_ID LST_UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(TD.UPD_DT,'YYYY-MM-DD') LST_UPD_DT" ).append("\n"); 
		query.append(", '' CRE_USR_OFC_CD" ).append("\n"); 
		query.append(", '' UPD_USR_OFC_CD" ).append("\n"); 
		query.append(", 'Y' CHK_AUTH_YN" ).append("\n"); 
		query.append(", TO_NUMBER('') SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(", TRS_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], Y.OFC_CD) ACT_YD_OFC_AUTH_YN  --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append("FROM TRS_ACT_COST_HDR TH, TRS_ACT_COST_DTL TD, TRS_ACT_COST_TP_SZ TT, MDM_YARD Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(TH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND TH.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("AND TO_CHAR(TH.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append("AND TH.TRSP_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND TH.TRSP_ACT_COST_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(X.TRSP_ACT_COST_SEQ) TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("FROM TRS_ACT_COST_HDR X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.TRSP_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND NVL(X.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND X.EXE_STS_CD IN ('C')" ).append("\n"); 
		query.append("AND TO_CHAR(X.EXE_FM_DT,'YYYYMM') = REPLACE(@[year_month],'-','') --// 년월 날짜 입력값" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${yd_cd} != '' )" ).append("\n"); 
		query.append("AND (TD.FM_YD_CD LIKE  @[yd_cd]||'%' OR TD.TO_YD_CD LIKE @[yd_cd]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TH.TRSP_ACT_COST_SEQ = TD.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.TRSP_AWK_CGO_TRF_TP_CD = @[trsp_awk_cgo_trf_tp_cd]  --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND TT.TRSP_ACT_COST_SEQ > 0" ).append("\n"); 
		query.append("AND TD.TRSP_ACT_COST_SEQ = TT.TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append("AND TD.FM_YD_CD = TT.FM_YD_CD" ).append("\n"); 
		query.append("AND TD.TO_YD_CD = TT.TO_YD_CD" ).append("\n"); 
		query.append("AND TD.TRSP_AWK_CGO_TRF_TP_CD = TT.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TD.IO_GA_CD = TT.IO_GA_CD" ).append("\n"); 
		query.append("AND TD.TRSP_CRR_MOD_CD IN ('TD')" ).append("\n"); 
		query.append("AND TD.TRSP_CRR_MOD_CD = TT.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT D.FM_YD_CD" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.TRSP_AWK_CGO_TRF_TP_CD = @[trsp_awk_cgo_trf_tp_cd] --// COST 유형 받아 걸기" ).append("\n"); 
		query.append("AND D.FM_YD_CD = TD.FM_YD_CD" ).append("\n"); 
		query.append("AND D.TO_YD_CD = TD.TO_YD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TD.FM_YD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("GROUP BY TD.TRSP_ACT_COST_SEQ, TD.FM_YD_CD, TD.TO_YD_CD, TD.TRSP_AWK_CGO_TRF_TP_CD, TD.IO_GA_CD, TD.TRSP_CRR_MOD_CD, TD.UPD_USR_ID, TO_CHAR(TD.UPD_DT,'YYYY-MM-DD'), Y.OFC_CD" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("X.IBFLAG, X.TRSP_ACT_COST_SEQ, X.FM_LOC_CD, X.FM_NOD_YD_NO, X.TO_LOC_CD, X.TO_NOD_YD_NO, X.TRSP_AWK_CGO_TRF_TP_CD," ).append("\n"); 
		query.append("X.LST_UPD_USR_ID, X.LST_UPD_DT, X.CRE_USR_OFC_CD, X.UPD_USR_OFC_CD, X.CHK_AUTH_YN, X.SPCL_CGO_REF_SEQ, X.ACT_YD_OFC_AUTH_YN" ).append("\n"); 
		query.append("--// DEFAULT 추가 -- 끝 ----------------------------------------" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append("#if(${cond_no} != '' )" ).append("\n"); 
		query.append("WHERE P.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY P.FM_LOC_CD, P.FM_NOD_YD_NO, P.TO_LOC_CD, P.TO_NOD_YD_NO, P.TRSP_AWK_CGO_TRF_TP_CD, P.IO_GA_CD, P.TRSP_CRR_MOD_CD, P.COND_NO" ).append("\n"); 

	}
}