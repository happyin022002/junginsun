/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MarkingReverseChargeVO.java
*@FileTitle : MarkingReverseChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.05.27 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MarkingReverseChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MarkingReverseChargeVO> models = new ArrayList<MarkingReverseChargeVO>();
	
	/* Column Info */
	private String blInvIfDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String rvsChgFlg = null;
	/* Column Info */
	private String mergeChk = null;
	/* Column Info */
	private String revTpSrc = null;
	/* Column Info */
	private String actCustCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String blInvCfmDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String invXchRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MarkingReverseChargeVO() {}

	public MarkingReverseChargeVO(String ibflag, String pagerows, String arIfNo, String actCustCd, String revTpSrc, String blInvIfDt, String blInvCfmDt, String invNo, String currCd, String chgAmt, String invXchRt, String loclAmt, String rvsChgFlg, String mergeChk) {
		this.blInvIfDt = blInvIfDt;
		this.currCd = currCd;
		this.loclAmt = loclAmt;
		this.rvsChgFlg = rvsChgFlg;
		this.mergeChk = mergeChk;
		this.revTpSrc = revTpSrc;
		this.actCustCd = actCustCd;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.blInvCfmDt = blInvCfmDt;
		this.ibflag = ibflag;
		this.arIfNo = arIfNo;
		this.chgAmt = chgAmt;
		this.invXchRt = invXchRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_inv_if_dt", getBlInvIfDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("rvs_chg_flg", getRvsChgFlg());
		this.hashColumns.put("merge_chk", getMergeChk());
		this.hashColumns.put("rev_tp_src", getRevTpSrc());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_inv_if_dt", "blInvIfDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("rvs_chg_flg", "rvsChgFlg");
		this.hashFields.put("merge_chk", "mergeChk");
		this.hashFields.put("rev_tp_src", "revTpSrc");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blInvIfDt
	 */
	public String getBlInvIfDt() {
		return this.blInvIfDt;
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
	 * @return loclAmt
	 */
	public String getLoclAmt() {
		return this.loclAmt;
	}
	
	/**
	 * Column Info
	 * @return rvsChgFlg
	 */
	public String getRvsChgFlg() {
		return this.rvsChgFlg;
	}
	
	/**
	 * Column Info
	 * @return mergeChk
	 */
	public String getMergeChk() {
		return this.mergeChk;
	}
	
	/**
	 * Column Info
	 * @return revTpSrc
	 */
	public String getRevTpSrc() {
		return this.revTpSrc;
	}
	
	/**
	 * Column Info
	 * @return actCustCd
	 */
	public String getActCustCd() {
		return this.actCustCd;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return blInvCfmDt
	 */
	public String getBlInvCfmDt() {
		return this.blInvCfmDt;
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	

	/**
	 * Column Info
	 * @param blInvIfDt
	 */
	public void setBlInvIfDt(String blInvIfDt) {
		this.blInvIfDt = blInvIfDt;
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
	 * @param loclAmt
	 */
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
	}
	
	/**
	 * Column Info
	 * @param rvsChgFlg
	 */
	public void setRvsChgFlg(String rvsChgFlg) {
		this.rvsChgFlg = rvsChgFlg;
	}
	
	/**
	 * Column Info
	 * @param mergeChk
	 */
	public void setMergeChk(String mergeChk) {
		this.mergeChk = mergeChk;
	}
	
	/**
	 * Column Info
	 * @param revTpSrc
	 */
	public void setRevTpSrc(String revTpSrc) {
		this.revTpSrc = revTpSrc;
	}
	
	/**
	 * Column Info
	 * @param actCustCd
	 */
	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param blInvCfmDt
	 */
	public void setBlInvCfmDt(String blInvCfmDt) {
		this.blInvCfmDt = blInvCfmDt;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
		setBlInvIfDt(JSPUtil.getParameter(request, prefix + "bl_inv_if_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
		setRvsChgFlg(JSPUtil.getParameter(request, prefix + "rvs_chg_flg", ""));
		setMergeChk(JSPUtil.getParameter(request, prefix + "merge_chk", ""));
		setRevTpSrc(JSPUtil.getParameter(request, prefix + "rev_tp_src", ""));
		setActCustCd(JSPUtil.getParameter(request, prefix + "act_cust_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request, prefix + "bl_inv_cfm_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MarkingReverseChargeVO[]
	 */
	public MarkingReverseChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MarkingReverseChargeVO[]
	 */
	public MarkingReverseChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MarkingReverseChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blInvIfDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_if_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] rvsChgFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_chg_flg", length));
			String[] mergeChk = (JSPUtil.getParameter(request, prefix	+ "merge_chk", length));
			String[] revTpSrc = (JSPUtil.getParameter(request, prefix	+ "rev_tp_src", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] blInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_cfm_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MarkingReverseChargeVO();
				if (blInvIfDt[i] != null)
					model.setBlInvIfDt(blInvIfDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (rvsChgFlg[i] != null)
					model.setRvsChgFlg(rvsChgFlg[i]);
				if (mergeChk[i] != null)
					model.setMergeChk(mergeChk[i]);
				if (revTpSrc[i] != null)
					model.setRevTpSrc(revTpSrc[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (blInvCfmDt[i] != null)
					model.setBlInvCfmDt(blInvCfmDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMarkingReverseChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MarkingReverseChargeVO[]
	 */
	public MarkingReverseChargeVO[] getMarkingReverseChargeVOs(){
		MarkingReverseChargeVO[] vos = (MarkingReverseChargeVO[])models.toArray(new MarkingReverseChargeVO[models.size()]);
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
		this.blInvIfDt = this.blInvIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsChgFlg = this.rvsChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeChk = this.mergeChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpSrc = this.revTpSrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt = this.blInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
