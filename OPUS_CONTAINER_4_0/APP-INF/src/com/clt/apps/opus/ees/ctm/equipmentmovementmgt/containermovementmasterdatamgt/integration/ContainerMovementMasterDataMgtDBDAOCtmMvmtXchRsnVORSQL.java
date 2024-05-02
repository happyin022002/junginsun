/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtDBDAOCtmMvmtXchRsnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.05 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMasterDataMgtDBDAOCtmMvmtXchRsnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0421 : CTM_MVMT_XCH_RSN에서 Reson리스트를 조회
	  * </pre>
	  */
	public ContainerMovementMasterDataMgtDBDAOCtmMvmtXchRsnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMasterDataMgtDBDAOCtmMvmtXchRsnVORSQL").append("\n"); 
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
		query.append("SELECT XCH_RSN_CD," ).append("\n"); 
		query.append("XCH_ABBR_NM," ).append("\n"); 
		query.append("XCH_DESC" ).append("\n"); 
		query.append("FROM CTM_MVMT_XCH_RSN" ).append("\n"); 
		query.append("ORDER BY XCH_RSN_CD" ).append("\n"); 

	}
}