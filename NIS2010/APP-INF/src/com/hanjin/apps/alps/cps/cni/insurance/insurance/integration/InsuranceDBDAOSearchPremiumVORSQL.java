/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceDBDAOSearchPremiumVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.insurance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceDBDAOSearchPremiumVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Premium를 조회한다
	  * </pre>
	  */
	public InsuranceDBDAOSearchPremiumVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_prm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_plcy_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.insurance.insurance.integration").append("\n"); 
		query.append("FileName : InsuranceDBDAOSearchPremiumVORSQL").append("\n"); 
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
		query.append("	INSUR_TP_CD" ).append("\n"); 
		query.append(",	INSUR_PLCY_YR" ).append("\n"); 
		query.append(",	INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",	INSUR_CLM_PTY_NO INSUR_CLM_PTY_NO_PRM" ).append("\n"); 
		query.append(",   (SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.INSUR_CLM_PTY_NO) INSUR_CLM_PTY_NM_PRM" ).append("\n"); 
		query.append(",	INSUR_PRM_TP_CD" ).append("\n"); 
		query.append(",	TO_CHAR(TTL_LOCL_AMT,'FM999,999,999,990.00') TTL_LOCL_AMT" ).append("\n"); 
		query.append(",	TTL_CURR_CD" ).append("\n"); 
		query.append(",	TO_CHAR(TTL_XCH_RT,'FM999,990.00000') TTL_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(TTL_USD_AMT,'FM999,999,999,990.00') TTL_USD_AMT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(TTL_DUE_DT, 'YYYYMMDD'),'YYYY-MM-DD') TTL_DUE_DT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(TTL_PAY_DT, 'YYYYMMDD'),'YYYY-MM-DD') TTL_PAY_DT" ).append("\n"); 
		query.append(",	TO_CHAR(ADJ_LOCL_AMT,'FM999,999,999,990.00') ADJ_LOCL_AMT" ).append("\n"); 
		query.append(",	ADJ_CURR_CD" ).append("\n"); 
		query.append(",	TO_CHAR(ADJ_XCH_RT,'FM999,990.00000') ADJ_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(ADJ_USD_AMT,'FM999,999,999,990.00') ADJ_USD_AMT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(ADJ_DUE_DT, 'YYYYMMDD'),'YYYY-MM-DD') ADJ_DUE_DT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(ADJ_PAY_DT, 'YYYYMMDD'),'YYYY-MM-DD') ADJ_PAY_DT" ).append("\n"); 
		query.append(",	TO_CHAR(RFND_LOCL_AMT,'FM999,999,999,990.00') RFND_LOCL_AMT" ).append("\n"); 
		query.append(",	RFND_CURR_CD" ).append("\n"); 
		query.append(",	TO_CHAR(RFND_XCH_RT,'FM999,990.00000') RFND_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(RFND_USD_AMT,'FM999,999,999,990.00') RFND_USD_AMT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(RFND_DUE_DT, 'YYYYMMDD'),'YYYY-MM-DD') RFND_DUE_DT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(RFND_PAY_DT, 'YYYYMMDD'),'YYYY-MM-DD') RFND_PAY_DT" ).append("\n"); 
		query.append(",	TO_CHAR(OTS_LOCL_AMT,'FM999,999,999,990.00') OTS_LOCL_AMT" ).append("\n"); 
		query.append(",	OTS_CURR_CD" ).append("\n"); 
		query.append(",	TO_CHAR(OTS_XCH_RT,'FM999,990.00000') OTS_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(OTS_USD_AMT,'FM999,999,999,990.00') OTS_USD_AMT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(OTS_DUE_DT, 'YYYYMMDD'),'YYYY-MM-DD') OTS_DUE_DT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(OTS_PAY_DT, 'YYYYMMDD'),'YYYY-MM-DD') OTS_PAY_DT" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append("FROM CNI_INSUR_PRM A" ).append("\n"); 
		query.append("WHERE	INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("AND	INSUR_PLCY_YR = @[insur_plcy_yr]" ).append("\n"); 
		query.append("#if (${insur_clm_pty_no} != '')  " ).append("\n"); 
		query.append("AND	    INSUR_CLM_PTY_NO = @[insur_clm_pty_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND	    INSUR_CLM_PTY_NO = (SELECT INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("                            FROM   CNI_INSUR_CTRT" ).append("\n"); 
		query.append("                            WHERE  INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("                            AND	   INSUR_PLCY_YR = @[insur_plcy_yr]" ).append("\n"); 
		query.append("                            AND    UPD_DT = (SELECT MAX(UPD_DT)" ).append("\n"); 
		query.append("                                             FROM   CNI_INSUR_CTRT" ).append("\n"); 
		query.append("                                             WHERE  INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("                                             AND	INSUR_PLCY_YR = @[insur_plcy_yr])" ).append("\n"); 
		query.append("                            AND    ROWNUM = 1) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	INSUR_PRM_TP_CD = @[insur_prm_tp_cd]" ).append("\n"); 

	}
}