/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PartnerDBDAOSearchCustAddrIfSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchCustAddrIfSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_CUST_ADDR_IF 테이블의 CUST_ADDR_IF_SEQ 를 채번한다.
	  * </pre>
	  */
	public PartnerDBDAOSearchCustAddrIfSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchCustAddrIfSeqRSQL").append("\n"); 
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
		query.append("SELECT MDM_CUST_ADDR_IF_SEQ.NEXTVAL cust_addr_if_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}