/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustomerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustomerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomerVO 생성 쿼리
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustomerVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustomerVORSQL").append("\n"); 
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
		query.append("SELECT A.CUST_CNT_CD,A.CUST_SEQ, -- CCD 넘길때 사용" ).append("\n"); 
		query.append("       A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') CUST_CD,A.CUST_LGL_ENG_NM,A.LOC_CD,A.OFC_CD,B.SREP_CD PRE_SREP_CD,B.SREP_CD,B.SREP_PRMRY_FLG,A.CUST_STS_CD,TO_CHAR(A.UPD_DT,'YYYY-MM-DD') LST_UPD_DT" ).append("\n"); 
		query.append("   FROM MDM_CUSTOMER A,SAM_CUST_SLS_REP_INFO B" ).append("\n"); 
		query.append("  WHERE B.SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("  AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("  AND A.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("and b.delt_flg = 'N'" ).append("\n"); 

	}
}