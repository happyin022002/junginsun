/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchMGSAgreementAgmtSeqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.16 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM CHANG SIK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchMGSAgreementAgmtSeqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchMGSAgreementAgmtSeqData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchMGSAgreementAgmtSeqDataRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("CASE WHEN MAX(AGMT_SEQ) + 1 = 999998" ).append("\n"); 
		query.append("THEN 1000000" ).append("\n"); 
		query.append("ELSE MAX(AGMT_SEQ) + 1 END 	AS AGMT_SEQ" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT" ).append("\n"); 
		query.append("WHERE AGMT_SEQ NOT IN (999999, 999998)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration ").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchMGSAgreementAgmtSeqDataRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}