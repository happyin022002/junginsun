/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonCodeDBDAOSearchBillingCaseCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.11.10 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchBillingCaseCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBillingCaseCode
	  * </pre>
	  */
	public CommonCodeDBDAOSearchBillingCaseCodeRSQL(){
		SetQuery();
		
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration ").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchBillingCaseCodeRSQL").append("\n"); 
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
	public void SetQuery(){
		query.append("SELECT n3pty_bil_tp_cd AS cd," ).append("\n");
		query.append("       n3pty_bil_tp_cd AS name" ).append("\n");
		query.append("  FROM TPB_N3RD_PTY_BIL_TP" ).append("\n");
		query.append(" WHERE 1=1" ).append("\n");
		query.append("   AND act_flg = 'Y'" ).append("\n");
		query.append(" ORDER BY n3pty_bil_tp_cd" ).append("\n");
	}
}