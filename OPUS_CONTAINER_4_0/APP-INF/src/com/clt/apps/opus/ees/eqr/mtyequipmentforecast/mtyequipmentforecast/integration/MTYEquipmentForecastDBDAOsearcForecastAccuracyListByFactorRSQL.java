/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearcForecastAccuracyListByFactorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearcForecastAccuracyListByFactorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY Balance Report의 In&Out Bound FCST Data의 정확도를 FACTOR별로 조회
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearcForecastAccuracyListByFactorRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearcForecastAccuracyListByFactorRSQL").append("\n"); 
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
		query.append("WITH LV_QTY_LIST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.BOUND" ).append("\n"); 
		query.append("      ,GROUPING(A.LOC_CD)||GROUPING(A.YRWK)||GROUPING(A.BOUND) GLOC_CD" ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.YRWK),0,A.YRWK,'999999') YRWK" ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),0,A.LOC_CD,'ZZZZ9') LOC_CD" ).append("\n"); 
		query.append("      ,A.DP_SEQ" ).append("\n"); 
		query.append("      ,SUM(DECODE(A.DP_SEQ,3,A.TOT_ABS_QTY,A.TOT_QTY)) TOT_QTY" ).append("\n"); 
		query.append("      ,SUM(A.TOT_ABS_QTY) TOT_ABS_QTY" ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.D2_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.D2_QTY)),SUM(A.D2_QTY))) D2_QTY   " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.D4_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.D4_QTY)),SUM(A.D4_QTY))) D4_QTY   " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.D5_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.D5_QTY)),SUM(A.D5_QTY))) D5_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.D7_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.D7_QTY)),SUM(A.D7_QTY))) D7_QTY       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.R2_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.R2_QTY)),SUM(A.R2_QTY))) R2_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.R5_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.R5_QTY)),SUM(A.R5_QTY))) R5_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.O2_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.O2_QTY)),SUM(A.O2_QTY))) O2_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.O4_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.O4_QTY)),SUM(A.O4_QTY))) O4_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.S2_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.S2_QTY)),SUM(A.S2_QTY))) S2_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.S4_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.S4_QTY)),SUM(A.S4_QTY))) S4_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.F2_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.F2_QTY)),SUM(A.F2_QTY))) F2_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.F4_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.F4_QTY)),SUM(A.F4_QTY))) F4_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.F5_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.F5_QTY)),SUM(A.F5_QTY))) F5_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.A2_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.A2_QTY)),SUM(A.A2_QTY))) A2_QTY       " ).append("\n"); 
		query.append("      ,DECODE(GROUPING(A.LOC_CD),1,SUM(ABS(A.A4_QTY)),DECODE(GROUPING(A.YRWK),1,SUM(ABS(A.A4_QTY)),SUM(A.A4_QTY))) A4_QTY       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,GROUPING(A.YRWK)||GROUPING(A.LOC_CD)      " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("              A.BOUND" ).append("\n"); 
		query.append("             ,A.YRWK" ).append("\n"); 
		query.append("             ,A.LOC_CD" ).append("\n"); 
		query.append("             ,A.DP_SEQ" ).append("\n"); 
		query.append("             ,SUM(A.CNTR_QTY) TOT_QTY" ).append("\n"); 
		query.append("             ,SUM(ABS(A.CNTR_QTY)) TOT_ABS_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'D2',A.CNTR_QTY,0)) D2_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'D4',A.CNTR_QTY,0)) D4_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'D5',A.CNTR_QTY,0)) D5_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'D7',A.CNTR_QTY,0)) D7_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'R2',A.CNTR_QTY,0)) R2_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'R5',A.CNTR_QTY,0)) R5_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'O2',A.CNTR_QTY,0)) O2_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'S2',A.CNTR_QTY,0)) S2_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'O4',A.CNTR_QTY,0)) O4_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'S4',A.CNTR_QTY,0)) S4_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'F2',A.CNTR_QTY,0)) F2_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'A2',A.CNTR_QTY,0)) A2_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'F4',A.CNTR_QTY,0)) F4_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'A4',A.CNTR_QTY,0)) A4_QTY" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.CNTR_TPSZ_CD,'F5',A.CNTR_QTY,0)) F5_QTY" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("                A.BOUND" ).append("\n"); 
		query.append("               ,A.YRWK" ).append("\n"); 
		query.append("               ,A.LOC_CD" ).append("\n"); 
		query.append("               ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               ,B.DP_SEQ" ).append("\n"); 
		query.append("               ,DECODE(B.DP_SEQ,1,A.FCAST_CNTR_QTY,2,A.PFMC_CNTR_QTY,3,A.DIFF_VOL,4,A.DIFF_RAT) CNTR_QTY" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT  " ).append("\n"); 
		query.append("                    A.BOUND" ).append("\n"); 
		query.append("                   ,A.YRWK" ).append("\n"); 
		query.append("                   ,A.LOC_CD" ).append("\n"); 
		query.append("                   ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   ,A.FCAST_CNTR_QTY" ).append("\n"); 
		query.append("                   ,A.PFMC_CNTR_QTY" ).append("\n"); 
		query.append("                   ,(A.FCAST_CNTR_QTY-A.PFMC_CNTR_QTY) DIFF_VOL" ).append("\n"); 
		query.append("                   ,DECODE(A.FCAST_CNTR_QTY,0,100,((A.FCAST_CNTR_QTY-A.PFMC_CNTR_QTY)/A.FCAST_CNTR_QTY)*100) DIFF_RAT" ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  " ).append("\n"); 
		query.append("                        A.BOUND" ).append("\n"); 
		query.append("                       ,A.YRWK" ).append("\n"); 
		query.append("                       ,A.LOC_CD" ).append("\n"); 
		query.append("                       ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       ,SUM(DECODE(A.SRC_CD,'F',A.CNTR_QTY,0)) FCAST_CNTR_QTY" ).append("\n"); 
		query.append("                       ,SUM(DECODE(A.SRC_CD,'P',A.CNTR_QTY,0)) PFMC_CNTR_QTY" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT  DECODE(A.MTY_BAL_TP_CD,'1','I/B','O/B') BOUND" ).append("\n"); 
		query.append("                            ,A.YRWK" ).append("\n"); 
		query.append("                            ,A.LOC_CD" ).append("\n"); 
		query.append("                            ,'F' SRC_CD" ).append("\n"); 
		query.append("                            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            ,SUM(NVL(A.CNTR_QTY,0)) CNTR_QTY" ).append("\n"); 
		query.append("                    FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                         SELECT " ).append("\n"); 
		query.append("                               A.MTY_BAL_TP_CD" ).append("\n"); 
		query.append("                              ,A.FCAST_YRWK YRWK" ).append("\n"); 
		query.append("                              ,B.ECC_CD LOC_CD" ).append("\n"); 
		query.append("                              ,DECODE(C.DP_SEQ,1,'D2',2,'D4',3,'D5',4,'D7',5,'R2',6,'R5',7,'O2',8,'S2',9,'O4',10,'S4',11,'F2',12,'A2',13,'F4',14,'A4',15,'F5') CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              ,MAX(DECODE(C.DP_SEQ, 1,D2_FCAST_QTY," ).append("\n"); 
		query.append("                                                2,D4_FCAST_QTY," ).append("\n"); 
		query.append("                                                3,D5_FCAST_QTY," ).append("\n"); 
		query.append("                                                4,D7_FCAST_QTY," ).append("\n"); 
		query.append("                                                5,R2_FCAST_QTY," ).append("\n"); 
		query.append("                                                6,R5_FCAST_QTY," ).append("\n"); 
		query.append("                                                7,O2_FCAST_QTY," ).append("\n"); 
		query.append("                                                8,S2_FCAST_QTY," ).append("\n"); 
		query.append("                                                9,O4_FCAST_QTY," ).append("\n"); 
		query.append("                                                10,S4_FCAST_QTY," ).append("\n"); 
		query.append("                                                11,F2_FCAST_QTY," ).append("\n"); 
		query.append("                                                12,A2_FCAST_QTY," ).append("\n"); 
		query.append("                                                13,F4_FCAST_QTY," ).append("\n"); 
		query.append("                                                14,A4_FCAST_QTY," ).append("\n"); 
		query.append("                                                15,F5_FCAST_QTY,0))  CNTR_QTY                   " ).append("\n"); 
		query.append("                        FROM " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("							SELECT" ).append("\n"); 
		query.append("							    (SELECT /*+INDEX_DESC(W XPKEQR_WK_PRD) */" ).append("\n"); 
		query.append("							        W.PLN_YR||PLN_WK" ).append("\n"); 
		query.append("							    FROM EQR_WK_PRD W" ).append("\n"); 
		query.append("							    WHERE @[fm_week] > W.PLN_YR||PLN_WK" ).append("\n"); 
		query.append("							    AND   ROWNUM = 1" ).append("\n"); 
		query.append("							    ) FM_INP_WEEK" ).append("\n"); 
		query.append("							    ,(SELECT /*+INDEX_DESC(W XPKEQR_WK_PRD) */" ).append("\n"); 
		query.append("							        W.PLN_YR||PLN_WK" ).append("\n"); 
		query.append("							    FROM EQR_WK_PRD W" ).append("\n"); 
		query.append("							    WHERE @[to_week] > W.PLN_YR||PLN_WK" ).append("\n"); 
		query.append("							    AND   ROWNUM = 1" ).append("\n"); 
		query.append("							    ) TO_INP_WEEK" ).append("\n"); 
		query.append("							FROM DUAL    " ).append("\n"); 
		query.append("							) W,EQR_MTY_BAL_RPT A, MDM_EQ_ORZ_CHT  B , (SELECT LEVEL DP_SEQ FROM DUAL CONNECT BY LEVEL <= 15) C " ).append("\n"); 
		query.append("                        WHERE A.CO_CD ='O'" ).append("\n"); 
		query.append("                        AND   A.INP_YRWK  BETWEEN W.FM_INP_WEEK AND W.TO_INP_WEEK" ).append("\n"); 
		query.append("                        AND   A.FCAST_YRWK = (SELECT W.PLN_YR||PLN_WK" ).append("\n"); 
		query.append("                                              FROM EQR_WK_PRD W" ).append("\n"); 
		query.append("                                              WHERE A.INP_YRWK <  W.PLN_YR||PLN_WK" ).append("\n"); 
		query.append("                                              AND   ROWNUM =1)" ).append("\n"); 
		query.append("						#if (${bound} == 'A' )" ).append("\n"); 
		query.append("	                        AND   A.MTY_BAL_TP_CD IN('1','3')   " ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							AND   DECODE(@[bound],'I','1','O','3') =  A.MTY_BAL_TP_CD      " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    	AND   A.LOC_CD = B.ECC_CD" ).append("\n"); 
		query.append("                        #if (${loc_tp_cd} == 'E' )" ).append("\n"); 
		query.append("                        	AND   @[loc_cd] = B.ECC_CD" ).append("\n"); 
		query.append("                       	#elseif (${loc_tp_cd} == 'L' )" ).append("\n"); 
		query.append("                        	AND   @[loc_cd] = B.LCC_CD" ).append("\n"); 
		query.append("                       	#elseif (${loc_tp_cd} == 'R' )" ).append("\n"); 
		query.append("                        	AND   @[loc_cd] = B.RCC_CD" ).append("\n"); 
		query.append("                       	#end" ).append("\n"); 
		query.append("                        GROUP BY A.MTY_BAL_TP_CD,B.ECC_CD,C.DP_SEQ,A.FCAST_YRWK" ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                    WHERE  A.CNTR_TPSZ_CD IN('D2','D4','D5','D7','R2','R5','O2','S2','O4','S4','F2','A2','F4','A4','F5')" ).append("\n"); 
		query.append("                    GROUP BY DECODE(A.MTY_BAL_TP_CD,'1','I/B','O/B'),A.YRWK,A.LOC_CD,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  A.BOUND" ).append("\n"); 
		query.append("                           ,A.YRWK" ).append("\n"); 
		query.append("                           ,A.LOC_CD" ).append("\n"); 
		query.append("                           ,'P' SRC_CD" ).append("\n"); 
		query.append("                           ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           ,A.CNTR_QTY" ).append("\n"); 
		query.append("                    FROM " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT   DECODE(B.DP_SEQ,1,'O/B','I/B') BOUND" ).append("\n"); 
		query.append("                                     ,A.YRWK" ).append("\n"); 
		query.append("                                     ,A.LOC_CD" ).append("\n"); 
		query.append("                                     ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     ,DECODE(B.DP_SEQ,1,OB_QTY,IB_QTY) CNTR_QTY " ).append("\n"); 
		query.append("                            FROM" ).append("\n"); 
		query.append("                                (SELECT A.TGT_YRWK YRWK" ).append("\n"); 
		query.append("                                       ,D.ECC_CD LOC_CD" ).append("\n"); 
		query.append("                                       ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                       ,SUM(A.IB_QTY) IB_QTY" ).append("\n"); 
		query.append("                                       ,SUM(A.OB_QTY) OB_QTY" ).append("\n"); 
		query.append("                                FROM  CIM_LOC_MTCH_BAK_SMRY A, MDM_LOCATION C, MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("                                WHERE A.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("                                AND   A.SOC_FLG = 'N'" ).append("\n"); 
		query.append("                                AND   A.ENR_FLG = 'N'" ).append("\n"); 
		query.append("                                AND   A.TGT_YRWK BETWEEN @[fm_week] AND @[to_week]" ).append("\n"); 
		query.append("                                AND   A.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("                                AND   C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("		                        #if (${loc_tp_cd} == 'E' )" ).append("\n"); 
		query.append("		                        	AND   @[loc_cd] = D.ECC_CD" ).append("\n"); 
		query.append("		                       	#elseif (${loc_tp_cd} == 'L' )" ).append("\n"); 
		query.append("		                        	AND   @[loc_cd] = D.LCC_CD" ).append("\n"); 
		query.append("		                       	#elseif (${loc_tp_cd} == 'R' )" ).append("\n"); 
		query.append("		                        	AND   @[loc_cd] = D.RCC_CD" ).append("\n"); 
		query.append("		                       	#end" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                AND   A.CNTR_TPSZ_CD IN('D2','D4','D5','D7','R2','R5','O2','S2','O4','S4','F2','A2','F4','A4','F5')" ).append("\n"); 
		query.append("                                GROUP BY A.TGT_YRWK,D.ECC_CD,A.CNTR_TPSZ_CD) A, (SELECT LEVEL DP_SEQ  FROM DUAL CONNECT BY LEVEL <=2) B" ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("						#if (${bound} != 'A' )" ).append("\n"); 
		query.append("                        	WHERE @[bound] = SUBSTR(A.BOUND,1,1)" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("                GROUP BY A.BOUND,A.YRWK,A.LOC_CD,A.CNTR_TPSZ_CD                " ).append("\n"); 
		query.append("                )  A" ).append("\n"); 
		query.append("            WHERE A.FCAST_CNTR_QTY + A.PFMC_CNTR_QTY > 0" ).append("\n"); 
		query.append("            ) A , (SELECT LEVEL DP_SEQ  FROM DUAL CONNECT BY LEVEL <=5) B" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("    GROUP BY  A.BOUND, A.YRWK,A.LOC_CD, A.DP_SEQ" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS((A.BOUND,A.LOC_CD,A.DP_SEQ,A.YRWK),(A.BOUND,A.LOC_CD,A.DP_SEQ),(A.BOUND,A.DP_SEQ,A.YRWK),(A.BOUND,A.DP_SEQ))" ).append("\n"); 
		query.append("ORDER BY DECODE(A.BOUND,'O/B',1,2), A.LOC_CD,A.DP_SEQ,A.YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", LV_QTY_LIST2 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("        A.BOUND" ).append("\n"); 
		query.append("       ,A.GLOC_CD" ).append("\n"); 
		query.append("       ,A.LOC_CD" ).append("\n"); 
		query.append("       ,A.DP_SEQ" ).append("\n"); 
		query.append("       ,A.YRWK" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.TOT_QTY,0,100,(C.TOT_QTY/B.TOT_QTY)*100),A.TOT_QTY) TOT_QTY   " ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.D2_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.D2_QTY+C.D2_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.D2_QTY,0,100, (C.D2_QTY/B.D2_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS D2_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.D4_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.D4_QTY+C.D4_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.D4_QTY,0,100, (C.D4_QTY/B.D4_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS D4_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.D5_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.D5_QTY+C.D5_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.D5_QTY,0,100, (C.D5_QTY/B.D5_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS D5_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.D7_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.D7_QTY+C.D7_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.D7_QTY,0,100, (C.D7_QTY/B.D7_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS D7_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.R2_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.R2_QTY+C.R2_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.R2_QTY,0,100, (C.R2_QTY/B.R2_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS R2_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.R5_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.R5_QTY+C.R5_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.R5_QTY,0,100, (C.R5_QTY/B.R5_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS R5_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.O2_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.O2_QTY+C.O2_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.O2_QTY,0,100, (C.O2_QTY/B.O2_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS O2_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.S2_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.S2_QTY+C.S2_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.S2_QTY,0,100, (C.S2_QTY/B.S2_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS S2_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.O4_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.O4_QTY+C.O4_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.O4_QTY,0,100, (C.O4_QTY/B.O4_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS O4_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.S4_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.S4_QTY+C.S4_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.S4_QTY,0,100, (C.S4_QTY/B.S4_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS S4_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.F2_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.F2_QTY+C.F2_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.F2_QTY,0,100, (C.F2_QTY/B.F2_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS F2_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.A2_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.A2_QTY+C.A2_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.A2_QTY,0,100, (C.A2_QTY/B.A2_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS A2_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.F4_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.F4_QTY+C.F4_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.F4_QTY,0,100, (C.F4_QTY/B.F4_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS F4_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.A4_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.A4_QTY+C.A4_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.A4_QTY,0,100, (C.A4_QTY/B.A4_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS A4_QTY         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,(CASE WHEN A.DP_SEQ <> '4' THEN " ).append("\n"); 
		query.append("		       A.F5_QTY" ).append("\n"); 
		query.append("		  ELSE " ).append("\n"); 
		query.append("		    ( CASE WHEN A.DP_SEQ||B.F5_QTY+C.F5_QTY = '40' THEN " ).append("\n"); 
		query.append("		          NULL" ).append("\n"); 
		query.append("		      ELSE " ).append("\n"); 
		query.append("		          DECODE(B.F5_QTY,0,100, (C.F5_QTY/B.F5_QTY)*100)" ).append("\n"); 
		query.append("		      END)" ).append("\n"); 
		query.append("		  END) AS F5_QTY         " ).append("\n"); 
		query.append("FROM LV_QTY_LIST A, LV_QTY_LIST B , LV_QTY_LIST C " ).append("\n"); 
		query.append("WHERE A.BOUND = B.BOUND" ).append("\n"); 
		query.append("AND   A.YRWK = B.YRWK" ).append("\n"); 
		query.append("AND   A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND   B.DP_SEQ = 1" ).append("\n"); 
		query.append("AND   A.BOUND = C.BOUND" ).append("\n"); 
		query.append("AND   A.YRWK = C.YRWK" ).append("\n"); 
		query.append("AND   A.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("AND   C.DP_SEQ = 3" ).append("\n"); 
		query.append("ORDER BY DECODE(A.BOUND,'O/B',1,2),LOC_CD,DP_SEQ,YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       A.BOUND" ).append("\n"); 
		query.append("       ,A.DP_SEQ" ).append("\n"); 
		query.append("       ,DECODE(A.LOC_CD,'ZZZZ9','Total',A.LOC_CD) LOC_CD" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,1,'FCST',2,'PFMC',3,'Diff. Vol',4,'Diff.(%)',5,'Evaluation') FACTOR" ).append("\n"); 
		query.append("       ,DECODE(A.YRWK,'999999','Total',A.YRWK) YRWK" ).append("\n"); 
		query.append("	   ,DECODE(A.DP_SEQ,2,TO_CHAR(ROUND(A.TOT_QTY,1),'999,999,999'),3,'ABS '||LTRIM(TO_CHAR(A.TOT_QTY,'999,999,999')),4,TO_CHAR(ROUND(A.TOT_QTY,1),'9,999,990.9')||'%',5,EQR_FCAST_EVAL_FNC(ABS(ROUND(B.TOT_QTY,1))),LTRIM(TO_CHAR(A.TOT_QTY),'999,999,999,999')) TOT_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.D2_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.D2_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.D2_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.D2_QTY,1),'999,999,999,999'))) D2_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.D4_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.D4_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.D4_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.D4_QTY,1),'999,999,999,999'))) D4_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.D5_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.D5_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.D5_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.D5_QTY,1),'999,999,999,999'))) D5_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.D7_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.D7_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.D7_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.D7_QTY,1),'999,999,999,999'))) D7_QTY" ).append("\n"); 
		query.append("                                                                                                                                                                                                                       " ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.R2_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.R2_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.R2_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.R2_QTY,1),'999,999,999,999'))) R2_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.R5_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.R5_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.R5_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.R5_QTY,1),'999,999,999,999'))) R5_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.O2_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.O2_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.O2_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.O2_QTY,1),'999,999,999,999'))) O2_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.S2_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.S2_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.S2_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.S2_QTY,1),'999,999,999,999'))) S2_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.O4_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.O4_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.O4_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.O4_QTY,1),'999,999,999,999'))) O4_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.S4_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.S4_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.S4_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.S4_QTY,1),'999,999,999,999'))) S4_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.F2_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.F2_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.F2_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.F2_QTY,1),'999,999,999,999'))) F2_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.A2_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.A2_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.A2_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.A2_QTY,1),'999,999,999,999'))) A2_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.F4_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.F4_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.F4_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.F4_QTY,1),'999,999,999,999'))) F4_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.A4_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.A4_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.A4_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.A4_QTY,1),'999,999,999,999'))) A4_QTY" ).append("\n"); 
		query.append("       ,DECODE(A.DP_SEQ,4,DECODE(B.F5_QTY,NULL,'',LTRIM(TO_CHAR(ROUND(B.F5_QTY,1),'9,999,990.9'))||'%'),5,LTRIM(TO_CHAR(EQR_FCAST_EVAL_FNC(ABS(ROUND(B.F5_QTY,1))))),LTRIM(TO_CHAR(ROUND(A.F5_QTY,1),'999,999,999,999'))) F5_QTY" ).append("\n"); 
		query.append("	   ,'FACTOR' VIEW_FLAG" ).append("\n"); 
		query.append("FROM LV_QTY_LIST2 A , LV_QTY_LIST2 b" ).append("\n"); 
		query.append("WHERE A.BOUND = B.BOUND" ).append("\n"); 
		query.append("AND   A.YRWK =  B.YRWK" ).append("\n"); 
		query.append("AND   A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND   B.DP_SEQ = 4" ).append("\n"); 
		query.append("#if (${loc_tp_cd} == 'E' )" ).append("\n"); 
		query.append("   AND A.LOC_CD <> 'ZZZZ9'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_tp_cd} == 'L' && ${loc_cd} =='HKHKG' )" ).append("\n"); 
		query.append("   AND A.LOC_CD <> 'ZZZZ9'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${fm_week} == ${to_week} )" ).append("\n"); 
		query.append("	AND A.YRWK <> '999999'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DECODE(A.BOUND,'O/B',1,2),A.LOC_CD,A.DP_SEQ,A.YRWK" ).append("\n"); 

	}
}