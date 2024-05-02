/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchBFRExceptionByGenerationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchBFRExceptionByGenerationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBFRExceptionByGeneration
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchBFRExceptionByGenerationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("efft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchBFRExceptionByGenerationRSQL").append("\n"); 
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
		query.append("SELECT RFA_EXPT_APRO_NO 	APPR_NO" ).append("\n"); 
		query.append("      ,RFA_EXPT_DAR_NO 		DAR_NO" ).append("\n"); 
		query.append("	  ,RFA_EXPT_MAPG_SEQ	MAPG_SEQ" ).append("\n"); 
		query.append("	  ,RFA_EXPT_VER_SEQ		VER_SEQ	" ).append("\n"); 
		query.append("      ,RFA_RQST_DTL_SEQ 	DTL_SEQ" ).append("\n"); 
		query.append("	  ,CVRG_CMB_SEQ 		CMB_SEQ" ).append("\n"); 
		query.append("      ,FT_USE_FLG 			FTIME_MK" ).append("\n"); 
		query.append("      ,ADD_DYS 				ADD_DAY" ).append("\n"); 
		query.append("      ,TTL_DYS 				TTL_DAY" ).append("\n"); 
		query.append("      ,XCLD_SAT_FLG 		EXCL_SAT" ).append("\n"); 
		query.append("      ,XCLD_SUN_FLG 		EXCL_SUN" ).append("\n"); 
		query.append("      ,XCLD_HOL_FLG 		EXCL_HOLI" ).append("\n"); 
		query.append("      ,RT_USE_FLG 			RATE_MK" ).append("\n"); 
		query.append("      ,CURR_CD 				CUR_CD" ).append("\n"); 
		query.append("      ,NVL(FT_ADJ_FLG,'N')	FT_ADJ_MK /*2016.01.04 NYK Add*/" ).append("\n"); 
		query.append("  FROM (SELECT  /*+ USE_NL( P M D C ) NO_EXPAND  " ).append("\n"); 
		query.append("                 INDEX( P  XUK1PRI_RP_HDR )  " ).append("\n"); 
		query.append("                 INDEX( M  XAK1DMT_RFA_EXPT_TRF  )  " ).append("\n"); 
		query.append("                 INDEX( D  XAK1DMT_RFA_EXPT_TRF_DTL) " ).append("\n"); 
		query.append("                 INDEX( C  XPKDMT_RFA_EXPT_CVRG_CMB )*/ " ).append("\n"); 
		query.append("				M.RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append("                ,D.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("				,D.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("				,D.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                ,D.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("				,D.CVRG_CMB_SEQ" ).append("\n"); 
		query.append("                ,D.FT_USE_FLG" ).append("\n"); 
		query.append("                ,D.ADD_DYS" ).append("\n"); 
		query.append("                ,D.TTL_DYS" ).append("\n"); 
		query.append("                ,D.XCLD_SAT_FLG" ).append("\n"); 
		query.append("                ,D.XCLD_SUN_FLG" ).append("\n"); 
		query.append("                ,D.XCLD_HOL_FLG" ).append("\n"); 
		query.append("                ,D.RT_USE_FLG" ).append("\n"); 
		query.append("                ,D.CURR_CD" ).append("\n"); 
		query.append("                ,D.FT_ADJ_FLG /*2016.01.04 NYK Add*/" ).append("\n"); 
		query.append("            FROM DMT_RFA_EXPT_TRF_DTL 	D" ).append("\n"); 
		query.append("                ,DMT_RFA_EXPT_TRF 		M" ).append("\n"); 
		query.append("                ,DMT_RFA_EXPT_CVRG_CMB 	C" ).append("\n"); 
		query.append("				,PRI_RP_HDR				P" ).append("\n"); 
		query.append("           WHERE M.RFA_EXPT_DAR_NO 		= D.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(" 			 AND M.RFA_EXPT_MAPG_SEQ 	= D.RFA_EXPT_MAPG_SEQ          " ).append("\n"); 
		query.append("             AND M.RFA_EXPT_VER_SEQ 	= D.RFA_EXPT_VER_SEQ           " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("			 AND D.RFA_EXPT_DAR_NO 		= C.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("			 AND D.RFA_EXPT_MAPG_SEQ 	= C.RFA_EXPT_MAPG_SEQ          " ).append("\n"); 
		query.append("             AND D.RFA_EXPT_VER_SEQ 	= C.RFA_EXPT_VER_SEQ           " ).append("\n"); 
		query.append("             AND D.RFA_RQST_DTL_SEQ 	= C.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("			 AND D.CVRG_CMB_SEQ			= C.CVRG_CMB_SEQ" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("			 AND D.EFF_DT 				<= TO_DATE (@[efft_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("             AND D.EXP_DT 				>= TO_DATE (@[efft_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("             AND M.DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("             AND M.RFA_EXPT_APRO_NO IS NOT NULL" ).append("\n"); 
		query.append("			 AND M.PROP_NO 				= P.PROP_NO" ).append("\n"); 
		query.append("			 AND P.RFA_NO 				= @[rfa_no]" ).append("\n"); 
		query.append("             AND D.DMDT_TRF_CD 			= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("             AND D.DMDT_CNTR_TP_CD 		= @[cntr_tp]" ).append("\n"); 
		query.append("             AND D.DMDT_CGO_TP_CD 		= @[cgo_tp]" ).append("\n"); 
		query.append("             /*2016.01.04 NYK Add Start*/" ).append("\n"); 
		query.append("             AND (   (  NVL(D.CMDT_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("                   AND (D.RFA_EXPT_DAR_NO, D.RFA_EXPT_MAPG_SEQ, D.RFA_EXPT_VER_SEQ, D.RFA_RQST_DTL_SEQ) IN (" ).append("\n"); 
		query.append("                          SELECT CMDT.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                ,CMDT.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("                                ,CMDT.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                                ,CMDT.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("                                --,CMDT.CVRG_CMB_SEQ" ).append("\n"); 
		query.append("                            FROM DMT_RFA_EXPT_CMDT CMDT" ).append("\n"); 
		query.append("                           WHERE D.RFA_EXPT_DAR_NO 		= CMDT.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("                             AND D.RFA_EXPT_MAPG_SEQ 	= CMDT.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("                             AND D.RFA_EXPT_VER_SEQ 	= CMDT.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                             AND D.RFA_RQST_DTL_SEQ 	= CMDT.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("                             --AND D.CVRG_CMB_SEQ 		= CMDT.CVRG_CMB_SEQ" ).append("\n"); 
		query.append("                             AND CMDT.CMDT_CD 			= @[cmdt_cd])" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("               OR ( NVL(D.CMDT_FLG,'N') = 'N')" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("             /*2016.01.04 NYK Add E n d*/" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'I') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${dmdt_trf_cd} == 'DMIF') " ).append("\n"); 
		query.append("		   AND (   C.CVRG_CONTI_CD = NVL(@[yrd_conti_cd], ' ')     OR C.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.CVRG_CNT_CD = NVL(@[yrd_cnt_cd]    , ' ')     OR C.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.CVRG_RGN_CD = NVL(@[yrd_rgn_cd]    , ' ')     OR C.CVRG_RGN_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.CVRG_STE_CD = NVL(@[yrd_ste_cd]    , ' ')     OR C.CVRG_STE_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.CVRG_LOC_CD = NVL(@[yrd_loc_cd]    , ' ')     OR C.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_CONTI_CD = NVL(@[por_conti_cd] , ' ')   OR C.ORG_DEST_CONTI_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_CNT_CD = NVL(@[por_cnt_cd]     , ' ')   OR C.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_RGN_CD = NVL(@[por_rgn_cd]     , ' ')   OR C.ORG_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_STE_CD = NVL(@[por_ste_cd]     , ' ')   OR C.ORG_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_LOC_CD = NVL(@[por_loc_cd]     , ' ')   OR C.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           -- 2010-06-14 수정" ).append("\n"); 
		query.append("           AND (" ).append("\n"); 
		query.append("				( 	   ( D.FNL_DEST_FLG = 'Y'	AND	( D.FNL_DEST_CNT_CD = NVL(@[del_cnt_cd]     , ' ') OR D.FNL_DEST_CNT_CD   = ' '))" ).append("\n"); 
		query.append("				   AND ( D.FNL_DEST_FLG = 'Y'	AND	( D.FNL_DEST_RGN_CD = NVL(@[del_rgn_cd]     , ' ') OR D.FNL_DEST_RGN_CD   = ' '))" ).append("\n"); 
		query.append("				   AND ( D.FNL_DEST_FLG = 'Y'	AND	( D.FNL_DEST_STE_CD = NVL(@[del_ste_cd]     , ' ') OR D.FNL_DEST_STE_CD   = ' '))" ).append("\n"); 
		query.append("				   AND ( D.FNL_DEST_FLG = 'Y'	AND	( D.FNL_DEST_LOC_CD = NVL(@[del_loc_cd]     , ' ') OR D.FNL_DEST_LOC_CD   = ' '))" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				OR ( NVL(D.FNL_DEST_FLG,'N') = 'N')" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#elseif (${dmdt_trf_cd} == 'DTIC' || ${dmdt_trf_cd} == 'CTIC') " ).append("\n"); 
		query.append("		   AND (   C.CVRG_CONTI_CD = NVL(@[del_conti_cd] , ' ')   OR C.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.CVRG_CNT_CD = NVL(@[del_cnt_cd]     , ' ')   OR C.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.CVRG_RGN_CD = NVL(@[del_rgn_cd]     , ' ')   OR C.CVRG_RGN_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.CVRG_STE_CD = NVL(@[del_ste_cd]     , ' ')   OR C.CVRG_STE_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.CVRG_LOC_CD = NVL(@[del_loc_cd]     , ' ')   OR C.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_CONTI_CD = NVL(@[por_conti_cd] , ' ')   OR C.ORG_DEST_CONTI_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_CNT_CD = NVL(@[por_cnt_cd]     , ' ')   OR C.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_RGN_CD = NVL(@[por_rgn_cd]     , ' ')   OR C.ORG_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_STE_CD = NVL(@[por_ste_cd]     , ' ')   OR C.ORG_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("		   AND (   C.ORG_DEST_LOC_CD = NVL(@[por_loc_cd]     , ' ')   OR C.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${io_bnd_cd} == 'O')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 	#if (${dmdt_trf_cd} == 'DMOF') " ).append("\n"); 
		query.append("			AND (   C.CVRG_CONTI_CD = NVL(@[yrd_conti_cd] , ' ')   OR C.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.CVRG_CNT_CD = NVL(@[yrd_cnt_cd]     , ' ')   OR C.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.CVRG_RGN_CD = NVL(@[yrd_rgn_cd]     , ' ')   OR C.CVRG_RGN_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.CVRG_STE_CD = NVL(@[yrd_ste_cd]     , ' ')   OR C.CVRG_STE_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.CVRG_LOC_CD = NVL(@[yrd_loc_cd]     , ' ')   OR C.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_CONTI_CD = NVL(@[del_conti_cd] , ' ')   OR C.ORG_DEST_CONTI_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_CNT_CD = NVL(@[del_cnt_cd]     , ' ')   OR C.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_RGN_CD = NVL(@[del_rgn_cd]     , ' ')   OR C.ORG_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_STE_CD = NVL(@[del_ste_cd]     , ' ')   OR C.ORG_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_LOC_CD = NVL(@[del_loc_cd]     , ' ')   OR C.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			-- 2010-06-14 수정            " ).append("\n"); 
		query.append("            AND (" ).append("\n"); 
		query.append("				(     ( D.FNL_DEST_FLG = 'Y'	AND	( D.FNL_DEST_CNT_CD = NVL(@[por_cnt_cd]     , ' ') OR D.FNL_DEST_CNT_CD   = ' '))" ).append("\n"); 
		query.append("				  AND ( D.FNL_DEST_FLG = 'Y'	AND	( D.FNL_DEST_RGN_CD = NVL(@[por_rgn_cd]     , ' ') OR D.FNL_DEST_RGN_CD   = ' '))" ).append("\n"); 
		query.append("				  AND ( D.FNL_DEST_FLG = 'Y'	AND	( D.FNL_DEST_STE_CD = NVL(@[por_ste_cd]     , ' ') OR D.FNL_DEST_STE_CD   = ' '))" ).append("\n"); 
		query.append("				  AND ( D.FNL_DEST_FLG = 'Y'	AND	( D.FNL_DEST_LOC_CD = NVL(@[por_loc_cd]     , ' ') OR D.FNL_DEST_LOC_CD   = ' '))" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				OR ( NVL(D.FNL_DEST_FLG,'N') = 'N')" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#elseif (${dmdt_trf_cd} == 'DTOC' || ${dmdt_trf_cd} == 'CTOC') " ).append("\n"); 
		query.append("			AND (   C.CVRG_CONTI_CD = NVL(@[por_conti_cd] , ' ')    OR C.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.CVRG_CNT_CD = NVL(@[por_cnt_cd]     , ' ')    OR C.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.CVRG_RGN_CD = NVL(@[por_rgn_cd]     , ' ')    OR C.CVRG_RGN_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.CVRG_STE_CD = NVL(@[por_ste_cd]     , ' ')    OR C.CVRG_STE_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.CVRG_LOC_CD = NVL(@[por_loc_cd]     , ' ')    OR C.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_CONTI_CD = NVL(@[del_conti_cd] , ' ')   OR C.ORG_DEST_CONTI_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_CNT_CD = NVL(@[del_cnt_cd]     , ' ')   OR C.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_RGN_CD = NVL(@[del_rgn_cd]     , ' ')   OR C.ORG_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_STE_CD = NVL(@[del_ste_cd]     , ' ')   OR C.ORG_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("			AND (   C.ORG_DEST_LOC_CD = NVL(@[del_loc_cd]     , ' ')   OR C.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND		(" ).append("\n"); 
		query.append("						NVL(D.ACT_CUST_CNT_CD, ' ')	=	DECODE(D.ACT_CUST_CNT_CD, NULL, ' ', NVL(@[act_cust_cnt_cd], ' '))" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("            AND		(" ).append("\n"); 
		query.append("						NVL(D.ACT_CUST_SEQ, 0)	=	DECODE(D.ACT_CUST_SEQ, NULL, 0, NVL(@[act_cust_seq], 0))" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("        ORDER BY M.APRO_DT DESC" ).append("\n"); 
		query.append("                ,C.CVRG_CONTI_CD DESC" ).append("\n"); 
		query.append("                ,C.CVRG_CNT_CD DESC" ).append("\n"); 
		query.append("                ,C.CVRG_RGN_CD DESC" ).append("\n"); 
		query.append("                ,C.CVRG_LOC_CD DESC" ).append("\n"); 
		query.append("    ,DECODE (D.ACT_CUST_CNT_CD , NULL, 2 , 1) ASC" ).append("\n"); 
		query.append("    ,DECODE (D.ACT_CUST_SEQ , NULL, 2 , 1) ASC" ).append("\n"); 
		query.append("                ,C.ORG_DEST_CONTI_CD DESC" ).append("\n"); 
		query.append("                ,C.ORG_DEST_CNT_CD DESC" ).append("\n"); 
		query.append("                ,C.ORG_DEST_RGN_CD DESC" ).append("\n"); 
		query.append("                ,C.ORG_DEST_LOC_CD DESC" ).append("\n"); 
		query.append("    ,D.FNL_DEST_CONTI_CD DESC" ).append("\n"); 
		query.append("    ,D.FNL_DEST_CNT_CD DESC" ).append("\n"); 
		query.append("    ,D.FNL_DEST_RGN_CD DESC    " ).append("\n"); 
		query.append("    ,D.FNL_DEST_STE_CD DESC" ).append("\n"); 
		query.append("    ,D.FNL_DEST_LOC_CD DESC" ).append("\n"); 
		query.append("                ,DECODE (D.CMDT_FLG , 'Y', 1 , 2) ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 

	}
}