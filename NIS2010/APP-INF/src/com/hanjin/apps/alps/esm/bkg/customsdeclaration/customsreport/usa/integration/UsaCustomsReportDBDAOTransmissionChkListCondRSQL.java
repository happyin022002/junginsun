/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsReportDBDAOTransmissionChkListCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.29 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOTransmissionChkListCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0233 TransmissionChkListCondVO 생성용.
	  * </pre>
	  */
	public UsaCustomsReportDBDAOTransmissionChkListCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration ").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOTransmissionChkListCondRSQL").append("\n"); 
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
		query.append("SELECT 	'' vvd, '' pod, '' pol," ).append("\n"); 
		query.append("'' trunkfirst, '' bofc, '' blmi," ).append("\n"); 
		query.append("'' allerror, '' pgmno," ).append("\n"); 
		query.append("'' tmp1, '' tmp2, '' tmp3" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}