/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgSurchargeRateVO.java
*@FileTitle : BkgSurchargeRateVO
*Open Issues :
*Change history :
*@LastModifyDate :2013.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.25  
* 1.0 Creation 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgSurchargeRateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgSurchargeRateVO> models = new ArrayList<BkgSurchargeRateVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String loginOfc = null;
	/* Column Info */
	private String ppdOfc = null;
	/* Column Info */
	private String payTermCd = null;
	/* Column Info */
	private String scgAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String frtInclXcldDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgSurchargeRateVO() {}

	public BkgSurchargeRateVO(String ibflag, String pagerows, String bkgNo, String ratUtCd, String cltOfcCd, String chgCd, String currCd, String scgAmt, String cgoCateCd, String creUsrId, String loginOfc, String ppdOfc, String payTermCd, String updUsrId, String frtInclXcldDivCd) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.chgCd = chgCd;
		this.cltOfcCd = cltOfcCd;
		this.currCd = currCd;
		this.cgoCateCd = cgoCateCd;
		this.creUsrId = creUsrId;
		this.loginOfc = loginOfc;
		this.ppdOfc = ppdOfc;
		this.payTermCd = payTermCd;
		this.scgAmt = scgAmt;
		this.ratUtCd = ratUtCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.frtInclXcldDivCd = frtInclXcldDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("clt_office", getCltOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("login_office", getLoginOfc());
		this.hashColumns.put("ppd_office", getPpdOfc());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("scg_amt", getScgAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("frt_incl_xcld_div_cd", getFrtInclXcldDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("clt_office", "cltOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("login_office", "loginOfc");
		this.hashFields.put("ppd_office", "ppdOfc");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("scg_amt", "scgAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("frt_incl_xcld_div_cd", "frtInclXcldDivCd");
		return this.hashFields;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return loginOfc
	 */
	public String getLoginOfc() {
		return this.loginOfc;
	}
	
	/**
	 * Column Info
	 * @return ppdOfc
	 */
	public String getPpdOfc() {
		return this.ppdOfc;
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
	 * @return scgAmt
	 */
	public String getScgAmt() {
		return this.scgAmt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return frtInclXcldDivCd
	 */
	public String getFrtInclXcldDivCd() {
		return this.frtInclXcldDivCd;
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
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}

	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
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
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
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
	 * @param loginOfc
	 */
	public void setLoginOfc(String loginOfc) {
		this.loginOfc = loginOfc;
	}
	
	/**
	 * Column Info
	 * @param ppdOfc
	 */
	public void setPpdOfc(String ppdOfc) {
		this.ppdOfc = ppdOfc;
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
	 * @param scgAmt
	 */
	public void setScgAmt(String scgAmt) {
		this.scgAmt = scgAmt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_office", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCgoCateCd(JSPUtil.getParameter(request, prefix + "cgo_cate_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLoginOfc(JSPUtil.getParameter(request, prefix + "login_office", ""));
		setPpdOfc(JSPUtil.getParameter(request, prefix + "ppd_office", ""));
		setPayTermCd(JSPUtil.getParameter(request, prefix + "pay_term_cd", ""));
		setScgAmt(JSPUtil.getParameter(request, prefix + "scg_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFrtInclXcldDivCd(JSPUtil.getParameter(request, prefix + "frt_incl_xcld_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgSurchargeRateVO[]
	 */
	public BkgSurchargeRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgSurchargeRateVO[]
	 */
	public BkgSurchargeRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgSurchargeRateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix + "clt_office", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] loginOfc = (JSPUtil.getParameter(request, prefix	+ "login_office", length));
			String[] ppdOfc = (JSPUtil.getParameter(request, prefix	+ "ppd_office", length));
			String[] payTermCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_cd", length));
			String[] scgAmt = (JSPUtil.getParameter(request, prefix	+ "scg_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] frtInclXcldDivCd = (JSPUtil.getParameter(request, prefix	+ "frt_incl_xcld_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgSurchargeRateVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (loginOfc[i] != null)
					model.setLoginOfc(loginOfc[i]);
				if (ppdOfc[i] != null)
					model.setPpdOfc(ppdOfc[i]);
				if (payTermCd[i] != null)
					model.setPayTermCd(payTermCd[i]);
				if (scgAmt[i] != null)
					model.setScgAmt(scgAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frtInclXcldDivCd[i] != null)
					model.setFrtInclXcldDivCd(frtInclXcldDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgSurchargeRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgSurchargeRateVO[]
	 */
	public BkgSurchargeRateVO[] getBkgSurchargeRateVOs(){
		BkgSurchargeRateVO[] vos = (BkgSurchargeRateVO[])models.toArray(new BkgSurchargeRateVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfc = this.loginOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOfc = this.ppdOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd = this.payTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgAmt = this.scgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtInclXcldDivCd = this.frtInclXcldDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
