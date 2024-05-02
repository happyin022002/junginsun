/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SecurityInputVO.java
*@FileTitle : SecurityInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.25 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SecurityInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SecurityInputVO> models = new ArrayList<SecurityInputVO>();
	
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toObTerm = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String fmIbTerm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custScrDivCd = null;
	/* Column Info */
	private String fmObTerm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ofc = null;
	/* Column Info */
	private String toIbTerm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SecurityInputVO() {}

	public SecurityInputVO(String ibflag, String pagerows, String custScrDivCd, String fmObTerm, String toObTerm, String fmIbTerm, String toIbTerm, String ofc, String custCntCd, String custSeq, String toDt, String fmDt) {
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.toObTerm = toObTerm;
		this.fmDt = fmDt;
		this.fmIbTerm = fmIbTerm;
		this.custSeq = custSeq;
		this.custScrDivCd = custScrDivCd;
		this.fmObTerm = fmObTerm;
		this.custCntCd = custCntCd;
		this.ofc = ofc;
		this.toIbTerm = toIbTerm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_ob_term", getToObTerm());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("fm_ib_term", getFmIbTerm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_scr_div_cd", getCustScrDivCd());
		this.hashColumns.put("fm_ob_term", getFmObTerm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ofc", getOfc());
		this.hashColumns.put("to_ib_term", getToIbTerm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_ob_term", "toObTerm");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("fm_ib_term", "fmIbTerm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_scr_div_cd", "custScrDivCd");
		this.hashFields.put("fm_ob_term", "fmObTerm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ofc", "ofc");
		this.hashFields.put("to_ib_term", "toIbTerm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return toObTerm
	 */
	public String getToObTerm() {
		return this.toObTerm;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return fmIbTerm
	 */
	public String getFmIbTerm() {
		return this.fmIbTerm;
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
	 * @return custScrDivCd
	 */
	public String getCustScrDivCd() {
		return this.custScrDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmObTerm
	 */
	public String getFmObTerm() {
		return this.fmObTerm;
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
	 * @return ofc
	 */
	public String getOfc() {
		return this.ofc;
	}
	
	/**
	 * Column Info
	 * @return toIbTerm
	 */
	public String getToIbTerm() {
		return this.toIbTerm;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param toObTerm
	 */
	public void setToObTerm(String toObTerm) {
		this.toObTerm = toObTerm;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param fmIbTerm
	 */
	public void setFmIbTerm(String fmIbTerm) {
		this.fmIbTerm = fmIbTerm;
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
	 * @param custScrDivCd
	 */
	public void setCustScrDivCd(String custScrDivCd) {
		this.custScrDivCd = custScrDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmObTerm
	 */
	public void setFmObTerm(String fmObTerm) {
		this.fmObTerm = fmObTerm;
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
	 * @param ofc
	 */
	public void setOfc(String ofc) {
		this.ofc = ofc;
	}
	
	/**
	 * Column Info
	 * @param toIbTerm
	 */
	public void setToIbTerm(String toIbTerm) {
		this.toIbTerm = toIbTerm;
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
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToObTerm(JSPUtil.getParameter(request, "to_ob_term", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setFmIbTerm(JSPUtil.getParameter(request, "fm_ib_term", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustScrDivCd(JSPUtil.getParameter(request, "cust_scr_div_cd", ""));
		setFmObTerm(JSPUtil.getParameter(request, "fm_ob_term", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setOfc(JSPUtil.getParameter(request, "ofc", ""));
		setToIbTerm(JSPUtil.getParameter(request, "to_ib_term", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SecurityInputVO[]
	 */
	public SecurityInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SecurityInputVO[]
	 */
	public SecurityInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SecurityInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toObTerm = (JSPUtil.getParameter(request, prefix	+ "to_ob_term", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] fmIbTerm = (JSPUtil.getParameter(request, prefix	+ "fm_ib_term", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custScrDivCd = (JSPUtil.getParameter(request, prefix	+ "cust_scr_div_cd", length));
			String[] fmObTerm = (JSPUtil.getParameter(request, prefix	+ "fm_ob_term", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] ofc = (JSPUtil.getParameter(request, prefix	+ "ofc", length));
			String[] toIbTerm = (JSPUtil.getParameter(request, prefix	+ "to_ib_term", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SecurityInputVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toObTerm[i] != null)
					model.setToObTerm(toObTerm[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (fmIbTerm[i] != null)
					model.setFmIbTerm(fmIbTerm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custScrDivCd[i] != null)
					model.setCustScrDivCd(custScrDivCd[i]);
				if (fmObTerm[i] != null)
					model.setFmObTerm(fmObTerm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ofc[i] != null)
					model.setOfc(ofc[i]);
				if (toIbTerm[i] != null)
					model.setToIbTerm(toIbTerm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSecurityInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SecurityInputVO[]
	 */
	public SecurityInputVO[] getSecurityInputVOs(){
		SecurityInputVO[] vos = (SecurityInputVO[])models.toArray(new SecurityInputVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toObTerm = this.toObTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIbTerm = this.fmIbTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrDivCd = this.custScrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmObTerm = this.fmObTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofc = this.ofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toIbTerm = this.toIbTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
