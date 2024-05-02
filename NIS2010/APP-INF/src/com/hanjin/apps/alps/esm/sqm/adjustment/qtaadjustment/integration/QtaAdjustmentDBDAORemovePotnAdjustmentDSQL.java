/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : QtaAdjustmentDBDAORemovePotnAdjustmentDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class QtaAdjustmentDBDAORemovePotnAdjustmentDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Adjustment by VVD]
	  * [Portion Adjustment by Head Office]
	  * [Portion Adjustment by RHQ]
	  * 화면의 [Creation] 시 확정 데이터를 [삭제] 합니다.
	  * 
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2015.08.10 김용습 [CHM-201536994] Split24-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * 2015.11.30 김용습 [버그수정] QTA Adjustment by VVD for IAS Sector에서 Adjusting VVD select시 체크시에는 검색조건의 dir_cd이 아닌 row의 dir_cd를 가져오도록 함
	  * 2016.06.15 SELCMI 예외처리로직 추가
	  * </pre>
	  */
	public QtaAdjustmentDBDAORemovePotnAdjustmentDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_dir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adj_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAORemovePotnAdjustmentDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM SQM_CFM_QTA X" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO' || ${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("   AND X.SQM_CNG_TP_CD   = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (X.QTA_RLSE_VER_NO,X.BSE_TP_CD,X.BSE_YR,X.BSE_QTR_CD,X.OFC_VW_CD,X.QTA_TGT_CD,X.TRD_CD,X.RLANE_CD,X.DIR_CD,X.VSL_CD,X.SKD_VOY_NO,X.SKD_DIR_CD,X.RHQ_CD)" ).append("\n"); 
		query.append("    IN (" ).append("\n"); 
		query.append("            SELECT A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                  ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("                  ,A1.BSE_YR" ).append("\n"); 
		query.append("                  ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("                  ,A1.QTA_TGT_CD" ).append("\n"); 
		query.append("                  ,A1.TRD_CD" ).append("\n"); 
		query.append("                  ,A1.RLANE_CD" ).append("\n"); 
		query.append("                  ,A1.DIR_CD" ).append("\n"); 
		query.append("                  ,A1.VSL_CD" ).append("\n"); 
		query.append("                  ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,A1.RHQ_CD" ).append("\n"); 
		query.append("              FROM SQM_CFM_QTA A1" ).append("\n"); 
		query.append("                  ,SQM_DAT_RLT A2" ).append("\n"); 
		query.append("                  ,MAS_LANE_RGST A3" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND A1.BSE_TP_CD       = A2.BSE_TP_CD" ).append("\n"); 
		query.append("               AND A1.BSE_YR          = A2.BSE_YR" ).append("\n"); 
		query.append("               AND A1.BSE_QTR_CD      = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND A1.OFC_VW_CD       = A2.OFC_VW_CD" ).append("\n"); 
		query.append("               AND DECODE(A1.BSE_YR||A1.BSE_QTR_CD, '20141Q', DECODE(A1.RGN_OFC_CD, 'SELSC', 'SHARC', 'TYOSC', 'SHARC', A1.RHQ_CD), A1.RHQ_CD) = A2.RHQ_CD" ).append("\n"); 
		query.append("               AND A1.TRD_CD          = A2.TRD_CD" ).append("\n"); 
		query.append("               AND A1.CONV_DIR_CD     = A2.CONV_DIR_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO' || ${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("               AND A1.SQM_CNG_TP_CD   = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               AND A1.TRD_CD          = A3.TRD_CD" ).append("\n"); 
		query.append("               AND A1.RLANE_CD        = A3.RLANE_CD" ).append("\n"); 
		query.append("               AND A1.DIR_CD          = A3.DIR_CD" ).append("\n"); 
		query.append("               AND A3.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               AND A1.QTA_RLSE_VER_NO like '%02'" ).append("\n"); 
		query.append("               AND A1.BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("               AND A1.BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("               AND A1.BSE_QTR_CD      = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("               AND A2.TEAM_CD         = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') " ).append("\n"); 
		query.append("                                                            THEN A2.TEAM_CD" ).append("\n"); 
		query.append("                                                       ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                              END TEAM_CD" ).append("\n"); 
		query.append("                                         FROM DUAL)" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("               AND A2.RHQ_CD          = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') " ).append("\n"); 
		query.append("                                                            THEN A2.RHQ_CD" ).append("\n"); 
		query.append("                                                       ELSE DECODE(@[ofc_cd], 'SELCMI', A2.RHQ_CD, @[ofc_cd])" ).append("\n"); 
		query.append("                                              END RHQ_CD" ).append("\n"); 
		query.append("                                         FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.OFC_VW_CD       = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.TRD_CD          = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '' && ${rlane_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.RLANE_CD        = @[rlane_cd] -- Adjustment by VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.RLANE_CD        IN (${f_rlane_cd})  -- Portion Adjustment by HO/RHQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.DIR_CD          = DECODE(@[adj_vvd], 'Y', @[dir_cd], @[f_dir_cd]) -- QTA Adjustment by VVD for IAS Sector에서 Adjusting VVD select시 체크시에는 검색조건의 dir_cd이 아닌 row의 dir_cd를 가져오도록 함" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.CONV_DIR_CD     = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("               AND A3.HUL_BND_CD      = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("               AND A2.OB_DIV_CD       = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("               AND A1.VSL_CD || A1.SKD_VOY_NO || A1.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}