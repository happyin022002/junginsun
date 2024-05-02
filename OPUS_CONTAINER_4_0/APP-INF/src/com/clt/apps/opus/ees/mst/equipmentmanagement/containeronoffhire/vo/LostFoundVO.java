/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LostFoundVO.java
*@FileTitle : LostFoundVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.07.31 민정호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LostFoundVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LostFoundVO> models = new ArrayList<LostFoundVO>();
	
	/* Column Info */
	private String inputCntrStsEvntDt = null;
	/* Column Info */
	private String inputCntrStsCd = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String hOnhYdCd = null;
	/* Column Info */
	private String hCntrStsCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hChk3 = null;
	/* Column Info */
	private String hChk2 = null;
	/* Column Info */
	private String hChk1 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String hCnmvEvntDt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hLstStsSeq = null;
	/* Column Info */
	private String cntrStsEvntDt = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String hSave = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hLstStsYdCd = null;
	/* Column Info */
	private String lstStsYdCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String cntrRmk = null;
	/* Column Info */
	private String inputOnhYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LostFoundVO() {}

	public LostFoundVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String lstmCd, String vndrSeq, String vndrLglEngNm, String cntrStsCd, String cntrStsEvntDt, String lstStsYdCd, String fullFlg, String cnmvStsCd, String crntYdCd, String cnmvDt, String cntrRmk, String hOnhYdCd, String hCntrStsCd, String hCnmvEvntDt, String hLstStsYdCd, String hLstStsSeq, String hChk1, String hChk2, String hChk3, String hSave, String ofcCd, String creUsrId, String updUsrId, String inputCntrStsCd, String inputCntrStsEvntDt, String inputOnhYdCd) {
		this.inputCntrStsEvntDt = inputCntrStsEvntDt;
		this.inputCntrStsCd = inputCntrStsCd;
		this.cntrStsCd = cntrStsCd;
		this.hOnhYdCd = hOnhYdCd;
		this.hCntrStsCd = hCntrStsCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.crntYdCd = crntYdCd;
		this.pagerows = pagerows;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.hChk3 = hChk3;
		this.hChk2 = hChk2;
		this.hChk1 = hChk1;
		this.cntrTpszCd = cntrTpszCd;
		this.hCnmvEvntDt = hCnmvEvntDt;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.hLstStsSeq = hLstStsSeq;
		this.cntrStsEvntDt = cntrStsEvntDt;
		this.cnmvDt = cnmvDt;
		this.hSave = hSave;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.hLstStsYdCd = hLstStsYdCd;
		this.lstStsYdCd = lstStsYdCd;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.fullFlg = fullFlg;
		this.cntrRmk = cntrRmk;
		this.inputOnhYdCd = inputOnhYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("input_cntr_sts_evnt_dt", getInputCntrStsEvntDt());
		this.hashColumns.put("input_cntr_sts_cd", getInputCntrStsCd());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("h_onh_yd_cd", getHOnhYdCd());
		this.hashColumns.put("h_cntr_sts_cd", getHCntrStsCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("h_chk3", getHChk3());
		this.hashColumns.put("h_chk2", getHChk2());
		this.hashColumns.put("h_chk1", getHChk1());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("h_cnmv_evnt_dt", getHCnmvEvntDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("h_lst_sts_seq", getHLstStsSeq());
		this.hashColumns.put("cntr_sts_evnt_dt", getCntrStsEvntDt());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("h_save", getHSave());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("h_lst_sts_yd_cd", getHLstStsYdCd());
		this.hashColumns.put("lst_sts_yd_cd", getLstStsYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("cntr_rmk", getCntrRmk());
		this.hashColumns.put("input_onh_yd_cd", getInputOnhYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("input_cntr_sts_evnt_dt", "inputCntrStsEvntDt");
		this.hashFields.put("input_cntr_sts_cd", "inputCntrStsCd");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("h_onh_yd_cd", "hOnhYdCd");
		this.hashFields.put("h_cntr_sts_cd", "hCntrStsCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("h_chk3", "hChk3");
		this.hashFields.put("h_chk2", "hChk2");
		this.hashFields.put("h_chk1", "hChk1");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("h_cnmv_evnt_dt", "hCnmvEvntDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("h_lst_sts_seq", "hLstStsSeq");
		this.hashFields.put("cntr_sts_evnt_dt", "cntrStsEvntDt");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("h_save", "hSave");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("h_lst_sts_yd_cd", "hLstStsYdCd");
		this.hashFields.put("lst_sts_yd_cd", "lstStsYdCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("cntr_rmk", "cntrRmk");
		this.hashFields.put("input_onh_yd_cd", "inputOnhYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inputCntrStsEvntDt
	 */
	public String getInputCntrStsEvntDt() {
		return this.inputCntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @return inputCntrStsCd
	 */
	public String getInputCntrStsCd() {
		return this.inputCntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return hOnhYdCd
	 */
	public String getHOnhYdCd() {
		return this.hOnhYdCd;
	}
	
	/**
	 * Column Info
	 * @return hCntrStsCd
	 */
	public String getHCntrStsCd() {
		return this.hCntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
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
	 * @return hChk3
	 */
	public String getHChk3() {
		return this.hChk3;
	}
	
	/**
	 * Column Info
	 * @return hChk2
	 */
	public String getHChk2() {
		return this.hChk2;
	}
	
	/**
	 * Column Info
	 * @return hChk1
	 */
	public String getHChk1() {
		return this.hChk1;
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
	 * @return hCnmvEvntDt
	 */
	public String getHCnmvEvntDt() {
		return this.hCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return hLstStsSeq
	 */
	public String getHLstStsSeq() {
		return this.hLstStsSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrStsEvntDt
	 */
	public String getCntrStsEvntDt() {
		return this.cntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvDt
	 */
	public String getCnmvDt() {
		return this.cnmvDt;
	}
	
	/**
	 * Column Info
	 * @return hSave
	 */
	public String getHSave() {
		return this.hSave;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return hLstStsYdCd
	 */
	public String getHLstStsYdCd() {
		return this.hLstStsYdCd;
	}
	
	/**
	 * Column Info
	 * @return lstStsYdCd
	 */
	public String getLstStsYdCd() {
		return this.lstStsYdCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return fullFlg
	 */
	public String getFullFlg() {
		return this.fullFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrRmk
	 */
	public String getCntrRmk() {
		return this.cntrRmk;
	}
	
	/**
	 * Column Info
	 * @return inputOnhYdCd
	 */
	public String getInputOnhYdCd() {
		return this.inputOnhYdCd;
	}
	

	/**
	 * Column Info
	 * @param inputCntrStsEvntDt
	 */
	public void setInputCntrStsEvntDt(String inputCntrStsEvntDt) {
		this.inputCntrStsEvntDt = inputCntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @param inputCntrStsCd
	 */
	public void setInputCntrStsCd(String inputCntrStsCd) {
		this.inputCntrStsCd = inputCntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param hOnhYdCd
	 */
	public void setHOnhYdCd(String hOnhYdCd) {
		this.hOnhYdCd = hOnhYdCd;
	}
	
	/**
	 * Column Info
	 * @param hCntrStsCd
	 */
	public void setHCntrStsCd(String hCntrStsCd) {
		this.hCntrStsCd = hCntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
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
	 * @param hChk3
	 */
	public void setHChk3(String hChk3) {
		this.hChk3 = hChk3;
	}
	
	/**
	 * Column Info
	 * @param hChk2
	 */
	public void setHChk2(String hChk2) {
		this.hChk2 = hChk2;
	}
	
	/**
	 * Column Info
	 * @param hChk1
	 */
	public void setHChk1(String hChk1) {
		this.hChk1 = hChk1;
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
	 * @param hCnmvEvntDt
	 */
	public void setHCnmvEvntDt(String hCnmvEvntDt) {
		this.hCnmvEvntDt = hCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param hLstStsSeq
	 */
	public void setHLstStsSeq(String hLstStsSeq) {
		this.hLstStsSeq = hLstStsSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrStsEvntDt
	 */
	public void setCntrStsEvntDt(String cntrStsEvntDt) {
		this.cntrStsEvntDt = cntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvDt
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
	}
	
	/**
	 * Column Info
	 * @param hSave
	 */
	public void setHSave(String hSave) {
		this.hSave = hSave;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param hLstStsYdCd
	 */
	public void setHLstStsYdCd(String hLstStsYdCd) {
		this.hLstStsYdCd = hLstStsYdCd;
	}
	
	/**
	 * Column Info
	 * @param lstStsYdCd
	 */
	public void setLstStsYdCd(String lstStsYdCd) {
		this.lstStsYdCd = lstStsYdCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param fullFlg
	 */
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrRmk
	 */
	public void setCntrRmk(String cntrRmk) {
		this.cntrRmk = cntrRmk;
	}
	
	/**
	 * Column Info
	 * @param inputOnhYdCd
	 */
	public void setInputOnhYdCd(String inputOnhYdCd) {
		this.inputOnhYdCd = inputOnhYdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInputCntrStsEvntDt(JSPUtil.getParameter(request, "input_cntr_sts_evnt_dt", ""));
		setInputCntrStsCd(JSPUtil.getParameter(request, "input_cntr_sts_cd", ""));
		setCntrStsCd(JSPUtil.getParameter(request, "cntr_sts_cd", ""));
		setHOnhYdCd(JSPUtil.getParameter(request, "h_onh_yd_cd", ""));
		setHCntrStsCd(JSPUtil.getParameter(request, "h_cntr_sts_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHChk3(JSPUtil.getParameter(request, "h_chk3", ""));
		setHChk2(JSPUtil.getParameter(request, "h_chk2", ""));
		setHChk1(JSPUtil.getParameter(request, "h_chk1", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setHCnmvEvntDt(JSPUtil.getParameter(request, "h_cnmv_evnt_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setHLstStsSeq(JSPUtil.getParameter(request, "h_lst_sts_seq", ""));
		setCntrStsEvntDt(JSPUtil.getParameter(request, "cntr_sts_evnt_dt", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setHSave(JSPUtil.getParameter(request, "h_save", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setHLstStsYdCd(JSPUtil.getParameter(request, "h_lst_sts_yd_cd", ""));
		setLstStsYdCd(JSPUtil.getParameter(request, "lst_sts_yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setCntrRmk(JSPUtil.getParameter(request, "cntr_rmk", ""));
		setInputOnhYdCd(JSPUtil.getParameter(request, "input_onh_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LostFoundVO[]
	 */
	public LostFoundVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LostFoundVO[]
	 */
	public LostFoundVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LostFoundVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inputCntrStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "input_cntr_sts_evnt_dt", length));
			String[] inputCntrStsCd = (JSPUtil.getParameter(request, prefix	+ "input_cntr_sts_cd", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] hOnhYdCd = (JSPUtil.getParameter(request, prefix	+ "h_onh_yd_cd", length));
			String[] hCntrStsCd = (JSPUtil.getParameter(request, prefix	+ "h_cntr_sts_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hChk3 = (JSPUtil.getParameter(request, prefix	+ "h_chk3", length));
			String[] hChk2 = (JSPUtil.getParameter(request, prefix	+ "h_chk2", length));
			String[] hChk1 = (JSPUtil.getParameter(request, prefix	+ "h_chk1", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] hCnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "h_cnmv_evnt_dt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hLstStsSeq = (JSPUtil.getParameter(request, prefix	+ "h_lst_sts_seq", length));
			String[] cntrStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_evnt_dt", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] hSave = (JSPUtil.getParameter(request, prefix	+ "h_save", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hLstStsYdCd = (JSPUtil.getParameter(request, prefix	+ "h_lst_sts_yd_cd", length));
			String[] lstStsYdCd = (JSPUtil.getParameter(request, prefix	+ "lst_sts_yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] cntrRmk = (JSPUtil.getParameter(request, prefix	+ "cntr_rmk", length));
			String[] inputOnhYdCd = (JSPUtil.getParameter(request, prefix	+ "input_onh_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new LostFoundVO();
				if (inputCntrStsEvntDt[i] != null)
					model.setInputCntrStsEvntDt(inputCntrStsEvntDt[i]);
				if (inputCntrStsCd[i] != null)
					model.setInputCntrStsCd(inputCntrStsCd[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (hOnhYdCd[i] != null)
					model.setHOnhYdCd(hOnhYdCd[i]);
				if (hCntrStsCd[i] != null)
					model.setHCntrStsCd(hCntrStsCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hChk3[i] != null)
					model.setHChk3(hChk3[i]);
				if (hChk2[i] != null)
					model.setHChk2(hChk2[i]);
				if (hChk1[i] != null)
					model.setHChk1(hChk1[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (hCnmvEvntDt[i] != null)
					model.setHCnmvEvntDt(hCnmvEvntDt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hLstStsSeq[i] != null)
					model.setHLstStsSeq(hLstStsSeq[i]);
				if (cntrStsEvntDt[i] != null)
					model.setCntrStsEvntDt(cntrStsEvntDt[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (hSave[i] != null)
					model.setHSave(hSave[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hLstStsYdCd[i] != null)
					model.setHLstStsYdCd(hLstStsYdCd[i]);
				if (lstStsYdCd[i] != null)
					model.setLstStsYdCd(lstStsYdCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (cntrRmk[i] != null)
					model.setCntrRmk(cntrRmk[i]);
				if (inputOnhYdCd[i] != null)
					model.setInputOnhYdCd(inputOnhYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLostFoundVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LostFoundVO[]
	 */
	public LostFoundVO[] getLostFoundVOs(){
		LostFoundVO[] vos = (LostFoundVO[])models.toArray(new LostFoundVO[models.size()]);
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
		this.inputCntrStsEvntDt = this.inputCntrStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputCntrStsCd = this.inputCntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hOnhYdCd = this.hOnhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCntrStsCd = this.hCntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hChk3 = this.hChk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hChk2 = this.hChk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hChk1 = this.hChk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCnmvEvntDt = this.hCnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hLstStsSeq = this.hLstStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsEvntDt = this.cntrStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hSave = this.hSave .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hLstStsYdCd = this.hLstStsYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstStsYdCd = this.lstStsYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRmk = this.cntrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputOnhYdCd = this.inputOnhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
