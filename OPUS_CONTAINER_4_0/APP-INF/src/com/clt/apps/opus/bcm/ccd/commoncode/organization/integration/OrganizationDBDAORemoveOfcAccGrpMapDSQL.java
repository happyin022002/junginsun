/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OrganizationDBDAORemoveOfcAccGrpMapDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.organization.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OrganizationDBDAORemoveOfcAccGrpMapDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Access Group Mapping 정보를 삭제한다.
	  * </pre>
	  */
	public OrganizationDBDAORemoveOfcAccGrpMapDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.organization.integration").append("\n"); 
		query.append("FileName : OrganizationDBDAORemoveOfcAccGrpMapDSQL").append("\n"); 
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
		query.append("DELETE FROM MDM_OFC_GRP_MAPG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SUB_SYS_CD = @[sub_sys_cd]" ).append("\n"); 
		query.append("AND OFC_GRP_ID = @[ofc_grp_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}