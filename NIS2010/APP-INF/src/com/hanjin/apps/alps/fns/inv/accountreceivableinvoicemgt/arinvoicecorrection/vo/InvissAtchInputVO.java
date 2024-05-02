/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvissAtchInputVO.java
*@FileTitle : InvissAtchInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.08.07 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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

public class InvissAtchInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvissAtchInputVO> models = new ArrayList<InvissAtchInputVO>();
	
	/* Column Info */
	private String searchOption = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvissAtchInputVO() {}

	public InvissAtchInputVO(String searchOption, String arOfcCd, String vvd, String portCd, String custCntCd, String custSeq) {
		this.searchOption = searchOption;
		this.arOfcCd = arOfcCd;
		this.vvd = vvd;
		this.portCd = portCd;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_option", getSearchOption());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("search_option", "searchOption");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		return this.hashFields;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getPortCd() {
		return portCd;
	}

	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSearchOption(JSPUtil.getParameter(request, "search_option", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvissAtchInputVO[]
	 */
	public InvissAtchInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvissAtchInputVO[]
	 */
	public InvissAtchInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvissAtchInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchOption = (JSPUtil.getParameter(request, prefix	+ "search_option", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvissAtchInputVO();
				if (searchOption[i] != null)
					model.setSearchOption(searchOption[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvissAtchInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvissAtchInputVO[]
	 */
	public InvissAtchInputVO[] getInvissAtchInputVOs(){
		InvissAtchInputVO[] vos = (InvissAtchInputVO[])models.toArray(new InvissAtchInputVO[models.size()]);
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
		this.searchOption = this.searchOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
