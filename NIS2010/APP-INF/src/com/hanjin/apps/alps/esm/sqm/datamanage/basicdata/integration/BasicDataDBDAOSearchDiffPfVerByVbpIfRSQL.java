/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BasicDataDBDAOSearchDiffPfVerByVbpIfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10 
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

public class BasicDataDBDAOSearchDiffPfVerByVbpIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회합니다_VBP에서 조회
	  * </pre>
	  */
	public BasicDataDBDAOSearchDiffPfVerByVbpIfRSQL(){
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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchDiffPfVerByVbpIfRSQL").append("\n"); 
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
		query.append("SELECT A1.RLANE_CD||'-'||A1.PF_SKD_TP_CD AS DIFF_PF_VER" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               VBP.TRD_CD" ).append("\n"); 
		query.append("              ,VBP.RLANE_CD" ).append("\n"); 
		query.append("              ,VBP.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,VSK.PF_SKD_TP_CD" ).append("\n"); 
		query.append("          FROM SQM_QTA_TGT_VVD_IF VBP" ).append("\n"); 
		query.append("              ,SQM_QTA_LANE_MGMT LANE" ).append("\n"); 
		query.append("              ,VSK_BUD_VSL_SKD VSK" ).append("\n"); 
		query.append("              ,( SELECT TRD_CD" ).append("\n"); 
		query.append("                      ,RLANE_CD" ).append("\n"); 
		query.append("                      ,DIR_CD" ).append("\n"); 
		query.append("                      ,SUB_TRD_CD" ).append("\n"); 
		query.append("                      ,ROUND(SUM(LOD_QTY)/53,0) LOD_QTY" ).append("\n"); 
		query.append("                  FROM SQM_PERF_IF" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND BSE_TP_CD   = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("                   AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("                   AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                   AND SUB_TRD_CD  = 'IP'" ).append("\n"); 
		query.append("                   AND OFC_VW_CD   = 'C'" ).append("\n"); 
		query.append("                   AND SQM_LVL_CD  = '2'" ).append("\n"); 
		query.append("                   AND QTA_TGT_CD  = 'D'" ).append("\n"); 
		query.append("                 GROUP BY TRD_CD, RLANE_CD, DIR_CD,SUB_TRD_CD" ).append("\n"); 
		query.append("                )PFMC" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND VBP.TRD_CD      = LANE.TRD_CD" ).append("\n"); 
		query.append("           AND VBP.RLANE_CD    = LANE.RLANE_CD" ).append("\n"); 
		query.append("           AND VBP.SUB_TRD_CD  = LANE.SUB_TRD_CD" ).append("\n"); 
		query.append("           AND VBP.DIR_CD      = NVL(LANE.LANE_DIR_CD,VBP.DIR_CD)" ).append("\n"); 
		query.append("           AND VBP.TRD_CD      = PFMC.TRD_CD(+)" ).append("\n"); 
		query.append("           AND VBP.RLANE_CD    = PFMC.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND VBP.SUB_TRD_CD  = PFMC.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("           AND VBP.DIR_CD      = PFMC.DIR_CD (+)" ).append("\n"); 
		query.append("           AND VBP.VSL_CD      = VSK.VSL_CD" ).append("\n"); 
		query.append("           AND VBP.SKD_VOY_NO  = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VBP.DIR_CD      = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND SUBSTR(VBP.RLANE_CD,1,3) = VSK.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND VBP.DIR_CD      = PFMC.DIR_CD(+)" ).append("\n"); 
		query.append("           AND VBP.TRD_CD      = PFMC.TRD_CD(+)" ).append("\n"); 
		query.append("           AND VBP.RLANE_CD    = PFMC.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND VBP.SUB_TRD_CD  = PFMC.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("           AND VBP.BSE_TP_CD   = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("           AND VBP.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND VBP.BSE_MON     BETWEEN '01' AND '12'" ).append("\n"); 
		query.append("        #if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("           AND VBP.BSE_QTR_CD  = '00'" ).append("\n"); 
		query.append("           AND VBP.BSE_WK      BETWEEN '00' AND '53'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("           AND VBP.BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("           AND VBP.BSE_WK      BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           AND VBP.DELT_FLG    =  'N'" ).append("\n"); 
		query.append("           AND LANE.SQM_ACT_FLG=  'Y'" ).append("\n"); 
		query.append("           AND VBP.TRD_CD      = 'IAS'" ).append("\n"); 
		query.append("       ) A1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                       SELECT DISTINCT SUB_TRD_CD, RLANE_CD, PF_SVC_TP_CD" ).append("\n"); 
		query.append("                        FROM SQM_SCTR_PF_GRP" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND BSE_TP_CD  = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("                        AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                        AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                        ) A2" ).append("\n"); 
		query.append("                WHERE A2.SUB_TRD_CD||A2.RLANE_CD||A2.PF_SVC_TP_CD =  A1.SUB_TRD_CD||A1.RLANE_CD||A1.PF_SKD_TP_CD)" ).append("\n"); 
		query.append("ORDER BY RLANE_CD , PF_SKD_TP_CD" ).append("\n"); 

	}
}