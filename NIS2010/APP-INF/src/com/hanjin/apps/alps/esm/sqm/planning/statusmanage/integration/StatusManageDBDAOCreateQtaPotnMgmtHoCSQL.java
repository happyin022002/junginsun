/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : StatusManageDBDAOCreateQtaPotnMgmtHoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.07 
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

public class StatusManageDBDAOCreateQtaPotnMgmtHoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * "Basic Data Creation" & "Lane-Office Relation Setting"의 데이터를 이용하여 "QTA Set up by Head Office" 화면의 데이터를 생성
	  * [CHM-201328244] IAS Sector Sales 판매시스템 개발
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public StatusManageDBDAOCreateQtaPotnMgmtHoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_qta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOCreateQtaPotnMgmtHoCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_POTN_MGMT (" ).append("\n"); 
		query.append("       BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,QTA_STEP_CD" ).append("\n"); 
		query.append("      ,QTA_VER_NO" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,CONV_DIR_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,GID_LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,GID_REV_POTN_RTO" ).append("\n"); 
		query.append("      ,LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,REV_POTN_RTO" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,@[f_qta_step_cd] AS QTA_STEP_CD" ).append("\n"); 
		query.append("      ,SUBSTR(A4.TEAM_CD, -3) || A4.TEAM_CD || SUBSTR(A4.BSE_YR, -2)|| A4.BSE_QTR_CD || '01' AS QTA_VER_NO" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RHQ_CD AS RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,NVL(A3.CONV_DIR_CD, A1.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,NVL(A2.LOD_POTN_RTO, 0) AS GID_LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,NVL(A2.REV_POTN_RTO, 0) AS GID_REV_POTN_RTO" ).append("\n"); 
		query.append("      ,NVL(A2.LOD_POTN_RTO, 0) AS LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,NVL(A2.REV_POTN_RTO, 0) AS REV_POTN_RTO" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               S2.BSE_TP_CD" ).append("\n"); 
		query.append("              ,S2.BSE_YR" ).append("\n"); 
		query.append("              ,S2.BSE_QTR_CD" ).append("\n"); 
		query.append("              ,S2.OFC_VW_CD" ).append("\n"); 
		query.append("              ,S2.TRD_CD" ).append("\n"); 
		query.append("              ,S2.RLANE_CD" ).append("\n"); 
		query.append("              ,S2.DIR_CD" ).append("\n"); 
		query.append("              ,S2.RHQ_CD" ).append("\n"); 
		query.append("              ,S2.SUB_TRD_CD " ).append("\n"); 
		query.append("          FROM SQM_QTA_LANE_OFC S2" ).append("\n"); 
		query.append("         WHERE S2.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("           AND S2.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND S2.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("           AND S2.RLANE_CD   <> 'RBCCO'" ).append("\n"); 
		query.append("           AND S2.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("--           AND 1 = CASE WHEN S2.BSE_YR || S2.BSE_QTR_CD > '20142Q' " ).append("\n"); 
		query.append("--                             THEN (" ).append("\n"); 
		query.append("--                                  SELECT DISTINCT 1" ).append("\n"); 
		query.append("--                                    FROM SQM_QTA_LANE_MGMT S1" ).append("\n"); 
		query.append("--                                   WHERE S1.TRD_CD   = S2.TRD_CD" ).append("\n"); 
		query.append("--                                     AND S1.RLANE_CD = S2.RLANE_CD" ).append("\n"); 
		query.append("--                                     AND S1.IAS_SCTR_FLG IS NULL" ).append("\n"); 
		query.append("--                                  )" ).append("\n"); 
		query.append("--                   ELSE 1" ).append("\n"); 
		query.append("--                   END" ).append("\n"); 
		query.append("       ) A1" ).append("\n"); 
		query.append("      ,SQM_PERF_IF  A2" ).append("\n"); 
		query.append("      ,SQM_DIR_CONV A3" ).append("\n"); 
		query.append("      ,SQM_DAT_RLT  A4     " ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD      = A2.BSE_TP_CD  (+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR         = A2.BSE_YR     (+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD     = A2.BSE_QTR_CD (+)" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD      = A2.OFC_VW_CD  (+)" ).append("\n"); 
		query.append("   AND A1.TRD_CD         = A2.TRD_CD     (+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD         = A2.DIR_CD     (+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD       = A2.RLANE_CD   (+)" ).append("\n"); 
		query.append("   AND A1.RHQ_CD         = A2.RHQ_CD     (+)" ).append("\n"); 
		query.append("   AND A2.QTA_TGT_CD (+) = 'D'" ).append("\n"); 
		query.append("   AND A2.SQM_LVL_CD (+) = '1'" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD      = A3.BSE_TP_CD  (+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR         = A3.BSE_YR     (+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD     = A3.BSE_QTR_CD (+)" ).append("\n"); 
		query.append("   AND A1.TRD_CD         = A3.TRD_CD     (+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD       = A3.RLANE_CD   (+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD         = A3.DIR_CD     (+)" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD      = A4.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR         = A4.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD     = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD      = A4.OFC_VW_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD         = A4.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD       = DECODE(UPPER(A4.RLANE_CD), 'ALL', A1.RLANE_CD, A4.RLANE_CD)" ).append("\n"); 
		query.append("   AND NVL(A3.CONV_DIR_CD, A1.DIR_CD) = A4.CONV_DIR_CD" ).append("\n"); 
		query.append("   AND A1.RHQ_CD         = A4.RHQ_CD" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD      = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR         = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD     = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 

	}
}