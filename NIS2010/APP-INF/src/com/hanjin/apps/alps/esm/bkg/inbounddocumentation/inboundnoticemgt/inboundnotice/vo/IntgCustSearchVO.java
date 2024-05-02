/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IntgCustSearchVO.java
*@FileTitle : IntgCustSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IntgCustSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IntgCustSearchVO> models = new ArrayList<IntgCustSearchVO>();
	
	/* Column Info */
	private String custSeqIb = null;
	/* Column Info */
	private String creLimit = null;
	/* Column Info */
	private String noUse = null;
	/* Column Info */
	private String bklst = null;
	/* Column Info */
	private String custStsCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String include = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String custCntCdExt = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String custLglEngNmIb = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loginOfcCd = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String custCntCdIb = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String ofcCdIb = null;
	/* Column Info */
	private String ctyCd = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public IntgCustSearchVO() {}

	public IntgCustSearchVO(String ibflag, String pagerows, String custSeqIb, String custStsCd, String custSeq, String custLglEngNm, String stsCd, String custLglEngNmIb, String ofcCd, String loginOfcCd, String custCntCdIb, String ctyCd, String custCntCd, String custCntCdExt, String ofcCdIb, String steCd, String noUse, String bklst, String include, String ctyNm, String zipCd, String creLimit) {
		this.custSeqIb = custSeqIb;
		this.creLimit = creLimit;
		this.noUse = noUse;
		this.bklst = bklst;
		this.custStsCd = custStsCd;
		this.custSeq = custSeq;
		this.include = include;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.custCntCdExt = custCntCdExt;
		this.stsCd = stsCd;
		this.custLglEngNmIb = custLglEngNmIb;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.loginOfcCd = loginOfcCd;
		this.zipCd = zipCd;
		this.custCntCdIb = custCntCdIb;
		this.ctyNm = ctyNm;
		this.ofcCdIb = ofcCdIb;
		this.ctyCd = ctyCd;
		this.steCd = steCd;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_seq_ib", getCustSeqIb());
		this.hashColumns.put("cre_limit", getCreLimit());
		this.hashColumns.put("no_use", getNoUse());
		this.hashColumns.put("bklst", getBklst());
		this.hashColumns.put("cust_sts_cd", getCustStsCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("include", getInclude());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cust_cnt_cd_ext", getCustCntCdExt());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("cust_lgl_eng_nm_ib", getCustLglEngNmIb());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cust_cnt_cd_ib", getCustCntCdIb());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("ofc_cd_ib", getOfcCdIb());
		this.hashColumns.put("cty_cd", getCtyCd());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_seq_ib", "custSeqIb");
		this.hashFields.put("cre_limit", "creLimit");
		this.hashFields.put("no_use", "noUse");
		this.hashFields.put("bklst", "bklst");
		this.hashFields.put("cust_sts_cd", "custStsCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("include", "include");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cust_cnt_cd_ext", "custCntCdExt");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("cust_lgl_eng_nm_ib", "custLglEngNmIb");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("cust_cnt_cd_ib", "custCntCdIb");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("ofc_cd_ib", "ofcCdIb");
		this.hashFields.put("cty_cd", "ctyCd");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custSeqIb
	 */
	public String getCustSeqIb() {
		return this.custSeqIb;
	}
	
	/**
	 * Column Info
	 * @return creLimit
	 */
	public String getCreLimit() {
		return this.creLimit;
	}
	
	/**
	 * Column Info
	 * @return noUse
	 */
	public String getNoUse() {
		return this.noUse;
	}
	
	/**
	 * Column Info
	 * @return bklst
	 */
	public String getBklst() {
		return this.bklst;
	}
	
	/**
	 * Column Info
	 * @return custStsCd
	 */
	public String getCustStsCd() {
		return this.custStsCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return include
	 */
	public String getInclude() {
		return this.include;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return custCntCdExt
	 */
	public String getCustCntCdExt() {
		return this.custCntCdExt;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNmIb
	 */
	public String getCustLglEngNmIb() {
		return this.custLglEngNmIb;
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
	 * @return loginOfcCd
	 */
	public String getLoginOfcCd() {
		return this.loginOfcCd;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCdIb
	 */
	public String getCustCntCdIb() {
		return this.custCntCdIb;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCdIb
	 */
	public String getOfcCdIb() {
		return this.ofcCdIb;
	}
	
	/**
	 * Column Info
	 * @return ctyCd
	 */
	public String getCtyCd() {
		return this.ctyCd;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param custSeqIb
	 */
	public void setCustSeqIb(String custSeqIb) {
		this.custSeqIb = custSeqIb;
	}
	
	/**
	 * Column Info
	 * @param creLimit
	 */
	public void setCreLimit(String creLimit) {
		this.creLimit = creLimit;
	}
	
	/**
	 * Column Info
	 * @param noUse
	 */
	public void setNoUse(String noUse) {
		this.noUse = noUse;
	}
	
	/**
	 * Column Info
	 * @param bklst
	 */
	public void setBklst(String bklst) {
		this.bklst = bklst;
	}
	
	/**
	 * Column Info
	 * @param custStsCd
	 */
	public void setCustStsCd(String custStsCd) {
		this.custStsCd = custStsCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param include
	 */
	public void setInclude(String include) {
		this.include = include;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param custCntCdExt
	 */
	public void setCustCntCdExt(String custCntCdExt) {
		this.custCntCdExt = custCntCdExt;
	}
	
	/**
	 * Column Info
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNmIb
	 */
	public void setCustLglEngNmIb(String custLglEngNmIb) {
		this.custLglEngNmIb = custLglEngNmIb;
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
	 * @param loginOfcCd
	 */
	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCdIb
	 */
	public void setCustCntCdIb(String custCntCdIb) {
		this.custCntCdIb = custCntCdIb;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCdIb
	 */
	public void setOfcCdIb(String ofcCdIb) {
		this.ofcCdIb = ofcCdIb;
	}
	
	/**
	 * Column Info
	 * @param ctyCd
	 */
	public void setCtyCd(String ctyCd) {
		this.ctyCd = ctyCd;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setCustSeqIb(JSPUtil.getParameter(request, prefix + "cust_seq_ib", ""));
		setCreLimit(JSPUtil.getParameter(request, prefix + "cre_limit", ""));
		setNoUse(JSPUtil.getParameter(request, prefix + "no_use", ""));
		setBklst(JSPUtil.getParameter(request, prefix + "bklst", ""));
		setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setInclude(JSPUtil.getParameter(request, prefix + "include", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCustCntCdExt(JSPUtil.getParameter(request, prefix + "cust_cnt_cd_ext", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setCustLglEngNmIb(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm_ib", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLoginOfcCd(JSPUtil.getParameter(request, prefix + "login_ofc_cd", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setCustCntCdIb(JSPUtil.getParameter(request, prefix + "cust_cnt_cd_ib", ""));
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setOfcCdIb(JSPUtil.getParameter(request, prefix + "ofc_cd_ib", ""));
		setCtyCd(JSPUtil.getParameter(request, prefix + "cty_cd", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IntgCustSearchVO[]
	 */
	public IntgCustSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IntgCustSearchVO[]
	 */
	public IntgCustSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IntgCustSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custSeqIb = (JSPUtil.getParameter(request, prefix	+ "cust_seq_ib", length));
			String[] creLimit = (JSPUtil.getParameter(request, prefix	+ "cre_limit", length));
			String[] noUse = (JSPUtil.getParameter(request, prefix	+ "no_use", length));
			String[] bklst = (JSPUtil.getParameter(request, prefix	+ "bklst", length));
			String[] custStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_sts_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] include = (JSPUtil.getParameter(request, prefix	+ "include", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] custCntCdExt = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd_ext", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] custLglEngNmIb = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm_ib", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loginOfcCd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_cd", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] custCntCdIb = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd_ib", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] ofcCdIb = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_ib", length));
			String[] ctyCd = (JSPUtil.getParameter(request, prefix	+ "cty_cd", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IntgCustSearchVO();
				if (custSeqIb[i] != null)
					model.setCustSeqIb(custSeqIb[i]);
				if (creLimit[i] != null)
					model.setCreLimit(creLimit[i]);
				if (noUse[i] != null)
					model.setNoUse(noUse[i]);
				if (bklst[i] != null)
					model.setBklst(bklst[i]);
				if (custStsCd[i] != null)
					model.setCustStsCd(custStsCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (include[i] != null)
					model.setInclude(include[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (custCntCdExt[i] != null)
					model.setCustCntCdExt(custCntCdExt[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (custLglEngNmIb[i] != null)
					model.setCustLglEngNmIb(custLglEngNmIb[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loginOfcCd[i] != null)
					model.setLoginOfcCd(loginOfcCd[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (custCntCdIb[i] != null)
					model.setCustCntCdIb(custCntCdIb[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (ofcCdIb[i] != null)
					model.setOfcCdIb(ofcCdIb[i]);
				if (ctyCd[i] != null)
					model.setCtyCd(ctyCd[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIntgCustSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IntgCustSearchVO[]
	 */
	public IntgCustSearchVO[] getIntgCustSearchVOs(){
		IntgCustSearchVO[] vos = (IntgCustSearchVO[])models.toArray(new IntgCustSearchVO[models.size()]);
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
		this.custSeqIb = this.custSeqIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLimit = this.creLimit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noUse = this.noUse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bklst = this.bklst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStsCd = this.custStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.include = this.include .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCdExt = this.custCntCdExt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNmIb = this.custLglEngNmIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd = this.loginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCdIb = this.custCntCdIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdIb = this.ofcCdIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyCd = this.ctyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
