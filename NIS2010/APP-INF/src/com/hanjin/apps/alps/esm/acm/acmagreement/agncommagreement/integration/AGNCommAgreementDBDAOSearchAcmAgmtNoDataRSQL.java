/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommAgreementDBDAOSearchAcmAgmtNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.10
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2014.02.10 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YOUNJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAgreementDBDAOSearchAcmAgmtNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAcmAgmtNoData
	  * </pre>
	  */
	public AGNCommAgreementDBDAOSearchAcmAgmtNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration").append("\n"); 
		query.append("FileName : AGNCommAgreementDBDAOSearchAcmAgmtNoDataRSQL").append("\n"); 
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
		query.append("SELECT AGN_AGMT_NO FROM ACM_AGN_AGMT_MST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AGN_AGMT_NO = @[agmt_no]" ).append("\n"); 

	}
}