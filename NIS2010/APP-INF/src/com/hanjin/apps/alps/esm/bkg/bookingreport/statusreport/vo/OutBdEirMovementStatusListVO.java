/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OutBdEirMovementStatusListVO.java
*@FileTitle : OutBdEirMovementStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.08  
* 1.0 Creation
* 1.2 2010.09.27 이재위 [CHM-201005253-01] [BKG/DOC] EIR Exchange & Customs Release Check Report 신규개발(ESM_BKG_1110)[SZPBB]
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OutBdEirMovementStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutBdEirMovementStatusListVO> models = new ArrayList<OutBdEirMovementStatusListVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String pre1Vvd = null;
	/* Column Info */
	private String curlTotalY = null;
	/* Column Info */
	private String ocCnmvEvntDt = null;
	/* Column Info */
	private String bs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgDtTo = null;
	/* Column Info */
	private String destTrnsSvcModCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ovrHgt = null;
	/* Column Info */
	private String oc = null;
	/* Column Info */
	private String eirTotY = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String st = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String eirTotN = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String ot = null;
	/* Column Info */
	private String xterBkgRqstCd = null;
	/* Column Info */
	private String bkgTotalF = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String eirTotalN = null;
	/* Column Info */
	private String bkgDtFr = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cntrVentTpCd = null;
	/* Column Info */
	private String curlTotalN = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String opStsCd = null;
	/* Column Info */
	private String chkLtType = null;
	/* Column Info */
	private String cntrTotalF = null;
	/* Column Info */
	private String opTot = null;
	/* Column Info */
	private String ovrFwrdLen = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String vl = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ofcIncSub = null;
	/* Column Info */
	private String curlTotY = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bkgTotal = null;
	/* Column Info */
	private String curlTotN = null;
	/* Column Info */
	private String stow = null;
	/* Column Info */
	private String cntrRnum = null;
	/* Column Info */
	private String opCnmvEvntDt = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String otTot = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String vlTot = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String curlFlg = null;
	/* Column Info */
	private String cntrTotal = null;
	/* Column Info */
	private String eirFlg = null;
	/* Column Info */
	private String eirTotalY = null;
	/* Column Info */
	private String cntrCfmFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String pre1PolCd = null;
	/* Column Info */
	private String ocStsCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ovrBkwdLen = null;
	/* Column Info */
	private String ocOrgYdCd = null;
	/* Column Info */
	private String ocTot = null;
	/* Column Info */
	private String bkgRnum = null;
	/* Column Info */
	private String opOrgYdCd = null;
	/* Column Info */
	private String curlDt = null;
	/* Column Info */
	private String moveSts = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String cbkgNo = null;
	/* Column Info */
	private String denseRank = null;
	/* Column Info */
	private String denseRank2 = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String cntrVolQty = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OutBdEirMovementStatusListVO() {}

	public OutBdEirMovementStatusListVO(String ibflag, String pagerows, String cntrRnum, String bkgRnum, String bkgNo, String st, String shprNm, String cneeNm, String porCd, String podCd, String rcvTermCd, String deTermCd, String bkgQty, String bs, String eirFlg, String cntrNo, String curlFlg, String curlDt, String opStsCd, String opOrgYdCd, String opCnmvEvntDt, String ocStsCd, String ocOrgYdCd, String ocCnmvEvntDt, String moveSts, String cntrTpszCd, String copNo, String cbkgNo, String denseRank, String denseRank2, String stow, String imdgUnNo, String imdgClssCd, String cdoTemp, String cntrVentTpCd, String ovrFwrdLen, String ovrBkwdLen, String ovrHgt, String bkgTotal, String bkgTotalF, String cntrTotal, String cntrTotalF, String eirTotalY, String eirTotalN, String eirTotY, String eirTotN, String curlTotalY, String curlTotalN, String curlTotY, String curlTotN, String op, String opTot, String oc, String ocTot, String vl, String vlTot, String ot, String otTot, String vvdCd, String bkgOfcCd, String ofcIncSub, String bkgDtFr, String bkgDtTo, String polCd, String orgYdCd, String chkLtType, String cntrCfmFlg, String bkgStsCd, String pre1Vvd, String pre1PolCd, String xterBkgRqstCd, String cnmvStsCd, String bkgCgoTpCd, String destTrnsSvcModCd, String custTpCd, String custCntCd, String custSeq, String custNm, String cntrPrtFlg, String cntrVolQty) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.pre1Vvd = pre1Vvd;
		this.curlTotalY = curlTotalY;
		this.ocCnmvEvntDt = ocCnmvEvntDt;
		this.bs = bs;
		this.pagerows = pagerows;
		this.bkgDtTo = bkgDtTo;
		this.destTrnsSvcModCd = destTrnsSvcModCd;
		this.polCd = polCd;
		this.ovrHgt = ovrHgt;
		this.oc = oc;
		this.eirTotY = eirTotY;
		this.vvdCd = vvdCd;
		this.st = st;
		this.custCntCd = custCntCd;
		this.imdgUnNo = imdgUnNo;
		this.eirTotN = eirTotN;
		this.bkgOfcCd = bkgOfcCd;
		this.ot = ot;
		this.xterBkgRqstCd = xterBkgRqstCd;
		this.bkgTotalF = bkgTotalF;
		this.op = op;
		this.eirTotalN = eirTotalN;
		this.bkgDtFr = bkgDtFr;
		this.podCd = podCd;
		this.cntrVentTpCd = cntrVentTpCd;
		this.curlTotalN = curlTotalN;
		this.bkgNo = bkgNo;
		this.opStsCd = opStsCd;
		this.chkLtType = chkLtType;
		this.cntrTotalF = cntrTotalF;
		this.opTot = opTot;
		this.ovrFwrdLen = ovrFwrdLen;
		this.imdgClssCd = imdgClssCd;
		this.vl = vl;
		this.porCd = porCd;
		this.custNm = custNm;
		this.ofcIncSub = ofcIncSub;
		this.curlTotY = curlTotY;
		this.bkgStsCd = bkgStsCd;
		this.bkgTotal = bkgTotal;
		this.curlTotN = curlTotN;
		this.stow = stow;
		this.cntrRnum = cntrRnum;
		this.opCnmvEvntDt = opCnmvEvntDt;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.otTot = otTot;
		this.bkgQty = bkgQty;
		this.vlTot = vlTot;
		this.shprNm = shprNm;
		this.rcvTermCd = rcvTermCd;
		this.custTpCd = custTpCd;
		this.curlFlg = curlFlg;
		this.cntrTotal = cntrTotal;
		this.eirFlg = eirFlg;
		this.eirTotalY = eirTotalY;
		this.cntrCfmFlg = cntrCfmFlg;
		this.custSeq = custSeq;
		this.orgYdCd = orgYdCd;
		this.pre1PolCd = pre1PolCd;
		this.ocStsCd = ocStsCd;
		this.deTermCd = deTermCd;
		this.cneeNm = cneeNm;
		this.cdoTemp = cdoTemp;
		this.cntrNo = cntrNo;
		this.ovrBkwdLen = ovrBkwdLen;
		this.ocOrgYdCd = ocOrgYdCd;
		this.ocTot = ocTot;
		this.bkgRnum = bkgRnum;
		this.opOrgYdCd = opOrgYdCd;
		this.curlDt = curlDt;
		this.moveSts = moveSts;
		this.cntrTpszCd = cntrTpszCd;
		this.copNo = copNo;
		this.cbkgNo = cbkgNo;
		this.denseRank = denseRank;
		this.denseRank2 = denseRank2;
		this.cntrPrtFlg = cntrPrtFlg;
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("pre_1_vvd", getPre1Vvd());
		this.hashColumns.put("curl_total_y", getCurlTotalY());
		this.hashColumns.put("oc_cnmv_evnt_dt", getOcCnmvEvntDt());
		this.hashColumns.put("bs", getBs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_dt_to", getBkgDtTo());
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("oc", getOc());
		this.hashColumns.put("eir_tot_y", getEirTotY());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("st", getSt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("eir_tot_n", getEirTotN());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("ot", getOt());
		this.hashColumns.put("xter_bkg_rqst_cd", getXterBkgRqstCd());
		this.hashColumns.put("bkg_total_f", getBkgTotalF());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("eir_total_n", getEirTotalN());
		this.hashColumns.put("bkg_dt_fr", getBkgDtFr());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cntr_vent_tp_cd", getCntrVentTpCd());
		this.hashColumns.put("curl_total_n", getCurlTotalN());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("op_sts_cd", getOpStsCd());
		this.hashColumns.put("chk_lt_type", getChkLtType());
		this.hashColumns.put("cntr_total_f", getCntrTotalF());
		this.hashColumns.put("op_tot", getOpTot());
		this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("vl", getVl());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ofc_inc_sub", getOfcIncSub());
		this.hashColumns.put("curl_tot_y", getCurlTotY());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bkg_total", getBkgTotal());
		this.hashColumns.put("curl_tot_n", getCurlTotN());
		this.hashColumns.put("stow", getStow());
		this.hashColumns.put("cntr_rnum", getCntrRnum());
		this.hashColumns.put("op_cnmv_evnt_dt", getOpCnmvEvntDt());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ot_tot", getOtTot());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("vl_tot", getVlTot());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("curl_flg", getCurlFlg());
		this.hashColumns.put("cntr_total", getCntrTotal());
		this.hashColumns.put("eir_flg", getEirFlg());
		this.hashColumns.put("eir_total_y", getEirTotalY());
		this.hashColumns.put("cntr_cfm_flg", getCntrCfmFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("pre_1_pol_cd", getPre1PolCd());
		this.hashColumns.put("oc_sts_cd", getOcStsCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
		this.hashColumns.put("oc_org_yd_cd", getOcOrgYdCd());
		this.hashColumns.put("oc_tot", getOcTot());
		this.hashColumns.put("bkg_rnum", getBkgRnum());
		this.hashColumns.put("op_org_yd_cd", getOpOrgYdCd());
		this.hashColumns.put("curl_dt", getCurlDt());
		this.hashColumns.put("move_sts", getMoveSts());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cbkg_no", getCbkgNo());
		this.hashColumns.put("dense_rank", getDenseRank());
		this.hashColumns.put("dense_rank2", getDenseRank2());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("pre_1_vvd", "pre1Vvd");
		this.hashFields.put("curl_total_y", "curlTotalY");
		this.hashFields.put("oc_cnmv_evnt_dt", "ocCnmvEvntDt");
		this.hashFields.put("bs", "bs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_dt_to", "bkgDtTo");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("oc", "oc");
		this.hashFields.put("eir_tot_y", "eirTotY");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("st", "st");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("eir_tot_n", "eirTotN");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("ot", "ot");
		this.hashFields.put("xter_bkg_rqst_cd", "xterBkgRqstCd");
		this.hashFields.put("bkg_total_f", "bkgTotalF");
		this.hashFields.put("op", "op");
		this.hashFields.put("eir_total_n", "eirTotalN");
		this.hashFields.put("bkg_dt_fr", "bkgDtFr");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cntr_vent_tp_cd", "cntrVentTpCd");
		this.hashFields.put("curl_total_n", "curlTotalN");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("op_sts_cd", "opStsCd");
		this.hashFields.put("chk_lt_type", "chkLtType");
		this.hashFields.put("cntr_total_f", "cntrTotalF");
		this.hashFields.put("op_tot", "opTot");
		this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("vl", "vl");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ofc_inc_sub", "ofcIncSub");
		this.hashFields.put("curl_tot_y", "curlTotY");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bkg_total", "bkgTotal");
		this.hashFields.put("curl_tot_n", "curlTotN");
		this.hashFields.put("stow", "stow");
		this.hashFields.put("cntr_rnum", "cntrRnum");
		this.hashFields.put("op_cnmv_evnt_dt", "opCnmvEvntDt");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ot_tot", "otTot");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("vl_tot", "vlTot");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("curl_flg", "curlFlg");
		this.hashFields.put("cntr_total", "cntrTotal");
		this.hashFields.put("eir_flg", "eirFlg");
		this.hashFields.put("eir_total_y", "eirTotalY");
		this.hashFields.put("cntr_cfm_flg", "cntrCfmFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("pre_1_pol_cd", "pre1PolCd");
		this.hashFields.put("oc_sts_cd", "ocStsCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
		this.hashFields.put("oc_org_yd_cd", "ocOrgYdCd");
		this.hashFields.put("oc_tot", "ocTot");
		this.hashFields.put("bkg_rnum", "bkgRnum");
		this.hashFields.put("op_org_yd_cd", "opOrgYdCd");
		this.hashFields.put("curl_dt", "curlDt");
		this.hashFields.put("move_sts", "moveSts");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cbkg_no", "cbkgNo");
		this.hashFields.put("dense_rank", "denseRank");
		this.hashFields.put("dense_rank2", "denseRank2");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return pre1Vvd
	 */
	public String getPre1Vvd() {
		return this.pre1Vvd;
	}
	
	/**
	 * Column Info
	 * @return curlTotalY
	 */
	public String getCurlTotalY() {
		return this.curlTotalY;
	}
	
	/**
	 * Column Info
	 * @return ocCnmvEvntDt
	 */
	public String getOcCnmvEvntDt() {
		return this.ocCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return bs
	 */
	public String getBs() {
		return this.bs;
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
	 * @return bkgDtTo
	 */
	public String getBkgDtTo() {
		return this.bkgDtTo;
	}
	
	/**
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
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
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
	}
	
	/**
	 * Column Info
	 * @return oc
	 */
	public String getOc() {
		return this.oc;
	}
	
	/**
	 * Column Info
	 * @return eirTotY
	 */
	public String getEirTotY() {
		return this.eirTotY;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return st
	 */
	public String getSt() {
		return this.st;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return eirTotN
	 */
	public String getEirTotN() {
		return this.eirTotN;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ot
	 */
	public String getOt() {
		return this.ot;
	}
	
	/**
	 * Column Info
	 * @return xterBkgRqstCd
	 */
	public String getXterBkgRqstCd() {
		return this.xterBkgRqstCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTotalF
	 */
	public String getBkgTotalF() {
		return this.bkgTotalF;
	}
	
	/**
	 * Column Info
	 * @return op
	 */
	public String getOp() {
		return this.op;
	}
	
	/**
	 * Column Info
	 * @return eirTotalN
	 */
	public String getEirTotalN() {
		return this.eirTotalN;
	}
	
	/**
	 * Column Info
	 * @return bkgDtFr
	 */
	public String getBkgDtFr() {
		return this.bkgDtFr;
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
	 * @return cntrVentTpCd
	 */
	public String getCntrVentTpCd() {
		return this.cntrVentTpCd;
	}
	
	/**
	 * Column Info
	 * @return curlTotalN
	 */
	public String getCurlTotalN() {
		return this.curlTotalN;
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
	 * @return opStsCd
	 */
	public String getOpStsCd() {
		return this.opStsCd;
	}
	
	/**
	 * Column Info
	 * @return chkLtType
	 */
	public String getChkLtType() {
		return this.chkLtType;
	}
	
	/**
	 * Column Info
	 * @return cntrTotalF
	 */
	public String getCntrTotalF() {
		return this.cntrTotalF;
	}
	
	/**
	 * Column Info
	 * @return opTot
	 */
	public String getOpTot() {
		return this.opTot;
	}
	
	/**
	 * Column Info
	 * @return ovrFwrdLen
	 */
	public String getOvrFwrdLen() {
		return this.ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return vl
	 */
	public String getVl() {
		return this.vl;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return ofcIncSub
	 */
	public String getOfcIncSub() {
		return this.ofcIncSub;
	}
	
	/**
	 * Column Info
	 * @return curlTotY
	 */
	public String getCurlTotY() {
		return this.curlTotY;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTotal
	 */
	public String getBkgTotal() {
		return this.bkgTotal;
	}
	
	/**
	 * Column Info
	 * @return curlTotN
	 */
	public String getCurlTotN() {
		return this.curlTotN;
	}
	
	/**
	 * Column Info
	 * @return stow
	 */
	public String getStow() {
		return this.stow;
	}
	
	/**
	 * Column Info
	 * @return cntrRnum
	 */
	public String getCntrRnum() {
		return this.cntrRnum;
	}
	
	/**
	 * Column Info
	 * @return opCnmvEvntDt
	 */
	public String getOpCnmvEvntDt() {
		return this.opCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return otTot
	 */
	public String getOtTot() {
		return this.otTot;
	}
	
	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return vlTot
	 */
	public String getVlTot() {
		return this.vlTot;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
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
	 * @return curlFlg
	 */
	public String getCurlFlg() {
		return this.curlFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTotal
	 */
	public String getCntrTotal() {
		return this.cntrTotal;
	}
	
	/**
	 * Column Info
	 * @return eirFlg
	 */
	public String getEirFlg() {
		return this.eirFlg;
	}
	
	/**
	 * Column Info
	 * @return eirTotalY
	 */
	public String getEirTotalY() {
		return this.eirTotalY;
	}
	
	/**
	 * Column Info
	 * @return cntrCfmFlg
	 */
	public String getCntrCfmFlg() {
		return this.cntrCfmFlg;
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
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return pre1PolCd
	 */
	public String getPre1PolCd() {
		return this.pre1PolCd;
	}
	
	/**
	 * Column Info
	 * @return ocStsCd
	 */
	public String getOcStsCd() {
		return this.ocStsCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return ovrBkwdLen
	 */
	public String getOvrBkwdLen() {
		return this.ovrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @return ocOrgYdCd
	 */
	public String getOcOrgYdCd() {
		return this.ocOrgYdCd;
	}
	
	/**
	 * Column Info
	 * @return ocTot
	 */
	public String getOcTot() {
		return this.ocTot;
	}
	
	/**
	 * Column Info
	 * @return bkgRnum
	 */
	public String getBkgRnum() {
		return this.bkgRnum;
	}
	
	/**
	 * Column Info
	 * @return opOrgYdCd
	 */
	public String getOpOrgYdCd() {
		return this.opOrgYdCd;
	}
	
	/**
	 * Column Info
	 * @return curlDt
	 */
	public String getCurlDt() {
		return this.curlDt;
	}
	
	/**
	 * Column Info
	 * @return moveSts
	 */
	public String getMoveSts() {
		return this.moveSts;
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
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return cbkgNo
	 */
	public String getCbkgNo() {
		return this.cbkgNo;
	}
	
	/**
	 * Column Info
	 * @return denseRank
	 */
	public String getDenseRank() {
		return this.denseRank;
	}
	
	/**
	 * Column Info
	 * @return denseRank2
	 */
	public String getDenseRank2() {
		return this.denseRank2;
	}
	
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param pre1Vvd
	 */
	public void setPre1Vvd(String pre1Vvd) {
		this.pre1Vvd = pre1Vvd;
	}
	
	/**
	 * Column Info
	 * @param curlTotalY
	 */
	public void setCurlTotalY(String curlTotalY) {
		this.curlTotalY = curlTotalY;
	}
	
	/**
	 * Column Info
	 * @param ocCnmvEvntDt
	 */
	public void setOcCnmvEvntDt(String ocCnmvEvntDt) {
		this.ocCnmvEvntDt = ocCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param bs
	 */
	public void setBs(String bs) {
		this.bs = bs;
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
	 * @param bkgDtTo
	 */
	public void setBkgDtTo(String bkgDtTo) {
		this.bkgDtTo = bkgDtTo;
	}
	
	/**
	 * Column Info
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
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
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
	}
	
	/**
	 * Column Info
	 * @param oc
	 */
	public void setOc(String oc) {
		this.oc = oc;
	}
	
	/**
	 * Column Info
	 * @param eirTotY
	 */
	public void setEirTotY(String eirTotY) {
		this.eirTotY = eirTotY;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param st
	 */
	public void setSt(String st) {
		this.st = st;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param eirTotN
	 */
	public void setEirTotN(String eirTotN) {
		this.eirTotN = eirTotN;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ot
	 */
	public void setOt(String ot) {
		this.ot = ot;
	}
	
	/**
	 * Column Info
	 * @param xterBkgRqstCd
	 */
	public void setXterBkgRqstCd(String xterBkgRqstCd) {
		this.xterBkgRqstCd = xterBkgRqstCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTotalF
	 */
	public void setBkgTotalF(String bkgTotalF) {
		this.bkgTotalF = bkgTotalF;
	}
	
	/**
	 * Column Info
	 * @param op
	 */
	public void setOp(String op) {
		this.op = op;
	}
	
	/**
	 * Column Info
	 * @param eirTotalN
	 */
	public void setEirTotalN(String eirTotalN) {
		this.eirTotalN = eirTotalN;
	}
	
	/**
	 * Column Info
	 * @param bkgDtFr
	 */
	public void setBkgDtFr(String bkgDtFr) {
		this.bkgDtFr = bkgDtFr;
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
	 * @param cntrVentTpCd
	 */
	public void setCntrVentTpCd(String cntrVentTpCd) {
		this.cntrVentTpCd = cntrVentTpCd;
	}
	
	/**
	 * Column Info
	 * @param curlTotalN
	 */
	public void setCurlTotalN(String curlTotalN) {
		this.curlTotalN = curlTotalN;
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
	 * @param opStsCd
	 */
	public void setOpStsCd(String opStsCd) {
		this.opStsCd = opStsCd;
	}
	
	/**
	 * Column Info
	 * @param chkLtType
	 */
	public void setChkLtType(String chkLtType) {
		this.chkLtType = chkLtType;
	}
	
	/**
	 * Column Info
	 * @param cntrTotalF
	 */
	public void setCntrTotalF(String cntrTotalF) {
		this.cntrTotalF = cntrTotalF;
	}
	
	/**
	 * Column Info
	 * @param opTot
	 */
	public void setOpTot(String opTot) {
		this.opTot = opTot;
	}
	
	/**
	 * Column Info
	 * @param ovrFwrdLen
	 */
	public void setOvrFwrdLen(String ovrFwrdLen) {
		this.ovrFwrdLen = ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param vl
	 */
	public void setVl(String vl) {
		this.vl = vl;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param ofcIncSub
	 */
	public void setOfcIncSub(String ofcIncSub) {
		this.ofcIncSub = ofcIncSub;
	}
	
	/**
	 * Column Info
	 * @param curlTotY
	 */
	public void setCurlTotY(String curlTotY) {
		this.curlTotY = curlTotY;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTotal
	 */
	public void setBkgTotal(String bkgTotal) {
		this.bkgTotal = bkgTotal;
	}
	
	/**
	 * Column Info
	 * @param curlTotN
	 */
	public void setCurlTotN(String curlTotN) {
		this.curlTotN = curlTotN;
	}
	
	/**
	 * Column Info
	 * @param stow
	 */
	public void setStow(String stow) {
		this.stow = stow;
	}
	
	/**
	 * Column Info
	 * @param cntrRnum
	 */
	public void setCntrRnum(String cntrRnum) {
		this.cntrRnum = cntrRnum;
	}
	
	/**
	 * Column Info
	 * @param opCnmvEvntDt
	 */
	public void setOpCnmvEvntDt(String opCnmvEvntDt) {
		this.opCnmvEvntDt = opCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param otTot
	 */
	public void setOtTot(String otTot) {
		this.otTot = otTot;
	}
	
	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param vlTot
	 */
	public void setVlTot(String vlTot) {
		this.vlTot = vlTot;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
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
	 * @param curlFlg
	 */
	public void setCurlFlg(String curlFlg) {
		this.curlFlg = curlFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTotal
	 */
	public void setCntrTotal(String cntrTotal) {
		this.cntrTotal = cntrTotal;
	}
	
	/**
	 * Column Info
	 * @param eirFlg
	 */
	public void setEirFlg(String eirFlg) {
		this.eirFlg = eirFlg;
	}
	
	/**
	 * Column Info
	 * @param eirTotalY
	 */
	public void setEirTotalY(String eirTotalY) {
		this.eirTotalY = eirTotalY;
	}
	
	/**
	 * Column Info
	 * @param cntrCfmFlg
	 */
	public void setCntrCfmFlg(String cntrCfmFlg) {
		this.cntrCfmFlg = cntrCfmFlg;
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
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param pre1PolCd
	 */
	public void setPre1PolCd(String pre1PolCd) {
		this.pre1PolCd = pre1PolCd;
	}
	
	/**
	 * Column Info
	 * @param ocStsCd
	 */
	public void setOcStsCd(String ocStsCd) {
		this.ocStsCd = ocStsCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param ovrBkwdLen
	 */
	public void setOvrBkwdLen(String ovrBkwdLen) {
		this.ovrBkwdLen = ovrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @param ocOrgYdCd
	 */
	public void setOcOrgYdCd(String ocOrgYdCd) {
		this.ocOrgYdCd = ocOrgYdCd;
	}
	
	/**
	 * Column Info
	 * @param ocTot
	 */
	public void setOcTot(String ocTot) {
		this.ocTot = ocTot;
	}
	
	/**
	 * Column Info
	 * @param bkgRnum
	 */
	public void setBkgRnum(String bkgRnum) {
		this.bkgRnum = bkgRnum;
	}
	
	/**
	 * Column Info
	 * @param opOrgYdCd
	 */
	public void setOpOrgYdCd(String opOrgYdCd) {
		this.opOrgYdCd = opOrgYdCd;
	}
	
	/**
	 * Column Info
	 * @param curlDt
	 */
	public void setCurlDt(String curlDt) {
		this.curlDt = curlDt;
	}
	
	/**
	 * Column Info
	 * @param moveSts
	 */
	public void setMoveSts(String moveSts) {
		this.moveSts = moveSts;
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
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param cbkgNo
	 */
	public void setCbkgNo(String cbkgNo) {
		this.cbkgNo = cbkgNo;
	}
	
	/**
	 * Column Info
	 * @param denseRank
	 */
	public void setDenseRank(String denseRank) {
		this.denseRank = denseRank;
	}
	
	/**
	 * Column Info
	 * @param denseRank2
	 */
	public void setDenseRank2(String denseRank2) {
		this.denseRank2 = denseRank2;
	}
	
	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
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
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setPre1Vvd(JSPUtil.getParameter(request, prefix + "pre_1_vvd", ""));
		setCurlTotalY(JSPUtil.getParameter(request, prefix + "curl_total_y", ""));
		setOcCnmvEvntDt(JSPUtil.getParameter(request, prefix + "oc_cnmv_evnt_dt", ""));
		setBs(JSPUtil.getParameter(request, prefix + "bs", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgDtTo(JSPUtil.getParameter(request, prefix + "bkg_dt_to", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
		setOc(JSPUtil.getParameter(request, prefix + "oc", ""));
		setEirTotY(JSPUtil.getParameter(request, prefix + "eir_tot_y", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setSt(JSPUtil.getParameter(request, prefix + "st", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setEirTotN(JSPUtil.getParameter(request, prefix + "eir_tot_n", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setOt(JSPUtil.getParameter(request, prefix + "ot", ""));
		setXterBkgRqstCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_cd", ""));
		setBkgTotalF(JSPUtil.getParameter(request, prefix + "bkg_total_f", ""));
		setOp(JSPUtil.getParameter(request, prefix + "op", ""));
		setEirTotalN(JSPUtil.getParameter(request, prefix + "eir_total_n", ""));
		setBkgDtFr(JSPUtil.getParameter(request, prefix + "bkg_dt_fr", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCntrVentTpCd(JSPUtil.getParameter(request, prefix + "cntr_vent_tp_cd", ""));
		setCurlTotalN(JSPUtil.getParameter(request, prefix + "curl_total_n", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOpStsCd(JSPUtil.getParameter(request, prefix + "op_sts_cd", ""));
		setChkLtType(JSPUtil.getParameter(request, prefix + "chk_lt_type", ""));
		setCntrTotalF(JSPUtil.getParameter(request, prefix + "cntr_total_f", ""));
		setOpTot(JSPUtil.getParameter(request, prefix + "op_tot", ""));
		setOvrFwrdLen(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setVl(JSPUtil.getParameter(request, prefix + "vl", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setOfcIncSub(JSPUtil.getParameter(request, prefix + "ofc_inc_sub", ""));
		setCurlTotY(JSPUtil.getParameter(request, prefix + "curl_tot_y", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBkgTotal(JSPUtil.getParameter(request, prefix + "bkg_total", ""));
		setCurlTotN(JSPUtil.getParameter(request, prefix + "curl_tot_n", ""));
		setStow(JSPUtil.getParameter(request, prefix + "stow", ""));
		setCntrRnum(JSPUtil.getParameter(request, prefix + "cntr_rnum", ""));
		setOpCnmvEvntDt(JSPUtil.getParameter(request, prefix + "op_cnmv_evnt_dt", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOtTot(JSPUtil.getParameter(request, prefix + "ot_tot", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setVlTot(JSPUtil.getParameter(request, prefix + "vl_tot", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setCurlFlg(JSPUtil.getParameter(request, prefix + "curl_flg", ""));
		setCntrTotal(JSPUtil.getParameter(request, prefix + "cntr_total", ""));
		setEirFlg(JSPUtil.getParameter(request, prefix + "eir_flg", ""));
		setEirTotalY(JSPUtil.getParameter(request, prefix + "eir_total_y", ""));
		setCntrCfmFlg(JSPUtil.getParameter(request, prefix + "cntr_cfm_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setPre1PolCd(JSPUtil.getParameter(request, prefix + "pre_1_pol_cd", ""));
		setOcStsCd(JSPUtil.getParameter(request, prefix + "oc_sts_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setOvrBkwdLen(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", ""));
		setOcOrgYdCd(JSPUtil.getParameter(request, prefix + "oc_org_yd_cd", ""));
		setOcTot(JSPUtil.getParameter(request, prefix + "oc_tot", ""));
		setBkgRnum(JSPUtil.getParameter(request, prefix + "bkg_rnum", ""));
		setOpOrgYdCd(JSPUtil.getParameter(request, prefix + "op_org_yd_cd", ""));
		setCurlDt(JSPUtil.getParameter(request, prefix + "curl_dt", ""));
		setMoveSts(JSPUtil.getParameter(request, prefix + "move_sts", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setCbkgNo(JSPUtil.getParameter(request, prefix + "cbkg_no", ""));
		setDenseRank(JSPUtil.getParameter(request, prefix + "dense_rank", ""));
		setDenseRank2(JSPUtil.getParameter(request, prefix + "dense_rank2", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutBdEirMovementStatusListVO[]
	 */
	public OutBdEirMovementStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutBdEirMovementStatusListVO[]
	 */
	public OutBdEirMovementStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutBdEirMovementStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] pre1Vvd = (JSPUtil.getParameter(request, prefix	+ "pre_1_vvd", length));
			String[] curlTotalY = (JSPUtil.getParameter(request, prefix	+ "curl_total_y", length));
			String[] ocCnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "oc_cnmv_evnt_dt", length));
			String[] bs = (JSPUtil.getParameter(request, prefix	+ "bs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgDtTo = (JSPUtil.getParameter(request, prefix	+ "bkg_dt_to", length));
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] oc = (JSPUtil.getParameter(request, prefix	+ "oc", length));
			String[] eirTotY = (JSPUtil.getParameter(request, prefix	+ "eir_tot_y", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] st = (JSPUtil.getParameter(request, prefix	+ "st", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] eirTotN = (JSPUtil.getParameter(request, prefix	+ "eir_tot_n", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] ot = (JSPUtil.getParameter(request, prefix	+ "ot", length));
			String[] xterBkgRqstCd = (JSPUtil.getParameter(request, prefix	+ "xter_bkg_rqst_cd", length));
			String[] bkgTotalF = (JSPUtil.getParameter(request, prefix	+ "bkg_total_f", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] eirTotalN = (JSPUtil.getParameter(request, prefix	+ "eir_total_n", length));
			String[] bkgDtFr = (JSPUtil.getParameter(request, prefix	+ "bkg_dt_fr", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cntrVentTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_tp_cd", length));
			String[] curlTotalN = (JSPUtil.getParameter(request, prefix	+ "curl_total_n", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] opStsCd = (JSPUtil.getParameter(request, prefix	+ "op_sts_cd", length));
			String[] chkLtType = (JSPUtil.getParameter(request, prefix	+ "chk_lt_type", length));
			String[] cntrTotalF = (JSPUtil.getParameter(request, prefix	+ "cntr_total_f", length));
			String[] opTot = (JSPUtil.getParameter(request, prefix	+ "op_tot", length));
			String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fwrd_len", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] vl = (JSPUtil.getParameter(request, prefix	+ "vl", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ofcIncSub = (JSPUtil.getParameter(request, prefix	+ "ofc_inc_sub", length));
			String[] curlTotY = (JSPUtil.getParameter(request, prefix	+ "curl_tot_y", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bkgTotal = (JSPUtil.getParameter(request, prefix	+ "bkg_total", length));
			String[] curlTotN = (JSPUtil.getParameter(request, prefix	+ "curl_tot_n", length));
			String[] stow = (JSPUtil.getParameter(request, prefix	+ "stow", length));
			String[] cntrRnum = (JSPUtil.getParameter(request, prefix	+ "cntr_rnum", length));
			String[] opCnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "op_cnmv_evnt_dt", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] otTot = (JSPUtil.getParameter(request, prefix	+ "ot_tot", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] vlTot = (JSPUtil.getParameter(request, prefix	+ "vl_tot", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] curlFlg = (JSPUtil.getParameter(request, prefix	+ "curl_flg", length));
			String[] cntrTotal = (JSPUtil.getParameter(request, prefix	+ "cntr_total", length));
			String[] eirFlg = (JSPUtil.getParameter(request, prefix	+ "eir_flg", length));
			String[] eirTotalY = (JSPUtil.getParameter(request, prefix	+ "eir_total_y", length));
			String[] cntrCfmFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_cfm_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] pre1PolCd = (JSPUtil.getParameter(request, prefix	+ "pre_1_pol_cd", length));
			String[] ocStsCd = (JSPUtil.getParameter(request, prefix	+ "oc_sts_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bkwd_len", length));
			String[] ocOrgYdCd = (JSPUtil.getParameter(request, prefix	+ "oc_org_yd_cd", length));
			String[] ocTot = (JSPUtil.getParameter(request, prefix	+ "oc_tot", length));
			String[] bkgRnum = (JSPUtil.getParameter(request, prefix	+ "bkg_rnum", length));
			String[] opOrgYdCd = (JSPUtil.getParameter(request, prefix	+ "op_org_yd_cd", length));
			String[] curlDt = (JSPUtil.getParameter(request, prefix	+ "curl_dt", length));
			String[] moveSts = (JSPUtil.getParameter(request, prefix	+ "move_sts", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] cbkgNo = (JSPUtil.getParameter(request, prefix	+ "cbkg_no", length));
			String[] denseRank = (JSPUtil.getParameter(request, prefix	+ "dense_rank", length));
			String[] denseRank2 = (JSPUtil.getParameter(request, prefix	+ "dense_rank2", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutBdEirMovementStatusListVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (pre1Vvd[i] != null)
					model.setPre1Vvd(pre1Vvd[i]);
				if (curlTotalY[i] != null)
					model.setCurlTotalY(curlTotalY[i]);
				if (ocCnmvEvntDt[i] != null)
					model.setOcCnmvEvntDt(ocCnmvEvntDt[i]);
				if (bs[i] != null)
					model.setBs(bs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgDtTo[i] != null)
					model.setBkgDtTo(bkgDtTo[i]);
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (oc[i] != null)
					model.setOc(oc[i]);
				if (eirTotY[i] != null)
					model.setEirTotY(eirTotY[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (st[i] != null)
					model.setSt(st[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (eirTotN[i] != null)
					model.setEirTotN(eirTotN[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (ot[i] != null)
					model.setOt(ot[i]);
				if (xterBkgRqstCd[i] != null)
					model.setXterBkgRqstCd(xterBkgRqstCd[i]);
				if (bkgTotalF[i] != null)
					model.setBkgTotalF(bkgTotalF[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (eirTotalN[i] != null)
					model.setEirTotalN(eirTotalN[i]);
				if (bkgDtFr[i] != null)
					model.setBkgDtFr(bkgDtFr[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cntrVentTpCd[i] != null)
					model.setCntrVentTpCd(cntrVentTpCd[i]);
				if (curlTotalN[i] != null)
					model.setCurlTotalN(curlTotalN[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (opStsCd[i] != null)
					model.setOpStsCd(opStsCd[i]);
				if (chkLtType[i] != null)
					model.setChkLtType(chkLtType[i]);
				if (cntrTotalF[i] != null)
					model.setCntrTotalF(cntrTotalF[i]);
				if (opTot[i] != null)
					model.setOpTot(opTot[i]);
				if (ovrFwrdLen[i] != null)
					model.setOvrFwrdLen(ovrFwrdLen[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (vl[i] != null)
					model.setVl(vl[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ofcIncSub[i] != null)
					model.setOfcIncSub(ofcIncSub[i]);
				if (curlTotY[i] != null)
					model.setCurlTotY(curlTotY[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bkgTotal[i] != null)
					model.setBkgTotal(bkgTotal[i]);
				if (curlTotN[i] != null)
					model.setCurlTotN(curlTotN[i]);
				if (stow[i] != null)
					model.setStow(stow[i]);
				if (cntrRnum[i] != null)
					model.setCntrRnum(cntrRnum[i]);
				if (opCnmvEvntDt[i] != null)
					model.setOpCnmvEvntDt(opCnmvEvntDt[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (otTot[i] != null)
					model.setOtTot(otTot[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (vlTot[i] != null)
					model.setVlTot(vlTot[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (curlFlg[i] != null)
					model.setCurlFlg(curlFlg[i]);
				if (cntrTotal[i] != null)
					model.setCntrTotal(cntrTotal[i]);
				if (eirFlg[i] != null)
					model.setEirFlg(eirFlg[i]);
				if (eirTotalY[i] != null)
					model.setEirTotalY(eirTotalY[i]);
				if (cntrCfmFlg[i] != null)
					model.setCntrCfmFlg(cntrCfmFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (pre1PolCd[i] != null)
					model.setPre1PolCd(pre1PolCd[i]);
				if (ocStsCd[i] != null)
					model.setOcStsCd(ocStsCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ovrBkwdLen[i] != null)
					model.setOvrBkwdLen(ovrBkwdLen[i]);
				if (ocOrgYdCd[i] != null)
					model.setOcOrgYdCd(ocOrgYdCd[i]);
				if (ocTot[i] != null)
					model.setOcTot(ocTot[i]);
				if (bkgRnum[i] != null)
					model.setBkgRnum(bkgRnum[i]);
				if (opOrgYdCd[i] != null)
					model.setOpOrgYdCd(opOrgYdCd[i]);
				if (curlDt[i] != null)
					model.setCurlDt(curlDt[i]);
				if (moveSts[i] != null)
					model.setMoveSts(moveSts[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (cbkgNo[i] != null)
					model.setCbkgNo(cbkgNo[i]);
				if (denseRank[i] != null)
					model.setDenseRank(denseRank[i]);
				if (denseRank2[i] != null)
					model.setDenseRank2(denseRank2[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutBdEirMovementStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutBdEirMovementStatusListVO[]
	 */
	public OutBdEirMovementStatusListVO[] getOutBdEirMovementStatusListVOs(){
		OutBdEirMovementStatusListVO[] vos = (OutBdEirMovementStatusListVO[])models.toArray(new OutBdEirMovementStatusListVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre1Vvd = this.pre1Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curlTotalY = this.curlTotalY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocCnmvEvntDt = this.ocCnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bs = this.bs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDtTo = this.bkgDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oc = this.oc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eirTotY = this.eirTotY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st = this.st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eirTotN = this.eirTotN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ot = this.ot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstCd = this.xterBkgRqstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTotalF = this.bkgTotalF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eirTotalN = this.eirTotalN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDtFr = this.bkgDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentTpCd = this.cntrVentTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curlTotalN = this.curlTotalN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opStsCd = this.opStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLtType = this.chkLtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTotalF = this.cntrTotalF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opTot = this.opTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFwrdLen = this.ovrFwrdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vl = this.vl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcIncSub = this.ofcIncSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curlTotY = this.curlTotY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTotal = this.bkgTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curlTotN = this.curlTotN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stow = this.stow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRnum = this.cntrRnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCnmvEvntDt = this.opCnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otTot = this.otTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vlTot = this.vlTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curlFlg = this.curlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTotal = this.cntrTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eirFlg = this.eirFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eirTotalY = this.eirTotalY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCfmFlg = this.cntrCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre1PolCd = this.pre1PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocStsCd = this.ocStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBkwdLen = this.ovrBkwdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocOrgYdCd = this.ocOrgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocTot = this.ocTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRnum = this.bkgRnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opOrgYdCd = this.opOrgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curlDt = this.curlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moveSts = this.moveSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbkgNo = this.cbkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.denseRank = this.denseRank .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.denseRank2 = this.denseRank2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
