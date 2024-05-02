/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAOSearchEstimatedProResultListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOEstimatedDBDAOSearchEstimatedProResultListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GL_ESTM_IF_ERP Pro Search
	  * </pre>
	  */
	public TCharterIOEstimatedDBDAOSearchEstimatedProResultListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
		query.append("FileName : TCharterIOEstimatedDBDAOSearchEstimatedProResultListRSQL").append("\n"); 
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
		query.append("SELECT 'R' AS IBFLAG" ).append("\n"); 
		query.append("     , G.EXE_YRMON" ).append("\n"); 
		query.append("     , G.REV_YRMON" ).append("\n"); 
		query.append("     , G.REV_YRMON||DECODE(G.ACCT_CD, '411211', 'TO', '510911','TI') AS SUBSUMCOL" ).append("\n"); 
		query.append("     , DECODE(G.ACCT_CD, '411211', 'TO', '510911','TI') AS FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , V.RLANE_CD AS RLANE_CD" ).append("\n"); 
		query.append("     , G.VSL_CD||G.SKD_VOY_NO||G.SKD_DIR_CD||G.REV_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("     , G.VSL_CD" ).append("\n"); 
		query.append("     , G.SKD_VOY_NO" ).append("\n"); 
		query.append("     , G.SKD_DIR_CD" ).append("\n"); 
		query.append("     , G.REV_DIR_CD" ).append("\n"); 
		query.append("     , V.VST_DT" ).append("\n"); 
		query.append("     , V.VED_DT" ).append("\n"); 
		query.append("     , G.HIR_DT_AMT AS HIRE_AMT" ).append("\n"); 
		query.append("     , G.ESTM_AMT AS EST_AMT" ).append("\n"); 
		query.append("     , G.ACT_AMT AS EST_AMT" ).append("\n"); 
		query.append("     , G.ACCL_AMT AS ACC_AMT" ).append("\n"); 
		query.append("     , G.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("  FROM GL_ESTM_IF_ERP G" ).append("\n"); 
		query.append("     , FMS_VVD V" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND G.SYS_SRC_ID = 'CDA'" ).append("\n"); 
		query.append("   AND G.EXE_YRMON = REPLACE(@[exe_yrmon],'-')" ).append("\n"); 
		query.append("   AND G.REV_YRMON BETWEEN REPLACE(@[fr_duration],'-') AND REPLACE(@[to_duration],'-')" ).append("\n"); 
		query.append("   AND G.ESTM_VVD_TP_CD = 'PV'" ).append("\n"); 
		query.append("   AND G.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("   AND G.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND G.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND G.REV_DIR_CD = V.REV_DIR_CD" ).append("\n"); 
		query.append("   AND G.REV_YRMON = V.REV_YRMON" ).append("\n"); 

	}
}