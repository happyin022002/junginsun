/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchEviCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.21 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSearchEviCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 세금계산서 코드목록을 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchEviCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchEviCodeListRSQL").append("\n"); 
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
		query.append("SELECT 	WKPLC_NM WKPLC_NMSTRING" ).append("\n"); 
		query.append("FROM  	AP_WORKPLACE" ).append("\n"); 

	}
}