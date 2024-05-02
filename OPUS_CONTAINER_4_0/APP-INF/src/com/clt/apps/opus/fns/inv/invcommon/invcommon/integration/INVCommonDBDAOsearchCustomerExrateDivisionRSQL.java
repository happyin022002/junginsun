/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : INVCommonDBDAOsearchCustomerExrateDivisionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.12.15 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchCustomerExrateDivisionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCustomerExrateDivision
	  * </pre>
	  */
	public INVCommonDBDAOsearchCustomerExrateDivisionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cntry_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchCustomerExrateDivisionRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUBSTR(XCH_RT_DIV_CD, 1, 1), 'N') div_cd1," ).append("\n"); 
		query.append("NVL(SUBSTR(XCH_RT_DIV_CD, 2, 1), 'N') div_cd2," ).append("\n"); 
		query.append("NVL(DY_XCH_APLY_ST_DT, '99991231') aply_st_dt," ).append("\n"); 
		query.append("NVL(CNG_INDIV_CD, 'N') cng_indiv_cd" ).append("\n"); 
		query.append("FROM   MDM_CR_CUST" ).append("\n"); 
		query.append("WHERE  CUST_CNT_CD = @[inv_cntry_cd]" ).append("\n"); 
		query.append("AND    CUST_SEQ  = TO_NUMBER(@[inv_cust_cd])" ).append("\n"); 
		query.append("AND    DELT_FLG <> 'Y'" ).append("\n"); 

	}
}