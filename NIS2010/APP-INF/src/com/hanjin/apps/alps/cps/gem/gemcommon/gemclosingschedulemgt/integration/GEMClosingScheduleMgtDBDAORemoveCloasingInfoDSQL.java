/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMClosingScheduleMgtDBDAORemoveCloasingInfoDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.01 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMClosingScheduleMgtDBDAORemoveCloasingInfoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * delete
	  * </pre>
	  */
	public GEMClosingScheduleMgtDBDAORemoveCloasingInfoDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clz_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clz_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM GEM_MON_CLZ" ).append("\n"); 
		query.append("WHERE       CLZ_YRMON = @[clz_yrmon]" ).append("\n"); 
		query.append("AND         CLZ_DIV_CD = @[clz_div_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemclosingschedulemgt.integration").append("\n"); 
		query.append("FileName : GEMClosingScheduleMgtDBDAORemoveCloasingInfoDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}