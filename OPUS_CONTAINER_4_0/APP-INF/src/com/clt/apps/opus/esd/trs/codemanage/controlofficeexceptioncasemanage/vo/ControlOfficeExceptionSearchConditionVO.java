/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ControlOfficeExceptionSearchConditionVO.java
*@FileTitle : ControlOfficeExceptionSearchConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.10 김성욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김성욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ControlOfficeExceptionSearchConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ControlOfficeExceptionSearchConditionVO> models = new ArrayList<ControlOfficeExceptionSearchConditionVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String searchTrsCostMdCd = null;
	/* Column Info */
	private String inputOffice = null;
	/* Column Info */
	private String searchToLoc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String searchViaYard = null;
	/* Column Info */
	private String searchFmYard = null;
	/* Column Info */
	private String searchDoorLoc = null;
	/* Column Info */
	private String searchFmLoc = null;
	/* Column Info */
	private String searchToYard = null;
	/* Column Info */
	private String searchCgoTpCd = null;
	/* Column Info */
	private String searchTrsMdCd = null;
	/* Column Info */
	private String searchDoorYard = null;
	/* Column Info */
	private String searchViaLoc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ControlOfficeExceptionSearchConditionVO() {}

	public ControlOfficeExceptionSearchConditionVO(String ibflag, String pagerows, String searchCgoTpCd, String searchTrsCostMdCd, String searchTrsMdCd, String inputOffice, String searchFmLoc, String searchFmYard, String searchViaLoc, String searchViaYard, String searchToLoc, String searchToYard, String searchDoorLoc, String searchDoorYard) {
		this.pagerows = pagerows;
		this.searchTrsCostMdCd = searchTrsCostMdCd;
		this.inputOffice = inputOffice;
		this.searchToLoc = searchToLoc;
		this.ibflag = ibflag;
		this.searchViaYard = searchViaYard;
		this.searchFmYard = searchFmYard;
		this.searchDoorLoc = searchDoorLoc;
		this.searchFmLoc = searchFmLoc;
		this.searchToYard = searchToYard;
		this.searchCgoTpCd = searchCgoTpCd;
		this.searchTrsMdCd = searchTrsMdCd;
		this.searchDoorYard = searchDoorYard;
		this.searchViaLoc = searchViaLoc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("search_trs_cost_md_cd", getSearchTrsCostMdCd());
		this.hashColumns.put("input_office", getInputOffice());
		this.hashColumns.put("search_to_loc", getSearchToLoc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("search_via_yard", getSearchViaYard());
		this.hashColumns.put("search_fm_yard", getSearchFmYard());
		this.hashColumns.put("search_door_loc", getSearchDoorLoc());
		this.hashColumns.put("search_fm_loc", getSearchFmLoc());
		this.hashColumns.put("search_to_yard", getSearchToYard());
		this.hashColumns.put("search_cgo_tp_cd", getSearchCgoTpCd());
		this.hashColumns.put("search_trs_md_cd", getSearchTrsMdCd());
		this.hashColumns.put("search_door_yard", getSearchDoorYard());
		this.hashColumns.put("search_via_loc", getSearchViaLoc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("search_trs_cost_md_cd", "searchTrsCostMdCd");
		this.hashFields.put("input_office", "inputOffice");
		this.hashFields.put("search_to_loc", "searchToLoc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("search_via_yard", "searchViaYard");
		this.hashFields.put("search_fm_yard", "searchFmYard");
		this.hashFields.put("search_door_loc", "searchDoorLoc");
		this.hashFields.put("search_fm_loc", "searchFmLoc");
		this.hashFields.put("search_to_yard", "searchToYard");
		this.hashFields.put("search_cgo_tp_cd", "searchCgoTpCd");
		this.hashFields.put("search_trs_md_cd", "searchTrsMdCd");
		this.hashFields.put("search_door_yard", "searchDoorYard");
		this.hashFields.put("search_via_loc", "searchViaLoc");
		return this.hashFields;
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
	 * @return searchTrsCostMdCd
	 */
	public String getSearchTrsCostMdCd() {
		return this.searchTrsCostMdCd;
	}
	
	/**
	 * Column Info
	 * @return inputOffice
	 */
	public String getInputOffice() {
		return this.inputOffice;
	}
	
	/**
	 * Column Info
	 * @return searchToLoc
	 */
	public String getSearchToLoc() {
		return this.searchToLoc;
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
	 * @return searchViaYard
	 */
	public String getSearchViaYard() {
		return this.searchViaYard;
	}
	
	/**
	 * Column Info
	 * @return searchFmYard
	 */
	public String getSearchFmYard() {
		return this.searchFmYard;
	}
	
	/**
	 * Column Info
	 * @return searchDoorLoc
	 */
	public String getSearchDoorLoc() {
		return this.searchDoorLoc;
	}
	
	/**
	 * Column Info
	 * @return searchFmLoc
	 */
	public String getSearchFmLoc() {
		return this.searchFmLoc;
	}
	
	/**
	 * Column Info
	 * @return searchToYard
	 */
	public String getSearchToYard() {
		return this.searchToYard;
	}
	
	/**
	 * Column Info
	 * @return searchCgoTpCd
	 */
	public String getSearchCgoTpCd() {
		return this.searchCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return searchTrsMdCd
	 */
	public String getSearchTrsMdCd() {
		return this.searchTrsMdCd;
	}
	
	/**
	 * Column Info
	 * @return searchDoorYard
	 */
	public String getSearchDoorYard() {
		return this.searchDoorYard;
	}
	
	/**
	 * Column Info
	 * @return searchViaLoc
	 */
	public String getSearchViaLoc() {
		return this.searchViaLoc;
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
	 * @param searchTrsCostMdCd
	 */
	public void setSearchTrsCostMdCd(String searchTrsCostMdCd) {
		this.searchTrsCostMdCd = searchTrsCostMdCd;
	}
	
	/**
	 * Column Info
	 * @param inputOffice
	 */
	public void setInputOffice(String inputOffice) {
		this.inputOffice = inputOffice;
	}
	
	/**
	 * Column Info
	 * @param searchToLoc
	 */
	public void setSearchToLoc(String searchToLoc) {
		this.searchToLoc = searchToLoc;
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
	 * @param searchViaYard
	 */
	public void setSearchViaYard(String searchViaYard) {
		this.searchViaYard = searchViaYard;
	}
	
	/**
	 * Column Info
	 * @param searchFmYard
	 */
	public void setSearchFmYard(String searchFmYard) {
		this.searchFmYard = searchFmYard;
	}
	
	/**
	 * Column Info
	 * @param searchDoorLoc
	 */
	public void setSearchDoorLoc(String searchDoorLoc) {
		this.searchDoorLoc = searchDoorLoc;
	}
	
	/**
	 * Column Info
	 * @param searchFmLoc
	 */
	public void setSearchFmLoc(String searchFmLoc) {
		this.searchFmLoc = searchFmLoc;
	}
	
	/**
	 * Column Info
	 * @param searchToYard
	 */
	public void setSearchToYard(String searchToYard) {
		this.searchToYard = searchToYard;
	}
	
	/**
	 * Column Info
	 * @param searchCgoTpCd
	 */
	public void setSearchCgoTpCd(String searchCgoTpCd) {
		this.searchCgoTpCd = searchCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param searchTrsMdCd
	 */
	public void setSearchTrsMdCd(String searchTrsMdCd) {
		this.searchTrsMdCd = searchTrsMdCd;
	}
	
	/**
	 * Column Info
	 * @param searchDoorYard
	 */
	public void setSearchDoorYard(String searchDoorYard) {
		this.searchDoorYard = searchDoorYard;
	}
	
	/**
	 * Column Info
	 * @param searchViaLoc
	 */
	public void setSearchViaLoc(String searchViaLoc) {
		this.searchViaLoc = searchViaLoc;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSearchTrsCostMdCd(JSPUtil.getParameter(request, prefix + "search_trs_cost_md_cd", ""));
		setInputOffice(JSPUtil.getParameter(request, prefix + "input_office", ""));
		setSearchToLoc(JSPUtil.getParameter(request, prefix + "search_to_loc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSearchViaYard(JSPUtil.getParameter(request, prefix + "search_via_yard", ""));
		setSearchFmYard(JSPUtil.getParameter(request, prefix + "search_fm_yard", ""));
		setSearchDoorLoc(JSPUtil.getParameter(request, prefix + "search_door_loc", ""));
		setSearchFmLoc(JSPUtil.getParameter(request, prefix + "search_fm_loc", ""));
		setSearchToYard(JSPUtil.getParameter(request, prefix + "search_to_yard", ""));
		setSearchCgoTpCd(JSPUtil.getParameter(request, prefix + "search_cgo_tp_cd", ""));
		setSearchTrsMdCd(JSPUtil.getParameter(request, prefix + "search_trs_md_cd", ""));
		setSearchDoorYard(JSPUtil.getParameter(request, prefix + "search_door_yard", ""));
		setSearchViaLoc(JSPUtil.getParameter(request, prefix + "search_via_loc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ControlOfficeExceptionSearchConditionVO[]
	 */
	public ControlOfficeExceptionSearchConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ControlOfficeExceptionSearchConditionVO[]
	 */
	public ControlOfficeExceptionSearchConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ControlOfficeExceptionSearchConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] searchTrsCostMdCd = (JSPUtil.getParameter(request, prefix	+ "search_trs_cost_md_cd", length));
			String[] inputOffice = (JSPUtil.getParameter(request, prefix	+ "input_office", length));
			String[] searchToLoc = (JSPUtil.getParameter(request, prefix	+ "search_to_loc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] searchViaYard = (JSPUtil.getParameter(request, prefix	+ "search_via_yard", length));
			String[] searchFmYard = (JSPUtil.getParameter(request, prefix	+ "search_fm_yard", length));
			String[] searchDoorLoc = (JSPUtil.getParameter(request, prefix	+ "search_door_loc", length));
			String[] searchFmLoc = (JSPUtil.getParameter(request, prefix	+ "search_fm_loc", length));
			String[] searchToYard = (JSPUtil.getParameter(request, prefix	+ "search_to_yard", length));
			String[] searchCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "search_cgo_tp_cd", length));
			String[] searchTrsMdCd = (JSPUtil.getParameter(request, prefix	+ "search_trs_md_cd", length));
			String[] searchDoorYard = (JSPUtil.getParameter(request, prefix	+ "search_door_yard", length));
			String[] searchViaLoc = (JSPUtil.getParameter(request, prefix	+ "search_via_loc", length));
			
			for (int i = 0; i < length; i++) {
				model = new ControlOfficeExceptionSearchConditionVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (searchTrsCostMdCd[i] != null)
					model.setSearchTrsCostMdCd(searchTrsCostMdCd[i]);
				if (inputOffice[i] != null)
					model.setInputOffice(inputOffice[i]);
				if (searchToLoc[i] != null)
					model.setSearchToLoc(searchToLoc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (searchViaYard[i] != null)
					model.setSearchViaYard(searchViaYard[i]);
				if (searchFmYard[i] != null)
					model.setSearchFmYard(searchFmYard[i]);
				if (searchDoorLoc[i] != null)
					model.setSearchDoorLoc(searchDoorLoc[i]);
				if (searchFmLoc[i] != null)
					model.setSearchFmLoc(searchFmLoc[i]);
				if (searchToYard[i] != null)
					model.setSearchToYard(searchToYard[i]);
				if (searchCgoTpCd[i] != null)
					model.setSearchCgoTpCd(searchCgoTpCd[i]);
				if (searchTrsMdCd[i] != null)
					model.setSearchTrsMdCd(searchTrsMdCd[i]);
				if (searchDoorYard[i] != null)
					model.setSearchDoorYard(searchDoorYard[i]);
				if (searchViaLoc[i] != null)
					model.setSearchViaLoc(searchViaLoc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getControlOfficeExceptionSearchConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ControlOfficeExceptionSearchConditionVO[]
	 */
	public ControlOfficeExceptionSearchConditionVO[] getControlOfficeExceptionSearchConditionVOs(){
		ControlOfficeExceptionSearchConditionVO[] vos = (ControlOfficeExceptionSearchConditionVO[])models.toArray(new ControlOfficeExceptionSearchConditionVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTrsCostMdCd = this.searchTrsCostMdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputOffice = this.inputOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchToLoc = this.searchToLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchViaYard = this.searchViaYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFmYard = this.searchFmYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDoorLoc = this.searchDoorLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFmLoc = this.searchFmLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchToYard = this.searchToYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchCgoTpCd = this.searchCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTrsMdCd = this.searchTrsMdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDoorYard = this.searchDoorYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchViaLoc = this.searchViaLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
