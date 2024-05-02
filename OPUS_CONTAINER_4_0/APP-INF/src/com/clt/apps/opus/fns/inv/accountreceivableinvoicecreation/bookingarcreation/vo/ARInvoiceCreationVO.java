/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCreationVO.java
*@FileTitle : ARInvoiceCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.01 정휘택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGContainerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceCreationVO> models = new ArrayList<ARInvoiceCreationVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String masterInv = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String lclVvd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String coRef = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String crCurrCd = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String siRefNo = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String mriMaxSeq = null;	
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String invCustSeq = null;	
	/* Column Info */
	private String lclCurr = null;
	/* Column Info */
	private String sailingDt = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String crFlg = null;
	/* Column Info */
	private String crTerm = null;
	/* Column Info */
	private String subsCoCd = null;
	/* Column Info */
	private String invCoaAcctCd = null;
	/* Column Info */
	private String zoneIoc = null;	
	/* Column Info */
	private String cityCd = null;	
	/* Column Info */
	private String blObrdDt = null;	
	/* Column Info */
	private String revVvd = null;	
	/* Column Info */
	private String revLane = null;	
	/* Column Info */
	private String usdExrateType = null;
	/* Column Info */
	private String thirdExrateType = null;
	/* Column Info */
	private String exRateDate = null;	
	/* Column Info */
	private String usdXchRt = null;	
	/* Column Info */
	private String totalLocalAmt = null;
	/* Column Info */
	private String userId = null;	
	/* Column Info */
	private String invSvcScpCd = null;
	
	/* Other Revenue 화면 추가 시작 */
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String arTaxIndCd = null;
	/* Column Info */
	private String slpNo = null;
	/* Column Info */
	private String taxXchRt = null;
	/* Column Info */
	private String blSrcNo = null;
	
	/* Column Info */
	private String invCreFlg = null;
	/* Column Info */
	private String invFirstFlg = null;
	/* Column Info */
	private String locCd = null;
	
	/* Column Info */
	private String arHdQtrOfcCd = null;
	private String arAgnStlCd = null;
	
	private String deltFlg = null;
		
	/* Other Revenue 화면 추가 끝 */

	private List<BkgChgeListVO> bkgChgeListVOs;
	private List<BKGContainerVO> bkgContainerVOs;	

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
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceChargeSumVO arInvChgSumVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<ARInvoiceChargeSumVO> arInvChgSumVOs;	
		
	public ARInvoiceCreationVO() {}

	public ARInvoiceCreationVO(String ibflag, String pagerows, String blNo, String bkgNo, String bkgNoSplit, String custCntCd, String custSeq, String custNm, String custRgstNo, String revSrcCd, String revTpCd, String crCurrCd, String crAmt, String obCrTermDys, String ibCrTermDys, String crCltOfcCd, String lclVvd, String svcScpCd, String ioBndCd, String sailArrDt, String trunkVvd, String porCd, String polCd, String podCd, String delCd, String masterInv, String coRef, String bkgTeuQty, String ofcCd, String svrId, String mriMaxSeq, String invCustCntCd, String invCustSeq, String lclCurr, String sailingDt, String laneCd, String crFlg, String crTerm, String subsCoCd, String invCoaAcctCd, String zoneIoc, String cityCd, String blObrdDt, String revVvd, String revLane, String usdExrateType, String thirdExrateType, String exRateDate, String usdXchRt, String totalLocalAmt, String userId, String bkgFeuQty, String invRefNo, String bkgRefNo, String siRefNo, String dueDt, String effDt, String invRmk, String arTaxIndCd, String slpNo, String taxXchRt, String blSrcNo, String invCreFlg, String locCd, String arHdQtrOfcCd,String arAgnStlCd, String invFirstFlg, String deltFlg, String invSvcScpCd) {
		this.porCd = porCd;
		this.masterInv = masterInv;
		this.custNm = custNm;
		this.lclVvd = lclVvd;
		this.svcScpCd = svcScpCd;
		this.coRef = coRef;
		this.trunkVvd = trunkVvd;
		this.custRgstNo = custRgstNo;
		this.obCrTermDys = obCrTermDys;
		this.blNo = blNo;
		this.crCltOfcCd = crCltOfcCd;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.ibCrTermDys = ibCrTermDys;
		this.effDt = effDt;
		this.bkgFeuQty = bkgFeuQty;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.crAmt = crAmt;
		this.dueDt = dueDt;
		this.custCntCd = custCntCd;
		this.invRefNo = invRefNo;
		this.bkgNoSplit = bkgNoSplit;
		this.delCd = delCd;
		this.custSeq = custSeq;
		this.ioBndCd = ioBndCd;
		this.crCurrCd = crCurrCd;
		this.bkgRefNo = bkgRefNo;
		this.podCd = podCd;
		this.siRefNo = siRefNo;
		this.revSrcCd = revSrcCd;
		this.revTpCd = revTpCd;
		this.bkgNo = bkgNo;
		this.bkgTeuQty = bkgTeuQty;
		this.ofcCd = ofcCd;
		this.svrId = svrId;
		this.mriMaxSeq = mriMaxSeq;
		this.invCustCntCd = invCustCntCd;
		this.invCustSeq = invCustSeq;
		this.lclCurr = lclCurr;
		this.sailingDt = sailingDt;
		this.laneCd = laneCd;
		this.crFlg = crFlg;
		this.crTerm = crTerm;
		this.subsCoCd = subsCoCd;
		this.invCoaAcctCd = invCoaAcctCd;
		this.zoneIoc = zoneIoc;
		this.cityCd = cityCd;
		this.blObrdDt = blObrdDt;
		this.revVvd = revVvd;
		this.revLane = revLane;
		this.usdExrateType = usdExrateType;
		this.thirdExrateType = thirdExrateType;
		this.exRateDate = exRateDate;
		this.usdXchRt = usdXchRt;	
		this.totalLocalAmt = totalLocalAmt;
		this.userId = userId;
		this.invRmk = invRmk;
		this.arTaxIndCd = arTaxIndCd;
		this.slpNo = slpNo;
		this.taxXchRt = taxXchRt;
		this.blSrcNo = blSrcNo;
		this.invCreFlg = invCreFlg;
		this.locCd = locCd;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.arAgnStlCd = arAgnStlCd;
		this.invFirstFlg = invFirstFlg;
		this.deltFlg = deltFlg;
		this.invSvcScpCd = invSvcScpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("master_inv", getMasterInv());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("lcl_vvd", getLclVvd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("co_ref", getCoRef());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("si_ref_no", getSiRefNo());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("mri_max_seq", getMriMaxSeq());	
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("lcl_curr", getLclCurr());
		this.hashColumns.put("sailing_dt", getSailingDt());		
		this.hashColumns.put("lane_cd", getLaneCd());		
		this.hashColumns.put("cr_flg", getCrFlg());
		this.hashColumns.put("cr_term", getCrTerm());
		this.hashColumns.put("subs_co_cd", getSubsCoCd());
		this.hashColumns.put("inv_coa_acct_cd", getInvCoaAcctCd());
		this.hashColumns.put("zone_ioc", getZoneIoc());
		this.hashColumns.put("city_cd", getCityCd());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("rev_lane", getRevLane());
		this.hashColumns.put("usd_exrate_type", getUsdExrateType());
		this.hashColumns.put("third_exrate_type", getThirdExrateType());
		this.hashColumns.put("ex_rate_date", getExRateDate());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("total_local_amt", getTotalLocalAmt());	
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("ar_tax_ind_cd", getArTaxIndCd());
		this.hashColumns.put("slp_no", getSlpNo());
		this.hashColumns.put("tax_xch_rt", getTaxXchRt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("inv_cre_flg", getInvCreFlg());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("ar_agn_stl_cd", getArAgnStlCd());
		this.hashColumns.put("inv_first_flg", getInvFirstFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("inv_svc_scp_cd", getInvSvcScpCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("master_inv", "masterInv");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("lcl_vvd", "lclVvd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("co_ref", "coRef");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("si_ref_no", "siRefNo");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("mri_max_seq", "mriMaxSeq");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("lcl_curr", "lclCurr");
		this.hashFields.put("sailing_dt", "sailingDt");	
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("cr_term", "crTerm");
		this.hashFields.put("subs_co_cd", "subsCoCd");
		this.hashFields.put("inv_coa_acct_cd", "invCoaAcctCd");
		this.hashFields.put("zone_ioc", "zoneIoc");
		this.hashFields.put("city_cd", "cityCd");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("rev_lane", "revLane");
		this.hashFields.put("usd_exrate_type", "usdExrateType");
		this.hashFields.put("third_exrate_type", "thirdExrateType");		
		this.hashFields.put("ex_rate_date", "exRateDate");		
		this.hashFields.put("usd_xch_rt", "usdXchRt");	
		this.hashFields.put("total_local_amt", "totalLocalAmt");
		this.hashFields.put("user_id", "userID");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("ar_tax_ind_cd", "arTaxIndCd");
		this.hashFields.put("slp_no", "slpNo");
		this.hashFields.put("tax_xch_rt", "taxXchRt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("inv_cre_flg", "invCreFlg");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("ar_agn_stl_cd", "arAgnStlCd");
		this.hashFields.put("inv_first_flg", "invFirstFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("inv_svc_scp_cd", "invSvcScpCd");
		
		return this.hashFields;
	}
	
	
	/**
	 * @return the invFirstFlg
	 */
	public String getInvFirstFlg() {
		return invFirstFlg;
	}

	/**
	 * @param invFirstFlg the invFirstFlg to set
	 */
	public void setInvFirstFlg(String invFirstFlg) {
		this.invFirstFlg = invFirstFlg;
	}

	/**
	 * @return the arAgnStlCd
	 */
	public String getArAgnStlCd() {
		return arAgnStlCd;
	}

	/**
	 * @param arAgnStlCd the arAgnStlCd to set
	 */
	public void setArAgnStlCd(String arAgnStlCd) {
		this.arAgnStlCd = arAgnStlCd;
	}

	/**
	 * @return the arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return arHdQtrOfcCd;
	}

	/**
	 * @param arHdQtrOfcCd the arHdQtrOfcCd to set
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}

	/**
	 * @return the locCd
	 */
	public String getLocCd() {
		return locCd;
	}

	/**
	 * @param locCd the locCd to set
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * @return the invCreFlg
	 */
	public String getInvCreFlg() {
		return invCreFlg;
	}

	/**
	 * @param invCreFlg the invCreFlg to set
	 */
	public void setInvCreFlg(String invCreFlg) {
		this.invCreFlg = invCreFlg;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return coRef
	 */
	public String getCoRef() {
		return this.coRef;
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
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
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
	 * @return invRefNo
	 */
	public String getInvRefNo() {
		return this.invRefNo;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return bkgRefNo
	 */
	public String getBkgRefNo() {
		return this.bkgRefNo;
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
	 * @return siRefNo
	 */
	public String getSiRefNo() {
		return this.siRefNo;
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
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param coRef
	 */
	public void setCoRef(String coRef) {
		this.coRef = coRef;
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
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
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
	 * @param invRefNo
	 */
	public void setInvRefNo(String invRefNo) {
		this.invRefNo = invRefNo;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param bkgRefNo
	 */
	public void setBkgRefNo(String bkgRefNo) {
		this.bkgRefNo = bkgRefNo;
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
	 * @param siRefNo
	 */
	public void setSiRefNo(String siRefNo) {
		this.siRefNo = siRefNo;
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
	
	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}		

	public String getSvrId() {
		return svrId;
	}

	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}

	public String getRevTpCd() {
		return revTpCd;
	}

	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
		
	public String getMriMaxSeq() {
		return mriMaxSeq;
	}

	public void setMriMaxSeq(String mriMaxSeq) {
		this.mriMaxSeq = mriMaxSeq;
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
	
	public String getLclCurr() {
		return lclCurr;
	}

	public void setLclCurr(String lclCurr) {
		this.lclCurr = lclCurr;
	}

	public String getSailingDt() {
		return sailingDt;
	}

	public void setSailingDt(String sailingDt) {
		this.sailingDt = sailingDt;
	}	

	public String getLaneCd() {
		return laneCd;
	}

	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}

	public String getCrFlg() {
		return crFlg;
	}

	public void setCrFlg(String crFlg) {
		this.crFlg = crFlg;
	}
    
	public String getCrTerm() {
		return crTerm;
	}

	public void setCrTerm(String crTerm) {
		this.crTerm = crTerm;
	}

	public String getSubsCoCd() {
		return subsCoCd;
	}

	public void setSubsCoCd(String subsCoCd) {
		this.subsCoCd = subsCoCd;
	}

	public String getInvCoaAcctCd() {
		return invCoaAcctCd;
	}

	public void setInvCoaAcctCd(String invCoaAcctCd) {
		this.invCoaAcctCd = invCoaAcctCd;
	}

	public String getZoneIoc() {
		return zoneIoc;
	}

	public void setZoneIoc(String zoneIoc) {
		this.zoneIoc = zoneIoc;
	}

	public String getCityCd() {
		return cityCd;
	}

	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
	}

	public String getBlObrdDt() {
		return blObrdDt;
	}

	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
	}

	public String getRevVvd() {
		return revVvd;
	}

	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}

	public String getRevLane() {
		return revLane;
	}

	public void setRevLane(String revLane) {
		this.revLane = revLane;
	}

	public String getUsdExrateType() {
		return usdExrateType;
	}

	public void setUsdExrateType(String usdExrateType) {
		this.usdExrateType = usdExrateType;
	}

	public String getThirdExrateType() {
		return thirdExrateType;
	}

	public void setThirdExrateType(String thirdExrateType) {
		this.thirdExrateType = thirdExrateType;
	}

	public String getExRateDate() {
		return exRateDate;
	}

	public void setExRateDate(String exRateDate) {
		this.exRateDate = exRateDate;
	}

	public String getUsdXchRt() {
		return usdXchRt;
	}

	public void setUsdXchRt(String usdXchRt) {
		this.usdXchRt = usdXchRt;
	}

	public String getTotalLocalAmt() {
		return totalLocalAmt;
	}

	public void setTotalLocalAmt(String totalLocalAmt) {
		this.totalLocalAmt = totalLocalAmt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}

	public List<BkgChgeListVO> getBkgChgeListVOs() {
		return bkgChgeListVOs;
	}

	public void setBkgChgeListVOs(List<BkgChgeListVO> bkgChgeListVOs) {
		this.bkgChgeListVOs = bkgChgeListVOs;
	}

	public List<BKGContainerVO> getBkgContainerVOs() {
		return bkgContainerVOs;
	}

	public void setBkgContainerVOs(List<BKGContainerVO> bkgContainerVOs) {
		this.bkgContainerVOs = bkgContainerVOs;
	}
	
	public String getArTaxIndCd() {
		return arTaxIndCd;
	}

	public void setArTaxIndCd(String arTaxIndCd) {
		this.arTaxIndCd = arTaxIndCd;
	}

	public String getTaxXchRt() {
		return taxXchRt;
	}

	public void setTaxXchRt(String taxXchRt) {
		this.taxXchRt = taxXchRt;
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

	public String getSlpNo() {
		return slpNo;
	}

	public void setSlpNo(String slpNo) {
		this.slpNo = slpNo;
	}

	public String getBlSrcNo() {
		return blSrcNo;
	}

	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
		
	/**
	 * @return the arInvChgSumVO
	 */
	public ARInvoiceChargeSumVO getArInvChgSumVO() {
		return arInvChgSumVO;
	}

	/**
	 * @param arInvChgSumVO the arInvChgSumVO to set
	 */
	public void setArInvChgSumVO(ARInvoiceChargeSumVO arInvChgSumVO) {
		this.arInvChgSumVO = arInvChgSumVO;
	}

	/**
	 * @return the arInvChgSumVOs
	 */
	public List<ARInvoiceChargeSumVO> getArInvChgSumVOs() {
		return arInvChgSumVOs;
	}

	/**
	 * @param arInvChgSumVOs the arInvChgSumVOs to set
	 */
	public void setArInvChgSumVOs(List<ARInvoiceChargeSumVO> arInvChgSumVOs) {
		this.arInvChgSumVOs = arInvChgSumVOs;
	}

	/**
	 * @return the deltFlg
	 */
	public String getDeltFlg() {
		return deltFlg;
	}

	/**
	 * @param deltFlg the deltFlg to set
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setMasterInv(JSPUtil.getParameter(request, "master_inv", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setLclVvd(JSPUtil.getParameter(request, "lcl_vvd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCoRef(JSPUtil.getParameter(request, "co_ref", ""));
		setTrunkVvd(JSPUtil.getParameter(request, "trunk_vvd", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setObCrTermDys(JSPUtil.getParameter(request, "ob_cr_term_dys", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, "cr_clt_ofc_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, "ib_cr_term_dys", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, "bkg_feu_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setInvRefNo(JSPUtil.getParameter(request, "inv_ref_no", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCrCurrCd(JSPUtil.getParameter(request, "cr_curr_cd", ""));
		setBkgRefNo(JSPUtil.getParameter(request, "bkg_ref_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSiRefNo(JSPUtil.getParameter(request, "si_ref_no", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, "bkg_teu_qty", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setMriMaxSeq(JSPUtil.getParameter(request, "mri_max_seq", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, "inv_cust_cnt_cd", ""));
		setInvCustSeq(JSPUtil.getParameter(request, "inv_cust_seq", ""));
		setLclCurr(JSPUtil.getParameter(request, "lcl_curr", ""));
		setSailingDt(JSPUtil.getParameter(request, "sailing_dt", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setCrFlg(JSPUtil.getParameter(request, "cr_flg", ""));
		setCrTerm(JSPUtil.getParameter(request, "cr_term", ""));
		setSubsCoCd(JSPUtil.getParameter(request, "subs_co_cd", ""));
		setInvCoaAcctCd(JSPUtil.getParameter(request, "inv_coa_acct_cd", ""));
		setZoneIoc(JSPUtil.getParameter(request, "zone_ioc", ""));
		setCityCd(JSPUtil.getParameter(request, "city_cd", ""));
		setBlObrdDt(JSPUtil.getParameter(request, "bl_obrd_dt", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setRevLane(JSPUtil.getParameter(request, "rev_lane", ""));
		setUsdExrateType(JSPUtil.getParameter(request, "usd_exrate_type", ""));
		setThirdExrateType(JSPUtil.getParameter(request, "third_exrate_type", ""));
		setExRateDate(JSPUtil.getParameter(request, "ex_rate_date", ""));
		setUsdXchRt(JSPUtil.getParameter(request, "usd_xch_rt", ""));
		setTotalLocalAmt(JSPUtil.getParameter(request, "total_local_amt", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setSlpNo(JSPUtil.getParameter(request, "slp_no", ""));
		setTaxXchRt(JSPUtil.getParameter(request, "tax_xch_rt", ""));
		setArTaxIndCd(JSPUtil.getParameter(request, "ar_tax_ind_cd", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setInvCreFlg(JSPUtil.getParameter(request, "inv_cre_flg", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
		setArAgnStlCd(JSPUtil.getParameter(request, "ar_agn_stl_cd", ""));
		setInvFirstFlg(JSPUtil.getParameter(request, "inv_first_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setInvSvcScpCd(JSPUtil.getParameter(request, "inv_svc_scp_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceCreationVO[]
	 */
	public ARInvoiceCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceCreationVO[]
	 */
	public ARInvoiceCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd".trim(), length));
			String[] masterInv = (JSPUtil.getParameter(request, prefix	+ "master_inv".trim(), length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
			String[] lclVvd = (JSPUtil.getParameter(request, prefix	+ "lcl_vvd".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] coRef = (JSPUtil.getParameter(request, prefix	+ "co_ref".trim(), length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd".trim(), length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no".trim(), length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd".trim(), length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt".trim(), length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd".trim(), length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] siRefNo = (JSPUtil.getParameter(request, prefix	+ "si_ref_no".trim(), length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd".trim(), length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id".trim(), length));
			String[] mriMaxSeq = (JSPUtil.getParameter(request, prefix	+ "mri_max_seq".trim(), length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd".trim(), length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq".trim(), length));
			String[] lclCurr = (JSPUtil.getParameter(request, prefix	+ "lcl_curr".trim(), length));
			String[] sailingDt = (JSPUtil.getParameter(request, prefix	+ "sailing_dt".trim(), length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd".trim(), length));		
			String[] crFlg = (JSPUtil.getParameter(request, prefix	+ "cr_flg".trim(), length));		
			String[] crTerm = (JSPUtil.getParameter(request, prefix	+ "cr_term".trim(), length));		
			String[] subsCoCd = (JSPUtil.getParameter(request, prefix	+ "subs_co_cd".trim(), length));		
			String[] invCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_acct_cd".trim(), length));		
			String[] zoneIoc = (JSPUtil.getParameter(request, prefix	+ "zone_ioc".trim(), length));		
			String[] cityCd = (JSPUtil.getParameter(request, prefix	+ "city_cd".trim(), length));		
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt".trim(), length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd".trim(), length));
			String[] revLane = (JSPUtil.getParameter(request, prefix	+ "rev_lane".trim(), length));
			String[] usdExrateType = (JSPUtil.getParameter(request, prefix	+ "usd_exrate_type".trim(), length));
			String[] thirdExrateType = (JSPUtil.getParameter(request, prefix	+ "third_exrate_type".trim(), length));
			String[] exRateDate = (JSPUtil.getParameter(request, prefix	+ "ex_rate_date".trim(), length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt".trim(), length));
			String[] totalLocalAmt = (JSPUtil.getParameter(request, prefix	+ "total_local_amt".trim(), length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id".trim(), length));			
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk".trim(), length));
			String[] slpNo = (JSPUtil.getParameter(request, prefix	+ "slp_no".trim(), length));
			String[] taxXchRt = (JSPUtil.getParameter(request, prefix	+ "tax_xch_rt".trim(), length));
			String[] arTaxIndCd = (JSPUtil.getParameter(request, prefix	+ "ar_tax_ind_cd".trim(), length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no".trim(), length));
			String[] invCreFlg = (JSPUtil.getParameter(request, prefix	+ "inv_cre_flg".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd".trim(), length));
			String[] arAgnStlCd = (JSPUtil.getParameter(request, prefix	+ "ar_agn_stl_cd".trim(), length));
			String[] invFirstFlg = (JSPUtil.getParameter(request, prefix	+ "inv_first_flg".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] invSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "inv_svc_scp_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceCreationVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (masterInv[i] != null)
					model.setMasterInv(masterInv[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (lclVvd[i] != null)
					model.setLclVvd(lclVvd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (coRef[i] != null)
					model.setCoRef(coRef[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (crCurrCd[i] != null)
					model.setCrCurrCd(crCurrCd[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (siRefNo[i] != null)
					model.setSiRefNo(siRefNo[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (mriMaxSeq[i] != null)
					model.setMriMaxSeq(mriMaxSeq[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]); 	
				if (lclCurr[i] != null)
					model.setLclCurr(lclCurr[i]);
				if (sailingDt[i] != null)
					model.setSailingDt(sailingDt[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (crFlg[i] != null)
					model.setCrFlg(crFlg[i]);
				if (crTerm[i] != null)
					model.setCrTerm(crTerm[i]);	
				if (subsCoCd[i] != null)
					model.setSubsCoCd(subsCoCd[i]);
				if (invCoaAcctCd[i] != null)
					model.setInvCoaAcctCd(invCoaAcctCd[i]);
				if (zoneIoc[i] != null)
					model.setZoneIoc(zoneIoc[i]);
				if (cityCd[i] != null)
					model.setCityCd(cityCd[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (revLane[i] != null)
					model.setRevLane(revLane[i]);
				if (usdExrateType[i] != null)
					model.setUsdExrateType(usdExrateType[i]);		
				if (thirdExrateType[i] != null)
					model.setThirdExrateType(thirdExrateType[i]);
				if (exRateDate[i] != null)
					model.setExRateDate(exRateDate[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (totalLocalAmt[i] != null)
					model.setTotalLocalAmt(totalLocalAmt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (slpNo[i] != null)
					model.setSlpNo(slpNo[i]);
				if (taxXchRt[i] != null)
					model.setTaxXchRt(taxXchRt[i]);
				if (arTaxIndCd[i] != null)
					model.setArTaxIndCd(arTaxIndCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (invCreFlg[i] != null)
					model.setInvCreFlg(invCreFlg[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (arAgnStlCd[i] != null)
					model.setArAgnStlCd(arAgnStlCd[i]);
				if (invFirstFlg[i] != null)
					model.setInvFirstFlg(invFirstFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (invSvcScpCd[i] != null)
					model.setInvSvcScpCd(invSvcScpCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceCreationVO[]
	 */
	public ARInvoiceCreationVO[] getARInvoiceCreationVOs(){
		ARInvoiceCreationVO[] vos = (ARInvoiceCreationVO[])models.toArray(new ARInvoiceCreationVO[models.size()]);
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
		this.masterInv = this.masterInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclVvd = this.lclVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coRef = this.coRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siRefNo = this.siRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mriMaxSeq = this.mriMaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurr = this.lclCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailingDt = this.sailingDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg = this.crFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTerm = this.crTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCoCd = this.subsCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaAcctCd = this.invCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zoneIoc = this.zoneIoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cityCd = this.cityCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revLane = this.revLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdExrateType = this.usdExrateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thirdExrateType = this.thirdExrateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRateDate = this.exRateDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalLocalAmt = this.totalLocalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxXchRt = this.taxXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreFlg = this.invCreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAgnStlCd = this.arAgnStlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFirstFlg = this.invFirstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSvcScpCd = this.invSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
