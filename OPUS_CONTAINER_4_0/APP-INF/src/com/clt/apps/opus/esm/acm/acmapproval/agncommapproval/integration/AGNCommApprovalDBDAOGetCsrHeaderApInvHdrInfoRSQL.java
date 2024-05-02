/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOGetCsrHeaderApInvHdrInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.27
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.06.27 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOGetCsrHeaderApInvHdrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * AP_INV_HDR 정보를 조회한다.
	  * </pre>
	  */
	public AGNCommApprovalDBDAOGetCsrHeaderApInvHdrInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration ").append("\n");
		query.append("FileName : AGNCommApprovalDBDAOGetCsrHeaderApInvHdrInfoRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("           A.TJ_OFC_CD," ).append("\n");
		query.append("         (" ).append("\n");
		query.append("               SELECT" ).append("\n");
		query.append("                      COUNT (DISTINCT ATTR_CTNT1)" ).append("\n");
		query.append("                 FROM AP_INV_DTRB" ).append("\n");
		query.append("                WHERE CSR_NO = A.CSR_NO" ).append("\n");
		query.append("         ) AS DTRB_CNT," ).append("\n");
		query.append("           A.VNDR_NO," ).append("\n");
		query.append("           A.INV_TERM_DT," ).append("\n");
		query.append("           A.CSR_CURR_CD," ).append("\n");
		query.append("           A.CSR_AMT," ).append("\n");
		query.append("           A.CRE_USR_ID," ).append("\n");
		query.append("		   A.CSR_NO" ).append("\n");
		query.append("      FROM AP_INV_HDR A" ).append("\n");
		query.append("     WHERE A.CSR_NO = @[csr_no]" ).append("\n");

	}
}