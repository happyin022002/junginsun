/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchChgRateByLBPVO.java
*@FileTitle : SearchChgRateByLBPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.26
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.01.26 조원주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
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
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchChgRateByLBPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchChgRateByLBPVO> models = new ArrayList<SearchChgRateByLBPVO>();
	
	/* Column Info */
	private String thirdPartyOfc = null;
	/* Column Info */
	private String ppdOffice = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payTermCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String applyFlg = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String repCustCntCd = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String scgAmt = null;
	/* Column Info */
	private String repCustSeq = null;
	/* Column Info */
	private String loginOffice = null;
	/* Column Info */
	private String cltOffice = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String frtInclXcldDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchChgRateByLBPVO() {}

	public SearchChgRateByLBPVO(String ibflag, String pagerows, String bkgNo, String chgCd, String cltOffice, String currCd, String cgoCateCd, String creUsrId, String loginOffice, String ppdOffice, String payTermCd, String scgAmt, String ratUtCd, String updUsrId, String frtInclXcldDivCd, String applyFlg, String thirdPartyOfc, String repCustCntCd, String repCustSeq, String frtTermCd) {
		this.thirdPartyOfc = thirdPartyOfc;
		this.ppdOffice = ppdOffice;
		this.currCd = currCd;
		this.payTermCd = payTermCd;
		this.frtTermCd = frtTermCd;
		this.applyFlg = applyFlg;
		this.ratUtCd = ratUtCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.repCustCntCd = repCustCntCd;
		this.cgoCateCd = cgoCateCd;
		this.scgAmt = scgAmt;
		this.repCustSeq = repCustSeq;
		this.loginOffice = loginOffice;
		this.cltOffice = cltOffice;
		this.updUsrId = updUsrId;
		this.frtInclXcldDivCd = frtInclXcldDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("third_party_ofc", getThirdPartyOfc());
		this.hashColumns.put("ppd_office", getPpdOffice());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("apply_flg", getApplyFlg());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("scg_amt", getScgAmt());
		this.hashColumns.put("rep_cust_seq", getRepCustSeq());
		this.hashColumns.put("login_office", getLoginOffice());
		this.hashColumns.put("clt_office", getCltOffice());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("frt_incl_xcld_div_cd", getFrtInclXcldDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("third_party_ofc", "thirdPartyOfc");
		this.hashFields.put("ppd_office", "ppdOffice");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("apply_flg", "applyFlg");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("scg_amt", "scgAmt");
		this.hashFields.put("rep_cust_seq", "repCustSeq");
		this.hashFields.put("login_office", "loginOffice");
		this.hashFields.put("clt_office", "cltOffice");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("frt_incl_xcld_div_cd", "frtInclXcldDivCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return thirdPartyOfc
	 */
	public String getThirdPartyOfc() {
		return this.thirdPartyOfc;
	}
	
	/**
	 * Column Info
	 * @return ppdOffice
	 */
	public String getPpdOffice() {
		return this.ppdOffice;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return payTermCd
	 */
	public String getPayTermCd() {
		return this.payTermCd;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return applyFlg
	 */
	public String getApplyFlg() {
		return this.applyFlg;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return repCustCntCd
	 */
	public String getRepCustCntCd() {
		return this.repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return scgAmt
	 */
	public String getScgAmt() {
		return this.scgAmt;
	}
	
	/**
	 * Column Info
	 * @return repCustSeq
	 */
	public String getRepCustSeq() {
		return this.repCustSeq;
	}
	
	/**
	 * Column Info
	 * @return loginOffice
	 */
	public String getLoginOffice() {
		return this.loginOffice;
	}
	
	/**
	 * Column Info
	 * @return cltOffice
	 */
	public String getCltOffice() {
		return this.cltOffice;
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
	 * @return frtInclXcldDivCd
	 */
	public String getFrtInclXcldDivCd() {
		return this.frtInclXcldDivCd;
	}
	

	/**
	 * Column Info
	 * @param thirdPartyOfc
	 */
	public void setThirdPartyOfc(String thirdPartyOfc) {
		this.thirdPartyOfc = thirdPartyOfc;
	}
	
	/**
	 * Column Info
	 * @param ppdOffice
	 */
	public void setPpdOffice(String ppdOffice) {
		this.ppdOffice = ppdOffice;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param payTermCd
	 */
	public void setPayTermCd(String payTermCd) {
		this.payTermCd = payTermCd;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param applyFlg
	 */
	public void setApplyFlg(String applyFlg) {
		this.applyFlg = applyFlg;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param repCustCntCd
	 */
	public void setRepCustCntCd(String repCustCntCd) {
		this.repCustCntCd = repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param scgAmt
	 */
	public void setScgAmt(String scgAmt) {
		this.scgAmt = scgAmt;
	}
	
	/**
	 * Column Info
	 * @param repCustSeq
	 */
	public void setRepCustSeq(String repCustSeq) {
		this.repCustSeq = repCustSeq;
	}
	
	/**
	 * Column Info
	 * @param loginOffice
	 */
	public void setLoginOffice(String loginOffice) {
		this.loginOffice = loginOffice;
	}
	
	/**
	 * Column Info
	 * @param cltOffice
	 */
	public void setCltOffice(String cltOffice) {
		this.cltOffice = cltOffice;
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
	 * @param frtInclXcldDivCd
	 */
	public void setFrtInclXcldDivCd(String frtInclXcldDivCd) {
		this.frtInclXcldDivCd = frtInclXcldDivCd;
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
		setThirdPartyOfc(JSPUtil.getParameter(request, prefix + "third_party_ofc", ""));
		setPpdOffice(JSPUtil.getParameter(request, prefix + "ppd_office", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayTermCd(JSPUtil.getParameter(request, prefix + "pay_term_cd", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setApplyFlg(JSPUtil.getParameter(request, prefix + "apply_flg", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRepCustCntCd(JSPUtil.getParameter(request, prefix + "rep_cust_cnt_cd", ""));
		setCgoCateCd(JSPUtil.getParameter(request, prefix + "cgo_cate_cd", ""));
		setScgAmt(JSPUtil.getParameter(request, prefix + "scg_amt", ""));
		setRepCustSeq(JSPUtil.getParameter(request, prefix + "rep_cust_seq", ""));
		setLoginOffice(JSPUtil.getParameter(request, prefix + "login_office", ""));
		setCltOffice(JSPUtil.getParameter(request, prefix + "clt_office", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFrtInclXcldDivCd(JSPUtil.getParameter(request, prefix + "frt_incl_xcld_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchChgRateByLBPVO[]
	 */
	public SearchChgRateByLBPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchChgRateByLBPVO[]
	 */
	public SearchChgRateByLBPVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchChgRateByLBPVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] thirdPartyOfc = (JSPUtil.getParameter(request, prefix	+ "third_party_ofc", length));
			String[] ppdOffice = (JSPUtil.getParameter(request, prefix	+ "ppd_office", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payTermCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] applyFlg = (JSPUtil.getParameter(request, prefix	+ "apply_flg", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] repCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rep_cust_cnt_cd", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] scgAmt = (JSPUtil.getParameter(request, prefix	+ "scg_amt", length));
			String[] repCustSeq = (JSPUtil.getParameter(request, prefix	+ "rep_cust_seq", length));
			String[] loginOffice = (JSPUtil.getParameter(request, prefix	+ "login_office", length));
			String[] cltOffice = (JSPUtil.getParameter(request, prefix	+ "clt_office", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] frtInclXcldDivCd = (JSPUtil.getParameter(request, prefix	+ "frt_incl_xcld_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchChgRateByLBPVO();
				if (thirdPartyOfc[i] != null)
					model.setThirdPartyOfc(thirdPartyOfc[i]);
				if (ppdOffice[i] != null)
					model.setPpdOffice(ppdOffice[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payTermCd[i] != null)
					model.setPayTermCd(payTermCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (applyFlg[i] != null)
					model.setApplyFlg(applyFlg[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (repCustCntCd[i] != null)
					model.setRepCustCntCd(repCustCntCd[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (scgAmt[i] != null)
					model.setScgAmt(scgAmt[i]);
				if (repCustSeq[i] != null)
					model.setRepCustSeq(repCustSeq[i]);
				if (loginOffice[i] != null)
					model.setLoginOffice(loginOffice[i]);
				if (cltOffice[i] != null)
					model.setCltOffice(cltOffice[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (frtInclXcldDivCd[i] != null)
					model.setFrtInclXcldDivCd(frtInclXcldDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchChgRateByLBPVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchChgRateByLBPVO[]
	 */
	public SearchChgRateByLBPVO[] getSearchChgRateByLBPVOs(){
		SearchChgRateByLBPVO[] vos = (SearchChgRateByLBPVO[])models.toArray(new SearchChgRateByLBPVO[models.size()]);
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
		this.thirdPartyOfc = this.thirdPartyOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOffice = this.ppdOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd = this.payTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applyFlg = this.applyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustCntCd = this.repCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgAmt = this.scgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustSeq = this.repCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOffice = this.loginOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOffice = this.cltOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtInclXcldDivCd = this.frtInclXcldDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
