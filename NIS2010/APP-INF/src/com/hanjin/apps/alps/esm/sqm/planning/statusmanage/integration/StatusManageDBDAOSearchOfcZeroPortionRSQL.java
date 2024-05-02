/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusManageDBDAOSearchOfcZeroPortionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOSearchOfcZeroPortionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Establishing Status]을 [생성] 합니다.
	  *  RHQ에는 Portion을 부여했으나 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은경우 체크
	  * </pre>
	  */
	public StatusManageDBDAOSearchOfcZeroPortionRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOSearchOfcZeroPortionRSQL").append("\n"); 
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
		query.append("SELECT DECODE(B.OFC_VW_CD,'C','Contract','L','Loading')||'/'||B.TRD_CD||'/'||B.RLANE_CD||'/'||B.DIR_CD||'B/'||B.RHQ_CD AS OfcZeroPortion" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT A1.OFC_VW_CD" ).append("\n"); 
		query.append("                       ,A1.TRD_CD" ).append("\n"); 
		query.append("                       ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                       ,A1.RLANE_CD" ).append("\n"); 
		query.append("                       ,A1.DIR_CD" ).append("\n"); 
		query.append("                       ,A1.RHQ_CD" ).append("\n"); 
		query.append("        FROM SQM_QTA_POTN_MGMT A1, SQM_QTA_LANE_OFC A2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("        AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("        AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("        AND A1.QTA_STEP_CD  = '02'" ).append("\n"); 
		query.append("        AND A1.LOD_POTN_RTO <> 0 " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("        AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("        AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND A1.OFC_VW_CD    = A2.OFC_VW_CD" ).append("\n"); 
		query.append("        AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("        AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("        AND A1.DIR_CD       = A2.DIR_CD" ).append("\n"); 
		query.append("        AND A1.RHQ_CD       = A2.RHQ_CD" ).append("\n"); 
		query.append("        AND A2.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("     ) A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT DISTINCT A1.OFC_VW_CD" ).append("\n"); 
		query.append("                       ,A1.QTA_STEP_CD" ).append("\n"); 
		query.append("                       ,A1.TRD_CD" ).append("\n"); 
		query.append("                       ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                       ,A1.RLANE_CD" ).append("\n"); 
		query.append("                       ,A1.DIR_CD" ).append("\n"); 
		query.append("                       ,A1.RHQ_CD" ).append("\n"); 
		query.append("                       ,SUM(A1.LOD_POTN_RTO)" ).append("\n"); 
		query.append("        FROM SQM_QTA_POTN_MGMT A1, SQM_QTA_LANE_OFC A2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("        AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("        AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("        AND A1.QTA_STEP_CD <> '02'" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("        AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("        AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND A1.OFC_VW_CD    = A2.OFC_VW_CD" ).append("\n"); 
		query.append("        AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("        AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("        AND A1.DIR_CD       = A2.DIR_CD" ).append("\n"); 
		query.append("        AND A1.RHQ_CD       = A2.RHQ_CD" ).append("\n"); 
		query.append("        AND A1.RGN_OFC_CD   = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("        AND A2.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("        GROUP BY A1.OFC_VW_CD" ).append("\n"); 
		query.append("                ,A1.QTA_STEP_CD" ).append("\n"); 
		query.append("                ,A1.TRD_CD" ).append("\n"); 
		query.append("                ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                ,A1.RLANE_CD" ).append("\n"); 
		query.append("                ,A1.DIR_CD" ).append("\n"); 
		query.append("                ,A1.RHQ_CD" ).append("\n"); 
		query.append("        HAVING SUM(A1.LOD_POTN_RTO) = 0" ).append("\n"); 
		query.append("        ORDER BY A1.DIR_CD, A1.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("WHERE A.OFC_VW_CD   = B.OFC_VW_CD" ).append("\n"); 
		query.append("AND   A.TRD_CD      = B.TRD_CD" ).append("\n"); 
		query.append("AND   A.SUB_TRD_CD  = B.SUB_TRD_CD " ).append("\n"); 
		query.append("AND   A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("AND   A.DIR_CD      = B.DIR_CD" ).append("\n"); 
		query.append("AND   A.RHQ_CD      = B.RHQ_CD" ).append("\n"); 

	}
}