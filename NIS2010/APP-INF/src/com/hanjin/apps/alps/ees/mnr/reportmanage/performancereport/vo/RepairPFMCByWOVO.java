/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCByWOVO.java
*@FileTitle : RepairPFMCByWOVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.05
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.05 박명신 
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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByWOVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByWOVO> models = new ArrayList<RepairPFMCByWOVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String costNm = null;
	/* Column Info */
	private String sprPrtNo = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String mnrHngrBarTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sprPrtSplYdCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String vslVvd = null;
	/* Column Info */
	private String mnrWoTpNm = null;
	/* Column Info */
	private String amt = null;
	/* Column Info */
	private String cntNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String avgAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String costDtlNm = null;
	/* Column Info */
	private String sprPrtUtTpNm = null;
	/* Column Info */
	private String hqty = null;
	/* Column Info */
	private String vndrSeqNm = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairPFMCByWOVO() {}

	public RepairPFMCByWOVO(String ibflag, String pagerows, String currCd, String costOfcCd, String costNm, String sprPrtNo, String qty, String mnrHngrBarTpNm, String sprPrtSplYdCd, String eqTpszCd, String vslVvd, String mnrWoTpNm, String amt, String vndrSeq, String acctCd, String avgAmt, String sprPrtUtTpNm, String costDtlNm, String hqty, String vndrSeqNm, String rhq, String cntNm) {
		this.currCd = currCd;
		this.costOfcCd = costOfcCd;
		this.costNm = costNm;
		this.sprPrtNo = sprPrtNo;
		this.qty = qty;
		this.mnrHngrBarTpNm = mnrHngrBarTpNm;
		this.pagerows = pagerows;
		this.sprPrtSplYdCd = sprPrtSplYdCd;
		this.eqTpszCd = eqTpszCd;
		this.vslVvd = vslVvd;
		this.mnrWoTpNm = mnrWoTpNm;
		this.amt = amt;
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.avgAmt = avgAmt;
		this.acctCd = acctCd;
		this.costDtlNm = costDtlNm;
		this.sprPrtUtTpNm = sprPrtUtTpNm;
		this.hqty = hqty;
		this.vndrSeqNm = vndrSeqNm;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("cost_nm", getCostNm());
		this.hashColumns.put("spr_prt_no", getSprPrtNo());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("mnr_hngr_bar_tp_nm", getMnrHngrBarTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spr_prt_spl_yd_cd", getSprPrtSplYdCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("vsl_vvd", getVslVvd());
		this.hashColumns.put("mnr_wo_tp_nm", getMnrWoTpNm());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("avg_amt", getAvgAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cost_dtl_nm", getCostDtlNm());
		this.hashColumns.put("spr_prt_ut_tp_nm", getSprPrtUtTpNm());
		this.hashColumns.put("hqty", getHqty());
		this.hashColumns.put("vndr_seq_nm", getVndrSeqNm());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("cost_nm", "costNm");
		this.hashFields.put("spr_prt_no", "sprPrtNo");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("mnr_hngr_bar_tp_nm", "mnrHngrBarTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spr_prt_spl_yd_cd", "sprPrtSplYdCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("vsl_vvd", "vslVvd");
		this.hashFields.put("mnr_wo_tp_nm", "mnrWoTpNm");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("avg_amt", "avgAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cost_dtl_nm", "costDtlNm");
		this.hashFields.put("spr_prt_ut_tp_nm", "sprPrtUtTpNm");
		this.hashFields.put("hqty", "hqty");
		this.hashFields.put("vndr_seq_nm", "vndrSeqNm");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
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
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return costNm
	 */
	public String getCostNm() {
		return this.costNm;
	}
	
	/**
	 * Column Info
	 * @return sprPrtNo
	 */
	public String getSprPrtNo() {
		return this.sprPrtNo;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrBarTpNm
	 */
	public String getMnrHngrBarTpNm() {
		return this.mnrHngrBarTpNm;
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
	 * @return sprPrtSplYdCd
	 */
	public String getSprPrtSplYdCd() {
		return this.sprPrtSplYdCd;
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
	 * @return vslVvd
	 */
	public String getVslVvd() {
		return this.vslVvd;
	}
	
	/**
	 * Column Info
	 * @return mnrWoTpNm
	 */
	public String getMnrWoTpNm() {
		return this.mnrWoTpNm;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return avgAmt
	 */
	public String getAvgAmt() {
		return this.avgAmt;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return costDtlNm
	 */
	public String getCostDtlNm() {
		return this.costDtlNm;
	}
	
	/**
	 * Column Info
	 * @return sprPrtUtTpNm
	 */
	public String getSprPrtUtTpNm() {
		return this.sprPrtUtTpNm;
	}
	
	/**
	 * Column Info
	 * @return hqty
	 */
	public String getHqty() {
		return this.hqty;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqNm
	 */
	public String getVndrSeqNm() {
		return this.vndrSeqNm;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param costNm
	 */
	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}
	
	/**
	 * Column Info
	 * @param sprPrtNo
	 */
	public void setSprPrtNo(String sprPrtNo) {
		this.sprPrtNo = sprPrtNo;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrBarTpNm
	 */
	public void setMnrHngrBarTpNm(String mnrHngrBarTpNm) {
		this.mnrHngrBarTpNm = mnrHngrBarTpNm;
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
	 * @param sprPrtSplYdCd
	 */
	public void setSprPrtSplYdCd(String sprPrtSplYdCd) {
		this.sprPrtSplYdCd = sprPrtSplYdCd;
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
	 * @param vslVvd
	 */
	public void setVslVvd(String vslVvd) {
		this.vslVvd = vslVvd;
	}
	
	/**
	 * Column Info
	 * @param mnrWoTpNm
	 */
	public void setMnrWoTpNm(String mnrWoTpNm) {
		this.mnrWoTpNm = mnrWoTpNm;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param avgAmt
	 */
	public void setAvgAmt(String avgAmt) {
		this.avgAmt = avgAmt;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param costDtlNm
	 */
	public void setCostDtlNm(String costDtlNm) {
		this.costDtlNm = costDtlNm;
	}
	
	/**
	 * Column Info
	 * @param sprPrtUtTpNm
	 */
	public void setSprPrtUtTpNm(String sprPrtUtTpNm) {
		this.sprPrtUtTpNm = sprPrtUtTpNm;
	}
	
	/**
	 * Column Info
	 * @param hqty
	 */
	public void setHqty(String hqty) {
		this.hqty = hqty;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqNm
	 */
	public void setVndrSeqNm(String vndrSeqNm) {
		this.vndrSeqNm = vndrSeqNm;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setCostNm(JSPUtil.getParameter(request, prefix + "cost_nm", ""));
		setSprPrtNo(JSPUtil.getParameter(request, prefix + "spr_prt_no", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setMnrHngrBarTpNm(JSPUtil.getParameter(request, prefix + "mnr_hngr_bar_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSprPrtSplYdCd(JSPUtil.getParameter(request, prefix + "spr_prt_spl_yd_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setVslVvd(JSPUtil.getParameter(request, prefix + "vsl_vvd", ""));
		setMnrWoTpNm(JSPUtil.getParameter(request, prefix + "mnr_wo_tp_nm", ""));
		setAmt(JSPUtil.getParameter(request, prefix + "amt", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setAvgAmt(JSPUtil.getParameter(request, prefix + "avg_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setCostDtlNm(JSPUtil.getParameter(request, prefix + "cost_dtl_nm", ""));
		setSprPrtUtTpNm(JSPUtil.getParameter(request, prefix + "spr_prt_ut_tp_nm", ""));
		setHqty(JSPUtil.getParameter(request, prefix + "hqty", ""));
		setVndrSeqNm(JSPUtil.getParameter(request, prefix + "vndr_seq_nm", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByWOVO[]
	 */
	public RepairPFMCByWOVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByWOVO[]
	 */
	public RepairPFMCByWOVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByWOVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));
			String[] sprPrtNo = (JSPUtil.getParameter(request, prefix	+ "spr_prt_no", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] mnrHngrBarTpNm = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_bar_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sprPrtSplYdCd = (JSPUtil.getParameter(request, prefix	+ "spr_prt_spl_yd_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] vslVvd = (JSPUtil.getParameter(request, prefix	+ "vsl_vvd", length));
			String[] mnrWoTpNm = (JSPUtil.getParameter(request, prefix	+ "mnr_wo_tp_nm", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] avgAmt = (JSPUtil.getParameter(request, prefix	+ "avg_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] costDtlNm = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_nm", length));
			String[] sprPrtUtTpNm = (JSPUtil.getParameter(request, prefix	+ "spr_prt_ut_tp_nm", length));
			String[] hqty = (JSPUtil.getParameter(request, prefix	+ "hqty", length));
			String[] vndrSeqNm = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_nm", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByWOVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (costNm[i] != null)
					model.setCostNm(costNm[i]);
				if (sprPrtNo[i] != null)
					model.setSprPrtNo(sprPrtNo[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (mnrHngrBarTpNm[i] != null)
					model.setMnrHngrBarTpNm(mnrHngrBarTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sprPrtSplYdCd[i] != null)
					model.setSprPrtSplYdCd(sprPrtSplYdCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (vslVvd[i] != null)
					model.setVslVvd(vslVvd[i]);
				if (mnrWoTpNm[i] != null)
					model.setMnrWoTpNm(mnrWoTpNm[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (avgAmt[i] != null)
					model.setAvgAmt(avgAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (costDtlNm[i] != null)
					model.setCostDtlNm(costDtlNm[i]);
				if (sprPrtUtTpNm[i] != null)
					model.setSprPrtUtTpNm(sprPrtUtTpNm[i]);
				if (hqty[i] != null)
					model.setHqty(hqty[i]);
				if (vndrSeqNm[i] != null)
					model.setVndrSeqNm(vndrSeqNm[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByWOVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByWOVO[]
	 */
	public RepairPFMCByWOVO[] getRepairPFMCByWOVOs(){
		RepairPFMCByWOVO[] vos = (RepairPFMCByWOVO[])models.toArray(new RepairPFMCByWOVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNm = this.costNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNo = this.sprPrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpNm = this.mnrHngrBarTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplYdCd = this.sprPrtSplYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVvd = this.vslVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoTpNm = this.mnrWoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgAmt = this.avgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlNm = this.costDtlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtUtTpNm = this.sprPrtUtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hqty = this.hqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqNm = this.vndrSeqNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
