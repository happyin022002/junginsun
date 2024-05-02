/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchOTSDistributionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.19 
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

public class AccountReceivableReceiptDBDAOSearchOTSDistributionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search OTS Distribution info
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchOTSDistributionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchOTSDistributionRSQL").append("\n"); 
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
		query.append("SELECT A.OTS_CD_CMB_SEQ 			" ).append("\n"); 
		query.append("     , A.CURR_CD        	  				" ).append("\n"); 
		query.append("     , A.BIL_TO_CUST_CNT_CD 		" ).append("\n"); 
		query.append("     , A.BIL_TO_CUST_SEQ    " ).append("\n"); 
		query.append("     , B.REC_ACCT_MTX_SEQ" ).append("\n"); 
		query.append("	 , B.BAL_AMT" ).append("\n"); 
		query.append("FROM SAR_OTS_DTRB A," ).append("\n"); 
		query.append("	 SAR_OTS_CHG B" ).append("\n"); 
		query.append("WHERE A.OTS_HIS_SEQ = B.OTS_HIS_SEQ" ).append("\n"); 
		query.append("AND A.CHG_TP_CD = B.CHG_TP_CD" ).append("\n"); 
		query.append("AND A.OTS_HIS_SEQ = @[ots_his_seq]" ).append("\n"); 
		query.append("AND A.CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("AND A.ACCT_CLSS_CD = 'REC'" ).append("\n"); 

	}
}