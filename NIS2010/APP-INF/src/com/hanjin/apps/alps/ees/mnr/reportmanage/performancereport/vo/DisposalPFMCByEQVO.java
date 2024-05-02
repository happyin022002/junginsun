/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalPFMCByEQVO.java
*@FileTitle : DisposalPFMCByEQVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.05.27 함형석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalPFMCByEQVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalPFMCByEQVO> models = new ArrayList<DisposalPFMCByEQVO>();
	
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String dispTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String dispStsCd = null;
	/* Column Info */
	private String dispRsnCd = null;
	/* Column Info */
	private String eqKind = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String usdOnly = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DisposalPFMCByEQVO() {}

	public DisposalPFMCByEQVO(String ibflag, String pagerows, String toDt, String dispTpCd, String ofcCd, String fmDt, String dispRsnCd, String eqKind, String usdOnly, String rhq, String eqTpszCd, String dispStsCd) {
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.dispTpCd = dispTpCd;
		this.ibflag = ibflag;
		this.fmDt = fmDt;
		this.dispStsCd = dispStsCd;
		this.dispRsnCd = dispRsnCd;
		this.eqKind = eqKind;
		this.eqTpszCd = eqTpszCd;
		this.rhq = rhq;
		this.usdOnly = usdOnly;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("disp_tp_cd", getDispTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("disp_sts_cd", getDispStsCd());
		this.hashColumns.put("disp_rsn_cd", getDispRsnCd());
		this.hashColumns.put("eq_kind", getEqKind());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("usd_only", getUsdOnly());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("disp_sts_cd", "dispStsCd");
		this.hashFields.put("disp_rsn_cd", "dispRsnCd");
		this.hashFields.put("eq_kind", "eqKind");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("usd_only", "usdOnly");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return dispTpCd
	 */
	public String getDispTpCd() {
		return this.dispTpCd;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return dispStsCd
	 */
	public String getDispStsCd() {
		return this.dispStsCd;
	}
	
	/**
	 * Column Info
	 * @return dispRsnCd
	 */
	public String getDispRsnCd() {
		return this.dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @return eqKind
	 */
	public String getEqKind() {
		return this.eqKind;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return usdOnly
	 */
	public String getUsdOnly() {
		return this.usdOnly;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param dispTpCd
	 */
	public void setDispTpCd(String dispTpCd) {
		this.dispTpCd = dispTpCd;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param dispStsCd
	 */
	public void setDispStsCd(String dispStsCd) {
		this.dispStsCd = dispStsCd;
	}
	
	/**
	 * Column Info
	 * @param dispRsnCd
	 */
	public void setDispRsnCd(String dispRsnCd) {
		this.dispRsnCd = dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @param eqKind
	 */
	public void setEqKind(String eqKind) {
		this.eqKind = eqKind;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param usdOnly
	 */
	public void setUsdOnly(String usdOnly) {
		this.usdOnly = usdOnly;
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
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDispTpCd(JSPUtil.getParameter(request, prefix + "disp_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setDispStsCd(JSPUtil.getParameter(request, prefix + "disp_sts_cd", ""));
		setDispRsnCd(JSPUtil.getParameter(request, prefix + "disp_rsn_cd", ""));
		setEqKind(JSPUtil.getParameter(request, prefix + "eq_kind", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setUsdOnly(JSPUtil.getParameter(request, prefix + "usd_only", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPFMCByEQVO[]
	 */
	public DisposalPFMCByEQVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalPFMCByEQVO[]
	 */
	public DisposalPFMCByEQVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPFMCByEQVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] dispTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] dispStsCd = (JSPUtil.getParameter(request, prefix	+ "disp_sts_cd", length));
			String[] dispRsnCd = (JSPUtil.getParameter(request, prefix	+ "disp_rsn_cd", length));
			String[] eqKind = (JSPUtil.getParameter(request, prefix	+ "eq_kind", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] usdOnly = (JSPUtil.getParameter(request, prefix	+ "usd_only", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalPFMCByEQVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (dispTpCd[i] != null)
					model.setDispTpCd(dispTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (dispStsCd[i] != null)
					model.setDispStsCd(dispStsCd[i]);
				if (dispRsnCd[i] != null)
					model.setDispRsnCd(dispRsnCd[i]);
				if (eqKind[i] != null)
					model.setEqKind(eqKind[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (usdOnly[i] != null)
					model.setUsdOnly(usdOnly[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalPFMCByEQVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPFMCByEQVO[]
	 */
	public DisposalPFMCByEQVO[] getDisposalPFMCByEQVOs(){
		DisposalPFMCByEQVO[] vos = (DisposalPFMCByEQVO[])models.toArray(new DisposalPFMCByEQVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpCd = this.dispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStsCd = this.dispStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRsnCd = this.dispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKind = this.eqKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdOnly = this.usdOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
