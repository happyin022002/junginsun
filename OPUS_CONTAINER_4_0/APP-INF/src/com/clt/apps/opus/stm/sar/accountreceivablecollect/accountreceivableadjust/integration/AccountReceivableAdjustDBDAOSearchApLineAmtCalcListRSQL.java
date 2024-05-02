/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchApLineAmtCalcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.18 
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

public class AccountReceivableAdjustDBDAOSearchApLineAmtCalcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Calculate Ap Line/GAIN/LOSS Amount
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchApLineAmtCalcListRSQL(){
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
		params.put("off_adj_acct_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_ap_hdr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_ap_func_ex_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_mst_sum_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchApLineAmtCalcListRSQL").append("\n"); 
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
		query.append("#if(${adj_tp_cd} == 'OFF')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    @[off_ap_hdr_amt] AS DTRB_AMT," ).append("\n"); 
		query.append("    '0' AS L_INV_ROUND_AMOUNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${adj_tp_cd} == 'OFFC')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	ROUND((@[off_adj_acct_amt]/@[off_ap_func_ex_rt]) * (@[off_ap_hdr_amt]*(-1)/@[off_mst_sum_amt]), @[dp_prcs_knt]) AS DTRB_AMT," ).append("\n"); 
		query.append("    ROUND((@[off_adj_acct_amt]/@[off_ap_func_ex_rt]) * (@[off_ap_hdr_amt]*(-1)/@[off_mst_sum_amt]), @[dp_prcs_knt]) - @[off_ap_hdr_amt] AS L_INV_ROUND_AMOUNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    DUAL  " ).append("\n"); 
		query.append("#elseif(${rvs_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	ROUND((@[off_adj_acct_amt]/@[off_ap_func_ex_rt]) * (@[off_ap_hdr_amt]*(-1)/@[off_mst_sum_amt]*(-1)), @[dp_prcs_knt]) AS DTRB_AMT," ).append("\n"); 
		query.append("    ROUND((@[off_adj_acct_amt]/@[off_ap_func_ex_rt]) * (@[off_ap_hdr_amt]*(-1)/@[off_mst_sum_amt]*(-1)), @[dp_prcs_knt]) - @[off_ap_hdr_amt] AS L_INV_ROUND_AMOUNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    DUAL  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}