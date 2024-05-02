/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOModifyCtmMvmtEdiMsgDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOModifyCtmMvmtEdiMsgDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Movement 수정
	  * </pre>
	  */
	public CIMCommonDBDAOModifyCtmMvmtEdiMsgDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOModifyCtmMvmtEdiMsgDataUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MVMT_EDI_MSG" ).append("\n"); 
		query.append("	SET MVMT_EDI_RSLT_CD = 'Y'," ).append("\n"); 
		query.append("		MVMT_EDI_RMK     = 'OK.PROCESSED'," ).append("\n"); 
		query.append("		EVNT_YD_CD       = @[org_yd_cd]," ).append("\n"); 
		query.append("		BKG_NO           = @[bkg_no]," ).append("\n"); 
		query.append("		CRNT_VSL_CD      = @[crnt_vsl_cd]," ).append("\n"); 
		query.append("		CRNT_SKD_VOY_NO  = @[crnt_skd_voy_no],		" ).append("\n"); 
		query.append("		CRNT_SKD_DIR_CD  = @[crnt_skd_dir_cd], " ).append("\n"); 
		query.append("		EDI_MVMT_STS_CD  = @[mvmt_sts_cd]," ).append("\n"); 
		query.append("		RTY_KNT          = RTY_KNT+1," ).append("\n"); 
		query.append("		UPD_LOCL_DT      = GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR(@[org_yd_cd], 0, 5 )) ," ).append("\n"); 
		query.append("		CNMV_RMK         = 'Appplied without validation' ," ).append("\n"); 
		query.append("		UPD_USR_ID       = 'OPUSADM'," ).append("\n"); 
		query.append("		UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHERE  MVMT_EDI_MSG_AREA_CD  	= @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("	AND MVMT_EDI_MSG_SEQ      = @[mvmt_edi_msg_seq]" ).append("\n"); 
		query.append("	AND MVMT_EDI_MSG_TP_ID    = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("	AND MVMT_EDI_MSG_YRMONDY  = @[mvmt_edi_msg_yrmondy]" ).append("\n"); 
		query.append("	AND MVMT_EDI_TP_CD        = @[mvmt_edi_tp_cd]" ).append("\n"); 

	}
}