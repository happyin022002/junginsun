/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOSearchMAXCustomerSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOSearchMAXCustomerSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer MAX SEQ
	  * </pre>
	  */
	public CustMainDBDAOSearchMAXCustomerSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchMAXCustomerSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(CUST_SEQ), 0)+1 cust_seq" ).append("\n"); 
		query.append("FROM   MDM_CUSTOMER " ).append("\n"); 
		query.append("WHERE  CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 

	}
}