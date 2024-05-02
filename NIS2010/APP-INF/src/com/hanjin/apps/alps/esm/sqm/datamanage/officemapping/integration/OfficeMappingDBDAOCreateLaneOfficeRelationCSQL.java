/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OfficeMappingDBDAOCreateLaneOfficeRelationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_LANE_OFC (" ).append("\n"); 
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
		query.append("      ,SQM_ACT_FLG" ).append("\n"); 
		query.append("      ,ADD_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,A2.TRD_CD" ).append("\n"); 
		query.append("      ,A2.RLANE_CD" ).append("\n"); 
		query.append("      ,A2.DIR_CD" ).append("\n"); 
		query.append("      ,A3.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A3.RHQ_CD" ).append("\n"); 
		query.append("      ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,NVL((SELECT T.SQM_ACT_FLG" ).append("\n"); 
		query.append("              FROM SQM_QTA_LANE_OFC T" ).append("\n"); 
		query.append("             WHERE T.BSE_YR||T.BSE_QTR_CD = ( SELECT /*+ INDEX_DESC(SQM_QTA_LANE_OFC XPKSQM_QTA_LANE_OFC) */" ).append("\n"); 
		query.append("                                                     BSE_YR || BSE_QTR_CD" ).append("\n"); 
		query.append("                                                FROM SQM_QTA_LANE_OFC" ).append("\n"); 
		query.append("                                               WHERE BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("                                                 AND BSE_YR || BSE_QTR_CD < @[f_bse_yr] || DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                                 AND ROWNUM = 1 )" ).append("\n"); 
		query.append("               AND T.OFC_VW_CD  = A1.OFC_VW_CD" ).append("\n"); 
		query.append("               AND T.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("               AND T.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("               AND T.DIR_CD     = A2.DIR_CD" ).append("\n"); 
		query.append("               AND T.RGN_OFC_CD = A3.RGN_OFC_CD" ).append("\n"); 
		query.append("               AND T.RHQ_CD     = A3.RHQ_CD      ), 'N') AS SQM_ACT_FLG" ).append("\n"); 
		query.append("      ,'N' AS ADD_FLG" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_DAT_RLT       A1" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("          SELECT DISTINCT" ).append("\n"); 
		query.append("                 TRD_CD" ).append("\n"); 
		query.append("                ,RLANE_CD" ).append("\n"); 
		query.append("                ,SUB_TRD_CD" ).append("\n"); 
		query.append("                ,NVL(LANE_DIR_CD, DECODE(CPY_NO, 0, 'E', 'W')) AS DIR_CD" ).append("\n"); 
		query.append("                ,SQM_ACT_FLG" ).append("\n"); 
		query.append("            FROM SQM_QTA_LANE_MGMT" ).append("\n"); 
		query.append("                ,COM_CPY_NO" ).append("\n"); 
		query.append("           WHERE SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("             AND CPY_NO      < 2" ).append("\n"); 
		query.append("      ) A2" ).append("\n"); 
		query.append("      ,SQM_QTA_OFC       A3" ).append("\n"); 
		query.append("      ,SQM_DIR_CONV      A4" ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A2.SQM_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = DECODE(UPPER(A1.RLANE_CD), 'ALL', A1.RLANE_CD, A2.RLANE_CD)" ).append("\n"); 
		query.append("   AND A1.CONV_DIR_CD  = NVL(A4.CONV_DIR_CD, A2.DIR_CD)" ).append("\n"); 
		query.append("   AND A1.RHQ_CD       = A3.RHQ_CD" ).append("\n"); 
		query.append("   AND A4.BSE_TP_CD(+) = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A4.BSE_YR(+)    = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A4.BSE_QTR_CD(+)= DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A2.TRD_CD       = A4.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A2.RLANE_CD     = A4.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A2.DIR_CD       = A4.DIR_CD(+)" ).append("\n"); 
		query.append("   AND A3.DELT_FLG     = 'N'" ).append("\n"); 

	}
}