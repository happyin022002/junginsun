/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOCoaVslRgstVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOCoaVslRgstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vsl_cd select
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOCoaVslRgstVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_seltrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selrlane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selslane",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_seldir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOCoaVslRgstVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT  B1.VSL_CD" ).append("\n"); 
		query.append("   FROM (SELECT A1.vsl_cd                                      AS vsl_cd" ).append("\n"); 
		query.append("               ,SUM(A1.STND_LDB_CAPA + NVL(A2.SUB_TRD_CAPA,0)) AS capa" ).append("\n"); 
		query.append("           FROM MAS_VSL_RGST A1" ).append("\n"); 
		query.append("               ,MAS_VSL_SUB_TRD_CAPA A2" ).append("\n"); 
		query.append("          WHERE A1.VSL_CD = A2.VSL_CD(+)" ).append("\n"); 
		query.append("          GROUP BY A1.VSL_CD" ).append("\n"); 
		query.append("        ) B1" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("         SELECT MIN(COST_YR||COST_WK) FM_PRD" ).append("\n"); 
		query.append("              , MAX(cost_yr||cost_wk) TO_PRD" ).append("\n"); 
		query.append("           FROM MAS_WK_PRD" ).append("\n"); 
		query.append("          WHERE COST_YR = @[f_year]" ).append("\n"); 
		query.append("            AND COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("        ) B2" ).append("\n"); 
		query.append("       ,MAS_MON_VVD_YRY_PLN B3" ).append("\n"); 
		query.append("  WHERE B1.VSL_CD   = B3.VSL_CD" ).append("\n"); 
		query.append("    AND B1.CAPA     = 0" ).append("\n"); 
		query.append("    AND B3.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_seltrade} != '')" ).append("\n"); 
		query.append("      AND B3.TRD_CD = @[f_seltrade]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_selrlane} != '')" ).append("\n"); 
		query.append("      AND B3.RLANE_CD = @[f_selrlane]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_seldir} != '')" ).append("\n"); 
		query.append("      AND B3.DIR_CD = @[f_seldir]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_selioc} != '')" ).append("\n"); 
		query.append("      AND B3.IOC_CD = @[f_selioc]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_selslane}!= '')" ).append("\n"); 
		query.append("      AND B3.SLAN_CD = @[f_selslane]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND SUBSTR(B3.COST_YRMON,1,4)||B3.COST_WK BETWEEN B2.FM_PRD AND B2.TO_PRD" ).append("\n"); 

	}
}