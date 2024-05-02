/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAOSearchEstimatedRevenueCListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOEstimatedDBDAOSearchEstimatedRevenueCListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEstimatedRevenueCListVO
	  * </pre>
	  */
	public TCharterIOEstimatedDBDAOSearchEstimatedRevenueCListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_duration",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
		query.append("FileName : TCharterIOEstimatedDBDAOSearchEstimatedRevenueCListVORSQL").append("\n"); 
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
		query.append("SELECT P.REV_YRMON," ).append("\n"); 
		query.append("  DECODE(P.ACCT_CD, '510911', 'TI', 'TO') FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("  V.RLANE_CD," ).append("\n"); 
		query.append("  P.VSL_CD||P.SKD_VOY_NO||P.SKD_DIR_CD||P.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("  P.HIR_DT_AMT AS HIRE_AMT," ).append("\n"); 
		query.append("  V.VST_DT," ).append("\n"); 
		query.append("  V.VED_DT," ).append("\n"); 
		query.append("  P.VVD_DUR_NO," ).append("\n"); 
		query.append("  P.ESTM_AMT AS EST_AMT," ).append("\n"); 
		query.append("  P.ACT_AMT AS ACT_AMT," ).append("\n"); 
		query.append("  P.ACCL_AMT AS ACC_AMT," ).append("\n"); 
		query.append("  P.ACCL_AMT AS ACC_OLD_AMT," ).append("\n"); 
		query.append("  P.FLET_ACCL_AMT AS FLET_ACCL_AMT" ).append("\n"); 
		query.append(",P.FLET_ACCL_AMT as ACC_OLD_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP P," ).append("\n"); 
		query.append("  FMS_VVD V" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("  AND P.EXE_YRMON = @[to_duration]" ).append("\n"); 
		query.append("  AND DECODE(P.ACCT_CD, '510911', 'TI', 'TO') LIKE @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("  AND P.SYS_SRC_ID = 'CDA'" ).append("\n"); 
		query.append("  AND P.REV_YRMON = V.REV_YRMON" ).append("\n"); 
		query.append("  AND P.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("  AND P.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND P.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND P.REV_DIR_CD = V.REV_DIR_CD" ).append("\n"); 
		query.append("  AND P.ESTM_VVD_TP_CD <> 'PV'" ).append("\n"); 

	}
}