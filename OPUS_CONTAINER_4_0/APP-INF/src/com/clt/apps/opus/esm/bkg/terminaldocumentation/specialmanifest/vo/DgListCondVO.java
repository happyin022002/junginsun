/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DgListCondVO.java
*@FileTitle : DgListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.05.02 이종길 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

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
 * @author 이종길
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DgListCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DgListCondVO> models = new ArrayList<DgListCondVO>();
	
	/* Column Info */
	private String bargeFlag = null;
	/* Column Info */
	private String frmFwrdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String frmBrthYdCd = null;
	/* Column Info */
	private String frmSpclCgoPrnrClzFlg = null;
	/* Column Info */
	private String appendFlag = null;
	/* Column Info */
	private String dType = null;
	/* Column Info */
	private String podCode = null;
	/* Column Info */
	private String frmVslCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String blNumber = null;
	/* Column Info */
	private String searchType = null;
	/* Column Info */
	private String frmImdgUnNo = null;
	/* Column Info */
	private String polCode = null;
	/* Column Info */
	private String dgListCopyFlag = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String bayPlnId = null;
	/* Column Info */
	private String uiType = null;
	/* Column Info */
	private String cargoOperCd = null;
	/* Column Info */
	private String cellPsnNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String autoUpdate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DgListCondVO() {}

	public DgListCondVO(String ibflag, String pagerows, String frmImdgUnNo, String dgListCopyFlag, String bayPlnId, String appendFlag, String searchType, String blNo, String frmVslCd, String ofcCd, String vvdCd, String frmBrthYdCd, String dType, String portCd, String bargeFlag, String uiType, String frmFwrdCd, String frmSpclCgoPrnrClzFlg, String updUsrId, String cntrNo, String cellPsnNo, String cargoOperCd, String polCode, String podCode, String blNumber, String autoUpdate) {
		this.bargeFlag = bargeFlag;
		this.frmFwrdCd = frmFwrdCd;
		this.ibflag = ibflag;
		this.blNo = blNo;
		this.updUsrId = updUsrId;
		this.vvdCd = vvdCd;
		this.frmBrthYdCd = frmBrthYdCd;
		this.frmSpclCgoPrnrClzFlg = frmSpclCgoPrnrClzFlg;
		this.appendFlag = appendFlag;
		this.dType = dType;
		this.podCode = podCode;
		this.frmVslCd = frmVslCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.blNumber = blNumber;
		this.searchType = searchType;
		this.frmImdgUnNo = frmImdgUnNo;
		this.polCode = polCode;
		this.dgListCopyFlag = dgListCopyFlag;
		this.portCd = portCd;
		this.bayPlnId = bayPlnId;
		this.uiType = uiType;
		this.cargoOperCd = cargoOperCd;
		this.cellPsnNo = cellPsnNo;
		this.cntrNo = cntrNo;
		this.autoUpdate = autoUpdate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("barge_flag", getBargeFlag());
		this.hashColumns.put("frm_fwrd_cd", getFrmFwrdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("frm_brth_yd_cd", getFrmBrthYdCd());
		this.hashColumns.put("frm_spcl_cgo_prnr_clz_flg", getFrmSpclCgoPrnrClzFlg());
		this.hashColumns.put("append_flag", getAppendFlag());
		this.hashColumns.put("d_type", getDType());
		this.hashColumns.put("pod_code", getPodCode());
		this.hashColumns.put("frm_vsl_cd", getFrmVslCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bl_number", getBlNumber());
		this.hashColumns.put("search_type", getSearchType());
		this.hashColumns.put("frm_imdg_un_no", getFrmImdgUnNo());
		this.hashColumns.put("pol_code", getPolCode());
		this.hashColumns.put("dg_list_copy_flag", getDgListCopyFlag());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("bay_pln_id", getBayPlnId());
		this.hashColumns.put("ui_type", getUiType());
		this.hashColumns.put("cargo_oper_cd", getCargoOperCd());
		this.hashColumns.put("cell_psn_no", getCellPsnNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("auto_update", getAutoUpdate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("barge_flag", "bargeFlag");
		this.hashFields.put("frm_fwrd_cd", "frmFwrdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("frm_brth_yd_cd", "frmBrthYdCd");
		this.hashFields.put("frm_spcl_cgo_prnr_clz_flg", "frmSpclCgoPrnrClzFlg");
		this.hashFields.put("append_flag", "appendFlag");
		this.hashFields.put("d_type", "dType");
		this.hashFields.put("pod_code", "podCode");
		this.hashFields.put("frm_vsl_cd", "frmVslCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bl_number", "blNumber");
		this.hashFields.put("search_type", "searchType");
		this.hashFields.put("frm_imdg_un_no", "frmImdgUnNo");
		this.hashFields.put("pol_code", "polCode");
		this.hashFields.put("dg_list_copy_flag", "dgListCopyFlag");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("bay_pln_id", "bayPlnId");
		this.hashFields.put("ui_type", "uiType");
		this.hashFields.put("cargo_oper_cd", "cargoOperCd");
		this.hashFields.put("cell_psn_no", "cellPsnNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("auto_update", "autoUpdate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bargeFlag
	 */
	public String getBargeFlag() {
		return this.bargeFlag;
	}
	
	/**
	 * Column Info
	 * @return frmFwrdCd
	 */
	public String getFrmFwrdCd() {
		return this.frmFwrdCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return frmBrthYdCd
	 */
	public String getFrmBrthYdCd() {
		return this.frmBrthYdCd;
	}
	
	/**
	 * Column Info
	 * @return frmSpclCgoPrnrClzFlg
	 */
	public String getFrmSpclCgoPrnrClzFlg() {
		return this.frmSpclCgoPrnrClzFlg;
	}
	
	/**
	 * Column Info
	 * @return appendFlag
	 */
	public String getAppendFlag() {
		return this.appendFlag;
	}
	
	/**
	 * Column Info
	 * @return dType
	 */
	public String getDType() {
		return this.dType;
	}
	
	/**
	 * Column Info
	 * @return podCode
	 */
	public String getPodCode() {
		return this.podCode;
	}
	
	/**
	 * Column Info
	 * @return frmVslCd
	 */
	public String getFrmVslCd() {
		return this.frmVslCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return blNumber
	 */
	public String getBlNumber() {
		return this.blNumber;
	}
	
	/**
	 * Column Info
	 * @return searchType
	 */
	public String getSearchType() {
		return this.searchType;
	}
	
	/**
	 * Column Info
	 * @return frmImdgUnNo
	 */
	public String getFrmImdgUnNo() {
		return this.frmImdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return polCode
	 */
	public String getPolCode() {
		return this.polCode;
	}
	
	/**
	 * Column Info
	 * @return dgListCopyFlag
	 */
	public String getDgListCopyFlag() {
		return this.dgListCopyFlag;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return bayPlnId
	 */
	public String getBayPlnId() {
		return this.bayPlnId;
	}
	
	/**
	 * Column Info
	 * @return uiType
	 */
	public String getUiType() {
		return this.uiType;
	}
	
	/**
	 * Column Info
	 * @return cargoOperCd
	 */
	public String getCargoOperCd() {
		return this.cargoOperCd;
	}
	
	/**
	 * Column Info
	 * @return cellPsnNo
	 */
	public String getCellPsnNo() {
		return this.cellPsnNo;
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
	 * @return autoUpdate
	 */
	public String getAutoUpdate() {
		return this.autoUpdate;
	}
	

	/**
	 * Column Info
	 * @param bargeFlag
	 */
	public void setBargeFlag(String bargeFlag) {
		this.bargeFlag = bargeFlag;
	}
	
	/**
	 * Column Info
	 * @param frmFwrdCd
	 */
	public void setFrmFwrdCd(String frmFwrdCd) {
		this.frmFwrdCd = frmFwrdCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param frmBrthYdCd
	 */
	public void setFrmBrthYdCd(String frmBrthYdCd) {
		this.frmBrthYdCd = frmBrthYdCd;
	}
	
	/**
	 * Column Info
	 * @param frmSpclCgoPrnrClzFlg
	 */
	public void setFrmSpclCgoPrnrClzFlg(String frmSpclCgoPrnrClzFlg) {
		this.frmSpclCgoPrnrClzFlg = frmSpclCgoPrnrClzFlg;
	}
	
	/**
	 * Column Info
	 * @param appendFlag
	 */
	public void setAppendFlag(String appendFlag) {
		this.appendFlag = appendFlag;
	}
	
	/**
	 * Column Info
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType;
	}
	
	/**
	 * Column Info
	 * @param podCode
	 */
	public void setPodCode(String podCode) {
		this.podCode = podCode;
	}
	
	/**
	 * Column Info
	 * @param frmVslCd
	 */
	public void setFrmVslCd(String frmVslCd) {
		this.frmVslCd = frmVslCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param blNumber
	 */
	public void setBlNumber(String blNumber) {
		this.blNumber = blNumber;
	}
	
	/**
	 * Column Info
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	/**
	 * Column Info
	 * @param frmImdgUnNo
	 */
	public void setFrmImdgUnNo(String frmImdgUnNo) {
		this.frmImdgUnNo = frmImdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param polCode
	 */
	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}
	
	/**
	 * Column Info
	 * @param dgListCopyFlag
	 */
	public void setDgListCopyFlag(String dgListCopyFlag) {
		this.dgListCopyFlag = dgListCopyFlag;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param bayPlnId
	 */
	public void setBayPlnId(String bayPlnId) {
		this.bayPlnId = bayPlnId;
	}
	
	/**
	 * Column Info
	 * @param uiType
	 */
	public void setUiType(String uiType) {
		this.uiType = uiType;
	}
	
	/**
	 * Column Info
	 * @param cargoOperCd
	 */
	public void setCargoOperCd(String cargoOperCd) {
		this.cargoOperCd = cargoOperCd;
	}
	
	/**
	 * Column Info
	 * @param cellPsnNo
	 */
	public void setCellPsnNo(String cellPsnNo) {
		this.cellPsnNo = cellPsnNo;
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
	 * @param autoUpdate
	 */
	public void setAutoUpdate(String autoUpdate) {
		this.autoUpdate = autoUpdate;
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
		setBargeFlag(JSPUtil.getParameter(request, prefix + "barge_flag", ""));
		setFrmFwrdCd(JSPUtil.getParameter(request, prefix + "frm_fwrd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setFrmBrthYdCd(JSPUtil.getParameter(request, prefix + "frm_brth_yd_cd", ""));
		setFrmSpclCgoPrnrClzFlg(JSPUtil.getParameter(request, prefix + "frm_spcl_cgo_prnr_clz_flg", ""));
		setAppendFlag(JSPUtil.getParameter(request, prefix + "append_flag", ""));
		setDType(JSPUtil.getParameter(request, prefix + "d_type", ""));
		setPodCode(JSPUtil.getParameter(request, prefix + "pod_code", ""));
		setFrmVslCd(JSPUtil.getParameter(request, prefix + "frm_vsl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBlNumber(JSPUtil.getParameter(request, prefix + "bl_number", ""));
		setSearchType(JSPUtil.getParameter(request, prefix + "search_type", ""));
		setFrmImdgUnNo(JSPUtil.getParameter(request, prefix + "frm_imdg_un_no", ""));
		setPolCode(JSPUtil.getParameter(request, prefix + "pol_code", ""));
		setDgListCopyFlag(JSPUtil.getParameter(request, prefix + "dg_list_copy_flag", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setBayPlnId(JSPUtil.getParameter(request, prefix + "bay_pln_id", ""));
		setUiType(JSPUtil.getParameter(request, prefix + "ui_type", ""));
		setCargoOperCd(JSPUtil.getParameter(request, prefix + "cargo_oper_cd", ""));
		setCellPsnNo(JSPUtil.getParameter(request, prefix + "cell_psn_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setAutoUpdate(JSPUtil.getParameter(request, prefix + "auto_update", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgListCondVO[]
	 */
	public DgListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DgListCondVO[]
	 */
	public DgListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bargeFlag = (JSPUtil.getParameter(request, prefix	+ "barge_flag", length));
			String[] frmFwrdCd = (JSPUtil.getParameter(request, prefix	+ "frm_fwrd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] frmBrthYdCd = (JSPUtil.getParameter(request, prefix	+ "frm_brth_yd_cd", length));
			String[] frmSpclCgoPrnrClzFlg = (JSPUtil.getParameter(request, prefix	+ "frm_spcl_cgo_prnr_clz_flg", length));
			String[] appendFlag = (JSPUtil.getParameter(request, prefix	+ "append_flag", length));
			String[] dType = (JSPUtil.getParameter(request, prefix	+ "d_type", length));
			String[] podCode = (JSPUtil.getParameter(request, prefix	+ "pod_code", length));
			String[] frmVslCd = (JSPUtil.getParameter(request, prefix	+ "frm_vsl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] blNumber = (JSPUtil.getParameter(request, prefix	+ "bl_number", length));
			String[] searchType = (JSPUtil.getParameter(request, prefix	+ "search_type", length));
			String[] frmImdgUnNo = (JSPUtil.getParameter(request, prefix	+ "frm_imdg_un_no", length));
			String[] polCode = (JSPUtil.getParameter(request, prefix	+ "pol_code", length));
			String[] dgListCopyFlag = (JSPUtil.getParameter(request, prefix	+ "dg_list_copy_flag", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] bayPlnId = (JSPUtil.getParameter(request, prefix	+ "bay_pln_id", length));
			String[] uiType = (JSPUtil.getParameter(request, prefix	+ "ui_type", length));
			String[] cargoOperCd = (JSPUtil.getParameter(request, prefix	+ "cargo_oper_cd", length));
			String[] cellPsnNo = (JSPUtil.getParameter(request, prefix	+ "cell_psn_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] autoUpdate = (JSPUtil.getParameter(request, prefix	+ "auto_update", length));
			
			for (int i = 0; i < length; i++) {
				model = new DgListCondVO();
				if (bargeFlag[i] != null)
					model.setBargeFlag(bargeFlag[i]);
				if (frmFwrdCd[i] != null)
					model.setFrmFwrdCd(frmFwrdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (frmBrthYdCd[i] != null)
					model.setFrmBrthYdCd(frmBrthYdCd[i]);
				if (frmSpclCgoPrnrClzFlg[i] != null)
					model.setFrmSpclCgoPrnrClzFlg(frmSpclCgoPrnrClzFlg[i]);
				if (appendFlag[i] != null)
					model.setAppendFlag(appendFlag[i]);
				if (dType[i] != null)
					model.setDType(dType[i]);
				if (podCode[i] != null)
					model.setPodCode(podCode[i]);
				if (frmVslCd[i] != null)
					model.setFrmVslCd(frmVslCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (blNumber[i] != null)
					model.setBlNumber(blNumber[i]);
				if (searchType[i] != null)
					model.setSearchType(searchType[i]);
				if (frmImdgUnNo[i] != null)
					model.setFrmImdgUnNo(frmImdgUnNo[i]);
				if (polCode[i] != null)
					model.setPolCode(polCode[i]);
				if (dgListCopyFlag[i] != null)
					model.setDgListCopyFlag(dgListCopyFlag[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (bayPlnId[i] != null)
					model.setBayPlnId(bayPlnId[i]);
				if (uiType[i] != null)
					model.setUiType(uiType[i]);
				if (cargoOperCd[i] != null)
					model.setCargoOperCd(cargoOperCd[i]);
				if (cellPsnNo[i] != null)
					model.setCellPsnNo(cellPsnNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (autoUpdate[i] != null)
					model.setAutoUpdate(autoUpdate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgListCondVO[]
	 */
	public DgListCondVO[] getDgListCondVOs(){
		DgListCondVO[] vos = (DgListCondVO[])models.toArray(new DgListCondVO[models.size()]);
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
		this.bargeFlag = this.bargeFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmFwrdCd = this.frmFwrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmBrthYdCd = this.frmBrthYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSpclCgoPrnrClzFlg = this.frmSpclCgoPrnrClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appendFlag = this.appendFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dType = this.dType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCode = this.podCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmVslCd = this.frmVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNumber = this.blNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchType = this.searchType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmImdgUnNo = this.frmImdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCode = this.polCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgListCopyFlag = this.dgListCopyFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayPlnId = this.bayPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiType = this.uiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoOperCd = this.cargoOperCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cellPsnNo = this.cellPsnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoUpdate = this.autoUpdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
