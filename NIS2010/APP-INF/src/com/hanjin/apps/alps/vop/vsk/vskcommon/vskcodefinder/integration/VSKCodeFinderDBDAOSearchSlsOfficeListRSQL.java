/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchSlsOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchSlsOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SLS_OFC_CD
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchSlsOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_port_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchSlsOfficeListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT SLS_OFC_CD  AS VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   SLS_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND     DELT_FLG        = 'N'" ).append("\n"); 
		query.append("#if (${vskd_port_rhq_cd} != 'ALL' && ${vskd_port_rhq_cd} != '')" ).append("\n"); 
		query.append("AND 1=1" ).append("\n"); 
		query.append("AND     VSKD_PORT_RHQ_CD = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VOP_PORT_CTRL_OFC_CD" ).append("\n"); 

	}
}