/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorRcvHistVO.java
*@FileTitle : KorRcvHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.14 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see RcvHistVO
 */

public class KorRcvHistVO extends RcvHistVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorRcvHistVO> models = new ArrayList<KorRcvHistVO>();

	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String msgLogTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String msgText = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String msgSts = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String ediRcvrNm = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String krVslCallSgnCd = null;
	/* Column Info */
	private String arrYr = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String cstmsRefNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorRcvHistVO() {}

	public KorRcvHistVO(String ibflag, String pagerows, String msgLogTpCd, String rcvDt, String vvd, String polCd, String podCd, String ofcCd, String blNo, String smtAmdNo, String msgSts, String msgText, String userId, String ediRcvrNm, String tmlCd, String krVslCallSgnCd, String arrYr, String callKnt, String cstmsRefNm) {
		this.smtAmdNo = smtAmdNo;
		this.msgLogTpCd = msgLogTpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.msgText = msgText;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.msgSts = msgSts;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.rcvDt = rcvDt;
		this.userId = userId;
		this.ediRcvrNm = ediRcvrNm;
		this.tmlCd = tmlCd;
		this.krVslCallSgnCd = krVslCallSgnCd;
		this.arrYr = arrYr;
		this.callKnt = callKnt;
		this.cstmsRefNm = cstmsRefNm;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("msg_log_tp_cd", getMsgLogTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("msg_text", getMsgText());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("msg_sts", getMsgSts());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("edi_rcvr_nm", getEdiRcvrNm());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("kr_vsl_call_sgn_cd", getKrVslCallSgnCd());
		this.hashColumns.put("arr_yr", getArrYr());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("cstms_ref_nm", getCstmsRefNm());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("msg_log_tp_cd", "msgLogTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("msg_text", "msgText");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("msg_sts", "msgSts");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("edi_rcvr_nm", "ediRcvrNm");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("kr_vsl_call_sgn_cd", "krVslCallSgnCd");
		this.hashFields.put("arr_yr", "arrYr");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("cstms_ref_nm", "cstmsRefNm");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return smtAmdNo
	 */
	public String getSmtAmdNo() {
		return this.smtAmdNo;
	}

	/**
	 * Column Info
	 * @return msgLogTpCd
	 */
	public String getMsgLogTpCd() {
		return this.msgLogTpCd;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return msgText
	 */
	public String getMsgText() {
		return this.msgText;
	}

	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}

	/**
	 * Column Info
	 * @return msgSts
	 */
	public String getMsgSts() {
		return this.msgSts;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}

	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}


	/**
	 * Column Info
	 * @param smtAmdNo
	 */
	public void setSmtAmdNo(String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
	}

	/**
	 * Column Info
	 * @param msgLogTpCd
	 */
	public void setMsgLogTpCd(String msgLogTpCd) {
		this.msgLogTpCd = msgLogTpCd;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param msgText
	 */
	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * Column Info
	 * @param msgSts
	 */
	public void setMsgSts(String msgSts) {
		this.msgSts = msgSts;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}

	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEdiRcvrNm() {
		return ediRcvrNm;
	}

	public void setEdiRcvrNm(String ediRcvrNm) {
		this.ediRcvrNm = ediRcvrNm;
	}

	public String getTmlCd() {
		return tmlCd;
	}

	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}

	public String getKrVslCallSgnCd() {
		return krVslCallSgnCd;
	}

	public void setKrVslCallSgnCd(String krVslCallSgnCd) {
		this.krVslCallSgnCd = krVslCallSgnCd;
	}

	public String getArrYr() {
		return arrYr;
	}

	public void setArrYr(String arrYr) {
		this.arrYr = arrYr;
	}

	public String getCallKnt() {
		return callKnt;
	}

	public void setCallKnt(String callKnt) {
		this.callKnt = callKnt;
	}

	public String getCstmsRefNm() {
		return cstmsRefNm;
	}

	public void setCstmsRefNm(String cstmsRefNm) {
		this.cstmsRefNm = cstmsRefNm;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSmtAmdNo(JSPUtil.getParameter(request, "smt_amd_no", ""));
		setMsgLogTpCd(JSPUtil.getParameter(request, "msg_log_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMsgText(JSPUtil.getParameter(request, "msg_text", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setMsgSts(JSPUtil.getParameter(request, "msg_sts", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setEdiRcvrNm(JSPUtil.getParameter(request, "edi_rcvr_nm", ""));
		setTmlCd(JSPUtil.getParameter(request, "tml_cd", ""));
		setKrVslCallSgnCd(JSPUtil.getParameter(request, "kr_vsl_call_sgn_cd", ""));
		setArrYr(JSPUtil.getParameter(request, "arr_yr", ""));
		setCallKnt(JSPUtil.getParameter(request, "call_knt", ""));
		setCstmsRefNm(JSPUtil.getParameter(request, "cstms_ref_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorRcvHistVO[]
	 */
	public KorRcvHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorRcvHistVO[]
	 */
	public KorRcvHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorRcvHistVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] msgLogTpCd = (JSPUtil.getParameter(request, prefix	+ "msg_log_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] msgText = (JSPUtil.getParameter(request, prefix	+ "msg_text", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] msgSts = (JSPUtil.getParameter(request, prefix	+ "msg_sts", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] ediRcvrNm = (JSPUtil.getParameter(request, prefix	+ "edi_rcvr_nm", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] krVslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "kr_vsl_call_sgn_cd", length));
			String[] arrYr = (JSPUtil.getParameter(request, prefix	+ "arr_yr", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] cstmsRefNm = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_nm", length));

			for (int i = 0; i < length; i++) {
				model = new KorRcvHistVO();
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (msgLogTpCd[i] != null)
					model.setMsgLogTpCd(msgLogTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (msgText[i] != null)
					model.setMsgText(msgText[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (msgSts[i] != null)
					model.setMsgSts(msgSts[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (ediRcvrNm[i] != null)
					model.setEdiRcvrNm(ediRcvrNm[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (krVslCallSgnCd[i] != null)
					model.setKrVslCallSgnCd(krVslCallSgnCd[i]);
				if (arrYr[i] != null)
					model.setArrYr(arrYr[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (cstmsRefNm[i] != null)
					model.setCstmsRefNm(cstmsRefNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorRcvHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorRcvHistVO[]
	 */
	public KorRcvHistVO[] getKorRcvHistVOs(){
		KorRcvHistVO[] vos = (KorRcvHistVO[])models.toArray(new KorRcvHistVO[models.size()]);
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
		this.smtAmdNo = this.smtAmdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgLogTpCd = this.msgLogTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgText = this.msgText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSts = this.msgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvrNm = this.ediRcvrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krVslCallSgnCd = this.krVslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrYr = this.arrYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefNm = this.cstmsRefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
