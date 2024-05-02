/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OnhireApprovalDBDAOOnhireApprovalNumberHistorySeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2010.05.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOOnhireApprovalNumberHistorySeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Onhire 될 장비의 Lift On Charge  내용을 조회
	  * </pre>
	  */
	public OnhireApprovalDBDAOOnhireApprovalNumberHistorySeqRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOOnhireApprovalNumberHistorySeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(ONH_APRO_SEQ), 0)+1 ONH_APRO_SEQ" ).append("\n"); 
		query.append("  FROM LSE_ONH_APRO_HIS" ).append("\n"); 
		query.append(" WHERE CNTR_ONH_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 

	}
}