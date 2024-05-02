/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleReceiveManagementDBDAOModifyExchangeHeaderUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleReceiveManagementDBDAOModifyExchangeHeaderUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exchange 반영상태 업데이트
	  * </pre>
	  */
	public ScheduleReceiveManagementDBDAOModifyExchangeHeaderUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_proc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration").append("\n"); 
		query.append("FileName : ScheduleReceiveManagementDBDAOModifyExchangeHeaderUSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("UPDATE     VSK_VSL_SKD_XCH_EDI_HDR  H" ).append("\n"); 
		query.append("SET        H.MAPG_SCS_FLG           = 'Y'" ).append("\n"); 
		query.append("       ,   H.EDI_PROC_RMK           = @[edi_proc_rmk]" ).append("\n"); 
		query.append("       ,   H.UPD_USR_ID             = 'EDI_XCH_AUTO_MAPPING'" ).append("\n"); 
		query.append("       ,   H.UPD_DT                 = SYSDATE" ).append("\n"); 
		query.append("WHERE      H.SND_RCV_KND_CD         = 'R'" ).append("\n"); 
		query.append("AND        H.SKD_EDI_RCV_SEQ        = @[skd_edi_rcv_seq]" ).append("\n"); 
		query.append("AND        H.VSL_CD_CTNT            = @[vsl_cd_ctnt]" ).append("\n"); 
		query.append("AND        H.SKD_VOY_NO_CTNT        = @[skd_voy_no_ctnt]" ).append("\n"); 
		query.append("AND        H.SKD_DIR_CD_CTNT        = @[skd_dir_cd_ctnt]  " ).append("\n"); 

	}
}