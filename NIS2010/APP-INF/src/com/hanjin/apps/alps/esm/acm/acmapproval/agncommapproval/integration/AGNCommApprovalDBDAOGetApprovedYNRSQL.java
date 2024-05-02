/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommApprovalDBDAOGetApprovedYNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOGetApprovedYNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR_USD_AMT(최초총액)(AP_COM_GET_USD_XCH_AMT_FNC FUNCTION)
	  * 에 따른 approvedYN (GW & ALPS 결재라인결정)
	  * ACM인경우, 10만불 이상일때 GW결재창을 사용(approvedYN = 'N')
	  *                   10만불 미만일때 기존 Approve 결재창을 사용(approvedYN = 'Y')
	  * 예외로 자동계산계정(512641) 인경우는 기존 ALPS Approve 결재창 사용
	  * </pre>
	  */
	public AGNCommApprovalDBDAOGetApprovedYNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOGetApprovedYNRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN " ).append("\n"); 
		query.append("				 AP_COM_GET_USD_XCH_AMT_FNC(@[curr_cd], ROUND(@[csr_amt], 2),SUBSTR(@[gl_dt], 0, 6)) " ).append("\n"); 
		query.append("				 >= 100000 THEN 'N' " ).append("\n"); 
		query.append("                           ELSE 'Y' " ).append("\n"); 
		query.append("        END AS APPROVED_YN" ).append("\n"); 
		query.append("   FROM DUAL " ).append("\n"); 

	}
}