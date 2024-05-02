/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSoProcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.08.12 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSoProcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer Procedure 리턴값을 받을 VO 생성용
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSoProcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSoProcRSQL").append("\n"); 
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
		query.append("SELECT '' rtn_value" ).append("\n"); 
		query.append(",'' act_cust_cnt_cd" ).append("\n"); 
		query.append(",'' act_cust_seq" ).append("\n"); 
		query.append(",'' act_cust_addr_seq" ).append("\n"); 
		query.append(",'' act_cust_fctry_pst_cd" ).append("\n"); 
		query.append(",'' act_cust_fctry_nm" ).append("\n"); 
		query.append(",'' act_cust_fctry_addr" ).append("\n"); 
		query.append(",'' act_cust_fctry_phn_no" ).append("\n"); 
		query.append(",'' act_cust_fctry_fax_no" ).append("\n"); 
		query.append(",'' act_cust_fctry_pic_no" ).append("\n"); 
		query.append(",'' act_cust_eml" ).append("\n"); 
		query.append(",'' act_cust_rmk" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}