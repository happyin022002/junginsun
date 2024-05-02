/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : INVCommonDBDAOsearchRhqListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchRhqListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ 조회용 쿼리
	  * </pre>
	  */
	public INVCommonDBDAOsearchRhqListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration ").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchRhqListRSQL").append("\n"); 
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
		query.append("SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("GROUP BY AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("ORDER BY AR_HD_QTR_OFC_CD" ).append("\n"); 

	}
}