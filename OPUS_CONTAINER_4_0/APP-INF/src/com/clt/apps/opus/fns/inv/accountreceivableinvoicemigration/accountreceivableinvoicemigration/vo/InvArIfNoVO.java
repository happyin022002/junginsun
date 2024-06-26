/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvArIfNoVO.java
*@FileTitle : InvArIfNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.22 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArIfNoVO extends AbstractValueObject {
 
	private static final long serialVersionUID = 1L;
	
	private Collection<InvArIfNoVO> models = new ArrayList<InvArIfNoVO>();
	
	/* Column Info */
	private String maxIfNo = null;
	/* Column Info */ 
	private String ifNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cancelIfNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mIfNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArIfNoVO() {}

	public InvArIfNoVO(String ibflag, String pagerows, String ifNo, String cancelIfNo, String maxIfNo, String mIfNo) {
		this.maxIfNo = maxIfNo;
		this.ifNo = ifNo;
		this.ibflag = ibflag;
		this.cancelIfNo = cancelIfNo;
		this.pagerows = pagerows;
		this.mIfNo = mIfNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("max_if_no", getMaxIfNo());
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cancel_if_no", getCancelIfNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("m_if_no", getMIfNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("max_if_no", "maxIfNo");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cancel_if_no", "cancelIfNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("m_if_no", "mIfNo");
		return this.hashFields;
	}
	
	/**
	 * @return the mIfNo
	 */
	public String getMIfNo() {
		return mIfNo;
	}

	/**
	 * @param ifNo the mIfNo to set
	 */
	public void setMIfNo(String ifNo) {
		mIfNo = ifNo;
	}

	/**
	 * Column Info
	 * @return maxIfNo
	 */
	public String getMaxIfNo() {
		return this.maxIfNo;
	}
	
	/**
	 * Column Info
	 * @return ifNo
	 */
	public String getIfNo() {
		return this.ifNo;
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
	 * @return cancelIfNo
	 */
	public String getCancelIfNo() {
		return this.cancelIfNo;
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
	 * @param maxIfNo
	 */
	public void setMaxIfNo(String maxIfNo) {
		this.maxIfNo = maxIfNo;
	}
	
	/**
	 * Column Info
	 * @param ifNo
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
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
	 * @param cancelIfNo
	 */
	public void setCancelIfNo(String cancelIfNo) {
		this.cancelIfNo = cancelIfNo;
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
		setMaxIfNo(JSPUtil.getParameter(request, "max_if_no", ""));
		setIfNo(JSPUtil.getParameter(request, "if_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCancelIfNo(JSPUtil.getParameter(request, "cancel_if_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMIfNo(JSPUtil.getParameter(request, "m_if_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArIfNoVO[]
	 */
	public InvArIfNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArIfNoVO[]
	 */
	public InvArIfNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArIfNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] maxIfNo = (JSPUtil.getParameter(request, prefix	+ "max_if_no", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cancelIfNo = (JSPUtil.getParameter(request, prefix	+ "cancel_if_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mIfNo = (JSPUtil.getParameter(request, prefix	+ "m_if_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArIfNoVO();
				if (maxIfNo[i] != null)
					model.setMaxIfNo(maxIfNo[i]);
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cancelIfNo[i] != null)
					model.setCancelIfNo(cancelIfNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mIfNo[i] != null)
					model.setMIfNo(mIfNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArIfNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArIfNoVO[]
	 */
	public InvArIfNoVO[] getInvArIfNoVOs(){
		InvArIfNoVO[] vos = (InvArIfNoVO[])models.toArray(new InvArIfNoVO[models.size()]);
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
		this.maxIfNo = this.maxIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelIfNo = this.cancelIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mIfNo = this.mIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
