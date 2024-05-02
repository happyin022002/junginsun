/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : HNWLInvoiceEdiVO.java
 * @FileTitle : HNWLInvoiceEdiVO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.05.24
 * @LastModifier : 김상현
 * @LastVersion : 1.0
 * 2012.05.24 김상현 1.0 Creation
 */

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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

public class HNWLInvoiceEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HNWLInvoiceEdiVO> models = new ArrayList<HNWLInvoiceEdiVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String frtUsdRtAmt = null;
	/* Column Info */
	private String funcCode = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String custRefNoCtnt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String ttlUsdAmt = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndSeq = null;
	/* Column Info */
	private String ackRsltCd = null;
	/* Column Info */
	private String otrUsdConvAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ediSndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HNWLInvoiceEdiVO() {}

	public HNWLInvoiceEdiVO(String ibflag, String pagerows, String blSrcNo, String sndSeq, String fltFileRefNo, String ediSndDt, String ackRsltCd, String frtUsdRtAmt, String otrUsdConvAmt, String ttlUsdAmt, String vvd, String sailArrDt, String custRefNoCtnt, String porCd, String polCd, String podCd, String delCd, String updUsrId, String ofcCd, String bkgNo, String ioBndCd, String funcCode) {
		this.porCd = porCd;
		this.blSrcNo = blSrcNo;
		this.frtUsdRtAmt = frtUsdRtAmt;
		this.funcCode = funcCode;
		this.delCd = delCd;
		this.fltFileRefNo = fltFileRefNo;
		this.custRefNoCtnt = custRefNoCtnt;
		this.ioBndCd = ioBndCd;
		this.ttlUsdAmt = ttlUsdAmt;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.sndSeq = sndSeq;
		this.ackRsltCd = ackRsltCd;
		this.otrUsdConvAmt = otrUsdConvAmt;
		this.updUsrId = updUsrId;
		this.ediSndDt = ediSndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("frt_usd_rt_amt", getFrtUsdRtAmt());
		this.hashColumns.put("func_code", getFuncCode());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("cust_ref_no_ctnt", getCustRefNoCtnt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ttl_usd_amt", getTtlUsdAmt());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_seq", getSndSeq());
		this.hashColumns.put("ack_rslt_cd", getAckRsltCd());
		this.hashColumns.put("otr_usd_conv_amt", getOtrUsdConvAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("frt_usd_rt_amt", "frtUsdRtAmt");
		this.hashFields.put("func_code", "funcCode");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("cust_ref_no_ctnt", "custRefNoCtnt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ttl_usd_amt", "ttlUsdAmt");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_seq", "sndSeq");
		this.hashFields.put("ack_rslt_cd", "ackRsltCd");
		this.hashFields.put("otr_usd_conv_amt", "otrUsdConvAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
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
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return frtUsdRtAmt
	 */
	public String getFrtUsdRtAmt() {
		return this.frtUsdRtAmt;
	}
	
	/**
	 * Column Info
	 * @return funcCode
	 */
	public String getFuncCode() {
		return this.funcCode;
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
	 * @return fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return this.fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @return custRefNoCtnt
	 */
	public String getCustRefNoCtnt() {
		return this.custRefNoCtnt;
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
	 * @return ttlUsdAmt
	 */
	public String getTtlUsdAmt() {
		return this.ttlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return sndSeq
	 */
	public String getSndSeq() {
		return this.sndSeq;
	}
	
	/**
	 * Column Info
	 * @return ackRsltCd
	 */
	public String getAckRsltCd() {
		return this.ackRsltCd;
	}
	
	/**
	 * Column Info
	 * @return otrUsdConvAmt
	 */
	public String getOtrUsdConvAmt() {
		return this.otrUsdConvAmt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
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
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param frtUsdRtAmt
	 */
	public void setFrtUsdRtAmt(String frtUsdRtAmt) {
		this.frtUsdRtAmt = frtUsdRtAmt;
	}
	
	/**
	 * Column Info
	 * @param funcCode
	 */
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
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
	 * @param fltFileRefNo
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @param custRefNoCtnt
	 */
	public void setCustRefNoCtnt(String custRefNoCtnt) {
		this.custRefNoCtnt = custRefNoCtnt;
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
	 * @param ttlUsdAmt
	 */
	public void setTtlUsdAmt(String ttlUsdAmt) {
		this.ttlUsdAmt = ttlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param sndSeq
	 */
	public void setSndSeq(String sndSeq) {
		this.sndSeq = sndSeq;
	}
	
	/**
	 * Column Info
	 * @param ackRsltCd
	 */
	public void setAckRsltCd(String ackRsltCd) {
		this.ackRsltCd = ackRsltCd;
	}
	
	/**
	 * Column Info
	 * @param otrUsdConvAmt
	 */
	public void setOtrUsdConvAmt(String otrUsdConvAmt) {
		this.otrUsdConvAmt = otrUsdConvAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
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
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setFrtUsdRtAmt(JSPUtil.getParameter(request, prefix + "frt_usd_rt_amt", ""));
		setFuncCode(JSPUtil.getParameter(request, prefix + "func_code", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
		setCustRefNoCtnt(JSPUtil.getParameter(request, prefix + "cust_ref_no_ctnt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setTtlUsdAmt(JSPUtil.getParameter(request, prefix + "ttl_usd_amt", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSndSeq(JSPUtil.getParameter(request, prefix + "snd_seq", ""));
		setAckRsltCd(JSPUtil.getParameter(request, prefix + "ack_rslt_cd", ""));
		setOtrUsdConvAmt(JSPUtil.getParameter(request, prefix + "otr_usd_conv_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEdiSndDt(JSPUtil.getParameter(request, prefix + "edi_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HNWLInvoiceEdiVO[]
	 */
	public HNWLInvoiceEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HNWLInvoiceEdiVO[]
	 */
	public HNWLInvoiceEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HNWLInvoiceEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] frtUsdRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_usd_rt_amt", length));
			String[] funcCode = (JSPUtil.getParameter(request, prefix	+ "func_code", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] custRefNoCtnt = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no_ctnt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] ttlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_usd_amt", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndSeq = (JSPUtil.getParameter(request, prefix	+ "snd_seq", length));
			String[] ackRsltCd = (JSPUtil.getParameter(request, prefix	+ "ack_rslt_cd", length));
			String[] otrUsdConvAmt = (JSPUtil.getParameter(request, prefix	+ "otr_usd_conv_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new HNWLInvoiceEdiVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (frtUsdRtAmt[i] != null)
					model.setFrtUsdRtAmt(frtUsdRtAmt[i]);
				if (funcCode[i] != null)
					model.setFuncCode(funcCode[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (custRefNoCtnt[i] != null)
					model.setCustRefNoCtnt(custRefNoCtnt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (ttlUsdAmt[i] != null)
					model.setTtlUsdAmt(ttlUsdAmt[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndSeq[i] != null)
					model.setSndSeq(sndSeq[i]);
				if (ackRsltCd[i] != null)
					model.setAckRsltCd(ackRsltCd[i]);
				if (otrUsdConvAmt[i] != null)
					model.setOtrUsdConvAmt(otrUsdConvAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHNWLInvoiceEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HNWLInvoiceEdiVO[]
	 */
	public HNWLInvoiceEdiVO[] getHNWLInvoiceEdiVOs(){
		HNWLInvoiceEdiVO[] vos = (HNWLInvoiceEdiVO[])models.toArray(new HNWLInvoiceEdiVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtUsdRtAmt = this.frtUsdRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.funcCode = this.funcCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNoCtnt = this.custRefNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUsdAmt = this.ttlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSeq = this.sndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRsltCd = this.ackRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrUsdConvAmt = this.otrUsdConvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
