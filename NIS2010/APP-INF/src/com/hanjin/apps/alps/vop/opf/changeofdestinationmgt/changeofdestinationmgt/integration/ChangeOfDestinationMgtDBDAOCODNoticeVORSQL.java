/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCODNoticeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.12.24 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOCODNoticeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCODNoticeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration ").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCODNoticeVORSQL").append("\n"); 
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
		query.append("select '' AS SNDR_USR_ID" ).append("\n"); 
		query.append(",      '' AS SNDR_USR_NM" ).append("\n"); 
		query.append(",      '' AS MSG_CTNT" ).append("\n"); 
		query.append(",      '' AS RCVR_USR_ID" ).append("\n"); 
		query.append(",      '' AS RCVR_USR_NM" ).append("\n"); 
		query.append(",      '' AS CNTR_NO" ).append("\n"); 
		query.append(",      '' AS BKG_NO" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}