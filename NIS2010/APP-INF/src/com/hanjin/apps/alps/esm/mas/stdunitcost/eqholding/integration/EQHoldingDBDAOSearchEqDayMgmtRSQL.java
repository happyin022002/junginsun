/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EQHoldingDBDAOSearchEqDayMgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier :  최덕우
*@LastVersion : 1.0
* 2016.08.25  최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Duk-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQHoldingDBDAOSearchEqDayMgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Day 관리화면 조회
	  * </pre>
	  */
	public EQHoldingDBDAOSearchEqDayMgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_eq_days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_del",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration").append("\n"); 
		query.append("FileName : EQHoldingDBDAOSearchEqDayMgmtRSQL").append("\n"); 
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
		query.append("#if (${code} == '0')" ).append("\n"); 
		query.append("  SELECT POR_CD" ).append("\n"); 
		query.append("        ,DEL_CD" ).append("\n"); 
		query.append("        ,TPSZ_CD" ).append("\n"); 
		query.append("        ,ROUND(SUM(FULL_DMT * BX_KNT)/DECODE(SUM(BX_KNT),0,1,SUM(BX_KNT)), 2) FULL_DMT" ).append("\n"); 
		query.append("        ,(ROUND(SUM(MT_LAND)/DECODE(COUNT(MT_LAND),0,1,COUNT(MT_LAND)), 2)) MT_LAND" ).append("\n"); 
		query.append("        ,ROUND(SUM(ORG_MTY_LAND_DYS)/DECODE(COUNT(ORG_MTY_LAND_DYS),0,1,COUNT(ORG_MTY_LAND_DYS)), 2) ORG_MTY_LAND_DYS" ).append("\n"); 
		query.append("        ,ROUND(SUM(DEST_MTY_LAND_DYS)/DECODE(COUNT(DEST_MTY_LAND_DYS),0,1,COUNT(DEST_MTY_LAND_DYS)), 2) DEST_MTY_LAND_DYS" ).append("\n"); 
		query.append("  FROM MAS_CNTR_PRECM_CALC" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND COST_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(@[f_cost_yrmon], 'YYYYMM'), -5), 'YYYYMM') AND @[f_cost_yrmon]" ).append("\n"); 
		query.append("  #if (${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    AND TPSZ_CD IN (" ).append("\n"); 
		query.append("        #if ($f_cntr_tpsz_cd.size() > 1 )" ).append("\n"); 
		query.append("          #foreach($key in ${f_cntr_tpsz_cd})" ).append("\n"); 
		query.append("            #if ($velocityCount < $f_cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_por} == 'RL')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(POR_CD,'RCC') = @[location_por]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_por} == 'LE')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(POR_CD,'LCC') = @[location_por]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_por} == 'ES')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(POR_CD,'ECC') = @[location_por]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_por} == 'CC')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(POR_CD,'SCC') LIKE @[location_por]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${location_by_del} == 'RL')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(DEL_CD,'RCC') = @[location_del]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_del} == 'LE')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(DEL_CD,'LCC') = @[location_del]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_del} == 'ES')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(DEL_CD,'ECC') = @[location_del]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_del} == 'CC')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(DEL_CD,'SCC') LIKE @[location_del]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  GROUP BY POR_CD" ).append("\n"); 
		query.append("          ,DEL_CD" ).append("\n"); 
		query.append("          ,TPSZ_CD" ).append("\n"); 
		query.append("  ORDER BY TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${code} == '1')" ).append("\n"); 
		query.append("  SELECT COST_YRMON" ).append("\n"); 
		query.append("        ,POR_CD" ).append("\n"); 
		query.append("        ,POL_CD" ).append("\n"); 
		query.append("        ,POD_CD" ).append("\n"); 
		query.append("        ,DEL_CD" ).append("\n"); 
		query.append("        ,TS_ROUT" ).append("\n"); 
		query.append("        ,TPSZ_CD" ).append("\n"); 
		query.append("        ,LANE_CD" ).append("\n"); 
		query.append("        ,SEA_DYS" ).append("\n"); 
		query.append("        ,ORG_RAIL_DYS" ).append("\n"); 
		query.append("      ,DEST_RAIL_DYS" ).append("\n"); 
		query.append("      ,FULL_DMT" ).append("\n"); 
		query.append("        ,ORG_MTY_LAND_DYS" ).append("\n"); 
		query.append("        ,DEST_MTY_LAND_DYS" ).append("\n"); 
		query.append("      ,MT_SEA_DYS" ).append("\n"); 
		query.append("	  ,MT_LAND" ).append("\n"); 
		query.append("	  ,DYS_DMT_EXPT_SEA" ).append("\n"); 
		query.append("  FROM MAS_CNTR_PRECM_CALC" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND COST_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(@[f_cost_yrmon], 'YYYYMM'), -5), 'YYYYMM') AND @[f_cost_yrmon]" ).append("\n"); 
		query.append("  #if (${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    AND TPSZ_CD IN (" ).append("\n"); 
		query.append("        #if ($f_cntr_tpsz_cd.size() > 1 )" ).append("\n"); 
		query.append("          #foreach($key in ${f_cntr_tpsz_cd})" ).append("\n"); 
		query.append("            #if ($velocityCount < $f_cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${f_lane_cd} != '')" ).append("\n"); 
		query.append("    AND LANE_CD = @[f_lane_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${f_eq_days} != '')" ).append("\n"); 
		query.append("    AND 1=1" ).append("\n"); 
		query.append("    #if (${f_eq_itm} == 'sea_dys')" ).append("\n"); 
		query.append("      AND SEA_DYS >= @[f_eq_days]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_eq_itm} == 'org_rail_dys')" ).append("\n"); 
		query.append("      AND ORG_RAIL_DYS >= @[f_eq_days]" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("    #if (${f_eq_itm} == 'dest_rail_dys')" ).append("\n"); 
		query.append("      AND DEST_RAIL_DYS >= @[f_eq_days]" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("    #if (${f_eq_itm} == 'full_dmt')" ).append("\n"); 
		query.append("      AND FULL_DMT >= @[f_eq_days]" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("    #if (${f_eq_itm} == 'org_mty_land_dys')" ).append("\n"); 
		query.append("      AND ORG_MTY_LAND_DYS >= @[f_eq_days]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_eq_itm} == 'dest_mty_land_dys')" ).append("\n"); 
		query.append("      AND DEST_MTY_LAND_DYS >= @[f_eq_days]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_eq_itm} == 'mt_sea_dys')" ).append("\n"); 
		query.append("      AND MT_SEA_DYS >= @[f_eq_days]" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_por} == 'RL')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(POR_CD,'RCC') = @[location_por]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_por} == 'LE')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(POR_CD,'LCC') = @[location_por]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_por} == 'ES')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(POR_CD,'ECC') = @[location_por]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_por} == 'CC')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(POR_CD,'SCC') LIKE @[location_por]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${location_by_del} == 'RL')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(DEL_CD,'RCC') = @[location_del]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_del} == 'LE')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(DEL_CD,'LCC') = @[location_del]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_del} == 'ES')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(DEL_CD,'ECC') = @[location_del]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${location_by_del} == 'CC')" ).append("\n"); 
		query.append("    AND MAS_LOC_FNC(DEL_CD,'SCC') LIKE @[location_del]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  ORDER BY TPSZ_CD" ).append("\n"); 
		query.append("		  ,COST_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}