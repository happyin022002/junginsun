/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SalesRPTDBDAOSearchRPTbyOfc070List11RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 2012.01.03 [CHM-201114896-01] 이석준  CM2(Own Feeder) 비용 반영
	  * 2012.02.29 [CHM-201216554-01] 전윤주 Office Report-vs QTA (VS Pre Week Tab) 화면 쿼리 튜닝
	  * - Velocity 문 구조 수정
	  * - BKG_CGO_TP_CD = 'P' 조건 삭제 
	  * - MAS_BKG_EXPN_DTL_WK에 걸리는 힌트 삭제
	  * 2015.04.22 [CHM-201534153] 김시몬 Dem/Det CM계정관련 수정
	  * 2015.08.31 [CHM-201536958] 손진환 Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
		params.put("f_ofc_lvl1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_curr_week",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
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
		query.append("SELECT  ''" ).append("\n"); 
		query.append("  ,OFC_CD1" ).append("\n"); 
		query.append("  ,OFC_CD2" ).append("\n"); 
		query.append("  ,TRD_CD" ).append("\n"); 
		query.append("  ,SUB_TRD_CD" ).append("\n"); 
		query.append("  ,RLANE_CD" ).append("\n"); 
		query.append("  ,VSL_CD" ).append("\n"); 
		query.append("  ,SKD_VOY_NO" ).append("\n"); 
		query.append("  ,DIR_CD" ).append("\n"); 
		query.append("  ,PREV_LOAD         ,CURR_LOAD" ).append("\n"); 
		query.append("  ,PREV_REV          ,CURR_REV" ).append("\n"); 
		query.append("  ,PREV_CM           ,CURR_CM" ).append("\n"); 
		query.append("  ,PREV_OTH_ABC_SVC  ,CURR_OTH_ABC_SVC" ).append("\n"); 
		query.append("  ,PREV_STP_REV      ,CURR_STP_REV" ).append("\n"); 
		query.append("  ,PREV_BALANCE_SVC  ,CURR_BALANCE_SVC" ).append("\n"); 
		query.append("  ,PREV_OTH_ABC_CONT ,CURR_OTH_ABC_CONT" ).append("\n"); 
		query.append("  ,PREV_STP_COST     ,CURR_STP_COST" ).append("\n"); 
		query.append("  ,PREV_BALANCE_CONT ,CURR_BALANCE_CONT" ).append("\n"); 
		query.append("  ,PREV_STP_PROFIT   ,CURR_STP_PROFIT" ).append("\n"); 
		query.append("  ,PREV_CM + PREV_STP_PROFIT AS PREV_BRANCH_CM" ).append("\n"); 
		query.append("  ,CURR_CM + CURR_STP_PROFIT AS CURR_BRANCH_CM" ).append("\n"); 
		query.append("  ,PREV_BKG_OP      ,CURR_BKG_OP" ).append("\n"); 
		query.append("  ,PREV_BKG_OP + PREV_STP_PROFIT AS  PREV_OP" ).append("\n"); 
		query.append("  ,CURR_BKG_OP + CURR_STP_PROFIT AS  CURR_OP" ).append("\n"); 
		query.append("  ,DECODE(PREV_LOAD,0,0, PREV_REV/PREV_LOAD) AS PREV_RPB" ).append("\n"); 
		query.append("  ,DECODE(CURR_LOAD,0,0, CURR_REV/CURR_LOAD) AS CURR_RPB" ).append("\n"); 
		query.append("  ,DECODE(PREV_LOAD,0,0, PREV_CM/PREV_LOAD)  AS PREV_CMB" ).append("\n"); 
		query.append("  ,DECODE(CURR_LOAD,0,0, CURR_CM/CURR_LOAD)  AS CURR_CMB" ).append("\n"); 
		query.append("  ,DECODE(PREV_LOAD,0,0, PREV_OP/PREV_LOAD)  AS PREV_OPB" ).append("\n"); 
		query.append("  ,DECODE(CURR_LOAD,0,0, CURR_OP/CURR_LOAD)  AS CURR_OPB" ).append("\n"); 
		query.append("  ,PREV_BSA_CAPA" ).append("\n"); 
		query.append("  ,CURR_BSA_CAPA" ).append("\n"); 
		query.append("  ,DECODE(PREV_BSA_CAPA,0,0, PREV_LOAD/PREV_BSA_CAPA *100) AS PREV_LF" ).append("\n"); 
		query.append("  ,DECODE(CURR_BSA_CAPA,0,0, CURR_LOAD/CURR_BSA_CAPA *100) AS CURR_LF" ).append("\n"); 
		query.append("  ,DECODE(PREV_LOAD,  0,0,((CURR_LOAD-PREV_LOAD)    /ABS(PREV_LOAD))  *100)    AS LOAD_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_REV,   0,0,((CURR_REV-PREV_REV)      /ABS(PREV_REV))   *100)    AS REV_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_CM,    0,0,((CURR_CM-PREV_CM)        /ABS(PREV_CM))    *100)    AS CM_CHNG" ).append("\n"); 
		query.append("  ,DECODE((PREV_BKG_OP + PREV_STP_PROFIT),0,0,((CURR_CM + CURR_STP_PROFIT) - (PREV_BKG_OP + PREV_STP_PROFIT))/ABS(PREV_BKG_OP + PREV_STP_PROFIT)*100) AS OP_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_BKG_OP,0,0,((CURR_BKG_OP-PREV_BKG_OP)/ABS(PREV_BKG_OP))*100)    AS BKG_OP_CHNG" ).append("\n"); 
		query.append("  ,CURR_BSA_CAPA-PREV_BSA_CAPA                                                 AS BSA_CAPA_CHNG" ).append("\n"); 
		query.append("  ,DECODE(CURR_BSA_CAPA  ,0,0,CURR_LOAD/CURR_BSA_CAPA *100)-DECODE(PREV_BSA_CAPA,0,0,PREV_LOAD/PREV_BSA_CAPA*100) AS LF_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_OTH_ABC_SVC,0,0,((CURR_OTH_ABC_SVC-PREV_STP_REV)/ABS(PREV_OTH_ABC_SVC))*100)              AS OTH_ABC_SVC_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_STP_REV,0,0,((CURR_STP_REV-PREV_STP_REV)/ABS(PREV_STP_REV))*100)                          AS STP_REV_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_BALANCE_SVC,0,0,((CURR_BALANCE_SVC-PREV_BALANCE_SVC)/ABS(PREV_BALANCE_SVC))*100)          AS BALANCE_SVC_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_OTH_ABC_CONT,0,0,((CURR_OTH_ABC_CONT-PREV_OTH_ABC_CONT)/ABS(PREV_OTH_ABC_CONT))*100)      AS OTH_ABC_CONT_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_STP_COST,0,0,((CURR_STP_COST-PREV_STP_COST)/ABS(PREV_STP_COST))*100)                      AS STP_COST_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_BALANCE_CONT,0,0,((CURR_BALANCE_CONT-PREV_BALANCE_CONT)/ABS(PREV_BALANCE_CONT))*100)      AS BALANCE_CONT_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_STP_PROFIT,0,0,((CURR_STP_PROFIT-PREV_STP_PROFIT)/ABS(PREV_STP_PROFIT))*100)              AS STP_PROFIT_CHNG" ).append("\n"); 
		query.append("  ,DECODE(PREV_LOAD,  0,0,(((CURR_CM + CURR_STP_PROFIT)-(PREV_CM + PREV_STP_PROFIT))    /ABS(PREV_CM + PREV_STP_PROFIT))  *100)    AS BRANCH_CHNG" ).append("\n"); 
		query.append("  ,DECODE(CURR_LOAD,0,0,CURR_REV/CURR_LOAD)-DECODE(PREV_LOAD,0,0,PREV_REV/PREV_LOAD) AS RPB_CHNG" ).append("\n"); 
		query.append("  ,DECODE(CURR_LOAD, 0,0,CURR_CM/CURR_LOAD)-DECODE(PREV_LOAD, 0,0,PREV_CM/PREV_LOAD) AS CMB_CHNG" ).append("\n"); 
		query.append("  ,ROUND((CURR_LOAD-PREV_LOAD)*DECODE(PREV_LOAD,0,0,PREV_REV/PREV_LOAD), 5)                                            AS BY_LOAD_GREV" ).append("\n"); 
		query.append("  ,ROUND((DECODE(CURR_LOAD,0,0,CURR_REV/CURR_LOAD)-DECODE(PREV_LOAD,0,0,PREV_REV/PREV_LOAD))*CURR_LOAD, 5)             AS BY_RPB_GREV" ).append("\n"); 
		query.append("  ,ROUND((CURR_LOAD-PREV_LOAD)*(DECODE(PREV_LOAD,0,0,PREV_CM_COST/PREV_LOAD)), 5)                                      AS BY_LOAD_COST" ).append("\n"); 
		query.append("  ,ROUND(((DECODE(CURR_LOAD,0,0,CURR_CM_COST/CURR_LOAD))-(DECODE(PREV_LOAD,0,0,PREV_CM_COST/PREV_LOAD)))*CURR_LOAD, 5) AS BY_CPB_COST" ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(PREV_LOAD) OVER(),0)*100 , 5)                                                               AS PREV_LOAD_SHARE" ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(CURR_LOAD) OVER(),0)*100 , 5)                                                               AS CURR_LOAD_SHARE" ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(PREV_CM)   OVER(),0)*100 , 5)                                                               AS PREV_CM_SHARE" ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(CURR_CM)   OVER(),0)*100 , 5)                                                               AS CURR_CM_SHARE" ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(PREV_CM-PREV_OP_COST) OVER(),0)*100 , 5)                                                    AS PREV_BKG_OP_SHARE" ).append("\n"); 
		query.append("  ,ROUND(NVL(RATIO_TO_REPORT(CURR_CM-CURR_OP_COST) OVER(),0)*100 , 5)                                                    AS CURR_BKG_OP_SHARE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT ''" ).append("\n"); 
		query.append("       ,OFC_CD1" ).append("\n"); 
		query.append("       ,OFC_CD2" ).append("\n"); 
		query.append("       ,TRD_CD" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='1')" ).append("\n"); 
		query.append("      ,NULL AS SUB_TRD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='1' ||${f_rpt_item} =='2')" ).append("\n"); 
		query.append("      ,NULL AS RLANE_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='1' ||${f_rpt_item} =='2'||${f_rpt_item} =='3')" ).append("\n"); 
		query.append("      ,NULL AS VSL_CD" ).append("\n"); 
		query.append("      ,NULL AS SKD_VOY_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${f_dir_sts} =='Y'||${f_rpt_item}=='4')" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,NULL AS DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), BKG_QTY)),0)                        AS PREV_LOAD" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), BKG_QTY)),0)                        AS CURR_LOAD" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), FR_REV)),0)                         AS PREV_REV" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), FR_REV)),0)                         AS CURR_REV" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), TOT_REV + DMDT - CM_COST)),0)              AS PREV_CM" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), TOT_REV + DMDT - CM_COST)),0)              AS CURR_CM" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), OTH_ABC_SVC) ) ,0)                  AS PREV_OTH_ABC_SVC" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), OTH_ABC_SVC) ) ,0)                  AS CURR_OTH_ABC_SVC" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), STP_REV) ) ,0)                      AS PREV_STP_REV" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), STP_REV) ) ,0)                      AS CURR_STP_REV" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), BALANCE_SVC) ) ,0)                  AS PREV_BALANCE_SVC" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), BALANCE_SVC) ) ,0)                  AS CURR_BALANCE_SVC" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), OTH_ABC_CONT) ) ,0)                 AS PREV_OTH_ABC_CONT" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), OTH_ABC_CONT) ) ,0)                 AS CURR_OTH_ABC_CONT" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), STP_COST) ) ,0)                     AS PREV_STP_COST" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), STP_COST) ) ,0)                     AS CURR_STP_COST" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), BALANCE_CONT) ) ,0)                 AS PREV_BALANCE_CONT" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), BALANCE_CONT) ) ,0)                 AS CURR_BALANCE_CONT" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), BALANCE_SVC) ) ,0)" ).append("\n"); 
		query.append("      +NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), BALANCE_CONT) ) ,0)                 AS PREV_STP_PROFIT" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), BALANCE_SVC) ) ,0)" ).append("\n"); 
		query.append("      +NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), BALANCE_CONT) ) ,0)                 AS CURR_STP_PROFIT" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), TOT_REV + DMDT - CM_COST - OP_COST)),0)    AS PREV_BKG_OP" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), TOT_REV + DMDT - CM_COST - OP_COST)),0)    AS CURR_BKG_OP" ).append("\n"); 
		query.append("      ,NULL                                                                                         AS PREV_OP" ).append("\n"); 
		query.append("      ,NULL                                                                                         AS CURR_OP" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), VVD_BSA_CAPA)),0)                   AS PREV_BSA_CAPA" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), VVD_BSA_CAPA)),0)                   AS CURR_BSA_CAPA" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), CM_COST)),0)                        AS PREV_CM_COST" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), CM_COST)),0)                        AS CURR_CM_COST" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_prev_week], 5, 2), OP_COST)),0)                        AS PREV_OP_COST" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B1.COST_WK, SUBSTR(@[f_curr_week], 5, 2), OP_COST)),0)                        AS CURR_OP_COST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT          " ).append("\n"); 
		query.append("          ''" ).append("\n"); 
		query.append("#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl1} =='1')" ).append("\n"); 
		query.append("         ,A4.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='2')" ).append("\n"); 
		query.append("         ,A4.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='3')" ).append("\n"); 
		query.append("         ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='4')" ).append("\n"); 
		query.append("         ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='5')" ).append("\n"); 
		query.append("         ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='6')" ).append("\n"); 
		query.append("         ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='7')" ).append("\n"); 
		query.append("         ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("#end OFC_CD1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_ofc_lvl2} =='1')" ).append("\n"); 
		query.append("         ,A4.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl2} =='2')" ).append("\n"); 
		query.append("         ,A4.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl2} =='3')" ).append("\n"); 
		query.append("         ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl2} =='4')" ).append("\n"); 
		query.append("         ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl2} =='5')" ).append("\n"); 
		query.append("         ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl2} =='6')" ).append("\n"); 
		query.append("         ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl2} =='7')" ).append("\n"); 
		query.append("         ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("#end OFC_CD2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          ,NULL AS OFC_CD1" ).append("\n"); 
		query.append("          ,NULL AS OFC_CD2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ,A1.TRD_CD" ).append("\n"); 
		query.append("          ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,A1.RLANE_CD" ).append("\n"); 
		query.append("          ,A1.VSL_CD" ).append("\n"); 
		query.append("          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A1.DIR_CD" ).append("\n"); 
		query.append("          ,NVL(A3.LOD_SPL_CNG_FLG,'N') AS LOD_SPL_CNG_FLG" ).append("\n"); 
		query.append("          ,A1.COST_WK" ).append("\n"); 
		query.append("          ,DECODE(NVL(A3.LOD_SPL_CNG_FLG,'N'),'Y', SUM(DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1,1),'2',NVL(A2.BKG_QTY,0),'3',NVL(A2.BKG_QTY,0),NVL(A2.BKG_QTY,0)*2))" ).append("\n"); 
		query.append("                                             ,'N', MAX(A1.VVD_BSA_CAPA))        AS VVD_BSA_CAPA" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1,1),'2',NVL(A2.BKG_QTY,0),'3',NVL(A2.BKG_QTY,0),NVL(A2.BKG_QTY,0)*2)),0) AS BKG_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(A2.BKG_REV+A2.BKG_OFT_REV),0)                                        AS FR_REV" ).append("\n"); 
		query.append("          ,NVL(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV),0)         AS TOT_REV" ).append("\n"); 
		query.append("          ,NVL(SUM(A2.DMDT_COM_AMT),0)                                                  AS DMDT" ).append("\n"); 
		query.append("#if(${f_pro_lvl} =='M')" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(@[f_pro_vw],'P', (A2.PA_CM_COST_TTL_AMT+NVL(A2.OWN_FDR_AMT,0)),'R',(A2.RA_CM_COST_TTL_AMT+NVL(A2.OWN_FDR_AMT,0)))),0) AS CM_COST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(@[f_pro_vw],'P', A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)),0) AS CM_COST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(@[f_pro_vw],'P', NVL(A6.PA_OP_COST_TTL_AMT, 0),'R',0)),0)                     AS OP_COST" ).append("\n"); 
		query.append("          ,NULL AS OTH_ABC_SVC" ).append("\n"); 
		query.append("          ,NULL AS STP_REV" ).append("\n"); 
		query.append("          ,NULL AS BALANCE_SVC" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(@[f_pro_vw],'P', 0,'R',A2.OTR_VOL_ACT_AMT)  )  ,0) AS OTH_ABC_CONT" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(@[f_pro_vw],'P', 0,'R',A2.STP_COST_AMT)     )  ,0) AS STP_COST" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(@[f_pro_vw],'P', 0,'R',A2.OTR_VOL_ACT_AMT)  )  ,0)" ).append("\n"); 
		query.append("          -NVL(SUM(DECODE(@[f_pro_vw],'P', 0,'R',A2.STP_COST_AMT)     )  ,0) AS BALANCE_CONT" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            MAS_BKG_EXPN_DTL_WK A2" ).append("\n"); 
		query.append("           ,MAS_BKG_OP_EXPN_DTL A6" ).append("\n"); 
		query.append("           ,MAS_MON_VVD A1" ).append("\n"); 
		query.append("           ,MAS_LANE_RGST A3" ).append("\n"); 
		query.append("           ,MAS_OFC_LVL A4" ).append("\n"); 
		query.append("        WHERE A1.TRD_CD              = A2.TRD_CD" ).append("\n"); 
		query.append("          AND A1.RLANE_CD            = A2.RLANE_CD" ).append("\n"); 
		query.append("          AND A1.IOC_CD              = A2.IOC_CD" ).append("\n"); 
		query.append("          AND A1.VSL_CD              = A2.VSL_CD" ).append("\n"); 
		query.append("          AND A1.SKD_VOY_NO          = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND A1.DIR_CD              = A2.DIR_CD" ).append("\n"); 
		query.append("          AND SUBSTR(A1.SLS_YRMON,1,4) || A1.COST_WK BETWEEN @[f_prev_week] AND @[f_curr_week]" ).append("\n"); 
		query.append("          AND SUBSTR(A1.SLS_YRMON,1,4) || A1.COST_WK = SUBSTR(A2.SLS_YRMON,1,4) || A2.COST_WK" ).append("\n"); 
		query.append("          AND A1.SLS_YRMON           = A2.SLS_YRMON" ).append("\n"); 
		query.append("          AND A1.COST_WK             = A2.COST_WK" ).append("\n"); 
		query.append("          AND A1.TRD_CD              = A3.TRD_CD" ).append("\n"); 
		query.append("          AND A1.RLANE_CD            = A3.RLANE_CD" ).append("\n"); 
		query.append("          AND A1.IOC_CD              = A3.IOC_CD" ).append("\n"); 
		query.append("          AND A1.DIR_CD              = A3.DIR_CD" ).append("\n"); 
		query.append("          AND A2.SLS_YRMON           BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("#if(${f_ofc_vw} =='C')" ).append("\n"); 
		query.append("          AND A2.AGMT_SGN_OFC_CD     = A4.OFC_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_vw} =='L')" ).append("\n"); 
		query.append("          AND A2.SLS_OFC_CD          = A4.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND NVL(A1.DELT_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("#if(${f_bkg_sts} =='Y')" ).append("\n"); 
		query.append("          AND A2.BKG_STS_CD        IN ('F','S','W')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND A2.BKG_STS_CD        IN ('F','S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         -- AND A2.BKG_CGO_TP_CD       <> 'P' 해당 조건의 BKG 들어오지 않음. 주석처리" ).append("\n"); 
		query.append("          AND A2.BL_NO_TP            IN ('M','0')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("    #if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("          AND DECODE('${f_ofc_lvl1}', '1', A4.OFC_N1ST_LVL_CD, '2', A4.OFC_N2ND_LVL_CD, '3', A4.OFC_N3RD_LVL_CD, '4', A4.OFC_N4TH_LVL_CD, '5', A4.OFC_N5TH_LVL_CD, '6', A4.OFC_N6TH_LVL_CD, '7', A4.OFC_N7TH_LVL_CD) = '${f_ofc_cd}'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          AND A4.OFC_CD = '${f_ofc_cd}'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ofc_lvl1}=='6' || ${f_ofc_lvl1}=='7')" ).append("\n"); 
		query.append("          AND A4.OFC_LVL = '${f_ofc_lvl1}'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	-------------------------------------------------------------------------------" ).append("\n"); 
		query.append("    -- 201401 부터 적용됨" ).append("\n"); 
		query.append("    -- SELBB, TYOBB 산하 XXXBS 레벨이 Sales Office 가 됨에 따라 Office Level2 가 Sales Office일때는 XXXBS가 조회안되도록 처리" ).append("\n"); 
		query.append("        AND A4.OFC_LVL <= CASE WHEN @[f_ofc_lvl1]='2' AND @[f_ofc_lvl2] <= '5' THEN DECODE(A4.OFC_N2ND_LVL_CD,'SELSC', '2', 'TYOSC', '2', '8') ELSE '8' END" ).append("\n"); 
		query.append("	-------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND A2.BKG_NO         = A6.BKG_NO(+)" ).append("\n"); 
		query.append("        AND A2.CNTR_TPSZ_CD   = A6.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("        AND A2.COST_ROUT_NO   = A6.COST_ROUT_NO(+)" ).append("\n"); 
		query.append("     GROUP BY ''" ).append("\n"); 
		query.append("/*      Office Display */" ).append("\n"); 
		query.append("#if(${f_ofc_sts} =='Y')	" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl1} =='1')" ).append("\n"); 
		query.append("            ,A4.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='2')" ).append("\n"); 
		query.append("            ,A4.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='3')" ).append("\n"); 
		query.append("            ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='4')" ).append("\n"); 
		query.append("            ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='5')" ).append("\n"); 
		query.append("            ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='6')" ).append("\n"); 
		query.append("            ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='7')" ).append("\n"); 
		query.append("            ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl2} =='1')" ).append("\n"); 
		query.append("            ,A4.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='2')" ).append("\n"); 
		query.append("            ,A4.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='3')" ).append("\n"); 
		query.append("            ,A4.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='4')" ).append("\n"); 
		query.append("            ,A4.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='5')" ).append("\n"); 
		query.append("            ,A4.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='6')" ).append("\n"); 
		query.append("            ,A4.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='7')" ).append("\n"); 
		query.append("            ,A4.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            ,A1.COST_WK" ).append("\n"); 
		query.append("            ,A1.TRD_CD" ).append("\n"); 
		query.append("            ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("            ,A1.RLANE_CD" ).append("\n"); 
		query.append("            ,A1.VSL_CD" ).append("\n"); 
		query.append("            ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("            ,A1.DIR_CD" ).append("\n"); 
		query.append("            ,A3.LOD_SPL_CNG_FLG" ).append("\n"); 
		query.append("            ,A1.VVD_BSA_CAPA" ).append("\n"); 
		query.append("#if(${f_pro_vw} =='R')" ).append("\n"); 
		query.append("/* -- STP 계산 ------*/" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        /* STE REV, ABC OTH SVC */" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("              /*+ USE_HASH(A2, A1, A3) PARALLEL(A2, 10) *//* + ORDERED */" ).append("\n"); 
		query.append("               ''" ).append("\n"); 
		query.append("#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl1} =='1')" ).append("\n"); 
		query.append("             ,A3.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='2')" ).append("\n"); 
		query.append("             ,A3.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='3')" ).append("\n"); 
		query.append("             ,A3.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='4')" ).append("\n"); 
		query.append("             ,A3.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='5')" ).append("\n"); 
		query.append("             ,A3.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='6')" ).append("\n"); 
		query.append("             ,A3.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='7')" ).append("\n"); 
		query.append("             ,A3.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end OFC_CD1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl2} =='1')" ).append("\n"); 
		query.append("             ,A3.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='2')" ).append("\n"); 
		query.append("             ,A3.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='3')" ).append("\n"); 
		query.append("             ,A3.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='4')" ).append("\n"); 
		query.append("             ,A3.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='5')" ).append("\n"); 
		query.append("             ,A3.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='6')" ).append("\n"); 
		query.append("             ,A3.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='7')" ).append("\n"); 
		query.append("             ,A3.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end OFC_CD2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             ,NULL AS OFC_CD1" ).append("\n"); 
		query.append("             ,NULL AS OFC_CD2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,A1.TRD_CD" ).append("\n"); 
		query.append("          ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,A1.RLANE_CD" ).append("\n"); 
		query.append("          ,A1.VSL_CD" ).append("\n"); 
		query.append("          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A1.DIR_CD" ).append("\n"); 
		query.append("          ,NULL AS LOD_SPL_CNG_FLG" ).append("\n"); 
		query.append("          ,A1.COST_WK" ).append("\n"); 
		query.append("          ,NULL AS VVD_BSA_CAPA" ).append("\n"); 
		query.append("          ,NULL AS BKG_QTY" ).append("\n"); 
		query.append("          ,NULL AS FR_REV" ).append("\n"); 
		query.append("          ,NULL AS TOT_REV" ).append("\n"); 
		query.append("          ,NULL AS DMDT" ).append("\n"); 
		query.append("          ,NULL AS CM_COST" ).append("\n"); 
		query.append("          ,NULL AS OP_COST" ).append("\n"); 
		query.append("          ,NVL(SUM(A2.OTR_PRC_AMT),0) AS OTH_ABC_SVC" ).append("\n"); 
		query.append("          ,NVL(SUM(A2.SVC_TRNS_PRC_AMT),0) AS STP_REV" ).append("\n"); 
		query.append("          ,NVL(SUM(A2.SVC_TRNS_PRC_AMT),0) - NVL(SUM(A2.OTR_PRC_AMT),0)  AS BALANCE_SVC" ).append("\n"); 
		query.append("          ,NULL AS OTH_ABC_CONT" ).append("\n"); 
		query.append("          ,NULL AS STP_COST" ).append("\n"); 
		query.append("          ,NULL AS BALANCE_CONT" ).append("\n"); 
		query.append("       FROM MAS_MON_VVD A1" ).append("\n"); 
		query.append("          ,MAS_BKG_SVC_TRNS_SMRY A2" ).append("\n"); 
		query.append("          ,MAS_OFC_LVL A3" ).append("\n"); 
		query.append("        WHERE A1.VSL_CD        = A2.VSL_CD" ).append("\n"); 
		query.append("          AND A1.SKD_VOY_NO    = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND A1.DIR_CD        = A2.DIR_CD" ).append("\n"); 
		query.append("          AND A1.TRD_CD        = A2.TRD_CD" ).append("\n"); 
		query.append("          AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("          AND A1.IOC_CD        = A2.IOC_CD" ).append("\n"); 
		query.append("          AND A1.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("          AND A2.BKG_STS_CD    IN ('S','F')" ).append("\n"); 
		query.append("          --AND A2.BKG_CGO_TP_CD <> 'P' 해당 조건의 BKG 들어오지 않음. 주석처리" ).append("\n"); 
		query.append("          AND A2.BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("          AND A1.COST_YRMON    BETWEEN A3.OFC_APLY_FM_YRMON AND A3.OFC_APLY_TO_YRMON   /* OFC 월별 관리 */" ).append("\n"); 
		query.append("          AND SUBSTR(A1.SLS_YRMON,1,4) || A1.COST_WK BETWEEN @[f_prev_week] AND @[f_curr_week]" ).append("\n"); 
		query.append("          AND A2.COND_OFC_CD = A3.OFC_CD" ).append("\n"); 
		query.append("#if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("    #if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("          AND DECODE(@[f_ofc_lvl1], '1', A3.OFC_N1ST_LVL_CD, '2', A3.OFC_N2ND_LVL_CD, '3', A3.OFC_N3RD_LVL_CD, '4', A3.OFC_N4TH_LVL_CD, '5', A3.OFC_N5TH_LVL_CD, '6', A3.OFC_N6TH_LVL_CD, '7', A3.OFC_N7TH_LVL_CD) = @[f_ofc_cd]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          AND A3.ofc_cd = @[f_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ofc_lvl1}=='6' || ${f_ofc_lvl1}=='7')" ).append("\n"); 
		query.append("          AND A3.OFC_LVL = @[f_ofc_lvl1]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND A3.OFC_LVL < '9'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY ''" ).append("\n"); 
		query.append("#if(${f_ofc_sts} =='Y')" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl1} =='1')" ).append("\n"); 
		query.append("             ,A3.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='2')" ).append("\n"); 
		query.append("             ,A3.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='3')" ).append("\n"); 
		query.append("             ,A3.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='4')" ).append("\n"); 
		query.append("             ,A3.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='5')" ).append("\n"); 
		query.append("             ,A3.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='6')" ).append("\n"); 
		query.append("             ,A3.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl1} =='7')" ).append("\n"); 
		query.append("             ,A3.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${f_ofc_lvl2} =='1')" ).append("\n"); 
		query.append("             ,A3.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='2')" ).append("\n"); 
		query.append("             ,A3.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='3')" ).append("\n"); 
		query.append("             ,A3.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='4')" ).append("\n"); 
		query.append("             ,A3.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='5')" ).append("\n"); 
		query.append("             ,A3.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='6')" ).append("\n"); 
		query.append("             ,A3.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("    #elseif (${f_ofc_lvl2} =='7')" ).append("\n"); 
		query.append("             ,A3.OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             ,A1.COST_WK" ).append("\n"); 
		query.append("             ,A1.TRD_CD" ).append("\n"); 
		query.append("             ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("             ,A1.RLANE_CD" ).append("\n"); 
		query.append("             ,A1.VSL_CD" ).append("\n"); 
		query.append("             ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("             ,A1.DIR_CD" ).append("\n"); 
		query.append("/* -- STP계산 끝   ------ */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ) b1" ).append("\n"); 
		query.append("    GROUP BY ''" ).append("\n"); 
		query.append("      ,OFC_CD1" ).append("\n"); 
		query.append("      ,OFC_CD2" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("#if(${f_rpt_item} !='1')" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='3'||${f_rpt_item} =='4')" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rpt_item} =='4')" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_sts} =='Y'||${f_rpt_item}=='4')" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("ORDER BY ''" ).append("\n"); 
		query.append("  ,OFC_CD1" ).append("\n"); 
		query.append("  ,OFC_CD2" ).append("\n"); 
		query.append("  ,TRD_CD" ).append("\n"); 
		query.append("  ,SUB_TRD_CD" ).append("\n"); 
		query.append("  ,RLANE_CD" ).append("\n"); 
		query.append("  ,VSL_CD" ).append("\n"); 
		query.append("  ,SKD_VOY_NO" ).append("\n"); 
		query.append("  ,DIR_CD" ).append("\n"); 

	}
}