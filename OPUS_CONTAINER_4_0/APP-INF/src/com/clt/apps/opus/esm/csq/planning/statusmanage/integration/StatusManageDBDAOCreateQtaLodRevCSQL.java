/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusManageDBDAOCreateQtaLodRevCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOCreateQtaLodRevCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * "Basic Data Relation Setting" & "Target VVD Fix" 의 데이터를 이용하여 "QTA Set up by Head Office_L_F & G.RPB"의 기초 데이터를 생성
	  * [CHM-201328244] IAS Sector Sales 판매시스템 개발
	  * </pre>
	  */
	public StatusManageDBDAOCreateQtaLodRevCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_qta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOCreateQtaLodRevCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_QTA_LOD_REV (" ).append("\n"); 
		query.append("       BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,QTA_STEP_CD" ).append("\n"); 
		query.append("      ,QTA_VER_NO" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,CONV_DIR_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,LDF_RTO" ).append("\n"); 
		query.append("      ,GRS_RPB_REV" ).append("\n"); 
		query.append("      ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,'C' AS OFC_VW_CD" ).append("\n"); 
		query.append("      ,@[f_qta_step_cd] AS QTA_STEP_CD" ).append("\n"); 
		query.append("      ,A4.QTA_VER_NO" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,NVL(A2.CONV_DIR_CD, A1.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,NVL(A1.FNL_BSA_CAPA, 0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,0 AS LDF_RTO" ).append("\n"); 
		query.append("      ,0 AS GRS_RPB_REV" ).append("\n"); 
		query.append("      ,NVL(A3.PA_CM_UC_AMT, 0) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,NVL(A3.RA_CM_UC_AMT, 0) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_QTA_TGT_VVD       A1" ).append("\n"); 
		query.append("      ,CSQ_DIR_CONV          A2" ).append("\n"); 
		query.append("      ,CSQ_QTA_LANE_OFC_COST A3" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT DISTINCT " ).append("\n"); 
		query.append("               BSE_TP_CD" ).append("\n"); 
		query.append("              ,BSE_YR" ).append("\n"); 
		query.append("              ,BSE_QTR_CD" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,CONV_DIR_CD" ).append("\n"); 
		query.append("              ,SUBSTR(TEAM_CD, -3) || DECODE(@[f_qta_step_cd], '01', TEAM_CD, RHQ_CD) || SUBSTR(BSE_YR, -2) || BSE_QTR_CD || '01' AS QTA_VER_NO" ).append("\n"); 
		query.append("          FROM CSQ_DAT_RLT" ).append("\n"); 
		query.append("         WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("           AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("       ) A4" ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD   = A2.BSE_TP_CD  (+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A2.BSE_YR     (+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD (+)" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = A2.TRD_CD     (+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A2.RLANE_CD   (+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = A2.DIR_CD     (+)" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = A3.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A3.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = A3.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A3.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = A3.DIR_CD" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = A4.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A4.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = A4.TRD_CD" ).append("\n"); 
		query.append("   AND NVL(A2.CONV_DIR_CD,A1.DIR_CD) = A4.CONV_DIR_CD" ).append("\n"); 
		query.append("   AND A3.RGN_OFC_CD  = 'XXXXXX'" ).append("\n"); 
		query.append("   AND A3.OFC_VW_CD   = 'C'" ).append("\n"); 
		query.append("   AND A1.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   <> 'RBCCO'" ).append("\n"); 
		query.append("   AND 1 = (" ).append("\n"); 
		query.append("             SELECT DISTINCT 1" ).append("\n"); 
		query.append("               FROM CSQ_QTA_LANE_MGMT S1" ).append("\n"); 
		query.append("              WHERE S1.TRD_CD     = A1.TRD_CD" ).append("\n"); 
		query.append("                AND S1.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("                AND S1.BSE_TP_CD  = A1.BSE_TP_CD" ).append("\n"); 
		query.append("                AND S1.BSE_YR     = A1.BSE_YR" ).append("\n"); 
		query.append("                AND S1.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND S1.IAS_SCTR_FLG = 'N'" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}