/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchEQCtrlOfcCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.07.07 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchEQCtrlOfcCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Office Cd 조회
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchEQCtrlOfcCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchEQCtrlOfcCdListRSQL").append("\n"); 
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
		query.append("SELECT 'ALL' EQ_CTRL_OFC_CD FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT EQ_CTRL_OFC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE cnt_cd in ('US','CA','MX') AND EQ_CTRL_OFC_CD IS NOT NULL" ).append("\n"); 

	}
}