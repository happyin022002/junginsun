/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerInfoManageDBDAOcheckPrmrySalesRepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.26
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2015.10.26 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOcheckPrmrySalesRepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer의 Primary Sales Rep을 확인
	  * </pre>
	  */
	public CustomerInfoManageDBDAOcheckPrmrySalesRepRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOcheckPrmrySalesRepRSQL").append("\n"); 
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
		query.append("SELECT SREP_CD" ).append("\n"); 
		query.append("FROM SAM_CUST_SLS_REP_INFO" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND CUST_CNT_CD = SUBSTR(@[cust_cd],1, 2)" ).append("\n"); 
		query.append("  AND CUST_SEQ = TO_NUMBER(substr(@[cust_cd], 3))" ).append("\n"); 
		query.append("  AND SREP_PRMRY_FLG = 'Y'" ).append("\n"); 

	}
}