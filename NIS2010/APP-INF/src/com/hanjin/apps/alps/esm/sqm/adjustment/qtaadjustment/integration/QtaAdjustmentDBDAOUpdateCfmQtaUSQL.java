/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateCfmQtaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.15 
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

public class QtaAdjustmentDBDAOUpdateCfmQtaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Adjustment by VVD]에서 확정데이터를 [수정] 합니다
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateCfmQtaUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mas_fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("copy_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateCfmQtaUSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_CFM_QTA T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("         SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("               ,BSE_TP_CD" ).append("\n"); 
		query.append("               ,BSE_YR" ).append("\n"); 
		query.append("               ,BSE_QTR_CD" ).append("\n"); 
		query.append("               ,OFC_VW_CD" ).append("\n"); 
		query.append("               ,QTA_TGT_CD" ).append("\n"); 
		query.append("               ,TRD_CD" ).append("\n"); 
		query.append("               ,RLANE_CD" ).append("\n"); 
		query.append("               ,DIR_CD" ).append("\n"); 
		query.append("               ,VSL_CD" ).append("\n"); 
		query.append("               ,SKD_VOY_NO" ).append("\n"); 
		query.append("               ,SKD_DIR_CD" ).append("\n"); 
		query.append("               ,RGN_OFC_CD" ).append("\n"); 
		query.append("               ,DECODE(DECODE(@[ibflag], 'I', @[mas_fnl_bsa_capa], @[fnl_bsa_capa]), 0, 0, NVL(ROUND(@[mas_fnl_bsa_capa] * LOD_QTY / DECODE(@[ibflag], 'I', (SELECT FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                                                                                                                                               FROM SQM_CFM_TGT_VVD T" ).append("\n"); 
		query.append("                                                                                                                                                              WHERE T.QTA_RLSE_VER_NO = C.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.BSE_TP_CD       = C.BSE_TP_CD" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.BSE_YR          = C.BSE_YR" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.BSE_QTR_CD      = C.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.QTA_TGT_CD      = C.QTA_TGT_CD" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.TRD_CD          = C.TRD_CD" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.RLANE_CD        = C.RLANE_CD" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.DIR_CD          = C.DIR_CD" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.VSL_CD          = SUBSTR(@[copy_vvd], 1, 4)" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.SKD_VOY_NO      = SUBSTR(@[copy_vvd], 5, 4)" ).append("\n"); 
		query.append("                                                                                                                                                                AND T.SKD_DIR_CD      = SUBSTR(@[copy_vvd], 9, 1) ), @[fnl_bsa_capa])), 0)) AS LOD_QTY" ).append("\n"); 
		query.append("               ,DECODE(@[ibflag], 'I', 'M', SQM_CNG_TP_CD) AS SQM_CNG_TP_CD" ).append("\n"); 
		query.append("           FROM SQM_CFM_QTA C" ).append("\n"); 
		query.append("          WHERE QTA_RLSE_VER_NO = @[qta_rlse_ver_no]" ).append("\n"); 
		query.append("            AND BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("            AND BSE_QTR_CD      = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("            AND QTA_TGT_CD      = 'D'" ).append("\n"); 
		query.append("            AND TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("            AND RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("            AND DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("            AND VSL_CD || SKD_VOY_NO || SKD_DIR_CD = @[mas_vvd]" ).append("\n"); 
		query.append("            AND SQM_CNG_TP_CD  <> 'A'" ).append("\n"); 
		query.append("      ) C" ).append("\n"); 
		query.append("   ON (         T.QTA_RLSE_VER_NO = C.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("            AND T.BSE_TP_CD       = C.BSE_TP_CD" ).append("\n"); 
		query.append("            AND T.BSE_YR          = C.BSE_YR" ).append("\n"); 
		query.append("            AND T.BSE_QTR_CD      = C.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND T.OFC_VW_CD       = C.OFC_VW_CD" ).append("\n"); 
		query.append("            AND T.QTA_TGT_CD      = C.QTA_TGT_CD" ).append("\n"); 
		query.append("            AND T.TRD_CD          = C.TRD_CD" ).append("\n"); 
		query.append("            AND T.RLANE_CD        = C.RLANE_CD" ).append("\n"); 
		query.append("            AND T.DIR_CD          = C.DIR_CD" ).append("\n"); 
		query.append("            AND T.VSL_CD          = C.VSL_CD" ).append("\n"); 
		query.append("            AND T.SKD_VOY_NO      = C.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND T.SKD_DIR_CD      = C.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND T.RGN_OFC_CD      = C.RGN_OFC_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET T.LOD_QTY       = C.LOD_QTY" ).append("\n"); 
		query.append("           ,T.SQM_CNG_TP_CD = C.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("           ,T.UPD_USR_ID    = @[usr_id]" ).append("\n"); 
		query.append("           ,T.UPD_DT        = SYSDATE" ).append("\n"); 

	}
}