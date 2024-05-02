/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOremoveAutoSettlementTemporaryListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.06 
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

public class AccountReceivableAdjustDBDAOremoveAutoSettlementTemporaryListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Temporary Table 삭제
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOremoveAutoSettlementTemporaryListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOremoveAutoSettlementTemporaryListDSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("FROM   SAR_AUTO_STL_TMP" ).append("\n"); 
		query.append("WHERE CRE_DT < SYSDATE - 30" ).append("\n"); 

	}
}