/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDPCSVolListOutVO.java
*@FileTitle : SearchDPCSVolListOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.15 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDPCSVolListOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDPCSVolListOutVO> models = new ArrayList<SearchDPCSVolListOutVO>();
	
	/* Column Info */
	private String queue = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String totSrVolAuditor = null;
	/* Column Info */
	private String totSrVolFofc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String totSrKindAddition = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String totBkgVol = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String totSrKind = null;
	/* Column Info */
	private String totSrKindBlCnfm = null;
	/* Column Info */
	private String totSrVolRater = null;
	/* Column Info */
	private String srKind = null;
	/* Column Info */
	private String pic = null;
	/* Column Info */
	private String totSrVolInputter = null;
	/* Column Info */
	private String totSrVol = null;
	/* Column Info */
	private String totStaffsAuditor = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String totStaffsInputter = null;
	/* Column Info */
	private String totSrKindAmend = null;
	/* Column Info */
	private String totStaffsFofc = null;
	/* Column Info */
	private String totStaffs = null;
	/* Column Info */
	private String totSrKindNew = null;
	/* Column Info */
	private String totStaffsRater = null;
	/* Column Info */
	private String docPart = null;
	/* Column Info */
	private String docPartEu = null;
	/* Column Info */
	private String docPartJp = null;
	/* Column Info */
	private String docPartSw = null;
	/* Column Info */
	private String docPartOt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDPCSVolListOutVO() {}

	public SearchDPCSVolListOutVO(String ibflag, String pagerows, String seqNo, String queue, String pic, String srKind, String bkgNo, String vvdCd, String polCd, String podCd, String srNo, String totStaffs, String totSrVol, String totSrKind, String totBkgVol, String totStaffsInputter, String totSrVolInputter, String totSrKindNew, String totStaffsRater, String totSrVolRater, String totSrKindAmend, String totStaffsAuditor, String totSrVolAuditor, String totSrKindBlCnfm, String totStaffsFofc, String totSrVolFofc, String totSrKindAddition, String docPart, String docPartEu, String docPartJp, String docPartSw, String docPartOt) {
		this.queue = queue;
		this.seqNo = seqNo;
		this.totSrVolAuditor = totSrVolAuditor;
		this.totSrVolFofc = totSrVolFofc;
		this.pagerows = pagerows;
		this.totSrKindAddition = totSrKindAddition;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.totBkgVol = totBkgVol;
		this.srNo = srNo;
		this.totSrKind = totSrKind;
		this.totSrKindBlCnfm = totSrKindBlCnfm;
		this.totSrVolRater = totSrVolRater;
		this.srKind = srKind;
		this.pic = pic;
		this.totSrVolInputter = totSrVolInputter;
		this.totSrVol = totSrVol;
		this.totStaffsAuditor = totStaffsAuditor;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.totStaffsInputter = totStaffsInputter;
		this.totSrKindAmend = totSrKindAmend;
		this.totStaffsFofc = totStaffsFofc;
		this.totStaffs = totStaffs;
		this.totSrKindNew = totSrKindNew;
		this.totStaffsRater = totStaffsRater;
		this.docPart = docPart;
		this.docPartEu = docPartEu;
		this.docPartJp = docPartJp;
		this.docPartSw = docPartSw;
		this.docPartOt = docPartOt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("queue", getQueue());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("tot_sr_vol_auditor", getTotSrVolAuditor());
		this.hashColumns.put("tot_sr_vol_fofc", getTotSrVolFofc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tot_sr_kind_addition", getTotSrKindAddition());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("tot_bkg_vol", getTotBkgVol());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("tot_sr_kind", getTotSrKind());
		this.hashColumns.put("tot_sr_kind_bl_cnfm", getTotSrKindBlCnfm());
		this.hashColumns.put("tot_sr_vol_rater", getTotSrVolRater());
		this.hashColumns.put("sr_kind", getSrKind());
		this.hashColumns.put("pic", getPic());
		this.hashColumns.put("tot_sr_vol_inputter", getTotSrVolInputter());
		this.hashColumns.put("tot_sr_vol", getTotSrVol());
		this.hashColumns.put("tot_staffs_auditor", getTotStaffsAuditor());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tot_staffs_inputter", getTotStaffsInputter());
		this.hashColumns.put("tot_sr_kind_amend", getTotSrKindAmend());
		this.hashColumns.put("tot_staffs_fofc", getTotStaffsFofc());
		this.hashColumns.put("tot_staffs", getTotStaffs());
		this.hashColumns.put("tot_sr_kind_new", getTotSrKindNew());
		this.hashColumns.put("tot_staffs_rater", getTotStaffsRater());
		this.hashColumns.put("doc_part", getDocPart());
		this.hashColumns.put("doc_part_eu", getDocPartEu());
		this.hashColumns.put("doc_part_jp", getDocPartJp());
		this.hashColumns.put("doc_part_sw", getDocPartSw());
		this.hashColumns.put("doc_part_ot", getDocPartOt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("queue", "queue");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("tot_sr_vol_auditor", "totSrVolAuditor");
		this.hashFields.put("tot_sr_vol_fofc", "totSrVolFofc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tot_sr_kind_addition", "totSrKindAddition");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("tot_bkg_vol", "totBkgVol");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("tot_sr_kind", "totSrKind");
		this.hashFields.put("tot_sr_kind_bl_cnfm", "totSrKindBlCnfm");
		this.hashFields.put("tot_sr_vol_rater", "totSrVolRater");
		this.hashFields.put("sr_kind", "srKind");
		this.hashFields.put("pic", "pic");
		this.hashFields.put("tot_sr_vol_inputter", "totSrVolInputter");
		this.hashFields.put("tot_sr_vol", "totSrVol");
		this.hashFields.put("tot_staffs_auditor", "totStaffsAuditor");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tot_staffs_inputter", "totStaffsInputter");
		this.hashFields.put("tot_sr_kind_amend", "totSrKindAmend");
		this.hashFields.put("tot_staffs_fofc", "totStaffsFofc");
		this.hashFields.put("tot_staffs", "totStaffs");
		this.hashFields.put("tot_sr_kind_new", "totSrKindNew");
		this.hashFields.put("tot_staffs_rater", "totStaffsRater");
		this.hashFields.put("doc_part", "docPart");
		this.hashFields.put("doc_part_eu", "docPartEu");
		this.hashFields.put("doc_part_jp", "docPartJp");
		this.hashFields.put("doc_part_sw", "docPartSw");
		this.hashFields.put("doc_part_ot", "docPartOt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return queue
	 */
	public String getQueue() {
		return this.queue;
	}
	
	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}
	
	/**
	 * Column Info
	 * @return totSrVolAuditor
	 */
	public String getTotSrVolAuditor() {
		return this.totSrVolAuditor;
	}
	
	/**
	 * Column Info
	 * @return totSrVolFofc
	 */
	public String getTotSrVolFofc() {
		return this.totSrVolFofc;
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
	 * @return totSrKindAddition
	 */
	public String getTotSrKindAddition() {
		return this.totSrKindAddition;
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
	 * @return totBkgVol
	 */
	public String getTotBkgVol() {
		return this.totBkgVol;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	
	/**
	 * Column Info
	 * @return totSrKind
	 */
	public String getTotSrKind() {
		return this.totSrKind;
	}
	
	/**
	 * Column Info
	 * @return totSrKindBlCnfm
	 */
	public String getTotSrKindBlCnfm() {
		return this.totSrKindBlCnfm;
	}
	
	/**
	 * Column Info
	 * @return totSrVolRater
	 */
	public String getTotSrVolRater() {
		return this.totSrVolRater;
	}
	
	/**
	 * Column Info
	 * @return srKind
	 */
	public String getSrKind() {
		return this.srKind;
	}
	
	/**
	 * Column Info
	 * @return pic
	 */
	public String getPic() {
		return this.pic;
	}
	
	/**
	 * Column Info
	 * @return totSrVolInputter
	 */
	public String getTotSrVolInputter() {
		return this.totSrVolInputter;
	}
	
	/**
	 * Column Info
	 * @return totSrVol
	 */
	public String getTotSrVol() {
		return this.totSrVol;
	}
	
	/**
	 * Column Info
	 * @return totStaffsAuditor
	 */
	public String getTotStaffsAuditor() {
		return this.totStaffsAuditor;
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
	 * @return totStaffsInputter
	 */
	public String getTotStaffsInputter() {
		return this.totStaffsInputter;
	}
	
	/**
	 * Column Info
	 * @return totSrKindAmend
	 */
	public String getTotSrKindAmend() {
		return this.totSrKindAmend;
	}
	
	/**
	 * Column Info
	 * @return totStaffsFofc
	 */
	public String getTotStaffsFofc() {
		return this.totStaffsFofc;
	}
	
	/**
	 * Column Info
	 * @return totStaffs
	 */
	public String getTotStaffs() {
		return this.totStaffs;
	}
	
	/**
	 * Column Info
	 * @return totSrKindNew
	 */
	public String getTotSrKindNew() {
		return this.totSrKindNew;
	}
	
	/**
	 * Column Info
	 * @return totStaffsRater
	 */
	public String getTotStaffsRater() {
		return this.totStaffsRater;
	}
	
	/**
	 * Column Info
	 * @return docPart
	 */
	public String getDocPart() {
		return this.docPart;
	}
	
	/**
	 * Column Info
	 * @return docPartEu
	 */
	public String getDocPartEu() {
		return this.docPartEu;
	}
	
	/**
	 * Column Info
	 * @return docPartJp
	 */
	public String getDocPartJp() {
		return this.docPartJp;
	}
	
	/**
	 * Column Info
	 * @return docPartOt
	 */
	public String getDocPartOt() {
		return this.docPartOt;
	}
	
	/**
	 * Column Info
	 * @return docPartSw
	 */
	public String getDocPartSw() {
		return this.docPartSw;
	}

	/**
	 * Column Info
	 * @param queue
	 */
	public void setQueue(String queue) {
		this.queue = queue;
	}
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	/**
	 * Column Info
	 * @param totSrVolAuditor
	 */
	public void setTotSrVolAuditor(String totSrVolAuditor) {
		this.totSrVolAuditor = totSrVolAuditor;
	}
	
	/**
	 * Column Info
	 * @param totSrVolFofc
	 */
	public void setTotSrVolFofc(String totSrVolFofc) {
		this.totSrVolFofc = totSrVolFofc;
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
	 * @param totSrKindAddition
	 */
	public void setTotSrKindAddition(String totSrKindAddition) {
		this.totSrKindAddition = totSrKindAddition;
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
	 * @param totBkgVol
	 */
	public void setTotBkgVol(String totBkgVol) {
		this.totBkgVol = totBkgVol;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Column Info
	 * @param totSrKind
	 */
	public void setTotSrKind(String totSrKind) {
		this.totSrKind = totSrKind;
	}
	
	/**
	 * Column Info
	 * @param totSrKindBlCnfm
	 */
	public void setTotSrKindBlCnfm(String totSrKindBlCnfm) {
		this.totSrKindBlCnfm = totSrKindBlCnfm;
	}
	
	/**
	 * Column Info
	 * @param totSrVolRater
	 */
	public void setTotSrVolRater(String totSrVolRater) {
		this.totSrVolRater = totSrVolRater;
	}
	
	/**
	 * Column Info
	 * @param srKind
	 */
	public void setSrKind(String srKind) {
		this.srKind = srKind;
	}
	
	/**
	 * Column Info
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/**
	 * Column Info
	 * @param totSrVolInputter
	 */
	public void setTotSrVolInputter(String totSrVolInputter) {
		this.totSrVolInputter = totSrVolInputter;
	}
	
	/**
	 * Column Info
	 * @param totSrVol
	 */
	public void setTotSrVol(String totSrVol) {
		this.totSrVol = totSrVol;
	}
	
	/**
	 * Column Info
	 * @param totStaffsAuditor
	 */
	public void setTotStaffsAuditor(String totStaffsAuditor) {
		this.totStaffsAuditor = totStaffsAuditor;
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
	 * @param totStaffsInputter
	 */
	public void setTotStaffsInputter(String totStaffsInputter) {
		this.totStaffsInputter = totStaffsInputter;
	}
	
	/**
	 * Column Info
	 * @param totSrKindAmend
	 */
	public void setTotSrKindAmend(String totSrKindAmend) {
		this.totSrKindAmend = totSrKindAmend;
	}
	
	/**
	 * Column Info
	 * @param totStaffsFofc
	 */
	public void setTotStaffsFofc(String totStaffsFofc) {
		this.totStaffsFofc = totStaffsFofc;
	}
	
	/**
	 * Column Info
	 * @param totStaffs
	 */
	public void setTotStaffs(String totStaffs) {
		this.totStaffs = totStaffs;
	}
	
	/**
	 * Column Info
	 * @param totSrKindNew
	 */
	public void setTotSrKindNew(String totSrKindNew) {
		this.totSrKindNew = totSrKindNew;
	}
	
	/**
	 * Column Info
	 * @param totStaffsRater
	 */
	public void setTotStaffsRater(String totStaffsRater) {
		this.totStaffsRater = totStaffsRater;
	}
	/**
	 * Column Info
	 * @param docPart
	 */
	public void setDocPart(String docPart) {
		this.docPart = docPart;
	}
	
	/**
	 * Column Info
	 * @param docPartEu
	 */
	public void setDocPartEu(String docPartEu) {
		this.docPartEu = docPartEu;
	}
	
	/**
	 * Column Info
	 * @param docPartJp
	 */
	public void setDocPartJp(String docPartJp) {
		this.docPartJp = docPartJp;
	}
	
	/**
	 * Column Info
	 * @param docPartSw
	 */
	public void setDocPartSw(String docPartSw) {
		this.docPartSw = docPartSw;
	}
	
	/**
	 * Column Info
	 * @param docPartOt
	 */
	public void setDocPartOt(String docPartOt) {
		this.docPartOt = docPartOt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setQueue(JSPUtil.getParameter(request, "queue", ""));
		setSeqNo(JSPUtil.getParameter(request, "seq_no", ""));
		setTotSrVolAuditor(JSPUtil.getParameter(request, "tot_sr_vol_auditor", ""));
		setTotSrVolFofc(JSPUtil.getParameter(request, "tot_sr_vol_fofc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTotSrKindAddition(JSPUtil.getParameter(request, "tot_sr_kind_addition", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setTotBkgVol(JSPUtil.getParameter(request, "tot_bkg_vol", ""));
		setSrNo(JSPUtil.getParameter(request, "sr_no", ""));
		setTotSrKind(JSPUtil.getParameter(request, "tot_sr_kind", ""));
		setTotSrKindBlCnfm(JSPUtil.getParameter(request, "tot_sr_kind_bl_cnfm", ""));
		setTotSrVolRater(JSPUtil.getParameter(request, "tot_sr_vol_rater", ""));
		setSrKind(JSPUtil.getParameter(request, "sr_kind", ""));
		setPic(JSPUtil.getParameter(request, "pic", ""));
		setTotSrVolInputter(JSPUtil.getParameter(request, "tot_sr_vol_inputter", ""));
		setTotSrVol(JSPUtil.getParameter(request, "tot_sr_vol", ""));
		setTotStaffsAuditor(JSPUtil.getParameter(request, "tot_staffs_auditor", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTotStaffsInputter(JSPUtil.getParameter(request, "tot_staffs_inputter", ""));
		setTotSrKindAmend(JSPUtil.getParameter(request, "tot_sr_kind_amend", ""));
		setTotStaffsFofc(JSPUtil.getParameter(request, "tot_staffs_fofc", ""));
		setTotStaffs(JSPUtil.getParameter(request, "tot_staffs", ""));
		setTotSrKindNew(JSPUtil.getParameter(request, "tot_sr_kind_new", ""));
		setTotStaffsRater(JSPUtil.getParameter(request, "tot_staffs_rater", ""));
		setDocPart(JSPUtil.getParameter(request, "doc_part", ""));
		setDocPartEu(JSPUtil.getParameter(request, "doc_part_eu", ""));
		setDocPartJp(JSPUtil.getParameter(request, "doc_part_jp", ""));
		setDocPartSw(JSPUtil.getParameter(request, "doc_part_sw", ""));
		setDocPartOt(JSPUtil.getParameter(request, "doc_part_ot", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDPCSVolListOutVO[]
	 */
	public SearchDPCSVolListOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDPCSVolListOutVO[]
	 */
	public SearchDPCSVolListOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDPCSVolListOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] queue = (JSPUtil.getParameter(request, prefix	+ "queue", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] totSrVolAuditor = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol_auditor", length));
			String[] totSrVolFofc = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol_fofc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] totSrKindAddition = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind_addition", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] totBkgVol = (JSPUtil.getParameter(request, prefix	+ "tot_bkg_vol", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] totSrKind = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind", length));
			String[] totSrKindBlCnfm = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind_bl_cnfm", length));
			String[] totSrVolRater = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol_rater", length));
			String[] srKind = (JSPUtil.getParameter(request, prefix	+ "sr_kind", length));
			String[] pic = (JSPUtil.getParameter(request, prefix	+ "pic", length));
			String[] totSrVolInputter = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol_inputter", length));
			String[] totSrVol = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol", length));
			String[] totStaffsAuditor = (JSPUtil.getParameter(request, prefix	+ "tot_staffs_auditor", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] totStaffsInputter = (JSPUtil.getParameter(request, prefix	+ "tot_staffs_inputter", length));
			String[] totSrKindAmend = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind_amend", length));
			String[] totStaffsFofc = (JSPUtil.getParameter(request, prefix	+ "tot_staffs_fofc", length));
			String[] totStaffs = (JSPUtil.getParameter(request, prefix	+ "tot_staffs", length));
			String[] totSrKindNew = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind_new", length));
			String[] totStaffsRater = (JSPUtil.getParameter(request, prefix	+ "tot_staffs_rater", length));
			String[] docPart = (JSPUtil.getParameter(request, prefix	+ "doc_part", length));
			String[] docPartEu = (JSPUtil.getParameter(request, prefix	+ "doc_part_eu", length));
			String[] docPartJp = (JSPUtil.getParameter(request, prefix	+ "doc_part_jp", length));
			String[] docPartSw = (JSPUtil.getParameter(request, prefix	+ "doc_part_sw", length));
			String[] docPartOt = (JSPUtil.getParameter(request, prefix	+ "doc_part_ot", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDPCSVolListOutVO();
				if (queue[i] != null)
					model.setQueue(queue[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (totSrVolAuditor[i] != null)
					model.setTotSrVolAuditor(totSrVolAuditor[i]);
				if (totSrVolFofc[i] != null)
					model.setTotSrVolFofc(totSrVolFofc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (totSrKindAddition[i] != null)
					model.setTotSrKindAddition(totSrKindAddition[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (totBkgVol[i] != null)
					model.setTotBkgVol(totBkgVol[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (totSrKind[i] != null)
					model.setTotSrKind(totSrKind[i]);
				if (totSrKindBlCnfm[i] != null)
					model.setTotSrKindBlCnfm(totSrKindBlCnfm[i]);
				if (totSrVolRater[i] != null)
					model.setTotSrVolRater(totSrVolRater[i]);
				if (srKind[i] != null)
					model.setSrKind(srKind[i]);
				if (pic[i] != null)
					model.setPic(pic[i]);
				if (totSrVolInputter[i] != null)
					model.setTotSrVolInputter(totSrVolInputter[i]);
				if (totSrVol[i] != null)
					model.setTotSrVol(totSrVol[i]);
				if (totStaffsAuditor[i] != null)
					model.setTotStaffsAuditor(totStaffsAuditor[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (totStaffsInputter[i] != null)
					model.setTotStaffsInputter(totStaffsInputter[i]);
				if (totSrKindAmend[i] != null)
					model.setTotSrKindAmend(totSrKindAmend[i]);
				if (totStaffsFofc[i] != null)
					model.setTotStaffsFofc(totStaffsFofc[i]);
				if (totStaffs[i] != null)
					model.setTotStaffs(totStaffs[i]);
				if (totSrKindNew[i] != null)
					model.setTotSrKindNew(totSrKindNew[i]);
				if (totStaffsRater[i] != null)
					model.setTotStaffsRater(totStaffsRater[i]);
				if (docPart[i] != null)
					model.setDocPart(docPart[i]);
				if (docPartEu[i] != null)
					model.setDocPartEu(docPartEu[i]);
				if (docPartJp[i] != null)
					model.setDocPartJp(docPartJp[i]);
				if (docPartSw[i] != null)
					model.setDocPartSw(docPartSw[i]);
				if (docPartOt[i] != null)
					model.setDocPartOt(docPartOt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDPCSVolListOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDPCSVolListOutVO[]
	 */
	public SearchDPCSVolListOutVO[] getSearchDPCSVolListOutVOs(){
		SearchDPCSVolListOutVO[] vos = (SearchDPCSVolListOutVO[])models.toArray(new SearchDPCSVolListOutVO[models.size()]);
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
		this.queue = this.queue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVolAuditor = this.totSrVolAuditor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVolFofc = this.totSrVolFofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKindAddition = this.totSrKindAddition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBkgVol = this.totBkgVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKind = this.totSrKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKindBlCnfm = this.totSrKindBlCnfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVolRater = this.totSrVolRater .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKind = this.srKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic = this.pic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVolInputter = this.totSrVolInputter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVol = this.totSrVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffsAuditor = this.totStaffsAuditor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffsInputter = this.totStaffsInputter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKindAmend = this.totSrKindAmend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffsFofc = this.totStaffsFofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffs = this.totStaffs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKindNew = this.totSrKindNew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffsRater = this.totStaffsRater .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPart = this.docPart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartEu = this.docPartEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartJp = this.docPartJp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartSw = this.docPartSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartOt = this.docPartOt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
