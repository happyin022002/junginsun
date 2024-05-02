/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ServiceDBDAOSearchSlaneIfSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOSearchSlaneIfSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_VSL_SVC_LANE_IF 테이블의 VSL_SLAN_SEQ 를 채번한다.
	  * </pre>
	  */
	public ServiceDBDAOSearchSlaneIfSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOSearchSlaneIfSeqRSQL").append("\n"); 
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
		query.append("SELECT MDM_VSL_SVC_LANE_IF_SEQ.NEXTVAL vsl_slan_if_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}