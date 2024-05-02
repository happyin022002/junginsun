/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementFileUploadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementFileUploadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement File Upload Search
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementFileUploadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementFileUploadRSQL").append("\n"); 
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
		query.append("SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.FILE_DTL_SEQ" ).append("\n"); 
		query.append("     , A.FILE_PATH_NM" ).append("\n"); 
		query.append("     , A.ORG_FILE_NM" ).append("\n"); 
		query.append("     , B.FILE_UPLD_NM" ).append("\n"); 
		query.append("     , B.FILE_SZ_CAPA" ).append("\n"); 
		query.append("     , B.FILE_PATH_URL" ).append("\n"); 
		query.append("FROM   LSE_AGMT_FILE_ATCH A, COM_UPLD_FILE B" ).append("\n"); 
		query.append("WHERE  A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND    A.ORG_FILE_NM = B.FILE_SAV_ID" ).append("\n"); 
		query.append("#if (${file_dtl_seq} != '')" ).append("\n"); 
		query.append("AND    A.FILE_DTL_SEQ = @[file_dtl_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER  BY A.AGMT_CTY_CD, A.AGMT_SEQ" ).append("\n"); 

	}
}