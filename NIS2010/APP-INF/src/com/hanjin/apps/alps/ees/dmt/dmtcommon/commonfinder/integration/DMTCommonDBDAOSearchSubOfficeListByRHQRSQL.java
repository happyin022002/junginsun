/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCommonDBDAOSearchSubOfficeListByRHQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.11.05 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchSubOfficeListByRHQRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMTCommonDBDAOSearchSubOfficeListByRHQRSQL
	  * </pre>
	  */
	public DMTCommonDBDAOSearchSubOfficeListByRHQRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchSubOfficeListByRHQRSQL").append("\n"); 
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
		query.append("SELECT  T1.OFC_CD" ).append("\n"); 
		query.append("       ,T1.OFC_ENG_NM" ).append("\n"); 
		query.append("  FROM  MDM_ORGANIZATION T1" ).append("\n"); 
		query.append(" WHERE  T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("-- 3101(OFC Transfer) 화면에서 RHQ 포함 목록 보이기 위해 조건 추가" ).append("\n"); 
		query.append("#if (${jspno} == '' || ${jspno}!='3101')" ).append("\n"); 
		query.append("   AND  T1.OFC_CD <> @[rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND  EXISTS" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT  1 " ).append("\n"); 
		query.append("			  FROM  MDM_YARD" ).append("\n"); 
		query.append("			 WHERE  DMDT_OFC_CD = T1.OFC_CD" ).append("\n"); 
		query.append("			   AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("START WITH T1.OFC_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("CONNECT BY PRIOR T1.OFC_CD = T1.PRNT_OFC_CD" ).append("\n"); 
		query.append("ORDER BY T1.OFC_CD" ).append("\n"); 

	}
}