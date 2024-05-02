/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeInputInquiryDBDAOaddTempSurchargeListRSQL.java
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

public class SurchargeInputInquiryDBDAOaddTempSurchargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addTempSurchargeList
	  * </pre>
	  */
	public SurchargeInputInquiryDBDAOaddTempSurchargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.integration ").append("\n"); 
		query.append("FileName : SurchargeInputInquiryDBDAOaddTempSurchargeListRSQL").append("\n"); 
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
		query.append("TRS_TRSP_SCG_DTL_TMP_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("AS GROUP_SEQ FROM DUAL" ).append("\n"); 

	}
}