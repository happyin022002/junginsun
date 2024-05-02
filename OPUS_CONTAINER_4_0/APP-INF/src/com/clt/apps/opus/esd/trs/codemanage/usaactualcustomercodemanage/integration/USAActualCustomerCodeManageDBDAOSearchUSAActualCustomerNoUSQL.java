/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.07.29 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer Seq 채번
	  * </pre>
	  */
	public USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration ").append("\n"); 
		query.append("FileName : USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoUSQL").append("\n"); 
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
		query.append("UPDATE	TRS_TRSP_USA_ACT_CUST" ).append("\n"); 
		query.append("SET		act_cust_seq   = NVL(act_cust_seq, 0)+1" ).append("\n"); 
		query.append("WHERE	trsp_act_cust_no = 0" ).append("\n"); 

	}
}