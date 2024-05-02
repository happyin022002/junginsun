/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdvJpReceiveLogVO.java
*@FileTitle : AdvJpReceiveLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier :
*@LastVersion : 1.0
* 2015.08.20
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdvJpReceiveLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AdvJpReceiveLogVO> models = new ArrayList<AdvJpReceiveLogVO>();

	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String jpBatNo = null;
	/* Column Info */
	private String rlxDiv = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ibCssmVoyNo = null;
	/* Column Info */
	private String jpSvcId = null;
	/* Column Info */
	private String jpMsgTpId = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String msgRcvNo = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String ediRefId = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ediRcvMsgCtnt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rcvKeyDatCtnt = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String hblDiv = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public AdvJpReceiveLogVO() {}

	public AdvJpReceiveLogVO(String ibflag, String pagerows, String bkgNo, String callSgnNo, String ediRcvMsgCtnt, String ediRefId, String hblDiv, String hblNo, String ibCssmVoyNo, String jpBatNo, String jpMsgTpId, String jpSvcId, String msgRcvNo, String podCd, String polCd, String porCd, String rcvKeyDatCtnt, String rcvSeq, String rlxDiv, String skdDirCd, String skdVoyNo, String usrId, String vslCd) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.jpBatNo = jpBatNo;
		this.rlxDiv = rlxDiv;
		this.callSgnNo = callSgnNo;
		this.ibCssmVoyNo = ibCssmVoyNo;
		this.jpSvcId = jpSvcId;
		this.jpMsgTpId = jpMsgTpId;
		this.skdVoyNo = skdVoyNo;
		this.msgRcvNo = msgRcvNo;
		this.rcvSeq = rcvSeq;
		this.ediRefId = ediRefId;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.ediRcvMsgCtnt = ediRcvMsgCtnt;
		this.usrId = usrId;
		this.rcvKeyDatCtnt = rcvKeyDatCtnt;
		this.hblNo = hblNo;
		this.hblDiv = hblDiv;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("jp_bat_no", getJpBatNo());
		this.hashColumns.put("rlx_div", getRlxDiv());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
		this.hashColumns.put("jp_svc_id", getJpSvcId());
		this.hashColumns.put("jp_msg_tp_id", getJpMsgTpId());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("msg_rcv_no", getMsgRcvNo());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("edi_ref_id", getEdiRefId());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("edi_rcv_msg_ctnt", getEdiRcvMsgCtnt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rcv_key_dat_ctnt", getRcvKeyDatCtnt());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("hbl_div", getHblDiv());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("jp_bat_no", "jpBatNo");
		this.hashFields.put("rlx_div", "rlxDiv");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
		this.hashFields.put("jp_svc_id", "jpSvcId");
		this.hashFields.put("jp_msg_tp_id", "jpMsgTpId");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("msg_rcv_no", "msgRcvNo");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("edi_ref_id", "ediRefId");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("edi_rcv_msg_ctnt", "ediRcvMsgCtnt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rcv_key_dat_ctnt", "rcvKeyDatCtnt");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("hbl_div", "hblDiv");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return jpBatNo
	 */
	public String getJpBatNo() {
		return this.jpBatNo;
	}

	/**
	 * Column Info
	 * @return rlxDiv
	 */
	public String getRlxDiv() {
		return this.rlxDiv;
	}

	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}

	/**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
	public String getIbCssmVoyNo() {
		return this.ibCssmVoyNo;
	}

	/**
	 * Column Info
	 * @return jpSvcId
	 */
	public String getJpSvcId() {
		return this.jpSvcId;
	}

	/**
	 * Column Info
	 * @return jpMsgTpId
	 */
	public String getJpMsgTpId() {
		return this.jpMsgTpId;
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
	 * @return msgRcvNo
	 */
	public String getMsgRcvNo() {
		return this.msgRcvNo;
	}

	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}

	/**
	 * Column Info
	 * @return ediRefId
	 */
	public String getEdiRefId() {
		return this.ediRefId;
	}

	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return ediRcvMsgCtnt
	 */
	public String getEdiRcvMsgCtnt() {
		return this.ediRcvMsgCtnt;
	}

	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return rcvKeyDatCtnt
	 */
	public String getRcvKeyDatCtnt() {
		return this.rcvKeyDatCtnt;
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
	 * @return hblDiv
	 */
	public String getHblDiv() {
		return this.hblDiv;
	}


	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param jpBatNo
	 */
	public void setJpBatNo(String jpBatNo) {
		this.jpBatNo = jpBatNo;
	}

	/**
	 * Column Info
	 * @param rlxDiv
	 */
	public void setRlxDiv(String rlxDiv) {
		this.rlxDiv = rlxDiv;
	}

	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}

	/**
	 * Column Info
	 * @param ibCssmVoyNo
	 */
	public void setIbCssmVoyNo(String ibCssmVoyNo) {
		this.ibCssmVoyNo = ibCssmVoyNo;
	}

	/**
	 * Column Info
	 * @param jpSvcId
	 */
	public void setJpSvcId(String jpSvcId) {
		this.jpSvcId = jpSvcId;
	}

	/**
	 * Column Info
	 * @param jpMsgTpId
	 */
	public void setJpMsgTpId(String jpMsgTpId) {
		this.jpMsgTpId = jpMsgTpId;
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
	 * @param msgRcvNo
	 */
	public void setMsgRcvNo(String msgRcvNo) {
		this.msgRcvNo = msgRcvNo;
	}

	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}

	/**
	 * Column Info
	 * @param ediRefId
	 */
	public void setEdiRefId(String ediRefId) {
		this.ediRefId = ediRefId;
	}

	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param ediRcvMsgCtnt
	 */
	public void setEdiRcvMsgCtnt(String ediRcvMsgCtnt) {
		this.ediRcvMsgCtnt = ediRcvMsgCtnt;
	}

	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param rcvKeyDatCtnt
	 */
	public void setRcvKeyDatCtnt(String rcvKeyDatCtnt) {
		this.rcvKeyDatCtnt = rcvKeyDatCtnt;
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
	 * @param hblDiv
	 */
	public void setHblDiv(String hblDiv) {
		this.hblDiv = hblDiv;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setJpBatNo(JSPUtil.getParameter(request, prefix + "jp_bat_no", ""));
		setRlxDiv(JSPUtil.getParameter(request, prefix + "rlx_div", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
		setJpSvcId(JSPUtil.getParameter(request, prefix + "jp_svc_id", ""));
		setJpMsgTpId(JSPUtil.getParameter(request, prefix + "jp_msg_tp_id", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setMsgRcvNo(JSPUtil.getParameter(request, prefix + "msg_rcv_no", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setEdiRefId(JSPUtil.getParameter(request, prefix + "edi_ref_id", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setEdiRcvMsgCtnt(JSPUtil.getParameter(request, prefix + "edi_rcv_msg_ctnt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setRcvKeyDatCtnt(JSPUtil.getParameter(request, prefix + "rcv_key_dat_ctnt", ""));
		setHblNo(JSPUtil.getParameter(request, prefix + "hbl_no", ""));
		setHblDiv(JSPUtil.getParameter(request, prefix + "hbl_div", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdvJpReceiveLogVO[]
	 */
	public AdvJpReceiveLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AdvJpReceiveLogVO[]
	 */
	public AdvJpReceiveLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdvJpReceiveLogVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] jpBatNo = (JSPUtil.getParameter(request, prefix	+ "jp_bat_no", length));
			String[] rlxDiv = (JSPUtil.getParameter(request, prefix	+ "rlx_div", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_cssm_voy_no", length));
			String[] jpSvcId = (JSPUtil.getParameter(request, prefix	+ "jp_svc_id", length));
			String[] jpMsgTpId = (JSPUtil.getParameter(request, prefix	+ "jp_msg_tp_id", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] msgRcvNo = (JSPUtil.getParameter(request, prefix	+ "msg_rcv_no", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] ediRefId = (JSPUtil.getParameter(request, prefix	+ "edi_ref_id", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ediRcvMsgCtnt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_msg_ctnt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] rcvKeyDatCtnt = (JSPUtil.getParameter(request, prefix	+ "rcv_key_dat_ctnt", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] hblDiv = (JSPUtil.getParameter(request, prefix	+ "hbl_div", length));

			for (int i = 0; i < length; i++) {
				model = new AdvJpReceiveLogVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (jpBatNo[i] != null)
					model.setJpBatNo(jpBatNo[i]);
				if (rlxDiv[i] != null)
					model.setRlxDiv(rlxDiv[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ibCssmVoyNo[i] != null)
					model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (jpSvcId[i] != null)
					model.setJpSvcId(jpSvcId[i]);
				if (jpMsgTpId[i] != null)
					model.setJpMsgTpId(jpMsgTpId[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (msgRcvNo[i] != null)
					model.setMsgRcvNo(msgRcvNo[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (ediRefId[i] != null)
					model.setEdiRefId(ediRefId[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ediRcvMsgCtnt[i] != null)
					model.setEdiRcvMsgCtnt(ediRcvMsgCtnt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rcvKeyDatCtnt[i] != null)
					model.setRcvKeyDatCtnt(rcvKeyDatCtnt[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (hblDiv[i] != null)
					model.setHblDiv(hblDiv[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdvJpReceiveLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdvJpReceiveLogVO[]
	 */
	public AdvJpReceiveLogVO[] getAdvJpReceiveLogVOs(){
		AdvJpReceiveLogVO[] vos = (AdvJpReceiveLogVO[])models.toArray(new AdvJpReceiveLogVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpBatNo = this.jpBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlxDiv = this.rlxDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNo = this.ibCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpSvcId = this.jpSvcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpMsgTpId = this.jpMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRcvNo = this.msgRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRefId = this.ediRefId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvMsgCtnt = this.ediRcvMsgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvKeyDatCtnt = this.rcvKeyDatCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblDiv = this.hblDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
