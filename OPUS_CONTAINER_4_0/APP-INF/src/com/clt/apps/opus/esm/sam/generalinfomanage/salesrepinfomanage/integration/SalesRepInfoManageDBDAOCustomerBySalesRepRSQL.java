/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesRepInfoManageDBDAOCustomerBySalesRepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.21
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.06.21 이창원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRepInfoManageDBDAOCustomerBySalesRepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SalesRepInfoManageDBDAOCustomerBySalesRep
	  * </pre>
	  */
	public SalesRepInfoManageDBDAOCustomerBySalesRepRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration").append("\n"); 
		query.append("FileName : SalesRepInfoManageDBDAOCustomerBySalesRepRSQL").append("\n"); 
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
		query.append("SELECT X.PRIMARY_SREP_CD AS PRIMARY_SREP_CD" ).append("\n"); 
		query.append(",X.CUST_CNT_CD || LPAD(X.CUST_SEQ, 6, 0) AS CUSTOMER_CODE" ).append("\n"); 
		query.append(",C.CUST_LGL_ENG_NM AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",C.LOC_CD AS LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",(SELECT P.INTL_PHN_NO||P.PHN_NO" ).append("\n"); 
		query.append("FROM   MDM_CUST_CNTC_PNT P" ).append("\n"); 
		query.append("WHERE  C.CUST_CNT_CD = P.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    C.CUST_SEQ = P.CUST_SEQ" ).append("\n"); 
		query.append("AND    P.CUST_CNTC_PNT_SEQ = (SELECT MAX(CUST_CNTC_PNT_SEQ)" ).append("\n"); 
		query.append("FROM   MDM_CUST_CNTC_PNT" ).append("\n"); 
		query.append("WHERE  CUST_CNT_CD = X.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    CUST_SEQ = X.CUST_SEQ)" ).append("\n"); 
		query.append(")PHN_NO" ).append("\n"); 
		query.append(",C.INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append(",X.FLG" ).append("\n"); 
		query.append(",X.SREP_CD" ).append("\n"); 
		query.append(",X.CUST_CNT_CD" ).append("\n"); 
		query.append(",X.CUST_SEQ" ).append("\n"); 
		query.append("--	  ,C.OFC_CD" ).append("\n"); 
		query.append("FROM   (SELECT B.SREP_CD ," ).append("\n"); 
		query.append("A.SREP_CD PRIMARY_SREP_CD ," ).append("\n"); 
		query.append("B.SREP_PRMRY_FLG FLG," ).append("\n"); 
		query.append("B.CUST_CNT_CD ," ).append("\n"); 
		query.append("B.CUST_SEQ" ).append("\n"); 
		query.append("FROM   SAM_CUST_SLS_REP_INFO A ," ).append("\n"); 
		query.append("SAM_CUST_SLS_REP_INFO B" ).append("\n"); 
		query.append("WHERE  A.CUST_CNT_CD(+) = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    A.CUST_SEQ(+) = B.CUST_SEQ" ).append("\n"); 
		query.append("AND    A.SREP_PRMRY_FLG(+) = 'Y'" ).append("\n"); 
		query.append("AND    B.SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append(") X ," ).append("\n"); 
		query.append("MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE  C.CUST_CNT_CD = X.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    C.CUST_SEQ = X.CUST_SEQ" ).append("\n"); 
		query.append("ORDER BY X.CUST_CNT_CD, X.CUST_SEQ" ).append("\n"); 

	}
}