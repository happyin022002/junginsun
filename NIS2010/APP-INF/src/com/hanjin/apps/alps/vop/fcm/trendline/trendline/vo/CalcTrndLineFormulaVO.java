/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CalcTrndLineFormulaVO.java
*@FileTitle : CalcTrndLineFormulaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.21 진마리아 
* 1.0 Creation
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CalcTrndLineFormulaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CalcTrndLineFormulaVO> models = new ArrayList<CalcTrndLineFormulaVO>();
	
	/* Column Info */
	private String trndLineTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String trndLineConsVal = null;
	/* Column Info */
	private String n2ndVarDgrVal = null;
	/* Column Info */
	private String n2ndCoefVal = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inVal = null;
	/* Column Info */
	private String outVal = null;
	/* Column Info */
	private String vslClssCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trndLineSeq = null;
	/* Column Info */
	private String n1stVarDgrVal = null;
	/* Column Info */
	private String trndLineChtTpCd = null;
	/* Column Info */
	private String trndLineUseTpCd = null;
	/* Column Info */
	private String vslClssSubCd = null;
	/* Column Info */
	private String trndLineTpSubCd = null;
	/* Column Info */
	private String coefOfDtmnVal = null;
	/* Column Info */
	private String n1stCoefVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CalcTrndLineFormulaVO() {}

	public CalcTrndLineFormulaVO(String ibflag, String pagerows, String trndLineSeq, String trndLineUseTpCd, String trndLineTpCd, String trndLineChtTpCd, String vslClssCd, String vslClssSubCd, String vslSlanCd, String vslCd, String skdDirCd, String trndLineTpSubCd, String n1stCoefVal, String n1stVarDgrVal, String n2ndCoefVal, String n2ndVarDgrVal, String trndLineConsVal, String coefOfDtmnVal, String inVal, String outVal) {
		this.trndLineTpCd = trndLineTpCd;
		this.vslCd = vslCd;
		this.trndLineConsVal = trndLineConsVal;
		this.n2ndVarDgrVal = n2ndVarDgrVal;
		this.n2ndCoefVal = n2ndCoefVal;
		this.vslSlanCd = vslSlanCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.inVal = inVal;
		this.outVal = outVal;
		this.vslClssCd = vslClssCd;
		this.ibflag = ibflag;
		this.trndLineSeq = trndLineSeq;
		this.n1stVarDgrVal = n1stVarDgrVal;
		this.trndLineChtTpCd = trndLineChtTpCd;
		this.trndLineUseTpCd = trndLineUseTpCd;
		this.vslClssSubCd = vslClssSubCd;
		this.trndLineTpSubCd = trndLineTpSubCd;
		this.coefOfDtmnVal = coefOfDtmnVal;
		this.n1stCoefVal = n1stCoefVal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trnd_line_tp_cd", getTrndLineTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("trnd_line_cons_val", getTrndLineConsVal());
		this.hashColumns.put("n2nd_var_dgr_val", getN2ndVarDgrVal());
		this.hashColumns.put("n2nd_coef_val", getN2ndCoefVal());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_val", getInVal());
		this.hashColumns.put("out_val", getOutVal());
		this.hashColumns.put("vsl_clss_cd", getVslClssCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trnd_line_seq", getTrndLineSeq());
		this.hashColumns.put("n1st_var_dgr_val", getN1stVarDgrVal());
		this.hashColumns.put("trnd_line_cht_tp_cd", getTrndLineChtTpCd());
		this.hashColumns.put("trnd_line_use_tp_cd", getTrndLineUseTpCd());
		this.hashColumns.put("vsl_clss_sub_cd", getVslClssSubCd());
		this.hashColumns.put("trnd_line_tp_sub_cd", getTrndLineTpSubCd());
		this.hashColumns.put("coef_of_dtmn_val", getCoefOfDtmnVal());
		this.hashColumns.put("n1st_coef_val", getN1stCoefVal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trnd_line_tp_cd", "trndLineTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("trnd_line_cons_val", "trndLineConsVal");
		this.hashFields.put("n2nd_var_dgr_val", "n2ndVarDgrVal");
		this.hashFields.put("n2nd_coef_val", "n2ndCoefVal");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_val", "inVal");
		this.hashFields.put("out_val", "outVal");
		this.hashFields.put("vsl_clss_cd", "vslClssCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trnd_line_seq", "trndLineSeq");
		this.hashFields.put("n1st_var_dgr_val", "n1stVarDgrVal");
		this.hashFields.put("trnd_line_cht_tp_cd", "trndLineChtTpCd");
		this.hashFields.put("trnd_line_use_tp_cd", "trndLineUseTpCd");
		this.hashFields.put("vsl_clss_sub_cd", "vslClssSubCd");
		this.hashFields.put("trnd_line_tp_sub_cd", "trndLineTpSubCd");
		this.hashFields.put("coef_of_dtmn_val", "coefOfDtmnVal");
		this.hashFields.put("n1st_coef_val", "n1stCoefVal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trndLineTpCd
	 */
	public String getTrndLineTpCd() {
		return this.trndLineTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return trndLineConsVal
	 */
	public String getTrndLineConsVal() {
		return this.trndLineConsVal;
	}
	
	/**
	 * Column Info
	 * @return n2ndVarDgrVal
	 */
	public String getN2ndVarDgrVal() {
		return this.n2ndVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @return n2ndCoefVal
	 */
	public String getN2ndCoefVal() {
		return this.n2ndCoefVal;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return inVal
	 */
	public String getInVal() {
		return this.inVal;
	}
	
	/**
	 * Column Info
	 * @return outVal
	 */
	public String getOutVal() {
		return this.outVal;
	}
	
	/**
	 * Column Info
	 * @return vslClssCd
	 */
	public String getVslClssCd() {
		return this.vslClssCd;
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
	 * @return trndLineSeq
	 */
	public String getTrndLineSeq() {
		return this.trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @return n1stVarDgrVal
	 */
	public String getN1stVarDgrVal() {
		return this.n1stVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @return trndLineChtTpCd
	 */
	public String getTrndLineChtTpCd() {
		return this.trndLineChtTpCd;
	}
	
	/**
	 * Column Info
	 * @return trndLineUseTpCd
	 */
	public String getTrndLineUseTpCd() {
		return this.trndLineUseTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssSubCd
	 */
	public String getVslClssSubCd() {
		return this.vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @return trndLineTpSubCd
	 */
	public String getTrndLineTpSubCd() {
		return this.trndLineTpSubCd;
	}
	
	/**
	 * Column Info
	 * @return coefOfDtmnVal
	 */
	public String getCoefOfDtmnVal() {
		return this.coefOfDtmnVal;
	}
	
	/**
	 * Column Info
	 * @return n1stCoefVal
	 */
	public String getN1stCoefVal() {
		return this.n1stCoefVal;
	}
	

	/**
	 * Column Info
	 * @param trndLineTpCd
	 */
	public void setTrndLineTpCd(String trndLineTpCd) {
		this.trndLineTpCd = trndLineTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param trndLineConsVal
	 */
	public void setTrndLineConsVal(String trndLineConsVal) {
		this.trndLineConsVal = trndLineConsVal;
	}
	
	/**
	 * Column Info
	 * @param n2ndVarDgrVal
	 */
	public void setN2ndVarDgrVal(String n2ndVarDgrVal) {
		this.n2ndVarDgrVal = n2ndVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @param n2ndCoefVal
	 */
	public void setN2ndCoefVal(String n2ndCoefVal) {
		this.n2ndCoefVal = n2ndCoefVal;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param inVal
	 */
	public void setInVal(String inVal) {
		this.inVal = inVal;
	}
	
	/**
	 * Column Info
	 * @param outVal
	 */
	public void setOutVal(String outVal) {
		this.outVal = outVal;
	}
	
	/**
	 * Column Info
	 * @param vslClssCd
	 */
	public void setVslClssCd(String vslClssCd) {
		this.vslClssCd = vslClssCd;
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
	 * @param trndLineSeq
	 */
	public void setTrndLineSeq(String trndLineSeq) {
		this.trndLineSeq = trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @param n1stVarDgrVal
	 */
	public void setN1stVarDgrVal(String n1stVarDgrVal) {
		this.n1stVarDgrVal = n1stVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @param trndLineChtTpCd
	 */
	public void setTrndLineChtTpCd(String trndLineChtTpCd) {
		this.trndLineChtTpCd = trndLineChtTpCd;
	}
	
	/**
	 * Column Info
	 * @param trndLineUseTpCd
	 */
	public void setTrndLineUseTpCd(String trndLineUseTpCd) {
		this.trndLineUseTpCd = trndLineUseTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssSubCd
	 */
	public void setVslClssSubCd(String vslClssSubCd) {
		this.vslClssSubCd = vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @param trndLineTpSubCd
	 */
	public void setTrndLineTpSubCd(String trndLineTpSubCd) {
		this.trndLineTpSubCd = trndLineTpSubCd;
	}
	
	/**
	 * Column Info
	 * @param coefOfDtmnVal
	 */
	public void setCoefOfDtmnVal(String coefOfDtmnVal) {
		this.coefOfDtmnVal = coefOfDtmnVal;
	}
	
	/**
	 * Column Info
	 * @param n1stCoefVal
	 */
	public void setN1stCoefVal(String n1stCoefVal) {
		this.n1stCoefVal = n1stCoefVal;
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
		setTrndLineTpCd(JSPUtil.getParameter(request, prefix + "trnd_line_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTrndLineConsVal(JSPUtil.getParameter(request, prefix + "trnd_line_cons_val", ""));
		setN2ndVarDgrVal(JSPUtil.getParameter(request, prefix + "n2nd_var_dgr_val", ""));
		setN2ndCoefVal(JSPUtil.getParameter(request, prefix + "n2nd_coef_val", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInVal(JSPUtil.getParameter(request, prefix + "in_val", ""));
		setOutVal(JSPUtil.getParameter(request, prefix + "out_val", ""));
		setVslClssCd(JSPUtil.getParameter(request, prefix + "vsl_clss_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrndLineSeq(JSPUtil.getParameter(request, prefix + "trnd_line_seq", ""));
		setN1stVarDgrVal(JSPUtil.getParameter(request, prefix + "n1st_var_dgr_val", ""));
		setTrndLineChtTpCd(JSPUtil.getParameter(request, prefix + "trnd_line_cht_tp_cd", ""));
		setTrndLineUseTpCd(JSPUtil.getParameter(request, prefix + "trnd_line_use_tp_cd", ""));
		setVslClssSubCd(JSPUtil.getParameter(request, prefix + "vsl_clss_sub_cd", ""));
		setTrndLineTpSubCd(JSPUtil.getParameter(request, prefix + "trnd_line_tp_sub_cd", ""));
		setCoefOfDtmnVal(JSPUtil.getParameter(request, prefix + "coef_of_dtmn_val", ""));
		setN1stCoefVal(JSPUtil.getParameter(request, prefix + "n1st_coef_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CalcTrndLineFormulaVO[]
	 */
	public CalcTrndLineFormulaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CalcTrndLineFormulaVO[]
	 */
	public CalcTrndLineFormulaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CalcTrndLineFormulaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trndLineTpCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] trndLineConsVal = (JSPUtil.getParameter(request, prefix	+ "trnd_line_cons_val", length));
			String[] n2ndVarDgrVal = (JSPUtil.getParameter(request, prefix	+ "n2nd_var_dgr_val", length));
			String[] n2ndCoefVal = (JSPUtil.getParameter(request, prefix	+ "n2nd_coef_val", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inVal = (JSPUtil.getParameter(request, prefix	+ "in_val", length));
			String[] outVal = (JSPUtil.getParameter(request, prefix	+ "out_val", length));
			String[] vslClssCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trndLineSeq = (JSPUtil.getParameter(request, prefix	+ "trnd_line_seq", length));
			String[] n1stVarDgrVal = (JSPUtil.getParameter(request, prefix	+ "n1st_var_dgr_val", length));
			String[] trndLineChtTpCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_cht_tp_cd", length));
			String[] trndLineUseTpCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_use_tp_cd", length));
			String[] vslClssSubCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_sub_cd", length));
			String[] trndLineTpSubCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_tp_sub_cd", length));
			String[] coefOfDtmnVal = (JSPUtil.getParameter(request, prefix	+ "coef_of_dtmn_val", length));
			String[] n1stCoefVal = (JSPUtil.getParameter(request, prefix	+ "n1st_coef_val", length));
			
			for (int i = 0; i < length; i++) {
				model = new CalcTrndLineFormulaVO();
				if (trndLineTpCd[i] != null)
					model.setTrndLineTpCd(trndLineTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (trndLineConsVal[i] != null)
					model.setTrndLineConsVal(trndLineConsVal[i]);
				if (n2ndVarDgrVal[i] != null)
					model.setN2ndVarDgrVal(n2ndVarDgrVal[i]);
				if (n2ndCoefVal[i] != null)
					model.setN2ndCoefVal(n2ndCoefVal[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inVal[i] != null)
					model.setInVal(inVal[i]);
				if (outVal[i] != null)
					model.setOutVal(outVal[i]);
				if (vslClssCd[i] != null)
					model.setVslClssCd(vslClssCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trndLineSeq[i] != null)
					model.setTrndLineSeq(trndLineSeq[i]);
				if (n1stVarDgrVal[i] != null)
					model.setN1stVarDgrVal(n1stVarDgrVal[i]);
				if (trndLineChtTpCd[i] != null)
					model.setTrndLineChtTpCd(trndLineChtTpCd[i]);
				if (trndLineUseTpCd[i] != null)
					model.setTrndLineUseTpCd(trndLineUseTpCd[i]);
				if (vslClssSubCd[i] != null)
					model.setVslClssSubCd(vslClssSubCd[i]);
				if (trndLineTpSubCd[i] != null)
					model.setTrndLineTpSubCd(trndLineTpSubCd[i]);
				if (coefOfDtmnVal[i] != null)
					model.setCoefOfDtmnVal(coefOfDtmnVal[i]);
				if (n1stCoefVal[i] != null)
					model.setN1stCoefVal(n1stCoefVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCalcTrndLineFormulaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CalcTrndLineFormulaVO[]
	 */
	public CalcTrndLineFormulaVO[] getCalcTrndLineFormulaVOs(){
		CalcTrndLineFormulaVO[] vos = (CalcTrndLineFormulaVO[])models.toArray(new CalcTrndLineFormulaVO[models.size()]);
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
		this.trndLineTpCd = this.trndLineTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineConsVal = this.trndLineConsVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVarDgrVal = this.n2ndVarDgrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndCoefVal = this.n2ndCoefVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVal = this.inVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outVal = this.outVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCd = this.vslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineSeq = this.trndLineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVarDgrVal = this.n1stVarDgrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineChtTpCd = this.trndLineChtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineUseTpCd = this.trndLineUseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssSubCd = this.vslClssSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineTpSubCd = this.trndLineTpSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coefOfDtmnVal = this.coefOfDtmnVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCoefVal = this.n1stCoefVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
