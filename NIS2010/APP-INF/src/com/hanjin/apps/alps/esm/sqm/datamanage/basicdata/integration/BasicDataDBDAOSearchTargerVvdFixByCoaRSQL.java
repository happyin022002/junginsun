/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BasicDataDBDAOSearchTargerVvdFixByCoaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchTargerVvdFixByCoaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target VVD List를 조회
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.05.24 김용습 wk가 아니라 month기준으로 조회되도록 함
	  * 2016.05.24 김용습 mas에서 vvd가져올때 연도는 sls_yrmon, 월은 cost_yrmon 기준
	  * </pre>
	  */
	public BasicDataDBDAOSearchTargerVvdFixByCoaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchTargerVvdFixByCoaRSQL").append("\n"); 
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
		query.append("SELECT @[f_bse_yr] BSE_YR" ).append("\n"); 
		query.append("      ,@[f_bse_qtr_cd] BSE_QTR_CD" ).append("\n"); 
		query.append("      ,VVD.TRD_CD" ).append("\n"); 
		query.append("      ,VVD.RLANE_CD" ).append("\n"); 
		query.append("      ,VVD.DIR_CD" ).append("\n"); 
		query.append("      ,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.DIR_CD VVD" ).append("\n"); 
		query.append("      ,VVD.VSL_CD" ).append("\n"); 
		query.append("      ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,VVD.DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(VVD.COST_YRMON,5,6) BSE_MON" ).append("\n"); 
		query.append("      ,VVD.COST_WK BSE_WK" ).append("\n"); 
		query.append("      ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,VVD.IOC_CD" ).append("\n"); 
		query.append("      ,NVL(BSA.FNL_HJS_BSA_CAPA,0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD VVD" ).append("\n"); 
		query.append("      ,BSA_VVD_MST BSA" ).append("\n"); 
		query.append("      ,SQM_QTA_LANE_MGMT LANE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.SLS_YRMON,0,4) = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.COST_YRMON, 5) BETWEEN (CASE WHEN @[f_bse_qtr_cd] = '1Q' THEN '01' WHEN @[f_bse_qtr_cd] = '2Q' THEN '04' WHEN @[f_bse_qtr_cd] = '3Q' THEN '07' WHEN @[f_bse_qtr_cd] = '4Q' THEN '10' ELSE '01' END) " ).append("\n"); 
		query.append("                                              AND (CASE WHEN @[f_bse_qtr_cd] = '1Q' THEN '03' WHEN @[f_bse_qtr_cd] = '2Q' THEN '06' WHEN @[f_bse_qtr_cd] = '3Q' THEN '09' WHEN @[f_bse_qtr_cd] = '4Q' THEN '12' ELSE '12' END)" ).append("\n"); 
		query.append("   AND VVD.TRD_CD       = BSA.TRD_CD(+)" ).append("\n"); 
		query.append("   AND VVD.RLANE_CD     = BSA.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = BSA.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO   = BSA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND VVD.DIR_CD       = BSA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND VVD.TRD_CD       = LANE.TRD_CD" ).append("\n"); 
		query.append("   AND VVD.RLANE_CD     = LANE.RLANE_CD" ).append("\n"); 
		query.append("   AND VVD.SUB_TRD_CD   = LANE.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND VVD.IOC_CD       = DECODE(VVD.RLANE_CD,'RBCCO','I',VVD.IOC_CD)" ).append("\n"); 
		query.append("   AND VVD.DIR_CD       = NVL(LANE.LANE_DIR_CD,VVD.DIR_CD)" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("  AND VVD.TRD_CD        = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("  AND VVD.DIR_CD        = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("  AND VVD.SUB_TRD_CD    = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("  AND VVD.RLANE_CD      = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND VVD.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("   AND LANE.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY VVD.TRD_CD" ).append("\n"); 
		query.append("        ,VVD.DIR_CD" ).append("\n"); 
		query.append("        ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,VVD.RLANE_CD" ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,VVD.COST_WK" ).append("\n"); 

	}
}