/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceDBDAOSearchPremiumInstallmentListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.13 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.insurance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceDBDAOSearchPremiumInstallmentListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Premium Installment를 조회한다
	  * </pre>
	  */
	public InsuranceDBDAOSearchPremiumInstallmentListVORSQL(){
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
		query.append("Path : com.clt.apps.opus.cps.cni.insurance.insurance.integration").append("\n"); 
		query.append("FileName : InsuranceDBDAOSearchPremiumInstallmentListVORSQL").append("\n"); 
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
		query.append(",	INSUR_PRM_TP_CD" ).append("\n"); 
		query.append(",	INST_SEQ" ).append("\n"); 
		query.append(",	TO_CHAR(INST_LOCL_AMT,'FM999,999,999,990.00') INST_LOCL_AMT" ).append("\n"); 
		query.append(",	INST_CURR_CD" ).append("\n"); 
		query.append(",	TO_CHAR(INST_XCH_RT,'FM999,990.00000') INST_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(INST_USD_AMT,'FM999,999,999,990.00') INST_USD_AMT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(INST_DUE_DT, 'YYYYMMDD'),'YYYY-MM-DD') INST_DUE_DT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(INST_PAY_DT, 'YYYYMMDD'),'YYYY-MM-DD') INST_PAY_DT" ).append("\n"); 
		query.append("FROM CNI_INSUR_PRM_INST" ).append("\n"); 
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