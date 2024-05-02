/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseApprovalDBDAOMisUseRequestNoItemsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.17 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MisUseApprovalDBDAOMisUseRequestNoItemsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인대상 Miss Use Request No. 목록을 조회한다.
	  * </pre>
	  */
	public MisUseApprovalDBDAOMisUseRequestNoItemsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration").append("\n"); 
		query.append("FileName : MisUseApprovalDBDAOMisUseRequestNoItemsRSQL").append("\n"); 
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
		query.append("SELECT  RQST_NO" ).append("\n"); 
		query.append("FROM    LSE_MSS_USD_RQST" ).append("\n"); 
		query.append("WHERE   APRO_NO IS NULL" ).append("\n"); 
		query.append("ORDER BY RQST_NO" ).append("\n"); 

	}
}