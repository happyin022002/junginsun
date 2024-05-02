/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOVerifyEasStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.11.30 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOVerifyEasStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 등록된 EAC 자료의 상태를 체크한다.
	  * </pre>
	  */
	public EacMgtDBDAOVerifyEasStsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOVerifyEasStsRSQL").append("\n"); 
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
		query.append("SELECT EAC_STS_CD" ).append("\n"); 
		query.append("  FROM EAS_EXPN_AUD_CS_APRO_STEP" ).append("\n"); 
		query.append(" WHERE EAC_NO = @[eac_no]" ).append("\n"); 
		query.append("   AND CASE WHEN EAC_STS_CD IN ('IS') THEN 'A'" ).append("\n"); 
		query.append("            WHEN EAC_STS_CD IN ('SC') THEN 'B'" ).append("\n"); 
		query.append("            WHEN EAC_STS_CD IN ('AC') THEN 'C'" ).append("\n"); 
		query.append("            WHEN EAC_STS_CD IN ('RC','RR') THEN 'D'" ).append("\n"); 
		query.append("            WHEN EAC_STS_CD IN ('HC','HR') THEN 'E'" ).append("\n"); 
		query.append("       END = " ).append("\n"); 
		query.append("       CASE WHEN @[eac_sts_cd] IN ('IS') THEN 'A'" ).append("\n"); 
		query.append("            WHEN @[eac_sts_cd] IN ('SC') THEN 'B'" ).append("\n"); 
		query.append("            WHEN @[eac_sts_cd] IN ('AC') THEN 'C'" ).append("\n"); 
		query.append("            WHEN @[eac_sts_cd] IN ('RC','RR') THEN 'D'" ).append("\n"); 
		query.append("            WHEN @[eac_sts_cd] IN ('HC','HR') THEN 'E'" ).append("\n"); 
		query.append("       END" ).append("\n"); 

	}
}