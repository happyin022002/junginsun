/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOFmsCustomerCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.21 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOFmsCustomerCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Code Select
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOFmsCustomerCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOFmsCustomerCodeRSQL").append("\n"); 
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
		query.append("SELECT A.CUST_CNT_CD," ).append("\n"); 
		query.append("A.CUST_SEQ," ).append("\n"); 
		query.append("B.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM FMS_CONTRACT A," ).append("\n"); 
		query.append("MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 

	}
}