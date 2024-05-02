/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchAdjustForOTSChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.12 
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

public class AccountReceivableAdjustDBDAOsearchAdjustForOTSChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Adjust for OTS Charge
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchAdjustForOTSChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchAdjustForOTSChargeRSQL").append("\n"); 
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
		query.append("SELECT OTS_HIS_SEQ" ).append("\n"); 
		query.append("	   , CHG_TP_CD" ).append("\n"); 
		query.append("       , ADJ_AMT BAL_AMT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("FROM sar_adj_his" ).append("\n"); 
		query.append("WHERE ADJ_NO IN (" ).append("\n"); 
		query.append("#foreach( $key IN ${adj_no_list}) " ).append("\n"); 
		query.append("	#if($velocityCount < $adj_no_list.size())" ).append("\n"); 
		query.append("  		'$key'," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		'$key'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ADJ_STS_CD = @[sts_cd]" ).append("\n"); 
		query.append("AND OTS_HIS_SEQ IS NOT NULL" ).append("\n"); 

	}
}