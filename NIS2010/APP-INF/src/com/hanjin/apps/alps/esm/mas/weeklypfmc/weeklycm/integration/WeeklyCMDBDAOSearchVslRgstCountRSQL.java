/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchVslRgstCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.09
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.02.09 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchVslRgstCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVslRgstCount SELECT
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchVslRgstCountRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchVslRgstCountRSQL").append("\n"); 
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
		query.append("       ,MAS_MON_VVD B3 /* 다시 변경 2009.10.15 */" ).append("\n"); 
		query.append("        /* MAS_MON_VVD 테이블은 Report 즉 실적을 보는 통계쪽에서만 없애는 것이고 일반 화면에서는 그대로 사용함.*/" ).append("\n"); 
		query.append("        /*,MAS_BKG_EXPN_DTL B3 변경 2009.09.10*/" ).append("\n"); 
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