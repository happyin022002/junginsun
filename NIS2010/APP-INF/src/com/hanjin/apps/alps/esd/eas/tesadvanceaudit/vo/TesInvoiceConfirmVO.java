/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesInvoiceConfirmVO.java
*@FileTitle : TesInvoiceConfirmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.06.26 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesInvoiceConfirmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesInvoiceConfirmVO> models = new ArrayList<TesInvoiceConfirmVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tmlInvTpCd = null;
	/* Column Info */
	private String atbDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String expnAudSeq = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expnAudStsNm = null;
	/* Column Info */
	private String batEstmVolRsltCd = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String expnAudStsCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String batVolRsltCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String batAmtRsltCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesInvoiceConfirmVO() {}

	public TesInvoiceConfirmVO(String ibflag, String pagerows, String rhqCd, String invOfcCd, String costOfcCd, String tmlInvTpCd, String ydCd, String vndrSeq, String invNo, String expnAudSeq, String issDt, String invCfmDt, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String ioBndCd, String atbDt, String fmPrdDt, String toPrdDt, String batVolRsltCd, String batAmtRsltCd, String batEstmVolRsltCd, String expnAudStsCd, String expnAudStsNm) {
		this.vslCd = vslCd;
		this.tmlInvTpCd = tmlInvTpCd;
		this.atbDt = atbDt;
		this.pagerows = pagerows;
		this.expnAudSeq = expnAudSeq;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.expnAudStsNm = expnAudStsNm;
		this.batEstmVolRsltCd = batEstmVolRsltCd;
		this.fmPrdDt = fmPrdDt;
		this.invOfcCd = invOfcCd;
		this.costOfcCd = costOfcCd;
		this.rhqCd = rhqCd;
		this.invCfmDt = invCfmDt;
		this.expnAudStsCd = expnAudStsCd;
		this.skdVoyNo = skdVoyNo;
		this.toPrdDt = toPrdDt;
		this.ioBndCd = ioBndCd;
		this.skdDirCd = skdDirCd;
		this.invNo = invNo;
		this.vvd = vvd;
		this.batVolRsltCd = batVolRsltCd;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.batAmtRsltCd = batAmtRsltCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("tml_inv_tp_cd", getTmlInvTpCd());
		this.hashColumns.put("atb_dt", getAtbDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("expn_aud_seq", getExpnAudSeq());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("expn_aud_sts_nm", getExpnAudStsNm());
		this.hashColumns.put("bat_estm_vol_rslt_cd", getBatEstmVolRsltCd());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("expn_aud_sts_cd", getExpnAudStsCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bat_vol_rslt_cd", getBatVolRsltCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("bat_amt_rslt_cd", getBatAmtRsltCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("tml_inv_tp_cd", "tmlInvTpCd");
		this.hashFields.put("atb_dt", "atbDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("expn_aud_seq", "expnAudSeq");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("expn_aud_sts_nm", "expnAudStsNm");
		this.hashFields.put("bat_estm_vol_rslt_cd", "batEstmVolRsltCd");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("expn_aud_sts_cd", "expnAudStsCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bat_vol_rslt_cd", "batVolRsltCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("bat_amt_rslt_cd", "batAmtRsltCd");
		return this.hashFields;
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
	 * @return tmlInvTpCd
	 */
	public String getTmlInvTpCd() {
		return this.tmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return atbDt
	 */
	public String getAtbDt() {
		return this.atbDt;
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
	 * @return expnAudSeq
	 */
	public String getExpnAudSeq() {
		return this.expnAudSeq;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return expnAudStsNm
	 */
	public String getExpnAudStsNm() {
		return this.expnAudStsNm;
	}
	
	/**
	 * Column Info
	 * @return batEstmVolRsltCd
	 */
	public String getBatEstmVolRsltCd() {
		return this.batEstmVolRsltCd;
	}
	
	/**
	 * Column Info
	 * @return fmPrdDt
	 */
	public String getFmPrdDt() {
		return this.fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return invCfmDt
	 */
	public String getInvCfmDt() {
		return this.invCfmDt;
	}
	
	/**
	 * Column Info
	 * @return expnAudStsCd
	 */
	public String getExpnAudStsCd() {
		return this.expnAudStsCd;
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
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return batVolRsltCd
	 */
	public String getBatVolRsltCd() {
		return this.batVolRsltCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return batAmtRsltCd
	 */
	public String getBatAmtRsltCd() {
		return this.batAmtRsltCd;
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
	 * @param tmlInvTpCd
	 */
	public void setTmlInvTpCd(String tmlInvTpCd) {
		this.tmlInvTpCd = tmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param atbDt
	 */
	public void setAtbDt(String atbDt) {
		this.atbDt = atbDt;
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
	 * @param expnAudSeq
	 */
	public void setExpnAudSeq(String expnAudSeq) {
		this.expnAudSeq = expnAudSeq;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param expnAudStsNm
	 */
	public void setExpnAudStsNm(String expnAudStsNm) {
		this.expnAudStsNm = expnAudStsNm;
	}
	
	/**
	 * Column Info
	 * @param batEstmVolRsltCd
	 */
	public void setBatEstmVolRsltCd(String batEstmVolRsltCd) {
		this.batEstmVolRsltCd = batEstmVolRsltCd;
	}
	
	/**
	 * Column Info
	 * @param fmPrdDt
	 */
	public void setFmPrdDt(String fmPrdDt) {
		this.fmPrdDt = fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param invCfmDt
	 */
	public void setInvCfmDt(String invCfmDt) {
		this.invCfmDt = invCfmDt;
	}
	
	/**
	 * Column Info
	 * @param expnAudStsCd
	 */
	public void setExpnAudStsCd(String expnAudStsCd) {
		this.expnAudStsCd = expnAudStsCd;
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
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param batVolRsltCd
	 */
	public void setBatVolRsltCd(String batVolRsltCd) {
		this.batVolRsltCd = batVolRsltCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param batAmtRsltCd
	 */
	public void setBatAmtRsltCd(String batAmtRsltCd) {
		this.batAmtRsltCd = batAmtRsltCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTmlInvTpCd(JSPUtil.getParameter(request, prefix + "tml_inv_tp_cd", ""));
		setAtbDt(JSPUtil.getParameter(request, prefix + "atb_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setExpnAudSeq(JSPUtil.getParameter(request, prefix + "expn_aud_seq", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExpnAudStsNm(JSPUtil.getParameter(request, prefix + "expn_aud_sts_nm", ""));
		setBatEstmVolRsltCd(JSPUtil.getParameter(request, prefix + "bat_estm_vol_rslt_cd", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setExpnAudStsCd(JSPUtil.getParameter(request, prefix + "expn_aud_sts_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBatVolRsltCd(JSPUtil.getParameter(request, prefix + "bat_vol_rslt_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setBatAmtRsltCd(JSPUtil.getParameter(request, prefix + "bat_amt_rslt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesInvoiceConfirmVO[]
	 */
	public TesInvoiceConfirmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesInvoiceConfirmVO[]
	 */
	public TesInvoiceConfirmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesInvoiceConfirmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_tp_cd", length));
			String[] atbDt = (JSPUtil.getParameter(request, prefix	+ "atb_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] expnAudSeq = (JSPUtil.getParameter(request, prefix	+ "expn_aud_seq", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expnAudStsNm = (JSPUtil.getParameter(request, prefix	+ "expn_aud_sts_nm", length));
			String[] batEstmVolRsltCd = (JSPUtil.getParameter(request, prefix	+ "bat_estm_vol_rslt_cd", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] expnAudStsCd = (JSPUtil.getParameter(request, prefix	+ "expn_aud_sts_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] batVolRsltCd = (JSPUtil.getParameter(request, prefix	+ "bat_vol_rslt_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] batAmtRsltCd = (JSPUtil.getParameter(request, prefix	+ "bat_amt_rslt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesInvoiceConfirmVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tmlInvTpCd[i] != null)
					model.setTmlInvTpCd(tmlInvTpCd[i]);
				if (atbDt[i] != null)
					model.setAtbDt(atbDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (expnAudSeq[i] != null)
					model.setExpnAudSeq(expnAudSeq[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expnAudStsNm[i] != null)
					model.setExpnAudStsNm(expnAudStsNm[i]);
				if (batEstmVolRsltCd[i] != null)
					model.setBatEstmVolRsltCd(batEstmVolRsltCd[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (expnAudStsCd[i] != null)
					model.setExpnAudStsCd(expnAudStsCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (batVolRsltCd[i] != null)
					model.setBatVolRsltCd(batVolRsltCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (batAmtRsltCd[i] != null)
					model.setBatAmtRsltCd(batAmtRsltCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesInvoiceConfirmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesInvoiceConfirmVO[]
	 */
	public TesInvoiceConfirmVO[] getTesInvoiceConfirmVOs(){
		TesInvoiceConfirmVO[] vos = (TesInvoiceConfirmVO[])models.toArray(new TesInvoiceConfirmVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvTpCd = this.tmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt = this.atbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudSeq = this.expnAudSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudStsNm = this.expnAudStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batEstmVolRsltCd = this.batEstmVolRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudStsCd = this.expnAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batVolRsltCd = this.batVolRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batAmtRsltCd = this.batAmtRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
