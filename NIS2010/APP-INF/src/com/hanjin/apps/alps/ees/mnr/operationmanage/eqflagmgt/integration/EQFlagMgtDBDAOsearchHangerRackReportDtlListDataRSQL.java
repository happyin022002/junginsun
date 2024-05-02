/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchHangerRackReportDtlListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.06
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2012.01.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 신혜정
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchHangerRackReportDtlListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2012.01.04 신혜정 [CHM-201215407-01] Hanger Rack/Bar Using Report 의 Detail EQ no 내역 팝업 조회
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchHangerRackReportDtlListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_rck_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchHangerRackReportDtlListDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.EQ_NO" ).append("\n"); 
		query.append("	, A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("	, B.LSTM_CD" ).append("\n"); 
		query.append("#if (${p_loc_cd} != '' && ${p_loc_tp} != 'YARD')" ).append("\n"); 
		query.append("	, @[p_loc_tp] AS P_LOC_TP" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	, (SELECT ME.RCC_CD || '/' || ME.LCC_CD || '/' || ME.SCC_CD " ).append("\n"); 
		query.append("		FROM MDM_EQ_ORZ_CHT ME, MDM_LOCATION ML" ).append("\n"); 
		query.append("	    WHERE ME.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("    	    AND ML.LOC_CD = SUBSTR(A.MNR_FLG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("        	AND ROWNUM = 1" ).append("\n"); 
		query.append("	) AS P_LOC_TP" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, A.MNR_FLG_YD_CD" ).append("\n"); 
		query.append("	, A.MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append("	, A.MNR_HNGR_TRF_CD" ).append("\n"); 
		query.append("    ,  (SELECT D.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("          FROM MNR_GEN_CD D" ).append("\n"); 
		query.append("         WHERE D.PRNT_CD_ID = 'CD00021'" ).append("\n"); 
		query.append("           AND D.MNR_CD_ID = A.MNR_HNGR_RCK_CD) AS MNR_HNGR_RCK_NM" ).append("\n"); 
		query.append("    ,  (SELECT D.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("          FROM MNR_GEN_CD D" ).append("\n"); 
		query.append("         WHERE D.PRNT_CD_ID = 'CD00092'" ).append("\n"); 
		query.append("           AND D.MNR_CD_ID = A.MNR_HNGR_TRF_CD) AS MNR_HNGR_TRF_NM" ).append("\n"); 
		query.append("	, DECODE(A.HNGR_BAR_AMD_QTY, '', 0, A.HNGR_BAR_AMD_QTY) AS INSTALL_QTY" ).append("\n"); 
		query.append("	, DECODE(A.MNR_STS_FLG, 'N', DECODE(B.ACT_INVT_QTY, '', 0, B.ACT_INVT_QTY), 0)  AS COLLECT_SOUND" ).append("\n"); 
		query.append("	, DECODE(A.MNR_STS_FLG, 'N', DECODE(B.MNR_HNGR_DMG_QTY, '', 0, B.MNR_HNGR_DMG_QTY), 0) AS COLLECT_REPAIR" ).append("\n"); 
		query.append("	, DECODE(A.MNR_STS_FLG, 'N', DECODE(B.MNR_LOST_HNGR_QTY, '', 0, B.MNR_LOST_HNGR_QTY), 0) AS COLLECT_MISSING" ).append("\n"); 
		query.append("	, DECODE(A.MNR_STS_FLG, 'N', DECODE(B.MNR_DISP_HNGR_QTY, '', 0, B.MNR_DISP_HNGR_QTY), 0) AS COLLECT_DISPOSAL" ).append("\n"); 
		query.append("	, DECODE(A.MNR_STS_FLG, 'N', DECODE(B.ACT_INVT_QTY, '', 0, B.ACT_INVT_QTY), 0)" ).append("\n"); 
		query.append("		+ DECODE(A.MNR_STS_FLG, 'N', DECODE(B.MNR_HNGR_DMG_QTY, '', 0, B.MNR_HNGR_DMG_QTY), 0)" ).append("\n"); 
		query.append("		+ DECODE(A.MNR_STS_FLG, 'N', DECODE(B.MNR_LOST_HNGR_QTY, '', 0, B.MNR_LOST_HNGR_QTY), 0)" ).append("\n"); 
		query.append("		+ DECODE(A.MNR_STS_FLG, 'N', DECODE(B.MNR_DISP_HNGR_QTY, '', 0, B.MNR_DISP_HNGR_QTY), 0) AS COLLECT_TOTAL" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	MNR_FLG_HIS A" ).append("\n"); 
		query.append("#if (${p_loc_cd} != '' && ${p_loc_tp} != 'YARD')" ).append("\n"); 
		query.append("	, (SELECT A.LOC_CD," ).append("\n"); 
		query.append("	       A.SCC_CD," ).append("\n"); 
		query.append("	       C.LCC_CD," ).append("\n"); 
		query.append("	       C.RCC_CD" ).append("\n"); 
		query.append("	  FROM MDM_LOCATION A," ).append("\n"); 
		query.append("	       MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("	 WHERE A.SCC_CD = C.SCC_CD) C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, MNR_EQ_STS_V B" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("	AND A.MNR_FLG_TP_CD = 'HGR'" ).append("\n"); 
		query.append("	AND A.MNR_FLG_INP_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[from_date], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("							AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_date], 'YYYY-MM-DD') + 0.99999, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("	AND A.MNR_HNGR_BAR_TP_CD = 'S'" ).append("\n"); 
		query.append("#if (${mnr_hngr_rck_cd} != '' && ${mnr_hngr_rck_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND A.MNR_HNGR_RCK_CD = @[mnr_hngr_rck_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_hngr_trf_cd} != '' && ${mnr_hngr_trf_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND A.MNR_HNGR_TRF_CD = @[mnr_hngr_trf_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_loc_cd} != '')" ).append("\n"); 
		query.append("     #if (${p_loc_tp} == 'RCC')" ).append("\n"); 
		query.append("	AND SUBSTR(A.MNR_FLG_YD_CD,1,5) = C.LOC_CD" ).append("\n"); 
		query.append("	AND C.RCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("     #elseif (${p_loc_tp} == 'LCC')" ).append("\n"); 
		query.append("	AND SUBSTR(A.MNR_FLG_YD_CD,1,5) = C.LOC_CD" ).append("\n"); 
		query.append("	AND C.LCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("     #elseif (${p_loc_tp} == 'SCC')" ).append("\n"); 
		query.append("	AND SUBSTR(A.MNR_FLG_YD_CD,1,5) = C.LOC_CD" ).append("\n"); 
		query.append("	AND C.SCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("     #else" ).append("\n"); 
		query.append("	AND SUBSTR(A.MNR_FLG_YD_CD,1,5) = @[p_loc_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.MNR_FLG_INP_DT, @[user_ofc_cd]), 'YYYY-MM') = @[year_month]" ).append("\n"); 
		query.append("    AND SUBSTR(A.MNR_FLG_YD_CD, 1, 5) = @[location]" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("    AND DECODE(SUBSTR(A.EQ_TPSZ_CD, 2, 1), '2', 1, 0) = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("	A.EQ_NO," ).append("\n"); 
		query.append("	A.MNR_FLG_SEQ ASC" ).append("\n"); 

	}
}