/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOMdmEqOrzChtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOMdmEqOrzChtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MdmEqOrzChtVO
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOMdmEqOrzChtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOMdmEqOrzChtVORSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_ASC(A XPKMDM_EQ_ORZ_CHT) */ " ).append("\n"); 
		query.append("     A.RCC_CD" ).append("\n"); 
		query.append("     ,A.LCC_CD" ).append("\n"); 
		query.append("     ,A.ECC_CD" ).append("\n"); 
		query.append("     ,A.SCC_CD" ).append("\n"); 
		query.append("     ,(SELECT LOC_NM B" ).append("\n"); 
		query.append("       FROM MDM_LOCATION B " ).append("\n"); 
		query.append("       WHERE A.SCC_CD = B.LOC_CD) AS SCC_NM" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 

	}
}