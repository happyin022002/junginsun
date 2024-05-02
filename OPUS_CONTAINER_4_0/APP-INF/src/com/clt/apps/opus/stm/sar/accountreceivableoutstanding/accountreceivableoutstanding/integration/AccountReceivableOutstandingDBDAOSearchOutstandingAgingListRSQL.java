/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchOutstandingAgingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOSearchOutstandingAgingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create list vo query
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchOutstandingAgingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration ").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchOutstandingAgingListRSQL").append("\n"); 
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
		query.append(" select" ).append("\n"); 
		query.append("  ''  col01" ).append("\n"); 
		query.append(", ''  col02" ).append("\n"); 
		query.append(", ''  col03" ).append("\n"); 
		query.append(", ''  col04" ).append("\n"); 
		query.append(", ''  col05" ).append("\n"); 
		query.append(", ''  col06" ).append("\n"); 
		query.append(", ''  col07" ).append("\n"); 
		query.append(", ''  col08" ).append("\n"); 
		query.append(", ''  col09" ).append("\n"); 
		query.append(", ''  col10" ).append("\n"); 
		query.append(", ''  col11" ).append("\n"); 
		query.append(", ''  col12" ).append("\n"); 
		query.append(", ''  col13" ).append("\n"); 
		query.append(", ''  col14" ).append("\n"); 
		query.append(", ''  col15" ).append("\n"); 
		query.append(", ''  col16" ).append("\n"); 
		query.append(", ''  col17" ).append("\n"); 
		query.append(", ''  col18" ).append("\n"); 
		query.append(", ''  col19" ).append("\n"); 
		query.append(", ''  col20" ).append("\n"); 
		query.append(", ''  col21" ).append("\n"); 
		query.append(", ''  col22" ).append("\n"); 
		query.append(", ''  col23" ).append("\n"); 
		query.append(", ''  col24" ).append("\n"); 
		query.append(", ''  col25" ).append("\n"); 
		query.append(", ''  col26" ).append("\n"); 
		query.append(", ''  col27" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}