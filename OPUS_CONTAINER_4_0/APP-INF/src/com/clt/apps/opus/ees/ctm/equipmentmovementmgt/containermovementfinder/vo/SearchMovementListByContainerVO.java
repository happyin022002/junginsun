/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMovementListByContainerVO.java
*@FileTitle : SearchMovementListByContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.24 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */
public class SearchMovementListByContainerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMovementListByContainerVO> models = new ArrayList<SearchMovementListByContainerVO>();

	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	private String cnmvCycNo = null;
	private String mvmtEdiMsgTpId = null;
	private String cnmvSeq = null;
	private String chssNo = null;
	private String checkDigit = null;
	private String creDt = null;
	private String mvmtTrspModCd = null;
	private String destYdCd = null;
	private String blNo = null;
	private String fcntrFlg = null;
	private String cnmvSplitNo = null;
	private String cntrDmgFlg = null;
	private String dmgFlgDt   =  null;
	private String dmgUnflgDt   =  null;
	private String pDate1 = null;
	private String bkgKnt = null;
	private String vvdCd = null;
	private String pDate2 = null;
	private String usrNm = null;
	private String cntrHngrBarAtchKnt = null;
	private String cntrRfubFlg = null;
	private String updDt = null;
	private String updLoclDt = null;
	private String wblNo = null;
	private String cnmvEvntDt = null;
	private String spclCgoFlg = null;
	private String mvmtCreTpCd = null;
	private String mgstNo = null;
	private String orgYdCd = null;
	private String obCntrFlg = null;
	private String pCntrno = null;
	private String ofcCd = null;
	private String bkgNo = null;
	private String mtyPlnNo = null;
	private String mvmtStsCd = null;
	private String cnmvRmk = null;
	private String creLoclDt = null;
	private String vndrSeq = null;
	private String cntrDispFlg = null;
	private String cntrSealNo = null;
	private String vndrAbbrNm = null;
	private String imdtExtFlg = null;
	private String cnmvYr = null;
	private String cnmvCoCd = null;
	private String pkupNo = null;
	private String cntrHngrRckCd = null;
	private String cntrXchCd = null;	
	private String rstrUsgLblNm = null;
	private String rstrUsgLblNmDesc = null;
	private String rstrUsgLblValDesc = null;
	private String usaEdiCd = null;
	private String cntrStwgPsnCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMovementListByContainerVO() {}

	public SearchMovementListByContainerVO(String ibflag, String pagerows, String cnmvCycNo, String cnmvCoCd, String mvmtStsCd, String mvmtCreTpCd, String orgYdCd, String destYdCd, String cnmvEvntDt, String vvdCd, String bkgKnt, String bkgNo, String mtyPlnNo, String blNo, String fcntrFlg, String obCntrFlg, String mvmtEdiMsgTpId, String bkgCgoTpCd, String cntrDmgFlg, String dmgFlgDt, String dmgUnflgDt, String cntrHngrRckCd, String cntrHngrBarAtchKnt, String cntrDispFlg, String imdtExtFlg, String cntrRfubFlg, String spclCgoFlg, String vndrSeq, String vndrAbbrNm, String rstrUsgLblNm, String mvmtTrspModCd, String chssNo, String mgstNo, String cntrSealNo, String wblNo, String pkupNo, String updLoclDt, String creLoclDt, String updDt, String creDt, String ofcCd, String usrNm, String cnmvRmk, String cnmvYr, String cnmvSeq, String cnmvSplitNo, String pCntrno, String checkDigit, String pDate1, String pDate2, String cntrXchCd, String rstrUsgLblNmDesc, String rstrUsgLblValDesc, String usaEdiCd, String cntrStwgPsnCtnt) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cnmvCycNo = cnmvCycNo;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.cnmvSeq = cnmvSeq;
		this.chssNo = chssNo;
		this.checkDigit = checkDigit;
		this.creDt = creDt;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.destYdCd = destYdCd;
		this.blNo = blNo;
		this.fcntrFlg = fcntrFlg;
		this.pagerows = pagerows;
		this.cnmvSplitNo = cnmvSplitNo;
		this.cntrDmgFlg = cntrDmgFlg;
		this.dmgFlgDt = dmgFlgDt;
		this.dmgUnflgDt = dmgUnflgDt;
		this.pDate1 = pDate1;
		this.ibflag = ibflag;
		this.bkgKnt = bkgKnt;
		this.vvdCd = vvdCd;
		this.pDate2 = pDate2;
		this.usrNm = usrNm;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.cntrRfubFlg = cntrRfubFlg;
		this.updDt = updDt;
		this.updLoclDt = updLoclDt;
		this.wblNo = wblNo;
		this.cnmvEvntDt = cnmvEvntDt;
		this.spclCgoFlg = spclCgoFlg;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.mgstNo = mgstNo;
		this.orgYdCd = orgYdCd;
		this.obCntrFlg = obCntrFlg;
		this.pCntrno = pCntrno;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.mtyPlnNo = mtyPlnNo;
		this.mvmtStsCd = mvmtStsCd;
		this.cnmvRmk = cnmvRmk;
		this.creLoclDt = creLoclDt;
		this.vndrSeq = vndrSeq;
		this.cntrDispFlg = cntrDispFlg;
		this.cntrSealNo = cntrSealNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.imdtExtFlg = imdtExtFlg;
		this.cnmvYr = cnmvYr;
		this.cnmvCoCd = cnmvCoCd;
		this.pkupNo = pkupNo;
		this.cntrHngrRckCd = cntrHngrRckCd;
		this.cntrXchCd = cntrXchCd;
		this.rstrUsgLblNm = rstrUsgLblNm;
		this.rstrUsgLblNmDesc = rstrUsgLblNmDesc;
		this.rstrUsgLblValDesc = rstrUsgLblValDesc;
		this.usaEdiCd = usaEdiCd;
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_knt", getBkgKnt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());
		this.hashColumns.put("rstr_usg_lbl_nm", getRstrUsgLblNm());
		this.hashColumns.put("rstr_usg_lbl_nm_desc", getRstrUsgLblNmDesc());
		this.hashColumns.put("rstr_usg_lbl_val_desc", getRstrUsgLblValDesc());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("cntr_stwg_psn_ctnt", getCntrStwgPsnCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");		
		this.hashFields.put("rstr_usg_lbl_nm", "rstrUsgLblNm");
		this.hashFields.put("rstr_usg_lbl_nm_desc", "rstrUsgLblNmDesc");
		this.hashFields.put("rstr_usg_lbl_val_desc", "rstrUsgLblValDesc");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("cntr_stwg_psn_ctnt", "cntrStwgPsnCtnt");
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
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtTrspModCd
	 */
	public String getMvmtTrspModCd() {
		return this.mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
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
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
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
	 * @return cnmvSplitNo
	 */
	public String getCnmvSplitNo() {
		return this.cnmvSplitNo;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @return dmgFlgDt
	 */
	public String getDmgFlgDt() {
		return this.dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @return dmgUnflgDt
	 */
	public String getDmgUnflgDt() {
		return this.dmgUnflgDt;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return bkgKnt
	 */
	public String getBkgKnt() {
		return this.bkgKnt;
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
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return cntrRfubFlg
	 */
	public String getCntrRfubFlg() {
		return this.cntrRfubFlg;
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
	 * @return updLoclDt
	 */
	public String getUpdLoclDt() {
		return this.updLoclDt;
	}
	
	/**
	 * Column Info
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoFlg
	 */
	public String getSpclCgoFlg() {
		return this.spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
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
	 * @return obCntrFlg
	 */
	public String getObCntrFlg() {
		return this.obCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return pCntrno
	 */
	public String getPCntrno() {
		return this.pCntrno;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return mtyPlnNo
	 */
	public String getMtyPlnNo() {
		return this.mtyPlnNo;
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
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrDispFlg
	 */
	public String getCntrDispFlg() {
		return this.cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
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
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return cnmvCoCd
	 */
	public String getCnmvCoCd() {
		return this.cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}

	/**
	 * Column Info
	 * @return cntrXchCd
	 */
	public String getCntrXchCd() {
		return this.cntrXchCd;
	}	

	/**
	 * Column Info
	 * @return rstrUsgLblNm
	 */
	public String getRstrUsgLblNm() {
		return this.rstrUsgLblNm;
	}

	/**
	 * Column Info
	 * @return usaEdiCd
	 */
	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}

	/**
	 * Column Info
	 * @return cntrStwgPsnCtnt
	 */
	public String getCntrStwgPsnCtnt() {
		return this.cntrStwgPsnCtnt;
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
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtTrspModCd
	 */
	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
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
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
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
	 * @param cnmvSplitNo
	 */
	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
	}
	
	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @param dmgFlgDt
	 */
	public void setDmgFlgDt(String dmgFlgDt) {
		this.dmgFlgDt = dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @param dmgUnflgDt
	 */
	public void setDmgUnflgDt(String dmgUnflgDt) {
		this.dmgUnflgDt = dmgUnflgDt;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param bkgKnt
	 */
	public void setBkgKnt(String bkgKnt) {
		this.bkgKnt = bkgKnt;
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
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param cntrRfubFlg
	 */
	public void setCntrRfubFlg(String cntrRfubFlg) {
		this.cntrRfubFlg = cntrRfubFlg;
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
	 * @param updLoclDt
	 */
	public void setUpdLoclDt(String updLoclDt) {
		this.updLoclDt = updLoclDt;
	}
	
	/**
	 * Column Info
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoFlg
	 */
	public void setSpclCgoFlg(String spclCgoFlg) {
		this.spclCgoFlg = spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
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
	 * @param obCntrFlg
	 */
	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param pCntrno
	 */
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param mtyPlnNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
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
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrDispFlg
	 */
	public void setCntrDispFlg(String cntrDispFlg) {
		this.cntrDispFlg = cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
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
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param cnmvCoCd
	 */
	public void setCnmvCoCd(String cnmvCoCd) {
		this.cnmvCoCd = cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param cntrXchCd
	 */
	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
	}	
	
	/**
	 * Column Info
	 * @param rstrUsgLblNm
	 */
	public void setRstrUsgLblNm(String rstrUsgLblNm) {
		this.rstrUsgLblNm = rstrUsgLblNm;
	}
	
	public String getRstrUsgLblNmDesc() {
		return rstrUsgLblNmDesc;
	}

	public void setRstrUsgLblNmDesc(String rstrUsgLblNmDesc) {
		this.rstrUsgLblNmDesc = rstrUsgLblNmDesc;
	}

	public String getRstrUsgLblValDesc() {
		return rstrUsgLblValDesc;
	}

	public void setRstrUsgLblValDesc(String rstrUsgLblValDesc) {
		this.rstrUsgLblValDesc = rstrUsgLblValDesc;
	}
	
	/**
	 * Column Info
	 * @param usaEdiCd
	 */
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStwgPsnCtnt
	 */
	public void setCntrStwgPsnCtnt(String cntrStwgPsnCtnt) {
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, "mvmt_edi_msg_tp_id", ""));
		setCnmvSeq(JSPUtil.getParameter(request, "cnmv_seq", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setCheckDigit(JSPUtil.getParameter(request, "check_digit", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, "mvmt_trsp_mod_cd", ""));
		setDestYdCd(JSPUtil.getParameter(request, "dest_yd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setFcntrFlg(JSPUtil.getParameter(request, "fcntr_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, "cnmv_split_no", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, "cntr_dmg_flg", ""));
		setDmgFlgDt(JSPUtil.getParameter(request, "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request, "dmg_unflg_dt", ""));
		setPDate1(JSPUtil.getParameter(request, "p_date1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgKnt(JSPUtil.getParameter(request, "bkg_knt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPDate2(JSPUtil.getParameter(request, "p_date2", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, "cntr_hngr_bar_atch_knt", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request, "cntr_rfub_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, "upd_locl_dt", ""));
		setWblNo(JSPUtil.getParameter(request, "wbl_no", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, "spcl_cgo_flg", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, "mvmt_cre_tp_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, "mgst_no", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setObCntrFlg(JSPUtil.getParameter(request, "ob_cntr_flg", ""));
		setPCntrno(JSPUtil.getParameter(request, "p_cntrno", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, "mty_pln_no", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setCnmvRmk(JSPUtil.getParameter(request, "cnmv_rmk", ""));
		setCreLoclDt(JSPUtil.getParameter(request, "cre_locl_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntrDispFlg(JSPUtil.getParameter(request, "cntr_disp_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, "cnmv_co_cd", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, "cntr_hngr_rck_cd", ""));
		setCntrXchCd(JSPUtil.getParameter(request, "cntr_xch_cd", ""));
		setRstrUsgLblNm(JSPUtil.getParameter(request, "rstr_usg_lbl_nm", ""));
		setRstrUsgLblNmDesc(JSPUtil.getParameter(request, "rstr_usg_lbl_nm_desc", ""));
		setRstrUsgLblValDesc(JSPUtil.getParameter(request, "rstr_usg_lbl_val_desc", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, "usa_edi_cd", ""));
		setCntrStwgPsnCtnt(JSPUtil.getParameter(request, "cntr_stwg_psn_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMovementListByContainerVO[]
	 */
	public SearchMovementListByContainerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMovementListByContainerVO[]
	 */
	public SearchMovementListByContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMovementListByContainerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] dmgFlgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_flg_dt", length));
			String[] dmgUnflgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_unflg_dt", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgKnt = (JSPUtil.getParameter(request, prefix	+ "bkg_knt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] cntrRfubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_rfub_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrDispFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_disp_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			String[] cntrXchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_cd", length));
			String[] rstrUsgLblNm = (JSPUtil.getParameter(request, prefix	+ "rstr_usg_lbl_nm", length));
			String[] rstrUsgLblNmDesc = (JSPUtil.getParameter(request, prefix	+ "rstr_usg_lbl_nm_desc", length));
			String[] rstrUsgLblValDesc = (JSPUtil.getParameter(request, prefix	+ "rstr_usg_lbl_val_desc", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] cntrStwgPsnCtnt = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_psn_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMovementListByContainerVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (dmgFlgDt[i] != null)
					model.setDmgFlgDt(dmgFlgDt[i]);
				if (dmgUnflgDt[i] != null)
					model.setDmgUnflgDt(dmgUnflgDt[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgKnt[i] != null)
					model.setBkgKnt(bkgKnt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (cntrRfubFlg[i] != null)
					model.setCntrRfubFlg(cntrRfubFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrDispFlg[i] != null)
					model.setCntrDispFlg(cntrDispFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				if (cntrXchCd[i] != null)
					model.setCntrXchCd(cntrXchCd[i]);
				if (rstrUsgLblNm[i] != null)
					model.setRstrUsgLblNm(rstrUsgLblNm[i]);
				if (rstrUsgLblNmDesc[i] != null)
					model.setRstrUsgLblNmDesc(rstrUsgLblNmDesc[i]);
				if (rstrUsgLblValDesc[i] != null)
					model.setRstrUsgLblValDesc(rstrUsgLblValDesc[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (cntrStwgPsnCtnt[i] != null)
					model.setCntrStwgPsnCtnt(cntrStwgPsnCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMovementListByContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMovementListByContainerVO[]
	 */
	public SearchMovementListByContainerVO[] getSearchMovementListByContainerVOs(){
		SearchMovementListByContainerVO[] vos = (SearchMovementListByContainerVO[])models.toArray(new SearchMovementListByContainerVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt = this.dmgFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt = this.dmgUnflgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt = this.bkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg = this.cntrRfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg = this.cntrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd = this.cntrXchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblNm = this.rstrUsgLblNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblNmDesc = this.rstrUsgLblNmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblValDesc = this.rstrUsgLblValDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgPsnCtnt = this.cntrStwgPsnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
