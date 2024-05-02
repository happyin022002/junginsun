/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.15
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.15 이혜민
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

public class SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAwkCgoBasicTrfHis
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_awk_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_ga_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfHisRSQL").append("\n"); 
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
		query.append("AD.YD_CD ," ).append("\n"); 
		query.append("SUBSTR(AD.YD_CD, 1, 5) PORT_CD ," ).append("\n"); 
		query.append("SUBSTR(AD.YD_CD, 6) TML_CD ," ).append("\n"); 
		query.append("DECODE(AH.MN_YD_FLG, 'Y', '1', '0') MN_YD_FLG ," ).append("\n"); 
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
		query.append("X.TTL_LOCL_CURR_CD ," ).append("\n"); 
		query.append("X.TTL_LOCL_AMT_20FT ," ).append("\n"); 
		query.append("X.TTL_LOCL_AMT_40FT ," ).append("\n"); 
		query.append("AD.APLY_RTO ," ).append("\n"); 
		query.append("X.FML_LOCL_CURR_CD ," ).append("\n"); 
		query.append("X.FML_LOCL_AMT_20FT ," ).append("\n"); 
		query.append("X.FML_LOCL_AMT_40FT ," ).append("\n"); 
		query.append("X.CALC_USD_AMT_20FT ," ).append("\n"); 
		query.append("X.CALC_USD_AMT_40FT ," ).append("\n"); 
		query.append("X.SUM_USD_AMT_20FT ," ).append("\n"); 
		query.append("X.SUM_USD_AMT_40FT ," ).append("\n"); 
		query.append("AD.CALC_RMK ," ).append("\n"); 
		query.append("AD.LST_UPD_USR_ID ," ).append("\n"); 
		query.append("TO_CHAR(AD.LST_UPD_DT, 'YYYY-MM-DD') LST_UPD_DT" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_TRF_HDR AH," ).append("\n"); 
		query.append("TES_AWK_CGO_TRF_DTL AD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/** HDR + DTL **/ T.YD_CD," ).append("\n"); 
		query.append("T.TML_AWK_CGO_TRF_TP_CD," ).append("\n"); 
		query.append("T.IO_BND_CD," ).append("\n"); 
		query.append("T.IO_GA_CD," ).append("\n"); 
		query.append("T.TML_AWK_TS_CD," ).append("\n"); 
		query.append("T.COND_NO," ).append("\n"); 
		query.append("T.TML_AWK_TRF_VER_NO," ).append("\n"); 
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
		query.append("/** TOTAL (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'T' THEN T.LOCL_CURR_CD END) TTL_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'T' THEN DECODE(T.CNTR_SZ_CD, '2', T.LOCL_CURR_AMT, '') END) TTL_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'T' THEN DECODE(T.CNTR_SZ_CD, '4', T.LOCL_CURR_AMT, '') END) TTL_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** FORMULA (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'F' THEN T.LOCL_CURR_CD END) FML_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'F' THEN DECODE(T.CNTR_SZ_CD, '2', T.LOCL_CURR_AMT, '') END) FML_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'F' THEN DECODE(T.CNTR_SZ_CD, '4', T.LOCL_CURR_AMT, '') END) FML_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** APPLIED EXTRA COST (USD) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'C' THEN DECODE(T.CNTR_SZ_CD, '2', T.USD_AMT, '') END) CALC_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TML_AWK_UC_CALC_TP_CD = 'C' THEN DECODE(T.CNTR_SZ_CD, '4', T.USD_AMT, '') END) CALC_USD_AMT_40FT," ).append("\n"); 
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
		query.append("AND D.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND D.TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND D.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND D.IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("AND D.TML_AWK_TS_CD = @[tml_awk_ts_cd]" ).append("\n"); 
		query.append("AND D.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("GROUP BY T.YD_CD, T.TML_AWK_CGO_TRF_TP_CD, T.IO_BND_CD, T.IO_GA_CD, T.TML_AWK_TS_CD, T.COND_NO, T.TML_AWK_TRF_VER_NO ) X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AH.YD_CD = AD.YD_CD" ).append("\n"); 
		query.append("AND NVL(AH.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND AD.TML_AWK_CGO_TRF_TP_CD = @[tml_awk_cgo_trf_tp_cd]" ).append("\n"); 
		query.append("AND AD.YD_CD = X.YD_CD" ).append("\n"); 
		query.append("AND AD.TML_AWK_CGO_TRF_TP_CD = X.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND AD.IO_BND_CD = X.IO_BND_CD" ).append("\n"); 
		query.append("AND AD.IO_GA_CD = X.IO_GA_CD" ).append("\n"); 
		query.append("AND AD.TML_AWK_TS_CD = X.TML_AWK_TS_CD" ).append("\n"); 
		query.append("AND AD.COND_NO = X.COND_NO" ).append("\n"); 
		query.append("AND AD.TML_AWK_TRF_VER_NO = X.TML_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append("ORDER BY P.PORT_CD, P.TML_CD, P.TML_AWK_CGO_TRF_TP_CD, P.IO_BND_CD, P.IO_GA_CD, P.TML_AWK_TS_CD, P.COND_NO, P.TML_AWK_TRF_VER_NO DESC" ).append("\n"); 

	}
}