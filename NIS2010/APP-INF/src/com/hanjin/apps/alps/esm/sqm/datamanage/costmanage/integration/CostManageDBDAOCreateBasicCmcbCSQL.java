/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CostManageDBDAOCreateBasicCmcbCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOCreateBasicCmcbCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane-Office Relation Setting + Basic Data Creation 정보를 가지고 Basic CMCB Data 를 생성한다.
	  * [CHM-201328244] IAS Sector Sales 판매시스템 개발
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public CostManageDBDAOCreateBasicCmcbCSQL(){
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
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOCreateBasicCmcbCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_LANE_OFC_COST (" ).append("\n"); 
		query.append("         BSE_TP_CD" ).append("\n"); 
		query.append("        ,BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,ADD_FLG" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("        ,GID_PA_CM_XCLD_EQ_UC_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("        ,A1.BSE_YR" ).append("\n"); 
		query.append("        ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,NVL(A1.OFC_VW_CD, 'C') AS OFC_VW_CD" ).append("\n"); 
		query.append("        ,A1.TRD_CD" ).append("\n"); 
		query.append("        ,A1.RLANE_CD" ).append("\n"); 
		query.append("        ,A1.DIR_CD" ).append("\n"); 
		query.append("        ,NVL(A1.RGN_OFC_CD, 'XXXXXX') AS RGN_OFC_CD" ).append("\n"); 
		query.append("        ,NVL(A1.RHQ_CD    , 'XXXXX')  AS RHQ_CD" ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY, 0)), 0, 0, SUM(NVL(A2.PA_CM_UC_AMT, 0) * NVL(A2.LOD_QTY, 0)) / SUM(NVL(A2.LOD_QTY, 0))), 0) AS GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY, 0)), 0, 0, SUM(NVL(A2.RA_CM_UC_AMT, 0) * NVL(A2.LOD_QTY, 0)) / SUM(NVL(A2.LOD_QTY, 0))), 0) AS GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("--        ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY, 0)), 0, 0, SUM(NVL(A2.PA_CM_UC_AMT, 0) * NVL(A2.LOD_QTY, 0)) / SUM(NVL(A2.LOD_QTY, 0))), 0) AS PA_CM_UC_AMT " ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY, 0)), 0, 0, SUM(NVL(A2.PA_CM_XCLD_EQ_UC_AMT, 0) * NVL(A2.LOD_QTY, 0)) / SUM(NVL(A2.LOD_QTY, 0))), 0) AS PA_CM_UC_AMT -- DEFAULT를 EXCLUDE EQ COST로" ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY, 0)), 0, 0, SUM(NVL(A2.RA_CM_UC_AMT, 0) * NVL(A2.LOD_QTY, 0)) / SUM(NVL(A2.LOD_QTY, 0))), 0) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,'N'         AS ADD_FLG" ).append("\n"); 
		query.append("        ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("        ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(NVL(A2.LOD_QTY, 0)), 0, 0, SUM(NVL(A2.PA_CM_XCLD_EQ_UC_AMT, 0) * NVL(A2.LOD_QTY, 0)) / SUM(NVL(A2.LOD_QTY, 0))), 0) AS GID_PA_CM_XCLD_EQ_UC_AMT" ).append("\n"); 
		query.append("    FROM SQM_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("        ,SQM_PERF_IF      A2" ).append("\n"); 
		query.append("   WHERE A1.BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND A1.BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND A1.BSE_QTR_CD      = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND A2.QTA_TGT_CD  (+) = 'D'" ).append("\n"); 
		query.append("     AND A2.SQM_LVL_CD  (+) = '2'" ).append("\n"); 
		query.append("     AND A1.BSE_TP_CD       = A2.BSE_TP_CD  (+)" ).append("\n"); 
		query.append("     AND A1.BSE_YR          = A2.BSE_YR     (+)" ).append("\n"); 
		query.append("     AND A1.BSE_QTR_CD      = A2.BSE_QTR_CD (+)" ).append("\n"); 
		query.append("     AND A1.OFC_VW_CD       = A2.OFC_VW_CD  (+)" ).append("\n"); 
		query.append("     AND A1.TRD_CD          = A2.TRD_CD     (+)" ).append("\n"); 
		query.append("     AND A1.RLANE_CD        = A2.RLANE_CD   (+)" ).append("\n"); 
		query.append("     AND A1.DIR_CD          = A2.DIR_CD     (+)" ).append("\n"); 
		query.append("     AND A1.RHQ_CD          = A2.RHQ_CD     (+)" ).append("\n"); 
		query.append("     AND A1.RGN_OFC_CD      = A2.RGN_OFC_CD (+)" ).append("\n"); 
		query.append("     AND A1.RLANE_CD       <> 'RBCCO'" ).append("\n"); 
		query.append("     AND A1.ADD_FLG         = 'N'" ).append("\n"); 
		query.append("--     AND 1 = CASE WHEN A1.BSE_YR || A1.BSE_QTR_CD > '20142Q' " ).append("\n"); 
		query.append("--                       THEN (" ).append("\n"); 
		query.append("--                            SELECT DISTINCT 1" ).append("\n"); 
		query.append("--                              FROM SQM_QTA_LANE_MGMT S1" ).append("\n"); 
		query.append("--                             WHERE S1.TRD_CD   = A1.TRD_CD" ).append("\n"); 
		query.append("--                               AND S1.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("--                               AND S1.IAS_SCTR_FLG IS NULL" ).append("\n"); 
		query.append("--                            )" ).append("\n"); 
		query.append("--             ELSE 1" ).append("\n"); 
		query.append("--             END" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS (  (A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.TRD_CD, A1.RLANE_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("                         ,(A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.OFC_VW_CD, A1.TRD_CD, A1.RLANE_CD, A1.DIR_CD,A1.RGN_OFC_CD, A1.RHQ_CD)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 

	}
}