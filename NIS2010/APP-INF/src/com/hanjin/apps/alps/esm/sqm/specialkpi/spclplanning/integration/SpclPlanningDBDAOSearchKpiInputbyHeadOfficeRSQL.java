/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpclPlanningDBDAOSearchKpiInputbyHeadOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpclPlanningDBDAOSearchKpiInputbyHeadOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpclPlanningDBDAOSearchKpiInputbyHeadOffice
	  * 2015.11.20 김용습 [CHM-201538497] [CSR 전환건] KPI Input by Head Office 화면 보완 (Trade Direction 칼럼 추가, Row Add 버튼 추가)
	  * </pre>
	  */
	public SpclPlanningDBDAOSearchKpiInputbyHeadOfficeRSQL(){
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
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration").append("\n"); 
		query.append("FileName : SpclPlanningDBDAOSearchKpiInputbyHeadOfficeRSQL").append("\n"); 
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
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,DECODE(MAS.HUL_BND_CD,'BH','B/H','H/H') HUL_BND_CD" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.GID_LOD_QTY" ).append("\n"); 
		query.append("      ,A1.GID_GRS_RPB_REV" ).append("\n"); 
		query.append("      ,A1.LOD_QTY" ).append("\n"); 
		query.append("      ,A1.GRS_RPB_REV" ).append("\n"); 
		query.append("  FROM SQM_SPCL_LOD_REV A1, MAS_LANE_RGST MAS" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD     = @[f_bse_tp_cd]  --필수" ).append("\n"); 
		query.append("   AND A1.SPCL_TGT_CD   = @[f_spcl_tgt_cd]  --필수" ).append("\n"); 
		query.append("   AND A1.BSE_YR        = @[f_bse_yr]  --필수" ).append("\n"); 
		query.append("#if(${f_bse_qtr_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD    = @[f_bse_qtr_cd]  --ALL 이 아닐때 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RHQ_CD        = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.TRD_CD        = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD      = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trd_dir} != 'on' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.CONV_DIR_CD   = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A1.TRD_CD           = MAS.TRD_CD" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD       = MAS.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD         = MAS.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD           = MAS.DIR_CD" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("AND MAS.HUL_BND_CD       = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A1.RHQ_CD, A1.TRD_CD, A1.SUB_TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.CONV_DIR_CD, A1.BSE_QTR_CD" ).append("\n"); 

	}
}