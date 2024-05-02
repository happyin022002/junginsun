/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : Equipment Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.28 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Suk Jun Kim
 * @see 
 * @since J2EE 1.4
 */

public class ContainerSpecMgtDBDAOSearchEqOrgSccListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOSearchEqOrgSccListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT /*+ INDEX_ASC(A XPKMDM_EQ_ORZ_CHT) */" ).append("\n"); 
		query.append("A.RCC_CD" ).append("\n"); 
		query.append(",A.LCC_CD" ).append("\n"); 
		query.append(",A.ECC_CD" ).append("\n"); 
		query.append(",A.SCC_CD" ).append("\n"); 
		query.append(",(SELECT LOC_NM B" ).append("\n"); 
		query.append("FROM MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.SCC_CD = B.LOC_CD) AS SCC_NM" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDAOMdmEqOrzChtVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}