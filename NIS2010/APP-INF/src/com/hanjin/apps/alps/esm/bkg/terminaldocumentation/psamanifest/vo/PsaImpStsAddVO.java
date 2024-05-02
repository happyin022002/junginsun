/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsaImpStsAddVO.java
*@FileTitle : PsaImpStsAddVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.09 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaImpStsAddVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaImpStsAddVO> models = new ArrayList<PsaImpStsAddVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String psaVslNm = null;
	/* Column Info */
	private String nextSkdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fmCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String nextSkdVoyNo = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String psaVoyDirCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String nextVslCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String opCd = null;
	/* Column Info */
	private String sav = null;
	/* Column Info */
	private String rcFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaImpStsAddVO() {}

	public PsaImpStsAddVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String sealNo, String polCd, String podCd, String cntrWgt, String vslCd, String skdVoyNo, String skdDirCd, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String opCd, String fmCd, String nextVslCd, String nextSkdVoyNo, String nextSkdDirCd, String portCd, String cntrTpszCd, String psaVoyDirCd, String psaVslNm, String sav) {
		this.vslCd = vslCd;
		this.rdCgoFlg = rdCgoFlg;
		this.psaVslNm = psaVslNm;
		this.nextSkdDirCd = nextSkdDirCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.fmCd = fmCd;
		this.portCd = portCd;
		this.nextSkdVoyNo = nextSkdVoyNo;
		this.sealNo = sealNo;
		this.psaVoyDirCd = psaVoyDirCd;
		this.cntrWgt = cntrWgt;
		this.nextVslCd = nextVslCd;
		this.awkCgoFlg = awkCgoFlg;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.opCd = opCd;
		this.sav = sav;
		this.rcFlg = rcFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("psa_vsl_nm", getPsaVslNm());
		this.hashColumns.put("next_skd_dir_cd", getNextSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fm_cd", getFmCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("next_skd_voy_no", getNextSkdVoyNo());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("psa_voy_dir_cd", getPsaVoyDirCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("next_vsl_cd", getNextVslCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("sav", getSav());
		this.hashColumns.put("rc_flg", getRcFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("psa_vsl_nm", "psaVslNm");
		this.hashFields.put("next_skd_dir_cd", "nextSkdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fm_cd", "fmCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("next_skd_voy_no", "nextSkdVoyNo");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("psa_voy_dir_cd", "psaVoyDirCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("next_vsl_cd", "nextVslCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("sav", "sav");
		this.hashFields.put("rc_flg", "rcFlg");
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
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return psaVslNm
	 */
	public String getPsaVslNm() {
		return this.psaVslNm;
	}
	
	/**
	 * Column Info
	 * @return nextSkdDirCd
	 */
	public String getNextSkdDirCd() {
		return this.nextSkdDirCd;
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
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fmCd
	 */
	public String getFmCd() {
		return this.fmCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return nextSkdVoyNo
	 */
	public String getNextSkdVoyNo() {
		return this.nextSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}
	
	/**
	 * Column Info
	 * @return psaVoyDirCd
	 */
	public String getPsaVoyDirCd() {
		return this.psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return nextVslCd
	 */
	public String getNextVslCd() {
		return this.nextVslCd;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return opCd
	 */
	public String getOpCd() {
		return this.opCd;
	}
	
	/**
	 * Column Info
	 * @return sav
	 */
	public String getSav() {
		return this.sav;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
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
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param psaVslNm
	 */
	public void setPsaVslNm(String psaVslNm) {
		this.psaVslNm = psaVslNm;
	}
	
	/**
	 * Column Info
	 * @param nextSkdDirCd
	 */
	public void setNextSkdDirCd(String nextSkdDirCd) {
		this.nextSkdDirCd = nextSkdDirCd;
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
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fmCd
	 */
	public void setFmCd(String fmCd) {
		this.fmCd = fmCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param nextSkdVoyNo
	 */
	public void setNextSkdVoyNo(String nextSkdVoyNo) {
		this.nextSkdVoyNo = nextSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	
	/**
	 * Column Info
	 * @param psaVoyDirCd
	 */
	public void setPsaVoyDirCd(String psaVoyDirCd) {
		this.psaVoyDirCd = psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param nextVslCd
	 */
	public void setNextVslCd(String nextVslCd) {
		this.nextVslCd = nextVslCd;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param opCd
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * Column Info
	 * @param sav
	 */
	public void setSav(String sav) {
		this.sav = sav;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setPsaVslNm(JSPUtil.getParameter(request, "psa_vsl_nm", ""));
		setNextSkdDirCd(JSPUtil.getParameter(request, "next_skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setFmCd(JSPUtil.getParameter(request, "fm_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setNextSkdVoyNo(JSPUtil.getParameter(request, "next_skd_voy_no", ""));
		setSealNo(JSPUtil.getParameter(request, "seal_no", ""));
		setPsaVoyDirCd(JSPUtil.getParameter(request, "psa_voy_dir_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setNextVslCd(JSPUtil.getParameter(request, "next_vsl_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOpCd(JSPUtil.getParameter(request, "op_cd", ""));
		setSav(JSPUtil.getParameter(request, "sav", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaImpStsAddVO[]
	 */
	public PsaImpStsAddVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaImpStsAddVO[]
	 */
	public PsaImpStsAddVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaImpStsAddVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] psaVslNm = (JSPUtil.getParameter(request, prefix	+ "psa_vsl_nm", length));
			String[] nextSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "next_skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fmCd = (JSPUtil.getParameter(request, prefix	+ "fm_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] nextSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "next_skd_voy_no", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] psaVoyDirCd = (JSPUtil.getParameter(request, prefix	+ "psa_voy_dir_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] nextVslCd = (JSPUtil.getParameter(request, prefix	+ "next_vsl_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd", length));
			String[] sav = (JSPUtil.getParameter(request, prefix	+ "sav", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaImpStsAddVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (psaVslNm[i] != null)
					model.setPsaVslNm(psaVslNm[i]);
				if (nextSkdDirCd[i] != null)
					model.setNextSkdDirCd(nextSkdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fmCd[i] != null)
					model.setFmCd(fmCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (nextSkdVoyNo[i] != null)
					model.setNextSkdVoyNo(nextSkdVoyNo[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (psaVoyDirCd[i] != null)
					model.setPsaVoyDirCd(psaVoyDirCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (nextVslCd[i] != null)
					model.setNextVslCd(nextVslCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (opCd[i] != null)
					model.setOpCd(opCd[i]);
				if (sav[i] != null)
					model.setSav(sav[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaImpStsAddVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaImpStsAddVO[]
	 */
	public PsaImpStsAddVO[] getPsaImpStsAddVOs(){
		PsaImpStsAddVO[] vos = (PsaImpStsAddVO[])models.toArray(new PsaImpStsAddVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVslNm = this.psaVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextSkdDirCd = this.nextSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCd = this.fmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextSkdVoyNo = this.nextSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVoyDirCd = this.psaVoyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVslCd = this.nextVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sav = this.sav .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
