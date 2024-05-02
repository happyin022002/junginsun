/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSAgreementAgmtSeqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.02.10 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchCHSAgreementAgmtSeqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchCHSAgreementAgmtSeqData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchCHSAgreementAgmtSeqDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchCHSAgreementAgmtSeqDataRSQL").append("\n"); 
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
		query.append("SELECT CASE" ).append("\n"); 
		query.append("          WHEN NVL(MAX(AGMT_SEQ), 0) + 1 = 999998" ).append("\n"); 
		query.append("          THEN 1000000" ).append("\n"); 
		query.append("          ELSE NVL(MAX(AGMT_SEQ), 0) + 1" ).append("\n"); 
		query.append("       END AS AGMT_SEQ" ).append("\n"); 
		query.append("  FROM CGM_AGREEMENT" ).append("\n"); 
		query.append("WHERE AGMT_SEQ NOT IN (999999, 999998)" ).append("\n"); 

	}
}