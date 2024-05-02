/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchVesselEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchVesselEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, vvd, portCd로 max ETA를 구하는 쿼리.
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchVesselEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchVesselEtaRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	TO_CHAR(MAX(VPS_ETA_DT), 'YYYY-MM-DD HH24:MI') eta" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	VSL_CD		= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND	SKD_VOY_NO	= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND	SKD_DIR_CD	= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	AND VPS_PORT_CD = @[port]" ).append("\n"); 

	}
}