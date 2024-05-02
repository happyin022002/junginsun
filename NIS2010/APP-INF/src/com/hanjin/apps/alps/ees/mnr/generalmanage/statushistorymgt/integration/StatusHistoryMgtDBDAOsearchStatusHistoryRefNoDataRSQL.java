/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHistoryMgtDBDAOsearchStatusHistoryRefNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.25 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusHistoryMgtDBDAOsearchStatusHistoryRefNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusHistory 의 Ref No 생성 조회
	  * </pre>
	  */
	public StatusHistoryMgtDBDAOsearchStatusHistoryRefNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.integration ").append("\n"); 
		query.append("FileName : StatusHistoryMgtDBDAOsearchStatusHistoryRefNoDataRSQL").append("\n"); 
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
		query.append("SELECT MAX(NVL(MNR_STS_REF_NO,0))+1 FROM MNR_STS_HIS" ).append("\n"); 

	}
}