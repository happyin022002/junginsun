/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.10.07 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration").append("\n"); 
		query.append("FileName : AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmCSQL").append("\n"); 
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
		query.append("-------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- 수행년월 기준으로 각각의 Revenue YearMonth별 Account Code 별로 입력된" ).append("\n"); 
		query.append("-- Estimated, Accrual Cost 값만을 추려 마지막 Confirm(반드시 한번만 Click)시" ).append("\n"); 
		query.append("-- GL_ACCL_IF테이블에 Insert 처리(Manual Input FLAG를 반드시 확인 후 처리 할것!)" ).append("\n"); 
		query.append("-- 공통항차(CNTC)의 VVD Type은 'RV' 임" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------" ).append("\n"); 
		query.append("INSERT INTO GL_ACCL_IF" ).append("\n"); 
		query.append("(EXE_YRMON, SYS_SRC_ID, REV_YRMON, ACCT_CD, ACCL_SEQ, BIZ_UT_ID, VSL_CD, SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD, REV_DIR_CD, ESTM_VVD_TP_CD, ESTM_IOC_DIV_CD, ESTM_VVD_HDR_ID," ).append("\n"); 
		query.append("ESTM_BC_DIV_CD, NOD_CD, ESTM_COST_AMT, ACT_COST_AMT, ACCL_COST_AMT, CRE_USR_ID, CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID, UPD_DT	)" ).append("\n"); 
		query.append("SELECT	A.EXE_YRMON, 'ESD', A.REV_YRMON, A.ACCT_CD, (B.ACCL_SEQ + ROWNUM), 'CNTR', 'CNTC'," ).append("\n"); 
		query.append("SUBSTR(REV_YRMON, 3, 4), 'M', 'M', 'RV', 'XX', '99999', 'C', 'HQCOL'," ).append("\n"); 
		query.append("SUM (A.ESTM_COST_AMT), DECODE(A.ACCT_CD , '512181', SUM(A.PRE_ACT_COST_AMT), '512381', SUM(A.PRE_ACT_COST_AMT), 0 )," ).append("\n"); 
		query.append("SUM (A.ACCL_COST_AMT), 'UI_MNL_SAV'," ).append("\n"); 
		query.append("SYSDATE, 'UI_MNL_SAV', SYSDATE" ).append("\n"); 
		query.append("FROM	LEA_ACCT_COST_AMT A," ).append("\n"); 
		query.append("(SELECT /*+ INDEX_DESC(GL_ACCL_IF XAK1GL_ACCL_IF) */" ).append("\n"); 
		query.append("ACCL_SEQ" ).append("\n"); 
		query.append("FROM GL_ACCL_IF" ).append("\n"); 
		query.append("WHERE EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-')  AND ROWNUM = 1) B" ).append("\n"); 
		query.append("WHERE	A.EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append("AND		A.ACCL_AUTO_CD = 'M'" ).append("\n"); 
		query.append("AND		A.MNL_INP_FLG = 'Y'   --Manual Rep Account 로 입력한 계정(Account Code)" ).append("\n"); 
		query.append("GROUP BY	A.EXE_YRMON, A.REV_YRMON, A.ACCT_CD, (B.ACCL_SEQ + ROWNUM), SUBSTR (REV_YRMON, 3, 4)" ).append("\n"); 

	}
}