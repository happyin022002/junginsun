/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpePopupVO.java
*@FileTitle : SpePopupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.04 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.common.popup.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpePopupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpePopupVO> models = new ArrayList<SpePopupVO>();
	
	/* Column Info */
	private String prntVndrSeq = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String lgsFlg = null;
	/* Column Info */
	private String slevel = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String searchType = null;
	/* Column Info */
	private String efptOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String egNm = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String evSvcCateCd = null;
	/* Column Info */
	private String sEvSvcCateCd = null;
	/* Column Info */
	private String ptsVndrCd = null;
	/* Column Info */
	private String orgVndrSeq = null;
	/* Column Info */
	private String engAddr = null;
	/* Column Info */
	private String vndrCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sEvYr = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String egOfcCd = null;
	/* Column Info */
	private String vndrNmEng = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String egId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpePopupVO() {}

	public SpePopupVO(String ibflag, String pagerows, String evSvcCateCd, String cntCd, String ofcCd, String egOfcCd, String slevel, String efptOfcCd, String vndrNmEng, String ptsVndrCd, String vndrCd, String lgsFlg, String vndrSeq, String vndrLglEngNm, String vndrAbbrNm, String prntVndrSeq, String vndrCntCd, String orgVndrSeq, String engAddr, String egId, String egNm, String searchType, String sEgRhqCd, String sEgOfcCd, String sEvSvcCateCd, String sEvYr) {
		this.prntVndrSeq = prntVndrSeq;
		this.vndrCntCd = vndrCntCd;
		this.lgsFlg = lgsFlg;
		this.slevel = slevel;
		this.vndrLglEngNm = vndrLglEngNm;
		this.searchType = searchType;
		this.efptOfcCd = efptOfcCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.egNm = egNm;
		this.cntCd = cntCd;
		this.evSvcCateCd = evSvcCateCd;
		this.sEvSvcCateCd = sEvSvcCateCd;
		this.ptsVndrCd = ptsVndrCd;
		this.orgVndrSeq = orgVndrSeq;
		this.engAddr = engAddr;
		this.vndrCd = vndrCd;
		this.ofcCd = ofcCd;
		this.sEvYr = sEvYr;
		this.sEgOfcCd = sEgOfcCd;
		this.vndrSeq = vndrSeq;
		this.sEgRhqCd = sEgRhqCd;
		this.egOfcCd = egOfcCd;
		this.vndrNmEng = vndrNmEng;
		this.vndrAbbrNm = vndrAbbrNm;
		this.egId = egId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prnt_vndr_seq", getPrntVndrSeq());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("lgs_flg", getLgsFlg());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("search_type", getSearchType());
		this.hashColumns.put("efpt_ofc_cd", getEfptOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ev_svc_cate_cd", getEvSvcCateCd());
		this.hashColumns.put("s_ev_svc_cate_cd", getSEvSvcCateCd());
		this.hashColumns.put("pts_vndr_cd", getPtsVndrCd());
		this.hashColumns.put("org_vndr_seq", getOrgVndrSeq());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("vndr_cd", getVndrCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_ev_yr", getSEvYr());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("eg_ofc_cd", getEgOfcCd());
		this.hashColumns.put("vndr_nm_eng", getVndrNmEng());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("eg_id", getEgId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prnt_vndr_seq", "prntVndrSeq");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("lgs_flg", "lgsFlg");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("search_type", "searchType");
		this.hashFields.put("efpt_ofc_cd", "efptOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ev_svc_cate_cd", "evSvcCateCd");
		this.hashFields.put("s_ev_svc_cate_cd", "sEvSvcCateCd");
		this.hashFields.put("pts_vndr_cd", "ptsVndrCd");
		this.hashFields.put("org_vndr_seq", "orgVndrSeq");
		this.hashFields.put("eng_addr", "engAddr");
		this.hashFields.put("vndr_cd", "vndrCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_ev_yr", "sEvYr");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("eg_ofc_cd", "egOfcCd");
		this.hashFields.put("vndr_nm_eng", "vndrNmEng");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("eg_id", "egId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prntVndrSeq
	 */
	public String getPrntVndrSeq() {
		return this.prntVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return lgsFlg
	 */
	public String getLgsFlg() {
		return this.lgsFlg;
	}
	
	/**
	 * Column Info
	 * @return slevel
	 */
	public String getSlevel() {
		return this.slevel;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return searchType
	 */
	public String getSearchType() {
		return this.searchType;
	}
	
	/**
	 * Column Info
	 * @return efptOfcCd
	 */
	public String getEfptOfcCd() {
		return this.efptOfcCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return egNm
	 */
	public String getEgNm() {
		return this.egNm;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return evSvcCateCd
	 */
	public String getEvSvcCateCd() {
		return this.evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return sEvSvcCateCd
	 */
	public String getSEvSvcCateCd() {
		return this.sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return ptsVndrCd
	 */
	public String getPtsVndrCd() {
		return this.ptsVndrCd;
	}
	
	/**
	 * Column Info
	 * @return orgVndrSeq
	 */
	public String getOrgVndrSeq() {
		return this.orgVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return engAddr
	 */
	public String getEngAddr() {
		return this.engAddr;
	}
	
	/**
	 * Column Info
	 * @return vndrCd
	 */
	public String getVndrCd() {
		return this.vndrCd;
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
	 * @return sEvYr
	 */
	public String getSEvYr() {
		return this.sEvYr;
	}
	
	/**
	 * Column Info
	 * @return sEgOfcCd
	 */
	public String getSEgOfcCd() {
		return this.sEgOfcCd;
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
	 * @return sEgRhqCd
	 */
	public String getSEgRhqCd() {
		return this.sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return egOfcCd
	 */
	public String getEgOfcCd() {
		return this.egOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrNmEng
	 */
	public String getVndrNmEng() {
		return this.vndrNmEng;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return egId
	 */
	public String getEgId() {
		return this.egId;
	}
	

	/**
	 * Column Info
	 * @param prntVndrSeq
	 */
	public void setPrntVndrSeq(String prntVndrSeq) {
		this.prntVndrSeq = prntVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param lgsFlg
	 */
	public void setLgsFlg(String lgsFlg) {
		this.lgsFlg = lgsFlg;
	}
	
	/**
	 * Column Info
	 * @param slevel
	 */
	public void setSlevel(String slevel) {
		this.slevel = slevel;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	/**
	 * Column Info
	 * @param efptOfcCd
	 */
	public void setEfptOfcCd(String efptOfcCd) {
		this.efptOfcCd = efptOfcCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param egNm
	 */
	public void setEgNm(String egNm) {
		this.egNm = egNm;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param evSvcCateCd
	 */
	public void setEvSvcCateCd(String evSvcCateCd) {
		this.evSvcCateCd = evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param sEvSvcCateCd
	 */
	public void setSEvSvcCateCd(String sEvSvcCateCd) {
		this.sEvSvcCateCd = sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param ptsVndrCd
	 */
	public void setPtsVndrCd(String ptsVndrCd) {
		this.ptsVndrCd = ptsVndrCd;
	}
	
	/**
	 * Column Info
	 * @param orgVndrSeq
	 */
	public void setOrgVndrSeq(String orgVndrSeq) {
		this.orgVndrSeq = orgVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param engAddr
	 */
	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
	}
	
	/**
	 * Column Info
	 * @param vndrCd
	 */
	public void setVndrCd(String vndrCd) {
		this.vndrCd = vndrCd;
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
	 * @param sEvYr
	 */
	public void setSEvYr(String sEvYr) {
		this.sEvYr = sEvYr;
	}
	
	/**
	 * Column Info
	 * @param sEgOfcCd
	 */
	public void setSEgOfcCd(String sEgOfcCd) {
		this.sEgOfcCd = sEgOfcCd;
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
	 * @param sEgRhqCd
	 */
	public void setSEgRhqCd(String sEgRhqCd) {
		this.sEgRhqCd = sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param egOfcCd
	 */
	public void setEgOfcCd(String egOfcCd) {
		this.egOfcCd = egOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrNmEng
	 */
	public void setVndrNmEng(String vndrNmEng) {
		this.vndrNmEng = vndrNmEng;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
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
		setPrntVndrSeq(JSPUtil.getParameter(request, prefix + "prnt_vndr_seq", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setLgsFlg(JSPUtil.getParameter(request, prefix + "lgs_flg", ""));
		setSlevel(JSPUtil.getParameter(request, prefix + "slevel", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setSearchType(JSPUtil.getParameter(request, prefix + "search_type", ""));
		setEfptOfcCd(JSPUtil.getParameter(request, prefix + "efpt_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setEvSvcCateCd(JSPUtil.getParameter(request, prefix + "ev_svc_cate_cd", ""));
		setSEvSvcCateCd(JSPUtil.getParameter(request, prefix + "s_ev_svc_cate_cd", ""));
		setPtsVndrCd(JSPUtil.getParameter(request, prefix + "pts_vndr_cd", ""));
		setOrgVndrSeq(JSPUtil.getParameter(request, prefix + "org_vndr_seq", ""));
		setEngAddr(JSPUtil.getParameter(request, prefix + "eng_addr", ""));
		setVndrCd(JSPUtil.getParameter(request, prefix + "vndr_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSEvYr(JSPUtil.getParameter(request, prefix + "s_ev_yr", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setEgOfcCd(JSPUtil.getParameter(request, prefix + "eg_ofc_cd", ""));
		setVndrNmEng(JSPUtil.getParameter(request, prefix + "vndr_nm_eng", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpePopupVO[]
	 */
	public SpePopupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpePopupVO[]
	 */
	public SpePopupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpePopupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prntVndrSeq = (JSPUtil.getParameter(request, prefix	+ "prnt_vndr_seq", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] lgsFlg = (JSPUtil.getParameter(request, prefix	+ "lgs_flg", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] searchType = (JSPUtil.getParameter(request, prefix	+ "search_type", length));
			String[] efptOfcCd = (JSPUtil.getParameter(request, prefix	+ "efpt_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] evSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_cd", length));
			String[] sEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_ev_svc_cate_cd", length));
			String[] ptsVndrCd = (JSPUtil.getParameter(request, prefix	+ "pts_vndr_cd", length));
			String[] orgVndrSeq = (JSPUtil.getParameter(request, prefix	+ "org_vndr_seq", length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr", length));
			String[] vndrCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sEvYr = (JSPUtil.getParameter(request, prefix	+ "s_ev_yr", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] egOfcCd = (JSPUtil.getParameter(request, prefix	+ "eg_ofc_cd", length));
			String[] vndrNmEng = (JSPUtil.getParameter(request, prefix	+ "vndr_nm_eng", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpePopupVO();
				if (prntVndrSeq[i] != null)
					model.setPrntVndrSeq(prntVndrSeq[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (lgsFlg[i] != null)
					model.setLgsFlg(lgsFlg[i]);
				if (slevel[i] != null)
					model.setSlevel(slevel[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (searchType[i] != null)
					model.setSearchType(searchType[i]);
				if (efptOfcCd[i] != null)
					model.setEfptOfcCd(efptOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (evSvcCateCd[i] != null)
					model.setEvSvcCateCd(evSvcCateCd[i]);
				if (sEvSvcCateCd[i] != null)
					model.setSEvSvcCateCd(sEvSvcCateCd[i]);
				if (ptsVndrCd[i] != null)
					model.setPtsVndrCd(ptsVndrCd[i]);
				if (orgVndrSeq[i] != null)
					model.setOrgVndrSeq(orgVndrSeq[i]);
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (vndrCd[i] != null)
					model.setVndrCd(vndrCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sEvYr[i] != null)
					model.setSEvYr(sEvYr[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (egOfcCd[i] != null)
					model.setEgOfcCd(egOfcCd[i]);
				if (vndrNmEng[i] != null)
					model.setVndrNmEng(vndrNmEng[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpePopupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpePopupVO[]
	 */
	public SpePopupVO[] getSpePopupVOs(){
		SpePopupVO[] vos = (SpePopupVO[])models.toArray(new SpePopupVO[models.size()]);
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
		this.prntVndrSeq = this.prntVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsFlg = this.lgsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchType = this.searchType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.efptOfcCd = this.efptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateCd = this.evSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvSvcCateCd = this.sEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptsVndrCd = this.ptsVndrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrSeq = this.orgVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCd = this.vndrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvYr = this.sEvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egOfcCd = this.egOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNmEng = this.vndrNmEng .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
