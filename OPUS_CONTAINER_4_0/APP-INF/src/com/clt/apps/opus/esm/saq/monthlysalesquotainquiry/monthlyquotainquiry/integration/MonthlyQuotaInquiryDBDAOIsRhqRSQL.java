/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaInquiryDBDAOIsRhqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.03.05 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaInquiryDBDAOIsRhqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * isRhq SQL 파일을 만들기 위한 파일
	  * </pre>
	  */
	public MonthlyQuotaInquiryDBDAOIsRhqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("orgCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaInquiryDBDAOIsRhqRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      DECODE(NVL(MIN(OFC_CD), 'X'), 'X', 'X', 'O') AS IS_RHQ " ).append("\n"); 
		query.append("FROM  SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("WHERE LVL = 2 " ).append("\n"); 
		query.append("AND   OFC_CD = @[orgCd]" ).append("\n"); 

	}
}