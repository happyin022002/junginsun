/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateQtaEditForAllocUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.07.25 최성민
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

public class QtaAdjustmentDBDAOUpdateQtaEditForAllocUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [확정 쿼타]의 Load와 상태를 변경한다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateQtaEditForAllocUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateQtaEditForAllocUSQL").append("\n"); 
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
		query.append("   MERGE INTO SQM_CFM_QTA A1 USING" ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("       SELECT S2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("            , S1.BSE_TP_CD" ).append("\n"); 
		query.append("            , S1.BSE_YR" ).append("\n"); 
		query.append("            , S2.BSE_QTR_CD" ).append("\n"); 
		query.append("            , S1.OFC_VW_CD" ).append("\n"); 
		query.append("            , S1.QTA_TGT_CD" ).append("\n"); 
		query.append("            , S1.TRD_CD" ).append("\n"); 
		query.append("            , S1.RLANE_CD" ).append("\n"); 
		query.append("            , S1.DIR_CD" ).append("\n"); 
		query.append("            , S1.VSL_CD" ).append("\n"); 
		query.append("            , S1.SKD_VOY_NO" ).append("\n"); 
		query.append("            , S1.SKD_DIR_CD" ).append("\n"); 
		query.append("            , S1.RHQ_CD" ).append("\n"); 
		query.append("            , S1.RGN_OFC_CD" ).append("\n"); 
		query.append("            , S1.LOD_QTY" ).append("\n"); 
		query.append("            , S1.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("            , S1.UPD_USR_ID" ).append("\n"); 
		query.append("            , S1.UPD_DT" ).append("\n"); 
		query.append("            , S2.CONV_DIR_CD" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("               SELECT @[bse_yr]         AS BSE_YR" ).append("\n"); 
		query.append("                    , 'Q'               AS BSE_TP_CD" ).append("\n"); 
		query.append("                    , 'L'               AS OFC_VW_CD" ).append("\n"); 
		query.append("                    , 'D'               AS QTA_TGT_CD" ).append("\n"); 
		query.append("                    , 'A'               AS SQM_CNG_TP_CD" ).append("\n"); 
		query.append("                    , @[trd_cd]         AS TRD_CD" ).append("\n"); 
		query.append("                    , @[rlane_cd]       AS RLANE_CD" ).append("\n"); 
		query.append("                    , @[dir_cd]         AS DIR_CD" ).append("\n"); 
		query.append("                    , @[vsl_cd]         AS VSL_CD" ).append("\n"); 
		query.append("                    , @[skd_voy_no]     AS SKD_VOY_NO" ).append("\n"); 
		query.append("                    , @[skd_dir_cd]     AS SKD_DIR_CD" ).append("\n"); 
		query.append("                    , @[rhq_cd]         AS RHQ_CD" ).append("\n"); 
		query.append("                    , @[rgn_ofc_cd]     AS RGN_OFC_CD" ).append("\n"); 
		query.append("                    , @[lod_qty]        AS LOD_QTY" ).append("\n"); 
		query.append("                    , @[upd_usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("                    , SYSDATE           AS UPD_DT" ).append("\n"); 
		query.append("                 FROM DUAL" ).append("\n"); 
		query.append("              ) S1" ).append("\n"); 
		query.append("            , SQM_CFM_TGT_VVD S2" ).append("\n"); 
		query.append("        WHERE S1.BSE_TP_CD      = S2.BSE_TP_CD" ).append("\n"); 
		query.append("          AND S1.BSE_YR         = S2.BSE_YR" ).append("\n"); 
		query.append("          AND S1.QTA_TGT_CD     = S2.QTA_TGT_CD" ).append("\n"); 
		query.append("          AND S1.TRD_CD         = S2.TRD_CD" ).append("\n"); 
		query.append("          AND S1.RLANE_CD       = S2.RLANE_CD" ).append("\n"); 
		query.append("          AND S1.DIR_CD         = S2.DIR_CD" ).append("\n"); 
		query.append("          AND S1.VSL_CD         = S2.VSL_CD" ).append("\n"); 
		query.append("          AND S1.SKD_VOY_NO     = S2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND S1.SKD_DIR_CD     = S2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND SUBSTR(S2.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("   ) A2" ).append("\n"); 
		query.append("   ON (" ).append("\n"); 
		query.append("        A1.QTA_RLSE_VER_NO = A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("    AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND A1.OFC_VW_CD    = A2.OFC_VW_CD" ).append("\n"); 
		query.append("    AND A1.QTA_TGT_CD   = A2.QTA_TGT_CD" ).append("\n"); 
		query.append("    AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("    AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.DIR_CD       = A2.DIR_CD" ).append("\n"); 
		query.append("    AND A1.VSL_CD       = A2.VSL_CD" ).append("\n"); 
		query.append("    AND A1.SKD_VOY_NO   = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A1.SKD_DIR_CD   = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND A1.RGN_OFC_CD   = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   WHEN MATCHED THEN" ).append("\n"); 
		query.append("       UPDATE" ).append("\n"); 
		query.append("          SET A1.LOD_QTY        = A2.LOD_QTY" ).append("\n"); 
		query.append("            , A1.SQM_CNG_TP_CD  = A2.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("            , A1.UPD_USR_ID     = A2.UPD_USR_ID" ).append("\n"); 
		query.append("            , A1.UPD_DT         = A2.UPD_DT" ).append("\n"); 
		query.append("   WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("       INSERT (" ).append("\n"); 
		query.append("             A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("           , A1.BSE_TP_CD" ).append("\n"); 
		query.append("           , A1.BSE_YR" ).append("\n"); 
		query.append("           , A1.BSE_QTR_CD" ).append("\n"); 
		query.append("           , A1.OFC_VW_CD" ).append("\n"); 
		query.append("           , A1.QTA_TGT_CD" ).append("\n"); 
		query.append("           , A1.TRD_CD" ).append("\n"); 
		query.append("           , A1.RLANE_CD" ).append("\n"); 
		query.append("           , A1.DIR_CD" ).append("\n"); 
		query.append("           , A1.VSL_CD" ).append("\n"); 
		query.append("           , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("           , A1.SKD_DIR_CD" ).append("\n"); 
		query.append("           , A1.RGN_OFC_CD" ).append("\n"); 
		query.append("           , A1.RHQ_CD" ).append("\n"); 
		query.append("           , A1.AQ_CD" ).append("\n"); 
		query.append("           , A1.CONV_DIR_CD" ).append("\n"); 
		query.append("           , A1.LOD_QTY" ).append("\n"); 
		query.append("           , A1.GRS_RPB_REV" ).append("\n"); 
		query.append("           , A1.PA_CM_UC_AMT" ).append("\n"); 
		query.append("           , A1.RA_CM_UC_AMT" ).append("\n"); 
		query.append("           , A1.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("           , A1.CRE_USR_ID" ).append("\n"); 
		query.append("           , A1.CRE_DT" ).append("\n"); 
		query.append("           , A1.UPD_USR_ID" ).append("\n"); 
		query.append("           , A1.UPD_DT" ).append("\n"); 
		query.append("           , A1.MA_SLS_YRMON" ).append("\n"); 
		query.append("       ) VALUES (" ).append("\n"); 
		query.append("             A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("           , A2.BSE_TP_CD" ).append("\n"); 
		query.append("           , A2.BSE_YR" ).append("\n"); 
		query.append("           , A2.BSE_QTR_CD" ).append("\n"); 
		query.append("           , A2.OFC_VW_CD" ).append("\n"); 
		query.append("           , A2.QTA_TGT_CD" ).append("\n"); 
		query.append("           , A2.TRD_CD" ).append("\n"); 
		query.append("           , A2.RLANE_CD" ).append("\n"); 
		query.append("           , A2.DIR_CD" ).append("\n"); 
		query.append("           , A2.VSL_CD" ).append("\n"); 
		query.append("           , A2.SKD_VOY_NO" ).append("\n"); 
		query.append("           , A2.SKD_DIR_CD" ).append("\n"); 
		query.append("           , A2.RGN_OFC_CD" ).append("\n"); 
		query.append("           , A2.RHQ_CD" ).append("\n"); 
		query.append("           , ''" ).append("\n"); 
		query.append("           , A2.CONV_DIR_CD" ).append("\n"); 
		query.append("           , A2.LOD_QTY" ).append("\n"); 
		query.append("           , 0" ).append("\n"); 
		query.append("           , 0" ).append("\n"); 
		query.append("           , 0" ).append("\n"); 
		query.append("           , A2.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("           , A2.UPD_USR_ID" ).append("\n"); 
		query.append("           , A2.UPD_DT" ).append("\n"); 
		query.append("           , A2.UPD_USR_ID" ).append("\n"); 
		query.append("           , A2.UPD_DT" ).append("\n"); 
		query.append("           , NULL" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}