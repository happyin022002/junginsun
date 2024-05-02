/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementImportDBDAOCreateNewAgmtTmpSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.12
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.07.12 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOCreateNewAgmtTmpSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_AGMT_TMP_SEQ1 sequence조회
	  * </pre>
	  */
	public AgreementImportDBDAOCreateNewAgmtTmpSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ").append("\n"); 
		query.append("FileName : AgreementImportDBDAOCreateNewAgmtTmpSeqRSQL").append("\n"); 
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
		query.append("SELECT TRS_AGMT_TMP_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}