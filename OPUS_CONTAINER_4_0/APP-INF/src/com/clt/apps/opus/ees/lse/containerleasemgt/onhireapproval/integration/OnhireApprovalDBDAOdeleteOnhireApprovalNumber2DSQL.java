/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireApprovalDBDAOdeleteOnhireApprovalNumber2DSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.07 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jin Jun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOdeleteOnhireApprovalNumber2DSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LSE_ONH_APRO_QTY를 삭제한다
	  * </pre>
	  */
	public OnhireApprovalDBDAOdeleteOnhireApprovalNumber2DSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_onh_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration ").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOdeleteOnhireApprovalNumber2DSQL").append("\n"); 
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
		query.append("DELETE LSE_ONH_APRO_QTY" ).append("\n"); 
		query.append("WHERE CNTR_ONH_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 

	}
}