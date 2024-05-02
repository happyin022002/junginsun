/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchSimilarVendorNameVO.java
*@FileTitle : SearchSimilarVendorNameVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2012.02.22 김종호 
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo;

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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimilarVendorNameVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimilarVendorNameVO> models = new ArrayList<SearchSimilarVendorNameVO>();
	
	/* Column Info */
	private String office = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String word1 = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String word2 = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String matchRule = null;
	/* Column Info */
	private String vndrCntCd = null;

	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimilarVendorNameVO() {}

	public SearchSimilarVendorNameVO(String ibflag, String pagerows, String code, String name, String location, String office, String word1, String word2, String matchRule, String vndrCntCd) {
		this.office = office;
		this.ibflag = ibflag;
		this.location = location;
		this.word1 = word1;
		this.name = name;
		this.word2 = word2;
		this.code = code;
		this.matchRule = matchRule;
		this.vndrCntCd = vndrCntCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("word1", getWord1());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("word2", getWord2());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("match_rule", getCode());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("location", "location");
		this.hashFields.put("word1", "word1");
		this.hashFields.put("name", "name");
		this.hashFields.put("word2", "word2");
		this.hashFields.put("code", "code");
		this.hashFields.put("match_rule", "matchRule");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
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
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return word1
	 */
	public String getWord1() {
		return this.word1;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return word2
	 */
	public String getWord2() {
		return this.word2;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getMatchRule() {
		return matchRule;
	}


	public String getVndrCntCd() {
		return vndrCntCd;
	}


	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
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
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param word1
	 */
	public void setWord1(String word1) {
		this.word1 = word1;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param word2
	 */
	public void setWord2(String word2) {
		this.word2 = word2;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setMatchRule(String matchRule) {
		this.matchRule = matchRule;
	}

	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocation(JSPUtil.getParameter(request, prefix + "location", ""));
		setWord1(JSPUtil.getParameter(request, prefix + "word1", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setWord2(JSPUtil.getParameter(request, prefix + "word2", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setCode(JSPUtil.getParameter(request, prefix + "match_rule", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimilarVendorNameVO[]
	 */
	public SearchSimilarVendorNameVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimilarVendorNameVO[]
	 */
	public SearchSimilarVendorNameVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimilarVendorNameVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] word1 = (JSPUtil.getParameter(request, prefix	+ "word1", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] word2 = (JSPUtil.getParameter(request, prefix	+ "word2", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] matchRule = (JSPUtil.getParameter(request, prefix	+ "match_rule", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimilarVendorNameVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (word1[i] != null)
					model.setWord1(word1[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (word2[i] != null)
					model.setWord2(word2[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (matchRule[i] != null)
					model.setMatchRule(matchRule[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimilarVendorNameVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimilarVendorNameVO[]
	 */
	public SearchSimilarVendorNameVO[] getSearchSimilarVendorNameVOs(){
		SearchSimilarVendorNameVO[] vos = (SearchSimilarVendorNameVO[])models.toArray(new SearchSimilarVendorNameVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.word1 = this.word1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.word2 = this.word2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchRule = this.matchRule .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
