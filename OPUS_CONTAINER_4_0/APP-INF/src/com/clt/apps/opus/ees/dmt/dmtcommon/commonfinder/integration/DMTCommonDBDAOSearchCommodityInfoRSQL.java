/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOSearchCommodityInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.01.08 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchCommodityInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 111
	  * </pre>
	  */
	public DMTCommonDBDAOSearchCommodityInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchCommodityInfoRSQL").append("\n"); 
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
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER (ORDER BY cmdt_cd ASC) no," ).append("\n"); 
		query.append("cmdt_cd," ).append("\n"); 
		query.append("cmdt_nm," ).append("\n"); 
		query.append("rep_cmdt_cd," ).append("\n"); 
		query.append("rep_imdg_lvl_cd," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("FROM mdm_commodity" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND cmdt_cd = @[cmdt_cd])" ).append("\n"); 

	}
}