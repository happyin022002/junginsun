/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SalesRPTDBDAOSearchRPTbyOfc070List11RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchRPTbyOfc070List11RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Report-vs QTA
	  * @SJH.20140814 : COA_BKG_EXPN_DTL_WK -> COA_BKG_EXPN_DTL
	  * </pre>
	  */
	public SalesRPTDBDAOSearchRPTbyOfc070List11RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_prev_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_curr_week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchRPTbyOfc070List11RSQL").append("\n"); 
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
		query.append("SELECT 	''	" ).append("\n"); 
		query.append("#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("  ,OFC_CD1		" ).append("\n"); 
		query.append("  ,OFC_CD2		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Report */		" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='T')" ).append("\n"); 
		query.append("  ,TRD_CD " ).append("\n"); 
		query.append("#elseif (${f_rpt_item} =='S')" ).append("\n"); 
		query.append("  ,TRD_CD " ).append("\n"); 
		query.append("  ,SUB_TRD_CD " ).append("\n"); 
		query.append("#elseif (${f_rpt_item} =='L')" ).append("\n"); 
		query.append("  ,TRD_CD " ).append("\n"); 
		query.append("  ,SUB_TRD_CD " ).append("\n"); 
		query.append("  ,RLANE_CD " ).append("\n"); 
		query.append("#elseif (${f_rpt_item} =='V')" ).append("\n"); 
		query.append("  ,TRD_CD " ).append("\n"); 
		query.append("  ,SUB_TRD_CD " ).append("\n"); 
		query.append("  ,RLANE_CD " ).append("\n"); 
		query.append("  ,VSL_CD " ).append("\n"); 
		query.append("  ,SKD_VOY_NO " ).append("\n"); 
		query.append("  ,DIR_CD 			" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("/* Directory Display */" ).append("\n"); 
		query.append("#if(${f_rpt_item} !='V' && ${f_dir_sts} =='Y')" ).append("\n"); 
		query.append("  ,DIR_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  ,CURR_LOAD        ,PREV_LOAD  " ).append("\n"); 
		query.append("  ,PREV_REV         ,CURR_REV  " ).append("\n"); 
		query.append("  ,PREV_CM          ,CURR_CM    " ).append("\n"); 
		query.append("  ,DECODE(PREV_LOAD,0,0, PREV_REV/PREV_LOAD) AS PREV_RPB " ).append("\n"); 
		query.append("  ,DECODE(CURR_LOAD,0,0, CURR_REV/CURR_LOAD) AS CURR_RPB " ).append("\n"); 
		query.append("  ,DECODE(PREV_LOAD,0,0, PREV_CM/PREV_LOAD) AS PREV_CMB " ).append("\n"); 
		query.append("  ,DECODE(CURR_LOAD,0,0, CURR_CM/CURR_LOAD) AS CURR_CMB " ).append("\n"); 
		query.append("  ,PREV_BSA_CAPA " ).append("\n"); 
		query.append("  ,CURR_BSA_CAPA " ).append("\n"); 
		query.append("  ,DECODE(PREV_BSA_CAPA,0,0, PREV_LOAD/PREV_BSA_CAPA*100) AS PREV_LF " ).append("\n"); 
		query.append("  ,DECODE(CURR_BSA_CAPA,0,0, CURR_LOAD/CURR_BSA_CAPA*100) AS CURR_LF " ).append("\n"); 
		query.append("  ,DECODE(PREV_LOAD,  0,0,((CURR_LOAD-PREV_LOAD)    /ABS(PREV_LOAD))  *100)    AS LOAD_CHNG  " ).append("\n"); 
		query.append("  ,DECODE(PREV_REV,   0,0,((CURR_REV-PREV_REV)      /ABS(PREV_REV))   *100)    AS REV_CHNG  " ).append("\n"); 
		query.append("  ,DECODE(PREV_CM,    0,0,((CURR_CM-PREV_CM)        /ABS(PREV_CM))    *100)    AS CM_CHNG  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,CURR_BSA_CAPA-PREV_BSA_CAPA                                                 AS BSA_CAPA_CHNG  " ).append("\n"); 
		query.append("  ,DECODE(CURR_BSA_CAPA  ,0,0,CURR_LOAD/CURR_BSA_CAPA*100)-DECODE(PREV_BSA_CAPA,0,0,PREV_LOAD/PREV_BSA_CAPA*100) AS LF_CHNG " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,DECODE(CURR_LOAD,0,0,CURR_REV/CURR_LOAD)-DECODE(PREV_LOAD,0,0,PREV_REV/PREV_LOAD) AS RPB_CHNG  " ).append("\n"); 
		query.append("  ,DECODE(CURR_LOAD, 0,0,CURR_CM/CURR_LOAD)-DECODE(PREV_LOAD, 0,0,PREV_CM/PREV_LOAD) AS CMB_CHNG  " ).append("\n"); 
		query.append("  ,ROUND((CURR_LOAD-PREV_LOAD)*DECODE(PREV_LOAD,0,0,PREV_REV/PREV_LOAD), 5)                                            AS BY_LOAD_GREV  " ).append("\n"); 
		query.append("  ,ROUND((DECODE(CURR_LOAD,0,0,CURR_REV/CURR_LOAD)-DECODE(PREV_LOAD,0,0,PREV_REV/PREV_LOAD))*CURR_LOAD, 5)             AS BY_RPB_GREV  " ).append("\n"); 
		query.append("  ,ROUND((CURR_LOAD-PREV_LOAD)*(DECODE(PREV_LOAD,0,0,PREV_CM_COST/PREV_LOAD)), 5)                                      AS BY_LOAD_COST  " ).append("\n"); 
		query.append("  ,ROUND(((DECODE(CURR_LOAD,0,0,CURR_CM_COST/CURR_LOAD))-(DECODE(PREV_LOAD,0,0,PREV_CM_COST/PREV_LOAD)))*CURR_LOAD, 5) AS BY_CPB_COST  " ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(PREV_LOAD) OVER(),0)*100 , 5)                                                               AS PREV_LOAD_SHARE  " ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(CURR_LOAD) OVER(),0)*100 , 5)                                                               AS CURR_LOAD_SHARE  " ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(PREV_CM)   OVER(),0)*100 , 5)                                                               AS PREV_CM_SHARE  " ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(CURR_CM)   OVER(),0)*100 , 5)                                                               AS CURR_CM_SHARE   " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("    SELECT '' 				" ).append("\n"); 
		query.append(" 	#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("       ,ofc_cd1		" ).append("\n"); 
		query.append("       ,ofc_cd2		" ).append("\n"); 
		query.append("	#end  	" ).append("\n"); 
		query.append("	#if(${f_rpt_item} =='T')" ).append("\n"); 
		query.append("        ,TRD_CD " ).append("\n"); 
		query.append("    #elseif (${f_rpt_item} =='S')" ).append("\n"); 
		query.append("        ,TRD_CD " ).append("\n"); 
		query.append("        ,SUB_TRD_CD " ).append("\n"); 
		query.append("    #elseif (${f_rpt_item} =='L')" ).append("\n"); 
		query.append("        ,TRD_CD " ).append("\n"); 
		query.append("        ,SUB_TRD_CD " ).append("\n"); 
		query.append("        ,RLANE_CD " ).append("\n"); 
		query.append("    #elseif (${f_rpt_item} =='V')" ).append("\n"); 
		query.append("        ,TRD_CD " ).append("\n"); 
		query.append("        ,SUB_TRD_CD " ).append("\n"); 
		query.append("        ,RLANE_CD " ).append("\n"); 
		query.append("        ,VSL_CD " ).append("\n"); 
		query.append("        ,SKD_VOY_NO " ).append("\n"); 
		query.append("        ,DIR_CD " ).append("\n"); 
		query.append("    #end		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	#if(${f_rpt_item} !='V' && ${f_dir_sts} =='Y')" ).append("\n"); 
		query.append("        ,DIR_CD " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), BKG_QTY)),0)             AS PREV_LOAD" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), BKG_QTY)),0)             AS CURR_LOAD" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), FR_REV)),0)              AS PREV_REV" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), FR_REV)),0)              AS CURR_REV" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), TOT_REV - CM_COST)),0)   AS PREV_CM" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), TOT_REV - CM_COST)),0)   AS CURR_CM        " ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), VVD_BSA_CAPA)),0)                 AS PREV_BSA_CAPA" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), VVD_BSA_CAPA)),0)                 AS CURR_BSA_CAPA" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), CM_COST)),0)                      AS PREV_CM_COST" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), CM_COST)),0)                      AS CURR_CM_COST" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("    FROM ( " ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("          /*+ USE_HASH(A2, A1, A3, A4) PARALLEL(A2, 4) */ " ).append("\n"); 
		query.append("          '' 		  " ).append("\n"); 
		query.append("		  #if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("		      #if(${f_ofc_lvl1} =='1') " ).append("\n"); 
		query.append("		        ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='2')" ).append("\n"); 
		query.append("		        ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='3')" ).append("\n"); 
		query.append("		        ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='4')" ).append("\n"); 
		query.append("		        ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='5')" ).append("\n"); 
		query.append("		        ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='6')" ).append("\n"); 
		query.append("		        ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='7')" ).append("\n"); 
		query.append("		        ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("		      #end OFC_CD1" ).append("\n"); 
		query.append("		      " ).append("\n"); 
		query.append("		      #if(${f_ofc_lvl2} =='1') " ).append("\n"); 
		query.append("		        ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='2')" ).append("\n"); 
		query.append("		        ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='3')" ).append("\n"); 
		query.append("		        ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='4')" ).append("\n"); 
		query.append("		        ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='5')" ).append("\n"); 
		query.append("		        ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='6')" ).append("\n"); 
		query.append("		        ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='7')" ).append("\n"); 
		query.append("		        ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("		      #end OFC_CD2" ).append("\n"); 
		query.append("		  #end		" ).append("\n"); 
		query.append("          ,A1.TRD_CD " ).append("\n"); 
		query.append("          ,A1.SUB_TRD_CD " ).append("\n"); 
		query.append("          ,A1.RLANE_CD " ).append("\n"); 
		query.append("          ,A1.VSL_CD " ).append("\n"); 
		query.append("          ,A1.SKD_VOY_NO " ).append("\n"); 
		query.append("          ,A1.DIR_CD " ).append("\n"); 
		query.append("          ,NVL(A3.LOD_SPL_CNG_FLG,'N') AS LOD_SPL_CNG_FLG  " ).append("\n"); 
		query.append("          ,A1.COST_WK   " ).append("\n"); 
		query.append("          ,DECODE(NVL(A3.LOD_SPL_CNG_FLG,'N'), 'Y', SUM(DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1,1),'2',NVL(A2.BKG_QTY,0),NVL(A2.BKG_QTY,0)*2))  " ).append("\n"); 
		query.append("                                            , 'N', MAX(A1.VVD_BSA_CAPA))        AS VVD_BSA_CAPA  " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1,1),'2',NVL(A2.BKG_QTY,0),NVL(A2.BKG_QTY,0)*2)),0) AS BKG_QTY  " ).append("\n"); 
		query.append("          ,NVL(SUM(A2.BKG_REV+A2.BKG_OFT_REV),0)                                        AS FR_REV  " ).append("\n"); 
		query.append("          ,NVL(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV),0)         AS TOT_REV  " ).append("\n"); 
		query.append("          ,NVL(SUM(A2.DMDT_COM_AMT),0)                                                  AS DMDT  		" ).append("\n"); 
		query.append("          ,NVL(SUM(A2.PA_CM_COST_TTL_AMT),0) AS CM_COST  				 		" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("           COA_BKG_EXPN_DTL A2                   	" ).append("\n"); 
		query.append("          ,COA_MON_VVD A1 " ).append("\n"); 
		query.append("          ,COA_LANE_RGST A3 " ).append("\n"); 
		query.append("          ,COA_OFC_LVL A4             " ).append("\n"); 
		query.append("        WHERE A1.TRD_CD              = A2.TRD_CD " ).append("\n"); 
		query.append("          AND A1.RLANE_CD            = A2.RLANE_CD " ).append("\n"); 
		query.append("          AND A1.IOC_CD              = A2.IOC_CD " ).append("\n"); 
		query.append("          AND A1.VSL_CD              = A2.VSL_CD " ).append("\n"); 
		query.append("          AND A1.SKD_VOY_NO          = A2.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND A1.DIR_CD              = A2.DIR_CD           " ).append("\n"); 
		query.append("          AND SUBSTR(A1.SLS_YRMON,1,4) || A1.COST_WK BETWEEN @[f_prev_week] AND @[f_curr_week] " ).append("\n"); 
		query.append("		  AND SUBSTR(A1.SLS_YRMON,1,4) || A1.COST_WK = SUBSTR(A2.SLS_YRMON,1,4) || A2.COST_WK" ).append("\n"); 
		query.append("		  AND A1.SLS_YRMON          = A2.SLS_YRMON" ).append("\n"); 
		query.append("		  AND A1.COST_WK            = A2.COST_WK		  " ).append("\n"); 
		query.append("		  AND A1.TRD_CD              = A3.TRD_CD " ).append("\n"); 
		query.append("          AND A1.RLANE_CD            = A3.RLANE_CD " ).append("\n"); 
		query.append("          AND A1.IOC_CD              = A3.IOC_CD " ).append("\n"); 
		query.append("          AND A1.DIR_CD              = A3.DIR_CD " ).append("\n"); 
		query.append("          AND A2.SLS_YRMON           BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON           " ).append("\n"); 
		query.append("          #if(${f_ofc_vw} =='C')" ).append("\n"); 
		query.append("			AND A2.AGMT_SGN_OFC_CD = A4.OFC_CD" ).append("\n"); 
		query.append("		  #elseif (${f_ofc_vw} =='L')" ).append("\n"); 
		query.append("			AND A2.SLS_OFC_CD = A4.OFC_CD" ).append("\n"); 
		query.append("		  #else" ).append("\n"); 
		query.append("			AND 1 = 0" ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("		  " ).append("\n"); 
		query.append("          AND NVL(A1.DELT_FLG,'N')   = 'N' " ).append("\n"); 
		query.append("  		#if(${f_bkg_sts} =='Y')" ).append("\n"); 
		query.append("  		      AND A2.BKG_STS_CD        IN ('F','S','W') " ).append("\n"); 
		query.append("  		#else                                         " ).append("\n"); 
		query.append("            AND A2.BKG_STS_CD        IN ('F','S') " ).append("\n"); 
		query.append("        #end      " ).append("\n"); 
		query.append("          AND A2.BKG_CGO_TP_CD       <> 'P' " ).append("\n"); 
		query.append("          AND A2.BL_NO_TP            IN ('M','0') " ).append("\n"); 
		query.append("                    			" ).append("\n"); 
		query.append("		#if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("		  #if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("          AND DECODE('${f_ofc_lvl1}', '1', A4.OFC_N1ST_LVL_CD, '2', A4.OFC_N2ND_LVL_CD, '3', A4.OFC_N3RD_LVL_CD, '4', A4.OFC_N4TH_LVL_CD, '5', A4.OFC_N5TH_LVL_CD, '6', A4.OFC_N6TH_LVL_CD, '7', A4.OFC_N7TH_LVL_CD) = '${f_ofc_cd}'  " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("          AND A4.OFC_CD = '${f_ofc_cd}'  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${f_ofc_lvl1}=='6' || ${f_ofc_lvl1}=='7')" ).append("\n"); 
		query.append("    		AND A4.OFC_LVL = '${f_ofc_lvl1}'" ).append("\n"); 
		query.append("  		#else" ).append("\n"); 
		query.append("    		AND A4.OFC_LVL < '9'" ).append("\n"); 
		query.append("  		#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("        GROUP BY 	'' " ).append("\n"); 
		query.append("/*	Office Display */		" ).append("\n"); 
		query.append("		#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("		      #if(${f_ofc_lvl1} =='1') " ).append("\n"); 
		query.append("		        ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='2')" ).append("\n"); 
		query.append("		        ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='3')" ).append("\n"); 
		query.append("		        ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='4')" ).append("\n"); 
		query.append("		        ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='5')" ).append("\n"); 
		query.append("		        ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='6')" ).append("\n"); 
		query.append("		        ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl1} =='7')" ).append("\n"); 
		query.append("		        ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("		      #end " ).append("\n"); 
		query.append("		      " ).append("\n"); 
		query.append("		      #if(${f_ofc_lvl2} =='1') " ).append("\n"); 
		query.append("		        ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='2')" ).append("\n"); 
		query.append("		        ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='3')" ).append("\n"); 
		query.append("		        ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='4')" ).append("\n"); 
		query.append("		        ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='5')" ).append("\n"); 
		query.append("		        ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='6')" ).append("\n"); 
		query.append("		        ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("		      #elseif (${f_ofc_lvl2} =='7')" ).append("\n"); 
		query.append("		        ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("		      #end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("          ,A1.COST_WK  	" ).append("\n"); 
		query.append("          ,A1.TRD_CD " ).append("\n"); 
		query.append("          ,A1.SUB_TRD_CD " ).append("\n"); 
		query.append("          ,A1.RLANE_CD " ).append("\n"); 
		query.append("          ,A1.VSL_CD " ).append("\n"); 
		query.append("          ,A1.SKD_VOY_NO " ).append("\n"); 
		query.append("          ,A1.DIR_CD " ).append("\n"); 
		query.append("/*	Directory Display */		" ).append("\n"); 
		query.append("		#if(${f_rpt_item} !='V' && ${f_dir_sts} =='Y')" ).append("\n"); 
		query.append("          ,A1.DIR_CD " ).append("\n"); 
		query.append("    	#end	" ).append("\n"); 
		query.append("          ,A3.LOD_SPL_CNG_FLG " ).append("\n"); 
		query.append("          ,A1.VVD_BSA_CAPA 		" ).append("\n"); 
		query.append("      ) b1  " ).append("\n"); 
		query.append("    GROUP BY '' " ).append("\n"); 
		query.append("		#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("      ,OFC_CD1		" ).append("\n"); 
		query.append("      ,OFC_CD2		" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if(${f_rpt_item} =='T')" ).append("\n"); 
		query.append("      ,TRD_CD " ).append("\n"); 
		query.append("    #elseif (${f_rpt_item} =='S')" ).append("\n"); 
		query.append("      ,TRD_CD " ).append("\n"); 
		query.append("      ,SUB_TRD_CD " ).append("\n"); 
		query.append("    #elseif (${f_rpt_item} =='L')" ).append("\n"); 
		query.append("      ,TRD_CD " ).append("\n"); 
		query.append("      ,SUB_TRD_CD " ).append("\n"); 
		query.append("      ,RLANE_CD " ).append("\n"); 
		query.append("    #elseif (${f_rpt_item} =='V')" ).append("\n"); 
		query.append("      ,TRD_CD " ).append("\n"); 
		query.append("      ,SUB_TRD_CD " ).append("\n"); 
		query.append("      ,RLANE_CD " ).append("\n"); 
		query.append("      ,VSL_CD " ).append("\n"); 
		query.append("      ,SKD_VOY_NO " ).append("\n"); 
		query.append("      ,DIR_CD 			" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append(" /* Directory Display */" ).append("\n"); 
		query.append("		#if(${f_rpt_item} !='V' && ${f_dir_sts} =='Y')" ).append("\n"); 
		query.append("		  ,DIR_CD " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("ORDER BY ''" ).append("\n"); 
		query.append("  #if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("  ,OFC_CD1		" ).append("\n"); 
		query.append("  ,OFC_CD2		" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  /* Report */		" ).append("\n"); 
		query.append("  #if(${f_rpt_item} =='T')" ).append("\n"); 
		query.append("    ,TRD_CD " ).append("\n"); 
		query.append("  #elseif (${f_rpt_item} =='S')" ).append("\n"); 
		query.append("    ,TRD_CD " ).append("\n"); 
		query.append("    ,SUB_TRD_CD " ).append("\n"); 
		query.append("  #elseif (${f_rpt_item} =='L')" ).append("\n"); 
		query.append("    ,TRD_CD " ).append("\n"); 
		query.append("    ,SUB_TRD_CD " ).append("\n"); 
		query.append("    ,RLANE_CD " ).append("\n"); 
		query.append("  #elseif (${f_rpt_item} =='V')" ).append("\n"); 
		query.append("    ,TRD_CD " ).append("\n"); 
		query.append("    ,SUB_TRD_CD " ).append("\n"); 
		query.append("    ,RLANE_CD " ).append("\n"); 
		query.append("    ,VSL_CD " ).append("\n"); 
		query.append("    ,SKD_VOY_NO " ).append("\n"); 
		query.append("    ,DIR_CD 			" ).append("\n"); 
		query.append("  #end" ).append("\n"); 

	}
}