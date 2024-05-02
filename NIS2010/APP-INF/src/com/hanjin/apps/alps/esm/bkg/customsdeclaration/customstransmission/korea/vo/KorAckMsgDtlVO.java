/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorAckMsgDtlVO.java
*@FileTitle : KorAckMsgDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.13 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorAckMsgDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorAckMsgDtlVO> models = new ArrayList<KorAckMsgDtlVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediRcvMsg = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String logDtlSeq = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String msgLogTpCd = null;
	/* Column Info */
	private String krCstmsRjctRsn2 = null;
	/* Column Info */
	private String krCstmsRjctRsn1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorAckMsgDtlVO() {}

	public KorAckMsgDtlVO(String ibflag, String pagerows, String msgLogTpCd, String rcvDt, String rcvSeq, String fltFileRefNo, String logDtlSeq, String ediRcvMsg, String krCstmsRjctRsn1, String krCstmsRjctRsn2, String userId) {
		this.ibflag = ibflag;
		this.ediRcvMsg = ediRcvMsg;
		this.rcvDt = rcvDt;
		this.userId = userId;
		this.logDtlSeq = logDtlSeq;
		this.fltFileRefNo = fltFileRefNo;
		this.rcvSeq = rcvSeq;
		this.msgLogTpCd = msgLogTpCd;
		this.krCstmsRjctRsn2 = krCstmsRjctRsn2;
		this.krCstmsRjctRsn1 = krCstmsRjctRsn1;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_rcv_msg", getEdiRcvMsg());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("log_dtl_seq", getLogDtlSeq());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("msg_log_tp_cd", getMsgLogTpCd());
		this.hashColumns.put("kr_cstms_rjct_rsn2", getKrCstmsRjctRsn2());
		this.hashColumns.put("kr_cstms_rjct_rsn1", getKrCstmsRjctRsn1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_rcv_msg", "ediRcvMsg");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("log_dtl_seq", "logDtlSeq");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("msg_log_tp_cd", "msgLogTpCd");
		this.hashFields.put("kr_cstms_rjct_rsn2", "krCstmsRjctRsn2");
		this.hashFields.put("kr_cstms_rjct_rsn1", "krCstmsRjctRsn1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return ediRcvMsg
	 */
	public String getEdiRcvMsg() {
		return this.ediRcvMsg;
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
	 * @return logDtlSeq
	 */
	public String getLogDtlSeq() {
		return this.logDtlSeq;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param ediRcvMsg
	 */
	public void setEdiRcvMsg(String ediRcvMsg) {
		this.ediRcvMsg = ediRcvMsg;
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
	 * @param logDtlSeq
	 */
	public void setLogDtlSeq(String logDtlSeq) {
		this.logDtlSeq = logDtlSeq;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdiRcvMsg(JSPUtil.getParameter(request, "edi_rcv_msg", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setLogDtlSeq(JSPUtil.getParameter(request, "log_dtl_seq", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, "flt_file_ref_no", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setMsgLogTpCd(JSPUtil.getParameter(request, "msg_log_tp_cd", ""));
		setKrCstmsRjctRsn2(JSPUtil.getParameter(request, "kr_cstms_rjct_rsn2", ""));
		setKrCstmsRjctRsn1(JSPUtil.getParameter(request, "kr_cstms_rjct_rsn1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorAckMsgDtlVO[]
	 */
	public KorAckMsgDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorAckMsgDtlVO[]
	 */
	public KorAckMsgDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorAckMsgDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediRcvMsg = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_msg", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] logDtlSeq = (JSPUtil.getParameter(request, prefix	+ "log_dtl_seq", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] msgLogTpCd = (JSPUtil.getParameter(request, prefix	+ "msg_log_tp_cd", length));
			String[] krCstmsRjctRsn2 = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_rjct_rsn2", length));
			String[] krCstmsRjctRsn1 = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_rjct_rsn1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorAckMsgDtlVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediRcvMsg[i] != null)
					model.setEdiRcvMsg(ediRcvMsg[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (logDtlSeq[i] != null)
					model.setLogDtlSeq(logDtlSeq[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (msgLogTpCd[i] != null)
					model.setMsgLogTpCd(msgLogTpCd[i]);
				if (krCstmsRjctRsn2[i] != null)
					model.setKrCstmsRjctRsn2(krCstmsRjctRsn2[i]);
				if (krCstmsRjctRsn1[i] != null)
					model.setKrCstmsRjctRsn1(krCstmsRjctRsn1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorAckMsgDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorAckMsgDtlVO[]
	 */
	public KorAckMsgDtlVO[] getKorAckMsgDtlVOs(){
		KorAckMsgDtlVO[] vos = (KorAckMsgDtlVO[])models.toArray(new KorAckMsgDtlVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvMsg = this.ediRcvMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logDtlSeq = this.logDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgLogTpCd = this.msgLogTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsRjctRsn2 = this.krCstmsRjctRsn2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsRjctRsn1 = this.krCstmsRjctRsn1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
