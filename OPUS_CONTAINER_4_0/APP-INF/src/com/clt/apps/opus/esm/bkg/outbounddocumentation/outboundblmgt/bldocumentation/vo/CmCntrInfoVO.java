/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CmCntrInfoVO.java
*@FileTitle : CmCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.25 김영출
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

public class CmCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CmCntrInfoVO> models = new ArrayList<CmCntrInfoVO>();

	/* Column Info */
	private String cmMeasQty = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String cmPckQty = null;
	/* Column Info */
	private String advShtgCd = null;
	/* Column Info */
	private String cntrMfFlag = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmCntrWgt = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String mfCfmFlg = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String cntrVolQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CmCntrInfoVO() {}

	public CmCntrInfoVO(String ibflag, String pagerows, String bkgNo, String mfCfmFlg, String cntrNo, String cntrMfFlag, String cntrSealNo, String cntrTpszCd, String rcvTermCd, String deTermCd, String cntrVolQty, String advShtgCd, String dcgoFlg, String bbCgoFlg, String awkCgoFlg, String rcFlg, String rdCgoFlg, String hngrFlg, String pckQty, String pckTpCd, String cntrWgt, String wgtUtCd, String measQty, String measUtCd, String cmPckQty, String cmCntrWgt, String cmMeasQty, String creUsrId, String updUsrId) {
		this.cmMeasQty = cmMeasQty;
		this.rdCgoFlg = rdCgoFlg;
		this.cmPckQty = cmPckQty;
		this.advShtgCd = advShtgCd;
		this.cntrMfFlag = cntrMfFlag;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cmCntrWgt = cmCntrWgt;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.mfCfmFlg = mfCfmFlg;
		this.pckQty = pckQty;
		this.rcvTermCd = rcvTermCd;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.updUsrId = updUsrId;
		this.cntrWgt = cntrWgt;
		this.awkCgoFlg = awkCgoFlg;
		this.deTermCd = deTermCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.hngrFlg = hngrFlg;
		this.cntrSealNo = cntrSealNo;
		this.rcFlg = rcFlg;
		this.cntrVolQty = cntrVolQty;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cm_meas_qty", getCmMeasQty());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("cm_pck_qty", getCmPckQty());
		this.hashColumns.put("adv_shtg_cd", getAdvShtgCd());
		this.hashColumns.put("cntr_mf_flag", getCntrMfFlag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cm_cntr_wgt", getCmCntrWgt());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("mf_cfm_flg", getMfCfmFlg());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cm_meas_qty", "cmMeasQty");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("cm_pck_qty", "cmPckQty");
		this.hashFields.put("adv_shtg_cd", "advShtgCd");
		this.hashFields.put("cntr_mf_flag", "cntrMfFlag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cm_cntr_wgt", "cmCntrWgt");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("mf_cfm_flg", "mfCfmFlg");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cmMeasQty
	 */
	public String getCmMeasQty() {
		return this.cmMeasQty;
	}

	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}

	/**
	 * Column Info
	 * @return cmPckQty
	 */
	public String getCmPckQty() {
		return this.cmPckQty;
	}

	/**
	 * Column Info
	 * @return advShtgCd
	 */
	public String getAdvShtgCd() {
		return this.advShtgCd;
	}

	/**
	 * Column Info
	 * @return cntrMfFlag
	 */
	public String getCntrMfFlag() {
		return this.cntrMfFlag;
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
	 * @return cmCntrWgt
	 */
	public String getCmCntrWgt() {
		return this.cmCntrWgt;
	}

	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}

	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return mfCfmFlg
	 */
	public String getMfCfmFlg() {
		return this.mfCfmFlg;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}

	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}

	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}


	/**
	 * Column Info
	 * @param cmMeasQty
	 */
	public void setCmMeasQty(String cmMeasQty) {
		this.cmMeasQty = cmMeasQty;
	}

	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}

	/**
	 * Column Info
	 * @param cmPckQty
	 */
	public void setCmPckQty(String cmPckQty) {
		this.cmPckQty = cmPckQty;
	}

	/**
	 * Column Info
	 * @param advShtgCd
	 */
	public void setAdvShtgCd(String advShtgCd) {
		this.advShtgCd = advShtgCd;
	}

	/**
	 * Column Info
	 * @param cntrMfFlag
	 */
	public void setCntrMfFlag(String cntrMfFlag) {
		this.cntrMfFlag = cntrMfFlag;
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
	 * @param cmCntrWgt
	 */
	public void setCmCntrWgt(String cmCntrWgt) {
		this.cmCntrWgt = cmCntrWgt;
	}

	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}

	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param mfCfmFlg
	 */
	public void setMfCfmFlg(String mfCfmFlg) {
		this.mfCfmFlg = mfCfmFlg;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}

	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmMeasQty(JSPUtil.getParameter(request, "cm_meas_qty", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setCmPckQty(JSPUtil.getParameter(request, "cm_pck_qty", ""));
		setAdvShtgCd(JSPUtil.getParameter(request, "adv_shtg_cd", ""));
		setCntrMfFlag(JSPUtil.getParameter(request, "cntr_mf_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmCntrWgt(JSPUtil.getParameter(request, "cm_cntr_wgt", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setMfCfmFlg(JSPUtil.getParameter(request, "mf_cfm_flg", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setHngrFlg(JSPUtil.getParameter(request, "hngr_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setCntrVolQty(JSPUtil.getParameter(request, "cntr_vol_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CmCntrInfoVO[]
	 */
	public CmCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CmCntrInfoVO[]
	 */
	public CmCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CmCntrInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cmMeasQty = (JSPUtil.getParameter(request, prefix	+ "cm_meas_qty", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] cmPckQty = (JSPUtil.getParameter(request, prefix	+ "cm_pck_qty", length));
			String[] advShtgCd = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd", length));
			String[] cntrMfFlag = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmCntrWgt = (JSPUtil.getParameter(request, prefix	+ "cm_cntr_wgt", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] mfCfmFlg = (JSPUtil.getParameter(request, prefix	+ "mf_cfm_flg", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));

			for (int i = 0; i < length; i++) {
				model = new CmCntrInfoVO();
				if (cmMeasQty[i] != null)
					model.setCmMeasQty(cmMeasQty[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (cmPckQty[i] != null)
					model.setCmPckQty(cmPckQty[i]);
				if (advShtgCd[i] != null)
					model.setAdvShtgCd(advShtgCd[i]);
				if (cntrMfFlag[i] != null)
					model.setCntrMfFlag(cntrMfFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmCntrWgt[i] != null)
					model.setCmCntrWgt(cmCntrWgt[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (mfCfmFlg[i] != null)
					model.setMfCfmFlg(mfCfmFlg[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCmCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CmCntrInfoVO[]
	 */
	public CmCntrInfoVO[] getCmCntrInfoVOs(){
		CmCntrInfoVO[] vos = (CmCntrInfoVO[])models.toArray(new CmCntrInfoVO[models.size()]);
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
		this.cmMeasQty = this.cmMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPckQty = this.cmPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advShtgCd = this.advShtgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfFlag = this.cntrMfFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCntrWgt = this.cmCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfCfmFlg = this.mfCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
