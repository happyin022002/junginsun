/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOSearchReceiptBankListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOSearchReceiptBankListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Receipt Bank List
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOSearchReceiptBankListRSQL(){
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
		params.put("rct_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dps_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dps_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOSearchReceiptBankListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.BANK_ACCT_SEQ, " ).append("\n"); 
		query.append("        A.BANK_ACCT_NM," ).append("\n"); 
		query.append("        A.BANK_ACCT_NO," ).append("\n"); 
		query.append("        A.CURR_CD," ).append("\n"); 
		query.append("        A.MLT_CURR_FLG," ).append("\n"); 
		query.append("        A.OPN_OFC_CD," ).append("\n"); 
		query.append("        A.AR_OFC_CD" ).append("\n"); 
		query.append("FROM SAP_BANK_ACCT A," ).append("\n"); 
		query.append("	 SAR_RECEIPT B" ).append("\n"); 
		query.append("WHERE A.BANK_ACCT_SEQ = B.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("AND B.RCT_DT >= NVL(REPLACE(@[rct_dt_fm],'-',''), B.RCT_DT)" ).append("\n"); 
		query.append("AND B.RCT_DT <= NVL(REPLACE(@[rct_dt_to],'-',''), B.RCT_DT)       " ).append("\n"); 
		query.append("AND B.RCT_DPS_DT >= NVL(REPLACE(@[rct_dps_dt_fm],'-',''), B.RCT_DPS_DT)" ).append("\n"); 
		query.append("AND B.RCT_DPS_DT <= NVL(REPLACE(@[rct_dps_dt_to],'-',''), B.RCT_DPS_DT)" ).append("\n"); 
		query.append("AND B.RCT_OFC_CD IN ( ${rct_ofc_cd} )" ).append("\n"); 
		query.append("AND ( (@[rct_sts_cd] = 'ALL') OR" ).append("\n"); 
		query.append("      (@[rct_sts_cd] = 'CANCEL' AND B.RCT_CXL_DT IS NOT NULL ) OR" ).append("\n"); 
		query.append("      (@[rct_sts_cd] = 'RECEIPT' AND B.RCT_CXL_DT IS NULL )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#if (${rct_unpay_sts_flg} == 'UNAPP')" ).append("\n"); 
		query.append("    AND B.RCT_STS_CD IN ('UNAPP','UNID')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}