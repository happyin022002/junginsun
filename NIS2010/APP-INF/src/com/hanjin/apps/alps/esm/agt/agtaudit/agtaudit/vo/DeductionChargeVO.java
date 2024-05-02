/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DeductionChargeVO.java
*@FileTitle : DeductionChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.03.08 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DeductionChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DeductionChargeVO> models = new ArrayList<DeductionChargeVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chgDdctLoclAmt = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String bkgAgmtUtCd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usdUcAmt = null;
	/* Column Info */
	private String chgDdctAmt = null;
	/* Column Info */
	private String nodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DeductionChargeVO() {}

	public DeductionChargeVO(String ibflag, String pagerows, String currCd, String chgDdctLoclAmt, String chgDdctAmt, String bkgAgmtUtCd, String chgCd, String stndCostNm, String nodCd, String toNodCd, String creUsrId, String sailArrDt, String usdUcAmt) {
		this.toNodCd = toNodCd;
		this.currCd = currCd;
		this.chgDdctLoclAmt = chgDdctLoclAmt;
		this.stndCostNm = stndCostNm;
		this.bkgAgmtUtCd = bkgAgmtUtCd;
		this.sailArrDt = sailArrDt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.usdUcAmt = usdUcAmt;
		this.chgDdctAmt = chgDdctAmt;
		this.nodCd = nodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chg_ddct_locl_amt", getChgDdctLoclAmt());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("bkg_agmt_ut_cd", getBkgAgmtUtCd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usd_uc_amt", getUsdUcAmt());
		this.hashColumns.put("chg_ddct_amt", getChgDdctAmt());
		this.hashColumns.put("nod_cd", getNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chg_ddct_locl_amt", "chgDdctLoclAmt");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("bkg_agmt_ut_cd", "bkgAgmtUtCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usd_uc_amt", "usdUcAmt");
		this.hashFields.put("chg_ddct_amt", "chgDdctAmt");
		this.hashFields.put("nod_cd", "nodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
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
	 * @return chgDdctLoclAmt
	 */
	public String getChgDdctLoclAmt() {
		return this.chgDdctLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
	}
	
	/**
	 * Column Info
	 * @return bkgAgmtUtCd
	 */
	public String getBkgAgmtUtCd() {
		return this.bkgAgmtUtCd;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return usdUcAmt
	 */
	public String getUsdUcAmt() {
		return this.usdUcAmt;
	}
	
	/**
	 * Column Info
	 * @return chgDdctAmt
	 */
	public String getChgDdctAmt() {
		return this.chgDdctAmt;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
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
	 * @param chgDdctLoclAmt
	 */
	public void setChgDdctLoclAmt(String chgDdctLoclAmt) {
		this.chgDdctLoclAmt = chgDdctLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
	}
	
	/**
	 * Column Info
	 * @param bkgAgmtUtCd
	 */
	public void setBkgAgmtUtCd(String bkgAgmtUtCd) {
		this.bkgAgmtUtCd = bkgAgmtUtCd;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param usdUcAmt
	 */
	public void setUsdUcAmt(String usdUcAmt) {
		this.usdUcAmt = usdUcAmt;
	}
	
	/**
	 * Column Info
	 * @param chgDdctAmt
	 */
	public void setChgDdctAmt(String chgDdctAmt) {
		this.chgDdctAmt = chgDdctAmt;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setChgDdctLoclAmt(JSPUtil.getParameter(request, prefix + "chg_ddct_locl_amt", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setBkgAgmtUtCd(JSPUtil.getParameter(request, prefix + "bkg_agmt_ut_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUsdUcAmt(JSPUtil.getParameter(request, prefix + "usd_uc_amt", ""));
		setChgDdctAmt(JSPUtil.getParameter(request, prefix + "chg_ddct_amt", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DeductionChargeVO[]
	 */
	public DeductionChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DeductionChargeVO[]
	 */
	public DeductionChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DeductionChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chgDdctLoclAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ddct_locl_amt", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] bkgAgmtUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_agmt_ut_cd", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usdUcAmt = (JSPUtil.getParameter(request, prefix	+ "usd_uc_amt", length));
			String[] chgDdctAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ddct_amt", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DeductionChargeVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chgDdctLoclAmt[i] != null)
					model.setChgDdctLoclAmt(chgDdctLoclAmt[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (bkgAgmtUtCd[i] != null)
					model.setBkgAgmtUtCd(bkgAgmtUtCd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usdUcAmt[i] != null)
					model.setUsdUcAmt(usdUcAmt[i]);
				if (chgDdctAmt[i] != null)
					model.setChgDdctAmt(chgDdctAmt[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDeductionChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DeductionChargeVO[]
	 */
	public DeductionChargeVO[] getDeductionChargeVOs(){
		DeductionChargeVO[] vos = (DeductionChargeVO[])models.toArray(new DeductionChargeVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDdctLoclAmt = this.chgDdctLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAgmtUtCd = this.bkgAgmtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdUcAmt = this.usdUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDdctAmt = this.chgDdctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
