/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonCodeDBDAOSearchCheckBillingCaseCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.01.21 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchCheckBillingCaseCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Billing Case Code Duplication Check
	  * </pre>
	  */
	public CommonCodeDBDAOSearchCheckBillingCaseCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchCheckBillingCaseCodeRSQL").append("\n"); 
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
		query.append("SELECT N3PTY_BIL_TP_CD, N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("FROM TPB_N3RD_PTY_BIL_TP" ).append("\n"); 
		query.append("WHERE N3PTY_BIL_TP_CD = @[s_n3pty_bil_tp_cd]" ).append("\n"); 

	}
}