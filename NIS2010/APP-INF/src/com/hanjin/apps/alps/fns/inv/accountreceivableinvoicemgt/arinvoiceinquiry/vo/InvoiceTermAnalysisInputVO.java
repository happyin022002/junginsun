/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceTermAnalysisInputVO.java
*@FileTitle : InvoiceTermAnalysisInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.08.25 박정진 
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

public class InvoiceTermAnalysisInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceTermAnalysisInputVO> models = new ArrayList<InvoiceTermAnalysisInputVO>();
	
	/* Column Info */
	private String office = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String revTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String loginOfcCd = null;
	/* Column Info */
	private String dateOption = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceTermAnalysisInputVO() {}

	public InvoiceTermAnalysisInputVO(String ibflag, String pagerows, String office, String fromDate, String toDate, String actCustCntCd, String actCustSeq, String ioBndCd, String revTpCd, String loginOfcCd, String dateOption) {
		this.office = office;
		this.ibflag = ibflag;
		this.fromDate = fromDate;
		this.actCustSeq = actCustSeq;
		this.actCustCntCd = actCustCntCd;
		this.toDate = toDate;
		this.ioBndCd = ioBndCd;
		this.revTpCd = revTpCd;
		this.pagerows = pagerows;
		this.loginOfcCd = loginOfcCd;
		this.dateOption = dateOption;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());
		this.hashColumns.put("date_option", getDateOption());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		this.hashFields.put("date_option", "dateOption");
		return this.hashFields;
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getLoginOfcCd() {
		return loginOfcCd;
	}

	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}

	public String getDateOption() {
		return dateOption;
	}

	public void setDateOption(String dateOption) {
		this.dateOption = dateOption;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFromDate(JSPUtil.getParameter(request, "from_date", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setToDate(JSPUtil.getParameter(request, "to_date", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLoginOfcCd(JSPUtil.getParameter(request, "login_ofc_cd", ""));
		setDateOption(JSPUtil.getParameter(request, "date_option", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceTermAnalysisInputVO[]
	 */
	public InvoiceTermAnalysisInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceTermAnalysisInputVO[]
	 */
	public InvoiceTermAnalysisInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceTermAnalysisInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] loginOfcCd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_cd", length));
			String[] dateOption = (JSPUtil.getParameter(request, prefix	+ "date_option", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceTermAnalysisInputVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (loginOfcCd[i] != null)
					model.setLoginOfcCd(loginOfcCd[i]);
				if (dateOption[i] != null)
					model.setDateOption(dateOption[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceTermAnalysisInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceTermAnalysisInputVO[]
	 */
	public InvoiceTermAnalysisInputVO[] getInvoiceTermAnalysisInputVOs(){
		InvoiceTermAnalysisInputVO[] vos = (InvoiceTermAnalysisInputVO[])models.toArray(new InvoiceTermAnalysisInputVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd = this.loginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateOption = this.dateOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
