/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeInputInquiryDBDAOsearchSurchargeCodeNameListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.10.19 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeInputInquiryDBDAOsearchSurchargeCodeNameListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSurchargeCodeNameList
	  * </pre>
	  */
	public SurchargeInputInquiryDBDAOsearchSurchargeCodeNameListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.integration ").append("\n"); 
		query.append("FileName : SurchargeInputInquiryDBDAOsearchSurchargeCodeNameListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("LGS_COST_FULL_NM" ).append("\n"); 
		query.append("FROM TES_LGS_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_SUBJ_CD IN ('SC', 'SM')" ).append("\n"); 

	}
}