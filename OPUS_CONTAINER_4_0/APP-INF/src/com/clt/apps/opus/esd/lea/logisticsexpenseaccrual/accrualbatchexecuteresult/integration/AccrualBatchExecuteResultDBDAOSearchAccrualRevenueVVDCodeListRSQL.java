/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualRevenueVVDCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.31 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualRevenueVVDCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수입대상항차조회   
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualRevenueVVDCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualRevenueVVDCodeListRSQL").append("\n"); 
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
		query.append("SELECT	EXE_YRMON" ).append("\n"); 
		query.append(",REV_YRMON" ).append("\n"); 
		query.append(",VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD REV_VVD_NO" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",ESTM_VVD_TP_CD" ).append("\n"); 
		query.append(",ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append(",ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append(",ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("FROM	GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE	EXE_YRMON = REPLACE(@[frm_exe_yrmon], '-')" ).append("\n"); 
		query.append("AND		REV_YRMON >= REPLACE(@[frm_rev_yrmon_from], '-')" ).append("\n"); 
		query.append("AND 	REV_YRMON <= REPLACE(@[frm_rev_yrmon_to], '-')" ).append("\n"); 
		query.append("ORDER BY	EXE_YRMON" ).append("\n"); 
		query.append(",REV_YRMON" ).append("\n"); 
		query.append(",REV_VVD_NO" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",ESTM_VVD_TP_CD" ).append("\n"); 
		query.append(",ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append(",ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append(",ESTM_BC_DIV_CD" ).append("\n"); 

	}
}