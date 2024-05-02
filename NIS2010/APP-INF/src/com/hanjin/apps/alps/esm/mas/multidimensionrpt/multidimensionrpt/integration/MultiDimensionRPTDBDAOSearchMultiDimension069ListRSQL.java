/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchMultiDimension069ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2010.03.25 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki-Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchMultiDimension069ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Minimum G.RPB
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchMultiDimension069ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_por",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cmdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usa_mode",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_r_cmdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchMultiDimension069ListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  POR" ).append("\n"); 
		query.append("  ,DEL" ).append("\n"); 
		query.append("  ,RLANE_CD" ).append("\n"); 
		query.append("  ,DIR_CD" ).append("\n"); 
		query.append("  ,POL" ).append("\n"); 
		query.append("  ,POD" ).append("\n"); 
		query.append("  ,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("  ,SUM(BKG_QTY) BKG_QTY " ).append("\n"); 
		query.append("  ,SUM(REV) REV " ).append("\n"); 
		query.append("  ,SUM(COST) COST " ).append("\n"); 
		query.append("  ,SUM(REV - COST) CM " ).append("\n"); 
		query.append("  ,SUM(REPO_COST_AMT) REPO_COST_AMT " ).append("\n"); 
		query.append("  ,SUM(REV - COST - REPO_COST_AMT) SAVE " ).append("\n"); 
		query.append("  ,SUM((REV - COST- REPO_COST_AMT)*EQ_REPO_CR_RTO) CR_AMT " ).append("\n"); 
		query.append("FROM (SELECT /*+ ORDERED INDEX(A4 XAK1MAS_MON_VVD) */  " ).append("\n"); 
		query.append("         A3.TRD_CD " ).append("\n"); 
		query.append("        ,A3.RLANE_CD " ).append("\n"); 
		query.append("        ,A3.DIR_CD " ).append("\n"); 
		query.append("        ,A3.BKG_NO " ).append("\n"); 
		query.append("        ,A1.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("        ,A3.REV_POL_CD POL " ).append("\n"); 
		query.append("        ,A3.REV_POD_CD POD " ).append("\n"); 
		query.append("        ,A3.BKG_POR_CD POR " ).append("\n"); 
		query.append("        ,A3.BKG_DEL_CD DEL " ).append("\n"); 
		query.append("        ,B2.COST_ROUT_NO " ).append("\n"); 
		query.append("        ,SUM(A1.PERF_COST_AMT) COST " ).append("\n"); 
		query.append("        ,SUM(-1 * NVL(A1.REPO_COST_AMT, 0)) REPO_COST_AMT " ).append("\n"); 
		query.append("        ,MAX(NVL(A1.EQ_REPO_CR_RTO, 0)) EQ_REPO_CR_RTO " ).append("\n"); 
		query.append("        ,MAX(NVL(B2.BKG_REV, 0) + NVL(B2.BKG_OFT_REV, 0) + NVL(B2.BKG_MISC_REV, 0) + NVL(B2.SCR_CHG_REV, 0)) REV " ).append("\n"); 
		query.append("        ,MAX(B2.BKG_QTY) BKG_QTY " ).append("\n"); 
		query.append("    FROM MAS_MON_VVD A4" ).append("\n"); 
		query.append("		,MAS_RGST_BKG A3" ).append("\n"); 
		query.append("		,MAS_BKG_REV_DTL B2" ).append("\n"); 
		query.append("		,MAS_CNTR_REPO_IDX_ITM A1		 " ).append("\n"); 
		query.append("    WHERE 1 = 1 " ).append("\n"); 
		query.append("      AND A4.COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if(${f_usa_mode} !='')" ).append("\n"); 
		query.append("        AND A3.USA_BKG_MOD_CD = @[f_usa_mode] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			#if(${f_r_cmdt} !='')" ).append("\n"); 
		query.append("        AND  A3.REP_CMDT_CD = @[f_r_cmdt] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			#if(${f_cntr_tpsz_cd} !='')" ).append("\n"); 
		query.append("        AND A1.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      AND A4.DELT_FLG     NOT IN ('Y') " ).append("\n"); 
		query.append("      AND A3.TRD_CD       = A4.TRD_CD " ).append("\n"); 
		query.append("      AND A3.RLANE_CD     = A4.RLANE_CD " ).append("\n"); 
		query.append("      AND A3.IOC_CD       = A4.IOC_CD " ).append("\n"); 
		query.append("      AND A3.VSL_CD       = A4.VSL_CD " ).append("\n"); 
		query.append("      AND A3.SKD_VOY_NO   = A4.SKD_VOY_NO " ).append("\n"); 
		query.append("      AND A3.DIR_CD       = A4.DIR_CD " ).append("\n"); 
		query.append("      AND A3.BL_NO_TP IN ('M','0')  " ).append("\n"); 
		query.append("      AND A3.BKG_STS_CD IN ('F','S')  " ).append("\n"); 
		query.append("      AND A3.BKG_CGO_TP_CD NOT IN ('P')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  AND A3.BKG_NO       = B2.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if(${f_por} !='')" ).append("\n"); 
		query.append("        AND A3.BKG_POR_CD = @[f_por] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			#if(${f_del} !='')" ).append("\n"); 
		query.append("        AND A3.BKG_DEL_CD = @[f_del] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			#if(${f_pol} !='')" ).append("\n"); 
		query.append("        AND A3.REV_POL_CD = @[f_pol] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			#if(${f_pod} !='')" ).append("\n"); 
		query.append("        AND A3.REV_POD_CD = @[f_pod] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			#if(${f_cmdt} !='')" ).append("\n"); 
		query.append("        AND A3.CMDT_CD = @[f_cmdt]  " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND A1.BKG_NO       = B2.BKG_NO " ).append("\n"); 
		query.append("      AND A1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      AND A1.COST_ROUT_NO = B2.COST_ROUT_NO " ).append("\n"); 
		query.append("      AND B2.BKG_QTY NOT IN (0)  " ).append("\n"); 
		query.append("    GROUP BY A3.TRD_CD " ).append("\n"); 
		query.append("      ,A3.RLANE_CD " ).append("\n"); 
		query.append("      ,A3.DIR_CD " ).append("\n"); 
		query.append("      ,A3.BKG_NO " ).append("\n"); 
		query.append("      ,A1.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      ,A3.REV_POL_CD  " ).append("\n"); 
		query.append("      ,A3.REV_POD_CD  " ).append("\n"); 
		query.append("      ,A3.BKG_POR_CD  " ).append("\n"); 
		query.append("      ,A3.BKG_DEL_CD  " ).append("\n"); 
		query.append("      ,B2.COST_ROUT_NO " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("GROUP BY RLANE_CD" ).append("\n"); 
		query.append("	,DIR_CD" ).append("\n"); 
		query.append("	, POL" ).append("\n"); 
		query.append("	, POD" ).append("\n"); 
		query.append("	, POR" ).append("\n"); 
		query.append("	, DEL" ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("ORDER BY RLANE_CD,DIR_CD" ).append("\n"); 
		query.append("	, POL" ).append("\n"); 
		query.append("	, POD" ).append("\n"); 
		query.append("	, POR" ).append("\n"); 
		query.append("	, DEL" ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD" ).append("\n"); 

	}
}