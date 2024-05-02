/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOSearchMissingBasicDataListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
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
		query.append("SELECT DECODE(D1.OFC_VW_CD, 'C', 'Contract', 'L', 'Loading') || '-' || D1.RLANE_CD || '-' || D1.DIR_CD || 'B' || '-' || D1.PF_GRP_CD AS MSG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               C1.BSE_TP_CD " ).append("\n"); 
		query.append("              ,C1.BSE_YR    " ).append("\n"); 
		query.append("              ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("              ,C1.OFC_VW_CD " ).append("\n"); 
		query.append("              ,C1.TRD_CD    " ).append("\n"); 
		query.append("              ,C1.RLANE_CD  " ).append("\n"); 
		query.append("              ,C1.DIR_CD " ).append("\n"); 
		query.append("              ,C1.PF_GRP_CD" ).append("\n"); 
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
		query.append("                          FROM CSQ_QTA_LANE_MGMT A1" ).append("\n"); 
		query.append("                              ,CSQ_DAT_RLT A2" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                          AND A2.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                          AND A2.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("                          AND A2.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                          AND A2.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("   						  AND A1.BSE_TP_CD   = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   						  AND A1.BSE_YR      = A2.BSE_YR " ).append("\n"); 
		query.append("   						  AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("                          AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("                          AND A2.CONV_DIR_CD = NVL(A1.LANE_DIR_CD, A2.CONV_DIR_CD)" ).append("\n"); 
		query.append("                          AND A1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("                          AND A1.IAS_SCTR_FLG = 'Y'" ).append("\n"); 
		query.append("                          --ADD CREATION, ADD FREEZING시에만 LANE 조건" ).append("\n"); 
		query.append("#if (${add_flg} == 'Y')" ).append("\n"); 
		query.append("                          AND A1.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ) B1" ).append("\n"); 
		query.append("                      ,CSQ_SCTR_PF_GRP B2" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND B1.BSE_TP_CD  = B2.BSE_TP_CD" ).append("\n"); 
		query.append("                    AND B1.BSE_YR     = B2.BSE_YR" ).append("\n"); 
		query.append("                    AND B1.BSE_QTR_CD = B2.BSE_QTR_CD" ).append("\n"); 
		query.append("                    AND B1.TRD_CD     = B2.TRD_CD" ).append("\n"); 
		query.append("                    AND B1.RLANE_CD   = B2.RLANE_CD       " ).append("\n"); 
		query.append("               ) C1" ).append("\n"); 
		query.append("              ,CSQ_SCTR_LANE_OFC C2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND C1.BSE_TP_CD  = C2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("           AND C1.BSE_YR     = C2.BSE_YR(+)" ).append("\n"); 
		query.append("           AND C1.BSE_QTR_CD = C2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("           AND C1.OFC_VW_CD  = C2.OFC_VW_CD(+)" ).append("\n"); 
		query.append("           AND C1.TRD_CD     = C2.TRD_CD(+)" ).append("\n"); 
		query.append("           AND C1.RLANE_CD   = C2.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND C1.DIR_CD     = C2.DIR_CD(+)" ).append("\n"); 
		query.append("           AND C1.PF_GRP_CD  = C2.PF_GRP_CD(+)" ).append("\n"); 
		query.append("           --FREEZING, ADD FREEZING 시에만" ).append("\n"); 
		query.append("#if (${freezing_flg} == 'Y')" ).append("\n"); 
		query.append("           AND C2.CSQ_ACT_FLG(+) = 'Y'" ).append("\n"); 
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
		query.append("        ) D1" ).append("\n"); 
		query.append("WHERE D1.CNT = 0" ).append("\n"); 

	}
}