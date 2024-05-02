/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRPTDBDAOSearchCntrTpSzListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.12 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki-Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchCntrTpSzListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * header
	  * </pre>
	  */
	public SalesRPTDBDAOSearchCntrTpSzListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchCntrTpSzListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM COA_SPCL_REPO_CNTR_RGST" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND SPCL_CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}