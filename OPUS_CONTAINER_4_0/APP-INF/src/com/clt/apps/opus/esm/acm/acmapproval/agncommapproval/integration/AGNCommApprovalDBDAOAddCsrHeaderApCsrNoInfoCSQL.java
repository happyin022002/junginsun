/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOAddCsrHeaderApCsrNoInfoCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.06.28 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOAddCsrHeaderApCsrNoInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * AP_CSR_NO에 CSR_NO를 생성한다.
	  * </pre>
	  */
	public AGNCommApprovalDBDAOAddCsrHeaderApCsrNoInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n");
		query.append("FileName : AGNCommApprovalDBDAOAddCsrHeaderApCsrNoInfoCSQL").append("\n");
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
		query.append("INSERT INTO AP_CSR_NO" ).append("\n");
		query.append("        ( CSR_NO," ).append("\n");
		query.append("          CRE_USR_ID," ).append("\n");
		query.append("          CRE_DT" ).append("\n");
		query.append("         )" ).append("\n");
		query.append("   VALUES" ).append("\n");
		query.append("        ( @[csr_no]," ).append("\n");
		query.append("          @[cre_usr_id]," ).append("\n");
		query.append("          SYSDATE" ).append("\n");
		query.append("         )" ).append("\n");

	}
}