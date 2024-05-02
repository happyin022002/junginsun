/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireContainerAgreementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireContainerAgreementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.05.17/ Jiyeon Jeon - Target Off-hire location이 지정된 agmt의 정보를 불러온다.
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireContainerAgreementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration ").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireContainerAgreementRSQL").append("\n"); 
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
		query.append("select *" ).append("\n"); 
		query.append("  from dual" ).append("\n"); 

	}
}