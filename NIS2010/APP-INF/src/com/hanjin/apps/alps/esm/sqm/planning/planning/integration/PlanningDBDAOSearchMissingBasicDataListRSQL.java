/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOSearchMissingBasicDataListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOSearchMissingBasicDataListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Creation, Freezing, Add-Creation, Add-Freezing 시 Basic data 중 누락된것 조회합니다.
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * -노선별로 어느 PF Group이건 하나의 PF Group에 값이 들어가 있으면 다른 PF Group에 값이 없는 것은 상관없이 데이터 생성되도록 로직 수정 요청
	  * -LANE OFFICE의 ACTIVE여부를 비교하는 부분 추가
	  * </pre>
	  */
	public PlanningDBDAOSearchMissingBasicDataListRSQL(){
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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchMissingBasicDataListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT DECODE(OFC_VW_CD, 'C', 'Contract', 'L', 'Loading') || '-' || RLANE_CD || '-' || DIR_CD AS MSG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT D1.* FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               C1.BSE_TP_CD " ).append("\n"); 
		query.append("              ,C1.BSE_YR    " ).append("\n"); 
		query.append("              ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("              ,C1.OFC_VW_CD " ).append("\n"); 
		query.append("              ,C1.TRD_CD    " ).append("\n"); 
		query.append("              ,C1.RLANE_CD  " ).append("\n"); 
		query.append("              ,C1.DIR_CD " ).append("\n"); 
		query.append("              --,C1.PF_GRP_CD" ).append("\n"); 
		query.append("              ,SUM(NVL2(C2.TRD_CD,1,0)) CNT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                -- PF SKD에 GROUP이 몇개 있는지 " ).append("\n"); 
		query.append("                SELECT DISTINCT " ).append("\n"); 
		query.append("                       B1.*" ).append("\n"); 
		query.append("                      ,B2.PF_GRP_CD" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        --LANE MASTER 정의" ).append("\n"); 
		query.append("                        SELECT DISTINCT " ).append("\n"); 
		query.append("                               A2.BSE_TP_CD " ).append("\n"); 
		query.append("                              ,A2.BSE_YR " ).append("\n"); 
		query.append("                              ,A2.BSE_QTR_CD " ).append("\n"); 
		query.append("                              ,A2.OFC_VW_CD" ).append("\n"); 
		query.append("                              ,A1.TRD_CD" ).append("\n"); 
		query.append("                              ,A1.RLANE_CD" ).append("\n"); 
		query.append("                              ,NVL(A1.LANE_DIR_CD, A2.CONV_DIR_CD) DIR_CD" ).append("\n"); 
		query.append("                          FROM SQM_QTA_LANE_MGMT A1" ).append("\n"); 
		query.append("                              ,SQM_DAT_RLT A2" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                          AND A2.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                          AND A2.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("                          AND A2.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                          AND A2.TRD_CD      = 'IAS'" ).append("\n"); 
		query.append("                          AND A2.TRD_CD      = A1.TRD_CD" ).append("\n"); 
		query.append("                          AND A2.CONV_DIR_CD = NVL(A1.LANE_DIR_CD, A2.CONV_DIR_CD)" ).append("\n"); 
		query.append("                          AND A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("                          AND A1.IAS_SCTR_FLG IS NOT NULL" ).append("\n"); 
		query.append("                          --ADD CREATION, ADD FREEZING시에만 LANE 조건" ).append("\n"); 
		query.append("#if (${add_flg} == 'Y')" ).append("\n"); 
		query.append("                          AND A1.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ) B1" ).append("\n"); 
		query.append("                      ,SQM_SCTR_PF_GRP B2" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND B1.BSE_TP_CD  = B2.BSE_TP_CD" ).append("\n"); 
		query.append("                    AND B1.BSE_YR     = B2.BSE_YR" ).append("\n"); 
		query.append("                    AND B1.BSE_QTR_CD = B2.BSE_QTR_CD" ).append("\n"); 
		query.append("                    AND B1.TRD_CD     = B2.TRD_CD" ).append("\n"); 
		query.append("                    AND B1.RLANE_CD   = B2.RLANE_CD       " ).append("\n"); 
		query.append("               ) C1" ).append("\n"); 
		query.append("              ,SQM_SCTR_LANE_OFC C2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND C1.BSE_TP_CD  = C2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("           AND C1.BSE_YR     = C2.BSE_YR(+)" ).append("\n"); 
		query.append("           AND C1.BSE_QTR_CD = C2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("           AND C1.OFC_VW_CD  = C2.OFC_VW_CD(+)" ).append("\n"); 
		query.append("           AND C1.TRD_CD     = C2.TRD_CD(+)" ).append("\n"); 
		query.append("           AND C1.RLANE_CD   = C2.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND C1.DIR_CD     = C2.DIR_CD(+)" ).append("\n"); 
		query.append("           --AND C1.PF_GRP_CD  = C2.PF_GRP_CD(+)" ).append("\n"); 
		query.append("           --FREEZING, ADD FREEZING 시에만" ).append("\n"); 
		query.append("#if (${freezing_flg} == 'Y')" ).append("\n"); 
		query.append("           AND C2.SQM_ACT_FLG(+) = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY C1.BSE_TP_CD " ).append("\n"); 
		query.append("              ,C1.BSE_YR    " ).append("\n"); 
		query.append("              ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("              ,C1.OFC_VW_CD" ).append("\n"); 
		query.append("              ,C1.TRD_CD    " ).append("\n"); 
		query.append("              ,C1.RLANE_CD  " ).append("\n"); 
		query.append("              ,C1.DIR_CD " ).append("\n"); 
		query.append("              ,C1.PF_GRP_CD" ).append("\n"); 
		query.append("        ORDER BY C1.OFC_VW_CD" ).append("\n"); 
		query.append("              ,C1.TRD_CD    " ).append("\n"); 
		query.append("              ,C1.RLANE_CD  " ).append("\n"); 
		query.append("              ,C1.DIR_CD " ).append("\n"); 
		query.append("              ,C1.PF_GRP_CD" ).append("\n"); 
		query.append("        ) D1," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT DISTINCT BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, DIR_CD FROM SQM_QTA_LANE_OFC" ).append("\n"); 
		query.append("            WHERE BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("            AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("            --AND OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("            AND TRD_CD = 'IAS'" ).append("\n"); 
		query.append("            --AND RLANE_CD = 'CMNAE'" ).append("\n"); 
		query.append("            --AND DIR_CD = 'E'" ).append("\n"); 
		query.append("            AND SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("        ) D2" ).append("\n"); 
		query.append("WHERE D1.CNT = 0" ).append("\n"); 
		query.append("AND D1.BSE_TP_CD  = D2.BSE_TP_CD" ).append("\n"); 
		query.append("AND D1.BSE_YR  = D2.BSE_YR" ).append("\n"); 
		query.append("AND D1.BSE_QTR_CD  = D2.BSE_QTR_CD" ).append("\n"); 
		query.append("AND D1.OFC_VW_CD  = D2.OFC_VW_CD" ).append("\n"); 
		query.append("AND D1.TRD_CD  = D2.TRD_CD" ).append("\n"); 
		query.append("AND D1.RLANE_CD  = D2.RLANE_CD" ).append("\n"); 
		query.append("AND D1.DIR_CD  = D2.DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY MSG" ).append("\n"); 

	}
}