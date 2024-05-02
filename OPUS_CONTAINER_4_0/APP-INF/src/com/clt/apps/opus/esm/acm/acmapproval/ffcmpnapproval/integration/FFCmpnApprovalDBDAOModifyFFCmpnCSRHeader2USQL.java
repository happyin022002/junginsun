/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRHeader2USQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.10 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOModifyFFCmpnCSRHeader2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ModifyFFCmpnHeader2
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOModifyFFCmpnCSRHeader2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n");
		query.append("FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRHeader2USQL").append("\n");
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
		query.append("/* AP_INV_HDR UPDATE */" ).append("\n");
		query.append("UPDATE AP_INV_HDR " ).append("\n");
		query.append("   SET IF_DT = SYSDATE, " ).append("\n");
		query.append("       IF_ERR_RSN = 'APPROVAL REQUEST!'" ).append("\n");
		query.append(" WHERE CSR_NO = @[csr_no]" ).append("\n");

	}
}