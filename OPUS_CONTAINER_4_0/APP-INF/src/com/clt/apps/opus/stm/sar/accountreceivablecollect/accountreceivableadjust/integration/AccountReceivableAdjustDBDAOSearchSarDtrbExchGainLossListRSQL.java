/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchSarDtrbExchGainLossListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOSearchSarDtrbExchGainLossListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GET SAR DISTRIBUTION ( CASE 'EXCH_GAIN', 'EXCH_LOSS' )
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchSarDtrbExchGainLossListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchSarDtrbExchGainLossListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    DTRB_SRC_SEQ," ).append("\n"); 
		query.append("    DTRB_SRC_TBL_CD," ).append("\n"); 
		query.append("    DTRB_SRC_TP_CD," ).append("\n"); 
		query.append("    INP_DR_AMT," ).append("\n"); 
		query.append("    INP_CR_AMT," ).append("\n"); 
		query.append("    ACCT_DR_AMT," ).append("\n"); 
		query.append("    ACCT_CR_AMT," ).append("\n"); 
		query.append("    ORZ_SEQ," ).append("\n"); 
		query.append("    BL_CURR_CD," ).append("\n"); 
		query.append("    DECODE(MAX_CONV_XCH_RT, MIN_CONV_XCH_RT, 'RND', 'EXCH') CONV_XCH_RT_FLG," ).append("\n"); 
		query.append("    CUST_CNT_CD," ).append("\n"); 
		query.append("    CUST_SEQ," ).append("\n"); 
		query.append("    DIFF_FLG," ).append("\n"); 
		query.append("    GL_DTRB_SRC_TP_CD," ).append("\n"); 
		query.append("    GL_INP_DR_AMT," ).append("\n"); 
		query.append("    GL_INP_CR_AMT," ).append("\n"); 
		query.append("    GL_ACCT_DR_AMT," ).append("\n"); 
		query.append("    GL_ACCT_CR_AMT  " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        DTRB_SRC_SEQ," ).append("\n"); 
		query.append("        DTRB_SRC_TBL_CD," ).append("\n"); 
		query.append("        CASE WHEN NVL(SUM(ACCT_DR_AMT),0) - NVL(SUM(ACCT_CR_AMT),0) < 0 THEN 'EXCH_LOSS'" ).append("\n"); 
		query.append("             WHEN NVL(SUM(ACCT_DR_AMT),0) - NVL(SUM(ACCT_CR_AMT),0) > 0 THEN 'EXCH_GAIN'" ).append("\n"); 
		query.append("        END AS DTRB_SRC_TP_CD," ).append("\n"); 
		query.append("        CASE WHEN NVL(SUM(ACCT_DR_AMT),0) - NVL(SUM(ACCT_CR_AMT),0) < 0 THEN 0" ).append("\n"); 
		query.append("        END AS INP_DR_AMT," ).append("\n"); 
		query.append("        CASE WHEN NVL(SUM(ACCT_DR_AMT),0) - NVL(SUM(ACCT_CR_AMT),0) > 0 THEN 0" ).append("\n"); 
		query.append("        END AS INP_CR_AMT," ).append("\n"); 
		query.append("        CASE WHEN NVL(SUM(ACCT_DR_AMT),0) - NVL(SUM(ACCT_CR_AMT),0) < 0 THEN ABS(NVL(SUM(ACCT_DR_AMT),0) - NVL(SUM(ACCT_CR_AMT),0))" ).append("\n"); 
		query.append("        END AS ACCT_DR_AMT," ).append("\n"); 
		query.append("        CASE WHEN NVL(SUM(ACCT_DR_AMT),0) - NVL(SUM(ACCT_CR_AMT),0) > 0 THEN ABS(NVL(SUM(ACCT_DR_AMT),0) - NVL(SUM(ACCT_CR_AMT),0))" ).append("\n"); 
		query.append("        END AS ACCT_CR_AMT," ).append("\n"); 
		query.append("        ORZ_SEQ," ).append("\n"); 
		query.append("        CURR_CD AS BL_CURR_CD," ).append("\n"); 
		query.append("        MAX(CONV_XCH_RT) MAX_CONV_XCH_RT," ).append("\n"); 
		query.append("        MIN(CONV_XCH_RT) MIN_CONV_XCH_RT," ).append("\n"); 
		query.append("        CUST_CNT_CD," ).append("\n"); 
		query.append("        CUST_SEQ," ).append("\n"); 
		query.append("        SIGN(NVL(SUM(ACCT_DR_AMT),0) - NVL(SUM(ACCT_CR_AMT),0)) DIFF_FLG," ).append("\n"); 
		query.append("		CASE WHEN NVL(SUM(GL_ACCT_DR_AMT),0) - NVL(SUM(GL_ACCT_CR_AMT),0) < 0 THEN 'EXCH_LOSS'" ).append("\n"); 
		query.append("             WHEN NVL(SUM(GL_ACCT_DR_AMT),0) - NVL(SUM(GL_ACCT_CR_AMT),0) > 0 THEN 'EXCH_GAIN'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END AS GL_DTRB_SRC_TP_CD," ).append("\n"); 
		query.append("        CASE WHEN NVL(SUM(GL_ACCT_DR_AMT),0) - NVL(SUM(GL_ACCT_CR_AMT),0) < 0 THEN 0" ).append("\n"); 
		query.append("        END AS GL_INP_DR_AMT," ).append("\n"); 
		query.append("        CASE WHEN NVL(SUM(GL_ACCT_DR_AMT),0) - NVL(SUM(GL_ACCT_CR_AMT),0) > 0 THEN 0" ).append("\n"); 
		query.append("        END AS GL_INP_CR_AMT," ).append("\n"); 
		query.append("        CASE WHEN NVL(SUM(GL_ACCT_DR_AMT),0) - NVL(SUM(GL_ACCT_CR_AMT),0) < 0 THEN ABS(NVL(SUM(GL_ACCT_DR_AMT),0) - NVL(SUM(GL_ACCT_CR_AMT),0))" ).append("\n"); 
		query.append("        END AS GL_ACCT_DR_AMT," ).append("\n"); 
		query.append("        CASE WHEN NVL(SUM(GL_ACCT_DR_AMT),0) - NVL(SUM(GL_ACCT_CR_AMT),0) > 0 THEN ABS(NVL(SUM(GL_ACCT_DR_AMT),0) - NVL(SUM(GL_ACCT_CR_AMT),0))" ).append("\n"); 
		query.append("        END AS GL_ACCT_CR_AMT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        SAR_CLT_DTRB" ).append("\n"); 
		query.append("    WHERE DTRB_SRC_SEQ = @[adj_his_seq]" ).append("\n"); 
		query.append("	AND   DTRB_SRC_TBL_CD = 'ADJ'" ).append("\n"); 
		query.append("    GROUP BY" ).append("\n"); 
		query.append("        DTRB_SRC_SEQ," ).append("\n"); 
		query.append("        DTRB_SRC_TBL_CD," ).append("\n"); 
		query.append("        ORZ_SEQ," ).append("\n"); 
		query.append("        CURR_CD," ).append("\n"); 
		query.append("        CUST_CNT_CD," ).append("\n"); 
		query.append("        CUST_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}