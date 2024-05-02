/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRepairPFMCBySPListSPDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.07
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.03.07 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchRepairPFMCBySPListSPDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepairPFMCBySPListSPData
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRepairPFMCBySPListSPDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fqa_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fqa_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchRepairPFMCBySPListSPDataRSQL").append("\n"); 
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
		query.append("	RH.EQ_KND_CD EQ_TYPE," ).append("\n"); 
		query.append("	RH.EQ_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("	MAX(MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD)) RHQ," ).append("\n"); 
		query.append("	RH.COST_OFC_CD OFC_CD," ).append("\n"); 
		query.append("	RH.RPR_YD_CD YARD_CD," ).append("\n"); 
		query.append("	VD.VNDR_LGL_ENG_NM SP_NM," ).append("\n"); 
		query.append("    VD.VNDR_SEQ," ).append("\n"); 
		query.append("    MAX(FQ.FQA_QTY) FQA_QTY," ).append("\n"); 
		query.append("    MAX(FQ.FQA_DT) FQA_DT," ).append("\n"); 
		query.append("    DECODE(@[curr_cd], 'Y', 'USD', MAX(RH.CURR_CD)) CURR," ).append("\n"); 
		query.append("	COUNT(*) UNIT," ).append("\n"); 
		query.append("	SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), " ).append("\n"); 
		query.append("                                             --RD.MNR_WRK_AMT" ).append("\n"); 
		query.append("                                             (SELECT SUM(RD.MNR_WRK_AMT)" ).append("\n"); 
		query.append("                                                FROM MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("                                               WHERE RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("                                                 AND RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                                                 AND RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("                                                 AND RH.RPR_RQST_LST_VER_FLG = RD.RPR_RQST_LST_VER_FLG)" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("        ) AMT," ).append("\n"); 
		query.append("	ROUND(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), " ).append("\n"); 
		query.append("                                                   --RD.MNR_WRK_AMT" ).append("\n"); 
		query.append("                                                   (SELECT SUM(RD.MNR_WRK_AMT)" ).append("\n"); 
		query.append("                                                      FROM MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("             										 WHERE RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("                                                       AND RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                                                       AND RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("                                                       AND RH.RPR_RQST_LST_VER_FLG = RD.RPR_RQST_LST_VER_FLG)" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("              )/COUNT(*),2" ).append("\n"); 
		query.append("          ) AVG_AMT," ).append("\n"); 
		query.append("	ROUND(AVG(DECODE((NVL(OD.RPR_RSLT_DT, SYSDATE) - NVL(RH.EQ_DMG_DT,RH.RQST_DT)),0,1,(NVL(OD.RPR_RSLT_DT, SYSDATE) - NVL(RH.EQ_DMG_DT,RH.RQST_DT))))) AVG_DAYS" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI') " ).append("\n"); 
		query.append("FROM   MNR_RPR_RQST_HDR RH, MNR_ORD_DTL OD, " ).append("\n"); 
		query.append("       MDM_VENDOR VD," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("        VNDR_SEQ," ).append("\n"); 
		query.append("        YD_CD," ).append("\n"); 
		query.append("        COUNT(FLD_AUD_DT) FQA_QTY," ).append("\n"); 
		query.append("        MAX(FLD_AUD_DT) FQA_DT" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT VNDR_SEQ,YD_CD,FLD_AUD_DT" ).append("\n"); 
		query.append("        FROM  MNR_FLD_QLTY_AUD_RSLT" ).append("\n"); 
		query.append("        GROUP BY VNDR_SEQ,YD_CD,FLD_AUD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#if (${fqa_fm_dt} != '' && ${fqa_to_dt} != '')" ).append("\n"); 
		query.append("      WHERE   FLD_AUD_DT BETWEEN  TO_DATE(@[fqa_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[fqa_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      GROUP BY VNDR_SEQ,YD_CD" ).append("\n"); 
		query.append("      ) FQ" ).append("\n"); 
		query.append("WHERE RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_SEQ        = OD.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("AND   RH.VNDR_SEQ = VD.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND   RH.VNDR_SEQ = FQ.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND   RH.RPR_YD_CD = FQ.YD_CD(+)" ).append("\n"); 
		query.append("AND RH.CRE_DT --RH.RQST_DT" ).append("\n"); 
		query.append("    BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[fm_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'WI') " ).append("\n"); 
		query.append("FROM   MNR_RPR_RQST_HDR RH, MNR_ORD_DTL OD, " ).append("\n"); 
		query.append("	   MNR_ORD_HDR OH, MDM_VENDOR VD," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("        VNDR_SEQ," ).append("\n"); 
		query.append("        YD_CD," ).append("\n"); 
		query.append("        COUNT(FLD_AUD_DT) FQA_QTY," ).append("\n"); 
		query.append("        MAX(FLD_AUD_DT) FQA_DT" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT VNDR_SEQ,YD_CD,FLD_AUD_DT" ).append("\n"); 
		query.append("        FROM  MNR_FLD_QLTY_AUD_RSLT" ).append("\n"); 
		query.append("        GROUP BY VNDR_SEQ,YD_CD,FLD_AUD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#if (${fqa_fm_dt} != '' && ${fqa_to_dt} != '')" ).append("\n"); 
		query.append("      WHERE   FLD_AUD_DT BETWEEN  TO_DATE(@[fqa_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[fqa_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      GROUP BY VNDR_SEQ,YD_CD" ).append("\n"); 
		query.append("      ) FQ" ).append("\n"); 
		query.append("WHERE RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   OH.MNR_ORD_SEQ        = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   RH.VNDR_SEQ = VD.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND   RH.VNDR_SEQ = FQ.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND   RH.RPR_YD_CD = FQ.YD_CD(+)" ).append("\n"); 
		query.append("AND OH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[fm_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'II') " ).append("\n"); 
		query.append("FROM   MNR_RPR_RQST_HDR RH," ).append("\n"); 
		query.append("       MNR_ORD_DTL OD, MNR_PAY_INV_WRK IW, MDM_VENDOR VD," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("        VNDR_SEQ," ).append("\n"); 
		query.append("        YD_CD," ).append("\n"); 
		query.append("        COUNT(FLD_AUD_DT) FQA_QTY," ).append("\n"); 
		query.append("        MAX(FLD_AUD_DT) FQA_DT" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT VNDR_SEQ,YD_CD,FLD_AUD_DT" ).append("\n"); 
		query.append("        FROM  MNR_FLD_QLTY_AUD_RSLT" ).append("\n"); 
		query.append("        GROUP BY VNDR_SEQ,YD_CD,FLD_AUD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#if (${fqa_fm_dt} != '' && ${fqa_to_dt} != '')" ).append("\n"); 
		query.append("      WHERE   FLD_AUD_DT BETWEEN  TO_DATE(@[fqa_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[fqa_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      GROUP BY VNDR_SEQ,YD_CD" ).append("\n"); 
		query.append("      ) FQ" ).append("\n"); 
		query.append("WHERE RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_SEQ        = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   OD.PAY_INV_SEQ        = IW.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND   RH.VNDR_SEQ = VD.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND   RH.VNDR_SEQ = FQ.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND   RH.RPR_YD_CD = FQ.YD_CD(+)" ).append("\n"); 
		query.append("AND   IW.ISS_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_type} != 'A' && ${eq_type} != 'A,U,Z,G')" ).append("\n"); 
		query.append("AND   RH.EQ_KND_CD  IN (" ).append("\n"); 
		query.append("		#foreach ($user_eqTypes IN ${eqTypes})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqTypes.size())" ).append("\n"); 
		query.append("				'$user_eqTypes'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eqTypes'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_sz_cd} != '') " ).append("\n"); 
		query.append("	AND	RH.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("				'$user_tpszCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_tpszCds'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A') " ).append("\n"); 
		query.append("AND   MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A') " ).append("\n"); 
		query.append("AND   RH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND   RH.VNDR_SEQ   = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_cd} != '')" ).append("\n"); 
		query.append("AND   RH.RPR_YD_CD  = @[yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY RH.EQ_KND_CD," ).append("\n"); 
		query.append("       RH.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       RH.COST_OFC_CD, " ).append("\n"); 
		query.append("       VD.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       VD.VNDR_SEQ, " ).append("\n"); 
		query.append("#if (${curr_cd} != 'Y')" ).append("\n"); 
		query.append("       RH.CURR_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       RH.RPR_YD_CD" ).append("\n"); 

	}
}