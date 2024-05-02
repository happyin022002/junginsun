/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HblDtlInfoVO.java
*@FileTitle : HblDtlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.08.06 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HblDtlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HblDtlInfoVO> models = new ArrayList<HblDtlInfoVO>();
	
	/* Column Info */
	private String cneeSteCd = null;
	/* Column Info */
	private String blGdsDesc = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String idaIecNo = null;
	/* Column Info */
	private String hblTtlKnt = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String shprSteCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String cmdtMeasUtCd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String notiCtyNm = null;
	/* Column Info */
	private String shprCtyNm = null;
	/* Column Info */
	private String shprZipCd = null;
	/* Column Info */
	private String notiZipCd = null;
	/* Column Info */
	private String cneeCtyNm = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String cntrMfNo = null;
	/* Column Info */
	private String orgCntrMfNo = null;
	/* Column Info */
	private String notiSteCd = null;
	/* Column Info */
	private String hblMfTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String notiAddr = null;
	/* Column Info */
	private String cneeZipCd = null;
	/* Column Info */
	private String notiCntCd = null;
	/* Column Info */
	private String hblWgt = null;
	/* Column Info */
	private String cmdtMeasQty = null;
	/* Column Info */
	private String blMkDesc = null;
	/* Column Info */
	private String hblSeq = null;
	/* Column Info */
	private String notiNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HblDtlInfoVO() {}

	public HblDtlInfoVO(String ibflag, String pagerows, String bkgNo, String hblTtlKnt, String hblSeq, String hblNo, String cntrMfNo, String orgCntrMfNo, String blMkDesc, String blGdsDesc, String pckQty, String pckTpCd, String hblWgt, String wgtUtCd, String cmdtMeasQty, String cmdtMeasUtCd, String hblMfTpCd, String idaIecNo, String shprNm, String shprAddr, String shprCtyNm, String shprSteCd, String shprCntCd, String shprZipCd, String cneeNm, String cneeAddr, String cneeCtyNm, String cneeSteCd, String cneeCntCd, String cneeZipCd, String notiNm, String notiAddr, String notiCtyNm, String notiSteCd, String notiCntCd, String notiZipCd, String creUsrId, String updUsrId) {
		this.cneeSteCd = cneeSteCd;
		this.blGdsDesc = blGdsDesc;
		this.cneeAddr = cneeAddr;
		this.idaIecNo = idaIecNo;
		this.hblTtlKnt = hblTtlKnt;
		this.cneeCntCd = cneeCntCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.shprAddr = shprAddr;
		this.shprSteCd = shprSteCd;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.hblNo = hblNo;
		this.cmdtMeasUtCd = cmdtMeasUtCd;
		this.shprNm = shprNm;
		this.pckTpCd = pckTpCd;
		this.updUsrId = updUsrId;
		this.notiCtyNm = notiCtyNm;
		this.shprCtyNm = shprCtyNm;
		this.shprZipCd = shprZipCd;
		this.notiZipCd = notiZipCd;
		this.cneeCtyNm = cneeCtyNm;
		this.shprCntCd = shprCntCd;
		this.cntrMfNo = cntrMfNo;
		this.orgCntrMfNo = orgCntrMfNo;
		this.notiSteCd = notiSteCd;
		this.hblMfTpCd = hblMfTpCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.cneeNm = cneeNm;
		this.notiAddr = notiAddr;
		this.cneeZipCd = cneeZipCd;
		this.notiCntCd = notiCntCd;
		this.hblWgt = hblWgt;
		this.cmdtMeasQty = cmdtMeasQty;
		this.blMkDesc = blMkDesc;
		this.hblSeq = hblSeq;
		this.notiNm = notiNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_ste_cd", getCneeSteCd());
		this.hashColumns.put("bl_gds_desc", getBlGdsDesc());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("ida_iec_no", getIdaIecNo());
		this.hashColumns.put("hbl_ttl_knt", getHblTtlKnt());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("shpr_ste_cd", getShprSteCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("cmdt_meas_ut_cd", getCmdtMeasUtCd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("noti_cty_nm", getNotiCtyNm());
		this.hashColumns.put("shpr_cty_nm", getShprCtyNm());
		this.hashColumns.put("shpr_zip_cd", getShprZipCd());
		this.hashColumns.put("noti_zip_cd", getNotiZipCd());
		this.hashColumns.put("cnee_cty_nm", getCneeCtyNm());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("cntr_mf_no", getCntrMfNo());
		this.hashColumns.put("org_cntr_mf_no", getOrgCntrMfNo());
		this.hashColumns.put("noti_ste_cd", getNotiSteCd());
		this.hashColumns.put("hbl_mf_tp_cd", getHblMfTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("noti_addr", getNotiAddr());
		this.hashColumns.put("cnee_zip_cd", getCneeZipCd());
		this.hashColumns.put("noti_cnt_cd", getNotiCntCd());
		this.hashColumns.put("hbl_wgt", getHblWgt());
		this.hashColumns.put("cmdt_meas_qty", getCmdtMeasQty());
		this.hashColumns.put("bl_mk_desc", getBlMkDesc());
		this.hashColumns.put("hbl_seq", getHblSeq());
		this.hashColumns.put("noti_nm", getNotiNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_ste_cd", "cneeSteCd");
		this.hashFields.put("bl_gds_desc", "blGdsDesc");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("ida_iec_no", "idaIecNo");
		this.hashFields.put("hbl_ttl_knt", "hblTtlKnt");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("shpr_ste_cd", "shprSteCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("cmdt_meas_ut_cd", "cmdtMeasUtCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("noti_cty_nm", "notiCtyNm");
		this.hashFields.put("shpr_cty_nm", "shprCtyNm");
		this.hashFields.put("shpr_zip_cd", "shprZipCd");
		this.hashFields.put("noti_zip_cd", "notiZipCd");
		this.hashFields.put("cnee_cty_nm", "cneeCtyNm");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("cntr_mf_no", "cntrMfNo");
		this.hashFields.put("org_cntr_mf_no", "orgCntrMfNo");
		this.hashFields.put("noti_ste_cd", "notiSteCd");
		this.hashFields.put("hbl_mf_tp_cd", "hblMfTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("noti_addr", "notiAddr");
		this.hashFields.put("cnee_zip_cd", "cneeZipCd");
		this.hashFields.put("noti_cnt_cd", "notiCntCd");
		this.hashFields.put("hbl_wgt", "hblWgt");
		this.hashFields.put("cmdt_meas_qty", "cmdtMeasQty");
		this.hashFields.put("bl_mk_desc", "blMkDesc");
		this.hashFields.put("hbl_seq", "hblSeq");
		this.hashFields.put("noti_nm", "notiNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneeSteCd
	 */
	public String getCneeSteCd() {
		return this.cneeSteCd;
	}
	
	/**
	 * Column Info
	 * @return blGdsDesc
	 */
	public String getBlGdsDesc() {
		return this.blGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
	}
	
	/**
	 * Column Info
	 * @return idaIecNo
	 */
	public String getIdaIecNo() {
		return this.idaIecNo;
	}
	
	/**
	 * Column Info
	 * @return hblTtlKnt
	 */
	public String getHblTtlKnt() {
		return this.hblTtlKnt;
	}
	
	/**
	 * Column Info
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return shprSteCd
	 */
	public String getShprSteCd() {
		return this.shprSteCd;
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
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtMeasUtCd
	 */
	public String getCmdtMeasUtCd() {
		return this.cmdtMeasUtCd;
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
	 * @return notiCtyNm
	 */
	public String getNotiCtyNm() {
		return this.notiCtyNm;
	}
	
	/**
	 * Column Info
	 * @return shprCtyNm
	 */
	public String getShprCtyNm() {
		return this.shprCtyNm;
	}
	
	/**
	 * Column Info
	 * @return shprZipCd
	 */
	public String getShprZipCd() {
		return this.shprZipCd;
	}
	
	/**
	 * Column Info
	 * @return notiZipCd
	 */
	public String getNotiZipCd() {
		return this.notiZipCd;
	}
	
	/**
	 * Column Info
	 * @return cneeCtyNm
	 */
	public String getCneeCtyNm() {
		return this.cneeCtyNm;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMfNo
	 */
	public String getCntrMfNo() {
		return this.cntrMfNo;
	}
	
	/**
	 * Column Info
	 * @return orgCntrMfNo
	 */
	public String getOrgCntrMfNo() {
		return this.orgCntrMfNo;
	}
	
	/**
	 * Column Info
	 * @return notiSteCd
	 */
	public String getNotiSteCd() {
		return this.notiSteCd;
	}
	
	/**
	 * Column Info
	 * @return hblMfTpCd
	 */
	public String getHblMfTpCd() {
		return this.hblMfTpCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return notiAddr
	 */
	public String getNotiAddr() {
		return this.notiAddr;
	}
	
	/**
	 * Column Info
	 * @return cneeZipCd
	 */
	public String getCneeZipCd() {
		return this.cneeZipCd;
	}
	
	/**
	 * Column Info
	 * @return notiCntCd
	 */
	public String getNotiCntCd() {
		return this.notiCntCd;
	}
	
	/**
	 * Column Info
	 * @return hblWgt
	 */
	public String getHblWgt() {
		return this.hblWgt;
	}
	
	/**
	 * Column Info
	 * @return cmdtMeasQty
	 */
	public String getCmdtMeasQty() {
		return this.cmdtMeasQty;
	}
	
	/**
	 * Column Info
	 * @return blMkDesc
	 */
	public String getBlMkDesc() {
		return this.blMkDesc;
	}
	
	/**
	 * Column Info
	 * @return hblSeq
	 */
	public String getHblSeq() {
		return this.hblSeq;
	}
	
	/**
	 * Column Info
	 * @return notiNm
	 */
	public String getNotiNm() {
		return this.notiNm;
	}
	

	/**
	 * Column Info
	 * @param cneeSteCd
	 */
	public void setCneeSteCd(String cneeSteCd) {
		this.cneeSteCd = cneeSteCd;
	}
	
	/**
	 * Column Info
	 * @param blGdsDesc
	 */
	public void setBlGdsDesc(String blGdsDesc) {
		this.blGdsDesc = blGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
	}
	
	/**
	 * Column Info
	 * @param idaIecNo
	 */
	public void setIdaIecNo(String idaIecNo) {
		this.idaIecNo = idaIecNo;
	}
	
	/**
	 * Column Info
	 * @param hblTtlKnt
	 */
	public void setHblTtlKnt(String hblTtlKnt) {
		this.hblTtlKnt = hblTtlKnt;
	}
	
	/**
	 * Column Info
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param shprSteCd
	 */
	public void setShprSteCd(String shprSteCd) {
		this.shprSteCd = shprSteCd;
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
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtMeasUtCd
	 */
	public void setCmdtMeasUtCd(String cmdtMeasUtCd) {
		this.cmdtMeasUtCd = cmdtMeasUtCd;
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
	 * @param notiCtyNm
	 */
	public void setNotiCtyNm(String notiCtyNm) {
		this.notiCtyNm = notiCtyNm;
	}
	
	/**
	 * Column Info
	 * @param shprCtyNm
	 */
	public void setShprCtyNm(String shprCtyNm) {
		this.shprCtyNm = shprCtyNm;
	}
	
	/**
	 * Column Info
	 * @param shprZipCd
	 */
	public void setShprZipCd(String shprZipCd) {
		this.shprZipCd = shprZipCd;
	}
	
	/**
	 * Column Info
	 * @param notiZipCd
	 */
	public void setNotiZipCd(String notiZipCd) {
		this.notiZipCd = notiZipCd;
	}
	
	/**
	 * Column Info
	 * @param cneeCtyNm
	 */
	public void setCneeCtyNm(String cneeCtyNm) {
		this.cneeCtyNm = cneeCtyNm;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMfNo
	 */
	public void setCntrMfNo(String cntrMfNo) {
		this.cntrMfNo = cntrMfNo;
	}
	
	/**
	 * Column Info
	 * @param orgCntrMfNo
	 */
	public void setOrgCntrMfNo(String orgCntrMfNo) {
		this.orgCntrMfNo = orgCntrMfNo;
	}
	
	/**
	 * Column Info
	 * @param notiSteCd
	 */
	public void setNotiSteCd(String notiSteCd) {
		this.notiSteCd = notiSteCd;
	}
	
	/**
	 * Column Info
	 * @param hblMfTpCd
	 */
	public void setHblMfTpCd(String hblMfTpCd) {
		this.hblMfTpCd = hblMfTpCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param notiAddr
	 */
	public void setNotiAddr(String notiAddr) {
		this.notiAddr = notiAddr;
	}
	
	/**
	 * Column Info
	 * @param cneeZipCd
	 */
	public void setCneeZipCd(String cneeZipCd) {
		this.cneeZipCd = cneeZipCd;
	}
	
	/**
	 * Column Info
	 * @param notiCntCd
	 */
	public void setNotiCntCd(String notiCntCd) {
		this.notiCntCd = notiCntCd;
	}
	
	/**
	 * Column Info
	 * @param hblWgt
	 */
	public void setHblWgt(String hblWgt) {
		this.hblWgt = hblWgt;
	}
	
	/**
	 * Column Info
	 * @param cmdtMeasQty
	 */
	public void setCmdtMeasQty(String cmdtMeasQty) {
		this.cmdtMeasQty = cmdtMeasQty;
	}
	
	/**
	 * Column Info
	 * @param blMkDesc
	 */
	public void setBlMkDesc(String blMkDesc) {
		this.blMkDesc = blMkDesc;
	}
	
	/**
	 * Column Info
	 * @param hblSeq
	 */
	public void setHblSeq(String hblSeq) {
		this.hblSeq = hblSeq;
	}
	
	/**
	 * Column Info
	 * @param notiNm
	 */
	public void setNotiNm(String notiNm) {
		this.notiNm = notiNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCneeSteCd(JSPUtil.getParameter(request, "cnee_ste_cd", ""));
		setBlGdsDesc(JSPUtil.getParameter(request, "bl_gds_desc", ""));
		setCneeAddr(JSPUtil.getParameter(request, "cnee_addr", ""));
		setIdaIecNo(JSPUtil.getParameter(request, "ida_iec_no", ""));
		setHblTtlKnt(JSPUtil.getParameter(request, "hbl_ttl_knt", ""));
		setCneeCntCd(JSPUtil.getParameter(request, "cnee_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setShprAddr(JSPUtil.getParameter(request, "shpr_addr", ""));
		setShprSteCd(JSPUtil.getParameter(request, "shpr_ste_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setHblNo(JSPUtil.getParameter(request, "hbl_no", ""));
		setCmdtMeasUtCd(JSPUtil.getParameter(request, "cmdt_meas_ut_cd", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setNotiCtyNm(JSPUtil.getParameter(request, "noti_cty_nm", ""));
		setShprCtyNm(JSPUtil.getParameter(request, "shpr_cty_nm", ""));
		setShprZipCd(JSPUtil.getParameter(request, "shpr_zip_cd", ""));
		setNotiZipCd(JSPUtil.getParameter(request, "noti_zip_cd", ""));
		setCneeCtyNm(JSPUtil.getParameter(request, "cnee_cty_nm", ""));
		setShprCntCd(JSPUtil.getParameter(request, "shpr_cnt_cd", ""));
		setCntrMfNo(JSPUtil.getParameter(request, "cntr_mf_no", ""));
		setOrgCntrMfNo(JSPUtil.getParameter(request, "org_cntr_mf_no", ""));
		setNotiSteCd(JSPUtil.getParameter(request, "noti_ste_cd", ""));
		setHblMfTpCd(JSPUtil.getParameter(request, "hbl_mf_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
		setNotiAddr(JSPUtil.getParameter(request, "noti_addr", ""));
		setCneeZipCd(JSPUtil.getParameter(request, "cnee_zip_cd", ""));
		setNotiCntCd(JSPUtil.getParameter(request, "noti_cnt_cd", ""));
		setHblWgt(JSPUtil.getParameter(request, "hbl_wgt", ""));
		setCmdtMeasQty(JSPUtil.getParameter(request, "cmdt_meas_qty", ""));
		setBlMkDesc(JSPUtil.getParameter(request, "bl_mk_desc", ""));
		setHblSeq(JSPUtil.getParameter(request, "hbl_seq", ""));
		setNotiNm(JSPUtil.getParameter(request, "noti_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HblDtlInfoVO[]
	 */
	public HblDtlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HblDtlInfoVO[]
	 */
	public HblDtlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HblDtlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeSteCd = (JSPUtil.getParameter(request, prefix	+ "cnee_ste_cd", length));
			String[] blGdsDesc = (JSPUtil.getParameter(request, prefix	+ "bl_gds_desc", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] idaIecNo = (JSPUtil.getParameter(request, prefix	+ "ida_iec_no", length));
			String[] hblTtlKnt = (JSPUtil.getParameter(request, prefix	+ "hbl_ttl_knt", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] shprSteCd = (JSPUtil.getParameter(request, prefix	+ "shpr_ste_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] cmdtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_meas_ut_cd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] notiCtyNm = (JSPUtil.getParameter(request, prefix	+ "noti_cty_nm", length));
			String[] shprCtyNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cty_nm", length));
			String[] shprZipCd = (JSPUtil.getParameter(request, prefix	+ "shpr_zip_cd", length));
			String[] notiZipCd = (JSPUtil.getParameter(request, prefix	+ "noti_zip_cd", length));
			String[] cneeCtyNm = (JSPUtil.getParameter(request, prefix	+ "cnee_cty_nm", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] cntrMfNo = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_no", length));
			String[] orgCntrMfNo = (JSPUtil.getParameter(request, prefix	+ "org_cntr_mf_no", length));
			String[] notiSteCd = (JSPUtil.getParameter(request, prefix	+ "noti_ste_cd", length));
			String[] hblMfTpCd = (JSPUtil.getParameter(request, prefix	+ "hbl_mf_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] notiAddr = (JSPUtil.getParameter(request, prefix	+ "noti_addr", length));
			String[] cneeZipCd = (JSPUtil.getParameter(request, prefix	+ "cnee_zip_cd", length));
			String[] notiCntCd = (JSPUtil.getParameter(request, prefix	+ "noti_cnt_cd", length));
			String[] hblWgt = (JSPUtil.getParameter(request, prefix	+ "hbl_wgt", length));
			String[] cmdtMeasQty = (JSPUtil.getParameter(request, prefix	+ "cmdt_meas_qty", length));
			String[] blMkDesc = (JSPUtil.getParameter(request, prefix	+ "bl_mk_desc", length));
			String[] hblSeq = (JSPUtil.getParameter(request, prefix	+ "hbl_seq", length));
			String[] notiNm = (JSPUtil.getParameter(request, prefix	+ "noti_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new HblDtlInfoVO();
				if (cneeSteCd[i] != null)
					model.setCneeSteCd(cneeSteCd[i]);
				if (blGdsDesc[i] != null)
					model.setBlGdsDesc(blGdsDesc[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (idaIecNo[i] != null)
					model.setIdaIecNo(idaIecNo[i]);
				if (hblTtlKnt[i] != null)
					model.setHblTtlKnt(hblTtlKnt[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (shprSteCd[i] != null)
					model.setShprSteCd(shprSteCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (cmdtMeasUtCd[i] != null)
					model.setCmdtMeasUtCd(cmdtMeasUtCd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (notiCtyNm[i] != null)
					model.setNotiCtyNm(notiCtyNm[i]);
				if (shprCtyNm[i] != null)
					model.setShprCtyNm(shprCtyNm[i]);
				if (shprZipCd[i] != null)
					model.setShprZipCd(shprZipCd[i]);
				if (notiZipCd[i] != null)
					model.setNotiZipCd(notiZipCd[i]);
				if (cneeCtyNm[i] != null)
					model.setCneeCtyNm(cneeCtyNm[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (cntrMfNo[i] != null)
					model.setCntrMfNo(cntrMfNo[i]);
				if (orgCntrMfNo[i] != null)
					model.setOrgCntrMfNo(orgCntrMfNo[i]);
				if (notiSteCd[i] != null)
					model.setNotiSteCd(notiSteCd[i]);
				if (hblMfTpCd[i] != null)
					model.setHblMfTpCd(hblMfTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (notiAddr[i] != null)
					model.setNotiAddr(notiAddr[i]);
				if (cneeZipCd[i] != null)
					model.setCneeZipCd(cneeZipCd[i]);
				if (notiCntCd[i] != null)
					model.setNotiCntCd(notiCntCd[i]);
				if (hblWgt[i] != null)
					model.setHblWgt(hblWgt[i]);
				if (cmdtMeasQty[i] != null)
					model.setCmdtMeasQty(cmdtMeasQty[i]);
				if (blMkDesc[i] != null)
					model.setBlMkDesc(blMkDesc[i]);
				if (hblSeq[i] != null)
					model.setHblSeq(hblSeq[i]);
				if (notiNm[i] != null)
					model.setNotiNm(notiNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHblDtlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HblDtlInfoVO[]
	 */
	public HblDtlInfoVO[] getHblDtlInfoVOs(){
		HblDtlInfoVO[] vos = (HblDtlInfoVO[])models.toArray(new HblDtlInfoVO[models.size()]);
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
		this.cneeSteCd = this.cneeSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blGdsDesc = this.blGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIecNo = this.idaIecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblTtlKnt = this.hblTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSteCd = this.shprSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtMeasUtCd = this.cmdtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notiCtyNm = this.notiCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCtyNm = this.shprCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprZipCd = this.shprZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notiZipCd = this.notiZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCtyNm = this.cneeCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfNo = this.cntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntrMfNo = this.orgCntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notiSteCd = this.notiSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblMfTpCd = this.hblMfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notiAddr = this.notiAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeZipCd = this.cneeZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notiCntCd = this.notiCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblWgt = this.hblWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtMeasQty = this.cmdtMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMkDesc = this.blMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblSeq = this.hblSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notiNm = this.notiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
