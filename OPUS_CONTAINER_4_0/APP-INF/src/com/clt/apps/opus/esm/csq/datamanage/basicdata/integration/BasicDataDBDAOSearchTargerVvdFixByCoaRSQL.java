/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOSearchTargerVvdFixByCoaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
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
		query.append("      ,SUBSTR(VVD.SLS_YRMON,5,6) BSE_MON" ).append("\n"); 
		query.append("      ,VVD.COST_WK BSE_WK" ).append("\n"); 
		query.append("      ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,VVD.IOC_CD" ).append("\n"); 
		query.append("      ,NVL(BSA.FNL_CO_BSA_CAPA,0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("  FROM COA_MON_VVD VVD" ).append("\n"); 
		query.append("      ,BSA_VVD_MST BSA" ).append("\n"); 
		query.append("      ,CSQ_QTA_LANE_MGMT LANE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.SLS_YRMON,0,4) = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND VVD.COST_WK      BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
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
		query.append("   AND LANE.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND LANE.BSE_TP_CD   = 'Q'" ).append("\n"); 
		query.append("   AND LANE.BSE_YR 	    = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND LANE.BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("ORDER BY VVD.TRD_CD" ).append("\n"); 
		query.append("        ,VVD.DIR_CD" ).append("\n"); 
		query.append("        ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,VVD.RLANE_CD" ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,VVD.COST_WK" ).append("\n"); 

	}
}