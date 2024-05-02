/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchMultiDimensionOfcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchMultiDimensionOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PFMC by Office
	  * 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchMultiDimensionOfcListRSQL(){
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
		params.put("f_chkprd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_shipper",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usa_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vvd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("f_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vvd2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchMultiDimensionOfcListRSQL").append("\n"); 
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
		query.append("#if(${f_sch_mode} =='3')" ).append("\n"); 
		query.append("	 BKG_NO" ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#elseif (${f_sch_mode} =='2' || ${f_sch_mode} =='4')" ).append("\n"); 
		query.append("	 RLANE_CD" ).append("\n"); 
		query.append("	,DIR_CD" ).append("\n"); 
		query.append("	,POL" ).append("\n"); 
		query.append("	,POD" ).append("\n"); 
		query.append("	,POR" ).append("\n"); 
		query.append("	,DEL" ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 TRD_CD" ).append("\n"); 
		query.append("	,DIR_CD" ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,SUM(BKG_QTY) BKG_QTY" ).append("\n"); 
		query.append("  ,SUM(REV) REV" ).append("\n"); 
		query.append("  ,SUM(COST) COST" ).append("\n"); 
		query.append("  ,SUM(REV - COST) CM" ).append("\n"); 
		query.append("  ,SUM(REPO_COST_AMT) REPO_COST_AMT" ).append("\n"); 
		query.append("  ,SUM(REV - COST - REPO_COST_AMT) SAVE" ).append("\n"); 
		query.append("  ,SUM((REV - COST- REPO_COST_AMT)*EQ_REPO_CR_RTO) CR_AMT" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("       A3.TRD_CD" ).append("\n"); 
		query.append("      ,A3.RLANE_CD" ).append("\n"); 
		query.append("      ,A3.DIR_CD" ).append("\n"); 
		query.append("      ,A3.BKG_NO" ).append("\n"); 
		query.append("      ,A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,A3.REV_POL_CD POL" ).append("\n"); 
		query.append("      ,A3.REV_POD_CD POD" ).append("\n"); 
		query.append("      ,A3.BKG_POR_CD POR" ).append("\n"); 
		query.append("      ,A3.BKG_DEL_CD DEL" ).append("\n"); 
		query.append("      ,B2.COST_ROUT_NO" ).append("\n"); 
		query.append("      ,SUM(A1.PERF_COST_AMT) COST" ).append("\n"); 
		query.append("      ,SUM(-1 * NVL(A1.REPO_COST_AMT, 0)) REPO_COST_AMT" ).append("\n"); 
		query.append("      ,MAX(NVL(A1.EQ_REPO_CR_RTO, 0)) EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("      ,MAX(NVL(B2.BKG_REV, 0) + NVL(B2.BKG_OFT_REV, 0) + NVL(B2.BKG_MISC_REV, 0) + NVL(B2.SCR_CHG_REV, 0)) REV" ).append("\n"); 
		query.append("      ,MAX(B2.BKG_QTY) BKG_QTY" ).append("\n"); 
		query.append("    FROM MAS_MON_VVD A4" ).append("\n"); 
		query.append("		,MAS_RGST_BKG A3" ).append("\n"); 
		query.append("		,MAS_OFC_LVL A6" ).append("\n"); 
		query.append("		,MAS_CNTR_REPO_IDX_ITM A1" ).append("\n"); 
		query.append("		,MAS_BKG_REV_DTL B2" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("		  AND A4.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("	  #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("		  AND A4.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("	    AND A4.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("  		AND  A4.TRD_CD = @[f_trd_cd]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("  		AND  A4.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("  		AND  A4.DIR_CD = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_vvd1} !='')" ).append("\n"); 
		query.append("  		AND  A4.VSL_CD = @[f_vvd1]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_vvd2} !='')" ).append("\n"); 
		query.append("  		AND  A4.SKD_VOY_NO = @[f_vvd2]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_vvd3} !='')" ).append("\n"); 
		query.append("  		AND  A4.DIR_CD = @[f_vvd3]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_usa_mode} !='')" ).append("\n"); 
		query.append("  		AND  A3.USA_BKG_MOD_CD = @[f_usa_mode]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_r_cmdt} !='')" ).append("\n"); 
		query.append("  		AND  A3.REP_CMDT_CD = @[f_r_cmdt]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_shipper} !='')" ).append("\n"); 
		query.append("  		AND A3.SHPR_CNT_CD = SUBSTR(@[f_shipper],1,2) AND A3.SHPR_CUST_SEQ = SUBSTR(@[f_shipper],3)" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_sc} !='')" ).append("\n"); 
		query.append("  		AND  A3.SC_NO = @[f_sc]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_rfa} !='')" ).append("\n"); 
		query.append("  		AND A3.RFA_NO = @[f_rfa]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	#if(${f_cntr_tpsz_cd} !='')" ).append("\n"); 
		query.append("  		AND  A1.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("  	" ).append("\n"); 
		query.append("  	  AND A3.SLS_OFC_CD = A6.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#if(${f_sls_ofc_cd} !='')" ).append("\n"); 
		query.append("  		AND DECODE(@[f_rhq_cd], '1', A6.OFC_N1ST_LVL_CD, '2', A6.OFC_N2ND_LVL_CD, '3', A6.OFC_N3RD_LVL_CD, '4', A6.OFC_N4TH_LVL_CD, '5', A6.OFC_N5TH_LVL_CD, '6', A6.OFC_N6TH_LVL_CD, '7', A6.OFC_N7TH_LVL_CD) = @[f_sls_ofc_cd]" ).append("\n"); 
		query.append("  	#else" ).append("\n"); 
		query.append("  		AND DECODE(@[f_rhq_cd], '1', A6.OFC_N1ST_LVL_CD, '2', A6.OFC_N2ND_LVL_CD, '3', A6.OFC_N3RD_LVL_CD, '4', A6.OFC_N4TH_LVL_CD, '5', A6.OFC_N5TH_LVL_CD, '6', A6.OFC_N6TH_LVL_CD, '7', A6.OFC_N7TH_LVL_CD) IS NOT NULL" ).append("\n"); 
		query.append("  	    AND DECODE(@[f_rhq_cd], '1', A6.OFC_N1ST_LVL_CD, '2', A6.OFC_N2ND_LVL_TP_CD, '3', A6.OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("  	                , '4', DECODE(SUBSTR(DECODE(@[f_chkprd], 'M', A4.COST_YRMON, A4.SLS_YRMON), 1, 4)" ).append("\n"); 
		query.append("  								, '2008', DECODE(A6.OFC_N4TH_LVL_CD, 'NYCRA', A6.OFC_N4TH_LVL_CD, A6.OFC_N4TH_LVL_TP_CD)" ).append("\n"); 
		query.append("  								, '2007', DECODE(A6.OFC_N4TH_LVL_CD, 'NYCRA', A6.OFC_N4TH_LVL_CD, A6.OFC_N4TH_LVL_TP_CD)" ).append("\n"); 
		query.append("  								, DECODE(A6.OFC_N4TH_LVL_CD, 'SZPDC', A6.OFC_N4TH_LVL_TP_CD, A6.OFC_N4TH_LVL_CD)) " ).append("\n"); 
		query.append("  	                , '5', A6.OFC_N5TH_LVL_TP_CD, '6', A6.OFC_N6TH_LVL_TP_CD,'7', A6.OFC_N7TH_LVL_TP_CD) IS NOT NULL" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A4.DELT_FLG  <> 'Y'" ).append("\n"); 
		query.append("       AND A3.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("       AND A3.RLANE_CD     = A4.RLANE_CD" ).append("\n"); 
		query.append("       AND A3.IOC_CD       = A4.IOC_CD" ).append("\n"); 
		query.append("       AND A3.VSL_CD       = A4.VSL_CD" ).append("\n"); 
		query.append("       AND A3.SKD_VOY_NO   = A4.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A3.DIR_CD       = A4.DIR_CD" ).append("\n"); 
		query.append("       AND A3.BKG_NO       = A1.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("  		AND A4.COST_YRMON BETWEEN A6.OFC_APLY_FM_YRMON AND A6.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  	#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("  		AND A4.SLS_YRMON  BETWEEN A6.OFC_APLY_FM_YRMON AND A6.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  	#end  " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND A3.BL_NO_TP IN ('M','0')" ).append("\n"); 
		query.append("       AND A3.BKG_STS_CD IN ('F','S')" ).append("\n"); 
		query.append("       AND A3.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("    #if(${f_sch_mode} =='3' || ${f_sch_mode} =='4')" ).append("\n"); 
		query.append("    	#if(${f_pol} !='')	" ).append("\n"); 
		query.append("    		AND A3.REV_POL_CD = @[f_pol]" ).append("\n"); 
		query.append("    	#end	" ).append("\n"); 
		query.append("    	#if(${f_pod} !='')	" ).append("\n"); 
		query.append("    		AND A3.REV_POD_CD = @[f_pod] " ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if(${f_por} !='')	" ).append("\n"); 
		query.append("    		AND A3.BKG_POR_CD = @[f_por]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if(${f_del} !='')	" ).append("\n"); 
		query.append("    		AND A3.BKG_DEL_CD = @[f_del]" ).append("\n"); 
		query.append("    	#end		" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("       AND A1.BKG_NO       = B2.BKG_NO" ).append("\n"); 
		query.append("       AND A1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       AND A1.COST_ROUT_NO = B2.COST_ROUT_NO" ).append("\n"); 
		query.append("       AND B2.BKG_QTY <> 0" ).append("\n"); 
		query.append("   GROUP BY A3.TRD_CD" ).append("\n"); 
		query.append("           ,A3.RLANE_CD" ).append("\n"); 
		query.append("           ,A3.DIR_CD" ).append("\n"); 
		query.append("           ,A3.BKG_NO" ).append("\n"); 
		query.append("           ,A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           ,A3.REV_POL_CD" ).append("\n"); 
		query.append("           ,A3.REV_POD_CD" ).append("\n"); 
		query.append("           ,A3.BKG_POR_CD" ).append("\n"); 
		query.append("           ,A3.BKG_DEL_CD" ).append("\n"); 
		query.append("           ,B2.COST_ROUT_NO" ).append("\n"); 
		query.append("   ) " ).append("\n"); 
		query.append("#if(${f_sch_mode} =='3')" ).append("\n"); 
		query.append("	GROUP BY BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  ORDER BY BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#elseif (${f_sch_mode} =='2' || ${f_sch_mode} =='4')	" ).append("\n"); 
		query.append("	GROUP BY RLANE_CD,DIR_CD" ).append("\n"); 
		query.append("		, POL" ).append("\n"); 
		query.append("		, POD" ).append("\n"); 
		query.append("		, POR" ).append("\n"); 
		query.append("		, DEL" ).append("\n"); 
		query.append("		,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("	ORDER BY RLANE_CD" ).append("\n"); 
		query.append("		,DIR_CD" ).append("\n"); 
		query.append("		, POL" ).append("\n"); 
		query.append("		, POD" ).append("\n"); 
		query.append("		, POR" ).append("\n"); 
		query.append("		, DEL" ).append("\n"); 
		query.append("		,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	GROUP BY TRD_CD" ).append("\n"); 
		query.append("		, DIR_CD" ).append("\n"); 
		query.append("		, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	ORDER BY TRD_CD" ).append("\n"); 
		query.append("		, DIR_CD" ).append("\n"); 
		query.append("		, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}