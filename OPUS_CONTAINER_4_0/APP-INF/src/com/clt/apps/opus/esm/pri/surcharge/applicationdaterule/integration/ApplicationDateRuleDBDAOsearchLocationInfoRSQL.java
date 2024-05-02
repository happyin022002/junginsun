/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ApplicationDateRuleDBDAOsearchLocationInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.04.27 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApplicationDateRuleDBDAOsearchLocationInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LocationInfo를 조회한다.
	  * </pre>
	  */
	public ApplicationDateRuleDBDAOsearchLocationInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_org_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_conv_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration").append("\n"); 
		query.append("FileName : ApplicationDateRuleDBDAOsearchLocationInfoRSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("ORG_LOC_CD," ).append("\n"); 
		query.append("CONV_LOC_CD," ).append("\n"); 
		query.append("POR_APPL_FLG," ).append("\n"); 
		query.append("POL_APPL_FLG," ).append("\n"); 
		query.append("POD_APPL_FLG," ).append("\n"); 
		query.append("DEL_APPL_FLG," ).append("\n"); 
		query.append("PRE_RLY_PORT_APPL_FLG," ).append("\n"); 
		query.append("PST_RLY_PORT_APPL_FLG" ).append("\n"); 
		query.append("FROM PRI_ROUT_LOC_CONV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${frm_org_loc_cd}!='')" ).append("\n"); 
		query.append("    AND ORG_LOC_CD LIKE '%'||@[frm_org_loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_conv_loc_cd}!='')" ).append("\n"); 
		query.append("    AND CONV_LOC_CD LIKE '%'||@[frm_conv_loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${scp_cd}!='')" ).append("\n"); 
		query.append("    AND SVC_SCP_CD LIKE '%'||@[scp_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD,ORG_LOC_CD,CONV_LOC_CD" ).append("\n"); 

	}
}