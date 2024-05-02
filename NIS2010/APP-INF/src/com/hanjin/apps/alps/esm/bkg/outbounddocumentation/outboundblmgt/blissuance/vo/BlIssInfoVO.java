/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlIssInfoVO.java
*@FileTitle : BlIssInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.12.17 이진서 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.11.16 김보배 [CHM-201221290] [BKG] B/L Issue 화면에 B/L HOLD 기능 추가 & B/L Status Report 기능 보완 (NSC #2 & #3)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlIssInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlIssInfoVO> models = new ArrayList<BlIssInfoVO>();
	
	/* Column Info */
	private String vesselDirection = null;
	/* Column Info */
	private String blProofbyshipperDate = null;
	/* Column Info */
	private String oblPrnFlg = null;
	/* Column Info */
	private String blackCustomerFlag = null;
	/* Column Info */
	private String trdPpdOffice = null;
	/* Column Info */
	private String trdCctBy = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String docProcSeq = null;
	/* Column Info */
	private String issuedEnable = null;
	/* Column Info */
	private String tpbIndicator = null;
	/* Column Info */
	private String cctConfirm = null;
	/* Column Info */
	private String oblIssRmk = null;
	/* Column Info */
	private String fFwdAddress = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String trdCctRcvDt = null;
	/* Column Info */
	private String trdCctConfirm = null;
	/* Column Info */
	private String doIssueAt = null;
	/* Column Info */
	private String finalDest = null;
	/* Column Info */
	private String oBlreceiveType = null;
	/* Column Info */
	private String blReadyOffice = null;
	/* Column Info */
	private String doIssueBy = null;
	/* Column Info */
	private String cctDate = null;
	/* Column Info */
	private String trdCctRcv = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tpbStatus = null;
	/* Column Info */
	private String trdCctRcvUserId = null;
	/* Column Info */
	private String oBlreceiveAt = null;
	/* Column Info */
	private String cctRcvUserOffice = null;
	/* Column Info */
	private String delName = null;
	/* Column Info */
	private String preCarriageBy = null;
	/* Column Info */
	private String blReadyBy = null;
	/* Column Info */
	private String ppdOffice = null;
	/* Column Info */
	private String bkgSts = null;
	/* Column Info */
	private String cctBy = null;
	/* Column Info */
	private String trdPpdDate = null;
	/* Column Info */
	private String fFwdName = null;
	/* Column Info */
	private String trdPpdRcvUserId = null;
	/* Column Info */
	private String polCode = null;
	/* Column Info */
	private String doIssueNo = null;
	/* Column Info */
	private String blProofbyshipperBy = null;
	/* Column Info */
	private String bdr = null;
	/* Column Info */
	private String trdPpdRcv = null;
	/* Column Info */
	private String flgRate = null;
	/* Column Info */
	private String onBoardType = null;
	/* Column Info */
	private String ppdRcvDt = null;
	/* Column Info */
	private String doIssueDate = null;
	/* Column Info */
	private String blProofbyshipperOffice = null;
	/* Column Info */
	private String docProcModyflg = null;
	/* Column Info */
	private String flgToOrder = null;
	/* Column Info */
	private String blIssueDate = null;
	/* Column Info */
	private String oBlreceiveNo = null;
	/* Column Info */
	private String porCode = null;
	/* Column Info */
	private String blReadyType = null;
	/* Column Info */
	private String ppdDate = null;
	/* Column Info */
	private String trdCctOffice = null;
	/* Column Info */
	private String blIssueNo = null;
	/* Column Info */
	private String moveType = null;
	/* Column Info */
	private String oBlreceiveDate = null;
	/* Column Info */
	private String buttontype = null;
	/* Column Info */
	private String blIssueblType = null;
	/* Column Info */
	private String trdPpdConfirm = null;
	/* Column Info */
	private String shprAddress = null;
	/* Column Info */
	private String surrender = null;
	/* Column Info */
	private String trdCctDate = null;
	/* Column Info */
	private String blIssueAt = null;
	/* Column Info */
	private String polEtdDt = null;
	/* Column Info */
	private String cgoRcvDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cctRcvUserId = null;
	/* Column Info */
	private String ppdRcvUserId = null;
	/* Column Info */
	private String cctOffice = null;
	/* Column Info */
	private String blIssueRelease = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String blProofbyshipperCheckbox = null;
	/* Column Info */
	private String onBoardDate = null;
	/* Column Info */
	private String printOption = null;
	/* Column Info */
	private String blReadyCheckbox = null;
	/* Column Info */
	private String issued = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String delCode = null;
	/* Column Info */
	private String trdCctRcvUserOffice = null;
	/* Column Info */
	private String ppdRcvUserOffice = null;
	/* Column Info */
	private String cctRcvDt = null;
	/* Column Info */
	private String blIssueBy = null;
	/* Column Info */
	private String docProcType = null;
	/* Column Info */
	private String blReadyDate = null;
	/* Column Info */
	private String ppdBy = null;
	/* Column Info */
	private String shprName = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String trdPpdRcvDt = null;
	/* Column Info */
	private String internetAuth = null;
	/* Column Info */
	private String trdPpdRcvUserOffice = null;
	/* Column Info */
	private String released = null;
	/* Column Info */
	private String ppdConfirm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podName = null;
	/* Column Info */
	private String docRequestFlag = null;
	/* Column Info */
	private String polName = null;
	/* Column Info */
	private String cntcPsonEml = null;
	/* Column Info */
	private String porName = null;
	/* Column Info */
	private String authFlag = null;
	/* Column Info */
	private String updOffice = null;
	/* Column Info */
	private String oBlreceiveBy = null;
	/* Column Info */
	private String cctRcv = null;
	/* Column Info */
	private String flgDo = null;
	/* Column Info */
	private String flgMd = null;
	/* Column Info */
	private String podCode = null;
	/* Column Info */
	private String flgPpd = null;
	/* Column Info */
	private String trdFlgPpd = null;
	/* Column Info */
	private String trdPpdBy = null;
	/* Column Info */
	private String ppdRcv = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String blHldFlg = null;
	/* Column Info */
	private String blHldRsnCd = null;
	/* Column Info */
	private String blHldDt = null;
	/* Column Info */
	private String blHldUsrId = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String wblEml = null;
	/* Column Info */
	private String wblRtTpCd = null;
	/* Column Info */
	private String imgFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlIssInfoVO() {}

	public BlIssInfoVO(String ibflag, String pagerows, String oblIssRmk, String vesselDirection, String blProofbyshipperDate, String oblPrnFlg, String blackCustomerFlag, String trdPpdOffice, String trdCctBy, String docProcSeq, String issuedEnable, String tpbIndicator, String cctConfirm, String fFwdAddress, String updUsrId, String trdCctRcvDt, String trdCctConfirm, String doIssueAt, String finalDest, String oBlreceiveType, String blReadyOffice, String doIssueBy, String cctDate, String trdCctRcv, String bkgNo, String tpbStatus, String trdCctRcvUserId, String oBlreceiveAt, String cctRcvUserOffice, String delName, String blReadyBy, String preCarriageBy, String ppdOffice, String cctBy, String bkgSts, String trdPpdDate, String fFwdName, String trdPpdRcvUserId, String polCode, String blProofbyshipperBy, String doIssueNo, String bdr, String trdPpdRcv, String flgRate, String onBoardType, String blProofbyshipperOffice, String doIssueDate, String ppdRcvDt, String docProcModyflg, String flgToOrder, String blIssueDate, String oBlreceiveNo, String porCode, String blReadyType, String ppdDate, String trdCctOffice, String blIssueNo, String moveType, String oBlreceiveDate, String buttontype, String blIssueblType, String trdPpdConfirm, String shprAddress, String surrender, String trdCctDate, String blIssueAt, String polEtdDt, String cgoRcvDt, String blNo, String cctRcvUserId, String ppdRcvUserId, String cctOffice, String blIssueRelease, String custToOrdFlg, String blProofbyshipperCheckbox, String onBoardDate, String printOption, String blReadyCheckbox, String issued, String tvvd, String delCode, String trdCctRcvUserOffice, String ppdRcvUserOffice, String cctRcvDt, String blIssueBy, String docProcType, String blReadyDate, String ppdBy, String shprName, String shprCntCd, String shprSeq, String trdPpdRcvDt, String internetAuth, String trdPpdRcvUserOffice, String released, String ppdConfirm, String podName, String docRequestFlag, String polName, String cntcPsonEml, String authFlag, String porName, String updOffice, String oBlreceiveBy, String cctRcv, String flgDo, String podCode, String flgMd, String flgPpd, String trdFlgPpd, String trdPpdBy, String ppdRcv, String oblIssFlg, String blHldFlg, String blHldRsnCd, String blHldDt, String blHldUsrId, String podNodCd, String delNodCd, String wblRtTpCd,String wblEml, String imgFlg) {
		this.vesselDirection = vesselDirection;
		this.blProofbyshipperDate = blProofbyshipperDate;
		this.oblPrnFlg = oblPrnFlg;
		this.blackCustomerFlag = blackCustomerFlag;
		this.trdPpdOffice = trdPpdOffice;
		this.trdCctBy = trdCctBy;
		this.pagerows = pagerows;
		this.docProcSeq = docProcSeq;
		this.issuedEnable = issuedEnable;
		this.tpbIndicator = tpbIndicator;
		this.cctConfirm = cctConfirm;
		this.oblIssRmk = oblIssRmk;
		this.fFwdAddress = fFwdAddress;
		this.updUsrId = updUsrId;
		this.trdCctRcvDt = trdCctRcvDt;
		this.trdCctConfirm = trdCctConfirm;
		this.doIssueAt = doIssueAt;
		this.finalDest = finalDest;
		this.oBlreceiveType = oBlreceiveType;
		this.blReadyOffice = blReadyOffice;
		this.doIssueBy = doIssueBy;
		this.cctDate = cctDate;
		this.trdCctRcv = trdCctRcv;
		this.bkgNo = bkgNo;
		this.tpbStatus = tpbStatus;
		this.trdCctRcvUserId = trdCctRcvUserId;
		this.oBlreceiveAt = oBlreceiveAt;
		this.cctRcvUserOffice = cctRcvUserOffice;
		this.delName = delName;
		this.preCarriageBy = preCarriageBy;
		this.blReadyBy = blReadyBy;
		this.ppdOffice = ppdOffice;
		this.bkgSts = bkgSts;
		this.cctBy = cctBy;
		this.trdPpdDate = trdPpdDate;
		this.fFwdName = fFwdName;
		this.trdPpdRcvUserId = trdPpdRcvUserId;
		this.polCode = polCode;
		this.doIssueNo = doIssueNo;
		this.blProofbyshipperBy = blProofbyshipperBy;
		this.bdr = bdr;
		this.trdPpdRcv = trdPpdRcv;
		this.flgRate = flgRate;
		this.onBoardType = onBoardType;
		this.ppdRcvDt = ppdRcvDt;
		this.doIssueDate = doIssueDate;
		this.blProofbyshipperOffice = blProofbyshipperOffice;
		this.docProcModyflg = docProcModyflg;
		this.flgToOrder = flgToOrder;
		this.blIssueDate = blIssueDate;
		this.oBlreceiveNo = oBlreceiveNo;
		this.porCode = porCode;
		this.blReadyType = blReadyType;
		this.ppdDate = ppdDate;
		this.trdCctOffice = trdCctOffice;
		this.blIssueNo = blIssueNo;
		this.moveType = moveType;
		this.oBlreceiveDate = oBlreceiveDate;
		this.buttontype = buttontype;
		this.blIssueblType = blIssueblType;
		this.trdPpdConfirm = trdPpdConfirm;
		this.shprAddress = shprAddress;
		this.surrender = surrender;
		this.trdCctDate = trdCctDate;
		this.blIssueAt = blIssueAt;
		this.polEtdDt = polEtdDt;
		this.cgoRcvDt = cgoRcvDt;
		this.blNo = blNo;
		this.cctRcvUserId = cctRcvUserId;
		this.ppdRcvUserId = ppdRcvUserId;
		this.cctOffice = cctOffice;
		this.blIssueRelease = blIssueRelease;
		this.custToOrdFlg = custToOrdFlg;
		this.blProofbyshipperCheckbox = blProofbyshipperCheckbox;
		this.onBoardDate = onBoardDate;
		this.printOption = printOption;
		this.blReadyCheckbox = blReadyCheckbox;
		this.issued = issued;
		this.tvvd = tvvd;
		this.delCode = delCode;
		this.trdCctRcvUserOffice = trdCctRcvUserOffice;
		this.ppdRcvUserOffice = ppdRcvUserOffice;
		this.cctRcvDt = cctRcvDt;
		this.blIssueBy = blIssueBy;
		this.docProcType = docProcType;
		this.blReadyDate = blReadyDate;
		this.ppdBy = ppdBy;
		this.shprName = shprName;
		this.shprCntCd = shprCntCd;
		this.shprSeq = shprSeq;
		this.trdPpdRcvDt = trdPpdRcvDt;
		this.internetAuth = internetAuth;
		this.trdPpdRcvUserOffice = trdPpdRcvUserOffice;
		this.released = released;
		this.ppdConfirm = ppdConfirm;
		this.ibflag = ibflag;
		this.podName = podName;
		this.docRequestFlag = docRequestFlag;
		this.polName = polName;
		this.cntcPsonEml = cntcPsonEml;
		this.porName = porName;
		this.authFlag = authFlag;
		this.updOffice = updOffice;
		this.oBlreceiveBy = oBlreceiveBy;
		this.cctRcv = cctRcv;
		this.flgDo = flgDo;
		this.flgMd = flgMd;
		this.podCode = podCode;
		this.flgPpd = flgPpd;
		this.trdFlgPpd = trdFlgPpd;
		this.trdPpdBy = trdPpdBy;
		this.ppdRcv = ppdRcv;
		this.oblIssFlg = oblIssFlg;
		this.blHldFlg = blHldFlg;
		this.blHldRsnCd = blHldRsnCd;
		this.blHldDt = blHldDt;
		this.blHldUsrId = blHldUsrId;
		this.podNodCd = podNodCd;
		this.delNodCd = delNodCd;
		this.wblEml = wblEml;
		this.wblRtTpCd = wblRtTpCd;
		this.imgFlg = imgFlg;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vessel_direction", getVesselDirection());
		this.hashColumns.put("bl_proofbyshipper_date", getBlProofbyshipperDate());
		this.hashColumns.put("obl_prn_flg", getOblPrnFlg());
		this.hashColumns.put("black_customer_flag", getBlackCustomerFlag());
		this.hashColumns.put("trd_ppd_office", getTrdPpdOffice());
		this.hashColumns.put("trd_cct_by", getTrdCctBy());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("doc_proc_seq", getDocProcSeq());
		this.hashColumns.put("issued_enable", getIssuedEnable());
		this.hashColumns.put("tpb_indicator", getTpbIndicator());
		this.hashColumns.put("cct_confirm", getCctConfirm());
		this.hashColumns.put("obl_iss_rmk", getOblIssRmk());
		this.hashColumns.put("f_fwd_address", getFFwdAddress());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("trd_cct_rcv_dt", getTrdCctRcvDt());
		this.hashColumns.put("trd_cct_confirm", getTrdCctConfirm());
		this.hashColumns.put("do_issue_at", getDoIssueAt());
		this.hashColumns.put("final_dest", getFinalDest());
		this.hashColumns.put("o_blreceive_type", getOBlreceiveType());
		this.hashColumns.put("bl_ready_office", getBlReadyOffice());
		this.hashColumns.put("do_issue_by", getDoIssueBy());
		this.hashColumns.put("cct_date", getCctDate());
		this.hashColumns.put("trd_cct_rcv", getTrdCctRcv());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tpb_status", getTpbStatus());
		this.hashColumns.put("trd_cct_rcv_user_id", getTrdCctRcvUserId());
		this.hashColumns.put("o_blreceive_at", getOBlreceiveAt());
		this.hashColumns.put("cct_rcv_user_office", getCctRcvUserOffice());
		this.hashColumns.put("del_name", getDelName());
		this.hashColumns.put("pre_carriage_by", getPreCarriageBy());
		this.hashColumns.put("bl_ready_by", getBlReadyBy());
		this.hashColumns.put("ppd_office", getPpdOffice());
		this.hashColumns.put("bkg_sts", getBkgSts());
		this.hashColumns.put("cct_by", getCctBy());
		this.hashColumns.put("trd_ppd_date", getTrdPpdDate());
		this.hashColumns.put("f_fwd_name", getFFwdName());
		this.hashColumns.put("trd_ppd_rcv_user_id", getTrdPpdRcvUserId());
		this.hashColumns.put("pol_code", getPolCode());
		this.hashColumns.put("do_issue_no", getDoIssueNo());
		this.hashColumns.put("bl_proofbyshipper_by", getBlProofbyshipperBy());
		this.hashColumns.put("bdr", getBdr());
		this.hashColumns.put("trd_ppd_rcv", getTrdPpdRcv());
		this.hashColumns.put("flg_rate", getFlgRate());
		this.hashColumns.put("on_board_type", getOnBoardType());
		this.hashColumns.put("ppd_rcv_dt", getPpdRcvDt());
		this.hashColumns.put("do_issue_date", getDoIssueDate());
		this.hashColumns.put("bl_proofbyshipper_office", getBlProofbyshipperOffice());
		this.hashColumns.put("doc_proc_modyflg", getDocProcModyflg());
		this.hashColumns.put("flg_to_order", getFlgToOrder());
		this.hashColumns.put("bl_issue_date", getBlIssueDate());
		this.hashColumns.put("o_blreceive_no", getOBlreceiveNo());
		this.hashColumns.put("por_code", getPorCode());
		this.hashColumns.put("bl_ready_type", getBlReadyType());
		this.hashColumns.put("ppd_date", getPpdDate());
		this.hashColumns.put("trd_cct_office", getTrdCctOffice());
		this.hashColumns.put("bl_issue_no", getBlIssueNo());
		this.hashColumns.put("move_type", getMoveType());
		this.hashColumns.put("o_blreceive_date", getOBlreceiveDate());
		this.hashColumns.put("buttontype", getButtontype());
		this.hashColumns.put("bl_issuebl_type", getBlIssueblType());
		this.hashColumns.put("trd_ppd_confirm", getTrdPpdConfirm());
		this.hashColumns.put("shpr_address", getShprAddress());
		this.hashColumns.put("surrender", getSurrender());
		this.hashColumns.put("trd_cct_date", getTrdCctDate());
		this.hashColumns.put("bl_issue_at", getBlIssueAt());
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());
		this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cct_rcv_user_id", getCctRcvUserId());
		this.hashColumns.put("ppd_rcv_user_id", getPpdRcvUserId());
		this.hashColumns.put("cct_office", getCctOffice());
		this.hashColumns.put("bl_issue_release", getBlIssueRelease());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("bl_proofbyshipper_checkbox", getBlProofbyshipperCheckbox());
		this.hashColumns.put("on_board_date", getOnBoardDate());
		this.hashColumns.put("print_option", getPrintOption());
		this.hashColumns.put("bl_ready_checkbox", getBlReadyCheckbox());
		this.hashColumns.put("issued", getIssued());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("del_code", getDelCode());
		this.hashColumns.put("trd_cct_rcv_user_office", getTrdCctRcvUserOffice());
		this.hashColumns.put("ppd_rcv_user_office", getPpdRcvUserOffice());
		this.hashColumns.put("cct_rcv_dt", getCctRcvDt());
		this.hashColumns.put("bl_issue_by", getBlIssueBy());
		this.hashColumns.put("doc_proc_type", getDocProcType());
		this.hashColumns.put("bl_ready_date", getBlReadyDate());
		this.hashColumns.put("ppd_by", getPpdBy());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("trd_ppd_rcv_dt", getTrdPpdRcvDt());
		this.hashColumns.put("internet_auth", getInternetAuth());
		this.hashColumns.put("trd_ppd_rcv_user_office", getTrdPpdRcvUserOffice());
		this.hashColumns.put("released", getReleased());
		this.hashColumns.put("ppd_confirm", getPpdConfirm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_name", getPodName());
		this.hashColumns.put("doc_request_flag", getDocRequestFlag());
		this.hashColumns.put("pol_name", getPolName());
		this.hashColumns.put("cntc_pson_eml", getCntcPsonEml());
		this.hashColumns.put("por_name", getPorName());
		this.hashColumns.put("auth_flag", getAuthFlag());
		this.hashColumns.put("upd_office", getUpdOffice());
		this.hashColumns.put("o_blreceive_by", getOBlreceiveBy());
		this.hashColumns.put("cct_rcv", getCctRcv());
		this.hashColumns.put("flg_do", getFlgDo());
		this.hashColumns.put("flg_md", getFlgMd());
		this.hashColumns.put("pod_code", getPodCode());
		this.hashColumns.put("flg_ppd", getFlgPpd());
		this.hashColumns.put("trd_flg_ppd", getTrdFlgPpd());
		this.hashColumns.put("trd_ppd_by", getTrdPpdBy());
		this.hashColumns.put("ppd_rcv", getPpdRcv());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("bl_hld_flg", getBlHldFlg());
		this.hashColumns.put("bl_hld_rsn_cd", getBlHldRsnCd());
		this.hashColumns.put("bl_hld_dt", getBlHldDt());
		this.hashColumns.put("bl_hld_usr_id", getBlHldUsrId());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("wbl_eml", getWblEml());
		this.hashColumns.put("wbl_rt_tp_cd", getWblRtTpCd());
		this.hashColumns.put("img_flg", getImgFlg());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vessel_direction", "vesselDirection");
		this.hashFields.put("bl_proofbyshipper_date", "blProofbyshipperDate");
		this.hashFields.put("obl_prn_flg", "oblPrnFlg");
		this.hashFields.put("black_customer_flag", "blackCustomerFlag");
		this.hashFields.put("trd_ppd_office", "trdPpdOffice");
		this.hashFields.put("trd_cct_by", "trdCctBy");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("doc_proc_seq", "docProcSeq");
		this.hashFields.put("issued_enable", "issuedEnable");
		this.hashFields.put("tpb_indicator", "tpbIndicator");
		this.hashFields.put("cct_confirm", "cctConfirm");
		this.hashFields.put("obl_iss_rmk", "oblIssRmk");
		this.hashFields.put("f_fwd_address", "fFwdAddress");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("trd_cct_rcv_dt", "trdCctRcvDt");
		this.hashFields.put("trd_cct_confirm", "trdCctConfirm");
		this.hashFields.put("do_issue_at", "doIssueAt");
		this.hashFields.put("final_dest", "finalDest");
		this.hashFields.put("o_blreceive_type", "oBlreceiveType");
		this.hashFields.put("bl_ready_office", "blReadyOffice");
		this.hashFields.put("do_issue_by", "doIssueBy");
		this.hashFields.put("cct_date", "cctDate");
		this.hashFields.put("trd_cct_rcv", "trdCctRcv");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tpb_status", "tpbStatus");
		this.hashFields.put("trd_cct_rcv_user_id", "trdCctRcvUserId");
		this.hashFields.put("o_blreceive_at", "oBlreceiveAt");
		this.hashFields.put("cct_rcv_user_office", "cctRcvUserOffice");
		this.hashFields.put("del_name", "delName");
		this.hashFields.put("pre_carriage_by", "preCarriageBy");
		this.hashFields.put("bl_ready_by", "blReadyBy");
		this.hashFields.put("ppd_office", "ppdOffice");
		this.hashFields.put("bkg_sts", "bkgSts");
		this.hashFields.put("cct_by", "cctBy");
		this.hashFields.put("trd_ppd_date", "trdPpdDate");
		this.hashFields.put("f_fwd_name", "fFwdName");
		this.hashFields.put("trd_ppd_rcv_user_id", "trdPpdRcvUserId");
		this.hashFields.put("pol_code", "polCode");
		this.hashFields.put("do_issue_no", "doIssueNo");
		this.hashFields.put("bl_proofbyshipper_by", "blProofbyshipperBy");
		this.hashFields.put("bdr", "bdr");
		this.hashFields.put("trd_ppd_rcv", "trdPpdRcv");
		this.hashFields.put("flg_rate", "flgRate");
		this.hashFields.put("on_board_type", "onBoardType");
		this.hashFields.put("ppd_rcv_dt", "ppdRcvDt");
		this.hashFields.put("do_issue_date", "doIssueDate");
		this.hashFields.put("bl_proofbyshipper_office", "blProofbyshipperOffice");
		this.hashFields.put("doc_proc_modyflg", "docProcModyflg");
		this.hashFields.put("flg_to_order", "flgToOrder");
		this.hashFields.put("bl_issue_date", "blIssueDate");
		this.hashFields.put("o_blreceive_no", "oBlreceiveNo");
		this.hashFields.put("por_code", "porCode");
		this.hashFields.put("bl_ready_type", "blReadyType");
		this.hashFields.put("ppd_date", "ppdDate");
		this.hashFields.put("trd_cct_office", "trdCctOffice");
		this.hashFields.put("bl_issue_no", "blIssueNo");
		this.hashFields.put("move_type", "moveType");
		this.hashFields.put("o_blreceive_date", "oBlreceiveDate");
		this.hashFields.put("buttontype", "buttontype");
		this.hashFields.put("bl_issuebl_type", "blIssueblType");
		this.hashFields.put("trd_ppd_confirm", "trdPpdConfirm");
		this.hashFields.put("shpr_address", "shprAddress");
		this.hashFields.put("surrender", "surrender");
		this.hashFields.put("trd_cct_date", "trdCctDate");
		this.hashFields.put("bl_issue_at", "blIssueAt");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cct_rcv_user_id", "cctRcvUserId");
		this.hashFields.put("ppd_rcv_user_id", "ppdRcvUserId");
		this.hashFields.put("cct_office", "cctOffice");
		this.hashFields.put("bl_issue_release", "blIssueRelease");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("bl_proofbyshipper_checkbox", "blProofbyshipperCheckbox");
		this.hashFields.put("on_board_date", "onBoardDate");
		this.hashFields.put("print_option", "printOption");
		this.hashFields.put("bl_ready_checkbox", "blReadyCheckbox");
		this.hashFields.put("issued", "issued");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("del_code", "delCode");
		this.hashFields.put("trd_cct_rcv_user_office", "trdCctRcvUserOffice");
		this.hashFields.put("ppd_rcv_user_office", "ppdRcvUserOffice");
		this.hashFields.put("cct_rcv_dt", "cctRcvDt");
		this.hashFields.put("bl_issue_by", "blIssueBy");
		this.hashFields.put("doc_proc_type", "docProcType");
		this.hashFields.put("bl_ready_date", "blReadyDate");
		this.hashFields.put("ppd_by", "ppdBy");
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("trd_ppd_rcv_dt", "trdPpdRcvDt");
		this.hashFields.put("internet_auth", "internetAuth");
		this.hashFields.put("trd_ppd_rcv_user_office", "trdPpdRcvUserOffice");
		this.hashFields.put("released", "released");
		this.hashFields.put("ppd_confirm", "ppdConfirm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_name", "podName");
		this.hashFields.put("doc_request_flag", "docRequestFlag");
		this.hashFields.put("pol_name", "polName");
		this.hashFields.put("cntc_pson_eml", "cntcPsonEml");
		this.hashFields.put("por_name", "porName");
		this.hashFields.put("auth_flag", "authFlag");
		this.hashFields.put("upd_office", "updOffice");
		this.hashFields.put("o_blreceive_by", "oBlreceiveBy");
		this.hashFields.put("cct_rcv", "cctRcv");
		this.hashFields.put("flg_do", "flgDo");
		this.hashFields.put("flg_md", "flgMd");
		this.hashFields.put("pod_code", "podCode");
		this.hashFields.put("flg_ppd", "flgPpd");
		this.hashFields.put("trd_flg_ppd", "trdFlgPpd");
		this.hashFields.put("trd_ppd_by", "trdPpdBy");
		this.hashFields.put("ppd_rcv", "ppdRcv");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("bl_hld_flg", "blHldFlg");
		this.hashFields.put("bl_hld_rsn_cd", "blHldRsnCd");
		this.hashFields.put("bl_hld_dt", "blHldDt");
		this.hashFields.put("bl_hld_usr_id", "blHldUsrId");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("wbl_eml", "wblEml");
		this.hashFields.put("wbl_rt_tp_cd", "wblRtTpCd");
		this.hashFields.put("img_flg", "imgFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vesselDirection
	 */
	public String getVesselDirection() {
		return this.vesselDirection;
	}
	
	/**
	 * Column Info
	 * @return blProofbyshipperDate
	 */
	public String getBlProofbyshipperDate() {
		return this.blProofbyshipperDate;
	}
	
	/**
	 * Column Info
	 * @return oblPrnFlg
	 */
	public String getOblPrnFlg() {
		return this.oblPrnFlg;
	}
	
	
	/**
	 * Column Info
	 * @return imgFlg
	 */
	public String getImgFlg() {
		return this.imgFlg;
	}
	
	/**
	 * Column Info
	 * @return wblEml
	 */
	public String getWblEml() {
		return this.wblEml;
	}
	
	
	/**
	 * Column Info
	 * @return wblRtTpCd
	 */
	public String getWblRtTpCd() {
		return this.wblRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return blackCustomerFlag
	 */
	public String getBlackCustomerFlag() {
		return this.blackCustomerFlag;
	}
	
	/**
	 * Column Info
	 * @return trdPpdOffice
	 */
	public String getTrdPpdOffice() {
		return this.trdPpdOffice;
	}
	
	/**
	 * Column Info
	 * @return trdCctBy
	 */
	public String getTrdCctBy() {
		return this.trdCctBy;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return docProcSeq
	 */
	public String getDocProcSeq() {
		return this.docProcSeq;
	}
	
	/**
	 * Column Info
	 * @return issuedEnable
	 */
	public String getIssuedEnable() {
		return this.issuedEnable;
	}
	
	/**
	 * Column Info
	 * @return tpbIndicator
	 */
	public String getTpbIndicator() {
		return this.tpbIndicator;
	}
	
	/**
	 * Column Info
	 * @return cctConfirm
	 */
	public String getCctConfirm() {
		return this.cctConfirm;
	}
	
	/**
	 * Column Info
	 * @return oblIssRmk
	 */
	public String getOblIssRmk() {
		return this.oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @return fFwdAddress
	 */
	public String getFFwdAddress() {
		return this.fFwdAddress;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return trdCctRcvDt
	 */
	public String getTrdCctRcvDt() {
		return this.trdCctRcvDt;
	}
	
	/**
	 * Column Info
	 * @return trdCctConfirm
	 */
	public String getTrdCctConfirm() {
		return this.trdCctConfirm;
	}
	
	/**
	 * Column Info
	 * @return doIssueAt
	 */
	public String getDoIssueAt() {
		return this.doIssueAt;
	}
	
	/**
	 * Column Info
	 * @return finalDest
	 */
	public String getFinalDest() {
		return this.finalDest;
	}
	
	/**
	 * Column Info
	 * @return oBlreceiveType
	 */
	public String getOBlreceiveType() {
		return this.oBlreceiveType;
	}
	
	/**
	 * Column Info
	 * @return blReadyOffice
	 */
	public String getBlReadyOffice() {
		return this.blReadyOffice;
	}
	
	/**
	 * Column Info
	 * @return doIssueBy
	 */
	public String getDoIssueBy() {
		return this.doIssueBy;
	}
	
	/**
	 * Column Info
	 * @return cctDate
	 */
	public String getCctDate() {
		return this.cctDate;
	}
	
	/**
	 * Column Info
	 * @return trdCctRcv
	 */
	public String getTrdCctRcv() {
		return this.trdCctRcv;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return tpbStatus
	 */
	public String getTpbStatus() {
		return this.tpbStatus;
	}
	
	/**
	 * Column Info
	 * @return trdCctRcvUserId
	 */
	public String getTrdCctRcvUserId() {
		return this.trdCctRcvUserId;
	}
	
	/**
	 * Column Info
	 * @return oBlreceiveAt
	 */
	public String getOBlreceiveAt() {
		return this.oBlreceiveAt;
	}
	
	/**
	 * Column Info
	 * @return cctRcvUserOffice
	 */
	public String getCctRcvUserOffice() {
		return this.cctRcvUserOffice;
	}
	
	/**
	 * Column Info
	 * @return delName
	 */
	public String getDelName() {
		return this.delName;
	}
	
	/**
	 * Column Info
	 * @return preCarriageBy
	 */
	public String getPreCarriageBy() {
		return this.preCarriageBy;
	}
	
	/**
	 * Column Info
	 * @return blReadyBy
	 */
	public String getBlReadyBy() {
		return this.blReadyBy;
	}
	
	/**
	 * Column Info
	 * @return ppdOffice
	 */
	public String getPpdOffice() {
		return this.ppdOffice;
	}
	
	/**
	 * Column Info
	 * @return bkgSts
	 */
	public String getBkgSts() {
		return this.bkgSts;
	}
	
	/**
	 * Column Info
	 * @return cctBy
	 */
	public String getCctBy() {
		return this.cctBy;
	}
	
	/**
	 * Column Info
	 * @return trdPpdDate
	 */
	public String getTrdPpdDate() {
		return this.trdPpdDate;
	}
	
	/**
	 * Column Info
	 * @return fFwdName
	 */
	public String getFFwdName() {
		return this.fFwdName;
	}
	
	/**
	 * Column Info
	 * @return trdPpdRcvUserId
	 */
	public String getTrdPpdRcvUserId() {
		return this.trdPpdRcvUserId;
	}
	
	/**
	 * Column Info
	 * @return polCode
	 */
	public String getPolCode() {
		return this.polCode;
	}
	
	/**
	 * Column Info
	 * @return doIssueNo
	 */
	public String getDoIssueNo() {
		return this.doIssueNo;
	}
	
	/**
	 * Column Info
	 * @return blProofbyshipperBy
	 */
	public String getBlProofbyshipperBy() {
		return this.blProofbyshipperBy;
	}
	
	/**
	 * Column Info
	 * @return bdr
	 */
	public String getBdr() {
		return this.bdr;
	}
	
	/**
	 * Column Info
	 * @return trdPpdRcv
	 */
	public String getTrdPpdRcv() {
		return this.trdPpdRcv;
	}
	
	/**
	 * Column Info
	 * @return flgRate
	 */
	public String getFlgRate() {
		return this.flgRate;
	}
	
	/**
	 * Column Info
	 * @return onBoardType
	 */
	public String getOnBoardType() {
		return this.onBoardType;
	}
	
	/**
	 * Column Info
	 * @return ppdRcvDt
	 */
	public String getPpdRcvDt() {
		return this.ppdRcvDt;
	}
	
	/**
	 * Column Info
	 * @return doIssueDate
	 */
	public String getDoIssueDate() {
		return this.doIssueDate;
	}
	
	/**
	 * Column Info
	 * @return blProofbyshipperOffice
	 */
	public String getBlProofbyshipperOffice() {
		return this.blProofbyshipperOffice;
	}
	
	/**
	 * Column Info
	 * @return docProcModyflg
	 */
	public String getDocProcModyflg() {
		return this.docProcModyflg;
	}
	
	/**
	 * Column Info
	 * @return flgToOrder
	 */
	public String getFlgToOrder() {
		return this.flgToOrder;
	}
	
	/**
	 * Column Info
	 * @return blIssueDate
	 */
	public String getBlIssueDate() {
		return this.blIssueDate;
	}
	
	/**
	 * Column Info
	 * @return oBlreceiveNo
	 */
	public String getOBlreceiveNo() {
		return this.oBlreceiveNo;
	}
	
	/**
	 * Column Info
	 * @return porCode
	 */
	public String getPorCode() {
		return this.porCode;
	}
	
	/**
	 * Column Info
	 * @return blReadyType
	 */
	public String getBlReadyType() {
		return this.blReadyType;
	}
	
	/**
	 * Column Info
	 * @return ppdDate
	 */
	public String getPpdDate() {
		return this.ppdDate;
	}
	
	/**
	 * Column Info
	 * @return trdCctOffice
	 */
	public String getTrdCctOffice() {
		return this.trdCctOffice;
	}
	
	/**
	 * Column Info
	 * @return blIssueNo
	 */
	public String getBlIssueNo() {
		return this.blIssueNo;
	}
	
	/**
	 * Column Info
	 * @return moveType
	 */
	public String getMoveType() {
		return this.moveType;
	}
	
	/**
	 * Column Info
	 * @return oBlreceiveDate
	 */
	public String getOBlreceiveDate() {
		return this.oBlreceiveDate;
	}
	
	/**
	 * Column Info
	 * @return buttontype
	 */
	public String getButtontype() {
		return this.buttontype;
	}
	
	/**
	 * Column Info
	 * @return blIssueblType
	 */
	public String getBlIssueblType() {
		return this.blIssueblType;
	}
	
	/**
	 * Column Info
	 * @return trdPpdConfirm
	 */
	public String getTrdPpdConfirm() {
		return this.trdPpdConfirm;
	}
	
	/**
	 * Column Info
	 * @return shprAddress
	 */
	public String getShprAddress() {
		return this.shprAddress;
	}
	
	/**
	 * Column Info
	 * @return surrender
	 */
	public String getSurrender() {
		return this.surrender;
	}
	
	/**
	 * Column Info
	 * @return trdCctDate
	 */
	public String getTrdCctDate() {
		return this.trdCctDate;
	}
	
	/**
	 * Column Info
	 * @return blIssueAt
	 */
	public String getBlIssueAt() {
		return this.blIssueAt;
	}
	
	/**
	 * Column Info
	 * @return polEtdDt
	 */
	public String getPolEtdDt() {
		return this.polEtdDt;
	}
	
	/**
	 * Column Info
	 * @return cgoRcvDt
	 */
	public String getCgoRcvDt() {
		return this.cgoRcvDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cctRcvUserId
	 */
	public String getCctRcvUserId() {
		return this.cctRcvUserId;
	}
	
	/**
	 * Column Info
	 * @return ppdRcvUserId
	 */
	public String getPpdRcvUserId() {
		return this.ppdRcvUserId;
	}
	
	/**
	 * Column Info
	 * @return cctOffice
	 */
	public String getCctOffice() {
		return this.cctOffice;
	}
	
	/**
	 * Column Info
	 * @return blIssueRelease
	 */
	public String getBlIssueRelease() {
		return this.blIssueRelease;
	}
	
	/**
	 * Column Info
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return blProofbyshipperCheckbox
	 */
	public String getBlProofbyshipperCheckbox() {
		return this.blProofbyshipperCheckbox;
	}
	
	/**
	 * Column Info
	 * @return onBoardDate
	 */
	public String getOnBoardDate() {
		return this.onBoardDate;
	}
	
	/**
	 * Column Info
	 * @return printOption
	 */
	public String getPrintOption() {
		return this.printOption;
	}
	
	/**
	 * Column Info
	 * @return blReadyCheckbox
	 */
	public String getBlReadyCheckbox() {
		return this.blReadyCheckbox;
	}
	
	/**
	 * Column Info
	 * @return issued
	 */
	public String getIssued() {
		return this.issued;
	}
	
	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return delCode
	 */
	public String getDelCode() {
		return this.delCode;
	}
	
	/**
	 * Column Info
	 * @return trdCctRcvUserOffice
	 */
	public String getTrdCctRcvUserOffice() {
		return this.trdCctRcvUserOffice;
	}
	
	/**
	 * Column Info
	 * @return ppdRcvUserOffice
	 */
	public String getPpdRcvUserOffice() {
		return this.ppdRcvUserOffice;
	}
	
	/**
	 * Column Info
	 * @return cctRcvDt
	 */
	public String getCctRcvDt() {
		return this.cctRcvDt;
	}
	
	/**
	 * Column Info
	 * @return blIssueBy
	 */
	public String getBlIssueBy() {
		return this.blIssueBy;
	}
	
	/**
	 * Column Info
	 * @return docProcType
	 */
	public String getDocProcType() {
		return this.docProcType;
	}
	
	/**
	 * Column Info
	 * @return blReadyDate
	 */
	public String getBlReadyDate() {
		return this.blReadyDate;
	}
	
	/**
	 * Column Info
	 * @return ppdBy
	 */
	public String getPpdBy() {
		return this.ppdBy;
	}
	
	/**
	 * Column Info
	 * @return shprName
	 */
	public String getShprName() {
		return this.shprName;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}
	
	/**
	 * Column Info
	 * @return trdPpdRcvDt
	 */
	public String getTrdPpdRcvDt() {
		return this.trdPpdRcvDt;
	}
	
	/**
	 * Column Info
	 * @return internetAuth
	 */
	public String getInternetAuth() {
		return this.internetAuth;
	}
	
	/**
	 * Column Info
	 * @return trdPpdRcvUserOffice
	 */
	public String getTrdPpdRcvUserOffice() {
		return this.trdPpdRcvUserOffice;
	}
	
	/**
	 * Column Info
	 * @return released
	 */
	public String getReleased() {
		return this.released;
	}
	
	/**
	 * Column Info
	 * @return ppdConfirm
	 */
	public String getPpdConfirm() {
		return this.ppdConfirm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return podName
	 */
	public String getPodName() {
		return this.podName;
	}
	
	/**
	 * Column Info
	 * @return docRequestFlag
	 */
	public String getDocRequestFlag() {
		return this.docRequestFlag;
	}
	
	/**
	 * Column Info
	 * @return polName
	 */
	public String getPolName() {
		return this.polName;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonEml
	 */
	public String getCntcPsonEml() {
		return this.cntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @return porName
	 */
	public String getPorName() {
		return this.porName;
	}
	
	/**
	 * Column Info
	 * @return authFlag
	 */
	public String getAuthFlag() {
		return this.authFlag;
	}
	
	/**
	 * Column Info
	 * @return updOffice
	 */
	public String getUpdOffice() {
		return this.updOffice;
	}
	
	/**
	 * Column Info
	 * @return oBlreceiveBy
	 */
	public String getOBlreceiveBy() {
		return this.oBlreceiveBy;
	}
	
	/**
	 * Column Info
	 * @return cctRcv
	 */
	public String getCctRcv() {
		return this.cctRcv;
	}
	
	/**
	 * Column Info
	 * @return flgDo
	 */
	public String getFlgDo() {
		return this.flgDo;
	}
	
	/**
	 * Column Info
	 * @return flgMd
	 */
	public String getFlgMd() {
		return this.flgMd;
	}
	
	/**
	 * Column Info
	 * @return podCode
	 */
	public String getPodCode() {
		return this.podCode;
	}
	
	/**
	 * Column Info
	 * @return flgPpd
	 */
	public String getFlgPpd() {
		return this.flgPpd;
	}
	
	/**
	 * Column Info
	 * @return trdFlgPpd
	 */
	public String getTrdFlgPpd() {
		return this.trdFlgPpd;
	}
	
	/**
	 * Column Info
	 * @return trdPpdBy
	 */
	public String getTrdPpdBy() {
		return this.trdPpdBy;
	}
	
	/**
	 * Column Info
	 * @return ppdRcv
	 */
	public String getPpdRcv() {
		return this.ppdRcv;
	}
	
	/**
	 * Column Info
	 * @return oblIssFlg
	 */
	public String getOblIssFlg() {
		return this.oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @return blHldFlg
	 */
	public String getBlHldFlg(){
		return this.blHldFlg;
	}
	
	/**
	 * Column Info
	 * @return blHldRsnCd
	 */
	public String getBlHldRsnCd(){
		return this.blHldRsnCd;
	}
	
	/**
	 * Column Info
	 * @return blHldDt
	 */
	public String getBlHldDt(){
		return this.blHldDt;
	}
	
	/**
	 * Column Info
	 * @return blHldUsrId
	 */
	public String getBlHldUsrId(){
		return this.blHldUsrId;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd(){
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd(){
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @param vesselDirection
	 */
	public void setVesselDirection(String vesselDirection) {
		this.vesselDirection = vesselDirection;
	}
	
	/**
	 * Column Info
	 * @param blProofbyshipperDate
	 */
	public void setBlProofbyshipperDate(String blProofbyshipperDate) {
		this.blProofbyshipperDate = blProofbyshipperDate;
	}
	
	/**
	 * Column Info
	 * @param oblPrnFlg
	 */
	public void setOblPrnFlg(String oblPrnFlg) {
		this.oblPrnFlg = oblPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param blackCustomerFlag
	 */
	public void setBlackCustomerFlag(String blackCustomerFlag) {
		this.blackCustomerFlag = blackCustomerFlag;
	}
	
	/**
	 * Column Info
	 * @param trdPpdOffice
	 */
	public void setTrdPpdOffice(String trdPpdOffice) {
		this.trdPpdOffice = trdPpdOffice;
	}
	
	/**
	 * Column Info
	 * @param trdCctBy
	 */
	public void setTrdCctBy(String trdCctBy) {
		this.trdCctBy = trdCctBy;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param docProcSeq
	 */
	public void setDocProcSeq(String docProcSeq) {
		this.docProcSeq = docProcSeq;
	}
	
	/**
	 * Column Info
	 * @param issuedEnable
	 */
	public void setIssuedEnable(String issuedEnable) {
		this.issuedEnable = issuedEnable;
	}
	
	/**
	 * Column Info
	 * @param tpbIndicator
	 */
	public void setTpbIndicator(String tpbIndicator) {
		this.tpbIndicator = tpbIndicator;
	}
	
	/**
	 * Column Info
	 * @param cctConfirm
	 */
	public void setCctConfirm(String cctConfirm) {
		this.cctConfirm = cctConfirm;
	}
	
	/**
	 * Column Info
	 * @param oblIssRmk
	 */
	public void setOblIssRmk(String oblIssRmk) {
		this.oblIssRmk = oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @param wblEml
	 */
	public void setWblEml(String wblEml) {
		this.wblEml = wblEml;
	}
	
	/**
	 * Column Info
	 * @param wblRtTpCd
	 */
	public void setWblRtTpCd(String wblRtTpCd) {
		this.wblRtTpCd = wblRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param fFwdAddress
	 */
	public void setFFwdAddress(String fFwdAddress) {
		this.fFwdAddress = fFwdAddress;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param trdCctRcvDt
	 */
	public void setTrdCctRcvDt(String trdCctRcvDt) {
		this.trdCctRcvDt = trdCctRcvDt;
	}
	
	/**
	 * Column Info
	 * @param trdCctConfirm
	 */
	public void setTrdCctConfirm(String trdCctConfirm) {
		this.trdCctConfirm = trdCctConfirm;
	}
	
	/**
	 * Column Info
	 * @param doIssueAt
	 */
	public void setDoIssueAt(String doIssueAt) {
		this.doIssueAt = doIssueAt;
	}
	
	/**
	 * Column Info
	 * @param finalDest
	 */
	public void setFinalDest(String finalDest) {
		this.finalDest = finalDest;
	}
	
	/**
	 * Column Info
	 * @param oBlreceiveType
	 */
	public void setOBlreceiveType(String oBlreceiveType) {
		this.oBlreceiveType = oBlreceiveType;
	}
	
	/**
	 * Column Info
	 * @param blReadyOffice
	 */
	public void setBlReadyOffice(String blReadyOffice) {
		this.blReadyOffice = blReadyOffice;
	}
	
	/**
	 * Column Info
	 * @param doIssueBy
	 */
	public void setDoIssueBy(String doIssueBy) {
		this.doIssueBy = doIssueBy;
	}
	
	/**
	 * Column Info
	 * @param cctDate
	 */
	public void setCctDate(String cctDate) {
		this.cctDate = cctDate;
	}
	
	/**
	 * Column Info
	 * @param trdCctRcv
	 */
	public void setTrdCctRcv(String trdCctRcv) {
		this.trdCctRcv = trdCctRcv;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param tpbStatus
	 */
	public void setTpbStatus(String tpbStatus) {
		this.tpbStatus = tpbStatus;
	}
	
	/**
	 * Column Info
	 * @param trdCctRcvUserId
	 */
	public void setTrdCctRcvUserId(String trdCctRcvUserId) {
		this.trdCctRcvUserId = trdCctRcvUserId;
	}
	
	/**
	 * Column Info
	 * @param oBlreceiveAt
	 */
	public void setOBlreceiveAt(String oBlreceiveAt) {
		this.oBlreceiveAt = oBlreceiveAt;
	}
	
	/**
	 * Column Info
	 * @param cctRcvUserOffice
	 */
	public void setCctRcvUserOffice(String cctRcvUserOffice) {
		this.cctRcvUserOffice = cctRcvUserOffice;
	}
	
	/**
	 * Column Info
	 * @param delName
	 */
	public void setDelName(String delName) {
		this.delName = delName;
	}
	
	/**
	 * Column Info
	 * @param preCarriageBy
	 */
	public void setPreCarriageBy(String preCarriageBy) {
		this.preCarriageBy = preCarriageBy;
	}
	
	/**
	 * Column Info
	 * @param blReadyBy
	 */
	public void setBlReadyBy(String blReadyBy) {
		this.blReadyBy = blReadyBy;
	}
	
	/**
	 * Column Info
	 * @param ppdOffice
	 */
	public void setPpdOffice(String ppdOffice) {
		this.ppdOffice = ppdOffice;
	}
	
	/**
	 * Column Info
	 * @param bkgSts
	 */
	public void setBkgSts(String bkgSts) {
		this.bkgSts = bkgSts;
	}
	
	/**
	 * Column Info
	 * @param cctBy
	 */
	public void setCctBy(String cctBy) {
		this.cctBy = cctBy;
	}
	
	/**
	 * Column Info
	 * @param trdPpdDate
	 */
	public void setTrdPpdDate(String trdPpdDate) {
		this.trdPpdDate = trdPpdDate;
	}
	
	/**
	 * Column Info
	 * @param fFwdName
	 */
	public void setFFwdName(String fFwdName) {
		this.fFwdName = fFwdName;
	}
	
	/**
	 * Column Info
	 * @param trdPpdRcvUserId
	 */
	public void setTrdPpdRcvUserId(String trdPpdRcvUserId) {
		this.trdPpdRcvUserId = trdPpdRcvUserId;
	}
	
	/**
	 * Column Info
	 * @param polCode
	 */
	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}
	
	/**
	 * Column Info
	 * @param doIssueNo
	 */
	public void setDoIssueNo(String doIssueNo) {
		this.doIssueNo = doIssueNo;
	}
	
	/**
	 * Column Info
	 * @param blProofbyshipperBy
	 */
	public void setBlProofbyshipperBy(String blProofbyshipperBy) {
		this.blProofbyshipperBy = blProofbyshipperBy;
	}
	
	/**
	 * Column Info
	 * @param bdr
	 */
	public void setBdr(String bdr) {
		this.bdr = bdr;
	}
	
	/**
	 * Column Info
	 * @param trdPpdRcv
	 */
	public void setTrdPpdRcv(String trdPpdRcv) {
		this.trdPpdRcv = trdPpdRcv;
	}
	
	/**
	 * Column Info
	 * @param flgRate
	 */
	public void setFlgRate(String flgRate) {
		this.flgRate = flgRate;
	}
	
	/**
	 * Column Info
	 * @param onBoardType
	 */
	public void setOnBoardType(String onBoardType) {
		this.onBoardType = onBoardType;
	}
	
	/**
	 * Column Info
	 * @param ppdRcvDt
	 */
	public void setPpdRcvDt(String ppdRcvDt) {
		this.ppdRcvDt = ppdRcvDt;
	}
	
	/**
	 * Column Info
	 * @param doIssueDate
	 */
	public void setDoIssueDate(String doIssueDate) {
		this.doIssueDate = doIssueDate;
	}
	
	/**
	 * Column Info
	 * @param blProofbyshipperOffice
	 */
	public void setBlProofbyshipperOffice(String blProofbyshipperOffice) {
		this.blProofbyshipperOffice = blProofbyshipperOffice;
	}
	
	/**
	 * Column Info
	 * @param docProcModyflg
	 */
	public void setDocProcModyflg(String docProcModyflg) {
		this.docProcModyflg = docProcModyflg;
	}
	
	/**
	 * Column Info
	 * @param flgToOrder
	 */
	public void setFlgToOrder(String flgToOrder) {
		this.flgToOrder = flgToOrder;
	}
	
	/**
	 * Column Info
	 * @param imgFlg
	 */
	public void setImgFlg(String imgFlg) {
		this.imgFlg = imgFlg;
	}
	
	/**
	 * Column Info
	 * @param blIssueDate
	 */
	public void setBlIssueDate(String blIssueDate) {
		this.blIssueDate = blIssueDate;
	}
	
	/**
	 * Column Info
	 * @param oBlreceiveNo
	 */
	public void setOBlreceiveNo(String oBlreceiveNo) {
		this.oBlreceiveNo = oBlreceiveNo;
	}
	
	/**
	 * Column Info
	 * @param porCode
	 */
	public void setPorCode(String porCode) {
		this.porCode = porCode;
	}
	
	/**
	 * Column Info
	 * @param blReadyType
	 */
	public void setBlReadyType(String blReadyType) {
		this.blReadyType = blReadyType;
	}
	
	/**
	 * Column Info
	 * @param ppdDate
	 */
	public void setPpdDate(String ppdDate) {
		this.ppdDate = ppdDate;
	}
	
	/**
	 * Column Info
	 * @param trdCctOffice
	 */
	public void setTrdCctOffice(String trdCctOffice) {
		this.trdCctOffice = trdCctOffice;
	}
	
	/**
	 * Column Info
	 * @param blIssueNo
	 */
	public void setBlIssueNo(String blIssueNo) {
		this.blIssueNo = blIssueNo;
	}
	
	/**
	 * Column Info
	 * @param moveType
	 */
	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}
	
	/**
	 * Column Info
	 * @param oBlreceiveDate
	 */
	public void setOBlreceiveDate(String oBlreceiveDate) {
		this.oBlreceiveDate = oBlreceiveDate;
	}
	
	/**
	 * Column Info
	 * @param buttontype
	 */
	public void setButtontype(String buttontype) {
		this.buttontype = buttontype;
	}
	
	/**
	 * Column Info
	 * @param blIssueblType
	 */
	public void setBlIssueblType(String blIssueblType) {
		this.blIssueblType = blIssueblType;
	}
	
	/**
	 * Column Info
	 * @param trdPpdConfirm
	 */
	public void setTrdPpdConfirm(String trdPpdConfirm) {
		this.trdPpdConfirm = trdPpdConfirm;
	}
	
	/**
	 * Column Info
	 * @param shprAddress
	 */
	public void setShprAddress(String shprAddress) {
		this.shprAddress = shprAddress;
	}
	
	/**
	 * Column Info
	 * @param surrender
	 */
	public void setSurrender(String surrender) {
		this.surrender = surrender;
	}
	
	/**
	 * Column Info
	 * @param trdCctDate
	 */
	public void setTrdCctDate(String trdCctDate) {
		this.trdCctDate = trdCctDate;
	}
	
	/**
	 * Column Info
	 * @param blIssueAt
	 */
	public void setBlIssueAt(String blIssueAt) {
		this.blIssueAt = blIssueAt;
	}
	
	/**
	 * Column Info
	 * @param polEtdDt
	 */
	public void setPolEtdDt(String polEtdDt) {
		this.polEtdDt = polEtdDt;
	}
	
	/**
	 * Column Info
	 * @param polEtdDt
	 */
	public void setCgoRcvDt(String cgoRcvDt) {
		this.cgoRcvDt = cgoRcvDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cctRcvUserId
	 */
	public void setCctRcvUserId(String cctRcvUserId) {
		this.cctRcvUserId = cctRcvUserId;
	}
	
	/**
	 * Column Info
	 * @param ppdRcvUserId
	 */
	public void setPpdRcvUserId(String ppdRcvUserId) {
		this.ppdRcvUserId = ppdRcvUserId;
	}
	
	/**
	 * Column Info
	 * @param cctOffice
	 */
	public void setCctOffice(String cctOffice) {
		this.cctOffice = cctOffice;
	}
	
	/**
	 * Column Info
	 * @param blIssueRelease
	 */
	public void setBlIssueRelease(String blIssueRelease) {
		this.blIssueRelease = blIssueRelease;
	}
	
	/**
	 * Column Info
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param blProofbyshipperCheckbox
	 */
	public void setBlProofbyshipperCheckbox(String blProofbyshipperCheckbox) {
		this.blProofbyshipperCheckbox = blProofbyshipperCheckbox;
	}
	
	/**
	 * Column Info
	 * @param onBoardDate
	 */
	public void setOnBoardDate(String onBoardDate) {
		this.onBoardDate = onBoardDate;
	}
	
	/**
	 * Column Info
	 * @param printOption
	 */
	public void setPrintOption(String printOption) {
		this.printOption = printOption;
	}
	
	/**
	 * Column Info
	 * @param blReadyCheckbox
	 */
	public void setBlReadyCheckbox(String blReadyCheckbox) {
		this.blReadyCheckbox = blReadyCheckbox;
	}
	
	/**
	 * Column Info
	 * @param issued
	 */
	public void setIssued(String issued) {
		this.issued = issued;
	}
	
	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param delCode
	 */
	public void setDelCode(String delCode) {
		this.delCode = delCode;
	}
	
	/**
	 * Column Info
	 * @param trdCctRcvUserOffice
	 */
	public void setTrdCctRcvUserOffice(String trdCctRcvUserOffice) {
		this.trdCctRcvUserOffice = trdCctRcvUserOffice;
	}
	
	/**
	 * Column Info
	 * @param ppdRcvUserOffice
	 */
	public void setPpdRcvUserOffice(String ppdRcvUserOffice) {
		this.ppdRcvUserOffice = ppdRcvUserOffice;
	}
	
	/**
	 * Column Info
	 * @param cctRcvDt
	 */
	public void setCctRcvDt(String cctRcvDt) {
		this.cctRcvDt = cctRcvDt;
	}
	
	/**
	 * Column Info
	 * @param blIssueBy
	 */
	public void setBlIssueBy(String blIssueBy) {
		this.blIssueBy = blIssueBy;
	}
	
	/**
	 * Column Info
	 * @param docProcType
	 */
	public void setDocProcType(String docProcType) {
		this.docProcType = docProcType;
	}
	
	/**
	 * Column Info
	 * @param blReadyDate
	 */
	public void setBlReadyDate(String blReadyDate) {
		this.blReadyDate = blReadyDate;
	}
	
	/**
	 * Column Info
	 * @param ppdBy
	 */
	public void setPpdBy(String ppdBy) {
		this.ppdBy = ppdBy;
	}
	
	/**
	 * Column Info
	 * @param shprName
	 */
	public void setShprName(String shprName) {
		this.shprName = shprName;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}
	
	/**
	 * Column Info
	 * @param trdPpdRcvDt
	 */
	public void setTrdPpdRcvDt(String trdPpdRcvDt) {
		this.trdPpdRcvDt = trdPpdRcvDt;
	}
	
	/**
	 * Column Info
	 * @param internetAuth
	 */
	public void setInternetAuth(String internetAuth) {
		this.internetAuth = internetAuth;
	}
	
	/**
	 * Column Info
	 * @param trdPpdRcvUserOffice
	 */
	public void setTrdPpdRcvUserOffice(String trdPpdRcvUserOffice) {
		this.trdPpdRcvUserOffice = trdPpdRcvUserOffice;
	}
	
	/**
	 * Column Info
	 * @param released
	 */
	public void setReleased(String released) {
		this.released = released;
	}
	
	/**
	 * Column Info
	 * @param ppdConfirm
	 */
	public void setPpdConfirm(String ppdConfirm) {
		this.ppdConfirm = ppdConfirm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param podName
	 */
	public void setPodName(String podName) {
		this.podName = podName;
	}
	
	/**
	 * Column Info
	 * @param docRequestFlag
	 */
	public void setDocRequestFlag(String docRequestFlag) {
		this.docRequestFlag = docRequestFlag;
	}
	
	/**
	 * Column Info
	 * @param polName
	 */
	public void setPolName(String polName) {
		this.polName = polName;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonEml
	 */
	public void setCntcPsonEml(String cntcPsonEml) {
		this.cntcPsonEml = cntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @param porName
	 */
	public void setPorName(String porName) {
		this.porName = porName;
	}
	
	/**
	 * Column Info
	 * @param authFlag
	 */
	public void setAuthFlag(String authFlag) {
		this.authFlag = authFlag;
	}
	
	/**
	 * Column Info
	 * @param updOffice
	 */
	public void setUpdOffice(String updOffice) {
		this.updOffice = updOffice;
	}
	
	/**
	 * Column Info
	 * @param oBlreceiveBy
	 */
	public void setOBlreceiveBy(String oBlreceiveBy) {
		this.oBlreceiveBy = oBlreceiveBy;
	}
	
	/**
	 * Column Info
	 * @param cctRcv
	 */
	public void setCctRcv(String cctRcv) {
		this.cctRcv = cctRcv;
	}
	
	/**
	 * Column Info
	 * @param flgDo
	 */
	public void setFlgDo(String flgDo) {
		this.flgDo = flgDo;
	}
	
	/**
	 * Column Info
	 * @param flgMd
	 */
	public void setFlgMd(String flgMd) {
		this.flgMd = flgMd;
	}
	
	/**
	 * Column Info
	 * @param podCode
	 */
	public void setPodCode(String podCode) {
		this.podCode = podCode;
	}
	
	/**
	 * Column Info
	 * @param flgPpd
	 */
	public void setFlgPpd(String flgPpd) {
		this.flgPpd = flgPpd;
	}
	
	/**
	 * Column Info
	 * @param trdFlgPpd
	 */
	public void setTrdFlgPpd(String trdFlgPpd) {
		this.trdFlgPpd = trdFlgPpd;
	}
	
	/**
	 * Column Info
	 * @param trdPpdBy
	 */
	public void setTrdPpdBy(String trdPpdBy) {
		this.trdPpdBy = trdPpdBy;
	}
	
	/**
	 * Column Info
	 * @param ppdRcv
	 */
	public void setPpdRcv(String ppdRcv) {
		this.ppdRcv = ppdRcv;
	}
	
	/**
	 * Column Info
	 * @param oblIssFlg
	 */
	public void setOblIssFlg(String oblIssFlg) {
		this.oblIssFlg = oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @param blHldFlg
	 */
	public void setBlHldFlg(String blHldFlg){
		this.blHldFlg = blHldFlg;
	}
	
	/**
	 * Column Info
	 * @param blHldRsnCd
	 */
	public void setBlHldRsnCd(String blHldRsnCd){
		this.blHldRsnCd = blHldRsnCd;
	}
	
	/**
	 * Column Info
	 * @param blHldDt
	 */
	public void setBlHldDt(String blHldDt){
		this.blHldDt = blHldDt;
	}
	
	/**
	 * Column Info
	 * @param blHldUsrId
	 */
	public void setBlHldUsrId(String blHldUsrId){
		this.blHldUsrId = blHldUsrId;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd){
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd){
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVesselDirection(JSPUtil.getParameter(request, "vessel_direction", ""));
		setBlProofbyshipperDate(JSPUtil.getParameter(request, "bl_proofbyshipper_date", ""));
		setOblPrnFlg(JSPUtil.getParameter(request, "obl_prn_flg", ""));
		setBlackCustomerFlag(JSPUtil.getParameter(request, "black_customer_flag", ""));
		setTrdPpdOffice(JSPUtil.getParameter(request, "trd_ppd_office", ""));
		setTrdCctBy(JSPUtil.getParameter(request, "trd_cct_by", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDocProcSeq(JSPUtil.getParameter(request, "doc_proc_seq", ""));
		setIssuedEnable(JSPUtil.getParameter(request, "issued_enable", ""));
		setTpbIndicator(JSPUtil.getParameter(request, "tpb_indicator", ""));
		setCctConfirm(JSPUtil.getParameter(request, "cct_confirm", ""));
		setOblIssRmk(JSPUtil.getParameter(request, "obl_iss_rmk", ""));
		setFFwdAddress(JSPUtil.getParameter(request, "f_fwd_address", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTrdCctRcvDt(JSPUtil.getParameter(request, "trd_cct_rcv_dt", ""));
		setTrdCctConfirm(JSPUtil.getParameter(request, "trd_cct_confirm", ""));
		setDoIssueAt(JSPUtil.getParameter(request, "do_issue_at", ""));
		setFinalDest(JSPUtil.getParameter(request, "final_dest", ""));
		setOBlreceiveType(JSPUtil.getParameter(request, "o_blreceive_type", ""));
		setBlReadyOffice(JSPUtil.getParameter(request, "bl_ready_office", ""));
		setDoIssueBy(JSPUtil.getParameter(request, "do_issue_by", ""));
		setCctDate(JSPUtil.getParameter(request, "cct_date", ""));
		setTrdCctRcv(JSPUtil.getParameter(request, "trd_cct_rcv", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTpbStatus(JSPUtil.getParameter(request, "tpb_status", ""));
		setTrdCctRcvUserId(JSPUtil.getParameter(request, "trd_cct_rcv_user_id", ""));
		setOBlreceiveAt(JSPUtil.getParameter(request, "o_blreceive_at", ""));
		setCctRcvUserOffice(JSPUtil.getParameter(request, "cct_rcv_user_office", ""));
		setDelName(JSPUtil.getParameter(request, "del_name", ""));
		setPreCarriageBy(JSPUtil.getParameter(request, "pre_carriage_by", ""));
		setBlReadyBy(JSPUtil.getParameter(request, "bl_ready_by", ""));
		setPpdOffice(JSPUtil.getParameter(request, "ppd_office", ""));
		setBkgSts(JSPUtil.getParameter(request, "bkg_sts", ""));
		setCctBy(JSPUtil.getParameter(request, "cct_by", ""));
		setTrdPpdDate(JSPUtil.getParameter(request, "trd_ppd_date", ""));
		setFFwdName(JSPUtil.getParameter(request, "f_fwd_name", ""));
		setTrdPpdRcvUserId(JSPUtil.getParameter(request, "trd_ppd_rcv_user_id", ""));
		setPolCode(JSPUtil.getParameter(request, "pol_code", ""));
		setDoIssueNo(JSPUtil.getParameter(request, "do_issue_no", ""));
		setBlProofbyshipperBy(JSPUtil.getParameter(request, "bl_proofbyshipper_by", ""));
		setBdr(JSPUtil.getParameter(request, "bdr", ""));
		setTrdPpdRcv(JSPUtil.getParameter(request, "trd_ppd_rcv", ""));
		setFlgRate(JSPUtil.getParameter(request, "flg_rate", ""));
		setOnBoardType(JSPUtil.getParameter(request, "on_board_type", ""));
		setPpdRcvDt(JSPUtil.getParameter(request, "ppd_rcv_dt", ""));
		setDoIssueDate(JSPUtil.getParameter(request, "do_issue_date", ""));
		setBlProofbyshipperOffice(JSPUtil.getParameter(request, "bl_proofbyshipper_office", ""));
		setDocProcModyflg(JSPUtil.getParameter(request, "doc_proc_modyflg", ""));
		setFlgToOrder(JSPUtil.getParameter(request, "flg_to_order", ""));
		setBlIssueDate(JSPUtil.getParameter(request, "bl_issue_date", ""));
		setOBlreceiveNo(JSPUtil.getParameter(request, "o_blreceive_no", ""));
		setPorCode(JSPUtil.getParameter(request, "por_code", ""));
		setBlReadyType(JSPUtil.getParameter(request, "bl_ready_type", ""));
		setPpdDate(JSPUtil.getParameter(request, "ppd_date", ""));
		setTrdCctOffice(JSPUtil.getParameter(request, "trd_cct_office", ""));
		setBlIssueNo(JSPUtil.getParameter(request, "bl_issue_no", ""));
		setMoveType(JSPUtil.getParameter(request, "move_type", ""));
		setOBlreceiveDate(JSPUtil.getParameter(request, "o_blreceive_date", ""));
		setButtontype(JSPUtil.getParameter(request, "buttontype", ""));
		setBlIssueblType(JSPUtil.getParameter(request, "bl_issuebl_type", ""));
		setTrdPpdConfirm(JSPUtil.getParameter(request, "trd_ppd_confirm", ""));
		setShprAddress(JSPUtil.getParameter(request, "shpr_address", ""));
		setSurrender(JSPUtil.getParameter(request, "surrender", ""));
		setTrdCctDate(JSPUtil.getParameter(request, "trd_cct_date", ""));
		setBlIssueAt(JSPUtil.getParameter(request, "bl_issue_at", ""));
		setPolEtdDt(JSPUtil.getParameter(request, "pol_etd_dt", ""));
		setCgoRcvDt(JSPUtil.getParameter(request, "cgo_rcv_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCctRcvUserId(JSPUtil.getParameter(request, "cct_rcv_user_id", ""));
		setPpdRcvUserId(JSPUtil.getParameter(request, "ppd_rcv_user_id", ""));
		setCctOffice(JSPUtil.getParameter(request, "cct_office", ""));
		setBlIssueRelease(JSPUtil.getParameter(request, "bl_issue_release", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, "cust_to_ord_flg", ""));
		setBlProofbyshipperCheckbox(JSPUtil.getParameter(request, "bl_proofbyshipper_checkbox", ""));
		setOnBoardDate(JSPUtil.getParameter(request, "on_board_date", ""));
		setPrintOption(JSPUtil.getParameter(request, "print_option", ""));
		setBlReadyCheckbox(JSPUtil.getParameter(request, "bl_ready_checkbox", ""));
		setIssued(JSPUtil.getParameter(request, "issued", ""));
		setTvvd(JSPUtil.getParameter(request, "tvvd", ""));
		setDelCode(JSPUtil.getParameter(request, "del_code", ""));
		setTrdCctRcvUserOffice(JSPUtil.getParameter(request, "trd_cct_rcv_user_office", ""));
		setPpdRcvUserOffice(JSPUtil.getParameter(request, "ppd_rcv_user_office", ""));
		setCctRcvDt(JSPUtil.getParameter(request, "cct_rcv_dt", ""));
		setBlIssueBy(JSPUtil.getParameter(request, "bl_issue_by", ""));
		setDocProcType(JSPUtil.getParameter(request, "doc_proc_type", ""));
		setBlReadyDate(JSPUtil.getParameter(request, "bl_ready_date", ""));
		setPpdBy(JSPUtil.getParameter(request, "ppd_by", ""));
		setShprName(JSPUtil.getParameter(request, "shpr_name", ""));
		setShprCntCd(JSPUtil.getParameter(request, "shpr_cnt_cd", ""));
		setShprSeq(JSPUtil.getParameter(request, "shpr_seq", ""));
		setTrdPpdRcvDt(JSPUtil.getParameter(request, "trd_ppd_rcv_dt", ""));
		setInternetAuth(JSPUtil.getParameter(request, "internet_auth", ""));
		setTrdPpdRcvUserOffice(JSPUtil.getParameter(request, "trd_ppd_rcv_user_office", ""));
		setReleased(JSPUtil.getParameter(request, "released", ""));
		setPpdConfirm(JSPUtil.getParameter(request, "ppd_confirm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodName(JSPUtil.getParameter(request, "pod_name", ""));
		setDocRequestFlag(JSPUtil.getParameter(request, "doc_request_flag", ""));
		setPolName(JSPUtil.getParameter(request, "pol_name", ""));
		setCntcPsonEml(JSPUtil.getParameter(request, "cntc_pson_eml", ""));
		setPorName(JSPUtil.getParameter(request, "por_name", ""));
		setAuthFlag(JSPUtil.getParameter(request, "auth_flag", ""));
		setUpdOffice(JSPUtil.getParameter(request, "upd_office", ""));
		setOBlreceiveBy(JSPUtil.getParameter(request, "o_blreceive_by", ""));
		setCctRcv(JSPUtil.getParameter(request, "cct_rcv", ""));
		setFlgDo(JSPUtil.getParameter(request, "flg_do", ""));
		setFlgMd(JSPUtil.getParameter(request, "flg_md", ""));
		setPodCode(JSPUtil.getParameter(request, "pod_code", ""));
		setFlgPpd(JSPUtil.getParameter(request, "flg_ppd", ""));
		setTrdFlgPpd(JSPUtil.getParameter(request, "trd_flg_ppd", ""));
		setTrdPpdBy(JSPUtil.getParameter(request, "trd_ppd_by", ""));
		setPpdRcv(JSPUtil.getParameter(request, "ppd_rcv", ""));
		setOblIssFlg(JSPUtil.getParameter(request, "obl_iss_flg", ""));
		setBlHldFlg(JSPUtil.getParameter(request, "bl_hld_flg", ""));
		setBlHldRsnCd(JSPUtil.getParameter(request, "bl_hld_rsn_cd", ""));
		setBlHldDt(JSPUtil.getParameter(request, "bl_hld_dt", ""));
		setBlHldUsrId(JSPUtil.getParameter(request, "bl_hld_usr_id", ""));
		setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setWblEml(JSPUtil.getParameter(request, "wbl_eml", ""));
		setWblRtTpCd(JSPUtil.getParameter(request, "wbl_rt_tp_cd", ""));
		setImgFlg(JSPUtil.getParameter(request, "img_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlIssInfoVO[]
	 */
	public BlIssInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlIssInfoVO[]
	 */
	public BlIssInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlIssInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vesselDirection = (JSPUtil.getParameter(request, prefix	+ "vessel_direction", length));
			String[] blProofbyshipperDate = (JSPUtil.getParameter(request, prefix	+ "bl_proofbyshipper_date", length));
			String[] oblPrnFlg = (JSPUtil.getParameter(request, prefix	+ "obl_prn_flg", length));
			String[] blackCustomerFlag = (JSPUtil.getParameter(request, prefix	+ "black_customer_flag", length));
			String[] trdPpdOffice = (JSPUtil.getParameter(request, prefix	+ "trd_ppd_office", length));
			String[] trdCctBy = (JSPUtil.getParameter(request, prefix	+ "trd_cct_by", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] docProcSeq = (JSPUtil.getParameter(request, prefix	+ "doc_proc_seq", length));
			String[] issuedEnable = (JSPUtil.getParameter(request, prefix	+ "issued_enable", length));
			String[] tpbIndicator = (JSPUtil.getParameter(request, prefix	+ "tpb_indicator", length));
			String[] cctConfirm = (JSPUtil.getParameter(request, prefix	+ "cct_confirm", length));
			String[] oblIssRmk = (JSPUtil.getParameter(request, prefix	+ "obl_iss_rmk", length));
			String[] fFwdAddress = (JSPUtil.getParameter(request, prefix	+ "f_fwd_address", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] trdCctRcvDt = (JSPUtil.getParameter(request, prefix	+ "trd_cct_rcv_dt", length));
			String[] trdCctConfirm = (JSPUtil.getParameter(request, prefix	+ "trd_cct_confirm", length));
			String[] doIssueAt = (JSPUtil.getParameter(request, prefix	+ "do_issue_at", length));
			String[] finalDest = (JSPUtil.getParameter(request, prefix	+ "final_dest", length));
			String[] oBlreceiveType = (JSPUtil.getParameter(request, prefix	+ "o_blreceive_type", length));
			String[] blReadyOffice = (JSPUtil.getParameter(request, prefix	+ "bl_ready_office", length));
			String[] doIssueBy = (JSPUtil.getParameter(request, prefix	+ "do_issue_by", length));
			String[] cctDate = (JSPUtil.getParameter(request, prefix	+ "cct_date", length));
			String[] trdCctRcv = (JSPUtil.getParameter(request, prefix	+ "trd_cct_rcv", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tpbStatus = (JSPUtil.getParameter(request, prefix	+ "tpb_status", length));
			String[] trdCctRcvUserId = (JSPUtil.getParameter(request, prefix	+ "trd_cct_rcv_user_id", length));
			String[] oBlreceiveAt = (JSPUtil.getParameter(request, prefix	+ "o_blreceive_at", length));
			String[] cctRcvUserOffice = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_user_office", length));
			String[] delName = (JSPUtil.getParameter(request, prefix	+ "del_name", length));
			String[] preCarriageBy = (JSPUtil.getParameter(request, prefix	+ "pre_carriage_by", length));
			String[] blReadyBy = (JSPUtil.getParameter(request, prefix	+ "bl_ready_by", length));
			String[] ppdOffice = (JSPUtil.getParameter(request, prefix	+ "ppd_office", length));
			String[] bkgSts = (JSPUtil.getParameter(request, prefix	+ "bkg_sts", length));
			String[] cctBy = (JSPUtil.getParameter(request, prefix	+ "cct_by", length));
			String[] trdPpdDate = (JSPUtil.getParameter(request, prefix	+ "trd_ppd_date", length));
			String[] fFwdName = (JSPUtil.getParameter(request, prefix	+ "f_fwd_name", length));
			String[] trdPpdRcvUserId = (JSPUtil.getParameter(request, prefix	+ "trd_ppd_rcv_user_id", length));
			String[] polCode = (JSPUtil.getParameter(request, prefix	+ "pol_code", length));
			String[] doIssueNo = (JSPUtil.getParameter(request, prefix	+ "do_issue_no", length));
			String[] blProofbyshipperBy = (JSPUtil.getParameter(request, prefix	+ "bl_proofbyshipper_by", length));
			String[] bdr = (JSPUtil.getParameter(request, prefix	+ "bdr", length));
			String[] trdPpdRcv = (JSPUtil.getParameter(request, prefix	+ "trd_ppd_rcv", length));
			String[] flgRate = (JSPUtil.getParameter(request, prefix	+ "flg_rate", length));
			String[] onBoardType = (JSPUtil.getParameter(request, prefix	+ "on_board_type", length));
			String[] ppdRcvDt = (JSPUtil.getParameter(request, prefix	+ "ppd_rcv_dt", length));
			String[] doIssueDate = (JSPUtil.getParameter(request, prefix	+ "do_issue_date", length));
			String[] blProofbyshipperOffice = (JSPUtil.getParameter(request, prefix	+ "bl_proofbyshipper_office", length));
			String[] docProcModyflg = (JSPUtil.getParameter(request, prefix	+ "doc_proc_modyflg", length));
			String[] flgToOrder = (JSPUtil.getParameter(request, prefix	+ "flg_to_order", length));
			String[] blIssueDate = (JSPUtil.getParameter(request, prefix	+ "bl_issue_date", length));
			String[] oBlreceiveNo = (JSPUtil.getParameter(request, prefix	+ "o_blreceive_no", length));
			String[] porCode = (JSPUtil.getParameter(request, prefix	+ "por_code", length));
			String[] blReadyType = (JSPUtil.getParameter(request, prefix	+ "bl_ready_type", length));
			String[] ppdDate = (JSPUtil.getParameter(request, prefix	+ "ppd_date", length));
			String[] trdCctOffice = (JSPUtil.getParameter(request, prefix	+ "trd_cct_office", length));
			String[] blIssueNo = (JSPUtil.getParameter(request, prefix	+ "bl_issue_no", length));
			String[] moveType = (JSPUtil.getParameter(request, prefix	+ "move_type", length));
			String[] oBlreceiveDate = (JSPUtil.getParameter(request, prefix	+ "o_blreceive_date", length));
			String[] buttontype = (JSPUtil.getParameter(request, prefix	+ "buttontype", length));
			String[] blIssueblType = (JSPUtil.getParameter(request, prefix	+ "bl_issuebl_type", length));
			String[] trdPpdConfirm = (JSPUtil.getParameter(request, prefix	+ "trd_ppd_confirm", length));
			String[] shprAddress = (JSPUtil.getParameter(request, prefix	+ "shpr_address", length));
			String[] surrender = (JSPUtil.getParameter(request, prefix	+ "surrender", length));
			String[] trdCctDate = (JSPUtil.getParameter(request, prefix	+ "trd_cct_date", length));
			String[] blIssueAt = (JSPUtil.getParameter(request, prefix	+ "bl_issue_at", length));
			String[] polEtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_dt", length));
			String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix	+ "cgo_rcv_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cctRcvUserId = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_user_id", length));
			String[] ppdRcvUserId = (JSPUtil.getParameter(request, prefix	+ "ppd_rcv_user_id", length));
			String[] cctOffice = (JSPUtil.getParameter(request, prefix	+ "cct_office", length));
			String[] blIssueRelease = (JSPUtil.getParameter(request, prefix	+ "bl_issue_release", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] blProofbyshipperCheckbox = (JSPUtil.getParameter(request, prefix	+ "bl_proofbyshipper_checkbox", length));
			String[] onBoardDate = (JSPUtil.getParameter(request, prefix	+ "on_board_date", length));
			String[] printOption = (JSPUtil.getParameter(request, prefix	+ "print_option", length));
			String[] blReadyCheckbox = (JSPUtil.getParameter(request, prefix	+ "bl_ready_checkbox", length));
			String[] issued = (JSPUtil.getParameter(request, prefix	+ "issued", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] delCode = (JSPUtil.getParameter(request, prefix	+ "del_code", length));
			String[] trdCctRcvUserOffice = (JSPUtil.getParameter(request, prefix	+ "trd_cct_rcv_user_office", length));
			String[] ppdRcvUserOffice = (JSPUtil.getParameter(request, prefix	+ "ppd_rcv_user_office", length));
			String[] cctRcvDt = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_dt", length));
			String[] blIssueBy = (JSPUtil.getParameter(request, prefix	+ "bl_issue_by", length));
			String[] docProcType = (JSPUtil.getParameter(request, prefix	+ "doc_proc_type", length));
			String[] blReadyDate = (JSPUtil.getParameter(request, prefix	+ "bl_ready_date", length));
			String[] ppdBy = (JSPUtil.getParameter(request, prefix	+ "ppd_by", length));
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] trdPpdRcvDt = (JSPUtil.getParameter(request, prefix	+ "trd_ppd_rcv_dt", length));
			String[] internetAuth = (JSPUtil.getParameter(request, prefix	+ "internet_auth", length));
			String[] trdPpdRcvUserOffice = (JSPUtil.getParameter(request, prefix	+ "trd_ppd_rcv_user_office", length));
			String[] released = (JSPUtil.getParameter(request, prefix	+ "released", length));
			String[] ppdConfirm = (JSPUtil.getParameter(request, prefix	+ "ppd_confirm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podName = (JSPUtil.getParameter(request, prefix	+ "pod_name", length));
			String[] docRequestFlag = (JSPUtil.getParameter(request, prefix	+ "doc_request_flag", length));
			String[] polName = (JSPUtil.getParameter(request, prefix	+ "pol_name", length));
			String[] cntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_eml", length));
			String[] porName = (JSPUtil.getParameter(request, prefix	+ "por_name", length));
			String[] authFlag = (JSPUtil.getParameter(request, prefix	+ "auth_flag", length));
			String[] updOffice = (JSPUtil.getParameter(request, prefix	+ "upd_office", length));
			String[] oBlreceiveBy = (JSPUtil.getParameter(request, prefix	+ "o_blreceive_by", length));
			String[] cctRcv = (JSPUtil.getParameter(request, prefix	+ "cct_rcv", length));
			String[] flgDo = (JSPUtil.getParameter(request, prefix	+ "flg_do", length));
			String[] flgMd = (JSPUtil.getParameter(request, prefix	+ "flg_md", length));
			String[] podCode = (JSPUtil.getParameter(request, prefix	+ "pod_code", length));
			String[] flgPpd = (JSPUtil.getParameter(request, prefix	+ "flg_ppd", length));
			String[] trdFlgPpd = (JSPUtil.getParameter(request, prefix	+ "trd_flg_ppd", length));
			String[] trdPpdBy = (JSPUtil.getParameter(request, prefix	+ "trd_ppd_by", length));
			String[] ppdRcv = (JSPUtil.getParameter(request, prefix	+ "ppd_rcv", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] blHldFlg = (JSPUtil.getParameter(request, prefix	+ "bl_hld_flg", length));
			String[] blHldRsnCd = (JSPUtil.getParameter(request, prefix	+ "bl_hld_rsn_cd", length));
			String[] blHldDt = (JSPUtil.getParameter(request, prefix	+ "bl_hld_dt", length));
			String[] blHldUsrId = (JSPUtil.getParameter(request, prefix	+ "bl_hld_usr_id", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] wblEml = (JSPUtil.getParameter(request, prefix	+ "wbl_eml", length));
			String[] wblRtTpCd = (JSPUtil.getParameter(request, prefix	+ "wbl_rt_tp_cd", length));
			String[] imgFlg = (JSPUtil.getParameter(request, prefix	+ "img_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlIssInfoVO();
				if (vesselDirection[i] != null)
					model.setVesselDirection(vesselDirection[i]);
				if (blProofbyshipperDate[i] != null)
					model.setBlProofbyshipperDate(blProofbyshipperDate[i]);
				if (oblPrnFlg[i] != null)
					model.setOblPrnFlg(oblPrnFlg[i]);
				if (blackCustomerFlag[i] != null)
					model.setBlackCustomerFlag(blackCustomerFlag[i]);
				if (trdPpdOffice[i] != null)
					model.setTrdPpdOffice(trdPpdOffice[i]);
				if (trdCctBy[i] != null)
					model.setTrdCctBy(trdCctBy[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (docProcSeq[i] != null)
					model.setDocProcSeq(docProcSeq[i]);
				if (issuedEnable[i] != null)
					model.setIssuedEnable(issuedEnable[i]);
				if (tpbIndicator[i] != null)
					model.setTpbIndicator(tpbIndicator[i]);
				if (cctConfirm[i] != null)
					model.setCctConfirm(cctConfirm[i]);
				if (oblIssRmk[i] != null)
					model.setOblIssRmk(oblIssRmk[i]);
				if (fFwdAddress[i] != null)
					model.setFFwdAddress(fFwdAddress[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (trdCctRcvDt[i] != null)
					model.setTrdCctRcvDt(trdCctRcvDt[i]);
				if (trdCctConfirm[i] != null)
					model.setTrdCctConfirm(trdCctConfirm[i]);
				if (doIssueAt[i] != null)
					model.setDoIssueAt(doIssueAt[i]);
				if (finalDest[i] != null)
					model.setFinalDest(finalDest[i]);
				if (oBlreceiveType[i] != null)
					model.setOBlreceiveType(oBlreceiveType[i]);
				if (blReadyOffice[i] != null)
					model.setBlReadyOffice(blReadyOffice[i]);
				if (doIssueBy[i] != null)
					model.setDoIssueBy(doIssueBy[i]);
				if (cctDate[i] != null)
					model.setCctDate(cctDate[i]);
				if (trdCctRcv[i] != null)
					model.setTrdCctRcv(trdCctRcv[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tpbStatus[i] != null)
					model.setTpbStatus(tpbStatus[i]);
				if (trdCctRcvUserId[i] != null)
					model.setTrdCctRcvUserId(trdCctRcvUserId[i]);
				if (oBlreceiveAt[i] != null)
					model.setOBlreceiveAt(oBlreceiveAt[i]);
				if (cctRcvUserOffice[i] != null)
					model.setCctRcvUserOffice(cctRcvUserOffice[i]);
				if (delName[i] != null)
					model.setDelName(delName[i]);
				if (preCarriageBy[i] != null)
					model.setPreCarriageBy(preCarriageBy[i]);
				if (blReadyBy[i] != null)
					model.setBlReadyBy(blReadyBy[i]);
				if (ppdOffice[i] != null)
					model.setPpdOffice(ppdOffice[i]);
				if (bkgSts[i] != null)
					model.setBkgSts(bkgSts[i]);
				if (cctBy[i] != null)
					model.setCctBy(cctBy[i]);
				if (trdPpdDate[i] != null)
					model.setTrdPpdDate(trdPpdDate[i]);
				if (fFwdName[i] != null)
					model.setFFwdName(fFwdName[i]);
				if (trdPpdRcvUserId[i] != null)
					model.setTrdPpdRcvUserId(trdPpdRcvUserId[i]);
				if (polCode[i] != null)
					model.setPolCode(polCode[i]);
				if (doIssueNo[i] != null)
					model.setDoIssueNo(doIssueNo[i]);
				if (blProofbyshipperBy[i] != null)
					model.setBlProofbyshipperBy(blProofbyshipperBy[i]);
				if (bdr[i] != null)
					model.setBdr(bdr[i]);
				if (trdPpdRcv[i] != null)
					model.setTrdPpdRcv(trdPpdRcv[i]);
				if (flgRate[i] != null)
					model.setFlgRate(flgRate[i]);
				if (onBoardType[i] != null)
					model.setOnBoardType(onBoardType[i]);
				if (ppdRcvDt[i] != null)
					model.setPpdRcvDt(ppdRcvDt[i]);
				if (doIssueDate[i] != null)
					model.setDoIssueDate(doIssueDate[i]);
				if (blProofbyshipperOffice[i] != null)
					model.setBlProofbyshipperOffice(blProofbyshipperOffice[i]);
				if (docProcModyflg[i] != null)
					model.setDocProcModyflg(docProcModyflg[i]);
				if (flgToOrder[i] != null)
					model.setFlgToOrder(flgToOrder[i]);
				if (blIssueDate[i] != null)
					model.setBlIssueDate(blIssueDate[i]);
				if (oBlreceiveNo[i] != null)
					model.setOBlreceiveNo(oBlreceiveNo[i]);
				if (porCode[i] != null)
					model.setPorCode(porCode[i]);
				if (blReadyType[i] != null)
					model.setBlReadyType(blReadyType[i]);
				if (ppdDate[i] != null)
					model.setPpdDate(ppdDate[i]);
				if (trdCctOffice[i] != null)
					model.setTrdCctOffice(trdCctOffice[i]);
				if (blIssueNo[i] != null)
					model.setBlIssueNo(blIssueNo[i]);
				if (moveType[i] != null)
					model.setMoveType(moveType[i]);
				if (oBlreceiveDate[i] != null)
					model.setOBlreceiveDate(oBlreceiveDate[i]);
				if (buttontype[i] != null)
					model.setButtontype(buttontype[i]);
				if (blIssueblType[i] != null)
					model.setBlIssueblType(blIssueblType[i]);
				if (trdPpdConfirm[i] != null)
					model.setTrdPpdConfirm(trdPpdConfirm[i]);
				if (shprAddress[i] != null)
					model.setShprAddress(shprAddress[i]);
				if (surrender[i] != null)
					model.setSurrender(surrender[i]);
				if (trdCctDate[i] != null)
					model.setTrdCctDate(trdCctDate[i]);
				if (blIssueAt[i] != null)
					model.setBlIssueAt(blIssueAt[i]);
				if (polEtdDt[i] != null)
					model.setPolEtdDt(polEtdDt[i]);
				if (cgoRcvDt[i] != null)
					model.setCgoRcvDt(cgoRcvDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cctRcvUserId[i] != null)
					model.setCctRcvUserId(cctRcvUserId[i]);
				if (ppdRcvUserId[i] != null)
					model.setPpdRcvUserId(ppdRcvUserId[i]);
				if (cctOffice[i] != null)
					model.setCctOffice(cctOffice[i]);
				if (blIssueRelease[i] != null)
					model.setBlIssueRelease(blIssueRelease[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (blProofbyshipperCheckbox[i] != null)
					model.setBlProofbyshipperCheckbox(blProofbyshipperCheckbox[i]);
				if (onBoardDate[i] != null)
					model.setOnBoardDate(onBoardDate[i]);
				if (printOption[i] != null)
					model.setPrintOption(printOption[i]);
				if (blReadyCheckbox[i] != null)
					model.setBlReadyCheckbox(blReadyCheckbox[i]);
				if (issued[i] != null)
					model.setIssued(issued[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (delCode[i] != null)
					model.setDelCode(delCode[i]);
				if (trdCctRcvUserOffice[i] != null)
					model.setTrdCctRcvUserOffice(trdCctRcvUserOffice[i]);
				if (ppdRcvUserOffice[i] != null)
					model.setPpdRcvUserOffice(ppdRcvUserOffice[i]);
				if (cctRcvDt[i] != null)
					model.setCctRcvDt(cctRcvDt[i]);
				if (blIssueBy[i] != null)
					model.setBlIssueBy(blIssueBy[i]);
				if (docProcType[i] != null)
					model.setDocProcType(docProcType[i]);
				if (blReadyDate[i] != null)
					model.setBlReadyDate(blReadyDate[i]);
				if (ppdBy[i] != null)
					model.setPpdBy(ppdBy[i]);
				if (shprName[i] != null)
					model.setShprName(shprName[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (trdPpdRcvDt[i] != null)
					model.setTrdPpdRcvDt(trdPpdRcvDt[i]);
				if (internetAuth[i] != null)
					model.setInternetAuth(internetAuth[i]);
				if (trdPpdRcvUserOffice[i] != null)
					model.setTrdPpdRcvUserOffice(trdPpdRcvUserOffice[i]);
				if (released[i] != null)
					model.setReleased(released[i]);
				if (ppdConfirm[i] != null)
					model.setPpdConfirm(ppdConfirm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podName[i] != null)
					model.setPodName(podName[i]);
				if (docRequestFlag[i] != null)
					model.setDocRequestFlag(docRequestFlag[i]);
				if (polName[i] != null)
					model.setPolName(polName[i]);
				if (cntcPsonEml[i] != null)
					model.setCntcPsonEml(cntcPsonEml[i]);
				if (porName[i] != null)
					model.setPorName(porName[i]);
				if (authFlag[i] != null)
					model.setAuthFlag(authFlag[i]);
				if (updOffice[i] != null)
					model.setUpdOffice(updOffice[i]);
				if (oBlreceiveBy[i] != null)
					model.setOBlreceiveBy(oBlreceiveBy[i]);
				if (cctRcv[i] != null)
					model.setCctRcv(cctRcv[i]);
				if (flgDo[i] != null)
					model.setFlgDo(flgDo[i]);
				if (flgMd[i] != null)
					model.setFlgMd(flgMd[i]);
				if (podCode[i] != null)
					model.setPodCode(podCode[i]);
				if (flgPpd[i] != null)
					model.setFlgPpd(flgPpd[i]);
				if (trdFlgPpd[i] != null)
					model.setTrdFlgPpd(trdFlgPpd[i]);
				if (trdPpdBy[i] != null)
					model.setTrdPpdBy(trdPpdBy[i]);
				if (ppdRcv[i] != null)
					model.setPpdRcv(ppdRcv[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (blHldFlg[i] != null)
					model.setBlHldFlg(blHldFlg[i]);
				if (blHldRsnCd[i] != null)
					model.setBlHldRsnCd(blHldRsnCd[i]);
				if (blHldDt[i] != null)
					model.setBlHldDt(blHldDt[i]);
				if (blHldUsrId[i] != null)
					model.setBlHldUsrId(blHldUsrId[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (wblEml[i] != null)
					model.setWblEml(wblEml[i]);
				if (wblRtTpCd[i] != null)
					model.setWblRtTpCd(wblRtTpCd[i]);
				if (imgFlg[i] != null)
					model.setImgFlg(imgFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlIssInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlIssInfoVO[]
	 */
	public BlIssInfoVO[] getBlIssInfoVOs(){
		BlIssInfoVO[] vos = (BlIssInfoVO[])models.toArray(new BlIssInfoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vesselDirection = this.vesselDirection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blProofbyshipperDate = this.blProofbyshipperDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblPrnFlg = this.oblPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blackCustomerFlag = this.blackCustomerFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPpdOffice = this.trdPpdOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCctBy = this.trdCctBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docProcSeq = this.docProcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issuedEnable = this.issuedEnable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbIndicator = this.tpbIndicator .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctConfirm = this.cctConfirm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssRmk = this.oblIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFwdAddress = this.fFwdAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCctRcvDt = this.trdCctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCctConfirm = this.trdCctConfirm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIssueAt = this.doIssueAt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalDest = this.finalDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oBlreceiveType = this.oBlreceiveType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blReadyOffice = this.blReadyOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIssueBy = this.doIssueBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctDate = this.cctDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCctRcv = this.trdCctRcv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbStatus = this.tpbStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCctRcvUserId = this.trdCctRcvUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oBlreceiveAt = this.oBlreceiveAt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvUserOffice = this.cctRcvUserOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delName = this.delName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCarriageBy = this.preCarriageBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blReadyBy = this.blReadyBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOffice = this.ppdOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSts = this.bkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctBy = this.cctBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPpdDate = this.trdPpdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFwdName = this.fFwdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPpdRcvUserId = this.trdPpdRcvUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCode = this.polCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIssueNo = this.doIssueNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blProofbyshipperBy = this.blProofbyshipperBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdr = this.bdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPpdRcv = this.trdPpdRcv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgRate = this.flgRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onBoardType = this.onBoardType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdRcvDt = this.ppdRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIssueDate = this.doIssueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blProofbyshipperOffice = this.blProofbyshipperOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docProcModyflg = this.docProcModyflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgToOrder = this.flgToOrder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssueDate = this.blIssueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oBlreceiveNo = this.oBlreceiveNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCode = this.porCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blReadyType = this.blReadyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdDate = this.ppdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCctOffice = this.trdCctOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssueNo = this.blIssueNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moveType = this.moveType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oBlreceiveDate = this.oBlreceiveDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buttontype = this.buttontype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssueblType = this.blIssueblType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPpdConfirm = this.trdPpdConfirm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddress = this.shprAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surrender = this.surrender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCctDate = this.trdCctDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssueAt = this.blIssueAt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt = this.polEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRcvDt = this.cgoRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvUserId = this.cctRcvUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdRcvUserId = this.ppdRcvUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOffice = this.cctOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssueRelease = this.blIssueRelease .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blProofbyshipperCheckbox = this.blProofbyshipperCheckbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onBoardDate = this.onBoardDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.printOption = this.printOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blReadyCheckbox = this.blReadyCheckbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issued = this.issued .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCode = this.delCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCctRcvUserOffice = this.trdCctRcvUserOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdRcvUserOffice = this.ppdRcvUserOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvDt = this.cctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssueBy = this.blIssueBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docProcType = this.docProcType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blReadyDate = this.blReadyDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdBy = this.ppdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPpdRcvDt = this.trdPpdRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.internetAuth = this.internetAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPpdRcvUserOffice = this.trdPpdRcvUserOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.released = this.released .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdConfirm = this.ppdConfirm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podName = this.podName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docRequestFlag = this.docRequestFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polName = this.polName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonEml = this.cntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porName = this.porName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authFlag = this.authFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOffice = this.updOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oBlreceiveBy = this.oBlreceiveBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcv = this.cctRcv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgDo = this.flgDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgMd = this.flgMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCode = this.podCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgPpd = this.flgPpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdFlgPpd = this.trdFlgPpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPpdBy = this.trdPpdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdRcv = this.ppdRcv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blHldFlg = this.blHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blHldRsnCd = this.blHldRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blHldDt = this.blHldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blHldUsrId = this.blHldUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblEml = this.wblEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblRtTpCd = this.wblRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFlg = this.imgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
