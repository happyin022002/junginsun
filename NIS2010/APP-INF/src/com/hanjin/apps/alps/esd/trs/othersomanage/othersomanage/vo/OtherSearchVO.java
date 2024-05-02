/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSearchVO.java
*@FileTitle : OtherSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OtherSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtherSearchVO> models = new ArrayList<OtherSearchVO>();
	
	/* Column Info */
	private String searchToYard = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String fmdate = null;
	/* Column Info */
	private String searchFmYard = null;
	/* Column Info */
	private String searchFmLoc = null;
	/* Column Info */
	private String trsCostMdCd = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String searchToLoc = null;
	/* Column Info */
	private String trsMdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OtherSearchVO() {}

	public OtherSearchVO(String ibflag, String pagerows, String fmdate, String todate, String trsCostMdCd, String trsMdCd, String searchFmLoc, String searchFmYard, String searchToLoc, String searchToYard, String eqNo) {
		this.searchToYard = searchToYard;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.fmdate = fmdate;
		this.searchFmYard = searchFmYard;
		this.searchFmLoc = searchFmLoc;
		this.trsCostMdCd = trsCostMdCd;
		this.todate = todate;
		this.searchToLoc = searchToLoc;
		this.trsMdCd = trsMdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_to_yard", getSearchToYard());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("fmdate", getFmdate());
		this.hashColumns.put("search_fm_yard", getSearchFmYard());
		this.hashColumns.put("search_fm_loc", getSearchFmLoc());
		this.hashColumns.put("trs_cost_md_cd", getTrsCostMdCd());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("search_to_loc", getSearchToLoc());
		this.hashColumns.put("trs_md_cd", getTrsMdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("search_to_yard", "searchToYard");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("fmdate", "fmdate");
		this.hashFields.put("search_fm_yard", "searchFmYard");
		this.hashFields.put("search_fm_loc", "searchFmLoc");
		this.hashFields.put("trs_cost_md_cd", "trsCostMdCd");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("search_to_loc", "searchToLoc");
		this.hashFields.put("trs_md_cd", "trsMdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return searchToYard
	 */
	public String getSearchToYard() {
		return this.searchToYard;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return fmdate
	 */
	public String getFmdate() {
		return this.fmdate;
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
	 * @return searchFmLoc
	 */
	public String getSearchFmLoc() {
		return this.searchFmLoc;
	}
	
	/**
	 * Column Info
	 * @return trsCostMdCd
	 */
	public String getTrsCostMdCd() {
		return this.trsCostMdCd;
	}
	
	/**
	 * Column Info
	 * @return todate
	 */
	public String getTodate() {
		return this.todate;
	}
	
	/**
	 * Column Info
	 * @return searchToLoc
	 */
	public String getSearchToLoc() {
		return this.searchToLoc;
	}
	
	/**
	 * Column Info
	 * @return trsMdCd
	 */
	public String getTrsMdCd() {
		return this.trsMdCd;
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
	 * @param searchToYard
	 */
	public void setSearchToYard(String searchToYard) {
		this.searchToYard = searchToYard;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param fmdate
	 */
	public void setFmdate(String fmdate) {
		this.fmdate = fmdate;
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
	 * @param searchFmLoc
	 */
	public void setSearchFmLoc(String searchFmLoc) {
		this.searchFmLoc = searchFmLoc;
	}
	
	/**
	 * Column Info
	 * @param trsCostMdCd
	 */
	public void setTrsCostMdCd(String trsCostMdCd) {
		this.trsCostMdCd = trsCostMdCd;
	}
	
	/**
	 * Column Info
	 * @param todate
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	/**
	 * Column Info
	 * @param searchToLoc
	 */
	public void setSearchToLoc(String searchToLoc) {
		this.searchToLoc = searchToLoc;
	}
	
	/**
	 * Column Info
	 * @param trsMdCd
	 */
	public void setTrsMdCd(String trsMdCd) {
		this.trsMdCd = trsMdCd;
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
		setSearchToYard(JSPUtil.getParameter(request, "search_to_yard", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setFmdate(JSPUtil.getParameter(request, "fmdate", ""));
		setSearchFmYard(JSPUtil.getParameter(request, "search_fm_yard", ""));
		setSearchFmLoc(JSPUtil.getParameter(request, "search_fm_loc", ""));
		setTrsCostMdCd(JSPUtil.getParameter(request, "trs_cost_md_cd", ""));
		setTodate(JSPUtil.getParameter(request, "todate", ""));
		setSearchToLoc(JSPUtil.getParameter(request, "search_to_loc", ""));
		setTrsMdCd(JSPUtil.getParameter(request, "trs_md_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtherSearchVO[]
	 */
	public OtherSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtherSearchVO[]
	 */
	public OtherSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtherSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchToYard = (JSPUtil.getParameter(request, prefix	+ "search_to_yard", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] fmdate = (JSPUtil.getParameter(request, prefix	+ "fmdate", length));
			String[] searchFmYard = (JSPUtil.getParameter(request, prefix	+ "search_fm_yard", length));
			String[] searchFmLoc = (JSPUtil.getParameter(request, prefix	+ "search_fm_loc", length));
			String[] trsCostMdCd = (JSPUtil.getParameter(request, prefix	+ "trs_cost_md_cd", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] searchToLoc = (JSPUtil.getParameter(request, prefix	+ "search_to_loc", length));
			String[] trsMdCd = (JSPUtil.getParameter(request, prefix	+ "trs_md_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtherSearchVO();
				if (searchToYard[i] != null)
					model.setSearchToYard(searchToYard[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (fmdate[i] != null)
					model.setFmdate(fmdate[i]);
				if (searchFmYard[i] != null)
					model.setSearchFmYard(searchFmYard[i]);
				if (searchFmLoc[i] != null)
					model.setSearchFmLoc(searchFmLoc[i]);
				if (trsCostMdCd[i] != null)
					model.setTrsCostMdCd(trsCostMdCd[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (searchToLoc[i] != null)
					model.setSearchToLoc(searchToLoc[i]);
				if (trsMdCd[i] != null)
					model.setTrsMdCd(trsMdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtherSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OtherSearchVO[]
	 */
	public OtherSearchVO[] getOtherSearchVOs(){
		OtherSearchVO[] vos = (OtherSearchVO[])models.toArray(new OtherSearchVO[models.size()]);
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
		this.searchToYard = this.searchToYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmdate = this.fmdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFmYard = this.searchFmYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFmLoc = this.searchFmLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsCostMdCd = this.trsCostMdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchToLoc = this.searchToLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsMdCd = this.trsMdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
