/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgIfManagerEdiVO.java
*@FileTitle : BkgIfManagerEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.24 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgIfManagerEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgIfManagerEdiVO> models = new ArrayList<BkgIfManagerEdiVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rcvId = null;
	/* Column Info */
	private String receiverName = null;
	/* Column Info */
	private String refCode = null;
	/* Column Info */
	private String groupEdiId = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String ack = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String sndUsrNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String groupId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String ediRef = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String sentStatus = null;
	/* Column Info */
	private String sentDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgIfManagerEdiVO() {}

	public BkgIfManagerEdiVO(String ibflag, String pagerows, String bkgNo, String status, String blNo, String custTpCd, String custCd, String custNm, String scNo, String groupEdiId, String ediRef, String receiverName, String vvd, String porCd, String polCd, String podCd, String delCd, String sentDt, String sndUsrId, String sndUsrNm, String sentStatus, String ack, String rcvId, String groupId, String refCode) {
		this.porCd = porCd;
		this.custNm = custNm;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.scNo = scNo;
		this.rcvId = rcvId;
		this.receiverName = receiverName;
		this.refCode = refCode;
		this.groupEdiId = groupEdiId;
		this.custTpCd = custTpCd;
		this.status = status;
		this.ack = ack;
		this.delCd = delCd;
		this.sndUsrNm = sndUsrNm;
		this.vvd = vvd;
		this.podCd = podCd;
		this.groupId = groupId;
		this.bkgNo = bkgNo;
		this.sndUsrId = sndUsrId;
		this.ediRef = ediRef;
		this.custCd = custCd;
		this.sentStatus = sentStatus;
		this.sentDt = sentDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rcv_id", getRcvId());
		this.hashColumns.put("receiver_name", getReceiverName());
		this.hashColumns.put("ref_code", getRefCode());
		this.hashColumns.put("group_edi_id", getGroupEdiId());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("ack", getAck());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("snd_usr_nm", getSndUsrNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("group_id", getGroupId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("edi_ref", getEdiRef());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sent_status", getSentStatus());
		this.hashColumns.put("sent_dt", getSentDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rcv_id", "rcvId");
		this.hashFields.put("receiver_name", "receiverName");
		this.hashFields.put("ref_code", "refCode");
		this.hashFields.put("group_edi_id", "groupEdiId");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("ack", "ack");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("snd_usr_nm", "sndUsrNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("group_id", "groupId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("edi_ref", "ediRef");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sent_status", "sentStatus");
		this.hashFields.put("sent_dt", "sentDt");
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return rcvId
	 */
	public String getRcvId() {
		return this.rcvId;
	}
	
	/**
	 * Column Info
	 * @return receiverName
	 */
	public String getReceiverName() {
		return this.receiverName;
	}
	
	/**
	 * Column Info
	 * @return refCode
	 */
	public String getRefCode() {
		return this.refCode;
	}
	
	/**
	 * Column Info
	 * @return groupEdiId
	 */
	public String getGroupEdiId() {
		return this.groupEdiId;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return ack
	 */
	public String getAck() {
		return this.ack;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return sndUsrNm
	 */
	public String getSndUsrNm() {
		return this.sndUsrNm;
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
	 * @return groupId
	 */
	public String getGroupId() {
		return this.groupId;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return ediRef
	 */
	public String getEdiRef() {
		return this.ediRef;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return sentStatus
	 */
	public String getSentStatus() {
		return this.sentStatus;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param rcvId
	 */
	public void setRcvId(String rcvId) {
		this.rcvId = rcvId;
	}
	
	/**
	 * Column Info
	 * @param receiverName
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	/**
	 * Column Info
	 * @param refCode
	 */
	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}
	
	/**
	 * Column Info
	 * @param groupEdiId
	 */
	public void setGroupEdiId(String groupEdiId) {
		this.groupEdiId = groupEdiId;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param ack
	 */
	public void setAck(String ack) {
		this.ack = ack;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param sndUsrNm
	 */
	public void setSndUsrNm(String sndUsrNm) {
		this.sndUsrNm = sndUsrNm;
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
	 * @param groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param ediRef
	 */
	public void setEdiRef(String ediRef) {
		this.ediRef = ediRef;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param sentStatus
	 */
	public void setSentStatus(String sentStatus) {
		this.sentStatus = sentStatus;
	}
	
	/**
	 * Column Info
	 * @param sentDt
	 */
	public void setSentDt(String sentDt) {
		this.sentDt = sentDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setRcvId(JSPUtil.getParameter(request, "rcv_id", ""));
		setReceiverName(JSPUtil.getParameter(request, "receiver_name", ""));
		setRefCode(JSPUtil.getParameter(request, "ref_code", ""));
		setGroupEdiId(JSPUtil.getParameter(request, "group_edi_id", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setAck(JSPUtil.getParameter(request, "ack", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSndUsrNm(JSPUtil.getParameter(request, "snd_usr_nm", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setGroupId(JSPUtil.getParameter(request, "group_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setEdiRef(JSPUtil.getParameter(request, "edi_ref", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setSentStatus(JSPUtil.getParameter(request, "sent_status", ""));
		setSentDt(JSPUtil.getParameter(request, "sent_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgIfManagerEdiVO[]
	 */
	public BkgIfManagerEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgIfManagerEdiVO[]
	 */
	public BkgIfManagerEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgIfManagerEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rcvId = (JSPUtil.getParameter(request, prefix	+ "rcv_id", length));
			String[] receiverName = (JSPUtil.getParameter(request, prefix	+ "receiver_name", length));
			String[] refCode = (JSPUtil.getParameter(request, prefix	+ "ref_code", length));
			String[] groupEdiId = (JSPUtil.getParameter(request, prefix	+ "group_edi_id", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] ack = (JSPUtil.getParameter(request, prefix	+ "ack", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] sndUsrNm = (JSPUtil.getParameter(request, prefix	+ "snd_usr_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] groupId = (JSPUtil.getParameter(request, prefix	+ "group_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] ediRef = (JSPUtil.getParameter(request, prefix	+ "edi_ref", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] sentStatus = (JSPUtil.getParameter(request, prefix	+ "sent_status", length));
			String[] sentDt = (JSPUtil.getParameter(request, prefix	+ "sent_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgIfManagerEdiVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rcvId[i] != null)
					model.setRcvId(rcvId[i]);
				if (receiverName[i] != null)
					model.setReceiverName(receiverName[i]);
				if (refCode[i] != null)
					model.setRefCode(refCode[i]);
				if (groupEdiId[i] != null)
					model.setGroupEdiId(groupEdiId[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (ack[i] != null)
					model.setAck(ack[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (sndUsrNm[i] != null)
					model.setSndUsrNm(sndUsrNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (groupId[i] != null)
					model.setGroupId(groupId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ediRef[i] != null)
					model.setEdiRef(ediRef[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (sentStatus[i] != null)
					model.setSentStatus(sentStatus[i]);
				if (sentDt[i] != null)
					model.setSentDt(sentDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgIfManagerEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgIfManagerEdiVO[]
	 */
	public BkgIfManagerEdiVO[] getBkgIfManagerEdiVOs(){
		BkgIfManagerEdiVO[] vos = (BkgIfManagerEdiVO[])models.toArray(new BkgIfManagerEdiVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvId = this.rcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverName = this.receiverName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refCode = this.refCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupEdiId = this.groupEdiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ack = this.ack .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrNm = this.sndUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupId = this.groupId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRef = this.ediRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentStatus = this.sentStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentDt = this.sentDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
