/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeMappingDBDAOCreateLaneOfficeRelationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOCreateLaneOfficeRelationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Office Relation Data 를 생성
	  * </pre>
	  */
	public OfficeMappingDBDAOCreateLaneOfficeRelationCSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOCreateLaneOfficeRelationCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_QTA_LANE_OFC (" ).append("\n"); 
		query.append("       BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,CSQ_ACT_FLG" ).append("\n"); 
		query.append("      ,ADD_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT B1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,B1.BSE_YR" ).append("\n"); 
		query.append("      ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,B1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,B1.TRD_CD" ).append("\n"); 
		query.append("      ,B1.RLANE_CD" ).append("\n"); 
		query.append("      ,B1.DIR_CD" ).append("\n"); 
		query.append("      ,B1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,B1.RHQ_CD" ).append("\n"); 
		query.append("      ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,NVL(B2.CSQ_ACT_FLG ,'N') CSQ_ACT_FLG" ).append("\n"); 
		query.append("      ,'N' AS ADD_FLG" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("              ,A1.BSE_YR" ).append("\n"); 
		query.append("              ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("              ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("              ,A2.TRD_CD" ).append("\n"); 
		query.append("              ,A2.RLANE_CD" ).append("\n"); 
		query.append("              ,A2.DIR_CD" ).append("\n"); 
		query.append("              ,A3.RGN_OFC_CD" ).append("\n"); 
		query.append("              ,A3.RHQ_CD" ).append("\n"); 
		query.append("              ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("          FROM CSQ_DAT_RLT       A1" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                    SELECT DISTINCT" ).append("\n"); 
		query.append("                             B1.BSE_TP_CD " ).append("\n"); 
		query.append("                            ,B1.BSE_YR " ).append("\n"); 
		query.append("                            ,B1.BSE_QTR_CD " ).append("\n"); 
		query.append("                            ,B1.TRD_CD" ).append("\n"); 
		query.append("                            ,B1.RLANE_CD" ).append("\n"); 
		query.append("                            ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                            ,NVL(B1.LANE_DIR_CD, B2.VSL_SLAN_DIR_CD ) AS DIR_CD" ).append("\n"); 
		query.append("                            ,B1.CSQ_ACT_FLG" ).append("\n"); 
		query.append("                    FROM CSQ_QTA_LANE_MGMT B1, MDM_VSL_SVC_LANE_DIR B2" ).append("\n"); 
		query.append("                    WHERE B1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("                     AND B1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                     AND B1.BSE_YR      = @[f_bse_yr] " ).append("\n"); 
		query.append("                     AND B1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                     AND SUBSTR(B1.RLANE_CD,0,3) = B2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                     AND B2.DELT_FLG             = 'N'" ).append("\n"); 
		query.append("              ) A2" ).append("\n"); 
		query.append("              ,CSQ_QTA_OFC       A3" ).append("\n"); 
		query.append("              ,CSQ_DIR_CONV      A4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("           AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("           AND A2.CSQ_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("           AND A1.BSE_TP_CD    = A2.BSE_TP_CD " ).append("\n"); 
		query.append("           AND A1.BSE_YR       = A2.BSE_YR " ).append("\n"); 
		query.append("           AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD " ).append("\n"); 
		query.append("           AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("           AND A1.CONV_DIR_CD  = NVL(A4.CONV_DIR_CD, A2.DIR_CD)" ).append("\n"); 
		query.append("           AND A1.RHQ_CD       = A3.RHQ_CD" ).append("\n"); 
		query.append("           AND A4.BSE_TP_CD(+) = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("           AND A4.BSE_YR(+)    = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND A4.BSE_QTR_CD(+)= DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("           AND A2.TRD_CD       = A4.TRD_CD(+)" ).append("\n"); 
		query.append("           AND A2.RLANE_CD     = A4.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND A2.DIR_CD       = A4.DIR_CD(+)" ).append("\n"); 
		query.append("           AND A3.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("        ) B1" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT OFC_VW_CD" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,RGN_OFC_CD" ).append("\n"); 
		query.append("              ,CSQ_ACT_FLG" ).append("\n"); 
		query.append("          FROM CSQ_QTA_LANE_OFC S1" ).append("\n"); 
		query.append("         WHERE S1.BSE_YR||S1.BSE_QTR_CD = ( SELECT /*+ INDEX_DESC(CSQ_QTA_LANE_OFC XPKCSQ_QTA_LANE_OFC) */" ).append("\n"); 
		query.append("                                                 BSE_YR || BSE_QTR_CD" ).append("\n"); 
		query.append("                                            FROM CSQ_QTA_LANE_OFC" ).append("\n"); 
		query.append("                                           WHERE BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("                                             AND BSE_YR || BSE_QTR_CD < @[f_bse_yr] || DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                             AND ROWNUM = 1 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ) B2     " ).append("\n"); 
		query.append("WHERE B1.OFC_VW_CD  = B2.OFC_VW_CD(+)" ).append("\n"); 
		query.append("  AND B1.TRD_CD     = B2.TRD_CD(+)" ).append("\n"); 
		query.append("  AND B1.RLANE_CD   = B2.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND B1.DIR_CD     = B2.DIR_CD(+)" ).append("\n"); 
		query.append("  AND B1.RGN_OFC_CD = B2.RGN_OFC_CD(+)" ).append("\n"); 

	}
}