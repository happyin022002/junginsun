/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PlanningDBDAOCreateRbcLaneQtaSettingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.11
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.10.11 조정민
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

public class PlanningDBDAOCreateRbcLaneQtaSettingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RbcLaneQta list를 생성한다.
	  * </pre>
	  */
	public PlanningDBDAOCreateRbcLaneQtaSettingCSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOCreateRbcLaneQtaSettingCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_RBC (" ).append("\n"); 
		query.append("         BSE_TP_CD" ).append("\n"); 
		query.append("        ,BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,GID_LOD_QTY" ).append("\n"); 
		query.append("        ,GID_GRS_REV" ).append("\n"); 
		query.append("        ,GID_PA_CM_AMT" ).append("\n"); 
		query.append("        ,GID_RA_CM_AMT" ).append("\n"); 
		query.append("        ,LOD_QTY" ).append("\n"); 
		query.append("        ,GRS_REV" ).append("\n"); 
		query.append("        ,PA_CM_AMT" ).append("\n"); 
		query.append("        ,RA_CM_AMT" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT   " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT OFC.BSE_TP_CD " ).append("\n"); 
		query.append("      ,OFC.BSE_YR" ).append("\n"); 
		query.append("      ,OFC.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC.OFC_VW_CD" ).append("\n"); 
		query.append("      ,OFC.TRD_CD" ).append("\n"); 
		query.append("      ,OFC.RLANE_CD" ).append("\n"); 
		query.append("      ,OFC.DIR_CD" ).append("\n"); 
		query.append("      ,OFC.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,OFC.RHQ_CD" ).append("\n"); 
		query.append("      ,OFC.SUB_TRD_CD      " ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.LOD_QTY,0) / 53) " ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 53) " ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 53) - ROUND(NVL(PER.PA_CM_UC_AMT,0)*NVL(PER.LOD_QTY,0) / 53) " ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 53) - ROUND(NVL(PER.RA_CM_UC_AMT,0)*NVL(PER.LOD_QTY,0) / 53)  " ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.LOD_QTY,0) / 53) " ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 53) " ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 53) - ROUND(NVL(PER.PA_CM_UC_AMT,0)*NVL(PER.LOD_QTY,0) / 53) " ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 53) - ROUND(NVL(PER.RA_CM_UC_AMT,0)*NVL(PER.LOD_QTY,0) / 53)  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.LOD_QTY,0) / 13)" ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 13) " ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 13) - ROUND(NVL(PER.PA_CM_UC_AMT,0)*NVL(PER.LOD_QTY,0) / 13)" ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 13) - ROUND(NVL(PER.RA_CM_UC_AMT,0)*NVL(PER.LOD_QTY,0) / 13)" ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.LOD_QTY,0) / 13)" ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 13) " ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 13) - ROUND(NVL(PER.PA_CM_UC_AMT,0)*NVL(PER.LOD_QTY,0) / 13)" ).append("\n"); 
		query.append("      ,ROUND(NVL(PER.GRS_TTL_REV,0) / 13) - ROUND(NVL(PER.RA_CM_UC_AMT,0)*NVL(PER.LOD_QTY,0) / 13) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,@[usr_id]  CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE        CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id]  UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE        UPD_DT" ).append("\n"); 
		query.append(" FROM SQM_PERF_IF PER" ).append("\n"); 
		query.append("     ,SQM_QTA_LANE_OFC OFC" ).append("\n"); 
		query.append("WHERE OFC.BSE_TP_CD      = PER.BSE_TP_CD(+)" ).append("\n"); 
		query.append("  AND OFC.BSE_YR         = PER.BSE_YR(+)" ).append("\n"); 
		query.append("  AND OFC.BSE_QTR_CD     = PER.BSE_QTR_CD(+) " ).append("\n"); 
		query.append("  AND OFC.OFC_VW_CD      = PER.OFC_VW_CD(+) " ).append("\n"); 
		query.append("  AND OFC.TRD_CD         = PER.TRD_CD(+)" ).append("\n"); 
		query.append("  AND OFC.SUB_TRD_CD     = PER.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("  AND OFC.RLANE_CD       = PER.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND OFC.DIR_CD         = PER.DIR_CD(+) " ).append("\n"); 
		query.append("  AND OFC.RHQ_CD         = PER.RHQ_CD(+)" ).append("\n"); 
		query.append("  AND OFC.RGN_OFC_CD     = PER.RGN_OFC_CD(+) " ).append("\n"); 
		query.append("  AND OFC.BSE_TP_CD      = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND OFC.BSE_YR         = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND OFC.BSE_QTR_CD     = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd]) " ).append("\n"); 
		query.append("  AND OFC.RLANE_CD       = 'RBCCO'" ).append("\n"); 
		query.append("  AND PER.QTA_TGT_CD(+)  = 'D'" ).append("\n"); 
		query.append("  AND PER.SQM_LVL_CD(+)  = 2" ).append("\n"); 

	}
}