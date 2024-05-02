/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOSearchEqOrgSccListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.21 
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

public class ContainerSpecMgtDBDAOSearchEqOrgSccListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerSpecMgtDBDAOSearchEqOrgSccListRSQL
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOSearchEqOrgSccListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOSearchEqOrgSccListRSQL").append("\n"); 
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
		query.append("SELECT /*+ index_asc(a XPKMDM_EQ_ORZ_CHT) */ " ).append("\n"); 
		query.append("     a.RCC_CD" ).append("\n"); 
		query.append("     ,a.LCC_CD" ).append("\n"); 
		query.append("     ,a.ECC_CD" ).append("\n"); 
		query.append("     ,a.SCC_CD" ).append("\n"); 
		query.append("     ,(select loc_nm b" ).append("\n"); 
		query.append("       from mdm_location b " ).append("\n"); 
		query.append("       where a.scc_cd = b.loc_cd) as scc_nm" ).append("\n"); 
		query.append("FROM mdm_eq_orz_cht a" ).append("\n"); 

	}
}