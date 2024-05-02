/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpcAlocCtrlOptVO.java
*@FileTitle : SpcAlocCtrlOptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.25
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.01.25 최윤성 
* 1.0 Creation
* 2013.01.25 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcAlocCtrlOptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcAlocCtrlOptVO> models = new ArrayList<SpcAlocCtrlOptVO>();
	
	/* Column Info */
	private String strdCmpb = null;
	/* Column Info */
	private String strdQty = null;
	/* Column Info */
	private String wkMqcQty = null;
	/* Column Info */
	private String custAdjQty = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String pfmcRatio = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String custQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subTrdAdjQty = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String costYrwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcAlocCtrlOptVO() {}

	public SpcAlocCtrlOptVO(String ibflag, String pagerows, String costYrwk, String verSeq, String custCntCd, String custSeq, String custLglEngNm, String custGrpNm, String ctrtOfcCd, String scNo, String rfaNo, String wkMqcQty, String custQty, String custAdjQty, String custCtrlCd, String slsRhqCd, String slsRgnOfcCd, String subTrdCd, String strdQty, String pfmcRatio, String subTrdAdjQty, String strdCmpb, String trdCd) {
		this.strdCmpb = strdCmpb;
		this.strdQty = strdQty;
		this.wkMqcQty = wkMqcQty;
		this.custAdjQty = custAdjQty;
		this.trdCd = trdCd;
		this.custCtrlCd = custCtrlCd;
		this.custSeq = custSeq;
		this.slsRhqCd = slsRhqCd;
		this.pagerows = pagerows;
		this.verSeq = verSeq;
		this.custLglEngNm = custLglEngNm;
		this.pfmcRatio = pfmcRatio;
		this.rfaNo = rfaNo;
		this.custQty = custQty;
		this.ibflag = ibflag;
		this.subTrdAdjQty = subTrdAdjQty;
		this.custGrpNm = custGrpNm;
		this.ctrtOfcCd = ctrtOfcCd;
		this.scNo = scNo;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.subTrdCd = subTrdCd;
		this.custCntCd = custCntCd;
		this.costYrwk = costYrwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("strd_cmpb", getStrdCmpb());
		this.hashColumns.put("strd_qty", getStrdQty());
		this.hashColumns.put("wk_mqc_qty", getWkMqcQty());
		this.hashColumns.put("cust_adj_qty", getCustAdjQty());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pfmc_ratio", getPfmcRatio());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cust_qty", getCustQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sub_trd_adj_qty", getSubTrdAdjQty());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("strd_cmpb", "strdCmpb");
		this.hashFields.put("strd_qty", "strdQty");
		this.hashFields.put("wk_mqc_qty", "wkMqcQty");
		this.hashFields.put("cust_adj_qty", "custAdjQty");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pfmc_ratio", "pfmcRatio");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cust_qty", "custQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sub_trd_adj_qty", "subTrdAdjQty");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return strdCmpb
	 */
	public String getStrdCmpb() {
		return this.strdCmpb;
	}
	
	/**
	 * Column Info
	 * @return strdQty
	 */
	public String getStrdQty() {
		return this.strdQty;
	}
	
	/**
	 * Column Info
	 * @return wkMqcQty
	 */
	public String getWkMqcQty() {
		return this.wkMqcQty;
	}
	
	/**
	 * Column Info
	 * @return custAdjQty
	 */
	public String getCustAdjQty() {
		return this.custAdjQty;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
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
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return pfmcRatio
	 */
	public String getPfmcRatio() {
		return this.pfmcRatio;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return custQty
	 */
	public String getCustQty() {
		return this.custQty;
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
	 * @return subTrdAdjQty
	 */
	public String getSubTrdAdjQty() {
		return this.subTrdAdjQty;
	}
	
	/**
	 * Column Info
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
	}
	

	/**
	 * Column Info
	 * @param strdCmpb
	 */
	public void setStrdCmpb(String strdCmpb) {
		this.strdCmpb = strdCmpb;
	}
	
	/**
	 * Column Info
	 * @param strdQty
	 */
	public void setStrdQty(String strdQty) {
		this.strdQty = strdQty;
	}
	
	/**
	 * Column Info
	 * @param wkMqcQty
	 */
	public void setWkMqcQty(String wkMqcQty) {
		this.wkMqcQty = wkMqcQty;
	}
	
	/**
	 * Column Info
	 * @param custAdjQty
	 */
	public void setCustAdjQty(String custAdjQty) {
		this.custAdjQty = custAdjQty;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
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
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param pfmcRatio
	 */
	public void setPfmcRatio(String pfmcRatio) {
		this.pfmcRatio = pfmcRatio;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param custQty
	 */
	public void setCustQty(String custQty) {
		this.custQty = custQty;
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
	 * @param subTrdAdjQty
	 */
	public void setSubTrdAdjQty(String subTrdAdjQty) {
		this.subTrdAdjQty = subTrdAdjQty;
	}
	
	/**
	 * Column Info
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
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
		setStrdCmpb(JSPUtil.getParameter(request, prefix + "strd_cmpb", ""));
		setStrdQty(JSPUtil.getParameter(request, prefix + "strd_qty", ""));
		setWkMqcQty(JSPUtil.getParameter(request, prefix + "wk_mqc_qty", ""));
		setCustAdjQty(JSPUtil.getParameter(request, prefix + "cust_adj_qty", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPfmcRatio(JSPUtil.getParameter(request, prefix + "pfmc_ratio", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setCustQty(JSPUtil.getParameter(request, prefix + "cust_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubTrdAdjQty(JSPUtil.getParameter(request, prefix + "sub_trd_adj_qty", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcAlocCtrlOptVO[]
	 */
	public SpcAlocCtrlOptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcAlocCtrlOptVO[]
	 */
	public SpcAlocCtrlOptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcAlocCtrlOptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] strdCmpb = (JSPUtil.getParameter(request, prefix	+ "strd_cmpb", length));
			String[] strdQty = (JSPUtil.getParameter(request, prefix	+ "strd_qty", length));
			String[] wkMqcQty = (JSPUtil.getParameter(request, prefix	+ "wk_mqc_qty", length));
			String[] custAdjQty = (JSPUtil.getParameter(request, prefix	+ "cust_adj_qty", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] pfmcRatio = (JSPUtil.getParameter(request, prefix	+ "pfmc_ratio", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] custQty = (JSPUtil.getParameter(request, prefix	+ "cust_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subTrdAdjQty = (JSPUtil.getParameter(request, prefix	+ "sub_trd_adj_qty", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcAlocCtrlOptVO();
				if (strdCmpb[i] != null)
					model.setStrdCmpb(strdCmpb[i]);
				if (strdQty[i] != null)
					model.setStrdQty(strdQty[i]);
				if (wkMqcQty[i] != null)
					model.setWkMqcQty(wkMqcQty[i]);
				if (custAdjQty[i] != null)
					model.setCustAdjQty(custAdjQty[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (pfmcRatio[i] != null)
					model.setPfmcRatio(pfmcRatio[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (custQty[i] != null)
					model.setCustQty(custQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subTrdAdjQty[i] != null)
					model.setSubTrdAdjQty(subTrdAdjQty[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcAlocCtrlOptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcAlocCtrlOptVO[]
	 */
	public SpcAlocCtrlOptVO[] getSpcAlocCtrlOptVOs(){
		SpcAlocCtrlOptVO[] vos = (SpcAlocCtrlOptVO[])models.toArray(new SpcAlocCtrlOptVO[models.size()]);
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
		this.strdCmpb = this.strdCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdQty = this.strdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkMqcQty = this.wkMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAdjQty = this.custAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcRatio = this.pfmcRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custQty = this.custQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdAdjQty = this.subTrdAdjQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
