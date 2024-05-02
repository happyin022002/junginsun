/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstDAOSearchRepYdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.05
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.08.05 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerRgstDAOSearchRepYdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepYd
	  * </pre>
	  */
	public CustomerNominatedTruckerRgstDAOSearchRepYdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_orgin",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtyPkupRtnYdCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerRgstDAOSearchRepYdRSQL").append("\n"); 
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
		query.append("#if (${mtyPkupRtnYdCd} != '')" ).append("\n"); 
		query.append("SELECT X.YD_NM" ).append("\n"); 
		query.append("  FROM MDM_YARD X" ).append("\n"); 
		query.append(" WHERE YD_CD = @[mtyPkupRtnYdCd]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT X.LSE_CO_YD_NM" ).append("\n"); 
		query.append("  FROM MDM_LSE_CO_YD X" ).append("\n"); 
		query.append(" WHERE LSE_CO_YD_CD = @[mtyPkupRtnYdCd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT YD_CD  AS REP_YD_CD" ).append("\n"); 
		query.append("     , YD_NM  AS REP_YD_NM" ).append("\n"); 
		query.append("  FROM MDM_YARD" ).append("\n"); 
		query.append(" WHERE YD_CD = (" ).append("\n"); 
		query.append(" SELECT MAX(YD_CD)" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("    SELECT DECODE(@[p_bnd], 'I', MTY_PKUP_YD_CD, 'O', EQ_RTN_YD_CD)  AS YD_CD -- BOUND에 따라 Pickup 또는 Return Yard 조회" ).append("\n"); 
		query.append("      FROM MDM_LOCATION A" ).append("\n"); 
		query.append("     WHERE LOC_CD = CASE LENGTH( DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin]) ) WHEN 7 THEN SUBSTR( DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin]), 1,5)" ).append("\n"); 
		query.append("                                                                               WHEN 5 THEN DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin])" ).append("\n"); 
		query.append("                                                                               ELSE ''" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT REP_YD_CD" ).append("\n"); 
		query.append("      FROM MDM_ZONE" ).append("\n"); 
		query.append("     WHERE ZN_CD = CASE LENGTH( DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin]) ) WHEN 7 THEN DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin])" ).append("\n"); 
		query.append("                                       WHEN 5 THEN DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin])||'01'" ).append("\n"); 
		query.append("                                       ELSE ''" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT LSE_CO_YD_CD, LSE_CO_YD_NM" ).append("\n"); 
		query.append("  FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append(" WHERE LSE_CO_YD_CD = (" ).append("\n"); 
		query.append(" SELECT MAX(YD_CD)" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("    SELECT DECODE(@[p_bnd], 'I', MTY_PKUP_YD_CD, 'O', EQ_RTN_YD_CD)  AS YD_CD -- BOUND에 따라 Pickup 또는 Return Yard 조회" ).append("\n"); 
		query.append("      FROM MDM_LOCATION A" ).append("\n"); 
		query.append("     WHERE LOC_CD = CASE LENGTH(DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin])) WHEN 7 THEN SUBSTR( DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin]), 1,5)" ).append("\n"); 
		query.append("                                                                             WHEN 5 THEN DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin])" ).append("\n"); 
		query.append("                                                                             ELSE ''" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT REP_YD_CD" ).append("\n"); 
		query.append("      FROM MDM_ZONE" ).append("\n"); 
		query.append("     WHERE ZN_CD = CASE LENGTH( DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin]) ) WHEN 7 THEN DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin])" ).append("\n"); 
		query.append("                                       WHEN 5 THEN DECODE(@[p_bnd], 'I', @[p_dest], 'O', @[p_orgin])||'01'" ).append("\n"); 
		query.append("                                       ELSE ''" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}