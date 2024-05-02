/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementTrsComScgMgmtDBDAOSearchRccCdComListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.09
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.11.09 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsComScgMgmtDBDAOSearchRccCdComListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RCC Code를 검색하는 SQL
	  * </pre>
	  */
	public AgreementTrsComScgMgmtDBDAOSearchRccCdComListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ").append("\n"); 
		query.append("FileName : AgreementTrsComScgMgmtDBDAOSearchRccCdComListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT RCC_CD" ).append("\n"); 
		query.append("  FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY RCC_CD" ).append("\n"); 

	}
}