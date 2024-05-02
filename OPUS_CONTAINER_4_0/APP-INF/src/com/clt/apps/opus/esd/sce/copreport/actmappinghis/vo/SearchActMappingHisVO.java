/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchActMappingHisVO.java
*@FileTitle : SearchActMappingHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copreport.actmappinghis.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchActMappingHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActMappingHisVO> models = new ArrayList<SearchActMappingHisVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String dupFlg = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Column Info */
	private String actUmchTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estmDt = null;
	/* Column Info */
	private String mstCopNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String page = null;
	/* Column Info */
	private String actFmDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String actToDt = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String plnDt = null;
	/* Column Info */
	private String actGapDesc = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String umchChkDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String actDatRcvDt = null;
	/* Column Info */
	private String iPage = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActMappingHisVO() {}

	public SearchActMappingHisVO(String ibflag, String pagerows, String actRcvTpCd, String actUmchTpCd, String actStsMapgCd, String actDt, String vvd, String bkgNo, String actGapDesc, String cntrNo, String copNo, String actCd, String nodCd, String plnDt, String estmDt, String mstCopNo, String actDatRcvDt, String umchChkDt, String dupFlg, String updDt, String updUsrId, String page, String actFmDt, String actToDt, String porCd, String podCd, String polCd, String delCd,String iPage) {
		this.porCd = porCd;
		this.copNo = copNo;
		this.dupFlg = dupFlg;
		this.actStsMapgCd = actStsMapgCd;
		this.actUmchTpCd = actUmchTpCd;
		this.pagerows = pagerows;
		this.estmDt = estmDt;
		this.mstCopNo = mstCopNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.page = page;
		this.actFmDt = actFmDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.actCd = actCd;
		this.actToDt = actToDt;
		this.actRcvTpCd = actRcvTpCd;
		this.delCd = delCd;
		this.plnDt = plnDt;
		this.actGapDesc = actGapDesc;
		this.podCd = podCd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.actDt = actDt;
		this.umchChkDt = umchChkDt;
		this.cntrNo = cntrNo;
		this.nodCd = nodCd;
		this.actDatRcvDt = actDatRcvDt;
		this.iPage = iPage;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("dup_flg", getDupFlg());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("act_umch_tp_cd", getActUmchTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("estm_dt", getEstmDt());
		this.hashColumns.put("mst_cop_no", getMstCopNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("page", getPage());
		this.hashColumns.put("act_fm_dt", getActFmDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("act_to_dt", getActToDt());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pln_dt", getPlnDt());
		this.hashColumns.put("act_gap_desc", getActGapDesc());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("umch_chk_dt", getUmchChkDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("act_dat_rcv_dt", getActDatRcvDt());
		this.hashColumns.put("i_page", getIPage());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("dup_flg", "dupFlg");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("act_umch_tp_cd", "actUmchTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("estm_dt", "estmDt");
		this.hashFields.put("mst_cop_no", "mstCopNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("page", "page");
		this.hashFields.put("act_fm_dt", "actFmDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("act_to_dt", "actToDt");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pln_dt", "plnDt");
		this.hashFields.put("act_gap_desc", "actGapDesc");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("umch_chk_dt", "umchChkDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("act_dat_rcv_dt", "actDatRcvDt");
		this.hashFields.put("i_page", "iPage");
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
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return dupFlg
	 */
	public String getDupFlg() {
		return this.dupFlg;
	}
	
	/**
	 * Column Info
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return actUmchTpCd
	 */
	public String getActUmchTpCd() {
		return this.actUmchTpCd;
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
	 * @return estmDt
	 */
	public String getEstmDt() {
		return this.estmDt;
	}
	
	/**
	 * Column Info
	 * @return mstCopNo
	 */
	public String getMstCopNo() {
		return this.mstCopNo;
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
	 * @return page
	 */
	public String getPage() {
		return this.page;
	}
	
	/**
	 * Column Info
	 * @return actFmDt
	 */
	public String getActFmDt() {
		return this.actFmDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return actToDt
	 */
	public String getActToDt() {
		return this.actToDt;
	}
	
	/**
	 * Column Info
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
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
	 * @return plnDt
	 */
	public String getPlnDt() {
		return this.plnDt;
	}
	
	/**
	 * Column Info
	 * @return actGapDesc
	 */
	public String getActGapDesc() {
		return this.actGapDesc;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return umchChkDt
	 */
	public String getUmchChkDt() {
		return this.umchChkDt;
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
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return actDatRcvDt
	 */
	public String getActDatRcvDt() {
		return this.actDatRcvDt;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
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
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param dupFlg
	 */
	public void setDupFlg(String dupFlg) {
		this.dupFlg = dupFlg;
	}
	
	/**
	 * Column Info
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param actUmchTpCd
	 */
	public void setActUmchTpCd(String actUmchTpCd) {
		this.actUmchTpCd = actUmchTpCd;
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
	 * @param estmDt
	 */
	public void setEstmDt(String estmDt) {
		this.estmDt = estmDt;
	}
	
	/**
	 * Column Info
	 * @param mstCopNo
	 */
	public void setMstCopNo(String mstCopNo) {
		this.mstCopNo = mstCopNo;
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
	 * @param page
	 */
	public void setPage(String page) {
		this.page = page;
	}
	
	/**
	 * Column Info
	 * @param actFmDt
	 */
	public void setActFmDt(String actFmDt) {
		this.actFmDt = actFmDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param actToDt
	 */
	public void setActToDt(String actToDt) {
		this.actToDt = actToDt;
	}
	
	/**
	 * Column Info
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
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
	 * @param plnDt
	 */
	public void setPlnDt(String plnDt) {
		this.plnDt = plnDt;
	}
	
	/**
	 * Column Info
	 * @param actGapDesc
	 */
	public void setActGapDesc(String actGapDesc) {
		this.actGapDesc = actGapDesc;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param umchChkDt
	 */
	public void setUmchChkDt(String umchChkDt) {
		this.umchChkDt = umchChkDt;
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
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Column Info
	 * @param actDatRcvDt
	 */
	public void setActDatRcvDt(String actDatRcvDt) {
		this.actDatRcvDt = actDatRcvDt;
	}	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setDupFlg(JSPUtil.getParameter(request, "dup_flg", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, "act_sts_mapg_cd", ""));
		setActUmchTpCd(JSPUtil.getParameter(request, "act_umch_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEstmDt(JSPUtil.getParameter(request, "estm_dt", ""));
		setMstCopNo(JSPUtil.getParameter(request, "mst_cop_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPage(JSPUtil.getParameter(request, "page", ""));
		setActFmDt(JSPUtil.getParameter(request, "act_fm_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setActToDt(JSPUtil.getParameter(request, "act_to_dt", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, "act_rcv_tp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPlnDt(JSPUtil.getParameter(request, "pln_dt", ""));
		setActGapDesc(JSPUtil.getParameter(request, "act_gap_desc", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setActDt(JSPUtil.getParameter(request, "act_dt", ""));
		setUmchChkDt(JSPUtil.getParameter(request, "umch_chk_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setActDatRcvDt(JSPUtil.getParameter(request, "act_dat_rcv_dt", ""));
		setIPage(JSPUtil.getParameter(request, "i_page", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActMappingHisVO[]
	 */
	public SearchActMappingHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActMappingHisVO[]
	 */
	public SearchActMappingHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActMappingHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] dupFlg = (JSPUtil.getParameter(request, prefix	+ "dup_flg", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_mapg_cd", length));
			String[] actUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "act_umch_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] estmDt = (JSPUtil.getParameter(request, prefix	+ "estm_dt", length));
			String[] mstCopNo = (JSPUtil.getParameter(request, prefix	+ "mst_cop_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] page = (JSPUtil.getParameter(request, prefix	+ "page", length));
			String[] actFmDt = (JSPUtil.getParameter(request, prefix	+ "act_fm_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] actToDt = (JSPUtil.getParameter(request, prefix	+ "act_to_dt", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] plnDt = (JSPUtil.getParameter(request, prefix	+ "pln_dt", length));
			String[] actGapDesc = (JSPUtil.getParameter(request, prefix	+ "act_gap_desc", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] umchChkDt = (JSPUtil.getParameter(request, prefix	+ "umch_chk_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] actDatRcvDt = (JSPUtil.getParameter(request, prefix	+ "act_dat_rcv_dt", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActMappingHisVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (dupFlg[i] != null)
					model.setDupFlg(dupFlg[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (actUmchTpCd[i] != null)
					model.setActUmchTpCd(actUmchTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (estmDt[i] != null)
					model.setEstmDt(estmDt[i]);
				if (mstCopNo[i] != null)
					model.setMstCopNo(mstCopNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (page[i] != null)
					model.setPage(page[i]);
				if (actFmDt[i] != null)
					model.setActFmDt(actFmDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (actToDt[i] != null)
					model.setActToDt(actToDt[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (plnDt[i] != null)
					model.setPlnDt(plnDt[i]);
				if (actGapDesc[i] != null)
					model.setActGapDesc(actGapDesc[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (umchChkDt[i] != null)
					model.setUmchChkDt(umchChkDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (actDatRcvDt[i] != null)
					model.setActDatRcvDt(actDatRcvDt[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActMappingHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActMappingHisVO[]
	 */
	public SearchActMappingHisVO[] getSearchActMappingHisVOs(){
		SearchActMappingHisVO[] vos = (SearchActMappingHisVO[])models.toArray(new SearchActMappingHisVO[models.size()]);
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
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupFlg = this.dupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actUmchTpCd = this.actUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDt = this.estmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCopNo = this.mstCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.page = this.page .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFmDt = this.actFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actToDt = this.actToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnDt = this.plnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actGapDesc = this.actGapDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchChkDt = this.umchChkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDatRcvDt = this.actDatRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
