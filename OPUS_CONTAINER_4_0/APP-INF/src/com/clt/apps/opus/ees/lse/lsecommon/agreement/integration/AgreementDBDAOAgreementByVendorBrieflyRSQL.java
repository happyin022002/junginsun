/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementDBDAOAgreementByVendorBrieflyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.12 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.agreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementDBDAOAgreementByVendorBrieflyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement Briefly Search
	  * </pre>
	  */
	public AgreementDBDAOAgreementByVendorBrieflyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.agreement.integration").append("\n"); 
		query.append("FileName : AgreementDBDAOAgreementByVendorBrieflyRSQL").append("\n"); 
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
		query.append("SELECT A.AGMT_CTY_CD || A.AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append(", A.AGMT_CTY_CD" ).append("\n"); 
		query.append(", A.AGMT_SEQ" ).append("\n"); 
		query.append(", A.AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append(", A.VNDR_SEQ" ).append("\n"); 
		query.append(", A.LSTM_CD" ).append("\n"); 
		query.append(", A.OFC_CD" ).append("\n"); 
		query.append(", A.CURR_CD" ).append("\n"); 
		query.append(", A.REF_NO" ).append("\n"); 
		query.append(", A.LSE_CTRT_NO" ).append("\n"); 
		query.append(", C.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append(", C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", TO_CHAR(A.LST_EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.LST_EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append(", SUBSTR(C.VNDR_ABBR_NM,0,3)         AS VNDR_ABBR_NM" ).append("\n"); 
		query.append(", A.LSE_FREE_DYS" ).append("\n"); 
		query.append(", A.LSE_CTRT_NO" ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT A" ).append("\n"); 
		query.append(", MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE  A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ IN (" ).append("\n"); 
		query.append("#foreach($key IN ${vndr_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $vndr_seq.size())" ).append("\n"); 
		query.append("$key," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}