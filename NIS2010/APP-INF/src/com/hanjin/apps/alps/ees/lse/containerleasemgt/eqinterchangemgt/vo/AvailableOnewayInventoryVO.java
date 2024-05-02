/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementListVO.java
*@FileTitle : AgreementListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.29 노정용 
* 1.0 Creation
* =======================================================
* 2010.12.02 박명신 [CHM-201007443-01] Ref No. 추가
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 두기민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AvailableOnewayInventoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AvailableOnewayInventoryVO> models = new ArrayList<AvailableOnewayInventoryVO>();
	
	/* Column Info */
	private String cntr12Qty = null;
	/* Column Info */
	private String cntr3Qty = null;
	/* Column Info */
	private String cntr22Qty = null;
	/* Column Info */
	private String cntr18Qty = null;
	/* Column Info */
	private String cntr25Qty = null;
	/* Column Info */
	private String cntr9Qty = null;
	/* Column Info */
	private String cntr13Qty = null;
	/* Column Info */
	private String cntr8Qty = null;
	/* Column Info */
	private String cntr20Qty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntr14Qty = null;
	/* Column Info */
	private String cntr26Qty = null;
	/* Column Info */
	private String cntr19Qty = null;
	/* Column Info */
	private String cntr15Qty = null;
	/* Column Info */
	private String cntr17Qty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String mvmt = null;
	/* Column Info */
	private String delDol = null;
	/* Column Info */
	private String porDol = null;
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String locCdTeuNo = null;
	/* Column Info */
	private String cntr2Qty = null;
	/* Column Info */
	private String cntr16Qty = null;
	/* Column Info */
	private String cntr29Qty = null;
	/* Column Info */
	private String typeNm = null;
	/* Column Info */
	private String cntr10Qty = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String cntr5Qty = null;
	/* Column Info */
	private String cntr4Qty = null;
	/* Column Info */
	private String cntr30Qty = null;
	/* Column Info */
	private String cntr23Qty = null;
	/* Column Info */
	private String cntr24Qty = null;
	/* Column Info */
	private String cntr11Qty = null;
	/* Column Info */
	private String cntr1Qty = null;
	/* Column Info */
	private String cntr6Qty = null;
	/* Column Info */
	private String cntr28Qty = null;
	/* Column Info */
	private String cntr21Qty = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String cntr7Qty = null;
	/* Column Info */
	private String cntr27Qty = null;
	/* Column Info */
	private String typeCd = null;
	/* Column Info */
	private String fstCls = null;
	/* Column Info */
	private String sndCls = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String onhQty = null;
	/* Column Info */
	private String trd = null;
	/* Column Info */
	private String offHireLoc = null;
	/* Column Info */
	private String targetDol = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String cntrMvDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String mvntDol = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String usingDays = null;
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String appDt = null;
	/* Column Info */
	private String sDays = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String rLane = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String rntlChg = null;
	/* Column Info */
	private String lon = null;
	/* Column Info */
	private String puc = null;
	/* Column Info */
	private String pcr = null;
	/* Column Info */
	private String lof = null;
	/* Column Info */
	private String doc = null;
	/* Column Info */
	private String dcr = null;
	/* Column Info */
	private String custTp = null;
	/* Column Info */
	private String gCustCd = null;
	/* Column Info */
	private String gCustNm = null;
	/* Column Info */
	private String mstIf = null;
	/* Column Info */
	private String onhYd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String slsOfc = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String custNo = null;
	/* Column Info */
	private String crrMvmtStsCd = null;
	/* Column Info */
	private String crrCnmvEvntDt = null;
	/* Column Info */
	private String crrOrgYdCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String del = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AvailableOnewayInventoryVO() {}

	public AvailableOnewayInventoryVO(String ibflag, String pagerows, String vndrAbbrNm, String lstmCd, String mvmt, String delDol, String porDol, String total,String agmtNo, String refNo, String cntrNo, String cntrTpszCd, String typeNm, String locCdTeuNo
			             , String cntr1Qty, String cntr2Qty, String cntr3Qty, String cntr4Qty, String cntr5Qty, String cntr6Qty, String cntr7Qty, String cntr8Qty
			             , String cntr9Qty, String cntr10Qty, String cntr11Qty, String cntr12Qty, String cntr13Qty, String cntr14Qty, String cntr15Qty
			             , String cntr16Qty, String cntr17Qty, String cntr18Qty, String cntr19Qty, String cntr20Qty, String cntr21Qty, String cntr22Qty
			             , String cntr23Qty, String cntr24Qty, String cntr25Qty, String cntr26Qty, String cntr27Qty, String cntr28Qty, String cntr29Qty
			             , String cntr30Qty, String typeCd, String fstCls, String sndCls, String ttl, String ctrtNo, String rccCd, String lccCd
			             , String eccCd, String onhQty, String trd, String offHireLoc, String targetDol, String cnmvStsCd, String cnmvDt, String cntrMvDt, String crntYdCd, String mvntDol, String mvmtStsCd, String orgYdCd, String onhDt
			             , String freeDys, String usingDays, String lessor, String agmtSeq, String appDt, String sDays, String sts
			             , String onhYd, String bkgNo, String updUsrId, String shpr, String cnee, String slsOfc, String scRfaNo, String custNo, String crrMvmtStsCd, String crrCnmvEvntDt, String crrOrgYdCd, String custNm, String pol, String por, String pod
			             , String del, String etdDt, String etaDt, String rLane, String vvd, String rntlChg, String lon, String puc
			             , String pcr, String lof, String doc, String dcr, String custTp, String gCustCd, String gCustNm, String mstIf) {
		this.cntr12Qty = cntr12Qty;
		this.cntr3Qty = cntr3Qty;
		this.cntr22Qty = cntr22Qty;
		this.cntr18Qty = cntr18Qty;
		this.cntr25Qty = cntr25Qty;
		this.cntr9Qty = cntr9Qty;
		this.cntr13Qty = cntr13Qty;
		this.cntr8Qty = cntr8Qty;
		this.cntr20Qty = cntr20Qty;
		this.pagerows = pagerows;
		this.cntrNo = cntrNo;
		this.ibflag = ibflag;
		this.cntr14Qty = cntr14Qty;
		this.cntr26Qty = cntr26Qty;
		this.cntr19Qty = cntr19Qty;
		this.cntr15Qty = cntr15Qty;
		this.cntr17Qty = cntr17Qty;
		this.cntrTpszCd = cntrTpszCd;
		this.lstmCd = lstmCd;
		this.mvmt = mvmt;
		this.delDol = delDol;
		this.porDol = porDol;
		this.total = total;
		this.locCdTeuNo = locCdTeuNo;
		this.cntr2Qty = cntr2Qty;
		this.cntr16Qty = cntr16Qty;
		this.cntr29Qty = cntr29Qty;
		this.typeNm = typeNm;
		this.cntr10Qty = cntr10Qty;
		this.agmtNo = agmtNo;
		this.refNo = refNo;
		this.onhYd = onhYd;
		this.bkgNo = bkgNo;
		this.updUsrId = updUsrId;
		this.shpr = shpr;
		this.cnee = cnee;
		this.slsOfc = slsOfc;
		this.scRfaNo = scRfaNo;
		this.custNo = custNo;
		this.crrMvmtStsCd = crrMvmtStsCd;
		this.crrCnmvEvntDt = crrCnmvEvntDt;
		this.crrOrgYdCd = crrOrgYdCd;
		this.custNm = custNm;
		this.pol = pol;
		this.por = por;
		this.pod = pod;
		this.del = del;
		this.etdDt = etdDt;
		this.etaDt = etaDt;
		this.rLane = rLane;
		this.vvd = vvd;
		this.rntlChg = rntlChg;
		this.lon = lon;
		this.puc = puc;
		this.pcr = pcr;
		this.lof = lof;
		this.doc = doc;
		this.dcr = dcr;
		this.custTp = custTp;
		this.gCustCd = gCustCd;
		this.gCustNm = gCustNm;
		this.mstIf = mstIf;
		this.cntr5Qty = cntr5Qty;
		this.cntr4Qty = cntr4Qty;
		this.cntr30Qty = cntr30Qty;
		this.cntr23Qty = cntr23Qty;
		this.cntr24Qty = cntr24Qty;
		this.cntr11Qty = cntr11Qty;
		this.cntr1Qty = cntr1Qty;
		this.cntr6Qty = cntr6Qty;
		this.cntr28Qty = cntr28Qty;
		this.cntr21Qty = cntr21Qty;
		this.vndrAbbrNm = vndrAbbrNm;
		this.cntr7Qty = cntr7Qty;
		this.cntr27Qty = cntr27Qty;
		this.typeCd = typeCd;
		this.fstCls = fstCls;
		this.sndCls = sndCls;
		this.ttl = ttl;
		this.ctrtNo = ctrtNo;
		this.rccCd = rccCd;
		this.lccCd = lccCd;
		this.eccCd = eccCd;
		this.onhQty = onhQty;
		this.trd = trd;
		this.offHireLoc = offHireLoc;
		this.targetDol = targetDol;
		this.cnmvStsCd = cnmvStsCd;
		this.cnmvDt = cnmvDt;
		this.cntrMvDt = cntrMvDt;
		this.crntYdCd = crntYdCd;
		this.mvntDol = mvntDol;
		this.mvmtStsCd = mvmtStsCd;
		this.orgYdCd = orgYdCd;
		this.onhDt = onhDt;
		this.freeDys = freeDys;
		this.usingDays = usingDays;
		this.lessor = lessor;
		this.agmtSeq = agmtSeq;
		this.appDt = appDt;
		this.sDays = sDays;
		this.sts = sts;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr12_qty", getCntr12Qty());
		this.hashColumns.put("cntr3_qty", getCntr3Qty());
		this.hashColumns.put("cntr22_qty", getCntr22Qty());
		this.hashColumns.put("cntr18_qty", getCntr18Qty());
		this.hashColumns.put("cntr25_qty", getCntr25Qty());
		this.hashColumns.put("cntr9_qty", getCntr9Qty());
		this.hashColumns.put("cntr13_qty", getCntr13Qty());
		this.hashColumns.put("cntr8_qty", getCntr8Qty());
		this.hashColumns.put("cntr20_qty", getCntr20Qty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr14_qty", getCntr14Qty());
		this.hashColumns.put("cntr26_qty", getCntr26Qty());
		this.hashColumns.put("cntr19_qty", getCntr19Qty());
		this.hashColumns.put("cntr15_qty", getCntr15Qty());
		this.hashColumns.put("cntr17_qty", getCntr17Qty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("mvmt", getMvmt());
		this.hashColumns.put("del_dol", getDelDol());
		this.hashColumns.put("por_dol", getPorDol());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("loc_cd_teu_no", getLocCdTeuNo());
		this.hashColumns.put("cntr2_qty", getCntr2Qty());
		this.hashColumns.put("cntr16_qty", getCntr16Qty());
		this.hashColumns.put("cntr29_qty", getCntr29Qty());
		this.hashColumns.put("type_nm", getTypeNm());
		this.hashColumns.put("cntr10_qty", getCntr10Qty());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("onh_yd", getOnhYd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("sls_ofc", getSlsOfc());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("cust_no", getCustNo());
		this.hashColumns.put("crr_mvmt_sts_cd", getCrrMvmtStsCd());
		this.hashColumns.put("crr_cnmv_evnt_dt", getCrrCnmvEvntDt());
		this.hashColumns.put("crr_org_yd_cd", getCrrOrgYdCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("r_lane", getRLane());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rntl_chg", getRntlChg());
		this.hashColumns.put("lon", getLon());
		this.hashColumns.put("puc", getPuc());
		this.hashColumns.put("pcr", getPcr());
		this.hashColumns.put("lof", getLof());
		this.hashColumns.put("doc", getDoc());
		this.hashColumns.put("dcr", getDcr());
		this.hashColumns.put("cust_tp", getCustTp());
		this.hashColumns.put("g_cust_cd", getGCustCd());
		this.hashColumns.put("g_cust_nm", getGCustNm());
		this.hashColumns.put("mst_if", getMstIf());
		this.hashColumns.put("cntr5_qty", getCntr5Qty());
		this.hashColumns.put("cntr4_qty", getCntr4Qty());
		this.hashColumns.put("cntr30_qty", getCntr30Qty());
		this.hashColumns.put("cntr23_qty", getCntr23Qty());
		this.hashColumns.put("cntr24_qty", getCntr24Qty());
		this.hashColumns.put("cntr11_qty", getCntr11Qty());
		this.hashColumns.put("cntr1_qty", getCntr1Qty());
		this.hashColumns.put("cntr6_qty", getCntr6Qty());
		this.hashColumns.put("cntr28_qty", getCntr28Qty());
		this.hashColumns.put("cntr21_qty", getCntr21Qty());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("cntr7_qty", getCntr7Qty());
		this.hashColumns.put("cntr27_qty", getCntr27Qty());
		this.hashColumns.put("vndr_nm_type_cd", getTypeCd());
		this.hashColumns.put("fst_cls", getFstCls());
		this.hashColumns.put("snd_cls", getSndCls());
		this.hashColumns.put("type_cd", getTypeCd());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("lse_ctrt_no", getCtrtNo());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("onh_qty", getOnhQty());
		this.hashColumns.put("trd", getTrd());
		this.hashColumns.put("off_hire_loc", getOffHireLoc());
		this.hashColumns.put("target_dol", getTargetDol());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("cntr_mv_dt", getCntrMvDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("mvnt_dol", getMvntDol());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("using_days", getUsingDays());
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("app_dt", getAppDt());
		this.hashColumns.put("s_days", getSDays());
		this.hashColumns.put("sts", getSts());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr12_qty", "cntr12Qty");
		this.hashFields.put("cntr3_qty", "cntr3Qty");
		this.hashFields.put("cntr22_qty", "cntr22Qty");
		this.hashFields.put("cntr18_qty", "cntr18Qty");
		this.hashFields.put("cntr25_qty", "cntr25Qty");
		this.hashFields.put("cntr9_qty", "cntr9Qty");
		this.hashFields.put("cntr13_qty", "cntr13Qty");
		this.hashFields.put("cntr8_qty", "cntr8Qty");
		this.hashFields.put("cntr20_qty", "cntr20Qty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr14_qty", "cntr14Qty");
		this.hashFields.put("cntr26_qty", "cntr26Qty");
		this.hashFields.put("cntr19_qty", "cntr19Qty");
		this.hashFields.put("cntr15_qty", "cntr15Qty");
		this.hashFields.put("cntr17_qty", "cntr17Qty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("mvmt", "mvmt");
		this.hashFields.put("del_dol", "delDol");
		this.hashFields.put("por_dol", "porDol");
		this.hashFields.put("total", "total");
		this.hashFields.put("loc_cd_teu_no", "locCdTeuNo");
		this.hashFields.put("cntr2_qty", "cntr2Qty");
		this.hashFields.put("cntr16_qty", "cntr16Qty");
		this.hashFields.put("cntr29_qty", "cntr29Qty");
		this.hashFields.put("type_nm", "typeNm");
		this.hashFields.put("cntr10_qty", "cntr10Qty");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("onh_yd", "onhYd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("sls_ofc", "slsOfc");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cust_no", "custNo");
		this.hashFields.put("crr_mvmt_sts_cd", "crrMvmtStsCd");
		this.hashFields.put("crr_cnmv_evnt_dt", "crrCnmvEvntDt");
		this.hashFields.put("crr_org_yd_cd", "crrOrgYdCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("por", "por");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("del", "del");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("r_lane", "rLane");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rntl_chg", "rntlChg");
		this.hashFields.put("lon", "lon");
		this.hashFields.put("puc", "puc");
		this.hashFields.put("pcr", "pcr");
		this.hashFields.put("lof", "lof");
		this.hashFields.put("doc", "doc");
		this.hashFields.put("dcr", "dcr");
		this.hashFields.put("cust_tp", "custTp");
		this.hashFields.put("g_cust_cd", "gCustCd");
		this.hashFields.put("g_cust_nm", "gCustNm");
		this.hashFields.put("mst_if", "mstIf");
		this.hashFields.put("cntr5_qty", "cntr5Qty");
		this.hashFields.put("cntr4_qty", "cntr4Qty");
		this.hashFields.put("cntr30_qty", "cntr30Qty");
		this.hashFields.put("cntr23_qty", "cntr23Qty");
		this.hashFields.put("cntr24_qty", "cntr24Qty");
		this.hashFields.put("cntr11_qty", "cntr11Qty");
		this.hashFields.put("cntr1_qty", "cntr1Qty");
		this.hashFields.put("cntr6_qty", "cntr6Qty");
		this.hashFields.put("cntr28_qty", "cntr28Qty");
		this.hashFields.put("cntr21_qty", "cntr21Qty");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cntr7_qty", "cntr7Qty");
		this.hashFields.put("cntr27_qty", "cntr27Qty");
		this.hashFields.put("type_cd", "typeCd");
		this.hashFields.put("fst_cls", "fstCls");
		this.hashFields.put("snd_cls", "sndCls");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("lse_ctrt_no", "ctrtNo");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("onh_qty", "onhQty");
		this.hashFields.put("trd", "trd");
		this.hashFields.put("off_hire_loc", "offHireLoc");
		this.hashFields.put("target_dol", "targetDol");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("cntr_mv_dt", "cntrMvDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("mvnt_dol", "mvntDol");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("using_days", "usingDays");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("app_dt", "appDt");
		this.hashFields.put("s_days", "sDays");
		this.hashFields.put("sts", "sts");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntr12Qty
	 */
	public String getCntr12Qty() {
		return this.cntr12Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr3Qty
	 */
	public String getCntr3Qty() {
		return this.cntr3Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr22Qty
	 */
	public String getCntr22Qty() {
		return this.cntr22Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr18Qty
	 */
	public String getCntr18Qty() {
		return this.cntr18Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr25Qty
	 */
	public String getCntr25Qty() {
		return this.cntr25Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr9Qty
	 */
	public String getCntr9Qty() {
		return this.cntr9Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr13Qty
	 */
	public String getCntr13Qty() {
		return this.cntr13Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr8Qty
	 */
	public String getCntr8Qty() {
		return this.cntr8Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr20Qty
	 */
	public String getCntr20Qty() {
		return this.cntr20Qty;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return cntr14Qty
	 */
	public String getCntr14Qty() {
		return this.cntr14Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr26Qty
	 */
	public String getCntr26Qty() {
		return this.cntr26Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr19Qty
	 */
	public String getCntr19Qty() {
		return this.cntr19Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr15Qty
	 */
	public String getCntr15Qty() {
		return this.cntr15Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr17Qty
	 */
	public String getCntr17Qty() {
		return this.cntr17Qty;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return mvmt
	 */
	public String getMvmt() {
		return this.mvmt;
	}
	
	/**
	 * Column Info
	 * @return delDol
	 */
	public String getDelDol() {
		return this.delDol;
	}
	
	/**
	 * Column Info
	 * @return porDol
	 */
	public String getPorDol() {
		return this.porDol;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}	
	
	/**
	 * Column Info
	 * @return locCdTeuNo
	 */
	public String getLocCdTeuNo() {
		return this.locCdTeuNo;
	}
	
	/**
	 * Column Info
	 * @return cntr2Qty
	 */
	public String getCntr2Qty() {
		return this.cntr2Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr16Qty
	 */
	public String getCntr16Qty() {
		return this.cntr16Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr29Qty
	 */
	public String getCntr29Qty() {
		return this.cntr29Qty;
	}
	
	/**
	 * Column Info
	 * @return typeNm
	 */
	public String getTypeNm() {
		return this.typeNm;
	}
	
	/**
	 * Column Info
	 * @return cntr10Qty
	 */
	public String getCntr10Qty() {
		return this.cntr10Qty;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return onhYd
	 */
	public String getOnhYd() {
		return this.onhYd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return slsOfc
	 */
	public String getSlsOfc() {
		return this.slsOfc;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return custNo
	 */
	public String getCustNo() {
		return this.custNo;
	}
	
	/**
	 * Column Info
	 * @return crrMvmtStsCd
	 */
	public String getCrrMvmtStsCd() {
		return this.crrMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return crrCnmvEvntDt
	 */
	public String getCrrCnmvEvntDt() {
		return this.crrCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return crrOrgYdCd
	 */
	public String getCrrOrgYdCd() {
		return this.crrOrgYdCd;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return rLane
	 */
	public String getRLane() {
		return this.rLane;
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
	 * @return rntlChg
	 */
	public String getRntlChg() {
		return this.rntlChg;
	}
	
	/**
	 * Column Info
	 * @return lon
	 */
	public String getLon() {
		return this.lon;
	}
	
	/**
	 * Column Info
	 * @return puc
	 */
	public String getPuc() {
		return this.puc;
	}
	
	/**
	 * Column Info
	 * @return pcr
	 */
	public String getPcr() {
		return this.pcr;
	}
	
	/**
	 * Column Info
	 * @return lof
	 */
	public String getLof() {
		return this.lof;
	}
	
	/**
	 * Column Info
	 * @return doc
	 */
	public String getDoc() {
		return this.doc;
	}
	
	/**
	 * Column Info
	 * @return dcr
	 */
	public String getDcr() {
		return this.dcr;
	}
	
	/**
	 * Column Info
	 * @return custTp
	 */
	public String getCustTp() {
		return this.custTp;
	}
	
	/**
	 * Column Info
	 * @return gCustCd
	 */
	public String getGCustCd() {
		return this.gCustCd;
	}
	
	/**
	 * Column Info
	 * @return gCustNm
	 */
	public String getGCustNm() {
		return this.gCustNm;
	}
	
	/**
	 * Column Info
	 * @return mstIf
	 */
	public String getMstIf() {
		return this.mstIf;
	}
	
	/**
	 * Column Info
	 * @return cntr5Qty
	 */
	public String getCntr5Qty() {
		return this.cntr5Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr4Qty
	 */
	public String getCntr4Qty() {
		return this.cntr4Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr30Qty
	 */
	public String getCntr30Qty() {
		return this.cntr30Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr23Qty
	 */
	public String getCntr23Qty() {
		return this.cntr23Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr24Qty
	 */
	public String getCntr24Qty() {
		return this.cntr24Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr11Qty
	 */
	public String getCntr11Qty() {
		return this.cntr11Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr1Qty
	 */
	public String getCntr1Qty() {
		return this.cntr1Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr6Qty
	 */
	public String getCntr6Qty() {
		return this.cntr6Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr28Qty
	 */
	public String getCntr28Qty() {
		return this.cntr28Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr21Qty
	 */
	public String getCntr21Qty() {
		return this.cntr21Qty;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return cntr7Qty
	 */
	public String getCntr7Qty() {
		return this.cntr7Qty;
	}
	
	/**
	 * Column Info
	 * @return cntr27Qty
	 */
	public String getCntr27Qty() {
		return this.cntr27Qty;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return onhQty
	 */
	public String getOnhQty() {
		return this.onhQty;
	}	
	
	/**
	 * Column Info
	 * @return trd
	 */
	public String getTrd() {
		return this.trd;
	}
	
	/**
	 * Column Info
	 * @return offHireLoc
	 */
	public String getOffHireLoc() {
		return this.offHireLoc;
	}
	
	/**
	 * Column Info
	 * @return targetDol
	 */
	public String getTargetDol() {
		return this.targetDol;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvDt
	 */
	public String getCnmvDt() {
		return this.cnmvDt;
	}
	
	/**
	 * Column Info
	 * @return cntrMvDt
	 */
	public String getCntrMvDt() {
		return this.cntrMvDt;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return mvntDol
	 */
	public String getMvntDol() {
		return this.mvntDol;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
	}
	
	/**
	 * Column Info
	 * @return usingDays
	 */
	public String getUsingDays() {
		return this.usingDays;
	}
	
	/**
	 * Column Info
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return appDt
	 */
	public String getAppDt() {
		return this.appDt;
	}
	
	/**
	 * Column Info
	 * @return sDays
	 */
	public String getSDays() {
		return this.sDays;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}	
	

	/**
	 * Column Info
	 * @param cntr12Qty
	 */
	public void setCntr12Qty(String cntr12Qty) {
		this.cntr12Qty = cntr12Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr3Qty
	 */
	public void setCntr3Qty(String cntr3Qty) {
		this.cntr3Qty = cntr3Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr22Qty
	 */
	public void setCntr22Qty(String cntr22Qty) {
		this.cntr22Qty = cntr22Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr18Qty
	 */
	public void setCntr18Qty(String cntr18Qty) {
		this.cntr18Qty = cntr18Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr25Qty
	 */
	public void setCntr25Qty(String cntr25Qty) {
		this.cntr25Qty = cntr25Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr9Qty
	 */
	public void setCntr9Qty(String cntr9Qty) {
		this.cntr9Qty = cntr9Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr13Qty
	 */
	public void setCntr13Qty(String cntr13Qty) {
		this.cntr13Qty = cntr13Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr8Qty
	 */
	public void setCntr8Qty(String cntr8Qty) {
		this.cntr8Qty = cntr8Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr20Qty
	 */
	public void setCntr20Qty(String cntr20Qty) {
		this.cntr20Qty = cntr20Qty;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param cntr14Qty
	 */
	public void setCntr14Qty(String cntr14Qty) {
		this.cntr14Qty = cntr14Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr26Qty
	 */
	public void setCntr26Qty(String cntr26Qty) {
		this.cntr26Qty = cntr26Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr19Qty
	 */
	public void setCntr19Qty(String cntr19Qty) {
		this.cntr19Qty = cntr19Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr15Qty
	 */
	public void setCntr15Qty(String cntr15Qty) {
		this.cntr15Qty = cntr15Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr17Qty
	 */
	public void setCntr17Qty(String cntr17Qty) {
		this.cntr17Qty = cntr17Qty;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param mvmt
	 */
	public void setMvmt(String mvmt) {
		this.mvmt = mvmt;
	}
	
	/**
	 * Column Info
	 * @param delDol
	 */
	public void setDelDol(String delDol) {
		this.delDol = delDol;
	}
	
	/**
	 * Column Info
	 * @param porDol
	 */
	public void setPorDol(String porDol) {
		this.porDol = porDol;
	}
	
	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param locCdTeuNo
	 */
	public void setLocCdTeuNo(String locCdTeuNo) {
		this.locCdTeuNo = locCdTeuNo;
	}
	
	/**
	 * Column Info
	 * @param cntr2Qty
	 */
	public void setCntr2Qty(String cntr2Qty) {
		this.cntr2Qty = cntr2Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr16Qty
	 */
	public void setCntr16Qty(String cntr16Qty) {
		this.cntr16Qty = cntr16Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr29Qty
	 */
	public void setCntr29Qty(String cntr29Qty) {
		this.cntr29Qty = cntr29Qty;
	}
	
	/**
	 * Column Info
	 * @param typeNm
	 */
	public void setTypeNm(String typeNm) {
		this.typeNm = typeNm;
	}
	
	/**
	 * Column Info
	 * @param cntr10Qty
	 */
	public void setCntr10Qty(String cntr10Qty) {
		this.cntr10Qty = cntr10Qty;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param onhYd
	 */
	public void setOnhYd(String onhYd) {
		this.refNo = onhYd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param slsOfc
	 */
	public void setSlsOfc(String slsOfc) {
		this.slsOfc = slsOfc;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	
	/**
	 * Column Info
	 * @param crrMvmtStsCd
	 */
	public void setCrrMvmtStsCd(String crrMvmtStsCd) {
		this.crrMvmtStsCd = crrMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param crrCnmvEvntDt
	 */
	public void setCrrCnmvEvntDt(String crrCnmvEvntDt) {
		this.crrCnmvEvntDt = crrCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param crrOrgYdCd
	 */
	public void setCrrOrgYdCd(String crrOrgYdCd) {
		this.crrOrgYdCd = crrOrgYdCd;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param rLane
	 */
	public void setRLane(String rLane) {
		this.rLane = rLane;
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
	 * @param rntlChg
	 */
	public void setRntlChg(String rntlChg) {
		this.rntlChg = rntlChg;
	}
	
	/**
	 * Column Info
	 * @param lon
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	/**
	 * Column Info
	 * @param puc
	 */
	public void setPuc(String puc) {
		this.puc = puc;
	}
	
	/**
	 * Column Info
	 * @param pcr
	 */
	public void setPcr(String pcr) {
		this.pcr = pcr;
	}
	
	/**
	 * Column Info
	 * @param lof
	 */
	public void setLof(String lof) {
		this.lof = lof;
	}
	
	/**
	 * Column Info
	 * @param doc
	 */
	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	/**
	 * Column Info
	 * @param dcr
	 */
	public void setDcr(String dcr) {
		this.dcr = dcr;
	}
	
	/**
	 * Column Info
	 * @param custTp
	 */
	public void setCustTp(String custTp) {
		this.custTp = custTp;
	}
	
	/**
	 * Column Info
	 * @param gCustCd
	 */
	public void setGCustCd(String gCustCd) {
		this.gCustCd = gCustCd;
	}
	
	/**
	 * Column Info
	 * @param gCustNm
	 */
	public void setGCustNm(String gCustNm) {
		this.gCustNm = gCustNm;
	}
	
	/**
	 * Column Info
	 * @param mstIf
	 */
	public void setMstIf(String mstIf) {
		this.mstIf = mstIf;
	}
	
	/**
	 * Column Info
	 * @param cntr5Qty
	 */
	public void setCntr5Qty(String cntr5Qty) {
		this.cntr5Qty = cntr5Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr4Qty
	 */
	public void setCntr4Qty(String cntr4Qty) {
		this.cntr4Qty = cntr4Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr30Qty
	 */
	public void setCntr30Qty(String cntr30Qty) {
		this.cntr30Qty = cntr30Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr23Qty
	 */
	public void setCntr23Qty(String cntr23Qty) {
		this.cntr23Qty = cntr23Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr24Qty
	 */
	public void setCntr24Qty(String cntr24Qty) {
		this.cntr24Qty = cntr24Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr11Qty
	 */
	public void setCntr11Qty(String cntr11Qty) {
		this.cntr11Qty = cntr11Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr1Qty
	 */
	public void setCntr1Qty(String cntr1Qty) {
		this.cntr1Qty = cntr1Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr6Qty
	 */
	public void setCntr6Qty(String cntr6Qty) {
		this.cntr6Qty = cntr6Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr28Qty
	 */
	public void setCntr28Qty(String cntr28Qty) {
		this.cntr28Qty = cntr28Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr21Qty
	 */
	public void setCntr21Qty(String cntr21Qty) {
		this.cntr21Qty = cntr21Qty;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param cntr7Qty
	 */
	public void setCntr7Qty(String cntr7Qty) {
		this.cntr7Qty = cntr7Qty;
	}
	
	/**
	 * Column Info
	 * @param cntr27Qty
	 */
	public void setCntr27Qty(String cntr27Qty) {
		this.cntr27Qty = cntr27Qty;
	}

	/**
	 * Column Info
	 * @param typeCd
	 */
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}

	/**
	 * Column Info
	 * @return typeCd
	 */
	public String getTypeCd() {
		return typeCd;
	}

	/**
	 * Column Info
	 * @param cntr27Qty
	 */
	public void setFstCls(String fstCls) {
		this.fstCls = fstCls;
	}

	/**
	 * Column Info
	 * @return fstCls
	 */
	public String getFstCls() {
		return fstCls;
	}

	/**
	 * Column Info
	 * @param sndCls
	 */
	public void setSndCls(String sndCls) {
		this.sndCls = sndCls;
	}

	/**
	 * Column Info
	 * @return sndCls
	 */
	public String getSndCls() {
		return sndCls;
	}
	
	/**
	 * Column Info
	 * @param contract no
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param onhQty
	 */
	public void setOnhQty(String onhQty) {
		this.onhQty = onhQty;
	}	
	
	/**
	 * Column Info
	 * @param trd
	 */
	public void setTrd(String trd) {
		this.trd = trd;
	}
	
	/**
	 * Column Info
	 * @param offHireLoc
	 */
	public void setOffHireLoc(String offHireLoc) {
		this.offHireLoc = offHireLoc;
	}
	
	/**
	 * Column Info
	 * @param targetDol
	 */
	public void setTargetDol(String targetDol) {
		this.targetDol = targetDol;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvDt
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
	}
	
	/**
	 * Column Info
	 * @param cntrMvDt
	 */
	public void setCntrMvDt(String cntrMvDt) {
		this.cntrMvDt = cntrMvDt;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param mvntDol
	 */
	public void setMvntDol(String mvntDol) {
		this.mvntDol = mvntDol;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
	}
	
	/**
	 * Column Info
	 * @param usingDays
	 */
	public void setUsingDays(String usingDays) {
		this.usingDays = usingDays;
	}
	
	/**
	 * Column Info
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param appDt
	 */
	public void setAppDt(String appDt) {
		this.appDt = appDt;
	}
	
	/**
	 * Column Info
	 * @param sDays
	 */
	public void setSDays(String sDays) {
		this.sDays = sDays;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}	

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntr12Qty(JSPUtil.getParameter(request, "cntr12_qty", ""));
		setCntr3Qty(JSPUtil.getParameter(request, "cntr3_qty", ""));
		setCntr22Qty(JSPUtil.getParameter(request, "cntr22_qty", ""));
		setCntr18Qty(JSPUtil.getParameter(request, "cntr18_qty", ""));
		setCntr25Qty(JSPUtil.getParameter(request, "cntr25_qty", ""));
		setCntr9Qty(JSPUtil.getParameter(request, "cntr9_qty", ""));
		setCntr13Qty(JSPUtil.getParameter(request, "cntr13_qty", ""));
		setCntr8Qty(JSPUtil.getParameter(request, "cntr8_qty", ""));
		setCntr20Qty(JSPUtil.getParameter(request, "cntr20_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntr14Qty(JSPUtil.getParameter(request, "cntr14_qty", ""));
		setCntr26Qty(JSPUtil.getParameter(request, "cntr26_qty", ""));
		setCntr19Qty(JSPUtil.getParameter(request, "cntr19_qty", ""));
		setCntr15Qty(JSPUtil.getParameter(request, "cntr15_qty", ""));
		setCntr17Qty(JSPUtil.getParameter(request, "cntr17_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setMvmt(JSPUtil.getParameter(request, "mvmt", ""));
		setDelDol(JSPUtil.getParameter(request, "del_dol", ""));
		setPorDol(JSPUtil.getParameter(request, "por_dol", ""));
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setLocCdTeuNo(JSPUtil.getParameter(request, "loc_cd_teu_no", ""));
		setCntr2Qty(JSPUtil.getParameter(request, "cntr2_qty", ""));
		setCntr16Qty(JSPUtil.getParameter(request, "cntr16_qty", ""));
		setCntr29Qty(JSPUtil.getParameter(request, "cntr29_qty", ""));
		setTypeNm(JSPUtil.getParameter(request, "type_nm", ""));
		setCntr10Qty(JSPUtil.getParameter(request, "cntr10_qty", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setOnhYd(JSPUtil.getParameter(request, "onh_yd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setSlsOfc(JSPUtil.getParameter(request, "sls_ofc", ""));
		setScRfaNo(JSPUtil.getParameter(request, "sc_rfa_no", ""));
		setCustNo(JSPUtil.getParameter(request, "cust_no", ""));
		setCrrMvmtStsCd(JSPUtil.getParameter(request, "crr_mvmt_sts_cd", ""));
		setCrrCnmvEvntDt(JSPUtil.getParameter(request, "crr_cnmv_evnt_dt", ""));
		setCrrOrgYdCd(JSPUtil.getParameter(request, "crr_org_yd_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setRLane(JSPUtil.getParameter(request, "r_lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setRntlChg(JSPUtil.getParameter(request, "rntl_chg", ""));
		setLon(JSPUtil.getParameter(request, "lon", ""));
		setPuc(JSPUtil.getParameter(request, "puc", ""));
		setPcr(JSPUtil.getParameter(request, "pcr", ""));
		setLof(JSPUtil.getParameter(request, "lof", ""));
		setDoc(JSPUtil.getParameter(request, "doc", ""));
		setDcr(JSPUtil.getParameter(request, "dcr", ""));
		setCustTp(JSPUtil.getParameter(request, "cust_tp", ""));
		setGCustCd(JSPUtil.getParameter(request, "g_cust_cd", ""));
		setGCustNm(JSPUtil.getParameter(request, "g_cust_nm", ""));
		setMstIf(JSPUtil.getParameter(request, "mst_if", ""));
		setCntr5Qty(JSPUtil.getParameter(request, "cntr5_qty", ""));
		setCntr4Qty(JSPUtil.getParameter(request, "cntr4_qty", ""));
		setCntr30Qty(JSPUtil.getParameter(request, "cntr30_qty", ""));
		setCntr23Qty(JSPUtil.getParameter(request, "cntr23_qty", ""));
		setCntr24Qty(JSPUtil.getParameter(request, "cntr24_qty", ""));
		setCntr11Qty(JSPUtil.getParameter(request, "cntr11_qty", ""));
		setCntr1Qty(JSPUtil.getParameter(request, "cntr1_qty", ""));
		setCntr6Qty(JSPUtil.getParameter(request, "cntr6_qty", ""));
		setCntr28Qty(JSPUtil.getParameter(request, "cntr28_qty", ""));
		setCntr21Qty(JSPUtil.getParameter(request, "cntr21_qty", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setCntr7Qty(JSPUtil.getParameter(request, "cntr7_qty", ""));
		setCntr27Qty(JSPUtil.getParameter(request, "cntr27_qty", ""));
		setTypeCd(JSPUtil.getParameter(request, "type_cd", ""));
		setFstCls(JSPUtil.getParameter(request, "fst_cls", ""));
		setSndCls(JSPUtil.getParameter(request, "snd_cls", ""));
		setTtl(JSPUtil.getParameter(request, "ttl", ""));
		setCtrtNo(JSPUtil.getParameter(request, "lse_ctrt_no", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setOnhQty(JSPUtil.getParameter(request, "onh_qty", ""));
		setTrd(JSPUtil.getParameter(request, "trd", ""));
		setOffHireLoc(JSPUtil.getParameter(request, "off_hire_loc", ""));
		setTargetDol(JSPUtil.getParameter(request, "target_dol", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setCntrMvDt(JSPUtil.getParameter(request, "cntr_mv_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setMvntDol(JSPUtil.getParameter(request, "mvnt_dol", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setFreeDys(JSPUtil.getParameter(request, "free_dys", ""));
		setUsingDays(JSPUtil.getParameter(request, "using_days", ""));
		setLessor(JSPUtil.getParameter(request, "lessor", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAppDt(JSPUtil.getParameter(request, "app_dt", ""));
		setSDays(JSPUtil.getParameter(request, "s_days", ""));
		setSts(JSPUtil.getParameter(request, "sts", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgreementListVO[]
	 */
	public AvailableOnewayInventoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgreementListVO[]
	 */
	public AvailableOnewayInventoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AvailableOnewayInventoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntr12Qty = (JSPUtil.getParameter(request, prefix	+ "cntr12_qty", length));
			String[] cntr3Qty = (JSPUtil.getParameter(request, prefix	+ "cntr3_qty", length));
			String[] cntr22Qty = (JSPUtil.getParameter(request, prefix	+ "cntr22_qty", length));
			String[] cntr18Qty = (JSPUtil.getParameter(request, prefix	+ "cntr18_qty", length));
			String[] cntr25Qty = (JSPUtil.getParameter(request, prefix	+ "cntr25_qty", length));
			String[] cntr9Qty = (JSPUtil.getParameter(request, prefix	+ "cntr9_qty", length));
			String[] cntr13Qty = (JSPUtil.getParameter(request, prefix	+ "cntr13_qty", length));
			String[] cntr8Qty = (JSPUtil.getParameter(request, prefix	+ "cntr8_qty", length));
			String[] cntr20Qty = (JSPUtil.getParameter(request, prefix	+ "cntr20_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntr14Qty = (JSPUtil.getParameter(request, prefix	+ "cntr14_qty", length));
			String[] cntr26Qty = (JSPUtil.getParameter(request, prefix	+ "cntr26_qty", length));
			String[] cntr19Qty = (JSPUtil.getParameter(request, prefix	+ "cntr19_qty", length));
			String[] cntr15Qty = (JSPUtil.getParameter(request, prefix	+ "cntr15_qty", length));
			String[] cntr17Qty = (JSPUtil.getParameter(request, prefix	+ "cntr17_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] mvmt = (JSPUtil.getParameter(request, prefix	+ "mvmt", length));
			String[] delDol = (JSPUtil.getParameter(request, prefix	+ "del_dol", length));
			String[] porDol = (JSPUtil.getParameter(request, prefix	+ "por_dol", length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] locCdTeuNo = (JSPUtil.getParameter(request, prefix	+ "loc_cd_teu_no", length));
			String[] cntr2Qty = (JSPUtil.getParameter(request, prefix	+ "cntr2_qty", length));
			String[] cntr16Qty = (JSPUtil.getParameter(request, prefix	+ "cntr16_qty", length));
			String[] cntr29Qty = (JSPUtil.getParameter(request, prefix	+ "cntr29_qty", length));
			String[] typeNm = (JSPUtil.getParameter(request, prefix	+ "type_nm", length));
			String[] cntr10Qty = (JSPUtil.getParameter(request, prefix	+ "cntr10_qty", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] onhYd = (JSPUtil.getParameter(request, prefix	+ "onh_yd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] slsOfc = (JSPUtil.getParameter(request, prefix	+ "sls_ofc", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] custNo = (JSPUtil.getParameter(request, prefix	+ "cust_no", length));
			String[] crrMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "crr_mvmt_sts_cd", length));
			String[] crrCnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "crr_cnmv_evnt_dt", length));
			String[] crrOrgYdCd = (JSPUtil.getParameter(request, prefix	+ "crr_org_yd_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] rLane = (JSPUtil.getParameter(request, prefix	+ "r_lane", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] rntlChg = (JSPUtil.getParameter(request, prefix	+ "rntl_chg", length));
			String[] lon = (JSPUtil.getParameter(request, prefix	+ "lon", length));
			String[] puc = (JSPUtil.getParameter(request, prefix	+ "puc", length));
			String[] pcr = (JSPUtil.getParameter(request, prefix	+ "pcr", length));
			String[] lof = (JSPUtil.getParameter(request, prefix	+ "lof", length));
			String[] doc = (JSPUtil.getParameter(request, prefix	+ "doc", length));
			String[] dcr = (JSPUtil.getParameter(request, prefix	+ "dcr", length));
			String[] custTp = (JSPUtil.getParameter(request, prefix	+ "cust_tp", length));
			String[] gCustCd = (JSPUtil.getParameter(request, prefix	+ "g_cust_cd", length));
			String[] gCustNm = (JSPUtil.getParameter(request, prefix	+ "g_cust_nm", length));
			String[] mstIf = (JSPUtil.getParameter(request, prefix	+ "mst_if", length));
			String[] cntr5Qty = (JSPUtil.getParameter(request, prefix	+ "cntr5_qty", length));
			String[] cntr4Qty = (JSPUtil.getParameter(request, prefix	+ "cntr4_qty", length));
			String[] cntr30Qty = (JSPUtil.getParameter(request, prefix	+ "cntr30_qty", length));
			String[] cntr23Qty = (JSPUtil.getParameter(request, prefix	+ "cntr23_qty", length));
			String[] cntr24Qty = (JSPUtil.getParameter(request, prefix	+ "cntr24_qty", length));
			String[] cntr11Qty = (JSPUtil.getParameter(request, prefix	+ "cntr11_qty", length));
			String[] cntr1Qty = (JSPUtil.getParameter(request, prefix	+ "cntr1_qty", length));
			String[] cntr6Qty = (JSPUtil.getParameter(request, prefix	+ "cntr6_qty", length));
			String[] cntr28Qty = (JSPUtil.getParameter(request, prefix	+ "cntr28_qty", length));
			String[] cntr21Qty = (JSPUtil.getParameter(request, prefix	+ "cntr21_qty", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] cntr7Qty = (JSPUtil.getParameter(request, prefix	+ "cntr7_qty", length));
			String[] cntr27Qty = (JSPUtil.getParameter(request, prefix	+ "cntr27_qty", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			String[] fstCls = (JSPUtil.getParameter(request, prefix	+ "fst_cls", length));
			String[] sndCls = (JSPUtil.getParameter(request, prefix	+ "snd_cls", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "lse_ctrt_no", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] onhQty = (JSPUtil.getParameter(request, prefix	+ "onh_qty", length));
			String[] trd = (JSPUtil.getParameter(request, prefix	+ "trd", length));
			String[] offHireLoc = (JSPUtil.getParameter(request, prefix	+ "off_hire_loc", length));
			String[] targetDol = (JSPUtil.getParameter(request, prefix	+ "target_dol", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] cntrMvDt = (JSPUtil.getParameter(request, prefix	+ "cntr_mv_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] mvntDol = (JSPUtil.getParameter(request, prefix	+ "mvnt_dol", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix	+ "free_dys", length));
			String[] usingDays = (JSPUtil.getParameter(request, prefix	+ "using_days", length));
			String[] lessor = (JSPUtil.getParameter(request, prefix	+ "lessor", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] appDt = (JSPUtil.getParameter(request, prefix	+ "app_dt", length));
			String[] sDays = (JSPUtil.getParameter(request, prefix	+ "s_days", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));

			for (int i = 0; i < length; i++) {
				model = new AvailableOnewayInventoryVO();
				if (cntr12Qty[i] != null)
					model.setCntr12Qty(cntr12Qty[i]);
				if (cntr3Qty[i] != null)
					model.setCntr3Qty(cntr3Qty[i]);
				if (cntr22Qty[i] != null)
					model.setCntr22Qty(cntr22Qty[i]);
				if (cntr18Qty[i] != null)
					model.setCntr18Qty(cntr18Qty[i]);
				if (cntr25Qty[i] != null)
					model.setCntr25Qty(cntr25Qty[i]);
				if (cntr9Qty[i] != null)
					model.setCntr9Qty(cntr9Qty[i]);
				if (cntr13Qty[i] != null)
					model.setCntr13Qty(cntr13Qty[i]);
				if (cntr8Qty[i] != null)
					model.setCntr8Qty(cntr8Qty[i]);
				if (cntr20Qty[i] != null)
					model.setCntr20Qty(cntr20Qty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntr14Qty[i] != null)
					model.setCntr14Qty(cntr14Qty[i]);
				if (cntr26Qty[i] != null)
					model.setCntr26Qty(cntr26Qty[i]);
				if (cntr19Qty[i] != null)
					model.setCntr19Qty(cntr19Qty[i]);
				if (cntr15Qty[i] != null)
					model.setCntr15Qty(cntr15Qty[i]);
				if (cntr17Qty[i] != null)
					model.setCntr17Qty(cntr17Qty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (mvmt[i] != null)
					model.setMvmt(mvmt[i]);
				if (delDol[i] != null)
					model.setDelDol(delDol[i]);
				if (porDol[i] != null)
					model.setPorDol(porDol[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (locCdTeuNo[i] != null)
					model.setLocCdTeuNo(locCdTeuNo[i]);
				if (cntr2Qty[i] != null)
					model.setCntr2Qty(cntr2Qty[i]);
				if (cntr16Qty[i] != null)
					model.setCntr16Qty(cntr16Qty[i]);
				if (cntr29Qty[i] != null)
					model.setCntr29Qty(cntr29Qty[i]);
				if (typeNm[i] != null)
					model.setTypeNm(typeNm[i]);
				if (cntr10Qty[i] != null)
					model.setCntr10Qty(cntr10Qty[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				
				if (onhYd[i] != null)
					model.setOnhYd(onhYd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (slsOfc[i] != null)
					model.setSlsOfc(slsOfc[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (custNo[i] != null)
					model.setCustNo(custNo[i]);
				if (crrMvmtStsCd[i] != null)
					model.setCrrMvmtStsCd(crrMvmtStsCd[i]);
				if (crrCnmvEvntDt[i] != null)
					model.setCrrCnmvEvntDt(crrCnmvEvntDt[i]);
				if (crrOrgYdCd[i] != null)
					model.setCrrOrgYdCd(crrOrgYdCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (rLane[i] != null)
					model.setRLane(rLane[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (rntlChg[i] != null)
					model.setRntlChg(rntlChg[i]);
				if (lon[i] != null)
					model.setLon(lon[i]);
				if (puc[i] != null)
					model.setPuc(puc[i]);
				if (pcr[i] != null)
					model.setPcr(pcr[i]);
				if (lof[i] != null)
					model.setLof(lof[i]);
				if (doc[i] != null)
					model.setDoc(doc[i]);
				if (dcr[i] != null)
					model.setDcr(dcr[i]);
				if (custTp[i] != null)
					model.setCustTp(custTp[i]);
				if (gCustCd[i] != null)
					model.setGCustCd(gCustCd[i]);
				if (gCustNm[i] != null)
					model.setGCustNm(gCustNm[i]);
				if (mstIf[i] != null)
					model.setMstIf(mstIf[i]);
				if (cntr5Qty[i] != null)
					model.setCntr5Qty(cntr5Qty[i]);
				if (cntr4Qty[i] != null)
					model.setCntr4Qty(cntr4Qty[i]);
				if (cntr30Qty[i] != null)
					model.setCntr30Qty(cntr30Qty[i]);
				if (cntr23Qty[i] != null)
					model.setCntr23Qty(cntr23Qty[i]);
				if (cntr24Qty[i] != null)
					model.setCntr24Qty(cntr24Qty[i]);
				if (cntr11Qty[i] != null)
					model.setCntr11Qty(cntr11Qty[i]);
				if (cntr1Qty[i] != null)
					model.setCntr1Qty(cntr1Qty[i]);
				if (cntr6Qty[i] != null)
					model.setCntr6Qty(cntr6Qty[i]);
				if (cntr28Qty[i] != null)
					model.setCntr28Qty(cntr28Qty[i]);
				if (cntr21Qty[i] != null)
					model.setCntr21Qty(cntr21Qty[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (cntr7Qty[i] != null)
					model.setCntr7Qty(cntr7Qty[i]);
				if (cntr27Qty[i] != null)
					model.setCntr27Qty(cntr27Qty[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				if (fstCls[i] != null)
					model.setFstCls(fstCls[i]);
				if (sndCls[i] != null)
					model.setSndCls(sndCls[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (onhQty[i] != null)
					model.setOnhQty(onhQty[i]);
				if (trd[i] != null)
					model.setTrd(trd[i]);
				if (offHireLoc[i] != null)
					model.setOffHireLoc(offHireLoc[i]);
				
				if (targetDol[i] != null)
					model.setTargetDol(targetDol[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (cntrMvDt[i] != null)
					model.setCntrMvDt(cntrMvDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (mvntDol[i] != null)
					model.setMvntDol(mvntDol[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (usingDays[i] != null)
					model.setUsingDays(usingDays[i]);
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (appDt[i] != null)
					model.setAppDt(appDt[i]);
				if (sDays[i] != null)
					model.setSDays(sDays[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAvailableOnewayInventoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgreementListVO[]
	 */
	public AvailableOnewayInventoryVO[] getAvailableOnewayInventoryVOs(){
		AvailableOnewayInventoryVO[] vos = (AvailableOnewayInventoryVO[])models.toArray(new AvailableOnewayInventoryVO[models.size()]);
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
		this.cntr12Qty = this.cntr12Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr3Qty = this.cntr3Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr22Qty = this.cntr22Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr18Qty = this.cntr18Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr25Qty = this.cntr25Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr9Qty = this.cntr9Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr13Qty = this.cntr13Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr8Qty = this.cntr8Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20Qty = this.cntr20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr14Qty = this.cntr14Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr26Qty = this.cntr26Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr19Qty = this.cntr19Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr15Qty = this.cntr15Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr17Qty = this.cntr17Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmt = this.mvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDol = this.delDol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDol = this.porDol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdTeuNo = this.locCdTeuNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr2Qty = this.cntr2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr16Qty = this.cntr16Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr29Qty = this.cntr29Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeNm = this.typeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr10Qty = this.cntr10Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhYd = this.onhYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfc = this.slsOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNo = this.custNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrMvmtStsCd = this.crrMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCnmvEvntDt = this.crrCnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrOrgYdCd = this.crrOrgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rLane = this.rLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChg = this.rntlChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lon = this.lon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.puc = this.puc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcr = this.pcr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lof = this.lof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doc = this.doc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcr = this.dcr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTp = this.custTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gCustCd = this.gCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gCustNm = this.gCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstIf = this.mstIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr5Qty = this.cntr5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr4Qty = this.cntr4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr30Qty = this.cntr30Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr23Qty = this.cntr23Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr24Qty = this.cntr24Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr11Qty = this.cntr11Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr1Qty = this.cntr1Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr6Qty = this.cntr6Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr28Qty = this.cntr28Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr21Qty = this.cntr21Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr7Qty = this.cntr7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr27Qty = this.cntr27Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fstCls = this.fstCls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndCls = this.sndCls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhQty = this.onhQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trd = this.trd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHireLoc = this.offHireLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetDol = this.targetDol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMvDt = this.cntrMvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvntDol = this.mvntDol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys = this.freeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usingDays = this.usingDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor = this.lessor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appDt = this.appDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDays = this.sDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public String getTtl() {
		return ttl;
	}
}