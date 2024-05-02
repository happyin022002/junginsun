/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DMTCommonDBDAOARCurrencyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.07 
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

public class DMTCommonDBDAOARCurrencyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR CURRENCY 조회
	  * </pre>
	  */
	public DMTCommonDBDAOARCurrencyVORSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOARCurrencyVORSQL").append("\n"); 
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
		query.append("SELECT	AR_CURR_CD" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("			SELECT  AR_CURR_CD" ).append("\n"); 
		query.append("				,	1 AS IDX" ).append("\n"); 
		query.append("			FROM	MDM_ORGANIZATION" ).append("\n"); 
		query.append("			WHERE	OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("				AND	DELT_FLG = 'N'" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("                SELECT  B.AR_CURR_CD, B.IDX" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("					SELECT AR_CURR_CD" ).append("\n"); 
		query.append("                        ,    1 AS IDX" ).append("\n"); 
		query.append("                    FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("                    WHERE    OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                    AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                ) A, " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT    'USD' AS AR_CURR_CD, 2 AS IDX" ).append("\n"); 
		query.append("                    FROM    DUAL" ).append("\n"); 
		query.append("#if (${jsp_no} == '4002' || ${jsp_no} == '3109' ) " ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT    'EUR', 3 AS IDX" ).append("\n"); 
		query.append("                    FROM    DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ) B" ).append("\n"); 
		query.append("                WHERE A.AR_CURR_CD != B.AR_CURR_CD(+)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            ORDER BY IDX" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE AR_CURR_CD IS NOT NULL" ).append("\n"); 

	}
}