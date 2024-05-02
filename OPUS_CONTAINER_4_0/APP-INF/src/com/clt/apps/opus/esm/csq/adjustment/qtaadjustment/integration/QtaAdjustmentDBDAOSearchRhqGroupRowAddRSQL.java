/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchRhqGroupRowAddRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOSearchRhqGroupRowAddRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Portion Adjustment by Head Office]를 [RHQ Group Row Add] 합니다
	  * [Portion Adjustment by RHQ]를 [RHQ Group Row Add] 합니다
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchRhqGroupRowAddRSQL(){
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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_qta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchRhqGroupRowAddRSQL").append("\n"); 
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
		query.append("      ,DECODE(A1.OFC_VW_CD,'C','Contract','Loading')    AS OFC_VW_CD" ).append("\n"); 
		query.append("      ,DECODE(A3.OB_DIV_CD,'N','N.OB','O/B')            AS OB_DIV_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,NVL(A5.CONV_DIR_CD, A1.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,A2.LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,A2.REV_POTN_RTO" ).append("\n"); 
		query.append("      ,DENSE_RANK() OVER(PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.OFC_VW_CD, A2.QTA_STEP_CD, A1.TRD_CD, A1.RLANE_CD --, A2.RHQ_CD" ).append("\n"); 
		query.append("                         ORDER BY A1.TRD_CD, A1.RLANE_CD, A2.CONV_DIR_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("      								, A2.RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         ) GRP_NO" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("      ,CSQ_QTA_POTN_MGMT A2" ).append("\n"); 
		query.append("      ,CSQ_DAT_RLT A3" ).append("\n"); 
		query.append("      ,CSQ_DIR_CONV A5" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD    = A5.BSE_TP_CD(+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR       = A5.BSE_YR(+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD   = A5.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A5.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A5.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A5.DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD    = A3.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR       = A3.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD   = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD    = A3.OFC_VW_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A3.TRD_CD" ).append("\n"); 
		query.append("   AND NVL(A5.CONV_DIR_CD,A1.DIR_CD)  = A3.CONV_DIR_CD" ).append("\n"); 
		query.append("   AND A1.RHQ_CD       = A3.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD    = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR       = A2.BSE_YR(+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD    = A2.OFC_VW_CD(+)" ).append("\n"); 
		query.append("   AND A1.RHQ_CD       = A2.RHQ_CD(+)" ).append("\n"); 
		query.append("#if (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD   = A2.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A2.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A2.DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.CSQ_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD    = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("   AND A2.QTA_STEP_CD(+)  = @[f_qta_step_cd]" ).append("\n"); 
		query.append("   AND A3.TEAM_CD      = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255')" ).append("\n"); 
		query.append("                                                       THEN A3.TEAM_CD" ).append("\n"); 
		query.append("                                                  ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                                END TEAM_CD" ).append("\n"); 
		query.append("                                          FROM DUAL)" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("   AND A2.QTA_STEP_CD(+)  <> '02'" ).append("\n"); 
		query.append("   AND A3.RHQ_CD       = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255')" ).append("\n"); 
		query.append("                                                       THEN A3.RHQ_CD" ).append("\n"); 
		query.append("                                                  ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                                END RHQ_CD" ).append("\n"); 
		query.append("                                          FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND NVL(A5.CONV_DIR_CD,A1.DIR_CD)  = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("   AND A3.OB_DIV_CD   = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD   = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A1.TRD_CD" ).append("\n"); 
		query.append("         ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("         ,A1.RLANE_CD" ).append("\n"); 
		query.append("         ,NVL(A5.CONV_DIR_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("         ,A1.RHQ_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("         ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}