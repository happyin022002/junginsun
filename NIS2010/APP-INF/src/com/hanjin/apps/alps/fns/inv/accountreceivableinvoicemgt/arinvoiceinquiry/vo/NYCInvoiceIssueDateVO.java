/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NYCInvoiceIssueDateVO.java
*@FileTitle : NYCInvoiceIssueDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.02.04 Do Soon Choi 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Do Soon Choi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NYCInvoiceIssueDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NYCInvoiceIssueDateVO> models = new ArrayList<NYCInvoiceIssueDateVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sndSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revType = null;
	/* Column Info */
	private String receivedNo = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String sentResult = null;
	/* Column Info */
	private String invSndDt = null;
	/* Column Info */
	private String timeSent = null;
	/* Column Info */
	private String sentBy = null;
	/* Column Info */
	private String timeRequested = null;
	/* Column Info */
	private String dueDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public NYCInvoiceIssueDateVO() {}

	public NYCInvoiceIssueDateVO(String ibflag, String pagerows, String timeSent, String sentBy, String sentResult, String receivedNo, String timeRequested, String arOfcCd, String ioBndCd, String revType, String blSrcNo, String custCode, String vvd, String sailArrDt, String polCd, String podCd, String ttlAmt, String creUsrId, String invSndDt, String sndSeq, String dueDt) {
		this.blSrcNo = blSrcNo;
		this.ttlAmt = ttlAmt;
		this.ioBndCd = ioBndCd;
		this.sailArrDt = sailArrDt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.sndSeq = sndSeq;
		this.creUsrId = creUsrId;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.revType = revType;
		this.receivedNo = receivedNo;
		this.custCode = custCode;
		this.sentResult = sentResult;
		this.invSndDt = invSndDt;
		this.timeSent = timeSent;
		this.sentBy = sentBy;
		this.timeRequested = timeRequested;
		this.dueDt = dueDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("snd_seq", getSndSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_type", getRevType());
		this.hashColumns.put("received_no", getReceivedNo());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("sent_result", getSentResult());
		this.hashColumns.put("inv_snd_dt", getInvSndDt());
		this.hashColumns.put("time_sent", getTimeSent());
		this.hashColumns.put("sent_by", getSentBy());
		this.hashColumns.put("time_requested", getTimeRequested());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("snd_seq", "sndSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_type", "revType");
		this.hashFields.put("received_no", "receivedNo");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("sent_result", "sentResult");
		this.hashFields.put("inv_snd_dt", "invSndDt");
		this.hashFields.put("time_sent", "timeSent");
		this.hashFields.put("sent_by", "sentBy");
		this.hashFields.put("time_requested", "timeRequested");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return sndSeq
	 */
	public String getSndSeq() {
		return this.sndSeq;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return revType
	 */
	public String getRevType() {
		return this.revType;
	}
	
	/**
	 * Column Info
	 * @return receivedNo
	 */
	public String getReceivedNo() {
		return this.receivedNo;
	}
	
	/**
	 * Column Info
	 * @return custCode
	 */
	public String getCustCode() {
		return this.custCode;
	}
	
	/**
	 * Column Info
	 * @return sentResult
	 */
	public String getSentResult() {
		return this.sentResult;
	}
	
	/**
	 * Column Info
	 * @return invSndDt
	 */
	public String getInvSndDt() {
		return this.invSndDt;
	}
	
	/**
	 * Column Info
	 * @return timeSent
	 */
	public String getTimeSent() {
		return this.timeSent;
	}
	
	/**
	 * Column Info
	 * @return sentBy
	 */
	public String getSentBy() {
		return this.sentBy;
	}
	
	/**
	 * Column Info
	 * @return timeRequested
	 */
	public String getTimeRequested() {
		return this.timeRequested;
	}
	

	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param sndSeq
	 */
	public void setSndSeq(String sndSeq) {
		this.sndSeq = sndSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param revType
	 */
	public void setRevType(String revType) {
		this.revType = revType;
	}
	
	/**
	 * Column Info
	 * @param receivedNo
	 */
	public void setReceivedNo(String receivedNo) {
		this.receivedNo = receivedNo;
	}
	
	/**
	 * Column Info
	 * @param custCode
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	/**
	 * Column Info
	 * @param sentResult
	 */
	public void setSentResult(String sentResult) {
		this.sentResult = sentResult;
	}
	
	/**
	 * Column Info
	 * @param invSndDt
	 */
	public void setInvSndDt(String invSndDt) {
		this.invSndDt = invSndDt;
	}
	
	/**
	 * Column Info
	 * @param timeSent
	 */
	public void setTimeSent(String timeSent) {
		this.timeSent = timeSent;
	}
	
	/**
	 * Column Info
	 * @param sentBy
	 */
	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}
	
	/**
	 * Column Info
	 * @param timeRequested
	 */
	public void setTimeRequested(String timeRequested) {
		this.timeRequested = timeRequested;
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
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSndSeq(JSPUtil.getParameter(request, prefix + "snd_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRevType(JSPUtil.getParameter(request, prefix + "rev_type", ""));
		setReceivedNo(JSPUtil.getParameter(request, prefix + "received_no", ""));
		setCustCode(JSPUtil.getParameter(request, prefix + "cust_code", ""));
		setSentResult(JSPUtil.getParameter(request, prefix + "sent_result", ""));
		setInvSndDt(JSPUtil.getParameter(request, prefix + "inv_snd_dt", ""));
		setTimeSent(JSPUtil.getParameter(request, prefix + "time_sent", ""));
		setSentBy(JSPUtil.getParameter(request, prefix + "sent_by", ""));
		setTimeRequested(JSPUtil.getParameter(request, prefix + "time_requested", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NYCInvoiceIssueDateVO[]
	 */
	public NYCInvoiceIssueDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NYCInvoiceIssueDateVO[]
	 */
	public NYCInvoiceIssueDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NYCInvoiceIssueDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sndSeq = (JSPUtil.getParameter(request, prefix	+ "snd_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revType = (JSPUtil.getParameter(request, prefix	+ "rev_type", length));
			String[] receivedNo = (JSPUtil.getParameter(request, prefix	+ "received_no", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] sentResult = (JSPUtil.getParameter(request, prefix	+ "sent_result", length));
			String[] invSndDt = (JSPUtil.getParameter(request, prefix	+ "inv_snd_dt", length));
			String[] timeSent = (JSPUtil.getParameter(request, prefix	+ "time_sent", length));
			String[] sentBy = (JSPUtil.getParameter(request, prefix	+ "sent_by", length));
			String[] timeRequested = (JSPUtil.getParameter(request, prefix	+ "time_requested", length));
			
			for (int i = 0; i < length; i++) {
				model = new NYCInvoiceIssueDateVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sndSeq[i] != null)
					model.setSndSeq(sndSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revType[i] != null)
					model.setRevType(revType[i]);
				if (receivedNo[i] != null)
					model.setReceivedNo(receivedNo[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (sentResult[i] != null)
					model.setSentResult(sentResult[i]);
				if (invSndDt[i] != null)
					model.setInvSndDt(invSndDt[i]);
				if (timeSent[i] != null)
					model.setTimeSent(timeSent[i]);
				if (sentBy[i] != null)
					model.setSentBy(sentBy[i]);
				if (timeRequested[i] != null)
					model.setTimeRequested(timeRequested[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNYCInvoiceIssueDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NYCInvoiceIssueDateVO[]
	 */
	public NYCInvoiceIssueDateVO[] getNYCInvoiceIssueDateVOs(){
		NYCInvoiceIssueDateVO[] vos = (NYCInvoiceIssueDateVO[])models.toArray(new NYCInvoiceIssueDateVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSeq = this.sndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revType = this.revType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receivedNo = this.receivedNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentResult = this.sentResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSndDt = this.invSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timeSent = this.timeSent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentBy = this.sentBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timeRequested = this.timeRequested .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
