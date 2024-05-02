/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOUsaRcvMsgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.02.18 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOUsaRcvMsgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : UsaRcvMsgVO 생성후 아래 구문 필히 추가
	  * 
	  * 	public class UsaRcvMsgVO extends RcvMsgVO { // extends 수정추가.
	  * 
	  * 	private List<CstmsHldVO> cstmsHlds = null;
	  * 	public void setCstmsHldVOs(List<CstmsHldVO> cstmsHlds) {
	  * 		this.cstmsHlds = cstmsHlds;
	  * 	}	
	  * 	public List<CstmsHldVO> getCstmsHldVOs() {
	  * 		return this.cstmsHlds;
	  * 	}
	  * 	private List<CstmsClrVO> cstmsClrs = null;
	  * 	public void setCstmsClrVOs(List<CstmsClrVO> cstmsClrs) {
	  * 		this.cstmsClrs = cstmsClrs;
	  * 	}	
	  * 	public List<CstmsClrVO> getCstmsClrVOs() {
	  * 		return this.cstmsClrs;
	  * 	}
	  * 	private List<CstmsHldVO> cstmsHldSends = null;
	  * 	public void setCstmsHldSendVOs(List<CstmsHldVO> cstmsHldSends) {
	  * 		this.cstmsHldSends = cstmsHldSends;
	  * 	}	
	  * 	public List<CstmsHldVO> getCstmsHldSendVOs() {
	  * 		return this.cstmsHldSends;
	  * 	}
	  * 	private List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs = null;
	  * 	public void setBkgCstmsAdvIbdVOs(List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs) {
	  * 		this.bkgCstmsAdvIbdVOs = bkgCstmsAdvIbdVOs;
	  * 	}
	  * 	public List<BkgCstmsAdvIbdVO> getBkgCstmsAdvIbdVOs() {
	  * 		return this.bkgCstmsAdvIbdVOs;
	  * 	}
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOUsaRcvMsgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOUsaRcvMsgRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	'' acp_date," ).append("\n"); 
		query.append("	'' bl_no," ).append("\n"); 
		query.append("	'' cnru_it," ).append("\n"); 
		query.append("	'' cstms_clr_cd," ).append("\n"); 
		query.append("	'' cus_amsport," ).append("\n"); 
		query.append("	'' cus_loc," ).append("\n"); 
		query.append("	'' cntr_no," ).append("\n"); 
		query.append("	'' crr_bat_no," ).append("\n"); 
		query.append("	'' hbl_no," ).append("\n"); 
		query.append("	'' mbl_no," ).append("\n"); 
		query.append("	-- ibd_rst_update_flg: ibd에 bl번호로 업데이트 할지, HJBL번호로 업데이트 할지를 결정한다. in modifyResultCdByBl" ).append("\n"); 
		query.append("	'' ibd_rst_update_flg, -- 'BL/HJBL'" ).append("\n"); 
		query.append("	'' icr_resend_ind," ).append("\n"); 
		query.append("	'' icr_code," ).append("\n"); 
		query.append("	'' icr_qty, " ).append("\n"); 
		query.append("	'' icr_et_tp," ).append("\n"); 
		query.append("	'' icr_et_no," ).append("\n"); 
		query.append("	'' icr_date," ).append("\n"); 
		query.append("	'' icr_seq," ).append("\n"); 
		query.append("	'' icr_remark1," ).append("\n"); 
		query.append("	'' in_bl," ).append("\n"); 
		query.append("	'' in_cntr," ).append("\n"); 
		query.append("	'' in_code," ).append("\n"); 
		query.append("	'' in_codeb," ).append("\n"); 
		query.append("	'' in_hjbl," ).append("\n"); 
		query.append("	'' in_nvobl," ).append("\n"); 
		query.append("	'' in_pod," ).append("\n"); 
		query.append("	'' in_snp," ).append("\n"); 
		query.append("	'' in_vvd," ).append("\n"); 
		query.append("	'' ir_type," ).append("\n"); 
		query.append("	'' ir_date," ).append("\n"); 
		query.append("	'' ir_date_m," ).append("\n"); 
		query.append("	'' ir_seq," ).append("\n"); 
		query.append("	'' ir_batch_no," ).append("\n"); 
		query.append("	'' isf_in_bl," ).append("\n"); 
		query.append("	'' isf_in_remark1," ).append("\n"); 
		query.append("	'' isf_in_remark2," ).append("\n"); 
		query.append("	'' isf_tran_no" ).append("\n"); 
		query.append("   ,'' isf_rcv_cd" ).append("\n"); 
		query.append("   ,'' isf_seq" ).append("\n"); 
		query.append("   ,'' it_qty, 				--bl package quantity총수량" ).append("\n"); 
		query.append("	'' it_cusr_tqty,		--수신 받은 package총수량" ).append("\n"); 
		query.append("	'' it_cstmcind,			--c-flag" ).append("\n"); 
		query.append("	'' it_cgo_cind,			--c-flag" ).append("\n"); 
		query.append("	'' it_cusj_tqty,		--1J받은 총량" ).append("\n"); 
		query.append("	'' it_cusw_tqty,		--1W받은 총량" ).append("\n"); 
		query.append("	'' it_hub," ).append("\n"); 
		query.append("	'' it_last," ).append("\n"); 
		query.append("	'' lcl_bl_nbr_a," ).append("\n"); 
		query.append("	'' loc_ams_port_cd," ).append("\n"); 
		query.append("	'' master_or_house," ).append("\n"); 
		query.append("	'' msg_desc," ).append("\n"); 
		query.append("	'' new_cntr_c_flag," ).append("\n"); 
		query.append("	'' pod_amsport," ).append("\n"); 
		query.append("	'' pod_amsport_m," ).append("\n"); 
		query.append("	'' pod_loc," ).append("\n"); 
		query.append("	'' pod_loc_m," ).append("\n"); 
		query.append("	'' rcv_msg," ).append("\n"); 
		query.append("	'' remark2," ).append("\n"); 
		query.append("	'' remark3," ).append("\n"); 
		query.append("	'' rcv_msg_dtl_seq," ).append("\n"); 
		query.append("	'' skd_dir_cd," ).append("\n"); 
		query.append("	'' skd_voy_no," ).append("\n"); 
		query.append("	'' skd_voy_no_m," ).append("\n"); 
		query.append("	'' vsl_cd," ).append("\n"); 
		query.append("	'' vsl_cd_m," ).append("\n"); 
		query.append("	'' vsl_eng_nm," ).append("\n"); 
		query.append("	'' vsl_eng_nm_m," ).append("\n"); 
		query.append("	'' zone" ).append("\n"); 
		query.append("   ,'' rlse_hld_cd" ).append("\n"); 
		query.append("   ,'' rlse_hld_dt" ).append("\n"); 
		query.append("   ,'' hld_cd" ).append("\n"); 
		query.append("   ,'' hld_dt" ).append("\n"); 
		query.append("   ,'' cntr_hold_remark" ).append("\n"); 
		query.append("   ,'' pol_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}