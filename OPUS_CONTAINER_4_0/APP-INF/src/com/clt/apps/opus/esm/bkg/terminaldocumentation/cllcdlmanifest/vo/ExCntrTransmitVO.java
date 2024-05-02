/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExCntrTransmitVO.java
*@FileTitle : ExCntrTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier :
*@LastVersion : 1.0
* 2010.03.26
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

public class ExCntrTransmitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ExCntrTransmitVO> models = new ArrayList<ExCntrTransmitVO>();

	/* Column Info */
	private String nykVvd = null;
	/* Column Info */
	private String termPol = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String nykPol = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String termPod = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String nykPod = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String tmnlBrthCd = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String termVvd = null;
	/* Column Info */
	private String fwrdAgnCd = null;
	/* Column Info */
	private String haulMode = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ExCntrTransmitVO() {}

	public ExCntrTransmitVO(String ibflag, String pagerows, String bkgNo, String termPol, String termPod, String nykVvd, String nykPol, String nykPod, String tmnlBrthCd, String cntrType, String cntrSize, String cntrQty, String grsWgt, String termVvd, String fwrdAgnCd, String haulMode) {
		this.nykVvd = nykVvd;
		this.termPol = termPol;
		this.pagerows = pagerows;
		this.cntrType = cntrType;
		this.nykPol = nykPol;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.termPod = termPod;
		this.cntrSize = cntrSize;
		this.nykPod = nykPod;
		this.cntrQty = cntrQty;
		this.tmnlBrthCd = tmnlBrthCd;
		this.grsWgt = grsWgt;
		this.termVvd = termVvd;
		this.fwrdAgnCd = fwrdAgnCd;
		this.haulMode = haulMode;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("nyk_vvd", getNykVvd());
		this.hashColumns.put("term_pol", getTermPol());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("nyk_pol", getNykPol());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("term_pod", getTermPod());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("nyk_pod", getNykPod());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("tmnl_brth_cd", getTmnlBrthCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("term_vvd", getTermVvd());
		this.hashColumns.put("fwrd_agn_cd", getFwrdAgnCd());
		this.hashColumns.put("haul_mode", getHaulMode());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("nyk_vvd", "nykVvd");
		this.hashFields.put("term_pol", "termPol");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("nyk_pol", "nykPol");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("term_pod", "termPod");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("nyk_pod", "nykPod");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("tmnl_brth_cd", "tmnlBrthCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("term_vvd", "termVvd");
		this.hashFields.put("fwrd_agn_cd", "fwrdAgnCd");
		this.hashFields.put("haul_mode", "haulMode");

		return this.hashFields;
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
	 * @return termPol
	 */
	public String getTermPol() {
		return this.termPol;
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
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cntrSize
	 */
	public String getCntrSize() {
		return this.cntrSize;
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
	 * @param nykVvd
	 */
	public void setNykVvd(String nykVvd) {
		this.nykVvd = nykVvd;
	}

	/**
	 * Column Info
	 * @param termPol
	 */
	public void setTermPol(String termPol) {
		this.termPol = termPol;
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
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cntrSize
	 */
	public void setCntrSize(String cntrSize) {
		this.cntrSize = cntrSize;
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

	public String getTermVvd() {
		return termVvd;
	}

	public void setTermVvd(String termVvd) {
		this.termVvd = termVvd;
	}

	public String getFwrdAgnCd() {
		return fwrdAgnCd;
	}

	public void setFwrdAgnCd(String fwrdAgnCd) {
		this.fwrdAgnCd = fwrdAgnCd;
	}

	public String getHaulMode() {
		return haulMode;
	}

	public void setHaulMode(String haulMode) {
		this.haulMode = haulMode;
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
		setNykVvd(JSPUtil.getParameter(request, prefix + "nyk_vvd", ""));
		setTermPol(JSPUtil.getParameter(request, prefix + "term_pol", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setNykPol(JSPUtil.getParameter(request, prefix + "nyk_pol", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTermPod(JSPUtil.getParameter(request, prefix + "term_pod", ""));
		setCntrSize(JSPUtil.getParameter(request, prefix + "cntr_size", ""));
		setNykPod(JSPUtil.getParameter(request, prefix + "nyk_pod", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setTmnlBrthCd(JSPUtil.getParameter(request, prefix + "tmnl_brth_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setTermVvd(JSPUtil.getParameter(request, prefix + "term_vvd", ""));
		setFwrdAgnCd(JSPUtil.getParameter(request, prefix + "fwrd_agn_cd", ""));
		setHaulMode(JSPUtil.getParameter(request, prefix + "haul_mode", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExCntrTransmitVO[]
	 */
	public ExCntrTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ExCntrTransmitVO[]
	 */
	public ExCntrTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExCntrTransmitVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] nykVvd = (JSPUtil.getParameter(request, prefix	+ "nyk_vvd", length));
			String[] termPol = (JSPUtil.getParameter(request, prefix	+ "term_pol", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] nykPol = (JSPUtil.getParameter(request, prefix	+ "nyk_pol", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] termPod = (JSPUtil.getParameter(request, prefix	+ "term_pod", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] nykPod = (JSPUtil.getParameter(request, prefix	+ "nyk_pod", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] tmnlBrthCd = (JSPUtil.getParameter(request, prefix	+ "tmnl_brth_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] termVvd = (JSPUtil.getParameter(request, prefix	+ "term_vvd", length));
			String[] fwrdAgnCd = (JSPUtil.getParameter(request, prefix	+ "fwrd_agn_cd", length));
			String[] haulMode = (JSPUtil.getParameter(request, prefix	+ "haul_mode", length));

			for (int i = 0; i < length; i++) {
				model = new ExCntrTransmitVO();
				if (nykVvd[i] != null)
					model.setNykVvd(nykVvd[i]);
				if (termPol[i] != null)
					model.setTermPol(termPol[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (nykPol[i] != null)
					model.setNykPol(nykPol[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (termPod[i] != null)
					model.setTermPod(termPod[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (nykPod[i] != null)
					model.setNykPod(nykPod[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (tmnlBrthCd[i] != null)
					model.setTmnlBrthCd(tmnlBrthCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (termVvd[i] != null)
					model.setTermVvd(termVvd[i]);
				if (fwrdAgnCd[i] != null)
					model.setFwrdAgnCd(fwrdAgnCd[i]);
				if (haulMode[i] != null)
					model.setHaulMode(haulMode[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExCntrTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExCntrTransmitVO[]
	 */
	public ExCntrTransmitVO[] getExCntrTransmitVOs(){
		ExCntrTransmitVO[] vos = (ExCntrTransmitVO[])models.toArray(new ExCntrTransmitVO[models.size()]);
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
		this.nykVvd = this.nykVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termPol = this.termPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nykPol = this.nykPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termPod = this.termPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nykPod = this.nykPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlBrthCd = this.tmnlBrthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termVvd = this.termVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdAgnCd = this.fwrdAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulMode = this.haulMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
