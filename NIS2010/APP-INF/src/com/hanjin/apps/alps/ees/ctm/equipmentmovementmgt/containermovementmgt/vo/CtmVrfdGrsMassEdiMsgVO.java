/**
 *Copyright(c) 2016 CyberLogitec
 *@FileName : CtmVrfdGrsMassEdiMsgVO.java
 *@FileTitle : CtmVrfdGrsMassEdiMsgVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.11
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.07.11 김상현 1.0 Creation
 */

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * Table Value Object.
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtmVrfdGrsMassEdiMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CtmVrfdGrsMassEdiMsgVO> models = new ArrayList<CtmVrfdGrsMassEdiMsgVO>();
	
	/* Column Info */
	private String ptyCntCd = null;
	/* Column Info */
	private String ptyPsonNm = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String ptyCtyCtnt = null;
	/* Column Info */
	private String smtAddr = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vgmVrfyDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String smtCntcEml = null;
	/* Column Info */
	private String smtCtyCtnt = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String smtCntcDtlCtnt = null;
	/* Column Info */
	private String porYdCd = null;
	/* Column Info */
	private String porNm = null;
	/* Column Info */
	private String cmmcCntcPhnCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String siRefNo = null;
	/* Column Info */
	private String vgmId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String smtNm = null;
	/* Column Info */
	private String refNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String docId = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vgmDtmnDt = null;
	/* Column Info */
	private String smtCntcPhnCtnt = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String vslLloydNo = null;
	/* Column Info */
	private String ptySteCtnt = null;
	/* Column Info */
	private String cmmcCntcEml = null;
	/* Column Info */
	private String vrfdWgtCd = null;
	/* Column Info */
	private String cmmcCntcFaxCtnt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vgmWgtQty = null;
	/* Column Info */
	private String smtZipCtnt = null;
	/* Column Info */
	private String smtSteCtnt = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String trspCtrlNoCtnt = null;
	/* Column Info */
	private String sealNoCtnt = null;
	/* Column Info */
	private String ptyAddr = null;
	/* Column Info */
	private String smtCntCd = null;
	/* Column Info */
	private String ptyNm = null;
	/* Column Info */
	private String cutOffDt = null;
	/* Column Info */
	private String funcCd = null;
	/* Column Info */
	private String ptyFuncCd = null;
	/* Column Info */
	private String ptyZipCtnt = null;
	/* Column Info */
	private String cntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CtmVrfdGrsMassEdiMsgVO() {}

	public CtmVrfdGrsMassEdiMsgVO(String ibflag, String pagerows, String refNo, String cntrNo, String cntrTpszCd, String vgmId, String funcCd, String issDt, String cutOffDt, String porNm, String porCd, String porYdCd, String polNm, String polCd, String polYdCd, String smtNm, String smtAddr, String smtCtyCtnt, String smtSteCtnt, String smtZipCtnt, String smtCntCd, String smtCntcDtlCtnt, String smtCntcEml, String smtCntcPhnCtnt, String vslCd, String skdVoyNo, String skdDirCd, String vslNm, String vslLloydNo, String bkgRefNo, String siRefNo, String bkgNo, String trspCtrlNoCtnt, String vgmWgtQty, String vrfdWgtCd, String vgmMzdTpCd, String docId, String vgmDtmnDt, String vgmVrfyDt, String sealNoCtnt, String ptyFuncCd, String ptyNm, String ptyAddr, String ptyCtyCtnt, String ptySteCtnt, String ptyZipCtnt, String ptyCntCd, String ptyPsonNm, String cmmcCntcPhnCtnt, String cmmcCntcEml, String cmmcCntcFaxCtnt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ptyCntCd = ptyCntCd;
		this.ptyPsonNm = ptyPsonNm;
		this.issDt = issDt;
		this.ptyCtyCtnt = ptyCtyCtnt;
		this.smtAddr = smtAddr;
		this.polYdCd = polYdCd;
		this.bkgNo = bkgNo;
		this.updUsrId = updUsrId;
		this.vgmVrfyDt = vgmVrfyDt;
		this.pagerows = pagerows;
		this.smtCntcEml = smtCntcEml;
		this.smtCtyCtnt = smtCtyCtnt;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.vslCd = vslCd;
		this.smtCntcDtlCtnt = smtCntcDtlCtnt;
		this.porYdCd = porYdCd;
		this.porNm = porNm;
		this.cmmcCntcPhnCtnt = cmmcCntcPhnCtnt;
		this.creDt = creDt;
		this.polNm = polNm;
		this.siRefNo = siRefNo;
		this.vgmId = vgmId;
		this.cntrTpszCd = cntrTpszCd;
		this.updDt = updDt;
		this.smtNm = smtNm;
		this.refNo = refNo;
		this.ibflag = ibflag;
		this.docId = docId;
		this.porCd = porCd;
		this.creUsrId = creUsrId;
		this.polCd = polCd;
		this.skdDirCd = skdDirCd;
		this.vgmDtmnDt = vgmDtmnDt;
		this.smtCntcPhnCtnt = smtCntcPhnCtnt;
		this.vslNm = vslNm;
		this.vslLloydNo = vslLloydNo;
		this.ptySteCtnt = ptySteCtnt;
		this.cmmcCntcEml = cmmcCntcEml;
		this.vrfdWgtCd = vrfdWgtCd;
		this.cmmcCntcFaxCtnt = cmmcCntcFaxCtnt;
		this.skdVoyNo = skdVoyNo;
		this.vgmWgtQty = vgmWgtQty;
		this.smtZipCtnt = smtZipCtnt;
		this.smtSteCtnt = smtSteCtnt;
		this.bkgRefNo = bkgRefNo;
		this.trspCtrlNoCtnt = trspCtrlNoCtnt;
		this.sealNoCtnt = sealNoCtnt;
		this.ptyAddr = ptyAddr;
		this.smtCntCd = smtCntCd;
		this.ptyNm = ptyNm;
		this.cutOffDt = cutOffDt;
		this.funcCd = funcCd;
		this.ptyFuncCd = ptyFuncCd;
		this.ptyZipCtnt = ptyZipCtnt;
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pty_cnt_cd", getPtyCntCd());
		this.hashColumns.put("pty_pson_nm", getPtyPsonNm());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("pty_cty_ctnt", getPtyCtyCtnt());
		this.hashColumns.put("smt_addr", getSmtAddr());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vgm_vrfy_dt", getVgmVrfyDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("smt_cntc_eml", getSmtCntcEml());
		this.hashColumns.put("smt_cty_ctnt", getSmtCtyCtnt());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("smt_cntc_dtl_ctnt", getSmtCntcDtlCtnt());
		this.hashColumns.put("por_yd_cd", getPorYdCd());
		this.hashColumns.put("por_nm", getPorNm());
		this.hashColumns.put("cmmc_cntc_phn_ctnt", getCmmcCntcPhnCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("si_ref_no", getSiRefNo());
		this.hashColumns.put("vgm_id", getVgmId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("smt_nm", getSmtNm());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("doc_id", getDocId());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vgm_dtmn_dt", getVgmDtmnDt());
		this.hashColumns.put("smt_cntc_phn_ctnt", getSmtCntcPhnCtnt());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("vsl_lloyd_no", getVslLloydNo());
		this.hashColumns.put("pty_ste_ctnt", getPtySteCtnt());
		this.hashColumns.put("cmmc_cntc_eml", getCmmcCntcEml());
		this.hashColumns.put("vrfd_wgt_cd", getVrfdWgtCd());
		this.hashColumns.put("cmmc_cntc_fax_ctnt", getCmmcCntcFaxCtnt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vgm_wgt_qty", getVgmWgtQty());
		this.hashColumns.put("smt_zip_ctnt", getSmtZipCtnt());
		this.hashColumns.put("smt_ste_ctnt", getSmtSteCtnt());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("trsp_ctrl_no_ctnt", getTrspCtrlNoCtnt());
		this.hashColumns.put("seal_no_ctnt", getSealNoCtnt());
		this.hashColumns.put("pty_addr", getPtyAddr());
		this.hashColumns.put("smt_cnt_cd", getSmtCntCd());
		this.hashColumns.put("pty_nm", getPtyNm());
		this.hashColumns.put("cut_off_dt", getCutOffDt());
		this.hashColumns.put("func_cd", getFuncCd());
		this.hashColumns.put("pty_func_cd", getPtyFuncCd());
		this.hashColumns.put("pty_zip_ctnt", getPtyZipCtnt());
		this.hashColumns.put("cntr_no", getCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pty_cnt_cd", "ptyCntCd");
		this.hashFields.put("pty_pson_nm", "ptyPsonNm");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("pty_cty_ctnt", "ptyCtyCtnt");
		this.hashFields.put("smt_addr", "smtAddr");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vgm_vrfy_dt", "vgmVrfyDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("smt_cntc_eml", "smtCntcEml");
		this.hashFields.put("smt_cty_ctnt", "smtCtyCtnt");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("smt_cntc_dtl_ctnt", "smtCntcDtlCtnt");
		this.hashFields.put("por_yd_cd", "porYdCd");
		this.hashFields.put("por_nm", "porNm");
		this.hashFields.put("cmmc_cntc_phn_ctnt", "cmmcCntcPhnCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("si_ref_no", "siRefNo");
		this.hashFields.put("vgm_id", "vgmId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("smt_nm", "smtNm");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("doc_id", "docId");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vgm_dtmn_dt", "vgmDtmnDt");
		this.hashFields.put("smt_cntc_phn_ctnt", "smtCntcPhnCtnt");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("vsl_lloyd_no", "vslLloydNo");
		this.hashFields.put("pty_ste_ctnt", "ptySteCtnt");
		this.hashFields.put("cmmc_cntc_eml", "cmmcCntcEml");
		this.hashFields.put("vrfd_wgt_cd", "vrfdWgtCd");
		this.hashFields.put("cmmc_cntc_fax_ctnt", "cmmcCntcFaxCtnt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vgm_wgt_qty", "vgmWgtQty");
		this.hashFields.put("smt_zip_ctnt", "smtZipCtnt");
		this.hashFields.put("smt_ste_ctnt", "smtSteCtnt");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("trsp_ctrl_no_ctnt", "trspCtrlNoCtnt");
		this.hashFields.put("seal_no_ctnt", "sealNoCtnt");
		this.hashFields.put("pty_addr", "ptyAddr");
		this.hashFields.put("smt_cnt_cd", "smtCntCd");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("cut_off_dt", "cutOffDt");
		this.hashFields.put("func_cd", "funcCd");
		this.hashFields.put("pty_func_cd", "ptyFuncCd");
		this.hashFields.put("pty_zip_ctnt", "ptyZipCtnt");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ptyCntCd
	 */
	public String getPtyCntCd() {
		return this.ptyCntCd;
	}
	
	/**
	 * Column Info
	 * @return ptyPsonNm
	 */
	public String getPtyPsonNm() {
		return this.ptyPsonNm;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return ptyCtyCtnt
	 */
	public String getPtyCtyCtnt() {
		return this.ptyCtyCtnt;
	}
	
	/**
	 * Column Info
	 * @return smtAddr
	 */
	public String getSmtAddr() {
		return this.smtAddr;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
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
	 * @return vgmVrfyDt
	 */
	public String getVgmVrfyDt() {
		return this.vgmVrfyDt;
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
	 * @return smtCntcEml
	 */
	public String getSmtCntcEml() {
		return this.smtCntcEml;
	}
	
	/**
	 * Column Info
	 * @return smtCtyCtnt
	 */
	public String getSmtCtyCtnt() {
		return this.smtCtyCtnt;
	}
	
	/**
	 * Column Info
	 * @return vgmMzdTpCd
	 */
	public String getVgmMzdTpCd() {
		return this.vgmMzdTpCd;
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
	 * @return smtCntcDtlCtnt
	 */
	public String getSmtCntcDtlCtnt() {
		return this.smtCntcDtlCtnt;
	}
	
	/**
	 * Column Info
	 * @return porYdCd
	 */
	public String getPorYdCd() {
		return this.porYdCd;
	}
	
	/**
	 * Column Info
	 * @return porNm
	 */
	public String getPorNm() {
		return this.porNm;
	}
	
	/**
	 * Column Info
	 * @return cmmcCntcPhnCtnt
	 */
	public String getCmmcCntcPhnCtnt() {
		return this.cmmcCntcPhnCtnt;
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
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
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
	 * @return vgmId
	 */
	public String getVgmId() {
		return this.vgmId;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return smtNm
	 */
	public String getSmtNm() {
		return this.smtNm;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
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
	 * @return docId
	 */
	public String getDocId() {
		return this.docId;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vgmDtmnDt
	 */
	public String getVgmDtmnDt() {
		return this.vgmDtmnDt;
	}
	
	/**
	 * Column Info
	 * @return smtCntcPhnCtnt
	 */
	public String getSmtCntcPhnCtnt() {
		return this.smtCntcPhnCtnt;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return vslLloydNo
	 */
	public String getVslLloydNo() {
		return this.vslLloydNo;
	}
	
	/**
	 * Column Info
	 * @return ptySteCtnt
	 */
	public String getPtySteCtnt() {
		return this.ptySteCtnt;
	}
	
	/**
	 * Column Info
	 * @return cmmcCntcEml
	 */
	public String getCmmcCntcEml() {
		return this.cmmcCntcEml;
	}
	
	/**
	 * Column Info
	 * @return vrfdWgtCd
	 */
	public String getVrfdWgtCd() {
		return this.vrfdWgtCd;
	}
	
	/**
	 * Column Info
	 * @return cmmcCntcFaxCtnt
	 */
	public String getCmmcCntcFaxCtnt() {
		return this.cmmcCntcFaxCtnt;
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
	 * @return vgmWgtQty
	 */
	public String getVgmWgtQty() {
		return this.vgmWgtQty;
	}
	
	/**
	 * Column Info
	 * @return smtZipCtnt
	 */
	public String getSmtZipCtnt() {
		return this.smtZipCtnt;
	}
	
	/**
	 * Column Info
	 * @return smtSteCtnt
	 */
	public String getSmtSteCtnt() {
		return this.smtSteCtnt;
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
	 * @return trspCtrlNoCtnt
	 */
	public String getTrspCtrlNoCtnt() {
		return this.trspCtrlNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return sealNoCtnt
	 */
	public String getSealNoCtnt() {
		return this.sealNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return ptyAddr
	 */
	public String getPtyAddr() {
		return this.ptyAddr;
	}
	
	/**
	 * Column Info
	 * @return smtCntCd
	 */
	public String getSmtCntCd() {
		return this.smtCntCd;
	}
	
	/**
	 * Column Info
	 * @return ptyNm
	 */
	public String getPtyNm() {
		return this.ptyNm;
	}
	
	/**
	 * Column Info
	 * @return cutOffDt
	 */
	public String getCutOffDt() {
		return this.cutOffDt;
	}
	
	/**
	 * Column Info
	 * @return funcCd
	 */
	public String getFuncCd() {
		return this.funcCd;
	}
	
	/**
	 * Column Info
	 * @return ptyFuncCd
	 */
	public String getPtyFuncCd() {
		return this.ptyFuncCd;
	}
	
	/**
	 * Column Info
	 * @return ptyZipCtnt
	 */
	public String getPtyZipCtnt() {
		return this.ptyZipCtnt;
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
	 * @param ptyCntCd
	 */
	public void setPtyCntCd(String ptyCntCd) {
		this.ptyCntCd = ptyCntCd;
	}
	
	/**
	 * Column Info
	 * @param ptyPsonNm
	 */
	public void setPtyPsonNm(String ptyPsonNm) {
		this.ptyPsonNm = ptyPsonNm;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param ptyCtyCtnt
	 */
	public void setPtyCtyCtnt(String ptyCtyCtnt) {
		this.ptyCtyCtnt = ptyCtyCtnt;
	}
	
	/**
	 * Column Info
	 * @param smtAddr
	 */
	public void setSmtAddr(String smtAddr) {
		this.smtAddr = smtAddr;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
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
	 * @param vgmVrfyDt
	 */
	public void setVgmVrfyDt(String vgmVrfyDt) {
		this.vgmVrfyDt = vgmVrfyDt;
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
	 * @param smtCntcEml
	 */
	public void setSmtCntcEml(String smtCntcEml) {
		this.smtCntcEml = smtCntcEml;
	}
	
	/**
	 * Column Info
	 * @param smtCtyCtnt
	 */
	public void setSmtCtyCtnt(String smtCtyCtnt) {
		this.smtCtyCtnt = smtCtyCtnt;
	}
	
	/**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
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
	 * @param smtCntcDtlCtnt
	 */
	public void setSmtCntcDtlCtnt(String smtCntcDtlCtnt) {
		this.smtCntcDtlCtnt = smtCntcDtlCtnt;
	}
	
	/**
	 * Column Info
	 * @param porYdCd
	 */
	public void setPorYdCd(String porYdCd) {
		this.porYdCd = porYdCd;
	}
	
	/**
	 * Column Info
	 * @param porNm
	 */
	public void setPorNm(String porNm) {
		this.porNm = porNm;
	}
	
	/**
	 * Column Info
	 * @param cmmcCntcPhnCtnt
	 */
	public void setCmmcCntcPhnCtnt(String cmmcCntcPhnCtnt) {
		this.cmmcCntcPhnCtnt = cmmcCntcPhnCtnt;
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
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
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
	 * @param vgmId
	 */
	public void setVgmId(String vgmId) {
		this.vgmId = vgmId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param smtNm
	 */
	public void setSmtNm(String smtNm) {
		this.smtNm = smtNm;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
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
	 * @param docId
	 */
	public void setDocId(String docId) {
		this.docId = docId;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vgmDtmnDt
	 */
	public void setVgmDtmnDt(String vgmDtmnDt) {
		this.vgmDtmnDt = vgmDtmnDt;
	}
	
	/**
	 * Column Info
	 * @param smtCntcPhnCtnt
	 */
	public void setSmtCntcPhnCtnt(String smtCntcPhnCtnt) {
		this.smtCntcPhnCtnt = smtCntcPhnCtnt;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param vslLloydNo
	 */
	public void setVslLloydNo(String vslLloydNo) {
		this.vslLloydNo = vslLloydNo;
	}
	
	/**
	 * Column Info
	 * @param ptySteCtnt
	 */
	public void setPtySteCtnt(String ptySteCtnt) {
		this.ptySteCtnt = ptySteCtnt;
	}
	
	/**
	 * Column Info
	 * @param cmmcCntcEml
	 */
	public void setCmmcCntcEml(String cmmcCntcEml) {
		this.cmmcCntcEml = cmmcCntcEml;
	}
	
	/**
	 * Column Info
	 * @param vrfdWgtCd
	 */
	public void setVrfdWgtCd(String vrfdWgtCd) {
		this.vrfdWgtCd = vrfdWgtCd;
	}
	
	/**
	 * Column Info
	 * @param cmmcCntcFaxCtnt
	 */
	public void setCmmcCntcFaxCtnt(String cmmcCntcFaxCtnt) {
		this.cmmcCntcFaxCtnt = cmmcCntcFaxCtnt;
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
	 * @param vgmWgtQty
	 */
	public void setVgmWgtQty(String vgmWgtQty) {
		this.vgmWgtQty = vgmWgtQty;
	}
	
	/**
	 * Column Info
	 * @param smtZipCtnt
	 */
	public void setSmtZipCtnt(String smtZipCtnt) {
		this.smtZipCtnt = smtZipCtnt;
	}
	
	/**
	 * Column Info
	 * @param smtSteCtnt
	 */
	public void setSmtSteCtnt(String smtSteCtnt) {
		this.smtSteCtnt = smtSteCtnt;
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
	 * @param trspCtrlNoCtnt
	 */
	public void setTrspCtrlNoCtnt(String trspCtrlNoCtnt) {
		this.trspCtrlNoCtnt = trspCtrlNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param sealNoCtnt
	 */
	public void setSealNoCtnt(String sealNoCtnt) {
		this.sealNoCtnt = sealNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param ptyAddr
	 */
	public void setPtyAddr(String ptyAddr) {
		this.ptyAddr = ptyAddr;
	}
	
	/**
	 * Column Info
	 * @param smtCntCd
	 */
	public void setSmtCntCd(String smtCntCd) {
		this.smtCntCd = smtCntCd;
	}
	
	/**
	 * Column Info
	 * @param ptyNm
	 */
	public void setPtyNm(String ptyNm) {
		this.ptyNm = ptyNm;
	}
	
	/**
	 * Column Info
	 * @param cutOffDt
	 */
	public void setCutOffDt(String cutOffDt) {
		this.cutOffDt = cutOffDt;
	}
	
	/**
	 * Column Info
	 * @param funcCd
	 */
	public void setFuncCd(String funcCd) {
		this.funcCd = funcCd;
	}
	
	/**
	 * Column Info
	 * @param ptyFuncCd
	 */
	public void setPtyFuncCd(String ptyFuncCd) {
		this.ptyFuncCd = ptyFuncCd;
	}
	
	/**
	 * Column Info
	 * @param ptyZipCtnt
	 */
	public void setPtyZipCtnt(String ptyZipCtnt) {
		this.ptyZipCtnt = ptyZipCtnt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setPtyCntCd(JSPUtil.getParameter(request, prefix + "pty_cnt_cd", ""));
		setPtyPsonNm(JSPUtil.getParameter(request, prefix + "pty_pson_nm", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setPtyCtyCtnt(JSPUtil.getParameter(request, prefix + "pty_cty_ctnt", ""));
		setSmtAddr(JSPUtil.getParameter(request, prefix + "smt_addr", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSmtCntcEml(JSPUtil.getParameter(request, prefix + "smt_cntc_eml", ""));
		setSmtCtyCtnt(JSPUtil.getParameter(request, prefix + "smt_cty_ctnt", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSmtCntcDtlCtnt(JSPUtil.getParameter(request, prefix + "smt_cntc_dtl_ctnt", ""));
		setPorYdCd(JSPUtil.getParameter(request, prefix + "por_yd_cd", ""));
		setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
		setCmmcCntcPhnCtnt(JSPUtil.getParameter(request, prefix + "cmmc_cntc_phn_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setSiRefNo(JSPUtil.getParameter(request, prefix + "si_ref_no", ""));
		setVgmId(JSPUtil.getParameter(request, prefix + "vgm_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSmtNm(JSPUtil.getParameter(request, prefix + "smt_nm", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDocId(JSPUtil.getParameter(request, prefix + "doc_id", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVgmDtmnDt(JSPUtil.getParameter(request, prefix + "vgm_dtmn_dt", ""));
		setSmtCntcPhnCtnt(JSPUtil.getParameter(request, prefix + "smt_cntc_phn_ctnt", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setVslLloydNo(JSPUtil.getParameter(request, prefix + "vsl_lloyd_no", ""));
		setPtySteCtnt(JSPUtil.getParameter(request, prefix + "pty_ste_ctnt", ""));
		setCmmcCntcEml(JSPUtil.getParameter(request, prefix + "cmmc_cntc_eml", ""));
		setVrfdWgtCd(JSPUtil.getParameter(request, prefix + "vrfd_wgt_cd", ""));
		setCmmcCntcFaxCtnt(JSPUtil.getParameter(request, prefix + "cmmc_cntc_fax_ctnt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVgmWgtQty(JSPUtil.getParameter(request, prefix + "vgm_wgt_qty", ""));
		setSmtZipCtnt(JSPUtil.getParameter(request, prefix + "smt_zip_ctnt", ""));
		setSmtSteCtnt(JSPUtil.getParameter(request, prefix + "smt_ste_ctnt", ""));
		setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
		setTrspCtrlNoCtnt(JSPUtil.getParameter(request, prefix + "trsp_ctrl_no_ctnt", ""));
		setSealNoCtnt(JSPUtil.getParameter(request, prefix + "seal_no_ctnt", ""));
		setPtyAddr(JSPUtil.getParameter(request, prefix + "pty_addr", ""));
		setSmtCntCd(JSPUtil.getParameter(request, prefix + "smt_cnt_cd", ""));
		setPtyNm(JSPUtil.getParameter(request, prefix + "pty_nm", ""));
		setCutOffDt(JSPUtil.getParameter(request, prefix + "cut_off_dt", ""));
		setFuncCd(JSPUtil.getParameter(request, prefix + "func_cd", ""));
		setPtyFuncCd(JSPUtil.getParameter(request, prefix + "pty_func_cd", ""));
		setPtyZipCtnt(JSPUtil.getParameter(request, prefix + "pty_zip_ctnt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmVrfdGrsMassEdiMsgVO[]
	 */
	public CtmVrfdGrsMassEdiMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CtmVrfdGrsMassEdiMsgVO[]
	 */
	public CtmVrfdGrsMassEdiMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmVrfdGrsMassEdiMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ptyCntCd = (JSPUtil.getParameter(request, prefix	+ "pty_cnt_cd", length));
			String[] ptyPsonNm = (JSPUtil.getParameter(request, prefix	+ "pty_pson_nm", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ptyCtyCtnt = (JSPUtil.getParameter(request, prefix	+ "pty_cty_ctnt", length));
			String[] smtAddr = (JSPUtil.getParameter(request, prefix	+ "smt_addr", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vgmVrfyDt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] smtCntcEml = (JSPUtil.getParameter(request, prefix	+ "smt_cntc_eml", length));
			String[] smtCtyCtnt = (JSPUtil.getParameter(request, prefix	+ "smt_cty_ctnt", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] smtCntcDtlCtnt = (JSPUtil.getParameter(request, prefix	+ "smt_cntc_dtl_ctnt", length));
			String[] porYdCd = (JSPUtil.getParameter(request, prefix	+ "por_yd_cd", length));
			String[] porNm = (JSPUtil.getParameter(request, prefix	+ "por_nm", length));
			String[] cmmcCntcPhnCtnt = (JSPUtil.getParameter(request, prefix	+ "cmmc_cntc_phn_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] siRefNo = (JSPUtil.getParameter(request, prefix	+ "si_ref_no", length));
			String[] vgmId = (JSPUtil.getParameter(request, prefix	+ "vgm_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] smtNm = (JSPUtil.getParameter(request, prefix	+ "smt_nm", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] docId = (JSPUtil.getParameter(request, prefix	+ "doc_id", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vgmDtmnDt = (JSPUtil.getParameter(request, prefix	+ "vgm_dtmn_dt", length));
			String[] smtCntcPhnCtnt = (JSPUtil.getParameter(request, prefix	+ "smt_cntc_phn_ctnt", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] vslLloydNo = (JSPUtil.getParameter(request, prefix	+ "vsl_lloyd_no", length));
			String[] ptySteCtnt = (JSPUtil.getParameter(request, prefix	+ "pty_ste_ctnt", length));
			String[] cmmcCntcEml = (JSPUtil.getParameter(request, prefix	+ "cmmc_cntc_eml", length));
			String[] vrfdWgtCd = (JSPUtil.getParameter(request, prefix	+ "vrfd_wgt_cd", length));
			String[] cmmcCntcFaxCtnt = (JSPUtil.getParameter(request, prefix	+ "cmmc_cntc_fax_ctnt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vgmWgtQty = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_qty", length));
			String[] smtZipCtnt = (JSPUtil.getParameter(request, prefix	+ "smt_zip_ctnt", length));
			String[] smtSteCtnt = (JSPUtil.getParameter(request, prefix	+ "smt_ste_ctnt", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] trspCtrlNoCtnt = (JSPUtil.getParameter(request, prefix	+ "trsp_ctrl_no_ctnt", length));
			String[] sealNoCtnt = (JSPUtil.getParameter(request, prefix	+ "seal_no_ctnt", length));
			String[] ptyAddr = (JSPUtil.getParameter(request, prefix	+ "pty_addr", length));
			String[] smtCntCd = (JSPUtil.getParameter(request, prefix	+ "smt_cnt_cd", length));
			String[] ptyNm = (JSPUtil.getParameter(request, prefix	+ "pty_nm", length));
			String[] cutOffDt = (JSPUtil.getParameter(request, prefix	+ "cut_off_dt", length));
			String[] funcCd = (JSPUtil.getParameter(request, prefix	+ "func_cd", length));
			String[] ptyFuncCd = (JSPUtil.getParameter(request, prefix	+ "pty_func_cd", length));
			String[] ptyZipCtnt = (JSPUtil.getParameter(request, prefix	+ "pty_zip_ctnt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CtmVrfdGrsMassEdiMsgVO();
				if (ptyCntCd[i] != null)
					model.setPtyCntCd(ptyCntCd[i]);
				if (ptyPsonNm[i] != null)
					model.setPtyPsonNm(ptyPsonNm[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ptyCtyCtnt[i] != null)
					model.setPtyCtyCtnt(ptyCtyCtnt[i]);
				if (smtAddr[i] != null)
					model.setSmtAddr(smtAddr[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vgmVrfyDt[i] != null)
					model.setVgmVrfyDt(vgmVrfyDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (smtCntcEml[i] != null)
					model.setSmtCntcEml(smtCntcEml[i]);
				if (smtCtyCtnt[i] != null)
					model.setSmtCtyCtnt(smtCtyCtnt[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (smtCntcDtlCtnt[i] != null)
					model.setSmtCntcDtlCtnt(smtCntcDtlCtnt[i]);
				if (porYdCd[i] != null)
					model.setPorYdCd(porYdCd[i]);
				if (porNm[i] != null)
					model.setPorNm(porNm[i]);
				if (cmmcCntcPhnCtnt[i] != null)
					model.setCmmcCntcPhnCtnt(cmmcCntcPhnCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (siRefNo[i] != null)
					model.setSiRefNo(siRefNo[i]);
				if (vgmId[i] != null)
					model.setVgmId(vgmId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (smtNm[i] != null)
					model.setSmtNm(smtNm[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (docId[i] != null)
					model.setDocId(docId[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vgmDtmnDt[i] != null)
					model.setVgmDtmnDt(vgmDtmnDt[i]);
				if (smtCntcPhnCtnt[i] != null)
					model.setSmtCntcPhnCtnt(smtCntcPhnCtnt[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (vslLloydNo[i] != null)
					model.setVslLloydNo(vslLloydNo[i]);
				if (ptySteCtnt[i] != null)
					model.setPtySteCtnt(ptySteCtnt[i]);
				if (cmmcCntcEml[i] != null)
					model.setCmmcCntcEml(cmmcCntcEml[i]);
				if (vrfdWgtCd[i] != null)
					model.setVrfdWgtCd(vrfdWgtCd[i]);
				if (cmmcCntcFaxCtnt[i] != null)
					model.setCmmcCntcFaxCtnt(cmmcCntcFaxCtnt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vgmWgtQty[i] != null)
					model.setVgmWgtQty(vgmWgtQty[i]);
				if (smtZipCtnt[i] != null)
					model.setSmtZipCtnt(smtZipCtnt[i]);
				if (smtSteCtnt[i] != null)
					model.setSmtSteCtnt(smtSteCtnt[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (trspCtrlNoCtnt[i] != null)
					model.setTrspCtrlNoCtnt(trspCtrlNoCtnt[i]);
				if (sealNoCtnt[i] != null)
					model.setSealNoCtnt(sealNoCtnt[i]);
				if (ptyAddr[i] != null)
					model.setPtyAddr(ptyAddr[i]);
				if (smtCntCd[i] != null)
					model.setSmtCntCd(smtCntCd[i]);
				if (ptyNm[i] != null)
					model.setPtyNm(ptyNm[i]);
				if (cutOffDt[i] != null)
					model.setCutOffDt(cutOffDt[i]);
				if (funcCd[i] != null)
					model.setFuncCd(funcCd[i]);
				if (ptyFuncCd[i] != null)
					model.setPtyFuncCd(ptyFuncCd[i]);
				if (ptyZipCtnt[i] != null)
					model.setPtyZipCtnt(ptyZipCtnt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtmVrfdGrsMassEdiMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmVrfdGrsMassEdiMsgVO[]
	 */
	public CtmVrfdGrsMassEdiMsgVO[] getCtmVrfdGrsMassEdiMsgVOs(){
		CtmVrfdGrsMassEdiMsgVO[] vos = (CtmVrfdGrsMassEdiMsgVO[])models.toArray(new CtmVrfdGrsMassEdiMsgVO[models.size()]);
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
		this.ptyCntCd = this.ptyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyPsonNm = this.ptyPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyCtyCtnt = this.ptyCtyCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtAddr = this.smtAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt = this.vgmVrfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtCntcEml = this.smtCntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtCtyCtnt = this.smtCtyCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtCntcDtlCtnt = this.smtCntcDtlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYdCd = this.porYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNm = this.porNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmmcCntcPhnCtnt = this.cmmcCntcPhnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siRefNo = this.siRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmId = this.vgmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtNm = this.smtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docId = this.docId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDtmnDt = this.vgmDtmnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtCntcPhnCtnt = this.smtCntcPhnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydNo = this.vslLloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptySteCtnt = this.ptySteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmmcCntcEml = this.cmmcCntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrfdWgtCd = this.vrfdWgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmmcCntcFaxCtnt = this.cmmcCntcFaxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtQty = this.vgmWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtZipCtnt = this.smtZipCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtSteCtnt = this.smtSteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCtrlNoCtnt = this.trspCtrlNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNoCtnt = this.sealNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyAddr = this.ptyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtCntCd = this.smtCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm = this.ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cutOffDt = this.cutOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.funcCd = this.funcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyFuncCd = this.ptyFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyZipCtnt = this.ptyZipCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
