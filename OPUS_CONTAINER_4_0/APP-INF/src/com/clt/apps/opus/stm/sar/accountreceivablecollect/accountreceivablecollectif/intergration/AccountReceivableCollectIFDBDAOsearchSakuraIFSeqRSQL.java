/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCollectIFDBDAOsearchSakuraIFSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCollectIFDBDAOsearchSakuraIFSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSakuraIFSeq
	  * </pre>
	  */
	public AccountReceivableCollectIFDBDAOsearchSakuraIFSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration").append("\n"); 
		query.append("FileName : AccountReceivableCollectIFDBDAOsearchSakuraIFSeqRSQL").append("\n"); 
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
		query.append("SELECT SAR_AR_IF_SEQ.NEXTVAL AR_IF_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}