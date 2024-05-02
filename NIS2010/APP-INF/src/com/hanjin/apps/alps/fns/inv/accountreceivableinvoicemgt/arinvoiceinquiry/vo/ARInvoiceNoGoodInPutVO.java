/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NoGoodNoIssueVO.java
*@FileTitle : NoGoodNoIssueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.27 박정진 
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

public class ARInvoiceNoGoodInPutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceNoGoodInPutVO> models = new ArrayList<ARInvoiceNoGoodInPutVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String selectOption = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dateOption = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String fromDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceNoGoodInPutVO() {}

	public ARInvoiceNoGoodInPutVO(String ibflag, String pagerows, String office, String userOfcCd, String fromDate, String dateOption, String selectOption, String revTpCd, String ioBndCd, String port, String toDate) {
		this.port = port;
		this.userOfcCd = userOfcCd;
		this.office = office;
		this.selectOption = selectOption;
		this.ibflag = ibflag;
		this.dateOption = dateOption;
		this.ioBndCd = ioBndCd;
		this.revTpCd = revTpCd;
		this.fromDate = fromDate;
		this.pagerows = pagerows;
		this.toDate = toDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("select_option", getSelectOption());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("date_option", getDateOption());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_date", getToDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("office", "office");
		this.hashFields.put("select_option", "selectOption");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("date_option", "dateOption");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_date", "toDate");
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
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return selectOption
	 */
	public String getSelectOption() {
		return this.selectOption;
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
	 * @return dateOption
	 */
	public String getDateOption() {
		return this.dateOption;
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
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param selectOption
	 */
	public void setSelectOption(String selectOption) {
		this.selectOption = selectOption;
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
	 * @param dateOption
	 */
	public void setDateOption(String dateOption) {
		this.dateOption = dateOption;
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
	
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setSelectOption(JSPUtil.getParameter(request, "select_option", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDateOption(JSPUtil.getParameter(request, "date_option", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setFromDate(JSPUtil.getParameter(request, "from_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDate(JSPUtil.getParameter(request, "to_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NoGoodNoIssueVO[]
	 */
	public ARInvoiceNoGoodInPutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NoGoodNoIssueVO[]
	 */
	public ARInvoiceNoGoodInPutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceNoGoodInPutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port".trim(), length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd".trim(), length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office".trim(), length));
			String[] selectOption = (JSPUtil.getParameter(request, prefix	+ "select_option".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] dateOption = (JSPUtil.getParameter(request, prefix	+ "date_option".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd".trim(), length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceNoGoodInPutVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (selectOption[i] != null)
					model.setSelectOption(selectOption[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dateOption[i] != null)
					model.setDateOption(dateOption[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNoGoodNoIssueVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NoGoodNoIssueVO[]
	 */
	public ARInvoiceNoGoodInPutVO[] getNoGoodNoIssueVOs(){
		ARInvoiceNoGoodInPutVO[] vos = (ARInvoiceNoGoodInPutVO[])models.toArray(new ARInvoiceNoGoodInPutVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectOption = this.selectOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateOption = this.dateOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
