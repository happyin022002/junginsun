/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRepairPFMCByESTListDataSPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.01.14 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchRepairPFMCByESTListDataSPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepairPFMCByESTListDataSP
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRepairPFMCByESTListDataSPRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchRepairPFMCByESTListDataSPRSQL").append("\n"); 
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
		query.append("SELECT MAX(MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD)) RHQ," ).append("\n"); 
		query.append("RH.COST_OFC_CD OFC_CD," ).append("\n"); 
		query.append("RH.VNDR_SEQ SP_CD," ).append("\n"); 
		query.append("MAX((SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = RH.VNDR_SEQ AND ROWNUM =1)) SP_NM," ).append("\n"); 
		query.append("RH.EQ_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("COUNT(distinct RH.RPR_RQST_SEQ) T_QTY," ).append("\n"); 
		query.append("SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), RH.CURR_CD, 'USD', RH.MNR_WRK_AMT)) T_AMT," ).append("\n"); 
		query.append("ROUND(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), RH.CURR_CD, 'USD', RH.MNR_WRK_AMT))/COUNT(distinct RH.RPR_RQST_SEQ), 2) T_AVG" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR RH, MNR_ORD_DTL OD, MNR_ORD_HDR OH, MNR_PAY_INV_WRK IW" ).append("\n"); 
		query.append("WHERE RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("AND   RH.RQST_EQ_NO = OD.EQ_NO(+)" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_SEQ = OD.RPR_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_VER_NO = OD.RPR_RQST_VER_NO(+)" ).append("\n"); 
		query.append("AND   OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND   OD.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("AND   OD.PAY_INV_SEQ        = IW.PAY_INV_SEQ(+)" ).append("\n"); 
		query.append("AND   RH.RQST_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("AND   RH.RQST_EQ_NO = OD.EQ_NO" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_SEQ = OD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_VER_NO = OD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND   OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   OD.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   OD.PAY_INV_SEQ        = IW.PAY_INV_SEQ(+)" ).append("\n"); 
		query.append("AND   OH.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'II')" ).append("\n"); 
		query.append("AND   RH.RQST_EQ_NO = OD.EQ_NO" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_SEQ = OD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_VER_NO = OD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND   OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   OD.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   OD.PAY_INV_SEQ        = IW.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND   IW.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_type} != 'A')" ).append("\n"); 
		query.append("AND   RH.EQ_KND_CD  = @[eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_sz_cd} != '')" ).append("\n"); 
		query.append("AND	  RH.EQ_TPSZ_CD IN (" ).append("\n"); 
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
		query.append("AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("AND RH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND RH.VNDR_SEQ   = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  RH.COST_OFC_CD, RH.VNDR_SEQ, RH.EQ_TPSZ_CD" ).append("\n"); 

	}
}