/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsReportDBDAOUsaVesselArrivalCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.30 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOUsaVesselArrivalCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, UsaVesselArrivalCondVO 생성용
	  * </pre>
	  */
	public UsaCustomsReportDBDAOUsaVesselArrivalCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration ").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOUsaVesselArrivalCondRSQL").append("\n"); 
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
		query.append("SELECT '' vvd, '' port FROM DUAL" ).append("\n"); 

	}
}