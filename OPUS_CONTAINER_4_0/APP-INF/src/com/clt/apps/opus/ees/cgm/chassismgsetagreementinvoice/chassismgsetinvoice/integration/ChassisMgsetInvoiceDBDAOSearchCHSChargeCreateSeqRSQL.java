/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSChargeCreateSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.18 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM CHANG SIK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSChargeCreateSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSChargeCreateSeq
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSChargeCreateSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration ").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSChargeCreateSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(CHG_CRE_SEQ),0) + 1 AS CHG_CRE_SEQ" ).append("\n"); 
		query.append("FROM CGM_LSE_CHG_HDR" ).append("\n"); 

	}
}