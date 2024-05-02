/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCommonDBDAOCountryByRHQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOCountryByRHQRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ 코드로 해당 Country 정보를 조회하기 위해 사용하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOCountryByRHQRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOCountryByRHQRSQL").append("\n"); 
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
		query.append("SELECT A.CNT_CD" ).append("\n"); 
		query.append("     , B.CNT_NM" ).append("\n"); 
		query.append("  FROM COM_SYS_AREA_GRP_ID A" ).append("\n"); 
		query.append("     , MDM_COUNTRY B" ).append("\n"); 
		query.append(" WHERE A.SYS_AREA_GRP_ID IN (" ).append("\n"); 
		query.append("        SELECT OFC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("          FROM COM_SYS_AREA_GRP_ID OFC" ).append("\n"); 
		query.append("         WHERE OFC.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("           AND OFC.CNT_CD = (" ).append("\n"); 
		query.append("                SELECT SUBSTR(LOC_CD, 1, 2) " ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                 WHERE OFC_CD = @[svr_id]" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           AND B.DELT_FLG = 'N' " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   AND B.CNT_CD = A.CNT_CD " ).append("\n"); 
		query.append(" ORDER BY CNT_CD ASC" ).append("\n"); 

	}
}