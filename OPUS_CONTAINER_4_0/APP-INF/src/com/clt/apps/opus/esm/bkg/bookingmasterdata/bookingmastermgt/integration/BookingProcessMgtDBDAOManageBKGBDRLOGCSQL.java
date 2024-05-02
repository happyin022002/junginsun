/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingProcessMgtDBDAOManageBKGBDRLOGCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.01.05 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtDBDAOManageBKGBDRLOGCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Activate 시점에 처음 만들어 Booking을 받을 수 있는 최종 시점을 관리 하는 BDR LOG 테이블을
	  * 관리할 목적. SKD를 Update될 때마다 항상 조건을 확인한 후 VBL_ESTBDR_DT, VBL_FESTBDR_DT를
	  * 수정하도록 한다.
	  * </pre>
	  */
	public BookingProcessMgtDBDAOManageBKGBDRLOGCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o_result",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o_err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_upd_user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOManageBKGBDRLOGCSQL").append("\n"); 
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
		query.append("CALL BKG_BDR_LOG_PKG.BDR_LOG_MAIN_PRC" ).append("\n"); 
		query.append("(@[in_vsl_cd]" ).append("\n"); 
		query.append(",@[in_skd_voy_no]" ).append("\n"); 
		query.append(",@[in_skd_dir_cd]" ).append("\n"); 
		query.append(",@[in_upd_user_id]" ).append("\n"); 
		query.append(",@[o_result]" ).append("\n"); 
		query.append(",@[o_err_msg])" ).append("\n"); 

	}
}