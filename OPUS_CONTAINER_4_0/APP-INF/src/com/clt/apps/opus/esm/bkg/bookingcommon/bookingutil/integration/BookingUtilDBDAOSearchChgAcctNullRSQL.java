/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOSearchChgAcctNullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchChgAcctNullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHECKING MDM_CHARGE.CO_CHG_ACCT_CD NULL
	  * </pre>
	  */
	public BookingUtilDBDAOSearchChgAcctNullRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchChgAcctNullRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD" ).append("\n"); 
		query.append("  FROM MDM_CHARGE " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CO_CHG_ACCT_CD IS NULL" ).append("\n"); 
		query.append("#if(${chg_cd_list} != '')" ).append("\n"); 
		query.append("   AND CHG_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${chg_cd_list}) " ).append("\n"); 
		query.append("         #if($velocityCount < $chg_cd_list.size()) " ).append("\n"); 
		query.append("          '$key', " ).append("\n"); 
		query.append("         #else " ).append("\n"); 
		query.append("          '$key' " ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}