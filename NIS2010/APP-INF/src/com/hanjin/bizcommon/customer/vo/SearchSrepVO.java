/*=========================================================
*Copyright(c) 2010 CyberLogitec

*@FileName : SearchCustomerVO.java
*@FileTitle : SearchCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.customer.vo;

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
public class SearchSrepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSrepVO> models = new ArrayList<SearchSrepVO>();
	
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String srepNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sexCd = null;
	/* Column Info */
	private String srepEml = null;
	/* Column Info */
	private String mphnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSrepVO() {}

	public SearchSrepVO(String ibflag, String pagerows, String srepCd, String srepNm, String ofcCd, String sexCd, String srepEml, String mphnNo) {
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.srepCd = srepCd;
		this.sexCd = sexCd;
		this.srepNm = srepNm;
		this.srepEml = srepEml;
		this.mphnNo = mphnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("sex_cd", getSexCd());
		this.hashColumns.put("srep_eml", getSrepEml());
		this.hashColumns.put("mphn_no", getMphnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("sex_cd", "sexCd");
		this.hashFields.put("srep_eml", "srepEml");
		this.hashFields.put("mphn_no", "mphnNo");
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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

	public String getSrepCd() {
		return srepCd;
	}

	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}

	public String getSrepNm() {
		return srepNm;
	}

	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}

	public String getSexCd() {
		return sexCd;
	}

	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}

	public String getSrepEml() {
		return srepEml;
	}

	public void setSrepEml(String srepEml) {
		this.srepEml = srepEml;
	}

	public String getMphnNo() {
		return mphnNo;
	}

	public void setMphnNo(String mphnNo) {
		this.mphnNo = mphnNo;
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
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setSexCd(JSPUtil.getParameter(request, prefix + "sex_cd", ""));
		setSrepEml(JSPUtil.getParameter(request, prefix + "srep_eml", ""));
		setMphnNo(JSPUtil.getParameter(request, prefix + "mphn_no", ""));
		

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerVO[]
	 */
	public SearchSrepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerVO[]
	 */
	public SearchSrepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSrepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] sexCd  = (JSPUtil.getParameter(request, prefix	+ "sex_cd", length));
			String[] srepEml = (JSPUtil.getParameter(request, prefix	+ "srep_eml", length));
			String[] mphnNo = (JSPUtil.getParameter(request, prefix	+ "mphn_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSrepVO();
				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (srepEml[i] != null)
					model.setSrepEml(srepEml[i]);
				if (sexCd[i] != null)
					model.setSexCd(sexCd[i]);
				if (mphnNo[i] != null)
					model.setMphnNo(mphnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSrepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerVO[]
	 */
	public SearchSrepVO[] getSearchSrepVOs(){
		SearchSrepVO[] vos = (SearchSrepVO[])models.toArray(new SearchSrepVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sexCd = this.sexCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepEml = this.srepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mphnNo = this.mphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
