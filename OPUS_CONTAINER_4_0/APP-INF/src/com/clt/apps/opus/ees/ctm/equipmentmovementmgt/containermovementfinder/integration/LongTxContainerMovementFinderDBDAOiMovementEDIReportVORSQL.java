/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOiMovementEDIReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongTxContainerMovementFinderDBDAOiMovementEDIReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOiMovementEDIReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gap",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("data_by",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : LongTxContainerMovementFinderDBDAOiMovementEDIReportVORSQL").append("\n"); 
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
		query.append("#if (${data_by} == '1')" ).append("\n"); 
		query.append("        A.RCC_CD," ).append("\n"); 
		query.append("#elseif (${data_by} == '2')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD," ).append("\n"); 
		query.append("#elseif (${data_by} == '5')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD, A.CNT_CD," ).append("\n"); 
		query.append("#elseif (${data_by} == '3')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD, A.CNT_CD, A.LOC_CD," ).append("\n"); 
		query.append("#elseif (${data_by} == '4')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD, A.CNT_CD, A.LOC_CD, A.ORG_YD_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        @[gap] GAP, @[p_date1] P_DATE1, @[p_date2] P_DATE2, @[data_by] DATA_BY, SUM(NVL(L_TOT,0)) TOT, SUM(NVL(ML_TOT,0)) MTOT, SUM(NVL(EL_TOT,0)) ETOT, SUM(NVL(SL_TOT,0)) STOT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gap} == '12')" ).append("\n"); 
		query.append("        SUM(NVL(OFF_12,0)) OFF_12, SUM(NVL(MOFF_12,0)) MOFF_12, SUM(NVL(SOFF_12,0)) SOFF_12, SUM(NVL(EOFF_12,0)) EOFF_12," ).append("\n"); 
		query.append("       (SUM(NVL(OFF_12,0)) /  SUM(DECODE( L_TOT,0,1,  L_TOT)) * 100) PER_12," ).append("\n"); 
		query.append("       (SUM(NVL(MOFF_12,0)) / SUM(DECODE(ML_TOT,0,1, ML_TOT)) * 100) MPER_12," ).append("\n"); 
		query.append("       (SUM(NVL(EOFF_12,0)) / SUM(DECODE(EL_TOT,0,1, EL_TOT)) * 100) EPER_12," ).append("\n"); 
		query.append("       (SUM(NVL(SOFF_12,0)) / SUM(DECODE(SL_TOT,0,1, SL_TOT)) * 100) SPER_12," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ((SUM(NVL(OVR_48,0)) + SUM(NVL(OFF_24,0)) + SUM(NVL(OFF_48,0)) ))  OVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(MOVR_48,0))+ SUM(NVL(MOFF_24,0))+ SUM(NVL(MOFF_48,0)))) MOVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(EOVR_48,0))+ SUM(NVL(EOFF_24,0))+ SUM(NVL(EOFF_48,0)))) EOVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(SOVR_48,0))+ SUM(NVL(SOFF_24,0))+ SUM(NVL(SOFF_48,0)))) SOVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(OVR_48,0)) + SUM(NVL(OFF_24,0)) + SUM(NVL(OFF_48,0)) )/ SUM(DECODE( L_TOT,0,1,  L_TOT)) * 100)  OPER_48," ).append("\n"); 
		query.append("       ((SUM(NVL(MOVR_48,0))+ SUM(NVL(MOFF_24,0))+ SUM(NVL(MOFF_48,0)))/ SUM(DECODE(ML_TOT,0,1, ML_TOT)) * 100) MOPER_48," ).append("\n"); 
		query.append("       ((SUM(NVL(EOVR_48,0))+ SUM(NVL(EOFF_24,0))+ SUM(NVL(EOFF_48,0)))/ SUM(DECODE(EL_TOT,0,1, EL_TOT)) * 100) EOPER_48," ).append("\n"); 
		query.append("       ((SUM(NVL(SOVR_48,0))+ SUM(NVL(SOFF_24,0))+ SUM(NVL(SOFF_48,0)))/ SUM(DECODE(SL_TOT,0,1, SL_TOT)) * 100) SOPER_48" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${gap} == '24')" ).append("\n"); 
		query.append("        SUM(NVL(OFF_24,0) + NVL(OFF_12,0)) OFF_24, SUM(NVL(MOFF_24,0) + NVL(MOFF_12,0)) MOFF_24, SUM(NVL(SOFF_24,0) + NVL(SOFF_12,0)) SOFF_24, SUM(NVL(EOFF_24,0) + NVL(EOFF_12,0)) EOFF_24," ).append("\n"); 
		query.append("       (SUM(NVL(OFF_24,0) + NVL(OFF_12,0))  / SUM(DECODE( L_TOT,0,1,  L_TOT)) * 100) PER_24," ).append("\n"); 
		query.append("       (SUM(NVL(MOFF_24,0)+ NVL(MOFF_12,0)) / SUM(DECODE(ML_TOT,0,1, ML_TOT)) * 100) MPER_24," ).append("\n"); 
		query.append("       (SUM(NVL(EOFF_24,0)+ NVL(EOFF_12,0)) / SUM(DECODE(EL_TOT,0,1, EL_TOT)) * 100) EPER_24," ).append("\n"); 
		query.append("       (SUM(NVL(SOFF_24,0)+ NVL(SOFF_12,0)) / SUM(DECODE(SL_TOT,0,1, SL_TOT)) * 100) SPER_24," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ((SUM(NVL(OVR_48,0)) + SUM(NVL(OFF_48,0)) ))  OVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(MOVR_48,0))+ SUM(NVL(MOFF_48,0)))) MOVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(EOVR_48,0))+ SUM(NVL(EOFF_48,0)))) EOVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(SOVR_48,0))+ SUM(NVL(SOFF_48,0)))) SOVR_48," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ((SUM(NVL(OVR_48,0)) + SUM(NVL(OFF_48,0)) )/ SUM(DECODE( L_TOT,0,1,  L_TOT)) * 100)  OPER_48," ).append("\n"); 
		query.append("       ((SUM(NVL(MOVR_48,0))+ SUM(NVL(MOFF_48,0)))/ SUM(DECODE(ML_TOT,0,1, ML_TOT)) * 100) MOPER_48," ).append("\n"); 
		query.append("       ((SUM(NVL(EOVR_48,0))+ SUM(NVL(EOFF_48,0)))/ SUM(DECODE(EL_TOT,0,1, EL_TOT)) * 100) EOPER_48," ).append("\n"); 
		query.append("       ((SUM(NVL(SOVR_48,0))+ SUM(NVL(SOFF_48,0)))/ SUM(DECODE(SL_TOT,0,1, SL_TOT)) * 100) SOPER_48" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${gap} == '48')" ).append("\n"); 
		query.append("        SUM(NVL(OFF_24,0) + NVL(OFF_12,0) + NVL(OFF_48,0)) OFF_48, SUM(NVL(MOFF_24,0) + NVL(MOFF_12,0) + NVL(MOFF_48,0)) MOFF_48, SUM(NVL(SOFF_24,0) + NVL(SOFF_12,0) + NVL(SOFF_48,0)) SOFF_48, SUM(NVL(EOFF_24,0) + NVL(EOFF_12,0) + NVL(EOFF_48,0)) EOFF_48," ).append("\n"); 
		query.append("       (SUM(NVL(OFF_24,0) + NVL(OFF_12,0)  + NVL(OFF_48,0))  / SUM(DECODE( L_TOT,0,1,  L_TOT)) * 100) PER_48," ).append("\n"); 
		query.append("       (SUM(NVL(MOFF_24,0)+ NVL(MOFF_12,0) + NVL(MOFF_48,0)) / SUM(DECODE(ML_TOT,0,1, ML_TOT)) * 100) MPER_48," ).append("\n"); 
		query.append("       (SUM(NVL(EOFF_24,0)+ NVL(EOFF_12,0) + NVL(EOFF_48,0)) / SUM(DECODE(EL_TOT,0,1, EL_TOT)) * 100) EPER_48," ).append("\n"); 
		query.append("       (SUM(NVL(SOFF_24,0)+ NVL(SOFF_12,0) + NVL(SOFF_48,0)) / SUM(DECODE(SL_TOT,0,1, SL_TOT)) * 100) SPER_48," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ((SUM(NVL(OVR_48,0 ))))  OVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(MOVR_48,0)))) MOVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(EOVR_48,0)))) EOVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(SOVR_48,0)))) SOVR_48," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ((SUM(NVL(OVR_48,0)) )/ SUM(DECODE( L_TOT,0,1,  L_TOT)) * 100)  OPER_48," ).append("\n"); 
		query.append("       ((SUM(NVL(MOVR_48,0)))/ SUM(DECODE(ML_TOT,0,1, ML_TOT)) * 100) MOPER_48," ).append("\n"); 
		query.append("       ((SUM(NVL(EOVR_48,0)))/ SUM(DECODE(EL_TOT,0,1, EL_TOT)) * 100) EOPER_48," ).append("\n"); 
		query.append("       ((SUM(NVL(SOVR_48,0)))/ SUM(DECODE(SL_TOT,0,1, SL_TOT)) * 100) SOPER_48" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        SUM(NVL(OFF_12,0)) OFF_12, SUM(NVL(MOFF_12,0)) MOFF_12, SUM(NVL(SOFF_12,0)) SOFF_12, SUM(NVL(EOFF_12,0)) EOFF_12," ).append("\n"); 
		query.append("       (SUM(NVL(OFF_12,0)) /  SUM(DECODE( L_TOT,0,1,  L_TOT)) * 100) PER_12," ).append("\n"); 
		query.append("       (SUM(NVL(MOFF_12,0)) / SUM(DECODE(ML_TOT,0,1, ML_TOT)) * 100) MPER_12," ).append("\n"); 
		query.append("       (SUM(NVL(EOFF_12,0)) / SUM(DECODE(EL_TOT,0,1, EL_TOT)) * 100) EPER_12," ).append("\n"); 
		query.append("       (SUM(NVL(SOFF_12,0)) / SUM(DECODE(SL_TOT,0,1, SL_TOT)) * 100) SPER_12," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SUM(NVL(OFF_24,0)) OFF_24, SUM(NVL(MOFF_24,0)) MOFF_24, SUM(NVL(SOFF_24,0)) SOFF_24, SUM(NVL(EOFF_24,0)) EOFF_24," ).append("\n"); 
		query.append("       (SUM(NVL(OFF_24,0)) /  SUM(DECODE( L_TOT,0,1,  L_TOT)) * 100) PER_24," ).append("\n"); 
		query.append("       (SUM(NVL(MOFF_24,0)) / SUM(DECODE(ML_TOT,0,1, ML_TOT)) * 100) MPER_24," ).append("\n"); 
		query.append("       (SUM(NVL(EOFF_24,0)) / SUM(DECODE(EL_TOT,0,1, EL_TOT)) * 100) EPER_24," ).append("\n"); 
		query.append("       (SUM(NVL(SOFF_24,0)) / SUM(DECODE(SL_TOT,0,1, SL_TOT)) * 100) SPER_24," ).append("\n"); 
		query.append("        SUM(NVL(OFF_48,0)) OFF_48," ).append("\n"); 
		query.append("        SUM(NVL(MOFF_48,0)) MOFF_48," ).append("\n"); 
		query.append("        SUM(NVL(SOFF_48,0)) SOFF_48," ).append("\n"); 
		query.append("        SUM(NVL(EOFF_48,0)) EOFF_48," ).append("\n"); 
		query.append("       (SUM(NVL(OFF_48,0)) /  SUM(DECODE(L_TOT,0,1,  L_TOT)) * 100) PER_48," ).append("\n"); 
		query.append("       (SUM(NVL(MOFF_48,0)) / SUM(DECODE(ML_TOT,0,1,ML_TOT)) * 100) MPER_48," ).append("\n"); 
		query.append("       (SUM(NVL(EOFF_48,0)) / SUM(DECODE(EL_TOT,0,1,EL_TOT)) * 100) EPER_48," ).append("\n"); 
		query.append("       (SUM(NVL(SOFF_48,0)) / SUM(DECODE(SL_TOT,0,1,SL_TOT)) * 100) SPER_48," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SUM(NVL(OVR_48,0)) /  SUM(DECODE(L_TOT,0,1 , L_TOT)) * 100) OPER_48," ).append("\n"); 
		query.append("       (SUM(NVL(MOVR_48,0)) / SUM(DECODE(ML_TOT,0,1,ML_TOT)) * 100) MOPER_48," ).append("\n"); 
		query.append("       (SUM(NVL(EOVR_48,0)) / SUM(DECODE(EL_TOT,0,1,EL_TOT)) * 100) EOPER_48," ).append("\n"); 
		query.append("       (SUM(NVL(SOVR_48,0)) / SUM(DECODE(SL_TOT,0,1,SL_TOT)) * 100) SOPER_48," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ((SUM(NVL(OVR_48,0))))  OVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(MOVR_48,0)))) MOVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(EOVR_48,0)))) EOVR_48," ).append("\n"); 
		query.append("       ((SUM(NVL(SOVR_48,0)))) SOVR_48" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("            SELECT RCC_CD, LCC_CD, CNT_CD, LOC_CD, ORG_YD_CD," ).append("\n"); 
		query.append("                   SUM(OFF_12) OFF_12, SUM(OFF_24) OFF_24, SUM(OFF_48) OFF_48, SUM(OVR_48) OVR_48, SUM(L_TOT) L_TOT," ).append("\n"); 
		query.append("                   SUM( EOFF_12 ) EOFF_12," ).append("\n"); 
		query.append("                   SUM( EOFF_24 ) EOFF_24," ).append("\n"); 
		query.append("                   SUM( EOFF_48 ) EOFF_48," ).append("\n"); 
		query.append("                   SUM( EOVR_48 ) EOVR_48," ).append("\n"); 
		query.append("                   SUM( EL_TOT ) EL_TOT," ).append("\n"); 
		query.append("                   SUM( SOFF_12 ) SOFF_12," ).append("\n"); 
		query.append("                   SUM( SOFF_24 ) SOFF_24," ).append("\n"); 
		query.append("                   SUM( SOFF_48 ) SOFF_48," ).append("\n"); 
		query.append("                   SUM( SOVR_48 ) SOVR_48," ).append("\n"); 
		query.append("                   SUM( SL_TOT ) SL_TOT," ).append("\n"); 
		query.append("                   SUM( MOFF_12 ) MOFF_12," ).append("\n"); 
		query.append("                   SUM( MOFF_24 ) MOFF_24," ).append("\n"); 
		query.append("                   SUM( MOFF_48 ) MOFF_48," ).append("\n"); 
		query.append("                   SUM( MOVR_48 ) MOVR_48," ).append("\n"); 
		query.append("                   SUM( ML_TOT ) ML_TOT" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                  SELECT /*+ USE_NL(CTM LOC EQ) */ EQ.RCC_CD, EQ.LCC_CD, LOC.CNT_CD, LOC.LOC_CD, ORG_YD_CD," ).append("\n"); 
		query.append("                         OFF_12," ).append("\n"); 
		query.append("                         OFF_24," ).append("\n"); 
		query.append("                         OFF_48," ).append("\n"); 
		query.append("                         OVR_48," ).append("\n"); 
		query.append("                         EOFF_12," ).append("\n"); 
		query.append("                         EOFF_24," ).append("\n"); 
		query.append("                          EOFF_48," ).append("\n"); 
		query.append("                          EOVR_48," ).append("\n"); 
		query.append("                          SOFF_12," ).append("\n"); 
		query.append("                          SOFF_24," ).append("\n"); 
		query.append("                          SOFF_48," ).append("\n"); 
		query.append("                          SOVR_48," ).append("\n"); 
		query.append("                          MOFF_12," ).append("\n"); 
		query.append("                          MOFF_24," ).append("\n"); 
		query.append("                          MOFF_48," ).append("\n"); 
		query.append("                          MOVR_48," ).append("\n"); 
		query.append("                          (OFF_12 + OFF_24 + OFF_48 + OVR_48) L_TOT," ).append("\n"); 
		query.append("                          ( EOFF_12 + EOFF_24 + EOFF_48 + EOVR_48 ) EL_TOT," ).append("\n"); 
		query.append("                         ( SOFF_12 + SOFF_24 + SOFF_48 + SOVR_48 ) SL_TOT," ).append("\n"); 
		query.append("                         ( MOFF_12 + MOFF_24 + MOFF_48 + MOVR_48 ) ML_TOT" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                              SELECT  ORG_YD_CD," ).append("\n"); 
		query.append("                                      SUM( OFF_12 ) OFF_12," ).append("\n"); 
		query.append("                                      SUM( OFF_24 ) OFF_24," ).append("\n"); 
		query.append("                                      SUM( OFF_48 ) OFF_48," ).append("\n"); 
		query.append("                                      SUM( OVR_48 ) OVR_48," ).append("\n"); 
		query.append("                                      SUM( EOFF_12 ) EOFF_12," ).append("\n"); 
		query.append("                                      SUM( EOFF_24 ) EOFF_24," ).append("\n"); 
		query.append("                                      SUM( EOFF_48 ) EOFF_48," ).append("\n"); 
		query.append("                                      SUM( EOVR_48 ) EOVR_48," ).append("\n"); 
		query.append("                                      SUM( SOFF_12 ) SOFF_12," ).append("\n"); 
		query.append("                                      SUM( SOFF_24 ) SOFF_24," ).append("\n"); 
		query.append("                                      SUM( SOFF_48 ) SOFF_48," ).append("\n"); 
		query.append("                                      SUM( SOVR_48 ) SOVR_48," ).append("\n"); 
		query.append("                                      SUM( MOFF_12 ) MOFF_12," ).append("\n"); 
		query.append("                                      SUM( MOFF_24 ) MOFF_24," ).append("\n"); 
		query.append("                                      SUM( MOFF_48 ) MOFF_48," ).append("\n"); 
		query.append("                                      SUM( MOVR_48 ) MOVR_48" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                              FROM  (SELECT ORG_YD_CD," ).append("\n"); 
		query.append("                                                  CASE WHEN OFFSET_DT <= 0.5                     THEN CNT ELSE 0 END OFF_12," ).append("\n"); 
		query.append("                                                  CASE WHEN OFFSET_DT >  2                       THEN CNT ELSE 0 END OVR_48," ).append("\n"); 
		query.append("                                                  CASE WHEN OFFSET_DT >  0.5  AND OFFSET_DT <= 1 THEN CNT ELSE 0 END OFF_24," ).append("\n"); 
		query.append("                                                  CASE WHEN OFFSET_DT >  1    AND OFFSET_DT <= 2 THEN CNT ELSE 0 END OFF_48," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='EDI' AND OFFSET_DT <= 0.5 THEN CNT ELSE 0 END EOFF_12," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='EDI' AND OFFSET_DT > 2      THEN CNT ELSE 0 END EOVR_48," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='EDI' AND OFFSET_DT > 0.5    AND OFFSET_DT <= 1 THEN CNT ELSE 0 END EOFF_24," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='EDI' AND OFFSET_DT > 1     AND OFFSET_DT <= 2 THEN CNT ELSE 0 END EOFF_48," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='SPP' AND OFFSET_DT <= 0.5 THEN CNT ELSE 0 END SOFF_12," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='SPP' AND OFFSET_DT > 2      THEN CNT ELSE 0 END SOVR_48," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='SPP' AND OFFSET_DT > 0.5    AND OFFSET_DT <= 1 THEN CNT ELSE 0 END SOFF_24," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='SPP' AND OFFSET_DT > 1     AND OFFSET_DT <= 2 THEN CNT ELSE 0 END SOFF_48," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='MAN' AND OFFSET_DT <= 0.5 THEN CNT ELSE 0 END MOFF_12," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='MAN' AND OFFSET_DT > 2      THEN CNT ELSE 0 END MOVR_48," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='MAN' AND OFFSET_DT > 0.5    AND OFFSET_DT <= 1 THEN CNT ELSE 0 END MOFF_24," ).append("\n"); 
		query.append("                                                 CASE WHEN MVMT_INP_TP_CD='MAN' AND OFFSET_DT > 1     AND OFFSET_DT <= 2 THEN CNT ELSE 0 END MOFF_48" ).append("\n"); 
		query.append("                                 FROM (SELECT /*+ INDEX ( A XAK1CTM_MOVEMENT)*/ ORG_YD_CD" ).append("\n"); 
		query.append("                                            --, (CRE_LOCL_DT - CNMV_EVNT_DT) OFFSET_DT, MVMT_INP_TP_CD" ).append("\n"); 
		query.append("                                            , CEIL((CRE_LOCL_DT - CNMV_EVNT_DT)*10)/10 OFFSET_DT, MVMT_INP_TP_CD" ).append("\n"); 
		query.append("                                            , COUNT(*) CNT" ).append("\n"); 
		query.append("                                         FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("                                        #if (${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                                        WHERE SYS_AREA_GRP_ID = (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID WHERE CNT_CD = SUBSTR(@[rcc_cd],0,2) AND SUBSTR(SYS_AREA_GRP_ID,0,1) != 'D')" ).append("\n"); 
		query.append("                                        #else" ).append("\n"); 
		query.append("                                        WHERE SYS_AREA_GRP_ID IN ('USA', 'SWA', 'KOR', 'EUR', 'CHN' )" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                          AND CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                          AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                                          #if (${p_yard1} != '')" ).append("\n"); 
		query.append("                                            #if (${p_yard2} != '')" ).append("\n"); 
		query.append("                                          AND ORG_YD_CD = @[p_yard1] || @[p_yard2]" ).append("\n"); 
		query.append("                                            #else" ).append("\n"); 
		query.append("                                          AND ORG_YD_CD LIKE @[p_yard1] || '%'" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                          #end" ).append("\n"); 
		query.append("                                          AND MVMT_INP_TP_CD  IN ('EDI','SPP','MAN')" ).append("\n"); 
		query.append("                                          AND NVL(MVMT_CRE_TP_CD, 'XX') = 'XX'" ).append("\n"); 
		query.append("                                          #if (${sts_cd} != '')" ).append("\n"); 
		query.append("                                          AND MVMT_STS_CD IN (${sts_cd})" ).append("\n"); 
		query.append("                                          #end" ).append("\n"); 
		query.append("                                          #if (${fcntr_flg} != '')" ).append("\n"); 
		query.append("                                          AND FCNTR_FLG = @[fcntr_flg]" ).append("\n"); 
		query.append("                                          #end" ).append("\n"); 
		query.append("                                        GROUP BY ORG_YD_CD, MVMT_INP_TP_CD, CEIL((CRE_LOCL_DT - CNMV_EVNT_DT)*10)" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                              GROUP BY ORG_YD_CD" ).append("\n"); 
		query.append("                      ) CTM, MDM_LOCATION LOC, MDM_EQ_ORZ_CHT EQ" ).append("\n"); 
		query.append("                  WHERE  LOC.SCC_CD = EQ.SCC_CD" ).append("\n"); 
		query.append("                  AND  LOC.LOC_CD = SUBSTR(CTM.ORG_YD_CD, 0, 5)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            GROUP BY RCC_CD, LCC_CD, CNT_CD, LOC_CD, ORG_YD_CD" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  #if (${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("  AND A.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${lcc_cd} != '')" ).append("\n"); 
		query.append("  AND A.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${p_yard1} != '')" ).append("\n"); 
		query.append("    #if (${p_yard2} != '')" ).append("\n"); 
		query.append("  AND A.ORG_YD_CD = @[p_yard1] || @[p_yard2]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("  AND A.ORG_YD_CD LIKE @[p_yard1] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("#if (${data_by} == '1')" ).append("\n"); 
		query.append("        A.RCC_CD" ).append("\n"); 
		query.append("#elseif (${data_by} == '2')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD" ).append("\n"); 
		query.append("#elseif (${data_by} == '5')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD, A.CNT_CD" ).append("\n"); 
		query.append("#elseif (${data_by} == '3')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD, A.CNT_CD, A.LOC_CD" ).append("\n"); 
		query.append("#elseif (${data_by} == '4')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD, A.CNT_CD, A.LOC_CD, A.ORG_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#if (${data_by} == '1')" ).append("\n"); 
		query.append("        A.RCC_CD" ).append("\n"); 
		query.append("#elseif (${data_by} == '2')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD" ).append("\n"); 
		query.append("#elseif (${data_by} == '5')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD, A.CNT_CD" ).append("\n"); 
		query.append("#elseif (${data_by} == '3')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD, A.CNT_CD, A.LOC_CD" ).append("\n"); 
		query.append("#elseif (${data_by} == '4')" ).append("\n"); 
		query.append("        A.RCC_CD, A.LCC_CD, A.CNT_CD, A.LOC_CD, A.ORG_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}