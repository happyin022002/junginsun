/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesAdminCommonDBDAOSearchActItemMstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.23
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.23 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesAdminCommonDBDAOSearchActItemMstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회용 쿼리
	  * </pre>
	  */
	public SalesAdminCommonDBDAOSearchActItemMstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration").append("\n"); 
		query.append("FileName : SalesAdminCommonDBDAOSearchActItemMstListRSQL").append("\n"); 
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
		query.append("SELECT sls_act_tp_cd" ).append("\n"); 
		query.append("	 , sls_act_tp_desc" ).append("\n"); 
		query.append("FROM sam_sls_act_tp_mst" ).append("\n"); 
		query.append("order by sls_act_tp_cd" ).append("\n"); 

	}
}