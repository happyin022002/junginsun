/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCntrOnHireApprovalVO.java
*@FileTitle : SearchCntrOnHireApprovalVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		Lee Byoung Hun				2009.09.07		1.0 최초 생성
*
*@LastModifyDate : 2009.09.07
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

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

public class SearchCntrOnHireApprovalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCntrOnHireApprovalVO> models = new ArrayList<SearchCntrOnHireApprovalVO>();
	
	/* Column Info */
	private String picQty = null;
	/* Column Info */
	private String appQty = null;
	/* Column Info */
	private String ctrtOfcCity = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String authNo = null;
	/* Column Info */
	private String ctrtSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCntrOnHireApprovalVO() {}

	public SearchCntrOnHireApprovalVO(String ibflag, String pagerows, String authNo, String ctrtOfcCity, String ctrtSeq, String cntrTpszCd, String appQty, String picQty) {
		this.picQty = picQty;
		this.appQty = appQty;
		this.ctrtOfcCity = ctrtOfcCity;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.authNo = authNo;
		this.ctrtSeq = ctrtSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pic_qty", getPicQty());
		this.hashColumns.put("app_qty", getAppQty());
		this.hashColumns.put("ctrt_ofc_city", getCtrtOfcCity());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("auth_no", getAuthNo());
		this.hashColumns.put("ctrt_seq", getCtrtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pic_qty", "picQty");
		this.hashFields.put("app_qty", "appQty");
		this.hashFields.put("ctrt_ofc_city", "ctrtOfcCity");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("auth_no", "authNo");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return picQty
	 */
	public String getPicQty() {
		return this.picQty;
	}
	
	/**
	 * Column Info
	 * @return appQty
	 */
	public String getAppQty() {
		return this.appQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCity
	 */
	public String getCtrtOfcCity() {
		return this.ctrtOfcCity;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return authNo
	 */
	public String getAuthNo() {
		return this.authNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtSeq
	 */
	public String getCtrtSeq() {
		return this.ctrtSeq;
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
	 * @param picQty
	 */
	public void setPicQty(String picQty) {
		this.picQty = picQty;
	}
	
	/**
	 * Column Info
	 * @param appQty
	 */
	public void setAppQty(String appQty) {
		this.appQty = appQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCity
	 */
	public void setCtrtOfcCity(String ctrtOfcCity) {
		this.ctrtOfcCity = ctrtOfcCity;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtSeq
	 */
	public void setCtrtSeq(String ctrtSeq) {
		this.ctrtSeq = ctrtSeq;
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
		setPicQty(JSPUtil.getParameter(request, "pic_qty", ""));
		setAppQty(JSPUtil.getParameter(request, "app_qty", ""));
		setCtrtOfcCity(JSPUtil.getParameter(request, "ctrt_ofc_city", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAuthNo(JSPUtil.getParameter(request, "auth_no", ""));
		setCtrtSeq(JSPUtil.getParameter(request, "ctrt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCntrOnHireApprovalVO[]
	 */
	public SearchCntrOnHireApprovalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCntrOnHireApprovalVO[]
	 */
	public SearchCntrOnHireApprovalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCntrOnHireApprovalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] picQty = (JSPUtil.getParameter(request, prefix	+ "pic_qty", length));
			String[] appQty = (JSPUtil.getParameter(request, prefix	+ "app_qty", length));
			String[] ctrtOfcCity = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_city", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] authNo = (JSPUtil.getParameter(request, prefix	+ "auth_no", length));
			String[] ctrtSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCntrOnHireApprovalVO();
				if (picQty[i] != null)
					model.setPicQty(picQty[i]);
				if (appQty[i] != null)
					model.setAppQty(appQty[i]);
				if (ctrtOfcCity[i] != null)
					model.setCtrtOfcCity(ctrtOfcCity[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (authNo[i] != null)
					model.setAuthNo(authNo[i]);
				if (ctrtSeq[i] != null)
					model.setCtrtSeq(ctrtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCntrOnHireApprovalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCntrOnHireApprovalVO[]
	 */
	public SearchCntrOnHireApprovalVO[] getSearchCntrOnHireApprovalVOs(){
		SearchCntrOnHireApprovalVO[] vos = (SearchCntrOnHireApprovalVO[])models.toArray(new SearchCntrOnHireApprovalVO[models.size()]);
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
		this.picQty = this.picQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appQty = this.appQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCity = this.ctrtOfcCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authNo = this.authNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq = this.ctrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
