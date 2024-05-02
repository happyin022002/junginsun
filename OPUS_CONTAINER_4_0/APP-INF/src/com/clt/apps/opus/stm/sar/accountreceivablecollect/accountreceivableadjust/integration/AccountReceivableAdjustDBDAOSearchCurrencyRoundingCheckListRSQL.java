/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchCurrencyRoundingCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12 
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

public class AccountReceivableAdjustDBDAOSearchCurrencyRoundingCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get Currency Rounding Check List
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchCurrencyRoundingCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_prcs_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchCurrencyRoundingCheckListRSQL").append("\n"); 
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
		query.append("    REC_ACCT_AMT," ).append("\n"); 
		query.append("    CONV_ADJ_ACCT_AMT," ).append("\n"); 
		query.append("    CASE WHEN ABS(REC_ACCT_AMT) - ABS(CONV_ADJ_ACCT_AMT) <> 0 THEN ABS(REC_ACCT_AMT) - ABS(CONV_ADJ_ACCT_AMT)" ).append("\n"); 
		query.append("    END AS CURR_ROUND," ).append("\n"); 
		query.append("    CASE WHEN ABS(REC_ACCT_AMT) - ABS(CONV_ADJ_ACCT_AMT) <> 0 THEN 'HDR_RND'" ).append("\n"); 
		query.append("    END AS DTRB_SRC_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(    " ).append("\n"); 
		query.append("    SELECT ROUND(SOC.BAL_AMT * SODR.CONV_XCH_RT, @[dp_prcs_knt]) AS OTS_BAL_ACCT_AMT," ).append("\n"); 
		query.append("           ROUND((SOC.BAL_AMT + @[adj_amt]) * SODR.CONV_XCH_RT, @[dp_prcs_knt]) AS OTS_ENDG_BAL_ACCT_AMT," ).append("\n"); 
		query.append("           (ROUND(SOC.BAL_AMT * SODR.CONV_XCH_RT, @[dp_prcs_knt]) - ROUND((SOC.BAL_AMT + @[adj_amt]) * SODR.CONV_XCH_RT, @[dp_prcs_knt])) AS REC_ACCT_AMT," ).append("\n"); 
		query.append("           ROUND(@[adj_amt] * SODR.CONV_XCH_RT, @[dp_prcs_knt]) AS CONV_ADJ_ACCT_AMT" ).append("\n"); 
		query.append("    FROM   SAR_OTS_CHG SOC," ).append("\n"); 
		query.append("           SAR_OTS_DTRB SODR" ).append("\n"); 
		query.append("    WHERE  SOC.OTS_HIS_SEQ = @[ots_his_seq]" ).append("\n"); 
		query.append("    AND    SOC.CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("    AND    SOC.OTS_HIS_SEQ = SODR.OTS_HIS_SEQ" ).append("\n"); 
		query.append("    AND    SOC.CHG_TP_CD = SODR.CHG_TP_CD" ).append("\n"); 
		query.append("    AND    SODR.ACCT_CLSS_CD = 'REC'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}