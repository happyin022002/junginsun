/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchDailyForecastManageListVO.java
*@FileTitle : SearchDailyForecastManageListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.08
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.07.08 최윤성 
* 1.0 Creation
* 2013.01.04 최윤성 [CHM-201322312-01] FCST Input(SELSA) 2차 수정요청
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.07.27 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo;

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

public class SearchDailyForecastManageListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDailyForecastManageListVO> models = new ArrayList<SearchDailyForecastManageListVO>();
	
	/* Column Info */
	private String cfm40ftHcQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cfmRfQty = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String lvl2 = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrl53 = null;
	/* Column Info */
	private String bkg45ftHcQty = null;
	/* Column Info */
	private String lvl1 = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String bkgRfQty = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String cfm53ftQty = null;
	/* Column Info */
	private String bkgTtlQty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String podSeq = null;
	/* Column Info */
	private String fcastRfQty = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgTtlWgt = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String chl = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String ctrlWt = null;
	/* Column Info */
	private String bkg40ftQty = null;
	/* Column Info */
	private String bkg40ftHcQty = null;
	/* Column Info */
	private String fcast40ftHcQty = null;
	/* Column Info */
	private String cfm45ftHcQty = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String polSeq = null;
	/* Column Info */
	private String ctrlLvl = null;
	/* Column Info */
	private String fcastCnt = null;
	/* Column Info */
	private String fcastTtlTeuQty = null;
	/* Column Info */
	private String cfmTtlQty = null;
	/* Column Info */
	private String bkg20ftQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrlRf = null;
	/* Column Info */
	private String fcastTtlQty = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String fcast53ftQty = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String fcastTtlWgt = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String iocTsCd = null;
	/* Column Info */
	private String cfmTtlWgt = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String mstCnt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ctrl45 = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String fcast45ftHcQty = null;
	/* Column Info */
	private String bkg53ftQty = null;
	/* Column Info */
	private String ctrlHc = null;

	// Add 2012.09.12.
	/* Column Info */
	private String fcast20Qty = null;
	/* Column Info */
	private String fcast40Qty = null;
	/* Column Info */
	private String bkgCustCntCd = null;
	/* Column Info */
	private String bkgCustSeq = null;
	/* Column Info */
	private String bkgCustNm = null; //BKG_CUST_NM
	
	/* Column Info */
	private String cif= null;
	/* Column Info */
	private String fob= null;
	/* Column Info */
	private String oth= null;
	/* Column Info */
	private String existFlg= null;
		
	/* Column Info */
	private String acctLvl = null;
	/* Column Info */
	private String guide = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String iseditable = null;
	/* Column Info */
	private String color = null;
	/* Column Info */
	private String fcastRmk = null;
	/* Column Info */
	private String salesRep = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fcastSeq = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String scFlg = null;
	/* Column Info */
	private String newFlg = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String viewType = null;
	/* Column Info */
	private String hhFlg = null;
	/* Column Info */
	private String ctrlAcct = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String zeroCust = null;
	
	//2014.07.27 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청
	/* Column Info */
	private String fcastRdQty = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String ctrlLocFlg = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String ctrlDestLvlCd = null;
	/* Column Info */
	private String bkg40FtDryQty = null;
	/* Column Info */
	private String ctrlAcctFlg = null;
	/* Column Info */
	private String ctrlRd = null;
	/* Column Info */
	private String ctrlRdFlg = null;
	/* Column Info */
	private String usdBkg40FtDryQty = null;
	/* Column Info */
	private String ctrlEccFlg = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String usdBkg20FtDryQty = null;
	/* Column Info */
	private String ctrlD2Flg = null;
	/* Column Info */
	private String cfm40FtDryQty = null;
	/* Column Info */
	private String ctrlUsaSvcModFlg = null;
	/* Column Info */
	private String fcast40FtDryQty = null;
	/* Column Info */
	private String bkgRdQty = null;
	/* Column Info */
	private String ctrlD2 = null;
	/* Column Info */
	private String ctrlD4 = null;
	/* Column Info */
	private String bkg20FtDryQty = null;
	/* Column Info */
	private String fcast20FtDryQty = null;
	/* Column Info */
	private String cfm20FtDryQty = null;
	/* Column Info */
	private String cfmRdQty = null;
	/* Column Info */
	private String ctrlD4Flg = null;
	/* Column Info */
	private String usdBkgRdQty = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDailyForecastManageListVO() {}

	public SearchDailyForecastManageListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String iocTsCd, 
			String rgnOfcCd, String subOfcCd, String ofcCd, String srepCd, String srepNm, String custTpCd, String custCntCd, String custSeq, 
			String custNm, String polCd, String podCd, String vslCd, String skdVoyNo, String skdDirCd, String costYr, String costWk, String lvl, 
			String lvl1, String lvl2, String rnum, String chl, String ctrlLvl, String ctrlHc, String ctrl45, String ctrl53, String ctrlRf, 
			String ctrlWt, String polSeq, String podSeq, String mstCnt, String fcastCnt, String bkgCnt, String fcastTtlTeuQty, 
			String fcastTtlQty, String fcast40ftHcQty, String fcast45ftHcQty, String fcast53ftQty, String fcastRfQty, 
			String fcastTtlWgt, String cfmTtlQty, String cfm40ftHcQty, String cfm45ftHcQty, String cfm53ftQty, String cfmRfQty, String cfmTtlWgt,
			String bkgTtlQty, String bkg20ftQty, String bkg40ftQty, String bkg40ftHcQty, String bkg45ftHcQty, String bkg53ftQty, String bkgRfQty, String bkgTtlWgt,
			String fcast20Qty, String fcast40Qty, String bkgCustCntCd, String bkgCustSeq, String bkgCustNm,
			String cif, String fob, String  oth,
			String existFlg, String acctLvl, String guide, String totCnt, String iseditable, String color, String fcastRmk, String salesRep, String updUsrId,
			String fcastSeq, String scNo, String scFlg   , String newFlg, String contiCd, String viewType, String hhFlg, String ctrlAcct, String slsRhqCd, String rfaNo, String zeroCust
			,String ctrlD2Flg, String ctrlD4Flg, String ctrlRdFlg, String ctrEccFlg, String ctrlLocFlg, String ctrlUsaSvcModFlg, String ctrlAcctFlg, String ctrlDestLvlCd, String usaBkgModCd, String destLocCd, String fcast20FtDryQty, String fcast40FtDryQty, String fcastRdQty, String cfm20FtDryQty, String cfm40FtDryQty, String cfmRdQty, String usdBkg20FtDryQty, String usdBkg40FtDryQty, String usdBkgRdQty, String bkg20FtDryQty, String bkg40FtDryQty, String bkgRdQty, String acctCd, String ctrlD2, String ctrlD4, String ctrlRd) {
		
		this.cfm40ftHcQty = cfm40ftHcQty;
		this.vslCd = vslCd;
		this.cfmRfQty = cfmRfQty;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.lvl2 = lvl2;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.ctrl53 = ctrl53;
		this.bkg45ftHcQty = bkg45ftHcQty;
		this.lvl1 = lvl1;
		this.polCd = polCd;
		this.rnum = rnum;
		this.bkgRfQty = bkgRfQty;
		this.custCntCd = custCntCd;
		this.cfm53ftQty = cfm53ftQty;
		this.bkgTtlQty = bkgTtlQty;
		this.skdVoyNo = skdVoyNo;
		this.bkgCnt = bkgCnt;
		this.podSeq = podSeq;
		this.fcastRfQty = fcastRfQty;
		this.podCd = podCd;
		this.bkgTtlWgt = bkgTtlWgt;
		this.lvl = lvl;
		this.chl = chl;
		this.costWk = costWk;
		this.ctrlWt = ctrlWt;
		this.bkg40ftQty = bkg40ftQty;
		this.bkg40ftHcQty = bkg40ftHcQty;
		this.fcast40ftHcQty = fcast40ftHcQty;
		this.cfm45ftHcQty = cfm45ftHcQty;
		this.subTrdCd = subTrdCd;
		this.custNm = custNm;
		this.polSeq = polSeq;
		this.ctrlLvl = ctrlLvl;
		this.fcastCnt = fcastCnt;
		this.fcastTtlTeuQty = fcastTtlTeuQty;
		this.cfmTtlQty = cfmTtlQty;
		this.bkg20ftQty = bkg20ftQty;
		this.ibflag = ibflag;
		this.ctrlRf = ctrlRf;
		this.fcastTtlQty = fcastTtlQty;
		this.srepNm = srepNm;
		this.fcast53ftQty = fcast53ftQty;
		this.dirCd = dirCd;
		this.fcastTtlWgt = fcastTtlWgt;
		this.rgnOfcCd = rgnOfcCd;
		this.custTpCd = custTpCd;
		this.iocTsCd = iocTsCd;
		this.cfmTtlWgt = cfmTtlWgt;
		this.subOfcCd = subOfcCd;
		this.mstCnt = mstCnt;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.ofcCd = ofcCd;
		this.ctrl45 = ctrl45;
		this.costYr = costYr;
		this.fcast45ftHcQty = fcast45ftHcQty;
		this.bkg53ftQty = bkg53ftQty;
		this.ctrlHc = ctrlHc;
		
		this.fcast20Qty = fcast20Qty;
		this.fcast40Qty = fcast40Qty;		
		this.bkgCustCntCd= bkgCustCntCd; 
		this.bkgCustSeq = bkgCustSeq;
		this.bkgCustNm = bkgCustNm;		
		
		this.cif =cif; 
		this.fob =fob;
		this.oth= oth;
		
		this.existFlg= existFlg;
		
		this.acctLvl    = acctLvl;
		this.guide      = guide;
		this.totCnt     = totCnt;
		this.iseditable = iseditable;
		this.color      = color;
		this.fcastRmk   = fcastRmk;
		this.salesRep   = salesRep;
		this.updUsrId   = updUsrId;
		this.fcastSeq   = fcastSeq;
		this.scNo       = scNo;
		this.scFlg      = scFlg;
		this.newFlg     = newFlg;
		this.contiCd    = contiCd;
		this.viewType   = viewType;
		this.hhFlg      = hhFlg;
		this.ctrlAcct   = ctrlAcct;
		this.slsRhqCd   = slsRhqCd;
		this.rfaNo      = rfaNo;
		this.zeroCust   = zeroCust;
		
		this.fcastRdQty = fcastRdQty;
		this.destLocCd = destLocCd;
		this.ctrlLocFlg = ctrlLocFlg;
		this.usaBkgModCd = usaBkgModCd;
		this.ctrlDestLvlCd = ctrlDestLvlCd;
		this.bkg40FtDryQty = bkg40FtDryQty;
		this.ctrlAcctFlg = ctrlAcctFlg;
		this.ctrlRd = ctrlRd;
		this.ctrlRdFlg = ctrlRdFlg;
		this.usdBkg40FtDryQty = usdBkg40FtDryQty;
		this.ctrlEccFlg = ctrlEccFlg;
		this.acctCd = acctCd;
		this.usdBkg20FtDryQty = usdBkg20FtDryQty;
		this.ctrlD2Flg = ctrlD2Flg;
		this.cfm40FtDryQty = cfm40FtDryQty;
		this.ctrlUsaSvcModFlg = ctrlUsaSvcModFlg;
		this.fcast40FtDryQty = fcast40FtDryQty;
		this.bkgRdQty = bkgRdQty;
		this.ctrlD2 = ctrlD2;
		this.ctrlD4 = ctrlD4;
		this.bkg20FtDryQty = bkg20FtDryQty;
		this.fcast20FtDryQty = fcast20FtDryQty;
		this.cfm20FtDryQty = cfm20FtDryQty;
		this.cfmRdQty = cfmRdQty;
		this.ctrlD4Flg = ctrlD4Flg;
		this.usdBkgRdQty = usdBkgRdQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cfm_40ft_hc_qty", getCfm40ftHcQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cfm_rf_qty", getCfmRfQty());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("lvl2", getLvl2());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrl_53", getCtrl53());
		this.hashColumns.put("bkg_45ft_hc_qty", getBkg45ftHcQty());
		this.hashColumns.put("lvl1", getLvl1());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cfm_53ft_qty", getCfm53ftQty());
		this.hashColumns.put("bkg_ttl_qty", getBkgTtlQty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("pod_seq", getPodSeq());
		this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_ttl_wgt", getBkgTtlWgt());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("chl", getChl());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("ctrl_wt", getCtrlWt());
		this.hashColumns.put("bkg_40ft_qty", getBkg40ftQty());
		this.hashColumns.put("bkg_40ft_hc_qty", getBkg40ftHcQty());
		this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
		this.hashColumns.put("cfm_45ft_hc_qty", getCfm45ftHcQty());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("pol_seq", getPolSeq());
		this.hashColumns.put("ctrl_lvl", getCtrlLvl());
		this.hashColumns.put("fcast_cnt", getFcastCnt());
		this.hashColumns.put("fcast_ttl_teu_qty", getFcastTtlTeuQty());
		this.hashColumns.put("cfm_ttl_qty", getCfmTtlQty());
		this.hashColumns.put("bkg_20ft_qty", getBkg20ftQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrl_rf", getCtrlRf());
		this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("ioc_ts_cd", getIocTsCd());
		this.hashColumns.put("cfm_ttl_wgt", getCfmTtlWgt());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("mst_cnt", getMstCnt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ctrl_45", getCtrl45());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
		this.hashColumns.put("bkg_53ft_qty", getBkg53ftQty());
		this.hashColumns.put("ctrl_hc", getCtrlHc());
		
		this.hashColumns.put("fcast_20ft_qty", getFcast20Qty() );
		this.hashColumns.put("fcast_40ft_qty", getFcast40Qty());
		this.hashColumns.put("bkg_cust_cnt_cd", getBkgCustCntCd() );
		this.hashColumns.put("bkg_cust_seq", getBkgCustSeq() );		
		this.hashColumns.put("bkg_cust_nm", getBkgCustNm() );
		
		this.hashColumns.put("cif", getCif()  );
		this.hashColumns.put("fob", getFob()  );
		this.hashColumns.put("oth", getOth()  );
		
		this.hashColumns.put("exist_flg", getExistFlg()  );
		
		this.hashColumns.put("acct_lvl"  , getAcctLvl());
		this.hashColumns.put("guide"     , getGuide());
		this.hashColumns.put("tot_cnt"   , getTotCnt());
		this.hashColumns.put("iseditable", getIseditable());
		this.hashColumns.put("color"     , getColor());
		this.hashColumns.put("fcast_rmk" , getFcastRmk());
		this.hashColumns.put("salesRep"  , getSalesRep());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("fcast_seq" , getFcastSeq());
		this.hashColumns.put("sc_no"     , getScNo());
		this.hashColumns.put("sc_flg"    , getScFlg());
		this.hashColumns.put("new_flg"   , getNewFlg());
		this.hashColumns.put("conti_cd"  , getContiCd());
		this.hashColumns.put("view_type" , getViewType());
		this.hashColumns.put("hh_flg"    , getHhFlg());
		this.hashColumns.put("ctrl_acct" , getCtrlAcct());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("rfa_no"    , getRfaNo());
		this.hashColumns.put("zero_cust" , getZeroCust());
		
		this.hashColumns.put("fcast_rd_qty", getFcastRdQty());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("ctrl_loc_flg", getCtrlLocFlg());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("ctrl_dest_lvl_cd", getCtrlDestLvlCd());
		this.hashColumns.put("bkg_40ft_dry_qty", getBkg40FtDryQty());
		this.hashColumns.put("ctrl_acct_flg", getCtrlAcctFlg());
		this.hashColumns.put("ctrl_rd", getCtrlRd());
		this.hashColumns.put("ctrl_rd_flg", getCtrlRdFlg());
		this.hashColumns.put("usd_bkg_40ft_dry_qty", getUsdBkg40FtDryQty());
		this.hashColumns.put("ctrl_ecc_flg", getCtrlEccFlg());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("usd_bkg_20ft_dry_qty", getUsdBkg20FtDryQty());
		this.hashColumns.put("ctrl_d2_flg", getCtrlD2Flg());
		this.hashColumns.put("cfm_40ft_dry_qty", getCfm40FtDryQty());
		this.hashColumns.put("ctrl_usa_svc_mod_flg", getCtrlUsaSvcModFlg());
		this.hashColumns.put("fcast_40ft_dry_qty", getFcast40FtDryQty());
		this.hashColumns.put("bkg_rd_qty", getBkgRdQty());
		this.hashColumns.put("ctrl_d2", getCtrlD2());
		this.hashColumns.put("ctrl_d4", getCtrlD4());
		this.hashColumns.put("bkg_20ft_dry_qty", getBkg20FtDryQty());
		this.hashColumns.put("fcast_20ft_dry_qty", getFcast20FtDryQty());
		this.hashColumns.put("cfm_20ft_dry_qty", getCfm20FtDryQty());
		this.hashColumns.put("cfm_rd_qty", getCfmRdQty());
		this.hashColumns.put("ctrl_d4_flg", getCtrlD4Flg());
		this.hashColumns.put("usd_bkg_rd_qty", getUsdBkgRdQty());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cfm_40ft_hc_qty", "cfm40ftHcQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cfm_rf_qty", "cfmRfQty");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("lvl2", "lvl2");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrl_53", "ctrl53");
		this.hashFields.put("bkg_45ft_hc_qty", "bkg45ftHcQty");
		this.hashFields.put("lvl1", "lvl1");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("bkg_rf_qty", "bkgRfQty");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cfm_53ft_qty", "cfm53ftQty");
		this.hashFields.put("bkg_ttl_qty", "bkgTtlQty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("pod_seq", "podSeq");
		this.hashFields.put("fcast_rf_qty", "fcastRfQty");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_ttl_wgt", "bkgTtlWgt");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("chl", "chl");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("ctrl_wt", "ctrlWt");
		this.hashFields.put("bkg_40ft_qty", "bkg40ftQty");
		this.hashFields.put("bkg_40ft_hc_qty", "bkg40ftHcQty");
		this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
		this.hashFields.put("cfm_45ft_hc_qty", "cfm45ftHcQty");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("pol_seq", "polSeq");
		this.hashFields.put("ctrl_lvl", "ctrlLvl");
		this.hashFields.put("fcast_cnt", "fcastCnt");
		this.hashFields.put("fcast_ttl_teu_qty", "fcastTtlTeuQty");
		this.hashFields.put("cfm_ttl_qty", "cfmTtlQty");
		this.hashFields.put("bkg_20ft_qty", "bkg20ftQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrl_rf", "ctrlRf");
		this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("ioc_ts_cd", "iocTsCd");
		this.hashFields.put("cfm_ttl_wgt", "cfmTtlWgt");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("mst_cnt", "mstCnt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ctrl_45", "ctrl45");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
		this.hashFields.put("bkg_53ft_qty", "bkg53ftQty");
		this.hashFields.put("ctrl_hc", "ctrlHc");	
		
		this.hashFields.put("fcast_20ft_qty", "fcast20Qty");
		this.hashFields.put("fcast_40ft_qty", "fcast40Qty");		
		this.hashFields.put("bkg_cust_cnt_cd", "bkgCustCntCd");
		this.hashFields.put("bkg_cust_seq", "bkgCustSeq");
		this.hashFields.put("bkg_cust_nm", "bkgCustNm");	
		
		this.hashFields.put("cif", "cif");
		this.hashFields.put("fob", "fob");
		this.hashFields.put("oth", "oth");
		
		this.hashFields.put("exist_flg", "existFlg");
		
		this.hashFields.put("acct_lvl"  , "acctLvl");
		this.hashFields.put("guide"     , "guide");
		this.hashFields.put("tot_cnt"   , "totCnt");
		this.hashFields.put("iseditable", "iseditable");
		this.hashFields.put("color"     , "color");
		this.hashFields.put("fcast_rmk" , "fcastRmk");
		this.hashFields.put("salesRep"  , "salesRep");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fcast_seq" , "fcastSeq");
		this.hashFields.put("sc_no"     , "scNo");
		this.hashFields.put("sc_flg"    , "scFlg");
		this.hashFields.put("new_flg"   , "newFlg");
		this.hashFields.put("conti_cd"  , "contiCd");
		this.hashFields.put("view_type" , "viewType");
		this.hashFields.put("hh_flg"    , "hhFlg");
		this.hashFields.put("ctrl_acct" , "ctrlAcct");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("rfa_no"    , "rfaNo");
		this.hashFields.put("zero_cust" , "zeroCust");
		
		this.hashFields.put("fcast_rd_qty", "fcastRdQty");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("ctrl_loc_flg", "ctrlLocFlg");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("ctrl_dest_lvl_cd", "ctrlDestLvlCd");
		this.hashFields.put("bkg_40ft_dry_qty", "bkg40FtDryQty");
		this.hashFields.put("ctrl_acct_flg", "ctrlAcctFlg");
		this.hashFields.put("ctrl_rd", "ctrlRd");
		this.hashFields.put("ctrl_rd_flg", "ctrlRdFlg");
		this.hashFields.put("usd_bkg_40ft_dry_qty", "usdBkg40FtDryQty");
		this.hashFields.put("ctrl_ecc_flg", "ctrlEccFlg");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("usd_bkg_20ft_dry_qty", "usdBkg20FtDryQty");
		this.hashFields.put("ctrl_d2_flg", "ctrlD2Flg");
		this.hashFields.put("cfm_40ft_dry_qty", "cfm40FtDryQty");
		this.hashFields.put("ctrl_usa_svc_mod_flg", "ctrlUsaSvcModFlg");
		this.hashFields.put("fcast_40ft_dry_qty", "fcast40FtDryQty");
		this.hashFields.put("bkg_rd_qty", "bkgRdQty");
		this.hashFields.put("ctrl_d2", "ctrlD2");
		this.hashFields.put("ctrl_d4", "ctrlD4");
		this.hashFields.put("bkg_20ft_dry_qty", "bkg20FtDryQty");
		this.hashFields.put("fcast_20ft_dry_qty", "fcast20FtDryQty");
		this.hashFields.put("cfm_20ft_dry_qty", "cfm20FtDryQty");
		this.hashFields.put("cfm_rd_qty", "cfmRdQty");
		this.hashFields.put("ctrl_d4_flg", "ctrlD4Flg");
		this.hashFields.put("usd_bkg_rd_qty", "usdBkgRdQty");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cfm40ftHcQty
	 */
	public String getCfm40ftHcQty() {
		return this.cfm40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return cfmRfQty
	 */
	public String getCfmRfQty() {
		return this.cfmRfQty;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return lvl2
	 */
	public String getLvl2() {
		return this.lvl2;
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
	 * @return ctrl53
	 */
	public String getCtrl53() {
		return this.ctrl53;
	}
	
	/**
	 * Column Info
	 * @return bkg45ftHcQty
	 */
	public String getBkg45ftHcQty() {
		return this.bkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return lvl1
	 */
	public String getLvl1() {
		return this.lvl1;
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
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return bkgRfQty
	 */
	public String getBkgRfQty() {
		return this.bkgRfQty;
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
	 * @return cfm53ftQty
	 */
	public String getCfm53ftQty() {
		return this.cfm53ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkgTtlQty
	 */
	public String getBkgTtlQty() {
		return this.bkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
	}
	
	/**
	 * Column Info
	 * @return podSeq
	 */
	public String getPodSeq() {
		return this.podSeq;
	}
	
	/**
	 * Column Info
	 * @return fcastRfQty
	 */
	public String getFcastRfQty() {
		return this.fcastRfQty;
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
	 * @return bkgTtlWgt
	 */
	public String getBkgTtlWgt() {
		return this.bkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return chl
	 */
	public String getChl() {
		return this.chl;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return ctrlWt
	 */
	public String getCtrlWt() {
		return this.ctrlWt;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftQty
	 */
	public String getBkg40ftQty() {
		return this.bkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftHcQty
	 */
	public String getBkg40ftHcQty() {
		return this.bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return fcast40ftHcQty
	 */
	public String getFcast40ftHcQty() {
		return this.fcast40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return cfm45ftHcQty
	 */
	public String getCfm45ftHcQty() {
		return this.cfm45ftHcQty;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return polSeq
	 */
	public String getPolSeq() {
		return this.polSeq;
	}
	
	/**
	 * Column Info
	 * @return ctrlLvl
	 */
	public String getCtrlLvl() {
		return this.ctrlLvl;
	}
	
	/**
	 * Column Info
	 * @return fcastCnt
	 */
	public String getFcastCnt() {
		return this.fcastCnt;
	}
	
	/**
	 * Column Info
	 * @return fcastTtlTeuQty
	 */
	public String getFcastTtlTeuQty() {
		return this.fcastTtlTeuQty;
	}
	
	/**
	 * Column Info
	 * @return cfmTtlQty
	 */
	public String getCfmTtlQty() {
		return this.cfmTtlQty;
	}
	
	/**
	 * Column Info
	 * @return bkg20ftQty
	 */
	public String getBkg20ftQty() {
		return this.bkg20ftQty;
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
	 * @return ctrlRf
	 */
	public String getCtrlRf() {
		return this.ctrlRf;
	}
	
	/**
	 * Column Info
	 * @return fcastTtlQty
	 */
	public String getFcastTtlQty() {
		return this.fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return fcast53ftQty
	 */
	public String getFcast53ftQty() {
		return this.fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return fcastTtlWgt
	 */
	public String getFcastTtlWgt() {
		return this.fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return iocTsCd
	 */
	public String getIocTsCd() {
		return this.iocTsCd;
	}
	
	/**
	 * Column Info
	 * @return cfmTtlWgt
	 */
	public String getCfmTtlWgt() {
		return this.cfmTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return subOfcCd
	 */
	public String getSubOfcCd() {
		return this.subOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mstCnt
	 */
	public String getMstCnt() {
		return this.mstCnt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrl45
	 */
	public String getCtrl45() {
		return this.ctrl45;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return fcast45ftHcQty
	 */
	public String getFcast45ftHcQty() {
		return this.fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return bkg53ftQty
	 */
	public String getBkg53ftQty() {
		return this.bkg53ftQty;
	}
	
	/**
	 * Column Info
	 * @return ctrlHc
	 */
	public String getCtrlHc() {
		return this.ctrlHc;
	}
	
	/**
	 * @return the fcastRmk
	 */
	public String getFcastRmk() {
		return fcastRmk;
	}
	
	/**
	 * @return the salesRep
	 */
	public String getSalesRep() {
		return salesRep;
	}
	
	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}
	
	/**
	 * @return the fcastSeq
	 */
	public String getFcastSeq() {
		return fcastSeq;
	}
	
	/**
	 * @return the scNo
	 */
	public String getScNo() {
		return scNo;
	}
	
	/**
	 * @return the scFlg
	 */
	public String getScFlg() {
		return scFlg;
	}
	
	/**
	 * @return the newFlg
	 */
	public String getNewFlg() {
		return newFlg;
	}
	
	/**
	 * @return the contiCd
	 */
	public String getContiCd() {
		return contiCd;
	}

	/**
	 * @return the viewType
	 */
	public String getViewType() {
		return viewType;
	}
	
	/**
	 * @return the hhFlg
	 */
	public String getHhFlg() {
		return hhFlg;
	}
	
	/**
	 * @return the ctrlAcct
	 */
	public String getCtrlAcct() {
		return ctrlAcct;
	}
	
	/**
	 * @return the slsRhqCd
	 */
	public String getSlsRhqCd() {
		return slsRhqCd;
	}
	
	/**
	 * @return the rfaNo
	 */
	public String getRfaNo() {
		return rfaNo;
	}
	
	/**
	 * @return the zeroCust
	 */
	public String getZeroCust() {
		return zeroCust;
	}
	
	/**
	 * @param fcastRmk the fcastRmk to set
	 */
	public void setFcastRmk(String fcastRmk) {
		this.fcastRmk = fcastRmk;
	}

	/**
	 * Column Info
	 * @param cfm40ftHcQty
	 */
	public void setCfm40ftHcQty(String cfm40ftHcQty) {
		this.cfm40ftHcQty = cfm40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param cfmRfQty
	 */
	public void setCfmRfQty(String cfmRfQty) {
		this.cfmRfQty = cfmRfQty;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param lvl2
	 */
	public void setLvl2(String lvl2) {
		this.lvl2 = lvl2;
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
	 * @param ctrl53
	 */
	public void setCtrl53(String ctrl53) {
		this.ctrl53 = ctrl53;
	}
	
	/**
	 * Column Info
	 * @param bkg45ftHcQty
	 */
	public void setBkg45ftHcQty(String bkg45ftHcQty) {
		this.bkg45ftHcQty = bkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param lvl1
	 */
	public void setLvl1(String lvl1) {
		this.lvl1 = lvl1;
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
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param bkgRfQty
	 */
	public void setBkgRfQty(String bkgRfQty) {
		this.bkgRfQty = bkgRfQty;
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
	 * @param cfm53ftQty
	 */
	public void setCfm53ftQty(String cfm53ftQty) {
		this.cfm53ftQty = cfm53ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkgTtlQty
	 */
	public void setBkgTtlQty(String bkgTtlQty) {
		this.bkgTtlQty = bkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}
	
	/**
	 * Column Info
	 * @param podSeq
	 */
	public void setPodSeq(String podSeq) {
		this.podSeq = podSeq;
	}
	
	/**
	 * Column Info
	 * @param fcastRfQty
	 */
	public void setFcastRfQty(String fcastRfQty) {
		this.fcastRfQty = fcastRfQty;
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
	 * @param bkgTtlWgt
	 */
	public void setBkgTtlWgt(String bkgTtlWgt) {
		this.bkgTtlWgt = bkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param chl
	 */
	public void setChl(String chl) {
		this.chl = chl;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param ctrlWt
	 */
	public void setCtrlWt(String ctrlWt) {
		this.ctrlWt = ctrlWt;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftQty
	 */
	public void setBkg40ftQty(String bkg40ftQty) {
		this.bkg40ftQty = bkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftHcQty
	 */
	public void setBkg40ftHcQty(String bkg40ftHcQty) {
		this.bkg40ftHcQty = bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param fcast40ftHcQty
	 */
	public void setFcast40ftHcQty(String fcast40ftHcQty) {
		this.fcast40ftHcQty = fcast40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param cfm45ftHcQty
	 */
	public void setCfm45ftHcQty(String cfm45ftHcQty) {
		this.cfm45ftHcQty = cfm45ftHcQty;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param polSeq
	 */
	public void setPolSeq(String polSeq) {
		this.polSeq = polSeq;
	}
	
	/**
	 * Column Info
	 * @param ctrlLvl
	 */
	public void setCtrlLvl(String ctrlLvl) {
		this.ctrlLvl = ctrlLvl;
	}
	
	/**
	 * Column Info
	 * @param fcastCnt
	 */
	public void setFcastCnt(String fcastCnt) {
		this.fcastCnt = fcastCnt;
	}
	
	/**
	 * Column Info
	 * @param fcastTtlTeuQty
	 */
	public void setFcastTtlTeuQty(String fcastTtlTeuQty) {
		this.fcastTtlTeuQty = fcastTtlTeuQty;
	}
	
	/**
	 * Column Info
	 * @param cfmTtlQty
	 */
	public void setCfmTtlQty(String cfmTtlQty) {
		this.cfmTtlQty = cfmTtlQty;
	}
	
	/**
	 * Column Info
	 * @param bkg20ftQty
	 */
	public void setBkg20ftQty(String bkg20ftQty) {
		this.bkg20ftQty = bkg20ftQty;
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
	 * @param ctrlRf
	 */
	public void setCtrlRf(String ctrlRf) {
		this.ctrlRf = ctrlRf;
	}
	
	/**
	 * Column Info
	 * @param fcastTtlQty
	 */
	public void setFcastTtlQty(String fcastTtlQty) {
		this.fcastTtlQty = fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param fcast53ftQty
	 */
	public void setFcast53ftQty(String fcast53ftQty) {
		this.fcast53ftQty = fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param fcastTtlWgt
	 */
	public void setFcastTtlWgt(String fcastTtlWgt) {
		this.fcastTtlWgt = fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param iocTsCd
	 */
	public void setIocTsCd(String iocTsCd) {
		this.iocTsCd = iocTsCd;
	}
	
	/**
	 * Column Info
	 * @param cfmTtlWgt
	 */
	public void setCfmTtlWgt(String cfmTtlWgt) {
		this.cfmTtlWgt = cfmTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param subOfcCd
	 */
	public void setSubOfcCd(String subOfcCd) {
		this.subOfcCd = subOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mstCnt
	 */
	public void setMstCnt(String mstCnt) {
		this.mstCnt = mstCnt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrl45
	 */
	public void setCtrl45(String ctrl45) {
		this.ctrl45 = ctrl45;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param fcast45ftHcQty
	 */
	public void setFcast45ftHcQty(String fcast45ftHcQty) {
		this.fcast45ftHcQty = fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param bkg53ftQty
	 */
	public void setBkg53ftQty(String bkg53ftQty) {
		this.bkg53ftQty = bkg53ftQty;
	}
	
	/**
	 * Column Info
	 * @param ctrlHc
	 */
	public void setCtrlHc(String ctrlHc) {
		this.ctrlHc = ctrlHc;
	}
	
	/**
	 * Column Info
	 * @return fcast20Qty
	 */
	public String getFcast20Qty() {
		return fcast20Qty;
	}


	/**
	 * Column Info
	 * @param fcast20Qty
	 */
	public void setFcast20Qty(String fcast20Qty) {
		this.fcast20Qty = fcast20Qty;
	}

	/**
	 * Column Info
	 * @return fcast40Qty
	 */
	public String getFcast40Qty() {
		return fcast40Qty;
	}
	

	/**
	 * Column Info
	 * @param fcast40Qty
	 */
	public void setFcast40Qty(String fcast40Qty) {
		this.fcast40Qty = fcast40Qty;
	}
	
	/**
	 * Column Info
	 * @return bkgCustCntCd
	 */
	public String getBkgCustCntCd() {
		return bkgCustCntCd;
	}


	/**
	 * Column Info
	 * @param bkgCustCntCd
	 */
	public void setBkgCustCntCd(String bkgCustCntCd) {
		this.bkgCustCntCd = bkgCustCntCd;
	}

	/**
	 * Column Info
	 * @return bkgCustSeq
	 */
	public String getBkgCustSeq() {
		return bkgCustSeq;
	}


	/**
	 * Column Info
	 * @param bkgCustSeq
	 */
	public void setBkgCustSeq(String bkgCustSeq) {
		this.bkgCustSeq = bkgCustSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgCustNm
	 */
	public String getBkgCustNm() {
		return bkgCustNm;
	}


	/**
	 * Column Info
	 * @param bkgCustNm
	 */
	public void setBkgCustNm(String bkgCustNm) {
		this.bkgCustNm = bkgCustNm;
	}
	
	
	/**
	 * Column Info
	 * @return cif
	 */
	public String getCif() {
		return cif;
	}


	/**
	 * Column Info
	 * @param cif
	 */
	public void setCif(String cif) {
		this.cif = cif;
	}

	/**
	 * Column Info
	 * @return fob
	 */
	public String getFob() {
		return fob;
	}


	/**
	 * Column Info
	 * @param fob
	 */
	public void setFob(String fob) {
		this.fob = fob;
	}

	/**
	 * Column Info
	 * @return oth
	 */
	public String getOth() {
		return oth;
	}


	/**
	 * Column Info
	 * @param oth
	 */
	public void setOth(String oth) {
		this.oth = oth;
	}
	
	
	/**
	 * Column Info
	 * @return existFlg
	 */
	public String getExistFlg() {
		return existFlg;
	}


	/**
	 * Column Info
	 * @param existFlg
	 */
	public void setExistFlg(String existFlg) {
		this.existFlg = existFlg;
	}
	
	/**
	 * Column Info
	 * @return acctLvl
	 */
	public String getAcctLvl() {
		return acctLvl;
	}

	/**
	 * Column Info
	 * @param acctLvl
	 */
	public void setAcctLvl(String acctLvl) {
		this.acctLvl = acctLvl;
	}
	
	/**
	 * Column Info
	 * @return guide
	 */
	public String getGuide() {
		return guide;
	}


	/**
	 * Column Info
	 * @param guide
	 */
	public void setGuide(String guide) {
		this.guide = guide;
	}
	
	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return totCnt;
	}


	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @return iseditable
	 */
	public String getIseditable() {
		return iseditable;
	}


	/**
	 * Column Info
	 * @param iseditable
	 */
	public void setIseditable(String iseditable) {
		this.iseditable = iseditable;
	}
	
	/**
	 * Column Info
	 * @return color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * Column Info
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Column Info
	 * @param salesRep
	 */
	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param fcastSeq
	 */
	public void setFcastSeq(String fcastSeq) {
		this.fcastSeq = fcastSeq;
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
	 * @param scFlg
	 */
	public void setScFlg(String scFlg) {
		this.scFlg = scFlg;
	}
	
	/**
	 * Column Info
	 * @param newFlg
	 */
	public void setNewFlg(String newFlg) {
		this.newFlg = newFlg;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param viewType
	 */
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
	/**
	 * Column Info
	 * @param hhFlg
	 */
	public void setHhFlg(String hhFlg) {
		this.hhFlg = hhFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlAcct
	 */
	public void setCtrlAcct(String ctrlAcct) {
		this.ctrlAcct = ctrlAcct;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
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
	 * @param zeroCust
	 */
	public void setZeroCust(String zeroCust) {
		this.zeroCust = zeroCust;
	}
	
	/**
	 * Column Info
	 * @return fcastRdQty
	 */
	public String getFcastRdQty() {
		return this.fcastRdQty;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlLocFlg
	 */
	public String getCtrlLocFlg() {
		return this.ctrlLocFlg;
	}
	
	/**
	 * Column Info
	 * @return usaBkgModCd
	 */
	public String getUsaBkgModCd() {
		return this.usaBkgModCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlDestLvlCd
	 */
	public String getCtrlDestLvlCd() {
		return this.ctrlDestLvlCd;
	}
	
	/**
	 * Column Info
	 * @return bkg40FtDryQty
	 */
	public String getBkg40FtDryQty() {
		return this.bkg40FtDryQty;
	}
	
	/**
	 * Column Info
	 * @return ctrlAcctFlg
	 */
	public String getCtrlAcctFlg() {
		return this.ctrlAcctFlg;
	}
	
	
	/**
	 * Column Info
	 * @return ctrlRd
	 */
	public String getCtrlRd() {
		return this.ctrlRd;
	}
	
	/**
	 * Column Info
	 * @return ctrlRdFlg
	 */
	public String getCtrlRdFlg() {
		return this.ctrlRdFlg;
	}
	
	/**
	 * Column Info
	 * @return usdBkg40FtDryQty
	 */
	public String getUsdBkg40FtDryQty() {
		return this.usdBkg40FtDryQty;
	}
	
	/**
	 * Column Info
	 * @return ctrlEccFlg
	 */
	public String getCtrlEccFlg() {
		return this.ctrlEccFlg;
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
	 * @return usdBkg20FtDryQty
	 */
	public String getUsdBkg20FtDryQty() {
		return this.usdBkg20FtDryQty;
	}
	
	/**
	 * Column Info
	 * @return ctrlD2Flg
	 */
	public String getCtrlD2Flg() {
		return this.ctrlD2Flg;
	}
	
	/**
	 * Column Info
	 * @return cfm40FtDryQty
	 */
	public String getCfm40FtDryQty() {
		return this.cfm40FtDryQty;
	}
	
	/**
	 * Column Info
	 * @return ctrlUsaSvcModFlg
	 */
	public String getCtrlUsaSvcModFlg() {
		return this.ctrlUsaSvcModFlg;
	}
	
	/**
	 * Column Info
	 * @return fcast40FtDryQty
	 */
	public String getFcast40FtDryQty() {
		return this.fcast40FtDryQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRdQty
	 */
	public String getBkgRdQty() {
		return this.bkgRdQty;
	}
	
	/**
	 * Column Info
	 * @return ctrlD2
	 */
	public String getCtrlD2() {
		return this.ctrlD2;
	}
	
	/**
	 * Column Info
	 * @return ctrlD4
	 */
	public String getCtrlD4() {
		return this.ctrlD4;
	}
	
	/**
	 * Column Info
	 * @return bkg20FtDryQty
	 */
	public String getBkg20FtDryQty() {
		return this.bkg20FtDryQty;
	}
	
	/**
	 * Column Info
	 * @return fcast20FtDryQty
	 */
	public String getFcast20FtDryQty() {
		return this.fcast20FtDryQty;
	}
	
	/**
	 * Column Info
	 * @return cfm20FtDryQty
	 */
	public String getCfm20FtDryQty() {
		return this.cfm20FtDryQty;
	}
	
	/**
	 * Column Info
	 * @return cfmRdQty
	 */
	public String getCfmRdQty() {
		return this.cfmRdQty;
	}
	
	/**
	 * Column Info
	 * @return ctrlD4Flg
	 */
	public String getCtrlD4Flg() {
		return this.ctrlD4Flg;
	}
	
	/**
	 * Column Info
	 * @return usdBkgRdQty
	 */
	public String getUsdBkgRdQty() {
		return this.usdBkgRdQty;
	}
	

	/**
	 * Column Info
	 * @param fcastRdQty
	 */
	public void setFcastRdQty(String fcastRdQty) {
		this.fcastRdQty = fcastRdQty;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlLocFlg
	 */
	public void setCtrlLocFlg(String ctrlLocFlg) {
		this.ctrlLocFlg = ctrlLocFlg;
	}
	
	/**
	 * Column Info
	 * @param usaBkgModCd
	 */
	public void setUsaBkgModCd(String usaBkgModCd) {
		this.usaBkgModCd = usaBkgModCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlDestLvlCd
	 */
	public void setCtrlDestLvlCd(String ctrlDestLvlCd) {
		this.ctrlDestLvlCd = ctrlDestLvlCd;
	}
	
	/**
	 * Column Info
	 * @param bkg40FtDryQty
	 */
	public void setBkg40FtDryQty(String bkg40FtDryQty) {
		this.bkg40FtDryQty = bkg40FtDryQty;
	}
	
	/**
	 * Column Info
	 * @param ctrlAcctFlg
	 */
	public void setCtrlAcctFlg(String ctrlAcctFlg) {
		this.ctrlAcctFlg = ctrlAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlRd
	 */
	public void setCtrlRd(String ctrlRd) {
		this.ctrlRd = ctrlRd;
	}
	
	/**
	 * Column Info
	 * @param ctrlRdFlg
	 */
	public void setCtrlRdFlg(String ctrlRdFlg) {
		this.ctrlRdFlg = ctrlRdFlg;
	}
	
	/**
	 * Column Info
	 * @param usdBkg40FtDryQty
	 */
	public void setUsdBkg40FtDryQty(String usdBkg40FtDryQty) {
		this.usdBkg40FtDryQty = usdBkg40FtDryQty;
	}
	
	/**
	 * Column Info
	 * @param ctrlEccFlg
	 */
	public void setCtrlEccFlg(String ctrlEccFlg) {
		this.ctrlEccFlg = ctrlEccFlg;
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
	 * @param usdBkg20FtDryQty
	 */
	public void setUsdBkg20FtDryQty(String usdBkg20FtDryQty) {
		this.usdBkg20FtDryQty = usdBkg20FtDryQty;
	}
	
	/**
	 * Column Info
	 * @param ctrlD2Flg
	 */
	public void setCtrlD2Flg(String ctrlD2Flg) {
		this.ctrlD2Flg = ctrlD2Flg;
	}
	
	/**
	 * Column Info
	 * @param cfm40FtDryQty
	 */
	public void setCfm40FtDryQty(String cfm40FtDryQty) {
		this.cfm40FtDryQty = cfm40FtDryQty;
	}
	
	/**
	 * Column Info
	 * @param ctrlUsaSvcModFlg
	 */
	public void setCtrlUsaSvcModFlg(String ctrlUsaSvcModFlg) {
		this.ctrlUsaSvcModFlg = ctrlUsaSvcModFlg;
	}
	
	/**
	 * Column Info
	 * @param fcast40FtDryQty
	 */
	public void setFcast40FtDryQty(String fcast40FtDryQty) {
		this.fcast40FtDryQty = fcast40FtDryQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRdQty
	 */
	public void setBkgRdQty(String bkgRdQty) {
		this.bkgRdQty = bkgRdQty;
	}
	
	/**
	 * Column Info
	 * @param ctrlD2
	 */
	public void setCtrlD2(String ctrlD2) {
		this.ctrlD2 = ctrlD2;
	}
	
	/**
	 * Column Info
	 * @param ctrlD4
	 */
	public void setCtrlD4(String ctrlD4) {
		this.ctrlD4 = ctrlD4;
	}
	
	/**
	 * Column Info
	 * @param bkg20FtDryQty
	 */
	public void setBkg20FtDryQty(String bkg20FtDryQty) {
		this.bkg20FtDryQty = bkg20FtDryQty;
	}
	
	/**
	 * Column Info
	 * @param fcast20FtDryQty
	 */
	public void setFcast20FtDryQty(String fcast20FtDryQty) {
		this.fcast20FtDryQty = fcast20FtDryQty;
	}
	
	/**
	 * Column Info
	 * @param cfm20FtDryQty
	 */
	public void setCfm20FtDryQty(String cfm20FtDryQty) {
		this.cfm20FtDryQty = cfm20FtDryQty;
	}
	
	/**
	 * Column Info
	 * @param cfmRdQty
	 */
	public void setCfmRdQty(String cfmRdQty) {
		this.cfmRdQty = cfmRdQty;
	}
	
	/**
	 * Column Info
	 * @param ctrlD4Flg
	 */
	public void setCtrlD4Flg(String ctrlD4Flg) {
		this.ctrlD4Flg = ctrlD4Flg;
	}
	
	/**
	 * Column Info
	 * @param usdBkgRdQty
	 */
	public void setUsdBkgRdQty(String usdBkgRdQty) {
		this.usdBkgRdQty = usdBkgRdQty;
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
		setCfm40ftHcQty(JSPUtil.getParameter(request, prefix + "cfm_40ft_hc_qty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCfmRfQty(JSPUtil.getParameter(request, prefix + "cfm_rf_qty", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setLvl2(JSPUtil.getParameter(request, prefix + "lvl2", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrl53(JSPUtil.getParameter(request, prefix + "ctrl_53", ""));
		setBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_45ft_hc_qty", ""));
		setLvl1(JSPUtil.getParameter(request, prefix + "lvl1", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setBkgRfQty(JSPUtil.getParameter(request, prefix + "bkg_rf_qty", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCfm53ftQty(JSPUtil.getParameter(request, prefix + "cfm_53ft_qty", ""));
		setBkgTtlQty(JSPUtil.getParameter(request, prefix + "bkg_ttl_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setPodSeq(JSPUtil.getParameter(request, prefix + "pod_seq", ""));
		setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgTtlWgt(JSPUtil.getParameter(request, prefix + "bkg_ttl_wgt", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setChl(JSPUtil.getParameter(request, prefix + "chl", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setCtrlWt(JSPUtil.getParameter(request, prefix + "ctrl_wt", ""));
		setBkg40ftQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_qty", ""));
		setBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_hc_qty", ""));
		setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
		setCfm45ftHcQty(JSPUtil.getParameter(request, prefix + "cfm_45ft_hc_qty", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setPolSeq(JSPUtil.getParameter(request, prefix + "pol_seq", ""));
		setCtrlLvl(JSPUtil.getParameter(request, prefix + "ctrl_lvl", ""));
		setFcastCnt(JSPUtil.getParameter(request, prefix + "fcast_cnt", ""));
		setFcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", ""));
		setCfmTtlQty(JSPUtil.getParameter(request, prefix + "cfm_ttl_qty", ""));
		setBkg20ftQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrlRf(JSPUtil.getParameter(request, prefix + "ctrl_rf", ""));
		setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setIocTsCd(JSPUtil.getParameter(request, prefix + "ioc_ts_cd", ""));
		setCfmTtlWgt(JSPUtil.getParameter(request, prefix + "cfm_ttl_wgt", ""));
		setSubOfcCd(JSPUtil.getParameter(request, prefix + "sub_ofc_cd", ""));
		setMstCnt(JSPUtil.getParameter(request, prefix + "mst_cnt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCtrl45(JSPUtil.getParameter(request, prefix + "ctrl_45", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
		setBkg53ftQty(JSPUtil.getParameter(request, prefix + "bkg_53ft_qty", ""));
		setCtrlHc(JSPUtil.getParameter(request, prefix + "ctrl_hc", ""));
		
		setFcast20Qty(JSPUtil.getParameter(request, prefix + "fcast_20ft_qty", ""));
		setFcast40Qty(JSPUtil.getParameter(request, prefix + "fcast_40ft_qty", ""));
		setBkgCustCntCd(JSPUtil.getParameter(request, prefix + "bkg_cust_cnt_cd", ""));
		setBkgCustSeq(JSPUtil.getParameter(request, prefix + "bkg_cust_seq", ""));
		setBkgCustNm(JSPUtil.getParameter(request, prefix + "bkg_cust_nm", ""));
		
		setCif(JSPUtil.getParameter(request, prefix + "cif", ""));
		setFob(JSPUtil.getParameter(request, prefix + "fob", ""));
		setOth(JSPUtil.getParameter(request, prefix + "oth", ""));
		
		setExistFlg(JSPUtil.getParameter(request, prefix + "exist_flg", ""));
		
		setAcctLvl(JSPUtil.getParameter(request, prefix + "acct_lvl", ""));
		setGuide(JSPUtil.getParameter(request, prefix + "guide", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setIseditable(JSPUtil.getParameter(request, prefix + "iseditable", ""));
		setColor(JSPUtil.getParameter(request, prefix + "color", ""));
		setFcastRmk(JSPUtil.getParameter(request, prefix + "fcast_rmk", ""));
		setSalesRep(JSPUtil.getParameter(request, prefix + "salesRep", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFcastSeq(JSPUtil.getParameter(request, prefix + "fcast_seq", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setScFlg(JSPUtil.getParameter(request, prefix + "sc_flg", ""));
		setNewFlg(JSPUtil.getParameter(request, prefix + "new_flg", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setViewType(JSPUtil.getParameter(request, prefix + "view_type", ""));
		setHhFlg(JSPUtil.getParameter(request, prefix + "hh_flg", ""));
		setCtrlAcct(JSPUtil.getParameter(request, prefix + "ctrl_acct", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setZeroCust(JSPUtil.getParameter(request, prefix + "zero_cust", ""));
	
		setFcastRdQty(JSPUtil.getParameter(request, prefix + "fcast_rd_qty", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setCtrlLocFlg(JSPUtil.getParameter(request, prefix + "ctrl_loc_flg", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setCtrlDestLvlCd(JSPUtil.getParameter(request, prefix + "ctrl_dest_lvl_cd", ""));
		setBkg40FtDryQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_dry_qty", ""));
		setCtrlAcctFlg(JSPUtil.getParameter(request, prefix + "ctrl_acct_flg", ""));
		setCtrlRd(JSPUtil.getParameter(request, prefix + "ctrl_rd", ""));
		setCtrlRdFlg(JSPUtil.getParameter(request, prefix + "ctrl_rd_flg", ""));
		setUsdBkg40FtDryQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_dry_qty", ""));
		setCtrlEccFlg(JSPUtil.getParameter(request, prefix + "ctrl_ecc_flg", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setUsdBkg20FtDryQty(JSPUtil.getParameter(request, prefix + "usd_bkg_20ft_dry_qty", ""));
		setCtrlD2Flg(JSPUtil.getParameter(request, prefix + "ctrl_d2_flg", ""));
		setCfm40FtDryQty(JSPUtil.getParameter(request, prefix + "cfm_40ft_dry_qty", ""));
		setCtrlUsaSvcModFlg(JSPUtil.getParameter(request, prefix + "ctrl_usa_svc_mod_flg", ""));
		setFcast40FtDryQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_dry_qty", ""));
		setBkgRdQty(JSPUtil.getParameter(request, prefix + "bkg_rd_qty", ""));
		setCtrlD2(JSPUtil.getParameter(request, prefix + "ctrl_d2", ""));
		setCtrlD4(JSPUtil.getParameter(request, prefix + "ctrl_d4", ""));
		setBkg20FtDryQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_dry_qty", ""));
		setFcast20FtDryQty(JSPUtil.getParameter(request, prefix + "fcast_20ft_dry_qty", ""));
		setCfm20FtDryQty(JSPUtil.getParameter(request, prefix + "cfm_20ft_dry_qty", ""));
		setCfmRdQty(JSPUtil.getParameter(request, prefix + "cfm_rd_qty", ""));
		setCtrlD4Flg(JSPUtil.getParameter(request, prefix + "ctrl_d4_flg", ""));
		setUsdBkgRdQty(JSPUtil.getParameter(request, prefix + "usd_bkg_rd_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyForecastManageListVO[]
	 */
	public SearchDailyForecastManageListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. -
	 * @param request
	 * @param prefix
	 * @return SearchDailyForecastManageListVO[]
	 */
	public SearchDailyForecastManageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDailyForecastManageListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cfm40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "cfm_40ft_hc_qty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cfmRfQty = (JSPUtil.getParameter(request, prefix	+ "cfm_rf_qty", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] lvl2 = (JSPUtil.getParameter(request, prefix	+ "lvl2", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrl53 = (JSPUtil.getParameter(request, prefix	+ "ctrl_53", length));
			String[] bkg45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_45ft_hc_qty", length));
			String[] lvl1 = (JSPUtil.getParameter(request, prefix	+ "lvl1", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] bkgRfQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_qty", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] cfm53ftQty = (JSPUtil.getParameter(request, prefix	+ "cfm_53ft_qty", length));
			String[] bkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] podSeq = (JSPUtil.getParameter(request, prefix	+ "pod_seq", length));
			String[] fcastRfQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rf_qty", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_wgt", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] chl = (JSPUtil.getParameter(request, prefix	+ "chl", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] ctrlWt = (JSPUtil.getParameter(request, prefix	+ "ctrl_wt", length));
			String[] bkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_qty", length));
			String[] bkg40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_hc_qty", length));
			String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_hc_qty", length));
			String[] cfm45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "cfm_45ft_hc_qty", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] polSeq = (JSPUtil.getParameter(request, prefix	+ "pol_seq", length));
			String[] ctrlLvl = (JSPUtil.getParameter(request, prefix	+ "ctrl_lvl", length));
			String[] fcastCnt = (JSPUtil.getParameter(request, prefix	+ "fcast_cnt", length));
			String[] fcastTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_teu_qty", length));
			String[] cfmTtlQty = (JSPUtil.getParameter(request, prefix	+ "cfm_ttl_qty", length));
			String[] bkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrlRf = (JSPUtil.getParameter(request, prefix	+ "ctrl_rf", length));
			String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_qty", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] fcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_53ft_qty", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_wgt", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] iocTsCd = (JSPUtil.getParameter(request, prefix	+ "ioc_ts_cd", length));
			String[] cfmTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cfm_ttl_wgt", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] mstCnt = (JSPUtil.getParameter(request, prefix	+ "mst_cnt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ctrl45 = (JSPUtil.getParameter(request, prefix	+ "ctrl_45", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_45ft_hc_qty", length));
			String[] bkg53ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_53ft_qty", length));
			String[] ctrlHc = (JSPUtil.getParameter(request, prefix	+ "ctrl_hc", length));
						
			String[] fcast20Qty = (JSPUtil.getParameter(request, prefix	+ "fcast_20ft_qty", length));
			String[] fcast40Qty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_qty", length));
			String[] bkgCustCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_cnt_cd", length));
			String[] bkgCustSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_seq", length));
			String[] bkgCustNm = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_nm", length));
			
			String[] cif = (JSPUtil.getParameter(request, prefix	+ "cif", length));
			String[] fob = (JSPUtil.getParameter(request, prefix	+ "fob", length));
			String[] oth = (JSPUtil.getParameter(request, prefix	+ "oth", length));
			
			String[] existFlg   = (JSPUtil.getParameter(request, prefix	+ "exist_flg", length));
			String[] acctLvl    = (JSPUtil.getParameter(request, prefix	+ "acct_lvl", length));
			String[] guide      = (JSPUtil.getParameter(request, prefix	+ "guide", length));
			String[] totCnt     = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] iseditable = (JSPUtil.getParameter(request, prefix	+ "iseditable", length));
			String[] color      = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] fcastRmk   = (JSPUtil.getParameter(request, prefix	+ "fcast_rmk", length));
			String[] salesRep   = (JSPUtil.getParameter(request, prefix	+ "salesRep", length));
			String[] updUsrId   = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fcastSeq   = (JSPUtil.getParameter(request, prefix	+ "fcast_seq", length));
			String[] scNo       = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] scFlg      = (JSPUtil.getParameter(request, prefix	+ "sc_flg", length));
			String[] newFlg     = (JSPUtil.getParameter(request, prefix	+ "new_flg", length));
			String[] contiCd    = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] viewType   = (JSPUtil.getParameter(request, prefix	+ "view_type", length));
			String[] hhFlg      = (JSPUtil.getParameter(request, prefix	+ "hh_flg", length));
			String[] ctrlAcct   = (JSPUtil.getParameter(request, prefix	+ "ctrl_acct", length));
			String[] slsRhqCd   = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] rfaNo      = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] zeroCust   = (JSPUtil.getParameter(request, prefix	+ "zero_cust", length));
			
			String[] fcastRdQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rd_qty", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] ctrlLocFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_loc_flg", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] ctrlDestLvlCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_dest_lvl_cd", length));
			String[] bkg40FtDryQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_dry_qty", length));
			String[] ctrlAcctFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_acct_flg", length));
			String[] ctrlRd = (JSPUtil.getParameter(request, prefix	+ "ctrl_rd", length));
			String[] ctrlRdFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rd_flg", length));
			String[] usdBkg40FtDryQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_dry_qty", length));
			String[] ctrlEccFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_ecc_flg", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] usdBkg20FtDryQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_20ft_dry_qty", length));
			String[] ctrlD2Flg = (JSPUtil.getParameter(request, prefix	+ "ctrl_d2_flg", length));
			String[] cfm40FtDryQty = (JSPUtil.getParameter(request, prefix	+ "cfm_40ft_dry_qty", length));
			String[] ctrlUsaSvcModFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_usa_svc_mod_flg", length));
			String[] fcast40FtDryQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_dry_qty", length));
			String[] bkgRdQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rd_qty", length));
			String[] ctrlD2 = (JSPUtil.getParameter(request, prefix	+ "ctrl_d2", length));
			String[] ctrlD4 = (JSPUtil.getParameter(request, prefix	+ "ctrl_d4", length));
			String[] bkg20FtDryQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_dry_qty", length));
			String[] fcast20FtDryQty = (JSPUtil.getParameter(request, prefix	+ "fcast_20ft_dry_qty", length));
			String[] cfm20FtDryQty = (JSPUtil.getParameter(request, prefix	+ "cfm_20ft_dry_qty", length));
			String[] cfmRdQty = (JSPUtil.getParameter(request, prefix	+ "cfm_rd_qty", length));
			String[] ctrlD4Flg = (JSPUtil.getParameter(request, prefix	+ "ctrl_d4_flg", length));
			String[] usdBkgRdQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_rd_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDailyForecastManageListVO();
				if (cfm40ftHcQty[i] != null)
					model.setCfm40ftHcQty(cfm40ftHcQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cfmRfQty[i] != null)
					model.setCfmRfQty(cfmRfQty[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (lvl2[i] != null)
					model.setLvl2(lvl2[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrl53[i] != null)
					model.setCtrl53(ctrl53[i]);
				if (bkg45ftHcQty[i] != null)
					model.setBkg45ftHcQty(bkg45ftHcQty[i]);
				if (lvl1[i] != null)
					model.setLvl1(lvl1[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (bkgRfQty[i] != null)
					model.setBkgRfQty(bkgRfQty[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (cfm53ftQty[i] != null)
					model.setCfm53ftQty(cfm53ftQty[i]);
				if (bkgTtlQty[i] != null)
					model.setBkgTtlQty(bkgTtlQty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (podSeq[i] != null)
					model.setPodSeq(podSeq[i]);
				if (fcastRfQty[i] != null)
					model.setFcastRfQty(fcastRfQty[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgTtlWgt[i] != null)
					model.setBkgTtlWgt(bkgTtlWgt[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (chl[i] != null)
					model.setChl(chl[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (ctrlWt[i] != null)
					model.setCtrlWt(ctrlWt[i]);
				if (bkg40ftQty[i] != null)
					model.setBkg40ftQty(bkg40ftQty[i]);
				if (bkg40ftHcQty[i] != null)
					model.setBkg40ftHcQty(bkg40ftHcQty[i]);
				if (fcast40ftHcQty[i] != null)
					model.setFcast40ftHcQty(fcast40ftHcQty[i]);
				if (cfm45ftHcQty[i] != null)
					model.setCfm45ftHcQty(cfm45ftHcQty[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (polSeq[i] != null)
					model.setPolSeq(polSeq[i]);
				if (ctrlLvl[i] != null)
					model.setCtrlLvl(ctrlLvl[i]);
				if (fcastCnt[i] != null)
					model.setFcastCnt(fcastCnt[i]);
				if (fcastTtlTeuQty[i] != null)
					model.setFcastTtlTeuQty(fcastTtlTeuQty[i]);
				if (cfmTtlQty[i] != null)
					model.setCfmTtlQty(cfmTtlQty[i]);
				if (bkg20ftQty[i] != null)
					model.setBkg20ftQty(bkg20ftQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrlRf[i] != null)
					model.setCtrlRf(ctrlRf[i]);
				if (fcastTtlQty[i] != null)
					model.setFcastTtlQty(fcastTtlQty[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (fcast53ftQty[i] != null)
					model.setFcast53ftQty(fcast53ftQty[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (fcastTtlWgt[i] != null)
					model.setFcastTtlWgt(fcastTtlWgt[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (iocTsCd[i] != null)
					model.setIocTsCd(iocTsCd[i]);
				if (cfmTtlWgt[i] != null)
					model.setCfmTtlWgt(cfmTtlWgt[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (mstCnt[i] != null)
					model.setMstCnt(mstCnt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ctrl45[i] != null)
					model.setCtrl45(ctrl45[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (fcast45ftHcQty[i] != null)
					model.setFcast45ftHcQty(fcast45ftHcQty[i]);
				if (bkg53ftQty[i] != null)
					model.setBkg53ftQty(bkg53ftQty[i]);
				if (ctrlHc[i] != null)
					model.setCtrlHc(ctrlHc[i]);
				
				if (fcast20Qty[i] != null)
					model.setFcast20Qty(fcast20Qty[i]);
				if (fcast40Qty[i] != null)
					model.setFcast40Qty(fcast40Qty[i]);				
				if (bkgCustCntCd[i] != null)
					model.setBkgCustCntCd(bkgCustCntCd[i]);
				if (bkgCustSeq[i] != null)
					model.setBkgCustSeq(bkgCustSeq[i]);
				if (bkgCustNm[i] != null)
					model.setBkgCustNm(bkgCustNm[i]);
				
				if (cif[i] != null)
					model.setCif(cif[i]);
				if (fob[i] != null)
					model.setFob(fob[i]);
				if (oth[i] != null)
					model.setOth(oth[i]);
				
				if (acctLvl[i] != null)
					model.setAcctLvl(acctLvl[i]);
				
				if (existFlg[i] != null)
					model.setExistFlg(existFlg[i]);
				if (guide[i] != null)
					model.setGuide(guide[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (iseditable[i] != null)
					model.setIseditable(iseditable[i]);
				if (color[i] != null)
					model.setColor(color[i]);
				if (fcastRmk[i] != null)
					model.setFcastRmk(fcastRmk[i]);
				if (salesRep[i] != null)
					model.setSalesRep(salesRep[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fcastSeq[i] != null)
					model.setFcastSeq(fcastSeq[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (scFlg[i] != null)
					model.setScFlg(scFlg[i]);
				if (newFlg[i] != null)
					model.setNewFlg(newFlg[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (viewType[i] != null)
					model.setViewType(viewType[i]);
				if (hhFlg[i] != null)
					model.setHhFlg(hhFlg[i]);
				if (ctrlAcct[i] != null)
					model.setCtrlAcct(ctrlAcct[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (zeroCust[i] != null)
					model.setZeroCust(zeroCust[i]);

				if (fcastRdQty[i] != null)
					model.setFcastRdQty(fcastRdQty[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (ctrlLocFlg[i] != null)
					model.setCtrlLocFlg(ctrlLocFlg[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (ctrlDestLvlCd[i] != null)
					model.setCtrlDestLvlCd(ctrlDestLvlCd[i]);
				if (bkg40FtDryQty[i] != null)
					model.setBkg40FtDryQty(bkg40FtDryQty[i]);
				if (ctrlAcctFlg[i] != null)
					model.setCtrlAcctFlg(ctrlAcctFlg[i]);
				if (ctrlRd[i] != null)
					model.setCtrlRd(ctrlRd[i]);
				if (ctrlRdFlg[i] != null)
					model.setCtrlRdFlg(ctrlRdFlg[i]);
				if (usdBkg40FtDryQty[i] != null)
					model.setUsdBkg40FtDryQty(usdBkg40FtDryQty[i]);
				if (ctrlEccFlg[i] != null)
					model.setCtrlEccFlg(ctrlEccFlg[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (usdBkg20FtDryQty[i] != null)
					model.setUsdBkg20FtDryQty(usdBkg20FtDryQty[i]);
				if (ctrlD2Flg[i] != null)
					model.setCtrlD2Flg(ctrlD2Flg[i]);
				if (cfm40FtDryQty[i] != null)
					model.setCfm40FtDryQty(cfm40FtDryQty[i]);
				if (ctrlUsaSvcModFlg[i] != null)
					model.setCtrlUsaSvcModFlg(ctrlUsaSvcModFlg[i]);
				if (fcast40FtDryQty[i] != null)
					model.setFcast40FtDryQty(fcast40FtDryQty[i]);
				if (bkgRdQty[i] != null)
					model.setBkgRdQty(bkgRdQty[i]);
				if (ctrlD2[i] != null)
					model.setCtrlD2(ctrlD2[i]);
				if (ctrlD4[i] != null)
					model.setCtrlD4(ctrlD4[i]);
				if (bkg20FtDryQty[i] != null)
					model.setBkg20FtDryQty(bkg20FtDryQty[i]);
				if (fcast20FtDryQty[i] != null)
					model.setFcast20FtDryQty(fcast20FtDryQty[i]);
				if (cfm20FtDryQty[i] != null)
					model.setCfm20FtDryQty(cfm20FtDryQty[i]);
				if (cfmRdQty[i] != null)
					model.setCfmRdQty(cfmRdQty[i]);
				if (ctrlD4Flg[i] != null)
					model.setCtrlD4Flg(ctrlD4Flg[i]);
				if (usdBkgRdQty[i] != null)
					model.setUsdBkgRdQty(usdBkgRdQty[i]);
				
				models.add(model);
			}
			

		} catch (Exception e) {
			return null;
		}
		return getSearchDailyForecastManageListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDailyForecastManageListVO[]
	 */
	public SearchDailyForecastManageListVO[] getSearchDailyForecastManageListVOs(){
		SearchDailyForecastManageListVO[] vos = (SearchDailyForecastManageListVO[])models.toArray(new SearchDailyForecastManageListVO[models.size()]);
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
		this.cfm40ftHcQty = this.cfm40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRfQty = this.cfmRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl2 = this.lvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl53 = this.ctrl53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg45ftHcQty = this.bkg45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl1 = this.lvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfQty = this.bkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfm53ftQty = this.cfm53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlQty = this.bkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSeq = this.podSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRfQty = this.fcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlWgt = this.bkgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chl = this.chl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlWt = this.ctrlWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftQty = this.bkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftHcQty = this.bkg40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftHcQty = this.fcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfm45ftHcQty = this.cfm45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSeq = this.polSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlLvl = this.ctrlLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCnt = this.fcastCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlTeuQty = this.fcastTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmTtlQty = this.cfmTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20ftQty = this.bkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRf = this.ctrlRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlQty = this.fcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53ftQty = this.fcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlWgt = this.fcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocTsCd = this.iocTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmTtlWgt = this.cfmTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCnt = this.mstCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl45 = this.ctrl45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45ftHcQty = this.fcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg53ftQty = this.bkg53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlHc = this.ctrlHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.fcast20Qty = this.fcast20Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40Qty = this.fcast40Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustNm = this.bkgCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
				
		this.cif = this.cif.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fob = this.fob.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oth = this.oth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.existFlg   = this.existFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctLvl    = this.acctLvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.guide      = this.guide.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt     = this.totCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iseditable = this.iseditable.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.color      = this.color.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRmk   = this.fcastRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesRep   = this.salesRep.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId   = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastSeq   = this.fcastSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo       = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scFlg      = this.scFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newFlg     = this.newFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd    = this.contiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewType   = this.viewType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hhFlg      = this.hhFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlAcct   = this.ctrlAcct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd   = this.slsRhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo      = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zeroCust   = this.zeroCust.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.fcastRdQty = this.fcastRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlLocFlg = this.ctrlLocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlDestLvlCd = this.ctrlDestLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40FtDryQty = this.bkg40FtDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlAcctFlg = this.ctrlAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRd = this.ctrlRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRdFlg = this.ctrlRdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40FtDryQty = this.usdBkg40FtDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlEccFlg = this.ctrlEccFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg20FtDryQty = this.usdBkg20FtDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD2Flg = this.ctrlD2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfm40FtDryQty = this.cfm40FtDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUsaSvcModFlg = this.ctrlUsaSvcModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40FtDryQty = this.fcast40FtDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRdQty = this.bkgRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD2 = this.ctrlD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD4 = this.ctrlD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20FtDryQty = this.bkg20FtDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast20FtDryQty = this.fcast20FtDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfm20FtDryQty = this.cfm20FtDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRdQty = this.cfmRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD4Flg = this.ctrlD4Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgRdQty = this.usdBkgRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
}
