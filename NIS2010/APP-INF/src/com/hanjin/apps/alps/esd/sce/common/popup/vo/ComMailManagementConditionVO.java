/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComMailManagementConditionVO.java
*@FileTitle : ComMailManagementConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.08.17 신한성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.common.popup.vo;

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
 * @author 신한성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComMailManagementConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComMailManagementConditionVO> models = new ArrayList<ComMailManagementConditionVO>();
	
	/* Column Info */
	private String sendEml3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String exptVal = null;
	/* Column Info */
	private String exptNo = null;
	/* Column Info */
	private String contents = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String attachnm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComMailManagementConditionVO() {}

	public ComMailManagementConditionVO(String ibflag, String pagerows, String sendEml3, String subject, String contents, String exptNo, String exptVal, String attachnm) {
		this.sendEml3 = sendEml3;
		this.ibflag = ibflag;
		this.exptVal = exptVal;
		this.exptNo = exptNo;
		this.contents = contents;
		this.subject = subject;
		this.attachnm = attachnm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("send_eml3", getSendEml3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("expt_val", getExptVal());
		this.hashColumns.put("expt_no", getExptNo());
		this.hashColumns.put("contents", getContents());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("attachnm", getAttachnm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("send_eml3", "sendEml3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("expt_val", "exptVal");
		this.hashFields.put("expt_no", "exptNo");
		this.hashFields.put("contents", "contents");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("attachnm", "attachnm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sendEml3
	 */
	public String getSendEml3() {
		return this.sendEml3;
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
	 * @return exptVal
	 */
	public String getExptVal() {
		return this.exptVal;
	}
	
	/**
	 * Column Info
	 * @return exptNo
	 */
	public String getExptNo() {
		return this.exptNo;
	}
	
	/**
	 * Column Info
	 * @return contents
	 */
	public String getContents() {
		return this.contents;
	}
	
	/**
	 * Column Info
	 * @return subject
	 */
	public String getSubject() {
		return this.subject;
	}
	
	/**
	 * Column Info
	 * @return attachnm
	 */
	public String getAttachnm() {
		return this.attachnm;
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
	 * @param sendEml3
	 */
	public void setSendEml3(String sendEml3) {
		this.sendEml3 = sendEml3;
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
	 * @param exptVal
	 */
	public void setExptVal(String exptVal) {
		this.exptVal = exptVal;
	}
	
	/**
	 * Column Info
	 * @param exptNo
	 */
	public void setExptNo(String exptNo) {
		this.exptNo = exptNo;
	}
	
	/**
	 * Column Info
	 * @param contents
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	/**
	 * Column Info
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Column Info
	 * @param attachnm
	 */
	public void setAttachnm(String attachnm) {
		this.attachnm = attachnm;
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
		setSendEml3(JSPUtil.getParameter(request, "send_eml3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setExptVal(JSPUtil.getParameter(request, "expt_val", ""));
		setExptNo(JSPUtil.getParameter(request, "expt_no", ""));
		setContents(JSPUtil.getParameter(request, "contents", ""));
		setSubject(JSPUtil.getParameter(request, "subject", ""));
		setAttachnm(JSPUtil.getParameter(request, "attachnm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComMailManagementConditionVO[]
	 */
	public ComMailManagementConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComMailManagementConditionVO[]
	 */
	public ComMailManagementConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComMailManagementConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sendEml3 = (JSPUtil.getParameter(request, prefix	+ "send_eml3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] exptVal = (JSPUtil.getParameter(request, prefix	+ "expt_val", length));
			String[] exptNo = (JSPUtil.getParameter(request, prefix	+ "expt_no", length));
			String[] contents = (JSPUtil.getParameter(request, prefix	+ "contents", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] attachnm = (JSPUtil.getParameter(request, prefix	+ "attachnm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComMailManagementConditionVO();
				if (sendEml3[i] != null)
					model.setSendEml3(sendEml3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (exptVal[i] != null)
					model.setExptVal(exptVal[i]);
				if (exptNo[i] != null)
					model.setExptNo(exptNo[i]);
				if (contents[i] != null)
					model.setContents(contents[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (attachnm[i] != null)
					model.setAttachnm(attachnm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComMailManagementConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComMailManagementConditionVO[]
	 */
	public ComMailManagementConditionVO[] getComMailManagementConditionVOs(){
		ComMailManagementConditionVO[] vos = (ComMailManagementConditionVO[])models.toArray(new ComMailManagementConditionVO[models.size()]);
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
		this.sendEml3 = this.sendEml3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptVal = this.exptVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptNo = this.exptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contents = this.contents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachnm = this.attachnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
