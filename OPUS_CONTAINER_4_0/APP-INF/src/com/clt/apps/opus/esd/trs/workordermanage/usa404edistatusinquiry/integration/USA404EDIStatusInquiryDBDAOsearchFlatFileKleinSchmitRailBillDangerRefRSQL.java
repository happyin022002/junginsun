/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRefRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRefRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFlatFileKleinSchmitRailBillDangerRef
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRefRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration ").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRefRSQL").append("\n"); 
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
		query.append("SELECT '' AS DOT_TYPE," ).append("\n"); 
		query.append("'' AS DOT_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}