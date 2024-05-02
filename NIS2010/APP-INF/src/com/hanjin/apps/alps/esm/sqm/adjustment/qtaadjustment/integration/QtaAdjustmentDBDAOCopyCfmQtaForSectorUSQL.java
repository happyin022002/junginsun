/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCopyCfmQtaForSectorUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOCopyCfmQtaForSectorUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P/F GROUP 변경
	  *  - VVD별 QTA Editor 데이터에 P/F Group 가 다를 경우가 존재함에 따라 
	  *  - 데이터 보정을 위해 사용됨.
	  * 2016.05.20 김용습 프로포마 그룹 일괄적용되는 현상 수정
	  * </pre>
	  */
	public QtaAdjustmentDBDAOCopyCfmQtaForSectorUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mas_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mas_pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOCopyCfmQtaForSectorUSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_SCTR_CFM_QTA M1 USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      , BSE_TP_CD" ).append("\n"); 
		query.append("      , BSE_YR" ).append("\n"); 
		query.append("      , BSE_QTR_CD" ).append("\n"); 
		query.append("      , OFC_VW_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , RGN_OFC_CD" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 
		query.append("      , @[mas_pf_grp_cd] AS PF_GRP_CD" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , SUB_TRD_CD" ).append("\n"); 
		query.append("      , RHQ_CD" ).append("\n"); 
		query.append("      , AQ_CD" ).append("\n"); 
		query.append("      , FNL_BSA_CAPA" ).append("\n"); 
		query.append("      , LOD_QTY" ).append("\n"); 
		query.append("      , GRS_RPB_REV" ).append("\n"); 
		query.append("      , PA_CM_UC_AMT" ).append("\n"); 
		query.append("      , RA_CM_UC_AMT" ).append("\n"); 
		query.append("      , POL_CALL_SEQ" ).append("\n"); 
		query.append("      , POD_CALL_SEQ" ).append("\n"); 
		query.append("      , SQM_CNG_TP_CD" ).append("\n"); 
		query.append("      , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE   AS CRE_DT" ).append("\n"); 
		query.append("      , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE   AS UPD_DT" ).append("\n"); 
		query.append("   FROM SQM_SCTR_CFM_QTA" ).append("\n"); 
		query.append("  WHERE 1               =1" ).append("\n"); 
		query.append("    AND QTA_RLSE_VER_NO = SUBSTR(@[bse_yr], -2) ||@[bse_qtr_cd]||'02'" ).append("\n"); 
		query.append("    AND BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("    AND BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("    AND BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("    AND DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("    AND VSL_CD          = SUBSTR(NVL(@[vvd], @[mas_vvd]), 1, 4)" ).append("\n"); 
		query.append("    AND SKD_VOY_NO      = SUBSTR(NVL(@[vvd], @[mas_vvd]), 5, 4)" ).append("\n"); 
		query.append("    AND SKD_DIR_CD      = SUBSTR(NVL(@[vvd], @[mas_vvd]), 9, 1)" ).append("\n"); 
		query.append(") S1" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("            M1.QTA_RLSE_VER_NO = S1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        AND M1.BSE_TP_CD       = S1.BSE_TP_CD" ).append("\n"); 
		query.append("        AND M1.BSE_YR          = S1.BSE_YR" ).append("\n"); 
		query.append("        AND M1.BSE_QTR_CD      = S1.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND M1.OFC_VW_CD       = S1.OFC_VW_CD" ).append("\n"); 
		query.append("        AND M1.RLANE_CD        = S1.RLANE_CD" ).append("\n"); 
		query.append("        AND M1.DIR_CD          = S1.DIR_CD" ).append("\n"); 
		query.append("        AND M1.VSL_CD          = S1.VSL_CD" ).append("\n"); 
		query.append("        AND M1.SKD_VOY_NO      = S1.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND M1.SKD_DIR_CD      = S1.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND M1.RGN_OFC_CD      = S1.RGN_OFC_CD" ).append("\n"); 
		query.append("        AND M1.POL_CD          = S1.POL_CD" ).append("\n"); 
		query.append("        AND M1.POD_CD          = S1.POD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("       SET --M1.PF_GRP_CD  = S1.PF_GRP_CD" ).append("\n"); 
		query.append("		   M1.PF_GRP_CD  = (SELECT MAX(P.PF_GRP_CD) FROM SQM_SCTR_PAIR_MGMT P" ).append("\n"); 
		query.append("                                WHERE P.BSE_TP_CD = S1.BSE_TP_CD" ).append("\n"); 
		query.append("                                AND P.BSE_YR = S1.BSE_YR" ).append("\n"); 
		query.append("                                AND P.BSE_QTR_CD = S1.BSE_QTR_CD" ).append("\n"); 
		query.append("                                AND P.RLANE_CD = S1.RLANE_CD" ).append("\n"); 
		query.append("                                AND P.DIR_CD = S1.DIR_CD" ).append("\n"); 
		query.append("                                AND P.SUB_TRD_CD = S1.SUB_TRD_CD" ).append("\n"); 
		query.append("                                AND P.POL_CD = S1.POL_CD" ).append("\n"); 
		query.append("                                AND P.POD_CD = S1.POD_CD" ).append("\n"); 
		query.append("                                AND P.SQM_ACT_FLG = 'Y')" ).append("\n"); 
		query.append("         , M1.UPD_USR_ID = S1.UPD_USR_ID" ).append("\n"); 
		query.append("         , M1.UPD_DT     = S1.UPD_DT" ).append("\n"); 

	}
}