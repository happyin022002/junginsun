/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchLoadUnloadShuttleExtCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.02
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.05.02 이혜민
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

public class SpecialCargoQuotationManageDBDAOsearchLoadUnloadShuttleExtCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLoadUnloadShuttleExtCost
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchLoadUnloadShuttleExtCostRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchLoadUnloadShuttleExtCostRSQL").append("\n"); 
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
		query.append("DENSE_RANK() OVER (PARTITION BY T.FM_LOC_CD, T.FM_NOD_YD_NO ,T.TO_LOC_CD, T.TO_NOD_YD_NO, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO  ORDER BY T.FM_LOC_CD, T.FM_NOD_YD_NO, T.TO_LOC_CD, T.TO_NOD_YD_NO, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO, T.TRSP_AWK_TRF_VER_NO DESC) RN," ).append("\n"); 
		query.append("T.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUBSTR(AD.FM_YD_CD,1,5) FM_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(AD.FM_YD_CD,6,2) FM_NOD_YD_NO" ).append("\n"); 
		query.append(", SUBSTR(AD.TO_YD_CD,1,5) TO_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(AD.TO_YD_CD,6,2) TO_NOD_YD_NO" ).append("\n"); 
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
		query.append(", X.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN Y.FM_YD_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR AD, (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/** HDR + DTL **/" ).append("\n"); 
		query.append("T.FM_YD_CD, T.TO_YD_CD, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO, MAX(T.TRSP_AWK_TRF_VER_NO) TRSP_AWK_TRF_VER_NO," ).append("\n"); 
		query.append("'' SPCL_CGO_REF_SEQ," ).append("\n"); 
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
		query.append("FROM TRS_AWK_CGO_TRF_HDR D, TRS_AWK_CGO_TRF_TP_SZ T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.FM_YD_CD = T.FM_YD_CD" ).append("\n"); 
		query.append("AND D.TO_YD_CD  = T.TO_YD_CD" ).append("\n"); 
		query.append("AND D.TRSP_AWK_CGO_TRF_TP_CD = T.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND D.IO_GA_CD = T.IO_GA_CD" ).append("\n"); 
		query.append("AND D.TRSP_CRR_MOD_CD = T.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND D.COND_NO = T.COND_NO" ).append("\n"); 
		query.append("AND D.TRSP_AWK_TRF_VER_NO = T.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND (D.FM_YD_CD, D.TO_YD_CD, D.TRSP_AWK_CGO_TRF_TP_CD, D.IO_GA_CD, D.TRSP_CRR_MOD_CD, D.COND_NO, D.TRSP_AWK_TRF_VER_NO) IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT TD.FM_YD_CD, TD.TO_YD_CD, TD.TRSP_AWK_CGO_TRF_TP_CD, TD.IO_GA_CD, TD.TRSP_CRR_MOD_CD, TD.COND_NO, TD.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR TS, TRS_AWK_CGO_TRF_TP_SZ TD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TS.FM_YD_CD = TD.FM_YD_CD" ).append("\n"); 
		query.append("AND TS.TO_YD_CD = TD.TO_YD_CD" ).append("\n"); 
		query.append("AND TS.TRSP_AWK_CGO_TRF_TP_CD = TD.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TS.IO_GA_CD = TD.IO_GA_CD" ).append("\n"); 
		query.append("AND TS.TRSP_CRR_MOD_CD = TD.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND TS.COND_NO = TD.COND_NO" ).append("\n"); 
		query.append("AND TS.TRSP_AWK_TRF_VER_NO = TD.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND SUBSTR(TS.FM_YD_CD,1,5) IN (SELECT" ).append("\n"); 
		query.append("DISTINCT SUBSTR(TS.FM_YD_CD,1,5) PORT" ).append("\n"); 
		query.append("FROM PRI_SCQ_AWK_ROUT_DTL PD, PRI_SCQ_AWK_ROUT PR, TRS_AWK_CGO_TRF_TP_SZ TS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = PR.SCQ_RQST_NO" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = PR.SCQ_VER_NO" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = PR.ROUT_SEQ" ).append("\n"); 
		query.append("AND DECODE(PR.ROUT_TP_CD,'L','B','P','B','N','S') = TS.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TS.TRSP_AWK_CGO_TRF_TP_CD = 'S'  --S로 고정" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND PD.COST_TP_CD = @[cost_tp_cd]" ).append("\n"); 
		query.append("AND 'N' = NVL(@[tmp_yn],'X')" ).append("\n"); 
		query.append("AND PD.SPCL_CGO_REF_SEQ = TS.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT SUBSTR(TS.FM_YD_CD,1,5) PORT" ).append("\n"); 
		query.append("FROM PRI_SCQ_AWK_ROUT_DTL_TMP PD, PRI_SCQ_AWK_ROUT_TMP PR, TRS_AWK_CGO_TRF_TP_SZ TS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = PR.SCQ_RQST_NO" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = PR.SCQ_VER_NO" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = PR.ROUT_SEQ" ).append("\n"); 
		query.append("AND DECODE(PR.ROUT_TP_CD,'L','B','P','B','N','S') = TS.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND TS.TRSP_AWK_CGO_TRF_TP_CD = 'S'  --S로 고정" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND PD.COST_TP_CD = @[cost_tp_cd]" ).append("\n"); 
		query.append("AND 'Y' = NVL(@[tmp_yn],'X')" ).append("\n"); 
		query.append("AND PD.SPCL_CGO_REF_SEQ = TS.SPCL_CGO_REF_SEQ  )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY T.FM_YD_CD, T.TO_YD_CD, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT T.FM_YD_CD, T.TO_YD_CD, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO, T.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_TP_SZ T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT PD.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("FROM PRI_SCQ_AWK_ROUT_DTL PD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND PD.COST_TP_CD = @[cost_tp_cd]" ).append("\n"); 
		query.append("AND 'N' = NVL(@[tmp_yn],'X')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT PD.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("FROM PRI_SCQ_AWK_ROUT_DTL_TMP PD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PD.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND PD.SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 
		query.append("AND PD.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND PD.COST_TP_CD = @[cost_tp_cd]" ).append("\n"); 
		query.append("AND 'Y' = NVL(@[tmp_yn],'X')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AD.TRSP_AWK_CGO_TRF_TP_CD = 'S'  --S로 고정" ).append("\n"); 
		query.append("AND AD.FM_YD_CD = X.FM_YD_CD" ).append("\n"); 
		query.append("AND AD.TO_YD_CD = X.TO_YD_CD" ).append("\n"); 
		query.append("AND AD.TRSP_AWK_CGO_TRF_TP_CD = X.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND AD.IO_GA_CD = X.IO_GA_CD" ).append("\n"); 
		query.append("AND AD.TRSP_CRR_MOD_CD = X.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND AD.COND_NO = X.COND_NO" ).append("\n"); 
		query.append("AND AD.TRSP_AWK_TRF_VER_NO = X.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND X.FM_YD_CD = Y.FM_YD_CD(+)" ).append("\n"); 
		query.append("AND X.TO_YD_CD = Y.TO_YD_CD(+)" ).append("\n"); 
		query.append("AND X.TRSP_AWK_CGO_TRF_TP_CD = Y.TRSP_AWK_CGO_TRF_TP_CD(+)" ).append("\n"); 
		query.append("AND X.IO_GA_CD = Y.IO_GA_CD(+)" ).append("\n"); 
		query.append("AND X.TRSP_CRR_MOD_CD = Y.TRSP_CRR_MOD_CD(+)" ).append("\n"); 
		query.append("AND X.COND_NO = Y.COND_NO(+)" ).append("\n"); 
		query.append("AND X.TRSP_AWK_TRF_VER_NO = Y.TRSP_AWK_TRF_VER_NO(+)" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(") K" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (K.RN = 1 OR K.CHK_SPCL_CGO_REF_SEQ = 'Y')" ).append("\n"); 
		query.append("ORDER BY K.FM_LOC_CD, K.FM_NOD_YD_NO ,K.TO_LOC_CD,K.TO_NOD_YD_NO, K.TRSP_AWK_CGO_TRF_TP_CD, K.IO_GA_CD, K.TRSP_CRR_MOD_CD, K.COND_NO, K.TRSP_AWK_TRF_VER_NO DESC" ).append("\n"); 

	}
}