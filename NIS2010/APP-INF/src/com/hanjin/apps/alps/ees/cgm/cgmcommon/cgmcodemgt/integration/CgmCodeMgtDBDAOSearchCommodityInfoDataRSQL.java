/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchCommodityInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchCommodityInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchCommodityInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchCommodityInfoDataRSQL").append("\n"); 
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
		query.append("SELECT cmdt_cd||'|'||cmdt_nm||'|'||rep_cmdt_cd||'|'||rep_imdg_lvl_cd||'|'||to_char(upd_dt,'YYYY-MM-DD') AS commodity" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("	SELECT ROW_NUMBER() OVER (ORDER BY cmdt_cd ASC) no," ).append("\n"); 
		query.append("		cmdt_cd,              " ).append("\n"); 
		query.append("        cmdt_nm," ).append("\n"); 
		query.append("        rep_cmdt_cd," ).append("\n"); 
		query.append("		rep_imdg_lvl_cd," ).append("\n"); 
		query.append("		upd_dt" ).append("\n"); 
		query.append("	FROM mdm_commodity" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("	AND cmdt_cd = @[cmdt_cd])" ).append("\n"); 

	}
}