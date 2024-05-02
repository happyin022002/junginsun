/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchRsltSmryCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.09.03 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchRsltSmryCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GEM_RSLT_SMRY중복체크
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchRsltSmryCheckRSQL(){
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
		params.put("sub_gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_co_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchRsltSmryCheckRSQL").append("\n"); 
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
		query.append("SELECT RSLT_YRMON" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",SUB_OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",SUB_GEN_EXPN_CD" ).append("\n"); 
		query.append(",OFC_CO_DIV_CD" ).append("\n"); 
		query.append("FROM   GEM_RSLT_SMRY" ).append("\n"); 
		query.append("WHERE  RSLT_YRMON			= SUBSTR(@[rslt_yrmon],1,6)" ).append("\n"); 
		query.append("AND    OFC_CD               = @[ofc_cd]" ).append("\n"); 
		query.append("AND    SUB_OFC_CD           = @[sub_ofc_cd]" ).append("\n"); 
		query.append("AND    GEN_EXPN_CD          = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND    SUB_GEN_EXPN_CD      = @[sub_gen_expn_cd]" ).append("\n"); 
		query.append("AND    OFC_CO_DIV_CD        = @[ofc_co_div_cd]" ).append("\n"); 

	}
}