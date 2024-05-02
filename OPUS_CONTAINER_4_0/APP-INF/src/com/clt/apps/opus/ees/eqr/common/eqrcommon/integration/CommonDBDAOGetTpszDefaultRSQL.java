/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOGetTpszDefaultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.24
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.12.24 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOGetTpszDefaultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기본 Type 조회
	  * </pre>
	  */
	public CommonDBDAOGetTpszDefaultRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOGetTpszDefaultRSQL").append("\n"); 
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
		query.append("SELECT TP.CNTR_TPSZ_CD AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ TP" ).append("\n"); 
		query.append("WHERE TP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY TP.RPT_DP_SEQ" ).append("\n"); 

	}
}