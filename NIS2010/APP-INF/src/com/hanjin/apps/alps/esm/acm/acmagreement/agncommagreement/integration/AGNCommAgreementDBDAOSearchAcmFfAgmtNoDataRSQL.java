/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommAgreementDBDAOSearchAcmFfAgmtNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.13
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2014.02.13 이윤정
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

public class AGNCommAgreementDBDAOSearchAcmFfAgmtNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAcmFfAgmtNoData
	  * </pre>
	  */
	public AGNCommAgreementDBDAOSearchAcmFfAgmtNoDataRSQL(){
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
		query.append("FileName : AGNCommAgreementDBDAOSearchAcmFfAgmtNoDataRSQL").append("\n"); 
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
		query.append("SELECT NEW_AGMT_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT FF_CNT_CD||LPAD(FF_SEQ,6,'0') NEW_AGMT_NO" ).append("\n"); 
		query.append("    FROM ACM_FF_AGMT " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND FF_CNT_CD         = SUBSTR(@[agmt_no],1,2)" ).append("\n"); 
		query.append("    AND TO_CHAR(FF_SEQ)   = SUBSTR(@[agmt_no],3,6)" ).append("\n"); 
		query.append("    AND DELT_FLG          = 'N'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT FF_CNT_CD||LPAD(FF_SEQ,6,'0') " ).append("\n"); 
		query.append("    FROM ACM_FAC_AGMT " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND FF_CNT_CD         = SUBSTR(@[agmt_no],1,2)" ).append("\n"); 
		query.append("    AND TO_CHAR(FF_SEQ)   = SUBSTR(@[agmt_no],3,6)" ).append("\n"); 
		query.append("    AND DELT_FLG          = 'N'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') " ).append("\n"); 
		query.append("    FROM ACM_SPCL_AGMT" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND CUST_CNT_CD       = SUBSTR(@[agmt_no],1,2)" ).append("\n"); 
		query.append("    AND TO_CHAR(CUST_SEQ) = SUBSTR(@[agmt_no],3,6)" ).append("\n"); 
		query.append("    AND DELT_FLG          = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}