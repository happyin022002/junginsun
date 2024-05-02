/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchOpenASAListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.03 
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

public class AccountReceivableReceiptDBDAOSearchOpenASAListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search open ASA list
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchOpenASAListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchOpenASAListRSQL").append("\n"); 
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
		query.append("SELECT SR.ASA_NO, SAM.CURR_CD" ).append("\n"); 
		query.append("FROM SAR_RECEIPT SR," ).append("\n"); 
		query.append("     SAR_ASA_MST SAM" ).append("\n"); 
		query.append("WHERE SR.RCT_NO = @[rct_no]" ).append("\n"); 
		query.append("AND SR.ASA_NO = SAM.ASA_NO" ).append("\n"); 
		query.append("AND SR.ASA_NO IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT ASA_NO, CURR_CD" ).append("\n"); 
		query.append("  FROM SAR_ASA_MST" ).append("\n"); 
		query.append(" WHERE AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND ASA_STS_CD = 'O'" ).append("\n"); 
		query.append("   AND ASA_FSH_DT IS NULL" ).append("\n"); 
		query.append("ORDER BY ASA_NO" ).append("\n"); 

	}
}