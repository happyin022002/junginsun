/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchCOPHistoryVO.java
*@FileTitle : SearchCOPHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.15
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.15 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copreport.cophsitory.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCOPHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCOPHistoryVO> models = new ArrayList<SearchCOPHistoryVO>();
	
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obBkgTroNo = null;
	/* Column Info */
	private String mstCopNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ibRoute = null;
	/* Column Info */
	private String page = null;
	/* Column Info */
	private String event = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String copSubStsCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String totcnt = null;
	/* Column Info */
	private String obRoute = null;
	/* Column Info */
	private String dTerm = null;
	/* Column Info */
	private String ocnRoute = null;
	/* Column Info */
	private String umchStsCd = null;
	/* Column Info */
	private String creOfdCd = null;
	/* Column Info */
	private String mstLclCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String ibBkgTroNo = null;
	/* Column Info */
	private String rTerm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCOPHistoryVO() {}

	public SearchCOPHistoryVO(String ibflag, String pagerows, String seq, String copNo, String cntrNo, String bkgNo, String event, String cntrTpszCd, String mstLclCd, String mstCopNo, String bkgStsCd, String copStsCd, String copSubStsCd, String rTerm, String obRoute, String ocnRoute, String ibRoute, String dTerm, String creDt, String creUsrId, String creOfdCd, String umchStsCd, String obBkgTroNo, String ibBkgTroNo, String page, String totcnt) {
		this.bkgStsCd = bkgStsCd;
		this.copNo = copNo;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.obBkgTroNo = obBkgTroNo;
		this.mstCopNo = mstCopNo;
		this.ibflag = ibflag;
		this.ibRoute = ibRoute;
		this.page = page;
		this.event = event;
		this.cntrTpszCd = cntrTpszCd;
		this.copSubStsCd = copSubStsCd;
		this.copStsCd = copStsCd;
		this.totcnt = totcnt;
		this.obRoute = obRoute;
		this.dTerm = dTerm;
		this.ocnRoute = ocnRoute;
		this.umchStsCd = umchStsCd;
		this.creOfdCd = creOfdCd;
		this.mstLclCd = mstLclCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.seq = seq;
		this.ibBkgTroNo = ibBkgTroNo;
		this.rTerm = rTerm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_bkg_tro_no", getObBkgTroNo());
		this.hashColumns.put("mst_cop_no", getMstCopNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ib_route", getIbRoute());
		this.hashColumns.put("page", getPage());
		this.hashColumns.put("event", getEvent());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cop_sub_sts_cd", getCopSubStsCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("totcnt", getTotcnt());
		this.hashColumns.put("ob_route", getObRoute());
		this.hashColumns.put("d_term", getDTerm());
		this.hashColumns.put("ocn_route", getOcnRoute());
		this.hashColumns.put("umch_sts_cd", getUmchStsCd());
		this.hashColumns.put("cre_ofd_cd", getCreOfdCd());
		this.hashColumns.put("mst_lcl_cd", getMstLclCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("ib_bkg_tro_no", getIbBkgTroNo());
		this.hashColumns.put("r_term", getRTerm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_bkg_tro_no", "obBkgTroNo");
		this.hashFields.put("mst_cop_no", "mstCopNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ib_route", "ibRoute");
		this.hashFields.put("page", "page");
		this.hashFields.put("event", "event");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cop_sub_sts_cd", "copSubStsCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("totcnt", "totcnt");
		this.hashFields.put("ob_route", "obRoute");
		this.hashFields.put("d_term", "dTerm");
		this.hashFields.put("ocn_route", "ocnRoute");
		this.hashFields.put("umch_sts_cd", "umchStsCd");
		this.hashFields.put("cre_ofd_cd", "creOfdCd");
		this.hashFields.put("mst_lcl_cd", "mstLclCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("ib_bkg_tro_no", "ibBkgTroNo");
		this.hashFields.put("r_term", "rTerm");
		return this.hashFields;
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
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return obBkgTroNo
	 */
	public String getObBkgTroNo() {
		return this.obBkgTroNo;
	}
	
	/**
	 * Column Info
	 * @return mstCopNo
	 */
	public String getMstCopNo() {
		return this.mstCopNo;
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
	 * @return ibRoute
	 */
	public String getIbRoute() {
		return this.ibRoute;
	}
	
	/**
	 * Column Info
	 * @return page
	 */
	public String getPage() {
		return this.page;
	}
	
	/**
	 * Column Info
	 * @return event
	 */
	public String getEvent() {
		return this.event;
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
	 * @return copSubStsCd
	 */
	public String getCopSubStsCd() {
		return this.copSubStsCd;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return totcnt
	 */
	public String getTotcnt() {
		return this.totcnt;
	}
	
	/**
	 * Column Info
	 * @return obRoute
	 */
	public String getObRoute() {
		return this.obRoute;
	}
	
	/**
	 * Column Info
	 * @return dTerm
	 */
	public String getDTerm() {
		return this.dTerm;
	}
	
	/**
	 * Column Info
	 * @return ocnRoute
	 */
	public String getOcnRoute() {
		return this.ocnRoute;
	}
	
	/**
	 * Column Info
	 * @return umchStsCd
	 */
	public String getUmchStsCd() {
		return this.umchStsCd;
	}
	
	/**
	 * Column Info
	 * @return creOfdCd
	 */
	public String getCreOfdCd() {
		return this.creOfdCd;
	}
	
	/**
	 * Column Info
	 * @return mstLclCd
	 */
	public String getMstLclCd() {
		return this.mstLclCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return ibBkgTroNo
	 */
	public String getIbBkgTroNo() {
		return this.ibBkgTroNo;
	}
	
	/**
	 * Column Info
	 * @return rTerm
	 */
	public String getRTerm() {
		return this.rTerm;
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
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param obBkgTroNo
	 */
	public void setObBkgTroNo(String obBkgTroNo) {
		this.obBkgTroNo = obBkgTroNo;
	}
	
	/**
	 * Column Info
	 * @param mstCopNo
	 */
	public void setMstCopNo(String mstCopNo) {
		this.mstCopNo = mstCopNo;
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
	 * @param ibRoute
	 */
	public void setIbRoute(String ibRoute) {
		this.ibRoute = ibRoute;
	}
	
	/**
	 * Column Info
	 * @param page
	 */
	public void setPage(String page) {
		this.page = page;
	}
	
	/**
	 * Column Info
	 * @param event
	 */
	public void setEvent(String event) {
		this.event = event;
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
	 * @param copSubStsCd
	 */
	public void setCopSubStsCd(String copSubStsCd) {
		this.copSubStsCd = copSubStsCd;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param totcnt
	 */
	public void setTotcnt(String totcnt) {
		this.totcnt = totcnt;
	}
	
	/**
	 * Column Info
	 * @param obRoute
	 */
	public void setObRoute(String obRoute) {
		this.obRoute = obRoute;
	}
	
	/**
	 * Column Info
	 * @param dTerm
	 */
	public void setDTerm(String dTerm) {
		this.dTerm = dTerm;
	}
	
	/**
	 * Column Info
	 * @param ocnRoute
	 */
	public void setOcnRoute(String ocnRoute) {
		this.ocnRoute = ocnRoute;
	}
	
	/**
	 * Column Info
	 * @param umchStsCd
	 */
	public void setUmchStsCd(String umchStsCd) {
		this.umchStsCd = umchStsCd;
	}
	
	/**
	 * Column Info
	 * @param creOfdCd
	 */
	public void setCreOfdCd(String creOfdCd) {
		this.creOfdCd = creOfdCd;
	}
	
	/**
	 * Column Info
	 * @param mstLclCd
	 */
	public void setMstLclCd(String mstLclCd) {
		this.mstLclCd = mstLclCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param ibBkgTroNo
	 */
	public void setIbBkgTroNo(String ibBkgTroNo) {
		this.ibBkgTroNo = ibBkgTroNo;
	}
	
	/**
	 * Column Info
	 * @param rTerm
	 */
	public void setRTerm(String rTerm) {
		this.rTerm = rTerm;
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
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObBkgTroNo(JSPUtil.getParameter(request, prefix + "ob_bkg_tro_no", ""));
		setMstCopNo(JSPUtil.getParameter(request, prefix + "mst_cop_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIbRoute(JSPUtil.getParameter(request, prefix + "ib_route", ""));
		setPage(JSPUtil.getParameter(request, prefix + "page", ""));
		setEvent(JSPUtil.getParameter(request, prefix + "event", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCopSubStsCd(JSPUtil.getParameter(request, prefix + "cop_sub_sts_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, prefix + "cop_sts_cd", ""));
		setTotcnt(JSPUtil.getParameter(request, prefix + "totcnt", ""));
		setObRoute(JSPUtil.getParameter(request, prefix + "ob_route", ""));
		setDTerm(JSPUtil.getParameter(request, prefix + "d_term", ""));
		setOcnRoute(JSPUtil.getParameter(request, prefix + "ocn_route", ""));
		setUmchStsCd(JSPUtil.getParameter(request, prefix + "umch_sts_cd", ""));
		setCreOfdCd(JSPUtil.getParameter(request, prefix + "cre_ofd_cd", ""));
		setMstLclCd(JSPUtil.getParameter(request, prefix + "mst_lcl_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setIbBkgTroNo(JSPUtil.getParameter(request, prefix + "ib_bkg_tro_no", ""));
		setRTerm(JSPUtil.getParameter(request, prefix + "r_term", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCOPHistoryVO[]
	 */
	public SearchCOPHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCOPHistoryVO[]
	 */
	public SearchCOPHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCOPHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obBkgTroNo = (JSPUtil.getParameter(request, prefix	+ "ob_bkg_tro_no", length));
			String[] mstCopNo = (JSPUtil.getParameter(request, prefix	+ "mst_cop_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ibRoute = (JSPUtil.getParameter(request, prefix	+ "ib_route", length));
			String[] page = (JSPUtil.getParameter(request, prefix	+ "page", length));
			String[] event = (JSPUtil.getParameter(request, prefix	+ "event", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] copSubStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sub_sts_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] totcnt = (JSPUtil.getParameter(request, prefix	+ "totcnt", length));
			String[] obRoute = (JSPUtil.getParameter(request, prefix	+ "ob_route", length));
			String[] dTerm = (JSPUtil.getParameter(request, prefix	+ "d_term", length));
			String[] ocnRoute = (JSPUtil.getParameter(request, prefix	+ "ocn_route", length));
			String[] umchStsCd = (JSPUtil.getParameter(request, prefix	+ "umch_sts_cd", length));
			String[] creOfdCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofd_cd", length));
			String[] mstLclCd = (JSPUtil.getParameter(request, prefix	+ "mst_lcl_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] ibBkgTroNo = (JSPUtil.getParameter(request, prefix	+ "ib_bkg_tro_no", length));
			String[] rTerm = (JSPUtil.getParameter(request, prefix	+ "r_term", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCOPHistoryVO();
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obBkgTroNo[i] != null)
					model.setObBkgTroNo(obBkgTroNo[i]);
				if (mstCopNo[i] != null)
					model.setMstCopNo(mstCopNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ibRoute[i] != null)
					model.setIbRoute(ibRoute[i]);
				if (page[i] != null)
					model.setPage(page[i]);
				if (event[i] != null)
					model.setEvent(event[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (copSubStsCd[i] != null)
					model.setCopSubStsCd(copSubStsCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (totcnt[i] != null)
					model.setTotcnt(totcnt[i]);
				if (obRoute[i] != null)
					model.setObRoute(obRoute[i]);
				if (dTerm[i] != null)
					model.setDTerm(dTerm[i]);
				if (ocnRoute[i] != null)
					model.setOcnRoute(ocnRoute[i]);
				if (umchStsCd[i] != null)
					model.setUmchStsCd(umchStsCd[i]);
				if (creOfdCd[i] != null)
					model.setCreOfdCd(creOfdCd[i]);
				if (mstLclCd[i] != null)
					model.setMstLclCd(mstLclCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (ibBkgTroNo[i] != null)
					model.setIbBkgTroNo(ibBkgTroNo[i]);
				if (rTerm[i] != null)
					model.setRTerm(rTerm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCOPHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCOPHistoryVO[]
	 */
	public SearchCOPHistoryVO[] getSearchCOPHistoryVOs(){
		SearchCOPHistoryVO[] vos = (SearchCOPHistoryVO[])models.toArray(new SearchCOPHistoryVO[models.size()]);
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
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBkgTroNo = this.obBkgTroNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCopNo = this.mstCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRoute = this.ibRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.page = this.page .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.event = this.event .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSubStsCd = this.copSubStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totcnt = this.totcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obRoute = this.obRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTerm = this.dTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnRoute = this.ocnRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchStsCd = this.umchStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfdCd = this.creOfdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstLclCd = this.mstLclCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBkgTroNo = this.ibBkgTroNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTerm = this.rTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
