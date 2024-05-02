/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchBKGCntrListVO.java
*@FileTitle : SearchBKGCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2013.09.12 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBKGCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBKGCntrListVO> models = new ArrayList<SearchBKGCntrListVO>();
	private List<DODTariffVO> listDODTariffVO = null;
	
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String nfty = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String bilCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dodInvNo = null;
	/* Column Info */
	private String dodLocCd = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String sessionOfcCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String polContiCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polContiNm = null;
	/* Column Info */
	private String addAmt = null;
	/* Column Info */
	private String totBilAmt = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBKGCntrListVO() {}

	public SearchBKGCntrListVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String dodLocCd, String bilCurrCd, String bilAmt, String taxAmt, String invAmt, String creUsrId, String podCd, String delCd, String deTermCd, String cnee, String nfty, String dodInvNo, String bkgNo, String blNo, String lstmCd,String shpr,String sessionOfcCd, String polCd, String polContiCd, String polContiNm, String effDt, String addAmt, String totBilAmt) {
		this.delCd = delCd;
		this.nfty = nfty;
		this.blNo = blNo;
		this.bilAmt = bilAmt;
		this.bilCurrCd = bilCurrCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.dodInvNo = dodInvNo;
		this.dodLocCd = dodLocCd;
		this.taxAmt = taxAmt;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.cnee = cnee;
		this.invAmt = invAmt;
		this.lstmCd = lstmCd;
		this.shpr = shpr;
		this.sessionOfcCd = sessionOfcCd;
		this.effDt = effDt;
		this.polContiCd = polContiCd;
		this.polCd = polCd;
		this.polContiNm = polContiNm;
		this.addAmt = addAmt;
		this.totBilAmt = totBilAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("nfty", getNfty());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("bil_curr_cd", getBilCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dod_inv_no", getDodInvNo());
		this.hashColumns.put("dod_loc_cd", getDodLocCd());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("session_ofc_cd", getSessionOfcCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("pol_conti_cd", getPolContiCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_conti_nm", getPolContiNm());
		this.hashColumns.put("add_amt", getAddAmt());
		this.hashColumns.put("tot_bil_amt", getTotBilAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("nfty", "nfty");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("bil_curr_cd", "bilCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dod_inv_no", "dodInvNo");
		this.hashFields.put("dod_loc_cd", "dodLocCd");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("sessionOfcCd","session_ofc_cd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("pol_conti_cd", "polContiCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_conti_nm", "polContiNm");
		this.hashFields.put("add_amt", "addAmt");
		this.hashFields.put("tot_bil_amt", "totBilAmt");
		return this.hashFields;
	}
	
	public List<DODTariffVO> getListDODTariffVO() {
		return listDODTariffVO;
	}

	public void setListDODTariffVO(List<DODTariffVO> listDODTariffVO) {
		this.listDODTariffVO = listDODTariffVO;
	}
	
	/**
	 * Column Info
	 * @return addAmt
	 */
	public String getAddAmt() {
		return this.addAmt;
	}
	
	/**
	 * Column Info
	 * @return totBilAmt
	 */
	public String getTotBilAmt() {
		return this.totBilAmt;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return polContiCd
	 */
	public String getPolContiCd() {
		return this.polContiCd;
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
	 * @return polContiNm
	 */
	public String getPolContiNm() {
		return this.polContiNm;
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
	 * @return nfty
	 */
	public String getNfty() {
		return this.nfty;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
	}
	
	/**
	 * Column Info
	 * @return bilCurrCd
	 */
	public String getBilCurrCd() {
		return this.bilCurrCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return dodInvNo
	 */
	public String getDodInvNo() {
		return this.dodInvNo;
	}
	
	/**
	 * Column Info
	 * @return dodLocCd
	 */
	public String getDodLocCd() {
		return this.dodLocCd;
	}
	
	/**
	 * Column Info
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column shpr
	 * @return shpr
	 */
	public String getShpr() {
		return shpr;
	}

	/**
	 * Column sessionOfcCd
	 * @return sessionOfcCd
	 */
	public String getSessionOfcCd() {
		return sessionOfcCd;
	}
	
	/**
	 * Column shpr
	 * @param shpr
	 */	
	public void setShpr(String shpr) {
		this.shpr = shpr;
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
	 * @param nfty
	 */
	public void setNfty(String nfty) {
		this.nfty = nfty;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param bilCurrCd
	 */
	public void setBilCurrCd(String bilCurrCd) {
		this.bilCurrCd = bilCurrCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param dodInvNo
	 */
	public void setDodInvNo(String dodInvNo) {
		this.dodInvNo = dodInvNo;
	}
	
	/**
	 * Column Info
	 * @param dodLocCd
	 */
	public void setDodLocCd(String dodLocCd) {
		this.dodLocCd = dodLocCd;
	}
	
	/**
	 * Column Info
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column sessionOfcCd
	 * @return sessionOfcCd
	 */
	public void setSessionOfcCd(String sessionOfcCd) {
		this.sessionOfcCd = sessionOfcCd;
	}	
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param polContiCd
	 */
	public void setPolContiCd(String polContiCd) {
		this.polContiCd = polContiCd;
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
	 * @param polContiNm
	 */
	public void setPolContiNm(String polContiNm) {
		this.polContiNm = polContiNm;
	}
	
	/**
	 * Column Info
	 * @param addAmt
	 */
	public void setAddAmt(String addAmt) {
		this.addAmt = addAmt;
	}
	
	/**
	 * Column Info
	 * @param totBilAmt
	 */
	public void setTotBilAmt(String totBilAmt) {
		this.totBilAmt = totBilAmt;
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
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setNfty(JSPUtil.getParameter(request, prefix + "nfty", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setBilCurrCd(JSPUtil.getParameter(request, prefix + "bil_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDodInvNo(JSPUtil.getParameter(request, prefix + "dod_inv_no", ""));
		setDodLocCd(JSPUtil.getParameter(request, prefix + "dod_loc_cd", ""));
		setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setSessionOfcCd(JSPUtil.getParameter(request, prefix + "session_ofc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setPolContiCd(JSPUtil.getParameter(request, prefix + "pol_conti_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPolContiNm(JSPUtil.getParameter(request, prefix + "pol_conti_nm", ""));
		setAddAmt(JSPUtil.getParameter(request, prefix + "add_amt", ""));
		setTotBilAmt(JSPUtil.getParameter(request, prefix + "tot_bil_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBKGCntrListVO[]
	 */
	public SearchBKGCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBKGCntrListVO[]
	 */
	public SearchBKGCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBKGCntrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] nfty = (JSPUtil.getParameter(request, prefix	+ "nfty", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] bilCurrCd = (JSPUtil.getParameter(request, prefix	+ "bil_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dodInvNo = (JSPUtil.getParameter(request, prefix	+ "dod_inv_no", length));
			String[] dodLocCd = (JSPUtil.getParameter(request, prefix	+ "dod_loc_cd", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] sessionOfcCd = (JSPUtil.getParameter(request, prefix	+ "session_ofc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] polContiCd = (JSPUtil.getParameter(request, prefix	+ "pol_conti_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polContiNm = (JSPUtil.getParameter(request, prefix	+ "pol_conti_nm", length));
			String[] addAmt = (JSPUtil.getParameter(request, prefix	+ "add_amt", length));
			String[] totBilAmt = (JSPUtil.getParameter(request, prefix	+ "tot_bil_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBKGCntrListVO();
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (nfty[i] != null)
					model.setNfty(nfty[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (bilCurrCd[i] != null)
					model.setBilCurrCd(bilCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dodInvNo[i] != null)
					model.setDodInvNo(dodInvNo[i]);
				if (dodLocCd[i] != null)
					model.setDodLocCd(dodLocCd[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (sessionOfcCd[i] != null)
					model.setSessionOfcCd(sessionOfcCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (polContiCd[i] != null)
					model.setPolContiCd(polContiCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polContiNm[i] != null)
					model.setPolContiNm(polContiNm[i]);
				if (addAmt[i] != null)
					model.setAddAmt(addAmt[i]);
				if (totBilAmt[i] != null)
					model.setTotBilAmt(totBilAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBKGCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBKGCntrListVO[]
	 */
	public SearchBKGCntrListVO[] getSearchBKGCntrListVOs(){
		SearchBKGCntrListVO[] vos = (SearchBKGCntrListVO[])models.toArray(new SearchBKGCntrListVO[models.size()]);
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
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfty = this.nfty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilCurrCd = this.bilCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodInvNo = this.dodInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodLocCd = this.dodLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sessionOfcCd = this.sessionOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polContiCd = this.polContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polContiNm = this.polContiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addAmt = this.addAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBilAmt = this.totBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
