/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOSearchEqOrgYardListRSQL.java
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

public class ContainerSpecMgtDBDAOSearchEqOrgYardListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEqOrgYardList
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOSearchEqOrgYardListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOSearchEqOrgYardListRSQL").append("\n"); 
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
		query.append("SELECT /*+ index_asc(b XPKMDM_YARD) */" ).append("\n"); 
		query.append("    b.YD_CD" ).append("\n"); 
		query.append("FROM mdm_location a, mdm_yard b" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    a.loc_cd = b.loc_cd" ).append("\n"); 
		query.append("    AND a.scc_cd = @[scc_cd]" ).append("\n"); 
		query.append("    AND b.delt_flg = 'N'" ).append("\n"); 

	}
}