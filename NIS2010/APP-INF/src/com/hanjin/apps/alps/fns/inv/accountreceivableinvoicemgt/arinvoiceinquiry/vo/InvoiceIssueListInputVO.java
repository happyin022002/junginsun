/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueListInputVO.java
*@FileTitle : InvoiceIssueListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.03 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceIssueListInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceIssueListInputVO> models = new ArrayList<InvoiceIssueListInputVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String office = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String issToDt = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String issFmDt = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String categories = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceIssueListInputVO() {}

	public InvoiceIssueListInputVO(String ibflag, String pagerows, String office, String issFmDt, String issToDt, String actCustCntCd, String categories, String actCustSeq, String vvd, String bound, String port) {
		this.port = port;
		this.vvd = vvd;
		this.office = office;
		this.ibflag = ibflag;
		this.issToDt = issToDt;
		this.actCustSeq = actCustSeq;
		this.issFmDt = issFmDt;
		this.bound = bound;
		this.actCustCntCd = actCustCntCd;
		this.categories = categories;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("iss_to_dt", getIssToDt());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("iss_fm_dt", getIssFmDt());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("categories", getCategories());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("office", "office");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("iss_to_dt", "issToDt");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("iss_fm_dt", "issFmDt");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("categories", "categories");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
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
	 * @return issToDt
	 */
	public String getIssToDt() {
		return this.issToDt;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return issFmDt
	 */
	public String getIssFmDt() {
		return this.issFmDt;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
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
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
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
	 * @param issToDt
	 */
	public void setIssToDt(String issToDt) {
		this.issToDt = issToDt;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param issFmDt
	 */
	public void setIssFmDt(String issFmDt) {
		this.issFmDt = issFmDt;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIssToDt(JSPUtil.getParameter(request, "iss_to_dt", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setIssFmDt(JSPUtil.getParameter(request, "iss_fm_dt", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setCategories(JSPUtil.getParameter(request, "categories", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceIssueListInputVO[]
	 */
	public InvoiceIssueListInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceIssueListInputVO[]
	 */
	public InvoiceIssueListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceIssueListInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] issToDt = (JSPUtil.getParameter(request, prefix	+ "iss_to_dt".trim(), length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq".trim(), length));
			String[] issFmDt = (JSPUtil.getParameter(request, prefix	+ "iss_fm_dt".trim(), length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound".trim(), length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd".trim(), length));
			String[] categories = (JSPUtil.getParameter(request, prefix	+ "categories".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceIssueListInputVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (issToDt[i] != null)
					model.setIssToDt(issToDt[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (issFmDt[i] != null)
					model.setIssFmDt(issFmDt[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (categories[i] != null)
					model.setCategories(categories[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceIssueListInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceIssueListInputVO[]
	 */
	public InvoiceIssueListInputVO[] getInvoiceIssueListInputVOs(){
		InvoiceIssueListInputVO[] vos = (InvoiceIssueListInputVO[])models.toArray(new InvoiceIssueListInputVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issToDt = this.issToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issFmDt = this.issFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.categories = this.categories .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
