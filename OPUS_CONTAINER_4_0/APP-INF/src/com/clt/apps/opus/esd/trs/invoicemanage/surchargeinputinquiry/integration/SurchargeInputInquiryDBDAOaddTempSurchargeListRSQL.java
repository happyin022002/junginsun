/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SurchargeInputInquiryDBDAOaddTempSurchargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration").append("\n"); 
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
		query.append("--SELECT TRS_TRSP_SCG_DTL_TMP_SEQ1.NEXTVAL AS GROUP_SEQ FROM DUAL" ).append("\n"); 
		query.append("SELECT trs_trsp_wrk_ord_prv_tmp_seq1.NEXTVAL group_seq	" ).append("\n"); 
		query.append("  FROM dual" ).append("\n"); 

	}
}