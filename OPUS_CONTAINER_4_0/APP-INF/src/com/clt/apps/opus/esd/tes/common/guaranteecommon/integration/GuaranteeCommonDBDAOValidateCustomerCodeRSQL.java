/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GuaranteeCommonDBDAOValidateCustomerCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.guaranteecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeCommonDBDAOValidateCustomerCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Code Validate
	  * </pre>
	  */
	public GuaranteeCommonDBDAOValidateCustomerCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.guaranteecommon.integration").append("\n"); 
		query.append("FileName : GuaranteeCommonDBDAOValidateCustomerCodeRSQL").append("\n"); 
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
		query.append("CASE WHEN COUNT(CUST_SEQ) > 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CUST_SEQ_EXIST" ).append("\n"); 
		query.append(", CUST_CNT_CD || LPAD( CUST_SEQ, 6, 0) CUST_CD" ).append("\n"); 
		query.append(", CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM    MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE   CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND     CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("GROUP BY CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 

	}
}