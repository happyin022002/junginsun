/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UnsettledAccountListVO.java
*@FileTitle : UnsettledAccountListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.28
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.28 차상영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 차상영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UnsettledAccountListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnsettledAccountListVO> models = new ArrayList<UnsettledAccountListVO>();
	
	/* Column Info */
	private String inpDrAmt = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String unstlDlLineNo = null;
	/* Column Info */
	private String coaCtrCd = null;
	/* Column Info */
	private String coaAcctCd = null;
	/* Column Info */
	private String unstlCurrCd = null;
	/* Column Info */
	private String cInpCrAmt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String cInpDrAmt = null;
	/* Column Info */
	private String acctEngNm = null;
	/* Column Info */
	private String inpCrAmt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String acctLoclNm = null;
	/* Column Info */
	private String unstlDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UnsettledAccountListVO() {}

	public UnsettledAccountListVO(String ibflag, String pagerows, String coaAcctCd, String acctEngNm, String acctLoclNm, String vndrLglEngNm, String vndrNo, String coaCtrCd, String ofcCd, String arOfcCd, String invNo, String unstlDlLineNo, String glDt, String unstlCurrCd, String inpDrAmt, String cInpDrAmt, String inpCrAmt, String cInpCrAmt, String unstlDesc) {
		this.inpDrAmt = inpDrAmt;
		this.glDt = glDt;
		this.unstlDlLineNo = unstlDlLineNo;
		this.coaCtrCd = coaCtrCd;
		this.coaAcctCd = coaAcctCd;
		this.unstlCurrCd = unstlCurrCd;
		this.cInpCrAmt = cInpCrAmt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.cInpDrAmt = cInpDrAmt;
		this.acctEngNm = acctEngNm;
		this.inpCrAmt = inpCrAmt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.vndrNo = vndrNo;
		this.acctLoclNm = acctLoclNm;
		this.unstlDesc = unstlDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inp_dr_amt", getInpDrAmt());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("unstl_dl_line_no", getUnstlDlLineNo());
		this.hashColumns.put("coa_ctr_cd", getCoaCtrCd());
		this.hashColumns.put("coa_acct_cd", getCoaAcctCd());
		this.hashColumns.put("unstl_curr_cd", getUnstlCurrCd());
		this.hashColumns.put("c_inp_cr_amt", getCInpCrAmt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("c_inp_dr_amt", getCInpDrAmt());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("inp_cr_amt", getInpCrAmt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("acct_locl_nm", getAcctLoclNm());
		this.hashColumns.put("unstl_desc", getUnstlDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inp_dr_amt", "inpDrAmt");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("unstl_dl_line_no", "unstlDlLineNo");
		this.hashFields.put("coa_ctr_cd", "coaCtrCd");
		this.hashFields.put("coa_acct_cd", "coaAcctCd");
		this.hashFields.put("unstl_curr_cd", "unstlCurrCd");
		this.hashFields.put("c_inp_cr_amt", "cInpCrAmt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("c_inp_dr_amt", "cInpDrAmt");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("inp_cr_amt", "inpCrAmt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("acct_locl_nm", "acctLoclNm");
		this.hashFields.put("unstl_desc", "unstlDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inpDrAmt
	 */
	public String getInpDrAmt() {
		return this.inpDrAmt;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return unstlDlLineNo
	 */
	public String getUnstlDlLineNo() {
		return this.unstlDlLineNo;
	}
	
	/**
	 * Column Info
	 * @return coaCtrCd
	 */
	public String getCoaCtrCd() {
		return this.coaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return coaAcctCd
	 */
	public String getCoaAcctCd() {
		return this.coaAcctCd;
	}
	
	/**
	 * Column Info
	 * @return unstlCurrCd
	 */
	public String getUnstlCurrCd() {
		return this.unstlCurrCd;
	}
	
	/**
	 * Column Info
	 * @return cInpCrAmt
	 */
	public String getCInpCrAmt() {
		return this.cInpCrAmt;
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
	 * @return cInpDrAmt
	 */
	public String getCInpDrAmt() {
		return this.cInpDrAmt;
	}
	
	/**
	 * Column Info
	 * @return acctEngNm
	 */
	public String getAcctEngNm() {
		return this.acctEngNm;
	}
	
	/**
	 * Column Info
	 * @return inpCrAmt
	 */
	public String getInpCrAmt() {
		return this.inpCrAmt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
	}
	
	/**
	 * Column Info
	 * @return acctLoclNm
	 */
	public String getAcctLoclNm() {
		return this.acctLoclNm;
	}
	
	/**
	 * Column Info
	 * @return unstlDesc
	 */
	public String getUnstlDesc() {
		return this.unstlDesc;
	}
	

	/**
	 * Column Info
	 * @param inpDrAmt
	 */
	public void setInpDrAmt(String inpDrAmt) {
		this.inpDrAmt = inpDrAmt;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param unstlDlLineNo
	 */
	public void setUnstlDlLineNo(String unstlDlLineNo) {
		this.unstlDlLineNo = unstlDlLineNo;
	}
	
	/**
	 * Column Info
	 * @param coaCtrCd
	 */
	public void setCoaCtrCd(String coaCtrCd) {
		this.coaCtrCd = coaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param coaAcctCd
	 */
	public void setCoaAcctCd(String coaAcctCd) {
		this.coaAcctCd = coaAcctCd;
	}
	
	/**
	 * Column Info
	 * @param unstlCurrCd
	 */
	public void setUnstlCurrCd(String unstlCurrCd) {
		this.unstlCurrCd = unstlCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cInpCrAmt
	 */
	public void setCInpCrAmt(String cInpCrAmt) {
		this.cInpCrAmt = cInpCrAmt;
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
	 * @param cInpDrAmt
	 */
	public void setCInpDrAmt(String cInpDrAmt) {
		this.cInpDrAmt = cInpDrAmt;
	}
	
	/**
	 * Column Info
	 * @param acctEngNm
	 */
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
	}
	
	/**
	 * Column Info
	 * @param inpCrAmt
	 */
	public void setInpCrAmt(String inpCrAmt) {
		this.inpCrAmt = inpCrAmt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}
	
	/**
	 * Column Info
	 * @param acctLoclNm
	 */
	public void setAcctLoclNm(String acctLoclNm) {
		this.acctLoclNm = acctLoclNm;
	}
	
	/**
	 * Column Info
	 * @param unstlDesc
	 */
	public void setUnstlDesc(String unstlDesc) {
		this.unstlDesc = unstlDesc;
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
		setInpDrAmt(JSPUtil.getParameter(request, prefix + "inp_dr_amt", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setUnstlDlLineNo(JSPUtil.getParameter(request, prefix + "unstl_dl_line_no", ""));
		setCoaCtrCd(JSPUtil.getParameter(request, prefix + "coa_ctr_cd", ""));
		setCoaAcctCd(JSPUtil.getParameter(request, prefix + "coa_acct_cd", ""));
		setUnstlCurrCd(JSPUtil.getParameter(request, prefix + "unstl_curr_cd", ""));
		setCInpCrAmt(JSPUtil.getParameter(request, prefix + "c_inp_cr_amt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCInpDrAmt(JSPUtil.getParameter(request, prefix + "c_inp_dr_amt", ""));
		setAcctEngNm(JSPUtil.getParameter(request, prefix + "acct_eng_nm", ""));
		setInpCrAmt(JSPUtil.getParameter(request, prefix + "inp_cr_amt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setAcctLoclNm(JSPUtil.getParameter(request, prefix + "acct_locl_nm", ""));
		setUnstlDesc(JSPUtil.getParameter(request, prefix + "unstl_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnsettledAccountListVO[]
	 */
	public UnsettledAccountListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnsettledAccountListVO[]
	 */
	public UnsettledAccountListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnsettledAccountListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inpDrAmt = (JSPUtil.getParameter(request, prefix	+ "inp_dr_amt", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] unstlDlLineNo = (JSPUtil.getParameter(request, prefix	+ "unstl_dl_line_no", length));
			String[] coaCtrCd = (JSPUtil.getParameter(request, prefix	+ "coa_ctr_cd", length));
			String[] coaAcctCd = (JSPUtil.getParameter(request, prefix	+ "coa_acct_cd", length));
			String[] unstlCurrCd = (JSPUtil.getParameter(request, prefix	+ "unstl_curr_cd", length));
			String[] cInpCrAmt = (JSPUtil.getParameter(request, prefix	+ "c_inp_cr_amt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] cInpDrAmt = (JSPUtil.getParameter(request, prefix	+ "c_inp_dr_amt", length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm", length));
			String[] inpCrAmt = (JSPUtil.getParameter(request, prefix	+ "inp_cr_amt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] acctLoclNm = (JSPUtil.getParameter(request, prefix	+ "acct_locl_nm", length));
			String[] unstlDesc = (JSPUtil.getParameter(request, prefix	+ "unstl_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnsettledAccountListVO();
				if (inpDrAmt[i] != null)
					model.setInpDrAmt(inpDrAmt[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (unstlDlLineNo[i] != null)
					model.setUnstlDlLineNo(unstlDlLineNo[i]);
				if (coaCtrCd[i] != null)
					model.setCoaCtrCd(coaCtrCd[i]);
				if (coaAcctCd[i] != null)
					model.setCoaAcctCd(coaAcctCd[i]);
				if (unstlCurrCd[i] != null)
					model.setUnstlCurrCd(unstlCurrCd[i]);
				if (cInpCrAmt[i] != null)
					model.setCInpCrAmt(cInpCrAmt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (cInpDrAmt[i] != null)
					model.setCInpDrAmt(cInpDrAmt[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (inpCrAmt[i] != null)
					model.setInpCrAmt(inpCrAmt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (acctLoclNm[i] != null)
					model.setAcctLoclNm(acctLoclNm[i]);
				if (unstlDesc[i] != null)
					model.setUnstlDesc(unstlDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnsettledAccountListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnsettledAccountListVO[]
	 */
	public UnsettledAccountListVO[] getUnsettledAccountListVOs(){
		UnsettledAccountListVO[] vos = (UnsettledAccountListVO[])models.toArray(new UnsettledAccountListVO[models.size()]);
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
		this.inpDrAmt = this.inpDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unstlDlLineNo = this.unstlDlLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCtrCd = this.coaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaAcctCd = this.coaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unstlCurrCd = this.unstlCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cInpCrAmt = this.cInpCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cInpDrAmt = this.cInpDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpCrAmt = this.inpCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctLoclNm = this.acctLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unstlDesc = this.unstlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
