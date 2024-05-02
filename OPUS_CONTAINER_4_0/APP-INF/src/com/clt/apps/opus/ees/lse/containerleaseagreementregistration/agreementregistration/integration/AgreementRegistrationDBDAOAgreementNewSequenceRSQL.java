/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementNewSequenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementNewSequenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement New Sequence Search
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementNewSequenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementNewSequenceRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(A.AGMT_SEQ), 0)+1 AS AGMT_SEQ" ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT A" ).append("\n"); 
		query.append("WHERE  A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ < 999990" ).append("\n"); 

	}
}