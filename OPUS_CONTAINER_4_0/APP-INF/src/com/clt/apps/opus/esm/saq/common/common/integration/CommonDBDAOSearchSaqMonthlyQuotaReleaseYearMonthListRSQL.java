/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonthlyQuotaReleaseYearMonthListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqMonthlyQuotaReleaseYearMonthListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSaqMonthlyQuotaReleaseYearMonthList 목록 조회
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonthlyQuotaReleaseYearMonthListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonthlyQuotaReleaseYearMonthListRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(SAQ_MON_QTA_RLSE XPKSAQ_MON_QTA_RLSE) */ " ).append("\n"); 
		query.append("      BSE_YR||BSE_QTR_CD AS CODE, " ).append("\n"); 
		query.append("      BSE_YR||BSE_QTR_CD AS TEXT " ).append("\n"); 
		query.append("FROM  SAQ_MON_QTA_RLSE " ).append("\n"); 
		query.append("WHERE QTA_RLSE_STS_CD = 'R' " ).append("\n"); 
		query.append("AND   ROWNUM = 1 " ).append("\n"); 

	}
}