/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusManageDBDAOCreateCfmTgtVvdCSQL.java
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

public class StatusManageDBDAOCreateCfmTgtVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Freezing 시 Confirm TGT VVVD 생성
	  * IAS Sector Sales 관련 TARGET VVD 제외로직 추가
	  * </pre>
	  */
	public StatusManageDBDAOCreateCfmTgtVvdCSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOCreateCfmTgtVvdCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_CFM_TGT_VVD (" ).append("\n"); 
		query.append("       QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,QTA_TGT_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,BSE_MON" ).append("\n"); 
		query.append("      ,BSE_WK" ).append("\n"); 
		query.append("      ,CONV_DIR_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,IOC_CD" ).append("\n"); 
		query.append("      ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,LOD_QTY" ).append("\n"); 
		query.append("      ,GRS_REV" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SUBSTR(@[f_bse_yr], 3, 2) || A1.BSE_QTR_CD || DECODE(CPY_NO, 0, '01', '02') AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.BSE_MON" ).append("\n"); 
		query.append("      ,A1.BSE_WK" ).append("\n"); 
		query.append("      ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,NVL(DECODE(A1.SUB_TRD_CD, 'IP', 0, A1.FNL_BSA_CAPA), 0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,ROUND(A2.FNL_BSA_CAPA * A2.LDF_RTO / 100, 0) AS LOD_QTY" ).append("\n"); 
		query.append("      ,NVL(A2.GRS_RPB_REV * ROUND(A2.FNL_BSA_CAPA * A2.LDF_RTO / 100, 0), 0) AS GRS_REV" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_QTA_TGT_VVD A1" ).append("\n"); 
		query.append("      ,CSQ_QTA_LOD_REV A2" ).append("\n"); 
		query.append("      ,COM_CPY_NO      A3" ).append("\n"); 
		query.append("      ,CSQ_QTA_LANE_MGMT A4" ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD     = A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  = A4.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = A4.BSE_YR " ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = A4.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A4.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = NVL(A4.LANE_DIR_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("   AND A4.IAS_SCTR_FLG = 'N'" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.RLANE_CD  <> 'RBCCO'" ).append("\n"); 
		query.append("   AND A1.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("   AND A3.CPY_NO     < 2" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT SUBSTR(@[f_bse_yr], 3, 2) || A1.BSE_QTR_CD || DECODE(CPY_NO, 0, '01', '02') AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.BSE_MON" ).append("\n"); 
		query.append("      ,A1.BSE_WK" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,NVL(A1.FNL_BSA_CAPA, 0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,0 AS LOD_QTY" ).append("\n"); 
		query.append("      ,0 AS GRS_REV" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_QTA_TGT_VVD A1" ).append("\n"); 
		query.append("      ,COM_CPY_NO      A2" ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = 'RBCCO'" ).append("\n"); 
		query.append("   AND A1.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("   AND A2.CPY_NO     < 2" ).append("\n"); 

	}
}