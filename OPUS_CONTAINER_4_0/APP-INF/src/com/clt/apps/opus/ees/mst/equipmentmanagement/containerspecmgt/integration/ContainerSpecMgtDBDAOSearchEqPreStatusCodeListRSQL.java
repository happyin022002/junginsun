/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOSearchEqPreStatusCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.12.03 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOSearchEqPreStatusCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEqPreStatusCodeList
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOSearchEqPreStatusCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOSearchEqPreStatusCodeListRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_ASC(A XPKMST_CNTR_PRE_STS) */" ).append("\n"); 
		query.append("A.CNTR_PRE_STS_CD, A.CNTR_STS_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MST_CNTR_PRE_STS A" ).append("\n"); 

	}
}