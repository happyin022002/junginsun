/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * port 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sect_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimPortRSQL").append("\n"); 
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
		query.append("SELECT B1.SLAN_CD " ).append("\n"); 
		query.append("               ,B2.SECT_NO " ).append("\n"); 
		query.append("               ,B2.TRD_CD " ).append("\n"); 
		query.append("               ,B2.RLANE_CD " ).append("\n"); 
		query.append("               ,B1.SKD_DIR_CD " ).append("\n"); 
		query.append("               ,B1.TML_CD " ).append("\n"); 
		query.append("               ,B1.SEQ " ).append("\n"); 
		query.append("               ,B1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("               ,B2.FM_CNT " ).append("\n"); 
		query.append("               ,B2.TO_CNT " ).append("\n"); 
		query.append("               ,ROW_NUMBER() OVER (PARTITION BY B1.SECT_NO ORDER BY B1.SECT_NO,B1.SEQ ) NUM" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                        SELECT @[f_slan_cd] SLAN_CD " ).append("\n"); 
		query.append("                              ,TML_CD " ).append("\n"); 
		query.append("                              ,B1.SKD_DIR_CD " ).append("\n"); 
		query.append("                              ,B1.SECT_NO " ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER (ORDER BY B1.SECT_NO,B1.PORT_SEQ) SEQ " ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER (PARTITION BY B1.SECT_NO ORDER BY B1.PORT_SEQ) PORT_SEQ " ).append("\n"); 
		query.append("                              ,B1.PORT_DYS " ).append("\n"); 
		query.append("                              ,B1.SEA_DYS " ).append("\n"); 
		query.append("                              ,B1.IOC_CD " ).append("\n"); 
		query.append("                              ,B1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("                              ,B1.CONTI_CD FM_CONTI_CD " ).append("\n"); 
		query.append("                              ,NVL(LEAD(B1.CONTI_CD) OVER(PARTITION BY B1.SKD_DIR_CD ORDER BY B1.SECT_NO,B1.PORT_SEQ),' ') TO_CONTI_CD " ).append("\n"); 
		query.append("                              ,COUNT(DISTINCT B1.CONTI_CD) OVER() PNDLM_CNT " ).append("\n"); 
		query.append("                          FROM ( " ).append("\n"); 
		query.append("                                 SELECT /*+ LEADING(A1 A2 A4 A3) USE_NL(A1 A2) USE_HASH(A2) */" ).append("\n"); 
		query.append("                                        DISTINCT " ).append("\n"); 
		query.append("                                        DECODE(A3.NUM, 1, SUBSTR(A1.TML_CD,1,5) " ).append("\n"); 
		query.append("                                                     , 2, SUBSTR(A1.TML_CD,1,5) " ).append("\n"); 
		query.append("                                               ) TML_CD " ).append("\n"); 
		query.append("                                       ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', DECODE(A1.SKD_DIR_CD,'E','W','E') , A1.SKD_DIR_CD) " ).append("\n"); 
		query.append("                                                     , 2, A1.SKD_DIR_CD " ).append("\n"); 
		query.append("                                               ) SKD_DIR_CD " ).append("\n"); 
		query.append("                                       ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', A1.PORT_SEQ+MAX(A1.PORT_SEQ)OVER(), A1.PORT_SEQ) " ).append("\n"); 
		query.append("                                                     , 2, A1.PORT_SEQ " ).append("\n"); 
		query.append("                                               ) PORT_SEQ " ).append("\n"); 
		query.append("                                       ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', A4.OTR_SECT, A4.SECT_NO) " ).append("\n"); 
		query.append("                                                     , 2, A4.SECT_NO " ).append("\n"); 
		query.append("                                               ) SECT_NO " ).append("\n"); 
		query.append("                                       ,A1.PORT_DYS " ).append("\n"); 
		query.append("                                       ,A1.SEA_DYS " ).append("\n"); 
		query.append("                                       ,A4.IOC_CD " ).append("\n"); 
		query.append("                                       ,A1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("                                       ,DECODE(@[f_slan_cd],'INX',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD)  " ).append("\n"); 
		query.append("                                                    ,'RES',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD) " ).append("\n"); 
		query.append("                                                    ,DECODE(A2.CONTI_CD,'F','E',A2.CONTI_CD) " ).append("\n"); 
		query.append("                                               ) CONTI_CD " ).append("\n"); 
		query.append("                                   FROM COA_SIM_TML_INFO A1 " ).append("\n"); 
		query.append("                                       ,( " ).append("\n"); 
		query.append("                                         SELECT SECT_NO " ).append("\n"); 
		query.append("                                               ,NVL(LEAD(SECT_NO) OVER(ORDER BY SECT_NO) -- NEXT ROW의 SECTION NUMBER 조회 " ).append("\n"); 
		query.append("                                                   ,LAG(SECT_NO,1,0) OVER(ORDER BY SECT_NO) -- PREVIOUS ROW의 SECTION NUMBER 조회 " ).append("\n"); 
		query.append("                                                   ) OTR_SECT -- E/B, W/B 각각 서로의 SECTION NUMBER 정보를 조회 " ).append("\n"); 
		query.append("                                               ,SKD_DIR_CD " ).append("\n"); 
		query.append("                                               ,IOC_CD " ).append("\n"); 
		query.append("                                           FROM( -- E/B, W/B 의 SECTION NUMBER의 최소값을 구한다. " ).append("\n"); 
		query.append("                                                 SELECT MIN(SECT_NO) SECT_NO " ).append("\n"); 
		query.append("                                                       ,SKD_DIR_CD " ).append("\n"); 
		query.append("                                                       ,IOC_CD " ).append("\n"); 
		query.append("                                                   FROM COA_SIM_SVC_LANE " ).append("\n"); 
		query.append("                                                  WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("                                                    AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("                                                  GROUP BY SKD_DIR_CD,IOC_CD " ).append("\n"); 
		query.append("                                                ) " ).append("\n"); 
		query.append("                                         ) A4 " ).append("\n"); 
		query.append("                                       ,MDM_LOCATION A2 " ).append("\n"); 
		query.append("                                       ,(SELECT CPY_NO NUM FROM COM_CPY_NO WHERE CPY_NO BETWEEN 1 AND 2) A3 " ).append("\n"); 
		query.append("                                  WHERE 1=1 " ).append("\n"); 
		query.append("                                    AND A1.SKD_DIR_CD = A4.SKD_DIR_CD " ).append("\n"); 
		query.append("                                    AND substr(A1.TML_CD,1,5) = A2.LOC_CD " ).append("\n"); 
		query.append("                                    AND A1.VSL_DBL_CALL_SEQ = '1' " ).append("\n"); 
		query.append("                                    AND A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("                                    AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("                                 ) B1 " ).append("\n"); 
		query.append("                          ORDER BY B1.SECT_NO, B1.PORT_SEQ " ).append("\n"); 
		query.append("                       ) B1 " ).append("\n"); 
		query.append("               ,( -- TRAD, RLANE, BOUND 별 포트정보 " ).append("\n"); 
		query.append("                         SELECT DISTINCT " ).append("\n"); 
		query.append("                                A2.SECT_NO " ).append("\n"); 
		query.append("                               ,A2.TRD_CD " ).append("\n"); 
		query.append("                               ,A2.RLANE_CD " ).append("\n"); 
		query.append("                               ,A1.SKD_DIR_CD " ).append("\n"); 
		query.append("                               ,CASE WHEN A1.IOC_CD = 'O' THEN LAG(A1.SEQ+1,1,1) OVER(ORDER BY A1.SECT_NO, A1.SEQ) " ).append("\n"); 
		query.append("                                     WHEN A1.IOC_CD = 'I' THEN MIN(A1.SEQ) OVER(PARTITION BY  A1.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                END FM_CNT " ).append("\n"); 
		query.append("                               ,CASE WHEN A1.IOC_CD = 'O' THEN LEAD(A1.SEQ,1) OVER(ORDER BY A1.SECT_NO, A1.SEQ) " ).append("\n"); 
		query.append("                                     WHEN A1.IOC_CD = 'I' THEN MAX(A1.SEQ) OVER(PARTITION BY A1.SKD_DIR_CD) " ).append("\n"); 
		query.append("                               END TO_CNT " ).append("\n"); 
		query.append("                           FROM (" ).append("\n"); 
		query.append("                        SELECT @[f_slan_cd] SLAN_CD " ).append("\n"); 
		query.append("                              ,TML_CD " ).append("\n"); 
		query.append("                              ,B1.SKD_DIR_CD " ).append("\n"); 
		query.append("                              ,B1.SECT_NO " ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER (ORDER BY B1.SECT_NO,B1.PORT_SEQ) SEQ " ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER (PARTITION BY B1.SECT_NO ORDER BY B1.PORT_SEQ) PORT_SEQ " ).append("\n"); 
		query.append("                              ,B1.PORT_DYS " ).append("\n"); 
		query.append("                              ,B1.SEA_DYS " ).append("\n"); 
		query.append("                              ,B1.IOC_CD " ).append("\n"); 
		query.append("                              ,B1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("                              ,B1.CONTI_CD FM_CONTI_CD " ).append("\n"); 
		query.append("                              ,NVL(LEAD(B1.CONTI_CD) OVER(PARTITION BY B1.SKD_DIR_CD ORDER BY B1.SECT_NO,B1.PORT_SEQ),' ') TO_CONTI_CD " ).append("\n"); 
		query.append("                              ,COUNT(DISTINCT B1.CONTI_CD) OVER() PNDLM_CNT " ).append("\n"); 
		query.append("                          FROM ( " ).append("\n"); 
		query.append("                                 SELECT /*+ LEADING(A1 A2 A4 A3) USE_NL(A1 A2) USE_HASH(A2) */" ).append("\n"); 
		query.append("                                        DISTINCT " ).append("\n"); 
		query.append("                                        DECODE(A3.NUM, 1, SUBSTR(A1.TML_CD,1,5) " ).append("\n"); 
		query.append("                                                     , 2, SUBSTR(A1.TML_CD,1,5) " ).append("\n"); 
		query.append("                                               ) TML_CD " ).append("\n"); 
		query.append("                                       ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', DECODE(A1.SKD_DIR_CD,'E','W','E') , A1.SKD_DIR_CD) " ).append("\n"); 
		query.append("                                                     , 2, A1.SKD_DIR_CD " ).append("\n"); 
		query.append("                                               ) SKD_DIR_CD " ).append("\n"); 
		query.append("                                       ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', A1.PORT_SEQ+MAX(A1.PORT_SEQ)OVER(), A1.PORT_SEQ) " ).append("\n"); 
		query.append("                                                     , 2, A1.PORT_SEQ " ).append("\n"); 
		query.append("                                               ) PORT_SEQ " ).append("\n"); 
		query.append("                                       ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', A4.OTR_SECT, A4.SECT_NO) " ).append("\n"); 
		query.append("                                                     , 2, A4.SECT_NO " ).append("\n"); 
		query.append("                                               ) SECT_NO " ).append("\n"); 
		query.append("                                       ,A1.PORT_DYS " ).append("\n"); 
		query.append("                                       ,A1.SEA_DYS " ).append("\n"); 
		query.append("                                       ,A4.IOC_CD " ).append("\n"); 
		query.append("                                       ,A1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("                                       ,DECODE(@[f_slan_cd],'INX',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD)  " ).append("\n"); 
		query.append("                                                    ,'RES',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD) " ).append("\n"); 
		query.append("                                                    ,DECODE(A2.CONTI_CD,'F','E',A2.CONTI_CD) " ).append("\n"); 
		query.append("                                               ) CONTI_CD " ).append("\n"); 
		query.append("                                   FROM COA_SIM_TML_INFO A1 " ).append("\n"); 
		query.append("                                       ,( " ).append("\n"); 
		query.append("                                         SELECT SECT_NO " ).append("\n"); 
		query.append("                                               ,NVL(LEAD(SECT_NO) OVER(ORDER BY SECT_NO) -- NEXT ROW의 SECTION NUMBER 조회 " ).append("\n"); 
		query.append("                                                   ,LAG(SECT_NO,1,0) OVER(ORDER BY SECT_NO) -- PREVIOUS ROW의 SECTION NUMBER 조회 " ).append("\n"); 
		query.append("                                                   ) OTR_SECT -- E/B, W/B 각각 서로의 SECTION NUMBER 정보를 조회 " ).append("\n"); 
		query.append("                                               ,SKD_DIR_CD " ).append("\n"); 
		query.append("                                               ,IOC_CD " ).append("\n"); 
		query.append("                                           FROM( -- E/B, W/B 의 SECTION NUMBER의 최소값을 구한다. " ).append("\n"); 
		query.append("                                                 SELECT MIN(SECT_NO) SECT_NO " ).append("\n"); 
		query.append("                                                       ,SKD_DIR_CD " ).append("\n"); 
		query.append("                                                       ,IOC_CD " ).append("\n"); 
		query.append("                                                   FROM COA_SIM_SVC_LANE " ).append("\n"); 
		query.append("                                                  WHERE SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("                                                    AND SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("                                                  GROUP BY SKD_DIR_CD,IOC_CD " ).append("\n"); 
		query.append("                                                ) " ).append("\n"); 
		query.append("                                         ) A4 " ).append("\n"); 
		query.append("                                       ,MDM_LOCATION A2 " ).append("\n"); 
		query.append("                                       ,(SELECT CPY_NO NUM FROM COM_CPY_NO WHERE CPY_NO BETWEEN 1 AND 2) A3 " ).append("\n"); 
		query.append("                                  WHERE 1=1 " ).append("\n"); 
		query.append("                                    AND A1.SKD_DIR_CD = A4.SKD_DIR_CD " ).append("\n"); 
		query.append("                                    AND substr(A1.TML_CD,1,5) = A2.LOC_CD " ).append("\n"); 
		query.append("                                    AND A1.VSL_DBL_CALL_SEQ = '1' " ).append("\n"); 
		query.append("                                    AND A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("                                    AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("                                 ) B1 " ).append("\n"); 
		query.append("                          ORDER BY B1.SECT_NO, B1.PORT_SEQ " ).append("\n"); 
		query.append("                       ) A1 " ).append("\n"); 
		query.append("                               ,(" ).append("\n"); 
		query.append("                       SELECT DISTINCT " ).append("\n"); 
		query.append("                              A1.TRD_CD " ).append("\n"); 
		query.append("                             ,A1.RLANE_CD " ).append("\n"); 
		query.append("                             ,A1.VSL_SLAN_DIR_CD SKD_DIR_CD " ).append("\n"); 
		query.append("                             ,DECODE(@[f_slan_cd],'INX', DECODE(A1.FM_CONTI_CD,'F','A',A1.FM_CONTI_CD)  " ).append("\n"); 
		query.append("                                                 ,'RES', DECODE(A1.FM_CONTI_CD,'F','A',A1.FM_CONTI_CD) " ).append("\n"); 
		query.append("                                                 ,DECODE(A1.FM_CONTI_CD,'F','E',A1.FM_CONTI_CD) " ).append("\n"); 
		query.append("                                     ) FM_CONTI_CD " ).append("\n"); 
		query.append("                             ,DECODE(@[f_slan_cd],'INX', DECODE(A1.TO_CONTI_CD,'F','A',A1.TO_CONTI_CD)  " ).append("\n"); 
		query.append("                                                 ,'RES', DECODE(A1.TO_CONTI_CD,'F','A',A1.TO_CONTI_CD) " ).append("\n"); 
		query.append("                                                 ,DECODE(A1.TO_CONTI_CD,'F','E',A1.TO_CONTI_CD) " ).append("\n"); 
		query.append("                                     ) TO_CONTI_CD " ).append("\n"); 
		query.append("                             ,A2.SECT_NO " ).append("\n"); 
		query.append("                        FROM ( " ).append("\n"); 
		query.append("                              SELECT RLANE_CD, VSL_SLAN_DIR_CD, IOC_CD, FM_CONTI_CD, TO_CONTI_CD, TRD_CD, SUB_TRD_CD " ).append("\n"); 
		query.append("                                FROM MDM_DTL_REV_LANE " ).append("\n"); 
		query.append("                               WHERE DELT_FLG        = 'N' " ).append("\n"); 
		query.append("                               UNION ALL " ).append("\n"); 
		query.append("                              SELECT RLANE_CD, SKD_DIR_CD, IOC_CD, FM_CONTI_CD, TO_CONTI_CD, TRD_CD, SUB_TRD_CD " ).append("\n"); 
		query.append("                                FROM COA_SIM_DTL_REV_LANE " ).append("\n"); 
		query.append("                             ) A1 " ).append("\n"); 
		query.append("                             ,COA_SIM_SVC_LANE A2 " ).append("\n"); 
		query.append("                        WHERE 1=1 " ).append("\n"); 
		query.append("                          AND A1.TRD_CD          = A2.TRD_CD " ).append("\n"); 
		query.append("                          AND A1.RLANE_CD        = A2.RLANE_CD " ).append("\n"); 
		query.append("                          AND A1.VSL_SLAN_DIR_CD = A2.SKD_DIR_CD " ).append("\n"); 
		query.append("                          AND A1.IOC_CD          = A2.IOC_CD " ).append("\n"); 
		query.append("                          AND A2.SIM_DT          = @[f_sim_dt]" ).append("\n"); 
		query.append("                          AND A2.SIM_NO          = @[f_sim_no]" ).append("\n"); 
		query.append("                      ) A2 " ).append("\n"); 
		query.append("                          WHERE 1=1 " ).append("\n"); 
		query.append("                            AND A1.SKD_DIR_CD  = A2.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("                            AND A1.FM_CONTI_CD = A2.FM_CONTI_CD(+) " ).append("\n"); 
		query.append("                            AND A1.TO_CONTI_CD = A2.TO_CONTI_CD(+) " ).append("\n"); 
		query.append("                            AND ((A1.FM_CONTI_CD <> A1.TO_CONTI_CD AND A1.IOC_CD = 'O') " ).append("\n"); 
		query.append("                             OR  (A1.IOC_CD = 'I')) " ).append("\n"); 
		query.append("                        ) B2 " ).append("\n"); 
		query.append("          WHERE 1=1 " ).append("\n"); 
		query.append("            AND B1.SEQ      BETWEEN FM_CNT AND TO_CNT " ).append("\n"); 
		query.append("            AND B2.TRD_CD   IS NOT NULL " ).append("\n"); 
		query.append("            AND B2.SECT_NO  = NVL(@[f_sect_no],B2.SECT_NO) " ).append("\n"); 
		query.append("          ORDER BY B2.SECT_NO, B2.FM_CNT,B1.SEQ" ).append("\n"); 

	}
}