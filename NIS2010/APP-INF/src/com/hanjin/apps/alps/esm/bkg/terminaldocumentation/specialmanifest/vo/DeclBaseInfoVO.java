/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DeclBaseInfoVO.java
*@FileTitle : DeclBaseInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DeclBaseInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DeclBaseInfoVO> models = new ArrayList<DeclBaseInfoVO>();
	
	/* Column Info */
	private String userRef = null;
	/* Column Info */
	private String docName = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String reason = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String firstUserRef = null;
	/* Column Info */
	private String secFileNbr = null;
	/* Column Info */
	private String ffRef = null;
	/* Column Info */
	private String handling = null;
	/* Column Info */
	private String declType = null;
	/* Column Info */
	private String oldUserRef = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DeclBaseInfoVO() {}

	public DeclBaseInfoVO(String ibflag, String pagerows, String docName, String declType, String handling, String status, String reason, String userRef, String oldUserRef, String firstUserRef, String secFileNbr, String ffRef) {
		this.userRef = userRef;
		this.docName = docName;
		this.ibflag = ibflag;
		this.reason = reason;
		this.status = status;
		this.firstUserRef = firstUserRef;
		this.secFileNbr = secFileNbr;
		this.ffRef = ffRef;
		this.handling = handling;
		this.declType = declType;
		this.oldUserRef = oldUserRef;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ref", getUserRef());
		this.hashColumns.put("doc_name", getDocName());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("reason", getReason());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("first_user_ref", getFirstUserRef());
		this.hashColumns.put("sec_file_nbr", getSecFileNbr());
		this.hashColumns.put("ff_ref", getFfRef());
		this.hashColumns.put("handling", getHandling());
		this.hashColumns.put("decl_type", getDeclType());
		this.hashColumns.put("old_user_ref", getOldUserRef());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ref", "userRef");
		this.hashFields.put("doc_name", "docName");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("reason", "reason");
		this.hashFields.put("status", "status");
		this.hashFields.put("first_user_ref", "firstUserRef");
		this.hashFields.put("sec_file_nbr", "secFileNbr");
		this.hashFields.put("ff_ref", "ffRef");
		this.hashFields.put("handling", "handling");
		this.hashFields.put("decl_type", "declType");
		this.hashFields.put("old_user_ref", "oldUserRef");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userRef
	 */
	public String getUserRef() {
		return this.userRef;
	}
	
	/**
	 * Column Info
	 * @return docName
	 */
	public String getDocName() {
		return this.docName;
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
	 * @return reason
	 */
	public String getReason() {
		return this.reason;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return firstUserRef
	 */
	public String getFirstUserRef() {
		return this.firstUserRef;
	}
	
	/**
	 * Column Info
	 * @return secFileNbr
	 */
	public String getSecFileNbr() {
		return this.secFileNbr;
	}
	
	/**
	 * Column Info
	 * @return ffRef
	 */
	public String getFfRef() {
		return this.ffRef;
	}
	
	/**
	 * Column Info
	 * @return handling
	 */
	public String getHandling() {
		return this.handling;
	}
	
	/**
	 * Column Info
	 * @return declType
	 */
	public String getDeclType() {
		return this.declType;
	}
	
	/**
	 * Column Info
	 * @return oldUserRef
	 */
	public String getOldUserRef() {
		return this.oldUserRef;
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
	 * @param userRef
	 */
	public void setUserRef(String userRef) {
		this.userRef = userRef;
	}
	
	/**
	 * Column Info
	 * @param docName
	 */
	public void setDocName(String docName) {
		this.docName = docName;
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
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param firstUserRef
	 */
	public void setFirstUserRef(String firstUserRef) {
		this.firstUserRef = firstUserRef;
	}
	
	/**
	 * Column Info
	 * @param secFileNbr
	 */
	public void setSecFileNbr(String secFileNbr) {
		this.secFileNbr = secFileNbr;
	}
	
	/**
	 * Column Info
	 * @param ffRef
	 */
	public void setFfRef(String ffRef) {
		this.ffRef = ffRef;
	}
	
	/**
	 * Column Info
	 * @param handling
	 */
	public void setHandling(String handling) {
		this.handling = handling;
	}
	
	/**
	 * Column Info
	 * @param declType
	 */
	public void setDeclType(String declType) {
		this.declType = declType;
	}
	
	/**
	 * Column Info
	 * @param oldUserRef
	 */
	public void setOldUserRef(String oldUserRef) {
		this.oldUserRef = oldUserRef;
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
		setUserRef(JSPUtil.getParameter(request, "user_ref", ""));
		setDocName(JSPUtil.getParameter(request, "doc_name", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setReason(JSPUtil.getParameter(request, "reason", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setFirstUserRef(JSPUtil.getParameter(request, "first_user_ref", ""));
		setSecFileNbr(JSPUtil.getParameter(request, "sec_file_nbr", ""));
		setFfRef(JSPUtil.getParameter(request, "ff_ref", ""));
		setHandling(JSPUtil.getParameter(request, "handling", ""));
		setDeclType(JSPUtil.getParameter(request, "decl_type", ""));
		setOldUserRef(JSPUtil.getParameter(request, "old_user_ref", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DeclBaseInfoVO[]
	 */
	public DeclBaseInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DeclBaseInfoVO[]
	 */
	public DeclBaseInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DeclBaseInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userRef = (JSPUtil.getParameter(request, prefix	+ "user_ref", length));
			String[] docName = (JSPUtil.getParameter(request, prefix	+ "doc_name", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] reason = (JSPUtil.getParameter(request, prefix	+ "reason", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] firstUserRef = (JSPUtil.getParameter(request, prefix	+ "first_user_ref", length));
			String[] secFileNbr = (JSPUtil.getParameter(request, prefix	+ "sec_file_nbr", length));
			String[] ffRef = (JSPUtil.getParameter(request, prefix	+ "ff_ref", length));
			String[] handling = (JSPUtil.getParameter(request, prefix	+ "handling", length));
			String[] declType = (JSPUtil.getParameter(request, prefix	+ "decl_type", length));
			String[] oldUserRef = (JSPUtil.getParameter(request, prefix	+ "old_user_ref", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DeclBaseInfoVO();
				if (userRef[i] != null)
					model.setUserRef(userRef[i]);
				if (docName[i] != null)
					model.setDocName(docName[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (reason[i] != null)
					model.setReason(reason[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (firstUserRef[i] != null)
					model.setFirstUserRef(firstUserRef[i]);
				if (secFileNbr[i] != null)
					model.setSecFileNbr(secFileNbr[i]);
				if (ffRef[i] != null)
					model.setFfRef(ffRef[i]);
				if (handling[i] != null)
					model.setHandling(handling[i]);
				if (declType[i] != null)
					model.setDeclType(declType[i]);
				if (oldUserRef[i] != null)
					model.setOldUserRef(oldUserRef[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDeclBaseInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DeclBaseInfoVO[]
	 */
	public DeclBaseInfoVO[] getDeclBaseInfoVOs(){
		DeclBaseInfoVO[] vos = (DeclBaseInfoVO[])models.toArray(new DeclBaseInfoVO[models.size()]);
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
		this.userRef = this.userRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docName = this.docName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reason = this.reason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstUserRef = this.firstUserRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.secFileNbr = this.secFileNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffRef = this.ffRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.handling = this.handling .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declType = this.declType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldUserRef = this.oldUserRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
