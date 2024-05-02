/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchTireReplacementHistoryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.02.11 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchTireReplacementHistoryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTireReplacementHistoryListData
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchTireReplacementHistoryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchTireReplacementHistoryListDataRSQL").append("\n"); 
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
		query.append("MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD) RHQ," ).append("\n"); 
		query.append("RH.COST_OFC_CD OFC_CD," ).append("\n"); 
		query.append("MV.VNDR_LGL_ENG_NM VNDR_NM," ).append("\n"); 
		query.append("RH.RQST_EQ_NO EQ_NO," ).append("\n"); 
		query.append("Rh.CURR_CD CURR," ).append("\n"); 
		query.append("RD.RPR_QTY RP_QTY," ).append("\n"); 
		query.append("RD.MNR_WRK_AMT RP_AMT," ).append("\n"); 
		query.append("TO_CHAR(RH.RPR_RSLT_DT, 'YYYY-MM-DD') RP_DT" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR RH, MNR_RPR_RQST_DTL RD, MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_LST_VER_FLG = RD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("AND   RH.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   RH.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND   RH.RPR_STS_CD = 'HA'" ).append("\n"); 
		query.append("AND   RD.EQ_CMPO_CD = 'KTA'" ).append("\n"); 
		query.append("AND   RD.EQ_RPR_CD = 'RP'" ).append("\n"); 
		query.append("AND   RH.APRO_DT BETWEEN  GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("AND   RH.RQST_EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RH.APRO_DT DESC" ).append("\n"); 

	}
}