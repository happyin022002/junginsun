/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SalesRPTDBDAOSearchRPTbyOfc070List12_2014RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.13
*@LastModifier :  최덕우
*@LastVersion : 1.0
* 2016.06.13  최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Duk-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchRPTbyOfc070List12_2014RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Report-vs QTA
	  * [CHM-201641966] 2016.06.10 Sector의 Default를 Sector 에서 Main으로 변경
	  * </pre>
	  */
	public SalesRPTDBDAOSearchRPTbyOfc070List12_2014RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ias_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchRPTbyOfc070List12_2014RSQL").append("\n"); 
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
		query.append("SELECT '' " ).append("\n"); 
		query.append("  ,OFC_CD1" ).append("\n"); 
		query.append("  ,OFC_CD2" ).append("\n"); 
		query.append("  ,COST_YRMON" ).append("\n"); 
		query.append("  ,COST_WK" ).append("\n"); 
		query.append("  ,TRD_CD" ).append("\n"); 
		query.append("  ,DECODE(IAS_RGN_CD,NULL,NULL,MAS_GET_CD_NM_FNC('CD03218', IAS_RGN_CD)) IAS_RGN_CD" ).append("\n"); 
		query.append("  ,DECODE(HUL_BND_CD,NULL,NULL,MAS_GET_CD_NM_FNC('CD03217', HUL_BND_CD)) HUL_BND_CD" ).append("\n"); 
		query.append("  ,SUB_TRD_CD" ).append("\n"); 
		query.append("  ,RLANE_CD" ).append("\n"); 
		query.append("  ,VSL_CD 	" ).append("\n"); 
		query.append("  ,SKD_VOY_NO" ).append("\n"); 
		query.append("  ,DIR_CD" ).append("\n"); 
		query.append("  ,POL_CD" ).append("\n"); 
		query.append("  ,POD_CD" ).append("\n"); 
		query.append("  ,NVL(MN_SCTR_FLG, 'Main') AS MN_SCTR_FLG" ).append("\n"); 
		query.append("  ,MAS_LOAD" ).append("\n"); 
		query.append("  ,QTA_LOAD " ).append("\n"); 
		query.append("  ,ROUND(MAS_REV,10)                                    AS MAS_REV " ).append("\n"); 
		query.append("  ,ROUND(QTA_REV,10)                                    AS QTA_REV " ).append("\n"); 
		query.append("  ,ROUND(MAS_CM ,10)                                    AS MAS_CM" ).append("\n"); 
		query.append("  ,ROUND(QTA_CM,10)                                     AS QTA_CM " ).append("\n"); 
		query.append("  ,ROUND(DECODE(MAS_LOAD,0,0,MAS_REV/MAS_LOAD),10)      AS MAS_RPB      " ).append("\n"); 
		query.append("  ,ROUND(DECODE(QTA_LOAD,0,0,QTA_REV/QTA_LOAD),10)      AS QTA_RPB " ).append("\n"); 
		query.append("  ,ROUND(DECODE(MAS_LOAD,0,0,MAS_CM/MAS_LOAD),10)       AS MAS_CMB      " ).append("\n"); 
		query.append("  ,ROUND(DECODE(QTA_LOAD,0,0,QTA_CM/QTA_LOAD),10)       AS QTA_CMB " ).append("\n"); 
		query.append("  ,ROUND(MAS_BSA,10)                                    AS MAS_BSA_CAPA " ).append("\n"); 
		query.append("  ,ROUND(QTA_BSA,10)                                    AS QTA_BSA" ).append("\n"); 
		query.append("  ,ROUND(DECODE(MAS_BSA,0,0,(MAS_LOAD/MAS_BSA)*100),10) AS MAS_LF " ).append("\n"); 
		query.append("  ,ROUND(DECODE(QTA_BSA,0,0,(QTA_LOAD/QTA_BSA)*100),10) AS QTA_LF " ).append("\n"); 
		query.append("  ,ROUND(DECODE(SIGN(QTA_LOAD), -1,DECODE(SIGN(MAS_LOAD),-1,DECODE(QTA_LOAD,0,0,1+(QTA_LOAD-MAS_LOAD)/QTA_LOAD)),DECODE(SIGN(MAS_LOAD),1,DECODE(QTA_LOAD,0,0,MAS_LOAD/QTA_LOAD)))*100,10)               AS LOAD_CHNG " ).append("\n"); 
		query.append("  ,ROUND(DECODE(SIGN(QTA_REV),  -1,DECODE(SIGN(MAS_REV), -1,DECODE(QTA_REV, 0,0,1+(QTA_REV-MAS_REV)/QTA_REV)),   DECODE(SIGN(MAS_REV), 1,DECODE(QTA_REV, 0,0,MAS_REV/QTA_REV)))*100,10)                 AS REV_CHNG " ).append("\n"); 
		query.append("  ,ROUND(DECODE(SIGN(QTA_CM),   -1,DECODE(SIGN(MAS_CM),  -1,DECODE(QTA_CM,  0,0,1+(QTA_CM-MAS_CM)/QTA_CM)),      DECODE(SIGN(MAS_CM),  1,DECODE(QTA_CM,  0,0,MAS_CM/QTA_CM)))*100,10)                   AS BKG_CM_CHNG " ).append("\n"); 
		query.append("  ,ROUND((DECODE(MAS_LOAD,0,0,MAS_REV/MAS_LOAD) - DECODE(QTA_LOAD,0,0,QTA_REV/QTA_LOAD)),10)                       AS RPB_CHNG " ).append("\n"); 
		query.append("  ,ROUND(DECODE(MAS_LOAD,0,0,MAS_CM/MAS_LOAD)-DECODE(QTA_LOAD,0,0,QTA_CM/QTA_LOAD),10)                             AS CMB_CHNG " ).append("\n"); 
		query.append("  ,ROUND(MAS_BSA - QTA_BSA,10)                                                                                     AS BSA_CHNG " ).append("\n"); 
		query.append("  ,ROUND(DECODE(MAS_BSA,0,0,(MAS_LOAD/MAS_BSA)*100)-DECODE(QTA_BSA,0,0,(QTA_LOAD/QTA_BSA)*100),10)                 AS MAS_LF_CHNG " ).append("\n"); 
		query.append("  ,ROUND((MAS_LOAD - QTA_LOAD) * DECODE(QTA_LOAD,0,0,QTA_REV/QTA_LOAD),10)                                         AS BY_LOAD_GREV " ).append("\n"); 
		query.append("  ,ROUND((DECODE(MAS_LOAD,0,0,MAS_REV/MAS_LOAD) - DECODE(QTA_LOAD,0,0,QTA_REV/QTA_LOAD))*MAS_LOAD,10)              AS BY_RPB_GREV " ).append("\n"); 
		query.append("  ,ROUND((MAS_LOAD - QTA_LOAD) * (DECODE(QTA_LOAD,0,0,QTA_CM_COST/QTA_LOAD)),10)                                   AS BY_LOAD_COST " ).append("\n"); 
		query.append("  ,ROUND(((DECODE(MAS_LOAD,0,0,MAS_CM_COST/MAS_LOAD)) -  (DECODE(QTA_LOAD,0,0,QTA_CM_COST/QTA_LOAD)))*MAS_LOAD,10) AS BY_CPB_COST " ).append("\n"); 
		query.append("  ,ROUND(DECODE(QTA_LOAD,  0,0,NVL(RATIO_TO_REPORT(QTA_LOAD)   OVER(),0)* 100),5)                                 AS QTA_LOAD_SHARE " ).append("\n"); 
		query.append("  ,ROUND(DECODE(MAS_LOAD,  0,0,NVL(RATIO_TO_REPORT(MAS_LOAD)   OVER(),0)* 100),5)                                 AS MAS_LOAD_SHARE " ).append("\n"); 
		query.append("  ,ROUND(DECODE(QTA_CM,    0,0,NVL(RATIO_TO_REPORT(QTA_CM)     OVER(),0)* 100),5)                                 AS QTA_CM_SHARE " ).append("\n"); 
		query.append("  ,ROUND(DECODE(MAS_CM,    0,0,NVL(RATIO_TO_REPORT(MAS_CM)     OVER(),0)* 100),5)                                 AS MAS_CM_SHARE " ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("    SELECT '' " ).append("\n"); 
		query.append("      ,AA.OFC_CD1 " ).append("\n"); 
		query.append("      ,AA.OFC_CD2" ).append("\n"); 
		query.append("#if(${f_r_month_sts} =='Y'||${f_rpt_item} =='4')              " ).append("\n"); 
		query.append("      ,AA.COST_YRMON " ).append("\n"); 
		query.append("#else                " ).append("\n"); 
		query.append("      ,NULL AS COST_YRMON " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_wk_sts} =='Y'||${f_rpt_item} =='4')              " ).append("\n"); 
		query.append("      ,AA.COST_WK " ).append("\n"); 
		query.append("#else                " ).append("\n"); 
		query.append("      ,NULL AS COST_WK " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,AA.TRD_CD" ).append("\n"); 
		query.append("#if( ${f_ias_rgn_sts} =='Y')" ).append("\n"); 
		query.append("      ,AA.IAS_RGN_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,NULL AS IAS_RGN_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${f_hul_bnd_sts} =='Y')" ).append("\n"); 
		query.append("      ,AA.HUL_BND_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,NULL AS HUL_BND_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='1')" ).append("\n"); 
		query.append("      ,NULL AS SUB_TRD_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,AA.SUB_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='1' ||${f_rpt_item} =='2')" ).append("\n"); 
		query.append("      ,NULL AS RLANE_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,AA.RLANE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='1' ||${f_rpt_item} =='2'||${f_rpt_item} =='3')" ).append("\n"); 
		query.append("      ,NULL AS VSL_CD " ).append("\n"); 
		query.append("      ,NULL AS SKD_VOY_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,AA.VSL_CD " ).append("\n"); 
		query.append("      ,AA.SKD_VOY_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${f_dir_sts} =='Y'||${f_rpt_item}=='4')       " ).append("\n"); 
		query.append("      ,AA.DIR_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,NULL AS DIR_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,AA.POL_CD" ).append("\n"); 
		query.append("      ,AA.POD_CD" ).append("\n"); 
		query.append("	  ,(SELECT DISTINCT DECODE(NVL(B1.SQM_MN_SCTR_FLG, 'N'), 'Y', 'Main', 'N', 'Sector') " ).append("\n"); 
		query.append("    	     FROM SQM_SCTR_PAIR_MGMT B1" ).append("\n"); 
		query.append("    	     WHERE 1=1" ).append("\n"); 
		query.append("    	         AND B1.POL_CD = AA.POL_CD" ).append("\n"); 
		query.append("    	         AND B1.POD_CD = AA.POD_CD" ).append("\n"); 
		query.append("    	         AND B1.RLANE_CD = AA.RLANE_CD" ).append("\n"); 
		query.append("    			 AND B1.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("    			 AND B1.BSE_YR = @[f_year]" ).append("\n"); 
		query.append("    			 AND B1.BSE_QTR_CD = (CASE WHEN AA.COST_WK >= '00' AND AA.COST_WK <= '13' THEN '1Q'" ).append("\n"); 
		query.append("    			                               WHEN AA.COST_WK >= '14' AND AA.COST_WK <= '26' THEN '2Q'" ).append("\n"); 
		query.append("    			                               WHEN AA.COST_WK >= '27' AND AA.COST_WK <= '39' THEN '3Q'" ).append("\n"); 
		query.append("    			                               WHEN AA.COST_WK >= '40' AND AA.COST_WK <= '53' THEN '4Q'" ).append("\n"); 
		query.append("    			                       END" ).append("\n"); 
		query.append("    			                     )" ).append("\n"); 
		query.append("    			 AND B1.DIR_CD = AA.DIR_CD" ).append("\n"); 
		query.append("       		) AS MN_SCTR_FLG" ).append("\n"); 
		query.append("      ,NVL(SUM(AA.VVD_BSA_CAPA),0)            AS MAS_BSA " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.MAS_QTY),0)                 AS MAS_LOAD " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.FR_REV),0)                  AS MAS_REV " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.TOT_REV-CM_COST+DMDT),0)    AS MAS_CM " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.CM_COST),0)                 AS MAS_CM_COST " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.OP_COST),0)                 AS OP_COST " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.QTA_LOAD),0)                AS QTA_LOAD " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.QTA_REV),0)                 AS QTA_REV " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.QTA_BKG_CM),0)              AS QTA_CM " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.QTA_CM_COST),0)             AS QTA_CM_COST " ).append("\n"); 
		query.append("      ,NVL(SUM(AA.QTA_BSA),0)                 AS QTA_BSA " ).append("\n"); 
		query.append("    FROM ( " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("        '' " ).append("\n"); 
		query.append("#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl1} =='1') " ).append("\n"); 
		query.append("          ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='2')" ).append("\n"); 
		query.append("          ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='3')" ).append("\n"); 
		query.append("          ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='4')" ).append("\n"); 
		query.append("          ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='5')" ).append("\n"); 
		query.append("          ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='6')" ).append("\n"); 
		query.append("          ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='7')" ).append("\n"); 
		query.append("          ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end OFC_CD1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl2} =='1') " ).append("\n"); 
		query.append("          ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='2')" ).append("\n"); 
		query.append("          ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='3')" ).append("\n"); 
		query.append("          ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='4')" ).append("\n"); 
		query.append("          ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='5')" ).append("\n"); 
		query.append("          ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='6')" ).append("\n"); 
		query.append("          ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='7')" ).append("\n"); 
		query.append("          ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end OFC_CD2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          ,NULL AS OFC_CD1 " ).append("\n"); 
		query.append("          ,NULL AS OFC_CD2 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	  ,A1.COST_YRMON" ).append("\n"); 
		query.append("          ,A1.COST_WK " ).append("\n"); 
		query.append("          ,A1.TRD_CD " ).append("\n"); 
		query.append("          ,A3.IAS_RGN_CD" ).append("\n"); 
		query.append("          ,A3.HUL_BND_CD" ).append("\n"); 
		query.append("          ,A1.SUB_TRD_CD " ).append("\n"); 
		query.append("          ,A1.RLANE_CD " ).append("\n"); 
		query.append("          ,A1.VSL_CD " ).append("\n"); 
		query.append("          ,A1.SKD_VOY_NO " ).append("\n"); 
		query.append("          ,A1.DIR_CD" ).append("\n"); 
		query.append("          ,A2.REV_POL_CD AS POL_CD" ).append("\n"); 
		query.append("          ,A2.REV_POD_CD AS POD_CD" ).append("\n"); 
		query.append("          ,NVL(A3.LOD_SPL_CNG_FLG,'N') AS LOD_SPL_CNG_FLG " ).append("\n"); 
		query.append("          ,DECODE(NVL(A3.LOD_SPL_CNG_FLG,'N'), 'Y', SUM(DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1,1),'2',NVL(A2.BKG_QTY,0),NVL(A2.BKG_QTY,0)*2)) " ).append("\n"); 
		query.append("                                             , 'N', MAX(A1.VVD_BSA_CAPA))                      AS VVD_BSA_CAPA " ).append("\n"); 
		query.append("          ,SUM(DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1,1),'2',NVL(A2.BKG_QTY,0),NVL(A2.BKG_QTY,0)*2)) AS MAS_QTY " ).append("\n"); 
		query.append("          ,SUM(A2.BKG_REV+A2.BKG_OFT_REV)                                                      AS FR_REV " ).append("\n"); 
		query.append("          ,SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV)                       AS TOT_REV " ).append("\n"); 
		query.append("          ,SUM(A2.DMDT_COM_AMT)                                                                AS DMDT " ).append("\n"); 
		query.append("          ,SUM(DECODE(@[f_pro_vw],'P', A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT))       AS CM_COST  " ).append("\n"); 
		query.append("          ,SUM(DECODE(@[f_pro_vw],'P', 0,'R',A2.RA_OP_COST_TTL_AMT))                           AS OP_COST  " ).append("\n"); 
		query.append("          ,NULL AS QTA_BSA " ).append("\n"); 
		query.append("          ,NULL AS QTA_LOAD " ).append("\n"); 
		query.append("          ,NULL AS QTA_REV " ).append("\n"); 
		query.append("          ,NULL AS QTA_BKG_CM " ).append("\n"); 
		query.append("          ,NULL AS QTA_CM_COST " ).append("\n"); 
		query.append("          ,NULL AS OFC_CD " ).append("\n"); 
		query.append("       FROM        " ).append("\n"); 
		query.append("      #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("           MAS_BKG_EXPN_DTL A2" ).append("\n"); 
		query.append("      #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("           MAS_BKG_EXPN_DTL_WK A2 " ).append("\n"); 
		query.append("      #end           " ).append("\n"); 
		query.append("          ,MAS_MON_VVD   A1 " ).append("\n"); 
		query.append("          ,MAS_LANE_RGST A3 " ).append("\n"); 
		query.append("          ,MAS_OFC_LVL   A4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      WHERE A1.TRD_CD              = A2.TRD_CD " ).append("\n"); 
		query.append("        AND A1.RLANE_CD            = A2.RLANE_CD " ).append("\n"); 
		query.append("        AND A1.IOC_CD              = A2.IOC_CD " ).append("\n"); 
		query.append("        AND A1.VSL_CD              = A2.VSL_CD " ).append("\n"); 
		query.append("        AND A1.SKD_VOY_NO          = A2.SKD_VOY_NO " ).append("\n"); 
		query.append("        AND A1.DIR_CD              = A2.DIR_CD " ).append("\n"); 
		query.append("        AND A1.TRD_CD              = A3.TRD_CD " ).append("\n"); 
		query.append("        AND A1.RLANE_CD            = A3.RLANE_CD " ).append("\n"); 
		query.append("        AND A1.IOC_CD              = A3.IOC_CD " ).append("\n"); 
		query.append("        AND A1.DIR_CD              = A3.DIR_CD" ).append("\n"); 
		query.append("#if(${f_chkprd} =='M')      " ).append("\n"); 
		query.append("        AND A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("        AND A2.COST_YRMON          BETWEEN '${f_year}'||'${f_fm_mon}' AND '${f_year}'||'${f_to_mon}'" ).append("\n"); 
		query.append("        AND A1.COST_YRMON          BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#elseif (${f_chkprd} =='W') " ).append("\n"); 
		query.append("        AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("        AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK = SUBSTR(A2.SLS_YRMON, 1, 4)||A2.COST_WK     " ).append("\n"); 
		query.append("        AND A1.SLS_YRMON           BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON      " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("#if(${f_ofc_vw} =='C')" ).append("\n"); 
		query.append("        AND A2.AGMT_SGN_OFC_CD = A4.OFC_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_vw} =='L')" ).append("\n"); 
		query.append("        AND A2.SLS_OFC_CD = A4.OFC_CD      " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND NVL(A1.DELT_FLG,'N')   = 'N'      " ).append("\n"); 
		query.append("#if(${f_bkg_sts} =='Y')                  " ).append("\n"); 
		query.append("        AND A2.BKG_STS_CD          IN ('F','S','W') " ).append("\n"); 
		query.append("#else                                         " ).append("\n"); 
		query.append("        AND A2.BKG_STS_CD          IN ('F','S') " ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("        AND A2.BL_NO_TP            IN ('M','0')             " ).append("\n"); 
		query.append("#if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("    #if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("        AND DECODE(@[f_ofc_lvl1], '1', A4.OFC_N1ST_LVL_CD, '2', A4.OFC_N2ND_LVL_CD, '3', A4.OFC_N3RD_LVL_CD, '4', A4.OFC_N4TH_LVL_CD, '5', A4.OFC_N5TH_LVL_CD, '6', A4.OFC_N6TH_LVL_CD, '7', A4.OFC_N7TH_LVL_CD) = @[f_ofc_cd]       " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND A4.OFC_CD = @[f_ofc_cd]  " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ofc_lvl1}=='6' || ${f_ofc_lvl1}=='7')" ).append("\n"); 
		query.append("        AND A4.OFC_LVL = @[f_ofc_lvl1]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND A4.OFC_LVL < '9'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_trd_cd} !='')                       " ).append("\n"); 
		query.append("        AND A1.TRD_CD   = @[f_trd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_sub_trd_cd} !='')                       " ).append("\n"); 
		query.append("        AND A1.SUB_TRD_CD   = @[f_sub_trd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ias_rgn_cd} !='')                       " ).append("\n"); 
		query.append("        AND A3.IAS_RGN_CD   = @[f_ias_rgn_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_hul_bnd_cd} !='')                       " ).append("\n"); 
		query.append("        AND A3.HUL_BND_CD   = @[f_hul_bnd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("        AND A1.RLANE_CD = @[f_rlane_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("        AND A1.DIR_CD   = @[f_dir_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("        AND A1.VSL_CD   = @[f_vsl_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("        AND A1.SKD_VOY_NO = @[f_skd_voy_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("        AND A1.DIR_CD   = @[f_skd_dir_cd]     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_pol_cd} !='')" ).append("\n"); 
		query.append("        AND A2.REV_POL_CD   = @[f_pol_cd]     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_pod_cd} !='')" ).append("\n"); 
		query.append("        AND A2.REV_POD_CD   = @[f_pod_cd]     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   GROUP BY '' " ).append("\n"); 
		query.append("#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl1} =='1') " ).append("\n"); 
		query.append("          ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='2')" ).append("\n"); 
		query.append("          ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='3')" ).append("\n"); 
		query.append("          ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='4')" ).append("\n"); 
		query.append("          ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='5')" ).append("\n"); 
		query.append("          ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='6')" ).append("\n"); 
		query.append("          ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='7')" ).append("\n"); 
		query.append("          ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end          " ).append("\n"); 
		query.append("    #if(${f_ofc_lvl2} =='1') " ).append("\n"); 
		query.append("          ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='2')" ).append("\n"); 
		query.append("          ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='3')" ).append("\n"); 
		query.append("          ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='4')" ).append("\n"); 
		query.append("          ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='5')" ).append("\n"); 
		query.append("          ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='6')" ).append("\n"); 
		query.append("          ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='7')" ).append("\n"); 
		query.append("          ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  ,A1.COST_YRMON" ).append("\n"); 
		query.append("          ,A1.COST_WK " ).append("\n"); 
		query.append("          ,A1.TRD_CD " ).append("\n"); 
		query.append("          ,A3.IAS_RGN_CD " ).append("\n"); 
		query.append("          ,A3.HUL_BND_CD " ).append("\n"); 
		query.append("          ,A1.SUB_TRD_CD " ).append("\n"); 
		query.append("          ,A1.RLANE_CD " ).append("\n"); 
		query.append("          ,A1.VSL_CD " ).append("\n"); 
		query.append("          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A1.DIR_CD" ).append("\n"); 
		query.append("          ,A2.REV_POL_CD" ).append("\n"); 
		query.append("          ,A2.REV_POD_CD" ).append("\n"); 
		query.append("          ,A3.LOD_SPL_CNG_FLG          " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if((${f_pro_vw} =='P' && ${f_ofc_lvl1} =='1') " ).append("\n"); 
		query.append("   ||${f_pro_vw} =='R')" ).append("\n"); 
		query.append("        UNION ALL " ).append("\n"); 
		query.append("        SELECT '' " ).append("\n"); 
		query.append("          ,OFC_CD1 " ).append("\n"); 
		query.append("          ,OFC_CD2" ).append("\n"); 
		query.append("          ,COST_YRMON " ).append("\n"); 
		query.append("          ,COST_WK " ).append("\n"); 
		query.append("          ,TRD_CD " ).append("\n"); 
		query.append("          ,IAS_RGN_CD" ).append("\n"); 
		query.append("          ,HUL_BND_CD" ).append("\n"); 
		query.append("          ,SUB_TRD_CD " ).append("\n"); 
		query.append("          ,RLANE_CD " ).append("\n"); 
		query.append("          ,VSL_CD " ).append("\n"); 
		query.append("          ,SKD_VOY_NO " ).append("\n"); 
		query.append("          ,DIR_CD " ).append("\n"); 
		query.append("          ,POL_CD" ).append("\n"); 
		query.append("          ,POD_CD" ).append("\n"); 
		query.append("          ,NULL AS LOD_SPL_CNG_FLG " ).append("\n"); 
		query.append("          ,NULL AS VVD_BSA_CAPA " ).append("\n"); 
		query.append("          ,NULL AS MAS_QTY " ).append("\n"); 
		query.append("          ,NULL AS FR_REV " ).append("\n"); 
		query.append("          ,NULL AS TOT_REV " ).append("\n"); 
		query.append("          ,NULL AS DMDT " ).append("\n"); 
		query.append("          ,NULL AS CM_COST " ).append("\n"); 
		query.append("          ,NULL AS OP_COST " ).append("\n"); 
		query.append("          ,MAX(DECODE(RLANE_CD, 'RBCCO' , DECODE(IOC_CD, 'O', 0 ,FNL_BSA_CAPA), FNL_BSA_CAPA)) QTA_BSA " ).append("\n"); 
		query.append("          ,SUM(DECODE(RLANE_CD, 'RBCCO' , DECODE(IOC_CD, 'O', 0 ,LOD_QTY), LOD_QTY)) QTA_LOAD " ).append("\n"); 
		query.append("          ,SUM(DECODE(RLANE_CD, 'RBCCO' , DECODE(IOC_CD, 'O', 0 ,LOD_QTY), LOD_QTY) * GRS_RPB_REV) QTA_REV " ).append("\n"); 
		query.append("          ,SUM(DECODE(RLANE_CD, 'RBCCO' , DECODE(IOC_CD, 'O', 0 ,LOD_QTY), LOD_QTY) * GRS_RPB_REV) - " ).append("\n"); 
		query.append("           SUM(DECODE(RLANE_CD, 'RBCCO' , DECODE(IOC_CD, 'O', 0 ,LOD_QTY), LOD_QTY) * DECODE(@[f_pro_vw], 'P', PA_CM_UC_AMT, RA_CM_UC_AMT)) QTA_BKG_CM  " ).append("\n"); 
		query.append("          ,SUM(DECODE(RLANE_CD, 'RBCCO' , DECODE(IOC_CD, 'O', 0 ,LOD_QTY), LOD_QTY) * DECODE(@[f_pro_vw], 'P', PA_CM_UC_AMT, RA_CM_UC_AMT)) QTA_CM_COST  " ).append("\n"); 
		query.append("          ,NULL AS OFC_CD " ).append("\n"); 
		query.append("       FROM(" ).append("\n"); 
		query.append("           SELECT " ).append("\n"); 
		query.append("              /*+ ordered */" ).append("\n"); 
		query.append("              '' " ).append("\n"); 
		query.append("#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl1} =='1') " ).append("\n"); 
		query.append("             ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='2')" ).append("\n"); 
		query.append("             ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='3')" ).append("\n"); 
		query.append("             ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='4')" ).append("\n"); 
		query.append("             ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='5')" ).append("\n"); 
		query.append("             ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='6')" ).append("\n"); 
		query.append("             ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='7')" ).append("\n"); 
		query.append("             ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end OFC_CD1              " ).append("\n"); 
		query.append("    #if(${f_ofc_lvl2} =='1') " ).append("\n"); 
		query.append("             ,A4.OFC_N1ST_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='2')" ).append("\n"); 
		query.append("             ,A4.OFC_N2ND_LVL_CD " ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='3')" ).append("\n"); 
		query.append("             ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='4')" ).append("\n"); 
		query.append("             ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='5')" ).append("\n"); 
		query.append("             ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='6')" ).append("\n"); 
		query.append("             ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='7')" ).append("\n"); 
		query.append("             ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end OFC_CD2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             ,NULL AS OFC_CD1 " ).append("\n"); 
		query.append("             ,NULL AS OFC_CD2 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			 ,A1.COST_YRMON" ).append("\n"); 
		query.append("             ,A1.COST_WK " ).append("\n"); 
		query.append("             ,A1.TRD_CD " ).append("\n"); 
		query.append("             ,A5.IAS_RGN_CD" ).append("\n"); 
		query.append("             ,A5.HUL_BND_CD" ).append("\n"); 
		query.append("             ,A1.SUB_TRD_CD " ).append("\n"); 
		query.append("             ,A1.RLANE_CD " ).append("\n"); 
		query.append("             ,A1.VSL_CD " ).append("\n"); 
		query.append("             ,A1.SKD_VOY_NO " ).append("\n"); 
		query.append("             ,A1.DIR_CD " ).append("\n"); 
		query.append("             ,A3.POL_CD" ).append("\n"); 
		query.append("             ,A3.POD_CD" ).append("\n"); 
		query.append("             ,A1.IOC_CD " ).append("\n"); 
		query.append("             ,ROUND(A3.LOD_QTY,9) AS LOD_QTY" ).append("\n"); 
		query.append("             ,A3.GRS_RPB_REV " ).append("\n"); 
		query.append("             ,A3.PA_CM_UC_AMT " ).append("\n"); 
		query.append("             ,A3.RA_CM_UC_AMT " ).append("\n"); 
		query.append("             ,A3.QTA_RLSE_VER_NO " ).append("\n"); 
		query.append("             ,MAX(A3.QTA_RLSE_VER_NO) OVER (PARTITION BY A3.TRD_CD, A3.RLANE_CD, A3.DIR_CD, A3.VSL_CD, A3.SKD_VOY_NO, A3.SKD_DIR_CD) QTA_VER_NO " ).append("\n"); 
		query.append("             ,A3.BSE_QTR_CD " ).append("\n"); 
		query.append("             ,MAX(A3.BSE_QTR_CD) OVER (PARTITION BY A3.BSE_YR, A3.TRD_CD, A3.RLANE_CD, A3.DIR_CD, A3.VSL_CD, A3.SKD_VOY_NO, A3.SKD_DIR_CD) QTR_CD " ).append("\n"); 
		query.append("             ,A3.FNL_BSA_CAPA " ).append("\n"); 
		query.append("           FROM MAS_MON_VVD A1 " ).append("\n"); 
		query.append("             ,SQM_QTA_RLSE_VER A2" ).append("\n"); 
		query.append("             ,SQM_SCTR_CFM_QTA A3" ).append("\n"); 
		query.append("             ,MAS_OFC_LVL A4 " ).append("\n"); 
		query.append("             ,MAS_LANE_RGST A5 " ).append("\n"); 
		query.append("          WHERE 1=1 " ).append("\n"); 
		query.append("            AND A1.TRD_CD           = A3.TRD_CD " ).append("\n"); 
		query.append("            AND A1.RLANE_CD         = A3.RLANE_CD " ).append("\n"); 
		query.append("            AND A1.VSL_CD           = A3.VSL_CD " ).append("\n"); 
		query.append("            AND A1.SKD_VOY_NO       = A3.SKD_VOY_NO " ).append("\n"); 
		query.append("            AND A1.DIR_CD           = A3.SKD_DIR_CD " ).append("\n"); 
		query.append("            AND A1.RLANE_CD         = A5.RLANE_CD " ).append("\n"); 
		query.append("            AND A1.DIR_CD           = A5.DIR_CD" ).append("\n"); 
		query.append("            AND A1.TRD_CD           = A5.TRD_CD " ).append("\n"); 
		query.append("            AND A1.IOC_CD           = A5.IOC_CD " ).append("\n"); 
		query.append("            AND A3.BSE_TP_CD        = 'Q'" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("            AND A1.COST_YRMON       BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("            AND A1.SLS_YRMON        BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND A2.QTA_RLSE_VER_NO  = A3.QTA_RLSE_VER_NO " ).append("\n"); 
		query.append("            AND A2.BSE_YR           = A3.BSE_YR" ).append("\n"); 
		query.append("            AND A2.BSE_QTR_CD       = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("			AND A2.BSE_TP_CD		= A3.BSE_TP_CD" ).append("\n"); 
		query.append("            AND A2.SQM_VER_STS_CD  = 'R'   " ).append("\n"); 
		query.append("            AND A3.OFC_VW_CD       = @[f_ofc_vw]  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("            AND A1.COST_YRMON       BETWEEN '${f_year}'||'${f_fm_mon}' AND '${f_year}'||'${f_to_mon}' " ).append("\n"); 
		query.append("#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("            AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND A1.DELT_FLG         = 'N' " ).append("\n"); 
		query.append("            AND A3.RGN_OFC_CD       = A4.OFC_CD        " ).append("\n"); 
		query.append("#if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("    #if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("            AND DECODE(@[f_ofc_lvl1], '1', a4.ofc_n1st_lvl_cd, '2', a4.ofc_n2nd_lvl_cd, '3', a4.ofc_n3rd_lvl_cd, '4', a4.ofc_n4th_lvl_cd, '5', a4.ofc_n5th_lvl_cd, '6', a4.ofc_n6th_lvl_cd, '7', a4.ofc_n7th_lvl_cd) = @[f_ofc_cd]       " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("            AND A4.ofc_cd = @[f_ofc_cd] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ofc_lvl1}=='6' || ${f_ofc_lvl1}=='7')" ).append("\n"); 
		query.append("            AND A4.OFC_LVL = @[f_ofc_lvl1]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND A4.OFC_LVL < '9'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_trd_cd} !='')                       " ).append("\n"); 
		query.append("            AND A1.TRD_CD   = @[f_trd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_sub_trd_cd} !='')                       " ).append("\n"); 
		query.append("            AND A1.SUB_TRD_CD   = @[f_sub_trd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ias_rgn_cd} !='')                       " ).append("\n"); 
		query.append("            AND A5.IAS_RGN_CD   = @[f_ias_rgn_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_hul_bnd_cd} !='')                       " ).append("\n"); 
		query.append("            AND A5.HUL_BND_CD   = @[f_hul_bnd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("            AND A1.RLANE_CD = @[f_rlane_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("            AND A1.DIR_CD   = @[f_dir_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("            AND A1.VSL_CD   = @[f_vsl_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("            AND A1.SKD_VOY_NO = @[f_skd_voy_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("            AND A1.DIR_CD   = @[f_skd_dir_cd]     " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${f_pol_cd} !='')" ).append("\n"); 
		query.append("        AND A3.POL_CD   = @[f_pol_cd]     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_pod_cd} !='')" ).append("\n"); 
		query.append("        AND A3.POD_CD   = @[f_pod_cd]     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("       WHERE 1=1 " ).append("\n"); 
		query.append("         AND QTA_RLSE_VER_NO = QTA_VER_NO " ).append("\n"); 
		query.append("         AND BSE_QTR_CD = QTR_CD " ).append("\n"); 
		query.append("      GROUP BY '' " ).append("\n"); 
		query.append("            ,OFC_CD1 " ).append("\n"); 
		query.append("            ,OFC_CD2" ).append("\n"); 
		query.append("			,COST_YRMON " ).append("\n"); 
		query.append("            ,COST_WK " ).append("\n"); 
		query.append("            ,TRD_CD " ).append("\n"); 
		query.append("            ,IAS_RGN_CD" ).append("\n"); 
		query.append("            ,HUL_BND_CD" ).append("\n"); 
		query.append("            ,SUB_TRD_CD " ).append("\n"); 
		query.append("            ,RLANE_CD " ).append("\n"); 
		query.append("            ,VSL_CD " ).append("\n"); 
		query.append("            ,SKD_VOY_NO " ).append("\n"); 
		query.append("            ,DIR_CD" ).append("\n"); 
		query.append("            ,POL_CD" ).append("\n"); 
		query.append("            ,POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ) AA" ).append("\n"); 
		query.append(" GROUP BY '' " ).append("\n"); 
		query.append("          ,OFC_CD1 " ).append("\n"); 
		query.append("          ,OFC_CD2" ).append("\n"); 
		query.append("#if(${f_r_month_sts} =='Y'||${f_rpt_item} =='4')              " ).append("\n"); 
		query.append("          ,COST_YRMON " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${f_wk_sts} =='Y'||${f_rpt_item} =='4')              " ).append("\n"); 
		query.append("          ,COST_WK " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ,TRD_CD" ).append("\n"); 
		query.append("#if( ${f_ias_rgn_sts} =='Y')" ).append("\n"); 
		query.append("          ,IAS_RGN_CD " ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("#if( ${f_hul_bnd_sts} =='Y')" ).append("\n"); 
		query.append("          ,HUL_BND_CD " ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("#if(${f_rpt_item} !='1')" ).append("\n"); 
		query.append("          ,SUB_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='3'||${f_rpt_item} =='4')" ).append("\n"); 
		query.append("          ,RLANE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='4')" ).append("\n"); 
		query.append("          ,VSL_CD " ).append("\n"); 
		query.append("          ,SKD_VOY_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_sts} =='Y'||${f_rpt_item}=='4')       " ).append("\n"); 
		query.append("          ,DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,POL_CD" ).append("\n"); 
		query.append("          ,POD_CD" ).append("\n"); 
		query.append("          ,COST_WK" ).append("\n"); 
		query.append("          ,RLANE_CD" ).append("\n"); 
		query.append("          ,DIR_CD" ).append("\n"); 
		query.append("  ) " ).append("\n"); 
		query.append("WHERE QTA_LOAD + MAS_LOAD <> 0--'0'" ).append("\n"); 
		query.append("#if (${f_mn_sctr} == 'M')" ).append("\n"); 
		query.append("--	AND MN_SCTR_FLG = 'Main'" ).append("\n"); 
		query.append("	AND (MN_SCTR_FLG = 'Main' OR MN_SCTR_FLG = '' OR MN_SCTR_FLG IS NULL)" ).append("\n"); 
		query.append("#elseif (${f_mn_sctr} == 'S')" ).append("\n"); 
		query.append("	AND MN_SCTR_FLG = 'Sector'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY       " ).append("\n"); 
		query.append("   OFC_CD1 " ).append("\n"); 
		query.append("  ,OFC_CD2" ).append("\n"); 
		query.append("  ,COST_YRMON" ).append("\n"); 
		query.append("  ,COST_WK" ).append("\n"); 
		query.append("  ,TRD_CD" ).append("\n"); 
		query.append("  ,IAS_RGN_CD" ).append("\n"); 
		query.append("  ,HUL_BND_CD" ).append("\n"); 
		query.append("  ,SUB_TRD_CD" ).append("\n"); 
		query.append("  ,RLANE_CD" ).append("\n"); 
		query.append("  ,VSL_CD " ).append("\n"); 
		query.append("  ,SKD_VOY_NO" ).append("\n"); 
		query.append("  ,DIR_CD" ).append("\n"); 
		query.append("  ,POL_CD" ).append("\n"); 
		query.append("  ,POD_CD" ).append("\n"); 

	}
}