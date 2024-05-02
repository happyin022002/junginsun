/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesAdminCommonDBDAOSearchSamActTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.06.20 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesAdminCommonDBDAOSearchSamActTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Activity Type 조회용 쿼리
	  * </pre>
	  */
	public SalesAdminCommonDBDAOSearchSamActTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration ").append("\n"); 
		query.append("FileName : SalesAdminCommonDBDAOSearchSamActTypeRSQL").append("\n"); 
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
		query.append("SELECT SLS_ACT_TP_CD CD" ).append("\n"); 
		query.append("      ,SLS_ACT_TP_DESC CD_DESC" ).append("\n"); 
		query.append("FROM SAM_SLS_ACT_TP_MST " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("ORDER BY SLS_ACT_TP_CD" ).append("\n"); 

	}
}