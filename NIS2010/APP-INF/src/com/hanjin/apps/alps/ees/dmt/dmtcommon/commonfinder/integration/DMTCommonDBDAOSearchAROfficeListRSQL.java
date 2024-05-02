/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOSearchAROfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.02.04 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchAROfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAROfficeList
	  * </pre>
	  */
	public DMTCommonDBDAOSearchAROfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchAROfficeListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT A.AR_OFC_CD  AS OFC_CD" ).append("\n"); 
		query.append("        ,A.OFC_ENG_NM AS OFC_ENG_NM" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("        , (SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                 ,AR_OFC_CD" ).append("\n"); 
		query.append("                 ,LOC_CD" ).append("\n"); 
		query.append("             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("#if(${rhq_ofc} != 'SELHO')" ).append("\n"); 
		query.append("            WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  ) B" ).append("\n"); 
		query.append("        ,COM_SYS_AREA_GRP_ID C" ).append("\n"); 
		query.append("        ,INV_AR_STUP_OFC D" ).append("\n"); 
		query.append("        ,MDM_CURRENCY E" ).append("\n"); 
		query.append("   WHERE A.AR_HD_QTR_OFC_CD = B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("     AND A.OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("     AND A.OFC_CD = D.AR_OFC_CD(+)" ).append("\n"); 
		query.append("     AND SUBSTR (A.LOC_CD" ).append("\n"); 
		query.append("                ,1" ).append("\n"); 
		query.append("                ,2" ).append("\n"); 
		query.append("                ) = C.CNT_CD" ).append("\n"); 
		query.append("     AND C.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("     AND A.AR_CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("ORDER BY A.AR_OFC_CD" ).append("\n"); 

	}
}