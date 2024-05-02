/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorImpPrtVslNmVO.java
*@FileTitle : KorImpPrtVslNmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.05 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorImpPrtVslNmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorImpPrtVslNmVO> models = new ArrayList<KorImpPrtVslNmVO>();

	/* Column Info */
	private String cntNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorImpPrtVslNmVO() {}

	public KorImpPrtVslNmVO(String ibflag, String pagerows, String vslEngNm, String callSgnNo, String vslRgstCntCd, String cntNm) {
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.vslRgstCntCd = vslRgstCntCd;
		this.vslEngNm = vslEngNm;
		this.callSgnNo = callSgnNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
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
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
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
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
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
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
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
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorImpPrtVslNmVO[]
	 */
	public KorImpPrtVslNmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorImpPrtVslNmVO[]
	 */
	public KorImpPrtVslNmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorImpPrtVslNmVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorImpPrtVslNmVO();
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorImpPrtVslNmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorImpPrtVslNmVO[]
	 */
	public KorImpPrtVslNmVO[] getKorImpPrtVslNmVOs(){
		KorImpPrtVslNmVO[] vos = (KorImpPrtVslNmVO[])models.toArray(new KorImpPrtVslNmVO[models.size()]);
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
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
