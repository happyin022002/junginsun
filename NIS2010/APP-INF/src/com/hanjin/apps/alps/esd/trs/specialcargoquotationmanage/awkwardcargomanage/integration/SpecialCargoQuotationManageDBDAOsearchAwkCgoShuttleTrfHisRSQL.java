/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.16
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.16 이혜민
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

public class SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAwkCgoShuttleTrfHis
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_nod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfHisRSQL").append("\n"); 
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
		query.append("SELECT T.* FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUBSTR(AH.FM_YD_CD,1,5) FM_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(AH.FM_YD_CD,6,2) FM_NOD_YD_NO" ).append("\n"); 
		query.append(", SUBSTR(AH.TO_YD_CD,1,5) TO_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(AH.TO_YD_CD,6,2) TO_NOD_YD_NO" ).append("\n"); 
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
		query.append(", AH.CALC_RMK" ).append("\n"); 
		query.append(", AH.LST_UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(AH.LST_UPD_DT,'YYYY-MM-DD') LST_UPD_DT" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR AH, (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/** HDR + DTL **/" ).append("\n"); 
		query.append("T.FM_YD_CD, T.TO_YD_CD, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO, MAX(T.TRSP_AWK_TRF_VER_NO) TRSP_AWK_TRF_VER_NO," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M' THEN T.LOCL_CURR_CD END) MAN_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M' THEN DECODE(T.CNTR_SZ_CD,'2',T.LOCL_CURR_AMT,'') END) MAN_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M' THEN DECODE(T.CNTR_SZ_CD,'4',T.LOCL_CURR_AMT,'') END) MAN_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (USD) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M' THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'') END) MAN_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'M' THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'') END) MAN_USD_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST AUTO (USD) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'A' THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'') END) AUTO_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'A' THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'') END) AUTO_USD_AMT_40FT," ).append("\n"); 
		query.append("/** TOTAL HANDLING COST (USD) **/" ).append("\n"); 
		query.append("MAX( CASE WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'S' THEN DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'') END) SUM_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX( CASE WHEN T.TRSP_AWK_UC_CALC_TP_CD = 'S' THEN DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'') END) SUM_USD_AMT_40FT" ).append("\n"); 
		query.append("FROM TRS_AWK_CGO_TRF_HDR D, TRS_AWK_CGO_TRF_TP_SZ T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.FM_YD_CD = T.FM_YD_CD" ).append("\n"); 
		query.append("AND D.TO_YD_CD  = T.TO_YD_CD" ).append("\n"); 
		query.append("AND D.TRSP_AWK_CGO_TRF_TP_CD = T.TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("AND D.IO_GA_CD = T.IO_GA_CD" ).append("\n"); 
		query.append("AND D.TRSP_CRR_MOD_CD = T.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND D.COND_NO = T.COND_NO" ).append("\n"); 
		query.append("AND D.TRSP_AWK_TRF_VER_NO = T.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("AND D.FM_YD_CD = @[fm_loc_cd]||@[fm_nod_yd_no]" ).append("\n"); 
		query.append("AND D.TO_YD_CD = @[to_loc_cd]||@[to_nod_yd_no]" ).append("\n"); 
		query.append("AND D.IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("AND D.TRSP_CRR_MOD_CD = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("AND D.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("GROUP BY T.FM_YD_CD, T.TO_YD_CD, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO, T.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AH.FM_YD_CD = X.FM_YD_CD" ).append("\n"); 
		query.append("AND AH.TO_YD_CD = X.TO_YD_CD" ).append("\n"); 
		query.append("AND AH.COND_NO 	= X.COND_NO" ).append("\n"); 
		query.append("AND AH.IO_GA_CD = X.IO_GA_CD" ).append("\n"); 
		query.append("AND AH.TRSP_CRR_MOD_CD = X.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("AND AH.TRSP_AWK_TRF_VER_NO = X.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("ORDER BY T.FM_LOC_CD, T.TO_LOC_CD, T.TRSP_AWK_CGO_TRF_TP_CD, T.IO_GA_CD, T.TRSP_CRR_MOD_CD, T.COND_NO, T.TRSP_AWK_TRF_VER_NO DESC" ).append("\n"); 

	}
}