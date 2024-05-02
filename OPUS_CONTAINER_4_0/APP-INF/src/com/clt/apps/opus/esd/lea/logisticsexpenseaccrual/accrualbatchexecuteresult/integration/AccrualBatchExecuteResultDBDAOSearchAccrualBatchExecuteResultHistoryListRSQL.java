/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchExecuteResultHistoryListRSQL.java
*@FileTitle : Accrual Result by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍
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

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchExecuteResultHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 결산 배치 결과 조회   
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchExecuteResultHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchExecuteResultHistoryListRSQL").append("\n"); 
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
		query.append("SELECT	SUBSTR(M.EXE_YRMON,0,4)||'-'||SUBSTR(M.EXE_YRMON,5,2)	EXE_YRMON" ).append("\n"); 
		query.append(",M.AP_CLZ_FLG" ).append("\n"); 
		query.append(",DECODE(M.AP_CLZ_FLG,'Y','YES','NO') AP_CLZ_FLG_DESC" ).append("\n"); 
		query.append(",M.REV_VVD_IF_FLG" ).append("\n"); 
		query.append(",M.REV_VVD_IF_KNT" ).append("\n"); 
		query.append(",DECODE(M.AP_CLZ_FLG,'Y','YES','NO')||'('||NVL(M.REV_VVD_IF_KNT,0)||')' REV_VVD_IF_FLG_DESC" ).append("\n"); 
		query.append(",M.MON_AVG_XCH_RT_IF_FLG" ).append("\n"); 
		query.append(",M.MON_AVG_XCH_RT_IF_KNT" ).append("\n"); 
		query.append(",DECODE(M.MON_AVG_XCH_RT_IF_FLG,'Y','YES','NO')||'('||NVL(M.MON_AVG_XCH_RT_IF_KNT,0)||')' MON_AVG_XCH_RT_IF_FLG_DESC" ).append("\n"); 
		query.append(",M.MNL_INP_FLG" ).append("\n"); 
		query.append(",DECODE(M.MNL_INP_FLG,'Y','YES','NO') MNL_INP_FLG_DESC" ).append("\n"); 
		query.append(",M.ERP_IF_FLG" ).append("\n"); 
		query.append(",TO_CHAR(M.ERP_IF_DT,'YYYY.MM.DD HH24:MI:SS')  ERP_IF_DT" ).append("\n"); 
		query.append(",S.BAT_ID" ).append("\n"); 
		query.append(",TO_CHAR(S.BAT_ST_DT,'YYYY.MM.DD HH24:MI:SS')  BAT_ST_DT" ).append("\n"); 
		query.append(",TO_CHAR(S.BAT_END_DT,'YYYY.MM.DD HH24:MI:SS')  BAT_END_DT" ).append("\n"); 
		query.append(",TO_CHAR(S.ESTM_ST_DT,'YYYY.MM.DD HH24:MI:SS')  ESTM_ST_DT" ).append("\n"); 
		query.append(",TO_CHAR(S.ESTM_END_DT,'YYYY.MM.DD HH24:MI:SS')  ESTM_END_DT" ).append("\n"); 
		query.append(",NVL(S.ESTM_KNT,0) ESTM_KNT" ).append("\n"); 
		query.append(",TO_CHAR(S.ESTM_UPD_ST_DT,'YYYY.MM.DD HH24:MI:SS')  ESTM_UPD_ST_DT" ).append("\n"); 
		query.append(",TO_CHAR(S.ESTM_UPD_END_DT,'YYYY.MM.DD HH24:MI:SS')  ESTM_UPD_END_DT" ).append("\n"); 
		query.append(",NVL(S.ESTM_UPD_KNT,0) ESTM_UPD_KNT" ).append("\n"); 
		query.append(",TO_CHAR(S.MAPG_ALOC_ST_DT,'YYYY.MM.DD HH24:MI:SS')  MAPG_ALOC_ST_DT" ).append("\n"); 
		query.append(",TO_CHAR(S.MAPG_ALOC_END_DT,'YYYY.MM.DD HH24:MI:SS')  MAPG_ALOC_END_DT" ).append("\n"); 
		query.append(",NVL(S.MAPG_ALOC_KNT,0) MAPG_ALOC_KNT" ).append("\n"); 
		query.append(",NVL(S.ERR_KNT,0) ERR_KNT" ).append("\n"); 
		query.append(",S.BAT_CMPL_FLG" ).append("\n"); 
		query.append(",DECODE(S.BAT_CMPL_FLG,'Y','YES','NO') BAT_CMPL_FLG_DESC" ).append("\n"); 
		query.append(",S.BAT_RMK" ).append("\n"); 
		query.append("FROM	LEA_ACCL_COND_ITM M," ).append("\n"); 
		query.append("LEA_ACCL_BAT_HIS S" ).append("\n"); 
		query.append("WHERE	M.EXE_YRMON = S.EXE_YRMON" ).append("\n"); 
		query.append("AND		S.EXE_YRMON >= REPLACE(@[exe_yrmon_from], '-')" ).append("\n"); 
		query.append("AND		S.EXE_YRMON <= REPLACE(@[exe_yrmon_to], '-')" ).append("\n"); 
		query.append("ORDER BY	S.BAT_ID DESC, M.EXE_YRMON" ).append("\n"); 

	}
}