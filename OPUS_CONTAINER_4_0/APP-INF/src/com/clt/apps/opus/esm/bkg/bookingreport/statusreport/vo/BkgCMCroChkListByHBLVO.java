/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCMCroChkListByHBLVO.java
*@FileTitle : BkgCMCroChkListByHBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.06 강동윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCMCroChkListByHBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCMCroChkListByHBLVO> models = new ArrayList<BkgCMCroChkListByHBLVO>();
	
	/* Column Info */
	private String bBlNo = null;
	/* Column Info */
	private String bCntrSealNo = null;
	/* Column Info */
	private String bCntrNo = null;
	/* Column Info */
	private String bCustAddrC = null;
	/* Column Info */
	private String bMeasQtyDa = null;
	/* Column Info */
	private String bPckQtyDa = null;
	/* Column Info */
	private String bCustNmC = null;
	/* Column Info */
	private String bUsaCstmsFileNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bCntrMfNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bCntrMfGdsDesc = null;
	/* Column Info */
	private String bCustNmN = null;
	/* Column Info */
	private String bPckQtyChk = null;
	/* Column Info */
	private String bPckQtyCo = null;
	/* Column Info */
	private String bPckQtyCm = null;
	/* Column Info */
	private String bCustNmS = null;
	/* Column Info */
	private String bCntrMfMkDesc = null;
	/* Column Info */
	private String bMeasQtyChk = null;
	/* Column Info */
	private String bHblWgtDa = null;
	/* Column Info */
	private String bCntrWgtCm = null;
	/* Column Info */
	private String bCntrWgtCo = null;
	/* Column Info */
	private String bCustAddrN = null;
	/* Column Info */
	private String bHblNo = null;
	/* Column Info */
	private String bHblWetChk = null;
	/* Column Info */
	private String bCustAddrS = null;
	/* Column Info */
	private String bMeasQtyCm = null;
	/* Column Info */
	private String bMeasQtyCo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCMCroChkListByHBLVO() {}

	public BkgCMCroChkListByHBLVO(String ibflag, String pagerows, String bBlNo, String bUsaCstmsFileNo, String bHblNo, String bCustNmS, String bCustAddrS, String bCustNmC, String bCustAddrC, String bCustNmN, String bCustAddrN, String bPckQtyDa, String bHblWgtDa, String bMeasQtyDa, String bPckQtyChk, String bHblWetChk, String bMeasQtyChk, String bPckQtyCm, String bCntrWgtCm, String bMeasQtyCm, String bCntrMfMkDesc, String bCntrMfGdsDesc, String bCntrMfNo, String bCntrNo, String bCntrSealNo, String bPckQtyCo, String bCntrWgtCo, String bMeasQtyCo) {
		this.bBlNo = bBlNo;
		this.bCntrSealNo = bCntrSealNo;
		this.bCntrNo = bCntrNo;
		this.bCustAddrC = bCustAddrC;
		this.bMeasQtyDa = bMeasQtyDa;
		this.bPckQtyDa = bPckQtyDa;
		this.bCustNmC = bCustNmC;
		this.bUsaCstmsFileNo = bUsaCstmsFileNo;
		this.pagerows = pagerows;
		this.bCntrMfNo = bCntrMfNo;
		this.ibflag = ibflag;
		this.bCntrMfGdsDesc = bCntrMfGdsDesc;
		this.bCustNmN = bCustNmN;
		this.bPckQtyChk = bPckQtyChk;
		this.bPckQtyCo = bPckQtyCo;
		this.bPckQtyCm = bPckQtyCm;
		this.bCustNmS = bCustNmS;
		this.bCntrMfMkDesc = bCntrMfMkDesc;
		this.bMeasQtyChk = bMeasQtyChk;
		this.bHblWgtDa = bHblWgtDa;
		this.bCntrWgtCm = bCntrWgtCm;
		this.bCntrWgtCo = bCntrWgtCo;
		this.bCustAddrN = bCustAddrN;
		this.bHblNo = bHblNo;
		this.bHblWetChk = bHblWetChk;
		this.bCustAddrS = bCustAddrS;
		this.bMeasQtyCm = bMeasQtyCm;
		this.bMeasQtyCo = bMeasQtyCo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("b_bl_no", getBBlNo());
		this.hashColumns.put("b_cntr_seal_no", getBCntrSealNo());
		this.hashColumns.put("b_cntr_no", getBCntrNo());
		this.hashColumns.put("b_cust_addr_c", getBCustAddrC());
		this.hashColumns.put("b_meas_qty_da", getBMeasQtyDa());
		this.hashColumns.put("b_pck_qty_da", getBPckQtyDa());
		this.hashColumns.put("b_cust_nm_c", getBCustNmC());
		this.hashColumns.put("b_usa_cstms_file_no", getBUsaCstmsFileNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("b_cntr_mf_no", getBCntrMfNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("b_cntr_mf_gds_desc", getBCntrMfGdsDesc());
		this.hashColumns.put("b_cust_nm_n", getBCustNmN());
		this.hashColumns.put("b_pck_qty_chk", getBPckQtyChk());
		this.hashColumns.put("b_pck_qty_co", getBPckQtyCo());
		this.hashColumns.put("b_pck_qty_cm", getBPckQtyCm());
		this.hashColumns.put("b_cust_nm_s", getBCustNmS());
		this.hashColumns.put("b_cntr_mf_mk_desc", getBCntrMfMkDesc());
		this.hashColumns.put("b_meas_qty_chk", getBMeasQtyChk());
		this.hashColumns.put("b_hbl_wgt_da", getBHblWgtDa());
		this.hashColumns.put("b_cntr_wgt_cm", getBCntrWgtCm());
		this.hashColumns.put("b_cntr_wgt_co", getBCntrWgtCo());
		this.hashColumns.put("b_cust_addr_n", getBCustAddrN());
		this.hashColumns.put("b_hbl_no", getBHblNo());
		this.hashColumns.put("b_hbl_wet_chk", getBHblWetChk());
		this.hashColumns.put("b_cust_addr_s", getBCustAddrS());
		this.hashColumns.put("b_meas_qty_cm", getBMeasQtyCm());
		this.hashColumns.put("b_meas_qty_co", getBMeasQtyCo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("b_bl_no", "bBlNo");
		this.hashFields.put("b_cntr_seal_no", "bCntrSealNo");
		this.hashFields.put("b_cntr_no", "bCntrNo");
		this.hashFields.put("b_cust_addr_c", "bCustAddrC");
		this.hashFields.put("b_meas_qty_da", "bMeasQtyDa");
		this.hashFields.put("b_pck_qty_da", "bPckQtyDa");
		this.hashFields.put("b_cust_nm_c", "bCustNmC");
		this.hashFields.put("b_usa_cstms_file_no", "bUsaCstmsFileNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("b_cntr_mf_no", "bCntrMfNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("b_cntr_mf_gds_desc", "bCntrMfGdsDesc");
		this.hashFields.put("b_cust_nm_n", "bCustNmN");
		this.hashFields.put("b_pck_qty_chk", "bPckQtyChk");
		this.hashFields.put("b_pck_qty_co", "bPckQtyCo");
		this.hashFields.put("b_pck_qty_cm", "bPckQtyCm");
		this.hashFields.put("b_cust_nm_s", "bCustNmS");
		this.hashFields.put("b_cntr_mf_mk_desc", "bCntrMfMkDesc");
		this.hashFields.put("b_meas_qty_chk", "bMeasQtyChk");
		this.hashFields.put("b_hbl_wgt_da", "bHblWgtDa");
		this.hashFields.put("b_cntr_wgt_cm", "bCntrWgtCm");
		this.hashFields.put("b_cntr_wgt_co", "bCntrWgtCo");
		this.hashFields.put("b_cust_addr_n", "bCustAddrN");
		this.hashFields.put("b_hbl_no", "bHblNo");
		this.hashFields.put("b_hbl_wet_chk", "bHblWetChk");
		this.hashFields.put("b_cust_addr_s", "bCustAddrS");
		this.hashFields.put("b_meas_qty_cm", "bMeasQtyCm");
		this.hashFields.put("b_meas_qty_co", "bMeasQtyCo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bBlNo
	 */
	public String getBBlNo() {
		return this.bBlNo;
	}
	
	/**
	 * Column Info
	 * @return bCntrSealNo
	 */
	public String getBCntrSealNo() {
		return this.bCntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return bCntrNo
	 */
	public String getBCntrNo() {
		return this.bCntrNo;
	}
	
	/**
	 * Column Info
	 * @return bCustAddrC
	 */
	public String getBCustAddrC() {
		return this.bCustAddrC;
	}
	
	/**
	 * Column Info
	 * @return bMeasQtyDa
	 */
	public String getBMeasQtyDa() {
		return this.bMeasQtyDa;
	}
	
	/**
	 * Column Info
	 * @return bPckQtyDa
	 */
	public String getBPckQtyDa() {
		return this.bPckQtyDa;
	}
	
	/**
	 * Column Info
	 * @return bCustNmC
	 */
	public String getBCustNmC() {
		return this.bCustNmC;
	}
	
	/**
	 * Column Info
	 * @return bUsaCstmsFileNo
	 */
	public String getBUsaCstmsFileNo() {
		return this.bUsaCstmsFileNo;
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
	 * @return bCntrMfNo
	 */
	public String getBCntrMfNo() {
		return this.bCntrMfNo;
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
	 * @return bCntrMfGdsDesc
	 */
	public String getBCntrMfGdsDesc() {
		return this.bCntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return bCustNmN
	 */
	public String getBCustNmN() {
		return this.bCustNmN;
	}
	
	/**
	 * Column Info
	 * @return bPckQtyChk
	 */
	public String getBPckQtyChk() {
		return this.bPckQtyChk;
	}
	
	/**
	 * Column Info
	 * @return bPckQtyCo
	 */
	public String getBPckQtyCo() {
		return this.bPckQtyCo;
	}
	
	/**
	 * Column Info
	 * @return bPckQtyCm
	 */
	public String getBPckQtyCm() {
		return this.bPckQtyCm;
	}
	
	/**
	 * Column Info
	 * @return bCustNmS
	 */
	public String getBCustNmS() {
		return this.bCustNmS;
	}
	
	/**
	 * Column Info
	 * @return bCntrMfMkDesc
	 */
	public String getBCntrMfMkDesc() {
		return this.bCntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @return bMeasQtyChk
	 */
	public String getBMeasQtyChk() {
		return this.bMeasQtyChk;
	}
	
	/**
	 * Column Info
	 * @return bHblWgtDa
	 */
	public String getBHblWgtDa() {
		return this.bHblWgtDa;
	}
	
	/**
	 * Column Info
	 * @return bCntrWgtCm
	 */
	public String getBCntrWgtCm() {
		return this.bCntrWgtCm;
	}
	
	/**
	 * Column Info
	 * @return bCntrWgtCo
	 */
	public String getBCntrWgtCo() {
		return this.bCntrWgtCo;
	}
	
	/**
	 * Column Info
	 * @return bCustAddrN
	 */
	public String getBCustAddrN() {
		return this.bCustAddrN;
	}
	
	/**
	 * Column Info
	 * @return bHblNo
	 */
	public String getBHblNo() {
		return this.bHblNo;
	}
	
	/**
	 * Column Info
	 * @return bHblWetChk
	 */
	public String getBHblWetChk() {
		return this.bHblWetChk;
	}
	
	/**
	 * Column Info
	 * @return bCustAddrS
	 */
	public String getBCustAddrS() {
		return this.bCustAddrS;
	}
	
	/**
	 * Column Info
	 * @return bMeasQtyCm
	 */
	public String getBMeasQtyCm() {
		return this.bMeasQtyCm;
	}
	
	/**
	 * Column Info
	 * @return bMeasQtyCo
	 */
	public String getBMeasQtyCo() {
		return this.bMeasQtyCo;
	}
	

	/**
	 * Column Info
	 * @param bBlNo
	 */
	public void setBBlNo(String bBlNo) {
		this.bBlNo = bBlNo;
	}
	
	/**
	 * Column Info
	 * @param bCntrSealNo
	 */
	public void setBCntrSealNo(String bCntrSealNo) {
		this.bCntrSealNo = bCntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param bCntrNo
	 */
	public void setBCntrNo(String bCntrNo) {
		this.bCntrNo = bCntrNo;
	}
	
	/**
	 * Column Info
	 * @param bCustAddrC
	 */
	public void setBCustAddrC(String bCustAddrC) {
		this.bCustAddrC = bCustAddrC;
	}
	
	/**
	 * Column Info
	 * @param bMeasQtyDa
	 */
	public void setBMeasQtyDa(String bMeasQtyDa) {
		this.bMeasQtyDa = bMeasQtyDa;
	}
	
	/**
	 * Column Info
	 * @param bPckQtyDa
	 */
	public void setBPckQtyDa(String bPckQtyDa) {
		this.bPckQtyDa = bPckQtyDa;
	}
	
	/**
	 * Column Info
	 * @param bCustNmC
	 */
	public void setBCustNmC(String bCustNmC) {
		this.bCustNmC = bCustNmC;
	}
	
	/**
	 * Column Info
	 * @param bUsaCstmsFileNo
	 */
	public void setBUsaCstmsFileNo(String bUsaCstmsFileNo) {
		this.bUsaCstmsFileNo = bUsaCstmsFileNo;
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
	 * @param bCntrMfNo
	 */
	public void setBCntrMfNo(String bCntrMfNo) {
		this.bCntrMfNo = bCntrMfNo;
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
	 * @param bCntrMfGdsDesc
	 */
	public void setBCntrMfGdsDesc(String bCntrMfGdsDesc) {
		this.bCntrMfGdsDesc = bCntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param bCustNmN
	 */
	public void setBCustNmN(String bCustNmN) {
		this.bCustNmN = bCustNmN;
	}
	
	/**
	 * Column Info
	 * @param bPckQtyChk
	 */
	public void setBPckQtyChk(String bPckQtyChk) {
		this.bPckQtyChk = bPckQtyChk;
	}
	
	/**
	 * Column Info
	 * @param bPckQtyCo
	 */
	public void setBPckQtyCo(String bPckQtyCo) {
		this.bPckQtyCo = bPckQtyCo;
	}
	
	/**
	 * Column Info
	 * @param bPckQtyCm
	 */
	public void setBPckQtyCm(String bPckQtyCm) {
		this.bPckQtyCm = bPckQtyCm;
	}
	
	/**
	 * Column Info
	 * @param bCustNmS
	 */
	public void setBCustNmS(String bCustNmS) {
		this.bCustNmS = bCustNmS;
	}
	
	/**
	 * Column Info
	 * @param bCntrMfMkDesc
	 */
	public void setBCntrMfMkDesc(String bCntrMfMkDesc) {
		this.bCntrMfMkDesc = bCntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @param bMeasQtyChk
	 */
	public void setBMeasQtyChk(String bMeasQtyChk) {
		this.bMeasQtyChk = bMeasQtyChk;
	}
	
	/**
	 * Column Info
	 * @param bHblWgtDa
	 */
	public void setBHblWgtDa(String bHblWgtDa) {
		this.bHblWgtDa = bHblWgtDa;
	}
	
	/**
	 * Column Info
	 * @param bCntrWgtCm
	 */
	public void setBCntrWgtCm(String bCntrWgtCm) {
		this.bCntrWgtCm = bCntrWgtCm;
	}
	
	/**
	 * Column Info
	 * @param bCntrWgtCo
	 */
	public void setBCntrWgtCo(String bCntrWgtCo) {
		this.bCntrWgtCo = bCntrWgtCo;
	}
	
	/**
	 * Column Info
	 * @param bCustAddrN
	 */
	public void setBCustAddrN(String bCustAddrN) {
		this.bCustAddrN = bCustAddrN;
	}
	
	/**
	 * Column Info
	 * @param bHblNo
	 */
	public void setBHblNo(String bHblNo) {
		this.bHblNo = bHblNo;
	}
	
	/**
	 * Column Info
	 * @param bHblWetChk
	 */
	public void setBHblWetChk(String bHblWetChk) {
		this.bHblWetChk = bHblWetChk;
	}
	
	/**
	 * Column Info
	 * @param bCustAddrS
	 */
	public void setBCustAddrS(String bCustAddrS) {
		this.bCustAddrS = bCustAddrS;
	}
	
	/**
	 * Column Info
	 * @param bMeasQtyCm
	 */
	public void setBMeasQtyCm(String bMeasQtyCm) {
		this.bMeasQtyCm = bMeasQtyCm;
	}
	
	/**
	 * Column Info
	 * @param bMeasQtyCo
	 */
	public void setBMeasQtyCo(String bMeasQtyCo) {
		this.bMeasQtyCo = bMeasQtyCo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBBlNo(JSPUtil.getParameter(request, "b_bl_no", ""));
		setBCntrSealNo(JSPUtil.getParameter(request, "b_cntr_seal_no", ""));
		setBCntrNo(JSPUtil.getParameter(request, "b_cntr_no", ""));
		setBCustAddrC(JSPUtil.getParameter(request, "b_cust_addr_c", ""));
		setBMeasQtyDa(JSPUtil.getParameter(request, "b_meas_qty_da", ""));
		setBPckQtyDa(JSPUtil.getParameter(request, "b_pck_qty_da", ""));
		setBCustNmC(JSPUtil.getParameter(request, "b_cust_nm_c", ""));
		setBUsaCstmsFileNo(JSPUtil.getParameter(request, "b_usa_cstms_file_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBCntrMfNo(JSPUtil.getParameter(request, "b_cntr_mf_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBCntrMfGdsDesc(JSPUtil.getParameter(request, "b_cntr_mf_gds_desc", ""));
		setBCustNmN(JSPUtil.getParameter(request, "b_cust_nm_n", ""));
		setBPckQtyChk(JSPUtil.getParameter(request, "b_pck_qty_chk", ""));
		setBPckQtyCo(JSPUtil.getParameter(request, "b_pck_qty_co", ""));
		setBPckQtyCm(JSPUtil.getParameter(request, "b_pck_qty_cm", ""));
		setBCustNmS(JSPUtil.getParameter(request, "b_cust_nm_s", ""));
		setBCntrMfMkDesc(JSPUtil.getParameter(request, "b_cntr_mf_mk_desc", ""));
		setBMeasQtyChk(JSPUtil.getParameter(request, "b_meas_qty_chk", ""));
		setBHblWgtDa(JSPUtil.getParameter(request, "b_hbl_wgt_da", ""));
		setBCntrWgtCm(JSPUtil.getParameter(request, "b_cntr_wgt_cm", ""));
		setBCntrWgtCo(JSPUtil.getParameter(request, "b_cntr_wgt_co", ""));
		setBCustAddrN(JSPUtil.getParameter(request, "b_cust_addr_n", ""));
		setBHblNo(JSPUtil.getParameter(request, "b_hbl_no", ""));
		setBHblWetChk(JSPUtil.getParameter(request, "b_hbl_wet_chk", ""));
		setBCustAddrS(JSPUtil.getParameter(request, "b_cust_addr_s", ""));
		setBMeasQtyCm(JSPUtil.getParameter(request, "b_meas_qty_cm", ""));
		setBMeasQtyCo(JSPUtil.getParameter(request, "b_meas_qty_co", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCMCroChkListByHBLVO[]
	 */
	public BkgCMCroChkListByHBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCMCroChkListByHBLVO[]
	 */
	public BkgCMCroChkListByHBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCMCroChkListByHBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bBlNo = (JSPUtil.getParameter(request, prefix	+ "b_bl_no", length));
			String[] bCntrSealNo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_seal_no", length));
			String[] bCntrNo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_no", length));
			String[] bCustAddrC = (JSPUtil.getParameter(request, prefix	+ "b_cust_addr_c", length));
			String[] bMeasQtyDa = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_da", length));
			String[] bPckQtyDa = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_da", length));
			String[] bCustNmC = (JSPUtil.getParameter(request, prefix	+ "b_cust_nm_c", length));
			String[] bUsaCstmsFileNo = (JSPUtil.getParameter(request, prefix	+ "b_usa_cstms_file_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bCntrMfNo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bCntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_gds_desc", length));
			String[] bCustNmN = (JSPUtil.getParameter(request, prefix	+ "b_cust_nm_n", length));
			String[] bPckQtyChk = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_chk", length));
			String[] bPckQtyCo = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_co", length));
			String[] bPckQtyCm = (JSPUtil.getParameter(request, prefix	+ "b_pck_qty_cm", length));
			String[] bCustNmS = (JSPUtil.getParameter(request, prefix	+ "b_cust_nm_s", length));
			String[] bCntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mf_mk_desc", length));
			String[] bMeasQtyChk = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_chk", length));
			String[] bHblWgtDa = (JSPUtil.getParameter(request, prefix	+ "b_hbl_wgt_da", length));
			String[] bCntrWgtCm = (JSPUtil.getParameter(request, prefix	+ "b_cntr_wgt_cm", length));
			String[] bCntrWgtCo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_wgt_co", length));
			String[] bCustAddrN = (JSPUtil.getParameter(request, prefix	+ "b_cust_addr_n", length));
			String[] bHblNo = (JSPUtil.getParameter(request, prefix	+ "b_hbl_no", length));
			String[] bHblWetChk = (JSPUtil.getParameter(request, prefix	+ "b_hbl_wet_chk", length));
			String[] bCustAddrS = (JSPUtil.getParameter(request, prefix	+ "b_cust_addr_s", length));
			String[] bMeasQtyCm = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_cm", length));
			String[] bMeasQtyCo = (JSPUtil.getParameter(request, prefix	+ "b_meas_qty_co", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCMCroChkListByHBLVO();
				if (bBlNo[i] != null)
					model.setBBlNo(bBlNo[i]);
				if (bCntrSealNo[i] != null)
					model.setBCntrSealNo(bCntrSealNo[i]);
				if (bCntrNo[i] != null)
					model.setBCntrNo(bCntrNo[i]);
				if (bCustAddrC[i] != null)
					model.setBCustAddrC(bCustAddrC[i]);
				if (bMeasQtyDa[i] != null)
					model.setBMeasQtyDa(bMeasQtyDa[i]);
				if (bPckQtyDa[i] != null)
					model.setBPckQtyDa(bPckQtyDa[i]);
				if (bCustNmC[i] != null)
					model.setBCustNmC(bCustNmC[i]);
				if (bUsaCstmsFileNo[i] != null)
					model.setBUsaCstmsFileNo(bUsaCstmsFileNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bCntrMfNo[i] != null)
					model.setBCntrMfNo(bCntrMfNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bCntrMfGdsDesc[i] != null)
					model.setBCntrMfGdsDesc(bCntrMfGdsDesc[i]);
				if (bCustNmN[i] != null)
					model.setBCustNmN(bCustNmN[i]);
				if (bPckQtyChk[i] != null)
					model.setBPckQtyChk(bPckQtyChk[i]);
				if (bPckQtyCo[i] != null)
					model.setBPckQtyCo(bPckQtyCo[i]);
				if (bPckQtyCm[i] != null)
					model.setBPckQtyCm(bPckQtyCm[i]);
				if (bCustNmS[i] != null)
					model.setBCustNmS(bCustNmS[i]);
				if (bCntrMfMkDesc[i] != null)
					model.setBCntrMfMkDesc(bCntrMfMkDesc[i]);
				if (bMeasQtyChk[i] != null)
					model.setBMeasQtyChk(bMeasQtyChk[i]);
				if (bHblWgtDa[i] != null)
					model.setBHblWgtDa(bHblWgtDa[i]);
				if (bCntrWgtCm[i] != null)
					model.setBCntrWgtCm(bCntrWgtCm[i]);
				if (bCntrWgtCo[i] != null)
					model.setBCntrWgtCo(bCntrWgtCo[i]);
				if (bCustAddrN[i] != null)
					model.setBCustAddrN(bCustAddrN[i]);
				if (bHblNo[i] != null)
					model.setBHblNo(bHblNo[i]);
				if (bHblWetChk[i] != null)
					model.setBHblWetChk(bHblWetChk[i]);
				if (bCustAddrS[i] != null)
					model.setBCustAddrS(bCustAddrS[i]);
				if (bMeasQtyCm[i] != null)
					model.setBMeasQtyCm(bMeasQtyCm[i]);
				if (bMeasQtyCo[i] != null)
					model.setBMeasQtyCo(bMeasQtyCo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCMCroChkListByHBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCMCroChkListByHBLVO[]
	 */
	public BkgCMCroChkListByHBLVO[] getBkgCMCroChkListByHBLVOs(){
		BkgCMCroChkListByHBLVO[] vos = (BkgCMCroChkListByHBLVO[])models.toArray(new BkgCMCroChkListByHBLVO[models.size()]);
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
		this.bBlNo = this.bBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrSealNo = this.bCntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrNo = this.bCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustAddrC = this.bCustAddrC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyDa = this.bMeasQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyDa = this.bPckQtyDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustNmC = this.bCustNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bUsaCstmsFileNo = this.bUsaCstmsFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfNo = this.bCntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfGdsDesc = this.bCntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustNmN = this.bCustNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyChk = this.bPckQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyCo = this.bPckQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPckQtyCm = this.bPckQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustNmS = this.bCustNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMfMkDesc = this.bCntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyChk = this.bMeasQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bHblWgtDa = this.bHblWgtDa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrWgtCm = this.bCntrWgtCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrWgtCo = this.bCntrWgtCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustAddrN = this.bCustAddrN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bHblNo = this.bHblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bHblWetChk = this.bHblWetChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCustAddrS = this.bCustAddrS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyCm = this.bMeasQtyCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMeasQtyCo = this.bMeasQtyCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
