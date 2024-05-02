/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgnReqRevInfoVO.java
*@FileTitle : AgnReqRevInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.01
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.01 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgnReqRevInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgnReqRevInfoVO> models = new ArrayList<AgnReqRevInfoVO>();
	
	/* Column Info */
	private String ppdCafAmt = null;
	/* Column Info */
	private String ppdOthAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ppdStrcRev = null;
	/* Column Info */
	private String ppdOftAmt = null;
	/* Column Info */
	private String cctStrcRev = null;
	/* Column Info */
	private String cctCafAmt = null;
	/* Column Info */
	private String cctOthAmt = null;
	/* Column Info */
	private String cctOftAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgnReqRevInfoVO() {}

	public AgnReqRevInfoVO(String ibflag, String pagerows, String ppdOftAmt, String ppdOthAmt, String cctOftAmt, String cctOthAmt, String ppdStrcRev, String cctStrcRev, String ppdCafAmt, String cctCafAmt) {
		this.ppdCafAmt = ppdCafAmt;
		this.ppdOthAmt = ppdOthAmt;
		this.ibflag = ibflag;
		this.ppdStrcRev = ppdStrcRev;
		this.ppdOftAmt = ppdOftAmt;
		this.cctStrcRev = cctStrcRev;
		this.cctCafAmt = cctCafAmt;
		this.cctOthAmt = cctOthAmt;
		this.cctOftAmt = cctOftAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ppd_caf_amt", getPpdCafAmt());
		this.hashColumns.put("ppd_oth_amt", getPpdOthAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ppd_strc_rev", getPpdStrcRev());
		this.hashColumns.put("ppd_oft_amt", getPpdOftAmt());
		this.hashColumns.put("cct_strc_rev", getCctStrcRev());
		this.hashColumns.put("cct_caf_amt", getCctCafAmt());
		this.hashColumns.put("cct_oth_amt", getCctOthAmt());
		this.hashColumns.put("cct_oft_amt", getCctOftAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ppd_caf_amt", "ppdCafAmt");
		this.hashFields.put("ppd_oth_amt", "ppdOthAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ppd_strc_rev", "ppdStrcRev");
		this.hashFields.put("ppd_oft_amt", "ppdOftAmt");
		this.hashFields.put("cct_strc_rev", "cctStrcRev");
		this.hashFields.put("cct_caf_amt", "cctCafAmt");
		this.hashFields.put("cct_oth_amt", "cctOthAmt");
		this.hashFields.put("cct_oft_amt", "cctOftAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ppdCafAmt
	 */
	public String getPpdCafAmt() {
		return this.ppdCafAmt;
	}
	
	/**
	 * Column Info
	 * @return ppdOthAmt
	 */
	public String getPpdOthAmt() {
		return this.ppdOthAmt;
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
	 * @return ppdStrcRev
	 */
	public String getPpdStrcRev() {
		return this.ppdStrcRev;
	}
	
	/**
	 * Column Info
	 * @return ppdOftAmt
	 */
	public String getPpdOftAmt() {
		return this.ppdOftAmt;
	}
	
	/**
	 * Column Info
	 * @return cctStrcRev
	 */
	public String getCctStrcRev() {
		return this.cctStrcRev;
	}
	
	/**
	 * Column Info
	 * @return cctCafAmt
	 */
	public String getCctCafAmt() {
		return this.cctCafAmt;
	}
	
	/**
	 * Column Info
	 * @return cctOthAmt
	 */
	public String getCctOthAmt() {
		return this.cctOthAmt;
	}
	
	/**
	 * Column Info
	 * @return cctOftAmt
	 */
	public String getCctOftAmt() {
		return this.cctOftAmt;
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
	 * @param ppdCafAmt
	 */
	public void setPpdCafAmt(String ppdCafAmt) {
		this.ppdCafAmt = ppdCafAmt;
	}
	
	/**
	 * Column Info
	 * @param ppdOthAmt
	 */
	public void setPpdOthAmt(String ppdOthAmt) {
		this.ppdOthAmt = ppdOthAmt;
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
	 * @param ppdStrcRev
	 */
	public void setPpdStrcRev(String ppdStrcRev) {
		this.ppdStrcRev = ppdStrcRev;
	}
	
	/**
	 * Column Info
	 * @param ppdOftAmt
	 */
	public void setPpdOftAmt(String ppdOftAmt) {
		this.ppdOftAmt = ppdOftAmt;
	}
	
	/**
	 * Column Info
	 * @param cctStrcRev
	 */
	public void setCctStrcRev(String cctStrcRev) {
		this.cctStrcRev = cctStrcRev;
	}
	
	/**
	 * Column Info
	 * @param cctCafAmt
	 */
	public void setCctCafAmt(String cctCafAmt) {
		this.cctCafAmt = cctCafAmt;
	}
	
	/**
	 * Column Info
	 * @param cctOthAmt
	 */
	public void setCctOthAmt(String cctOthAmt) {
		this.cctOthAmt = cctOthAmt;
	}
	
	/**
	 * Column Info
	 * @param cctOftAmt
	 */
	public void setCctOftAmt(String cctOftAmt) {
		this.cctOftAmt = cctOftAmt;
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
		setPpdCafAmt(JSPUtil.getParameter(request, prefix + "ppd_caf_amt", ""));
		setPpdOthAmt(JSPUtil.getParameter(request, prefix + "ppd_oth_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPpdStrcRev(JSPUtil.getParameter(request, prefix + "ppd_strc_rev", ""));
		setPpdOftAmt(JSPUtil.getParameter(request, prefix + "ppd_oft_amt", ""));
		setCctStrcRev(JSPUtil.getParameter(request, prefix + "cct_strc_rev", ""));
		setCctCafAmt(JSPUtil.getParameter(request, prefix + "cct_caf_amt", ""));
		setCctOthAmt(JSPUtil.getParameter(request, prefix + "cct_oth_amt", ""));
		setCctOftAmt(JSPUtil.getParameter(request, prefix + "cct_oft_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgnReqRevInfoVO[]
	 */
	public AgnReqRevInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgnReqRevInfoVO[]
	 */
	public AgnReqRevInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgnReqRevInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ppdCafAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_caf_amt", length));
			String[] ppdOthAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_oth_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ppdStrcRev = (JSPUtil.getParameter(request, prefix	+ "ppd_strc_rev", length));
			String[] ppdOftAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_oft_amt", length));
			String[] cctStrcRev = (JSPUtil.getParameter(request, prefix	+ "cct_strc_rev", length));
			String[] cctCafAmt = (JSPUtil.getParameter(request, prefix	+ "cct_caf_amt", length));
			String[] cctOthAmt = (JSPUtil.getParameter(request, prefix	+ "cct_oth_amt", length));
			String[] cctOftAmt = (JSPUtil.getParameter(request, prefix	+ "cct_oft_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgnReqRevInfoVO();
				if (ppdCafAmt[i] != null)
					model.setPpdCafAmt(ppdCafAmt[i]);
				if (ppdOthAmt[i] != null)
					model.setPpdOthAmt(ppdOthAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ppdStrcRev[i] != null)
					model.setPpdStrcRev(ppdStrcRev[i]);
				if (ppdOftAmt[i] != null)
					model.setPpdOftAmt(ppdOftAmt[i]);
				if (cctStrcRev[i] != null)
					model.setCctStrcRev(cctStrcRev[i]);
				if (cctCafAmt[i] != null)
					model.setCctCafAmt(cctCafAmt[i]);
				if (cctOthAmt[i] != null)
					model.setCctOthAmt(cctOthAmt[i]);
				if (cctOftAmt[i] != null)
					model.setCctOftAmt(cctOftAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgnReqRevInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgnReqRevInfoVO[]
	 */
	public AgnReqRevInfoVO[] getAgnReqRevInfoVOs(){
		AgnReqRevInfoVO[] vos = (AgnReqRevInfoVO[])models.toArray(new AgnReqRevInfoVO[models.size()]);
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
		this.ppdCafAmt = this.ppdCafAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOthAmt = this.ppdOthAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdStrcRev = this.ppdStrcRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOftAmt = this.ppdOftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctStrcRev = this.cctStrcRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctCafAmt = this.cctCafAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOthAmt = this.cctOthAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOftAmt = this.cctOftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
