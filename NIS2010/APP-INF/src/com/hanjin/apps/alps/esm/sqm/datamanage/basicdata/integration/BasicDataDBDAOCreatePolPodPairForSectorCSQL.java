/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOCreatePolPodPairForSectorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOCreatePolPodPairForSectorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pol Pod Pair 정보를 생성합니다.
	  * 
	  * * History
	  * * 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
	  * * 2015.11.10 김용습 [CHM-201538877] SQM POL-POD Management 상 Port 매치 로직 관련 CSR
	  * </pre>
	  */
	public BasicDataDBDAOCreatePolPodPairForSectorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCreatePolPodPairForSectorCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SCTR_PAIR_MGMT " ).append("\n"); 
		query.append("           (BSE_TP_CD," ).append("\n"); 
		query.append("            BSE_YR," ).append("\n"); 
		query.append("            BSE_QTR_CD," ).append("\n"); 
		query.append("            RLANE_CD," ).append("\n"); 
		query.append("            DIR_CD," ).append("\n"); 
		query.append("            PF_GRP_CD," ).append("\n"); 
		query.append("            POL_CD," ).append("\n"); 
		query.append("            POD_CD," ).append("\n"); 
		query.append("            TRD_CD," ).append("\n"); 
		query.append("            SUB_TRD_CD," ).append("\n"); 
		query.append("            POL_CALL_SEQ," ).append("\n"); 
		query.append("            POD_CALL_SEQ," ).append("\n"); 
		query.append("            SQM_ACT_FLG," ).append("\n"); 
		query.append("            SQM_MN_SCTR_FLG," ).append("\n"); 
		query.append("            ADD_FLG," ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("WITH SKD_DATA AS (" ).append("\n"); 
		query.append("                  SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("                        , RLANE_CD" ).append("\n"); 
		query.append("                        ,PF_SVC_TP_CD" ).append("\n"); 
		query.append("                        ,DENSE_RANK() OVER(PARTITION BY VSL_SLAN_CD, PF_SVC_TP_CD ORDER BY MAX_SEQ) AS DIR_SEQ" ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER(PARTITION BY VSL_SLAN_CD, PF_SVC_TP_CD, SKD_DIR_CD  ORDER BY PORT_ROTN_SEQ) AS PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                        ,PORT_CD" ).append("\n"); 
		query.append("                        ,SKD_DIR_CD" ).append("\n"); 
		query.append("                        ,TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                          SELECT NO" ).append("\n"); 
		query.append("                                ,VSL_SLAN_CD" ).append("\n"); 
		query.append("                                ,RLANE_CD" ).append("\n"); 
		query.append("                                ,PF_SVC_TP_CD" ).append("\n"); 
		query.append("                                ,PORT_CD" ).append("\n"); 
		query.append("                                ,SKD_DIR_CD" ).append("\n"); 
		query.append("                                -- 2번은 1번 이후로 SEQ가 부여된다." ).append("\n"); 
		query.append("                                ,DECODE(NO, 1, PORT_ROTN_SEQ, 2, MAX_SEQ + MAX(MAX_SEQ) OVER (PARTITION BY VSL_SLAN_CD, PF_SVC_TP_CD, SKD_DIR_CD))  PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                                ,TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                ,DECODE(NO, 1, PORT_ROTN_SEQ, 2, MAX_SEQ) SEQ" ).append("\n"); 
		query.append("                                ,MAX(MAX_SEQ) " ).append("\n"); 
		query.append("                                OVER (PARTITION BY VSL_SLAN_CD, PF_SVC_TP_CD, SKD_DIR_CD) MAX_SEQ" ).append("\n"); 
		query.append("                            FROM (" ).append("\n"); 
		query.append("                                  SELECT A3.NO" ).append("\n"); 
		query.append("                                        ,A2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                        ,A1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                                        ,A4.RLANE_CD" ).append("\n"); 
		query.append("                                        ,A2.PORT_CD" ).append("\n"); 
		query.append("                                        -- 2번은 DIRECTION을 바꿔준다" ).append("\n"); 
		query.append("                                        ,A2.SKD_DIR_CD ORD_DIR_CD" ).append("\n"); 
		query.append("                                        ,DECODE(A3.NO, 2, DECODE(A2.SKD_DIR_CD, 'E', 'W', 'E'), A2.SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("                                        ,A2.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                                        ,A2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                        -- 1번은 E/W의 MAX 순번을 구하고" ).append("\n"); 
		query.append("                                        -- 2번은 SLAN-DIR-TURN_PORT_IND기준의 SEQ를 구한다." ).append("\n"); 
		query.append("                                        ,DECODE(A3.NO, 1, MAX(A2.PORT_ROTN_SEQ) OVER (PARTITION BY A2.VSL_SLAN_CD, A1.PF_SVC_TP_CD, SKD_DIR_CD) " ).append("\n"); 
		query.append("                                                     , 2, ROW_NUMBER() OVER (PARTITION BY A3.NO, A2.VSL_SLAN_CD, A1.PF_SVC_TP_CD, SKD_DIR_CD, A2.TURN_PORT_IND_CD ORDER BY A1.PF_SVC_TP_CD, A2.PORT_ROTN_SEQ)" ).append("\n"); 
		query.append("                                               )MAX_SEQ" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("                                    FROM VSK_PF_SKD A1" ).append("\n"); 
		query.append("                                        ,VSK_PF_SKD_DTL A2" ).append("\n"); 
		query.append("#elseif(${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("                                    FROM VSK_BUD_PF_SKD A1" ).append("\n"); 
		query.append("                                        ,VSK_BUD_PF_SKD_DTL A2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                        ,(SELECT CPY_NO AS NO FROM COM_CPY_NO WHERE CPY_NO BETWEEN 1 AND 2) A3" ).append("\n"); 
		query.append("                                        ,(SELECT SUBSTR(RLANE_CD, 1,3) SLAN_CD,RLANE_CD ,MAX(PF_SVC_TP_CD) PF_SVC_TP_CD_MAX" ).append("\n"); 
		query.append("                                                                                  FROM SQM_SCTR_PF_GRP" ).append("\n"); 
		query.append("                                                                                  WHERE 1=1" ).append("\n"); 
		query.append("                                                                                  AND BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                                                  AND BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                                                  AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                                                                  GROUP BY SUB_TRD_CD,RLANE_CD,PF_GRP_CD) A4" ).append("\n"); 
		query.append("                                   WHERE 1=1" ).append("\n"); 
		query.append("                                     AND A1.VSL_SLAN_CD = A4.SLAN_CD" ).append("\n"); 
		query.append("                                     AND A1.PF_SVC_TP_CD = A4.PF_SVC_TP_CD_MAX" ).append("\n"); 
		query.append("                                     AND A1.VSL_SLAN_CD   = A2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                     AND A1.PF_SVC_TP_CD  = A2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                                   ORDER BY NO, PF_SVC_TP_CD, PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                           WHERE 1=1" ).append("\n"); 
		query.append("                             AND NOT (NO = 2 AND TURN_PORT_IND_CD IN ('N','F'))" ).append("\n"); 
		query.append("                           ORDER BY PF_SVC_TP_CD, PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                  ORDER BY VSL_SLAN_CD, PF_SVC_TP_CD, DIR_SEQ, PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       DISTINCT -- 동일 포트에 다른 야드를 들어가는 노선이 존재, 이것을 하나도 만들어주기 위해서" ).append("\n"); 
		query.append("       @[f_bse_tp_cd] BSE_TP_CD " ).append("\n"); 
		query.append("      ,@[f_bse_yr] BSE_YR" ).append("\n"); 
		query.append("      ,DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) BSE_QTR_CD" ).append("\n"); 
		query.append("      ,B1.RLANE_CD" ).append("\n"); 
		query.append("      ,B1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,B2.PF_GRP_CD" ).append("\n"); 
		query.append("      ,B1.POL_PORT" ).append("\n"); 
		query.append("      ,B1.POD_PORT" ).append("\n"); 
		query.append("      ,B1.TRD_CD" ).append("\n"); 
		query.append("      ,B2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,MIN(B1.POL_SEQ) OVER (PARTITION BY B1.RLANE_CD, B1.DIR_SEQ, B1.POL_PORT, B1.POD_PORT) POL_SEQ" ).append("\n"); 
		query.append("      ,MAX(B1.POD_SEQ) OVER (PARTITION BY B1.RLANE_CD, B1.DIR_SEQ, B1.POL_PORT, B1.POD_PORT) POD_SEQ" ).append("\n"); 
		query.append("      ,NVL((SELECT DISTINCT T.SQM_ACT_FLG" ).append("\n"); 
		query.append("      		FROM SQM_SCTR_PAIR_MGMT T" ).append("\n"); 
		query.append("     		WHERE T.BSE_YR||T.BSE_QTR_CD = (SELECT /*+ INDEX_DESC(SQM_SCTR_PAIR_MGMT XPKSQM_SCTR_PAIR_MGMT) */" ).append("\n"); 
		query.append("                                             BSE_YR || BSE_QTR_CD" ).append("\n"); 
		query.append("                                        	FROM SQM_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("                                       		WHERE BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("                                         	AND BSE_YR || BSE_QTR_CD < @[f_bse_yr] || DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                         	AND ROWNUM = 1 )" ).append("\n"); 
		query.append("       		AND T.RLANE_CD = B1.RLANE_CD" ).append("\n"); 
		query.append("       		AND T.DIR_CD   = B1.SKD_DIR_CD" ).append("\n"); 
		query.append("       		AND T.POL_CD   = B1.POL_PORT" ).append("\n"); 
		query.append("       		AND T.POD_CD   = B1.POD_PORT ), 'N') AS SQM_ACT_FLG" ).append("\n"); 
		query.append("      ,NVL((SELECT DISTINCT T.SQM_MN_SCTR_FLG" ).append("\n"); 
		query.append("      		FROM SQM_SCTR_PAIR_MGMT T" ).append("\n"); 
		query.append("     		WHERE T.BSE_YR||T.BSE_QTR_CD = (SELECT /*+ INDEX_DESC(SQM_SCTR_PAIR_MGMT XPKSQM_SCTR_PAIR_MGMT) */" ).append("\n"); 
		query.append("                                             BSE_YR || BSE_QTR_CD" ).append("\n"); 
		query.append("                                        	FROM SQM_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("                                       		WHERE BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("                                         	AND BSE_YR || BSE_QTR_CD < @[f_bse_yr] || DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                         	AND ROWNUM = 1 )" ).append("\n"); 
		query.append("       		AND T.RLANE_CD = B1.RLANE_CD" ).append("\n"); 
		query.append("       		AND T.DIR_CD   = B1.SKD_DIR_CD" ).append("\n"); 
		query.append("       		AND T.POL_CD   = B1.POL_PORT" ).append("\n"); 
		query.append("       		AND T.POD_CD   = B1.POD_PORT ), '') AS SQM_MN_SCTR_FLG" ).append("\n"); 
		query.append("      ,'N' ADD_FLG" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID    " ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT 'IAS' AS TRD_CD" ).append("\n"); 
		query.append("              ,POL.RLANE_CD" ).append("\n"); 
		query.append("              ,POL.PF_SVC_TP_CD" ).append("\n"); 
		query.append("              ,POL.DIR_SEQ" ).append("\n"); 
		query.append("              ,POL.PORT_CD POL_PORT" ).append("\n"); 
		query.append("              ,POD.PORT_CD POD_PORT" ).append("\n"); 
		query.append("              ,POL.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,POL.PORT_ROTN_SEQ AS POL_SEQ" ).append("\n"); 
		query.append("              ,POD.PORT_ROTN_SEQ AS POD_SEQ" ).append("\n"); 
		query.append("          FROM SKD_DATA POL" ).append("\n"); 
		query.append("              ,SKD_DATA POD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND POL.VSL_SLAN_CD   = POD.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND POL.PF_SVC_TP_CD  = POD.PF_SVC_TP_CD" ).append("\n"); 
		query.append("           AND POL.SKD_DIR_CD    = POD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND POL.PORT_ROTN_SEQ < POD.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("         ORDER BY POL.VSL_SLAN_CD, POL.PF_SVC_TP_CD, POL.DIR_SEQ, POL.PORT_ROTN_SEQ, POD.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("      ) B1 , SQM_SCTR_PF_GRP B2, SQM_QTA_LANE_MGMT B3" ).append("\n"); 
		query.append("      -- 동일 포트에 다른 야드를 들어가는 노선이 존재, 이것을 하나도 만들어주기 위해서" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND B1.RLANE_CD = B2.RLANE_CD" ).append("\n"); 
		query.append(" AND B1.PF_SVC_TP_CD = B2.PF_SVC_TP_CD" ).append("\n"); 
		query.append(" AND B2.BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append(" AND B2.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append(" AND B2.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append(" AND B2.SUB_TRD_CD = B3.SUB_TRD_CD" ).append("\n"); 
		query.append(" AND B1.RLANE_CD = B3.RLANE_CD" ).append("\n"); 
		query.append(" AND B1.SKD_DIR_CD = NVL(B3.LANE_DIR_CD, B1.SKD_DIR_CD)  " ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append(" AND B1.POL_PORT IN (SELECT VSK.PORT_CD FROM VSK_PF_SKD_DTL VSK" ).append("\n"); 
		query.append("                    WHERE VSK.VSL_SLAN_CD = SUBSTR(B1.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("                        AND VSK.PF_SVC_TP_CD = B1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                        AND VSK.SKD_DIR_CD = B1.SKD_DIR_CD)" ).append("\n"); 
		query.append("#elseif(${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append(" AND B1.POL_PORT IN (SELECT VSK.PORT_CD FROM VSK_BUD_PF_SKD_DTL VSK" ).append("\n"); 
		query.append("                    WHERE VSK.VSL_SLAN_CD = SUBSTR(B1.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("                        AND VSK.PF_SVC_TP_CD = B1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                        AND VSK.SKD_DIR_CD = B1.SKD_DIR_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY B1.RLANE_CD" ).append("\n"); 

	}
}