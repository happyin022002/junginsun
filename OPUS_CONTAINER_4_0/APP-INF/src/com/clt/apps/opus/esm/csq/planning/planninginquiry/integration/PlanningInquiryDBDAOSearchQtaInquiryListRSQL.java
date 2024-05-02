/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningInquiryDBDAOSearchQtaInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planninginquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningInquiryDBDAOSearchQtaInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PlanningInquiryDBDAOSearchQtaInquiryList
	  * </pre>
	  */
	public PlanningInquiryDBDAOSearchQtaInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planninginquiry.integration").append("\n"); 
		query.append("FileName : PlanningInquiryDBDAOSearchQtaInquiryListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       BSE_YR" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,BSE_MON" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,BSA_CAPA AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,ROUND(SUM(LOD_QTY)) AS LOD_QTY" ).append("\n"); 
		query.append("      ,SUM(G_REV) G_REV" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(LOD_QTY),0,0,SUM(G_REV)/SUM(LOD_QTY)) ) GRPB" ).append("\n"); 
		query.append("      ,ROUND(SUM(PA_CM_C)) PA_CM_C" ).append("\n"); 
		query.append("      ,ROUND(SUM(RA_CM_C)) RA_CM_C" ).append("\n"); 
		query.append("      ,ROUND(SUM(G_REV)-SUM(PA_CM_C)) PA_CM" ).append("\n"); 
		query.append("      ,ROUND(SUM(G_REV)-SUM(RA_CM_C)) RA_CM" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(LOD_QTY), 0 ,0, SUM(RA_CM_C)/SUM(LOD_QTY))) RA_CMCB" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(LOD_QTY), 0 ,0, SUM(PA_CM_C)/SUM(LOD_QTY))) PA_CMCB" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(LOD_QTY), 0 ,0, (SUM(G_REV)-SUM(RA_CM_C))/SUM(LOD_QTY))) RA_CMPB" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(LOD_QTY), 0 ,0, (SUM(G_REV)-SUM(PA_CM_C))/SUM(LOD_QTY))) PA_CMPB" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT QTA.BSE_YR" ).append("\n"); 
		query.append("      ,DECODE(QTA.OFC_VW_CD,'L','Loading','Contract') AS OFC_VW_CD" ).append("\n"); 
		query.append("      ,QTA.TRD_CD" ).append("\n"); 
		query.append("      ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,QTA.RLANE_CD" ).append("\n"); 
		query.append("      ,QTA.DIR_CD " ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '01')" ).append("\n"); 
		query.append("      ,'' AS RHQ_CD" ).append("\n"); 
		query.append("      ,'' AS RGN_OFC_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '02')   " ).append("\n"); 
		query.append("      ,QTA.RHQ_CD" ).append("\n"); 
		query.append("      ,'' AS RGN_OFC_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '03') " ).append("\n"); 
		query.append("      ,QTA.RHQ_CD" ).append("\n"); 
		query.append("      ,QTA.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,SUM(VVD.FNL_BSA_CAPA) OVER (PARTITION BY QTA.BSE_YR,QTA.OFC_VW_CD,QTA.RGN_OFC_CD,QTA.TRD_CD,VVD.SUB_TRD_CD,QTA.RLANE_CD,QTA.DIR_CD,QTA.RHQ_CD,VVD.BSE_MON ) BSA_CAPA" ).append("\n"); 
		query.append("      ,VVD.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,VVD.BSE_MON" ).append("\n"); 
		query.append("      ,'' as vvd" ).append("\n"); 
		query.append("--      ,QTA.VSL_CD||QTA.SKD_VOY_NO||QTA.SKD_DIR_CD vvd" ).append("\n"); 
		query.append("      ,QTA.LOD_QTY" ).append("\n"); 
		query.append("      ,ROUND(QTA.LOD_QTY * QTA.GRS_RPB_REV) as G_REV" ).append("\n"); 
		query.append("      ,QTA.LOD_QTY * QTA.PA_CM_UC_AMT as PA_CM_C" ).append("\n"); 
		query.append("      ,QTA.LOD_QTY * QTA.RA_CM_UC_AMT as RA_CM_C" ).append("\n"); 
		query.append("  FROM CSQ_CFM_QTA QTA" ).append("\n"); 
		query.append("      ,CSQ_CFM_TGT_VVD VVD" ).append("\n"); 
		query.append(" WHERE QTA.BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND QTA.BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND QTA.BSE_QTR_CD      = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND QTA.OFC_VW_CD       = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.TRD_CD          = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.RLANE_CD        = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_gubun} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.DIR_CD          = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} != '01' && ${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.RHQ_CD          = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '03' && ${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.RGN_OFC_CD      = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_fm_mon} != '' && ${f_to_mon} != '')" ).append("\n"); 
		query.append("   AND VVD.BSE_MON BETWEEN @[f_fm_mon] AND @[f_to_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND QTA.QTA_RLSE_VER_NO = VVD.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("   AND QTA.BSE_TP_CD       = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("   AND QTA.BSE_YR          = VVD.BSE_YR" ).append("\n"); 
		query.append("   AND QTA.BSE_QTR_CD      = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND QTA.QTA_TGT_CD      = VVD.QTA_TGT_CD" ).append("\n"); 
		query.append("   AND QTA.TRD_CD          = VVD.TRD_CD" ).append("\n"); 
		query.append("   AND QTA.RLANE_CD        = VVD.RLANE_CD" ).append("\n"); 
		query.append("   AND QTA.DIR_CD          = VVD.DIR_CD" ).append("\n"); 
		query.append("   AND QTA.VSL_CD          = VVD.VSL_CD" ).append("\n"); 
		query.append("   AND QTA.SKD_VOY_NO      = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND QTA.SKD_DIR_CD      = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SUBSTR(QTA.QTA_RLSE_VER_NO,-2) = '01'" ).append("\n"); 
		query.append("   AND VVD.QTA_TGT_CD      = 'D'" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("       BSE_YR" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,BSE_MON" ).append("\n"); 
		query.append("      ,BSA_CAPA" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("       RHQ_CD" ).append("\n"); 
		query.append("      ,RGN_OFC_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,BSE_MON" ).append("\n"); 
		query.append("      ,BSA_CAPA" ).append("\n"); 

	}
}