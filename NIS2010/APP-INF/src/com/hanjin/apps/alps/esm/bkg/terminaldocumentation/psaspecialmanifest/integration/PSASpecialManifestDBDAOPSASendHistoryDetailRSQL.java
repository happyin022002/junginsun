/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOPSASendHistoryDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.09
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.11.09 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOPSASendHistoryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgSendHistoryVO 생성을 위해 사용
	  * </pre>
	  */
	public PSASpecialManifestDBDAOPSASendHistoryDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOPSASendHistoryDetailRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("'' PSA_EDI_MSG_TP_ID" ).append("\n"); 
		query.append(",'' MSG_RCV_NO" ).append("\n"); 
		query.append(",'' RCV_LOG_SEQ" ).append("\n"); 
		query.append(",'' RCV_LOG_ERR_SEQ" ).append("\n"); 
		query.append(",'' CSTMS_ERR_ID" ).append("\n"); 
		query.append(",'' CSTMS_ERR_MSG" ).append("\n"); 
		query.append(",'' CSTMS_ERR_REF_NO1" ).append("\n"); 
		query.append(",'' CSTMS_ERR_REF_NO2" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' PSA_VSL_NM" ).append("\n"); 
		query.append(",'' IB_VVD_CD" ).append("\n"); 
		query.append(",'' OB_VVD_CD" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append(",'' ERR_CNTR_STS_CD" ).append("\n"); 
		query.append(",'' TNK_CNTR_TPSZ_FLG" ).append("\n"); 
		query.append(",'' TTL_PCK_QTY" ).append("\n"); 
		query.append(",'' TTL_PCK_TP_NM" ).append("\n"); 
		query.append(",'' DG_TTL_WGT" ).append("\n"); 
		query.append(",'' IMO_NO" ).append("\n"); 
		query.append(",'' IMDG_UN_NO" ).append("\n"); 
		query.append(",'' CNTR_TTL_KNT" ).append("\n"); 
		query.append(",'' CNTR_TTL_ERR_KNT" ).append("\n"); 
		query.append(",'' CNTR_TTL_SCS_KNT" ).append("\n"); 
		query.append(",'' imdg_pck_grp_cd" ).append("\n"); 
		query.append(",'' flsh_pnt_cdo_temp" ).append("\n"); 
		query.append(",'' imdg_pck_grp_cd" ).append("\n"); 
		query.append(",'' flsh_pnt_cdo_temp" ).append("\n"); 
		query.append(",'' eur_pck_desc" ).append("\n"); 
		query.append(",'' snd_dt" ).append("\n"); 
		query.append(",'' bl_no" ).append("\n"); 
		query.append(",'' vvd_cd" ).append("\n"); 
		query.append(",'' msg_func_id" ).append("\n"); 
		query.append(",'' eur_dg_decl_tp_cd" ).append("\n"); 
		query.append(",'' pck_qty" ).append("\n"); 
		query.append(",'' scr_file_no" ).append("\n"); 
		query.append(",'' port_cd" ).append("\n"); 
		query.append(",'' tran_id" ).append("\n"); 
		query.append(",'' imdg_un_no" ).append("\n"); 
		query.append(",'' ack_dt" ).append("\n"); 
		query.append(",'' auto_snd_tp_cd" ).append("\n"); 
		query.append(",'' net_wgt" ).append("\n"); 
		query.append(",'' cstms_err_msg" ).append("\n"); 
		query.append(",'' apro_dt" ).append("\n"); 
		query.append(",'' cntr_cgo_seq" ).append("\n"); 
		query.append(",'' cntr_no" ).append("\n"); 
		query.append(",'' ack_rcv_sts_cd" ).append("\n"); 
		query.append(",'' hzd_desc" ).append("\n"); 
		query.append(",'' prp_shp_nm" ).append("\n"); 
		query.append(",'' msg_snd_no" ).append("\n"); 
		query.append(",'' grs_wgt" ).append("\n"); 
		query.append(",'' imdg_clss_cd" ).append("\n"); 
		query.append(",'' MSG_SND_NO" ).append("\n"); 
		query.append(",'' SND_DT" ).append("\n"); 
		query.append(",'' SND_USR_ID" ).append("\n"); 
		query.append(",'' MSG_FUNC_ID" ).append("\n"); 
		query.append(",'' PSA_DG_DECL_TP_CD" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}