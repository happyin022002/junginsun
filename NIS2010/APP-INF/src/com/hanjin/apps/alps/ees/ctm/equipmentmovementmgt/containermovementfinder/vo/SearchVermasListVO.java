/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : SearchVermasListVO.java
 * @FileTitle : SearchVermasListVO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.07.18
 * @LastModifier : 
 * @LastVersion : 1.0
 * 2016.07.18 김상현 1.0 Creation.
 */

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * Table Value Object.
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVermasListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVermasListVO> models = new ArrayList<SearchVermasListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vrfdWgtCd = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String ptyPsonNm = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vgmWgtQty = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String via = null;
	/* Column Info */
	private String ptyNm = null;
	/* Column Info */
	private String divflag = null;
	/* Column Info */
	private String ptyFuncCd = null;
	/* Column Info */
	private String vgmVrfyDt = null;
	/* Column Info */
	private String vgmSeq = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String smtNm = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String creLoclDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchVermasListVO() {}

	public SearchVermasListVO(String ibflag, String pagerows, String cntrNo, String bkgNo, String vgmWgtQty, String vrfdWgtCd, String ptyNm, String vgmMzdTpCd, String vgmVrfyDt, String refNo, String ptyFuncCd, String ptyPsonNm, String vgmSeq, String polYdCd, String smtNm, String creLoclDt, String via, String pDate1, String pDate2, String rccCd, String lccCd, String orgYdCd, String divflag) {
		this.pagerows = pagerows;
		this.vrfdWgtCd = vrfdWgtCd;
		this.refNo = refNo;
		this.ptyPsonNm = ptyPsonNm;
		this.orgYdCd = orgYdCd;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.ibflag = ibflag;
		this.polYdCd = polYdCd;
		this.rccCd = rccCd;
		this.bkgNo = bkgNo;
		this.vgmWgtQty = vgmWgtQty;
		this.lccCd = lccCd;
		this.via = via;
		this.ptyNm = ptyNm;
		this.divflag = divflag;
		this.ptyFuncCd = ptyFuncCd;
		this.vgmVrfyDt = vgmVrfyDt;
		this.vgmSeq = vgmSeq;
		this.pDate1 = pDate1;
		this.cntrNo = cntrNo;
		this.smtNm = smtNm;
		this.pDate2 = pDate2;
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vrfd_wgt_cd", getVrfdWgtCd());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("pty_pson_nm", getPtyPsonNm());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vgm_wgt_qty", getVgmWgtQty());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("via", getVia());
		this.hashColumns.put("pty_nm", getPtyNm());
		this.hashColumns.put("divflag", getDivflag());
		this.hashColumns.put("pty_func_cd", getPtyFuncCd());
		this.hashColumns.put("vgm_vrfy_dt", getVgmVrfyDt());
		this.hashColumns.put("vgm_seq", getVgmSeq());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("smt_nm", getSmtNm());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vrfd_wgt_cd", "vrfdWgtCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("pty_pson_nm", "ptyPsonNm");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vgm_wgt_qty", "vgmWgtQty");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("via", "via");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("divflag", "divflag");
		this.hashFields.put("pty_func_cd", "ptyFuncCd");
		this.hashFields.put("vgm_vrfy_dt", "vgmVrfyDt");
		this.hashFields.put("vgm_seq", "vgmSeq");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("smt_nm", "smtNm");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		return this.hashFields;
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
	 * @return vrfdWgtCd
	 */
	public String getVrfdWgtCd() {
		return this.vrfdWgtCd;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return ptyPsonNm
	 */
	public String getPtyPsonNm() {
		return this.ptyPsonNm;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return vgmMzdTpCd
	 */
	public String getVgmMzdTpCd() {
		return this.vgmMzdTpCd;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
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
	 * @return vgmWgtQty
	 */
	public String getVgmWgtQty() {
		return this.vgmWgtQty;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return via
	 */
	public String getVia() {
		return this.via;
	}
	
	/**
	 * Column Info
	 * @return ptyNm
	 */
	public String getPtyNm() {
		return this.ptyNm;
	}
	
	/**
	 * Column Info
	 * @return divflag
	 */
	public String getDivflag() {
		return this.divflag;
	}
	
	/**
	 * Column Info
	 * @return ptyFuncCd
	 */
	public String getPtyFuncCd() {
		return this.ptyFuncCd;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfyDt
	 */
	public String getVgmVrfyDt() {
		return this.vgmVrfyDt;
	}
	
	/**
	 * Column Info
	 * @return vgmSeq
	 */
	public String getVgmSeq() {
		return this.vgmSeq;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return smtNm
	 */
	public String getSmtNm() {
		return this.smtNm;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
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
	 * @param vrfdWgtCd
	 */
	public void setVrfdWgtCd(String vrfdWgtCd) {
		this.vrfdWgtCd = vrfdWgtCd;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param ptyPsonNm
	 */
	public void setPtyPsonNm(String ptyPsonNm) {
		this.ptyPsonNm = ptyPsonNm;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
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
	 * @param vgmWgtQty
	 */
	public void setVgmWgtQty(String vgmWgtQty) {
		this.vgmWgtQty = vgmWgtQty;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param via
	 */
	public void setVia(String via) {
		this.via = via;
	}
	
	/**
	 * Column Info
	 * @param ptyNm
	 */
	public void setPtyNm(String ptyNm) {
		this.ptyNm = ptyNm;
	}
	
	/**
	 * Column Info
	 * @param divflag
	 */
	public void setDivflag(String divflag) {
		this.divflag = divflag;
	}
	
	/**
	 * Column Info
	 * @param ptyFuncCd
	 */
	public void setPtyFuncCd(String ptyFuncCd) {
		this.ptyFuncCd = ptyFuncCd;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfyDt
	 */
	public void setVgmVrfyDt(String vgmVrfyDt) {
		this.vgmVrfyDt = vgmVrfyDt;
	}
	
	/**
	 * Column Info
	 * @param vgmSeq
	 */
	public void setVgmSeq(String vgmSeq) {
		this.vgmSeq = vgmSeq;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param smtNm
	 */
	public void setSmtNm(String smtNm) {
		this.smtNm = smtNm;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVrfdWgtCd(JSPUtil.getParameter(request, prefix + "vrfd_wgt_cd", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setPtyPsonNm(JSPUtil.getParameter(request, prefix + "pty_pson_nm", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVgmWgtQty(JSPUtil.getParameter(request, prefix + "vgm_wgt_qty", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setVia(JSPUtil.getParameter(request, prefix + "via", ""));
		setPtyNm(JSPUtil.getParameter(request, prefix + "pty_nm", ""));
		setDivflag(JSPUtil.getParameter(request, prefix + "divflag", ""));
		setPtyFuncCd(JSPUtil.getParameter(request, prefix + "pty_func_cd", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", ""));
		setVgmSeq(JSPUtil.getParameter(request, prefix + "vgm_seq", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSmtNm(JSPUtil.getParameter(request, prefix + "smt_nm", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVermasListVO[]
	 */
	public SearchVermasListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVermasListVO[]
	 */
	public SearchVermasListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVermasListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vrfdWgtCd = (JSPUtil.getParameter(request, prefix	+ "vrfd_wgt_cd", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] ptyPsonNm = (JSPUtil.getParameter(request, prefix	+ "pty_pson_nm", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vgmWgtQty = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_qty", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] via = (JSPUtil.getParameter(request, prefix	+ "via", length));
			String[] ptyNm = (JSPUtil.getParameter(request, prefix	+ "pty_nm", length));
			String[] divflag = (JSPUtil.getParameter(request, prefix	+ "divflag", length));
			String[] ptyFuncCd = (JSPUtil.getParameter(request, prefix	+ "pty_func_cd", length));
			String[] vgmVrfyDt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_dt", length));
			String[] vgmSeq = (JSPUtil.getParameter(request, prefix	+ "vgm_seq", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] smtNm = (JSPUtil.getParameter(request, prefix	+ "smt_nm", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVermasListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vrfdWgtCd[i] != null)
					model.setVrfdWgtCd(vrfdWgtCd[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (ptyPsonNm[i] != null)
					model.setPtyPsonNm(ptyPsonNm[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vgmWgtQty[i] != null)
					model.setVgmWgtQty(vgmWgtQty[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (via[i] != null)
					model.setVia(via[i]);
				if (ptyNm[i] != null)
					model.setPtyNm(ptyNm[i]);
				if (divflag[i] != null)
					model.setDivflag(divflag[i]);
				if (ptyFuncCd[i] != null)
					model.setPtyFuncCd(ptyFuncCd[i]);
				if (vgmVrfyDt[i] != null)
					model.setVgmVrfyDt(vgmVrfyDt[i]);
				if (vgmSeq[i] != null)
					model.setVgmSeq(vgmSeq[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (smtNm[i] != null)
					model.setSmtNm(smtNm[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVermasListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVermasListVO[]
	 */
	public SearchVermasListVO[] getSearchVermasListVOs(){
		SearchVermasListVO[] vos = (SearchVermasListVO[])models.toArray(new SearchVermasListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrfdWgtCd = this.vrfdWgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyPsonNm = this.ptyPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtQty = this.vgmWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.via = this.via .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm = this.ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divflag = this.divflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyFuncCd = this.ptyFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt = this.vgmVrfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmSeq = this.vgmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtNm = this.smtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
