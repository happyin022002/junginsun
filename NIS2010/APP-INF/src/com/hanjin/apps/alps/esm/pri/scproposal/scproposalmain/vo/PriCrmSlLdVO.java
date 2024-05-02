/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriCrmSlLdVO.java
*@FileTitle : PriCrmSlLdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.11 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriCrmSlLdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriCrmSlLdVO> models = new ArrayList<PriCrmSlLdVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slsLdNo = null;
	/* Column Info */
	private String slsLdNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriCrmSlLdVO() {}

	public PriCrmSlLdVO(String ibflag, String pagerows, String slsLdNo, String slsLdNm) {
		this.ibflag = ibflag;
		this.slsLdNo = slsLdNo;
		this.slsLdNm = slsLdNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sls_ld_no", getSlsLdNo());
		this.hashColumns.put("sls_ld_nm", getSlsLdNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sls_ld_no", "slsLdNo");
		this.hashFields.put("sls_ld_nm", "slsLdNm");
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
	 * @return slsLdNo
	 */
	public String getSlsLdNo() {
		return this.slsLdNo;
	}
	
	/**
	 * Column Info
	 * @return slsLdNm
	 */
	public String getSlsLdNm() {
		return this.slsLdNm;
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
	 * @param slsLdNo
	 */
	public void setSlsLdNo(String slsLdNo) {
		this.slsLdNo = slsLdNo;
	}
	
	/**
	 * Column Info
	 * @param slsLdNm
	 */
	public void setSlsLdNm(String slsLdNm) {
		this.slsLdNm = slsLdNm;
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
		setSlsLdNo(JSPUtil.getParameter(request, "sls_ld_no", ""));
		setSlsLdNm(JSPUtil.getParameter(request, "sls_ld_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriCrmSlLdVO[]
	 */
	public PriCrmSlLdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriCrmSlLdVO[]
	 */
	public PriCrmSlLdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriCrmSlLdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slsLdNo = (JSPUtil.getParameter(request, prefix	+ "sls_ld_no", length));
			String[] slsLdNm = (JSPUtil.getParameter(request, prefix	+ "sls_ld_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriCrmSlLdVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slsLdNo[i] != null)
					model.setSlsLdNo(slsLdNo[i]);
				if (slsLdNm[i] != null)
					model.setSlsLdNm(slsLdNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriCrmSlLdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriCrmSlLdVO[]
	 */
	public PriCrmSlLdVO[] getPriCrmSlLdVOs(){
		PriCrmSlLdVO[] vos = (PriCrmSlLdVO[])models.toArray(new PriCrmSlLdVO[models.size()]);
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
		this.slsLdNo = this.slsLdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsLdNm = this.slsLdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
