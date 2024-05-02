/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SendBkgEdiVO.java
*@FileTitle : SendBkgEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SendBkgEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SendBkgEdiVO> models = new ArrayList<SendBkgEdiVO>();
	
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String senderNm = null;
	/* Column Info */
	private String sendDt = null;
	/* Column Info */
	private String ntcKndCd = null;
	/* Column Info */
	private String refTpCd = null;
	/* Column Info */
	private String groupNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sender = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNtcSndRsltCd = null;
	/* Column Info */
	private String refCode = null;
	/* Column Info */
	private String groupEdiId = null;
	/* Column Info */
	private String ntcKndNm = null;
	/* Column Info */
	private String ediReceiveId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SendBkgEdiVO() {}

	public SendBkgEdiVO(String ibflag, String pagerows, String ntcKndNm, String ntcKndCd, String refTpCd, String refCode, String ediReceiveId, String groupEdiId, String groupNm, String sender, String senderNm, String sendDt, String bkgNtcSndRsltCd, String result) {
		this.result = result;
		this.senderNm = senderNm;
		this.sendDt = sendDt;
		this.ntcKndCd = ntcKndCd;
		this.refTpCd = refTpCd;
		this.groupNm = groupNm;
		this.pagerows = pagerows;
		this.sender = sender;
		this.ibflag = ibflag;
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
		this.refCode = refCode;
		this.groupEdiId = groupEdiId;
		this.ntcKndNm = ntcKndNm;
		this.ediReceiveId = ediReceiveId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("sender_nm", getSenderNm());
		this.hashColumns.put("send_dt", getSendDt());
		this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
		this.hashColumns.put("ref_tp_cd", getRefTpCd());
		this.hashColumns.put("group_nm", getGroupNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sender", getSender());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ntc_snd_rslt_cd", getBkgNtcSndRsltCd());
		this.hashColumns.put("ref_code", getRefCode());
		this.hashColumns.put("group_edi_id", getGroupEdiId());
		this.hashColumns.put("ntc_knd_nm", getNtcKndNm());
		this.hashColumns.put("edi_receive_id", getEdiReceiveId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("sender_nm", "senderNm");
		this.hashFields.put("send_dt", "sendDt");
		this.hashFields.put("ntc_knd_cd", "ntcKndCd");
		this.hashFields.put("ref_tp_cd", "refTpCd");
		this.hashFields.put("group_nm", "groupNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sender", "sender");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ntc_snd_rslt_cd", "bkgNtcSndRsltCd");
		this.hashFields.put("ref_code", "refCode");
		this.hashFields.put("group_edi_id", "groupEdiId");
		this.hashFields.put("ntc_knd_nm", "ntcKndNm");
		this.hashFields.put("edi_receive_id", "ediReceiveId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return senderNm
	 */
	public String getSenderNm() {
		return this.senderNm;
	}
	
	/**
	 * Column Info
	 * @return sendDt
	 */
	public String getSendDt() {
		return this.sendDt;
	}
	
	/**
	 * Column Info
	 * @return ntcKndCd
	 */
	public String getNtcKndCd() {
		return this.ntcKndCd;
	}
	
	/**
	 * Column Info
	 * @return refTpCd
	 */
	public String getRefTpCd() {
		return this.refTpCd;
	}
	
	/**
	 * Column Info
	 * @return groupNm
	 */
	public String getGroupNm() {
		return this.groupNm;
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
	 * @return sender
	 */
	public String getSender() {
		return this.sender;
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
	 * @return bkgNtcSndRsltCd
	 */
	public String getBkgNtcSndRsltCd() {
		return this.bkgNtcSndRsltCd;
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
	 * @return ntcKndNm
	 */
	public String getNtcKndNm() {
		return this.ntcKndNm;
	}
	
	/**
	 * Column Info
	 * @return ediReceiveId
	 */
	public String getEdiReceiveId() {
		return this.ediReceiveId;
	}
	

	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param senderNm
	 */
	public void setSenderNm(String senderNm) {
		this.senderNm = senderNm;
	}
	
	/**
	 * Column Info
	 * @param sendDt
	 */
	public void setSendDt(String sendDt) {
		this.sendDt = sendDt;
	}
	
	/**
	 * Column Info
	 * @param ntcKndCd
	 */
	public void setNtcKndCd(String ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
	}
	
	/**
	 * Column Info
	 * @param refTpCd
	 */
	public void setRefTpCd(String refTpCd) {
		this.refTpCd = refTpCd;
	}
	
	/**
	 * Column Info
	 * @param groupNm
	 */
	public void setGroupNm(String groupNm) {
		this.groupNm = groupNm;
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
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
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
	 * @param bkgNtcSndRsltCd
	 */
	public void setBkgNtcSndRsltCd(String bkgNtcSndRsltCd) {
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
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
	 * @param ntcKndNm
	 */
	public void setNtcKndNm(String ntcKndNm) {
		this.ntcKndNm = ntcKndNm;
	}
	
	/**
	 * Column Info
	 * @param ediReceiveId
	 */
	public void setEdiReceiveId(String ediReceiveId) {
		this.ediReceiveId = ediReceiveId;
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
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setSenderNm(JSPUtil.getParameter(request, prefix + "sender_nm", ""));
		setSendDt(JSPUtil.getParameter(request, prefix + "send_dt", ""));
		setNtcKndCd(JSPUtil.getParameter(request, prefix + "ntc_knd_cd", ""));
		setRefTpCd(JSPUtil.getParameter(request, prefix + "ref_tp_cd", ""));
		setGroupNm(JSPUtil.getParameter(request, prefix + "group_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSender(JSPUtil.getParameter(request, prefix + "sender", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "bkg_ntc_snd_rslt_cd", ""));
		setRefCode(JSPUtil.getParameter(request, prefix + "ref_code", ""));
		setGroupEdiId(JSPUtil.getParameter(request, prefix + "group_edi_id", ""));
		setNtcKndNm(JSPUtil.getParameter(request, prefix + "ntc_knd_nm", ""));
		setEdiReceiveId(JSPUtil.getParameter(request, prefix + "edi_receive_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendBkgEdiVO[]
	 */
	public SendBkgEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendBkgEdiVO[]
	 */
	public SendBkgEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendBkgEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] senderNm = (JSPUtil.getParameter(request, prefix	+ "sender_nm", length));
			String[] sendDt = (JSPUtil.getParameter(request, prefix	+ "send_dt", length));
			String[] ntcKndCd = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_cd", length));
			String[] refTpCd = (JSPUtil.getParameter(request, prefix	+ "ref_tp_cd", length));
			String[] groupNm = (JSPUtil.getParameter(request, prefix	+ "group_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sender = (JSPUtil.getParameter(request, prefix	+ "sender", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ntc_snd_rslt_cd", length));
			String[] refCode = (JSPUtil.getParameter(request, prefix	+ "ref_code", length));
			String[] groupEdiId = (JSPUtil.getParameter(request, prefix	+ "group_edi_id", length));
			String[] ntcKndNm = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_nm", length));
			String[] ediReceiveId = (JSPUtil.getParameter(request, prefix	+ "edi_receive_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SendBkgEdiVO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (senderNm[i] != null)
					model.setSenderNm(senderNm[i]);
				if (sendDt[i] != null)
					model.setSendDt(sendDt[i]);
				if (ntcKndCd[i] != null)
					model.setNtcKndCd(ntcKndCd[i]);
				if (refTpCd[i] != null)
					model.setRefTpCd(refTpCd[i]);
				if (groupNm[i] != null)
					model.setGroupNm(groupNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sender[i] != null)
					model.setSender(sender[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNtcSndRsltCd[i] != null)
					model.setBkgNtcSndRsltCd(bkgNtcSndRsltCd[i]);
				if (refCode[i] != null)
					model.setRefCode(refCode[i]);
				if (groupEdiId[i] != null)
					model.setGroupEdiId(groupEdiId[i]);
				if (ntcKndNm[i] != null)
					model.setNtcKndNm(ntcKndNm[i]);
				if (ediReceiveId[i] != null)
					model.setEdiReceiveId(ediReceiveId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendBkgEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendBkgEdiVO[]
	 */
	public SendBkgEdiVO[] getSendBkgEdiVOs(){
		SendBkgEdiVO[] vos = (SendBkgEdiVO[])models.toArray(new SendBkgEdiVO[models.size()]);
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
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderNm = this.senderNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDt = this.sendDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCd = this.ntcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refTpCd = this.refTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupNm = this.groupNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sender = this.sender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtcSndRsltCd = this.bkgNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refCode = this.refCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupEdiId = this.groupEdiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndNm = this.ntcKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediReceiveId = this.ediReceiveId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
