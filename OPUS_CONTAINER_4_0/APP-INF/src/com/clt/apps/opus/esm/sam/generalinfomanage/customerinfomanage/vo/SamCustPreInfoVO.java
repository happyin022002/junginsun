/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SamCustPreInfoVO.java
*@FileTitle : SamCustPreInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.06.13 박찬민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo;

import java.lang.reflect.Field;
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
 * @author 박찬민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamCustPreInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamCustPreInfoVO> models = new ArrayList<SamCustPreInfoVO>();
	
	/* Column Info */
	private String prfCateCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prfModCd = null;
	/* Column Info */
	private String prfFmLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custPrfSeq = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String prfToLocCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String prfVndrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamCustPreInfoVO() {}

	public SamCustPreInfoVO(String ibflag, String pagerows, String custPrfSeq, String prfCateCd, String prfModCd, String prfFmLocCd, String prfToLocCd, String vndrLglEngNm, String prfVndrSeq, String userId, String custCd, String custCntCd, String custSeq) {
		this.prfCateCd = prfCateCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.prfModCd = prfModCd;
		this.prfFmLocCd = prfFmLocCd;
		this.ibflag = ibflag;
		this.custCd = custCd;
		this.custPrfSeq = custPrfSeq;
		this.userId = userId;
		this.prfToLocCd = prfToLocCd;
		this.custCntCd = custCntCd;
		this.prfVndrSeq = prfVndrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prf_cate_cd", getPrfCateCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prf_mod_cd", getPrfModCd());
		this.hashColumns.put("prf_fm_loc_cd", getPrfFmLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_prf_seq", getCustPrfSeq());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("prf_to_loc_cd", getPrfToLocCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("prf_vndr_seq", getPrfVndrSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prf_cate_cd", "prfCateCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prf_mod_cd", "prfModCd");
		this.hashFields.put("prf_fm_loc_cd", "prfFmLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_prf_seq", "custPrfSeq");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("prf_to_loc_cd", "prfToLocCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("prf_vndr_seq", "prfVndrSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prfCateCd
	 */
	public String getPrfCateCd() {
		return this.prfCateCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return prfModCd
	 */
	public String getPrfModCd() {
		return this.prfModCd;
	}
	
	/**
	 * Column Info
	 * @return prfFmLocCd
	 */
	public String getPrfFmLocCd() {
		return this.prfFmLocCd;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return custPrfSeq
	 */
	public String getCustPrfSeq() {
		return this.custPrfSeq;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return prfToLocCd
	 */
	public String getPrfToLocCd() {
		return this.prfToLocCd;
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
	 * @return prfVndrSeq
	 */
	public String getPrfVndrSeq() {
		return this.prfVndrSeq;
	}
	

	/**
	 * Column Info
	 * @param prfCateCd
	 */
	public void setPrfCateCd(String prfCateCd) {
		this.prfCateCd = prfCateCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param prfModCd
	 */
	public void setPrfModCd(String prfModCd) {
		this.prfModCd = prfModCd;
	}
	
	/**
	 * Column Info
	 * @param prfFmLocCd
	 */
	public void setPrfFmLocCd(String prfFmLocCd) {
		this.prfFmLocCd = prfFmLocCd;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param custPrfSeq
	 */
	public void setCustPrfSeq(String custPrfSeq) {
		this.custPrfSeq = custPrfSeq;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param prfToLocCd
	 */
	public void setPrfToLocCd(String prfToLocCd) {
		this.prfToLocCd = prfToLocCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param prfVndrSeq
	 */
	public void setPrfVndrSeq(String prfVndrSeq) {
		this.prfVndrSeq = prfVndrSeq;
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
		setPrfCateCd(JSPUtil.getParameter(request, prefix + "prf_cate_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrfModCd(JSPUtil.getParameter(request, prefix + "prf_mod_cd", ""));
		setPrfFmLocCd(JSPUtil.getParameter(request, prefix + "prf_fm_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCustPrfSeq(JSPUtil.getParameter(request, prefix + "cust_prf_seq", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setPrfToLocCd(JSPUtil.getParameter(request, prefix + "prf_to_loc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPrfVndrSeq(JSPUtil.getParameter(request, prefix + "prf_vndr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamCustPreInfoVO[]
	 */
	public SamCustPreInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamCustPreInfoVO[]
	 */
	public SamCustPreInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamCustPreInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prfCateCd = (JSPUtil.getParameter(request, prefix	+ "prf_cate_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prfModCd = (JSPUtil.getParameter(request, prefix	+ "prf_mod_cd", length));
			String[] prfFmLocCd = (JSPUtil.getParameter(request, prefix	+ "prf_fm_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custPrfSeq = (JSPUtil.getParameter(request, prefix	+ "cust_prf_seq", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] prfToLocCd = (JSPUtil.getParameter(request, prefix	+ "prf_to_loc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] prfVndrSeq = (JSPUtil.getParameter(request, prefix	+ "prf_vndr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamCustPreInfoVO();
				if (prfCateCd[i] != null)
					model.setPrfCateCd(prfCateCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prfModCd[i] != null)
					model.setPrfModCd(prfModCd[i]);
				if (prfFmLocCd[i] != null)
					model.setPrfFmLocCd(prfFmLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custPrfSeq[i] != null)
					model.setCustPrfSeq(custPrfSeq[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (prfToLocCd[i] != null)
					model.setPrfToLocCd(prfToLocCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (prfVndrSeq[i] != null)
					model.setPrfVndrSeq(prfVndrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamCustPreInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamCustPreInfoVO[]
	 */
	public SamCustPreInfoVO[] getSamCustPreInfoVOs(){
		SamCustPreInfoVO[] vos = (SamCustPreInfoVO[])models.toArray(new SamCustPreInfoVO[models.size()]);
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
		this.prfCateCd = this.prfCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfModCd = this.prfModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfFmLocCd = this.prfFmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custPrfSeq = this.custPrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfToLocCd = this.prfToLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfVndrSeq = this.prfVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
