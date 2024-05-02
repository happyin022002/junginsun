/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VgmEdiSupVO.java
*@FileTitle : VgmEdiSupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
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

public class VgmEdiSupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VgmEdiSupVO> models = new ArrayList<VgmEdiSupVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String bkgNtcSndRsltCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sender = null;
	/* Column Info */
	private String senderNm = null;
	/* Column Info */
	private String sendDt = null;
	/* Column Info */
	private String ediReceiveId = null;
	/* Column Info */
	private String ntcKndNm = null;
	/* Column Info */
	private String ntcKndCd = null;
	/* Column Info */
	private String refCode = null;
	/* Column Info */
	private String ediSndId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String inEdiKnd = null;
	/* Column Info */
	private String inYdCd = null;
	/* Column Info */
	private String inRcvrId = null;
	/* Column Info */
	private String inSndrId = null;
	/* Column Info */
	private String bkgNos = null;
	/* Column Info */
	private String cntrNos = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String bkgOrd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VgmEdiSupVO() {}

	public VgmEdiSupVO(String ibflag, String pagerows, String ntcKndNm, String ntcKndCd, String refCode, String ediReceiveId, String sender, String senderNm, String sendDt, String bkgNtcSndRsltCd, String result, String ediSndId, String bkgNo, String inEdiKnd, String inYdCd, String inRcvrId, String inSndrId, String bkgNos, String cntrNos, String cntrNo, String ydCd, String vgmWgt, String vgmWgtUtCd, String bkgOrd) {
		this.pagerows = pagerows;
		this.result = result;
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
		this.ibflag = ibflag;
		this.sender = sender;
		this.senderNm = senderNm;
		this.sendDt = sendDt;
		this.ediReceiveId = ediReceiveId;
		this.ntcKndNm = ntcKndNm;
		this.ntcKndCd = ntcKndCd;
		this.refCode = refCode;
		this.ediSndId = ediSndId;
		this.bkgNo = bkgNo;
		this.inEdiKnd = inEdiKnd;
		this.inYdCd = inYdCd;
		this.inRcvrId = inRcvrId;
		this.inSndrId = inSndrId;
		this.bkgNos = bkgNos;
		this.cntrNos = cntrNos;
		this.cntrNo = cntrNo;
		this.ydCd = ydCd;
		this.vgmWgt = vgmWgt;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.bkgOrd = bkgOrd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("bkg_ntc_snd_rslt_cd", getBkgNtcSndRsltCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sender", getSender());
		this.hashColumns.put("sender_nm", getSenderNm());
		this.hashColumns.put("send_dt", getSendDt());
		this.hashColumns.put("edi_receive_id", getEdiReceiveId());
		this.hashColumns.put("ntc_knd_nm", getNtcKndNm());
		this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
		this.hashColumns.put("ref_code", getRefCode());
		this.hashColumns.put("edi_snd_id", getEdiSndId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("in_edi_knd", getInEdiKnd());
		this.hashColumns.put("in_yd_cd", getInYdCd());
		this.hashColumns.put("in_rcvr_id", getInRcvrId());
		this.hashColumns.put("in_sndr_id", getInSndrId());
		this.hashColumns.put("bkg_nos", getBkgNos());
		this.hashColumns.put("cntr_nos", getCntrNos());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("bkg_ord", getBkgOrd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("result", "result");
		this.hashFields.put("bkg_ntc_snd_rslt_cd", "bkgNtcSndRsltCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sender", "sender");
		this.hashFields.put("sender_nm", "senderNm");
		this.hashFields.put("send_dt", "sendDt");
		this.hashFields.put("edi_receive_id", "ediReceiveId");
		this.hashFields.put("ntc_knd_nm", "ntcKndNm");
		this.hashFields.put("ntc_knd_cd", "ntcKndCd");
		this.hashFields.put("ref_code", "refCode");
		this.hashFields.put("edi_snd_id", "ediSndId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("in_edi_knd", "inEdiKnd");
		this.hashFields.put("in_yd_cd", "inYdCd");
		this.hashFields.put("in_rcvr_id", "inRcvrId");
		this.hashFields.put("in_sndr_id", "inSndrId");
		this.hashFields.put("bkg_nos", "bkgNos");
		this.hashFields.put("cntr_nos", "cntrNos");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("bkg_ord", "bkgOrd");
		return this.hashFields;
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
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return bkgNtcSndRsltCd
	 */
	public String getBkgNtcSndRsltCd() {
		return this.bkgNtcSndRsltCd;
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
	 * @return sender
	 */
	public String getSender() {
		return this.sender;
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
	 * @return ediReceiveId
	 */
	public String getEdiReceiveId() {
		return this.ediReceiveId;
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
	 * @return ntcKndCd
	 */
	public String getNtcKndCd() {
		return this.ntcKndCd;
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
	 * @return ediSndId
	 */
	public String getEdiSndId() {
		return this.ediSndId;
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
	 * @return inEdiKnd
	 */
	public String getInEdiKnd() {
		return this.inEdiKnd;
	}
	
	/**
	 * Column Info
	 * @return inYdCd
	 */
	public String getInYdCd() {
		return this.inYdCd;
	}
	
	/**
	 * Column Info
	 * @return inRcvrId
	 */
	public String getInRcvrId() {
		return this.inRcvrId;
	}
	
	/**
	 * Column Info
	 * @return inSndrId
	 */
	public String getInSndrId() {
		return this.inSndrId;
	}
	
	/**
	 * Column Info
	 * @return bkgNos
	 */
	public String getBkgNos() {
		return this.bkgNos;
	}
	
	/**
	 * Column Info
	 * @return cntrNos
	 */
	public String getCntrNos() {
		return this.cntrNos;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOrd
	 */
	public String getBkgOrd() {
		return this.bkgOrd;
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
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param bkgNtcSndRsltCd
	 */
	public void setBkgNtcSndRsltCd(String bkgNtcSndRsltCd) {
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
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
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
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
	 * @param ediReceiveId
	 */
	public void setEdiReceiveId(String ediReceiveId) {
		this.ediReceiveId = ediReceiveId;
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
	 * @param ntcKndCd
	 */
	public void setNtcKndCd(String ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
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
	 * @param ediSndId
	 */
	public void setEdiSndId(String ediSndId) {
		this.ediSndId = ediSndId;
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
	 * @param inEdiKnd
	 */
	public void setInEdiKnd(String inEdiKnd) {
		this.inEdiKnd = inEdiKnd;
	}
	
	/**
	 * Column Info
	 * @param inYdCd
	 */
	public void setInYdCd(String inYdCd) {
		this.inYdCd = inYdCd;
	}
	
	/**
	 * Column Info
	 * @param inRcvrId
	 */
	public void setInRcvrId(String inRcvrId) {
		this.inRcvrId = inRcvrId;
	}
	
	/**
	 * Column Info
	 * @param inSndrId
	 */
	public void setInSndrId(String inSndrId) {
		this.inSndrId = inSndrId;
	}
	
	/**
	 * Column Info
	 * @param bkgNos
	 */
	public void setBkgNos(String bkgNos) {
		this.bkgNos = bkgNos;
	}
	
	/**
	 * Column Info
	 * @param cntrNos
	 */
	public void setCntrNos(String cntrNos) {
		this.cntrNos = cntrNos;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOrd
	 */
	public void setBkgOrd(String bkgOrd) {
		this.bkgOrd = bkgOrd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setBkgNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "bkg_ntc_snd_rslt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSender(JSPUtil.getParameter(request, prefix + "sender", ""));
		setSenderNm(JSPUtil.getParameter(request, prefix + "sender_nm", ""));
		setSendDt(JSPUtil.getParameter(request, prefix + "send_dt", ""));
		setEdiReceiveId(JSPUtil.getParameter(request, prefix + "edi_receive_id", ""));
		setNtcKndNm(JSPUtil.getParameter(request, prefix + "ntc_knd_nm", ""));
		setNtcKndCd(JSPUtil.getParameter(request, prefix + "ntc_knd_cd", ""));
		setRefCode(JSPUtil.getParameter(request, prefix + "ref_code", ""));
		setEdiSndId(JSPUtil.getParameter(request, prefix + "edi_snd_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setInEdiKnd(JSPUtil.getParameter(request, prefix + "in_edi_knd", ""));
		setInYdCd(JSPUtil.getParameter(request, prefix + "in_yd_cd", ""));
		setInRcvrId(JSPUtil.getParameter(request, prefix + "in_rcvr_id", ""));
		setInSndrId(JSPUtil.getParameter(request, prefix + "in_sndr_id", ""));
		setBkgNos(JSPUtil.getParameter(request, prefix + "bkg_nos", ""));
		setCntrNos(JSPUtil.getParameter(request, prefix + "cntr_nos", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setBkgOrd(JSPUtil.getParameter(request, prefix + "bkg_ord", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VgmEdiSupVO[]
	 */
	public VgmEdiSupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VgmEdiSupVO[]
	 */
	public VgmEdiSupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VgmEdiSupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] bkgNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ntc_snd_rslt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sender = (JSPUtil.getParameter(request, prefix	+ "sender", length));
			String[] senderNm = (JSPUtil.getParameter(request, prefix	+ "sender_nm", length));
			String[] sendDt = (JSPUtil.getParameter(request, prefix	+ "send_dt", length));
			String[] ediReceiveId = (JSPUtil.getParameter(request, prefix	+ "edi_receive_id", length));
			String[] ntcKndNm = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_nm", length));
			String[] ntcKndCd = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_cd", length));
			String[] refCode = (JSPUtil.getParameter(request, prefix	+ "ref_code", length));
			String[] ediSndId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] inEdiKnd = (JSPUtil.getParameter(request, prefix	+ "in_edi_knd", length));
			String[] inYdCd = (JSPUtil.getParameter(request, prefix	+ "in_yd_cd", length));
			String[] inRcvrId = (JSPUtil.getParameter(request, prefix	+ "in_rcvr_id", length));
			String[] inSndrId = (JSPUtil.getParameter(request, prefix	+ "in_sndr_id", length));
			String[] bkgNos = (JSPUtil.getParameter(request, prefix	+ "bkg_nos", length));
			String[] cntrNos = (JSPUtil.getParameter(request, prefix	+ "cntr_nos", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] bkgOrd = (JSPUtil.getParameter(request, prefix	+ "bkg_ord", length));
			
			for (int i = 0; i < length; i++) {
				model = new VgmEdiSupVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (bkgNtcSndRsltCd[i] != null)
					model.setBkgNtcSndRsltCd(bkgNtcSndRsltCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sender[i] != null)
					model.setSender(sender[i]);
				if (senderNm[i] != null)
					model.setSenderNm(senderNm[i]);
				if (sendDt[i] != null)
					model.setSendDt(sendDt[i]);
				if (ediReceiveId[i] != null)
					model.setEdiReceiveId(ediReceiveId[i]);
				if (ntcKndNm[i] != null)
					model.setNtcKndNm(ntcKndNm[i]);
				if (ntcKndCd[i] != null)
					model.setNtcKndCd(ntcKndCd[i]);
				if (refCode[i] != null)
					model.setRefCode(refCode[i]);
				if (ediSndId[i] != null)
					model.setEdiSndId(ediSndId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (inEdiKnd[i] != null)
					model.setInEdiKnd(inEdiKnd[i]);
				if (inYdCd[i] != null)
					model.setInYdCd(inYdCd[i]);
				if (inRcvrId[i] != null)
					model.setInRcvrId(inRcvrId[i]);
				if (inSndrId[i] != null)
					model.setInSndrId(inSndrId[i]);
				if (bkgNos[i] != null)
					model.setBkgNos(bkgNos[i]);
				if (cntrNos[i] != null)
					model.setCntrNos(cntrNos[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (bkgOrd[i] != null)
					model.setBkgOrd(bkgOrd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVgmEdiSupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VgmEdiSupVO[]
	 */
	public VgmEdiSupVO[] getVgmEdiSupVOs(){
		VgmEdiSupVO[] vos = (VgmEdiSupVO[])models.toArray(new VgmEdiSupVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtcSndRsltCd = this.bkgNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sender = this.sender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderNm = this.senderNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDt = this.sendDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediReceiveId = this.ediReceiveId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndNm = this.ntcKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCd = this.ntcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refCode = this.refCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndId = this.ediSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEdiKnd = this.inEdiKnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inYdCd = this.inYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRcvrId = this.inRcvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSndrId = this.inSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNos = this.bkgNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNos = this.cntrNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOrd = this.bkgOrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
