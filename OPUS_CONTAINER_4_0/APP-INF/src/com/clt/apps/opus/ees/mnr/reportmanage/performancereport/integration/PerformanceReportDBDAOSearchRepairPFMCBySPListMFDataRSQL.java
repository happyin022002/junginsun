/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRepairPFMCBySPListMFDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.01.25 박명신
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

public class PerformanceReportDBDAOSearchRepairPFMCBySPListMFDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepairPFMCBySPListMFData
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRepairPFMCBySPListMFDataRSQL(){
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("component",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchRepairPFMCBySPListMFDataRSQL").append("\n"); 
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
		query.append("MAX(MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD)) RHQ," ).append("\n"); 
		query.append("RH.COST_OFC_CD OFC_CD," ).append("\n"); 
		query.append("DECODE( ESV.LSTM_CD,'OW','MNFR','LP','MNFR','OL','MNFR','LESSOR') LESSOR," ).append("\n"); 
		query.append("ESV.LESSOR_CD LESSOR_CD," ).append("\n"); 
		query.append("ESV.LESSOR_NM LESSOR_NM," ).append("\n"); 
		query.append("DECODE('USD', 'USD', 'USD', RH.CURR_CD) CURR," ).append("\n"); 
		query.append("RH.EQ_KND_CD EQ_TYPE," ).append("\n"); 
		query.append("RH.EQ_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("RD.EQ_LOC_CD LOC," ).append("\n"); 
		query.append("RD.EQ_CMPO_CD COMPO," ).append("\n"); 
		query.append("COUNT(*) UNIT," ).append("\n"); 
		query.append("SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), RH.CURR_CD, 'USD', RD.MNR_WRK_AMT)) AMT" ).append("\n"); 
		query.append("FROM   MNR_RPR_RQST_HDR RH, MNR_RPR_RQST_DTL RD, MNR_EQ_STS_V ESV" ).append("\n"); 
		query.append("WHERE RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND   RH.RQST_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND   RH.RQST_EQ_NO = ESV.EQ_NO" ).append("\n"); 
		query.append("#if (${eq_type} != 'A')" ).append("\n"); 
		query.append("AND   RH.EQ_KND_CD  = @[eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_sz_cd} != '')" ).append("\n"); 
		query.append("AND	RH.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("'$user_tpszCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_tpszCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A')" ).append("\n"); 
		query.append("AND   MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("AND   RH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND   RH.VNDR_SEQ   = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY RH.COST_OFC_CD," ).append("\n"); 
		query.append("DECODE( ESV.LSTM_CD,'OW','MNFR','LP','MNFR','OL','MNFR','LESSOR')," ).append("\n"); 
		query.append("ESV.LESSOR_CD," ).append("\n"); 
		query.append("ESV.LESSOR_NM," ).append("\n"); 
		query.append("DECODE('USD', 'USD', 'USD', RH.CURR_CD)," ).append("\n"); 
		query.append("RH.EQ_KND_CD," ).append("\n"); 
		query.append("RH.EQ_TPSZ_CD," ).append("\n"); 
		query.append("RD.EQ_LOC_CD," ).append("\n"); 
		query.append("RD.EQ_CMPO_CD" ).append("\n"); 
		query.append("#if (${component} != 'A')" ).append("\n"); 
		query.append("HAVING RD.EQ_CMPO_CD = @[component]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}