/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaRcvMsgVO.java
*@FileTitle : UsaRcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.02.17 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.syscommon.common.table.BkgCstmsAdvIbdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaRcvMsgVO extends RcvMsgVO { // extends 수정추가.

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaRcvMsgVO> models = new ArrayList<UsaRcvMsgVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String itCusjTqty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String inPod = null;
	/* Column Info */
	private String irDateM = null;
	/* Column Info */
	private String cntrHoldRemark = null;
	/* Column Info */
	private String itLast = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String rlseHldCd = null;
	/* Column Info */
	private String vslEngNmM = null;
	/* Column Info */
	private String icrRemark1 = null;
	/* Column Info */
	private String lclBlNbrA = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String remark3 = null;
	/* Column Info */
	private String inNvobl = null;
	/* Column Info */
	private String remark2 = null;
	/* Column Info */
	private String inCodeb = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String itCstmcind = null;
	/* Column Info */
	private String itCuswTqty = null;
	/* Column Info */
	private String inCntr = null;
	/* Column Info */
	private String icrDate = null;
	/* Column Info */
	private String acpDate = null;
	/* Column Info */
	private String hldCd = null;
	/* Column Info */
	private String skdVoyNoM = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String inBl = null;
	/* Column Info */
	private String itQty = null;
	/* Column Info */
	private String inCode = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String itCusrTqty = null;
	/* Column Info */
	private String vslCdM = null;
	/* Column Info */
	private String isfTranNo = null;
	/* Column Info */
	private String rcvMsgDtlSeq = null;
	/* Column Info */
	private String icrEtTp = null;
	/* Column Info */
	private String irType = null;
	/* Column Info */
	private String masterOrHouse = null;
	/* Column Info */
	private String icrEtNo = null;
	/* Column Info */
	private String icrQty = null;
	/* Column Info */
	private String itHub = null;
	/* Column Info */
	private String rcvMsg = null;
	/* Column Info */
	private String isfSeq = null;
	/* Column Info */
	private String rlseHldDt = null;
	/* Column Info */
	private String locAmsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cusAmsport = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String itCgoCind = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String ibdRstUpdateFlg = null;
	/* Column Info */
	private String inSnp = null;
	/* Column Info */
	private String podAmsportM = null;
	/* Column Info */
	private String hldDt = null;
	/* Column Info */
	private String podAmsport = null;
	/* Column Info */
	private String icrResendInd = null;
	/* Column Info */
	private String isfInRemark1 = null;
	/* Column Info */
	private String podLocM = null;
	/* Column Info */
	private String isfInRemark2 = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String crrBatNo = null;
	/* Column Info */
	private String irBatchNo = null;
	/* Column Info */
	private String cnruIt = null;
	/* Column Info */
	private String newCntrCFlag = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String icrCode = null;
	/* Column Info */
	private String irDate = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mblNo = null;
	/* Column Info */
	private String irSeq = null;
	/* Column Info */
	private String isfInBl = null;
	/* Column Info */
	private String isfRcvCd = null;
	/* Column Info */
	private String icrSeq = null;
	/* Column Info */
	private String cusLoc = null;
	/* Column Info */
	private String zone = null;
	/* Column Info */
	private String inHjbl = null;
	/* Column Info */
	private String isBaplieRC = null;
	/* Column Info */
	private String cstmsRmk1 = null;
	/* Column Info */
	private String ackResult = null;
	/* Column Info */
	private String ackCode = null;
	/* Column Info */
	private String ackDesc = null;
	/* Column Info */
	private String cntrOpr = null;
	/* Column Info */
	private String errResult = null;
	/* Column Info */
	private String errCode = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String podCd = null;

	/* Column Info */
	private String cstmsLocDiffFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaRcvMsgVO() {}

	public UsaRcvMsgVO(String ibflag, String pagerows, String acpDate, String blNo, String cnruIt, String cstmsClrCd, String cusAmsport, String destLocCd, String cusLoc, String cntrNo, String crrBatNo, String hblNo, String mblNo, String ibdRstUpdateFlg, String icrResendInd, String icrCode, String icrQty, String icrEtTp, String icrEtNo, String icrDate, String icrSeq, String icrRemark1, String inBl, String inCntr, String inCode, String inCodeb, String inHjbl,String isBaplieRC,String cstmsRmk1, String inNvobl, String inPod, String inSnp, String inVvd, String irType, String irDate, String irDateM, String irSeq, String irBatchNo, String isfInBl, String isfInRemark1, String isfInRemark2, String isfTranNo, String isfRcvCd, String isfSeq, String itQty, String itCusrTqty, String itCstmcind, String itCgoCind, String itCusjTqty, String itCuswTqty, String itHub, String itLast, String lclBlNbrA, String locAmsPortCd, String masterOrHouse, String msgDesc, String newCntrCFlag, String podAmsport, String podAmsportM, String podLoc, String podLocM, String rcvMsg, String remark2, String remark3, String rcvMsgDtlSeq, String skdDirCd, String skdVoyNo, String skdVoyNoM, String vslCd, String vslCdM, String vslEngNm, String vslEngNmM, String zone, String rlseHldCd, String rlseHldDt, String hldCd, String hldDt, String cntrHoldRemark, String polCd, 
						String ackResult, String ackCode, String ackDesc, String cntrOpr, String errResult, String errCode, String errDesc, String podCd
						,String cstmsLocDiffFlg) {
		this.inVvd = inVvd;
		this.itCusjTqty = itCusjTqty;
		this.vslCd = vslCd;
		this.inPod = inPod;
		this.irDateM = irDateM;
		this.cntrHoldRemark = cntrHoldRemark;
		this.itLast = itLast;
		this.msgDesc = msgDesc;
		this.rlseHldCd = rlseHldCd;
		this.vslEngNmM = vslEngNmM;
		this.icrRemark1 = icrRemark1;
		this.lclBlNbrA = lclBlNbrA;
		this.blNo = blNo;
		this.remark3 = remark3;
		this.inNvobl = inNvobl;
		this.remark2 = remark2;
		this.inCodeb = inCodeb;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.hblNo = hblNo;
		this.itCstmcind = itCstmcind;
		this.itCuswTqty = itCuswTqty;
		this.inCntr = inCntr;
		this.icrDate = icrDate;
		this.acpDate = acpDate;
		this.hldCd = hldCd;
		this.skdVoyNoM = skdVoyNoM;
		this.skdVoyNo = skdVoyNo;
		this.inBl = inBl;
		this.itQty = itQty;
		this.inCode = inCode;
		this.podLoc = podLoc;
		this.itCusrTqty = itCusrTqty;
		this.vslCdM = vslCdM;
		this.isfTranNo = isfTranNo;
		this.rcvMsgDtlSeq = rcvMsgDtlSeq;
		this.icrEtTp = icrEtTp;
		this.irType = irType;
		this.masterOrHouse = masterOrHouse;
		this.icrEtNo = icrEtNo;
		this.icrQty = icrQty;
		this.itHub = itHub;
		this.rcvMsg = rcvMsg;
		this.isfSeq = isfSeq;
		this.rlseHldDt = rlseHldDt;
		this.locAmsPortCd = locAmsPortCd;
		this.ibflag = ibflag;
		this.cusAmsport = cusAmsport;
		this.destLocCd = destLocCd;
		this.itCgoCind = itCgoCind;
		this.vslEngNm = vslEngNm;
		this.ibdRstUpdateFlg = ibdRstUpdateFlg;
		this.inSnp = inSnp;
		this.podAmsportM = podAmsportM;
		this.hldDt = hldDt;
		this.podAmsport = podAmsport;
		this.icrResendInd = icrResendInd;
		this.isfInRemark1 = isfInRemark1;
		this.podLocM = podLocM;
		this.isfInRemark2 = isfInRemark2;
		this.cstmsClrCd = cstmsClrCd;
		this.crrBatNo = crrBatNo;
		this.irBatchNo = irBatchNo;
		this.cnruIt = cnruIt;
		this.newCntrCFlag = newCntrCFlag;
		this.skdDirCd = skdDirCd;
		this.icrCode = icrCode;
		this.irDate = irDate;
		this.cntrNo = cntrNo;
		this.mblNo = mblNo;
		this.irSeq = irSeq;
		this.isfInBl = isfInBl;
		this.isfRcvCd = isfRcvCd;
		this.icrSeq = icrSeq;
		this.cusLoc = cusLoc;
		this.zone = zone;
		this.inHjbl = inHjbl;
		this.isBaplieRC = isBaplieRC;
		this.cstmsRmk1 = cstmsRmk1;
		this.ackResult = ackResult;
		this.ackCode = ackCode;
		this.ackDesc = ackDesc;
		this.cntrOpr = cntrOpr;
		this.errResult = errResult;
		this.errCode = errCode;
		this.errDesc = errDesc;
		this.podCd = podCd;
		this.cstmsLocDiffFlg = cstmsLocDiffFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("it_cusj_tqty", getItCusjTqty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("in_pod", getInPod());
		this.hashColumns.put("ir_date_m", getIrDateM());
		this.hashColumns.put("cntr_hold_remark", getCntrHoldRemark());
		this.hashColumns.put("it_last", getItLast());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("rlse_hld_cd", getRlseHldCd());
		this.hashColumns.put("vsl_eng_nm_m", getVslEngNmM());
		this.hashColumns.put("icr_remark1", getIcrRemark1());
		this.hashColumns.put("lcl_bl_nbr_a", getLclBlNbrA());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("remark3", getRemark3());
		this.hashColumns.put("in_nvobl", getInNvobl());
		this.hashColumns.put("remark2", getRemark2());
		this.hashColumns.put("in_codeb", getInCodeb());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("it_cstmcind", getItCstmcind());
		this.hashColumns.put("it_cusw_tqty", getItCuswTqty());
		this.hashColumns.put("in_cntr", getInCntr());
		this.hashColumns.put("icr_date", getIcrDate());
		this.hashColumns.put("acp_date", getAcpDate());
		this.hashColumns.put("hld_cd", getHldCd());
		this.hashColumns.put("skd_voy_no_m", getSkdVoyNoM());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("in_bl", getInBl());
		this.hashColumns.put("it_qty", getItQty());
		this.hashColumns.put("in_code", getInCode());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("it_cusr_tqty", getItCusrTqty());
		this.hashColumns.put("vsl_cd_m", getVslCdM());
		this.hashColumns.put("isf_tran_no", getIsfTranNo());
		this.hashColumns.put("rcv_msg_dtl_seq", getRcvMsgDtlSeq());
		this.hashColumns.put("icr_et_tp", getIcrEtTp());
		this.hashColumns.put("ir_type", getIrType());
		this.hashColumns.put("master_or_house", getMasterOrHouse());
		this.hashColumns.put("icr_et_no", getIcrEtNo());
		this.hashColumns.put("icr_qty", getIcrQty());
		this.hashColumns.put("it_hub", getItHub());
		this.hashColumns.put("rcv_msg", getRcvMsg());
		this.hashColumns.put("isf_seq", getIsfSeq());
		this.hashColumns.put("rlse_hld_dt", getRlseHldDt());
		this.hashColumns.put("loc_ams_port_cd", getLocAmsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cus_amsport", getCusAmsport());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("it_cgo_cind", getItCgoCind());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("ibd_rst_update_flg", getIbdRstUpdateFlg());
		this.hashColumns.put("in_snp", getInSnp());
		this.hashColumns.put("pod_amsport_m", getPodAmsportM());
		this.hashColumns.put("hld_dt", getHldDt());
		this.hashColumns.put("pod_amsport", getPodAmsport());
		this.hashColumns.put("icr_resend_ind", getIcrResendInd());
		this.hashColumns.put("isf_in_remark1", getIsfInRemark1());
		this.hashColumns.put("pod_loc_m", getPodLocM());
		this.hashColumns.put("isf_in_remark2", getIsfInRemark2());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("crr_bat_no", getCrrBatNo());
		this.hashColumns.put("ir_batch_no", getIrBatchNo());
		this.hashColumns.put("cnru_it", getCnruIt());
		this.hashColumns.put("new_cntr_c_flag", getNewCntrCFlag());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("icr_code", getIcrCode());
		this.hashColumns.put("ir_date", getIrDate());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mbl_no", getMblNo());
		this.hashColumns.put("ir_seq", getIrSeq());
		this.hashColumns.put("isf_in_bl", getIsfInBl());
		this.hashColumns.put("isf_rcv_cd", getIsfRcvCd());
		this.hashColumns.put("icr_seq", getIcrSeq());
		this.hashColumns.put("cus_loc", getCusLoc());
		this.hashColumns.put("zone", getZone());
		this.hashColumns.put("in_hjbl", getInHjbl());
		this.hashColumns.put("is_baplie_rc", getIsBaplieRC());
		this.hashColumns.put("cstms_rmk1", getCstmsRmk1());
		this.hashColumns.put("ack_result", getAckResult());
		this.hashColumns.put("ack_code", getAckCode());
		this.hashColumns.put("ack_desc", getAckDesc());
		this.hashColumns.put("cntr_opr", getCntrOpr());
		this.hashColumns.put("err_result", getErrResult());
		this.hashColumns.put("err_code", getErrCode());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cstms_loc_diff_flg", getCstmsLocDiffFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("it_cusj_tqty", "itCusjTqty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("in_pod", "inPod");
		this.hashFields.put("ir_date_m", "irDateM");
		this.hashFields.put("cntr_hold_remark", "cntrHoldRemark");
		this.hashFields.put("it_last", "itLast");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("rlse_hld_cd", "rlseHldCd");
		this.hashFields.put("vsl_eng_nm_m", "vslEngNmM");
		this.hashFields.put("icr_remark1", "icrRemark1");
		this.hashFields.put("lcl_bl_nbr_a", "lclBlNbrA");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("remark3", "remark3");
		this.hashFields.put("in_nvobl", "inNvobl");
		this.hashFields.put("remark2", "remark2");
		this.hashFields.put("in_codeb", "inCodeb");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("it_cstmcind", "itCstmcind");
		this.hashFields.put("it_cusw_tqty", "itCuswTqty");
		this.hashFields.put("in_cntr", "inCntr");
		this.hashFields.put("icr_date", "icrDate");
		this.hashFields.put("acp_date", "acpDate");
		this.hashFields.put("hld_cd", "hldCd");
		this.hashFields.put("skd_voy_no_m", "skdVoyNoM");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("in_bl", "inBl");
		this.hashFields.put("it_qty", "itQty");
		this.hashFields.put("in_code", "inCode");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("it_cusr_tqty", "itCusrTqty");
		this.hashFields.put("vsl_cd_m", "vslCdM");
		this.hashFields.put("isf_tran_no", "isfTranNo");
		this.hashFields.put("rcv_msg_dtl_seq", "rcvMsgDtlSeq");
		this.hashFields.put("icr_et_tp", "icrEtTp");
		this.hashFields.put("ir_type", "irType");
		this.hashFields.put("master_or_house", "masterOrHouse");
		this.hashFields.put("icr_et_no", "icrEtNo");
		this.hashFields.put("icr_qty", "icrQty");
		this.hashFields.put("it_hub", "itHub");
		this.hashFields.put("rcv_msg", "rcvMsg");
		this.hashFields.put("isf_seq", "isfSeq");
		this.hashFields.put("rlse_hld_dt", "rlseHldDt");
		this.hashFields.put("loc_ams_port_cd", "locAmsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cus_amsport", "cusAmsport");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("it_cgo_cind", "itCgoCind");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("ibd_rst_update_flg", "ibdRstUpdateFlg");
		this.hashFields.put("in_snp", "inSnp");
		this.hashFields.put("pod_amsport_m", "podAmsportM");
		this.hashFields.put("hld_dt", "hldDt");
		this.hashFields.put("pod_amsport", "podAmsport");
		this.hashFields.put("icr_resend_ind", "icrResendInd");
		this.hashFields.put("isf_in_remark1", "isfInRemark1");
		this.hashFields.put("pod_loc_m", "podLocM");
		this.hashFields.put("isf_in_remark2", "isfInRemark2");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("crr_bat_no", "crrBatNo");
		this.hashFields.put("ir_batch_no", "irBatchNo");
		this.hashFields.put("cnru_it", "cnruIt");
		this.hashFields.put("new_cntr_c_flag", "newCntrCFlag");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("icr_code", "icrCode");
		this.hashFields.put("ir_date", "irDate");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mbl_no", "mblNo");
		this.hashFields.put("ir_seq", "irSeq");
		this.hashFields.put("isf_in_bl", "isfInBl");
		this.hashFields.put("isf_rcv_cd", "isfRcvCd");
		this.hashFields.put("icr_seq", "icrSeq");
		this.hashFields.put("cus_loc", "cusLoc");
		this.hashFields.put("zone", "zone");
		this.hashFields.put("in_hjbl", "inHjbl");
		this.hashFields.put("is_baplie_rc", "isBaplieRC");
		this.hashFields.put("cstms_rmk1", "cstmsRmk1");
		this.hashFields.put("ack_result", "ackResult");
		this.hashFields.put("ack_code", "ackCode");
		this.hashFields.put("ack_desc", "ackDesc");
		this.hashFields.put("cntr_opr", "cntrOpr");
		this.hashFields.put("err_result", "errResult");
		this.hashFields.put("err_code", "errCode");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cstms_loc_diff_flg", "cstmsLocDiffFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}
	
	/**
	 * Column Info
	 * @return itCusjTqty
	 */
	public String getItCusjTqty() {
		return this.itCusjTqty;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return inPod
	 */
	public String getInPod() {
		return this.inPod;
	}
	
	/**
	 * Column Info
	 * @return irDateM
	 */
	public String getIrDateM() {
		return this.irDateM;
	}
	
	/**
	 * Column Info
	 * @return cntrHoldRemark
	 */
	public String getCntrHoldRemark() {
		return this.cntrHoldRemark;
	}
	
	/**
	 * Column Info
	 * @return itLast
	 */
	public String getItLast() {
		return this.itLast;
	}
	
	/**
	 * Column Info
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
	}
	
	/**
	 * Column Info
	 * @return rlseHldCd
	 */
	public String getRlseHldCd() {
		return this.rlseHldCd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNmM
	 */
	public String getVslEngNmM() {
		return this.vslEngNmM;
	}
	
	/**
	 * Column Info
	 * @return icrRemark1
	 */
	public String getIcrRemark1() {
		return this.icrRemark1;
	}
	
	/**
	 * Column Info
	 * @return lclBlNbrA
	 */
	public String getLclBlNbrA() {
		return this.lclBlNbrA;
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
	 * @return remark3
	 */
	public String getRemark3() {
		return this.remark3;
	}
	
	/**
	 * Column Info
	 * @return inNvobl
	 */
	public String getInNvobl() {
		return this.inNvobl;
	}
	
	/**
	 * Column Info
	 * @return remark2
	 */
	public String getRemark2() {
		return this.remark2;
	}
	
	/**
	 * Column Info
	 * @return inCodeb
	 */
	public String getInCodeb() {
		return this.inCodeb;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return itCstmcind
	 */
	public String getItCstmcind() {
		return this.itCstmcind;
	}
	
	/**
	 * Column Info
	 * @return itCuswTqty
	 */
	public String getItCuswTqty() {
		return this.itCuswTqty;
	}
	
	/**
	 * Column Info
	 * @return inCntr
	 */
	public String getInCntr() {
		return this.inCntr;
	}
	
	/**
	 * Column Info
	 * @return icrDate
	 */
	public String getIcrDate() {
		return this.icrDate;
	}
	
	/**
	 * Column Info
	 * @return acpDate
	 */
	public String getAcpDate() {
		return this.acpDate;
	}
	
	/**
	 * Column Info
	 * @return hldCd
	 */
	public String getHldCd() {
		return this.hldCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNoM
	 */
	public String getSkdVoyNoM() {
		return this.skdVoyNoM;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return inBl
	 */
	public String getInBl() {
		return this.inBl;
	}
	
	/**
	 * Column Info
	 * @return itQty
	 */
	public String getItQty() {
		return this.itQty;
	}
	
	/**
	 * Column Info
	 * @return inCode
	 */
	public String getInCode() {
		return this.inCode;
	}
	
	/**
	 * Column Info
	 * @return podLoc
	 */
	public String getPodLoc() {
		return this.podLoc;
	}
	
	/**
	 * Column Info
	 * @return itCusrTqty
	 */
	public String getItCusrTqty() {
		return this.itCusrTqty;
	}
	
	/**
	 * Column Info
	 * @return vslCdM
	 */
	public String getVslCdM() {
		return this.vslCdM;
	}
	
	/**
	 * Column Info
	 * @return isfTranNo
	 */
	public String getIsfTranNo() {
		return this.isfTranNo;
	}
	
	/**
	 * Column Info
	 * @return rcvMsgDtlSeq
	 */
	public String getRcvMsgDtlSeq() {
		return this.rcvMsgDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return icrEtTp
	 */
	public String getIcrEtTp() {
		return this.icrEtTp;
	}
	
	/**
	 * Column Info
	 * @return irType
	 */
	public String getIrType() {
		return this.irType;
	}
	
	/**
	 * Column Info
	 * @return masterOrHouse
	 */
	public String getMasterOrHouse() {
		return this.masterOrHouse;
	}
	
	/**
	 * Column Info
	 * @return icrEtNo
	 */
	public String getIcrEtNo() {
		return this.icrEtNo;
	}
	
	/**
	 * Column Info
	 * @return icrQty
	 */
	public String getIcrQty() {
		return this.icrQty;
	}
	
	/**
	 * Column Info
	 * @return itHub
	 */
	public String getItHub() {
		return this.itHub;
	}
	
	/**
	 * Column Info
	 * @return rcvMsg
	 */
	public String getRcvMsg() {
		return this.rcvMsg;
	}
	
	/**
	 * Column Info
	 * @return isfSeq
	 */
	public String getIsfSeq() {
		return this.isfSeq;
	}
	
	/**
	 * Column Info
	 * @return rlseHldDt
	 */
	public String getRlseHldDt() {
		return this.rlseHldDt;
	}
	
	/**
	 * Column Info
	 * @return locAmsPortCd
	 */
	public String getLocAmsPortCd() {
		return this.locAmsPortCd;
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
	 * @return cusAmsport
	 */
	public String getCusAmsport() {
		return this.cusAmsport;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
	}
	
	/**
	 * Column Info
	 * @return itCgoCind
	 */
	public String getItCgoCind() {
		return this.itCgoCind;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return ibdRstUpdateFlg
	 */
	public String getIbdRstUpdateFlg() {
		return this.ibdRstUpdateFlg;
	}
	
	/**
	 * Column Info
	 * @return inSnp
	 */
	public String getInSnp() {
		return this.inSnp;
	}
	
	/**
	 * Column Info
	 * @return podAmsportM
	 */
	public String getPodAmsportM() {
		return this.podAmsportM;
	}
	
	/**
	 * Column Info
	 * @return hldDt
	 */
	public String getHldDt() {
		return this.hldDt;
	}
	
	/**
	 * Column Info
	 * @return podAmsport
	 */
	public String getPodAmsport() {
		return this.podAmsport;
	}
	
	/**
	 * Column Info
	 * @return icrResendInd
	 */
	public String getIcrResendInd() {
		return this.icrResendInd;
	}
	
	/**
	 * Column Info
	 * @return isfInRemark1
	 */
	public String getIsfInRemark1() {
		return this.isfInRemark1;
	}
	
	/**
	 * Column Info
	 * @return podLocM
	 */
	public String getPodLocM() {
		return this.podLocM;
	}
	
	/**
	 * Column Info
	 * @return isfInRemark2
	 */
	public String getIsfInRemark2() {
		return this.isfInRemark2;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return crrBatNo
	 */
	public String getCrrBatNo() {
		return this.crrBatNo;
	}
	
	/**
	 * Column Info
	 * @return irBatchNo
	 */
	public String getIrBatchNo() {
		return this.irBatchNo;
	}
	
	/**
	 * Column Info
	 * @return cnruIt
	 */
	public String getCnruIt() {
		return this.cnruIt;
	}
	
	/**
	 * Column Info
	 * @return newCntrCFlag
	 */
	public String getNewCntrCFlag() {
		return this.newCntrCFlag;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return icrCode
	 */
	public String getIcrCode() {
		return this.icrCode;
	}
	
	/**
	 * Column Info
	 * @return irDate
	 */
	public String getIrDate() {
		return this.irDate;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return mblNo
	 */
	public String getMblNo() {
		return this.mblNo;
	}
	
	/**
	 * Column Info
	 * @return irSeq
	 */
	public String getIrSeq() {
		return this.irSeq;
	}
	
	/**
	 * Column Info
	 * @return isfInBl
	 */
	public String getIsfInBl() {
		return this.isfInBl;
	}
	
	/**
	 * Column Info
	 * @return isfRcvCd
	 */
	public String getIsfRcvCd() {
		return this.isfRcvCd;
	}
	
	/**
	 * Column Info
	 * @return icrSeq
	 */
	public String getIcrSeq() {
		return this.icrSeq;
	}
	
	/**
	 * Column Info
	 * @return cusLoc
	 */
	public String getCusLoc() {
		return this.cusLoc;
	}
	
	/**
	 * Column Info
	 * @return zone
	 */
	public String getZone() {
		return this.zone;
	}
	
	/**
	 * Column Info
	 * @return inHjbl
	 */
	public String getInHjbl() {
		return this.inHjbl;
	}
	
	/**
	 * Column Info
	 * @return isBaplieRC
	 */
	public String getIsBaplieRC() {
		return this.isBaplieRC;
	}
	/**
	 * Column Info
	 * @return cstmsRmk1
	 */
	public String getCstmsRmk1() {
		return this.cstmsRmk1;
	}
	
	/**
	 * Column Info
	 * @return ackResult
	 */
	public String getAckResult() {
		return this.ackResult;
	}
	
	/**
	 * Column Info
	 * @return ackCode
	 */
	public String getAckCode() {
		return this.ackCode;
	}
	/**
	 * Column Info
	 * @return ackDesc
	 */
	public String getAckDesc() {
		return this.ackDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrOpr
	 */
	public String getCntrOpr() {
		return this.cntrOpr;
	}
	
	/**
	 * Column Info
	 * @return errResult
	 */
	public String getErrResult() {
		return this.errResult;
	}
	
	/**
	 * Column Info
	 * @return errCode
	 */
	public String getErrCode() {
		return this.errCode;
	}
	/**
	 * Column Info
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsLocDiffFlg
	 */
	public String getCstmsLocDiffFlg() {
		return this.cstmsLocDiffFlg;
	}

	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}
	
	/**
	 * Column Info
	 * @param itCusjTqty
	 */
	public void setItCusjTqty(String itCusjTqty) {
		this.itCusjTqty = itCusjTqty;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param inPod
	 */
	public void setInPod(String inPod) {
		this.inPod = inPod;
	}
	
	/**
	 * Column Info
	 * @param irDateM
	 */
	public void setIrDateM(String irDateM) {
		this.irDateM = irDateM;
	}
	
	/**
	 * Column Info
	 * @param cntrHoldRemark
	 */
	public void setCntrHoldRemark(String cntrHoldRemark) {
		this.cntrHoldRemark = cntrHoldRemark;
	}
	
	/**
	 * Column Info
	 * @param itLast
	 */
	public void setItLast(String itLast) {
		this.itLast = itLast;
	}
	
	/**
	 * Column Info
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	/**
	 * Column Info
	 * @param rlseHldCd
	 */
	public void setRlseHldCd(String rlseHldCd) {
		this.rlseHldCd = rlseHldCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNmM
	 */
	public void setVslEngNmM(String vslEngNmM) {
		this.vslEngNmM = vslEngNmM;
	}
	
	/**
	 * Column Info
	 * @param icrRemark1
	 */
	public void setIcrRemark1(String icrRemark1) {
		this.icrRemark1 = icrRemark1;
	}
	
	/**
	 * Column Info
	 * @param lclBlNbrA
	 */
	public void setLclBlNbrA(String lclBlNbrA) {
		this.lclBlNbrA = lclBlNbrA;
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
	 * @param remark3
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	
	/**
	 * Column Info
	 * @param inNvobl
	 */
	public void setInNvobl(String inNvobl) {
		this.inNvobl = inNvobl;
	}
	
	/**
	 * Column Info
	 * @param remark2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	
	/**
	 * Column Info
	 * @param inCodeb
	 */
	public void setInCodeb(String inCodeb) {
		this.inCodeb = inCodeb;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param itCstmcind
	 */
	public void setItCstmcind(String itCstmcind) {
		this.itCstmcind = itCstmcind;
	}
	
	/**
	 * Column Info
	 * @param itCuswTqty
	 */
	public void setItCuswTqty(String itCuswTqty) {
		this.itCuswTqty = itCuswTqty;
	}
	
	/**
	 * Column Info
	 * @param inCntr
	 */
	public void setInCntr(String inCntr) {
		this.inCntr = inCntr;
	}
	
	/**
	 * Column Info
	 * @param icrDate
	 */
	public void setIcrDate(String icrDate) {
		this.icrDate = icrDate;
	}
	
	/**
	 * Column Info
	 * @param acpDate
	 */
	public void setAcpDate(String acpDate) {
		this.acpDate = acpDate;
	}
	
	/**
	 * Column Info
	 * @param hldCd
	 */
	public void setHldCd(String hldCd) {
		this.hldCd = hldCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNoM
	 */
	public void setSkdVoyNoM(String skdVoyNoM) {
		this.skdVoyNoM = skdVoyNoM;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param inBl
	 */
	public void setInBl(String inBl) {
		this.inBl = inBl;
	}
	
	/**
	 * Column Info
	 * @param itQty
	 */
	public void setItQty(String itQty) {
		this.itQty = itQty;
	}
	
	/**
	 * Column Info
	 * @param inCode
	 */
	public void setInCode(String inCode) {
		this.inCode = inCode;
	}
	
	/**
	 * Column Info
	 * @param podLoc
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}
	
	/**
	 * Column Info
	 * @param itCusrTqty
	 */
	public void setItCusrTqty(String itCusrTqty) {
		this.itCusrTqty = itCusrTqty;
	}
	
	/**
	 * Column Info
	 * @param vslCdM
	 */
	public void setVslCdM(String vslCdM) {
		this.vslCdM = vslCdM;
	}
	
	/**
	 * Column Info
	 * @param isfTranNo
	 */
	public void setIsfTranNo(String isfTranNo) {
		this.isfTranNo = isfTranNo;
	}
	
	/**
	 * Column Info
	 * @param rcvMsgDtlSeq
	 */
	public void setRcvMsgDtlSeq(String rcvMsgDtlSeq) {
		this.rcvMsgDtlSeq = rcvMsgDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param icrEtTp
	 */
	public void setIcrEtTp(String icrEtTp) {
		this.icrEtTp = icrEtTp;
	}
	
	/**
	 * Column Info
	 * @param irType
	 */
	public void setIrType(String irType) {
		this.irType = irType;
	}
	
	/**
	 * Column Info
	 * @param masterOrHouse
	 */
	public void setMasterOrHouse(String masterOrHouse) {
		this.masterOrHouse = masterOrHouse;
	}
	
	/**
	 * Column Info
	 * @param icrEtNo
	 */
	public void setIcrEtNo(String icrEtNo) {
		this.icrEtNo = icrEtNo;
	}
	
	/**
	 * Column Info
	 * @param icrQty
	 */
	public void setIcrQty(String icrQty) {
		this.icrQty = icrQty;
	}
	
	/**
	 * Column Info
	 * @param itHub
	 */
	public void setItHub(String itHub) {
		this.itHub = itHub;
	}
	
	/**
	 * Column Info
	 * @param rcvMsg
	 */
	public void setRcvMsg(String rcvMsg) {
		this.rcvMsg = rcvMsg;
	}
	
	/**
	 * Column Info
	 * @param isfSeq
	 */
	public void setIsfSeq(String isfSeq) {
		this.isfSeq = isfSeq;
	}
	
	/**
	 * Column Info
	 * @param rlseHldDt
	 */
	public void setRlseHldDt(String rlseHldDt) {
		this.rlseHldDt = rlseHldDt;
	}
	
	/**
	 * Column Info
	 * @param locAmsPortCd
	 */
	public void setLocAmsPortCd(String locAmsPortCd) {
		this.locAmsPortCd = locAmsPortCd;
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
	 * @param cusAmsport
	 */
	public void setCusAmsport(String cusAmsport) {
		this.cusAmsport = cusAmsport;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd (String destLocCd) {
		this.destLocCd = destLocCd;
	}
	
	/**
	 * Column Info
	 * @param itCgoCind
	 */
	public void setItCgoCind(String itCgoCind) {
		this.itCgoCind = itCgoCind;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param ibdRstUpdateFlg
	 */
	public void setIbdRstUpdateFlg(String ibdRstUpdateFlg) {
		this.ibdRstUpdateFlg = ibdRstUpdateFlg;
	}
	
	/**
	 * Column Info
	 * @param inSnp
	 */
	public void setInSnp(String inSnp) {
		this.inSnp = inSnp;
	}
	
	/**
	 * Column Info
	 * @param podAmsportM
	 */
	public void setPodAmsportM(String podAmsportM) {
		this.podAmsportM = podAmsportM;
	}
	
	/**
	 * Column Info
	 * @param hldDt
	 */
	public void setHldDt(String hldDt) {
		this.hldDt = hldDt;
	}
	
	/**
	 * Column Info
	 * @param podAmsport
	 */
	public void setPodAmsport(String podAmsport) {
		this.podAmsport = podAmsport;
	}
	
	/**
	 * Column Info
	 * @param icrResendInd
	 */
	public void setIcrResendInd(String icrResendInd) {
		this.icrResendInd = icrResendInd;
	}
	
	/**
	 * Column Info
	 * @param isfInRemark1
	 */
	public void setIsfInRemark1(String isfInRemark1) {
		this.isfInRemark1 = isfInRemark1;
	}
	
	/**
	 * Column Info
	 * @param podLocM
	 */
	public void setPodLocM(String podLocM) {
		this.podLocM = podLocM;
	}
	
	/**
	 * Column Info
	 * @param isfInRemark2
	 */
	public void setIsfInRemark2(String isfInRemark2) {
		this.isfInRemark2 = isfInRemark2;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param crrBatNo
	 */
	public void setCrrBatNo(String crrBatNo) {
		this.crrBatNo = crrBatNo;
	}
	
	/**
	 * Column Info
	 * @param irBatchNo
	 */
	public void setIrBatchNo(String irBatchNo) {
		this.irBatchNo = irBatchNo;
	}
	
	/**
	 * Column Info
	 * @param cnruIt
	 */
	public void setCnruIt(String cnruIt) {
		this.cnruIt = cnruIt;
	}
	
	/**
	 * Column Info
	 * @param newCntrCFlag
	 */
	public void setNewCntrCFlag(String newCntrCFlag) {
		this.newCntrCFlag = newCntrCFlag;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param icrCode
	 */
	public void setIcrCode(String icrCode) {
		this.icrCode = icrCode;
	}
	
	/**
	 * Column Info
	 * @param irDate
	 */
	public void setIrDate(String irDate) {
		this.irDate = irDate;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param mblNo
	 */
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	
	/**
	 * Column Info
	 * @param irSeq
	 */
	public void setIrSeq(String irSeq) {
		this.irSeq = irSeq;
	}
	
	/**
	 * Column Info
	 * @param isfInBl
	 */
	public void setIsfInBl(String isfInBl) {
		this.isfInBl = isfInBl;
	}
	
	/**
	 * Column Info
	 * @param isfRcvCd
	 */
	public void setIsfRcvCd(String isfRcvCd) {
		this.isfRcvCd = isfRcvCd;
	}
	
	/**
	 * Column Info
	 * @param icrSeq
	 */
	public void setIcrSeq(String icrSeq) {
		this.icrSeq = icrSeq;
	}
	
	/**
	 * Column Info
	 * @param cusLoc
	 */
	public void setCusLoc(String cusLoc) {
		this.cusLoc = cusLoc;
	}
	
	/**
	 * Column Info
	 * @param zone
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	/**
	 * Column Info
	 * @param inHjbl
	 */
	public void setInHjbl(String inHjbl) {
		this.inHjbl = inHjbl;
	}
	
	/**
	 * Column Info
	 * @param isBaplieRC
	 */
	public void setIsBaplieRC(String isBaplieRC) {
		this.isBaplieRC = isBaplieRC;
	}
	/**
	 * Column Info
	 * @param cstmsRmk1
	 */
	public void setCstmsRmk1(String cstmsRmk1) {
		this.cstmsRmk1 = cstmsRmk1;
	}
	
	/**
	 * Column Info
	 * @param ackResult
	 */
	public void setAckResult(String ackResult) {
		this.ackResult = ackResult;
	}
	
	/**
	 * Column Info
	 * @param ackCode
	 */
	public void setAckCode(String ackCode) {
		this.ackCode = ackCode;
	}
	/**
	 * Column Info
	 * @param ackDesc
	 */
	public void setAckDesc(String ackDesc) {
		this.ackDesc = ackDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrOpr
	 */
	public void setCntrOpr(String cntrOpr) {
		this.cntrOpr = cntrOpr;
	}
	
	/**
	 * Column Info
	 * @param errResult
	 */
	public void setErrResult(String errResult) {
		this.errResult = errResult;
	}
	
	/**
	 * Column Info
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	/**
	 * Column Info
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsLocDiffFlg
	 */
	public void setCstmsLocDiffFlg(String cstmsLocDiffFlg) {
		this.cstmsLocDiffFlg = cstmsLocDiffFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setInVvd(JSPUtil.getParameter(request, prefix + "in_vvd", ""));
		setItCusjTqty(JSPUtil.getParameter(request, prefix + "it_cusj_tqty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setInPod(JSPUtil.getParameter(request, prefix + "in_pod", ""));
		setIrDateM(JSPUtil.getParameter(request, prefix + "ir_date_m", ""));
		setCntrHoldRemark(JSPUtil.getParameter(request, prefix + "cntr_hold_remark", ""));
		setItLast(JSPUtil.getParameter(request, prefix + "it_last", ""));
		setMsgDesc(JSPUtil.getParameter(request, prefix + "msg_desc", ""));
		setRlseHldCd(JSPUtil.getParameter(request, prefix + "rlse_hld_cd", ""));
		setVslEngNmM(JSPUtil.getParameter(request, prefix + "vsl_eng_nm_m", ""));
		setIcrRemark1(JSPUtil.getParameter(request, prefix + "icr_remark1", ""));
		setLclBlNbrA(JSPUtil.getParameter(request, prefix + "lcl_bl_nbr_a", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRemark3(JSPUtil.getParameter(request, prefix + "remark3", ""));
		setInNvobl(JSPUtil.getParameter(request, prefix + "in_nvobl", ""));
		setRemark2(JSPUtil.getParameter(request, prefix + "remark2", ""));
		setInCodeb(JSPUtil.getParameter(request, prefix + "in_codeb", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setHblNo(JSPUtil.getParameter(request, prefix + "hbl_no", ""));
		setItCstmcind(JSPUtil.getParameter(request, prefix + "it_cstmcind", ""));
		setItCuswTqty(JSPUtil.getParameter(request, prefix + "it_cusw_tqty", ""));
		setInCntr(JSPUtil.getParameter(request, prefix + "in_cntr", ""));
		setIcrDate(JSPUtil.getParameter(request, prefix + "icr_date", ""));
		setAcpDate(JSPUtil.getParameter(request, prefix + "acp_date", ""));
		setHldCd(JSPUtil.getParameter(request, prefix + "hld_cd", ""));
		setSkdVoyNoM(JSPUtil.getParameter(request, prefix + "skd_voy_no_m", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setInBl(JSPUtil.getParameter(request, prefix + "in_bl", ""));
		setItQty(JSPUtil.getParameter(request, prefix + "it_qty", ""));
		setInCode(JSPUtil.getParameter(request, prefix + "in_code", ""));
		setPodLoc(JSPUtil.getParameter(request, prefix + "pod_loc", ""));
		setItCusrTqty(JSPUtil.getParameter(request, prefix + "it_cusr_tqty", ""));
		setVslCdM(JSPUtil.getParameter(request, prefix + "vsl_cd_m", ""));
		setIsfTranNo(JSPUtil.getParameter(request, prefix + "isf_tran_no", ""));
		setRcvMsgDtlSeq(JSPUtil.getParameter(request, prefix + "rcv_msg_dtl_seq", ""));
		setIcrEtTp(JSPUtil.getParameter(request, prefix + "icr_et_tp", ""));
		setIrType(JSPUtil.getParameter(request, prefix + "ir_type", ""));
		setMasterOrHouse(JSPUtil.getParameter(request, prefix + "master_or_house", ""));
		setIcrEtNo(JSPUtil.getParameter(request, prefix + "icr_et_no", ""));
		setIcrQty(JSPUtil.getParameter(request, prefix + "icr_qty", ""));
		setItHub(JSPUtil.getParameter(request, prefix + "it_hub", ""));
		setRcvMsg(JSPUtil.getParameter(request, prefix + "rcv_msg", ""));
		setIsfSeq(JSPUtil.getParameter(request, prefix + "isf_seq", ""));
		setRlseHldDt(JSPUtil.getParameter(request, prefix + "rlse_hld_dt", ""));
		setLocAmsPortCd(JSPUtil.getParameter(request, prefix + "loc_ams_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCusAmsport(JSPUtil.getParameter(request, prefix + "cus_amsport", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setItCgoCind(JSPUtil.getParameter(request, prefix + "it_cgo_cind", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setIbdRstUpdateFlg(JSPUtil.getParameter(request, prefix + "ibd_rst_update_flg", ""));
		setInSnp(JSPUtil.getParameter(request, prefix + "in_snp", ""));
		setPodAmsportM(JSPUtil.getParameter(request, prefix + "pod_amsport_m", ""));
		setHldDt(JSPUtil.getParameter(request, prefix + "hld_dt", ""));
		setPodAmsport(JSPUtil.getParameter(request, prefix + "pod_amsport", ""));
		setIcrResendInd(JSPUtil.getParameter(request, prefix + "icr_resend_ind", ""));
		setIsfInRemark1(JSPUtil.getParameter(request, prefix + "isf_in_remark1", ""));
		setPodLocM(JSPUtil.getParameter(request, prefix + "pod_loc_m", ""));
		setIsfInRemark2(JSPUtil.getParameter(request, prefix + "isf_in_remark2", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
		setCrrBatNo(JSPUtil.getParameter(request, prefix + "crr_bat_no", ""));
		setIrBatchNo(JSPUtil.getParameter(request, prefix + "ir_batch_no", ""));
		setCnruIt(JSPUtil.getParameter(request, prefix + "cnru_it", ""));
		setNewCntrCFlag(JSPUtil.getParameter(request, prefix + "new_cntr_c_flag", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setIcrCode(JSPUtil.getParameter(request, prefix + "icr_code", ""));
		setIrDate(JSPUtil.getParameter(request, prefix + "ir_date", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMblNo(JSPUtil.getParameter(request, prefix + "mbl_no", ""));
		setIrSeq(JSPUtil.getParameter(request, prefix + "ir_seq", ""));
		setIsfInBl(JSPUtil.getParameter(request, prefix + "isf_in_bl", ""));
		setIsfRcvCd(JSPUtil.getParameter(request, prefix + "isf_rcv_cd", ""));
		setIcrSeq(JSPUtil.getParameter(request, prefix + "icr_seq", ""));
		setCusLoc(JSPUtil.getParameter(request, prefix + "cus_loc", ""));
		setZone(JSPUtil.getParameter(request, prefix + "zone", ""));
		setInHjbl(JSPUtil.getParameter(request, prefix + "in_hjbl", ""));
		setIsBaplieRC(JSPUtil.getParameter(request, prefix + "is_baplie_rc", ""));
		setCstmsRmk1(JSPUtil.getParameter(request, prefix + "cstms_rmk1", ""));
		setAckResult(JSPUtil.getParameter(request, prefix + "ack_result", ""));
		setAckCode(JSPUtil.getParameter(request, prefix + "ack_code", ""));
		setAckDesc(JSPUtil.getParameter(request, prefix + "ack_desc", ""));
		setCntrOpr(JSPUtil.getParameter(request, prefix + "cntr_opr", ""));
		setErrResult(JSPUtil.getParameter(request, prefix + "err_result", ""));
		setErrCode(JSPUtil.getParameter(request, prefix + "err_code", ""));
		setErrDesc(JSPUtil.getParameter(request, prefix + "err_desc", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "cstms_loc_diff_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaRcvMsgVO[]
	 */
	public UsaRcvMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaRcvMsgVO[]
	 */
	public UsaRcvMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaRcvMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] itCusjTqty = (JSPUtil.getParameter(request, prefix	+ "it_cusj_tqty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] inPod = (JSPUtil.getParameter(request, prefix	+ "in_pod", length));
			String[] irDateM = (JSPUtil.getParameter(request, prefix	+ "ir_date_m", length));
			String[] cntrHoldRemark = (JSPUtil.getParameter(request, prefix	+ "cntr_hold_remark", length));
			String[] itLast = (JSPUtil.getParameter(request, prefix	+ "it_last", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] rlseHldCd = (JSPUtil.getParameter(request, prefix	+ "rlse_hld_cd", length));
			String[] vslEngNmM = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm_m", length));
			String[] icrRemark1 = (JSPUtil.getParameter(request, prefix	+ "icr_remark1", length));
			String[] lclBlNbrA = (JSPUtil.getParameter(request, prefix	+ "lcl_bl_nbr_a", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] remark3 = (JSPUtil.getParameter(request, prefix	+ "remark3", length));
			String[] inNvobl = (JSPUtil.getParameter(request, prefix	+ "in_nvobl", length));
			String[] remark2 = (JSPUtil.getParameter(request, prefix	+ "remark2", length));
			String[] inCodeb = (JSPUtil.getParameter(request, prefix	+ "in_codeb", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] itCstmcind = (JSPUtil.getParameter(request, prefix	+ "it_cstmcind", length));
			String[] itCuswTqty = (JSPUtil.getParameter(request, prefix	+ "it_cusw_tqty", length));
			String[] inCntr = (JSPUtil.getParameter(request, prefix	+ "in_cntr", length));
			String[] icrDate = (JSPUtil.getParameter(request, prefix	+ "icr_date", length));
			String[] acpDate = (JSPUtil.getParameter(request, prefix	+ "acp_date", length));
			String[] hldCd = (JSPUtil.getParameter(request, prefix	+ "hld_cd", length));
			String[] skdVoyNoM = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no_m", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] inBl = (JSPUtil.getParameter(request, prefix	+ "in_bl", length));
			String[] itQty = (JSPUtil.getParameter(request, prefix	+ "it_qty", length));
			String[] inCode = (JSPUtil.getParameter(request, prefix	+ "in_code", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] itCusrTqty = (JSPUtil.getParameter(request, prefix	+ "it_cusr_tqty", length));
			String[] vslCdM = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_m", length));
			String[] isfTranNo = (JSPUtil.getParameter(request, prefix	+ "isf_tran_no", length));
			String[] rcvMsgDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_dtl_seq", length));
			String[] icrEtTp = (JSPUtil.getParameter(request, prefix	+ "icr_et_tp", length));
			String[] irType = (JSPUtil.getParameter(request, prefix	+ "ir_type", length));
			String[] masterOrHouse = (JSPUtil.getParameter(request, prefix	+ "master_or_house", length));
			String[] icrEtNo = (JSPUtil.getParameter(request, prefix	+ "icr_et_no", length));
			String[] icrQty = (JSPUtil.getParameter(request, prefix	+ "icr_qty", length));
			String[] itHub = (JSPUtil.getParameter(request, prefix	+ "it_hub", length));
			String[] rcvMsg = (JSPUtil.getParameter(request, prefix	+ "rcv_msg", length));
			String[] isfSeq = (JSPUtil.getParameter(request, prefix	+ "isf_seq", length));
			String[] rlseHldDt = (JSPUtil.getParameter(request, prefix	+ "rlse_hld_dt", length));
			String[] locAmsPortCd = (JSPUtil.getParameter(request, prefix	+ "loc_ams_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cusAmsport = (JSPUtil.getParameter(request, prefix	+ "cus_amsport", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] itCgoCind = (JSPUtil.getParameter(request, prefix	+ "it_cgo_cind", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] ibdRstUpdateFlg = (JSPUtil.getParameter(request, prefix	+ "ibd_rst_update_flg", length));
			String[] inSnp = (JSPUtil.getParameter(request, prefix	+ "in_snp", length));
			String[] podAmsportM = (JSPUtil.getParameter(request, prefix	+ "pod_amsport_m", length));
			String[] hldDt = (JSPUtil.getParameter(request, prefix	+ "hld_dt", length));
			String[] podAmsport = (JSPUtil.getParameter(request, prefix	+ "pod_amsport", length));
			String[] icrResendInd = (JSPUtil.getParameter(request, prefix	+ "icr_resend_ind", length));
			String[] isfInRemark1 = (JSPUtil.getParameter(request, prefix	+ "isf_in_remark1", length));
			String[] podLocM = (JSPUtil.getParameter(request, prefix	+ "pod_loc_m", length));
			String[] isfInRemark2 = (JSPUtil.getParameter(request, prefix	+ "isf_in_remark2", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] crrBatNo = (JSPUtil.getParameter(request, prefix	+ "crr_bat_no", length));
			String[] irBatchNo = (JSPUtil.getParameter(request, prefix	+ "ir_batch_no", length));
			String[] cnruIt = (JSPUtil.getParameter(request, prefix	+ "cnru_it", length));
			String[] newCntrCFlag = (JSPUtil.getParameter(request, prefix	+ "new_cntr_c_flag", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] icrCode = (JSPUtil.getParameter(request, prefix	+ "icr_code", length));
			String[] irDate = (JSPUtil.getParameter(request, prefix	+ "ir_date", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mblNo = (JSPUtil.getParameter(request, prefix	+ "mbl_no", length));
			String[] irSeq = (JSPUtil.getParameter(request, prefix	+ "ir_seq", length));
			String[] isfInBl = (JSPUtil.getParameter(request, prefix	+ "isf_in_bl", length));
			String[] isfRcvCd = (JSPUtil.getParameter(request, prefix	+ "isf_rcv_cd", length));
			String[] icrSeq = (JSPUtil.getParameter(request, prefix	+ "icr_seq", length));
			String[] cusLoc = (JSPUtil.getParameter(request, prefix	+ "cus_loc", length));
			String[] zone = (JSPUtil.getParameter(request, prefix	+ "zone", length));
			String[] inHjbl = (JSPUtil.getParameter(request, prefix	+ "in_hjbl", length));
			String[] isBaplieRC = (JSPUtil.getParameter(request, prefix	+ "is_baplie_rc", length));
			String[] cstmsRmk1 = (JSPUtil.getParameter(request, prefix	+ "cstms_rmk1", length));
			String[] ackResult = (JSPUtil.getParameter(request, prefix	+ "ack_result", length));
			String[] ackCode = (JSPUtil.getParameter(request, prefix	+ "ack_code", length));
			String[] ackDesc = (JSPUtil.getParameter(request, prefix	+ "ack_desc", length));
			String[] cntrOpr = (JSPUtil.getParameter(request, prefix	+ "cntr_opr", length));
			String[] errResult = (JSPUtil.getParameter(request, prefix	+ "err_result", length));
			String[] errCode = (JSPUtil.getParameter(request, prefix	+ "err_code", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cstmsLocDiffFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_diff_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaRcvMsgVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (itCusjTqty[i] != null)
					model.setItCusjTqty(itCusjTqty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (inPod[i] != null)
					model.setInPod(inPod[i]);
				if (irDateM[i] != null)
					model.setIrDateM(irDateM[i]);
				if (cntrHoldRemark[i] != null)
					model.setCntrHoldRemark(cntrHoldRemark[i]);
				if (itLast[i] != null)
					model.setItLast(itLast[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (rlseHldCd[i] != null)
					model.setRlseHldCd(rlseHldCd[i]);
				if (vslEngNmM[i] != null)
					model.setVslEngNmM(vslEngNmM[i]);
				if (icrRemark1[i] != null)
					model.setIcrRemark1(icrRemark1[i]);
				if (lclBlNbrA[i] != null)
					model.setLclBlNbrA(lclBlNbrA[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (remark3[i] != null)
					model.setRemark3(remark3[i]);
				if (inNvobl[i] != null)
					model.setInNvobl(inNvobl[i]);
				if (remark2[i] != null)
					model.setRemark2(remark2[i]);
				if (inCodeb[i] != null)
					model.setInCodeb(inCodeb[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (itCstmcind[i] != null)
					model.setItCstmcind(itCstmcind[i]);
				if (itCuswTqty[i] != null)
					model.setItCuswTqty(itCuswTqty[i]);
				if (inCntr[i] != null)
					model.setInCntr(inCntr[i]);
				if (icrDate[i] != null)
					model.setIcrDate(icrDate[i]);
				if (acpDate[i] != null)
					model.setAcpDate(acpDate[i]);
				if (hldCd[i] != null)
					model.setHldCd(hldCd[i]);
				if (skdVoyNoM[i] != null)
					model.setSkdVoyNoM(skdVoyNoM[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (inBl[i] != null)
					model.setInBl(inBl[i]);
				if (itQty[i] != null)
					model.setItQty(itQty[i]);
				if (inCode[i] != null)
					model.setInCode(inCode[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (itCusrTqty[i] != null)
					model.setItCusrTqty(itCusrTqty[i]);
				if (vslCdM[i] != null)
					model.setVslCdM(vslCdM[i]);
				if (isfTranNo[i] != null)
					model.setIsfTranNo(isfTranNo[i]);
				if (rcvMsgDtlSeq[i] != null)
					model.setRcvMsgDtlSeq(rcvMsgDtlSeq[i]);
				if (icrEtTp[i] != null)
					model.setIcrEtTp(icrEtTp[i]);
				if (irType[i] != null)
					model.setIrType(irType[i]);
				if (masterOrHouse[i] != null)
					model.setMasterOrHouse(masterOrHouse[i]);
				if (icrEtNo[i] != null)
					model.setIcrEtNo(icrEtNo[i]);
				if (icrQty[i] != null)
					model.setIcrQty(icrQty[i]);
				if (itHub[i] != null)
					model.setItHub(itHub[i]);
				if (rcvMsg[i] != null)
					model.setRcvMsg(rcvMsg[i]);
				if (isfSeq[i] != null)
					model.setIsfSeq(isfSeq[i]);
				if (rlseHldDt[i] != null)
					model.setRlseHldDt(rlseHldDt[i]);
				if (locAmsPortCd[i] != null)
					model.setLocAmsPortCd(locAmsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cusAmsport[i] != null)
					model.setCusAmsport(cusAmsport[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (itCgoCind[i] != null)
					model.setItCgoCind(itCgoCind[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (ibdRstUpdateFlg[i] != null)
					model.setIbdRstUpdateFlg(ibdRstUpdateFlg[i]);
				if (inSnp[i] != null)
					model.setInSnp(inSnp[i]);
				if (podAmsportM[i] != null)
					model.setPodAmsportM(podAmsportM[i]);
				if (hldDt[i] != null)
					model.setHldDt(hldDt[i]);
				if (podAmsport[i] != null)
					model.setPodAmsport(podAmsport[i]);
				if (icrResendInd[i] != null)
					model.setIcrResendInd(icrResendInd[i]);
				if (isfInRemark1[i] != null)
					model.setIsfInRemark1(isfInRemark1[i]);
				if (podLocM[i] != null)
					model.setPodLocM(podLocM[i]);
				if (isfInRemark2[i] != null)
					model.setIsfInRemark2(isfInRemark2[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (crrBatNo[i] != null)
					model.setCrrBatNo(crrBatNo[i]);
				if (irBatchNo[i] != null)
					model.setIrBatchNo(irBatchNo[i]);
				if (cnruIt[i] != null)
					model.setCnruIt(cnruIt[i]);
				if (newCntrCFlag[i] != null)
					model.setNewCntrCFlag(newCntrCFlag[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (icrCode[i] != null)
					model.setIcrCode(icrCode[i]);
				if (irDate[i] != null)
					model.setIrDate(irDate[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mblNo[i] != null)
					model.setMblNo(mblNo[i]);
				if (irSeq[i] != null)
					model.setIrSeq(irSeq[i]);
				if (isfInBl[i] != null)
					model.setIsfInBl(isfInBl[i]);
				if (isfRcvCd[i] != null)
					model.setIsfRcvCd(isfRcvCd[i]);
				if (icrSeq[i] != null)
					model.setIcrSeq(icrSeq[i]);
				if (cusLoc[i] != null)
					model.setCusLoc(cusLoc[i]);
				if (zone[i] != null)
					model.setZone(zone[i]);
				if (inHjbl[i] != null)
					model.setInHjbl(inHjbl[i]);
				if (isBaplieRC[i] != null)
					model.setIsBaplieRC(isBaplieRC[i]);
				if (cstmsRmk1[i] != null)
					model.setCstmsRmk1(cstmsRmk1[i]);
				if (ackResult[i] != null)
					model.setAckResult(ackResult[i]);
				if (ackCode[i] != null)
					model.setAckCode(ackCode[i]);
				if (ackDesc[i] != null)
					model.setAckDesc(ackDesc[i]);
				if (cntrOpr[i] != null)
					model.setCntrOpr(cntrOpr[i]);
				if (errResult[i] != null)
					model.setErrResult(errResult[i]);
				if (errCode[i] != null)
					model.setErrCode(errCode[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cstmsLocDiffFlg[i] != null)
					model.setCstmsLocDiffFlg(cstmsLocDiffFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaRcvMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaRcvMsgVO[]
	 */
	public UsaRcvMsgVO[] getUsaRcvMsgVOs(){
		UsaRcvMsgVO[] vos = (UsaRcvMsgVO[])models.toArray(new UsaRcvMsgVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCusjTqty = this.itCusjTqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPod = this.inPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irDateM = this.irDateM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHoldRemark = this.cntrHoldRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itLast = this.itLast .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseHldCd = this.rlseHldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNmM = this.vslEngNmM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icrRemark1 = this.icrRemark1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclBlNbrA = this.lclBlNbrA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark3 = this.remark3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inNvobl = this.inNvobl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark2 = this.remark2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCodeb = this.inCodeb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCstmcind = this.itCstmcind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCuswTqty = this.itCuswTqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntr = this.inCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icrDate = this.icrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acpDate = this.acpDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldCd = this.hldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNoM = this.skdVoyNoM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBl = this.inBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itQty = this.itQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCode = this.inCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCusrTqty = this.itCusrTqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdM = this.vslCdM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfTranNo = this.isfTranNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsgDtlSeq = this.rcvMsgDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icrEtTp = this.icrEtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irType = this.irType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masterOrHouse = this.masterOrHouse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icrEtNo = this.icrEtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icrQty = this.icrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itHub = this.itHub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsg = this.rcvMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfSeq = this.isfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseHldDt = this.rlseHldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locAmsPortCd = this.locAmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusAmsport = this.cusAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCgoCind = this.itCgoCind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdRstUpdateFlg = this.ibdRstUpdateFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSnp = this.inSnp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsportM = this.podAmsportM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldDt = this.hldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsport = this.podAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icrResendInd = this.icrResendInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfInRemark1 = this.isfInRemark1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocM = this.podLocM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfInRemark2 = this.isfInRemark2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBatNo = this.crrBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irBatchNo = this.irBatchNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnruIt = this.cnruIt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCntrCFlag = this.newCntrCFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icrCode = this.icrCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irDate = this.irDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblNo = this.mblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irSeq = this.irSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfInBl = this.isfInBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfRcvCd = this.isfRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icrSeq = this.icrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusLoc = this.cusLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zone = this.zone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inHjbl = this.inHjbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isBaplieRC = this.isBaplieRC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRmk1 = this.cstmsRmk1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackResult = this.ackResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackCode = this.ackCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDesc = this.ackDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOpr = this.cntrOpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errResult = this.errResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCode = this.errCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsLocDiffFlg = this.cstmsLocDiffFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	private List<CstmsHldVO> cstmsHlds = null;
	public void setCstmsHldVOs(List<CstmsHldVO> cstmsHlds) {
		this.cstmsHlds = cstmsHlds;
	}	
	public List<CstmsHldVO> getCstmsHldVOs() {
		return this.cstmsHlds;
	}
	private List<CstmsClrVO> cstmsClrs = null;
	public void setCstmsClrVOs(List<CstmsClrVO> cstmsClrs) {
		this.cstmsClrs = cstmsClrs;
	}	
	public List<CstmsClrVO> getCstmsClrVOs() {
		return this.cstmsClrs;
	}
	private List<CstmsHldVO> cstmsHldSends = null;
	public void setCstmsHldSendVOs(List<CstmsHldVO> cstmsHldSends) {
		this.cstmsHldSends = cstmsHldSends;
	}	
	public List<CstmsHldVO> getCstmsHldSendVOs() {
		return this.cstmsHldSends;
	}
	private List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs = null;
	public void setBkgCstmsAdvIbdVOs(List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs) {
		this.bkgCstmsAdvIbdVOs = bkgCstmsAdvIbdVOs;
	}
	public List<BkgCstmsAdvIbdVO> getBkgCstmsAdvIbdVOs() {
		return this.bkgCstmsAdvIbdVOs;
	}
}
