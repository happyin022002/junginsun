/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchParameterAccrualEmailSettingVO.java
*@FileTitle : SearchParameterAccrualEmailSettingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.21 Jeon Jae Hong 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo;

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
 * @author Jeon Jae Hong
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchParameterAccrualEmailSettingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchParameterAccrualEmailSettingVO> models = new ArrayList<SearchParameterAccrualEmailSettingVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subjNm = null;
	/* Column Info */
	private String ccEml = null;
	/* Column Info */
	private String frmMailDiv = null;
	/* Column Info */
	private String frmExeYrmon = null;
	/* Column Info */
	private String toEml = null;
	/* Column Info */
	private String ctnt = null;
	/* Column Info */
	private String fmEml = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchParameterAccrualEmailSettingVO() {}

	public SearchParameterAccrualEmailSettingVO(String ibflag, String pagerows, String fmEml, String toEml, String ccEml, String ctnt, String subjNm, String frmMailDiv, String frmExeYrmon) {
		this.ibflag = ibflag;
		this.subjNm = subjNm;
		this.ccEml = ccEml;
		this.frmMailDiv = frmMailDiv;
		this.frmExeYrmon = frmExeYrmon;
		this.toEml = toEml;
		this.ctnt = ctnt;
		this.fmEml = fmEml;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("subj_nm", getSubjNm());
		this.hashColumns.put("cc_eml", getCcEml());
		this.hashColumns.put("frm_mail_div", getFrmMailDiv());
		this.hashColumns.put("frm_exe_yrmon", getFrmExeYrmon());
		this.hashColumns.put("to_eml", getToEml());
		this.hashColumns.put("ctnt", getCtnt());
		this.hashColumns.put("fm_eml", getFmEml());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("subj_nm", "subjNm");
		this.hashFields.put("cc_eml", "ccEml");
		this.hashFields.put("frm_mail_div", "frmMailDiv");
		this.hashFields.put("frm_exe_yrmon", "frmExeYrmon");
		this.hashFields.put("to_eml", "toEml");
		this.hashFields.put("ctnt", "ctnt");
		this.hashFields.put("fm_eml", "fmEml");
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
	 * @return subjNm
	 */
	public String getSubjNm() {
		return this.subjNm;
	}
	
	/**
	 * Column Info
	 * @return ccEml
	 */
	public String getCcEml() {
		return this.ccEml;
	}
	
	/**
	 * Column Info
	 * @return frmMailDiv
	 */
	public String getFrmMailDiv() {
		return this.frmMailDiv;
	}
	
	/**
	 * Column Info
	 * @return frmExeYrmon
	 */
	public String getFrmExeYrmon() {
		return this.frmExeYrmon;
	}
	
	/**
	 * Column Info
	 * @return toEml
	 */
	public String getToEml() {
		return this.toEml;
	}
	
	/**
	 * Column Info
	 * @return ctnt
	 */
	public String getCtnt() {
		return this.ctnt;
	}
	
	/**
	 * Column Info
	 * @return fmEml
	 */
	public String getFmEml() {
		return this.fmEml;
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
	 * @param subjNm
	 */
	public void setSubjNm(String subjNm) {
		this.subjNm = subjNm;
	}
	
	/**
	 * Column Info
	 * @param ccEml
	 */
	public void setCcEml(String ccEml) {
		this.ccEml = ccEml;
	}
	
	/**
	 * Column Info
	 * @param frmMailDiv
	 */
	public void setFrmMailDiv(String frmMailDiv) {
		this.frmMailDiv = frmMailDiv;
	}
	
	/**
	 * Column Info
	 * @param frmExeYrmon
	 */
	public void setFrmExeYrmon(String frmExeYrmon) {
		this.frmExeYrmon = frmExeYrmon;
	}
	
	/**
	 * Column Info
	 * @param toEml
	 */
	public void setToEml(String toEml) {
		this.toEml = toEml;
	}
	
	/**
	 * Column Info
	 * @param ctnt
	 */
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	
	/**
	 * Column Info
	 * @param fmEml
	 */
	public void setFmEml(String fmEml) {
		this.fmEml = fmEml;
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
		setSubjNm(JSPUtil.getParameter(request, "subj_nm", ""));
		setCcEml(JSPUtil.getParameter(request, "cc_eml", ""));
		setFrmMailDiv(JSPUtil.getParameter(request, "frm_mail_div", ""));
		setFrmExeYrmon(JSPUtil.getParameter(request, "frm_exe_yrmon", ""));
		setToEml(JSPUtil.getParameter(request, "to_eml", ""));
		setCtnt(JSPUtil.getParameter(request, "ctnt", ""));
		setFmEml(JSPUtil.getParameter(request, "fm_eml", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchParameterAccrualEmailSettingVO[]
	 */
	public SearchParameterAccrualEmailSettingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchParameterAccrualEmailSettingVO[]
	 */
	public SearchParameterAccrualEmailSettingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchParameterAccrualEmailSettingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subjNm = (JSPUtil.getParameter(request, prefix	+ "subj_nm", length));
			String[] ccEml = (JSPUtil.getParameter(request, prefix	+ "cc_eml", length));
			String[] frmMailDiv = (JSPUtil.getParameter(request, prefix	+ "frm_mail_div", length));
			String[] frmExeYrmon = (JSPUtil.getParameter(request, prefix	+ "frm_exe_yrmon", length));
			String[] toEml = (JSPUtil.getParameter(request, prefix	+ "to_eml", length));
			String[] ctnt = (JSPUtil.getParameter(request, prefix	+ "ctnt", length));
			String[] fmEml = (JSPUtil.getParameter(request, prefix	+ "fm_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchParameterAccrualEmailSettingVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subjNm[i] != null)
					model.setSubjNm(subjNm[i]);
				if (ccEml[i] != null)
					model.setCcEml(ccEml[i]);
				if (frmMailDiv[i] != null)
					model.setFrmMailDiv(frmMailDiv[i]);
				if (frmExeYrmon[i] != null)
					model.setFrmExeYrmon(frmExeYrmon[i]);
				if (toEml[i] != null)
					model.setToEml(toEml[i]);
				if (ctnt[i] != null)
					model.setCtnt(ctnt[i]);
				if (fmEml[i] != null)
					model.setFmEml(fmEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchParameterAccrualEmailSettingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchParameterAccrualEmailSettingVO[]
	 */
	public SearchParameterAccrualEmailSettingVO[] getSearchParameterAccrualEmailSettingVOs(){
		SearchParameterAccrualEmailSettingVO[] vos = (SearchParameterAccrualEmailSettingVO[])models.toArray(new SearchParameterAccrualEmailSettingVO[models.size()]);
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
		this.subjNm = this.subjNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccEml = this.ccEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmMailDiv = this.frmMailDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmExeYrmon = this.frmExeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEml = this.toEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctnt = this.ctnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEml = this.fmEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
