/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UserMappingDAOMdmOrganizationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.04.04 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kyungbum kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserMappingDAOMdmOrganizationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT MDM_ORGANIZATION
	  * </pre>
	  */
	public UserMappingDAOMdmOrganizationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration").append("\n"); 
		query.append("FileName : UserMappingDAOMdmOrganizationRSQL").append("\n"); 
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
		query.append("#if(${usr_auth_tp_cd}=='A')     " ).append("\n"); 
		query.append("	SELECT                                                                " ).append("\n"); 
		query.append("	    level,                                                              " ).append("\n"); 
		query.append("	    ofc_cd,                                                             " ).append("\n"); 
		query.append("	    ofc_eng_nm,                                                         " ).append("\n"); 
		query.append("	    ofc_krn_nm                                                          " ).append("\n"); 
		query.append("	  FROM mdm_organization                                                 " ).append("\n"); 
		query.append("	  WHERE DELT_FLG = 'N'                                                  " ).append("\n"); 
		query.append("	  CONNECT BY PRIOR ofc_cd = prnt_ofc_cd                                 " ).append("\n"); 
		query.append("	  START WITH prnt_ofc_cd IS NULL                                       " ).append("\n"); 
		query.append("#elseif(${usr_auth_tp_cd}=='S')" ).append("\n"); 
		query.append(" SELECT                                                                " ).append("\n"); 
		query.append("    level,                                                              " ).append("\n"); 
		query.append("    ofc_cd,                                                             " ).append("\n"); 
		query.append("    ofc_eng_nm,                                                         " ).append("\n"); 
		query.append("    ofc_krn_nm                                                          " ).append("\n"); 
		query.append("  FROM mdm_organization                                                 " ).append("\n"); 
		query.append("  WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${rhq_ofc_cd}!='SELHO') " ).append("\n"); 
		query.append("  AND ar_hd_qtr_ofc_cd = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  CONNECT BY PRIOR ofc_cd = prnt_ofc_cd" ).append("\n"); 
		query.append("  START WITH prnt_ofc_cd IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}