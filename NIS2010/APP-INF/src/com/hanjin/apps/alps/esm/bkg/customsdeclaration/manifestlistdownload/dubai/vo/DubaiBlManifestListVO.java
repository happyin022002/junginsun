/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiBlManifestListVO.java
*@FileTitle : DubaiBlManifestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.26 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DubaiBlManifestListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DubaiBlManifestListVO> models = new ArrayList<DubaiBlManifestListVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cnslCgoFlg = null;
	/* Column Info */
	private String vDuRotnNo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String duPckTpCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String orgPortCd = null;
	/* Column Info */
	private String duMrnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String duVoyAgnId = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String duCmdtCd = null;
	/* Column Info */
	private String duLineId = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String duTrdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String duCgoCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String orgCntCd = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String duInstlNo = null;
	/* Column Info */
	private String duRotnNo = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DubaiBlManifestListVO() {}

	public DubaiBlManifestListVO(String ibflag, String pagerows, String chk, String duRotnNo, String blNo, String bkgNo, String duLineId, String duVoyAgnId, String orgPortCd, String porCd, String polCd, String podCd, String delCd, String duTrdCd, String duCgoCd, String cnslCgoFlg, String orgCntCd, String custNm, String custAddr, String duCmdtCd, String pckQty, String duPckTpCd, String cgoWgt, String grsWgt, String vslCd, String skdVoyNo, String skdDirCd, String vslNm, String etaDt, String clptSeq, String vDuRotnNo, String duInstlNo, String bkgCustTpCd, String duMrnNo) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.cnslCgoFlg = cnslCgoFlg;
		this.vDuRotnNo = vDuRotnNo;
		this.custNm = custNm;
		this.duPckTpCd = duPckTpCd;
		this.etaDt = etaDt;
		this.orgPortCd = orgPortCd;
		this.duMrnNo = duMrnNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.clptSeq = clptSeq;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.pckQty = pckQty;
		this.duVoyAgnId = duVoyAgnId;
		this.bkgCustTpCd = bkgCustTpCd;
		this.cgoWgt = cgoWgt;
		this.duCmdtCd = duCmdtCd;
		this.duLineId = duLineId;
		this.delCd = delCd;
		this.duTrdCd = duTrdCd;
		this.skdVoyNo = skdVoyNo;
		this.custAddr = custAddr;
		this.vslNm = vslNm;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.duCgoCd = duCgoCd;
		this.bkgNo = bkgNo;
		this.orgCntCd = orgCntCd;
		this.chk = chk;
		this.duInstlNo = duInstlNo;
		this.duRotnNo = duRotnNo;
		this.grsWgt = grsWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cnsl_cgo_flg", getCnslCgoFlg());
		this.hashColumns.put("v_du_rotn_no", getVDuRotnNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("du_pck_tp_cd", getDuPckTpCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("org_port_cd", getOrgPortCd());
		this.hashColumns.put("du_mrn_no", getDuMrnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("du_voy_agn_id", getDuVoyAgnId());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("du_cmdt_cd", getDuCmdtCd());
		this.hashColumns.put("du_line_id", getDuLineId());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("du_trd_cd", getDuTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("du_cgo_cd", getDuCgoCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("org_cnt_cd", getOrgCntCd());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("du_instl_no", getDuInstlNo());
		this.hashColumns.put("du_rotn_no", getDuRotnNo());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cnsl_cgo_flg", "cnslCgoFlg");
		this.hashFields.put("v_du_rotn_no", "vDuRotnNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("du_pck_tp_cd", "duPckTpCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("org_port_cd", "orgPortCd");
		this.hashFields.put("du_mrn_no", "duMrnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("du_voy_agn_id", "duVoyAgnId");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("du_cmdt_cd", "duCmdtCd");
		this.hashFields.put("du_line_id", "duLineId");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("du_trd_cd", "duTrdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("du_cgo_cd", "duCgoCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("org_cnt_cd", "orgCntCd");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("du_instl_no", "duInstlNo");
		this.hashFields.put("du_rotn_no", "duRotnNo");
		this.hashFields.put("grs_wgt", "grsWgt");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return cnslCgoFlg
	 */
	public String getCnslCgoFlg() {
		return this.cnslCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return vDuRotnNo
	 */
	public String getVDuRotnNo() {
		return this.vDuRotnNo;
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
	 * @return duPckTpCd
	 */
	public String getDuPckTpCd() {
		return this.duPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return orgPortCd
	 */
	public String getOrgPortCd() {
		return this.orgPortCd;
	}
	
	/**
	 * Column Info
	 * @return duMrnNo
	 */
	public String getDuMrnNo() {
		return this.duMrnNo;
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
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return duVoyAgnId
	 */
	public String getDuVoyAgnId() {
		return this.duVoyAgnId;
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
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
	}
	
	/**
	 * Column Info
	 * @return duCmdtCd
	 */
	public String getDuCmdtCd() {
		return this.duCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return duLineId
	 */
	public String getDuLineId() {
		return this.duLineId;
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
	 * @return duTrdCd
	 */
	public String getDuTrdCd() {
		return this.duTrdCd;
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
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
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
	 * @return duCgoCd
	 */
	public String getDuCgoCd() {
		return this.duCgoCd;
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
	 * @return orgCntCd
	 */
	public String getOrgCntCd() {
		return this.orgCntCd;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return duInstlNo
	 */
	public String getDuInstlNo() {
		return this.duInstlNo;
	}
	
	/**
	 * Column Info
	 * @return duRotnNo
	 */
	public String getDuRotnNo() {
		return this.duRotnNo;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param cnslCgoFlg
	 */
	public void setCnslCgoFlg(String cnslCgoFlg) {
		this.cnslCgoFlg = cnslCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param vDuRotnNo
	 */
	public void setVDuRotnNo(String vDuRotnNo) {
		this.vDuRotnNo = vDuRotnNo;
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
	 * @param duPckTpCd
	 */
	public void setDuPckTpCd(String duPckTpCd) {
		this.duPckTpCd = duPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param orgPortCd
	 */
	public void setOrgPortCd(String orgPortCd) {
		this.orgPortCd = orgPortCd;
	}
	
	/**
	 * Column Info
	 * @param duMrnNo
	 */
	public void setDuMrnNo(String duMrnNo) {
		this.duMrnNo = duMrnNo;
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
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param duVoyAgnId
	 */
	public void setDuVoyAgnId(String duVoyAgnId) {
		this.duVoyAgnId = duVoyAgnId;
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
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
	}
	
	/**
	 * Column Info
	 * @param duCmdtCd
	 */
	public void setDuCmdtCd(String duCmdtCd) {
		this.duCmdtCd = duCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param duLineId
	 */
	public void setDuLineId(String duLineId) {
		this.duLineId = duLineId;
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
	 * @param duTrdCd
	 */
	public void setDuTrdCd(String duTrdCd) {
		this.duTrdCd = duTrdCd;
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
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
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
	 * @param duCgoCd
	 */
	public void setDuCgoCd(String duCgoCd) {
		this.duCgoCd = duCgoCd;
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
	 * @param orgCntCd
	 */
	public void setOrgCntCd(String orgCntCd) {
		this.orgCntCd = orgCntCd;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param duInstlNo
	 */
	public void setDuInstlNo(String duInstlNo) {
		this.duInstlNo = duInstlNo;
	}
	
	/**
	 * Column Info
	 * @param duRotnNo
	 */
	public void setDuRotnNo(String duRotnNo) {
		this.duRotnNo = duRotnNo;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCnslCgoFlg(JSPUtil.getParameter(request, prefix + "cnsl_cgo_flg", ""));
		setVDuRotnNo(JSPUtil.getParameter(request, prefix + "v_du_rotn_no", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setDuPckTpCd(JSPUtil.getParameter(request, prefix + "du_pck_tp_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setOrgPortCd(JSPUtil.getParameter(request, prefix + "org_port_cd", ""));
		setDuMrnNo(JSPUtil.getParameter(request, prefix + "du_mrn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setDuVoyAgnId(JSPUtil.getParameter(request, prefix + "du_voy_agn_id", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setCgoWgt(JSPUtil.getParameter(request, prefix + "cgo_wgt", ""));
		setDuCmdtCd(JSPUtil.getParameter(request, prefix + "du_cmdt_cd", ""));
		setDuLineId(JSPUtil.getParameter(request, prefix + "du_line_id", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDuTrdCd(JSPUtil.getParameter(request, prefix + "du_trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDuCgoCd(JSPUtil.getParameter(request, prefix + "du_cgo_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOrgCntCd(JSPUtil.getParameter(request, prefix + "org_cnt_cd", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setDuInstlNo(JSPUtil.getParameter(request, prefix + "du_instl_no", ""));
		setDuRotnNo(JSPUtil.getParameter(request, prefix + "du_rotn_no", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DubaiBlManifestListVO[]
	 */
	public DubaiBlManifestListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DubaiBlManifestListVO[]
	 */
	public DubaiBlManifestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DubaiBlManifestListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cnslCgoFlg = (JSPUtil.getParameter(request, prefix	+ "cnsl_cgo_flg", length));
			String[] vDuRotnNo = (JSPUtil.getParameter(request, prefix	+ "v_du_rotn_no", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] duPckTpCd = (JSPUtil.getParameter(request, prefix	+ "du_pck_tp_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] orgPortCd = (JSPUtil.getParameter(request, prefix	+ "org_port_cd", length));
			String[] duMrnNo = (JSPUtil.getParameter(request, prefix	+ "du_mrn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] duVoyAgnId = (JSPUtil.getParameter(request, prefix	+ "du_voy_agn_id", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] duCmdtCd = (JSPUtil.getParameter(request, prefix	+ "du_cmdt_cd", length));
			String[] duLineId = (JSPUtil.getParameter(request, prefix	+ "du_line_id", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] duTrdCd = (JSPUtil.getParameter(request, prefix	+ "du_trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] duCgoCd = (JSPUtil.getParameter(request, prefix	+ "du_cgo_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] orgCntCd = (JSPUtil.getParameter(request, prefix	+ "org_cnt_cd", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] duInstlNo = (JSPUtil.getParameter(request, prefix	+ "du_instl_no", length));
			String[] duRotnNo = (JSPUtil.getParameter(request, prefix	+ "du_rotn_no", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DubaiBlManifestListVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cnslCgoFlg[i] != null)
					model.setCnslCgoFlg(cnslCgoFlg[i]);
				if (vDuRotnNo[i] != null)
					model.setVDuRotnNo(vDuRotnNo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (duPckTpCd[i] != null)
					model.setDuPckTpCd(duPckTpCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (orgPortCd[i] != null)
					model.setOrgPortCd(orgPortCd[i]);
				if (duMrnNo[i] != null)
					model.setDuMrnNo(duMrnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (duVoyAgnId[i] != null)
					model.setDuVoyAgnId(duVoyAgnId[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (duCmdtCd[i] != null)
					model.setDuCmdtCd(duCmdtCd[i]);
				if (duLineId[i] != null)
					model.setDuLineId(duLineId[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (duTrdCd[i] != null)
					model.setDuTrdCd(duTrdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (duCgoCd[i] != null)
					model.setDuCgoCd(duCgoCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (orgCntCd[i] != null)
					model.setOrgCntCd(orgCntCd[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (duInstlNo[i] != null)
					model.setDuInstlNo(duInstlNo[i]);
				if (duRotnNo[i] != null)
					model.setDuRotnNo(duRotnNo[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDubaiBlManifestListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DubaiBlManifestListVO[]
	 */
	public DubaiBlManifestListVO[] getDubaiBlManifestListVOs(){
		DubaiBlManifestListVO[] vos = (DubaiBlManifestListVO[])models.toArray(new DubaiBlManifestListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnslCgoFlg = this.cnslCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vDuRotnNo = this.vDuRotnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duPckTpCd = this.duPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPortCd = this.orgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duMrnNo = this.duMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duVoyAgnId = this.duVoyAgnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duCmdtCd = this.duCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duLineId = this.duLineId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duTrdCd = this.duTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duCgoCd = this.duCgoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntCd = this.orgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duInstlNo = this.duInstlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duRotnNo = this.duRotnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
