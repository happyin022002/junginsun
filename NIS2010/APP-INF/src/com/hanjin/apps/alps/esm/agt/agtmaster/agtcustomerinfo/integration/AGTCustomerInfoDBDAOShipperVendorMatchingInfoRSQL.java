/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTCustomerInfoDBDAOShipperVendorMatchingInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.04.22 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCustomerInfoDBDAOShipperVendorMatchingInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_058 화면 조회
	  * </pre>
	  */
	public AGTCustomerInfoDBDAOShipperVendorMatchingInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.integration").append("\n"); 
		query.append("FileName : AGTCustomerInfoDBDAOShipperVendorMatchingInfoRSQL").append("\n"); 
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
		query.append("ROWNUM," ).append("\n"); 
		query.append("A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000') AS CUST_CNT_FF," ).append("\n"); 
		query.append("TO_CHAR(A.VNDR_SEQ,'FM000000') AS VNDR_SEQ," ).append("\n"); 
		query.append("NVL(A.CUST_NM,(SELECT" ).append("\n"); 
		query.append("CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("AND NVL(CNTR_DIV_FLG,'Y') = 'Y'" ).append("\n"); 
		query.append("AND NVL(RVIS_CNTR_CUST_TP_CD,'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N')" ).append("\n"); 
		query.append(") AS CUST_NM," ).append("\n"); 
		query.append("A.CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("A.CUST_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("A.VNDR_CNT_CD AS VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ AS VNDR_SEQ2," ).append("\n"); 
		query.append("A.VNDR_CNT_CD AS VNDR_CNT_CD2" ).append("\n"); 
		query.append("FROM AGT_CMPN_CUST_MTCH A" ).append("\n"); 
		query.append("#if (${cust_cnt_seq} != '')" ).append("\n"); 
		query.append("WHERE CONCAT(A.CUST_CNT_CD, TO_CHAR(A.CUST_SEQ, 'FM000000')) LIKE @[cust_cnt_seq]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000')," ).append("\n"); 
		query.append("TO_CHAR(A.VNDR_SEQ,'FM000000')" ).append("\n"); 

	}
}