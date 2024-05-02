/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : OrganizationDBDAOSearchOfcAccGrpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.organization.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OrganizationDBDAOSearchOfcAccGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Office Access Group Creation 정보를 조회한다.
	  * </pre>
	  */
	public OrganizationDBDAOSearchOfcAccGrpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.organization.integration").append("\n"); 
		query.append("FileName : OrganizationDBDAOSearchOfcAccGrpRSQL").append("\n"); 
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
		query.append("SELECT SUB_SYS_CD" ).append("\n"); 
		query.append("      ,OFC_GRP_ID" ).append("\n"); 
		query.append("      ,OFC_GRP_NM" ).append("\n"); 
		query.append("      ,OFC_GRP_DESC" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM MDM_OFC_GRP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SUB_SYS_CD = @[sub_sys_cd]" ).append("\n"); 
		query.append("	#if(${ofc_grp_id} != '')" ).append("\n"); 
		query.append("	AND OFC_GRP_ID = @[ofc_grp_id]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY OFC_GRP_ID" ).append("\n"); 

	}
}