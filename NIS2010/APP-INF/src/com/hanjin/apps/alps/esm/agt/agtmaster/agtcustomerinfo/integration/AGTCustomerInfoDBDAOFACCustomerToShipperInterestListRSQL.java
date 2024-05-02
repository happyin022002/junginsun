/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCustomerInfoDBDAOFACCustomerToShipperInterestListRSQL.java
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

public class AGTCustomerInfoDBDAOFACCustomerToShipperInterestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_030 화면 조회
	  * </pre>
	  */
	public AGTCustomerInfoDBDAOFACCustomerToShipperInterestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.integration").append("\n"); 
		query.append("FileName : AGTCustomerInfoDBDAOFACCustomerToShipperInterestListRSQL").append("\n"); 
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
		query.append("CUST_CNT_CD || LTRIM(TO_CHAR(CUST_SEQ,'000000')) AS CUST_CD_SEQ," ).append("\n"); 
		query.append("CUST_NM," ).append("\n"); 
		query.append("SHPR_CNT_CD || LTRIM(TO_CHAR(SHPR_SEQ,'000000')) AS SHPR_CD_SEQ," ).append("\n"); 
		query.append("SHPR_NM," ).append("\n"); 
		query.append("FAC_OFC_CD," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("SHPR_CNT_CD," ).append("\n"); 
		query.append("SHPR_SEQ," ).append("\n"); 
		query.append("FAC_OFC_CD AS FAC_OFC_CD2," ).append("\n"); 
		query.append("CUST_CNT_CD AS CUST_CNT_CD2," ).append("\n"); 
		query.append("CUST_SEQ AS CUST_SEQ2," ).append("\n"); 
		query.append("SHPR_CNT_CD AS SHPR_CNT_CD2," ).append("\n"); 
		query.append("SHPR_SEQ AS SHPR_SEQ2" ).append("\n"); 
		query.append("FROM AGT_FAC_CUST_RLT" ).append("\n"); 
		query.append("#if (${fac_ofc_cd} != '')" ).append("\n"); 
		query.append("WHERE FAC_OFC_CD = @[fac_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}