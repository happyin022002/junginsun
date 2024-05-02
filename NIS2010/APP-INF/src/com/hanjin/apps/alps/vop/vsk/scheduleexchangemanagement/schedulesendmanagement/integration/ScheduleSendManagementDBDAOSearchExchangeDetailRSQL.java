/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleSendManagementDBDAOSearchExchangeDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleSendManagementDBDAOSearchExchangeDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule Exchange 대상데이터 조회
	  * </pre>
	  */
	public ScheduleSendManagementDBDAOSearchExchangeDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleSendManagementDBDAOSearchExchangeDetailRSQL").append("\n"); 
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
		query.append("SELECT  	D.SND_RCV_KND_CD" ).append("\n"); 
		query.append("  		,  	D.SKD_EDI_RCV_DT" ).append("\n"); 
		query.append("  		,  	D.SKD_EDI_RCV_SEQ" ).append("\n"); 
		query.append("  		,  	D.EDI_XCH_LOG_SEQ" ).append("\n"); 
		query.append("  		,  	D.VPS_PORT_CD_CTNT" ).append("\n"); 
		query.append("		,	D.ALLN_PORT_CD_CTNT" ).append("\n"); 
		query.append("  		,  	D.VPS_PORT_NM" ).append("\n"); 
		query.append("  		,  	D.YD_CD_CTNT" ).append("\n"); 
		query.append("  		,  	D.CLPT_IND_SEQ_CTNT" ).append("\n"); 
		query.append("  		,  	D.CLPT_SEQ_CTNT" ).append("\n"); 
		query.append("  		,  	D.LOC_IND_CD_CTNT" ).append("\n"); 
		query.append("  		,  	D.CALL_YD_IND_SEQ_CTNT" ).append("\n"); 
		query.append("  		,  	D.VPS_ETA_DT_CTNT" ).append("\n"); 
		query.append("  		,  	D.VPS_ETB_DT_CTNT" ).append("\n"); 
		query.append("  		,  	D.VPS_ETD_DT_CTNT" ).append("\n"); 
		query.append("  		,  	D.ACT_ARR_DT_CTNT" ).append("\n"); 
		query.append("  		,  	D.ACT_BRTH_DT_CTNT" ).append("\n"); 
		query.append("  		,  	D.ACT_DEP_DT_CTNT" ).append("\n"); 
		query.append("  		,  	D.TURN_PORT_FLG_CTNT" ).append("\n"); 
		query.append("  		,  	D.TURN_PORT_IND_CD_CTNT" ).append("\n"); 
		query.append("  		,  	D.TURN_SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("  		,  	D.TURN_SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("  		,  	D.TURN_CLPT_IND_SEQ_CTNT" ).append("\n"); 
		query.append("  		,  	D.CRE_USR_ID" ).append("\n"); 
		query.append("  		,  	D.CRE_DT" ).append("\n"); 
		query.append("  		,  	D.UPD_USR_ID" ).append("\n"); 
		query.append("  		,  	D.UPD_DT" ).append("\n"); 
		query.append("  		,  	D.VSL_CD_CTNT" ).append("\n"); 
		query.append("  		,  	D.SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("  		,  	D.SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("FROM  		VSK_VSL_SKD_XCH_EDI_DTL  D" ).append("\n"); 
		query.append("WHERE       1 = 1" ).append("\n"); 
		query.append("AND			D.SND_RCV_KND_CD			= 'S'" ).append("\n"); 
		query.append("AND         D.VSL_CD_CTNT               = @[vsl_cd_ctnt]" ).append("\n"); 
		query.append("AND         D.SKD_VOY_NO_CTNT           = @[skd_voy_no_ctnt]" ).append("\n"); 
		query.append("AND         D.SKD_DIR_CD_CTNT           = @[skd_dir_cd_ctnt]" ).append("\n"); 
		query.append("AND			D.SKD_EDI_RCV_SEQ			= @[skd_edi_rcv_seq]" ).append("\n"); 

	}
}