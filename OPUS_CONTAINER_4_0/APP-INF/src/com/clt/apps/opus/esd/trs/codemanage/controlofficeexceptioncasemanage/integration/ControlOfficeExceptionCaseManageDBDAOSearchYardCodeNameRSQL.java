/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAOSearchYardCodeNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ControlOfficeExceptionCaseManageDBDAOSearchYardCodeNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ControlOfficeExceptionCaseManageDBDAOSearchYardCodeName
	  * </pre>
	  */
	public ControlOfficeExceptionCaseManageDBDAOSearchYardCodeNameRSQL(){
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
		query.append("FileName : ControlOfficeExceptionCaseManageDBDAOSearchYardCodeNameRSQL").append("\n"); 
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
		query.append("SELECT ZN_CD AS YD_CD, ZN_NM AS YD_NM, SUBSTR(ZN_CD, 1, 5) AS LOC, SUBSTR(ZN_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("  FROM MDM_ZONE" ).append("\n"); 
		query.append(" WHERE ZN_CD = @[searchStr]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT LSE_CO_YD_CD AS YD_CD, LSE_CO_YD_NM AS YD_NM, SUBSTR(LSE_CO_YD_CD, 1, 5) AS LOC, SUBSTR(LSE_CO_YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("  FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append(" WHERE LSE_CO_YD_CD = @[searchStr]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT YD_CD AS YD_CD, YD_NM AS YD_NM, SUBSTR(YD_CD, 1, 5) AS LOC, SUBSTR(YD_CD, 6, 2) AS NOD" ).append("\n"); 
		query.append("  FROM MDM_YARD" ).append("\n"); 
		query.append(" WHERE YD_CD = @[searchStr]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT LOC_CD YD_CD, LOC_NM YD_NM" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append(" WHERE LOC_CD = @[searchStr]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}