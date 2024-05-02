/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdjustmentDBDAOSearchCurrentKpiReportPreviousVersionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOSearchCurrentKpiReportPreviousVersionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AdjustmentDBDAOSearchCurrentKpiReportPreviousVersion
	  * </pre>
	  */
	public AdjustmentDBDAOSearchCurrentKpiReportPreviousVersionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOSearchCurrentKpiReportPreviousVersionRSQL").append("\n"); 
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
		query.append("#if (${f_chk_week} == 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("    SELECT BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("    ,BSE_WK " ).append("\n"); 
		query.append("--    ,VVD" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("	,RGN_OFC_CD " ).append("\n"); 
		query.append("    ,SUM(FNL_BSA_CAPA) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("    ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("    ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("    ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB" ).append("\n"); 
		query.append("    ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("    ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("    ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("    ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("    ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("#elseif (${f_chk_week} == 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '02')" ).append("\n"); 
		query.append("SELECT BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("    ,BSE_WK" ).append("\n"); 
		query.append("--    ,VVD" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("    ,SUM(FNL_BSA_CAPA) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("    ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("    ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("    ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB" ).append("\n"); 
		query.append("    ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("    ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("    ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("    ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("    ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,HUL_BND_CD" ).append("\n"); 
		query.append("        ,BSE_MON                 " ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("        ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("        ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append("        ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("        ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("        ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("        ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("        ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("        ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("        ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("        ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("        ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("#elseif (${f_chk_week} == 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '01')" ).append("\n"); 
		query.append("SELECT BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("    ,BSE_WK" ).append("\n"); 
		query.append("--    ,VVD" ).append("\n"); 
		query.append("    ,SUM(FNL_BSA_CAPA) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("    ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("    ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("    ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append("    ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("    ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("    ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("    ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("    ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,HUL_BND_CD" ).append("\n"); 
		query.append("        ,BSE_MON                 " ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("        ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("        ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append("        ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("        ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("        ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("        ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("        ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("        ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("        ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("        ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("        ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("#elseif (${f_chk_week} != 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("    SELECT BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("--    ,BSE_WK" ).append("\n"); 
		query.append("--    ,VVD" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("	,RGN_OFC_CD " ).append("\n"); 
		query.append("    ,SUM(FNL_BSA_CAPA) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("    ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("    ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("    ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append("    ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("    ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("    ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("    ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("    ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("#elseif (${f_chk_week} != 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '02')" ).append("\n"); 
		query.append("SELECT BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",CONV_DIR_CD" ).append("\n"); 
		query.append(",HUL_BND_CD" ).append("\n"); 
		query.append(",BSE_MON                 " ).append("\n"); 
		query.append("--,BSE_WK" ).append("\n"); 
		query.append("--,VVD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",SUM(FNL_BSA_CAPA) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append(",SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append(",NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append(",ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append(",SUM(GREV) AS GREV" ).append("\n"); 
		query.append(",SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append(",SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append(",NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append(",NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append(",SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append(",SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append(",NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append(",NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,HUL_BND_CD" ).append("\n"); 
		query.append("        ,BSE_MON                 " ).append("\n"); 
		query.append("    --    ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("        ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("        ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append("        ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("        ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("        ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("        ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("        ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("        ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("        ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("        ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("        ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (    " ).append("\n"); 
		query.append("#elseif (${f_chk_week} != 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '01')" ).append("\n"); 
		query.append("SELECT BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",CONV_DIR_CD" ).append("\n"); 
		query.append(",HUL_BND_CD" ).append("\n"); 
		query.append(",BSE_MON                 " ).append("\n"); 
		query.append("--,BSE_WK" ).append("\n"); 
		query.append("--,VVD" ).append("\n"); 
		query.append(",SUM(FNL_BSA_CAPA) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append(",SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append(",NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append(",ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append(",SUM(GREV) AS GREV" ).append("\n"); 
		query.append(",SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append(",SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append(",NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append(",NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append(",SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append(",SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append(",NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append(",NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,HUL_BND_CD" ).append("\n"); 
		query.append("        ,BSE_MON                 " ).append("\n"); 
		query.append("    --    ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("        ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("        ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append("        ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("        ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("        ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("        ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("        ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("        ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("        ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("        ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("        ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("###elseif (${f_chk_week} != 'W' && ${f_chk_vvd} == 'V' && ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("#elseif (${f_chk_week} != 'W' && ${f_chk_vvd} == 'V')" ).append("\n"); 
		query.append("    SELECT BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("--    ,BSE_WK" ).append("\n"); 
		query.append("    ,VVD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02' || ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("	,RGN_OFC_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("    ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("    ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("    ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append("    ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("    ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("    ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("    ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("    ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("#elseif (${f_chk_week} == 'W' && ${f_chk_vvd} == 'V' && ${f_ofc_lvl} != '03')" ).append("\n"); 
		query.append("    SELECT BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("    ,BSE_WK" ).append("\n"); 
		query.append("    ,VVD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02')" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("    ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("    ,NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("    ,ROUND(NVL((SUM(GREV)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0)) AS GRPB " ).append("\n"); 
		query.append("    ,SUM(GREV) AS GREV" ).append("\n"); 
		query.append("    ,SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("    ,SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMCB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM_COST)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMCB" ).append("\n"); 
		query.append("    ,SUM(PA_CM) AS PA_CM" ).append("\n"); 
		query.append("    ,SUM(RA_CM) AS RA_CM" ).append("\n"); 
		query.append("    ,NVL((SUM(PA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS PA_CMPB" ).append("\n"); 
		query.append("    ,NVL((SUM(RA_CM)/DECODE(SUM(LOD_QTY), 0, NULL, SUM(LOD_QTY))),0) AS RA_CMPB" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BSE_TP_CD" ).append("\n"); 
		query.append("          ,'20'||SUBSTR(BSE_YR,-2) AS BSE_YR" ).append("\n"); 
		query.append("          ,BSE_QTR_CD" ).append("\n"); 
		query.append("          ,TRD_CD" ).append("\n"); 
		query.append("          ,SUB_TRD_CD" ).append("\n"); 
		query.append("          ,RLANE_CD" ).append("\n"); 
		query.append("          ,DIR_CD" ).append("\n"); 
		query.append("          ,CONV_DIR_CD" ).append("\n"); 
		query.append("          ,DECODE(HUL_BND_CD, 'HH', 'H/H', 'BH', 'B/H') HUL_BND_CD" ).append("\n"); 
		query.append("          ,BSE_MON          " ).append("\n"); 
		query.append("          ,RHQ_CD" ).append("\n"); 
		query.append("          ,RGN_OFC_CD" ).append("\n"); 
		query.append("          ,BSE_WK" ).append("\n"); 
		query.append("          ,VSL_CD ||SKD_VOY_NO ||SKD_DIR_CD AS VVD " ).append("\n"); 
		query.append("          ,FNL_BSA_CAPA          " ).append("\n"); 
		query.append("          ,LOD_QTY" ).append("\n"); 
		query.append("          ,GRS_REV AS GREV" ).append("\n"); 
		query.append("          ,ROUND(GRS_RPB_REV) AS GRPB" ).append("\n"); 
		query.append("          ,GRS_RPB_REV AS GRPB_DECIMAL" ).append("\n"); 
		query.append("          ,PA_CM_COST_AMT AS PA_CM_COST" ).append("\n"); 
		query.append("          ,RA_CM_COST_AMT AS RA_CM_COST" ).append("\n"); 
		query.append("          ,PA_CM_COST_PER_BX_AMT AS PA_CMCB" ).append("\n"); 
		query.append("          ,RA_CM_COST_PER_BX_AMT AS RA_CMCB" ).append("\n"); 
		query.append("          ,PA_CM_AMT AS PA_CM" ).append("\n"); 
		query.append("          ,RA_CM_AMT AS RA_CM" ).append("\n"); 
		query.append("          ,PA_CM_PER_BX_AMT AS PA_CMPB" ).append("\n"); 
		query.append("          ,RA_CM_PER_BX_AMT AS RA_CMPB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM SQM_RPT_DAT_BKUP" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("	#if(${f_year_tp_cd} != 'C')" ).append("\n"); 
		query.append("    AND BSE_TP_CD   = @[f_bse_tp_cd] --Currently Update조회시에는 타입코드를 비교하지 않는다. 이 경우에는 타입코드에는 Q, Y가 혼재되어서 들어가 있기 때문에" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if(${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("    AND OFC_VW_CD   = @[f_year_tp_cd] --OFC_VW_CD에 Initially Fixed(I)인지 Currently Updated(C)인지 담아줌" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND BSE_YR      = 'K'||@[f_bse_tp_cd]||SUBSTR(@[f_bse_yr],-2)" ).append("\n"); 
		query.append("    #if(${f_bse_qtr_cd} != 'All')" ).append("\n"); 
		query.append("    AND BSE_QTR_CD  = SUBSTR(@[f_bse_qtr_cd],1,1)||@[f_spcl_tgt_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND SQM_MN_SCTR_FLG = @[f_spcl_tgt_cd] -- SPCL_TGT_CD정보를 SQM_MN_SCTR_FLG컬럼에 담아둠 -------" ).append("\n"); 
		query.append("    #if(${f_fm_mon} != '' && ${f_to_mon} != '')" ).append("\n"); 
		query.append("    AND BSE_MON     BETWEEN @[f_fm_mon] AND @[f_to_mon]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_fm_wk} != '' && ${f_to_wk} != '')" ).append("\n"); 
		query.append("    AND BSE_WK      BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("    AND TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("    AND RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_trd_dir} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("    AND CONV_DIR_CD = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("    AND HUL_BND_CD  = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("    AND RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("    AND RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    ORDER BY BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,BSE_MON" ).append("\n"); 
		query.append("	  ,BSE_WK" ).append("\n"); 
		query.append("      ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("#if (${f_chk_week} == 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("    ,BSE_WK" ).append("\n"); 
		query.append("--    ,VVD" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("	,RGN_OFC_CD" ).append("\n"); 
		query.append("--    ,TOT_BSA_CAPA " ).append("\n"); 
		query.append("    ORDER BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,RHQ_CD" ).append("\n"); 
		query.append("    ,RGN_OFC_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , BSE_MON" ).append("\n"); 
		query.append("    , BSE_WK" ).append("\n"); 
		query.append("--    , VVD " ).append("\n"); 
		query.append("#elseif (${f_chk_week} == 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '02')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        GROUP BY BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,HUL_BND_CD" ).append("\n"); 
		query.append("        ,BSE_MON                 " ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA " ).append("\n"); 
		query.append("        ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("        , RLANE_CD" ).append("\n"); 
		query.append("        , DIR_CD" ).append("\n"); 
		query.append("        , BSE_MON     " ).append("\n"); 
		query.append("        , BSE_WK" ).append("\n"); 
		query.append("        , VVD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("    ,BSE_WK" ).append("\n"); 
		query.append("--    ,VVD" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("--    ,FNL_BSA_CAPA " ).append("\n"); 
		query.append("    ORDER BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,RHQ_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , BSE_MON    " ).append("\n"); 
		query.append("    , BSE_WK" ).append("\n"); 
		query.append("--    , VVD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#elseif (${f_chk_week} == 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '01')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        GROUP BY BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,HUL_BND_CD" ).append("\n"); 
		query.append("        ,BSE_MON                 " ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA " ).append("\n"); 
		query.append("        ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("        , RLANE_CD" ).append("\n"); 
		query.append("        , DIR_CD" ).append("\n"); 
		query.append("        , BSE_MON  " ).append("\n"); 
		query.append("        , BSE_WK" ).append("\n"); 
		query.append("        , VVD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("    ,BSE_WK" ).append("\n"); 
		query.append("--    ,VVD" ).append("\n"); 
		query.append("--    ,FNL_BSA_CAPA " ).append("\n"); 
		query.append("    ORDER BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , BSE_MON    " ).append("\n"); 
		query.append("    , BSE_WK" ).append("\n"); 
		query.append("--    , VVD" ).append("\n"); 
		query.append("#elseif (${f_chk_week} != 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("--    ,BSE_WK" ).append("\n"); 
		query.append("--    ,VVD" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("	,RGN_OFC_CD" ).append("\n"); 
		query.append("--    ,TOT_BSA_CAPA " ).append("\n"); 
		query.append("    ORDER BY BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , BSE_MON   " ).append("\n"); 
		query.append("--    , BSE_WK" ).append("\n"); 
		query.append("--    , VVD" ).append("\n"); 
		query.append("#elseif (${f_chk_week} != 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '02')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        GROUP BY BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,HUL_BND_CD" ).append("\n"); 
		query.append("        ,BSE_MON                 " ).append("\n"); 
		query.append("    --    ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA " ).append("\n"); 
		query.append("        ORDER BY BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("        , RLANE_CD" ).append("\n"); 
		query.append("        , DIR_CD" ).append("\n"); 
		query.append("        , BSE_MON     " ).append("\n"); 
		query.append("    --    , BSE_WK" ).append("\n"); 
		query.append("        , VVD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",CONV_DIR_CD" ).append("\n"); 
		query.append(",HUL_BND_CD" ).append("\n"); 
		query.append(",BSE_MON                 " ).append("\n"); 
		query.append("--,BSE_WK" ).append("\n"); 
		query.append("--,VVD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append("--,FNL_BSA_CAPA " ).append("\n"); 
		query.append("ORDER BY BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(", RLANE_CD" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", BSE_MON   " ).append("\n"); 
		query.append("--, BSE_WK" ).append("\n"); 
		query.append("--, VVD " ).append("\n"); 
		query.append("#elseif (${f_chk_week} != 'W' && ${f_chk_vvd} != 'V' && ${f_ofc_lvl} == '01')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    GROUP BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("--    ,BSE_WK" ).append("\n"); 
		query.append("    ,VVD" ).append("\n"); 
		query.append("    ,FNL_BSA_CAPA " ).append("\n"); 
		query.append("    ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , BSE_MON   " ).append("\n"); 
		query.append("--    , BSE_WK" ).append("\n"); 
		query.append("    , VVD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",CONV_DIR_CD" ).append("\n"); 
		query.append(",HUL_BND_CD" ).append("\n"); 
		query.append(",BSE_MON                 " ).append("\n"); 
		query.append("--,BSE_WK" ).append("\n"); 
		query.append("--,VVD" ).append("\n"); 
		query.append("--,FNL_BSA_CAPA " ).append("\n"); 
		query.append("ORDER BY BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(", RLANE_CD" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", BSE_MON     " ).append("\n"); 
		query.append("--, BSE_WK" ).append("\n"); 
		query.append("--, VVD" ).append("\n"); 
		query.append("###elseif (${f_chk_week} != 'W' && ${f_chk_vvd} == 'V' && ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("#elseif (${f_chk_week} != 'W' && ${f_chk_vvd} == 'V') " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("--    ,BSE_WK" ).append("\n"); 
		query.append("    ,VVD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02' || ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("	,RGN_OFC_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,FNL_BSA_CAPA " ).append("\n"); 
		query.append("    ORDER BY BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02' || ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("	,RGN_OFC_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , BSE_MON    " ).append("\n"); 
		query.append("--    , BSE_WK" ).append("\n"); 
		query.append("--    , VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${f_chk_week} == 'W' && ${f_chk_vvd} == 'V' && ${f_ofc_lvl} != '03')" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY BSE_YR" ).append("\n"); 
		query.append("    ,BSE_QTR_CD" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,CONV_DIR_CD" ).append("\n"); 
		query.append("    ,HUL_BND_CD" ).append("\n"); 
		query.append("    ,BSE_MON                 " ).append("\n"); 
		query.append("    ,BSE_WK" ).append("\n"); 
		query.append("    ,VVD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02')" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,FNL_BSA_CAPA " ).append("\n"); 
		query.append("    ORDER BY BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02')" ).append("\n"); 
		query.append("	,RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , BSE_MON    " ).append("\n"); 
		query.append("    , BSE_WK" ).append("\n"); 
		query.append("    , VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}