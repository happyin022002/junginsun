/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCustomerInfoDBDAOSearchFFVendorMatchListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.07 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCustomerInfoDBDAOSearchFFVendorMatchListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ACMCustomerInfoDBDAOSearchFFVendorMatchListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.integration").append("\n"); 
		query.append("FileName : ACMCustomerInfoDBDAOSearchFFVendorMatchListRSQL").append("\n"); 
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
		query.append("SELECT A.FF_CNT_CD||TO_CHAR(A.FF_SEQ,'FM000000') AS FF_CNT_SEQ," ).append("\n"); 
		query.append("       (SELECT MAX(NVL(LTRIM(C.CUST_LGL_ENG_NM), ' '))" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("         WHERE C.CUST_CNT_CD(+) = A.FF_CNT_CD" ).append("\n"); 
		query.append("           AND C.CUST_SEQ(+) = A.FF_SEQ" ).append("\n"); 
		query.append("           AND C.CNTR_DIV_FLG(+) = 'Y' ) AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       TO_CHAR(A.VNDR_SEQ,'FM000000') AS VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT NVL(VNDR_LGL_ENG_NM, VNDR_LOCL_LANG_NM)" ).append("\n"); 
		query.append("          FROM MDM_VENDOR" ).append("\n"); 
		query.append("         WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.FF_CNT_CD," ).append("\n"); 
		query.append("       A.FF_SEQ AS ORG_FF_SEQ," ).append("\n"); 
		query.append("       A.VNDR_CNT_CD," ).append("\n"); 
		query.append("       A.VNDR_CNT_CD AS ORG_VNDR_CNT_CD," ).append("\n"); 
		query.append("       A.VNDR_SEQ AS ORG_VNDR_SEQ" ).append("\n"); 
		query.append("  FROM ACM_FF_VNDR_MTCH A" ).append("\n"); 
		query.append(" WHERE A.FF_CNT_CD = @[ff_cnt_cd]" ).append("\n"); 
		query.append(" ORDER BY A.FF_CNT_CD||TO_CHAR(A.FF_SEQ,'FM000000')," ).append("\n"); 
		query.append("          TO_CHAR(A.VNDR_SEQ,'FM000000')" ).append("\n"); 

	}
}