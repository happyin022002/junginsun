/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMCommonDBDAOSearchSumGenExpnAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.01.19 진윤오
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

public class GEMCommonDBDAOSearchSumGenExpnAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당월까지 예산비용 합계
	  * </pre>
	  */
	public GEMCommonDBDAOSearchSumGenExpnAmtRSQL(){
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
		params.put("rslt_rymon_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_rymon_end",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemcommon.integration").append("\n"); 
		query.append("FileName : GEMCommonDBDAOSearchSumGenExpnAmtRSQL").append("\n"); 
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
		query.append("    MAX(OFC_CD) OFC_CD" ).append("\n"); 
		query.append("  , MAX(GEN_EXPN_CD) GEN_EXPN_CD" ).append("\n"); 
		query.append("  , SUM (GEN_EXPN_INIT_AMT + GEN_EXPN_ADD_AMT + GEN_EXPN_TRNS_AMT) SUM_GEN_EXPN_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    GEM_RSLT_SMRY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    RSLT_YRMON BETWEEN @[rslt_rymon_start] AND @[rslt_rymon_end]" ).append("\n"); 
		query.append("    AND OFC_CD IN (${ofc_cd})" ).append("\n"); 
		query.append("    AND GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 

	}
}