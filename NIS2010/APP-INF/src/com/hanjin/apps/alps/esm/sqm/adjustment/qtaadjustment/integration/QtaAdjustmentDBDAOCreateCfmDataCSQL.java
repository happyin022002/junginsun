/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCreateCfmDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.29 
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

public class QtaAdjustmentDBDAOCreateCfmDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation = QTA Adjustment화면에서 sel체크 후 Activate버튼 누르면 확정데이터가 생성되는 쿼리
	  * 2015.10.05 김용습 [CHM-201537934] [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정
	  * 2015.10.27 김용습 [CHM-201538639] [CSR 전환건] Allocation = QTA 화면 내 Activate 버튼 로직 보완 
	  * </pre>
	  */
	public QtaAdjustmentDBDAOCreateCfmDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cfm_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOCreateCfmDataCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_CFM_QTA" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("QTA_RLSE_VER_NO --1" ).append("\n"); 
		query.append(", BSE_TP_CD --2" ).append("\n"); 
		query.append(", BSE_YR --3" ).append("\n"); 
		query.append(", BSE_QTR_CD --4" ).append("\n"); 
		query.append(", OFC_VW_CD --5" ).append("\n"); 
		query.append(", QTA_TGT_CD --6" ).append("\n"); 
		query.append(", TRD_CD --7" ).append("\n"); 
		query.append(", RLANE_CD --8" ).append("\n"); 
		query.append(", DIR_CD --9" ).append("\n"); 
		query.append(", VSL_CD --10" ).append("\n"); 
		query.append(", SKD_VOY_NO --11" ).append("\n"); 
		query.append(", SKD_DIR_CD --12" ).append("\n"); 
		query.append(", RGN_OFC_CD --13" ).append("\n"); 
		query.append(", RHQ_CD --14" ).append("\n"); 
		query.append(", AQ_CD --15" ).append("\n"); 
		query.append(", CONV_DIR_CD --16" ).append("\n"); 
		query.append(", LOD_QTY --17" ).append("\n"); 
		query.append(", GRS_RPB_REV --18" ).append("\n"); 
		query.append(", PA_CM_UC_AMT --19" ).append("\n"); 
		query.append(", RA_CM_UC_AMT --20" ).append("\n"); 
		query.append(", SQM_CNG_TP_CD --21" ).append("\n"); 
		query.append(", CRE_USR_ID --22" ).append("\n"); 
		query.append(", CRE_DT --23" ).append("\n"); 
		query.append(", UPD_USR_ID --24" ).append("\n"); 
		query.append(", UPD_DT --25" ).append("\n"); 
		query.append(", MA_SLS_YRMON --26" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(SUBSTR(@[bse_yr],-2)||CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END||'02' --1" ).append("\n"); 
		query.append(", 'Q' --2" ).append("\n"); 
		query.append(", @[bse_yr] --3" ).append("\n"); 
		query.append(", CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END --4" ).append("\n"); 
		query.append(", 'L' --5" ).append("\n"); 
		query.append(", 'D' --6" ).append("\n"); 
		query.append(", @[trd_cd] --7" ).append("\n"); 
		query.append(", @[rlane_cd] --8" ).append("\n"); 
		query.append(", @[dir_cd] --9" ).append("\n"); 
		query.append(", @[vsl_cd] --10" ).append("\n"); 
		query.append(", @[skd_voy_no] --11" ).append("\n"); 
		query.append(", @[skd_dir_cd] --12" ).append("\n"); 
		query.append(", @[rgn_ofc_cd] --13" ).append("\n"); 
		query.append(", @[rhq_cd] --14" ).append("\n"); 
		query.append(", NVL(( SELECT V.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("        FROM SQM_ORGANIZATION_V V" ).append("\n"); 
		query.append("        WHERE V.OFC_CD   = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("        AND V.DELT_FLG = 'N'),'') --15" ).append("\n"); 
		query.append(", NVL( (SELECT DISTINCT CONV_DIR_CD " ).append("\n"); 
		query.append("    FROM SQM_DIR_CONV " ).append("\n"); 
		query.append("        WHERE BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("         AND BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("         AND BSE_QTR_CD = CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("         AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("         AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("         AND DIR_CD = @[dir_cd] ), @[dir_cd]) --16" ).append("\n"); 
		query.append(", @[cfm_lod_qty] --17" ).append("\n"); 
		query.append(", NVL( NVL( (SELECT DISTINCT GRS_RPB_REV " ).append("\n"); 
		query.append("    FROM SQM_QTA_LOD_REV REV, SQM_QTA_TGT_VVD VVD" ).append("\n"); 
		query.append("        WHERE REV.BSE_TP_CD  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("         AND REV.BSE_YR     = VVD.BSE_YR" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("         AND REV.TRD_CD     = VVD.TRD_CD" ).append("\n"); 
		query.append("         AND REV.RLANE_CD   = VVD.RLANE_CD" ).append("\n"); 
		query.append("         AND REV.DIR_CD     = VVD.DIR_CD" ).append("\n"); 
		query.append("         AND REV.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("         AND REV.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND REV.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         AND REV.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("         AND REV.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("         AND REV.OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("         AND REV.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("         AND REV.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("         AND REV.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("         AND VVD.BSE_WK = @[bse_wk]), " ).append("\n"); 
		query.append("         (SELECT AVG(GRS_RPB_REV) " ).append("\n"); 
		query.append("        FROM SQM_QTA_LOD_REV REV, SQM_QTA_TGT_VVD VVD" ).append("\n"); 
		query.append("        WHERE REV.BSE_TP_CD  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("         AND REV.BSE_YR     = VVD.BSE_YR" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("         AND REV.TRD_CD     = VVD.TRD_CD" ).append("\n"); 
		query.append("         AND REV.RLANE_CD   = VVD.RLANE_CD" ).append("\n"); 
		query.append("         AND REV.DIR_CD     = VVD.DIR_CD" ).append("\n"); 
		query.append("         AND REV.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("         AND REV.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND REV.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         AND REV.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("         AND REV.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("         AND REV.OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("         AND REV.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("         AND REV.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("         AND REV.DIR_CD = @[dir_cd]) ), 0)--18" ).append("\n"); 
		query.append(", NVL( NVL( (SELECT DISTINCT PA_CM_UC_AMT " ).append("\n"); 
		query.append("    FROM SQM_QTA_LOD_REV REV, SQM_QTA_TGT_VVD VVD" ).append("\n"); 
		query.append("        WHERE REV.BSE_TP_CD  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("         AND REV.BSE_YR     = VVD.BSE_YR" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("         AND REV.TRD_CD     = VVD.TRD_CD" ).append("\n"); 
		query.append("         AND REV.RLANE_CD   = VVD.RLANE_CD" ).append("\n"); 
		query.append("         AND REV.DIR_CD     = VVD.DIR_CD" ).append("\n"); 
		query.append("         AND REV.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("         AND REV.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND REV.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         AND REV.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("         AND REV.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("         AND REV.OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("         AND REV.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("         AND REV.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("         AND REV.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("         AND VVD.BSE_WK = @[bse_wk])," ).append("\n"); 
		query.append("         (SELECT AVG(PA_CM_UC_AMT) " ).append("\n"); 
		query.append("        FROM SQM_QTA_LOD_REV REV, SQM_QTA_TGT_VVD VVD" ).append("\n"); 
		query.append("        WHERE REV.BSE_TP_CD  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("         AND REV.BSE_YR     = VVD.BSE_YR" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("         AND REV.TRD_CD     = VVD.TRD_CD" ).append("\n"); 
		query.append("         AND REV.RLANE_CD   = VVD.RLANE_CD" ).append("\n"); 
		query.append("         AND REV.DIR_CD     = VVD.DIR_CD" ).append("\n"); 
		query.append("         AND REV.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("         AND REV.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND REV.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         AND REV.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("         AND REV.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("         AND REV.OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("         AND REV.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("         AND REV.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("         AND REV.DIR_CD = @[dir_cd]) ), 0) --19" ).append("\n"); 
		query.append(", NVL( NVL( (SELECT DISTINCT RA_CM_UC_AMT " ).append("\n"); 
		query.append("    FROM SQM_QTA_LOD_REV REV, SQM_QTA_TGT_VVD VVD" ).append("\n"); 
		query.append("        WHERE REV.BSE_TP_CD  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("         AND REV.BSE_YR     = VVD.BSE_YR" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("         AND REV.TRD_CD     = VVD.TRD_CD" ).append("\n"); 
		query.append("         AND REV.RLANE_CD   = VVD.RLANE_CD" ).append("\n"); 
		query.append("         AND REV.DIR_CD     = VVD.DIR_CD" ).append("\n"); 
		query.append("         AND REV.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("         AND REV.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND REV.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         AND REV.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("         AND REV.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("         AND REV.OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("         AND REV.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("         AND REV.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("         AND REV.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("         AND VVD.BSE_WK = @[bse_wk])," ).append("\n"); 
		query.append("         (SELECT AVG(RA_CM_UC_AMT) " ).append("\n"); 
		query.append("        FROM SQM_QTA_LOD_REV REV, SQM_QTA_TGT_VVD VVD" ).append("\n"); 
		query.append("        WHERE REV.BSE_TP_CD  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("         AND REV.BSE_YR     = VVD.BSE_YR" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("         AND REV.TRD_CD     = VVD.TRD_CD" ).append("\n"); 
		query.append("         AND REV.RLANE_CD   = VVD.RLANE_CD" ).append("\n"); 
		query.append("         AND REV.DIR_CD     = VVD.DIR_CD" ).append("\n"); 
		query.append("         AND REV.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("         AND REV.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND REV.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         AND REV.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("         AND REV.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("         AND REV.BSE_QTR_CD = CASE WHEN @[bse_mon] = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN @[bse_mon] = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("         AND REV.OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("         AND REV.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("         AND REV.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("         AND REV.DIR_CD = @[dir_cd]) ), 0) --20" ).append("\n"); 
		query.append(", 'A' --21" ).append("\n"); 
		query.append(", @[upd_usr_id] --21" ).append("\n"); 
		query.append(", SYSDATE --22" ).append("\n"); 
		query.append(", @[upd_usr_id] --23" ).append("\n"); 
		query.append(", SYSDATE --24" ).append("\n"); 
		query.append(", '' --25" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}