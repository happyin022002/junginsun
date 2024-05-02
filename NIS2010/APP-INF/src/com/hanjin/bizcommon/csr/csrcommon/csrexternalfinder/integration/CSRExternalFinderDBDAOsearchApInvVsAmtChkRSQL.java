/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CSRExternalFinderDBDAOsearchApInvVsAmtChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.10.12 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRExternalFinderDBDAOsearchApInvVsAmtChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 비교할 INV_AMT 와 Currency에따른 소수점 적용된 INV_AMT 비교 체크 - 결과값이 0 이아니면 CSR00081에러
	  * </pre>
	  */
	public CSRExternalFinderDBDAOsearchApInvVsAmtChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.integration").append("\n"); 
		query.append("FileName : CSRExternalFinderDBDAOsearchApInvVsAmtChkRSQL").append("\n"); 
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
		query.append("SELECT ( MAX(A.INV_NET_AMT) - SUM(B.INV_AMT) ) AS amtChk" ).append("\n"); 
		query.append("FROM AP_PAY_INV A" ).append("\n"); 
		query.append(",AP_PAY_INV_DTL B" ).append("\n"); 
		query.append("WHERE A.INV_RGST_NO = B.INV_RGST_NO" ).append("\n"); 
		query.append("AND A.INV_RGST_NO = @[inv_rqst_no]" ).append("\n"); 

	}
}