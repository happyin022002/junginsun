/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BKGInvoiceVO.java
*@FileTitle : BKGInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.20 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정휘택
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class BKGInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BKGInvoiceVO> models = new ArrayList<BKGInvoiceVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String masterInv = null;
	/* Column Info */
	private String custRefNo1 = null;
	/* Column Info */
	private String custRefNo2 = null;
	/* Column Info */
	private String lclVvd = null;
	/* Column Info */
	private String custRefNo3 = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String invCustSeq = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String custCrFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String revSrcCd = null;	
	/* Column Info */
	private String invSvcScpCd = null;
	
	/* Column Info */
	private List<BKGContainerVO> bkgContainerVo = null;

	public List<BKGContainerVO> getBkgContainerVo() {
		return bkgContainerVo;
	}

	public void setBkgContainerVo(List<BKGContainerVO> bkgContainerVo) {
		this.bkgContainerVo = bkgContainerVo;
	}

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BKGInvoiceVO() {}

	public BKGInvoiceVO(String ibflag, String pagerows, String blSrcNo, String bkgNo, String bkgNoSplit, String actCustCntCd, String actCustSeq, String lclVvd, String svcScpCd, String ioBndCd, String sailArrDt, String trunkVvd, String porCd, String polCd, String podCd, String delCd, String masterInv, String loclCurrCd, String invCustCntCd, String invCustSeq, String dueDt, String bkgTeuQty, String bkgFeuQty, String custCrFlg, String custRefNo1, String custRefNo2, String custRefNo3, String glEffDt, String revTpCd, String revSrcCd, String invSvcScpCd) {
		this.porCd = porCd;
		this.masterInv = masterInv;
		this.custRefNo1 = custRefNo1;
		this.custRefNo2 = custRefNo2;
		this.lclVvd = lclVvd;
		this.custRefNo3 = custRefNo3;
		this.svcScpCd = svcScpCd;
		this.trunkVvd = trunkVvd;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgFeuQty = bkgFeuQty;
		this.invCustCntCd = invCustCntCd;
		this.actCustCntCd = actCustCntCd;
		this.dueDt = dueDt;
		this.blSrcNo = blSrcNo;
		this.bkgNoSplit = bkgNoSplit;
		this.invCustSeq = invCustSeq;
		this.actCustSeq = actCustSeq;
		this.loclCurrCd = loclCurrCd;
		this.delCd = delCd;
		this.ioBndCd = ioBndCd;
		this.custCrFlg = custCrFlg;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.bkgTeuQty = bkgTeuQty;
		this.glEffDt = glEffDt;
		this.revTpCd = revTpCd;
		this.revSrcCd = revSrcCd;
		this.invSvcScpCd = invSvcScpCd;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("master_inv", getMasterInv());
		this.hashColumns.put("cust_ref_no1", getCustRefNo1());
		this.hashColumns.put("cust_ref_no2", getCustRefNo2());
		this.hashColumns.put("lcl_vvd", getLclVvd());
		this.hashColumns.put("cust_ref_no3", getCustRefNo3());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cust_cr_flg", getCustCrFlg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("inv_svc_scp_cd", getInvSvcScpCd());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("master_inv", "masterInv");
		this.hashFields.put("cust_ref_no1", "custRefNo1");
		this.hashFields.put("cust_ref_no2", "custRefNo2");
		this.hashFields.put("lcl_vvd", "lclVvd");
		this.hashFields.put("cust_ref_no3", "custRefNo3");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust_cr_flg", "custCrFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("inv_svc_scp_cd", "invSvcScpCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return masterInv
	 */
	public String getMasterInv() {
		return this.masterInv;
	}
	
	/**
	 * Column Info
	 * @return custRefNo1
	 */
	public String getCustRefNo1() {
		return this.custRefNo1;
	}
	
	/**
	 * Column Info
	 * @return custRefNo2
	 */
	public String getCustRefNo2() {
		return this.custRefNo2;
	}
	
	/**
	 * Column Info
	 * @return lclVvd
	 */
	public String getLclVvd() {
		return this.lclVvd;
	}
	
	/**
	 * Column Info
	 * @return custRefNo3
	 */
	public String getCustRefNo3() {
		return this.custRefNo3;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
	}
	
	/**
	 * Column Info
	 * @return invCustCntCd
	 */
	public String getInvCustCntCd() {
		return this.invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return invCustSeq
	 */
	public String getInvCustSeq() {
		return this.invCustSeq;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return custCrFlg
	 */
	public String getCustCrFlg() {
		return this.custCrFlg;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param masterInv
	 */
	public void setMasterInv(String masterInv) {
		this.masterInv = masterInv;
	}
	
	/**
	 * Column Info
	 * @param custRefNo1
	 */
	public void setCustRefNo1(String custRefNo1) {
		this.custRefNo1 = custRefNo1;
	}
	
	/**
	 * Column Info
	 * @param custRefNo2
	 */
	public void setCustRefNo2(String custRefNo2) {
		this.custRefNo2 = custRefNo2;
	}
	
	/**
	 * Column Info
	 * @param lclVvd
	 */
	public void setLclVvd(String lclVvd) {
		this.lclVvd = lclVvd;
	}
	
	/**
	 * Column Info
	 * @param custRefNo3
	 */
	public void setCustRefNo3(String custRefNo3) {
		this.custRefNo3 = custRefNo3;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
	}
	
	/**
	 * Column Info
	 * @param invCustCntCd
	 */
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param invCustSeq
	 */
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param custCrFlg
	 */
	public void setCustCrFlg(String custCrFlg) {
		this.custCrFlg = custCrFlg;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	/**
	 * @return the glEffDt
	 */
	public String getGlEffDt() {
		return glEffDt;
	}

	/**
	 * @param glEffDt the glEffDt to set
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}

	/**
	 * @return the revTpCd
	 */
	public String getRevTpCd() {
		return revTpCd;
	}

	/**
	 * @param revTpCd the revTpCd to set
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}

	/**
	 * @return the revSrcCd
	 */
	public String getRevSrcCd() {
		return revSrcCd;
	}

	/**
	 * @param revSrcCd the revSrcCd to set
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
	}

	/**
	 * @return the invSvcScpCd
	 */
	public String getInvSvcScpCd() {
		return invSvcScpCd;
	}

	/**
	 * @param invSvcScpCd the invSvcScpCd to set
	 */
	public void setInvSvcScpCd(String invSvcScpCd) {
		this.invSvcScpCd = invSvcScpCd;
	}

	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setMasterInv(JSPUtil.getParameter(request, "master_inv", ""));
		setCustRefNo1(JSPUtil.getParameter(request, "cust_ref_no1", ""));
		setCustRefNo2(JSPUtil.getParameter(request, "cust_ref_no2", ""));
		setLclVvd(JSPUtil.getParameter(request, "lcl_vvd", ""));
		setCustRefNo3(JSPUtil.getParameter(request, "cust_ref_no3", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setTrunkVvd(JSPUtil.getParameter(request, "trunk_vvd", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, "bkg_feu_qty", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, "inv_cust_cnt_cd", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setInvCustSeq(JSPUtil.getParameter(request, "inv_cust_seq", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCustCrFlg(JSPUtil.getParameter(request, "cust_cr_flg", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, "bkg_teu_qty", ""));
		setGlEffDt(JSPUtil.getParameter(request, "gl_eff_dt", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
		setInvSvcScpCd(JSPUtil.getParameter(request, "inv_svc_scp_cd", ""));
		
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return BKGInvoiceVO[]
	 */
	public BKGInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BKGInvoiceVO[]
	 */
	public BKGInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BKGInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd".trim(), length));
			String[] masterInv = (JSPUtil.getParameter(request, prefix	+ "master_inv".trim(), length));
			String[] custRefNo1 = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no1".trim(), length));
			String[] custRefNo2 = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no2".trim(), length));
			String[] lclVvd = (JSPUtil.getParameter(request, prefix	+ "lcl_vvd".trim(), length));
			String[] custRefNo3 = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no3".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd".trim(), length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty".trim(), length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd".trim(), length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd".trim(), length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt".trim(), length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split".trim(), length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq".trim(), length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq".trim(), length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] custCrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_cr_flg".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty".trim(), length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt".trim(), length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd".trim(), length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd".trim(), length));
			String[] invSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "inv_svc_scp_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BKGInvoiceVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (masterInv[i] != null)
					model.setMasterInv(masterInv[i]);
				if (custRefNo1[i] != null)
					model.setCustRefNo1(custRefNo1[i]);
				if (custRefNo2[i] != null)
					model.setCustRefNo2(custRefNo2[i]);
				if (lclVvd[i] != null)
					model.setLclVvd(lclVvd[i]);
				if (custRefNo3[i] != null)
					model.setCustRefNo3(custRefNo3[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (custCrFlg[i] != null)
					model.setCustCrFlg(custCrFlg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (invSvcScpCd[i] != null)
					model.setInvSvcScpCd(invSvcScpCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBKGInvoiceVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return BKGInvoiceVO[]
	 */
	public BKGInvoiceVO[] getBKGInvoiceVOs(){
		BKGInvoiceVO[] vos = (BKGInvoiceVO[])models.toArray(new BKGInvoiceVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masterInv = this.masterInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo1 = this.custRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo2 = this.custRefNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclVvd = this.lclVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo3 = this.custRefNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrFlg = this.custCrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSvcScpCd = this.invSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
	
}
