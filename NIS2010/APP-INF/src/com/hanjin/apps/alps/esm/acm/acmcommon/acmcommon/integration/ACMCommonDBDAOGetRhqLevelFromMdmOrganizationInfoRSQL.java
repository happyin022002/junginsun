/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOGetRhqLevelFromMdmOrganizationInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.11 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOGetRhqLevelFromMdmOrganizationInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ACMCommonDBDAOGetRhqLevelFromMdmOrganizationInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value0",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration").append("\n"); 
		query.append("FileName : ACMCommonDBDAOGetRhqLevelFromMdmOrganizationInfoRSQL").append("\n"); 
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
		query.append("/* RHQ 본사 User의 경우 (OFC_KND_CD=1) RHQ CD 가 Null로  조회. 그 외 에는 RHQ 조회됨 */" ).append("\n"); 
		query.append("SELECT DECODE(M.OFC_KND_CD, 1, '', 9, '', M.AR_HD_QTR_OFC_CD) AS VALUE0,    -- RHQ_CD" ).append("\n"); 
		query.append("       M.OFC_KND_CD AS VALUE1    -- OFC_KND_CD:1=>1본사, 9=>CLT " ).append("\n"); 
		query.append("  FROM COM_USER C," ).append("\n"); 
		query.append("       MDM_ORGANIZATION M" ).append("\n"); 
		query.append(" WHERE NVL(C.USE_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("   AND C.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("   AND C.USR_ID = @[value0]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 1 FROM DUAL WHERE OFC_KND_CD IN (1, 9)" ).append("\n"); 
		query.append("               UNION " ).append("\n"); 
		query.append("               SELECT 1 FROM ACM_OFC_INFO WHERE AR_HD_QTR_OFC_CD IN RHQ_CD)" ).append("\n"); 

	}
}