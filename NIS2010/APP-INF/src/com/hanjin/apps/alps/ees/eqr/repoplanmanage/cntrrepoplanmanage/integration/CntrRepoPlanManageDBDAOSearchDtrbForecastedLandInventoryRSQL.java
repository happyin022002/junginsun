/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAOSearchDtrbForecastedLandInventoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBDAOSearchDtrbForecastedLandInventoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0045 컨테이너 이송 계획 목록 조회>
	  * 컨테이너 이송계획 관리 Distribution 가능여부 조회
	  * 
	  * <Change History>
	  * 1	2009.08.20	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanManageDBDAOSearchDtrbForecastedLandInventoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBDAOSearchDtrbForecastedLandInventoryRSQL").append("\n"); 
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
		query.append("SELECT REPO_PLN_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT REPO_PLN_DTRB_FLG ,REPO_PLN_ID" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID LIKE  '${repoPlnIdLike}%'" ).append("\n"); 
		query.append("AND REPO_PLN_DTRB_FLG = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}