/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceDBDAOSearchInsuranceVORSQL.java
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

public class InsuranceDBDAOSearchInsuranceVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insurance를 조회한다
	  * </pre>
	  */
	public InsuranceDBDAOSearchInsuranceVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : InsuranceDBDAOSearchInsuranceVORSQL").append("\n"); 
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
		query.append(",   (SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.INSUR_CLM_PTY_NO) INSUR_CLM_PTY_NM" ).append("\n"); 
		query.append(",	INSUR_CTNT" ).append("\n"); 
		query.append(",	RINS_CLM_PTY_NO" ).append("\n"); 
		query.append(",   (SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.RINS_CLM_PTY_NO) RINS_CLM_PTY_NM" ).append("\n"); 
		query.append(",	RINS_CTNT" ).append("\n"); 
		query.append(",	INS_CLM_PTY_NO" ).append("\n"); 
		query.append(",   (SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.INS_CLM_PTY_NO) INS_CLM_PTY_NM" ).append("\n"); 
		query.append(",	INS_CTNT" ).append("\n"); 
		query.append(",	CINS_CLM_PTY_NO" ).append("\n"); 
		query.append(",   (SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.CINS_CLM_PTY_NO) CINS_CLM_PTY_NM" ).append("\n"); 
		query.append(",	CINS_CTNT" ).append("\n"); 
		query.append(",	BRO_CLM_PTY_NO" ).append("\n"); 
		query.append(",   (SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.BRO_CLM_PTY_NO) BRO_CLM_PTY_NM" ).append("\n"); 
		query.append(",	INT_DESC" ).append("\n"); 
		query.append(",	INT_DESC INT_DESC_NM" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(INSUR_CTRT_EFF_DT, 'YYYYMMDD'),'YYYY-MM-DD') INSUR_CTRT_EFF_DT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(INSUR_CTRT_EXP_DT, 'YYYYMMDD'),'YYYY-MM-DD') INSUR_CTRT_EXP_DT" ).append("\n"); 
		query.append(",	SUBJ_MAT_INS_DESC" ).append("\n"); 
		query.append(",	SUBJ_MAT_INS_DESC SUBJ_MAT_INS_DESC_NM" ).append("\n"); 
		query.append(",	INS_CURR_CD" ).append("\n"); 
		query.append(",	TO_CHAR(INS_LOCL_AMT,'FM999,999,999,990.00') INS_LOCL_AMT" ).append("\n"); 
		query.append(",	TO_CHAR(INS_XCH_RT,'FM999,990.00000') INS_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(INS_USD_AMT,'FM999,999,999,990.00') INS_USD_AMT" ).append("\n"); 
		query.append(",	LMT_INS_CURR_CD" ).append("\n"); 
		query.append(",	TO_CHAR(LMT_INS_LOCL_AMT,'FM999,999,999,990.00') LMT_INS_LOCL_AMT" ).append("\n"); 
		query.append(",	TO_CHAR(LMT_INS_XCH_RT,'FM999,990.00000') LMT_INS_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(LMT_INS_USD_AMT,'FM999,999,999,990.00') LMT_INS_USD_AMT" ).append("\n"); 
		query.append(",	INSUR_RMK" ).append("\n"); 
		query.append(",	TO_CHAR(TTL_LOCL_AMT,'FM999,999,999,990.00') INSUR_TTL_LOCL_AMT" ).append("\n"); 
		query.append(",	TTL_CURR_CD INSUR_TTL_CURR_CD " ).append("\n"); 
		query.append(",	TO_CHAR(TTL_XCH_RT,'FM999,990.00000') INSUR_TTL_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(TTL_USD_AMT,'FM999,999,999,990.00') INSUR_TTL_USD_AMT" ).append("\n"); 
		query.append("FROM CNI_INSUR_CTRT A, (SELECT MAX(TTL_LOCL_AMT) TTL_LOCL_AMT, MAX(TTL_CURR_CD) TTL_CURR_CD, " ).append("\n"); 
		query.append("							   MAX(TTL_XCH_RT) TTL_XCH_RT, MAX(TTL_USD_AMT) TTL_USD_AMT" ).append("\n"); 
		query.append("					    FROM   CNI_INSUR_PRM" ).append("\n"); 
		query.append("                        WHERE  INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("						AND	   INSUR_PLCY_YR = @[insur_plcy_yr]" ).append("\n"); 
		query.append("#if (${insur_clm_pty_no} != '')  " ).append("\n"); 
		query.append("                        AND	   INSUR_CLM_PTY_NO = @[insur_clm_pty_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                        AND	   INSUR_CLM_PTY_NO = (SELECT INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("                                                   FROM   CNI_INSUR_CTRT" ).append("\n"); 
		query.append("                                                   WHERE  INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("                                                   AND	  INSUR_PLCY_YR = @[insur_plcy_yr]" ).append("\n"); 
		query.append("                                                   AND    UPD_DT = (SELECT MAX(UPD_DT)" ).append("\n"); 
		query.append("                                                                    FROM   CNI_INSUR_CTRT" ).append("\n"); 
		query.append("                                                                    WHERE  INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("                                                                    AND	   INSUR_PLCY_YR = @[insur_plcy_yr])" ).append("\n"); 
		query.append("                                                   AND    ROWNUM = 1) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("						AND    INSUR_PRM_TP_CD = 'APR') B" ).append("\n"); 
		query.append("WHERE	INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("AND	INSUR_PLCY_YR = @[insur_plcy_yr]" ).append("\n"); 
		query.append("#if (${insur_clm_pty_no} != '')  " ).append("\n"); 
		query.append("AND	INSUR_CLM_PTY_NO = @[insur_clm_pty_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	INSUR_CLM_PTY_NO = (SELECT INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("                        FROM   CNI_INSUR_CTRT" ).append("\n"); 
		query.append("                        WHERE  INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("                        AND	   INSUR_PLCY_YR = @[insur_plcy_yr]" ).append("\n"); 
		query.append("                        AND    UPD_DT = (SELECT MAX(UPD_DT)" ).append("\n"); 
		query.append("                                         FROM   CNI_INSUR_CTRT" ).append("\n"); 
		query.append("                                         WHERE  INSUR_TP_CD = @[insur_tp_cd]" ).append("\n"); 
		query.append("                                         AND	INSUR_PLCY_YR = @[insur_plcy_yr])" ).append("\n"); 
		query.append("                           AND    ROWNUM = 1) " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}