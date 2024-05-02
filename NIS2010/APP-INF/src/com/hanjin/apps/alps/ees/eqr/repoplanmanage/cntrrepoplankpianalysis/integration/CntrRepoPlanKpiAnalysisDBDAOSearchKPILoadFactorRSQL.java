/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CntrRepoPlanKpiAnalysisDBDAOSearchKPILoadFactorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanKpiAnalysisDBDAOSearchKPILoadFactorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VESSEL 별 LOAD FACTOR 목표대비실적 조회
	  *  * CSR NO :N200903060090
	  *  * 제목    : EQR sked 기준 변경
	  *  * 내용    :EQR의 MT reposition by Vessel(T/D VVD, Water)의 도착예정시간 기준을 ETA에서 ETB로 변경바랍니다
	  * </pre>
	  */
	public CntrRepoPlanKpiAnalysisDBDAOSearchKPILoadFactorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanKpiAnalysisDBDAOSearchKPILoadFactorRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM" ).append("\n"); 
		query.append("      ,DECODE(CO_CD ,'H','SML','SEN')" ).append("\n"); 
		query.append("      ,RCC" ).append("\n"); 
		query.append("      ,TRADE" ).append("\n"); 
		query.append("      ,LANE" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,LAST_PORT" ).append("\n"); 
		query.append("      ,TO_CHAR(ETD_DT,'YYYY-MM-DD') ETD_DT" ).append("\n"); 
		query.append("      ,YRWK" ).append("\n"); 
		query.append("      ,F_20" ).append("\n"); 
		query.append("      ,F_40" ).append("\n"); 
		query.append("      ,F_HC" ).append("\n"); 
		query.append("      ,F_45" ).append("\n"); 
		query.append("      ,(F_20 + F_40 + F_HC + F_45 ) F_TTL" ).append("\n"); 
		query.append("      ,E_20" ).append("\n"); 
		query.append("      ,E_40" ).append("\n"); 
		query.append("      ,E_HC" ).append("\n"); 
		query.append("      ,E_45" ).append("\n"); 
		query.append("      ,(E_20 + E_40 + E_HC + E_45 ) E_TTL" ).append("\n"); 
		query.append("      ,(F_20 + F_40 + F_HC + F_45 + E_20 + E_40 + E_HC + E_45) TOT_BOX" ).append("\n"); 
		query.append("      ,TEU" ).append("\n"); 
		query.append("      ,BSA_SPACE" ).append("\n"); 
		query.append("      ,BSA_WGT" ).append("\n"); 
		query.append("      ,NVL(DEAD_SLOT,0)" ).append("\n"); 
		query.append("      ,NVL(WEIGHT,0)* 0.001" ).append("\n"); 
		query.append("      ,(NVL(BSA_SPACE, 0) - TEU ) UNUSED_SPACE" ).append("\n"); 
		query.append(" 	  ,ROUND((F_TEU + NVL(DEAD_SLOT,0)) / DECODE(NVL(BSA_SPACE, 0), 0, 1, NVL(BSA_SPACE, 0))*100 ,1)   LOADFACTOR_SPACE                                                                                                                                                                          " ).append("\n"); 
		query.append("	  ,ROUND((TEU + NVL(DEAD_SLOT,0)) / DECODE(NVL(BSA_SPACE, 0), 0, 1, NVL(BSA_SPACE, 0))*100, 1) LOADFACTOR_TOT_SPACE                                                                                                                                                                          " ).append("\n"); 
		query.append("	  ,ROUND((WEIGHT/DECODE(BSA_WGT,0,1,BSA_WGT))*100,1) LOADFACTOR_WGT_TOTAL                                                                                                                                                                                                                                               " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A.CO_CD" ).append("\n"); 
		query.append("          ,A.RCC RCC" ).append("\n"); 
		query.append("          ,A.TRADE TRADE" ).append("\n"); 
		query.append("          ,A.IOC_CD" ).append("\n"); 
		query.append("          ,A.LANE LANE" ).append("\n"); 
		query.append("          ,A.VSL||A.VOY||A.DIR VVD" ).append("\n"); 
		query.append("          ,A.LAST_PORT LAST_PORT                                                                                                                                                                                  " ).append("\n"); 
		query.append("          ,A.ETD_DT ETD_DT" ).append("\n"); 
		query.append("          ,A.YRWK YRWK" ).append("\n"); 
		query.append("          ,A.F_SNAP_20 F_20" ).append("\n"); 
		query.append("          ,A.F_SNAP_40 F_40" ).append("\n"); 
		query.append("          ,A.F_SNAP_HC F_HC" ).append("\n"); 
		query.append("          ,A.F_SNAP_45 F_45" ).append("\n"); 
		query.append("          ,A.F_TEU F_TEU" ).append("\n"); 
		query.append("          ,A.E_SNAP_20 E_20" ).append("\n"); 
		query.append("          ,A.E_SNAP_40 E_40" ).append("\n"); 
		query.append("          ,A.E_SNAP_HC E_HC" ).append("\n"); 
		query.append("          ,A.E_SNAP_45 E_45" ).append("\n"); 
		query.append("          ,(A.F_TEU + A.E_TEU) TEU" ).append("\n"); 
		query.append("          ,B.DEAD_SLOT DEAD_SLOT" ).append("\n"); 
		query.append("          ,B.WEIGHT_TOTAL WEIGHT                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("          ,NVL((SELECT SUM(SPC_CTRL_SLT_CAPA)                                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                 FROM   BSA_VVD_OTR_CRR  CB" ).append("\n"); 
		query.append("                       ,COA_MON_VVD CM                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                 WHERE  CB.VSL_CD = A.VSL                                                                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                 AND    CB.SKD_VOY_NO  = A.VOY                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                 AND    CB.SKD_DIR_CD  = A.DIR 																									                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                 AND    CB.BSA_OP_JB_CD = '007'                                                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("                 AND    CB.CRR_CD IN  ('SEN','SML')                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("                 AND    CB.TRD_CD = A.TRADE                                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append(" 		         AND	CB.VSL_CD = CM.VSL_CD         " ).append("\n"); 
		query.append(" 		         AND	CB.SKD_VOY_NO = CM.SKD_VOY_NO " ).append("\n"); 
		query.append(" 		         AND	CB.SKD_DIR_CD = CM.DIR_CD     " ).append("\n"); 
		query.append(" 		         AND	CB.TRD_CD = CM.TRD_CD         " ).append("\n"); 
		query.append(" 		         AND 	CB.RLANE_CD = CM.RLANE_CD     " ).append("\n"); 
		query.append(" 		         AND	CM.DELT_FLG  = 'N'            " ).append("\n"); 
		query.append("               ),0)   BSA_SPACE                                                                                           				                                                                                                                                                                  " ).append("\n"); 
		query.append("          ,NVL(( " ).append("\n"); 
		query.append("                 SELECT ROUND( SUM(DECODE(BSA_OP_JB_CD, '009', decode(CRR_BSA_CAPA,0,1,CRR_BSA_CAPA))) / (SUM(DECODE(BSA_OP_JB_CD, '007', decode(CRR_BSA_CAPA,0,1,CRR_BSA_CAPA)))) * SUM(DECODE(BSA_OP_JB_CD, '007', SPC_CTRL_SLT_CAPA)),2)*1000  CRR_BSA_CAPA                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                 FROM  BSA_VVD_OTR_CRR                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                 WHERE  VSL_CD = a.vsl                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("                 AND SKD_VOY_NO =a.voy                                                                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                 AND SKD_DIR_CD  = A.dir 																											                                                                                                                                                                                                        " ).append("\n"); 
		query.append("  		         AND   BSA_OP_JB_CD in ('007','009' )                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("  		         AND   CRR_CD in('SML')                                                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("  		         AND    TRD_CD = A.TRADE         " ).append("\n"); 
		query.append("  		       ),0)  BSA_WGT                                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("        -- 20100511 MODIFIED BY SHIN YONGCHAN, TUNNING KIM BONGKAB (/*+ FULL(vs) */ 추가)" ).append("\n"); 
		query.append("        SELECT   /*+ FULL(vs) */  SP.CO_CD" ).append("\n"); 
		query.append("				 -- 20100125 SQL TUNNING, SHIN YONGCHAN, KIM BONGGAB" ).append("\n"); 
		query.append("                 --,(SELECT DISTINCT RCC_CD  FROM MDM_EQ_ORZ_CHT  WHERE ECC_CD = CM.LST_LODG_PORT_CD AND ROWNUM = 1) RCC" ).append("\n"); 
		query.append("                ,(SELECT RCC_CD FROM MDM_EQ_ORZ_CHT  WHERE ECC_CD = CM.LST_LODG_PORT_CD AND ROWNUM = 1) RCC" ).append("\n"); 
		query.append("                ,CM.TRD_CD TRADE " ).append("\n"); 
		query.append("                ,CM.SLAN_CD LANE" ).append("\n"); 
		query.append("                ,CM.VSL_CD VSL" ).append("\n"); 
		query.append("                ,CM.SKD_VOY_NO VOY" ).append("\n"); 
		query.append("                ,CM.DIR_CD DIR" ).append("\n"); 
		query.append("                ,CM.LST_LODG_PORT_CD LAST_PORT" ).append("\n"); 
		query.append("                ,CM.LST_LODG_PORT_ETD_DT ETD_DT" ).append("\n"); 
		query.append("                ,CM.IOC_CD" ).append("\n"); 
		query.append("                ,(SELECT PLN_YR||PLN_WK FROM EQR_WK_PRD WHERE TO_CHAR(CM.LST_LODG_PORT_ETD_DT,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT) YRWK                                                                                                                                                       " ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'Y',DECODE(CNTR_TPSZ_CD , 'D2', CNTR_QTY 					                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                  	 	 	                                          , 'R2', CNTR_QTY					                                                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                    	 		                                      , 'O2', CNTR_QTY					                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                  	 		                                          , 'F2', CNTR_QTY, 0),0)),0) F_SNAP_20	                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("                 --PROJECT_NAME : 신규 장비(F5-40FT H/C FLAT RACK) 발주에 따른 NIS 상에 F5 등록" ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'Y',DECODE(CNTR_TPSZ_CD, 'D4', CNTR_QTY   				                                                                                                                                                                                                          " ).append("\n"); 
		query.append("      			                                                     , 'O4', CNTR_QTY	  				                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("      			                                                     , 'F5', CNTR_QTY	  				                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("       				                                                 , 'F4', CNTR_QTY , 0),0)),0) F_SNAP_40	                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'Y',DECODE(CNTR_TPSZ_CD, 'D5', CNTR_QTY   				                                                                                                                                                                                                          " ).append("\n"); 
		query.append("                      	                                             , 'R5', CNTR_QTY , 0),0)),0) F_SNAP_HC			                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'Y',DECODE(CNTR_TPSZ_CD, 'D7', CNTR_QTY , 0),0)),0) F_SNAP_45                                                                                                                                                                                               " ).append("\n"); 
		query.append("                --PROJECT_NAME : 신규 장비(F5-40FT H/C FLAT RACK) 발주에 따른 NIS 상에 F5 등록" ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'Y',DECODE(CNTR_TPSZ_CD,'D2', CNTR_QTY*1,                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                                                      'D4', CNTR_QTY*2,                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                                                      'D5', CNTR_QTY*2,                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                                                      'D7', CNTR_QTY*2.5,                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("                                                                      'O2', CNTR_QTY*1,                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                                                      'O4', CNTR_QTY*2,                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                                                      'R2', CNTR_QTY*1,                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                                                      'R5', CNTR_QTY*2,                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                                                      'F2', CNTR_QTY*1,                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                                                      'F5', CNTR_QTY*2,                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                                                      'F4', CNTR_QTY*2, 0),0)),0) F_TEU                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'N',DECODE(CNTR_TPSZ_CD, 'D2', CNTR_QTY 					                                                                                                                                                                                                          " ).append("\n"); 
		query.append("                  	 	 	                                         , 'R2', CNTR_QTY					                                                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                    	 		                                     , 'O2', CNTR_QTY					                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                  	 		                                         , 'F2', CNTR_QTY , 0),0)),0) E_SNAP_20	" ).append("\n"); 
		query.append("                --PROJECT_NAME : 신규 장비(F5-40FT H/C FLAT RACK) 발주에 따른 NIS 상에 F5 등록  	 		                                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'N',DECODE(CNTR_TPSZ_CD, 'D4', CNTR_QTY   				                                                                                                                                                                                                          " ).append("\n"); 
		query.append("      			                                                     , 'O4', CNTR_QTY	  				                                                                                                                                                                                                                                                                          		" ).append("\n"); 
		query.append("      			                                                     , 'F5', CNTR_QTY	  				                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("       				                                                 , 'F4', CNTR_QTY , 0),0)),0) E_SNAP_40	                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'N',DECODE(CNTR_TPSZ_CD, 'D5', CNTR_QTY   				                                                                                                                                                                                                          " ).append("\n"); 
		query.append("                      	                                             , 'R5', CNTR_QTY , 0),0)),0) E_SNAP_HC			                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'N',DECODE(CNTR_TPSZ_CD  , 'D7', CNTR_QTY , 0),0)),0) E_SNAP_45                                                                                                                                                                                               " ).append("\n"); 
		query.append("                ,NVL(SUM(DECODE(CNTR_FULL_FLG,'N', CNTR_QTY * (SELECT TEU_FCTR_RT FROM EQR_ENG_INP_TEU_EQV TE WHERE SP.CNTR_TPSZ_CD = TE.CNTR_TPSZ_CD  AND TE.TEU_CMPU_TP_CD ='EB'),0)), 0) E_TEU                                                                                                          " ).append("\n"); 
		query.append("        FROM  EQR_SEA_INVT_SNAP_POL sp" ).append("\n"); 
		query.append("             ,COA_MON_VVD cm " ).append("\n"); 
		query.append("             ,VSK_VSL_PORT_SKD vs" ).append("\n"); 
		query.append("             ,COA_LANE_RGST cl" ).append("\n"); 
		query.append("             ,(" ).append("\n"); 
		query.append("                SELECT  COUNT(M2.TRD_CD) CNT" ).append("\n"); 
		query.append("                       ,M1.VSL_CD" ).append("\n"); 
		query.append("                       ,M1.SKD_VOY_NO" ).append("\n"); 
		query.append("                       ,M1.DIR_CD                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                FROM (  " ).append("\n"); 
		query.append("                         SELECT DISTINCT VSL_CD" ).append("\n"); 
		query.append("                                    ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                    ,DIR_CD " ).append("\n"); 
		query.append("                         FROM COA_MON_VVD" ).append("\n"); 
		query.append("                         WHERE LST_LODG_PORT_ETD_DT BETWEEN (SELECT TO_DATE(WK_ST_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[fr_week])  		                                                                                                                                                                                      " ).append("\n"); 
		query.append("                                                    AND     (SELECT TO_DATE(WK_END_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[to_week])	                                                                                                                                                                                  " ).append("\n"); 
		query.append("                     ) M1, " ).append("\n"); 
		query.append("                     COA_MON_VVD M2                                                                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                 WHERE M2.VSL_CD = M1.VSL_CD                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                 AND M2.SKD_VOY_NO = M1.SKD_VOY_NO                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("                 AND M2.DIR_CD = M1.DIR_CD                                                                                                                                                                                                                                                               " ).append("\n"); 
		query.append("                 GROUP BY M1.VSL_CD,M1.SKD_VOY_NO,M1.DIR_CD                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("               ) tr                                                                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("        WHERE  SP.SNAP_DT = " ).append("\n"); 
		query.append("            CASE WHEN CM.IOC_CD ='I' THEN                                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("                   CASE WHEN TRUNC(SYSDATE) = TRUNC(LST_LODG_PORT_ETD_DT+0.99999)" ).append("\n"); 
		query.append("                        THEN TO_CHAR(TRUNC(LST_LODG_PORT_ETD_DT+0.99999), 'YYYYMMDD')                                                                                                                                                        " ).append("\n"); 
		query.append("                            		-- CSRNO : N200903060090 의거 ETA-->ETB로 변경 " ).append("\n"); 
		query.append("                        WHEN  TRUNC(SYSDATE) < (SELECT /*+ INDEX_ASC(A XAK7VSK_VSL_PORT_SKD) */ TRUNC(MIN(VPS_ETB_DT)+0.99999)                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("                                           FROM VSK_VSL_PORT_SKD                                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("                                           WHERE VPS_ETD_DT > CM.LST_LODG_PORT_ETD_DT +0.99999                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                           AND VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')                                                                                                                                                                                                                               " ).append("\n"); 
		query.append("                                           AND VSL_CD = CM.VSL_CD                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("                                           AND SKD_VOY_NO = CM.SKD_VOY_NO                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("                                           AND SKD_DIR_CD = CM.DIR_CD)                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("                        THEN TO_CHAR(TRUNC(SYSDATE),'YYYYMMDD')                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                      --   		 CSRNO : N200903060090 의거 ETA-->ETB로 변경" ).append("\n"); 
		query.append("                        WHEN TRUNC(SYSDATE) >=  (SELECT /*+ INDEX_ASC(A XAK7VSK_VSL_PORT_SKD) */ TRUNC(MIN(VPS_ETB_DT)+0.99999)                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                                            FROM VSK_VSL_PORT_SKD                                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("                                            WHERE VPS_ETD_DT > CM.LST_LODG_PORT_ETD_DT +0.99999                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                            AND VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')                                                                                                                                                                                                                               " ).append("\n"); 
		query.append("                                            AND VSL_CD = CM.VSL_CD                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("                                            AND SKD_VOY_NO = CM.SKD_VOY_NO                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("                                            AND SKD_DIR_CD = CM.DIR_CD)                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("                   --   		 CSRNO : N200903060090 의거 ETA-->ETB로 변경" ).append("\n"); 
		query.append("                        THEN TO_CHAR( (SELECT /*+ INDEX_ASC(A XAK7VSK_VSL_PORT_SKD) */ TRUNC(MIN(VPS_ETB_DT)+0.99999) -1                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD                                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("                                  WHERE VPS_ETD_DT > CM.LST_LODG_PORT_ETD_DT +0.99999                                                                                                                                                                                                                    " ).append("\n"); 
		query.append("                                  AND VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')                                                                                                                                                                                                                               " ).append("\n"); 
		query.append("                                  AND VSL_CD = CM.VSL_CD                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("                                  AND SKD_VOY_NO = CM.SKD_VOY_NO                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("                                  AND SKD_DIR_CD = CM.DIR_CD)  ,'YYYYMMDD')                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                   END                                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("            ELSE                                                                                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                  CASE WHEN   CM.SLAN_CD = 'MIX' OR  CM.SLAN_CD = 'AEC' THEN                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                        CASE WHEN TRUNC(SYSDATE) = TRUNC(LST_LODG_PORT_ETD_DT+0.99999) " ).append("\n"); 
		query.append("                            THEN TO_CHAR(TRUNC(LST_LODG_PORT_ETD_DT+0.99999), 'YYYYMMDD')                                                                                                                                                    " ).append("\n"); 
		query.append("                        WHEN  TRUNC(SYSDATE) < (SELECT /*+ INDEX_ASC(A XAK7VSK_VSL_PORT_SKD) */ TRUNC(MIN(VPS_ETB_DT)+0.99999)                                                                                                                                                                                                                   " ).append("\n"); 
		query.append("                                               FROM VSK_VSL_PORT_SKD                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                                               WHERE VPS_ETD_DT > CM.LST_LODG_PORT_ETD_DT +0.99999                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                                               AND VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                                               AND VSL_CD = CM.VSL_CD                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                                               AND SKD_VOY_NO = CM.SKD_VOY_NO                                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                                               AND SKD_DIR_CD = CM.DIR_CD)                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                        THEN TO_CHAR(TRUNC(SYSDATE),'YYYYMMDD')                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("                        WHEN TRUNC(SYSDATE) >=  (SELECT /*+ INDEX_ASC(A XAK7VSK_VSL_PORT_SKD) */ TRUNC(MIN(VPS_ETB_DT)+0.99999)                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                                                WHERE VPS_ETD_DT > CM.LST_LODG_PORT_ETD_DT +0.99999                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                                                AND   VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                                                AND   VSL_CD = CM.VSL_CD                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                                                AND SKD_VOY_NO = CM.SKD_VOY_NO                                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                                                AND SKD_DIR_CD = CM.DIR_CD)                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                        THEN TO_CHAR( (SELECT /*+ INDEX_ASC(A XAK7VSK_VSL_PORT_SKD) */ TRUNC(MIN(VPS_ETB_DT)+0.99999) -1                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                                       WHERE VPS_ETD_DT > CM.LST_LODG_PORT_ETD_DT +0.99999                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                                       AND VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                                       AND VSL_CD = CM.VSL_CD                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                                       AND SKD_VOY_NO = CM.SKD_VOY_NO                                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                                       AND SKD_DIR_CD = CM.DIR_CD)  ,'YYYYMMDD')                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("                  END                                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("            ELSE                                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("                 CASE WHEN TRUNC(SYSDATE) = TRUNC(LST_LODG_PORT_ETD_DT+0.99999) " ).append("\n"); 
		query.append("                      THEN TO_CHAR(TRUNC(LST_LODG_PORT_ETD_DT+0.99999), 'YYYYMMDD')                                                                                                                                                     " ).append("\n"); 
		query.append("                      WHEN  TRUNC(SYSDATE) < (SELECT /*+ INDEX_ASC(A XAK7VSK_VSL_PORT_SKD) */ TRUNC(MIN(VPS_ETB_DT)+0.99999) -2                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                                              FROM VSK_VSL_PORT_SKD                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                                              WHERE VPS_ETD_DT > CM.LST_LODG_PORT_ETD_DT +0.99999                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                                              AND VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                                              AND VSL_CD = CM.VSL_CD                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                                              AND SKD_VOY_NO = CM.SKD_VOY_NO                                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                                              AND SKD_DIR_CD = CM.DIR_CD)                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                      THEN TO_CHAR(TRUNC(SYSDATE),'YYYYMMDD')                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("                      WHEN TRUNC(SYSDATE) >=  (SELECT /*+ INDEX_ASC(A XAK7VSK_VSL_PORT_SKD) */  TRUNC(MIN(VPS_ETB_DT)+0.99999) -2                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                                               FROM VSK_VSL_PORT_SKD                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                                               WHERE VPS_ETD_DT > CM.LST_LODG_PORT_ETD_DT +0.99999                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                                               AND VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                                               AND VSL_CD = CM.VSL_CD                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                                               AND SKD_VOY_NO = CM.SKD_VOY_NO                                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                                               AND SKD_DIR_CD = CM.DIR_CD)                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                      THEN TO_CHAR( (SELECT /*+ INDEX_ASC(A XAK7VSK_VSL_PORT_SKD) */  TRUNC(MIN(VPS_ETB_DT)+0.99999) -3                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("                                     FROM VSK_VSL_PORT_SKD                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("                                     WHERE VPS_ETD_DT > CM.LST_LODG_PORT_ETD_DT +0.99999                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                                     AND VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                                     AND VSL_CD = CM.VSL_CD                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                                     AND SKD_VOY_NO = CM.SKD_VOY_NO                                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("                                     AND SKD_DIR_CD = CM.DIR_CD)  ,'YYYYMMDD')                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("                     END                                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("                END                                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("           END                                                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append("        AND  CM.LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("             BETWEEN                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("             (SELECT TO_DATE(WK_ST_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[fr_week])  		                                                                                                                                                                                          " ).append("\n"); 
		query.append("              AND" ).append("\n"); 
		query.append("             (SELECT TO_DATE(WK_END_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[to_week])	                                                                                                                                                                                      " ).append("\n"); 
		query.append("        AND CM.IOC_CD = DECODE(CNT,1, CM.IOC_CD, 'O')                                                                                                                                                                                                                                              " ).append("\n"); 
		query.append("        AND SP.VSL_CD      = CM.VSL_CD                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("        AND SP.SKD_VOY_NO  = CM.SKD_VOY_NO                                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("        AND SP.SKD_DIR_CD  = CM.DIR_CD                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("        AND SP.VSL_SLAN_CD = CM.SLAN_CD                                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("        AND SP.VSL_CD      = VS.VSL_CD                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("        AND SP.SKD_VOY_NO  = VS.SKD_VOY_NO                                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("        AND SP.SKD_DIR_CD  = VS.SKD_DIR_CD                                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("        AND CM.LST_LODG_PORT_CD = VS.VPS_PORT_CD                                                                                                                                                                                                                                                   " ).append("\n"); 
		query.append("        AND CM.SLAN_CD     = VS.SLAN_CD                                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("        AND CM.TRD_CD      = CL.TRD_CD                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("        AND CM.RLANE_CD    = CL.RLANE_CD                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("        AND CM.DIR_CD      = CL.DIR_CD                                                                                                                                                                                                                                                             " ).append("\n"); 
		query.append("        AND SP.VSL_CD       = TR.VSL_CD                                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("        AND SP.SKD_VOY_NO   = TR.SKD_VOY_NO                                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("        AND SP.SKD_DIR_CD   = TR.DIR_CD                                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("        AND CL.VSL_LANE_TP_CD IN ('SC','JO')                                                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("        AND NVL(CM.DELT_FLG,'N') <> 'Y'                                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("        GROUP BY  SP.CO_CD" ).append("\n"); 
		query.append("                 ,CM.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("                 ,CM.TRD_CD " ).append("\n"); 
		query.append("                 ,CM.SLAN_CD " ).append("\n"); 
		query.append("                 ,CM.VSL_CD" ).append("\n"); 
		query.append("                 ,CM.SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,CM.DIR_CD" ).append("\n"); 
		query.append("                 ,CM.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("                 ,CM.IOC_CD" ).append("\n"); 
		query.append("                 ,VS.CLPT_SEQ" ).append("\n"); 
		query.append("                 ,SP.SNAP_DT" ).append("\n"); 
		query.append("                 ,CM.LST_LODG_PORT_ETD_DT                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("    ) A, " ).append("\n"); 
		query.append("    (  " ).append("\n"); 
		query.append("        SELECT  VSL" ).append("\n"); 
		query.append("               ,VOY" ).append("\n"); 
		query.append("               ,DIR" ).append("\n"); 
		query.append("               ,POL" ).append("\n"); 
		query.append("               ,SUM(DEAD_SLOT) DEAD_SLOT" ).append("\n"); 
		query.append("               ,SUM(NVL(CNTR_WGT,0)) WEIGHT_TOTAL                                                                                                                                                                                                    " ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("        (  " ).append("\n"); 
		query.append("            SELECT BV.VSL_CD VSL" ).append("\n"); 
		query.append("                  ,BV.SKD_VOY_NO VOY" ).append("\n"); 
		query.append("                  ,BV.SKD_DIR_CD DIR" ).append("\n"); 
		query.append("                  ,BV. POL_CD POL                                                                                                                                                                                                           " ).append("\n"); 
		query.append("                  ,NVL(DECODE(BK.BKG_CGO_TP_CD,'F',(DECODE(BC.CNTR_TPSZ_CD,'D5',1,'R5',1,0)),                                                                                                                                                                                                           " ).append("\n"); 
		query.append("         	                     'P',(DECODE(BC.CNTR_TPSZ_CD,'D5',1,'R5',1,0)),                                                                                                                                                                                                           " ).append("\n"); 
		query.append("         	                         (DECODE(BC.AWK_CGO_FLG,'Y',1,0))),0) DEAD_SLOT                                                                                                                                                                                             " ).append("\n"); 
		query.append("         	      ,BC.CNTR_WGT CNTR_WGT                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("            FROM BKG_VVD BV, BKG_BOOKING BK, BKG_CONTAINER BC, COA_MON_VVD CM	                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("            WHERE CM.LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("                    BETWEEN                                                                                                                                                                                                                                                   " ).append("\n"); 
		query.append("                     (SELECT TO_DATE(WK_ST_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[fr_week])  		                                                                                                                                                                                      " ).append("\n"); 
		query.append("                    AND	" ).append("\n"); 
		query.append("                     (SELECT TO_DATE(WK_END_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[to_week])                                                                                                                                                                                      " ).append("\n"); 
		query.append("            AND BV.VSL_CD     = BK.VSL_CD 								                                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("            AND BV.SKD_VOY_NO   = BK.SKD_VOY_NO						                                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD   = BK.SKD_DIR_CD 	                                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("            AND BV.POL_CD       = BK.POL_CD                                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("            AND BV.BKG_NO       = BK.BKG_NO 								                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("            AND BV.BKG_NO       = BK.BKG_NO	                                                                                                                                                                                                                                                  " ).append("\n"); 
		query.append("            AND BV.BKG_NO       = BC.BKG_NO 								                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("            AND BV.BKG_NO       = BC.BKG_NO			                                                                                                                                                                                                                                            " ).append("\n"); 
		query.append("            AND BV.VSL_CD       = CM.VSL_CD 								                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("            AND BV.SKD_VOY_NO   = CM.SKD_VOY_NO 						                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD   = CM.DIR_CD                                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("            AND BV.SLAN_CD      = CM.SLAN_CD                                                                                                                                                                                                                                                        " ).append("\n"); 
		query.append("            AND BK.BKG_STS_CD IN ('F','S')                                                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("            AND BV.POL_CD       = CM.LST_LODG_PORT_CD                                                                                                                                                                                                                                               " ).append("\n"); 
		query.append("        )                                                                                                                                                                                                                                                                                          " ).append("\n"); 
		query.append("        GROUP BY VSL" ).append("\n"); 
		query.append("                ,VOY" ).append("\n"); 
		query.append("                ,DIR" ).append("\n"); 
		query.append("                ,POL                                                                                                                                                                                                                                                                " ).append("\n"); 
		query.append("                                                                                                                                                                                                                                                                                                 " ).append("\n"); 
		query.append("    ) B                                                                                              																										                                                                                                                                          " ).append("\n"); 
		query.append("    WHERE A.VSL = B.VSL(+)                                                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("    AND   A.VOY = B.VOY(+)                                                                                                                                                                                                                                                                         " ).append("\n"); 
		query.append("    AND A.DIR = B.DIR(+)                                                                                                                                                                                                                                                                           " ).append("\n"); 
		query.append("    AND A.LAST_PORT = B.POL(+)                                                                                                                                                                                                                                                                     " ).append("\n"); 
		query.append("#if (${loccd} != \"\")" ).append("\n"); 
		query.append("  #if(${loctype} == \"R\")" ).append("\n"); 
		query.append("    AND LAST_PORT IN (SELECT ECC_CD FROM EQR_ECC_MST WHERE RCC_CD IN (${loccd}))  " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${loctype} == \"L\")" ).append("\n"); 
		query.append("    AND LAST_PORT IN (SELECT ECC_CD FROM EQR_ECC_MST WHERE LCC_CD in (${loccd}))  " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${loctype} == \"E\")" ).append("\n"); 
		query.append("    AND LAST_PORT IN (${loccd})  " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane} !=\"\")" ).append("\n"); 
		query.append("    AND A.LANE IN(${lane})" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${vvd} !=\"\")" ).append("\n"); 
		query.append("    AND A.VSL||A.VOY||A.DIR IN(${vvd})" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${trade} !=\"\")" ).append("\n"); 
		query.append("    AND A.TRADE IN(${trade})" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}