/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOAddSectorCfmTargetVVDCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.02.18 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOAddSectorCfmTargetVVDCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Edit Office Add Cfm Target VVD을 생성합니다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOAddSectorCfmTargetVVDCSQL(){
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOAddSectorCfmTargetVVDCSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_CFM_TGT_VVD A1 USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT SUBSTR(@[bse_yr], 3, 2) || A1.BSE_QTR_CD || LPAD(A3.CPY_NO, 2, '0') AS QTA_RLSE_VER_NO " ).append("\n"); 
		query.append("      , A1.BSE_TP_CD" ).append("\n"); 
		query.append("      , A1.BSE_YR" ).append("\n"); 
		query.append("      , A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      , 'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      , A1.TRD_CD" ).append("\n"); 
		query.append("      , A1.RLANE_CD" ).append("\n"); 
		query.append("      , A1.DIR_CD" ).append("\n"); 
		query.append("      , A1.VSL_CD" ).append("\n"); 
		query.append("      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      , A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      , A1.BSE_MON" ).append("\n"); 
		query.append("      , A1.BSE_WK" ).append("\n"); 
		query.append("      , A4.COST_YRMON" ).append("\n"); 
		query.append("      , A4.SLS_YRMON" ).append("\n"); 
		query.append("      , NVL(" ).append("\n"); 
		query.append("        (SELECT S1.CONV_DIR_CD" ).append("\n"); 
		query.append("           FROM SQM_DIR_CONV S1" ).append("\n"); 
		query.append("          WHERE S1.BSE_TP_CD  = A1.BSE_TP_CD" ).append("\n"); 
		query.append("            AND S1.BSE_YR     = A1.BSE_YR" ).append("\n"); 
		query.append("            AND S1.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND S1.TRD_CD     = A1.TRD_CD" ).append("\n"); 
		query.append("            AND S1.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("            AND S1.DIR_CD     = A1.DIR_CD" ).append("\n"); 
		query.append("        ), A1.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A1.IOC_CD" ).append("\n"); 
		query.append("      , A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      , 0             AS LOD_QTY" ).append("\n"); 
		query.append("      , 0             AS GRS_REV" ).append("\n"); 
		query.append("      , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE       AS CRE_DT" ).append("\n"); 
		query.append("      , @[upd_usr_id] AS UPD_USR_ID " ).append("\n"); 
		query.append("      , SYSDATE       AS UPD_DT" ).append("\n"); 
		query.append("   FROM SQM_SCTR_ADD_TGT_VVD A1" ).append("\n"); 
		query.append("      , SQM_QTA_LANE_MGMT A2" ).append("\n"); 
		query.append("      , COM_CPY_NO A3" ).append("\n"); 
		query.append("      , MAS_MON_VVD A4" ).append("\n"); 
		query.append("  WHERE 1                =1" ).append("\n"); 
		query.append("    AND A1.TRD_CD        = A2.TRD_CD" ).append("\n"); 
		query.append("    AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.DIR_CD        = NVL(A2.LANE_DIR_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("    AND A1.TRD_CD        = A4.TRD_CD" ).append("\n"); 
		query.append("    AND A1.RLANE_CD      = A4.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.IOC_CD        = A4.IOC_CD" ).append("\n"); 
		query.append("    AND A1.DIR_CD        = A4.DIR_CD" ).append("\n"); 
		query.append("    AND A1.VSL_CD        = A4.VSL_CD" ).append("\n"); 
		query.append("    AND A1.SKD_VOY_NO    = A4.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A2.IAS_SCTR_FLG IS NOT NULL" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD     = @[bse_tp_cd]" ).append("\n"); 
		query.append("    AND A1.BSE_YR        = @[bse_yr]" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD    = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("    AND A3.CPY_NO BETWEEN 1 AND 2" ).append("\n"); 
		query.append("    AND A1.SUB_TRD_CD    = @[sub_trd_cd]" ).append("\n"); 
		query.append("    AND A1.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("    AND A1.DIR_CD        = NVL(@[dir_cd], A1.DIR_CD)  " ).append("\n"); 
		query.append("    AND A1.PF_GRP_CD     = @[pf_grp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ON (   A1.QTA_RLSE_VER_NO = A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD 	= A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR 		= A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD 	= A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.QTA_TGT_CD 	= A2.QTA_TGT_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD 		= A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD 		= A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD 		= A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD 		= A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO 	= A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD 	= A2.SKD_DIR_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT 	(  " ).append("\n"); 
		query.append("	  A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("	, A1.BSE_TP_CD" ).append("\n"); 
		query.append("	, A1.BSE_YR" ).append("\n"); 
		query.append("	, A1.BSE_QTR_CD" ).append("\n"); 
		query.append("	, A1.QTA_TGT_CD" ).append("\n"); 
		query.append("	, A1.TRD_CD" ).append("\n"); 
		query.append("	, A1.RLANE_CD" ).append("\n"); 
		query.append("	, A1.DIR_CD" ).append("\n"); 
		query.append("	, A1.VSL_CD" ).append("\n"); 
		query.append("	, A1.SKD_VOY_NO" ).append("\n"); 
		query.append("	, A1.SKD_DIR_CD" ).append("\n"); 
		query.append("	, A1.BSE_MON" ).append("\n"); 
		query.append("	, A1.BSE_WK" ).append("\n"); 
		query.append("	, A1.CONV_DIR_CD" ).append("\n"); 
		query.append("	, A1.SUB_TRD_CD" ).append("\n"); 
		query.append("	, A1.IOC_CD" ).append("\n"); 
		query.append("	, A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("	, A1.LOD_QTY" ).append("\n"); 
		query.append("	, A1.GRS_REV" ).append("\n"); 
		query.append("	, A1.CRE_USR_ID" ).append("\n"); 
		query.append("	, A1.CRE_DT" ).append("\n"); 
		query.append("	, A1.UPD_USR_ID" ).append("\n"); 
		query.append("	, A1.UPD_DT" ).append("\n"); 
		query.append("	, A1.SLS_YRMON" ).append("\n"); 
		query.append("	, A1.COST_YRMON )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    VALUES (      " ).append("\n"); 
		query.append("	  A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("	, A2.BSE_TP_CD" ).append("\n"); 
		query.append("	, A2.BSE_YR" ).append("\n"); 
		query.append("	, A2.BSE_QTR_CD" ).append("\n"); 
		query.append("	, A2.QTA_TGT_CD" ).append("\n"); 
		query.append("	, A2.TRD_CD" ).append("\n"); 
		query.append("	, A2.RLANE_CD" ).append("\n"); 
		query.append("	, A2.DIR_CD" ).append("\n"); 
		query.append("	, A2.VSL_CD" ).append("\n"); 
		query.append("	, A2.SKD_VOY_NO" ).append("\n"); 
		query.append("	, A2.SKD_DIR_CD" ).append("\n"); 
		query.append("	, A2.BSE_MON" ).append("\n"); 
		query.append("	, A2.BSE_WK" ).append("\n"); 
		query.append("	, A2.CONV_DIR_CD" ).append("\n"); 
		query.append("	, A2.SUB_TRD_CD" ).append("\n"); 
		query.append("	, A2.IOC_CD" ).append("\n"); 
		query.append("	, A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("	, A2.LOD_QTY" ).append("\n"); 
		query.append("	, A2.GRS_REV" ).append("\n"); 
		query.append("	, A2.CRE_USR_ID" ).append("\n"); 
		query.append("	, A2.CRE_DT" ).append("\n"); 
		query.append("	, A2.UPD_USR_ID" ).append("\n"); 
		query.append("	, A2.UPD_DT" ).append("\n"); 
		query.append("	, A2.SLS_YRMON" ).append("\n"); 
		query.append("	, A2.COST_YRMON )" ).append("\n"); 

	}
}