/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchDeletedMVMTListVO.java
*@FileTitle : SearchDeletedMVMTListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDeletedMVMTListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDeletedMVMTListVO> models = new ArrayList<SearchDeletedMVMTListVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String dmgFlgDt = null;
	/* Column Info */
	private String dmgUnflgDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String cntrXchCd = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String maxCnmvCycNo = null;
	/* Column Info */
	private String cntrRfubFlg = null;
	/* Column Info */
	private String oscarFlag = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String pCntrno = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fdrCd = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String deltUsrId = null;
	/* Column Info */
	private String mtyPlnNo = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchDeletedMVMTListVO() {}

	public SearchDeletedMVMTListVO(String ibflag, String pagerows, String bkgCgoTpCd, String cnmvCycNo, String mvmtEdiMsgTpId, String chssNo, String checkDigit, String creDt, String mvmtTrspModCd, String destYdCd, String blNo, String fcntrFlg, String cntrDmgFlg, String dmgFlgDt, String dmgUnflgDt, String pDate1, String cnmvStsCd, String bkgKnt, String pDate2, String usrNm, String cntrRfubFlg, String updDt, String updLoclDt, String wblNo, String cnmvEvntDt, String spclCgoFlg, String deltDt, String mvmtCreTpCd, String mgstNo, String orgYdCd, String obCntrFlg, String pCntrno, String bkgNo, String fdrCd, String cnmvRmk, String creLoclDt, String vndrSeq, String cntrDispFlg, String cntrSealNo, String imdtExtFlg, String vndrAbbrNm, String cnmvCoCd, String deltUsrId, String pkupNo, String cntrXchCd, String oscarFlag, String cntrNo, String maxCnmvCycNo, String vpsEtdDt, String trunkVvd, String mtyPlnNo) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cnmvCycNo = cnmvCycNo;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.chssNo = chssNo;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.creDt = creDt;
		this.checkDigit = checkDigit;
		this.destYdCd = destYdCd;
		this.fcntrFlg = fcntrFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cntrDmgFlg = cntrDmgFlg;
		this.dmgFlgDt = dmgFlgDt;
		this.dmgUnflgDt = dmgUnflgDt;
		this.ibflag = ibflag;
		this.pDate1 = pDate1;
		this.cnmvStsCd = cnmvStsCd;
		this.cntrXchCd = cntrXchCd;
		this.bkgKnt = bkgKnt;
		this.pDate2 = pDate2;
		this.usrNm = usrNm;
		this.maxCnmvCycNo = maxCnmvCycNo;
		this.cntrRfubFlg = cntrRfubFlg;
		this.oscarFlag = oscarFlag;
		this.updDt = updDt;
		this.vpsEtdDt = vpsEtdDt;
		this.trunkVvd = trunkVvd;
		this.updLoclDt = updLoclDt;
		this.wblNo = wblNo;
		this.cnmvEvntDt = cnmvEvntDt;
		this.spclCgoFlg = spclCgoFlg;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.deltDt = deltDt;
		this.orgYdCd = orgYdCd;
		this.mgstNo = mgstNo;
		this.obCntrFlg = obCntrFlg;
		this.pCntrno = pCntrno;
		this.bkgNo = bkgNo;
		this.fdrCd = fdrCd;
		this.creLoclDt = creLoclDt;
		this.cnmvRmk = cnmvRmk;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.cntrDispFlg = cntrDispFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.imdtExtFlg = imdtExtFlg;
		this.cntrSealNo = cntrSealNo;
		this.cnmvCoCd = cnmvCoCd;
		this.pkupNo = pkupNo;
		this.deltUsrId = deltUsrId;
		this.mtyPlnNo = mtyPlnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());
		this.hashColumns.put("bkg_knt", getBkgKnt());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("max_cnmv_cyc_no", getMaxCnmvCycNo());
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());
		this.hashColumns.put("oscar_flag", getOscarFlag());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fdr_cd", getFdrCd());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
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
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("max_cnmv_cyc_no", "maxCnmvCycNo");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("oscar_flag", "oscarFlag");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fdr_cd", "fdrCd");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
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
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
	}
	
	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return cntrXchCd
	 */
	public String getCntrXchCd() {
		return this.cntrXchCd;
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
	 * @return maxCnmvCycNo
	 */
	public String getMaxCnmvCycNo() {
		return this.maxCnmvCycNo;
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
	 * @return oscarFlag
	 */
	public String getOscarFlag() {
		return this.oscarFlag;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
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
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
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
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return fdrCd
	 */
	public String getFdrCd() {
		return this.fdrCd;
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
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
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
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
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
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
	}
	
	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param cntrXchCd
	 */
	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
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
	 * @param maxCnmvCycNo
	 */
	public void setMaxCnmvCycNo(String maxCnmvCycNo) {
		this.maxCnmvCycNo = maxCnmvCycNo;
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
	 * @param oscarFlag
	 */
	public void setOscarFlag(String oscarFlag) {
		this.oscarFlag = oscarFlag;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
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
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
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
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param fdrCd
	 */
	public void setFdrCd(String fdrCd) {
		this.fdrCd = fdrCd;
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
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
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
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
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
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
	}
	
	/**
	 * Column Info
	 * @param mtyPlnNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
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
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, prefix + "mvmt_trsp_mod_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCheckDigit(JSPUtil.getParameter(request, prefix + "check_digit", ""));
		setDestYdCd(JSPUtil.getParameter(request, prefix + "dest_yd_cd", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, prefix + "cntr_dmg_flg", ""));
		setDmgFlgDt(JSPUtil.getParameter(request, prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request, prefix + "dmg_unflg_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setCntrXchCd(JSPUtil.getParameter(request, prefix + "cntr_xch_cd", ""));
		setBkgKnt(JSPUtil.getParameter(request, prefix + "bkg_knt", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setMaxCnmvCycNo(JSPUtil.getParameter(request, prefix + "max_cnmv_cyc_no", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request, prefix + "cntr_rfub_flg", ""));
		setOscarFlag(JSPUtil.getParameter(request, prefix + "oscar_flag", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, prefix + "upd_locl_dt", ""));
		setWblNo(JSPUtil.getParameter(request, prefix + "wbl_no", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setObCntrFlg(JSPUtil.getParameter(request, prefix + "ob_cntr_flg", ""));
		setPCntrno(JSPUtil.getParameter(request, prefix + "p_cntrno", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFdrCd(JSPUtil.getParameter(request, prefix + "fdr_cd", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrDispFlg(JSPUtil.getParameter(request, prefix + "cntr_disp_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, prefix + "cnmv_co_cd", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, prefix + "mty_pln_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDeletedMVMTListVO[]
	 */
	public SearchDeletedMVMTListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDeletedMVMTListVO[]
	 */
	public SearchDeletedMVMTListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDeletedMVMTListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] dmgFlgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_flg_dt", length));
			String[] dmgUnflgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_unflg_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] cntrXchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_cd", length));
			String[] bkgKnt = (JSPUtil.getParameter(request, prefix	+ "bkg_knt", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] maxCnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "max_cnmv_cyc_no", length));
			String[] cntrRfubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_rfub_flg", length));
			String[] oscarFlag = (JSPUtil.getParameter(request, prefix	+ "oscar_flag", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fdrCd = (JSPUtil.getParameter(request, prefix	+ "fdr_cd", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrDispFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_disp_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDeletedMVMTListVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (dmgFlgDt[i] != null)
					model.setDmgFlgDt(dmgFlgDt[i]);
				if (dmgUnflgDt[i] != null)
					model.setDmgUnflgDt(dmgUnflgDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (cntrXchCd[i] != null)
					model.setCntrXchCd(cntrXchCd[i]);
				if (bkgKnt[i] != null)
					model.setBkgKnt(bkgKnt[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (maxCnmvCycNo[i] != null)
					model.setMaxCnmvCycNo(maxCnmvCycNo[i]);
				if (cntrRfubFlg[i] != null)
					model.setCntrRfubFlg(cntrRfubFlg[i]);
				if (oscarFlag[i] != null)
					model.setOscarFlag(oscarFlag[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
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
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fdrCd[i] != null)
					model.setFdrCd(fdrCd[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrDispFlg[i] != null)
					model.setCntrDispFlg(cntrDispFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDeletedMVMTListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDeletedMVMTListVO[]
	 */
	public SearchDeletedMVMTListVO[] getSearchDeletedMVMTListVOs(){
		SearchDeletedMVMTListVO[] vos = (SearchDeletedMVMTListVO[])models.toArray(new SearchDeletedMVMTListVO[models.size()]);
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
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt = this.dmgFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt = this.dmgUnflgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd = this.cntrXchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt = this.bkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCnmvCycNo = this.maxCnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg = this.cntrRfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oscarFlag = this.oscarFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrCd = this.fdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg = this.cntrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
