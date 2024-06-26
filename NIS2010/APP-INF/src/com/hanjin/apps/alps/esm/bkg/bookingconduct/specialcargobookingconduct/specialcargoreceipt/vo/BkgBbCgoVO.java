/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgBbCgoVO.java
*@FileTitle : BkgBbCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.08
*@LastModifier : 최문환
*@LastVersion : 1.0
* 2013.05.08 최문환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author 최문환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgBbCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L; 
	
	private Collection<BkgBbCgoVO> models = new ArrayList<BkgBbCgoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String slngPntFlg = null;
	/* Column Info */
	private String scrDngCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bbDcgoSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoAproCd = null;
	/* Column Info */
	private String dimWdt = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String dimLen = null;
	/* Column Info */
	private String cgoDchgMzdCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String stwgInstrDesc = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String gravCtrDesc = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String pckDtlDesc = null;
	/* Column Info */
	private String cgoLodgMzdCd = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String dimHgt = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String aplyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String spclRqstDesc = null;
	/* Column Info */
	private String bbCgoSeq = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String cgoDchgSdCd = null;
	/* Column Info */
	private String cgoLodgSdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgBbCgoVO() {}

	public BkgBbCgoVO(String ibflag, String pagerows, String bkgNo, String bbCgoSeq, String rcvTermCd, String deTermCd, String pckQty, String pckTpCd, String grsWgt, String netWgt, String wgtUtCd, String dimLen, String dimWdt, String dimHgt, String cgoWgt, String stwgInstrDesc, String bbDcgoSeq, String cmdtCd, String cmdtNm, String slngPntFlg, String gravCtrDesc, String pckDtlDesc, String cgoLodgMzdCd, String scrDngCtnt, String spclRqstDesc, String diffRmk, String rqstDt, String rqstUsrId, String spclCgoAproCd, String creUsrId, String creDt, String updUsrId, String cgoDchgMzdCd, String updDt, String porCd, String delCd, String cntrCgoSeq, String aplyNo, String cgoDchgSdCd, String cgoLodgSdCd) {
		this.porCd = porCd;
		this.rqstUsrId = rqstUsrId;
		this.slngPntFlg = slngPntFlg;
		this.scrDngCtnt = scrDngCtnt;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.bbDcgoSeq = bbDcgoSeq;
		this.ibflag = ibflag;
		this.spclCgoAproCd = spclCgoAproCd;
		this.dimWdt = dimWdt;
		this.cmdtCd = cmdtCd;
		this.dimLen = dimLen;
		this.cgoDchgMzdCd = cgoDchgMzdCd;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.stwgInstrDesc = stwgInstrDesc;
		this.rcvTermCd = rcvTermCd;
		this.pckTpCd = pckTpCd;
		this.updUsrId = updUsrId;
		this.gravCtrDesc = gravCtrDesc;
		this.cgoWgt = cgoWgt;
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.pckDtlDesc = pckDtlDesc;
		this.cgoLodgMzdCd = cgoLodgMzdCd;
		this.netWgt = netWgt;
		this.delCd = delCd;
		this.dimHgt = dimHgt;
		this.cntrCgoSeq = cntrCgoSeq;
		this.cmdtNm = cmdtNm;
		this.deTermCd = deTermCd;
		this.aplyNo = aplyNo;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.spclRqstDesc = spclRqstDesc;
		this.bbCgoSeq = bbCgoSeq;
		this.grsWgt = grsWgt;
		this.cgoDchgSdCd = cgoDchgSdCd;
		this.cgoLodgSdCd = cgoLodgSdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("slng_pnt_flg", getSlngPntFlg());
		this.hashColumns.put("scr_dng_ctnt", getScrDngCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bb_dcgo_seq", getBbDcgoSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
		this.hashColumns.put("dim_wdt", getDimWdt());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("dim_len", getDimLen());
		this.hashColumns.put("cgo_dchg_mzd_cd", getCgoDchgMzdCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("stwg_instr_desc", getStwgInstrDesc());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("grav_ctr_desc", getGravCtrDesc());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("pck_dtl_desc", getPckDtlDesc());
		this.hashColumns.put("cgo_lodg_mzd_cd", getCgoLodgMzdCd());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dim_hgt", getDimHgt());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("aply_no", getAplyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("spcl_rqst_desc", getSpclRqstDesc());
		this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("cgo_dchg_sd_cd", getCgoDchgSdCd());
		this.hashColumns.put("cgo_lodg_sd_cd", getCgoLodgSdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("slng_pnt_flg", "slngPntFlg");
		this.hashFields.put("scr_dng_ctnt", "scrDngCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bb_dcgo_seq", "bbDcgoSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
		this.hashFields.put("dim_wdt", "dimWdt");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("dim_len", "dimLen");
		this.hashFields.put("cgo_dchg_mzd_cd", "cgoDchgMzdCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("stwg_instr_desc", "stwgInstrDesc");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("grav_ctr_desc", "gravCtrDesc");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("pck_dtl_desc", "pckDtlDesc");
		this.hashFields.put("cgo_lodg_mzd_cd", "cgoLodgMzdCd");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dim_hgt", "dimHgt");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("aply_no", "aplyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("spcl_rqst_desc", "spclRqstDesc");
		this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("cgo_dchg_sd_cd", "cgoDchgSdCd");
		this.hashFields.put("cgo_lodg_sd_cd", "cgoLodgSdCd");
		return this.hashFields;
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
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return slngPntFlg
	 */
	public String getSlngPntFlg() {
		return this.slngPntFlg;
	}
	
	/**
	 * Column Info
	 * @return scrDngCtnt
	 */
	public String getScrDngCtnt() {
		return this.scrDngCtnt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return bbDcgoSeq
	 */
	public String getBbDcgoSeq() {
		return this.bbDcgoSeq;
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
	 * @return spclCgoAproCd
	 */
	public String getSpclCgoAproCd() {
		return this.spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @return dimWdt
	 */
	public String getDimWdt() {
		return this.dimWdt;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return dimLen
	 */
	public String getDimLen() {
		return this.dimLen;
	}
	
	/**
	 * Column Info
	 * @return cgoDchgMzdCd
	 */
	public String getCgoDchgMzdCd() {
		return this.cgoDchgMzdCd;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return stwgInstrDesc
	 */
	public String getStwgInstrDesc() {
		return this.stwgInstrDesc;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
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
	 * @return gravCtrDesc
	 */
	public String getGravCtrDesc() {
		return this.gravCtrDesc;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return pckDtlDesc
	 */
	public String getPckDtlDesc() {
		return this.pckDtlDesc;
	}
	
	/**
	 * Column Info
	 * @return cgoLodgMzdCd
	 */
	public String getCgoLodgMzdCd() {
		return this.cgoLodgMzdCd;
	}
	
	/**
	 * Column Info
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
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
	 * @return dimHgt
	 */
	public String getDimHgt() {
		return this.dimHgt;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return aplyNo
	 */
	public String getAplyNo() {
		return this.aplyNo;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return spclRqstDesc
	 */
	public String getSpclRqstDesc() {
		return this.spclRqstDesc;
	}
	
	/**
	 * Column Info
	 * @return bbCgoSeq
	 */
	public String getBbCgoSeq() {
		return this.bbCgoSeq;
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
	 * @return cgoDchgSdCd
	 */
	public String getCgoDchgSdCd() {
		return cgoDchgSdCd;
	}
	
	/**
	 * Column Info
	 * @return cgoLodgSdCd
	 */
	public String getCgoLodgSdCd() {
		return cgoLodgSdCd;
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
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param slngPntFlg
	 */
	public void setSlngPntFlg(String slngPntFlg) {
		this.slngPntFlg = slngPntFlg;
	}
	
	/**
	 * Column Info
	 * @param scrDngCtnt
	 */
	public void setScrDngCtnt(String scrDngCtnt) {
		this.scrDngCtnt = scrDngCtnt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param bbDcgoSeq
	 */
	public void setBbDcgoSeq(String bbDcgoSeq) {
		this.bbDcgoSeq = bbDcgoSeq;
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
	 * @param spclCgoAproCd
	 */
	public void setSpclCgoAproCd(String spclCgoAproCd) {
		this.spclCgoAproCd = spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @param dimWdt
	 */
	public void setDimWdt(String dimWdt) {
		this.dimWdt = dimWdt;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param dimLen
	 */
	public void setDimLen(String dimLen) {
		this.dimLen = dimLen;
	}
	
	/**
	 * Column Info
	 * @param cgoDchgMzdCd
	 */
	public void setCgoDchgMzdCd(String cgoDchgMzdCd) {
		this.cgoDchgMzdCd = cgoDchgMzdCd;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param stwgInstrDesc
	 */
	public void setStwgInstrDesc(String stwgInstrDesc) {
		this.stwgInstrDesc = stwgInstrDesc;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
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
	 * @param gravCtrDesc
	 */
	public void setGravCtrDesc(String gravCtrDesc) {
		this.gravCtrDesc = gravCtrDesc;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param pckDtlDesc
	 */
	public void setPckDtlDesc(String pckDtlDesc) {
		this.pckDtlDesc = pckDtlDesc;
	}
	
	/**
	 * Column Info
	 * @param cgoLodgMzdCd
	 */
	public void setCgoLodgMzdCd(String cgoLodgMzdCd) {
		this.cgoLodgMzdCd = cgoLodgMzdCd;
	}
	
	/**
	 * Column Info
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
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
	 * @param dimHgt
	 */
	public void setDimHgt(String dimHgt) {
		this.dimHgt = dimHgt;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param aplyNo
	 */
	public void setAplyNo(String aplyNo) {
		this.aplyNo = aplyNo;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param spclRqstDesc
	 */
	public void setSpclRqstDesc(String spclRqstDesc) {
		this.spclRqstDesc = spclRqstDesc;
	}
	
	/**
	 * Column Info
	 * @param bbCgoSeq
	 */
	public void setBbCgoSeq(String bbCgoSeq) {
		this.bbCgoSeq = bbCgoSeq;
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
	 * @param cgoDchgSdCd
	 */
	public void setCgoDchgSdCd(String cgoDchgSdCd) {
		this.cgoDchgSdCd = cgoDchgSdCd;
	}
	
	/**
	 * Column Info
	 * @param cgoLodgSdCd
	 */
	public void setCgoLodgSdCd(String cgoLodgSdCd) {
		this.cgoLodgSdCd = cgoLodgSdCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setSlngPntFlg(JSPUtil.getParameter(request, prefix + "slng_pnt_flg", ""));
		setScrDngCtnt(JSPUtil.getParameter(request, prefix + "scr_dng_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBbDcgoSeq(JSPUtil.getParameter(request, prefix + "bb_dcgo_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpclCgoAproCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", ""));
		setDimWdt(JSPUtil.getParameter(request, prefix + "dim_wdt", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setDimLen(JSPUtil.getParameter(request, prefix + "dim_len", ""));
		setCgoDchgMzdCd(JSPUtil.getParameter(request, prefix + "cgo_dchg_mzd_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setStwgInstrDesc(JSPUtil.getParameter(request, prefix + "stwg_instr_desc", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setGravCtrDesc(JSPUtil.getParameter(request, prefix + "grav_ctr_desc", ""));
		setCgoWgt(JSPUtil.getParameter(request, prefix + "cgo_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setPckDtlDesc(JSPUtil.getParameter(request, prefix + "pck_dtl_desc", ""));
		setCgoLodgMzdCd(JSPUtil.getParameter(request, prefix + "cgo_lodg_mzd_cd", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDimHgt(JSPUtil.getParameter(request, prefix + "dim_hgt", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setAplyNo(JSPUtil.getParameter(request, prefix + "aply_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setSpclRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_rqst_desc", ""));
		setBbCgoSeq(JSPUtil.getParameter(request, prefix + "bb_cgo_seq", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setCgoDchgSdCd(JSPUtil.getParameter(request, prefix + "cgo_dchg_sd_cd", ""));
		setCgoLodgSdCd(JSPUtil.getParameter(request, prefix + "cgo_lodg_sd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgBbCgoVO[]
	 */
	public BkgBbCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgBbCgoVO[]
	 */
	public BkgBbCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgBbCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] slngPntFlg = (JSPUtil.getParameter(request, prefix	+ "slng_pnt_flg", length));
			String[] scrDngCtnt = (JSPUtil.getParameter(request, prefix	+ "scr_dng_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bbDcgoSeq = (JSPUtil.getParameter(request, prefix	+ "bb_dcgo_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_cd", length));
			String[] dimWdt = (JSPUtil.getParameter(request, prefix	+ "dim_wdt", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] dimLen = (JSPUtil.getParameter(request, prefix	+ "dim_len", length));
			String[] cgoDchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "cgo_dchg_mzd_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] stwgInstrDesc = (JSPUtil.getParameter(request, prefix	+ "stwg_instr_desc", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] gravCtrDesc = (JSPUtil.getParameter(request, prefix	+ "grav_ctr_desc", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] pckDtlDesc = (JSPUtil.getParameter(request, prefix	+ "pck_dtl_desc", length));
			String[] cgoLodgMzdCd = (JSPUtil.getParameter(request, prefix	+ "cgo_lodg_mzd_cd", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] dimHgt = (JSPUtil.getParameter(request, prefix	+ "dim_hgt", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] aplyNo = (JSPUtil.getParameter(request, prefix	+ "aply_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] spclRqstDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_rqst_desc", length));
			String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_seq", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] cgoDchgSdCd = (JSPUtil.getParameter(request, prefix	+ "cgo_dchg_sd_cd", length));
			String[] cgoLodgSdCd = (JSPUtil.getParameter(request, prefix	+ "cgo_lodg_sd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgBbCgoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (slngPntFlg[i] != null)
					model.setSlngPntFlg(slngPntFlg[i]);
				if (scrDngCtnt[i] != null)
					model.setScrDngCtnt(scrDngCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bbDcgoSeq[i] != null)
					model.setBbDcgoSeq(bbDcgoSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoAproCd[i] != null)
					model.setSpclCgoAproCd(spclCgoAproCd[i]);
				if (dimWdt[i] != null)
					model.setDimWdt(dimWdt[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (dimLen[i] != null)
					model.setDimLen(dimLen[i]);
				if (cgoDchgMzdCd[i] != null)
					model.setCgoDchgMzdCd(cgoDchgMzdCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (stwgInstrDesc[i] != null)
					model.setStwgInstrDesc(stwgInstrDesc[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (gravCtrDesc[i] != null)
					model.setGravCtrDesc(gravCtrDesc[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (pckDtlDesc[i] != null)
					model.setPckDtlDesc(pckDtlDesc[i]);
				if (cgoLodgMzdCd[i] != null)
					model.setCgoLodgMzdCd(cgoLodgMzdCd[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (dimHgt[i] != null)
					model.setDimHgt(dimHgt[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (aplyNo[i] != null)
					model.setAplyNo(aplyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (spclRqstDesc[i] != null)
					model.setSpclRqstDesc(spclRqstDesc[i]);
				if (bbCgoSeq[i] != null)
					model.setBbCgoSeq(bbCgoSeq[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (cgoDchgSdCd[i] != null)
					model.setCgoDchgSdCd(cgoDchgSdCd[i]);
				if (cgoLodgSdCd[i] != null)
					model.setCgoLodgSdCd(cgoLodgSdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgBbCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgBbCgoVO[]
	 */
	public BkgBbCgoVO[] getBkgBbCgoVOs(){
		BkgBbCgoVO[] vos = (BkgBbCgoVO[])models.toArray(new BkgBbCgoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slngPntFlg = this.slngPntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrDngCtnt = this.scrDngCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbDcgoSeq = this.bbDcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproCd = this.spclCgoAproCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimWdt = this.dimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimLen = this.dimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDchgMzdCd = this.cgoDchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgInstrDesc = this.stwgInstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gravCtrDesc = this.gravCtrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckDtlDesc = this.pckDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoLodgMzdCd = this.cgoLodgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimHgt = this.dimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyNo = this.aplyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRqstDesc = this.spclRqstDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoSeq = this.bbCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDchgSdCd = this.cgoDchgSdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoLodgSdCd = this.cgoLodgSdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
