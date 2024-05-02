/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSEquipmentINVO.java
*@FileTitle : CHSEquipmentINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.12 박의수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 박의수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSEquipmentINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSEquipmentINVO> models = new ArrayList<CHSEquipmentINVO>();
	
	/* Column Info */
	private String onhYdCd = null;
	/* Column Info */
	private String chssRgstUpdOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chssRgstLicNoa = null;
	/* Column Info */
	private String eqNoTmp = null;
	/* Column Info */
	private String eqNoFm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chssRgstPrdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String onhOfcCd = null;
	/* Column Info */
	private String chssAlsNo = null;
	/* Column Info */
	private String chssTareWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chssRgstUpdDt = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String chssTitNo = null;
	/* Column Info */
	private String chssRgstLicNo = null;
	/* Column Info */
	private String chssRgstExpDt = null;
	/* Column Info */
	private String chssRgstUpdId = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqNoTo = null;
	/* Column Info */
	private String n2ndChssAlsNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String chssRgstYr = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String chssRgstSteCd = null;
	/* Column Info */
	private String chssVehIdNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSEquipmentINVO() {}

	public CHSEquipmentINVO(String ibflag, String pagerows, String eqNo, String eqNoFm, String eqNoTo, String eqNoTmp, String eqKndCd, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String chssRgstLicNo, String chssRgstLicNoa, String chssVehIdNo, String eqTpszCd, String mftDt, String chssTareWgt, String chssRgstSteCd, String chssRgstYr, String chssRgstPrdCd, String chssRgstExpDt, String chssTitNo, String chssAlsNo, String n2ndChssAlsNo, String onhYdCd, String chssRgstUpdOfcCd, String onhOfcCd, String creDt, String creUsrId, String chssRgstUpdDt, String chssRgstUpdId, String updDt, String updUsrId) {
		this.onhYdCd = onhYdCd;
		this.chssRgstUpdOfcCd = chssRgstUpdOfcCd;
		this.creDt = creDt;
		this.chssRgstLicNoa = chssRgstLicNoa;
		this.eqNoTmp = eqNoTmp;
		this.eqNoFm = eqNoFm;
		this.pagerows = pagerows;
		this.chssRgstPrdCd = chssRgstPrdCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.onhOfcCd = onhOfcCd;
		this.chssAlsNo = chssAlsNo;
		this.chssTareWgt = chssTareWgt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.chssRgstUpdDt = chssRgstUpdDt;
		this.agmtSeq = agmtSeq;
		this.chssTitNo = chssTitNo;
		this.chssRgstLicNo = chssRgstLicNo;
		this.chssRgstExpDt = chssRgstExpDt;
		this.chssRgstUpdId = chssRgstUpdId;
		this.eqKndCd = eqKndCd;
		this.eqNoTo = eqNoTo;
		this.n2ndChssAlsNo = n2ndChssAlsNo;
		this.eqTpszCd = eqTpszCd;
		this.mftDt = mftDt;
		this.chssRgstYr = chssRgstYr;
		this.creUsrId = creUsrId;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.agmtVerNo = agmtVerNo;
		this.chssRgstSteCd = chssRgstSteCd;
		this.chssVehIdNo = chssVehIdNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());
		this.hashColumns.put("chss_rgst_upd_ofc_cd", getChssRgstUpdOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chss_rgst_lic_noa", getChssRgstLicNoa());
		this.hashColumns.put("eq_no_tmp", getEqNoTmp());
		this.hashColumns.put("eq_no_fm", getEqNoFm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chss_rgst_prd_cd", getChssRgstPrdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("onh_ofc_cd", getOnhOfcCd());
		this.hashColumns.put("chss_als_no", getChssAlsNo());
		this.hashColumns.put("chss_tare_wgt", getChssTareWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chss_rgst_upd_dt", getChssRgstUpdDt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("chss_tit_no", getChssTitNo());
		this.hashColumns.put("chss_rgst_lic_no", getChssRgstLicNo());
		this.hashColumns.put("chss_rgst_exp_dt", getChssRgstExpDt());
		this.hashColumns.put("chss_rgst_upd_id", getChssRgstUpdId());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_no_to", getEqNoTo());
		this.hashColumns.put("n2nd_chss_als_no", getN2ndChssAlsNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("chss_rgst_yr", getChssRgstYr());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("chss_rgst_ste_cd", getChssRgstSteCd());
		this.hashColumns.put("chss_veh_id_no", getChssVehIdNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("chss_rgst_upd_ofc_cd", "chssRgstUpdOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chss_rgst_lic_noa", "chssRgstLicNoa");
		this.hashFields.put("eq_no_tmp", "eqNoTmp");
		this.hashFields.put("eq_no_fm", "eqNoFm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chss_rgst_prd_cd", "chssRgstPrdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("onh_ofc_cd", "onhOfcCd");
		this.hashFields.put("chss_als_no", "chssAlsNo");
		this.hashFields.put("chss_tare_wgt", "chssTareWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chss_rgst_upd_dt", "chssRgstUpdDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("chss_tit_no", "chssTitNo");
		this.hashFields.put("chss_rgst_lic_no", "chssRgstLicNo");
		this.hashFields.put("chss_rgst_exp_dt", "chssRgstExpDt");
		this.hashFields.put("chss_rgst_upd_id", "chssRgstUpdId");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_no_to", "eqNoTo");
		this.hashFields.put("n2nd_chss_als_no", "n2ndChssAlsNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("chss_rgst_yr", "chssRgstYr");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("chss_rgst_ste_cd", "chssRgstSteCd");
		this.hashFields.put("chss_veh_id_no", "chssVehIdNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return onhYdCd
	 */
	public String getOnhYdCd() {
		return this.onhYdCd;
	}
	
	/**
	 * Column Info
	 * @return chssRgstUpdOfcCd
	 */
	public String getChssRgstUpdOfcCd() {
		return this.chssRgstUpdOfcCd;
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
	 * @return chssRgstLicNoa
	 */
	public String getChssRgstLicNoa() {
		return this.chssRgstLicNoa;
	}
	
	/**
	 * Column Info
	 * @return eqNoTmp
	 */
	public String getEqNoTmp() {
		return this.eqNoTmp;
	}
	
	/**
	 * Column Info
	 * @return eqNoFm
	 */
	public String getEqNoFm() {
		return this.eqNoFm;
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
	 * @return chssRgstPrdCd
	 */
	public String getChssRgstPrdCd() {
		return this.chssRgstPrdCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return onhOfcCd
	 */
	public String getOnhOfcCd() {
		return this.onhOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chssAlsNo
	 */
	public String getChssAlsNo() {
		return this.chssAlsNo;
	}
	
	/**
	 * Column Info
	 * @return chssTareWgt
	 */
	public String getChssTareWgt() {
		return this.chssTareWgt;
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
	 * @return chssRgstUpdDt
	 */
	public String getChssRgstUpdDt() {
		return this.chssRgstUpdDt;
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
	 * @return chssTitNo
	 */
	public String getChssTitNo() {
		return this.chssTitNo;
	}
	
	/**
	 * Column Info
	 * @return chssRgstLicNo
	 */
	public String getChssRgstLicNo() {
		return this.chssRgstLicNo;
	}
	
	/**
	 * Column Info
	 * @return chssRgstExpDt
	 */
	public String getChssRgstExpDt() {
		return this.chssRgstExpDt;
	}
	
	/**
	 * Column Info
	 * @return chssRgstUpdId
	 */
	public String getChssRgstUpdId() {
		return this.chssRgstUpdId;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return eqNoTo
	 */
	public String getEqNoTo() {
		return this.eqNoTo;
	}
	
	/**
	 * Column Info
	 * @return n2ndChssAlsNo
	 */
	public String getN2ndChssAlsNo() {
		return this.n2ndChssAlsNo;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
	}
	
	/**
	 * Column Info
	 * @return chssRgstYr
	 */
	public String getChssRgstYr() {
		return this.chssRgstYr;
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
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return chssRgstSteCd
	 */
	public String getChssRgstSteCd() {
		return this.chssRgstSteCd;
	}
	
	/**
	 * Column Info
	 * @return chssVehIdNo
	 */
	public String getChssVehIdNo() {
		return this.chssVehIdNo;
	}
	

	/**
	 * Column Info
	 * @param onhYdCd
	 */
	public void setOnhYdCd(String onhYdCd) {
		this.onhYdCd = onhYdCd;
	}
	
	/**
	 * Column Info
	 * @param chssRgstUpdOfcCd
	 */
	public void setChssRgstUpdOfcCd(String chssRgstUpdOfcCd) {
		this.chssRgstUpdOfcCd = chssRgstUpdOfcCd;
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
	 * @param chssRgstLicNoa
	 */
	public void setChssRgstLicNoa(String chssRgstLicNoa) {
		this.chssRgstLicNoa = chssRgstLicNoa;
	}
	
	/**
	 * Column Info
	 * @param eqNoTmp
	 */
	public void setEqNoTmp(String eqNoTmp) {
		this.eqNoTmp = eqNoTmp;
	}
	
	/**
	 * Column Info
	 * @param eqNoFm
	 */
	public void setEqNoFm(String eqNoFm) {
		this.eqNoFm = eqNoFm;
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
	 * @param chssRgstPrdCd
	 */
	public void setChssRgstPrdCd(String chssRgstPrdCd) {
		this.chssRgstPrdCd = chssRgstPrdCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param onhOfcCd
	 */
	public void setOnhOfcCd(String onhOfcCd) {
		this.onhOfcCd = onhOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chssAlsNo
	 */
	public void setChssAlsNo(String chssAlsNo) {
		this.chssAlsNo = chssAlsNo;
	}
	
	/**
	 * Column Info
	 * @param chssTareWgt
	 */
	public void setChssTareWgt(String chssTareWgt) {
		this.chssTareWgt = chssTareWgt;
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
	 * @param chssRgstUpdDt
	 */
	public void setChssRgstUpdDt(String chssRgstUpdDt) {
		this.chssRgstUpdDt = chssRgstUpdDt;
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
	 * @param chssTitNo
	 */
	public void setChssTitNo(String chssTitNo) {
		this.chssTitNo = chssTitNo;
	}
	
	/**
	 * Column Info
	 * @param chssRgstLicNo
	 */
	public void setChssRgstLicNo(String chssRgstLicNo) {
		this.chssRgstLicNo = chssRgstLicNo;
	}
	
	/**
	 * Column Info
	 * @param chssRgstExpDt
	 */
	public void setChssRgstExpDt(String chssRgstExpDt) {
		this.chssRgstExpDt = chssRgstExpDt;
	}
	
	/**
	 * Column Info
	 * @param chssRgstUpdId
	 */
	public void setChssRgstUpdId(String chssRgstUpdId) {
		this.chssRgstUpdId = chssRgstUpdId;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param eqNoTo
	 */
	public void setEqNoTo(String eqNoTo) {
		this.eqNoTo = eqNoTo;
	}
	
	/**
	 * Column Info
	 * @param n2ndChssAlsNo
	 */
	public void setN2ndChssAlsNo(String n2ndChssAlsNo) {
		this.n2ndChssAlsNo = n2ndChssAlsNo;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
	}
	
	/**
	 * Column Info
	 * @param chssRgstYr
	 */
	public void setChssRgstYr(String chssRgstYr) {
		this.chssRgstYr = chssRgstYr;
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
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param chssRgstSteCd
	 */
	public void setChssRgstSteCd(String chssRgstSteCd) {
		this.chssRgstSteCd = chssRgstSteCd;
	}
	
	/**
	 * Column Info
	 * @param chssVehIdNo
	 */
	public void setChssVehIdNo(String chssVehIdNo) {
		this.chssVehIdNo = chssVehIdNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOnhYdCd(JSPUtil.getParameter(request, "onh_yd_cd", ""));
		setChssRgstUpdOfcCd(JSPUtil.getParameter(request, "chss_rgst_upd_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setChssRgstLicNoa(JSPUtil.getParameter(request, "chss_rgst_lic_noa", ""));
		setEqNoTmp(JSPUtil.getParameter(request, "eq_no_tmp", ""));
		setEqNoFm(JSPUtil.getParameter(request, "eq_no_fm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChssRgstPrdCd(JSPUtil.getParameter(request, "chss_rgst_prd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setOnhOfcCd(JSPUtil.getParameter(request, "onh_ofc_cd", ""));
		setChssAlsNo(JSPUtil.getParameter(request, "chss_als_no", ""));
		setChssTareWgt(JSPUtil.getParameter(request, "chss_tare_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setChssRgstUpdDt(JSPUtil.getParameter(request, "chss_rgst_upd_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setChssTitNo(JSPUtil.getParameter(request, "chss_tit_no", ""));
		setChssRgstLicNo(JSPUtil.getParameter(request, "chss_rgst_lic_no", ""));
		setChssRgstExpDt(JSPUtil.getParameter(request, "chss_rgst_exp_dt", ""));
		setChssRgstUpdId(JSPUtil.getParameter(request, "chss_rgst_upd_id", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setEqNoTo(JSPUtil.getParameter(request, "eq_no_to", ""));
		setN2ndChssAlsNo(JSPUtil.getParameter(request, "n2nd_chss_als_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setChssRgstYr(JSPUtil.getParameter(request, "chss_rgst_yr", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setChssRgstSteCd(JSPUtil.getParameter(request, "chss_rgst_ste_cd", ""));
		setChssVehIdNo(JSPUtil.getParameter(request, "chss_veh_id_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSEquipmentINVO[]
	 */
	public CHSEquipmentINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSEquipmentINVO[]
	 */
	public CHSEquipmentINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSEquipmentINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] onhYdCd = (JSPUtil.getParameter(request, prefix	+ "onh_yd_cd", length));
			String[] chssRgstUpdOfcCd = (JSPUtil.getParameter(request, prefix + "chss_rgst_upd_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chssRgstLicNoa = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_lic_noa", length));
			String[] eqNoTmp = (JSPUtil.getParameter(request, prefix	+ "eq_no_tmp", length));
			String[] eqNoFm = (JSPUtil.getParameter(request, prefix	+ "eq_no_fm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chssRgstPrdCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_prd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] onhOfcCd = (JSPUtil.getParameter(request, prefix	+ "onh_ofc_cd", length));
			String[] chssAlsNo = (JSPUtil.getParameter(request, prefix	+ "chss_als_no", length));
			String[] chssTareWgt = (JSPUtil.getParameter(request, prefix	+ "chss_tare_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chssRgstUpdDt = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_dt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] chssTitNo = (JSPUtil.getParameter(request, prefix	+ "chss_tit_no", length));
			String[] chssRgstLicNo = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_lic_no", length));
			String[] chssRgstExpDt = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_exp_dt", length));
			String[] chssRgstUpdId = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_id", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqNoTo = (JSPUtil.getParameter(request, prefix	+ "eq_no_to", length));
			String[] n2ndChssAlsNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_chss_als_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] chssRgstYr = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_yr", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] chssRgstSteCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_ste_cd", length));
			String[] chssVehIdNo = (JSPUtil.getParameter(request, prefix	+ "chss_veh_id_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSEquipmentINVO();
				if (onhYdCd[i] != null)
					model.setOnhYdCd(onhYdCd[i]);
				if (chssRgstUpdOfcCd[i] != null)
					model.setChssRgstUpdOfcCd(chssRgstUpdOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chssRgstLicNoa[i] != null)
					model.setChssRgstLicNoa(chssRgstLicNoa[i]);
				if (eqNoTmp[i] != null)
					model.setEqNoTmp(eqNoTmp[i]);
				if (eqNoFm[i] != null)
					model.setEqNoFm(eqNoFm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chssRgstPrdCd[i] != null)
					model.setChssRgstPrdCd(chssRgstPrdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (onhOfcCd[i] != null)
					model.setOnhOfcCd(onhOfcCd[i]);
				if (chssAlsNo[i] != null)
					model.setChssAlsNo(chssAlsNo[i]);
				if (chssTareWgt[i] != null)
					model.setChssTareWgt(chssTareWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chssRgstUpdDt[i] != null)
					model.setChssRgstUpdDt(chssRgstUpdDt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (chssTitNo[i] != null)
					model.setChssTitNo(chssTitNo[i]);
				if (chssRgstLicNo[i] != null)
					model.setChssRgstLicNo(chssRgstLicNo[i]);
				if (chssRgstExpDt[i] != null)
					model.setChssRgstExpDt(chssRgstExpDt[i]);
				if (chssRgstUpdId[i] != null)
					model.setChssRgstUpdId(chssRgstUpdId[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqNoTo[i] != null)
					model.setEqNoTo(eqNoTo[i]);
				if (n2ndChssAlsNo[i] != null)
					model.setN2ndChssAlsNo(n2ndChssAlsNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (chssRgstYr[i] != null)
					model.setChssRgstYr(chssRgstYr[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (chssRgstSteCd[i] != null)
					model.setChssRgstSteCd(chssRgstSteCd[i]);
				if (chssVehIdNo[i] != null)
					model.setChssVehIdNo(chssVehIdNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSEquipmentINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSEquipmentINVO[]
	 */
	public CHSEquipmentINVO[] getCHSEquipmentINVOs(){
		CHSEquipmentINVO[] vos = (CHSEquipmentINVO[])models.toArray(new CHSEquipmentINVO[models.size()]);
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
		this.onhYdCd = this.onhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdOfcCd = this.chssRgstUpdOfcCd .replaceAll(",", "").replaceAll("-","").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstLicNoa = this.chssRgstLicNoa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNoTmp = this.eqNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNoFm = this.eqNoFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstPrdCd = this.chssRgstPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhOfcCd = this.onhOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssAlsNo = this.chssAlsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTareWgt = this.chssTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdDt = this.chssRgstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTitNo = this.chssTitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstLicNo = this.chssRgstLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstExpDt = this.chssRgstExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdId = this.chssRgstUpdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNoTo = this.eqNoTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndChssAlsNo = this.n2ndChssAlsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstYr = this.chssRgstYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstSteCd = this.chssRgstSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssVehIdNo = this.chssVehIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
