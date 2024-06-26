/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpclPlanningDBDAOCreateBasicCmcbCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpclPlanningDBDAOCreateBasicCmcbCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpclPlanningDBDAOCreateBasicCmcb
	  * </pre>
	  */
	public SpclPlanningDBDAOCreateBasicCmcbCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration").append("\n"); 
		query.append("FileName : SpclPlanningDBDAOCreateBasicCmcbCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SPCL_LANE_OFC_COST (" ).append("\n"); 
		query.append("             BSE_TP_CD" ).append("\n"); 
		query.append("            ,BSE_YR" ).append("\n"); 
		query.append("            ,BSE_QTR_CD" ).append("\n"); 
		query.append("            ,SPCL_TGT_CD" ).append("\n"); 
		query.append("            ,TRD_CD" ).append("\n"); 
		query.append("            ,RLANE_CD" ).append("\n"); 
		query.append("            ,DIR_CD" ).append("\n"); 
		query.append("            ,RGN_OFC_CD" ).append("\n"); 
		query.append("            ,RHQ_CD" ).append("\n"); 
		query.append("            ,CONV_DIR_CD" ).append("\n"); 
		query.append("            ,GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("            ,GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("            ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("            ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("            ,LOD_POTN_RTO" ).append("\n"); 
		query.append("            ,REV_POTN_RTO" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT B2.BSE_TP_CD" ).append("\n"); 
		query.append("      ,B2.BSE_YR" ).append("\n"); 
		query.append("      ,B2.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,@[f_spcl_tgt_cd] AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,B2.TRD_CD" ).append("\n"); 
		query.append("      ,B2.RLANE_CD" ).append("\n"); 
		query.append("      ,B2.DIR_CD" ).append("\n"); 
		query.append("      ,B2.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,B2.RHQ_CD" ).append("\n"); 
		query.append("      ,B2.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,NVL(ROUND(B1.PA_CM_UC_AMT,0), 0) AS GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,NVL(ROUND(B1.RA_CM_UC_AMT,0), 0) AS GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,NVL(ROUND(B1.PA_CM_UC_AMT,0), 0) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,NVL(ROUND(B1.RA_CM_UC_AMT,0), 0) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,NVL(B1.LOD_POTN_RTO, 0) AS LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,NVL(B1.REV_POTN_RTO, 0) AS REV_POTN_RTO" ).append("\n"); 
		query.append("      ,@[usr_id]  AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE    AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id]  AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE    AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_PERF_IF B1" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("          SELECT DISTINCT" ).append("\n"); 
		query.append("                 A1.BSE_TP_CD" ).append("\n"); 
		query.append("                ,A1.BSE_YR" ).append("\n"); 
		query.append("                ,DECODE( A1.BSE_TP_CD, 'Y', A2.CPY_NO || 'Q', @[f_bse_qtr_cd]) AS BSE_QTR_CD" ).append("\n"); 
		query.append("                ,A1.TRD_CD" ).append("\n"); 
		query.append("                ,A1.RLANE_CD" ).append("\n"); 
		query.append("                ,NVL(A3.CONV_DIR_CD, A1.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("                ,A1.DIR_CD" ).append("\n"); 
		query.append("                ,A1.RHQ_CD" ).append("\n"); 
		query.append("                ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("           FROM SQM_PERF_IF A1" ).append("\n"); 
		query.append("               ,COM_CPY_NO A2" ).append("\n"); 
		query.append("               ,SQM_DIR_CONV A3" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND A1.BSE_TP_CD     = A3.BSE_TP_CD(+)" ).append("\n"); 
		query.append("             AND A1.BSE_YR        = A3.BSE_YR(+)" ).append("\n"); 
		query.append("             AND A1.TRD_CD        = A3.TRD_CD(+)" ).append("\n"); 
		query.append("             AND A1.RLANE_CD      = A3.RLANE_CD(+)" ).append("\n"); 
		query.append("             AND A1.DIR_CD        = A3.DIR_CD(+)" ).append("\n"); 
		query.append("             AND A1.BSE_TP_CD     = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("             AND A1.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("             AND A1.BSE_QTR_CD    = DECODE(A1.BSE_TP_CD, 'Y', A1.BSE_QTR_CD, @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("             AND A3.BSE_QTR_CD(+) = DECODE(A1.BSE_TP_CD, 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("             AND A1.QTA_TGT_CD    = @[f_spcl_tgt_cd]" ).append("\n"); 
		query.append("             AND A1.OFC_VW_CD     = 'C'" ).append("\n"); 
		query.append("             AND A1.SQM_LVL_CD    = '2'" ).append("\n"); 
		query.append("             AND A2.CPY_NO        BETWEEN '1' AND DECODE( A1.BSE_TP_CD, 'Y','4','1')" ).append("\n"); 
		query.append("       ) B2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND B2.BSE_TP_CD      = B1.BSE_TP_CD(+)" ).append("\n"); 
		query.append("   AND B2.BSE_YR         = B1.BSE_YR(+)" ).append("\n"); 
		query.append("   AND B2.BSE_QTR_CD     = B1.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("   AND B2.TRD_CD         = B1.TRD_CD(+)" ).append("\n"); 
		query.append("   AND B2.RLANE_CD       = B1.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND B2.DIR_CD         = B1.DIR_CD(+)" ).append("\n"); 
		query.append("   AND B2.RHQ_CD         = B1.RHQ_CD(+)" ).append("\n"); 
		query.append("   AND B2.RGN_OFC_CD     = B1.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("   AND B1.QTA_TGT_CD(+)  = @[f_spcl_tgt_cd]  -- S, R 필수" ).append("\n"); 
		query.append("   AND B1.OFC_VW_CD(+)   = 'C'" ).append("\n"); 
		query.append("   AND B1.SQM_LVL_CD(+)  = '2'" ).append("\n"); 
		query.append("  ORDER BY TRD_CD, RLANE_CD, DIR_CD, RHQ_CD, RGN_OFC_CD, BSE_QTR_CD" ).append("\n"); 

	}
}