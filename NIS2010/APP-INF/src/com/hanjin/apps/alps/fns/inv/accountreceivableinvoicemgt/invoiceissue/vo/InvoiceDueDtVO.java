/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceDueDtVO.java
*@FileTitle : InvoiceDueDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.26 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceDueDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceDueDtVO> models = new ArrayList<InvoiceDueDtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String duedt = null;
	/* Column Info */
	private String invno = null;
	/* Column Info */
	private String ifno = null;
	/* Column Info */
	private String issflg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceDueDtVO() {}

	public InvoiceDueDtVO(String ibflag, String pagerows, String invno, String issflg, String ifno, String duedt) {
		this.ibflag = ibflag;
		this.duedt = duedt;
		this.invno = invno;
		this.ifno = ifno;
		this.issflg = issflg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("duedt", getDuedt());
		this.hashColumns.put("invno", getInvno());
		this.hashColumns.put("ifno", getIfno());
		this.hashColumns.put("issflg", getIssflg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("duedt", "duedt");
		this.hashFields.put("invno", "invno");
		this.hashFields.put("ifno", "ifno");
		this.hashFields.put("issflg", "issflg");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return duedt
	 */
	public String getDuedt() {
		return this.duedt;
	}
	
	/**
	 * Column Info
	 * @return invno
	 */
	public String getInvno() {
		return this.invno;
	}
	
	/**
	 * Column Info
	 * @return ifno
	 */
	public String getIfno() {
		return this.ifno;
	}
	
	/**
	 * Column Info
	 * @return issflg
	 */
	public String getIssflg() {
		return this.issflg;
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
	 * @param duedt
	 */
	public void setDuedt(String duedt) {
		this.duedt = duedt;
	}
	
	/**
	 * Column Info
	 * @param invno
	 */
	public void setInvno(String invno) {
		this.invno = invno;
	}
	
	/**
	 * Column Info
	 * @param ifno
	 */
	public void setIfno(String ifno) {
		this.ifno = ifno;
	}
	
	/**
	 * Column Info
	 * @param issflg
	 */
	public void setIssflg(String issflg) {
		this.issflg = issflg;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDuedt(JSPUtil.getParameter(request, "duedt", ""));
		setInvno(JSPUtil.getParameter(request, "invno", ""));
		setIfno(JSPUtil.getParameter(request, "ifno", ""));
		setIssflg(JSPUtil.getParameter(request, "issflg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceDueDtVO[]
	 */
	public InvoiceDueDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceDueDtVO[]
	 */
	public InvoiceDueDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceDueDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] duedt = (JSPUtil.getParameter(request, prefix	+ "duedt".trim(), length));
			String[] invno = (JSPUtil.getParameter(request, prefix	+ "invno".trim(), length));
			String[] ifno = (JSPUtil.getParameter(request, prefix	+ "ifno".trim(), length));
			String[] issflg = (JSPUtil.getParameter(request, prefix	+ "issflg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceDueDtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (duedt[i] != null)
					model.setDuedt(duedt[i]);
				if (invno[i] != null)
					model.setInvno(invno[i]);
				if (ifno[i] != null)
					model.setIfno(ifno[i]);
				if (issflg[i] != null)
					model.setIssflg(issflg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceDueDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceDueDtVO[]
	 */
	public InvoiceDueDtVO[] getInvoiceDueDtVOs(){
		InvoiceDueDtVO[] vos = (InvoiceDueDtVO[])models.toArray(new InvoiceDueDtVO[models.size()]);
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
		this.duedt = this.duedt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invno = this.invno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifno = this.ifno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issflg = this.issflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
