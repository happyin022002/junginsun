/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorVslVO.java
*@FileTitle : KorVslVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.12 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorVslVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorVslVO> models = new ArrayList<KorVslVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String inYear = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslCallSign = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String vslEngNm2 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorVslVO() {}

	public KorVslVO(String ibflag, String pagerows, String vslFlag, String vslEngNm, String vslCallSign, String inYear, String vslEngNm2, String vvd) {
		this.vvd = vvd;
		this.inYear = inYear;
		this.ibflag = ibflag;
		this.vslCallSign = vslCallSign;
		this.vslEngNm = vslEngNm;
		this.vslFlag = vslFlag;
		this.vslEngNm2 = vslEngNm2;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("in_year", getInYear());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_call_sign", getVslCallSign());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("vsl_eng_nm2", getVslEngNm2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("in_year", "inYear");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_call_sign", "vslCallSign");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("vsl_eng_nm2", "vslEngNm2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return inYear
	 */
	public String getInYear() {
		return this.inYear;
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
	 * @return vslCallSign
	 */
	public String getVslCallSign() {
		return this.vslCallSign;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm2
	 */
	public String getVslEngNm2() {
		return this.vslEngNm2;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param inYear
	 */
	public void setInYear(String inYear) {
		this.inYear = inYear;
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
	 * @param vslCallSign
	 */
	public void setVslCallSign(String vslCallSign) {
		this.vslCallSign = vslCallSign;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm2
	 */
	public void setVslEngNm2(String vslEngNm2) {
		this.vslEngNm2 = vslEngNm2;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setInYear(JSPUtil.getParameter(request, "in_year", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslCallSign(JSPUtil.getParameter(request, "vsl_call_sign", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setVslFlag(JSPUtil.getParameter(request, "vsl_flag", ""));
		setVslEngNm2(JSPUtil.getParameter(request, "vsl_eng_nm2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorVslVO[]
	 */
	public KorVslVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorVslVO[]
	 */
	public KorVslVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorVslVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] inYear = (JSPUtil.getParameter(request, prefix	+ "in_year", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslCallSign = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sign", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] vslEngNm2 = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorVslVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (inYear[i] != null)
					model.setInYear(inYear[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCallSign[i] != null)
					model.setVslCallSign(vslCallSign[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (vslEngNm2[i] != null)
					model.setVslEngNm2(vslEngNm2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorVslVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorVslVO[]
	 */
	public KorVslVO[] getKorVslVOs(){
		KorVslVO[] vos = (KorVslVO[])models.toArray(new KorVslVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inYear = this.inYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSign = this.vslCallSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm2 = this.vslEngNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
