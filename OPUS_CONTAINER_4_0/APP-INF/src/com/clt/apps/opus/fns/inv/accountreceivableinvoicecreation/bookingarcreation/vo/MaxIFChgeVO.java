/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MaxIFChgeVO.java
*@FileTitle : MaxIFChgeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.26 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MaxIFChgeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MaxIFChgeVO> models = new ArrayList<MaxIFChgeVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String perTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String ratAsCntrQty = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MaxIFChgeVO() {}

	public MaxIFChgeVO(String ibflag, String pagerows, String chgCd, String currCd, String perTpCd, String trfRtAmt, String ratAsCntrQty, String chgAmt, String invXchRt, String trfNo) {
		this.ibflag = ibflag;
		this.perTpCd = perTpCd;
		this.currCd = currCd;
		this.trfNo = trfNo;
		this.chgAmt = chgAmt;
		this.trfRtAmt = trfRtAmt;
		this.ratAsCntrQty = ratAsCntrQty;
		this.invXchRt = invXchRt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("per_tp_cd", getPerTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return perTpCd
	 */
	public String getPerTpCd() {
		return this.perTpCd;
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
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param perTpCd
	 */
	public void setPerTpCd(String perTpCd) {
		this.perTpCd = perTpCd;
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
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPerTpCd(JSPUtil.getParameter(request, "per_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, "trf_rt_amt", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, "rat_as_cntr_qty", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MaxIFChgeVO[]
	 */
	public MaxIFChgeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MaxIFChgeVO[]
	 */
	public MaxIFChgeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MaxIFChgeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] perTpCd = (JSPUtil.getParameter(request, prefix	+ "per_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MaxIFChgeVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (perTpCd[i] != null)
					model.setPerTpCd(perTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMaxIFChgeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MaxIFChgeVO[]
	 */
	public MaxIFChgeVO[] getMaxIFChgeVOs(){
		MaxIFChgeVO[] vos = (MaxIFChgeVO[])models.toArray(new MaxIFChgeVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd = this.perTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
