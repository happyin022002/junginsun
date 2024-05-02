/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueApWorkplaceDBDAOModifyApWorkplaceUSQL.java
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

public class ReceiveQueueApWorkplaceDBDAOModifyApWorkplaceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ap_workplace update
	  * </pre>
	  */
	public ReceiveQueueApWorkplaceDBDAOModifyApWorkplaceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wkplc_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inact_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueApWorkplaceDBDAOModifyApWorkplaceUSQL").append("\n"); 
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
		query.append("UPDATE ap_workplace" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("wkplc_desc = HJSEAI_PKG.h_decode(@[wkplc_desc], 'UTF8' , 'UTF8')" ).append("\n"); 
		query.append(", inact_dt = to_date(@[inact_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append(", upd_dt = sysdate -- 임시" ).append("\n"); 
		query.append(", eai_evnt_dt = to_date(@[eai_evnt_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("WHERE wkplc_nm = HJSEAI_PKG.h_decode(@[wkplc_nm], 'UTF8' , 'UTF8')" ).append("\n"); 
		query.append("AND eai_evnt_dt <= to_date(@[eai_evnt_dt], 'yyyymmddhh24miss')" ).append("\n"); 

	}
}