/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PartnerDBDAOSearchCustPerfIfSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchCustPerfIfSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_CUST_PERF_GRP_IF 테이블의 CUST_PERF_GRP_IF_SEQ 를 채번한다.
	  * </pre>
	  */
	public PartnerDBDAOSearchCustPerfIfSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration ").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchCustPerfIfSeqRSQL").append("\n"); 
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
		query.append("SELECT MDM_CUST_PERF_GRP_IF_SEQ.NEXTVAL cust_perf_grp_if_seq " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}