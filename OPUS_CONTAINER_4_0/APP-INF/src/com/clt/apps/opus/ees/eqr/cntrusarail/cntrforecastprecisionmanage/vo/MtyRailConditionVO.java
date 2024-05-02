/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyRailVO.java
*@FileTitle : MtyRailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MtyRailConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyRailConditionVO> models = new ArrayList<MtyRailConditionVO>();
	
	/* Column Info */
	private String railCompany = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String dateKind = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String orgLoc = null;
	/* Column Info */
	private String destLoc = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String diffDate = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MtyRailConditionVO() {}

	public MtyRailConditionVO(String ibflag, String pagerows, String fmDt, String toDt, String orgLoc, String destLoc, String gubun, String company, String railCompany, String dateKind, String tpsztype, String diffDate) {
		this.railCompany = railCompany;
		this.toDt = toDt;
		this.dateKind = dateKind;
		this.ibflag = ibflag;
		this.gubun = gubun;
		this.fmDt = fmDt;
		this.company = company;
		this.orgLoc = orgLoc;
		this.destLoc = destLoc;
		this.tpsztype = tpsztype;
		this.diffDate = diffDate;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rail_company", getRailCompany());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("date_kind", getDateKind());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("org_loc", getOrgLoc());
		this.hashColumns.put("dest_loc", getDestLoc());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("diff_date", getDiffDate());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rail_company", "railCompany");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("date_kind", "dateKind");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("company", "company");
		this.hashFields.put("org_loc", "orgLoc");
		this.hashFields.put("dest_loc", "destLoc");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("diff_date", "diffDate");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return railCompany
	 */
	public String getRailCompany() {
		return this.railCompany;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return dateKind
	 */
	public String getDateKind() {
		return this.dateKind;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return orgLoc
	 */
	public String getOrgLoc() {
		return this.orgLoc;
	}
	
	/**
	 * Column Info
	 * @return destLoc
	 */
	public String getDestLoc() {
		return this.destLoc;
	}
	
	/**
	 * Column Info
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
	}
	
	/**
	 * Column Info
	 * @return diffDate
	 */
	public String getDiffDate() {
		return this.diffDate;
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
	 * @param railCompany
	 */
	public void setRailCompany(String railCompany) {
		this.railCompany = railCompany;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param dateKind
	 */
	public void setDateKind(String dateKind) {
		this.dateKind = dateKind;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param orgLoc
	 */
	public void setOrgLoc(String orgLoc) {
		this.orgLoc = orgLoc;
	}
	
	/**
	 * Column Info
	 * @param destLoc
	 */
	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}
	
	/**
	 * Column Info
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	/**
	 * Column Info
	 * @param diffDate
	 */
	public void setDiffDate(String diffDate) {
		this.diffDate = diffDate;
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
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setOrgLoc(JSPUtil.getParameter(request, "org_loc", ""));
		setDestLoc(JSPUtil.getParameter(request, "dest_loc", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setRailCompany(JSPUtil.getParameter(request, "rail_company", ""));
		setDateKind(JSPUtil.getParameter(request, "date_kind", ""));
		setTpsztype(JSPUtil.getParameter(request, "tpsztype", ""));
		setDiffDate(JSPUtil.getParameter(request, "diff_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRailVO[]
	 */
	public MtyRailConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRailVO[]
	 */
	public MtyRailConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyRailConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] railCompany = (JSPUtil.getParameter(request, prefix	+ "rail_company", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] dateKind = (JSPUtil.getParameter(request, prefix	+ "date_kind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] orgLoc = (JSPUtil.getParameter(request, prefix	+ "org_loc", length));
			String[] destLoc = (JSPUtil.getParameter(request, prefix	+ "dest_loc", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] diffDate = (JSPUtil.getParameter(request, prefix	+ "diff_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MtyRailConditionVO();
				if (railCompany[i] != null)
					model.setRailCompany(railCompany[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (dateKind[i] != null)
					model.setDateKind(dateKind[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (orgLoc[i] != null)
					model.setOrgLoc(orgLoc[i]);
				if (destLoc[i] != null)
					model.setDestLoc(destLoc[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (diffDate[i] != null)
					model.setDiffDate(diffDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyRailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyRailVO[]
	 */
	public MtyRailConditionVO[] getMtyRailVOs(){
		MtyRailConditionVO[] vos = (MtyRailConditionVO[])models.toArray(new MtyRailConditionVO[models.size()]);
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
		this.railCompany = this.railCompany .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateKind = this.dateKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLoc = this.orgLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLoc = this.destLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffDate = this.diffDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
