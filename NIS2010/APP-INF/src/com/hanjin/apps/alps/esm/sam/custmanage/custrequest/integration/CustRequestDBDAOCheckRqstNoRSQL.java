/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustRequestDBDAOCheckRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custrequest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRequestDBDAOCheckRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer request no check
	  * </pre>
	  */
	public CustRequestDBDAOCheckRqstNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custrequest.integration ").append("\n"); 
		query.append("FileName : CustRequestDBDAOCheckRqstNoRSQL").append("\n"); 
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
		query.append("SELECT A.MDM_CUSTOMER_RQST_SEQ " ).append("\n"); 
		query.append("FROM MDM_CUSTOMER_RQST A " ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND A.MDM_CUSTOMER_RQST_SEQ = @[rqst_no]" ).append("\n"); 

	}
}