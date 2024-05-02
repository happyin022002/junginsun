/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReportDBDAOSearchOfficeHierarchyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.report.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReportDBDAOSearchOfficeHierarchyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OfficeHierarchy정보를 조회를 해온다.
	  * </pre>
	  */
	public ReportDBDAOSearchOfficeHierarchyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_kind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.report.integration").append("\n"); 
		query.append("FileName : ReportDBDAOSearchOfficeHierarchyRSQL").append("\n"); 
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
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT OFC_KND_CD, OFC_CD, OFC_LVL," ).append("\n"); 
		query.append("		       REGEXP_SUBSTR(OFC_CD_PATH, '[^|]+', 1, 1) HO," ).append("\n"); 
		query.append("		       REGEXP_SUBSTR(OFC_CD_PATH, '[^|]+', 1, 2) RHQ," ).append("\n"); 
		query.append("	    	   REGEXP_SUBSTR(OFC_CD_PATH, '[^|]+', 1, 3) BB_AA," ).append("\n"); 
		query.append("		       REGEXP_SUBSTR(OFC_CD_PATH, '[^|]+', 1, 4) SUB_BB," ).append("\n"); 
		query.append("		       REGEXP_SUBSTR(OFC_CD_PATH, '[^|]+', 1, 5) BB_AA3," ).append("\n"); 
		query.append("	    	   REGEXP_SUBSTR(OFC_CD_PATH, '[^|]+', 1, 6) BB_AA4, " ).append("\n"); 
		query.append("		       OFC_ENG_NM, STATUS, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT," ).append("\n"); 
		query.append("		       PRNT_OFC_CD, OFC_CD_PATH" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			    SELECT OFC_CD, PRNT_OFC_CD, OFC_KND_CD, OFC_ENG_NM, DELT_FLG AS STATUS, LEVEL OFC_LVL, CRE_USR_ID, TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT, UPD_USR_ID, TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("                       SYS_CONNECT_BY_PATH(OFC_CD, '|') OFC_CD_PATH " ).append("\n"); 
		query.append("			      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("			   CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("	    		 START WITH OFC_CD = COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()" ).append("\n"); 
		query.append("			  )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("	#if (${ofc_kind_cd} == '1')" ).append("\n"); 
		query.append("  AND HO = @[ofc_cd]" ).append("\n"); 
		query.append("	#elseif (${ofc_kind_cd} == '2')" ).append("\n"); 
		query.append("  AND RHQ = @[ofc_cd]" ).append("\n"); 
		query.append("	#elseif (${ofc_kind_cd} == '3')" ).append("\n"); 
		query.append("  AND OFC_KND_CD = @[ofc_kind_cd]" ).append("\n"); 
		query.append("  AND (BB_AA = @[ofc_cd] OR SUB_BB = @[ofc_cd] OR BB_AA3 = @[ofc_cd] OR BB_AA4 = @[ofc_cd])" ).append("\n"); 
		query.append("	#elseif (${ofc_kind_cd} == '6')" ).append("\n"); 
		query.append("  AND OFC_KND_CD = @[ofc_kind_cd]" ).append("\n"); 
		query.append("  AND (BB_AA = @[ofc_cd] OR SUB_BB = @[ofc_cd] OR BB_AA3 = @[ofc_cd] OR BB_AA4 = @[ofc_cd])" ).append("\n"); 
		query.append("	#elseif (${ofc_kind_cd} == '' ) " ).append("\n"); 
		query.append("  AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} == '')" ).append("\n"); 
		query.append("	#if (${ofc_kind_cd} != '')" ).append("\n"); 
		query.append("  AND OFC_KND_CD = @[ofc_kind_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status_cd} == 'Y')" ).append("\n"); 
		query.append("  AND STATUS <> 'Y'" ).append("\n"); 
		query.append("#elseif (${status_cd} == 'N')" ).append("\n"); 
		query.append("  AND STATUS = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}