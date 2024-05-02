/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorAckMsgVO.java
*@FileTitle : KorAckMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.06  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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

public class KorAckMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorAckMsgVO> models = new ArrayList<KorAckMsgVO>();
	
	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String ediRcvrNm = null;
	/* Column Info */
	private String arrYr = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String msgLogTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String krCstmsRjctRsn2 = null;
	/* Column Info */
	private String krCstmsRjctRsn1 = null;
	/* Column Info */
	private String cstmsRefNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String krVslCallSgnCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String krCstmsAcptCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KorAckMsgVO() {}

	public KorAckMsgVO(String ibflag, String pagerows, String smtAmdNo, String rcvDt, String userId, String krCstmsAcptCd, String fltFileRefNo, String rcvSeq, String msgLogTpCd, String blNo, String ediRcvrNm, String tmlCd, String krVslCallSgnCd, String arrYr, String callKnt, String cstmsRefNm, String krCstmsRjctRsn1, String krCstmsRjctRsn2) {
		this.smtAmdNo = smtAmdNo;
		this.ediRcvrNm = ediRcvrNm;
		this.arrYr = arrYr;
		this.fltFileRefNo = fltFileRefNo;
		this.rcvSeq = rcvSeq;
		this.msgLogTpCd = msgLogTpCd;
		this.blNo = blNo;
		this.tmlCd = tmlCd;
		this.krCstmsRjctRsn2 = krCstmsRjctRsn2;
		this.krCstmsRjctRsn1 = krCstmsRjctRsn1;
		this.cstmsRefNm = cstmsRefNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.krVslCallSgnCd = krVslCallSgnCd;
		this.rcvDt = rcvDt;
		this.userId = userId;
		this.callKnt = callKnt;
		this.krCstmsAcptCd = krCstmsAcptCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("edi_rcvr_nm", getEdiRcvrNm());
		this.hashColumns.put("arr_yr", getArrYr());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("msg_log_tp_cd", getMsgLogTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("kr_cstms_rjct_rsn2", getKrCstmsRjctRsn2());
		this.hashColumns.put("kr_cstms_rjct_rsn1", getKrCstmsRjctRsn1());
		this.hashColumns.put("cstms_ref_nm", getCstmsRefNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("kr_vsl_call_sgn_cd", getKrVslCallSgnCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("kr_cstms_acpt_cd", getKrCstmsAcptCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("edi_rcvr_nm", "ediRcvrNm");
		this.hashFields.put("arr_yr", "arrYr");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("msg_log_tp_cd", "msgLogTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("kr_cstms_rjct_rsn2", "krCstmsRjctRsn2");
		this.hashFields.put("kr_cstms_rjct_rsn1", "krCstmsRjctRsn1");
		this.hashFields.put("cstms_ref_nm", "cstmsRefNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("kr_vsl_call_sgn_cd", "krVslCallSgnCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("kr_cstms_acpt_cd", "krCstmsAcptCd");
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
	 * @return ediRcvrNm
	 */
	public String getEdiRcvrNm() {
		return this.ediRcvrNm;
	}
	
	/**
	 * Column Info
	 * @return arrYr
	 */
	public String getArrYr() {
		return this.arrYr;
	}
	
	/**
	 * Column Info
	 * @return fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return this.fltFileRefNo;
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
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return krCstmsRjctRsn2
	 */
	public String getKrCstmsRjctRsn2() {
		return this.krCstmsRjctRsn2;
	}
	
	/**
	 * Column Info
	 * @return krCstmsRjctRsn1
	 */
	public String getKrCstmsRjctRsn1() {
		return this.krCstmsRjctRsn1;
	}
	
	/**
	 * Column Info
	 * @return cstmsRefNm
	 */
	public String getCstmsRefNm() {
		return this.cstmsRefNm;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return krVslCallSgnCd
	 */
	public String getKrVslCallSgnCd() {
		return this.krVslCallSgnCd;
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
	 * @return callKnt
	 */
	public String getCallKnt() {
		return this.callKnt;
	}
	
	/**
	 * Column Info
	 * @return krCstmsAcptCd
	 */
	public String getKrCstmsAcptCd() {
		return this.krCstmsAcptCd;
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
	 * @param ediRcvrNm
	 */
	public void setEdiRcvrNm(String ediRcvrNm) {
		this.ediRcvrNm = ediRcvrNm;
	}
	
	/**
	 * Column Info
	 * @param arrYr
	 */
	public void setArrYr(String arrYr) {
		this.arrYr = arrYr;
	}
	
	/**
	 * Column Info
	 * @param fltFileRefNo
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
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
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param krCstmsRjctRsn2
	 */
	public void setKrCstmsRjctRsn2(String krCstmsRjctRsn2) {
		this.krCstmsRjctRsn2 = krCstmsRjctRsn2;
	}
	
	/**
	 * Column Info
	 * @param krCstmsRjctRsn1
	 */
	public void setKrCstmsRjctRsn1(String krCstmsRjctRsn1) {
		this.krCstmsRjctRsn1 = krCstmsRjctRsn1;
	}
	
	/**
	 * Column Info
	 * @param cstmsRefNm
	 */
	public void setCstmsRefNm(String cstmsRefNm) {
		this.cstmsRefNm = cstmsRefNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param krVslCallSgnCd
	 */
	public void setKrVslCallSgnCd(String krVslCallSgnCd) {
		this.krVslCallSgnCd = krVslCallSgnCd;
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
	
	/**
	 * Column Info
	 * @param callKnt
	 */
	public void setCallKnt(String callKnt) {
		this.callKnt = callKnt;
	}
	
	/**
	 * Column Info
	 * @param krCstmsAcptCd
	 */
	public void setKrCstmsAcptCd(String krCstmsAcptCd) {
		this.krCstmsAcptCd = krCstmsAcptCd;
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
		setSmtAmdNo(JSPUtil.getParameter(request, prefix + "smt_amd_no", ""));
		setEdiRcvrNm(JSPUtil.getParameter(request, prefix + "edi_rcvr_nm", ""));
		setArrYr(JSPUtil.getParameter(request, prefix + "arr_yr", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setMsgLogTpCd(JSPUtil.getParameter(request, prefix + "msg_log_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setKrCstmsRjctRsn2(JSPUtil.getParameter(request, prefix + "kr_cstms_rjct_rsn2", ""));
		setKrCstmsRjctRsn1(JSPUtil.getParameter(request, prefix + "kr_cstms_rjct_rsn1", ""));
		setCstmsRefNm(JSPUtil.getParameter(request, prefix + "cstms_ref_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setKrVslCallSgnCd(JSPUtil.getParameter(request, prefix + "kr_vsl_call_sgn_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCallKnt(JSPUtil.getParameter(request, prefix + "call_knt", ""));
		setKrCstmsAcptCd(JSPUtil.getParameter(request, prefix + "kr_cstms_acpt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorAckMsgVO[]
	 */
	public KorAckMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorAckMsgVO[]
	 */
	public KorAckMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorAckMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] ediRcvrNm = (JSPUtil.getParameter(request, prefix	+ "edi_rcvr_nm", length));
			String[] arrYr = (JSPUtil.getParameter(request, prefix	+ "arr_yr", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] msgLogTpCd = (JSPUtil.getParameter(request, prefix	+ "msg_log_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] krCstmsRjctRsn2 = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_rjct_rsn2", length));
			String[] krCstmsRjctRsn1 = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_rjct_rsn1", length));
			String[] cstmsRefNm = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] krVslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "kr_vsl_call_sgn_cd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] krCstmsAcptCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_acpt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorAckMsgVO();
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (ediRcvrNm[i] != null)
					model.setEdiRcvrNm(ediRcvrNm[i]);
				if (arrYr[i] != null)
					model.setArrYr(arrYr[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (msgLogTpCd[i] != null)
					model.setMsgLogTpCd(msgLogTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (krCstmsRjctRsn2[i] != null)
					model.setKrCstmsRjctRsn2(krCstmsRjctRsn2[i]);
				if (krCstmsRjctRsn1[i] != null)
					model.setKrCstmsRjctRsn1(krCstmsRjctRsn1[i]);
				if (cstmsRefNm[i] != null)
					model.setCstmsRefNm(cstmsRefNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (krVslCallSgnCd[i] != null)
					model.setKrVslCallSgnCd(krVslCallSgnCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (krCstmsAcptCd[i] != null)
					model.setKrCstmsAcptCd(krCstmsAcptCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorAckMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorAckMsgVO[]
	 */
	public KorAckMsgVO[] getKorAckMsgVOs(){
		KorAckMsgVO[] vos = (KorAckMsgVO[])models.toArray(new KorAckMsgVO[models.size()]);
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
		this.ediRcvrNm = this.ediRcvrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrYr = this.arrYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgLogTpCd = this.msgLogTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsRjctRsn2 = this.krCstmsRjctRsn2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsRjctRsn1 = this.krCstmsRjctRsn1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefNm = this.cstmsRefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krVslCallSgnCd = this.krVslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsAcptCd = this.krCstmsAcptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
