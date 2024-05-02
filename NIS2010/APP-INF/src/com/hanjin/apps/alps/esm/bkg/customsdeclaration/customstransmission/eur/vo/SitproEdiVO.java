/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SitproEdiVO.java
*@FileTitle : SitproEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.11.27 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SitproEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitproEdiVO> models = new ArrayList<SitproEdiVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String compId = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String msncfm = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bkgSpeAk = null;
	/* Column Info */
	private String bkgCgoTp = null;
	/* Column Info */
	private String bkgSpeBb = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String bndCd = null;
	/* Column Info */
	private String blts = null;
	/* Column Info */
	private String bltp = null;
	/* Column Info */
	private String bkgSpeDg = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String bkgSpeRd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgSpeRf = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitproEdiVO() {}

	public SitproEdiVO(String ibflag, String pagerows, String vvdCd, String bkgNo, String porCd, String polCd, String podCd, String docUsrId, String ofcCd, String bndCd, String cntrNo, String bkgCgoTp, String bkgSpeRf, String bkgSpeDg, String bkgSpeAk, String bkgSpeBb, String cmdtDesc, String cmdtCd, String bkgSpeRd, String compId, String mrnNo, String blts, String bltp, String msncfm, String cmdtNm, String repCmdtNm) {
		this.porCd = porCd;
		this.compId = compId;
		this.docUsrId = docUsrId;
		this.msncfm = msncfm;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.cmdtCd = cmdtCd;
		this.bkgSpeAk = bkgSpeAk;
		this.bkgCgoTp = bkgCgoTp;
		this.bkgSpeBb = bkgSpeBb;
		this.repCmdtNm = repCmdtNm;
		this.bndCd = bndCd;
		this.blts = blts;
		this.bltp = bltp;
		this.bkgSpeDg = bkgSpeDg;
		this.cmdtNm = cmdtNm;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.cmdtDesc = cmdtDesc;
		this.bkgSpeRd = bkgSpeRd;
		this.cntrNo = cntrNo;
		this.bkgSpeRf = bkgSpeRf;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("comp_id", getCompId());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("msncfm", getMsncfm());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bkg_spe_ak", getBkgSpeAk());
		this.hashColumns.put("bkg_cgo_tp", getBkgCgoTp());
		this.hashColumns.put("bkg_spe_bb", getBkgSpeBb());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("bnd_cd", getBndCd());
		this.hashColumns.put("blts", getBlts());
		this.hashColumns.put("bltp", getBltp());
		this.hashColumns.put("bkg_spe_dg", getBkgSpeDg());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("bkg_spe_rd", getBkgSpeRd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkg_spe_rf", getBkgSpeRf());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("comp_id", "compId");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("msncfm", "msncfm");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bkg_spe_ak", "bkgSpeAk");
		this.hashFields.put("bkg_cgo_tp", "bkgCgoTp");
		this.hashFields.put("bkg_spe_bb", "bkgSpeBb");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("bnd_cd", "bndCd");
		this.hashFields.put("blts", "blts");
		this.hashFields.put("bltp", "bltp");
		this.hashFields.put("bkg_spe_dg", "bkgSpeDg");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("bkg_spe_rd", "bkgSpeRd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkg_spe_rf", "bkgSpeRf");
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
	 * @return compId
	 */
	public String getCompId() {
		return this.compId;
	}
	
	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
	}
	
	/**
	 * Column Info
	 * @return msncfm
	 */
	public String getMsncfm() {
		return this.msncfm;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeAk
	 */
	public String getBkgSpeAk() {
		return this.bkgSpeAk;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTp
	 */
	public String getBkgCgoTp() {
		return this.bkgCgoTp;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeBb
	 */
	public String getBkgSpeBb() {
		return this.bkgSpeBb;
	}
	
	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return bndCd
	 */
	public String getBndCd() {
		return this.bndCd;
	}
	
	/**
	 * Column Info
	 * @return blts
	 */
	public String getBlts() {
		return this.blts;
	}
	
	/**
	 * Column Info
	 * @return bltp
	 */
	public String getBltp() {
		return this.bltp;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeDg
	 */
	public String getBkgSpeDg() {
		return this.bkgSpeDg;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeRd
	 */
	public String getBkgSpeRd() {
		return this.bkgSpeRd;
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
	 * @return bkgSpeRf
	 */
	public String getBkgSpeRf() {
		return this.bkgSpeRf;
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
	 * @param compId
	 */
	public void setCompId(String compId) {
		this.compId = compId;
	}
	
	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
	}
	
	/**
	 * Column Info
	 * @param msncfm
	 */
	public void setMsncfm(String msncfm) {
		this.msncfm = msncfm;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeAk
	 */
	public void setBkgSpeAk(String bkgSpeAk) {
		this.bkgSpeAk = bkgSpeAk;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTp
	 */
	public void setBkgCgoTp(String bkgCgoTp) {
		this.bkgCgoTp = bkgCgoTp;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeBb
	 */
	public void setBkgSpeBb(String bkgSpeBb) {
		this.bkgSpeBb = bkgSpeBb;
	}
	
	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param bndCd
	 */
	public void setBndCd(String bndCd) {
		this.bndCd = bndCd;
	}
	
	/**
	 * Column Info
	 * @param blts
	 */
	public void setBlts(String blts) {
		this.blts = blts;
	}
	
	/**
	 * Column Info
	 * @param bltp
	 */
	public void setBltp(String bltp) {
		this.bltp = bltp;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeDg
	 */
	public void setBkgSpeDg(String bkgSpeDg) {
		this.bkgSpeDg = bkgSpeDg;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeRd
	 */
	public void setBkgSpeRd(String bkgSpeRd) {
		this.bkgSpeRd = bkgSpeRd;
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
	 * @param bkgSpeRf
	 */
	public void setBkgSpeRf(String bkgSpeRf) {
		this.bkgSpeRf = bkgSpeRf;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCompId(JSPUtil.getParameter(request, "comp_id", ""));
		setDocUsrId(JSPUtil.getParameter(request, "doc_usr_id", ""));
		setMsncfm(JSPUtil.getParameter(request, "msncfm", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setBkgSpeAk(JSPUtil.getParameter(request, "bkg_spe_ak", ""));
		setBkgCgoTp(JSPUtil.getParameter(request, "bkg_cgo_tp", ""));
		setBkgSpeBb(JSPUtil.getParameter(request, "bkg_spe_bb", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setBndCd(JSPUtil.getParameter(request, "bnd_cd", ""));
		setBlts(JSPUtil.getParameter(request, "blts", ""));
		setBltp(JSPUtil.getParameter(request, "bltp", ""));
		setBkgSpeDg(JSPUtil.getParameter(request, "bkg_spe_dg", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setBkgSpeRd(JSPUtil.getParameter(request, "bkg_spe_rd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBkgSpeRf(JSPUtil.getParameter(request, "bkg_spe_rf", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitproEdiVO[]
	 */
	public SitproEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitproEdiVO[]
	 */
	public SitproEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitproEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] compId = (JSPUtil.getParameter(request, prefix	+ "comp_id", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] msncfm = (JSPUtil.getParameter(request, prefix	+ "msncfm", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bkgSpeAk = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_ak", length));
			String[] bkgCgoTp = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp", length));
			String[] bkgSpeBb = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_bb", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] bndCd = (JSPUtil.getParameter(request, prefix	+ "bnd_cd", length));
			String[] blts = (JSPUtil.getParameter(request, prefix	+ "blts", length));
			String[] bltp = (JSPUtil.getParameter(request, prefix	+ "bltp", length));
			String[] bkgSpeDg = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_dg", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] bkgSpeRd = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgSpeRf = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rf", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitproEdiVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (compId[i] != null)
					model.setCompId(compId[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (msncfm[i] != null)
					model.setMsncfm(msncfm[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bkgSpeAk[i] != null)
					model.setBkgSpeAk(bkgSpeAk[i]);
				if (bkgCgoTp[i] != null)
					model.setBkgCgoTp(bkgCgoTp[i]);
				if (bkgSpeBb[i] != null)
					model.setBkgSpeBb(bkgSpeBb[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (bndCd[i] != null)
					model.setBndCd(bndCd[i]);
				if (blts[i] != null)
					model.setBlts(blts[i]);
				if (bltp[i] != null)
					model.setBltp(bltp[i]);
				if (bkgSpeDg[i] != null)
					model.setBkgSpeDg(bkgSpeDg[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (bkgSpeRd[i] != null)
					model.setBkgSpeRd(bkgSpeRd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgSpeRf[i] != null)
					model.setBkgSpeRf(bkgSpeRf[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitproEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitproEdiVO[]
	 */
	public SitproEdiVO[] getSitproEdiVOs(){
		SitproEdiVO[] vos = (SitproEdiVO[])models.toArray(new SitproEdiVO[models.size()]);
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
		this.compId = this.compId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msncfm = this.msncfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeAk = this.bkgSpeAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTp = this.bkgCgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeBb = this.bkgSpeBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndCd = this.bndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blts = this.blts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bltp = this.bltp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeDg = this.bkgSpeDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRd = this.bkgSpeRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRf = this.bkgSpeRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
