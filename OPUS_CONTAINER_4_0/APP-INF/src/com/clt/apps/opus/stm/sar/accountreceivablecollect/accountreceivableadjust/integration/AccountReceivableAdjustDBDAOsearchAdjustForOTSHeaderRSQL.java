/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchAdjustForOTSHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.03 
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

public class AccountReceivableAdjustDBDAOsearchAdjustForOTSHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Adjust for OTS Header
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchAdjustForOTSHeaderRSQL(){
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
		query.append("FileName : AccountReceivableAdjustDBDAOsearchAdjustForOTSHeaderRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT Q.RHQ_CD" ).append("\n"); 
		query.append("   	   , Q.OTS_OFC_CD" ).append("\n"); 
		query.append("   	   , Q.BL_NO" ).append("\n"); 
		query.append("   	   , Q.INV_NO" ).append("\n"); 
		query.append("   	   , P.UPD_USR_ID" ).append("\n"); 
		query.append("FROM SAR_ADJ_HIS P," ).append("\n"); 
		query.append("     SAR_OTS_HIS Q" ).append("\n"); 
		query.append("WHERE P.OTS_HIS_SEQ = Q.OTS_HIS_SEQ" ).append("\n"); 
		query.append("AND P.ADJ_NO IN (" ).append("\n"); 
		query.append("#foreach( $key IN ${adj_no_list}) " ).append("\n"); 
		query.append("	#if($velocityCount < $adj_no_list.size())" ).append("\n"); 
		query.append("  		'$key'," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		'$key'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND P.ADJ_STS_CD = @[sts_cd]" ).append("\n"); 

	}
}