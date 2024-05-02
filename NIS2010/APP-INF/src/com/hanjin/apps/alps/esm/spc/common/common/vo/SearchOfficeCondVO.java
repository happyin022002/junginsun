/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOfficeCondVO.java
*@FileTitle : SearchOfficeCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.21 최윤성 
* 1.0 Creation
* 2011.07.26 김종준 [SRM-201118467] usrRoleYn 추가
=========================================================*/

package com.hanjin.apps.alps.esm.spc.common.common.vo;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOfficeCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOfficeCondVO> models = new ArrayList<SearchOfficeCondVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String adm = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String aqCd = null;
	/* Page Number */
	private String pagerows = null;

	
	/* Column Info */
	private String usrRoleYn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOfficeCondVO() {}

	public SearchOfficeCondVO(String ibflag, String pagerows, String adm, String rhqCd, String aqCd, String rgnOfcCd, String ofcCd, String ofcTpCd, String usrRoleYn) {
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.rhqCd = rhqCd;
		this.adm = adm;
		this.ofcTpCd = ofcTpCd;
		this.rgnOfcCd = rgnOfcCd;
		this.aqCd = aqCd;
		this.pagerows = pagerows;
		
		this.usrRoleYn = usrRoleYn;
}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("adm", getAdm());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("aq_cd", getAqCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usr_role_yn", getUsrRoleYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("adm", "adm");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("aq_cd", "aqCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_role_yn", "usrRoleYn");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return adm
	 */
	public String getAdm() {
		return this.adm;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aqCd
	 */
	public String getAqCd() {
		return this.aqCd;
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
	 * @return usrRoleYn
	 */
	public String getUsrRoleYn() {
		return this.usrRoleYn;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param adm
	 */
	public void setAdm(String adm) {
		this.adm = adm;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aqCd
	 */
	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param usrRoleYn
	 */
	public void setUsrRoleYn(String usrRoleYn) {
		this.usrRoleYn = usrRoleYn;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setAdm(JSPUtil.getParameter(request, "adm", ""));
		setOfcTpCd(JSPUtil.getParameter(request, "ofc_tp_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, "rgn_ofc_cd", ""));
		setAqCd(JSPUtil.getParameter(request, "aq_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));

		setUsrRoleYn(JSPUtil.getParameter(request, "usr_role_yn", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOfficeCondVO[]
	 */
	public SearchOfficeCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOfficeCondVO[]
	 */
	public SearchOfficeCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOfficeCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] adm = (JSPUtil.getParameter(request, prefix	+ "adm", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			String[] usrRoleYn = (JSPUtil.getParameter(request, prefix	+ "usr_role_yn", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOfficeCondVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (adm[i] != null)
					model.setAdm(adm[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);

				if (usrRoleYn[i] != null)
					model.setUsrRoleYn(usrRoleYn[i]);

				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOfficeCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOfficeCondVO[]
	 */
	public SearchOfficeCondVO[] getSearchOfficeCondVOs(){
		SearchOfficeCondVO[] vos = (SearchOfficeCondVO[])models.toArray(new SearchOfficeCondVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adm = this.adm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.usrRoleYn = this.usrRoleYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
