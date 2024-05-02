/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrOnSiteVO.java
*@FileTitle : MnrOnSiteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.08.20 이율규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo;

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
 * @author 이율규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MnrOnSiteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrOnSiteVO> models = new ArrayList<MnrOnSiteVO>();
	
	/* Column Info */
	private String rsltNormFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String egItmFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fldAudRmk = null;
	/* Column Info */
	private String brncMonChkFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String brncDlyChkFlg = null;
	/* Column Info */
	private String rsltGdFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hdbrnWkyChkFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String inspOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String evItmNm = null;
	/* Column Info */
	private String hdbrnDlyChkFlg = null;
	/* Column Info */
	private String hdbrnMonChkFlg = null;
	/* Column Info */
	private String evItmSeq = null;
	/* Column Info */
	private String evItmOrdNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String onsiteInspRsltDtlSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String rsltBadFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String brncWkyChkFlg = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String fldInspDt = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String inspYr = null;
	/* Column Info */
	private String brncInspFlg = null;
	/* Column Info */
	private String hdbrnInspFlg = null;
	/* Column Info */
	private String sheetBrncInspFlg = null;
	/* Column Info */
	private String sheetHdbrnInspFlg = null;
	/* Column Info */
	private String vndrSeqForSave = null;
	/* Column Info */
	private String ydCdForSave = null;
	/* Column Info */
	private String fldInspDtForSave = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MnrOnSiteVO() {}

	public MnrOnSiteVO(String ibflag, String pagerows, String vndrSeq, String vndrNm, String inspOfcCd, String ydCd, String fileSeq, String fldInspDt, String onsiteInspRsltDtlSeq, String evItmNm, String evItmOrdNo, String brncDlyChkFlg, String brncWkyChkFlg, String brncMonChkFlg, String hdbrnDlyChkFlg, String hdbrnWkyChkFlg, String hdbrnMonChkFlg, String rsltGdFlg, String rsltNormFlg, String rsltBadFlg, String fldAudRmk, String evItmSeq, String egItmFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String usrId, String seq, String rhqOfcCd, String inspYr, String brncInspFlg, String hdbrnInspFlg, String sheetBrncInspFlg, String sheetHdbrnInspFlg, String vndrSeqForSave, String ydCdForSave, String fldInspDtForSave) {
		this.rsltNormFlg = rsltNormFlg;
		this.deltFlg = deltFlg;
		this.egItmFlg = egItmFlg;
		this.creDt = creDt;
		this.fldAudRmk = fldAudRmk;
		this.brncMonChkFlg = brncMonChkFlg;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.brncDlyChkFlg = brncDlyChkFlg;
		this.rsltGdFlg = rsltGdFlg;
		this.ibflag = ibflag;
		this.hdbrnWkyChkFlg = hdbrnWkyChkFlg;
		this.usrId = usrId;
		this.inspOfcCd = inspOfcCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.evItmNm = evItmNm;
		this.hdbrnDlyChkFlg = hdbrnDlyChkFlg;
		this.hdbrnMonChkFlg = hdbrnMonChkFlg;
		this.evItmSeq = evItmSeq;
		this.evItmOrdNo = evItmOrdNo;
		this.creUsrId = creUsrId;
		this.onsiteInspRsltDtlSeq = onsiteInspRsltDtlSeq;
		this.ydCd = ydCd;
		this.rsltBadFlg = rsltBadFlg;
		this.vndrSeq = vndrSeq;
		this.brncWkyChkFlg = brncWkyChkFlg;
		this.seq = seq;
		this.fileSeq = fileSeq;
		this.fldInspDt = fldInspDt;
		this.rhqOfcCd = rhqOfcCd;
		this.inspYr = inspYr;
		this.brncInspFlg = brncInspFlg;
		this.hdbrnInspFlg = hdbrnInspFlg;
		this.sheetBrncInspFlg = sheetBrncInspFlg;
		this.sheetHdbrnInspFlg = sheetHdbrnInspFlg;
		this.vndrSeqForSave = vndrSeqForSave;
		this.ydCdForSave = ydCdForSave;
		this.fldInspDtForSave = fldInspDtForSave;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rslt_norm_flg", getRsltNormFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("eg_itm_flg", getEgItmFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fld_aud_rmk", getFldAudRmk());
		this.hashColumns.put("brnc_mon_chk_flg", getBrncMonChkFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("brnc_dly_chk_flg", getBrncDlyChkFlg());
		this.hashColumns.put("rslt_gd_flg", getRsltGdFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hdbrn_wky_chk_flg", getHdbrnWkyChkFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("insp_ofc_cd", getInspOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ev_itm_nm", getEvItmNm());
		this.hashColumns.put("hdbrn_dly_chk_flg", getHdbrnDlyChkFlg());
		this.hashColumns.put("hdbrn_mon_chk_flg", getHdbrnMonChkFlg());
		this.hashColumns.put("ev_itm_seq", getEvItmSeq());
		this.hashColumns.put("ev_itm_ord_no", getEvItmOrdNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("onsite_insp_rslt_dtl_seq", getOnsiteInspRsltDtlSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("rslt_bad_flg", getRsltBadFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("brnc_wky_chk_flg", getBrncWkyChkFlg());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("fld_insp_dt", getFldInspDt());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("insp_yr", getInspYr());
		this.hashColumns.put("brnc_insp_flg", getBrncInspFlg());
		this.hashColumns.put("hdbrn_insp_flg", getHdbrnInspFlg());
		this.hashColumns.put("sheet_brnc_insp_flg", getSheetBrncInspFlg());
		this.hashColumns.put("sheet_hdbrn_insp_flg", getSheetHdbrnInspFlg());
		this.hashColumns.put("vndr_seq_for_save", getVndrSeqForSave());
		this.hashColumns.put("yd_cd_for_save", getYdCdForSave());
		this.hashColumns.put("fld_insp_dt_for_save", getFldInspDtForSave());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rslt_norm_flg", "rsltNormFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("eg_itm_flg", "egItmFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fld_aud_rmk", "fldAudRmk");
		this.hashFields.put("brnc_mon_chk_flg", "brncMonChkFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("brnc_dly_chk_flg", "brncDlyChkFlg");
		this.hashFields.put("rslt_gd_flg", "rsltGdFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hdbrn_wky_chk_flg", "hdbrnWkyChkFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("insp_ofc_cd", "inspOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ev_itm_nm", "evItmNm");
		this.hashFields.put("hdbrn_dly_chk_flg", "hdbrnDlyChkFlg");
		this.hashFields.put("hdbrn_mon_chk_flg", "hdbrnMonChkFlg");
		this.hashFields.put("ev_itm_seq", "evItmSeq");
		this.hashFields.put("ev_itm_ord_no", "evItmOrdNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("onsite_insp_rslt_dtl_seq", "onsiteInspRsltDtlSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("rslt_bad_flg", "rsltBadFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("brnc_wky_chk_flg", "brncWkyChkFlg");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("fld_insp_dt", "fldInspDt");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("insp_yr", "inspYr");
		this.hashFields.put("brnc_insp_flg", "brncInspFlg");
		this.hashFields.put("hdbrn_insp_flg", "hdbrnInspFlg");
		this.hashFields.put("sheet_brnc_insp_flg", "sheetBrncInspFlg");
		this.hashFields.put("sheet_hdbrn_insp_flg", "sheetHdbrnInspFlg");
		this.hashFields.put("vndr_seq_for_save", "vndrSeqForSave");
		this.hashFields.put("yd_cd_for_save", "ydCdForSave");
		this.hashFields.put("fld_insp_dt_for_save", "fldInspDtForSave");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rsltNormFlg
	 */
	public String getRsltNormFlg() {
		return this.rsltNormFlg;
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
	 * @return egItmFlg
	 */
	public String getEgItmFlg() {
		return this.egItmFlg;
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
	 * @return fldAudRmk
	 */
	public String getFldAudRmk() {
		return this.fldAudRmk;
	}
	
	/**
	 * Column Info
	 * @return brncMonChkFlg
	 */
	public String getBrncMonChkFlg() {
		return this.brncMonChkFlg;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return brncDlyChkFlg
	 */
	public String getBrncDlyChkFlg() {
		return this.brncDlyChkFlg;
	}
	
	/**
	 * Column Info
	 * @return rsltGdFlg
	 */
	public String getRsltGdFlg() {
		return this.rsltGdFlg;
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
	 * @return hdbrnWkyChkFlg
	 */
	public String getHdbrnWkyChkFlg() {
		return this.hdbrnWkyChkFlg;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return inspOfcCd
	 */
	public String getInspOfcCd() {
		return this.inspOfcCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return evItmNm
	 */
	public String getEvItmNm() {
		return this.evItmNm;
	}
	
	/**
	 * Column Info
	 * @return hdbrnDlyChkFlg
	 */
	public String getHdbrnDlyChkFlg() {
		return this.hdbrnDlyChkFlg;
	}
	
	/**
	 * Column Info
	 * @return hdbrnMonChkFlg
	 */
	public String getHdbrnMonChkFlg() {
		return this.hdbrnMonChkFlg;
	}
	
	/**
	 * Column Info
	 * @return evItmSeq
	 */
	public String getEvItmSeq() {
		return this.evItmSeq;
	}
	
	/**
	 * Column Info
	 * @return evItmOrdNo
	 */
	public String getEvItmOrdNo() {
		return this.evItmOrdNo;
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
	 * @return onsiteInspRsltDtlSeq
	 */
	public String getOnsiteInspRsltDtlSeq() {
		return this.onsiteInspRsltDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return rsltBadFlg
	 */
	public String getRsltBadFlg() {
		return this.rsltBadFlg;
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
	 * @return brncWkyChkFlg
	 */
	public String getBrncWkyChkFlg() {
		return this.brncWkyChkFlg;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return fldInspDt
	 */
	public String getFldInspDt() {
		return this.fldInspDt;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return inspYr
	 */
	public String getInspYr() {
		return this.inspYr;
	}
	
	/**
	 * Column Info
	 * @return brncInspFlg
	 */
	public String getBrncInspFlg() {
		return this.brncInspFlg;
	}
	
	/**
	 * Column Info
	 * @return hdbrnInspFlg
	 */
	public String getHdbrnInspFlg() {
		return this.hdbrnInspFlg;
	}
	
	/**
	 * Column Info
	 * @return sheetBrncInspFlg
	 */
	public String getSheetBrncInspFlg() {
		return this.sheetBrncInspFlg;
	}
	
	/**
	 * Column Info
	 * @return sheetHdbrnInspFlg
	 */
	public String getSheetHdbrnInspFlg() {
		return this.sheetHdbrnInspFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqForSave
	 */
	public String getVndrSeqForSave() {
		return this.vndrSeqForSave;
	}
	
	/**
	 * Column Info
	 * @return ydCdForSave
	 */
	public String getYdCdForSave() {
		return this.ydCdForSave;
	}
	
	/**
	 * Column Info
	 * @return fldInspDtForSave
	 */
	public String getFldInspDtForSave() {
		return this.fldInspDtForSave;
	}
	
	/**
	 * Column Info
	 * @param rsltNormFlg
	 */
	public void setRsltNormFlg(String rsltNormFlg) {
		this.rsltNormFlg = rsltNormFlg;
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
	 * @param egItmFlg
	 */
	public void setEgItmFlg(String egItmFlg) {
		this.egItmFlg = egItmFlg;
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
	 * @param fldAudRmk
	 */
	public void setFldAudRmk(String fldAudRmk) {
		this.fldAudRmk = fldAudRmk;
	}
	
	/**
	 * Column Info
	 * @param brncMonChkFlg
	 */
	public void setBrncMonChkFlg(String brncMonChkFlg) {
		this.brncMonChkFlg = brncMonChkFlg;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param brncDlyChkFlg
	 */
	public void setBrncDlyChkFlg(String brncDlyChkFlg) {
		this.brncDlyChkFlg = brncDlyChkFlg;
	}
	
	/**
	 * Column Info
	 * @param rsltGdFlg
	 */
	public void setRsltGdFlg(String rsltGdFlg) {
		this.rsltGdFlg = rsltGdFlg;
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
	 * @param hdbrnWkyChkFlg
	 */
	public void setHdbrnWkyChkFlg(String hdbrnWkyChkFlg) {
		this.hdbrnWkyChkFlg = hdbrnWkyChkFlg;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param inspOfcCd
	 */
	public void setInspOfcCd(String inspOfcCd) {
		this.inspOfcCd = inspOfcCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param evItmNm
	 */
	public void setEvItmNm(String evItmNm) {
		this.evItmNm = evItmNm;
	}
	
	/**
	 * Column Info
	 * @param hdbrnDlyChkFlg
	 */
	public void setHdbrnDlyChkFlg(String hdbrnDlyChkFlg) {
		this.hdbrnDlyChkFlg = hdbrnDlyChkFlg;
	}
	
	/**
	 * Column Info
	 * @param hdbrnMonChkFlg
	 */
	public void setHdbrnMonChkFlg(String hdbrnMonChkFlg) {
		this.hdbrnMonChkFlg = hdbrnMonChkFlg;
	}
	
	/**
	 * Column Info
	 * @param evItmSeq
	 */
	public void setEvItmSeq(String evItmSeq) {
		this.evItmSeq = evItmSeq;
	}
	
	/**
	 * Column Info
	 * @param evItmOrdNo
	 */
	public void setEvItmOrdNo(String evItmOrdNo) {
		this.evItmOrdNo = evItmOrdNo;
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
	 * @param onsiteInspRsltDtlSeq
	 */
	public void setOnsiteInspRsltDtlSeq(String onsiteInspRsltDtlSeq) {
		this.onsiteInspRsltDtlSeq = onsiteInspRsltDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param rsltBadFlg
	 */
	public void setRsltBadFlg(String rsltBadFlg) {
		this.rsltBadFlg = rsltBadFlg;
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
	 * @param brncWkyChkFlg
	 */
	public void setBrncWkyChkFlg(String brncWkyChkFlg) {
		this.brncWkyChkFlg = brncWkyChkFlg;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param fldInspDt
	 */
	public void setFldInspDt(String fldInspDt) {
		this.fldInspDt = fldInspDt;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param inspYr
	 */
	public void setInspYr(String inspYr) {
		this.inspYr = inspYr;
	}
	
	/**
	 * Column Info
	 * @param brncInspFlg
	 */
	public void setBrncInspFlg(String brncInspFlg) {
		this.brncInspFlg = brncInspFlg;
	}
	
	/**
	 * Column Info
	 * @param hdbrnInspFlg
	 */
	public void setHdbrnInspFlg(String hdbrnInspFlg) {
		this.hdbrnInspFlg = hdbrnInspFlg;
	}
	
	/**
	 * Column Info
	 * @param sheetBrncInspFlg
	 */
	public void setSheetBrncInspFlg(String sheetBrncInspFlg) {
		this.sheetBrncInspFlg = sheetBrncInspFlg;
	}
	
	/**
	 * Column Info
	 * @param hdbrnInspFlg
	 */
	public void setSheetHdbrnInspFlg(String sheetHdbrnInspFlg) {
		this.sheetHdbrnInspFlg = sheetHdbrnInspFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqForSave
	 */
	public void setVndrSeqForSave(String vndrSeqForSave) {
		this.vndrSeqForSave = vndrSeqForSave;
	}
	
	/**
	 * Column Info
	 * @param ydCdForSave
	 */
	public void setYdCdForSave(String ydCdForSave) {
		this.ydCdForSave = ydCdForSave;
	}
	
	/**
	 * Column Info
	 * @param fldInspDtForSave
	 */
	public void setFldInspDtForSave(String fldInspDtForSave) {
		this.fldInspDtForSave = fldInspDtForSave;
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
		setRsltNormFlg(JSPUtil.getParameter(request, prefix + "rslt_norm_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEgItmFlg(JSPUtil.getParameter(request, prefix + "eg_itm_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFldAudRmk(JSPUtil.getParameter(request, prefix + "fld_aud_rmk", ""));
		setBrncMonChkFlg(JSPUtil.getParameter(request, prefix + "brnc_mon_chk_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setBrncDlyChkFlg(JSPUtil.getParameter(request, prefix + "brnc_dly_chk_flg", ""));
		setRsltGdFlg(JSPUtil.getParameter(request, prefix + "rslt_gd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHdbrnWkyChkFlg(JSPUtil.getParameter(request, prefix + "hdbrn_wky_chk_flg", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setInspOfcCd(JSPUtil.getParameter(request, prefix + "insp_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEvItmNm(JSPUtil.getParameter(request, prefix + "ev_itm_nm", ""));
		setHdbrnDlyChkFlg(JSPUtil.getParameter(request, prefix + "hdbrn_dly_chk_flg", ""));
		setHdbrnMonChkFlg(JSPUtil.getParameter(request, prefix + "hdbrn_mon_chk_flg", ""));
		setEvItmSeq(JSPUtil.getParameter(request, prefix + "ev_itm_seq", ""));
		setEvItmOrdNo(JSPUtil.getParameter(request, prefix + "ev_itm_ord_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOnsiteInspRsltDtlSeq(JSPUtil.getParameter(request, prefix + "onsite_insp_rslt_dtl_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setRsltBadFlg(JSPUtil.getParameter(request, prefix + "rslt_bad_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setBrncWkyChkFlg(JSPUtil.getParameter(request, prefix + "brnc_wky_chk_flg", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setFldInspDt(JSPUtil.getParameter(request, prefix + "fld_insp_dt", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setInspYr(JSPUtil.getParameter(request, prefix + "insp_yr", ""));
		setBrncInspFlg(JSPUtil.getParameter(request, prefix + "brnc_insp_flg", ""));
		setHdbrnInspFlg(JSPUtil.getParameter(request, prefix + "hdbrn_insp_flg", ""));
		setSheetBrncInspFlg(JSPUtil.getParameter(request, prefix + "sheet_brnc_insp_flg", ""));
		setSheetHdbrnInspFlg(JSPUtil.getParameter(request, prefix + "sheet_hdbrn_insp_flg", ""));
		setVndrSeqForSave(JSPUtil.getParameter(request, prefix + "vndr_seq_for_save", ""));
		setYdCdForSave(JSPUtil.getParameter(request, prefix + "yd_cd_for_save", ""));
		setFldInspDtForSave(JSPUtil.getParameter(request, prefix + "fld_insp_dt_for_save", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrOnSiteVO[]
	 */
	public MnrOnSiteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrOnSiteVO[]
	 */
	public MnrOnSiteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrOnSiteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rsltNormFlg = (JSPUtil.getParameter(request, prefix	+ "rslt_norm_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] egItmFlg = (JSPUtil.getParameter(request, prefix	+ "eg_itm_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fldAudRmk = (JSPUtil.getParameter(request, prefix	+ "fld_aud_rmk", length));
			String[] brncMonChkFlg = (JSPUtil.getParameter(request, prefix	+ "brnc_mon_chk_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] brncDlyChkFlg = (JSPUtil.getParameter(request, prefix	+ "brnc_dly_chk_flg", length));
			String[] rsltGdFlg = (JSPUtil.getParameter(request, prefix	+ "rslt_gd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hdbrnWkyChkFlg = (JSPUtil.getParameter(request, prefix	+ "hdbrn_wky_chk_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] inspOfcCd = (JSPUtil.getParameter(request, prefix	+ "insp_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] evItmNm = (JSPUtil.getParameter(request, prefix	+ "ev_itm_nm", length));
			String[] hdbrnDlyChkFlg = (JSPUtil.getParameter(request, prefix	+ "hdbrn_dly_chk_flg", length));
			String[] hdbrnMonChkFlg = (JSPUtil.getParameter(request, prefix	+ "hdbrn_mon_chk_flg", length));
			String[] evItmSeq = (JSPUtil.getParameter(request, prefix	+ "ev_itm_seq", length));
			String[] evItmOrdNo = (JSPUtil.getParameter(request, prefix	+ "ev_itm_ord_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] onsiteInspRsltDtlSeq = (JSPUtil.getParameter(request, prefix	+ "onsite_insp_rslt_dtl_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] rsltBadFlg = (JSPUtil.getParameter(request, prefix	+ "rslt_bad_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] brncWkyChkFlg = (JSPUtil.getParameter(request, prefix	+ "brnc_wky_chk_flg", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] fldInspDt = (JSPUtil.getParameter(request, prefix	+ "fld_insp_dt", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] inspYr = (JSPUtil.getParameter(request, prefix	+ "insp_yr", length));
			String[] brncInspFlg = (JSPUtil.getParameter(request, prefix	+ "brnc_insp_flg", length));
			String[] hdbrnInspFlg = (JSPUtil.getParameter(request, prefix	+ "hdbrn_insp_flg", length));
			String[] sheetBrncInspFlg = (JSPUtil.getParameter(request, prefix	+ "sheet_brnc_insp_flg", length));
			String[] sheetHdbrnInspFlg = (JSPUtil.getParameter(request, prefix	+ "sheet_hdbrn_insp_flg", length));
			String[] vndrSeqForSave = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_for_save", length));
			String[] ydCdForSave = (JSPUtil.getParameter(request, prefix	+ "yd_cd_for_save", length));
			String[] fldInspDtForSave = (JSPUtil.getParameter(request, prefix	+ "fld_insp_dt_for_save", length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrOnSiteVO();
				if (rsltNormFlg[i] != null)
					model.setRsltNormFlg(rsltNormFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (egItmFlg[i] != null)
					model.setEgItmFlg(egItmFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fldAudRmk[i] != null)
					model.setFldAudRmk(fldAudRmk[i]);
				if (brncMonChkFlg[i] != null)
					model.setBrncMonChkFlg(brncMonChkFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (brncDlyChkFlg[i] != null)
					model.setBrncDlyChkFlg(brncDlyChkFlg[i]);
				if (rsltGdFlg[i] != null)
					model.setRsltGdFlg(rsltGdFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hdbrnWkyChkFlg[i] != null)
					model.setHdbrnWkyChkFlg(hdbrnWkyChkFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (inspOfcCd[i] != null)
					model.setInspOfcCd(inspOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (evItmNm[i] != null)
					model.setEvItmNm(evItmNm[i]);
				if (hdbrnDlyChkFlg[i] != null)
					model.setHdbrnDlyChkFlg(hdbrnDlyChkFlg[i]);
				if (hdbrnMonChkFlg[i] != null)
					model.setHdbrnMonChkFlg(hdbrnMonChkFlg[i]);
				if (evItmSeq[i] != null)
					model.setEvItmSeq(evItmSeq[i]);
				if (evItmOrdNo[i] != null)
					model.setEvItmOrdNo(evItmOrdNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (onsiteInspRsltDtlSeq[i] != null)
					model.setOnsiteInspRsltDtlSeq(onsiteInspRsltDtlSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (rsltBadFlg[i] != null)
					model.setRsltBadFlg(rsltBadFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (brncWkyChkFlg[i] != null)
					model.setBrncWkyChkFlg(brncWkyChkFlg[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (fldInspDt[i] != null)
					model.setFldInspDt(fldInspDt[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (inspYr[i] != null)
					model.setInspYr(inspYr[i]);
				if (brncInspFlg[i] != null)
					model.setBrncInspFlg(brncInspFlg[i]);
				if (hdbrnInspFlg[i] != null)
					model.setHdbrnInspFlg(hdbrnInspFlg[i]);
				if (sheetBrncInspFlg[i] != null)
					model.setSheetBrncInspFlg(sheetBrncInspFlg[i]);
				if (sheetHdbrnInspFlg[i] != null)
					model.setSheetHdbrnInspFlg(sheetHdbrnInspFlg[i]);
				if (vndrSeqForSave[i] != null)
					model.setVndrSeqForSave(vndrSeqForSave[i]);
				if (ydCdForSave[i] != null)
					model.setYdCdForSave(ydCdForSave[i]);
				if (fldInspDtForSave[i] != null)
					model.setFldInspDtForSave(fldInspDtForSave[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrOnSiteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrOnSiteVO[]
	 */
	public MnrOnSiteVO[] getMnrOnSiteVOs(){
		MnrOnSiteVO[] vos = (MnrOnSiteVO[])models.toArray(new MnrOnSiteVO[models.size()]);
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
		this.rsltNormFlg = this.rsltNormFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egItmFlg = this.egItmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fldAudRmk = this.fldAudRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brncMonChkFlg = this.brncMonChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brncDlyChkFlg = this.brncDlyChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltGdFlg = this.rsltGdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdbrnWkyChkFlg = this.hdbrnWkyChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inspOfcCd = this.inspOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evItmNm = this.evItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdbrnDlyChkFlg = this.hdbrnDlyChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdbrnMonChkFlg = this.hdbrnMonChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evItmSeq = this.evItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evItmOrdNo = this.evItmOrdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onsiteInspRsltDtlSeq = this.onsiteInspRsltDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltBadFlg = this.rsltBadFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brncWkyChkFlg = this.brncWkyChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fldInspDt = this.fldInspDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inspYr = this.inspYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brncInspFlg = this.brncInspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdbrnInspFlg = this.hdbrnInspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetBrncInspFlg = this.sheetBrncInspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetHdbrnInspFlg = this.sheetHdbrnInspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqForSave = this.vndrSeqForSave .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCdForSave = this.ydCdForSave .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fldInspDtForSave = this.fldInspDtForSave .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
