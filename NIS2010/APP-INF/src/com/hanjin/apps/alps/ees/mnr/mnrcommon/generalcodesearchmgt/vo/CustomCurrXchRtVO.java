/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomCurrXchRtVO.java
*@FileTitle : CustomCurrXchRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.02 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomCurrXchRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomCurrXchRtVO> models = new ArrayList<CustomCurrXchRtVO>();
	
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String xchRtYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dpPrcsCurrCd = null;
	/* Column Info */
	private String xchCurrCd = null;
	/* Column Info */
	private String xchAmt = null;
	/* Column Info */
	private String xchRt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomCurrXchRtVO() {}

	public CustomCurrXchRtVO(String ibflag, String pagerows, String dpPrcsKnt, String xchRtYrmon, String currCd, String xchCurrCd, String xchAmt, String xchRt, String dpPrcsCurrCd) {
		this.dpPrcsKnt = dpPrcsKnt;
		this.xchRtYrmon = xchRtYrmon;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.dpPrcsCurrCd = dpPrcsCurrCd;
		this.xchCurrCd = xchCurrCd;
		this.xchAmt = xchAmt;
		this.xchRt = xchRt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("xch_rt_yrmon", getXchRtYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dp_prcs_curr_cd", getDpPrcsCurrCd());
		this.hashColumns.put("xch_curr_cd", getXchCurrCd());
		this.hashColumns.put("xch_amt", getXchAmt());
		this.hashColumns.put("xch_rt", getXchRt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("xch_rt_yrmon", "xchRtYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dp_prcs_curr_cd", "dpPrcsCurrCd");
		this.hashFields.put("xch_curr_cd", "xchCurrCd");
		this.hashFields.put("xch_amt", "xchAmt");
		this.hashFields.put("xch_rt", "xchRt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return xchRtYrmon
	 */
	public String getXchRtYrmon() {
		return this.xchRtYrmon;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsCurrCd
	 */
	public String getDpPrcsCurrCd() {
		return this.dpPrcsCurrCd;
	}
	
	/**
	 * Column Info
	 * @return xchCurrCd
	 */
	public String getXchCurrCd() {
		return this.xchCurrCd;
	}
	
	/**
	 * Column Info
	 * @return xchAmt
	 */
	public String getXchAmt() {
		return this.xchAmt;
	}
	
	/**
	 * Column Info
	 * @return xchRt
	 */
	public String getXchRt() {
		return this.xchRt;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param xchRtYrmon
	 */
	public void setXchRtYrmon(String xchRtYrmon) {
		this.xchRtYrmon = xchRtYrmon;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param dpPrcsCurrCd
	 */
	public void setDpPrcsCurrCd(String dpPrcsCurrCd) {
		this.dpPrcsCurrCd = dpPrcsCurrCd;
	}
	
	/**
	 * Column Info
	 * @param xchCurrCd
	 */
	public void setXchCurrCd(String xchCurrCd) {
		this.xchCurrCd = xchCurrCd;
	}
	
	/**
	 * Column Info
	 * @param xchAmt
	 */
	public void setXchAmt(String xchAmt) {
		this.xchAmt = xchAmt;
	}
	
	/**
	 * Column Info
	 * @param xchRt
	 */
	public void setXchRt(String xchRt) {
		this.xchRt = xchRt;
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
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setXchRtYrmon(JSPUtil.getParameter(request, prefix + "xch_rt_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDpPrcsCurrCd(JSPUtil.getParameter(request, prefix + "dp_prcs_curr_cd", ""));
		setXchCurrCd(JSPUtil.getParameter(request, prefix + "xch_curr_cd", ""));
		setXchAmt(JSPUtil.getParameter(request, prefix + "xch_amt", ""));
		setXchRt(JSPUtil.getParameter(request, prefix + "xch_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomCurrXchRtVO[]
	 */
	public CustomCurrXchRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomCurrXchRtVO[]
	 */
	public CustomCurrXchRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomCurrXchRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] xchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "xch_rt_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dpPrcsCurrCd = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_curr_cd", length));
			String[] xchCurrCd = (JSPUtil.getParameter(request, prefix	+ "xch_curr_cd", length));
			String[] xchAmt = (JSPUtil.getParameter(request, prefix	+ "xch_amt", length));
			String[] xchRt = (JSPUtil.getParameter(request, prefix	+ "xch_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomCurrXchRtVO();
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (xchRtYrmon[i] != null)
					model.setXchRtYrmon(xchRtYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dpPrcsCurrCd[i] != null)
					model.setDpPrcsCurrCd(dpPrcsCurrCd[i]);
				if (xchCurrCd[i] != null)
					model.setXchCurrCd(xchCurrCd[i]);
				if (xchAmt[i] != null)
					model.setXchAmt(xchAmt[i]);
				if (xchRt[i] != null)
					model.setXchRt(xchRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomCurrXchRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomCurrXchRtVO[]
	 */
	public CustomCurrXchRtVO[] getCustomCurrXchRtVOs(){
		CustomCurrXchRtVO[] vos = (CustomCurrXchRtVO[])models.toArray(new CustomCurrXchRtVO[models.size()]);
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
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtYrmon = this.xchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsCurrCd = this.dpPrcsCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchCurrCd = this.xchCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchAmt = this.xchAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRt = this.xchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
