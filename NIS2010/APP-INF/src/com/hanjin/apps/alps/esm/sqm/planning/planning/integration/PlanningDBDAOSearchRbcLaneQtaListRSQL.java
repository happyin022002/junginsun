/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PlanningDBDAOSearchRbcLaneQtaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.23
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.08.23 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOSearchRbcLaneQtaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RBC Lane Qta list를 조회한다.
	  * </pre>
	  */
	public PlanningDBDAOSearchRbcLaneQtaListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchRbcLaneQtaListRSQL").append("\n"); 
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
		query.append("SELECT RBC.BSE_TP_CD" ).append("\n"); 
		query.append("      ,RBC.BSE_YR" ).append("\n"); 
		query.append("      ,RBC.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,DECODE(RBC.OFC_VW_CD, 'C', 'CONTRACT', 'LOADING') OFC_VW_CD" ).append("\n"); 
		query.append("      ,RBC.TRD_CD" ).append("\n"); 
		query.append("      ,RBC.RLANE_CD" ).append("\n"); 
		query.append("      ,RBC.DIR_CD" ).append("\n"); 
		query.append("      ,RBC.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,RBC.RHQ_CD" ).append("\n"); 
		query.append("      ,RBC.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RBC.GID_LOD_QTY" ).append("\n"); 
		query.append("      ,RBC.GID_GRS_REV" ).append("\n"); 
		query.append("      ,RBC.GID_PA_CM_AMT" ).append("\n"); 
		query.append("      ,RBC.GID_RA_CM_AMT" ).append("\n"); 
		query.append("      ,RBC.LOD_QTY" ).append("\n"); 
		query.append("      ,RBC.GRS_REV" ).append("\n"); 
		query.append("      ,RBC.PA_CM_AMT" ).append("\n"); 
		query.append("      ,RBC.RA_CM_AMT" ).append("\n"); 
		query.append(" FROM SQM_QTA_RBC RBC" ).append("\n"); 
		query.append("     ,SQM_QTA_LANE_OFC OFC" ).append("\n"); 
		query.append("WHERE RBC.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND RBC.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND RBC.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("  AND RBC.OFC_VW_CD    = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("  AND RBC.RHQ_CD       = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("  AND RBC.RGN_OFC_CD   = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND RBC.BSE_TP_CD    = OFC.BSE_TP_CD" ).append("\n"); 
		query.append("  AND RBC.BSE_YR       = OFC.BSE_YR" ).append("\n"); 
		query.append("  AND RBC.BSE_QTR_CD   = OFC.BSE_QTR_CD" ).append("\n"); 
		query.append("  AND RBC.OFC_VW_CD    = OFC.OFC_VW_CD" ).append("\n"); 
		query.append("  AND RBC.TRD_CD       = OFC.TRD_CD" ).append("\n"); 
		query.append("  AND RBC.RLANE_CD     = OFC.RLANE_CD" ).append("\n"); 
		query.append("  AND RBC.DIR_CD       = OFC.DIR_CD" ).append("\n"); 
		query.append("  AND RBC.RGN_OFC_CD   = OFC.RGN_OFC_CD" ).append("\n"); 
		query.append("  AND OFC.SQM_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("ORDER BY RBC.TRD_CD" ).append("\n"); 
		query.append("        ,RBC.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RBC.RLANE_CD" ).append("\n"); 
		query.append("        ,RBC.DIR_CD" ).append("\n"); 
		query.append("        ,RBC.RHQ_CD" ).append("\n"); 
		query.append("        ,RBC.RGN_OFC_CD" ).append("\n"); 

	}
}