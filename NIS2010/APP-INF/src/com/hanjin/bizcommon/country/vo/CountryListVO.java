/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CountryListVO.java
*@FileTitle : CountryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.06
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.07.06 함대성 
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.country.vo;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CountryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CountryListVO> models = new ArrayList<CountryListVO>();
	
	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String cntNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String contiNm = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String scontiCd = null;
	/* Column Info */
	private String eu_cnt_flg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CountryListVO() {}

	public CountryListVO(String ibflag, String pagerows, String cntCd, String cntNm, String contiCd, String contiNm, String scontiCd, String scontiNm, String eu_cnt_flg) {
		this.scontiNm = scontiNm;
		this.contiCd = contiCd;
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.contiNm = contiNm;
		this.cntCd = cntCd;
		this.scontiCd = scontiCd;
		this.eu_cnt_flg = eu_cnt_flg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("conti_nm", getContiNm());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("eu_cnt_flg", getEu_cnt_flg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	public String getEu_cnt_flg() {
		return eu_cnt_flg;
	}

	public void setEu_cnt_flg(String eu_cnt_flg) {
		this.eu_cnt_flg = eu_cnt_flg;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("conti_nm", "contiNm");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("eu_cnt_flg", "eu_cnt_flg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scontiNm
	 */
	public String getScontiNm() {
		return this.scontiNm;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return contiNm
	 */
	public String getContiNm() {
		return this.contiNm;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
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
	 * @param scontiNm
	 */
	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param contiNm
	 */
	public void setContiNm(String contiNm) {
		this.contiNm = contiNm;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
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
		setScontiNm(JSPUtil.getParameter(request, prefix + "sconti_nm", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setContiNm(JSPUtil.getParameter(request, prefix + "conti_nm", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
		setEu_cnt_flg(JSPUtil.getParameter(request, prefix + "eu_cnt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CountryListVO[]
	 */
	public CountryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CountryListVO[]
	 */
	public CountryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CountryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scontiNm = (JSPUtil.getParameter(request, prefix	+ "sconti_nm", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] contiNm = (JSPUtil.getParameter(request, prefix	+ "conti_nm", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			String[] eu_cnt_flg = (JSPUtil.getParameter(request, prefix	+ "eu_cnt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CountryListVO();
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (contiNm[i] != null)
					model.setContiNm(contiNm[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (eu_cnt_flg[i] != null)
					model.setScontiCd(eu_cnt_flg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCountryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CountryListVO[]
	 */
	public CountryListVO[] getCountryListVOs(){
		CountryListVO[] vos = (CountryListVO[])models.toArray(new CountryListVO[models.size()]);
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
		this.scontiNm = this.scontiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiNm = this.contiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eu_cnt_flg = this.eu_cnt_flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
