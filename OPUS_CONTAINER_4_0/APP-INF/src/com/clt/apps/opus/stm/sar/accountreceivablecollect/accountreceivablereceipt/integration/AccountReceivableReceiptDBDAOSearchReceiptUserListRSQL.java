/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchReceiptUserListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.04 
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

public class AccountReceivableReceiptDBDAOSearchReceiptUserListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReceiptUserList
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchReceiptUserListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rct_dps_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rct_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rct_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rct_dps_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchReceiptUserListRSQL").append("\n"); 
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
		query.append("SELECT USR_ID," ).append("\n"); 
		query.append("       USR_NM," ).append("\n"); 
		query.append("       USR_EML" ).append("\n"); 
		query.append("FROM   SAR_RECEIPT SR," ).append("\n"); 
		query.append("       COM_USER    CU" ).append("\n"); 
		query.append("WHERE  SR.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("   AND    UPPER(CU.USR_ID) LIKE '%'||UPPER(@[usr_id])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_rct_dt} != '')" ).append("\n"); 
		query.append("   AND    SR.RCT_DT >= REPLACE(@[fm_rct_dt], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_rct_dt} != '')" ).append("\n"); 
		query.append("   AND    SR.RCT_DT <= REPLACE(@[to_rct_dt], '-', '')" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("#if (${fm_rct_dps_dt} != '')" ).append("\n"); 
		query.append("   AND    SR.RCT_DPS_DT >= REPLACE(@[fm_rct_dps_dt], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_rct_dps_dt} != '')" ).append("\n"); 
		query.append("   AND    SR.RCT_DPS_DT <= REPLACE(@[to_rct_dps_dt], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY USR_ID," ).append("\n"); 
		query.append("         USR_NM," ).append("\n"); 
		query.append("         USR_EML" ).append("\n"); 

	}
}