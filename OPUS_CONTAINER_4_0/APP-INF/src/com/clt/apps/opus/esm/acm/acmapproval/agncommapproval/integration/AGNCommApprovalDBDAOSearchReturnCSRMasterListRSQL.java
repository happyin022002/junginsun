/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AGNCommApprovalDBDAOSearchReturnCSRMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOSearchReturnCSRMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACMCommVendorInfo
	  * </pre>
	  */
	public AGNCommApprovalDBDAOSearchReturnCSRMasterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOSearchReturnCSRMasterListRSQL").append("\n"); 
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
		query.append("WITH A AS (SELECT CSR_NO , COUNT(distinct bkg_no) AS BKG_CNT" ).append("\n"); 
		query.append("             FROM ACM_AGN_COMM A" ).append("\n"); 
		query.append("            WHERE AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("              AND A.APRO_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("              AND CSR_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${csr_no} != '')" ).append("\n"); 
		query.append("             AND CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            GROUP BY CSR_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.CSR_NO, A.BKG_CNT" ).append("\n"); 
		query.append("  FROM A, AP_INV_HDR I" ).append("\n"); 
		query.append(" WHERE A.CSR_NO = I.CSR_NO" ).append("\n"); 
		query.append("   AND NVL(I.IF_FLG,'N') = 'E'" ).append("\n"); 

	}
}