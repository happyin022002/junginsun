/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodValidationDBDAOcheckCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.12.17 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DodValidationDBDAOcheckCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customern 코드 유효성 검사
	  * </pre>
	  */
	public DodValidationDBDAOcheckCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration").append("\n"); 
		query.append("FileName : DodValidationDBDAOcheckCustomerRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append(" WHERE CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') = @[s_value]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("   AND NMD_CUST_FLG = 'N'" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER A" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND C.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND C.CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("           AND ( A.NMD_CUST_FLG = 'Y'" ).append("\n"); 
		query.append("                    OR A.SLS_DELT_EFF_DT IS NOT NULL))" ).append("\n"); 

	}
}