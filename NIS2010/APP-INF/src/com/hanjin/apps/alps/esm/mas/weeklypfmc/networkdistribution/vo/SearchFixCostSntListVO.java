/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchFixCostSntListVO.java
*@FileTitle : SearchFixCostSntListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.03.23 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo;

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
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFixCostSntListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFixCostSntListVO> models = new ArrayList<SearchFixCostSntListVO>();
	
	/* Column Info */
	private String dRlaneCd = null;
	/* Column Info */
	private String dVvdCd = null;
	/* Column Info */
	private String dAssignAmt = null;
	/* Column Info */
	private String dFnlHjsBsaCapa = null;
	/* Column Info */
	private String mVvdCd = null;
	/* Column Info */
	private String dTrdCd = null;
	/* Column Info */
	private String mIocCd = null;
	/* Column Info */
	private String dSlotPrice = null;
	/* Column Info */
	private String dIocCd = null;
	/* Column Info */
	private String mTrdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mRlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dVvdExpense = null;
	/* Column Info */
	private String dTsQty = null;
	/* Column Info */
	private String loclTsStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFixCostSntListVO() {}

	public SearchFixCostSntListVO(String ibflag, String pagerows, String mTrdCd, String mRlaneCd, String mVvdCd, String mIocCd, String dTrdCd, String dRlaneCd, String dVvdCd, String dIocCd, String loclTsStsCd, String dTsQty, String dFnlHjsBsaCapa, String dAssignAmt, String dSlotPrice, String dVvdExpense) {
		this.dRlaneCd = dRlaneCd;
		this.dVvdCd = dVvdCd;
		this.dAssignAmt = dAssignAmt;
		this.dFnlHjsBsaCapa = dFnlHjsBsaCapa;
		this.mVvdCd = mVvdCd;
		this.dTrdCd = dTrdCd;
		this.mIocCd = mIocCd;
		this.dSlotPrice = dSlotPrice;
		this.dIocCd = dIocCd;
		this.mTrdCd = mTrdCd;
		this.pagerows = pagerows;
		this.mRlaneCd = mRlaneCd;
		this.ibflag = ibflag;
		this.dVvdExpense = dVvdExpense;
		this.dTsQty = dTsQty;
		this.loclTsStsCd = loclTsStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d_rlane_cd", getDRlaneCd());
		this.hashColumns.put("d_vvd_cd", getDVvdCd());
		this.hashColumns.put("d_assign_amt", getDAssignAmt());
		this.hashColumns.put("d_fnl_hjs_bsa_capa", getDFnlHjsBsaCapa());
		this.hashColumns.put("m_vvd_cd", getMVvdCd());
		this.hashColumns.put("d_trd_cd", getDTrdCd());
		this.hashColumns.put("m_ioc_cd", getMIocCd());
		this.hashColumns.put("d_slot_price", getDSlotPrice());
		this.hashColumns.put("d_ioc_cd", getDIocCd());
		this.hashColumns.put("m_trd_cd", getMTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("m_rlane_cd", getMRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d_vvd_expense", getDVvdExpense());
		this.hashColumns.put("d_ts_qty", getDTsQty());
		this.hashColumns.put("locl_ts_sts_cd", getLoclTsStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d_rlane_cd", "dRlaneCd");
		this.hashFields.put("d_vvd_cd", "dVvdCd");
		this.hashFields.put("d_assign_amt", "dAssignAmt");
		this.hashFields.put("d_fnl_hjs_bsa_capa", "dFnlHjsBsaCapa");
		this.hashFields.put("m_vvd_cd", "mVvdCd");
		this.hashFields.put("d_trd_cd", "dTrdCd");
		this.hashFields.put("m_ioc_cd", "mIocCd");
		this.hashFields.put("d_slot_price", "dSlotPrice");
		this.hashFields.put("d_ioc_cd", "dIocCd");
		this.hashFields.put("m_trd_cd", "mTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("m_rlane_cd", "mRlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d_vvd_expense", "dVvdExpense");
		this.hashFields.put("d_ts_qty", "dTsQty");
		this.hashFields.put("locl_ts_sts_cd", "loclTsStsCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dRlaneCd
	 */
	public String getDRlaneCd() {
		return this.dRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return dVvdCd
	 */
	public String getDVvdCd() {
		return this.dVvdCd;
	}
	
	/**
	 * Column Info
	 * @return dAssignAmt
	 */
	public String getDAssignAmt() {
		return this.dAssignAmt;
	}
	
	/**
	 * Column Info
	 * @return dFnlHjsBsaCapa
	 */
	public String getDFnlHjsBsaCapa() {
		return this.dFnlHjsBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return mVvdCd
	 */
	public String getMVvdCd() {
		return this.mVvdCd;
	}
	
	/**
	 * Column Info
	 * @return dTrdCd
	 */
	public String getDTrdCd() {
		return this.dTrdCd;
	}
	
	/**
	 * Column Info
	 * @return mIocCd
	 */
	public String getMIocCd() {
		return this.mIocCd;
	}
	
	/**
	 * Column Info
	 * @return dSlotPrice
	 */
	public String getDSlotPrice() {
		return this.dSlotPrice;
	}
	
	/**
	 * Column Info
	 * @return dIocCd
	 */
	public String getDIocCd() {
		return this.dIocCd;
	}
	
	/**
	 * Column Info
	 * @return mTrdCd
	 */
	public String getMTrdCd() {
		return this.mTrdCd;
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
	 * @return mRlaneCd
	 */
	public String getMRlaneCd() {
		return this.mRlaneCd;
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
	 * @return dVvdExpense
	 */
	public String getDVvdExpense() {
		return this.dVvdExpense;
	}
	
	/**
	 * Column Info
	 * @return dTsQty
	 */
	public String getDTsQty() {
		return this.dTsQty;
	}
	
	/**
	 * Column Info
	 * @return loclTsStsCd
	 */
	public String getLoclTsStsCd() {
		return this.loclTsStsCd;
	}
	

	/**
	 * Column Info
	 * @param dRlaneCd
	 */
	public void setDRlaneCd(String dRlaneCd) {
		this.dRlaneCd = dRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param dVvdCd
	 */
	public void setDVvdCd(String dVvdCd) {
		this.dVvdCd = dVvdCd;
	}
	
	/**
	 * Column Info
	 * @param dAssignAmt
	 */
	public void setDAssignAmt(String dAssignAmt) {
		this.dAssignAmt = dAssignAmt;
	}
	
	/**
	 * Column Info
	 * @param dFnlHjsBsaCapa
	 */
	public void setDFnlHjsBsaCapa(String dFnlHjsBsaCapa) {
		this.dFnlHjsBsaCapa = dFnlHjsBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param mVvdCd
	 */
	public void setMVvdCd(String mVvdCd) {
		this.mVvdCd = mVvdCd;
	}
	
	/**
	 * Column Info
	 * @param dTrdCd
	 */
	public void setDTrdCd(String dTrdCd) {
		this.dTrdCd = dTrdCd;
	}
	
	/**
	 * Column Info
	 * @param mIocCd
	 */
	public void setMIocCd(String mIocCd) {
		this.mIocCd = mIocCd;
	}
	
	/**
	 * Column Info
	 * @param dSlotPrice
	 */
	public void setDSlotPrice(String dSlotPrice) {
		this.dSlotPrice = dSlotPrice;
	}
	
	/**
	 * Column Info
	 * @param dIocCd
	 */
	public void setDIocCd(String dIocCd) {
		this.dIocCd = dIocCd;
	}
	
	/**
	 * Column Info
	 * @param mTrdCd
	 */
	public void setMTrdCd(String mTrdCd) {
		this.mTrdCd = mTrdCd;
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
	 * @param mRlaneCd
	 */
	public void setMRlaneCd(String mRlaneCd) {
		this.mRlaneCd = mRlaneCd;
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
	 * @param dVvdExpense
	 */
	public void setDVvdExpense(String dVvdExpense) {
		this.dVvdExpense = dVvdExpense;
	}
	
	/**
	 * Column Info
	 * @param dTsQty
	 */
	public void setDTsQty(String dTsQty) {
		this.dTsQty = dTsQty;
	}
	
	/**
	 * Column Info
	 * @param loclTsStsCd
	 */
	public void setLoclTsStsCd(String loclTsStsCd) {
		this.loclTsStsCd = loclTsStsCd;
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
		setDRlaneCd(JSPUtil.getParameter(request, prefix + "d_rlane_cd", ""));
		setDVvdCd(JSPUtil.getParameter(request, prefix + "d_vvd_cd", ""));
		setDAssignAmt(JSPUtil.getParameter(request, prefix + "d_assign_amt", ""));
		setDFnlHjsBsaCapa(JSPUtil.getParameter(request, prefix + "d_fnl_hjs_bsa_capa", ""));
		setMVvdCd(JSPUtil.getParameter(request, prefix + "m_vvd_cd", ""));
		setDTrdCd(JSPUtil.getParameter(request, prefix + "d_trd_cd", ""));
		setMIocCd(JSPUtil.getParameter(request, prefix + "m_ioc_cd", ""));
		setDSlotPrice(JSPUtil.getParameter(request, prefix + "d_slot_price", ""));
		setDIocCd(JSPUtil.getParameter(request, prefix + "d_ioc_cd", ""));
		setMTrdCd(JSPUtil.getParameter(request, prefix + "m_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMRlaneCd(JSPUtil.getParameter(request, prefix + "m_rlane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDVvdExpense(JSPUtil.getParameter(request, prefix + "d_vvd_expense", ""));
		setDTsQty(JSPUtil.getParameter(request, prefix + "d_ts_qty", ""));
		setLoclTsStsCd(JSPUtil.getParameter(request, prefix + "locl_ts_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFixCostSntListVO[]
	 */
	public SearchFixCostSntListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFixCostSntListVO[]
	 */
	public SearchFixCostSntListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFixCostSntListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dRlaneCd = (JSPUtil.getParameter(request, prefix	+ "d_rlane_cd", length));
			String[] dVvdCd = (JSPUtil.getParameter(request, prefix	+ "d_vvd_cd", length));
			String[] dAssignAmt = (JSPUtil.getParameter(request, prefix	+ "d_assign_amt", length));
			String[] dFnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "d_fnl_hjs_bsa_capa", length));
			String[] mVvdCd = (JSPUtil.getParameter(request, prefix	+ "m_vvd_cd", length));
			String[] dTrdCd = (JSPUtil.getParameter(request, prefix	+ "d_trd_cd", length));
			String[] mIocCd = (JSPUtil.getParameter(request, prefix	+ "m_ioc_cd", length));
			String[] dSlotPrice = (JSPUtil.getParameter(request, prefix	+ "d_slot_price", length));
			String[] dIocCd = (JSPUtil.getParameter(request, prefix	+ "d_ioc_cd", length));
			String[] mTrdCd = (JSPUtil.getParameter(request, prefix	+ "m_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mRlaneCd = (JSPUtil.getParameter(request, prefix	+ "m_rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dVvdExpense = (JSPUtil.getParameter(request, prefix	+ "d_vvd_expense", length));
			String[] dTsQty = (JSPUtil.getParameter(request, prefix	+ "d_ts_qty", length));
			String[] loclTsStsCd = (JSPUtil.getParameter(request, prefix	+ "locl_ts_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFixCostSntListVO();
				if (dRlaneCd[i] != null)
					model.setDRlaneCd(dRlaneCd[i]);
				if (dVvdCd[i] != null)
					model.setDVvdCd(dVvdCd[i]);
				if (dAssignAmt[i] != null)
					model.setDAssignAmt(dAssignAmt[i]);
				if (dFnlHjsBsaCapa[i] != null)
					model.setDFnlHjsBsaCapa(dFnlHjsBsaCapa[i]);
				if (mVvdCd[i] != null)
					model.setMVvdCd(mVvdCd[i]);
				if (dTrdCd[i] != null)
					model.setDTrdCd(dTrdCd[i]);
				if (mIocCd[i] != null)
					model.setMIocCd(mIocCd[i]);
				if (dSlotPrice[i] != null)
					model.setDSlotPrice(dSlotPrice[i]);
				if (dIocCd[i] != null)
					model.setDIocCd(dIocCd[i]);
				if (mTrdCd[i] != null)
					model.setMTrdCd(mTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mRlaneCd[i] != null)
					model.setMRlaneCd(mRlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dVvdExpense[i] != null)
					model.setDVvdExpense(dVvdExpense[i]);
				if (dTsQty[i] != null)
					model.setDTsQty(dTsQty[i]);
				if (loclTsStsCd[i] != null)
					model.setLoclTsStsCd(loclTsStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFixCostSntListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFixCostSntListVO[]
	 */
	public SearchFixCostSntListVO[] getSearchFixCostSntListVOs(){
		SearchFixCostSntListVO[] vos = (SearchFixCostSntListVO[])models.toArray(new SearchFixCostSntListVO[models.size()]);
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
		this.dRlaneCd = this.dRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dVvdCd = this.dVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAssignAmt = this.dAssignAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dFnlHjsBsaCapa = this.dFnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mVvdCd = this.mVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTrdCd = this.dTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mIocCd = this.mIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dSlotPrice = this.dSlotPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dIocCd = this.dIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mTrdCd = this.mTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mRlaneCd = this.mRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dVvdExpense = this.dVvdExpense .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTsQty = this.dTsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsStsCd = this.loclTsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
