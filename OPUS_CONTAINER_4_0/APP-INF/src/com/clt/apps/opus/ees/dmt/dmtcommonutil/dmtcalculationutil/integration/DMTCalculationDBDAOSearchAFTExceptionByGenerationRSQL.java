/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchAFTExceptionByGenerationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.02.26 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchAFTExceptionByGenerationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAFTExceptionByGeneration
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchAFTExceptionByGenerationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtt_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchAFTExceptionByGenerationRSQL").append("\n"); 
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
		query.append("SELECT  APPR_NO" ).append("\n"); 
		query.append("       ,DAR_NO" ).append("\n"); 
		query.append("       ,ADJ_SEQ" ).append("\n"); 
		query.append("       ,FTIME_MK" ).append("\n"); 
		query.append("       ,ADD_DAY" ).append("\n"); 
		query.append("       ,TTL_DAY" ).append("\n"); 
		query.append("       ,EXCL_SAT" ).append("\n"); 
		query.append("       ,EXCL_SUN" ).append("\n"); 
		query.append("       ,EXCL_HOLI" ).append("\n"); 
		query.append("       ,DC_MK" ).append("\n"); 
		query.append("       ,CUR_CD" ).append("\n"); 
		query.append("       ,DC_AMT" ).append("\n"); 
		query.append("       ,DC_RATE" ).append("\n"); 
		query.append("FROM (            " ).append("\n"); 
		query.append("        SELECT    /*+ ORDERED USE_NL( D M )" ).append("\n"); 
		query.append("					  INDEX( D XAK1DMT_AFT_BKG_ADJ_RQST_DTL ) " ).append("\n"); 
		query.append("      				  INDEX( M XPKDMT_AFT_BKG_ADJ_RQST )  */	" ).append("\n"); 
		query.append("               M.AFT_BKG_APRO_NO AS APPR_NO" ).append("\n"); 
		query.append("              ,D.AFT_EXPT_DAR_NO AS DAR_NO" ).append("\n"); 
		query.append("              ,D.AFT_EXPT_ADJ_SEQ AS ADJ_SEQ" ).append("\n"); 
		query.append("              ,D.FT_ADJ_FLG AS FTIME_MK" ).append("\n"); 
		query.append("              ,D.FT_ADD_DYS AS ADD_DAY" ).append("\n"); 
		query.append("              ,D.FT_TTL_DYS AS TTL_DAY" ).append("\n"); 
		query.append("              ,D.XCLD_SAT_FLG AS EXCL_SAT" ).append("\n"); 
		query.append("              ,D.XCLD_SUN_FLG AS EXCL_SUN" ).append("\n"); 
		query.append("              ,D.XCLD_HOL_FLG AS EXCL_HOLI" ).append("\n"); 
		query.append("              ,D.DC_FLG AS DC_MK" ).append("\n"); 
		query.append("              ,D.CURR_CD AS CUR_CD" ).append("\n"); 
		query.append("              ,D.DC_AMT AS DC_AMT" ).append("\n"); 
		query.append("              ,D.DC_RTO AS DC_RATE  " ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_ADJ_RQST_DTL D" ).append("\n"); 
		query.append("              ,DMT_AFT_BKG_ADJ_RQST M" ).append("\n"); 
		query.append("         WHERE M.AFT_EXPT_DAR_NO = D.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND M.DMDT_EXPT_RQST_STS_CD = 'A'   " ).append("\n"); 
		query.append("           AND D.DMDT_TRF_CD = @[dtt_code]" ).append("\n"); 
		query.append("           AND D.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("           AND D.EACH_CNTR_FLG = 'N'   " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT /*+ ORDERED USE_NL( D M C)" ).append("\n"); 
		query.append("				   INDEX( D XAK1DMT_AFT_BKG_ADJ_RQST_DTL )" ).append("\n"); 
		query.append("    			   INDEX( M XPKDMT_AFT_BKG_ADJ_RQST )" ).append("\n"); 
		query.append("                   INDEX( C XAK1DMT_AFT_BKG_CNTR)  " ).append("\n"); 
		query.append("			   	   */" ).append("\n"); 
		query.append("               M.AFT_BKG_APRO_NO AS APPR_NO" ).append("\n"); 
		query.append("              ,D.AFT_EXPT_DAR_NO AS DAR_NO" ).append("\n"); 
		query.append("              ,D.AFT_EXPT_ADJ_SEQ AS ADJ_SEQ" ).append("\n"); 
		query.append("              ,C.FT_ADJ_FLG AS FTIME_MK" ).append("\n"); 
		query.append("              ,C.FT_ADD_DYS AS ADD_DAY" ).append("\n"); 
		query.append("              ,C.FT_TTL_DYS AS TTL_DAY" ).append("\n"); 
		query.append("              ,C.XCLD_SAT_FLG AS EXCL_SAT" ).append("\n"); 
		query.append("              ,C.XCLD_SUN_FLG AS EXCL_SUN" ).append("\n"); 
		query.append("              ,C.XCLD_HOL_FLG AS EXCL_HOLI" ).append("\n"); 
		query.append("			  ,CASE" ).append("\n"); 
		query.append("    				WHEN    C.CNTR_CHG_DC_AMT > 0 THEN" ).append("\n"); 
		query.append("        				'Y'" ).append("\n"); 
		query.append("    				WHEN   C.CNTR_CHG_DC_RTO <> 0 THEN" ).append("\n"); 
		query.append("        				'Y'" ).append("\n"); 
		query.append("    				ELSE" ).append("\n"); 
		query.append("        				'N'" ).append("\n"); 
		query.append("				END   AS DC_MK" ).append("\n"); 
		query.append("              ,D.CURR_CD AS CUR_CD" ).append("\n"); 
		query.append("              ,C.CNTR_CHG_DC_AMT AS DC_AMT" ).append("\n"); 
		query.append("              ,C.CNTR_CHG_DC_RTO AS DC_RATE " ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_ADJ_RQST_DTL D" ).append("\n"); 
		query.append("              ,DMT_AFT_BKG_ADJ_RQST M" ).append("\n"); 
		query.append("              ,DMT_AFT_BKG_CNTR C" ).append("\n"); 
		query.append("         WHERE M.AFT_EXPT_DAR_NO = D.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND M.DMDT_EXPT_RQST_STS_CD = 'A'   " ).append("\n"); 
		query.append("           AND D.DMDT_TRF_CD = @[dtt_code]" ).append("\n"); 
		query.append("           AND D.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("           AND D.EACH_CNTR_FLG = 'Y'   " ).append("\n"); 
		query.append("           AND D.AFT_EXPT_DAR_NO = C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND D.AFT_EXPT_ADJ_SEQ = C.AFT_EXPT_ADJ_SEQ           " ).append("\n"); 
		query.append("           AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND C.CNTR_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("           AND C.DMDT_TRF_CD = @[dtt_code]" ).append("\n"); 
		query.append("           AND C.DMDT_CHG_LOC_DIV_CD = @[loc_div]" ).append("\n"); 
		query.append("           AND C.CHG_SEQ = 1" ).append("\n"); 
		query.append("           AND (C.CNTR_CHG_DC_AMT IS NOT NULL " ).append("\n"); 
		query.append("                OR C.CNTR_CHG_DC_RTO IS NOT NULL " ).append("\n"); 
		query.append("                OR C.FT_ADD_DYS IS NOT NULL " ).append("\n"); 
		query.append("                OR C.FT_TTL_DYS IS NOT NULL " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}