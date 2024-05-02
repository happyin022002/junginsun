/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueApLuValDBDAOSearchApLuValListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueApLuValDBDAOSearchApLuValListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ap_lu_val select
	  * </pre>
	  */
	public ReceiveQueueApLuValDBDAOSearchApLuValListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_tp_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueApLuValDBDAOSearchApLuValListRSQL").append("\n"); 
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
		query.append("SELECT lu_tp_ind_cd" ).append("\n"); 
		query.append("FROM ap_lu_val" ).append("\n"); 
		query.append("WHERE lu_tp_ind_cd = HJSEAI_PKG.h_decode(@[lu_tp_ind_cd],'UTF8','UTF8')" ).append("\n"); 
		query.append("AND lu_cd 	   = HJSEAI_PKG.h_decode(@[lu_cd],'UTF8','UTF8')" ).append("\n"); 

	}
}