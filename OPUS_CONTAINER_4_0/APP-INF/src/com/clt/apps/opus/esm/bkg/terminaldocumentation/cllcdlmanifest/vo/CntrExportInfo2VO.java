/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrExportInfo2VO.java
*@FileTitle : CntrExportInfo2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier :
*@LastVersion : 1.0
* 2010.03.25
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrExportInfo2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CntrExportInfo2VO> models = new ArrayList<CntrExportInfo2VO>();

	/* Column Info */
	private String nykPol = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String termPod = null;
	/* Column Info */
	private String nykVvd = null;
	/* Column Info */
	private String nykPod = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String termPol = null;
	/* Column Info */
	private String tmnlBrthCd = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String cntrType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CntrExportInfo2VO() {}

	public CntrExportInfo2VO(String ibflag, String pagerows, String termPol, String termPod, String nykVvd, String nykPol, String nykPod, String tmnlBrthCd, String cntrType, String cntrSize, String cntrQty, String grsWgt) {
		this.nykPol = nykPol;
		this.ibflag = ibflag;
		this.cntrSize = cntrSize;
		this.termPod = termPod;
		this.nykVvd = nykVvd;
		this.nykPod = nykPod;
		this.cntrQty = cntrQty;
		this.termPol = termPol;
		this.tmnlBrthCd = tmnlBrthCd;
		this.grsWgt = grsWgt;
		this.cntrType = cntrType;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("nyk_pol", getNykPol());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("term_pod", getTermPod());
		this.hashColumns.put("nyk_vvd", getNykVvd());
		this.hashColumns.put("nyk_pod", getNykPod());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("term_pol", getTermPol());
		this.hashColumns.put("tmnl_brth_cd", getTmnlBrthCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("nyk_pol", "nykPol");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("term_pod", "termPod");
		this.hashFields.put("nyk_vvd", "nykVvd");
		this.hashFields.put("nyk_pod", "nykPod");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("term_pol", "termPol");
		this.hashFields.put("tmnl_brth_cd", "tmnlBrthCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return nykPol
	 */
	public String getNykPol() {
		return this.nykPol;
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
	 * @return cntrSize
	 */
	public String getCntrSize() {
		return this.cntrSize;
	}

	/**
	 * Column Info
	 * @return termPod
	 */
	public String getTermPod() {
		return this.termPod;
	}

	/**
	 * Column Info
	 * @return nykVvd
	 */
	public String getNykVvd() {
		return this.nykVvd;
	}

	/**
	 * Column Info
	 * @return nykPod
	 */
	public String getNykPod() {
		return this.nykPod;
	}

	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}

	/**
	 * Column Info
	 * @return termPol
	 */
	public String getTermPol() {
		return this.termPol;
	}

	/**
	 * Column Info
	 * @return tmnlBrthCd
	 */
	public String getTmnlBrthCd() {
		return this.tmnlBrthCd;
	}

	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}

	/**
	 * Column Info
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @param nykPol
	 */
	public void setNykPol(String nykPol) {
		this.nykPol = nykPol;
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
	 * @param cntrSize
	 */
	public void setCntrSize(String cntrSize) {
		this.cntrSize = cntrSize;
	}

	/**
	 * Column Info
	 * @param termPod
	 */
	public void setTermPod(String termPod) {
		this.termPod = termPod;
	}

	/**
	 * Column Info
	 * @param nykVvd
	 */
	public void setNykVvd(String nykVvd) {
		this.nykVvd = nykVvd;
	}

	/**
	 * Column Info
	 * @param nykPod
	 */
	public void setNykPod(String nykPod) {
		this.nykPod = nykPod;
	}

	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}

	/**
	 * Column Info
	 * @param termPol
	 */
	public void setTermPol(String termPol) {
		this.termPol = termPol;
	}

	/**
	 * Column Info
	 * @param tmnlBrthCd
	 */
	public void setTmnlBrthCd(String tmnlBrthCd) {
		this.tmnlBrthCd = tmnlBrthCd;
	}

	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}

	/**
	 * Column Info
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
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
		setNykPol(JSPUtil.getParameter(request, prefix + "nyk_pol", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrSize(JSPUtil.getParameter(request, prefix + "cntr_size", ""));
		setTermPod(JSPUtil.getParameter(request, prefix + "term_pod", ""));
		setNykVvd(JSPUtil.getParameter(request, prefix + "nyk_vvd", ""));
		setNykPod(JSPUtil.getParameter(request, prefix + "nyk_pod", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setTermPol(JSPUtil.getParameter(request, prefix + "term_pol", ""));
		setTmnlBrthCd(JSPUtil.getParameter(request, prefix + "tmnl_brth_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrExportInfo2VO[]
	 */
	public CntrExportInfo2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CntrExportInfo2VO[]
	 */
	public CntrExportInfo2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrExportInfo2VO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] nykPol = (JSPUtil.getParameter(request, prefix	+ "nyk_pol", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] termPod = (JSPUtil.getParameter(request, prefix	+ "term_pod", length));
			String[] nykVvd = (JSPUtil.getParameter(request, prefix	+ "nyk_vvd", length));
			String[] nykPod = (JSPUtil.getParameter(request, prefix	+ "nyk_pod", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] termPol = (JSPUtil.getParameter(request, prefix	+ "term_pol", length));
			String[] tmnlBrthCd = (JSPUtil.getParameter(request, prefix	+ "tmnl_brth_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CntrExportInfo2VO();
				if (nykPol[i] != null)
					model.setNykPol(nykPol[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (termPod[i] != null)
					model.setTermPod(termPod[i]);
				if (nykVvd[i] != null)
					model.setNykVvd(nykVvd[i]);
				if (nykPod[i] != null)
					model.setNykPod(nykPod[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (termPol[i] != null)
					model.setTermPol(termPol[i]);
				if (tmnlBrthCd[i] != null)
					model.setTmnlBrthCd(tmnlBrthCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrExportInfo2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrExportInfo2VO[]
	 */
	public CntrExportInfo2VO[] getCntrExportInfo2VOs(){
		CntrExportInfo2VO[] vos = (CntrExportInfo2VO[])models.toArray(new CntrExportInfo2VO[models.size()]);
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
		this.nykPol = this.nykPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termPod = this.termPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nykVvd = this.nykVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nykPod = this.nykPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termPol = this.termPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlBrthCd = this.tmnlBrthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
