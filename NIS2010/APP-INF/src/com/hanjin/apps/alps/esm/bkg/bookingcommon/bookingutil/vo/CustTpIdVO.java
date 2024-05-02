/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustTpIdVO.java
*@FileTitle : CustTpIdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.09.22 김영출 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustTpIdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustTpIdVO> models = new ArrayList<CustTpIdVO>();
	
	/* Column Info */
	private String groupId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvId = null;
	/* Column Info */
	private String refCode = null;
	/* Column Info */
	private String funcCode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustTpIdVO() {}

	public CustTpIdVO(String ibflag, String pagerows, String groupId, String rcvId, String refCode, String funcCode) {
		this.groupId = groupId;
		this.ibflag = ibflag;
		this.rcvId = rcvId;
		this.refCode = refCode;
		this.funcCode = funcCode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("group_id", getGroupId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcv_id", getRcvId());
		this.hashColumns.put("ref_code", getRefCode());
		this.hashColumns.put("func_code", getFuncCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("group_id", "groupId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcv_id", "rcvId");
		this.hashFields.put("ref_code", "refCode");
		this.hashFields.put("func_code", "funcCode");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return groupId
	 */
	public String getGroupId() {
		return this.groupId;
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
	 * @return rcvId
	 */
	public String getRcvId() {
		return this.rcvId;
	}
	
	/**
	 * Column Info
	 * @return refCode
	 */
	public String getRefCode() {
		return this.refCode;
	}
	
	/**
	 * Column Info
	 * @return funcCode
	 */
	public String getFuncCode() {
		return this.funcCode;
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
	 * @param groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
	 * @param rcvId
	 */
	public void setRcvId(String rcvId) {
		this.rcvId = rcvId;
	}
	
	/**
	 * Column Info
	 * @param refCode
	 */
	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}
	
	/**
	 * Column Info
	 * @param funcCode
	 */
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
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
		setGroupId(JSPUtil.getParameter(request, "group_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcvId(JSPUtil.getParameter(request, "rcv_id", ""));
		setRefCode(JSPUtil.getParameter(request, "ref_code", ""));
		setFuncCode(JSPUtil.getParameter(request, "func_code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustTpIdVO[]
	 */
	public CustTpIdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustTpIdVO[]
	 */
	public CustTpIdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustTpIdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] groupId = (JSPUtil.getParameter(request, prefix	+ "group_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvId = (JSPUtil.getParameter(request, prefix	+ "rcv_id", length));
			String[] refCode = (JSPUtil.getParameter(request, prefix	+ "ref_code", length));
			String[] funcCode = (JSPUtil.getParameter(request, prefix	+ "func_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustTpIdVO();
				if (groupId[i] != null)
					model.setGroupId(groupId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvId[i] != null)
					model.setRcvId(rcvId[i]);
				if (refCode[i] != null)
					model.setRefCode(refCode[i]);
				if (funcCode[i] != null)
					model.setFuncCode(funcCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustTpIdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustTpIdVO[]
	 */
	public CustTpIdVO[] getCustTpIdVOs(){
		CustTpIdVO[] vos = (CustTpIdVO[])models.toArray(new CustTpIdVO[models.size()]);
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
		this.groupId = this.groupId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvId = this.rcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refCode = this.refCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.funcCode = this.funcCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
