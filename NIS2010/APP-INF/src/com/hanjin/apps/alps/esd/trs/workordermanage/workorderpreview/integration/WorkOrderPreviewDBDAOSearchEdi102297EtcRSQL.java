/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi102297EtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi102297EtcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_102297_ETC
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi102297EtcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi102297EtcRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(globaldate_pkg.time_local_ofc_fnc(@[usr_ofc_cd]), '[MM.DD] [HH24:MI:SS]') as hd_dt" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}