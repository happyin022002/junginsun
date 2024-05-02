/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMCommonDBDAOSearchSlipPerfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.11 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMCommonDBDAOSearchSlipPerfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당월의 전표실적을 가져온다.
	  * </pre>
	  */
	public GEMCommonDBDAOSearchSlipPerfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemcommon.integration").append("\n"); 
		query.append("FileName : GEMCommonDBDAOSearchSlipPerfRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    SLP_TJ_NO" ).append("\n"); 
		query.append("  , SLP_SEQ_NO" ).append("\n"); 
		query.append("  , RSLT_YRMON" ).append("\n"); 
		query.append("  , OFC_CD" ).append("\n"); 
		query.append("  , (SELECT MAX(LOCL_CURR_CD) FROM GEM_OFFICE WHERE OFC_CD = GEM_SLP_PERF.OFC_CD ) OFC_CURR_CD" ).append("\n"); 
		query.append("  , SUB_OFC_CD" ).append("\n"); 
		query.append("  , GEN_EXPN_CD" ).append("\n"); 
		query.append("  , SUB_GEN_EXPN_CD" ).append("\n"); 
		query.append("  , ACCT_CD" ).append("\n"); 
		query.append("  , SLP_CTR_CD" ).append("\n"); 
		query.append("  , SLP_CURR_CD" ).append("\n"); 
		query.append("  , SLP_AMT" ).append("\n"); 
		query.append("  , SLP_VNDR_CD" ).append("\n"); 
		query.append("  , GL_EFF_DT" ).append("\n"); 
		query.append("  , GEN_EXPN_FNL_LOCL_AMT" ).append("\n"); 
		query.append("  , SLP_PERF_AMT" ).append("\n"); 
		query.append("  , SLP_DESC" ).append("\n"); 
		query.append("  , PRPR_USR_ID" ).append("\n"); 
		query.append("  , APRO_USR_ID" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    GEM_SLP_PERF" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    RSLT_YRMON      = @[rslt_yrmon]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("    AND OFC_CD      = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gen_expn_cd} != '') " ).append("\n"); 
		query.append("    AND GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("    CRE_DT" ).append("\n"); 
		query.append("  , SLP_TJ_NO" ).append("\n"); 
		query.append("  , SLP_SEQ_NO" ).append("\n"); 

	}
}