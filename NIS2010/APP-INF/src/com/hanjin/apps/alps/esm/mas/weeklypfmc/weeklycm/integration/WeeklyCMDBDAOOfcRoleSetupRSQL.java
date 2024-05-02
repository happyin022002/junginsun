/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOOfcRoleSetupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.03.17 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOOfcRoleSetupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Role Setup 을 조회한다.
	  * </pre>
	  */
	public WeeklyCMDBDAOOfcRoleSetupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOOfcRoleSetupRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD " ).append("\n"); 
		query.append("      ,DELT_FLG " ).append("\n"); 
		query.append("      ,CRE_USR_ID AS CRE_USR_ID_SHEET" ).append("\n"); 
		query.append("      ,TO_CHAR(CRE_DT, 'YYYY-MM-DD') AS CRE_DT " ).append("\n"); 
		query.append("      ,UPD_USR_ID AS UPD_USR_ID_SHEET" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("      ,OFC_CD AS OFC_CD_ORG" ).append("\n"); 
		query.append("      ,CRE_USR_ID AS CRE_USR_ID_ORG" ).append("\n"); 
		query.append("      ,UPD_USR_ID AS UPD_USR_ID_ORG" ).append("\n"); 
		query.append("FROM MAS_OP_EXPT_OFC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ofc_cd} != '')" ).append("\n"); 
		query.append("    WHERE OFC_CD LIKE @[f_ofc_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${f_ofc_cd} == '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY OFC_CD" ).append("\n"); 

	}
}