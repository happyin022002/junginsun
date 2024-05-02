/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOSearchBDRBookingStatusList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBDRBookingStatusList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBDRBookingStatusList1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBDRBookingStatusList1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBDRBookingStatusList1RSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       VVD_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       TRNK_BDR_DYS," ).append("\n"); 
		query.append("       DECODE(TRNK_MNL_BDR_DT,NULL,TO_CHAR(TRNK_BDR_DT, 'YYYY-MM-DD'),TO_CHAR(TRNK_MNL_BDR_DT, 'YYYY-MM-DD')) TRNK_BDR_DT," ).append("\n"); 
		query.append("       TRNK_BDR_FLG," ).append("\n"); 
		query.append("       FDR_BDR_DYS," ).append("\n"); 
		query.append("	   DECODE(FDR_MNL_BDR_DT,null,TO_CHAR(FDR_BDR_DT, 'YYYY-MM-DD'),TO_CHAR(FDR_MNL_BDR_DT, 'YYYY-MM-DD')) FDR_BDR_DT," ).append("\n"); 
		query.append("       FDR_BDR_FLG" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            C.SLAN_CD, C.SKD_DIR_CD," ).append("\n"); 
		query.append("            C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD VVD_CD, " ).append("\n"); 
		query.append("            C.POL_CD,  A.VPS_ETD_DT," ).append("\n"); 
		query.append("            C.POD_CD," ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            /*TRUNK*/" ).append("\n"); 
		query.append("            NVL(B.TRNK_BDR_DYS, 0) TRNK_BDR_DYS ,/*trunk_day*/" ).append("\n"); 
		query.append("            DECODE(C.TRNK_BDR_FLG, 'Y', C.TRNK_AUTO_BDR_DT,  " ).append("\n"); 
		query.append("                                        DECODE(C.TRNK_MNL_BDR_FLG, 'Y', C.TRNK_MNL_BDR_DT," ).append("\n"); 
		query.append("                                             NVL(C.TRNK_ESTM_BDR_DT, A.VPS_ETD_DT + NVL(B.TRNK_BDR_DYS, 0)))) TRNK_BDR_DT,/*trnk_bdr_time*/  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            DECODE(C.TRNK_BDR_FLG, 'Y', 'Yes',  " ).append("\n"); 
		query.append("                                           DECODE(C.TRNK_MNL_BDR_FLG, 'Y', 'Yes', 'No')) TRNK_BDR_FLG, /*trunk_bdr*/" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            /*FEEDER*/" ).append("\n"); 
		query.append("            NVL(B.FDR_BDR_DYS, 0) FDR_BDR_DYS ,/*feeder_day*/" ).append("\n"); 
		query.append("            DECODE(C.FDR_BDR_FLG, 'Y', C.FDR_AUTO_BDR_DT,  " ).append("\n"); 
		query.append("                                   DECODE(C.FDR_MNL_BDR_FLG, 'Y', C.FDR_MNL_BDR_DT,  " ).append("\n"); 
		query.append("                                     NVL(C.FDR_ESTM_BDR_DT, A.VPS_ETD_DT + NVL(B.TRNK_BDR_DYS, 0)))) FDR_BDR_DT ,  /*feeder_bdr_time*/" ).append("\n"); 
		query.append("            CASE WHEN C.FDR_BDR_FLG = 'Y' OR C.FDR_MNL_BDR_FLG = 'Y' OR C.FDR_AUTO_BDR_FLG = 'Y' THEN 'Yes' ELSE 'No' END AS FDR_BDR_FLG, /*feeder_bdr*/" ).append("\n"); 
		query.append("			C.TRNK_MNL_BDR_DT," ).append("\n"); 
		query.append("			C.FDR_MNL_BDR_DT" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD A, BKG_BDR_TM B, BKG_VVD_BDR_LOG C" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        /* Common*/" ).append("\n"); 
		query.append("        AND B.SLAN_CD(+) = C.SLAN_CD" ).append("\n"); 
		query.append("        AND B.SKD_DIR_CD(+) = C.SKD_DIR_CD " ).append("\n"); 
		query.append("        AND B.POL_CD(+) = C.POL_CD" ).append("\n"); 
		query.append("        AND B.POD_CD(+) = C.POD_CD" ).append("\n"); 
		query.append("        AND A.VSL_CD = C.VSL_CD " ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO = C.SKD_VOY_NO " ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD = C.SKD_DIR_CD " ).append("\n"); 
		query.append("        AND A.VPS_PORT_CD  = C.POL_CD" ).append("\n"); 
		query.append("		AND A.CLPT_IND_SEQ = C.POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /* 2 Lane*/" ).append("\n"); 
		query.append("        #if (${slan_cd} != '') " ).append("\n"); 
		query.append("        AND C.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /*3 Bound*/" ).append("\n"); 
		query.append("        #if (${skd_dir_cd} != '' && ${skd_dir_cd} != 'A') " ).append("\n"); 
		query.append("        AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /*4 VVD*/" ).append("\n"); 
		query.append("        #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("        AND C.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("        AND C.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("        AND C.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1) " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /*5 POL*/" ).append("\n"); 
		query.append("        #if (${pol_cd} != '') " ).append("\n"); 
		query.append("        AND C.POL_CD LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /*6 POD*/" ).append("\n"); 
		query.append("        #if (${pod_cd} != '') " ).append("\n"); 
		query.append("        AND C.POD_CD LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /*7  Date Condition*/" ).append("\n"); 
		query.append("        #if ('POL/ETD' == ${period_type}) " ).append("\n"); 
		query.append("            #if (${from_dt} != '') " ).append("\n"); 
		query.append("            AND A.VPS_ETD_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${to_dt} != '') " ).append("\n"); 
		query.append("            AND A.VPS_ETD_DT < TO_DATE(@[to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /*9  Date Condition*/" ).append("\n"); 
		query.append("        #if ('POD/ETA' == ${period_type}) " ).append("\n"); 
		query.append("            #if (${from_dt} != '') " ).append("\n"); 
		query.append("            AND A.VPS_ETA_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${to_dt} != '') " ).append("\n"); 
		query.append("            AND A.VPS_ETA_DT < TO_DATE(@[to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /* 11 BDR Date*/" ).append("\n"); 
		query.append("        #if (${bdr_dt} != '') " ).append("\n"); 
		query.append("        AND DECODE(C.TRNK_BDR_FLG, 'Y', C.TRNK_AUTO_BDR_DT,  " ).append("\n"); 
		query.append("                                             DECODE(C.TRNK_MNL_BDR_FLG, 'Y', C.TRNK_MNL_BDR_DT," ).append("\n"); 
		query.append("                                             NVL(C.TRNK_ESTM_BDR_DT, A.VPS_ETD_DT + NVL(B.TRNK_BDR_DYS, 0)))) >= TO_DATE(@[bdr_dt] , 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                             " ).append("\n"); 
		query.append("        AND DECODE(C.TRNK_BDR_FLG, 'Y', C.TRNK_AUTO_BDR_DT,  " ).append("\n"); 
		query.append("                                             DECODE(C.TRNK_MNL_BDR_FLG, 'Y', C.TRNK_MNL_BDR_DT," ).append("\n"); 
		query.append("                                             NVL(C.TRNK_ESTM_BDR_DT, A.VPS_ETD_DT + NVL(B.TRNK_BDR_DYS, 0)))) < TO_DATE(@[bdr_dt], 'YYYY-MM-DD') + 1                                    " ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("		ORDER BY C.POL_CD, VPS_ETD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}