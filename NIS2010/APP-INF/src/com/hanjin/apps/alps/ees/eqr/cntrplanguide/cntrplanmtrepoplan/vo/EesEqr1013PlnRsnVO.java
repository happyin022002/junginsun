/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1013PlnRsnVO.java
*@FileTitle : EesEqr1013PlnRsnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo;

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

public class EesEqr1013PlnRsnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1013PlnRsnVO> models = new ArrayList<EesEqr1013PlnRsnVO>();
	
	/* Column Info */
	private String plnRsnSubNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String plnRsnHdrText = null;
	/* Column Info */
	private String plnRsnHdrCode = null;
	/* Column Info */
	private String plnRsnHdrNm = null;
	/* Column Info */
	private String plnRsnSubCd = null;
	/* Column Info */
	private String plnRsnHdrCd = null;
	/* Column Info */
	private String plnRsnSubCode = null;
	/* Column Info */
	private String plnRsnSubText = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1013PlnRsnVO() {}

	public EesEqr1013PlnRsnVO(String ibflag, String pagerows, String plnRsnHdrCd, String plnRsnHdrNm, String plnRsnHdrCode, String plnRsnHdrText, String plnRsnSubCd, String plnRsnSubNm, String plnRsnSubText, String plnRsnSubCode) {
		this.plnRsnSubNm = plnRsnSubNm;
		this.ibflag = ibflag;
		this.plnRsnHdrText = plnRsnHdrText;
		this.plnRsnHdrCode = plnRsnHdrCode;
		this.plnRsnHdrNm = plnRsnHdrNm;
		this.plnRsnSubCd = plnRsnSubCd;
		this.plnRsnHdrCd = plnRsnHdrCd;
		this.plnRsnSubCode = plnRsnSubCode;
		this.plnRsnSubText = plnRsnSubText;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pln_rsn_sub_nm", getPlnRsnSubNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pln_rsn_hdr_text", getPlnRsnHdrText());
		this.hashColumns.put("pln_rsn_hdr_code", getPlnRsnHdrCode());
		this.hashColumns.put("pln_rsn_hdr_nm", getPlnRsnHdrNm());
		this.hashColumns.put("pln_rsn_sub_cd", getPlnRsnSubCd());
		this.hashColumns.put("pln_rsn_hdr_cd", getPlnRsnHdrCd());
		this.hashColumns.put("pln_rsn_sub_code", getPlnRsnSubCode());
		this.hashColumns.put("pln_rsn_sub_text", getPlnRsnSubText());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pln_rsn_sub_nm", "plnRsnSubNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pln_rsn_hdr_text", "plnRsnHdrText");
		this.hashFields.put("pln_rsn_hdr_code", "plnRsnHdrCode");
		this.hashFields.put("pln_rsn_hdr_nm", "plnRsnHdrNm");
		this.hashFields.put("pln_rsn_sub_cd", "plnRsnSubCd");
		this.hashFields.put("pln_rsn_hdr_cd", "plnRsnHdrCd");
		this.hashFields.put("pln_rsn_sub_code", "plnRsnSubCode");
		this.hashFields.put("pln_rsn_sub_text", "plnRsnSubText");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return plnRsnSubNm
	 */
	public String getPlnRsnSubNm() {
		return this.plnRsnSubNm;
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
	 * @return plnRsnHdrText
	 */
	public String getPlnRsnHdrText() {
		return this.plnRsnHdrText;
	}
	
	/**
	 * Column Info
	 * @return plnRsnHdrCode
	 */
	public String getPlnRsnHdrCode() {
		return this.plnRsnHdrCode;
	}
	
	/**
	 * Column Info
	 * @return plnRsnHdrNm
	 */
	public String getPlnRsnHdrNm() {
		return this.plnRsnHdrNm;
	}
	
	/**
	 * Column Info
	 * @return plnRsnSubCd
	 */
	public String getPlnRsnSubCd() {
		return this.plnRsnSubCd;
	}
	
	/**
	 * Column Info
	 * @return plnRsnHdrCd
	 */
	public String getPlnRsnHdrCd() {
		return this.plnRsnHdrCd;
	}
	
	/**
	 * Column Info
	 * @return plnRsnSubCode
	 */
	public String getPlnRsnSubCode() {
		return this.plnRsnSubCode;
	}
	
	/**
	 * Column Info
	 * @return plnRsnSubText
	 */
	public String getPlnRsnSubText() {
		return this.plnRsnSubText;
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
	 * @param plnRsnSubNm
	 */
	public void setPlnRsnSubNm(String plnRsnSubNm) {
		this.plnRsnSubNm = plnRsnSubNm;
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
	 * @param plnRsnHdrText
	 */
	public void setPlnRsnHdrText(String plnRsnHdrText) {
		this.plnRsnHdrText = plnRsnHdrText;
	}
	
	/**
	 * Column Info
	 * @param plnRsnHdrCode
	 */
	public void setPlnRsnHdrCode(String plnRsnHdrCode) {
		this.plnRsnHdrCode = plnRsnHdrCode;
	}
	
	/**
	 * Column Info
	 * @param plnRsnHdrNm
	 */
	public void setPlnRsnHdrNm(String plnRsnHdrNm) {
		this.plnRsnHdrNm = plnRsnHdrNm;
	}
	
	/**
	 * Column Info
	 * @param plnRsnSubCd
	 */
	public void setPlnRsnSubCd(String plnRsnSubCd) {
		this.plnRsnSubCd = plnRsnSubCd;
	}
	
	/**
	 * Column Info
	 * @param plnRsnHdrCd
	 */
	public void setPlnRsnHdrCd(String plnRsnHdrCd) {
		this.plnRsnHdrCd = plnRsnHdrCd;
	}
	
	/**
	 * Column Info
	 * @param plnRsnSubCode
	 */
	public void setPlnRsnSubCode(String plnRsnSubCode) {
		this.plnRsnSubCode = plnRsnSubCode;
	}
	
	/**
	 * Column Info
	 * @param plnRsnSubText
	 */
	public void setPlnRsnSubText(String plnRsnSubText) {
		this.plnRsnSubText = plnRsnSubText;
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
		setPlnRsnSubNm(JSPUtil.getParameter(request, prefix + "pln_rsn_sub_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPlnRsnHdrText(JSPUtil.getParameter(request, prefix + "pln_rsn_hdr_text", ""));
		setPlnRsnHdrCode(JSPUtil.getParameter(request, prefix + "pln_rsn_hdr_code", ""));
		setPlnRsnHdrNm(JSPUtil.getParameter(request, prefix + "pln_rsn_hdr_nm", ""));
		setPlnRsnSubCd(JSPUtil.getParameter(request, prefix + "pln_rsn_sub_cd", ""));
		setPlnRsnHdrCd(JSPUtil.getParameter(request, prefix + "pln_rsn_hdr_cd", ""));
		setPlnRsnSubCode(JSPUtil.getParameter(request, prefix + "pln_rsn_sub_code", ""));
		setPlnRsnSubText(JSPUtil.getParameter(request, prefix + "pln_rsn_sub_text", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1013PlnRsnVO[]
	 */
	public EesEqr1013PlnRsnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1013PlnRsnVO[]
	 */
	public EesEqr1013PlnRsnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1013PlnRsnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] plnRsnSubNm = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_sub_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] plnRsnHdrText = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_hdr_text", length));
			String[] plnRsnHdrCode = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_hdr_code", length));
			String[] plnRsnHdrNm = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_hdr_nm", length));
			String[] plnRsnSubCd = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_sub_cd", length));
			String[] plnRsnHdrCd = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_hdr_cd", length));
			String[] plnRsnSubCode = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_sub_code", length));
			String[] plnRsnSubText = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_sub_text", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1013PlnRsnVO();
				if (plnRsnSubNm[i] != null)
					model.setPlnRsnSubNm(plnRsnSubNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (plnRsnHdrText[i] != null)
					model.setPlnRsnHdrText(plnRsnHdrText[i]);
				if (plnRsnHdrCode[i] != null)
					model.setPlnRsnHdrCode(plnRsnHdrCode[i]);
				if (plnRsnHdrNm[i] != null)
					model.setPlnRsnHdrNm(plnRsnHdrNm[i]);
				if (plnRsnSubCd[i] != null)
					model.setPlnRsnSubCd(plnRsnSubCd[i]);
				if (plnRsnHdrCd[i] != null)
					model.setPlnRsnHdrCd(plnRsnHdrCd[i]);
				if (plnRsnSubCode[i] != null)
					model.setPlnRsnSubCode(plnRsnSubCode[i]);
				if (plnRsnSubText[i] != null)
					model.setPlnRsnSubText(plnRsnSubText[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1013PlnRsnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1013PlnRsnVO[]
	 */
	public EesEqr1013PlnRsnVO[] getEesEqr1013PlnRsnVOs(){
		EesEqr1013PlnRsnVO[] vos = (EesEqr1013PlnRsnVO[])models.toArray(new EesEqr1013PlnRsnVO[models.size()]);
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
		this.plnRsnSubNm = this.plnRsnSubNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnHdrText = this.plnRsnHdrText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnHdrCode = this.plnRsnHdrCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnHdrNm = this.plnRsnHdrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnSubCd = this.plnRsnSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnHdrCd = this.plnRsnHdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnSubCode = this.plnRsnSubCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnSubText = this.plnRsnSubText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
