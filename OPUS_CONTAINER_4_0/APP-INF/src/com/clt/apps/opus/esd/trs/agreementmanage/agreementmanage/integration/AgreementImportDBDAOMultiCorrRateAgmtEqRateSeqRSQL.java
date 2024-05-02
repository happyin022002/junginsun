/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrRateAgmtEqRateSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.16
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.16 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOMultiCorrRateAgmtEqRateSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Rate Seqence 채번
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrRateAgmtEqRateSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOMultiCorrRateAgmtEqRateSeqRSQL").append("\n"); 
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
		query.append("SELECT LEVEL, TRS_AGMT_SCG_RT_SEQ1.NEXTVAL AS EQ_RT_SEQ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= ${new_agmt_cnt}" ).append("\n"); 

	}
}