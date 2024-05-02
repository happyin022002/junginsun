/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOSearchMnrCrIssNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.05.03 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOSearchMnrCrIssNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R Credit Insert시 Credit Issue Number Search
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOSearchMnrCrIssNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOSearchMnrCrIssNoRSQL").append("\n"); 
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
		query.append("SELECT 'MNR'||TO_CHAR(SYSDATE,'YYYY')||LPAD(CR_ISS_NO,4,'0') CR_ISS_NO" ).append("\n"); 
		query.append("FROM ( SELECT CASE WHEN MAX(TO_NUMBER(SUBSTR(A.CR_ISS_NO,8,4))) IS NULL THEN 1" ).append("\n"); 
		query.append("                   ELSE MAX(TO_NUMBER(SUBSTR(A.CR_ISS_NO,8,4)))+1" ).append("\n"); 
		query.append("	           END AS CR_ISS_NO" ).append("\n"); 
		query.append("         FROM EAS_MNR_CR_ISS A" ).append("\n"); 
		query.append("        WHERE SUBSTR(A.CR_ISS_NO,1,7) = 'MNR'||TO_CHAR(SYSDATE,'YYYY')" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}