/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOManualKeyByRateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOManualKeyByRateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회된 Rate 정보를 저장할 VO 객체 생성을 위한 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOManualKeyByRateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOManualKeyByRateVORSQL").append("\n"); 
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
		query.append("SELECT	DMDT_INV_NO" ).append("\n"); 
		query.append(",	INV_DTL_SEQ" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	INV_RT_SEQ" ).append("\n"); 
		query.append(",	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	BZC_DMDT_TRF_CD" ).append("\n"); 
		query.append(",	BZC_TRF_SEQ" ).append("\n"); 
		query.append(",	BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",	BZC_TRF_RT_SEQ" ).append("\n"); 
		query.append(",	FT_OVR_DYS" ).append("\n"); 
		query.append(",	FT_UND_DYS" ).append("\n"); 
		query.append(",	INV_RT_AMT" ).append("\n"); 
		query.append(",	RT_OVR_DYS" ).append("\n"); 
		query.append(",	RT_OVR_CHG_AMT" ).append("\n"); 
		query.append(",	BZC_CURR_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_INV_RT" ).append("\n"); 

	}
}