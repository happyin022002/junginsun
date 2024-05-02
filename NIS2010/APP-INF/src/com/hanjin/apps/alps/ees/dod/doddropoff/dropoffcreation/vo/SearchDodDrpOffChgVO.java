/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchDodDrpOffChgVO.java
*@FileTitle : SearchDodDrpOffChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchDodDrpOffChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDodDrpOffChgVO> models = new ArrayList<SearchDodDrpOffChgVO>();
	
	/* Column Info */
	private String tmpCustCntCd = null;
	/* Column Info */
	private String troIbCfmOfcCd = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String orgCurrCd = null;
	/* Column Info */
	private String orgDcAmt = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dcAmt = null;
	/* Column Info */
	private String orgGenTrfAmt = null;
	/* Column Info */
	private String orgCntrRtnYdCd = null;
	/* Column Info */
	private String cntrRtnYdCd = null;
	/* Column Info */
	private String drpOffChgSeq = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String custCdSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String troIbCxlFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String orgSpclTrfAmt = null;
	/* Column Info */
	private String spclTrfAmt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String svcFeeAmt = null;
	/* Column Info */
	private String spcDrpOffChgTrfExptFlg = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String genDrpOffChgTrfExptFlg = null;
	/* Column Info */
	private String tmpCustSeq = null;
	/* Column Info */
	private String tmpCustCdSeq = null;
	/* Column Info */
	private String drpOffXterRmk = null;
	/* Column Info */
	private String genTrfAmt = null;
	/* Column Info */
	private String strTtlAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String spclCustCntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String drpOffChgMnlFlg = null;
	/* Column Info */
	private String dcRmk = null;
	/* Column Info */
	private String drpOffChgTrfSeq = null;
	/* Column Info */
	private String spclCustLglEngNm = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgSvcFeeAmt = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String sCustCd = null;
	/* Column Info */
	private String orgTtlAmt = null;
	/* Column Info */
	private String tmpCustLglEngNm = null;
	/* Column Info */
	private String cntrRtnDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String savFlg = null;
	/* Column Info */
	private String atchFileLnkCnt = null;
	/* Column Info */
	private String drpOffCustRefRmk = null;
	/* Column Info */
	private String spclCdSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ofcFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String invSrcNo = null;
	/* Column Info */
	private String drpOffChgTrfSpclSeq = null;
	/* Column Info */
	private String custRefRmk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String spclCustSeq = null;
	/* Column Info */
	private String troIbCfmDt = null;
	/* Column Info */
	private String strTtlCurrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchDodDrpOffChgVO() {}

	public SearchDodDrpOffChgVO(String ibflag, String pagerows, String drpOffXterRmk, String drpOffCustRefRmk, String savFlg, String strTtlCurrCd, String strTtlAmt, String tmpCustCntCd, String troIbCfmOfcCd, String ttlAmt, String blNo, String orgCurrCd, String orgDcAmt, String atchFileLnkId, String dcAmt, String cntrRtnYdCd, String orgCntrRtnYdCd, String orgGenTrfAmt, String drpOffChgSeq, String scNo, String cntrTpszCd, String custCdSeq, String custCntCd, String updUsrId, String troIbCxlFlg, String delCd, String orgSpclTrfAmt, String spclTrfAmt, String custLglEngNm, String creUsrId, String bkgNo, String svcFeeAmt, String spcDrpOffChgTrfExptFlg, String zipCd, String xterRmk, String genDrpOffChgTrfExptFlg, String tmpCustSeq, String tmpCustCdSeq, String genTrfAmt, String currCd, String deltFlg, String spclCustCntCd, String creDt, String drpOffChgMnlFlg, String dcRmk, String drpOffChgTrfSeq, String spclCustLglEngNm, String rfaNo, String orgSvcFeeAmt, String arIfNo, String tmpCustLglEngNm, String orgTtlAmt, String sCustCd, String cntrRtnDt, String updDt, String atchFileLnkCnt, String spclCdSeq, String custSeq, String ofcFlg, String custRefRmk, String drpOffChgTrfSpclSeq, String invSrcNo, String ofcCd, String cntrNo, String spclCustSeq, String troIbCfmDt) {
		this.tmpCustCntCd = tmpCustCntCd;
		this.troIbCfmOfcCd = troIbCfmOfcCd;
		this.ttlAmt = ttlAmt;
		this.blNo = blNo;
		this.orgCurrCd = orgCurrCd;
		this.orgDcAmt = orgDcAmt;
		this.atchFileLnkId = atchFileLnkId;
		this.pagerows = pagerows;
		this.dcAmt = dcAmt;
		this.orgGenTrfAmt = orgGenTrfAmt;
		this.orgCntrRtnYdCd = orgCntrRtnYdCd;
		this.cntrRtnYdCd = cntrRtnYdCd;
		this.drpOffChgSeq = drpOffChgSeq;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.custCdSeq = custCdSeq;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.troIbCxlFlg = troIbCxlFlg;
		this.delCd = delCd;
		this.orgSpclTrfAmt = orgSpclTrfAmt;
		this.spclTrfAmt = spclTrfAmt;
		this.custLglEngNm = custLglEngNm;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.svcFeeAmt = svcFeeAmt;
		this.spcDrpOffChgTrfExptFlg = spcDrpOffChgTrfExptFlg;
		this.zipCd = zipCd;
		this.xterRmk = xterRmk;
		this.genDrpOffChgTrfExptFlg = genDrpOffChgTrfExptFlg;
		this.tmpCustSeq = tmpCustSeq;
		this.tmpCustCdSeq = tmpCustCdSeq;
		this.drpOffXterRmk = drpOffXterRmk;
		this.genTrfAmt = genTrfAmt;
		this.strTtlAmt = strTtlAmt;
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.spclCustCntCd = spclCustCntCd;
		this.creDt = creDt;
		this.drpOffChgMnlFlg = drpOffChgMnlFlg;
		this.dcRmk = dcRmk;
		this.drpOffChgTrfSeq = drpOffChgTrfSeq;
		this.spclCustLglEngNm = spclCustLglEngNm;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.orgSvcFeeAmt = orgSvcFeeAmt;
		this.arIfNo = arIfNo;
		this.sCustCd = sCustCd;
		this.orgTtlAmt = orgTtlAmt;
		this.tmpCustLglEngNm = tmpCustLglEngNm;
		this.cntrRtnDt = cntrRtnDt;
		this.updDt = updDt;
		this.savFlg = savFlg;
		this.atchFileLnkCnt = atchFileLnkCnt;
		this.drpOffCustRefRmk = drpOffCustRefRmk;
		this.spclCdSeq = spclCdSeq;
		this.custSeq = custSeq;
		this.ofcFlg = ofcFlg;
		this.ofcCd = ofcCd;
		this.invSrcNo = invSrcNo;
		this.drpOffChgTrfSpclSeq = drpOffChgTrfSpclSeq;
		this.custRefRmk = custRefRmk;
		this.cntrNo = cntrNo;
		this.spclCustSeq = spclCustSeq;
		this.troIbCfmDt = troIbCfmDt;
		this.strTtlCurrCd = strTtlCurrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tmp_cust_cnt_cd", getTmpCustCntCd());
		this.hashColumns.put("tro_ib_cfm_ofc_cd", getTroIbCfmOfcCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("org_curr_cd", getOrgCurrCd());
		this.hashColumns.put("org_dc_amt", getOrgDcAmt());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("org_gen_trf_amt", getOrgGenTrfAmt());
		this.hashColumns.put("org_cntr_rtn_yd_cd", getOrgCntrRtnYdCd());
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());
		this.hashColumns.put("drp_off_chg_seq", getDrpOffChgSeq());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cust_cd_seq", getCustCdSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("tro_ib_cxl_flg", getTroIbCxlFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("org_spcl_trf_amt", getOrgSpclTrfAmt());
		this.hashColumns.put("spcl_trf_amt", getSpclTrfAmt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("svc_fee_amt", getSvcFeeAmt());
		this.hashColumns.put("spc_drp_off_chg_trf_expt_flg", getSpcDrpOffChgTrfExptFlg());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("gen_drp_off_chg_trf_expt_flg", getGenDrpOffChgTrfExptFlg());
		this.hashColumns.put("tmp_cust_seq", getTmpCustSeq());
		this.hashColumns.put("tmp_cust_cd_seq", getTmpCustCdSeq());
		this.hashColumns.put("drp_off_xter_rmk", getDrpOffXterRmk());
		this.hashColumns.put("gen_trf_amt", getGenTrfAmt());
		this.hashColumns.put("str_ttl_amt", getStrTtlAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("spcl_cust_cnt_cd", getSpclCustCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("drp_off_chg_mnl_flg", getDrpOffChgMnlFlg());
		this.hashColumns.put("dc_rmk", getDcRmk());
		this.hashColumns.put("drp_off_chg_trf_seq", getDrpOffChgTrfSeq());
		this.hashColumns.put("spcl_cust_lgl_eng_nm", getSpclCustLglEngNm());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_svc_fee_amt", getOrgSvcFeeAmt());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("s_cust_cd", getSCustCd());
		this.hashColumns.put("org_ttl_amt", getOrgTtlAmt());
		this.hashColumns.put("tmp_cust_lgl_eng_nm", getTmpCustLglEngNm());
		this.hashColumns.put("cntr_rtn_dt", getCntrRtnDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sav_flg", getSavFlg());
		this.hashColumns.put("atch_file_lnk_cnt", getAtchFileLnkCnt());
		this.hashColumns.put("drp_off_cust_ref_rmk", getDrpOffCustRefRmk());
		this.hashColumns.put("spcl_cd_seq", getSpclCdSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ofc_flg", getOfcFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("inv_src_no", getInvSrcNo());
		this.hashColumns.put("drp_off_chg_trf_spcl_seq", getDrpOffChgTrfSpclSeq());
		this.hashColumns.put("cust_ref_rmk", getCustRefRmk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("spcl_cust_seq", getSpclCustSeq());
		this.hashColumns.put("tro_ib_cfm_dt", getTroIbCfmDt());
		this.hashColumns.put("str_ttl_curr_cd", getStrTtlCurrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tmp_cust_cnt_cd", "tmpCustCntCd");
		this.hashFields.put("tro_ib_cfm_ofc_cd", "troIbCfmOfcCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("org_curr_cd", "orgCurrCd");
		this.hashFields.put("org_dc_amt", "orgDcAmt");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("org_gen_trf_amt", "orgGenTrfAmt");
		this.hashFields.put("org_cntr_rtn_yd_cd", "orgCntrRtnYdCd");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("drp_off_chg_seq", "drpOffChgSeq");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cust_cd_seq", "custCdSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("tro_ib_cxl_flg", "troIbCxlFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("org_spcl_trf_amt", "orgSpclTrfAmt");
		this.hashFields.put("spcl_trf_amt", "spclTrfAmt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("svc_fee_amt", "svcFeeAmt");
		this.hashFields.put("spc_drp_off_chg_trf_expt_flg", "spcDrpOffChgTrfExptFlg");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("gen_drp_off_chg_trf_expt_flg", "genDrpOffChgTrfExptFlg");
		this.hashFields.put("tmp_cust_seq", "tmpCustSeq");
		this.hashFields.put("tmp_cust_cd_seq", "tmpCustCdSeq");
		this.hashFields.put("drp_off_xter_rmk", "drpOffXterRmk");
		this.hashFields.put("gen_trf_amt", "genTrfAmt");
		this.hashFields.put("str_ttl_amt", "strTtlAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("spcl_cust_cnt_cd", "spclCustCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("drp_off_chg_mnl_flg", "drpOffChgMnlFlg");
		this.hashFields.put("dc_rmk", "dcRmk");
		this.hashFields.put("drp_off_chg_trf_seq", "drpOffChgTrfSeq");
		this.hashFields.put("spcl_cust_lgl_eng_nm", "spclCustLglEngNm");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_svc_fee_amt", "orgSvcFeeAmt");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("org_ttl_amt", "orgTtlAmt");
		this.hashFields.put("tmp_cust_lgl_eng_nm", "tmpCustLglEngNm");
		this.hashFields.put("cntr_rtn_dt", "cntrRtnDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sav_flg", "savFlg");
		this.hashFields.put("atch_file_lnk_cnt", "atchFileLnkCnt");
		this.hashFields.put("drp_off_cust_ref_rmk", "drpOffCustRefRmk");
		this.hashFields.put("spcl_cd_seq", "spclCdSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ofc_flg", "ofcFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("inv_src_no", "invSrcNo");
		this.hashFields.put("drp_off_chg_trf_spcl_seq", "drpOffChgTrfSpclSeq");
		this.hashFields.put("cust_ref_rmk", "custRefRmk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("spcl_cust_seq", "spclCustSeq");
		this.hashFields.put("tro_ib_cfm_dt", "troIbCfmDt");
		this.hashFields.put("str_ttl_curr_cd", "strTtlCurrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmpCustCntCd
	 */
	public String getTmpCustCntCd() {
		return this.tmpCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return troIbCfmOfcCd
	 */
	public String getTroIbCfmOfcCd() {
		return this.troIbCfmOfcCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return orgCurrCd
	 */
	public String getOrgCurrCd() {
		return this.orgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return orgDcAmt
	 */
	public String getOrgDcAmt() {
		return this.orgDcAmt;
	}
	
	/**
	 * Column Info
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
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
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
	}
	
	/**
	 * Column Info
	 * @return orgGenTrfAmt
	 */
	public String getOrgGenTrfAmt() {
		return this.orgGenTrfAmt;
	}
	
	/**
	 * Column Info
	 * @return orgCntrRtnYdCd
	 */
	public String getOrgCntrRtnYdCd() {
		return this.orgCntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrRtnYdCd
	 */
	public String getCntrRtnYdCd() {
		return this.cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgSeq
	 */
	public String getDrpOffChgSeq() {
		return this.drpOffChgSeq;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return custCdSeq
	 */
	public String getCustCdSeq() {
		return this.custCdSeq;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return troIbCxlFlg
	 */
	public String getTroIbCxlFlg() {
		return this.troIbCxlFlg;
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
	 * @return orgSpclTrfAmt
	 */
	public String getOrgSpclTrfAmt() {
		return this.orgSpclTrfAmt;
	}
	
	/**
	 * Column Info
	 * @return spclTrfAmt
	 */
	public String getSpclTrfAmt() {
		return this.spclTrfAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return svcFeeAmt
	 */
	public String getSvcFeeAmt() {
		return this.svcFeeAmt;
	}
	
	/**
	 * Column Info
	 * @return spcDrpOffChgTrfExptFlg
	 */
	public String getSpcDrpOffChgTrfExptFlg() {
		return this.spcDrpOffChgTrfExptFlg;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	
	/**
	 * Column Info
	 * @return genDrpOffChgTrfExptFlg
	 */
	public String getGenDrpOffChgTrfExptFlg() {
		return this.genDrpOffChgTrfExptFlg;
	}
	
	/**
	 * Column Info
	 * @return tmpCustSeq
	 */
	public String getTmpCustSeq() {
		return this.tmpCustSeq;
	}
	
	/**
	 * Column Info
	 * @return tmpCustCdSeq
	 */
	public String getTmpCustCdSeq() {
		return this.tmpCustCdSeq;
	}
	
	/**
	 * Column Info
	 * @return drpOffXterRmk
	 */
	public String getDrpOffXterRmk() {
		return this.drpOffXterRmk;
	}
	
	/**
	 * Column Info
	 * @return genTrfAmt
	 */
	public String getGenTrfAmt() {
		return this.genTrfAmt;
	}
	
	/**
	 * Column Info
	 * @return strTtlAmt
	 */
	public String getStrTtlAmt() {
		return this.strTtlAmt;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return spclCustCntCd
	 */
	public String getSpclCustCntCd() {
		return this.spclCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgMnlFlg
	 */
	public String getDrpOffChgMnlFlg() {
		return this.drpOffChgMnlFlg;
	}
	
	/**
	 * Column Info
	 * @return dcRmk
	 */
	public String getDcRmk() {
		return this.dcRmk;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfSeq
	 */
	public String getDrpOffChgTrfSeq() {
		return this.drpOffChgTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return spclCustLglEngNm
	 */
	public String getSpclCustLglEngNm() {
		return this.spclCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return orgSvcFeeAmt
	 */
	public String getOrgSvcFeeAmt() {
		return this.orgSvcFeeAmt;
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
	 * @return sCustCd
	 */
	public String getSCustCd() {
		return this.sCustCd;
	}
	
	/**
	 * Column Info
	 * @return orgTtlAmt
	 */
	public String getOrgTtlAmt() {
		return this.orgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return tmpCustLglEngNm
	 */
	public String getTmpCustLglEngNm() {
		return this.tmpCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return cntrRtnDt
	 */
	public String getCntrRtnDt() {
		return this.cntrRtnDt;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return savFlg
	 */
	public String getSavFlg() {
		return this.savFlg;
	}
	
	/**
	 * Column Info
	 * @return atchFileLnkCnt
	 */
	public String getAtchFileLnkCnt() {
		return this.atchFileLnkCnt;
	}
	
	/**
	 * Column Info
	 * @return drpOffCustRefRmk
	 */
	public String getDrpOffCustRefRmk() {
		return this.drpOffCustRefRmk;
	}
	
	/**
	 * Column Info
	 * @return spclCdSeq
	 */
	public String getSpclCdSeq() {
		return this.spclCdSeq;
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
	 * @return ofcFlg
	 */
	public String getOfcFlg() {
		return this.ofcFlg;
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
	 * @return invSrcNo
	 */
	public String getInvSrcNo() {
		return this.invSrcNo;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfSpclSeq
	 */
	public String getDrpOffChgTrfSpclSeq() {
		return this.drpOffChgTrfSpclSeq;
	}
	
	/**
	 * Column Info
	 * @return custRefRmk
	 */
	public String getCustRefRmk() {
		return this.custRefRmk;
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
	 * @return spclCustSeq
	 */
	public String getSpclCustSeq() {
		return this.spclCustSeq;
	}
	
	/**
	 * Column Info
	 * @return troIbCfmDt
	 */
	public String getTroIbCfmDt() {
		return this.troIbCfmDt;
	}
	
	/**
	 * Column Info
	 * @return strTtlCurrCd
	 */
	public String getStrTtlCurrCd() {
		return this.strTtlCurrCd;
	}
	

	/**
	 * Column Info
	 * @param tmpCustCntCd
	 */
	public void setTmpCustCntCd(String tmpCustCntCd) {
		this.tmpCustCntCd = tmpCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param troIbCfmOfcCd
	 */
	public void setTroIbCfmOfcCd(String troIbCfmOfcCd) {
		this.troIbCfmOfcCd = troIbCfmOfcCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param orgCurrCd
	 */
	public void setOrgCurrCd(String orgCurrCd) {
		this.orgCurrCd = orgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param orgDcAmt
	 */
	public void setOrgDcAmt(String orgDcAmt) {
		this.orgDcAmt = orgDcAmt;
	}
	
	/**
	 * Column Info
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
	}
	
	/**
	 * Column Info
	 * @param orgGenTrfAmt
	 */
	public void setOrgGenTrfAmt(String orgGenTrfAmt) {
		this.orgGenTrfAmt = orgGenTrfAmt;
	}
	
	/**
	 * Column Info
	 * @param orgCntrRtnYdCd
	 */
	public void setOrgCntrRtnYdCd(String orgCntrRtnYdCd) {
		this.orgCntrRtnYdCd = orgCntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrRtnYdCd
	 */
	public void setCntrRtnYdCd(String cntrRtnYdCd) {
		this.cntrRtnYdCd = cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgSeq
	 */
	public void setDrpOffChgSeq(String drpOffChgSeq) {
		this.drpOffChgSeq = drpOffChgSeq;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param custCdSeq
	 */
	public void setCustCdSeq(String custCdSeq) {
		this.custCdSeq = custCdSeq;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param troIbCxlFlg
	 */
	public void setTroIbCxlFlg(String troIbCxlFlg) {
		this.troIbCxlFlg = troIbCxlFlg;
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
	 * @param orgSpclTrfAmt
	 */
	public void setOrgSpclTrfAmt(String orgSpclTrfAmt) {
		this.orgSpclTrfAmt = orgSpclTrfAmt;
	}
	
	/**
	 * Column Info
	 * @param spclTrfAmt
	 */
	public void setSpclTrfAmt(String spclTrfAmt) {
		this.spclTrfAmt = spclTrfAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param svcFeeAmt
	 */
	public void setSvcFeeAmt(String svcFeeAmt) {
		this.svcFeeAmt = svcFeeAmt;
	}
	
	/**
	 * Column Info
	 * @param spcDrpOffChgTrfExptFlg
	 */
	public void setSpcDrpOffChgTrfExptFlg(String spcDrpOffChgTrfExptFlg) {
		this.spcDrpOffChgTrfExptFlg = spcDrpOffChgTrfExptFlg;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	
	/**
	 * Column Info
	 * @param genDrpOffChgTrfExptFlg
	 */
	public void setGenDrpOffChgTrfExptFlg(String genDrpOffChgTrfExptFlg) {
		this.genDrpOffChgTrfExptFlg = genDrpOffChgTrfExptFlg;
	}
	
	/**
	 * Column Info
	 * @param tmpCustSeq
	 */
	public void setTmpCustSeq(String tmpCustSeq) {
		this.tmpCustSeq = tmpCustSeq;
	}
	
	/**
	 * Column Info
	 * @param tmpCustCdSeq
	 */
	public void setTmpCustCdSeq(String tmpCustCdSeq) {
		this.tmpCustCdSeq = tmpCustCdSeq;
	}
	
	/**
	 * Column Info
	 * @param drpOffXterRmk
	 */
	public void setDrpOffXterRmk(String drpOffXterRmk) {
		this.drpOffXterRmk = drpOffXterRmk;
	}
	
	/**
	 * Column Info
	 * @param genTrfAmt
	 */
	public void setGenTrfAmt(String genTrfAmt) {
		this.genTrfAmt = genTrfAmt;
	}
	
	/**
	 * Column Info
	 * @param strTtlAmt
	 */
	public void setStrTtlAmt(String strTtlAmt) {
		this.strTtlAmt = strTtlAmt;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param spclCustCntCd
	 */
	public void setSpclCustCntCd(String spclCustCntCd) {
		this.spclCustCntCd = spclCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgMnlFlg
	 */
	public void setDrpOffChgMnlFlg(String drpOffChgMnlFlg) {
		this.drpOffChgMnlFlg = drpOffChgMnlFlg;
	}
	
	/**
	 * Column Info
	 * @param dcRmk
	 */
	public void setDcRmk(String dcRmk) {
		this.dcRmk = dcRmk;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfSeq
	 */
	public void setDrpOffChgTrfSeq(String drpOffChgTrfSeq) {
		this.drpOffChgTrfSeq = drpOffChgTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param spclCustLglEngNm
	 */
	public void setSpclCustLglEngNm(String spclCustLglEngNm) {
		this.spclCustLglEngNm = spclCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param orgSvcFeeAmt
	 */
	public void setOrgSvcFeeAmt(String orgSvcFeeAmt) {
		this.orgSvcFeeAmt = orgSvcFeeAmt;
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
	 * @param sCustCd
	 */
	public void setSCustCd(String sCustCd) {
		this.sCustCd = sCustCd;
	}
	
	/**
	 * Column Info
	 * @param orgTtlAmt
	 */
	public void setOrgTtlAmt(String orgTtlAmt) {
		this.orgTtlAmt = orgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param tmpCustLglEngNm
	 */
	public void setTmpCustLglEngNm(String tmpCustLglEngNm) {
		this.tmpCustLglEngNm = tmpCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param cntrRtnDt
	 */
	public void setCntrRtnDt(String cntrRtnDt) {
		this.cntrRtnDt = cntrRtnDt;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param savFlg
	 */
	public void setSavFlg(String savFlg) {
		this.savFlg = savFlg;
	}
	
	/**
	 * Column Info
	 * @param atchFileLnkCnt
	 */
	public void setAtchFileLnkCnt(String atchFileLnkCnt) {
		this.atchFileLnkCnt = atchFileLnkCnt;
	}
	
	/**
	 * Column Info
	 * @param drpOffCustRefRmk
	 */
	public void setDrpOffCustRefRmk(String drpOffCustRefRmk) {
		this.drpOffCustRefRmk = drpOffCustRefRmk;
	}
	
	/**
	 * Column Info
	 * @param spclCdSeq
	 */
	public void setSpclCdSeq(String spclCdSeq) {
		this.spclCdSeq = spclCdSeq;
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
	 * @param ofcFlg
	 */
	public void setOfcFlg(String ofcFlg) {
		this.ofcFlg = ofcFlg;
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
	 * @param invSrcNo
	 */
	public void setInvSrcNo(String invSrcNo) {
		this.invSrcNo = invSrcNo;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfSpclSeq
	 */
	public void setDrpOffChgTrfSpclSeq(String drpOffChgTrfSpclSeq) {
		this.drpOffChgTrfSpclSeq = drpOffChgTrfSpclSeq;
	}
	
	/**
	 * Column Info
	 * @param custRefRmk
	 */
	public void setCustRefRmk(String custRefRmk) {
		this.custRefRmk = custRefRmk;
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
	 * @param spclCustSeq
	 */
	public void setSpclCustSeq(String spclCustSeq) {
		this.spclCustSeq = spclCustSeq;
	}
	
	/**
	 * Column Info
	 * @param troIbCfmDt
	 */
	public void setTroIbCfmDt(String troIbCfmDt) {
		this.troIbCfmDt = troIbCfmDt;
	}
	
	/**
	 * Column Info
	 * @param strTtlCurrCd
	 */
	public void setStrTtlCurrCd(String strTtlCurrCd) {
		this.strTtlCurrCd = strTtlCurrCd;
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
		setTmpCustCntCd(JSPUtil.getParameter(request, prefix + "tmp_cust_cnt_cd", ""));
		setTroIbCfmOfcCd(JSPUtil.getParameter(request, prefix + "tro_ib_cfm_ofc_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setOrgCurrCd(JSPUtil.getParameter(request, prefix + "org_curr_cd", ""));
		setOrgDcAmt(JSPUtil.getParameter(request, prefix + "org_dc_amt", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
		setOrgGenTrfAmt(JSPUtil.getParameter(request, prefix + "org_gen_trf_amt", ""));
		setOrgCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "org_cntr_rtn_yd_cd", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "cntr_rtn_yd_cd", ""));
		setDrpOffChgSeq(JSPUtil.getParameter(request, prefix + "drp_off_chg_seq", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCustCdSeq(JSPUtil.getParameter(request, prefix + "cust_cd_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setTroIbCxlFlg(JSPUtil.getParameter(request, prefix + "tro_ib_cxl_flg", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOrgSpclTrfAmt(JSPUtil.getParameter(request, prefix + "org_spcl_trf_amt", ""));
		setSpclTrfAmt(JSPUtil.getParameter(request, prefix + "spcl_trf_amt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSvcFeeAmt(JSPUtil.getParameter(request, prefix + "svc_fee_amt", ""));
		setSpcDrpOffChgTrfExptFlg(JSPUtil.getParameter(request, prefix + "spc_drp_off_chg_trf_expt_flg", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setGenDrpOffChgTrfExptFlg(JSPUtil.getParameter(request, prefix + "gen_drp_off_chg_trf_expt_flg", ""));
		setTmpCustSeq(JSPUtil.getParameter(request, prefix + "tmp_cust_seq", ""));
		setTmpCustCdSeq(JSPUtil.getParameter(request, prefix + "tmp_cust_cd_seq", ""));
		setDrpOffXterRmk(JSPUtil.getParameter(request, prefix + "drp_off_xter_rmk", ""));
		setGenTrfAmt(JSPUtil.getParameter(request, prefix + "gen_trf_amt", ""));
		setStrTtlAmt(JSPUtil.getParameter(request, prefix + "str_ttl_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setSpclCustCntCd(JSPUtil.getParameter(request, prefix + "spcl_cust_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDrpOffChgMnlFlg(JSPUtil.getParameter(request, prefix + "drp_off_chg_mnl_flg", ""));
		setDcRmk(JSPUtil.getParameter(request, prefix + "dc_rmk", ""));
		setDrpOffChgTrfSeq(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_seq", ""));
		setSpclCustLglEngNm(JSPUtil.getParameter(request, prefix + "spcl_cust_lgl_eng_nm", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgSvcFeeAmt(JSPUtil.getParameter(request, prefix + "org_svc_fee_amt", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setSCustCd(JSPUtil.getParameter(request, prefix + "s_cust_cd", ""));
		setOrgTtlAmt(JSPUtil.getParameter(request, prefix + "org_ttl_amt", ""));
		setTmpCustLglEngNm(JSPUtil.getParameter(request, prefix + "tmp_cust_lgl_eng_nm", ""));
		setCntrRtnDt(JSPUtil.getParameter(request, prefix + "cntr_rtn_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSavFlg(JSPUtil.getParameter(request, prefix + "sav_flg", ""));
		setAtchFileLnkCnt(JSPUtil.getParameter(request, prefix + "atch_file_lnk_cnt", ""));
		setDrpOffCustRefRmk(JSPUtil.getParameter(request, prefix + "drp_off_cust_ref_rmk", ""));
		setSpclCdSeq(JSPUtil.getParameter(request, prefix + "spcl_cd_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOfcFlg(JSPUtil.getParameter(request, prefix + "ofc_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setInvSrcNo(JSPUtil.getParameter(request, prefix + "inv_src_no", ""));
		setDrpOffChgTrfSpclSeq(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_spcl_seq", ""));
		setCustRefRmk(JSPUtil.getParameter(request, prefix + "cust_ref_rmk", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSpclCustSeq(JSPUtil.getParameter(request, prefix + "spcl_cust_seq", ""));
		setTroIbCfmDt(JSPUtil.getParameter(request, prefix + "tro_ib_cfm_dt", ""));
		setStrTtlCurrCd(JSPUtil.getParameter(request, prefix + "str_ttl_curr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDodDrpOffChgVO[]
	 */
	public SearchDodDrpOffChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDodDrpOffChgVO[]
	 */
	public SearchDodDrpOffChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDodDrpOffChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tmpCustCntCd = (JSPUtil.getParameter(request, prefix	+ "tmp_cust_cnt_cd", length));
			String[] troIbCfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "tro_ib_cfm_ofc_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] orgCurrCd = (JSPUtil.getParameter(request, prefix	+ "org_curr_cd", length));
			String[] orgDcAmt = (JSPUtil.getParameter(request, prefix	+ "org_dc_amt", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] orgGenTrfAmt = (JSPUtil.getParameter(request, prefix	+ "org_gen_trf_amt", length));
			String[] orgCntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "org_cntr_rtn_yd_cd", length));
			String[] cntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_yd_cd", length));
			String[] drpOffChgSeq = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_seq", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] custCdSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cd_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] troIbCxlFlg = (JSPUtil.getParameter(request, prefix	+ "tro_ib_cxl_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] orgSpclTrfAmt = (JSPUtil.getParameter(request, prefix	+ "org_spcl_trf_amt", length));
			String[] spclTrfAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_trf_amt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] svcFeeAmt = (JSPUtil.getParameter(request, prefix	+ "svc_fee_amt", length));
			String[] spcDrpOffChgTrfExptFlg = (JSPUtil.getParameter(request, prefix	+ "spc_drp_off_chg_trf_expt_flg", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] genDrpOffChgTrfExptFlg = (JSPUtil.getParameter(request, prefix	+ "gen_drp_off_chg_trf_expt_flg", length));
			String[] tmpCustSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_cust_seq", length));
			String[] tmpCustCdSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_cust_cd_seq", length));
			String[] drpOffXterRmk = (JSPUtil.getParameter(request, prefix	+ "drp_off_xter_rmk", length));
			String[] genTrfAmt = (JSPUtil.getParameter(request, prefix	+ "gen_trf_amt", length));
			String[] strTtlAmt = (JSPUtil.getParameter(request, prefix	+ "str_ttl_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] spclCustCntCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] drpOffChgMnlFlg = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_mnl_flg", length));
			String[] dcRmk = (JSPUtil.getParameter(request, prefix	+ "dc_rmk", length));
			String[] drpOffChgTrfSeq = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_seq", length));
			String[] spclCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_lgl_eng_nm", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgSvcFeeAmt = (JSPUtil.getParameter(request, prefix	+ "org_svc_fee_amt", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] sCustCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cd", length));
			String[] orgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "org_ttl_amt", length));
			String[] tmpCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "tmp_cust_lgl_eng_nm", length));
			String[] cntrRtnDt = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] savFlg = (JSPUtil.getParameter(request, prefix	+ "sav_flg", length));
			String[] atchFileLnkCnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_cnt", length));
			String[] drpOffCustRefRmk = (JSPUtil.getParameter(request, prefix	+ "drp_off_cust_ref_rmk", length));
			String[] spclCdSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cd_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ofcFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] invSrcNo = (JSPUtil.getParameter(request, prefix	+ "inv_src_no", length));
			String[] drpOffChgTrfSpclSeq = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_spcl_seq", length));
			String[] custRefRmk = (JSPUtil.getParameter(request, prefix	+ "cust_ref_rmk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] spclCustSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_seq", length));
			String[] troIbCfmDt = (JSPUtil.getParameter(request, prefix	+ "tro_ib_cfm_dt", length));
			String[] strTtlCurrCd = (JSPUtil.getParameter(request, prefix	+ "str_ttl_curr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDodDrpOffChgVO();
				if (tmpCustCntCd[i] != null)
					model.setTmpCustCntCd(tmpCustCntCd[i]);
				if (troIbCfmOfcCd[i] != null)
					model.setTroIbCfmOfcCd(troIbCfmOfcCd[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (orgCurrCd[i] != null)
					model.setOrgCurrCd(orgCurrCd[i]);
				if (orgDcAmt[i] != null)
					model.setOrgDcAmt(orgDcAmt[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (orgGenTrfAmt[i] != null)
					model.setOrgGenTrfAmt(orgGenTrfAmt[i]);
				if (orgCntrRtnYdCd[i] != null)
					model.setOrgCntrRtnYdCd(orgCntrRtnYdCd[i]);
				if (cntrRtnYdCd[i] != null)
					model.setCntrRtnYdCd(cntrRtnYdCd[i]);
				if (drpOffChgSeq[i] != null)
					model.setDrpOffChgSeq(drpOffChgSeq[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (custCdSeq[i] != null)
					model.setCustCdSeq(custCdSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (troIbCxlFlg[i] != null)
					model.setTroIbCxlFlg(troIbCxlFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (orgSpclTrfAmt[i] != null)
					model.setOrgSpclTrfAmt(orgSpclTrfAmt[i]);
				if (spclTrfAmt[i] != null)
					model.setSpclTrfAmt(spclTrfAmt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (svcFeeAmt[i] != null)
					model.setSvcFeeAmt(svcFeeAmt[i]);
				if (spcDrpOffChgTrfExptFlg[i] != null)
					model.setSpcDrpOffChgTrfExptFlg(spcDrpOffChgTrfExptFlg[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (genDrpOffChgTrfExptFlg[i] != null)
					model.setGenDrpOffChgTrfExptFlg(genDrpOffChgTrfExptFlg[i]);
				if (tmpCustSeq[i] != null)
					model.setTmpCustSeq(tmpCustSeq[i]);
				if (tmpCustCdSeq[i] != null)
					model.setTmpCustCdSeq(tmpCustCdSeq[i]);
				if (drpOffXterRmk[i] != null)
					model.setDrpOffXterRmk(drpOffXterRmk[i]);
				if (genTrfAmt[i] != null)
					model.setGenTrfAmt(genTrfAmt[i]);
				if (strTtlAmt[i] != null)
					model.setStrTtlAmt(strTtlAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (spclCustCntCd[i] != null)
					model.setSpclCustCntCd(spclCustCntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (drpOffChgMnlFlg[i] != null)
					model.setDrpOffChgMnlFlg(drpOffChgMnlFlg[i]);
				if (dcRmk[i] != null)
					model.setDcRmk(dcRmk[i]);
				if (drpOffChgTrfSeq[i] != null)
					model.setDrpOffChgTrfSeq(drpOffChgTrfSeq[i]);
				if (spclCustLglEngNm[i] != null)
					model.setSpclCustLglEngNm(spclCustLglEngNm[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgSvcFeeAmt[i] != null)
					model.setOrgSvcFeeAmt(orgSvcFeeAmt[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (sCustCd[i] != null)
					model.setSCustCd(sCustCd[i]);
				if (orgTtlAmt[i] != null)
					model.setOrgTtlAmt(orgTtlAmt[i]);
				if (tmpCustLglEngNm[i] != null)
					model.setTmpCustLglEngNm(tmpCustLglEngNm[i]);
				if (cntrRtnDt[i] != null)
					model.setCntrRtnDt(cntrRtnDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (savFlg[i] != null)
					model.setSavFlg(savFlg[i]);
				if (atchFileLnkCnt[i] != null)
					model.setAtchFileLnkCnt(atchFileLnkCnt[i]);
				if (drpOffCustRefRmk[i] != null)
					model.setDrpOffCustRefRmk(drpOffCustRefRmk[i]);
				if (spclCdSeq[i] != null)
					model.setSpclCdSeq(spclCdSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ofcFlg[i] != null)
					model.setOfcFlg(ofcFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (invSrcNo[i] != null)
					model.setInvSrcNo(invSrcNo[i]);
				if (drpOffChgTrfSpclSeq[i] != null)
					model.setDrpOffChgTrfSpclSeq(drpOffChgTrfSpclSeq[i]);
				if (custRefRmk[i] != null)
					model.setCustRefRmk(custRefRmk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (spclCustSeq[i] != null)
					model.setSpclCustSeq(spclCustSeq[i]);
				if (troIbCfmDt[i] != null)
					model.setTroIbCfmDt(troIbCfmDt[i]);
				if (strTtlCurrCd[i] != null)
					model.setStrTtlCurrCd(strTtlCurrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDodDrpOffChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDodDrpOffChgVO[]
	 */
	public SearchDodDrpOffChgVO[] getSearchDodDrpOffChgVOs(){
		SearchDodDrpOffChgVO[] vos = (SearchDodDrpOffChgVO[])models.toArray(new SearchDodDrpOffChgVO[models.size()]);
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
		this.tmpCustCntCd = this.tmpCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troIbCfmOfcCd = this.troIbCfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCurrCd = this.orgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDcAmt = this.orgDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGenTrfAmt = this.orgGenTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntrRtnYdCd = this.orgCntrRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd = this.cntrRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgSeq = this.drpOffChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCdSeq = this.custCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troIbCxlFlg = this.troIbCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSpclTrfAmt = this.orgSpclTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTrfAmt = this.spclTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcFeeAmt = this.svcFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcDrpOffChgTrfExptFlg = this.spcDrpOffChgTrfExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genDrpOffChgTrfExptFlg = this.genDrpOffChgTrfExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpCustSeq = this.tmpCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpCustCdSeq = this.tmpCustCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffXterRmk = this.drpOffXterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genTrfAmt = this.genTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strTtlAmt = this.strTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustCntCd = this.spclCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgMnlFlg = this.drpOffChgMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRmk = this.dcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfSeq = this.drpOffChgTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustLglEngNm = this.spclCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSvcFeeAmt = this.orgSvcFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd = this.sCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTtlAmt = this.orgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpCustLglEngNm = this.tmpCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnDt = this.cntrRtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savFlg = this.savFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkCnt = this.atchFileLnkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffCustRefRmk = this.drpOffCustRefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCdSeq = this.spclCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFlg = this.ofcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSrcNo = this.invSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfSpclSeq = this.drpOffChgTrfSpclSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefRmk = this.custRefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustSeq = this.spclCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troIbCfmDt = this.troIbCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strTtlCurrCd = this.strTtlCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
