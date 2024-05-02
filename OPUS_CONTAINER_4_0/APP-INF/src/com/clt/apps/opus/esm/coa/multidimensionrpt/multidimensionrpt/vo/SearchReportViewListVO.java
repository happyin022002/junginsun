/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchReportViewListVO.java
*@FileTitle : SearchReportViewListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.07.23 박수훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo;

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
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchReportViewListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchReportViewListVO> models = new ArrayList<SearchReportViewListVO>();
	
	/* Column Info */
	private String ofcCd2 = null;
	/* Column Info */
	private String ofcCd1 = null;
	/* Column Info */
	private String ofcLvlDesc = null;
	/* Column Info */
	private String ofcLvl = null;
	/* Column Info */
	private String pfitDflt = null;
	/* Column Info */
	private String pfitCd1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lvlDflt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfitCd2 = null;
	/* Column Info */
	private String lvlCd1 = null;
	/* Column Info */
	private String lvlCd2 = null;
	/* Column Info */
	private String rptSeq = null;
	/* Column Info */
	private String ofcDflt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchReportViewListVO() {}

	public SearchReportViewListVO(String ibflag, String pagerows, String rptSeq, String ofcLvl, String ofcLvlDesc, String pfitCd1, String pfitCd2, String pfitDflt, String ofcCd1, String ofcCd2, String ofcDflt, String lvlCd1, String lvlCd2, String lvlDflt) {
		this.ofcCd2 = ofcCd2;
		this.ofcCd1 = ofcCd1;
		this.ofcLvlDesc = ofcLvlDesc;
		this.ofcLvl = ofcLvl;
		this.pfitDflt = pfitDflt;
		this.pfitCd1 = pfitCd1;
		this.pagerows = pagerows;
		this.lvlDflt = lvlDflt;
		this.ibflag = ibflag;
		this.pfitCd2 = pfitCd2;
		this.lvlCd1 = lvlCd1;
		this.lvlCd2 = lvlCd2;
		this.rptSeq = rptSeq;
		this.ofcDflt = ofcDflt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpt_seq", getRptSeq());
		this.hashColumns.put("ofc_lvl", getOfcLvl());
		this.hashColumns.put("ofc_lvl_desc", getOfcLvlDesc());
		this.hashColumns.put("pfit_cd1", getPfitCd1());
		this.hashColumns.put("pfit_cd2", getPfitCd2());
		this.hashColumns.put("pfit_dflt", getPfitDflt());
		this.hashColumns.put("ofc_cd1", getOfcCd1());
		this.hashColumns.put("ofc_cd2", getOfcCd2());
		this.hashColumns.put("ofc_dflt", getOfcDflt());
		this.hashColumns.put("lvl_cd1", getLvlCd1());
		this.hashColumns.put("lvl_cd2", getLvlCd2());
		this.hashColumns.put("lvl_dflt", getLvlDflt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpt_seq", "rptSeq");
		this.hashFields.put("ofc_lvl", "ofcLvl");
		this.hashFields.put("ofc_lvl_desc", "ofcLvlDesc");
		this.hashFields.put("pfit_cd1", "pfitCd1");
		this.hashFields.put("pfit_cd2", "pfitCd2");
		this.hashFields.put("pfit_dflt", "pfitDflt");
		this.hashFields.put("ofc_cd1", "ofcCd1");
		this.hashFields.put("ofc_cd2", "ofcCd2");
		this.hashFields.put("ofc_dflt", "ofcDflt");
		this.hashFields.put("lvl_cd1", "lvlCd1");
		this.hashFields.put("lvl_cd2", "lvlCd2");
		this.hashFields.put("lvl_dflt", "lvlDflt");
		this.hashFields.put("pagerows", "pagerows");
		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd2
	 */
	public String getOfcCd2() {
		return this.ofcCd2;
	}
	
	/**
	 * Column Info
	 * @return ofcCd1
	 */
	public String getOfcCd1() {
		return this.ofcCd1;
	}
	
	/**
	 * Column Info
	 * @return ofcLvlDesc
	 */
	public String getOfcLvlDesc() {
		return this.ofcLvlDesc;
	}
	
	/**
	 * Column Info
	 * @return ofcLvl
	 */
	public String getOfcLvl() {
		return this.ofcLvl;
	}
	
	/**
	 * Column Info
	 * @return pfitDflt
	 */
	public String getPfitDflt() {
		return this.pfitDflt;
	}
	
	/**
	 * Column Info
	 * @return pfitCd1
	 */
	public String getPfitCd1() {
		return this.pfitCd1;
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
	 * @return lvlDflt
	 */
	public String getLvlDflt() {
		return this.lvlDflt;
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
	 * @return pfitCd2
	 */
	public String getPfitCd2() {
		return this.pfitCd2;
	}
	
	/**
	 * Column Info
	 * @return lvlCd1
	 */
	public String getLvlCd1() {
		return this.lvlCd1;
	}
	
	/**
	 * Column Info
	 * @return lvlCd2
	 */
	public String getLvlCd2() {
		return this.lvlCd2;
	}
	
	/**
	 * Column Info
	 * @return rptSeq
	 */
	public String getRptSeq() {
		return this.rptSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcDflt
	 */
	public String getOfcDflt() {
		return this.ofcDflt;
	}
	

	/**
	 * Column Info
	 * @param ofcCd2
	 */
	public void setOfcCd2(String ofcCd2) {
		this.ofcCd2 = ofcCd2;
	}
	
	/**
	 * Column Info
	 * @param ofcCd1
	 */
	public void setOfcCd1(String ofcCd1) {
		this.ofcCd1 = ofcCd1;
	}
	
	/**
	 * Column Info
	 * @param ofcLvlDesc
	 */
	public void setOfcLvlDesc(String ofcLvlDesc) {
		this.ofcLvlDesc = ofcLvlDesc;
	}
	
	/**
	 * Column Info
	 * @param ofcLvl
	 */
	public void setOfcLvl(String ofcLvl) {
		this.ofcLvl = ofcLvl;
	}
	
	/**
	 * Column Info
	 * @param pfitDflt
	 */
	public void setPfitDflt(String pfitDflt) {
		this.pfitDflt = pfitDflt;
	}
	
	/**
	 * Column Info
	 * @param pfitCd1
	 */
	public void setPfitCd1(String pfitCd1) {
		this.pfitCd1 = pfitCd1;
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
	 * @param lvlDflt
	 */
	public void setLvlDflt(String lvlDflt) {
		this.lvlDflt = lvlDflt;
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
	 * @param pfitCd2
	 */
	public void setPfitCd2(String pfitCd2) {
		this.pfitCd2 = pfitCd2;
	}
	
	/**
	 * Column Info
	 * @param lvlCd1
	 */
	public void setLvlCd1(String lvlCd1) {
		this.lvlCd1 = lvlCd1;
	}
	
	/**
	 * Column Info
	 * @param lvlCd2
	 */
	public void setLvlCd2(String lvlCd2) {
		this.lvlCd2 = lvlCd2;
	}
	
	/**
	 * Column Info
	 * @param rptSeq
	 */
	public void setRptSeq(String rptSeq) {
		this.rptSeq = rptSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcDflt
	 */
	public void setOfcDflt(String ofcDflt) {
		this.ofcDflt = ofcDflt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcCd2(JSPUtil.getParameter(request, "ofc_cd2", ""));
		setOfcCd1(JSPUtil.getParameter(request, "ofc_cd1", ""));
		setOfcLvlDesc(JSPUtil.getParameter(request, "ofc_lvl_desc", ""));
		setOfcLvl(JSPUtil.getParameter(request, "ofc_lvl", ""));
		setPfitDflt(JSPUtil.getParameter(request, "pfit_dflt", ""));
		setPfitCd1(JSPUtil.getParameter(request, "pfit_cd1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLvlDflt(JSPUtil.getParameter(request, "lvl_dflt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPfitCd2(JSPUtil.getParameter(request, "pfit_cd2", ""));
		setLvlCd1(JSPUtil.getParameter(request, "lvl_cd1", ""));
		setLvlCd2(JSPUtil.getParameter(request, "lvl_cd2", ""));
		setRptSeq(JSPUtil.getParameter(request, "rpt_seq", ""));
		setOfcDflt(JSPUtil.getParameter(request, "ofc_dflt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchReportViewListVO[]
	 */
	public SearchReportViewListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchReportViewListVO[]
	 */
	public SearchReportViewListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchReportViewListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd2 = (JSPUtil.getParameter(request, prefix	+ "ofc_cd2", length));
			String[] ofcCd1 = (JSPUtil.getParameter(request, prefix	+ "ofc_cd1", length));
			String[] ofcLvlDesc = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl_desc", length));
			String[] ofcLvl = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl", length));
			String[] pfitDflt = (JSPUtil.getParameter(request, prefix	+ "pfit_dflt", length));
			String[] pfitCd1 = (JSPUtil.getParameter(request, prefix	+ "pfit_cd1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lvlDflt = (JSPUtil.getParameter(request, prefix	+ "lvl_dflt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfitCd2 = (JSPUtil.getParameter(request, prefix	+ "pfit_cd2", length));
			String[] lvlCd1 = (JSPUtil.getParameter(request, prefix	+ "lvl_cd1", length));
			String[] lvlCd2 = (JSPUtil.getParameter(request, prefix	+ "lvl_cd2", length));
			String[] rptSeq = (JSPUtil.getParameter(request, prefix	+ "rpt_seq", length));
			String[] ofcDflt = (JSPUtil.getParameter(request, prefix	+ "ofc_dflt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchReportViewListVO();
				if (ofcCd2[i] != null)
					model.setOfcCd2(ofcCd2[i]);
				if (ofcCd1[i] != null)
					model.setOfcCd1(ofcCd1[i]);
				if (ofcLvlDesc[i] != null)
					model.setOfcLvlDesc(ofcLvlDesc[i]);
				if (ofcLvl[i] != null)
					model.setOfcLvl(ofcLvl[i]);
				if (pfitDflt[i] != null)
					model.setPfitDflt(pfitDflt[i]);
				if (pfitCd1[i] != null)
					model.setPfitCd1(pfitCd1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lvlDflt[i] != null)
					model.setLvlDflt(lvlDflt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfitCd2[i] != null)
					model.setPfitCd2(pfitCd2[i]);
				if (lvlCd1[i] != null)
					model.setLvlCd1(lvlCd1[i]);
				if (lvlCd2[i] != null)
					model.setLvlCd2(lvlCd2[i]);
				if (rptSeq[i] != null)
					model.setRptSeq(rptSeq[i]);
				if (ofcDflt[i] != null)
					model.setOfcDflt(ofcDflt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchReportViewListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchReportViewListVO[]
	 */
	public SearchReportViewListVO[] getSearchReportViewListVOs(){
		SearchReportViewListVO[] vos = (SearchReportViewListVO[])models.toArray(new SearchReportViewListVO[models.size()]);
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
		this.ofcCd2 = this.ofcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd1 = this.ofcCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvlDesc = this.ofcLvlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl = this.ofcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfitDflt = this.pfitDflt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfitCd1 = this.pfitCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvlDflt = this.lvlDflt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfitCd2 = this.pfitCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvlCd1 = this.lvlCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvlCd2 = this.lvlCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptSeq = this.rptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcDflt = this.ofcDflt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
