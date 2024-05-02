/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaManifestSendDetailListVO.java
*@FileTitle : ChinaManifestSendDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.28
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.12.28 박성진
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaManifestSendDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaManifestSendDetailListVO> models = new ArrayList<ChinaManifestSendDetailListVO>();

	/* Column Info */
	private String blAckText = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String custAckMsg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String custAckDt = null;
	/* Column Info */
	private String agnAckMsg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrAckType = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cntrAckText = null;
	/* Column Info */
	private String blAckType = null;
	/* Column Info */
	private String ackRcvDt = null;
	/* Column Info */
	private String agnAckDt = null;
	/* Column Info */
	private String sentDt = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaManifestSendDetailListVO() {}

	public ChinaManifestSendDetailListVO(String ibflag, String pagerows, String blNo, String polCd, String podCd, String sentDt, String blAckType, String blAckText, String cntrNo, String cntrAckType, String cntrAckText, String ackRcvDt, String seq, String cnt, String rhq, String agnAckMsg, String custAckMsg, String agnAckDt, String custAckDt) {
		this.blAckText = blAckText;
		this.cnt = cnt;
		this.custAckMsg = custAckMsg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.custAckDt = custAckDt;
		this.agnAckMsg = agnAckMsg;
		this.cntrNo = cntrNo;
		this.cntrAckType = cntrAckType;
		this.seq = seq;
		this.cntrAckText = cntrAckText;
		this.blAckType = blAckType;
		this.ackRcvDt = ackRcvDt;
		this.agnAckDt = agnAckDt;
		this.sentDt = sentDt;
		this.rhq = rhq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_ack_text", getBlAckText());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("cust_ack_msg", getCustAckMsg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cust_ack_dt", getCustAckDt());
		this.hashColumns.put("agn_ack_msg", getAgnAckMsg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_ack_type", getCntrAckType());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cntr_ack_text", getCntrAckText());
		this.hashColumns.put("bl_ack_type", getBlAckType());
		this.hashColumns.put("ack_rcv_dt", getAckRcvDt());
		this.hashColumns.put("agn_ack_dt", getAgnAckDt());
		this.hashColumns.put("sent_dt", getSentDt());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_ack_text", "blAckText");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("cust_ack_msg", "custAckMsg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cust_ack_dt", "custAckDt");
		this.hashFields.put("agn_ack_msg", "agnAckMsg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_ack_type", "cntrAckType");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cntr_ack_text", "cntrAckText");
		this.hashFields.put("bl_ack_type", "blAckType");
		this.hashFields.put("ack_rcv_dt", "ackRcvDt");
		this.hashFields.put("agn_ack_dt", "agnAckDt");
		this.hashFields.put("sent_dt", "sentDt");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return blAckText
	 */
	public String getBlAckText() {
		return this.blAckText;
	}

	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}

	/**
	 * Column Info
	 * @return custAckMsg
	 */
	public String getCustAckMsg() {
		return this.custAckMsg;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return custAckDt
	 */
	public String getCustAckDt() {
		return this.custAckDt;
	}

	/**
	 * Column Info
	 * @return agnAckMsg
	 */
	public String getAgnAckMsg() {
		return this.agnAckMsg;
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
	 * @return cntrAckType
	 */
	public String getCntrAckType() {
		return this.cntrAckType;
	}

	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}

	/**
	 * Column Info
	 * @return cntrAckText
	 */
	public String getCntrAckText() {
		return this.cntrAckText;
	}

	/**
	 * Column Info
	 * @return blAckType
	 */
	public String getBlAckType() {
		return this.blAckType;
	}

	/**
	 * Column Info
	 * @return ackRcvDt
	 */
	public String getAckRcvDt() {
		return this.ackRcvDt;
	}

	/**
	 * Column Info
	 * @return agnAckDt
	 */
	public String getAgnAckDt() {
		return this.agnAckDt;
	}

	/**
	 * Column Info
	 * @return sentDt
	 */
	public String getSentDt() {
		return this.sentDt;
	}

	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}


	/**
	 * Column Info
	 * @param blAckText
	 */
	public void setBlAckText(String blAckText) {
		this.blAckText = blAckText;
	}

	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	/**
	 * Column Info
	 * @param custAckMsg
	 */
	public void setCustAckMsg(String custAckMsg) {
		this.custAckMsg = custAckMsg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param custAckDt
	 */
	public void setCustAckDt(String custAckDt) {
		this.custAckDt = custAckDt;
	}

	/**
	 * Column Info
	 * @param agnAckMsg
	 */
	public void setAgnAckMsg(String agnAckMsg) {
		this.agnAckMsg = agnAckMsg;
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
	 * @param cntrAckType
	 */
	public void setCntrAckType(String cntrAckType) {
		this.cntrAckType = cntrAckType;
	}

	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * Column Info
	 * @param cntrAckText
	 */
	public void setCntrAckText(String cntrAckText) {
		this.cntrAckText = cntrAckText;
	}

	/**
	 * Column Info
	 * @param blAckType
	 */
	public void setBlAckType(String blAckType) {
		this.blAckType = blAckType;
	}

	/**
	 * Column Info
	 * @param ackRcvDt
	 */
	public void setAckRcvDt(String ackRcvDt) {
		this.ackRcvDt = ackRcvDt;
	}

	/**
	 * Column Info
	 * @param agnAckDt
	 */
	public void setAgnAckDt(String agnAckDt) {
		this.agnAckDt = agnAckDt;
	}

	/**
	 * Column Info
	 * @param sentDt
	 */
	public void setSentDt(String sentDt) {
		this.sentDt = sentDt;
	}

	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setBlAckText(JSPUtil.getParameter(request, prefix + "bl_ack_text", ""));
		setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
		setCustAckMsg(JSPUtil.getParameter(request, prefix + "cust_ack_msg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCustAckDt(JSPUtil.getParameter(request, prefix + "cust_ack_dt", ""));
		setAgnAckMsg(JSPUtil.getParameter(request, prefix + "agn_ack_msg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrAckType(JSPUtil.getParameter(request, prefix + "cntr_ack_type", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setCntrAckText(JSPUtil.getParameter(request, prefix + "cntr_ack_text", ""));
		setBlAckType(JSPUtil.getParameter(request, prefix + "bl_ack_type", ""));
		setAckRcvDt(JSPUtil.getParameter(request, prefix + "ack_rcv_dt", ""));
		setAgnAckDt(JSPUtil.getParameter(request, prefix + "agn_ack_dt", ""));
		setSentDt(JSPUtil.getParameter(request, prefix + "sent_dt", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaManifestSendDetailListVO[]
	 */
	public ChinaManifestSendDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaManifestSendDetailListVO[]
	 */
	public ChinaManifestSendDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaManifestSendDetailListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] blAckText = (JSPUtil.getParameter(request, prefix	+ "bl_ack_text", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] custAckMsg = (JSPUtil.getParameter(request, prefix	+ "cust_ack_msg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] custAckDt = (JSPUtil.getParameter(request, prefix	+ "cust_ack_dt", length));
			String[] agnAckMsg = (JSPUtil.getParameter(request, prefix	+ "agn_ack_msg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrAckType = (JSPUtil.getParameter(request, prefix	+ "cntr_ack_type", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cntrAckText = (JSPUtil.getParameter(request, prefix	+ "cntr_ack_text", length));
			String[] blAckType = (JSPUtil.getParameter(request, prefix	+ "bl_ack_type", length));
			String[] ackRcvDt = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_dt", length));
			String[] agnAckDt = (JSPUtil.getParameter(request, prefix	+ "agn_ack_dt", length));
			String[] sentDt = (JSPUtil.getParameter(request, prefix	+ "sent_dt", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaManifestSendDetailListVO();
				if (blAckText[i] != null)
					model.setBlAckText(blAckText[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (custAckMsg[i] != null)
					model.setCustAckMsg(custAckMsg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (custAckDt[i] != null)
					model.setCustAckDt(custAckDt[i]);
				if (agnAckMsg[i] != null)
					model.setAgnAckMsg(agnAckMsg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrAckType[i] != null)
					model.setCntrAckType(cntrAckType[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cntrAckText[i] != null)
					model.setCntrAckText(cntrAckText[i]);
				if (blAckType[i] != null)
					model.setBlAckType(blAckType[i]);
				if (ackRcvDt[i] != null)
					model.setAckRcvDt(ackRcvDt[i]);
				if (agnAckDt[i] != null)
					model.setAgnAckDt(agnAckDt[i]);
				if (sentDt[i] != null)
					model.setSentDt(sentDt[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaManifestSendDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaManifestSendDetailListVO[]
	 */
	public ChinaManifestSendDetailListVO[] getChinaManifestSendDetailListVOs(){
		ChinaManifestSendDetailListVO[] vos = (ChinaManifestSendDetailListVO[])models.toArray(new ChinaManifestSendDetailListVO[models.size()]);
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
		this.blAckText = this.blAckText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAckMsg = this.custAckMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAckDt = this.custAckDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAckMsg = this.agnAckMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAckType = this.cntrAckType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAckText = this.cntrAckText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAckType = this.blAckType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvDt = this.ackRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAckDt = this.agnAckDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentDt = this.sentDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
