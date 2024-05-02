/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAOSearchYardCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.02.29 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ControlOfficeExceptionCaseManageDBDAOSearchYardCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Node 정보 조회
	  * </pre>
	  */
	public ControlOfficeExceptionCaseManageDBDAOSearchYardCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchStr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.integration").append("\n"); 
		query.append("FileName : ControlOfficeExceptionCaseManageDBDAOSearchYardCodeRSQL").append("\n"); 
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
		query.append("#if (${isZone} == 'Y')" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("      FROM (SELECT ZN_CD AS YD_CD," ).append("\n"); 
		query.append("                   ZN_CD AS YD_NM," ).append("\n"); 
		query.append("                   SUBSTR(ZN_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                   SUBSTR(ZN_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("              FROM MDM_ZONE" ).append("\n"); 
		query.append("             WHERE ZN_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("               AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("             ORDER BY ZN_CD)" ).append("\n"); 
		query.append("#elseif (${isZone} == 'A')" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("      FROM (SELECT ZN_CD AS YD_CD," ).append("\n"); 
		query.append("                   ZN_CD AS YD_NM," ).append("\n"); 
		query.append("                   SUBSTR(ZN_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                   SUBSTR(ZN_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("              FROM MDM_ZONE" ).append("\n"); 
		query.append("             WHERE ZN_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("               AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("             ORDER BY ZN_CD)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    #if (${TRSP_SO_EQ_KIND} == 'N')" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT LSE_CO_YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       LSE_CO_YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append("                 WHERE LSE_CO_YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY LSE_CO_YD_CD)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #elseif (${TRSP_SO_EQ_KIND} == 'A')" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_YARD" ).append("\n"); 
		query.append("                 WHERE YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY YD_CD)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT LSE_CO_YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       LSE_CO_YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append("                 WHERE LSE_CO_YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY LSE_CO_YD_CD)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_YARD" ).append("\n"); 
		query.append("                 WHERE YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY YD_CD)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT LSE_CO_YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       LSE_CO_YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append("                 WHERE LSE_CO_YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY LSE_CO_YD_CD)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${TRSP_SO_EQ_KIND} == 'N')" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT LSE_CO_YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       LSE_CO_YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append("                 WHERE LSE_CO_YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY LSE_CO_YD_CD)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #elseif (${TRSP_SO_EQ_KIND} == 'A')" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_YARD" ).append("\n"); 
		query.append("                 WHERE YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY YD_CD)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT LSE_CO_YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       LSE_CO_YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append("                 WHERE LSE_CO_YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY LSE_CO_YD_CD)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("     #else" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_YARD" ).append("\n"); 
		query.append("                 WHERE YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY YD_CD)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT LSE_CO_YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       LSE_CO_YD_CD AS YD_NM," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("                       SUBSTR(LSE_CO_YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("                  FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append("                 WHERE LSE_CO_YD_CD LIKE @[searchStr]||'%'" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 ORDER BY LSE_CO_YD_CD)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        --ORDER BY YD_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}