/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomMnrEqRngStsVO.java
*@FileTitle : CustomMnrEqRngStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrEqRngStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrEqRngStsVO> models = new ArrayList<CustomMnrEqRngStsVO>();
	
	/* Column Info */
	private String rfMkrNm = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String fmSerNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eqRangeNo = null;
	/* Column Info */
	private String rfMdlNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqQty = null;
	/* Column Info */
	private String mnrDispSelFlg = null;
	/* Column Info */
	private String toSerNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrDispSelFlgDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eqMdlNm = null;
	/* Column Info */
	private String mftVndrNm = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fmWarrDt = null;
	/* Column Info */
	private String toWarrDt = null;
	/* Column Info */
	private String warrRmk = null;
	/* Column Info */
	private String lotEqPfxCd = null;
	/* Column Info */
	private String eqMkrNm = null;
	/* Column Info */
	private String mftYr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrEqRngStsVO() {}

	public CustomMnrEqRngStsVO(String ibflag, String pagerows, String lotEqPfxCd, String fmSerNo, String toSerNo, String mnrGrpTpCd, String eqKndCd, String eqTpszCd, String eqMkrNm, String eqMdlNm, String mnrDispSelFlg, String mnrDispSelFlgDt, String fmWarrDt, String toWarrDt, String warrRmk, String mftYr, String eqQty, String creUsrId, String creDt, String updUsrId, String updDt, String eqRangeNo, String mftVndrNm, String mftDt, String rfMkrNm, String rfMdlNm) {
		this.rfMkrNm = rfMkrNm;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.fmSerNo = fmSerNo;
		this.creDt = creDt;
		this.eqRangeNo = eqRangeNo;
		this.rfMdlNm = rfMdlNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqQty = eqQty;
		this.mnrDispSelFlg = mnrDispSelFlg;
		this.toSerNo = toSerNo;
		this.updUsrId = updUsrId;
		this.mnrDispSelFlgDt = mnrDispSelFlgDt;
		this.updDt = updDt;
		this.eqMdlNm = eqMdlNm;
		this.mftVndrNm = mftVndrNm;
		this.eqKndCd = eqKndCd;
		this.eqTpszCd = eqTpszCd;
		this.mftDt = mftDt;
		this.creUsrId = creUsrId;
		this.fmWarrDt = fmWarrDt;
		this.toWarrDt = toWarrDt;
		this.warrRmk = warrRmk;
		this.lotEqPfxCd = lotEqPfxCd;
		this.eqMkrNm = eqMkrNm;
		this.mftYr = mftYr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_mkr_nm", getRfMkrNm());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("fm_ser_no", getFmSerNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eq_range_no", getEqRangeNo());
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_qty", getEqQty());
		this.hashColumns.put("mnr_disp_sel_flg", getMnrDispSelFlg());
		this.hashColumns.put("to_ser_no", getToSerNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_disp_sel_flg_dt", getMnrDispSelFlgDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eq_mdl_nm", getEqMdlNm());
		this.hashColumns.put("mft_vndr_nm", getMftVndrNm());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fm_warr_dt", getFmWarrDt());
		this.hashColumns.put("to_warr_dt", getToWarrDt());
		this.hashColumns.put("warr_rmk", getWarrRmk());
		this.hashColumns.put("lot_eq_pfx_cd", getLotEqPfxCd());
		this.hashColumns.put("eq_mkr_nm", getEqMkrNm());
		this.hashColumns.put("mft_yr", getMftYr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_mkr_nm", "rfMkrNm");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("fm_ser_no", "fmSerNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eq_range_no", "eqRangeNo");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_qty", "eqQty");
		this.hashFields.put("mnr_disp_sel_flg", "mnrDispSelFlg");
		this.hashFields.put("to_ser_no", "toSerNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_disp_sel_flg_dt", "mnrDispSelFlgDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eq_mdl_nm", "eqMdlNm");
		this.hashFields.put("mft_vndr_nm", "mftVndrNm");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fm_warr_dt", "fmWarrDt");
		this.hashFields.put("to_warr_dt", "toWarrDt");
		this.hashFields.put("warr_rmk", "warrRmk");
		this.hashFields.put("lot_eq_pfx_cd", "lotEqPfxCd");
		this.hashFields.put("eq_mkr_nm", "eqMkrNm");
		this.hashFields.put("mft_yr", "mftYr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rfMkrNm
	 */
	public String getRfMkrNm() {
		return this.rfMkrNm;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmSerNo
	 */
	public String getFmSerNo() {
		return this.fmSerNo;
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
	 * @return eqRangeNo
	 */
	public String getEqRangeNo() {
		return this.eqRangeNo;
	}
	
	/**
	 * Column Info
	 * @return rfMdlNm
	 */
	public String getRfMdlNm() {
		return this.rfMdlNm;
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
	 * @return eqQty
	 */
	public String getEqQty() {
		return this.eqQty;
	}
	
	/**
	 * Column Info
	 * @return mnrDispSelFlg
	 */
	public String getMnrDispSelFlg() {
		return this.mnrDispSelFlg;
	}
	
	/**
	 * Column Info
	 * @return toSerNo
	 */
	public String getToSerNo() {
		return this.toSerNo;
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
	 * @return mnrDispSelFlgDt
	 */
	public String getMnrDispSelFlgDt() {
		return this.mnrDispSelFlgDt;
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
	 * @return eqMdlNm
	 */
	public String getEqMdlNm() {
		return this.eqMdlNm;
	}
	
	/**
	 * Column Info
	 * @return mftVndrNm
	 */
	public String getMftVndrNm() {
		return this.mftVndrNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return fmWarrDt
	 */
	public String getFmWarrDt() {
		return this.fmWarrDt;
	}
	
	/**
	 * Column Info
	 * @return toWarrDt
	 */
	public String getToWarrDt() {
		return this.toWarrDt;
	}
	
	/**
	 * Column Info
	 * @return warrRmk
	 */
	public String getWarrRmk() {
		return this.warrRmk;
	}
	
	/**
	 * Column Info
	 * @return lotEqPfxCd
	 */
	public String getLotEqPfxCd() {
		return this.lotEqPfxCd;
	}
	
	/**
	 * Column Info
	 * @return eqMkrNm
	 */
	public String getEqMkrNm() {
		return this.eqMkrNm;
	}
	
	/**
	 * Column Info
	 * @return mftYr
	 */
	public String getMftYr() {
		return this.mftYr;
	}
	

	/**
	 * Column Info
	 * @param rfMkrNm
	 */
	public void setRfMkrNm(String rfMkrNm) {
		this.rfMkrNm = rfMkrNm;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmSerNo
	 */
	public void setFmSerNo(String fmSerNo) {
		this.fmSerNo = fmSerNo;
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
	 * @param eqRangeNo
	 */
	public void setEqRangeNo(String eqRangeNo) {
		this.eqRangeNo = eqRangeNo;
	}
	
	/**
	 * Column Info
	 * @param rfMdlNm
	 */
	public void setRfMdlNm(String rfMdlNm) {
		this.rfMdlNm = rfMdlNm;
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
	 * @param eqQty
	 */
	public void setEqQty(String eqQty) {
		this.eqQty = eqQty;
	}
	
	/**
	 * Column Info
	 * @param mnrDispSelFlg
	 */
	public void setMnrDispSelFlg(String mnrDispSelFlg) {
		this.mnrDispSelFlg = mnrDispSelFlg;
	}
	
	/**
	 * Column Info
	 * @param toSerNo
	 */
	public void setToSerNo(String toSerNo) {
		this.toSerNo = toSerNo;
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
	 * @param mnrDispSelFlgDt
	 */
	public void setMnrDispSelFlgDt(String mnrDispSelFlgDt) {
		this.mnrDispSelFlgDt = mnrDispSelFlgDt;
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
	 * @param eqMdlNm
	 */
	public void setEqMdlNm(String eqMdlNm) {
		this.eqMdlNm = eqMdlNm;
	}
	
	/**
	 * Column Info
	 * @param mftVndrNm
	 */
	public void setMftVndrNm(String mftVndrNm) {
		this.mftVndrNm = mftVndrNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param fmWarrDt
	 */
	public void setFmWarrDt(String fmWarrDt) {
		this.fmWarrDt = fmWarrDt;
	}
	
	/**
	 * Column Info
	 * @param toWarrDt
	 */
	public void setToWarrDt(String toWarrDt) {
		this.toWarrDt = toWarrDt;
	}
	
	/**
	 * Column Info
	 * @param warrRmk
	 */
	public void setWarrRmk(String warrRmk) {
		this.warrRmk = warrRmk;
	}
	
	/**
	 * Column Info
	 * @param lotEqPfxCd
	 */
	public void setLotEqPfxCd(String lotEqPfxCd) {
		this.lotEqPfxCd = lotEqPfxCd;
	}
	
	/**
	 * Column Info
	 * @param eqMkrNm
	 */
	public void setEqMkrNm(String eqMkrNm) {
		this.eqMkrNm = eqMkrNm;
	}
	
	/**
	 * Column Info
	 * @param mftYr
	 */
	public void setMftYr(String mftYr) {
		this.mftYr = mftYr;
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
		setRfMkrNm(JSPUtil.getParameter(request, prefix + "rf_mkr_nm", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, prefix + "mnr_grp_tp_cd", ""));
		setFmSerNo(JSPUtil.getParameter(request, prefix + "fm_ser_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEqRangeNo(JSPUtil.getParameter(request, prefix + "eq_range_no", ""));
		setRfMdlNm(JSPUtil.getParameter(request, prefix + "rf_mdl_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqQty(JSPUtil.getParameter(request, prefix + "eq_qty", ""));
		setMnrDispSelFlg(JSPUtil.getParameter(request, prefix + "mnr_disp_sel_flg", ""));
		setToSerNo(JSPUtil.getParameter(request, prefix + "to_ser_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMnrDispSelFlgDt(JSPUtil.getParameter(request, prefix + "mnr_disp_sel_flg_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEqMdlNm(JSPUtil.getParameter(request, prefix + "eq_mdl_nm", ""));
		setMftVndrNm(JSPUtil.getParameter(request, prefix + "mft_vndr_nm", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setMftDt(JSPUtil.getParameter(request, prefix + "mft_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFmWarrDt(JSPUtil.getParameter(request, prefix + "fm_warr_dt", ""));
		setToWarrDt(JSPUtil.getParameter(request, prefix + "to_warr_dt", ""));
		setWarrRmk(JSPUtil.getParameter(request, prefix + "warr_rmk", ""));
		setLotEqPfxCd(JSPUtil.getParameter(request, prefix + "lot_eq_pfx_cd", ""));
		setEqMkrNm(JSPUtil.getParameter(request, prefix + "eq_mkr_nm", ""));
		setMftYr(JSPUtil.getParameter(request, prefix + "mft_yr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrEqRngStsVO[]
	 */
	public CustomMnrEqRngStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrEqRngStsVO[]
	 */
	public CustomMnrEqRngStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrEqRngStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfMkrNm = (JSPUtil.getParameter(request, prefix	+ "rf_mkr_nm", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] fmSerNo = (JSPUtil.getParameter(request, prefix	+ "fm_ser_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eqRangeNo = (JSPUtil.getParameter(request, prefix	+ "eq_range_no", length));
			String[] rfMdlNm = (JSPUtil.getParameter(request, prefix	+ "rf_mdl_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqQty = (JSPUtil.getParameter(request, prefix	+ "eq_qty", length));
			String[] mnrDispSelFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_sel_flg", length));
			String[] toSerNo = (JSPUtil.getParameter(request, prefix	+ "to_ser_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrDispSelFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_sel_flg_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eqMdlNm = (JSPUtil.getParameter(request, prefix	+ "eq_mdl_nm", length));
			String[] mftVndrNm = (JSPUtil.getParameter(request, prefix	+ "mft_vndr_nm", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fmWarrDt = (JSPUtil.getParameter(request, prefix	+ "fm_warr_dt", length));
			String[] toWarrDt = (JSPUtil.getParameter(request, prefix	+ "to_warr_dt", length));
			String[] warrRmk = (JSPUtil.getParameter(request, prefix	+ "warr_rmk", length));
			String[] lotEqPfxCd = (JSPUtil.getParameter(request, prefix	+ "lot_eq_pfx_cd", length));
			String[] eqMkrNm = (JSPUtil.getParameter(request, prefix	+ "eq_mkr_nm", length));
			String[] mftYr = (JSPUtil.getParameter(request, prefix	+ "mft_yr", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrEqRngStsVO();
				if (rfMkrNm[i] != null)
					model.setRfMkrNm(rfMkrNm[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (fmSerNo[i] != null)
					model.setFmSerNo(fmSerNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eqRangeNo[i] != null)
					model.setEqRangeNo(eqRangeNo[i]);
				if (rfMdlNm[i] != null)
					model.setRfMdlNm(rfMdlNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqQty[i] != null)
					model.setEqQty(eqQty[i]);
				if (mnrDispSelFlg[i] != null)
					model.setMnrDispSelFlg(mnrDispSelFlg[i]);
				if (toSerNo[i] != null)
					model.setToSerNo(toSerNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrDispSelFlgDt[i] != null)
					model.setMnrDispSelFlgDt(mnrDispSelFlgDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eqMdlNm[i] != null)
					model.setEqMdlNm(eqMdlNm[i]);
				if (mftVndrNm[i] != null)
					model.setMftVndrNm(mftVndrNm[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fmWarrDt[i] != null)
					model.setFmWarrDt(fmWarrDt[i]);
				if (toWarrDt[i] != null)
					model.setToWarrDt(toWarrDt[i]);
				if (warrRmk[i] != null)
					model.setWarrRmk(warrRmk[i]);
				if (lotEqPfxCd[i] != null)
					model.setLotEqPfxCd(lotEqPfxCd[i]);
				if (eqMkrNm[i] != null)
					model.setEqMkrNm(eqMkrNm[i]);
				if (mftYr[i] != null)
					model.setMftYr(mftYr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrEqRngStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrEqRngStsVO[]
	 */
	public CustomMnrEqRngStsVO[] getCustomMnrEqRngStsVOs(){
		CustomMnrEqRngStsVO[] vos = (CustomMnrEqRngStsVO[])models.toArray(new CustomMnrEqRngStsVO[models.size()]);
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
		this.rfMkrNm = this.rfMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSerNo = this.fmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRangeNo = this.eqRangeNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm = this.rfMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqQty = this.eqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispSelFlg = this.mnrDispSelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSerNo = this.toSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispSelFlgDt = this.mnrDispSelFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMdlNm = this.eqMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftVndrNm = this.mftVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWarrDt = this.fmWarrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWarrDt = this.toWarrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.warrRmk = this.warrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotEqPfxCd = this.lotEqPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMkrNm = this.eqMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftYr = this.mftYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
