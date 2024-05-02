/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NotissuedInputVO.java
*@FileTitle : NotissuedInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.23 박정진 
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

public class NotissuedInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NotissuedInputVO> models = new ArrayList<NotissuedInputVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fromOverDue = null;
	/* Column Info */
	private String asOfDate = null;
	/* Column Info */
	private String amountOption = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String toOverDue = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String userOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NotissuedInputVO() {}

	public NotissuedInputVO(String ibflag, String pagerows, String asOfDate, String actCustCntCd, String actCustSeq, String arOfcCd, String amountOption, String fromOverDue, String toOverDue, String userOfcCd) {
		this.ibflag = ibflag;
		this.fromOverDue = fromOverDue;
		this.asOfDate = asOfDate;
		this.amountOption = amountOption;
		this.actCustSeq = actCustSeq;
		this.toOverDue = toOverDue;
		this.actCustCntCd = actCustCntCd;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from_over_due", getFromOverDue());
		this.hashColumns.put("as_of_date", getAsOfDate());
		this.hashColumns.put("amount_option", getAmountOption());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("to_over_due", getToOverDue());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from_over_due", "fromOverDue");
		this.hashFields.put("as_of_date", "asOfDate");
		this.hashFields.put("amount_option", "amountOption");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("to_over_due", "toOverDue");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		return this.hashFields;
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
	 * @return fromOverDue
	 */
	public String getFromOverDue() {
		return this.fromOverDue;
	}
	
	/**
	 * Column Info
	 * @return asOfDate
	 */
	public String getAsOfDate() {
		return this.asOfDate;
	}
	
	/**
	 * Column Info
	 * @return amountOption
	 */
	public String getAmountOption() {
		return this.amountOption;
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
	 * @return toOverDue
	 */
	public String getToOverDue() {
		return this.toOverDue;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param fromOverDue
	 */
	public void setFromOverDue(String fromOverDue) {
		this.fromOverDue = fromOverDue;
	}
	
	/**
	 * Column Info
	 * @param asOfDate
	 */
	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}
	
	/**
	 * Column Info
	 * @param amountOption
	 */
	public void setAmountOption(String amountOption) {
		this.amountOption = amountOption;
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
	 * @param toOverDue
	 */
	public void setToOverDue(String toOverDue) {
		this.toOverDue = toOverDue;
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
	
	public String getUserOfcCd() {
		return userOfcCd;
	}

	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFromOverDue(JSPUtil.getParameter(request, "from_over_due", ""));
		setAsOfDate(JSPUtil.getParameter(request, "as_of_date", ""));
		setAmountOption(JSPUtil.getParameter(request, "amount_option", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setToOverDue(JSPUtil.getParameter(request, "to_over_due", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NotissuedInputVO[]
	 */
	public NotissuedInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NotissuedInputVO[]
	 */
	public NotissuedInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NotissuedInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fromOverDue = (JSPUtil.getParameter(request, prefix	+ "from_over_due", length));
			String[] asOfDate = (JSPUtil.getParameter(request, prefix	+ "as_of_date", length));
			String[] amountOption = (JSPUtil.getParameter(request, prefix	+ "amount_option", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] toOverDue = (JSPUtil.getParameter(request, prefix	+ "to_over_due", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NotissuedInputVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromOverDue[i] != null)
					model.setFromOverDue(fromOverDue[i]);
				if (asOfDate[i] != null)
					model.setAsOfDate(asOfDate[i]);
				if (amountOption[i] != null)
					model.setAmountOption(amountOption[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (toOverDue[i] != null)
					model.setToOverDue(toOverDue[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNotissuedInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NotissuedInputVO[]
	 */
	public NotissuedInputVO[] getNotissuedInputVOs(){
		NotissuedInputVO[] vos = (NotissuedInputVO[])models.toArray(new NotissuedInputVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromOverDue = this.fromOverDue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asOfDate = this.asOfDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountOption = this.amountOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOverDue = this.toOverDue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
