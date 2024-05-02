/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRDetailforCommissionHdrVO.java
*@FileTitle : CSRDetailforCommissionHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.06 이호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo;

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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CSRDetailforCommissionHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CSRDetailforCommissionHdrVO> models = new ArrayList<CSRDetailforCommissionHdrVO>();
	
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invTermDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String tjOfcCd = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String vndrLoclLangNm = null;
	/* Column Info */
	private String invDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CSRDetailforCommissionHdrVO() {}

	public CSRDetailforCommissionHdrVO(String ibflag, String pagerows, String tjOfcCd, String invDt, String vndrSeq, String vndrLoclLangNm, String attrCtnt1, String csrCurrCd, String csrAmt, String invTermDt, String attrCtnt2, String csrNo) {
		this.csrNo = csrNo;
		this.attrCtnt1 = attrCtnt1;
		this.attrCtnt2 = attrCtnt2;
		this.ibflag = ibflag;
		this.invTermDt = invTermDt;
		this.vndrSeq = vndrSeq;
		this.tjOfcCd = tjOfcCd;
		this.csrCurrCd = csrCurrCd;
		this.csrAmt = csrAmt;
		this.vndrLoclLangNm = vndrLoclLangNm;
		this.invDt = invDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_term_dt", getInvTermDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tj_ofc_cd", getTjOfcCd());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("vndr_locl_lang_nm", getVndrLoclLangNm());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_term_dt", "invTermDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tj_ofc_cd", "tjOfcCd");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("vndr_locl_lang_nm", "vndrLoclLangNm");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return this.attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
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
	 * @return invTermDt
	 */
	public String getInvTermDt() {
		return this.invTermDt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return tjOfcCd
	 */
	public String getTjOfcCd() {
		return this.tjOfcCd;
	}
	
	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrLoclLangNm
	 */
	public String getVndrLoclLangNm() {
		return this.vndrLoclLangNm;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt1
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
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
	 * @param invTermDt
	 */
	public void setInvTermDt(String invTermDt) {
		this.invTermDt = invTermDt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param tjOfcCd
	 */
	public void setTjOfcCd(String tjOfcCd) {
		this.tjOfcCd = tjOfcCd;
	}
	
	/**
	 * Column Info
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrLoclLangNm
	 */
	public void setVndrLoclLangNm(String vndrLoclLangNm) {
		this.vndrLoclLangNm = vndrLoclLangNm;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, "attr_ctnt1", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, "attr_ctnt2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInvTermDt(JSPUtil.getParameter(request, "inv_term_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setTjOfcCd(JSPUtil.getParameter(request, "tj_ofc_cd", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setVndrLoclLangNm(JSPUtil.getParameter(request, "vndr_locl_lang_nm", ""));
		setInvDt(JSPUtil.getParameter(request, "inv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CSRDetailforCommissionHdrVO[]
	 */
	public CSRDetailforCommissionHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CSRDetailforCommissionHdrVO[]
	 */
	public CSRDetailforCommissionHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CSRDetailforCommissionHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invTermDt = (JSPUtil.getParameter(request, prefix	+ "inv_term_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] tjOfcCd = (JSPUtil.getParameter(request, prefix	+ "tj_ofc_cd", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] vndrLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "vndr_locl_lang_nm", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CSRDetailforCommissionHdrVO();
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invTermDt[i] != null)
					model.setInvTermDt(invTermDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (tjOfcCd[i] != null)
					model.setTjOfcCd(tjOfcCd[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (vndrLoclLangNm[i] != null)
					model.setVndrLoclLangNm(vndrLoclLangNm[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCSRDetailforCommissionHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CSRDetailforCommissionHdrVO[]
	 */
	public CSRDetailforCommissionHdrVO[] getCSRDetailforCommissionHdrVOs(){
		CSRDetailforCommissionHdrVO[] vos = (CSRDetailforCommissionHdrVO[])models.toArray(new CSRDetailforCommissionHdrVO[models.size()]);
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
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermDt = this.invTermDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjOfcCd = this.tjOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLoclLangNm = this.vndrLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
