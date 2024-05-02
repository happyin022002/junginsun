/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatusManageDBDAOCreateCfmQtaRbccoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13 
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

public class StatusManageDBDAOCreateCfmQtaRbccoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Freezing 시 RBCCO Confirm Qta 생성
	  * </pre>
	  */
	public StatusManageDBDAOCreateCfmQtaRbccoCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOCreateCfmQtaRbccoCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_CFM_QTA (" ).append("\n"); 
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
		query.append("      ,SQM_CNG_TP_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SUBSTR(@[f_bse_yr], 3, 2) || A1.BSE_QTR_CD || DECODE(CPY_NO, 0, '01', '02') AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A2.OFC_VW_CD" ).append("\n"); 
		query.append("      ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A3.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A3.RHQ_CD" ).append("\n"); 
		query.append("      ,NVL(( SELECT V.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("           FROM SQM_ORGANIZATION_V V" ).append("\n"); 
		query.append("          WHERE V.OFC_CD   = A3.RGN_OFC_CD" ).append("\n"); 
		query.append("            AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        ),'') AS AQ_CD" ).append("\n"); 
		query.append("      ,A2.DIR_CD" ).append("\n"); 
		query.append("      ,NVL(A2.LOD_QTY, 0) AS LOD_QTY" ).append("\n"); 
		query.append("      ,DECODE(NVL(A2.LOD_QTY, 0), 0, 0, NVL(A2.GRS_REV, 0) / A2.LOD_QTY) AS GRS_REV" ).append("\n"); 
		query.append("      ,ROUND(DECODE(NVL(A2.LOD_QTY, 0), 0, 0, (NVL(A2.GRS_REV, 0) - NVL(A2.PA_CM_AMT, 0)) / A2.LOD_QTY)) AS PA_CM_AMT" ).append("\n"); 
		query.append("      ,ROUND(DECODE(NVL(A2.LOD_QTY, 0), 0, 0, (NVL(A2.GRS_REV, 0) - NVL(A2.RA_CM_AMT, 0)) / A2.LOD_QTY)) AS RA_CM_AMT" ).append("\n"); 
		query.append("      ,'I' AS SQM_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_QTA_TGT_VVD  A1" ).append("\n"); 
		query.append("      ,SQM_QTA_RBC      A2" ).append("\n"); 
		query.append("      ,SQM_QTA_LANE_OFC A3" ).append("\n"); 
		query.append("      ,COM_CPY_NO       A4" ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD   = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A2.BSE_TP_CD   = A3.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A2.BSE_YR      = A3.BSE_YR" ).append("\n"); 
		query.append("   AND A2.BSE_QTR_CD  = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A2.OFC_VW_CD   = A3.OFC_VW_CD" ).append("\n"); 
		query.append("   AND A2.TRD_CD      = A3.TRD_CD" ).append("\n"); 
		query.append("   AND A2.RLANE_CD    = A3.RLANE_CD" ).append("\n"); 
		query.append("   AND A2.DIR_CD      = A3.DIR_CD" ).append("\n"); 
		query.append("   AND A2.RGN_OFC_CD  = A3.RGN_OFC_CD" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = 'RBCCO'" ).append("\n"); 
		query.append("   AND A3.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A4.CPY_NO      < 2" ).append("\n"); 

	}
}