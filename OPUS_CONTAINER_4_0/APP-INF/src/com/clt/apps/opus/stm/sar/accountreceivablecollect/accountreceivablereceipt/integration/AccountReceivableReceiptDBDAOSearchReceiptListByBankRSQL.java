/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchReceiptListByBankRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOSearchReceiptListByBankRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReceiptListByBank
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchReceiptListByBankRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchReceiptListByBankRSQL").append("\n"); 
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
		query.append("SELECT RCT_OFC_CD," ).append("\n"); 
		query.append("       BANK_ACCT_NM," ).append("\n"); 
		query.append("       RCT_CURR_CD," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(RCT_CURR_CD, SUM(RCT_AMT)) RCT_AMT," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(RCT_CURR_CD, SUM(RCT_UNA_AMT)) UNA_AMT," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(RCT_CURR_CD, SUM(RCT_UNI_AMT)) UNI_AMT," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(RCT_CURR_CD, SUM(RCT_CXL_AMT)) BOU_AMT," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(RCT_CURR_CD, SUM(RFD_AMT)) 	REF_AMT" ).append("\n"); 
		query.append("FROM  (       " ).append("\n"); 
		query.append("       SELECT SR.RCT_OFC_CD," ).append("\n"); 
		query.append("    		SBA.BANK_ACCT_NM," ).append("\n"); 
		query.append("              SR.RCT_NO," ).append("\n"); 
		query.append("              SR.RCT_DT," ).append("\n"); 
		query.append("              SR.RCT_DPS_DT," ).append("\n"); 
		query.append("              SR.RCT_CURR_CD," ).append("\n"); 
		query.append("              SR.RCT_AMT," ).append("\n"); 
		query.append("			  DECODE(SR.RCT_STS_CD, 'UNAPP', SR.BAL_RCT_AMT, 0) RCT_UNA_AMT," ).append("\n"); 
		query.append("			  DECODE(SR.RCT_STS_CD, 'UNID', SR.BAL_RCT_AMT, 0) RCT_UNI_AMT," ).append("\n"); 
		query.append("              DECODE(SR.RCT_CXL_DT, NULL, 0, SR.RCT_AMT) RCT_CXL_AMT," ).append("\n"); 
		query.append("              (SELECT SUM(RCT_APLY_AMT)" ).append("\n"); 
		query.append("			   FROM SAR_RCT_APLY_DTL" ).append("\n"); 
		query.append("			   WHERE RCT_SEQ = SR.RCT_SEQ" ).append("\n"); 
		query.append("			   AND WRTF_CD = 'RFD') RFD_AMT" ).append("\n"); 
		query.append("       FROM   SAR_RECEIPT SR," ).append("\n"); 
		query.append("              SAP_BANK_ACCT SBA," ).append("\n"); 
		query.append("              SCO_OFC_INFO SO" ).append("\n"); 
		query.append("       WHERE  SR.BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("       AND    SR.RCT_OFC_CD = SO.OFC_CD" ).append("\n"); 
		query.append("       AND    SR.CRE_USR_ID = NVL(@[rct_usr_id], SR.CRE_USR_ID)" ).append("\n"); 
		query.append("#if (${rct_dt_tp_cd} == 'RECEIPT') " ).append("\n"); 
		query.append("       AND    SR.RCT_DT >= NVL(REPLACE(@[rct_dt_fm], '-', ''), SR.RCT_DT) " ).append("\n"); 
		query.append("       AND    SR.RCT_DT <= NVL(REPLACE(@[rct_dt_to], '-', ''), SR.RCT_DT)     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_dt_tp_cd} == 'DEPOSIT')" ).append("\n"); 
		query.append("       AND    SR.RCT_DPS_DT >= NVL(REPLACE(@[rct_dt_fm], '-', ''), SR.RCT_DPS_DT)" ).append("\n"); 
		query.append("       AND    SR.RCT_DPS_DT <= NVL(REPLACE(@[rct_dt_to], '-', ''), SR.RCT_DPS_DT) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND    SR.BANK_ACCT_SEQ = NVL(@[bank_acct_seq], SR.BANK_ACCT_SEQ)" ).append("\n"); 
		query.append("       AND    SR.RCT_TP_CD = NVL(@[rct_tp_cd], SR.RCT_TP_CD)" ).append("\n"); 
		query.append("       AND    ( (@[rct_sts_cd] = 'ALL') OR" ).append("\n"); 
		query.append("                (@[rct_sts_cd] = 'CANCEL' AND SR.RCT_CXL_DT IS NOT NULL ) OR" ).append("\n"); 
		query.append("                (@[rct_sts_cd] = 'RECEIPT' AND SR.RCT_CXL_DT IS NULL )" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("       AND    SR.RCT_CURR_CD = NVL(@[rct_curr_cd], SR.RCT_CURR_CD)" ).append("\n"); 
		query.append("#if (${rct_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND    SR.RCT_OFC_CD in ( ${rct_ofc_cd} ) " ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("       RCT_OFC_CD," ).append("\n"); 
		query.append("       BANK_ACCT_NM," ).append("\n"); 
		query.append("       RCT_CURR_CD" ).append("\n"); 

	}
}