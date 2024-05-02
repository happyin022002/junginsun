/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchSectorOfcRelationSetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.15 
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

public class OfficeMappingDBDAOSearchSectorOfcRelationSetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sector Office Relation Setting for IAS Sector List를 조회합니다.
	  * 
	  * * History
	  * * 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
	  * * 2014.06.20 이혜민 [CHM-201430324] PAIR는 같은데 POL_CALL_SEQ, POD_CALL_SEQ 가 달라 중복 데이터가 나오는것 수정
	  * * 2014.09.23 이혜민 [CHM-201431753] Sector-Office Relation Setting 화면 내 Raw Data Export 버튼 생성건 
	  * * 2014.11.18 이혜민 [] 조회시 같은 데이터가 중복으로 나오는 것 수정(조인조건 추가)
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchSectorOfcRelationSetListRSQL(){
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
		params.put("f_ias_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchSectorOfcRelationSetListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID  = 'CD00940'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = A1.OFC_VW_CD) OFC_VW_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD03218'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = A2.IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("--      ,A1.POL_CALL_SEQ" ).append("\n"); 
		query.append("--      ,A1.POD_CALL_SEQ" ).append("\n"); 
		query.append("      ,MIN(A1.POL_CALL_SEQ) OVER (PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.OFC_VW_CD, A1.RLANE_CD, A1.DIR_CD, A1.RGN_OFC_CD, A1.RHQ_CD, A1.POL_CD, A1.POD_CD, A1.TRD_CD, A1.SUB_TRD_CD) POL_CALL_SEQ" ).append("\n"); 
		query.append("      ,MAX(A1.POD_CALL_SEQ) OVER (PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.OFC_VW_CD, A1.RLANE_CD, A1.DIR_CD, A1.RGN_OFC_CD, A1.RHQ_CD, A1.POL_CD, A1.POD_CD, A1.TRD_CD, A1.SUB_TRD_CD) POD_CALL_SEQ" ).append("\n"); 
		query.append("#if (${f_gubun} != '' && ${f_gubun} == 'Y') " ).append("\n"); 
		query.append("      ,A1.SQM_ACT_FLG SQM_ACT_FLG " ).append("\n"); 
		query.append("      ,NVL(A4.SQM_MN_SCTR_FLG, 'N') SQM_MN_SCTR_FLG" ).append("\n"); 
		query.append("#else   " ).append("\n"); 
		query.append("	  ,DECODE(A1.SQM_ACT_FLG, 'Y', 1, 'N', 0) SQM_ACT_FLG " ).append("\n"); 
		query.append("      ,DECODE(A4.SQM_MN_SCTR_FLG, 'Y', 1, 'N', 0) SQM_MN_SCTR_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM SQM_SCTR_LANE_OFC A1, MAS_LANE_RGST A2, SQM_QTA_LANE_OFC A3, SQM_SCTR_PAIR_MGMT A4" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD  = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD      = A2.DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD   = A3.BSE_TP_CD " ).append("\n"); 
		query.append("AND A1.BSE_YR      = A3.BSE_YR    " ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD  = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("AND A1.OFC_VW_CD   = A3.OFC_VW_CD " ).append("\n"); 
		query.append("AND A1.TRD_CD      = A3.TRD_CD    " ).append("\n"); 
		query.append("AND A1.RLANE_CD    = A3.RLANE_CD  " ).append("\n"); 
		query.append("AND A1.DIR_CD      = A3.DIR_CD    " ).append("\n"); 
		query.append("AND A1.RGN_OFC_CD  = A3.RGN_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD   = A4.BSE_TP_CD " ).append("\n"); 
		query.append("AND A1.BSE_YR      = A4.BSE_YR    " ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD  = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("AND A1.TRD_CD      = A4.TRD_CD    " ).append("\n"); 
		query.append("AND A1.RLANE_CD    = A4.RLANE_CD  " ).append("\n"); 
		query.append("AND A1.DIR_CD      = A4.DIR_CD    " ).append("\n"); 
		query.append("AND A1.POL_CD      = A4.POL_CD" ).append("\n"); 
		query.append("AND A1.POD_CD      = A4.POD_CD" ).append("\n"); 
		query.append("AND A1.PF_GRP_CD   = A4.PF_GRP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A3.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("AND A1.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_gubun} == '' || ${f_gubun} != 'Y')" ).append("\n"); 
		query.append("AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POL_CD      = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POD_CD      = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("AND A2.IAS_RGN_CD  = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A1.TRD_CD, A1.SUB_TRD_CD, IAS_RGN_CD, A1.RLANE_CD, A1.DIR_CD, A1.RHQ_CD, A1.RGN_OFC_CD, POL_CALL_SEQ ,POD_CALL_SEQ" ).append("\n"); 

	}
}