/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDPCSPfmcErrorListVO.java
*@FileTitle : SearchDPCSPfmcErrorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.03 김태경 
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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDPCSPfmcErrorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDPCSPfmcErrorListVO> models = new ArrayList<SearchDPCSPfmcErrorListVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String toMt = null;
	/* Column Info */
	private String amdRespbUsrId = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String fntOfcTrnsDt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String usrGrpNm = null;
	/* Column Info */
	private String fromMt = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String usrGrpCd = null;
	/* Column Info */
	private String docPartEu = null;
	/* Column Info */
	private String srAmdTpNm = null;
	/* Column Info */
	private String docPartSw = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String srAmdRsnCd = null;
	/* Column Info */
	private String srKindNm = null;
	/* Column Info */
	private String srAmdRsnTpCd = null;
	/* Column Info */
	private String rsnNm = null;
	/* Column Info */
	private String docPart = null;
	/* Column Info */
	private String docPartJp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDPCSPfmcErrorListVO() {}

	public SearchDPCSPfmcErrorListVO(String ibflag, String pagerows, String fromDt, String srAmdTpNm, String toMt, String amdRespbUsrId,  String toDt, String podCd,  String srAmdRsnCd, String bkgNo, String polCd, String vvdCd, String fntOfcTrnsDt, String srKindNm, String srAmdRsnTpCd, String srAmdTpCd, String usrGrpNm, String srNo, String fromMt, String usrGrpCd, String rsnNm, String docPart, String docPartEu, String docPartJp, String docPartSw) {
		this.fromDt = fromDt;
		this.toMt = toMt;
		this.amdRespbUsrId = amdRespbUsrId;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.fntOfcTrnsDt = fntOfcTrnsDt;
		this.srAmdTpCd = srAmdTpCd;
		this.usrGrpNm = usrGrpNm;
		this.fromMt = fromMt;
		this.srNo = srNo;
		this.usrGrpCd = usrGrpCd;
		this.docPartEu = docPartEu;
		this.srAmdTpNm = srAmdTpNm;
		this.docPartSw = docPartSw;
		this.podCd = podCd;
		this.toDt = toDt;
		this.bkgNo = bkgNo;
		this.srAmdRsnCd = srAmdRsnCd;
		this.srKindNm = srKindNm;
		this.srAmdRsnTpCd = srAmdRsnTpCd;
		this.rsnNm = rsnNm;
		this.docPart = docPart;
		this.docPartJp = docPartJp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("to_mt", getToMt());
		this.hashColumns.put("amd_respb_usr_id", getAmdRespbUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("fnt_ofc_trns_dt", getFntOfcTrnsDt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("usr_grp_nm", getUsrGrpNm());
		this.hashColumns.put("from_mt", getFromMt());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("usr_grp_cd", getUsrGrpCd());
		this.hashColumns.put("doc_part_eu", getDocPartEu());
		this.hashColumns.put("sr_amd_tp_nm", getSrAmdTpNm());
		this.hashColumns.put("doc_part_sw", getDocPartSw());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sr_amd_rsn_cd", getSrAmdRsnCd());
		this.hashColumns.put("sr_kind_nm", getSrKindNm());
		this.hashColumns.put("sr_amd_rsn_tp_cd", getSrAmdRsnTpCd());
		this.hashColumns.put("rsn_nm", getRsnNm());
		this.hashColumns.put("doc_part", getDocPart());
		this.hashColumns.put("doc_part_jp", getDocPartJp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("to_mt", "toMt");
		this.hashFields.put("amd_respb_usr_id", "amdRespbUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("fnt_ofc_trns_dt", "fntOfcTrnsDt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("usr_grp_nm", "usrGrpNm");
		this.hashFields.put("from_mt", "fromMt");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("usr_grp_cd", "usrGrpCd");
		this.hashFields.put("doc_part_eu", "docPartEu");
		this.hashFields.put("sr_amd_tp_nm", "srAmdTpNm");
		this.hashFields.put("doc_part_sw", "docPartSw");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sr_amd_rsn_cd", "srAmdRsnCd");
		this.hashFields.put("sr_kind_nm", "srKindNm");
		this.hashFields.put("sr_amd_rsn_tp_cd", "srAmdRsnTpCd");
		this.hashFields.put("rsn_nm", "rsnNm");
		this.hashFields.put("doc_part", "docPart");
		this.hashFields.put("doc_part_jp", "docPartJp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return toMt
	 */
	public String getToMt() {
		return this.toMt;
	}
	
	/**
	 * Column Info
	 * @return amdRespbUsrId
	 */
	public String getAmdRespbUsrId() {
		return this.amdRespbUsrId;
	}
	
	/**
	 * Column Info
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
	 * Column Info
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
	 * @return fntOfcTrnsDt
	 */
	public String getFntOfcTrnsDt() {
		return this.fntOfcTrnsDt;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return usrGrpNm
	 */
	public String getUsrGrpNm() {
		return this.usrGrpNm;
	}
	
	/**
	 * Column Info
	 * @return fromMt
	 */
	public String getFromMt() {
		return this.fromMt;
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
	 * @return usrGrpCd
	 */
	public String getUsrGrpCd() {
		return this.usrGrpCd;
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
	 * @return srAmdTpNm
	 */
	public String getSrAmdTpNm() {
		return this.srAmdTpNm;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return srAmdRsnCd
	 */
	public String getSrAmdRsnCd() {
		return this.srAmdRsnCd;
	}
	
	/**
	 * Column Info
	 * @return srKindNm
	 */
	public String getSrKindNm() {
		return this.srKindNm;
	}
	
	/**
	 * Column Info
	 * @return srAmdRsnTpCd
	 */
	public String getSrAmdRsnTpCd() {
		return this.srAmdRsnTpCd;
	}
	
	/**
	 * Column Info
	 * @return rsnNm
	 */
	public String getRsnNm() {
		return this.rsnNm;
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
	 * @return docPartJp
	 */
	public String getDocPartJp() {
		return this.docPartJp;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param toMt
	 */
	public void setToMt(String toMt) {
		this.toMt = toMt;
	}
	
	/**
	 * Column Info
	 * @param amdRespbUsrId
	 */
	public void setAmdRespbUsrId(String amdRespbUsrId) {
		this.amdRespbUsrId = amdRespbUsrId;
	}
	
	/**
	 * Column Info
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
	 * Column Info
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
	 * @param fntOfcTrnsDt
	 */
	public void setFntOfcTrnsDt(String fntOfcTrnsDt) {
		this.fntOfcTrnsDt = fntOfcTrnsDt;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param usrGrpNm
	 */
	public void setUsrGrpNm(String usrGrpNm) {
		this.usrGrpNm = usrGrpNm;
	}
	
	/**
	 * Column Info
	 * @param fromMt
	 */
	public void setFromMt(String fromMt) {
		this.fromMt = fromMt;
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
	 * @param usrGrpCd
	 */
	public void setUsrGrpCd(String usrGrpCd) {
		this.usrGrpCd = usrGrpCd;
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
	 * @param srAmdTpNm
	 */
	public void setSrAmdTpNm(String srAmdTpNm) {
		this.srAmdTpNm = srAmdTpNm;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param srAmdRsnCd
	 */
	public void setSrAmdRsnCd(String srAmdRsnCd) {
		this.srAmdRsnCd = srAmdRsnCd;
	}
	
	/**
	 * Column Info
	 * @param srKindNm
	 */
	public void setSrKindNm(String srKindNm) {
		this.srKindNm = srKindNm;
	}
	
	/**
	 * Column Info
	 * @param srAmdRsnTpCd
	 */
	public void setSrAmdRsnTpCd(String srAmdRsnTpCd) {
		this.srAmdRsnTpCd = srAmdRsnTpCd;
	}
	
	/**
	 * Column Info
	 * @param rsnNm
	 */
	public void setRsnNm(String rsnNm) {
		this.rsnNm = rsnNm;
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
	 * @param docPartJp
	 */
	public void setDocPartJp(String docPartJp) {
		this.docPartJp = docPartJp;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setToMt(JSPUtil.getParameter(request, "to_mt", ""));
		setAmdRespbUsrId(JSPUtil.getParameter(request, "amd_respb_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setFntOfcTrnsDt(JSPUtil.getParameter(request, "fnt_ofc_trns_dt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, "sr_amd_tp_cd", ""));
		setUsrGrpNm(JSPUtil.getParameter(request, "usr_grp_nm", ""));
		setFromMt(JSPUtil.getParameter(request, "from_mt", ""));
		setSrNo(JSPUtil.getParameter(request, "sr_no", ""));
		setUsrGrpCd(JSPUtil.getParameter(request, "usr_grp_cd", ""));
		setDocPartEu(JSPUtil.getParameter(request, "doc_part_eu", ""));
		setSrAmdTpNm(JSPUtil.getParameter(request, "sr_amd_tp_nm", ""));
		setDocPartSw(JSPUtil.getParameter(request, "doc_part_sw", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSrAmdRsnCd(JSPUtil.getParameter(request, "sr_amd_rsn_cd", ""));
		setSrKindNm(JSPUtil.getParameter(request, "sr_kind_nm", ""));
		setSrAmdRsnTpCd(JSPUtil.getParameter(request, "sr_amd_rsn_tp_cd", ""));
		setRsnNm(JSPUtil.getParameter(request, "rsn_nm", ""));
		setDocPart(JSPUtil.getParameter(request, "doc_part", ""));
		setDocPartJp(JSPUtil.getParameter(request, "doc_part_jp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDPCSPfmcErrorListVO[]
	 */
	public SearchDPCSPfmcErrorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDPCSPfmcErrorListVO[]
	 */
	public SearchDPCSPfmcErrorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDPCSPfmcErrorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] toMt = (JSPUtil.getParameter(request, prefix	+ "to_mt", length));
			String[] amdRespbUsrId = (JSPUtil.getParameter(request, prefix	+ "amd_respb_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] fntOfcTrnsDt = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_trns_dt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] usrGrpNm = (JSPUtil.getParameter(request, prefix	+ "usr_grp_nm", length));
			String[] fromMt = (JSPUtil.getParameter(request, prefix	+ "from_mt", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] usrGrpCd = (JSPUtil.getParameter(request, prefix	+ "usr_grp_cd", length));
			String[] docPartEu = (JSPUtil.getParameter(request, prefix	+ "doc_part_eu", length));
			String[] srAmdTpNm = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_nm", length));
			String[] docPartSw = (JSPUtil.getParameter(request, prefix	+ "doc_part_sw", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] srAmdRsnCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_rsn_cd", length));
			String[] srKindNm = (JSPUtil.getParameter(request, prefix	+ "sr_kind_nm", length));
			String[] srAmdRsnTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_rsn_tp_cd", length));
			String[] rsnNm = (JSPUtil.getParameter(request, prefix	+ "rsn_nm", length));
			String[] docPart = (JSPUtil.getParameter(request, prefix	+ "doc_part", length));
			String[] docPartJp = (JSPUtil.getParameter(request, prefix	+ "doc_part_jp", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDPCSPfmcErrorListVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (toMt[i] != null)
					model.setToMt(toMt[i]);
				if (amdRespbUsrId[i] != null)
					model.setAmdRespbUsrId(amdRespbUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (fntOfcTrnsDt[i] != null)
					model.setFntOfcTrnsDt(fntOfcTrnsDt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (usrGrpNm[i] != null)
					model.setUsrGrpNm(usrGrpNm[i]);
				if (fromMt[i] != null)
					model.setFromMt(fromMt[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (usrGrpCd[i] != null)
					model.setUsrGrpCd(usrGrpCd[i]);
				if (docPartEu[i] != null)
					model.setDocPartEu(docPartEu[i]);
				if (srAmdTpNm[i] != null)
					model.setSrAmdTpNm(srAmdTpNm[i]);
				if (docPartSw[i] != null)
					model.setDocPartSw(docPartSw[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (srAmdRsnCd[i] != null)
					model.setSrAmdRsnCd(srAmdRsnCd[i]);
				if (srKindNm[i] != null)
					model.setSrKindNm(srKindNm[i]);
				if (srAmdRsnTpCd[i] != null)
					model.setSrAmdRsnTpCd(srAmdRsnTpCd[i]);
				if (rsnNm[i] != null)
					model.setRsnNm(rsnNm[i]);
				if (docPart[i] != null)
					model.setDocPart(docPart[i]);
				if (docPartJp[i] != null)
					model.setDocPartJp(docPartJp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDPCSPfmcErrorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDPCSPfmcErrorListVO[]
	 */
	public SearchDPCSPfmcErrorListVO[] getSearchDPCSPfmcErrorListVOs(){
		SearchDPCSPfmcErrorListVO[] vos = (SearchDPCSPfmcErrorListVO[])models.toArray(new SearchDPCSPfmcErrorListVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMt = this.toMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdRespbUsrId = this.amdRespbUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcTrnsDt = this.fntOfcTrnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrGrpNm = this.usrGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromMt = this.fromMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrGrpCd = this.usrGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartEu = this.docPartEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpNm = this.srAmdTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartSw = this.docPartSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdRsnCd = this.srAmdRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKindNm = this.srKindNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdRsnTpCd = this.srAmdRsnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnNm = this.rsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPart = this.docPart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartJp = this.docPartJp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
