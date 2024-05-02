/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InDblWblInVO.java
*@FileTitle : InDblWblInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.09.18 이일민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InDblWblInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InDblWblInVO> models = new ArrayList<InDblWblInVO>();
	
	/* Column Info */
	private String blObrdDtFrom = null;
	/* Column Info */
	private String blObrdDtTo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String oblIssDtFrom = null;
	/* Column Info */
	private String oblIssDtTo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String faxProcStsCd = null;
	/* Column Info */
	private String emlProcStsCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String etaDtFrom= null;
	/* Column Info */
	private String etaDtTo = null;
	/* Column Info */
	private String cgoChkOpt1 = null;
	/* Column Info */
	private String cgoChkOpt2 = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InDblWblInVO() {}

	public InDblWblInVO(String ibflag, String pagerows, String blTpCd, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String bkgStsCd, String bkgCustTpCd, String custCntCd, String custSeq, String custNm, String blNo, String blObrdDtFrom, String blObrdDtTo, String oblIssDtFrom, String oblIssDtTo, String faxProcStsCd, String emlProcStsCd, String scNo, String etaDtFrom, String etaDtTo, String cgoChkOpt1, String cgoChkOpt2) {
		this.blObrdDtFrom = blObrdDtFrom;
		this.blObrdDtTo = blObrdDtTo;
		this.vslCd = vslCd;
		this.oblIssDtFrom = oblIssDtFrom;
		this.oblIssDtTo = oblIssDtTo;
		this.custNm = custNm;
		this.bkgStsCd = bkgStsCd;
		this.skdVoyNo = skdVoyNo;
		this.custSeq = custSeq;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.blTpCd = blTpCd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custCntCd = custCntCd;
		this.faxProcStsCd = faxProcStsCd;
		this.emlProcStsCd = emlProcStsCd;
		this.scNo = scNo;
		this.etaDtFrom = etaDtFrom;
		this.etaDtTo = etaDtTo;
		this.cgoChkOpt1 = cgoChkOpt1;
		this.cgoChkOpt2 = cgoChkOpt2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_obrd_dt_from", getBlObrdDtFrom());
		this.hashColumns.put("bl_obrd_dt_to", getBlObrdDtTo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("obl_iss_dt_from", getOblIssDtFrom());
		this.hashColumns.put("obl_iss_dt_to", getOblIssDtTo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("fax_proc_sts_cd", getFaxProcStsCd());
		this.hashColumns.put("eml_proc_sts_cd", getEmlProcStsCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("eta_dt_from", getEtaDtFrom());
		this.hashColumns.put("eta_dt_to", getEtaDtTo());
		this.hashColumns.put("cgo_chk_opt1", getCgoChkOpt1());
		this.hashColumns.put("cgo_chk_opt2", getCgoChkOpt2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_obrd_dt_from", "blObrdDtFrom");
		this.hashFields.put("bl_obrd_dt_to", "blObrdDtTo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("obl_iss_dt_from", "oblIssDtFrom");
		this.hashFields.put("obl_iss_dt_to", "oblIssDtTo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("fax_proc_sts_cd", "faxProcStsCd");
		this.hashFields.put("eml_proc_sts_cd", "emlProcStsCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("eta_dt_from", "etaDtFrom");
		this.hashFields.put("eta_dt_to", "etaDtTo");
		this.hashFields.put("cgo_chk_opt1", "cgoChkOpt1");
		this.hashFields.put("cgo_chk_opt2", "cgoChkOpt2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blObrdDtFrom
	 */
	public String getBlObrdDtFrom() {
		return this.blObrdDtFrom;
	}
	
	/**
	 * Column Info
	 * @return blObrdDtTo
	 */
	public String getBlObrdDtTo() {
		return this.blObrdDtTo;
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
	 * @return oblIssDtFrom
	 */
	public String getOblIssDtFrom() {
		return this.oblIssDtFrom;
	}
	
	/**
	 * Column Info
	 * @return oblIssDtTo
	 */
	public String getOblIssDtTo() {
		return this.oblIssDtTo;
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
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}

	/**
	 * Column Info
	 * @return faxProcStsCd
	 */
	public String getFaxProcStsCd() {
		return this.faxProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return emlProcStsCd
	 */
	public String getEmlProcStsCd() {
		return this.emlProcStsCd;
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
	 * @return etaDtFrom
	 */
	public String getEtaDtFrom() {
		return this.etaDtFrom;
	}

	/**
	 * Column Info
	 * @return etaDtTo
	 */
	public String getEtaDtTo() {
		return this.etaDtTo;
	}
	
	/**
	 * Column Info
	 * @return cgoChkOpt1
	 */
	public String getCgoChkOpt1() {
		return this.cgoChkOpt1;
	}
	
	/**
	 * Column Info
	 * @return cgoChkOpt2
	 */
	public String getCgoChkOpt2() {
		return this.cgoChkOpt2;
	}
	
	
	
	/**
	 * Column Info
	 * @param blObrdDtFrom
	 */
	public void setBlObrdDtFrom(String blObrdDtFrom) {
		this.blObrdDtFrom = blObrdDtFrom;
	}
	
	/**
	 * Column Info
	 * @param blObrdDtTo
	 */
	public void setBlObrdDtTo(String blObrdDtTo) {
		this.blObrdDtTo = blObrdDtTo;
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
	 * @param oblIssDtFrom
	 */
	public void setOblIssDtFrom(String oblIssDtFrom) {
		this.oblIssDtFrom = oblIssDtFrom;
	}
	
	/**
	 * Column Info
	 * @param oblIssDtTo
	 */
	public void setOblIssDtTo(String oblIssDtTo) {
		this.oblIssDtTo = oblIssDtTo;
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
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
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
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param faxProcStsCd
	 */
	public void setFaxProcStsCd(String faxProcStsCd) {
		this.faxProcStsCd = faxProcStsCd;
	}

	/**
	 * Column Info
	 * @param emlProcStsCd
	 */
	public void setEmlProcStsCd(String emlProcStsCd) {
		this.emlProcStsCd = emlProcStsCd;
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
	 * @param etaDtFrom
	 */
	public void setEtaDtFrom(String etaDtFrom) {
		this.etaDtFrom = etaDtFrom;
	}

	/**
	 * Column Info
	 * @param etaDtTo
	 */
	public void setEtaDtTo(String etaDtTo) {
		this.etaDtTo = etaDtTo;
	}
	
	/**
	 * Column Info
	 * @param cgoChkOpt1
	 */
	public void setCgoChkOpt1(String cgoChkOpt1) {
		this.cgoChkOpt1 = cgoChkOpt1;
	}
	
	/**
	 * Column Info
	 * @param cgoChkOpt2
	 */
	public void setCgoChkOpt2(String cgoChkOpt2) {
		this.cgoChkOpt2 = cgoChkOpt2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlObrdDtFrom(JSPUtil.getParameter(request, "bl_obrd_dt_from", ""));
		setBlObrdDtTo(JSPUtil.getParameter(request, "bl_obrd_dt_to", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setOblIssDtFrom(JSPUtil.getParameter(request, "obl_iss_dt_from", ""));
		setOblIssDtTo(JSPUtil.getParameter(request, "obl_iss_dt_to", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setFaxProcStsCd(JSPUtil.getParameter(request, "fax_proc_sts_cd", ""));
		setEmlProcStsCd(JSPUtil.getParameter(request, "eml_proc_sts_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setEtaDtFrom(JSPUtil.getParameter(request, "eta_dt_from", ""));
		setEtaDtTo(JSPUtil.getParameter(request, "eta_dt_to", ""));
		setCgoChkOpt1(JSPUtil.getParameter(request, "cgo_chk_opt1", ""));
		setCgoChkOpt2(JSPUtil.getParameter(request, "cgo_chk_opt2", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InDblWblInVO[]
	 */
	public InDblWblInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InDblWblInVO[]
	 */
	public InDblWblInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InDblWblInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blObrdDtFrom = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_from", length));
			String[] blObrdDtTo = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_to", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] oblIssDtFrom = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt_from", length));
			String[] oblIssDtTo = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt_to", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] faxProcStsCd = (JSPUtil.getParameter(request, prefix	+ "fax_proc_sts_cd", length));
			String[] emlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "eml_proc_sts_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] etaDtFrom = (JSPUtil.getParameter(request, prefix	+ "eta_dt_from", length));
			String[] etaDtTo = (JSPUtil.getParameter(request, prefix	+ "eta_dt_to", length));
			String[] cgoChkOpt1 = (JSPUtil.getParameter(request, prefix	+ "cgo_chk_opt1", length));
			String[] cgoChkOpt2 = (JSPUtil.getParameter(request, prefix	+ "cgo_chk_opt2", length));

			for (int i = 0; i < length; i++) {
				model = new InDblWblInVO();
				if (blObrdDtFrom[i] != null)
					model.setBlObrdDtFrom(blObrdDtFrom[i]);
				if (blObrdDtTo[i] != null)
					model.setBlObrdDtTo(blObrdDtTo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (oblIssDtFrom[i] != null)
					model.setOblIssDtFrom(oblIssDtFrom[i]);
				if (oblIssDtTo[i] != null)
					model.setOblIssDtTo(oblIssDtTo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (faxProcStsCd[i] != null)
					model.setFaxProcStsCd(faxProcStsCd[i]);
				if (emlProcStsCd[i] != null)
					model.setEmlProcStsCd(emlProcStsCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (etaDtFrom[i] != null)
					model.setEtaDtFrom(etaDtFrom[i]);
				if (etaDtTo[i] != null)
					model.setEtaDtTo(etaDtTo[i]);
				if (cgoChkOpt1[i] != null)
					model.setCgoChkOpt1(cgoChkOpt1[i]);
				if (cgoChkOpt2[i] != null)
					model.setCgoChkOpt2(cgoChkOpt2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInDblWblInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InDblWblInVO[]
	 */
	public InDblWblInVO[] getInDblWblInVOs(){
		InDblWblInVO[] vos = (InDblWblInVO[])models.toArray(new InDblWblInVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.blObrdDtFrom = this.blObrdDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtTo = this.blObrdDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDtFrom = this.oblIssDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDtTo = this.oblIssDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxProcStsCd = this.faxProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlProcStsCd = this.emlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDtFrom = this.etaDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDtTo = this.etaDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoChkOpt1 = this.cgoChkOpt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoChkOpt2 = this.cgoChkOpt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
