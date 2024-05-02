/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchLoadingViewCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.06.28 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOSearchLoadingViewCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Office Relation Setting 화면의 Loading View Check Copy 버튼 조회
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchLoadingViewCheckListRSQL(){
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
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchLoadingViewCheckListRSQL").append("\n"); 
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
		query.append(" SELECT A1.BSE_YR" ).append("\n"); 
		query.append("      , A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      , A1.OFC_VW_CD" ).append("\n"); 
		query.append("      , A1.TRD_CD" ).append("\n"); 
		query.append("      , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A1.RLANE_CD" ).append("\n"); 
		query.append("      , A1.DIR_CD" ).append("\n"); 
		query.append("      , A1.RHQ_CD" ).append("\n"); 
		query.append("      , A1.RGN_OFC_CD" ).append("\n"); 
		query.append("--      , A1.SQM_ACT_FLG" ).append("\n"); 
		query.append("      , NVL(A2.SQM_ACT_FLG, 'N') SQM_ACT_FLG" ).append("\n"); 
		query.append("      , DECODE(A1.SQM_ACT_FLG, NVL(A2.SQM_ACT_FLG, 'N'), 'N', 'Y') AS MODI_FLG" ).append("\n"); 
		query.append("   FROM SQM_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("      , SQM_QTA_LANE_OFC A2" ).append("\n"); 
		query.append("  WHERE 1               =1" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("    AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("    AND A1.OFC_VW_CD    = @[f_ofc_vw_cd]    " ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("    AND A1.TRD_CD       = @[f_trd_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("    AND A1.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("    AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("    AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("    AND A1.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD    = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("    AND A1.BSE_YR       = A2.BSE_YR(+)" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("    AND A1.TRD_CD       = A2.TRD_CD(+)" ).append("\n"); 
		query.append("    AND A1.RLANE_CD     = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND A1.DIR_CD       = A2.DIR_CD(+)" ).append("\n"); 
		query.append("    AND A1.RGN_OFC_CD   = A2.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("    AND A2.OFC_VW_CD(+) = 'L'" ).append("\n"); 
		query.append("ORDER BY A1.TRD_CD" ).append("\n"); 
		query.append("      , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A1.RLANE_CD" ).append("\n"); 
		query.append("      , A1.DIR_CD" ).append("\n"); 
		query.append("      , A1.RHQ_CD" ).append("\n"); 
		query.append("      , A1.RGN_OFC_CD" ).append("\n"); 

	}
}