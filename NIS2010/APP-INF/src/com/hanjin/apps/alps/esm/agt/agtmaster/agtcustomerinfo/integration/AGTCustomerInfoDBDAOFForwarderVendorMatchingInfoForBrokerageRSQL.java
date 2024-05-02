/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCustomerInfoDBDAOFForwarderVendorMatchingInfoForBrokerageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCustomerInfoDBDAOFForwarderVendorMatchingInfoForBrokerageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_025 화면 조회
	  * </pre>
	  */
	public AGTCustomerInfoDBDAOFForwarderVendorMatchingInfoForBrokerageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.integration").append("\n"); 
		query.append("FileName : AGTCustomerInfoDBDAOFForwarderVendorMatchingInfoForBrokerageRSQL").append("\n"); 
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
		query.append("FROM AGT_BROG_CUST_MTCH A" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000')," ).append("\n"); 
		query.append("TO_CHAR(A.VNDR_SEQ,'FM000000')" ).append("\n"); 

	}
}