/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchLoadUnloadTsExtCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.02
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.05.02 이혜민
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

public class SpecialCargoQuotationManageDBDAOsearchLoadUnloadTsExtCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLoadUnloadTsExtCost
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchLoadUnloadTsExtCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_yn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchLoadUnloadTsExtCostRSQL").append("\n"); 
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
		query.append("K.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DENSE_RANK() OVER (PARTITION BY T.YD_CD, T.TML_AWK_CGO_TRF_TP_CD, T.IO_BND_CD, T.IO_GA_CD, T.TML_AWK_TS_CD, T.COND_NO  ORDER BY T.YD_CD, T.TML_AWK_CGO_TRF_TP_CD, T.IO_BND_CD, T.IO_GA_CD, T.TML_AWK_TS_CD, T.COND_NO, T.TML_AWK_TRF_VER_NO DESC) RN," ).append("\n"); 
		query.append("T.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("AD.YD_CD ," ).append("\n"); 
		query.append("SUBSTR(AD.YD_CD, 1, 5) PORT_CD ," ).append("\n"); 
		query.append("SUBSTR(AD.YD_CD, 6) TML_CD ," ).append("\n"); 
		query.append("X.TML_AWK_CGO_TRF_TP_CD ," ).append("\n"); 
		query.append("X.IO_BND_CD," ).append("\n"); 
		query.append("X.IO_GA_CD ," ).append("\n"); 
		query.append("X.TML_AWK_TS_CD ," ).append("\n"); 
		query.append("X.COND_NO ," ).append("\n"); 
		query.append("(SELECT C.COND_DESC" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = X.COND_NO) COND_DESC," ).append("\n"); 
		query.append("X.TML_AWK_TRF_VER_NO ," ).append("\n"); 
		query.append("X.MAN_LOCL_CURR_CD ," ).append("\n"); 
		query.append("X.MAN_LOCL_AMT_20FT ," ).append("\n"); 
		query.append("X.MAN_LOCL_AMT_40FT ," ).append("\n"); 
		query.append("X.MAN_USD_AMT_20FT ," ).append("\n"); 
		query.append("X.MAN_USD_AMT_40FT ," ).append("\n"); 
		query.append("X.AUTO_USD_AMT_20FT ," ).append("\n"); 
		query.append("X.AUTO_USD_AMT_40FT ," ).append("\n"); 
		query.append("X.SUM_USD_AMT_20FT ," ).append("\n"); 
		query.append("X.SUM_USD_AMT_40FT ," ).append("\n"); 
		query.append("AD.CALC_RMK ," ).append("\n"); 
		query.append("AD.LST_UPD_USR_ID ," ).append("\n"); 
		query.append("TO_CHAR(AD.LST_UPD_DT, 'YYYY-MM-DD') LST_UPD_DT," ).append("\n"); 
		query.append("X.SPCL_CGO_REF_SEQ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN Y.YD_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_HDR AH, TES_AWK_CGO_TRF_DTL AD, (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/** HDR + DTL **/ T.YD_CD," ).append("\n"); 
		query.append("T.TML_AWK_CGO_TRF_TP_CD," ).append("\n"); 
		query.append("T.IO_BND_CD," ).append("\n"); 
		query.append("T.IO_GA_CD," ).append("\n"); 
		query.append("T.TML_AWK_TS_CD," ).append("\n"); 
		query.append("T.COND_NO," ).append("\n"); 
		query.append("T.TML_AWK_TRF_VER_NO," ).append("\n"); 
		query.append("/** SPCL_CGO_REF_SEQ **/" ).append("\n"); 
		query.append("'' SPCL_CGO_REF_SEQ," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'M' THEN T.LOCL_CURR_CD END) MAN_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'M' THEN DECODE(T.CNTR_SZ_CD, '2', T.LOCL_CURR_AMT, '') END) MAN_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'M' THEN DECODE(T.CNTR_SZ_CD, '4', T.LOCL_CURR_AMT, '') END) MAN_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (USD) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'M' THEN DECODE(T.CNTR_SZ_CD, '2', T.USD_AMT, '') END) MAN_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'M' THEN DECODE(T.CNTR_SZ_CD, '4', T.USD_AMT, '') END) MAN_USD_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST AUTO (USD) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'A' THEN DECODE(T.CNTR_SZ_CD, '2', T.USD_AMT, '') END) AUTO_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'A' THEN DECODE(T.CNTR_SZ_CD, '4', T.USD_AMT, '') END) AUTO_USD_AMT_40FT," ).append("\n"); 
		query.append("/** TOTAL HANDLING COST (USD) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'S' THEN DECODE(T.CNTR_SZ_CD, '2', T.USD_AMT, '') END) SUM_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'S' THEN DECODE(T.CNTR_SZ_CD, '4', T.USD_AMT, '') END) SUM_USD_AMT_40FT" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_HDR H, TES_AWK_CGO_TRF_DTL D, TES_AWK_CGO_TRF_TP_SZ T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.YD_CD = D.YD_CD" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND D.YD_CD = T.YD_CD" ).append("\n"); 
		query.append("AND D.TML_AWK_CGO_TRF_TP_CD = T.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND D.IO_BND_CD = T.IO_BND_CD" ).append("\n"); 
		query.append("AND D.IO_GA_CD = T.IO_GA_CD" ).append("\n"); 
		query.append("AND D.TML_AWK_TS_CD = T.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND D.COND_NO = T.COND_NO" ).append("\n"); 
		query.append("AND D.TML_AWK_TRF_VER_NO = T.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND (D.YD_CD, D.TML_AWK_CGO_TRF_TP_CD, D.IO_BND_CD, D.IO_GA_CD, D.TML_AWK_TS_CD, D.COND_NO, D.TML_AWK_TRF_VER_NO) IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT TD.YD_CD, TD.TML_AWK_CGO_TRF_TP_CD, TD.IO_BND_CD, TD.IO_GA_CD, TD.TML_AWK_TS_CD, TD.COND_NO, TD.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_TP_SZ TS, TES_AWK_CGO_TRF_DTL TD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TS.YD_CD = TD.YD_CD" ).append("\n"); 
		query.append("AND TS.TML_AWK_CGO_TRF_TP_CD = TD.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TS.IO_BND_CD = TD.IO_BND_CD" ).append("\n"); 
		query.append("AND TS.IO_GA_CD = TD.IO_GA_CD" ).append("\n"); 
		query.append("AND TS.TML_AWK_TS_CD = TD.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND TS.COND_NO = TD.COND_NO" ).append("\n"); 
		query.append("AND TS.TML_AWK_TRF_VER_NO = TD.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND SUBSTR(TS.YD_CD,1,5) IN  (  SELECT" ).append("\n"); 
		query.append("DISTINCT SUBSTR(TS.YD_CD,1,5) PORT" ).append("\n"); 
		query.append("FROM PRI_SCQ_AWK_YD_DTL PD, PRI_SCQ_AWK_ROUT PR, TES_AWK_CGO_TRF_TP_SZ TS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = PR.SCQ_RQST_NO" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = PR.SCQ_VER_NO" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = PR.ROUT_SEQ" ).append("\n"); 
		query.append("AND DECODE(PR.ROUT_TP_CD,'L','B','P','B','N','T') = TS.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TS.TML_AWK_CGO_TRF_TP_CD = 'T'  --T로 고정" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND PD.COST_TP_CD = @[cost_tp_cd]" ).append("\n"); 
		query.append("AND 'N' = NVL(@[tmp_yn],'X')" ).append("\n"); 
		query.append("AND PD.SPCL_CGO_REF_SEQ = TS.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT SUBSTR(TS.YD_CD,1,5) PORT" ).append("\n"); 
		query.append("FROM PRI_SCQ_AWK_YD_DTL_TMP PD, PRI_SCQ_AWK_ROUT_TMP PR, TES_AWK_CGO_TRF_TP_SZ TS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = PR.SCQ_RQST_NO" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = PR.SCQ_VER_NO" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = PR.ROUT_SEQ" ).append("\n"); 
		query.append("AND DECODE(PR.ROUT_TP_CD,'L','B','P','B','N','T') = TS.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TS.TML_AWK_CGO_TRF_TP_CD = 'T'  --T로 고정" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND PD.COST_TP_CD = @[cost_tp_cd]" ).append("\n"); 
		query.append("AND 'Y' = NVL(@[tmp_yn],'X')" ).append("\n"); 
		query.append("AND PD.SPCL_CGO_REF_SEQ = TS.SPCL_CGO_REF_SEQ  )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY T.YD_CD, T.TML_AWK_CGO_TRF_TP_CD, T.IO_BND_CD, T.IO_GA_CD, T.TML_AWK_TS_CD, T.COND_NO, T.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT T.YD_CD, T.TML_AWK_CGO_TRF_TP_CD, T.IO_BND_CD, T.IO_GA_CD, T.TML_AWK_TS_CD, T.COND_NO, T.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_TP_SZ T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT PD.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("FROM PRI_SCQ_AWK_YD_DTL PD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND PD.COST_TP_CD = @[cost_tp_cd]" ).append("\n"); 
		query.append("AND 'N' = NVL(@[tmp_yn],'X')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT PD.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("FROM PRI_SCQ_AWK_YD_DTL_TMP PD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND PD.COST_TP_CD = @[cost_tp_cd]" ).append("\n"); 
		query.append("AND 'Y' = NVL(@[tmp_yn],'X')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AH.YD_CD = AD.YD_CD" ).append("\n"); 
		query.append("AND NVL(AH.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND AD.TML_AWK_CGO_TRF_TP_CD = 'T'" ).append("\n"); 
		query.append("AND AD.YD_CD = X.YD_CD" ).append("\n"); 
		query.append("AND AD.TML_AWK_CGO_TRF_TP_CD = X.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND AD.IO_BND_CD = X.IO_BND_CD" ).append("\n"); 
		query.append("AND AD.IO_GA_CD = X.IO_GA_CD" ).append("\n"); 
		query.append("AND AD.TML_AWK_TS_CD = X.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND AD.COND_NO = X.COND_NO" ).append("\n"); 
		query.append("AND AD.TML_AWK_TRF_VER_NO = X.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND X.YD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("AND X.TML_AWK_CGO_TRF_TP_CD = Y.TML_AWK_CGO_TRF_TP_CD(+)" ).append("\n"); 
		query.append("AND X.IO_BND_CD = Y.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND X.IO_GA_CD = Y.IO_GA_CD(+)" ).append("\n"); 
		query.append("AND X.TML_AWK_TS_CD = Y.TML_AWK_TS_CD(+)" ).append("\n"); 
		query.append("AND X.COND_NO = Y.COND_NO(+)" ).append("\n"); 
		query.append("AND X.TML_AWK_TRF_VER_NO = Y.TML_AWK_TRF_VER_NO(+)" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(") K" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (K.RN = 1 OR K.CHK_SPCL_CGO_REF_SEQ = 'Y')" ).append("\n"); 
		query.append("ORDER BY K.YD_CD, K.TML_AWK_CGO_TRF_TP_CD, K.IO_BND_CD, K.IO_GA_CD, K.TML_AWK_TS_CD, K.COND_NO, K.TML_AWK_TRF_VER_NO DESC, K.MAN_LOCL_CURR_CD" ).append("\n"); 

	}
}