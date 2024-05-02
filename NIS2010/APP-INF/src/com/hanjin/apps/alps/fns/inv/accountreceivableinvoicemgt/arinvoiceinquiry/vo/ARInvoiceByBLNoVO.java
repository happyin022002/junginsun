/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceByBLNoVO.java
*@FileTitle : ARInvoiceByBLNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.08.27 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceByBLNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceByBLNoVO> models = new ArrayList<ARInvoiceByBLNoVO>();
	
	private List<ARInvoiceChargeSumVO> listInvoiceChargeSumVO = null;
	
	private List<ARInvoiceChargeByBLNoVO> listInvoiceChargeByBLNoVO = null;

	private List<ARInvoiceHistoryByBLNoVO> listInvoiceHistoryByBLNoVO = null;
	
	private List<ARInvoiceContainerVO> listInvoiceContainerVO = null;
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String good = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Column Info */
	private String nogood = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String mstBlNo = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String cgoMeasQty = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String crCurrCd = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String bkgTeuQty = null;
	
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String invCustSeq = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String xchRtUsdTpCd = null;
	/* Column Info */
	private String rvsChgFlg = null;
	/* Column Info */
	private String invTpCd = null;
	
	/* Column Info */
	private List<String> listArOfcCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceByBLNoVO() {}

public ARInvoiceByBLNoVO(String ibflag, String pagerows, String blSrcNo, String bkgNo, String blTpCd, String arOfcCd, String actCustCntCd, String actCustSeq, String custLglEngNm, String custRgstNo, String revTpCd, String revSrcCd, String crCurrCd, String crAmt, String ibCrTermDys, String obCrTermDys, String crCltOfcCd, String vvd, String svcScpCd, String ioBndCd, String sailArrDt, String trunkVvd, String slanCd, String porCd, String polCd, String podCd, String delCd, String mstBlNo, String rfaNo, String scNo, String srepCd, String cgoWgt, String cgoMeasQty, String whfDeclNo, String bkgTeuQty, String bkgFeuQty, String usdXchRt, String good, String nogood, String invNo, String issDt, String invCustCntCd, String invCustSeq, String loclCurrCd, String dueDt, String invRmk, String ctrtOfcCd, String xchRtUsdTpCd, String rvsChgFlg, String invTpCd) {
		this.porCd = porCd;
		this.svcScpCd = svcScpCd;
		this.usdXchRt = usdXchRt;
		this.trunkVvd = trunkVvd;
		this.good = good;
		this.custRgstNo = custRgstNo;
		this.whfDeclNo = whfDeclNo;
		this.nogood = nogood;
		this.srepCd = srepCd;
		this.obCrTermDys = obCrTermDys;
		this.crCltOfcCd = crCltOfcCd;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibCrTermDys = ibCrTermDys;
		this.bkgFeuQty = bkgFeuQty;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.crAmt = crAmt;
		this.revSrcCd = revSrcCd;
		this.scNo = scNo;
		this.actCustCntCd = actCustCntCd;
		this.mstBlNo = mstBlNo;
		this.cgoWgt = cgoWgt;
		this.cgoMeasQty = cgoMeasQty;
		this.blSrcNo = blSrcNo;
		this.actCustSeq = actCustSeq;
		this.delCd = delCd;
		this.ioBndCd = ioBndCd;
		this.crCurrCd = crCurrCd;
		this.revTpCd = revTpCd;
		this.arOfcCd = arOfcCd;
		this.custLglEngNm = custLglEngNm;
		this.blTpCd = blTpCd;
		this.invNo = invNo;
		this.podCd = podCd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.bkgTeuQty = bkgTeuQty;
		this.issDt = issDt;
		this.invCustCntCd = invCustCntCd;
		this.invCustSeq = invCustSeq;
		this.loclCurrCd = loclCurrCd;
		this.dueDt = dueDt;
		this.invRmk = invRmk;
		this.ctrtOfcCd = ctrtOfcCd;
		this.xchRtUsdTpCd = xchRtUsdTpCd;
		this.rvsChgFlg = rvsChgFlg;
		this.invTpCd = invTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("good", getGood());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("nogood", getNogood());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("mst_bl_no", getMstBlNo());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("cgo_meas_qty", getCgoMeasQty());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("xch_rt_usd_tp_cd", getXchRtUsdTpCd());
		this.hashColumns.put("rvs_chg_flg", getRvsChgFlg());
		this.hashColumns.put("inv_tp_cd", getInvTpCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("good", "good");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("nogood", "nogood");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("mst_bl_no", "mstBlNo");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("cgo_meas_qty", "cgoMeasQty");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("xch_rt_usd_tp_cd", "xchRtUsdTpCd");
		this.hashFields.put("rvs_chg_flg", "rvsChgFlg");
		this.hashFields.put("inv_tp_cd", "invTpCd");
		return this.hashFields;
	}
	
	
	/**
	 * @return the rvsChgFlg
	 */
	public String getRvsChgFlg() {
		return rvsChgFlg;
	}

	/**
	 * @param rvsChgFlg the rvsChgFlg to set
	 */
	public void setRvsChgFlg(String rvsChgFlg) {
		this.rvsChgFlg = rvsChgFlg;
	}

	/**
	 * @return the xchRtUsdTpCd
	 */
	public String getXchRtUsdTpCd() {
		return xchRtUsdTpCd;
	}

	/**
	 * @param xchRtUsdTpCd the xchRtUsdTpCd to set
	 */
	public void setXchRtUsdTpCd(String xchRtUsdTpCd) {
		this.xchRtUsdTpCd = xchRtUsdTpCd;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return usdXchRt
	 */
	public String getUsdXchRt() {
		return this.usdXchRt;
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
	 * @return good
	 */
	public String getGood() {
		return this.good;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
	}
	
	/**
	 * Column Info
	 * @return whfDeclNo
	 */
	public String getWhfDeclNo() {
		return this.whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @return nogood
	 */
	public String getNogood() {
		return this.nogood;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
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
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return revSrcCd
	 */
	public String getRevSrcCd() {
		return this.revSrcCd;
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
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return mstBlNo
	 */
	public String getMstBlNo() {
		return this.mstBlNo;
	}
	
	/**
	 * Column Info
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
	}
	
	/**
	 * Column Info
	 * @return cgoMeasQty
	 */
	public String getCgoMeasQty() {
		return this.cgoMeasQty;
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
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
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
	 * @return crCurrCd
	 */
	public String getCrCurrCd() {
		return this.crCurrCd;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param usdXchRt
	 */
	public void setUsdXchRt(String usdXchRt) {
		this.usdXchRt = usdXchRt;
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
	 * @param good
	 */
	public void setGood(String good) {
		this.good = good;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}
	
	/**
	 * Column Info
	 * @param whfDeclNo
	 */
	public void setWhfDeclNo(String whfDeclNo) {
		this.whfDeclNo = whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @param nogood
	 */
	public void setNogood(String nogood) {
		this.nogood = nogood;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param crCltOfcCd
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
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
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param revSrcCd
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
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
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param mstBlNo
	 */
	public void setMstBlNo(String mstBlNo) {
		this.mstBlNo = mstBlNo;
	}
	
	/**
	 * Column Info
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
	}
	
	/**
	 * Column Info
	 * @param cgoMeasQty
	 */
	public void setCgoMeasQty(String cgoMeasQty) {
		this.cgoMeasQty = cgoMeasQty;
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
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
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
	 * @param crCurrCd
	 */
	public void setCrCurrCd(String crCurrCd) {
		this.crCurrCd = crCurrCd;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	public String getIssDt() {
		return issDt;
	}

	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}

	public String getInvCustCntCd() {
		return invCustCntCd;
	}

	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}

	public String getInvCustSeq() {
		return invCustSeq;
	}

	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}

	public String getLoclCurrCd() {
		return loclCurrCd;
	}

	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}

	public String getDueDt() {
		return dueDt;
	}

	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	public String getInvRmk() {
		return invRmk;
	}

	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}

	public String getCtrtOfcCd() {
		return ctrtOfcCd;
	}

	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}

	public List<ARInvoiceChargeSumVO> getListInvoiceChargeSumVO() {
		return listInvoiceChargeSumVO;
	}

	public void setListInvoiceChargeSumVO(List<ARInvoiceChargeSumVO> listInvoiceChargeSumVO) {
		this.listInvoiceChargeSumVO = listInvoiceChargeSumVO;
	}

	public List<ARInvoiceChargeByBLNoVO> getListInvoiceChargeByBLNoVO() {
		return listInvoiceChargeByBLNoVO;
	}

	public void setListInvoiceChargeByBLNoVO(List<ARInvoiceChargeByBLNoVO> listInvoiceChargeByBLNoVO) {
		this.listInvoiceChargeByBLNoVO = listInvoiceChargeByBLNoVO;
	}

	public List<ARInvoiceHistoryByBLNoVO> getListInvoiceHistoryByBLNoVO() {
		return listInvoiceHistoryByBLNoVO;
	}

	public void setListInvoiceHistoryByBLNoVO(List<ARInvoiceHistoryByBLNoVO> listInvoiceHistoryByBLNoVO) {
		this.listInvoiceHistoryByBLNoVO = listInvoiceHistoryByBLNoVO;
	}

	public List<ARInvoiceContainerVO> getListInvoiceContainerVO() {
		return listInvoiceContainerVO;
	}

	public void setListInvoiceContainerVO(List<ARInvoiceContainerVO> listInvoiceContainerVO) {
		this.listInvoiceContainerVO = listInvoiceContainerVO;
	}
	
	public List<String> getListArOfcCd() {
		return listArOfcCd;
	}

	public void setListArOfcCd(List<String> listArOfcCd) {
		this.listArOfcCd = listArOfcCd;
	}
	
	/**
	 * @return the invTpCd
	 */
	public String getInvTpCd() {
		return invTpCd;
	}

	/**
	 * @param invTpCd the invTpCd to set
	 */
	public void setInvTpCd(String invTpCd) {
		this.invTpCd = invTpCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setUsdXchRt(JSPUtil.getParameter(request, "usd_xch_rt", ""));
		setTrunkVvd(JSPUtil.getParameter(request, "trunk_vvd", ""));
		setGood(JSPUtil.getParameter(request, "good", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setWhfDeclNo(JSPUtil.getParameter(request, "whf_decl_no", ""));
		setNogood(JSPUtil.getParameter(request, "nogood", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setObCrTermDys(JSPUtil.getParameter(request, "ob_cr_term_dys", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, "cr_clt_ofc_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, "ib_cr_term_dys", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, "bkg_feu_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setMstBlNo(JSPUtil.getParameter(request, "mst_bl_no", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
		setCgoMeasQty(JSPUtil.getParameter(request, "cgo_meas_qty", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCrCurrCd(JSPUtil.getParameter(request, "cr_curr_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, "bkg_teu_qty", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, "inv_cust_cnt_cd", ""));
		setInvCustSeq(JSPUtil.getParameter(request, "inv_cust_seq", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, "ctrt_ofc_cd", ""));
		setXchRtUsdTpCd(JSPUtil.getParameter(request, "xch_rt_usd_tp_cd", ""));
		setRvsChgFlg(JSPUtil.getParameter(request, "rvs_chg_flg", ""));
		setInvTpCd(JSPUtil.getParameter(request, "inv_tp_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceByBLNoVO[]
	 */
	public ARInvoiceByBLNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceByBLNoVO[]
	 */
	public ARInvoiceByBLNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceByBLNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] good = (JSPUtil.getParameter(request, prefix	+ "good", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] nogood = (JSPUtil.getParameter(request, prefix	+ "nogood", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] mstBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_bl_no", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] cgoMeasQty = (JSPUtil.getParameter(request, prefix	+ "cgo_meas_qty", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd", length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] xchRtUsdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_usd_tp_cd", length));
			String[] rvsChgFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_chg_flg", length));
			String[] invTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceByBLNoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (good[i] != null)
					model.setGood(good[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (nogood[i] != null)
					model.setNogood(nogood[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (mstBlNo[i] != null)
					model.setMstBlNo(mstBlNo[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (cgoMeasQty[i] != null)
					model.setCgoMeasQty(cgoMeasQty[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (crCurrCd[i] != null)
					model.setCrCurrCd(crCurrCd[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (xchRtUsdTpCd[i] != null)
					model.setXchRtUsdTpCd(xchRtUsdTpCd[i]);
				if (rvsChgFlg[i] != null)
					model.setRvsChgFlg(rvsChgFlg[i]);
				if (invTpCd[i] != null)
					model.setInvTpCd(invTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceByBLNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceByBLNoVO[]
	 */
	public ARInvoiceByBLNoVO[] getARInvoiceByBLNoVOs(){
		ARInvoiceByBLNoVO[] vos = (ARInvoiceByBLNoVO[])models.toArray(new ARInvoiceByBLNoVO[models.size()]);
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
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.good = this.good .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nogood = this.nogood .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlNo = this.mstBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMeasQty = this.cgoMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtUsdTpCd = this.xchRtUsdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsChgFlg = this.rvsChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpCd = this.invTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
