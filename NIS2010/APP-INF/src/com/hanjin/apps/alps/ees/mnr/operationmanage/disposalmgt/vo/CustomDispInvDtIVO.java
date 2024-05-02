/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomDispInvDtIVO.java
*@FileTitle : CustomDispInvDtIVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomDispInvDtIVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomDispInvDtIVO> models = new ArrayList<CustomDispInvDtIVO>();
	
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String dispSoldDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String mnrDispDtlRmk = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String dispTpNm = null;
	/* Column Info */
	private String invDueDt = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String dispRlseNo = null;
	/* Column Info */
	private String cxlInvSeq = null;
	/* Column Info */
	private String usdTtlAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomDispInvDtIVO() {}

	public CustomDispInvDtIVO(String ibflag, String pagerows, String rqstDt, String dispSoldDt, String currCd, String dispNo, String mnrDispDtlRmk, String ttlAmt, String dispTpNm, String invDueDt, String eqTpszCd, String invNo, String dpPrcsKnt,String eqNo, String invAmt, String dispRlseNo, String cxlInvSeq, String usdTtlAmt) {
		this.rqstDt = rqstDt;
		this.dispSoldDt = dispSoldDt;
		this.currCd = currCd;
		this.dispNo = dispNo;
		this.mnrDispDtlRmk = mnrDispDtlRmk;
		this.ttlAmt = ttlAmt;
		this.dispTpNm = dispTpNm;
		this.invDueDt = invDueDt;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.invNo = invNo;
		this.dpPrcsKnt = dpPrcsKnt;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.invAmt = invAmt;
		this.dispRlseNo = dispRlseNo;
		this.cxlInvSeq = cxlInvSeq;
		this.usdTtlAmt = usdTtlAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("disp_sold_dt", getDispSoldDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("mnr_disp_dtl_rmk", getMnrDispDtlRmk());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("disp_tp_nm", getDispTpNm());
		this.hashColumns.put("inv_due_dt", getInvDueDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("disp_rlse_no", getDispRlseNo());
		this.hashColumns.put("cxl_inv_seq", getCxlInvSeq());
		this.hashColumns.put("usd_ttl_amt", getUsdTtlAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("disp_sold_dt", "dispSoldDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("mnr_disp_dtl_rmk", "mnrDispDtlRmk");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("disp_tp_nm", "dispTpNm");
		this.hashFields.put("inv_due_dt", "invDueDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("disp_rlse_no", "dispRlseNo");
		this.hashFields.put("cxl_inv_seq", "cxlInvSeq");
		this.hashFields.put("usd_ttl_amt", "usdTtlAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return dispSoldDt
	 */
	public String getDispSoldDt() {
		return this.dispSoldDt;
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
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return mnrDispDtlRmk
	 */
	public String getMnrDispDtlRmk() {
		return this.mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return dispTpNm
	 */
	public String getDispTpNm() {
		return this.dispTpNm;
	}
	
	/**
	 * Column Info
	 * @return invDueDt
	 */
	public String getInvDueDt() {
		return this.invDueDt;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return dispRlseNo
	 */
	public String getDispRlseNo() {
		return this.dispRlseNo;
	}
	
	/**
	 * Column Info
	 * @return cxlInvSeq
	 */
	public String getCxlInvSeq() {
		return this.cxlInvSeq;
	}
	
	/**
	 * Column Info
	 * @return usdTtlAmt
	 */
	public String getUsdTtlAmt() {
		return this.usdTtlAmt;
	}
	

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param dispSoldDt
	 */
	public void setDispSoldDt(String dispSoldDt) {
		this.dispSoldDt = dispSoldDt;
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
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param mnrDispDtlRmk
	 */
	public void setMnrDispDtlRmk(String mnrDispDtlRmk) {
		this.mnrDispDtlRmk = mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param dispTpNm
	 */
	public void setDispTpNm(String dispTpNm) {
		this.dispTpNm = dispTpNm;
	}
	
	/**
	 * Column Info
	 * @param invDueDt
	 */
	public void setInvDueDt(String invDueDt) {
		this.invDueDt = invDueDt;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param dispRlseNo
	 */
	public void setDispRlseNo(String dispRlseNo) {
		this.dispRlseNo = dispRlseNo;
	}
	
	/**
	 * Column Info
	 * @param cxlInvSeq
	 */
	public void setCxlInvSeq(String cxlInvSeq) {
		this.cxlInvSeq = cxlInvSeq;
	}
	
	/**
	 * Column Info
	 * @param usdTtlAmt
	 */
	public void setUsdTtlAmt(String usdTtlAmt) {
		this.usdTtlAmt = usdTtlAmt;
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
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setDispSoldDt(JSPUtil.getParameter(request, prefix + "disp_sold_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setMnrDispDtlRmk(JSPUtil.getParameter(request, prefix + "mnr_disp_dtl_rmk", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setDispTpNm(JSPUtil.getParameter(request, prefix + "disp_tp_nm", ""));
		setInvDueDt(JSPUtil.getParameter(request, prefix + "inv_due_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setDispRlseNo(JSPUtil.getParameter(request, prefix + "disp_rlse_no", ""));
		setCxlInvSeq(JSPUtil.getParameter(request, prefix + "cxl_inv_seq", ""));
		setUsdTtlAmt(JSPUtil.getParameter(request, prefix + "usd_ttl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomDispInvDtIVO[]
	 */
	public CustomDispInvDtIVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomDispInvDtIVO[]
	 */
	public CustomDispInvDtIVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomDispInvDtIVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] dispSoldDt = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] mnrDispDtlRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_dtl_rmk", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] dispTpNm = (JSPUtil.getParameter(request, prefix	+ "disp_tp_nm", length));
			String[] invDueDt = (JSPUtil.getParameter(request, prefix	+ "inv_due_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] dispRlseNo = (JSPUtil.getParameter(request, prefix	+ "disp_rlse_no", length));
			String[] cxlInvSeq = (JSPUtil.getParameter(request, prefix	+ "cxl_inv_seq", length));
			String[] usdTtlAmt = (JSPUtil.getParameter(request, prefix	+ "usd_ttl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomDispInvDtIVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (dispSoldDt[i] != null)
					model.setDispSoldDt(dispSoldDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (mnrDispDtlRmk[i] != null)
					model.setMnrDispDtlRmk(mnrDispDtlRmk[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (dispTpNm[i] != null)
					model.setDispTpNm(dispTpNm[i]);
				if (invDueDt[i] != null)
					model.setInvDueDt(invDueDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (dispRlseNo[i] != null)
					model.setDispRlseNo(dispRlseNo[i]);
				if (cxlInvSeq[i] != null)
					model.setCxlInvSeq(cxlInvSeq[i]);
				if (usdTtlAmt[i] != null)
					model.setUsdTtlAmt(usdTtlAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomDispInvDtIVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomDispInvDtIVO[]
	 */
	public CustomDispInvDtIVO[] getCustomDispInvDtIVOs(){
		CustomDispInvDtIVO[] vos = (CustomDispInvDtIVO[])models.toArray(new CustomDispInvDtIVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSoldDt = this.dispSoldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispDtlRmk = this.mnrDispDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpNm = this.dispTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDt = this.invDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRlseNo = this.dispRlseNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlInvSeq = this.cxlInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdTtlAmt = this.usdTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
