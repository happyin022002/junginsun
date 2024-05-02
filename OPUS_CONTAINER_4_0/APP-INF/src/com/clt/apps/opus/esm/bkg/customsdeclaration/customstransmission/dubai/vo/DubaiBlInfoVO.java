/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiBlInfoVO.java
*@FileTitle : DubaiBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.12 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DubaiBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DubaiBlInfoVO> models = new ArrayList<DubaiBlInfoVO>();
	
	/* Column Info */
	private String mkNoCtnt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cnslCgoFlg = null;
	/* Column Info */
	private String duPckTpCd = null;
	/* Column Info */
	private String cDuCustId = null;
	/* Column Info */
	private String orgPortCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cOrgCustNm = null;
	/* Column Info */
	private String tareWgt = null;
	/* Column Info */
	private String duCntrSvcTpCd = null;
	/* Column Info */
	private String cCustCntCd = null;
	/* Column Info */
	private String orgSkdVoyNo = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String sOrgCustAddr = null;
	/* Column Info */
	private String orgVslCd = null;
	/* Column Info */
	private String duTrdCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String cOrgCustAddr = null;
	/* Column Info */
	private String orgSkdDirCd = null;
	/* Column Info */
	private String nCustCntCd = null;
	/* Column Info */
	private String duCgoCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String duRotnNo = null;
	/* Column Info */
	private String sCustAddr = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String duMfNo = null;
	/* Column Info */
	private String duPckDesc = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String nDuCustId = null;
	/* Column Info */
	private String sOrgCustNm = null;
	/* Column Info */
	private String nCustAddr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pltQty = null;
	/* Column Info */
	private String duVoyAgnId = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String duTsModCd = null;
	/* Column Info */
	private String orgBlNo = null;
	/* Column Info */
	private String duCmdtCd = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String duLineId = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String duTtlQty = null;
	/* Column Info */
	private String orgVslNm = null;
	/* Column Info */
	private String duFrtWgt = null;
	/* Column Info */
	private String orgCntCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrKnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DubaiBlInfoVO() {}

	public DubaiBlInfoVO(String ibflag, String pagerows, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String duRotnNo, String duLineId, String duVoyAgnId, String orgPortCd, String porCd, String polCd, String podCd, String delCd, String duMfNo, String duCgoCd, String duCntrSvcTpCd, String duTrdCd, String duTsModCd, String cnslCgoFlg, String orgBlNo, String orgCntCd, String orgVslCd, String orgSkdVoyNo, String orgSkdDirCd, String mkNoCtnt, String duCmdtCd, String cmdtDesc, String pckQty, String duPckDesc, String duPckTpCd, String cntrNo, String checkDigit, String cntrKnt, String bkgTeuQty, String tareWgt, String cgoWgt, String grsWgt, String measQty, String duTtlQty, String duFrtWgt, String pltQty, String sCustCntCd, String sCustNm, String sCustAddr, String sOrgCustNm, String sOrgCustAddr, String cCustCntCd, String cDuCustId, String cCustNm, String cCustAddr, String cOrgCustNm, String cOrgCustAddr, String nCustCntCd, String nDuCustId, String nCustNm, String nCustAddr, String orgVslNm) {
		this.mkNoCtnt = mkNoCtnt;
		this.vslCd = vslCd;
		this.cnslCgoFlg = cnslCgoFlg;
		this.duPckTpCd = duPckTpCd;
		this.cDuCustId = cDuCustId;
		this.orgPortCd = orgPortCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.cOrgCustNm = cOrgCustNm;
		this.tareWgt = tareWgt;
		this.duCntrSvcTpCd = duCntrSvcTpCd;
		this.cCustCntCd = cCustCntCd;
		this.orgSkdVoyNo = orgSkdVoyNo;
		this.cgoWgt = cgoWgt;
		this.sOrgCustAddr = sOrgCustAddr;
		this.orgVslCd = orgVslCd;
		this.duTrdCd = duTrdCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.sCustCntCd = sCustCntCd;
		this.cOrgCustAddr = cOrgCustAddr;
		this.orgSkdDirCd = orgSkdDirCd;
		this.nCustCntCd = nCustCntCd;
		this.duCgoCd = duCgoCd;
		this.podCd = podCd;
		this.cmdtDesc = cmdtDesc;
		this.duRotnNo = duRotnNo;
		this.sCustAddr = sCustAddr;
		this.bkgTeuQty = bkgTeuQty;
		this.grsWgt = grsWgt;
		this.porCd = porCd;
		this.duMfNo = duMfNo;
		this.duPckDesc = duPckDesc;
		this.cCustNm = cCustNm;
		this.checkDigit = checkDigit;
		this.nDuCustId = nDuCustId;
		this.sOrgCustNm = sOrgCustNm;
		this.nCustAddr = nCustAddr;
		this.ibflag = ibflag;
		this.cCustAddr = cCustAddr;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.pltQty = pltQty;
		this.duVoyAgnId = duVoyAgnId;
		this.nCustNm = nCustNm;
		this.duTsModCd = duTsModCd;
		this.orgBlNo = orgBlNo;
		this.duCmdtCd = duCmdtCd;
		this.sCustNm = sCustNm;
		this.duLineId = duLineId;
		this.skdDirCd = skdDirCd;
		this.duTtlQty = duTtlQty;
		this.orgVslNm = orgVslNm;
		this.duFrtWgt = duFrtWgt;
		this.orgCntCd = orgCntCd;
		this.cntrNo = cntrNo;
		this.cntrKnt = cntrKnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mk_no_ctnt", getMkNoCtnt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cnsl_cgo_flg", getCnslCgoFlg());
		this.hashColumns.put("du_pck_tp_cd", getDuPckTpCd());
		this.hashColumns.put("c_du_cust_id", getCDuCustId());
		this.hashColumns.put("org_port_cd", getOrgPortCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("c_org_cust_nm", getCOrgCustNm());
		this.hashColumns.put("tare_wgt", getTareWgt());
		this.hashColumns.put("du_cntr_svc_tp_cd", getDuCntrSvcTpCd());
		this.hashColumns.put("c_cust_cnt_cd", getCCustCntCd());
		this.hashColumns.put("org_skd_voy_no", getOrgSkdVoyNo());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("s_org_cust_addr", getSOrgCustAddr());
		this.hashColumns.put("org_vsl_cd", getOrgVslCd());
		this.hashColumns.put("du_trd_cd", getDuTrdCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("c_org_cust_addr", getCOrgCustAddr());
		this.hashColumns.put("org_skd_dir_cd", getOrgSkdDirCd());
		this.hashColumns.put("n_cust_cnt_cd", getNCustCntCd());
		this.hashColumns.put("du_cgo_cd", getDuCgoCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("du_rotn_no", getDuRotnNo());
		this.hashColumns.put("s_cust_addr", getSCustAddr());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("du_mf_no", getDuMfNo());
		this.hashColumns.put("du_pck_desc", getDuPckDesc());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("n_du_cust_id", getNDuCustId());
		this.hashColumns.put("s_org_cust_nm", getSOrgCustNm());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("plt_qty", getPltQty());
		this.hashColumns.put("du_voy_agn_id", getDuVoyAgnId());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("du_ts_mod_cd", getDuTsModCd());
		this.hashColumns.put("org_bl_no", getOrgBlNo());
		this.hashColumns.put("du_cmdt_cd", getDuCmdtCd());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("du_line_id", getDuLineId());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("du_ttl_qty", getDuTtlQty());
		this.hashColumns.put("org_vsl_nm", getOrgVslNm());
		this.hashColumns.put("du_frt_wgt", getDuFrtWgt());
		this.hashColumns.put("org_cnt_cd", getOrgCntCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_knt", getCntrKnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mk_no_ctnt", "mkNoCtnt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cnsl_cgo_flg", "cnslCgoFlg");
		this.hashFields.put("du_pck_tp_cd", "duPckTpCd");
		this.hashFields.put("c_du_cust_id", "cDuCustId");
		this.hashFields.put("org_port_cd", "orgPortCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("c_org_cust_nm", "cOrgCustNm");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("du_cntr_svc_tp_cd", "duCntrSvcTpCd");
		this.hashFields.put("c_cust_cnt_cd", "cCustCntCd");
		this.hashFields.put("org_skd_voy_no", "orgSkdVoyNo");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("s_org_cust_addr", "sOrgCustAddr");
		this.hashFields.put("org_vsl_cd", "orgVslCd");
		this.hashFields.put("du_trd_cd", "duTrdCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("c_org_cust_addr", "cOrgCustAddr");
		this.hashFields.put("org_skd_dir_cd", "orgSkdDirCd");
		this.hashFields.put("n_cust_cnt_cd", "nCustCntCd");
		this.hashFields.put("du_cgo_cd", "duCgoCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("du_rotn_no", "duRotnNo");
		this.hashFields.put("s_cust_addr", "sCustAddr");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("du_mf_no", "duMfNo");
		this.hashFields.put("du_pck_desc", "duPckDesc");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("n_du_cust_id", "nDuCustId");
		this.hashFields.put("s_org_cust_nm", "sOrgCustNm");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("plt_qty", "pltQty");
		this.hashFields.put("du_voy_agn_id", "duVoyAgnId");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("du_ts_mod_cd", "duTsModCd");
		this.hashFields.put("org_bl_no", "orgBlNo");
		this.hashFields.put("du_cmdt_cd", "duCmdtCd");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("du_line_id", "duLineId");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("du_ttl_qty", "duTtlQty");
		this.hashFields.put("org_vsl_nm", "orgVslNm");
		this.hashFields.put("du_frt_wgt", "duFrtWgt");
		this.hashFields.put("org_cnt_cd", "orgCntCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_knt", "cntrKnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mkNoCtnt
	 */
	public String getMkNoCtnt() {
		return this.mkNoCtnt;
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
	 * @return cnslCgoFlg
	 */
	public String getCnslCgoFlg() {
		return this.cnslCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return duPckTpCd
	 */
	public String getDuPckTpCd() {
		return this.duPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return cDuCustId
	 */
	public String getCDuCustId() {
		return this.cDuCustId;
	}
	
	/**
	 * Column Info
	 * @return orgPortCd
	 */
	public String getOrgPortCd() {
		return this.orgPortCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return cOrgCustNm
	 */
	public String getCOrgCustNm() {
		return this.cOrgCustNm;
	}
	
	/**
	 * Column Info
	 * @return tareWgt
	 */
	public String getTareWgt() {
		return this.tareWgt;
	}
	
	/**
	 * Column Info
	 * @return duCntrSvcTpCd
	 */
	public String getDuCntrSvcTpCd() {
		return this.duCntrSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return cCustCntCd
	 */
	public String getCCustCntCd() {
		return this.cCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return orgSkdVoyNo
	 */
	public String getOrgSkdVoyNo() {
		return this.orgSkdVoyNo;
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
	 * @return sOrgCustAddr
	 */
	public String getSOrgCustAddr() {
		return this.sOrgCustAddr;
	}
	
	/**
	 * Column Info
	 * @return orgVslCd
	 */
	public String getOrgVslCd() {
		return this.orgVslCd;
	}
	
	/**
	 * Column Info
	 * @return duTrdCd
	 */
	public String getDuTrdCd() {
		return this.duTrdCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return sCustCntCd
	 */
	public String getSCustCntCd() {
		return this.sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cOrgCustAddr
	 */
	public String getCOrgCustAddr() {
		return this.cOrgCustAddr;
	}
	
	/**
	 * Column Info
	 * @return orgSkdDirCd
	 */
	public String getOrgSkdDirCd() {
		return this.orgSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return nCustCntCd
	 */
	public String getNCustCntCd() {
		return this.nCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return duCgoCd
	 */
	public String getDuCgoCd() {
		return this.duCgoCd;
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
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return duRotnNo
	 */
	public String getDuRotnNo() {
		return this.duRotnNo;
	}
	
	/**
	 * Column Info
	 * @return sCustAddr
	 */
	public String getSCustAddr() {
		return this.sCustAddr;
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
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @return duMfNo
	 */
	public String getDuMfNo() {
		return this.duMfNo;
	}
	
	/**
	 * Column Info
	 * @return duPckDesc
	 */
	public String getDuPckDesc() {
		return this.duPckDesc;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
	}
	
	/**
	 * Column Info
	 * @return nDuCustId
	 */
	public String getNDuCustId() {
		return this.nDuCustId;
	}
	
	/**
	 * Column Info
	 * @return sOrgCustNm
	 */
	public String getSOrgCustNm() {
		return this.sOrgCustNm;
	}
	
	/**
	 * Column Info
	 * @return nCustAddr
	 */
	public String getNCustAddr() {
		return this.nCustAddr;
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
	 * @return cCustAddr
	 */
	public String getCCustAddr() {
		return this.cCustAddr;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return pltQty
	 */
	public String getPltQty() {
		return this.pltQty;
	}
	
	/**
	 * Column Info
	 * @return duVoyAgnId
	 */
	public String getDuVoyAgnId() {
		return this.duVoyAgnId;
	}
	
	/**
	 * Column Info
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
	}
	
	/**
	 * Column Info
	 * @return duTsModCd
	 */
	public String getDuTsModCd() {
		return this.duTsModCd;
	}
	
	/**
	 * Column Info
	 * @return orgBlNo
	 */
	public String getOrgBlNo() {
		return this.orgBlNo;
	}
	
	/**
	 * Column Info
	 * @return duCmdtCd
	 */
	public String getDuCmdtCd() {
		return this.duCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return duLineId
	 */
	public String getDuLineId() {
		return this.duLineId;
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
	 * @return duTtlQty
	 */
	public String getDuTtlQty() {
		return this.duTtlQty;
	}
	
	/**
	 * Column Info
	 * @return orgVslNm
	 */
	public String getOrgVslNm() {
		return this.orgVslNm;
	}
	
	/**
	 * Column Info
	 * @return duFrtWgt
	 */
	public String getDuFrtWgt() {
		return this.duFrtWgt;
	}
	
	/**
	 * Column Info
	 * @return orgCntCd
	 */
	public String getOrgCntCd() {
		return this.orgCntCd;
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
	 * @return cntrKnt
	 */
	public String getCntrKnt() {
		return this.cntrKnt;
	}
	

	/**
	 * Column Info
	 * @param mkNoCtnt
	 */
	public void setMkNoCtnt(String mkNoCtnt) {
		this.mkNoCtnt = mkNoCtnt;
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
	 * @param cnslCgoFlg
	 */
	public void setCnslCgoFlg(String cnslCgoFlg) {
		this.cnslCgoFlg = cnslCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param duPckTpCd
	 */
	public void setDuPckTpCd(String duPckTpCd) {
		this.duPckTpCd = duPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param cDuCustId
	 */
	public void setCDuCustId(String cDuCustId) {
		this.cDuCustId = cDuCustId;
	}
	
	/**
	 * Column Info
	 * @param orgPortCd
	 */
	public void setOrgPortCd(String orgPortCd) {
		this.orgPortCd = orgPortCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param cOrgCustNm
	 */
	public void setCOrgCustNm(String cOrgCustNm) {
		this.cOrgCustNm = cOrgCustNm;
	}
	
	/**
	 * Column Info
	 * @param tareWgt
	 */
	public void setTareWgt(String tareWgt) {
		this.tareWgt = tareWgt;
	}
	
	/**
	 * Column Info
	 * @param duCntrSvcTpCd
	 */
	public void setDuCntrSvcTpCd(String duCntrSvcTpCd) {
		this.duCntrSvcTpCd = duCntrSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param cCustCntCd
	 */
	public void setCCustCntCd(String cCustCntCd) {
		this.cCustCntCd = cCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param orgSkdVoyNo
	 */
	public void setOrgSkdVoyNo(String orgSkdVoyNo) {
		this.orgSkdVoyNo = orgSkdVoyNo;
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
	 * @param sOrgCustAddr
	 */
	public void setSOrgCustAddr(String sOrgCustAddr) {
		this.sOrgCustAddr = sOrgCustAddr;
	}
	
	/**
	 * Column Info
	 * @param orgVslCd
	 */
	public void setOrgVslCd(String orgVslCd) {
		this.orgVslCd = orgVslCd;
	}
	
	/**
	 * Column Info
	 * @param duTrdCd
	 */
	public void setDuTrdCd(String duTrdCd) {
		this.duTrdCd = duTrdCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param sCustCntCd
	 */
	public void setSCustCntCd(String sCustCntCd) {
		this.sCustCntCd = sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cOrgCustAddr
	 */
	public void setCOrgCustAddr(String cOrgCustAddr) {
		this.cOrgCustAddr = cOrgCustAddr;
	}
	
	/**
	 * Column Info
	 * @param orgSkdDirCd
	 */
	public void setOrgSkdDirCd(String orgSkdDirCd) {
		this.orgSkdDirCd = orgSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param nCustCntCd
	 */
	public void setNCustCntCd(String nCustCntCd) {
		this.nCustCntCd = nCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param duCgoCd
	 */
	public void setDuCgoCd(String duCgoCd) {
		this.duCgoCd = duCgoCd;
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
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param duRotnNo
	 */
	public void setDuRotnNo(String duRotnNo) {
		this.duRotnNo = duRotnNo;
	}
	
	/**
	 * Column Info
	 * @param sCustAddr
	 */
	public void setSCustAddr(String sCustAddr) {
		this.sCustAddr = sCustAddr;
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
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
	 * @param duMfNo
	 */
	public void setDuMfNo(String duMfNo) {
		this.duMfNo = duMfNo;
	}
	
	/**
	 * Column Info
	 * @param duPckDesc
	 */
	public void setDuPckDesc(String duPckDesc) {
		this.duPckDesc = duPckDesc;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}
	
	/**
	 * Column Info
	 * @param nDuCustId
	 */
	public void setNDuCustId(String nDuCustId) {
		this.nDuCustId = nDuCustId;
	}
	
	/**
	 * Column Info
	 * @param sOrgCustNm
	 */
	public void setSOrgCustNm(String sOrgCustNm) {
		this.sOrgCustNm = sOrgCustNm;
	}
	
	/**
	 * Column Info
	 * @param nCustAddr
	 */
	public void setNCustAddr(String nCustAddr) {
		this.nCustAddr = nCustAddr;
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
	 * @param cCustAddr
	 */
	public void setCCustAddr(String cCustAddr) {
		this.cCustAddr = cCustAddr;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param pltQty
	 */
	public void setPltQty(String pltQty) {
		this.pltQty = pltQty;
	}
	
	/**
	 * Column Info
	 * @param duVoyAgnId
	 */
	public void setDuVoyAgnId(String duVoyAgnId) {
		this.duVoyAgnId = duVoyAgnId;
	}
	
	/**
	 * Column Info
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
	}
	
	/**
	 * Column Info
	 * @param duTsModCd
	 */
	public void setDuTsModCd(String duTsModCd) {
		this.duTsModCd = duTsModCd;
	}
	
	/**
	 * Column Info
	 * @param orgBlNo
	 */
	public void setOrgBlNo(String orgBlNo) {
		this.orgBlNo = orgBlNo;
	}
	
	/**
	 * Column Info
	 * @param duCmdtCd
	 */
	public void setDuCmdtCd(String duCmdtCd) {
		this.duCmdtCd = duCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param duLineId
	 */
	public void setDuLineId(String duLineId) {
		this.duLineId = duLineId;
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
	 * @param duTtlQty
	 */
	public void setDuTtlQty(String duTtlQty) {
		this.duTtlQty = duTtlQty;
	}
	
	/**
	 * Column Info
	 * @param orgVslNm
	 */
	public void setOrgVslNm(String orgVslNm) {
		this.orgVslNm = orgVslNm;
	}
	
	/**
	 * Column Info
	 * @param duFrtWgt
	 */
	public void setDuFrtWgt(String duFrtWgt) {
		this.duFrtWgt = duFrtWgt;
	}
	
	/**
	 * Column Info
	 * @param orgCntCd
	 */
	public void setOrgCntCd(String orgCntCd) {
		this.orgCntCd = orgCntCd;
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
	 * @param cntrKnt
	 */
	public void setCntrKnt(String cntrKnt) {
		this.cntrKnt = cntrKnt;
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
		setMkNoCtnt(JSPUtil.getParameter(request, prefix + "mk_no_ctnt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCnslCgoFlg(JSPUtil.getParameter(request, prefix + "cnsl_cgo_flg", ""));
		setDuPckTpCd(JSPUtil.getParameter(request, prefix + "du_pck_tp_cd", ""));
		setCDuCustId(JSPUtil.getParameter(request, prefix + "c_du_cust_id", ""));
		setOrgPortCd(JSPUtil.getParameter(request, prefix + "org_port_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCOrgCustNm(JSPUtil.getParameter(request, prefix + "c_org_cust_nm", ""));
		setTareWgt(JSPUtil.getParameter(request, prefix + "tare_wgt", ""));
		setDuCntrSvcTpCd(JSPUtil.getParameter(request, prefix + "du_cntr_svc_tp_cd", ""));
		setCCustCntCd(JSPUtil.getParameter(request, prefix + "c_cust_cnt_cd", ""));
		setOrgSkdVoyNo(JSPUtil.getParameter(request, prefix + "org_skd_voy_no", ""));
		setCgoWgt(JSPUtil.getParameter(request, prefix + "cgo_wgt", ""));
		setSOrgCustAddr(JSPUtil.getParameter(request, prefix + "s_org_cust_addr", ""));
		setOrgVslCd(JSPUtil.getParameter(request, prefix + "org_vsl_cd", ""));
		setDuTrdCd(JSPUtil.getParameter(request, prefix + "du_trd_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSCustCntCd(JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", ""));
		setCOrgCustAddr(JSPUtil.getParameter(request, prefix + "c_org_cust_addr", ""));
		setOrgSkdDirCd(JSPUtil.getParameter(request, prefix + "org_skd_dir_cd", ""));
		setNCustCntCd(JSPUtil.getParameter(request, prefix + "n_cust_cnt_cd", ""));
		setDuCgoCd(JSPUtil.getParameter(request, prefix + "du_cgo_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setDuRotnNo(JSPUtil.getParameter(request, prefix + "du_rotn_no", ""));
		setSCustAddr(JSPUtil.getParameter(request, prefix + "s_cust_addr", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setDuMfNo(JSPUtil.getParameter(request, prefix + "du_mf_no", ""));
		setDuPckDesc(JSPUtil.getParameter(request, prefix + "du_pck_desc", ""));
		setCCustNm(JSPUtil.getParameter(request, prefix + "c_cust_nm", ""));
		setCheckDigit(JSPUtil.getParameter(request, prefix + "check_digit", ""));
		setNDuCustId(JSPUtil.getParameter(request, prefix + "n_du_cust_id", ""));
		setSOrgCustNm(JSPUtil.getParameter(request, prefix + "s_org_cust_nm", ""));
		setNCustAddr(JSPUtil.getParameter(request, prefix + "n_cust_addr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCCustAddr(JSPUtil.getParameter(request, prefix + "c_cust_addr", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPltQty(JSPUtil.getParameter(request, prefix + "plt_qty", ""));
		setDuVoyAgnId(JSPUtil.getParameter(request, prefix + "du_voy_agn_id", ""));
		setNCustNm(JSPUtil.getParameter(request, prefix + "n_cust_nm", ""));
		setDuTsModCd(JSPUtil.getParameter(request, prefix + "du_ts_mod_cd", ""));
		setOrgBlNo(JSPUtil.getParameter(request, prefix + "org_bl_no", ""));
		setDuCmdtCd(JSPUtil.getParameter(request, prefix + "du_cmdt_cd", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setDuLineId(JSPUtil.getParameter(request, prefix + "du_line_id", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setDuTtlQty(JSPUtil.getParameter(request, prefix + "du_ttl_qty", ""));
		setOrgVslNm(JSPUtil.getParameter(request, prefix + "org_vsl_nm", ""));
		setDuFrtWgt(JSPUtil.getParameter(request, prefix + "du_frt_wgt", ""));
		setOrgCntCd(JSPUtil.getParameter(request, prefix + "org_cnt_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrKnt(JSPUtil.getParameter(request, prefix + "cntr_knt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DubaiBlInfoVO[]
	 */
	public DubaiBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DubaiBlInfoVO[]
	 */
	public DubaiBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DubaiBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mkNoCtnt = (JSPUtil.getParameter(request, prefix	+ "mk_no_ctnt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cnslCgoFlg = (JSPUtil.getParameter(request, prefix	+ "cnsl_cgo_flg", length));
			String[] duPckTpCd = (JSPUtil.getParameter(request, prefix	+ "du_pck_tp_cd", length));
			String[] cDuCustId = (JSPUtil.getParameter(request, prefix	+ "c_du_cust_id", length));
			String[] orgPortCd = (JSPUtil.getParameter(request, prefix	+ "org_port_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cOrgCustNm = (JSPUtil.getParameter(request, prefix	+ "c_org_cust_nm", length));
			String[] tareWgt = (JSPUtil.getParameter(request, prefix	+ "tare_wgt", length));
			String[] duCntrSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "du_cntr_svc_tp_cd", length));
			String[] cCustCntCd = (JSPUtil.getParameter(request, prefix	+ "c_cust_cnt_cd", length));
			String[] orgSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "org_skd_voy_no", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] sOrgCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_org_cust_addr", length));
			String[] orgVslCd = (JSPUtil.getParameter(request, prefix	+ "org_vsl_cd", length));
			String[] duTrdCd = (JSPUtil.getParameter(request, prefix	+ "du_trd_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] cOrgCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_org_cust_addr", length));
			String[] orgSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "org_skd_dir_cd", length));
			String[] nCustCntCd = (JSPUtil.getParameter(request, prefix	+ "n_cust_cnt_cd", length));
			String[] duCgoCd = (JSPUtil.getParameter(request, prefix	+ "du_cgo_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] duRotnNo = (JSPUtil.getParameter(request, prefix	+ "du_rotn_no", length));
			String[] sCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_cust_addr", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] duMfNo = (JSPUtil.getParameter(request, prefix	+ "du_mf_no", length));
			String[] duPckDesc = (JSPUtil.getParameter(request, prefix	+ "du_pck_desc", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] nDuCustId = (JSPUtil.getParameter(request, prefix	+ "n_du_cust_id", length));
			String[] sOrgCustNm = (JSPUtil.getParameter(request, prefix	+ "s_org_cust_nm", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pltQty = (JSPUtil.getParameter(request, prefix	+ "plt_qty", length));
			String[] duVoyAgnId = (JSPUtil.getParameter(request, prefix	+ "du_voy_agn_id", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] duTsModCd = (JSPUtil.getParameter(request, prefix	+ "du_ts_mod_cd", length));
			String[] orgBlNo = (JSPUtil.getParameter(request, prefix	+ "org_bl_no", length));
			String[] duCmdtCd = (JSPUtil.getParameter(request, prefix	+ "du_cmdt_cd", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] duLineId = (JSPUtil.getParameter(request, prefix	+ "du_line_id", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] duTtlQty = (JSPUtil.getParameter(request, prefix	+ "du_ttl_qty", length));
			String[] orgVslNm = (JSPUtil.getParameter(request, prefix	+ "org_vsl_nm", length));
			String[] duFrtWgt = (JSPUtil.getParameter(request, prefix	+ "du_frt_wgt", length));
			String[] orgCntCd = (JSPUtil.getParameter(request, prefix	+ "org_cnt_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_knt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DubaiBlInfoVO();
				if (mkNoCtnt[i] != null)
					model.setMkNoCtnt(mkNoCtnt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cnslCgoFlg[i] != null)
					model.setCnslCgoFlg(cnslCgoFlg[i]);
				if (duPckTpCd[i] != null)
					model.setDuPckTpCd(duPckTpCd[i]);
				if (cDuCustId[i] != null)
					model.setCDuCustId(cDuCustId[i]);
				if (orgPortCd[i] != null)
					model.setOrgPortCd(orgPortCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cOrgCustNm[i] != null)
					model.setCOrgCustNm(cOrgCustNm[i]);
				if (tareWgt[i] != null)
					model.setTareWgt(tareWgt[i]);
				if (duCntrSvcTpCd[i] != null)
					model.setDuCntrSvcTpCd(duCntrSvcTpCd[i]);
				if (cCustCntCd[i] != null)
					model.setCCustCntCd(cCustCntCd[i]);
				if (orgSkdVoyNo[i] != null)
					model.setOrgSkdVoyNo(orgSkdVoyNo[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (sOrgCustAddr[i] != null)
					model.setSOrgCustAddr(sOrgCustAddr[i]);
				if (orgVslCd[i] != null)
					model.setOrgVslCd(orgVslCd[i]);
				if (duTrdCd[i] != null)
					model.setDuTrdCd(duTrdCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (cOrgCustAddr[i] != null)
					model.setCOrgCustAddr(cOrgCustAddr[i]);
				if (orgSkdDirCd[i] != null)
					model.setOrgSkdDirCd(orgSkdDirCd[i]);
				if (nCustCntCd[i] != null)
					model.setNCustCntCd(nCustCntCd[i]);
				if (duCgoCd[i] != null)
					model.setDuCgoCd(duCgoCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (duRotnNo[i] != null)
					model.setDuRotnNo(duRotnNo[i]);
				if (sCustAddr[i] != null)
					model.setSCustAddr(sCustAddr[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (duMfNo[i] != null)
					model.setDuMfNo(duMfNo[i]);
				if (duPckDesc[i] != null)
					model.setDuPckDesc(duPckDesc[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (nDuCustId[i] != null)
					model.setNDuCustId(nDuCustId[i]);
				if (sOrgCustNm[i] != null)
					model.setSOrgCustNm(sOrgCustNm[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pltQty[i] != null)
					model.setPltQty(pltQty[i]);
				if (duVoyAgnId[i] != null)
					model.setDuVoyAgnId(duVoyAgnId[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (duTsModCd[i] != null)
					model.setDuTsModCd(duTsModCd[i]);
				if (orgBlNo[i] != null)
					model.setOrgBlNo(orgBlNo[i]);
				if (duCmdtCd[i] != null)
					model.setDuCmdtCd(duCmdtCd[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (duLineId[i] != null)
					model.setDuLineId(duLineId[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (duTtlQty[i] != null)
					model.setDuTtlQty(duTtlQty[i]);
				if (orgVslNm[i] != null)
					model.setOrgVslNm(orgVslNm[i]);
				if (duFrtWgt[i] != null)
					model.setDuFrtWgt(duFrtWgt[i]);
				if (orgCntCd[i] != null)
					model.setOrgCntCd(orgCntCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrKnt[i] != null)
					model.setCntrKnt(cntrKnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDubaiBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DubaiBlInfoVO[]
	 */
	public DubaiBlInfoVO[] getDubaiBlInfoVOs(){
		DubaiBlInfoVO[] vos = (DubaiBlInfoVO[])models.toArray(new DubaiBlInfoVO[models.size()]);
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
		this.mkNoCtnt = this.mkNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnslCgoFlg = this.cnslCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duPckTpCd = this.duPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cDuCustId = this.cDuCustId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPortCd = this.orgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cOrgCustNm = this.cOrgCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt = this.tareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duCntrSvcTpCd = this.duCntrSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustCntCd = this.cCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSkdVoyNo = this.orgSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOrgCustAddr = this.sOrgCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVslCd = this.orgVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duTrdCd = this.duTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cOrgCustAddr = this.cOrgCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSkdDirCd = this.orgSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustCntCd = this.nCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duCgoCd = this.duCgoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duRotnNo = this.duRotnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustAddr = this.sCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duMfNo = this.duMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duPckDesc = this.duPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nDuCustId = this.nDuCustId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOrgCustNm = this.sOrgCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltQty = this.pltQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duVoyAgnId = this.duVoyAgnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duTsModCd = this.duTsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBlNo = this.orgBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duCmdtCd = this.duCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duLineId = this.duLineId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duTtlQty = this.duTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVslNm = this.orgVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duFrtWgt = this.duFrtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntCd = this.orgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrKnt = this.cntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
