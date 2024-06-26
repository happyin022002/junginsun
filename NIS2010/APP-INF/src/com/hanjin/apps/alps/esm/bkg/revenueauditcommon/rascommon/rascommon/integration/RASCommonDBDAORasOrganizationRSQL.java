/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RASCommonDBDAORasOrganizationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RASCommonDBDAORasOrganizationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RasOrganization
	  * </pre>
	  */
	public RASCommonDBDAORasOrganizationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration").append("\n"); 
		query.append("FileName : RASCommonDBDAORasOrganizationRSQL").append("\n"); 
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
		query.append("#if (${etc2} == 'SELHO')" ).append("\n"); 
		query.append("		SELECT ATTR_CTNT2 AS CD," ).append("\n"); 
		query.append("			   ATTR_CTNT3 AS NM" ).append("\n"); 
		query.append("		FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("		WHERE HRD_CDG_ID = 'RAS_HRD_OFC'" ).append("\n"); 
		query.append("		AND ATTR_CTNT1 = 'RESP_OFC'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${rhqSet} == 'resp')" ).append("\n"); 
		query.append("	SELECT  OFC_CD AS CD" ).append("\n"); 
		query.append("	,		PRNT_OFC_CD 	AS NM" ).append("\n"); 
		query.append("	FROM  MDM_ORGANIZATION" ).append("\n"); 
		query.append("	WHERE  DELT_FLG  = 'N'" ).append("\n"); 
		query.append("	#if (${etc2} == '')" ).append("\n"); 
		query.append("		AND   OFC_TP_CD   = 'HQ'" ).append("\n"); 
		query.append("		--ORDER BY    OFC_CD" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT ATTR_CTNT2 AS CD, " ).append("\n"); 
		query.append("			   ATTR_CTNT3 AS NM" ).append("\n"); 
		query.append("		FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("		WHERE HRD_CDG_ID = 'RAS_HRD_OFC'" ).append("\n"); 
		query.append("		AND ATTR_CTNT1 = 'RESP_RHQ'	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif(${rhqSet} == 'gso')" ).append("\n"); 
		query.append("	SELECT  OFC_CD AS CD" ).append("\n"); 
		query.append("	,		PRNT_OFC_CD 	AS NM" ).append("\n"); 
		query.append("	FROM  MDM_ORGANIZATION" ).append("\n"); 
		query.append("	WHERE  DELT_FLG  = 'N'" ).append("\n"); 
		query.append("	AND LEVEL = 1" ).append("\n"); 
		query.append("	START WITH PRNT_OFC_CD = @[etc2]" ).append("\n"); 
		query.append("	CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("	ORDER BY    OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SELECT  DISTINCT OFC_CD AS CD" ).append("\n"); 
		query.append("	,		PRNT_OFC_CD 	AS NM" ).append("\n"); 
		query.append("	FROM  MDM_ORGANIZATION" ).append("\n"); 
		query.append("	WHERE  DELT_FLG  = 'N'" ).append("\n"); 
		query.append("	#if (${etc2} == '')" ).append("\n"); 
		query.append("		AND   OFC_TP_CD   = 'HQ'" ).append("\n"); 
		query.append("		ORDER BY    OFC_CD" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if(${etc4} == '')" ).append("\n"); 
		query.append("		AND   OFC_TP_CD   <> 'AQ'" ).append("\n"); 
		query.append("		START WITH PRNT_OFC_CD = @[etc2]" ).append("\n"); 
		query.append("		CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("		ORDER BY    OFC_CD" ).append("\n"); 
		query.append("	  #else" ).append("\n"); 
		query.append("		AND   OFC_TP_CD   <> 'AQ'" ).append("\n"); 
		query.append("		START WITH PRNT_OFC_CD = @[etc4] OR OFC_CD = @[etc4]" ).append("\n"); 
		query.append("		CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}