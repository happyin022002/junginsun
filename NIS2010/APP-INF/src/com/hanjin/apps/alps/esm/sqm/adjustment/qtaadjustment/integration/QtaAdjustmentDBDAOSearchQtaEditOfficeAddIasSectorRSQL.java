/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchQtaEditOfficeAddIasSectorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.04.11 최성민
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

public class QtaAdjustmentDBDAOSearchQtaEditOfficeAddIasSectorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Edit_ Office Add for IAS Sector List 를 조회 합니다.
	  * 
	  * 2014.07.03 이혜민 OFC_VW_CD 추가
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.02.05 최성민 [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
	  * 2016.04.11 최성민 [CHM-201640884] Sector Office Add 로직 수정
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchQtaEditOfficeAddIasSectorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ias_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchQtaEditOfficeAddIasSectorRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A1.BSE_TP_CD  " ).append("\n"); 
		query.append("      ,A1.BSE_YR  " ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD  " ).append("\n"); 
		query.append("      ,A1.RLANE_CD  " ).append("\n"); 
		query.append("      ,A1.DIR_CD  " ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD  " ).append("\n"); 
		query.append("      ,A1.PF_GRP_CD  " ).append("\n"); 
		query.append("      ,A1.RHQ_CD  " ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD  " ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC  " ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL  " ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD03218'  " ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = A2.IAS_RGN_CD) IAS_RGN_CD  " ).append("\n"); 
		query.append("      ,A1.POL_CD  " ).append("\n"); 
		query.append("      ,A1.POD_CD  " ).append("\n"); 
		query.append("FROM SQM_SCTR_LANE_OFC A1, MAS_LANE_RGST A2  " ).append("\n"); 
		query.append("WHERE 1=1  " ).append("\n"); 
		query.append("AND A1.SQM_ACT_FLG = 'Y'  " ).append("\n"); 
		query.append("AND A1.TRD_CD     = A2.TRD_CD  " ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = A2.SUB_TRD_CD  " ).append("\n"); 
		query.append("AND A1.RLANE_CD   = A2.RLANE_CD  " ).append("\n"); 
		query.append("AND A1.BSE_TP_CD   = @[f_bse_tp_cd]  " ).append("\n"); 
		query.append("AND A1.BSE_YR      = @[f_bse_yr]  " ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])  " ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD  = @[f_sub_trd_cd]  " ).append("\n"); 
		query.append("AND A1.RLANE_CD    = @[f_rlane_cd]  " ).append("\n"); 
		query.append("AND A1.DIR_CD      = @[f_dir_cd]  " ).append("\n"); 
		query.append("AND A1.OFC_VW_CD   = SUBSTR(@[f_ofc_vw_cd], 0 ,1)  " ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')  " ).append("\n"); 
		query.append("AND A1.POL_CD      = @[f_pol_cd]  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')  " ).append("\n"); 
		query.append("AND A1.POD_CD      = @[f_pod_cd]  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')  " ).append("\n"); 
		query.append("AND A1.RHQ_CD      = @[f_rhq_cd]  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')  " ).append("\n"); 
		query.append("AND A1.RGN_OFC_CD  = @[f_rgn_ofc_cd]  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND A1.RHQ_CD||A1.RGN_OFC_CD||A1.POL_CD||A1.POD_CD||A1.PF_GRP_CD NOT IN (   " ).append("\n"); 
		query.append("----------------------------------  " ).append("\n"); 
		query.append("	      SELECT DISTINCT A1.RHQ_CD||A1.RGN_OFC_CD||A1.POL_CD||A1.POD_CD||A4.PF_GRP_CD  " ).append("\n"); 
		query.append("		FROM SQM_SCTR_CFM_QTA A1  " ).append("\n"); 
		query.append("		    ,SQM_CFM_TGT_VVD A2  " ).append("\n"); 
		query.append("		    ,MAS_LANE_RGST A3  " ).append("\n"); 
		query.append("		    ,SQM_SCTR_PAIR_MGMT A4  " ).append("\n"); 
		query.append("	       WHERE A1.BSE_TP_CD                  = 'Q'  " ).append("\n"); 
		query.append("		 AND A1.BSE_YR                     = @[f_bse_yr]  " ).append("\n"); 
		query.append("		 AND A1.BSE_QTR_CD                 = @[f_bse_qtr_cd]  " ).append("\n"); 
		query.append("		 AND A1.OFC_VW_CD                  = SUBSTR(@[f_ofc_vw_cd], 0 ,1)  " ).append("\n"); 
		query.append("		 AND SUBSTR(A1.QTA_RLSE_VER_NO,-2) = '02'  " ).append("\n"); 
		query.append("		 AND A1.TRD_CD                     = 'IAS'    " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	      #if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')  " ).append("\n"); 
		query.append("		 AND A1.SUB_TRD_CD                 = @[f_sub_trd_cd]  " ).append("\n"); 
		query.append("	      #end  " ).append("\n"); 
		query.append("	      #if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')  " ).append("\n"); 
		query.append("		 AND A1.RLANE_CD                   = @[f_rlane_cd]  " ).append("\n"); 
		query.append("	      #end  " ).append("\n"); 
		query.append("	      #if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')  " ).append("\n"); 
		query.append("		 AND A1.DIR_CD                     = @[f_dir_cd]  " ).append("\n"); 
		query.append("	      #end  " ).append("\n"); 
		query.append("	      #if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')  " ).append("\n"); 
		query.append("		 AND A3.IAS_RGN_CD                 = @[f_ias_rgn_cd]  " ).append("\n"); 
		query.append("	      #end  " ).append("\n"); 
		query.append("	      #if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')  " ).append("\n"); 
		query.append("		 AND A1.RHQ_CD                     = @[f_rhq_cd]  " ).append("\n"); 
		query.append("	      #end  " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	      #if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')  " ).append("\n"); 
		query.append("		 AND A1.POL_CD                 = @[f_pol_cd]  " ).append("\n"); 
		query.append("	      #end  " ).append("\n"); 
		query.append("	      #if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')  " ).append("\n"); 
		query.append("		 AND A1.POD_CD                 = @[f_pod_cd]  " ).append("\n"); 
		query.append("	      #end                " ).append("\n"); 
		query.append("	      #if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')  " ).append("\n"); 
		query.append("		 AND A1.RGN_OFC_CD                 = @[f_rgn_ofc_cd]  " ).append("\n"); 
		query.append("	      #end  " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		 AND A1.QTA_RLSE_VER_NO            = A2.QTA_RLSE_VER_NO  " ).append("\n"); 
		query.append("		 AND A1.BSE_TP_CD                  = A2.BSE_TP_CD  " ).append("\n"); 
		query.append("		 AND A1.BSE_YR                     = A2.BSE_YR  " ).append("\n"); 
		query.append("		 AND A1.BSE_QTR_CD                 = A2.BSE_QTR_CD  " ).append("\n"); 
		query.append("		 AND A1.TRD_CD                     = A2.TRD_CD  " ).append("\n"); 
		query.append("		 AND A1.RLANE_CD                   = A2.RLANE_CD  " ).append("\n"); 
		query.append("		 AND A1.DIR_CD                     = A2.DIR_CD    " ).append("\n"); 
		query.append("		 AND A1.VSL_CD                     = A2.VSL_CD  " ).append("\n"); 
		query.append("		 AND A1.SKD_VOY_NO                 = A2.SKD_VOY_NO  " ).append("\n"); 
		query.append("		 AND A1.SKD_DIR_CD                 = A2.SKD_DIR_CD  " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		 AND A1.TRD_CD                     = A3.TRD_CD  " ).append("\n"); 
		query.append("		 AND A1.SUB_TRD_CD                 = A3.SUB_TRD_CD  " ).append("\n"); 
		query.append("		 AND A1.RLANE_CD                   = A3.RLANE_CD  " ).append("\n"); 
		query.append("		 AND A1.DIR_CD                     = A3.DIR_CD    " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		 AND A2.IOC_CD                     = A3.IOC_CD  " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		 AND A1.BSE_TP_CD  				 = A4.BSE_TP_CD  " ).append("\n"); 
		query.append("		 AND A1.BSE_YR     				 = A4.BSE_YR  " ).append("\n"); 
		query.append("		 AND A1.BSE_QTR_CD 				 = A4.BSE_QTR_CD  " ).append("\n"); 
		query.append("		 AND A1.RLANE_CD   				 = A4.RLANE_CD  " ).append("\n"); 
		query.append("		 AND A1.DIR_CD     				 = A4.DIR_CD  " ).append("\n"); 
		query.append("		 AND A1.PF_GRP_CD  				 = A4.PF_GRP_CD  " ).append("\n"); 
		query.append("		 AND A1.POL_CD     				 = A4.POL_CD  " ).append("\n"); 
		query.append("		 AND A1.POD_CD     				 = A4.POD_CD   " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	      ---------------------------------  " ).append("\n"); 
		query.append("				    )  " ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')  " ).append("\n"); 
		query.append("AND A2.IAS_RGN_CD = @[f_ias_rgn_cd]  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("ORDER BY RHQ_CD, RGN_OFC_CD, POL_CD, POD_CD, A1.PF_GRP_CD" ).append("\n"); 

	}
}