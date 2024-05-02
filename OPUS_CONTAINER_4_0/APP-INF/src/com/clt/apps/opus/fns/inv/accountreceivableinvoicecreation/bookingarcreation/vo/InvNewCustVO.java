/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvNewCustVO.java
*@FileTitle : InvNewCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.20 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

public class InvNewCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvNewCustVO> models = new ArrayList<InvNewCustVO>();
	
	/* Column Info */
	private String xchRtDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String invTtlLoclAmt = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xchRtUsdTpCd = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String invXchRtDt = null;
	/* Column Info */
	private String mstBlNo = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String uiType = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String cgoMeasQty = null;
	/* Column Info */
	private String crTermDys = null;
	/* Column Info */
	private String splitFlag = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String invCustSeq = null;
	/* Column Info */
	private String xchRtN3rdTpCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String frtFwrdCustSeq = null;
	/* Column Info */
	private String custCrFlg = null;
	/* Column Info */
	private String obrdDt = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String frtFwrdCntCd = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String revSrcCd = null;	
	/* Column Info */
	private String vslCd = null;	
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String znIocCd = null;
	/* Column Info */
	private String blInvCfmDt = null;	
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String invCustFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArAmtVO invArAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArAmtVO> invArAmtVOs;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArChgVO invArChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArChgVO> invArChgVOs;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArCntrVO invArCntrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArCntrVO> invArCntrVOs;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArMnVO invArMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArMnVO> invArMnVOs;	
	
	public InvNewCustVO() {}

	public InvNewCustVO(String ibflag, String pagerows, String actCustCntCd, String actCustSeq, String custCrFlg, String invCustCntCd, String invCustSeq, String dueDt, String invRmk, String usdXchRt, String crTermDys, String arIfNo, String currCd, String glEffDt, String uiType, String xchRtUsdTpCd, String xchRtN3rdTpCd, String xchRtDt, String obrdDt, String invTtlLoclAmt, String invXchRt, String invXchRtDt, String invRefNo, String mstBlNo, String rfaNo, String scNo, String srepCd, String cgoWgt, String cgoMeasQty, String bkgTeuQty, String bkgFeuQty, String frtFwrdCntCd, String frtFwrdCustSeq, String splitFlag, String otsSmryCd, String revTpCd, String revSrcCd, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd,String znIocCd, String blInvCfmDt, String sailArrDt,String invCustFlg) {
		this.xchRtDt = xchRtDt;
		this.currCd = currCd;
		this.invTtlLoclAmt = invTtlLoclAmt;
		this.usdXchRt = usdXchRt;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.bkgFeuQty = bkgFeuQty;
		this.ibflag = ibflag;
		this.xchRtUsdTpCd = xchRtUsdTpCd;
		this.invCustCntCd = invCustCntCd;
		this.scNo = scNo;
		this.arIfNo = arIfNo;
		this.actCustCntCd = actCustCntCd;
		this.invXchRtDt = invXchRtDt;
		this.mstBlNo = mstBlNo;
		this.dueDt = dueDt;
		this.uiType = uiType;
		this.invXchRt = invXchRt;
		this.cgoWgt = cgoWgt;
		this.cgoMeasQty = cgoMeasQty;
		this.crTermDys = crTermDys;
		this.splitFlag = splitFlag;
		this.glEffDt = glEffDt;
		this.invRefNo = invRefNo;
		this.invCustSeq = invCustSeq;
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
		this.actCustSeq = actCustSeq;
		this.frtFwrdCustSeq = frtFwrdCustSeq;
		this.custCrFlg = custCrFlg;
		this.obrdDt = obrdDt;
		this.invRmk = invRmk;
		this.bkgTeuQty = bkgTeuQty;
		this.frtFwrdCntCd = frtFwrdCntCd;
		this.otsSmryCd = otsSmryCd;
		this.revTpCd = revTpCd;
		this.revSrcCd = revSrcCd;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.znIocCd = znIocCd;
		this.blInvCfmDt = blInvCfmDt;
		this.sailArrDt = sailArrDt;
		this.invCustFlg = invCustFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("inv_ttl_locl_amt", getInvTtlLoclAmt());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("xch_rt_usd_tp_cd", getXchRtUsdTpCd());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("inv_xch_rt_dt", getInvXchRtDt());
		this.hashColumns.put("mst_bl_no", getMstBlNo());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("ui_type", getUiType());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("cgo_meas_qty", getCgoMeasQty());
		this.hashColumns.put("cr_term_dys", getCrTermDys());
		this.hashColumns.put("split_flag", getSplitFlag());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("xch_rt_n3rd_tp_cd", getXchRtN3rdTpCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("frt_fwrd_cust_seq", getFrtFwrdCustSeq());
		this.hashColumns.put("cust_cr_flg", getCustCrFlg());
		this.hashColumns.put("obrd_dt", getObrdDt());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("zn_ioc_cd", getZnIocCd());
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("inv_cust_flg", getInvCustFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("inv_ttl_locl_amt", "invTtlLoclAmt");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("xch_rt_usd_tp_cd", "xchRtUsdTpCd");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("inv_xch_rt_dt", "invXchRtDt");
		this.hashFields.put("mst_bl_no", "mstBlNo");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("ui_type", "uiType");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("cgo_meas_qty", "cgoMeasQty");
		this.hashFields.put("cr_term_dys", "crTermDys");
		this.hashFields.put("split_flag", "splitFlag");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("xch_rt_n3rd_tp_cd", "xchRtN3rdTpCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("frt_fwrd_cust_seq", "frtFwrdCustSeq");
		this.hashFields.put("cust_cr_flg", "custCrFlg");
		this.hashFields.put("obrd_dt", "obrdDt");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("zn_ioc_cd", "znIocCd");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("inv_cust_flg", "invCustFlg");
		return this.hashFields;
	}
	
	
	/**
	 * @return the invCustFlg
	 */
	public String getInvCustFlg() {
		return invCustFlg;
	}

	/**
	 * @param invCustFlg the invCustFlg to set
	 */
	public void setInvCustFlg(String invCustFlg) {
		this.invCustFlg = invCustFlg;
	}

	/**
	 * @return the sailArrDt
	 */
	public String getSailArrDt() {
		return sailArrDt;
	}

	/**
	 * @param sailArrDt the sailArrDt to set
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}

	/**
	 * @return the znIocCd
	 */
	public String getZnIocCd() {
		return znIocCd;
	}

	/**
	 * @param znIocCd the znIocCd to set
	 */
	public void setZnIocCd(String znIocCd) {
		this.znIocCd = znIocCd;
	}

	/**
	 * @return the blInvCfmDt
	 */
	public String getBlInvCfmDt() {
		return blInvCfmDt;
	}

	/**
	 * @param blInvCfmDt the blInvCfmDt to set
	 */
	public void setBlInvCfmDt(String blInvCfmDt) {
		this.blInvCfmDt = blInvCfmDt;
	}

	/**
	 * @return the vslCd
	 */
	public String getVslCd() {
		return vslCd;
	}

	/**
	 * @param vslCd the vslCd to set
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * @return the skdVoyNo
	 */
	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	/**
	 * @param skdVoyNo the skdVoyNo to set
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * @return the skdDirCd
	 */
	public String getSkdDirCd() {
		return skdDirCd;
	}

	/**
	 * @param skdDirCd the skdDirCd to set
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @return the otsSmryCd
	 */
	public String getOtsSmryCd() {
		return otsSmryCd;
	}

	/**
	 * @param otsSmryCd the otsSmryCd to set
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}

	/**
	 * Column Info
	 * @return xchRtDt
	 */
	public String getXchRtDt() {
		return this.xchRtDt;
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
	 * @return invTtlLoclAmt
	 */
	public String getInvTtlLoclAmt() {
		return this.invTtlLoclAmt;
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
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return xchRtUsdTpCd
	 */
	public String getXchRtUsdTpCd() {
		return this.xchRtUsdTpCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return invXchRtDt
	 */
	public String getInvXchRtDt() {
		return this.invXchRtDt;
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
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return uiType
	 */
	public String getUiType() {
		return this.uiType;
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
	 * @return crTermDys
	 */
	public String getCrTermDys() {
		return this.crTermDys;
	}
	
	/**
	 * Column Info
	 * @return splitFlag
	 */
	public String getSplitFlag() {
		return this.splitFlag;
	}
	
	/**
	 * Column Info
	 * @return glEffDt
	 */
	public String getGlEffDt() {
		return this.glEffDt;
	}
	
	/**
	 * Column Info
	 * @return invRefNo
	 */
	public String getInvRefNo() {
		return this.invRefNo;
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
	 * @return xchRtN3rdTpCd
	 */
	public String getXchRtN3rdTpCd() {
		return this.xchRtN3rdTpCd;
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
	 * @return frtFwrdCustSeq
	 */
	public String getFrtFwrdCustSeq() {
		return this.frtFwrdCustSeq;
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
	 * @return obrdDt
	 */
	public String getObrdDt() {
		return this.obrdDt;
	}
	
	/**
	 * Column Info
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
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
	 * @return frtFwrdCntCd
	 */
	public String getFrtFwrdCntCd() {
		return this.frtFwrdCntCd;
	}
	

	/**
	 * Column Info
	 * @param xchRtDt
	 */
	public void setXchRtDt(String xchRtDt) {
		this.xchRtDt = xchRtDt;
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
	 * @param invTtlLoclAmt
	 */
	public void setInvTtlLoclAmt(String invTtlLoclAmt) {
		this.invTtlLoclAmt = invTtlLoclAmt;
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
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param xchRtUsdTpCd
	 */
	public void setXchRtUsdTpCd(String xchRtUsdTpCd) {
		this.xchRtUsdTpCd = xchRtUsdTpCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param invXchRtDt
	 */
	public void setInvXchRtDt(String invXchRtDt) {
		this.invXchRtDt = invXchRtDt;
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
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param uiType
	 */
	public void setUiType(String uiType) {
		this.uiType = uiType;
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
	 * @param crTermDys
	 */
	public void setCrTermDys(String crTermDys) {
		this.crTermDys = crTermDys;
	}
	
	/**
	 * Column Info
	 * @param splitFlag
	 */
	public void setSplitFlag(String splitFlag) {
		this.splitFlag = splitFlag;
	}
	
	/**
	 * Column Info
	 * @param glEffDt
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}
	
	/**
	 * Column Info
	 * @param invRefNo
	 */
	public void setInvRefNo(String invRefNo) {
		this.invRefNo = invRefNo;
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
	 * @param xchRtN3rdTpCd
	 */
	public void setXchRtN3rdTpCd(String xchRtN3rdTpCd) {
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
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
	 * @param frtFwrdCustSeq
	 */
	public void setFrtFwrdCustSeq(String frtFwrdCustSeq) {
		this.frtFwrdCustSeq = frtFwrdCustSeq;
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
	 * @param obrdDt
	 */
	public void setObrdDt(String obrdDt) {
		this.obrdDt = obrdDt;
	}
	
	/**
	 * Column Info
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCntCd
	 */
	public void setFrtFwrdCntCd(String frtFwrdCntCd) {
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * @return the invArAmtVO
	 */
	public InvArAmtVO getInvArAmtVO() {
		return invArAmtVO;
	}

	/**
	 * @param invArAmtVO the invArAmtVO to set
	 */
	public void setInvArAmtVO(InvArAmtVO invArAmtVO) {
		this.invArAmtVO = invArAmtVO;
	}

	/**
	 * @return the invArAmtVOs
	 */
	public List<InvArAmtVO> getInvArAmtVOs() {
		return invArAmtVOs;
	}

	/**
	 * @param invArAmtVOs the invArAmtVOs to set
	 */
	public void setInvArAmtVOs(List<InvArAmtVO> invArAmtVOs) {
		this.invArAmtVOs = invArAmtVOs;
	}

	/**
	 * @return the invArChgVO
	 */
	public InvArChgVO getInvArChgVO() {
		return invArChgVO;
	}

	/**
	 * @param invArChgVO the invArChgVO to set
	 */
	public void setInvArChgVO(InvArChgVO invArChgVO) {
		this.invArChgVO = invArChgVO;
	}

	/**
	 * @return the invArChgVOs
	 */
	public List<InvArChgVO> getInvArChgVOs() {
		return invArChgVOs;
	}

	/**
	 * @param invArChgVOs the invArChgVOs to set
	 */
	public void setInvArChgVOs(List<InvArChgVO> invArChgVOs) {
		this.invArChgVOs = invArChgVOs;
	}

	/**
	 * @return the invArCntrVO
	 */
	public InvArCntrVO getInvArCntrVO() {
		return invArCntrVO;
	}

	/**
	 * @param invArCntrVO the invArCntrVO to set
	 */
	public void setInvArCntrVO(InvArCntrVO invArCntrVO) {
		this.invArCntrVO = invArCntrVO;
	}

	/**
	 * @return the invArCntrVOs
	 */
	public List<InvArCntrVO> getInvArCntrVOs() {
		return invArCntrVOs;
	}

	/**
	 * @param invArCntrVOs the invArCntrVOs to set
	 */
	public void setInvArCntrVOs(List<InvArCntrVO> invArCntrVOs) {
		this.invArCntrVOs = invArCntrVOs;
	}

	/**
	 * @return the invArMnVO
	 */
	public InvArMnVO getInvArMnVO() {
		return invArMnVO;
	}

	/**
	 * @param invArMnVO the invArMnVO to set
	 */
	public void setInvArMnVO(InvArMnVO invArMnVO) {
		this.invArMnVO = invArMnVO;
	}

	/**
	 * @return the invArMnVOs
	 */
	public List<InvArMnVO> getInvArMnVOs() {
		return invArMnVOs;
	}

	/**
	 * @param invArMnVOs the invArMnVOs to set
	 */
	public void setInvArMnVOs(List<InvArMnVO> invArMnVOs) {
		this.invArMnVOs = invArMnVOs;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXchRtDt(JSPUtil.getParameter(request, "xch_rt_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setInvTtlLoclAmt(JSPUtil.getParameter(request, "inv_ttl_locl_amt", ""));
		setUsdXchRt(JSPUtil.getParameter(request, "usd_xch_rt", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, "bkg_feu_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setXchRtUsdTpCd(JSPUtil.getParameter(request, "xch_rt_usd_tp_cd", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, "inv_cust_cnt_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setInvXchRtDt(JSPUtil.getParameter(request, "inv_xch_rt_dt", ""));
		setMstBlNo(JSPUtil.getParameter(request, "mst_bl_no", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setUiType(JSPUtil.getParameter(request, "ui_type", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
		setCgoMeasQty(JSPUtil.getParameter(request, "cgo_meas_qty", ""));
		setCrTermDys(JSPUtil.getParameter(request, "cr_term_dys", ""));
		setSplitFlag(JSPUtil.getParameter(request, "split_flag", ""));
		setGlEffDt(JSPUtil.getParameter(request, "gl_eff_dt", ""));
		setInvRefNo(JSPUtil.getParameter(request, "inv_ref_no", ""));
		setInvCustSeq(JSPUtil.getParameter(request, "inv_cust_seq", ""));
		setXchRtN3rdTpCd(JSPUtil.getParameter(request, "xch_rt_n3rd_tp_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setFrtFwrdCustSeq(JSPUtil.getParameter(request, "frt_fwrd_cust_seq", ""));
		setCustCrFlg(JSPUtil.getParameter(request, "cust_cr_flg", ""));
		setObrdDt(JSPUtil.getParameter(request, "obrd_dt", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, "bkg_teu_qty", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, "frt_fwrd_cnt_cd", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, "ots_smry_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setZnIocCd(JSPUtil.getParameter(request, "zn_ioc_cd", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request, "bl_inv_cfm_dt", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setInvCustFlg(JSPUtil.getParameter(request, "inv_cust_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvNewCustVO[]
	 */
	public InvNewCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvNewCustVO[]
	 */
	public InvNewCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvNewCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xchRtDt = (JSPUtil.getParameter(request, prefix	+ "xch_rt_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] invTtlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_ttl_locl_amt", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] xchRtUsdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_usd_tp_cd", length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] invXchRtDt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt_dt", length));
			String[] mstBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_bl_no", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] uiType = (JSPUtil.getParameter(request, prefix	+ "ui_type", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] cgoMeasQty = (JSPUtil.getParameter(request, prefix	+ "cgo_meas_qty", length));
			String[] crTermDys = (JSPUtil.getParameter(request, prefix	+ "cr_term_dys", length));
			String[] splitFlag = (JSPUtil.getParameter(request, prefix	+ "split_flag", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq", length));
			String[] xchRtN3rdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_n3rd_tp_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] frtFwrdCustSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cust_seq", length));
			String[] custCrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_cr_flg", length));
			String[] obrdDt = (JSPUtil.getParameter(request, prefix	+ "obrd_dt", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] znIocCd = (JSPUtil.getParameter(request, prefix	+ "zn_ioc_cd", length));
			String[] blInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_cfm_dt", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] invCustFlg = (JSPUtil.getParameter(request, prefix	+ "inv_cust_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvNewCustVO();
				if (xchRtDt[i] != null)
					model.setXchRtDt(xchRtDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (invTtlLoclAmt[i] != null)
					model.setInvTtlLoclAmt(invTtlLoclAmt[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xchRtUsdTpCd[i] != null)
					model.setXchRtUsdTpCd(xchRtUsdTpCd[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (invXchRtDt[i] != null)
					model.setInvXchRtDt(invXchRtDt[i]);
				if (mstBlNo[i] != null)
					model.setMstBlNo(mstBlNo[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (uiType[i] != null)
					model.setUiType(uiType[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (cgoMeasQty[i] != null)
					model.setCgoMeasQty(cgoMeasQty[i]);
				if (crTermDys[i] != null)
					model.setCrTermDys(crTermDys[i]);
				if (splitFlag[i] != null)
					model.setSplitFlag(splitFlag[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				if (xchRtN3rdTpCd[i] != null)
					model.setXchRtN3rdTpCd(xchRtN3rdTpCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (frtFwrdCustSeq[i] != null)
					model.setFrtFwrdCustSeq(frtFwrdCustSeq[i]);
				if (custCrFlg[i] != null)
					model.setCustCrFlg(custCrFlg[i]);
				if (obrdDt[i] != null)
					model.setObrdDt(obrdDt[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (znIocCd[i] != null)
					model.setZnIocCd(znIocCd[i]);
				if (blInvCfmDt[i] != null)
					model.setBlInvCfmDt(blInvCfmDt[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (invCustFlg[i] != null)
					model.setInvCustFlg(invCustFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvNewCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvNewCustVO[]
	 */
	public InvNewCustVO[] getInvNewCustVOs(){
		InvNewCustVO[] vos = (InvNewCustVO[])models.toArray(new InvNewCustVO[models.size()]);
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
		this.xchRtDt = this.xchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlLoclAmt = this.invTtlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtUsdTpCd = this.xchRtUsdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtDt = this.invXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlNo = this.mstBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiType = this.uiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMeasQty = this.cgoMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTermDys = this.crTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlag = this.splitFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtN3rdTpCd = this.xchRtN3rdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCustSeq = this.frtFwrdCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrFlg = this.custCrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdDt = this.obrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znIocCd = this.znIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt = this.blInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustFlg = this.invCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
