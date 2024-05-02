/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueApWorkplaceDBDAORemoveApWorkplaceDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.common.tableSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueApWorkplaceDBDAORemoveApWorkplaceDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ap_wokplace 데이터 삭제
	  * </pre>
	  */
	public ReceiveQueueApWorkplaceDBDAORemoveApWorkplaceDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wkplc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.common.tableSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueApWorkplaceDBDAORemoveApWorkplaceDSQL").append("\n"); 
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
		query.append("DELETE FROM ap_workplace" ).append("\n"); 
		query.append("WHERE 	wkplc_nm  = HJSEAI_PKG.h_decode(@[wkplc_nm], 'UTF8' ,'UTF8')" ).append("\n"); 
		query.append("AND 	eai_evnt_dt <= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 

	}
}