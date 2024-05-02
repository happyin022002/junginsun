/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultBookingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2010.02.10 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultBookingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    Accrual Result by Booking 조회
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultBookingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cost_diff_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cost_diff_per",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultBookingListRSQL").append("\n"); 
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
		query.append(",REV_VVD_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",ESTM_COST_AMT" ).append("\n"); 
		query.append(",ACT_COST_AMT" ).append("\n"); 
		query.append(",ACCL_COST_AMT" ).append("\n"); 
		query.append(",CONFIRMED_COST_AMT" ).append("\n"); 
		query.append(",COST_DIFF_AMT" ).append("\n"); 
		query.append(",DECODE(ESTM_COST_AMT,0,0,ABS(COST_DIFF_AMT)/ESTM_COST_AMT*100) COST_DIFF_PER" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT   /*+ INDEX(A XAK1LEA_ACCL_DTL) */ REPLACE(@[frm_exe_yrmon],'-') EXE_YRMON" ).append("\n"); 
		query.append(",A.REV_YRMON" ).append("\n"); 
		query.append(",(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD) REV_VVD_NO" ).append("\n"); 
		query.append(",A.BKG_NO BKG_NO" ).append("\n"); 
		query.append(",SUM(NVL(A.ESTM_COST_AMT,0))   ESTM_COST_AMT" ).append("\n"); 
		query.append(",SUM(NVL(A.ACT_COST_AMT ,0))   ACT_COST_AMT" ).append("\n"); 
		query.append(",SUM(NVL(A.ACCL_COST_AMT,0))   ACCL_COST_AMT" ).append("\n"); 
		query.append(",SUM((NVL(A.ACT_COST_AMT,0)+NVL(A.ACCL_COST_AMT,0)))  CONFIRMED_COST_AMT" ).append("\n"); 
		query.append(",SUM((NVL(A.ACT_COST_AMT,0)+NVL(A.ACCL_COST_AMT,0)-NVL(A.ESTM_COST_AMT,0))) COST_DIFF_AMT" ).append("\n"); 
		query.append("FROM	LEA_ACCL_DTL A" ).append("\n"); 
		query.append("WHERE	A.REV_YRMON  = REPLACE(@[frm_rev_yrmon],'-')" ).append("\n"); 
		query.append("AND		A.DELT_FLG   = 'N' --Not Delete" ).append("\n"); 
		query.append("AND		A.BKG_STS_CD = 'F' --Firm" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${frm_acct_cd} != '') && (${frm_acct_cd} != 'ALL'))" ).append("\n"); 
		query.append("AND    A.ACCT_CD = @[frm_acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${frm_vvd_no} != '') && (${frm_vvd_no} != 'ALL'))" ).append("\n"); 
		query.append("AND    (A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD) = @[frm_vvd_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_bkg_no} != '')" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[frm_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY	A.REV_YRMON" ).append("\n"); 
		query.append(",(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD)" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_diff_div} == 'A')" ).append("\n"); 
		query.append("WHERE    ABS(COST_DIFF_AMT) >= TO_NUMBER(@[frm_cost_diff_amt])" ).append("\n"); 
		query.append("#elseif (${frm_diff_div} == 'P')" ).append("\n"); 
		query.append("WHERE    ROUND(DECODE(ESTM_COST_AMT,0,0,ABS(COST_DIFF_AMT)/ESTM_COST_AMT*100),2) >=  TO_NUMBER(@[frm_cost_diff_per])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY	EXE_YRMON" ).append("\n"); 
		query.append(",REV_YRMON" ).append("\n"); 
		query.append(",REV_VVD_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 

	}
}