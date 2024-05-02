/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AustrailiaManifestTransmitVO.java
*@FileTitle : AustrailiaManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 이경원
*@LastVersion : 1.0
* 2011.12.26 이경원 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이경원
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AustrailiaManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AustrailiaManifestTransmitVO> models = new ArrayList<AustrailiaManifestTransmitVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String frmSkdVoyNo = null;
	/* Column Info */
	private String st9 = null;
	/* Column Info */
	private String frmPodCd = null;
	/* Column Info */
	private String transGubun = null;
	/* Column Info */
	private String frmVslCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String st10 = null;
	/* Column Info */
	private String bkgSpeAk = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String frmPolCd = null;
	/* Column Info */
	private String bkgCgoTp = null;
	/* Column Info */
	private String frmSkdDirCd = null;
	/* Column Info */
	private String bkgSpeBb = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ediInd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bkgSpeDg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgSpeRd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgSpeRf = null;
	/* Column Info */
	private String frmEdiInd = null;
	/* Column Info */
	private String frmTransGubun = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AustrailiaManifestTransmitVO() {}

	public AustrailiaManifestTransmitVO(String ibflag, String pagerows, String vslCd, String bkgCgoTp, String bkgSpeBb, String st9, String skdVoyNo, String transGubun, String bkgSpeDg, String skdDirCd, String ediInd, String podCd, String polCd, String bkgNo, String bkgSpeRd, String cmdtCd, String cmdtDesc, String cntrNo, String st10, String bkgSpeRf, String bkgSpeAk, String portCd, String frmVslCd, String frmSkdVoyNo, String frmSkdDirCd, String frmPolCd, String frmPodCd, String frmTransGubun, String frmEdiInd) {
		this.vslCd = vslCd;
		this.frmSkdVoyNo = frmSkdVoyNo;
		this.st9 = st9;
		this.frmPodCd = frmPodCd;
		this.transGubun = transGubun;
		this.frmVslCd = frmVslCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.st10 = st10;
		this.bkgSpeAk = bkgSpeAk;
		this.portCd = portCd;
		this.frmPolCd = frmPolCd;
		this.bkgCgoTp = bkgCgoTp;
		this.frmSkdDirCd = frmSkdDirCd;
		this.bkgSpeBb = bkgSpeBb;
		this.skdVoyNo = skdVoyNo;
		this.ediInd = ediInd;
		this.skdDirCd = skdDirCd;
		this.bkgSpeDg = bkgSpeDg;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.bkgSpeRd = bkgSpeRd;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.bkgSpeRf = bkgSpeRf;
		this.frmEdiInd = frmEdiInd;
		this.frmTransGubun = frmTransGubun;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("frm_skd_voy_no", getFrmSkdVoyNo());
		this.hashColumns.put("st_9", getSt9());
		this.hashColumns.put("frm_pod_cd", getFrmPodCd());
		this.hashColumns.put("trans_gubun", getTransGubun());
		this.hashColumns.put("frm_vsl_cd", getFrmVslCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("st_10", getSt10());
		this.hashColumns.put("bkg_spe_ak", getBkgSpeAk());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("frm_pol_cd", getFrmPolCd());
		this.hashColumns.put("bkg_cgo_tp", getBkgCgoTp());
		this.hashColumns.put("frm_skd_dir_cd", getFrmSkdDirCd());
		this.hashColumns.put("bkg_spe_bb", getBkgSpeBb());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("edi_ind", getEdiInd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bkg_spe_dg", getBkgSpeDg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_spe_rd", getBkgSpeRd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkg_spe_rf", getBkgSpeRf());
		this.hashColumns.put("frm_edi_ind", getFrmEdiInd());
		this.hashColumns.put("frm_trans_gubun", getFrmTransGubun());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("frm_skd_voy_no", "frmSkdVoyNo");
		this.hashFields.put("st_9", "st9");
		this.hashFields.put("frm_pod_cd", "frmPodCd");
		this.hashFields.put("trans_gubun", "transGubun");
		this.hashFields.put("frm_vsl_cd", "frmVslCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("st_10", "st10");
		this.hashFields.put("bkg_spe_ak", "bkgSpeAk");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("frm_pol_cd", "frmPolCd");
		this.hashFields.put("bkg_cgo_tp", "bkgCgoTp");
		this.hashFields.put("frm_skd_dir_cd", "frmSkdDirCd");
		this.hashFields.put("bkg_spe_bb", "bkgSpeBb");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("edi_ind", "ediInd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bkg_spe_dg", "bkgSpeDg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_spe_rd", "bkgSpeRd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkg_spe_rf", "bkgSpeRf");
		this.hashFields.put("frm_edi_ind", "frmEdiInd");
		this.hashFields.put("frm_trans_gubun", "frmTransGubun");
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
	 * @return frmSkdVoyNo
	 */
	public String getFrmSkdVoyNo() {
		return this.frmSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return st9
	 */
	public String getSt9() {
		return this.st9;
	}
	
	/**
	 * Column Info
	 * @return frmPodCd
	 */
	public String getFrmPodCd() {
		return this.frmPodCd;
	}
	
	/**
	 * Column Info
	 * @return transGubun
	 */
	public String getTransGubun() {
		return this.transGubun;
	}
	
	/**
	 * Column Info
	 * @return frmVslCd
	 */
	public String getFrmVslCd() {
		return this.frmVslCd;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return st10
	 */
	public String getSt10() {
		return this.st10;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return frmPolCd
	 */
	public String getFrmPolCd() {
		return this.frmPolCd;
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
	 * @return frmSkdDirCd
	 */
	public String getFrmSkdDirCd() {
		return this.frmSkdDirCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ediInd
	 */
	public String getEdiInd() {
		return this.ediInd;
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
	 * @return bkgSpeDg
	 */
	public String getBkgSpeDg() {
		return this.bkgSpeDg;
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
	 * @return bkgSpeRd
	 */
	public String getBkgSpeRd() {
		return this.bkgSpeRd;
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
	 * @return frmEdiInd
	 */
	public String getFrmEdiInd() {
		return this.frmEdiInd;
	}
	
	/**
	 * Column Info
	 * @return frmTransGubun
	 */
	public String getFrmTransGubun() {
		return this.frmTransGubun;
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
	 * @param frmSkdVoyNo
	 */
	public void setFrmSkdVoyNo(String frmSkdVoyNo) {
		this.frmSkdVoyNo = frmSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param st9
	 */
	public void setSt9(String st9) {
		this.st9 = st9;
	}
	
	/**
	 * Column Info
	 * @param frmPodCd
	 */
	public void setFrmPodCd(String frmPodCd) {
		this.frmPodCd = frmPodCd;
	}
	
	/**
	 * Column Info
	 * @param transGubun
	 */
	public void setTransGubun(String transGubun) {
		this.transGubun = transGubun;
	}
	
	/**
	 * Column Info
	 * @param frmVslCd
	 */
	public void setFrmVslCd(String frmVslCd) {
		this.frmVslCd = frmVslCd;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param st10
	 */
	public void setSt10(String st10) {
		this.st10 = st10;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param frmPolCd
	 */
	public void setFrmPolCd(String frmPolCd) {
		this.frmPolCd = frmPolCd;
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
	 * @param frmSkdDirCd
	 */
	public void setFrmSkdDirCd(String frmSkdDirCd) {
		this.frmSkdDirCd = frmSkdDirCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ediInd
	 */
	public void setEdiInd(String ediInd) {
		this.ediInd = ediInd;
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
	 * @param bkgSpeDg
	 */
	public void setBkgSpeDg(String bkgSpeDg) {
		this.bkgSpeDg = bkgSpeDg;
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
	 * @param bkgSpeRd
	 */
	public void setBkgSpeRd(String bkgSpeRd) {
		this.bkgSpeRd = bkgSpeRd;
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
	 * Column Info
	 * @param frmEdiInd
	 */
	public void setFrmEdiInd(String frmEdiInd) {
		this.frmEdiInd = frmEdiInd;
	}
	
	/**
	 * Column Info
	 * @param frmTransGubun
	 */
	public void setFrmTransGubun(String frmTransGubun) {
		this.frmTransGubun = frmTransGubun;
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
		setFrmSkdVoyNo(JSPUtil.getParameter(request, prefix + "frm_skd_voy_no", ""));
		setSt9(JSPUtil.getParameter(request, prefix + "st_9", ""));
		setFrmPodCd(JSPUtil.getParameter(request, prefix + "frm_pod_cd", ""));
		setTransGubun(JSPUtil.getParameter(request, prefix + "trans_gubun", ""));
		setFrmVslCd(JSPUtil.getParameter(request, prefix + "frm_vsl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setSt10(JSPUtil.getParameter(request, prefix + "st_10", ""));
		setBkgSpeAk(JSPUtil.getParameter(request, prefix + "bkg_spe_ak", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setFrmPolCd(JSPUtil.getParameter(request, prefix + "frm_pol_cd", ""));
		setBkgCgoTp(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp", ""));
		setFrmSkdDirCd(JSPUtil.getParameter(request, prefix + "frm_skd_dir_cd", ""));
		setBkgSpeBb(JSPUtil.getParameter(request, prefix + "bkg_spe_bb", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEdiInd(JSPUtil.getParameter(request, prefix + "edi_ind", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBkgSpeDg(JSPUtil.getParameter(request, prefix + "bkg_spe_dg", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBkgSpeRd(JSPUtil.getParameter(request, prefix + "bkg_spe_rd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setBkgSpeRf(JSPUtil.getParameter(request, prefix + "bkg_spe_rf", ""));
		setFrmEdiInd(JSPUtil.getParameter(request, prefix + "frm_edi_ind", ""));
		setFrmTransGubun(JSPUtil.getParameter(request, prefix + "frm_trans_gubun", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AustrailiaManifestTransmitVO[]
	 */
	public AustrailiaManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AustrailiaManifestTransmitVO[]
	 */
	public AustrailiaManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AustrailiaManifestTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] frmSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "frm_skd_voy_no", length));
			String[] st9 = (JSPUtil.getParameter(request, prefix	+ "st_9", length));
			String[] frmPodCd = (JSPUtil.getParameter(request, prefix	+ "frm_pod_cd", length));
			String[] transGubun = (JSPUtil.getParameter(request, prefix	+ "trans_gubun", length));
			String[] frmVslCd = (JSPUtil.getParameter(request, prefix	+ "frm_vsl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] st10 = (JSPUtil.getParameter(request, prefix	+ "st_10", length));
			String[] bkgSpeAk = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_ak", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] frmPolCd = (JSPUtil.getParameter(request, prefix	+ "frm_pol_cd", length));
			String[] bkgCgoTp = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp", length));
			String[] frmSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "frm_skd_dir_cd", length));
			String[] bkgSpeBb = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_bb", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ediInd = (JSPUtil.getParameter(request, prefix	+ "edi_ind", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] bkgSpeDg = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_dg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgSpeRd = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgSpeRf = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rf", length));
			String[] frmEdiInd = (JSPUtil.getParameter(request, prefix	+ "frm_edi_ind", length));
			String[] frmTransGubun = (JSPUtil.getParameter(request, prefix	+ "frm_trans_gubun", length));
			
			for (int i = 0; i < length; i++) {
				model = new AustrailiaManifestTransmitVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (frmSkdVoyNo[i] != null)
					model.setFrmSkdVoyNo(frmSkdVoyNo[i]);
				if (st9[i] != null)
					model.setSt9(st9[i]);
				if (frmPodCd[i] != null)
					model.setFrmPodCd(frmPodCd[i]);
				if (transGubun[i] != null)
					model.setTransGubun(transGubun[i]);
				if (frmVslCd[i] != null)
					model.setFrmVslCd(frmVslCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (st10[i] != null)
					model.setSt10(st10[i]);
				if (bkgSpeAk[i] != null)
					model.setBkgSpeAk(bkgSpeAk[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (frmPolCd[i] != null)
					model.setFrmPolCd(frmPolCd[i]);
				if (bkgCgoTp[i] != null)
					model.setBkgCgoTp(bkgCgoTp[i]);
				if (frmSkdDirCd[i] != null)
					model.setFrmSkdDirCd(frmSkdDirCd[i]);
				if (bkgSpeBb[i] != null)
					model.setBkgSpeBb(bkgSpeBb[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ediInd[i] != null)
					model.setEdiInd(ediInd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bkgSpeDg[i] != null)
					model.setBkgSpeDg(bkgSpeDg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgSpeRd[i] != null)
					model.setBkgSpeRd(bkgSpeRd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgSpeRf[i] != null)
					model.setBkgSpeRf(bkgSpeRf[i]);
				if (frmEdiInd[i] != null)
					model.setFrmEdiInd(frmEdiInd[i]);
				if (frmTransGubun[i] != null)
					model.setFrmTransGubun(frmTransGubun[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAustrailiaManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AustrailiaManifestTransmitVO[]
	 */
	public AustrailiaManifestTransmitVO[] getAustrailiaManifestTransmitVOs(){
		AustrailiaManifestTransmitVO[] vos = (AustrailiaManifestTransmitVO[])models.toArray(new AustrailiaManifestTransmitVO[models.size()]);
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
		this.frmSkdVoyNo = this.frmSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st9 = this.st9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPodCd = this.frmPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transGubun = this.transGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmVslCd = this.frmVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st10 = this.st10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeAk = this.bkgSpeAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPolCd = this.frmPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTp = this.bkgCgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSkdDirCd = this.frmSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeBb = this.bkgSpeBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediInd = this.ediInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeDg = this.bkgSpeDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRd = this.bkgSpeRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRf = this.bkgSpeRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmEdiInd = this.frmEdiInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmTransGubun = this.frmTransGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}