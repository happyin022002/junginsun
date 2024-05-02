/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OrganizationDBDAOAddOfcAccGrpMapCSQL.java
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

public class OrganizationDBDAOAddOfcAccGrpMapCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Office Access Group Mapping 정보를 등록한다.
	  * </pre>
	  */
	public OrganizationDBDAOAddOfcAccGrpMapCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.organization.integration").append("\n"); 
		query.append("FileName : OrganizationDBDAOAddOfcAccGrpMapCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_OFC_GRP_MAPG(" ).append("\n"); 
		query.append("            SUB_SYS_CD" ).append("\n"); 
		query.append("           ,OFC_GRP_ID " ).append("\n"); 
		query.append("           ,OFC_CD" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    VALUES(@[sub_sys_cd]" ).append("\n"); 
		query.append("          ,@[ofc_grp_id]" ).append("\n"); 
		query.append("          ,@[ofc_cd]" ).append("\n"); 
		query.append("          ,@[cre_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[upd_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}