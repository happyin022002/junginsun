/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonCodeDBDAOSearchGetAllBillingCaseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.11.12 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchGetAllBillingCaseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchGetAllBillingCase
	  * </pre>
	  */
	public CommonCodeDBDAOSearchGetAllBillingCaseRSQL(){
		SetQuery();
		
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchGetAllBillingCaseRSQL").append("\n"); 
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
		query.append("SELECT n3pty_bil_tp_cd || '--' || TPB_GET_N3PTY_BIL_TP_NM_FNC(n3pty_bil_tp_cd) AS v_tpb_cd" ).append("\n");
		query.append("  FROM TPB_N3RD_PTY_BIL_TP" ).append("\n");
		query.append(" WHERE 1=1" ).append("\n");
		query.append("   AND n3pty_bil_tp_cd != 'JO'" ).append("\n");
		query.append("   AND act_flg ='Y'" ).append("\n");
		query.append("#if (${ord} == 'Y')" ).append("\n");
		query.append(" ORDER BY v_tpb_cd" ).append("\n");
		query.append("#end" ).append("\n");
	}
}