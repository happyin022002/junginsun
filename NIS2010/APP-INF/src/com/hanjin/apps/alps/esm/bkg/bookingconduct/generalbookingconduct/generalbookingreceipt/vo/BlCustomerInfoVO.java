/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlCustomerInfoVO.java
*@FileTitle : BlCustomerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2010.01.13 김병규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlCustomerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCustomerInfoVO> models = new ArrayList<BlCustomerInfoVO>();
	
	/* Column Info */
	private String sCustCntCdOld = null;
	/* Column Info */
	private String sCustSeq = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String cCustExistFlg = null;
	/* Column Info */
	private String cCustCntCdOld = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String cCustSeq = null;
	/* Column Info */
	private String cCustSubstFlg = null;
	/* Column Info */
	private String fCustCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fCustSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fCustSeqOld = null;
	/* Column Info */
	private String fCustExistFlg = null;
	/* Column Info */
	private String fCustNm = null;
	/* Column Info */
	private String sCustExistFlg = null;
	/* Column Info */
	private String fCustCntCdOld = null;
	/* Column Info */
	private String fCustSubstFlg = null;
	/* Column Info */
	private String sCustSubstFlg = null;
	/* Column Info */
	private String cCustCntCd = null;
	/* Column Info */
	private String cCustSeqOld = null;
	/* Column Info */
	private String sCustSeqOld = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlCustomerInfoVO() {}

	public BlCustomerInfoVO(String ibflag, String pagerows, String sCustCntCd, String sCustCntCdOld, String sCustSeq, String sCustSeqOld, String sCustNm, String sCustExistFlg, String cCustCntCd, String cCustCntCdOld, String cCustSeq, String cCustSeqOld, String cCustNm, String cCustExistFlg, String fCustCntCd, String fCustCntCdOld, String fCustSeq, String fCustSeqOld, String fCustNm, String fCustExistFlg, String sCustSubstFlg, String cCustSubstFlg, String fCustSubstFlg) {
		this.sCustCntCdOld = sCustCntCdOld;
		this.sCustSeq = sCustSeq;
		this.sCustNm = sCustNm;
		this.cCustExistFlg = cCustExistFlg;
		this.cCustCntCdOld = cCustCntCdOld;
		this.cCustNm = cCustNm;
		this.sCustCntCd = sCustCntCd;
		this.cCustSeq = cCustSeq;
		this.cCustSubstFlg = cCustSubstFlg;
		this.fCustCntCd = fCustCntCd;
		this.pagerows = pagerows;
		this.fCustSeq = fCustSeq;
		this.ibflag = ibflag;
		this.fCustSeqOld = fCustSeqOld;
		this.fCustExistFlg = fCustExistFlg;
		this.fCustNm = fCustNm;
		this.sCustExistFlg = sCustExistFlg;
		this.fCustCntCdOld = fCustCntCdOld;
		this.fCustSubstFlg = fCustSubstFlg;
		this.sCustSubstFlg = sCustSubstFlg;
		this.cCustCntCd = cCustCntCd;
		this.cCustSeqOld = cCustSeqOld;
		this.sCustSeqOld = sCustSeqOld;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_cust_cnt_cd_old", getSCustCntCdOld());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("c_cust_exist_flg", getCCustExistFlg());
		this.hashColumns.put("c_cust_cnt_cd_old", getCCustCntCdOld());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("c_cust_seq", getCCustSeq());
		this.hashColumns.put("c_cust_subst_flg", getCCustSubstFlg());
		this.hashColumns.put("f_cust_cnt_cd", getFCustCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_cust_seq", getFCustSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_cust_seq_old", getFCustSeqOld());
		this.hashColumns.put("f_cust_exist_flg", getFCustExistFlg());
		this.hashColumns.put("f_cust_nm", getFCustNm());
		this.hashColumns.put("s_cust_exist_flg", getSCustExistFlg());
		this.hashColumns.put("f_cust_cnt_cd_old", getFCustCntCdOld());
		this.hashColumns.put("f_cust_subst_flg", getFCustSubstFlg());
		this.hashColumns.put("s_cust_subst_flg", getSCustSubstFlg());
		this.hashColumns.put("c_cust_cnt_cd", getCCustCntCd());
		this.hashColumns.put("c_cust_seq_old", getCCustSeqOld());
		this.hashColumns.put("s_cust_seq_old", getSCustSeqOld());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_cust_cnt_cd_old", "sCustCntCdOld");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("c_cust_exist_flg", "cCustExistFlg");
		this.hashFields.put("c_cust_cnt_cd_old", "cCustCntCdOld");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("c_cust_seq", "cCustSeq");
		this.hashFields.put("c_cust_subst_flg", "cCustSubstFlg");
		this.hashFields.put("f_cust_cnt_cd", "fCustCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_cust_seq", "fCustSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_cust_seq_old", "fCustSeqOld");
		this.hashFields.put("f_cust_exist_flg", "fCustExistFlg");
		this.hashFields.put("f_cust_nm", "fCustNm");
		this.hashFields.put("s_cust_exist_flg", "sCustExistFlg");
		this.hashFields.put("f_cust_cnt_cd_old", "fCustCntCdOld");
		this.hashFields.put("f_cust_subst_flg", "fCustSubstFlg");
		this.hashFields.put("s_cust_subst_flg", "sCustSubstFlg");
		this.hashFields.put("c_cust_cnt_cd", "cCustCntCd");
		this.hashFields.put("c_cust_seq_old", "cCustSeqOld");
		this.hashFields.put("s_cust_seq_old", "sCustSeqOld");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sCustCntCdOld
	 */
	public String getSCustCntCdOld() {
		return this.sCustCntCdOld;
	}
	
	/**
	 * Column Info
	 * @return sCustSeq
	 */
	public String getSCustSeq() {
		return this.sCustSeq;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return cCustExistFlg
	 */
	public String getCCustExistFlg() {
		return this.cCustExistFlg;
	}
	
	/**
	 * Column Info
	 * @return cCustCntCdOld
	 */
	public String getCCustCntCdOld() {
		return this.cCustCntCdOld;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return sCustCntCd
	 */
	public String getSCustCntCd() {
		return this.sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cCustSeq
	 */
	public String getCCustSeq() {
		return this.cCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cCustSubstFlg
	 */
	public String getCCustSubstFlg() {
		return this.cCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @return fCustCntCd
	 */
	public String getFCustCntCd() {
		return this.fCustCntCd;
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
	 * @return fCustSeq
	 */
	public String getFCustSeq() {
		return this.fCustSeq;
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
	 * @return fCustSeqOld
	 */
	public String getFCustSeqOld() {
		return this.fCustSeqOld;
	}
	
	/**
	 * Column Info
	 * @return fCustExistFlg
	 */
	public String getFCustExistFlg() {
		return this.fCustExistFlg;
	}
	
	/**
	 * Column Info
	 * @return fCustNm
	 */
	public String getFCustNm() {
		return this.fCustNm;
	}
	
	/**
	 * Column Info
	 * @return sCustExistFlg
	 */
	public String getSCustExistFlg() {
		return this.sCustExistFlg;
	}
	
	/**
	 * Column Info
	 * @return fCustCntCdOld
	 */
	public String getFCustCntCdOld() {
		return this.fCustCntCdOld;
	}
	
	/**
	 * Column Info
	 * @return fCustSubstFlg
	 */
	public String getFCustSubstFlg() {
		return this.fCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @return sCustSubstFlg
	 */
	public String getSCustSubstFlg() {
		return this.sCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @return cCustCntCd
	 */
	public String getCCustCntCd() {
		return this.cCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cCustSeqOld
	 */
	public String getCCustSeqOld() {
		return this.cCustSeqOld;
	}
	
	/**
	 * Column Info
	 * @return sCustSeqOld
	 */
	public String getSCustSeqOld() {
		return this.sCustSeqOld;
	}
	

	/**
	 * Column Info
	 * @param sCustCntCdOld
	 */
	public void setSCustCntCdOld(String sCustCntCdOld) {
		this.sCustCntCdOld = sCustCntCdOld;
	}
	
	/**
	 * Column Info
	 * @param sCustSeq
	 */
	public void setSCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param cCustExistFlg
	 */
	public void setCCustExistFlg(String cCustExistFlg) {
		this.cCustExistFlg = cCustExistFlg;
	}
	
	/**
	 * Column Info
	 * @param cCustCntCdOld
	 */
	public void setCCustCntCdOld(String cCustCntCdOld) {
		this.cCustCntCdOld = cCustCntCdOld;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param sCustCntCd
	 */
	public void setSCustCntCd(String sCustCntCd) {
		this.sCustCntCd = sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cCustSeq
	 */
	public void setCCustSeq(String cCustSeq) {
		this.cCustSeq = cCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cCustSubstFlg
	 */
	public void setCCustSubstFlg(String cCustSubstFlg) {
		this.cCustSubstFlg = cCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @param fCustCntCd
	 */
	public void setFCustCntCd(String fCustCntCd) {
		this.fCustCntCd = fCustCntCd;
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
	 * @param fCustSeq
	 */
	public void setFCustSeq(String fCustSeq) {
		this.fCustSeq = fCustSeq;
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
	 * @param fCustSeqOld
	 */
	public void setFCustSeqOld(String fCustSeqOld) {
		this.fCustSeqOld = fCustSeqOld;
	}
	
	/**
	 * Column Info
	 * @param fCustExistFlg
	 */
	public void setFCustExistFlg(String fCustExistFlg) {
		this.fCustExistFlg = fCustExistFlg;
	}
	
	/**
	 * Column Info
	 * @param fCustNm
	 */
	public void setFCustNm(String fCustNm) {
		this.fCustNm = fCustNm;
	}
	
	/**
	 * Column Info
	 * @param sCustExistFlg
	 */
	public void setSCustExistFlg(String sCustExistFlg) {
		this.sCustExistFlg = sCustExistFlg;
	}
	
	/**
	 * Column Info
	 * @param fCustCntCdOld
	 */
	public void setFCustCntCdOld(String fCustCntCdOld) {
		this.fCustCntCdOld = fCustCntCdOld;
	}
	
	/**
	 * Column Info
	 * @param fCustSubstFlg
	 */
	public void setFCustSubstFlg(String fCustSubstFlg) {
		this.fCustSubstFlg = fCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @param sCustSubstFlg
	 */
	public void setSCustSubstFlg(String sCustSubstFlg) {
		this.sCustSubstFlg = sCustSubstFlg;
	}
	
	/**
	 * Column Info
	 * @param cCustCntCd
	 */
	public void setCCustCntCd(String cCustCntCd) {
		this.cCustCntCd = cCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cCustSeqOld
	 */
	public void setCCustSeqOld(String cCustSeqOld) {
		this.cCustSeqOld = cCustSeqOld;
	}
	
	/**
	 * Column Info
	 * @param sCustSeqOld
	 */
	public void setSCustSeqOld(String sCustSeqOld) {
		this.sCustSeqOld = sCustSeqOld;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSCustCntCdOld(JSPUtil.getParameter(request, "s_cust_cnt_cd_old", ""));
		setSCustSeq(JSPUtil.getParameter(request, "s_cust_seq", ""));
		setSCustNm(JSPUtil.getParameter(request, "s_cust_nm", ""));
		setCCustExistFlg(JSPUtil.getParameter(request, "c_cust_exist_flg", ""));
		setCCustCntCdOld(JSPUtil.getParameter(request, "c_cust_cnt_cd_old", ""));
		setCCustNm(JSPUtil.getParameter(request, "c_cust_nm", ""));
		setSCustCntCd(JSPUtil.getParameter(request, "s_cust_cnt_cd", ""));
		setCCustSeq(JSPUtil.getParameter(request, "c_cust_seq", ""));
		setCCustSubstFlg(JSPUtil.getParameter(request, "c_cust_subst_flg", ""));
		setFCustCntCd(JSPUtil.getParameter(request, "f_cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFCustSeq(JSPUtil.getParameter(request, "f_cust_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFCustSeqOld(JSPUtil.getParameter(request, "f_cust_seq_old", ""));
		setFCustExistFlg(JSPUtil.getParameter(request, "f_cust_exist_flg", ""));
		setFCustNm(JSPUtil.getParameter(request, "f_cust_nm", ""));
		setSCustExistFlg(JSPUtil.getParameter(request, "s_cust_exist_flg", ""));
		setFCustCntCdOld(JSPUtil.getParameter(request, "f_cust_cnt_cd_old", ""));
		setFCustSubstFlg(JSPUtil.getParameter(request, "f_cust_subst_flg", ""));
		setSCustSubstFlg(JSPUtil.getParameter(request, "s_cust_subst_flg", ""));
		setCCustCntCd(JSPUtil.getParameter(request, "c_cust_cnt_cd", ""));
		setCCustSeqOld(JSPUtil.getParameter(request, "c_cust_seq_old", ""));
		setSCustSeqOld(JSPUtil.getParameter(request, "s_cust_seq_old", ""));
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setSCustCntCdOld(JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd_old", ""));
		setSCustSeq(JSPUtil.getParameter(request, prefix	+ "s_cust_seq", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix	+ "s_cust_nm", ""));
		setCCustExistFlg(JSPUtil.getParameter(request, prefix	+ "c_cust_exist_flg", ""));
		setCCustCntCdOld(JSPUtil.getParameter(request, prefix	+ "c_cust_cnt_cd_old", ""));
		setCCustNm(JSPUtil.getParameter(request, prefix	+ "c_cust_nm", ""));
		setSCustCntCd(JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", ""));
		setCCustSeq(JSPUtil.getParameter(request, prefix	+ "c_cust_seq", ""));
		setCCustSubstFlg(JSPUtil.getParameter(request, prefix	+ "c_cust_subst_flg", ""));
		setFCustCntCd(JSPUtil.getParameter(request, prefix	+ "f_cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix	+ "pagerows", ""));
		setFCustSeq(JSPUtil.getParameter(request, prefix	+ "f_cust_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix	+ "ibflag", ""));
		setFCustSeqOld(JSPUtil.getParameter(request, prefix	+ "f_cust_seq_old", ""));
		setFCustExistFlg(JSPUtil.getParameter(request, prefix	+ "f_cust_exist_flg", ""));
		setFCustNm(JSPUtil.getParameter(request, prefix	+ "f_cust_nm", ""));
		setSCustExistFlg(JSPUtil.getParameter(request, prefix	+ "s_cust_exist_flg", ""));
		setFCustCntCdOld(JSPUtil.getParameter(request, prefix	+  "f_cust_cnt_cd_old", ""));
		setFCustSubstFlg(JSPUtil.getParameter(request, prefix	+ "f_cust_subst_flg", ""));
		setSCustSubstFlg(JSPUtil.getParameter(request, prefix	+ "s_cust_subst_flg", ""));
		setCCustCntCd(JSPUtil.getParameter(request, prefix	+ "c_cust_cnt_cd", ""));
		setCCustSeqOld(JSPUtil.getParameter(request, prefix	+ "c_cust_seq_old", ""));
		setSCustSeqOld(JSPUtil.getParameter(request, prefix	+ "s_cust_seq_old", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCustomerInfoVO[]
	 */
	public BlCustomerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCustomerInfoVO[]
	 */
	public BlCustomerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCustomerInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sCustCntCdOld = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd_old", length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] cCustExistFlg = (JSPUtil.getParameter(request, prefix	+ "c_cust_exist_flg", length));
			String[] cCustCntCdOld = (JSPUtil.getParameter(request, prefix	+ "c_cust_cnt_cd_old", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] cCustSeq = (JSPUtil.getParameter(request, prefix	+ "c_cust_seq", length));
			String[] cCustSubstFlg = (JSPUtil.getParameter(request, prefix	+ "c_cust_subst_flg", length));
			String[] fCustCntCd = (JSPUtil.getParameter(request, prefix	+ "f_cust_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fCustSeq = (JSPUtil.getParameter(request, prefix	+ "f_cust_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fCustSeqOld = (JSPUtil.getParameter(request, prefix	+ "f_cust_seq_old", length));
			String[] fCustExistFlg = (JSPUtil.getParameter(request, prefix	+ "f_cust_exist_flg", length));
			String[] fCustNm = (JSPUtil.getParameter(request, prefix	+ "f_cust_nm", length));
			String[] sCustExistFlg = (JSPUtil.getParameter(request, prefix	+ "s_cust_exist_flg", length));
			String[] fCustCntCdOld = (JSPUtil.getParameter(request, prefix	+ "f_cust_cnt_cd_old", length));
			String[] fCustSubstFlg = (JSPUtil.getParameter(request, prefix	+ "f_cust_subst_flg", length));
			String[] sCustSubstFlg = (JSPUtil.getParameter(request, prefix	+ "s_cust_subst_flg", length));
			String[] cCustCntCd = (JSPUtil.getParameter(request, prefix	+ "c_cust_cnt_cd", length));
			String[] cCustSeqOld = (JSPUtil.getParameter(request, prefix	+ "c_cust_seq_old", length));
			String[] sCustSeqOld = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq_old", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlCustomerInfoVO();
				if (sCustCntCdOld[i] != null)
					model.setSCustCntCdOld(sCustCntCdOld[i]);
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (cCustExistFlg[i] != null)
					model.setCCustExistFlg(cCustExistFlg[i]);
				if (cCustCntCdOld[i] != null)
					model.setCCustCntCdOld(cCustCntCdOld[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (cCustSeq[i] != null)
					model.setCCustSeq(cCustSeq[i]);
				if (cCustSubstFlg[i] != null)
					model.setCCustSubstFlg(cCustSubstFlg[i]);
				if (fCustCntCd[i] != null)
					model.setFCustCntCd(fCustCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fCustSeq[i] != null)
					model.setFCustSeq(fCustSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fCustSeqOld[i] != null)
					model.setFCustSeqOld(fCustSeqOld[i]);
				if (fCustExistFlg[i] != null)
					model.setFCustExistFlg(fCustExistFlg[i]);
				if (fCustNm[i] != null)
					model.setFCustNm(fCustNm[i]);
				if (sCustExistFlg[i] != null)
					model.setSCustExistFlg(sCustExistFlg[i]);
				if (fCustCntCdOld[i] != null)
					model.setFCustCntCdOld(fCustCntCdOld[i]);
				if (fCustSubstFlg[i] != null)
					model.setFCustSubstFlg(fCustSubstFlg[i]);
				if (sCustSubstFlg[i] != null)
					model.setSCustSubstFlg(sCustSubstFlg[i]);
				if (cCustCntCd[i] != null)
					model.setCCustCntCd(cCustCntCd[i]);
				if (cCustSeqOld[i] != null)
					model.setCCustSeqOld(cCustSeqOld[i]);
				if (sCustSeqOld[i] != null)
					model.setSCustSeqOld(sCustSeqOld[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCustomerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCustomerInfoVO[]
	 */
	public BlCustomerInfoVO[] getBlCustomerInfoVOs(){
		BlCustomerInfoVO[] vos = (BlCustomerInfoVO[])models.toArray(new BlCustomerInfoVO[models.size()]);
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
		this.sCustCntCdOld = this.sCustCntCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustExistFlg = this.cCustExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustCntCdOld = this.cCustCntCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustSeq = this.cCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustSubstFlg = this.cCustSubstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustCntCd = this.fCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustSeq = this.fCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustSeqOld = this.fCustSeqOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustExistFlg = this.fCustExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustNm = this.fCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustExistFlg = this.sCustExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustCntCdOld = this.fCustCntCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustSubstFlg = this.fCustSubstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSubstFlg = this.sCustSubstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustCntCd = this.cCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustSeqOld = this.cCustSeqOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeqOld = this.sCustSeqOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
