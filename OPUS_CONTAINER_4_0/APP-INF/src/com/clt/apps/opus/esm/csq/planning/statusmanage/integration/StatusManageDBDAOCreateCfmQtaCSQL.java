/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusManageDBDAOCreateCfmQtaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.28 
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

public class StatusManageDBDAOCreateCfmQtaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Freezing 시 Confirm Qta 생성
	  * 
	  * *[CHM-201431754] 이혜민 simulation_v를 RHQ, Office 단으로 나눠서 관리
	  * </pre>
	  */
	public StatusManageDBDAOCreateCfmQtaCSQL(){
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
		query.append("FileName : StatusManageDBDAOCreateCfmQtaCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_CFM_QTA (" ).append("\n"); 
		query.append("       QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,QTA_TGT_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,AQ_CD" ).append("\n"); 
		query.append("      ,CONV_DIR_CD" ).append("\n"); 
		query.append("      ,LOD_QTY" ).append("\n"); 
		query.append("      ,GRS_RPB_REV" ).append("\n"); 
		query.append("      ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SUBSTR(@[f_bse_yr], 3, 2) || C1.BSE_QTR_CD || DECODE(C3.CPY_NO, 0, '01', '02') AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,C1.BSE_TP_CD " ).append("\n"); 
		query.append("      ,C1.BSE_YR" ).append("\n"); 
		query.append("      ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,C1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,C1.TRD_CD" ).append("\n"); 
		query.append("      ,C1.RLANE_CD" ).append("\n"); 
		query.append("      ,C1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,C1.VSL_CD" ).append("\n"); 
		query.append("      ,C1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,C1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,C1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("      ,'' AS AQ_CD" ).append("\n"); 
		query.append("      ,C1.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,C1.OFC_QTY" ).append("\n"); 
		query.append("      ,DECODE(C1.OFC_QTY, 0, 0, C1.OFC_REV / C1.OFC_QTY) AS OFC_RPB" ).append("\n"); 
		query.append("      ,NVL(C2.PA_CM_UC_AMT, 0) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,NVL(C2.RA_CM_UC_AMT, 0) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,'I' AS CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_SIMULATION_OFC_V  C1" ).append("\n"); 
		query.append("      ,CSQ_QTA_LANE_OFC_COST C2" ).append("\n"); 
		query.append("      ,COM_CPY_NO            C3" ).append("\n"); 
		query.append("WHERE C1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND C1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND C1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("  AND C1.BSE_TP_CD   = C2.BSE_TP_CD" ).append("\n"); 
		query.append("  AND C1.BSE_YR      = C2.BSE_YR" ).append("\n"); 
		query.append("  AND C1.BSE_QTR_CD  = C2.BSE_QTR_CD" ).append("\n"); 
		query.append("  AND C1.OFC_VW_CD   = C2.OFC_VW_CD" ).append("\n"); 
		query.append("  AND C1.TRD_CD      = C2.TRD_CD" ).append("\n"); 
		query.append("  AND C1.RLANE_CD    = C2.RLANE_CD" ).append("\n"); 
		query.append("  AND C1.SKD_DIR_CD  = C2.DIR_CD" ).append("\n"); 
		query.append("  AND C1.RGN_OFC_CD  = C2.RGN_OFC_CD" ).append("\n"); 
		query.append("  AND C3.CPY_NO      < 2" ).append("\n"); 

	}
}