/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCustomerInfoDBDAOGetCustomerFromCustVendorMatchForSCompInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.11 김상수
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

public class ACMCustomerInfoDBDAOGetCustomerFromCustVendorMatchForSCompInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ACMCustomerInfoDBDAOGetCustomerFromCustVendorMatchForSCompInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.integration").append("\n"); 
		query.append("FileName : ACMCustomerInfoDBDAOGetCustomerFromCustVendorMatchForSCompInfoRSQL").append("\n"); 
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
		query.append("SELECT CUST_CNT_CD||TO_CHAR(CUST_SEQ,'FM000000') AS CUST_CNT_SEQ" ).append("\n"); 
		query.append("  FROM ACM_SPCL_CUST_VNDR_MTCH" ).append("\n"); 
		query.append(" WHERE CUST_CNT_CD = SUBSTR(@[cust_cnt_seq], 1, 2)" ).append("\n"); 
		query.append("   AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cnt_seq], 3))" ).append("\n"); 
		query.append("   AND VNDR_CNT_CD = @[vndr_cnt_cd]" ).append("\n"); 
		query.append("   AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}