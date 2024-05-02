/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SitProENSDownExcelVO.java
*@FileTitle : SitProENSDownExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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

public class SitProENSDownExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProENSDownExcelVO> models = new ArrayList<SitProENSDownExcelVO>();
	
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String item27 = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String nCustAddr = null;
	/* Column Info */
	private String item29 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pkgCount = null;
	/* Column Info */
	private String sealNbr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String unloadLocCd = null;
	/* Column Info */
	private String ddate = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String crn = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String pkgType = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String item30 = null;
	/* Column Info */
	private String cmShipMark = null;
	/* Column Info */
	private String routeCountry = null;
	/* Column Info */
	private String item14 = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String item5 = null;
	/* Column Info */
	private String trspDocNo = null;
	/* Column Info */
	private String item7 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sCustAddr = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String loadLocCd = null;
	
	private String mvmtRefNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitProENSDownExcelVO() {}

	public SitProENSDownExcelVO(String ibflag, String pagerows, String seq, String bkgNo, String trspDocNo, String sCustNm, String sCustAddr, String item5, String cCustNm, String cCustAddr, String item7, String nCustNm, String nCustAddr, String transMode, String crn, String cstmsPortCd, String vpsEtaDt, String routeCountry, String item14, String loadLocCd, String unloadLocCd, String cstmsDesc, String pkgType, String pkgCount, String cmShipMark, String cntrNo, String pckQty, String cmdtHsCd, String actWgt, String imdgUnNo, String sealNbr, String item27, String ddate, String item29, String item30, String cntrMfGdsDesc, String mvmtRefNo) {
		this.cCustNm = cCustNm;
		this.item27 = item27;
		this.vpsEtaDt = vpsEtaDt;
		this.nCustAddr = nCustAddr;
		this.item29 = item29;
		this.pagerows = pagerows;
		this.pkgCount = pkgCount;
		this.sealNbr = sealNbr;
		this.ibflag = ibflag;
		this.cCustAddr = cCustAddr;
		this.unloadLocCd = unloadLocCd;
		this.ddate = ddate;
		this.cstmsDesc = cstmsDesc;
		this.pckQty = pckQty;
		this.crn = crn;
		this.cmdtHsCd = cmdtHsCd;
		this.nCustNm = nCustNm;
		this.pkgType = pkgType;
		this.imdgUnNo = imdgUnNo;
		this.cstmsPortCd = cstmsPortCd;
		this.sCustNm = sCustNm;
		this.item30 = item30;
		this.cmShipMark = cmShipMark;
		this.routeCountry = routeCountry;
		this.item14 = item14;
		this.actWgt = actWgt;
		this.bkgNo = bkgNo;
		this.transMode = transMode;
		this.item5 = item5;
		this.trspDocNo = trspDocNo;
		this.item7 = item7;
		this.cntrNo = cntrNo;
		this.sCustAddr = sCustAddr;
		this.seq = seq;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.loadLocCd = loadLocCd;
		this.mvmtRefNo = mvmtRefNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("item27", getItem27());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("item29", getItem29());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pkg_count", getPkgCount());
		this.hashColumns.put("seal_nbr", getSealNbr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("unload_loc_cd", getUnloadLocCd());
		this.hashColumns.put("ddate", getDdate());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("crn", getCrn());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("pkg_type", getPkgType());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("item30", getItem30());
		this.hashColumns.put("cm_ship_mark", getCmShipMark());
		this.hashColumns.put("route_country", getRouteCountry());
		this.hashColumns.put("item14", getItem14());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("item5", getItem5());
		this.hashColumns.put("trsp_doc_no", getTrspDocNo());
		this.hashColumns.put("item7", getItem7());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("s_cust_addr", getSCustAddr());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("load_loc_cd", getLoadLocCd());
		this.hashColumns.put("mvmt_ref_no", getMvmtRefNo());		

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("item27", "item27");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("item29", "item29");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pkg_count", "pkgCount");
		this.hashFields.put("seal_nbr", "sealNbr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("unload_loc_cd", "unloadLocCd");
		this.hashFields.put("ddate", "ddate");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("crn", "crn");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("pkg_type", "pkgType");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("item30", "item30");
		this.hashFields.put("cm_ship_mark", "cmShipMark");
		this.hashFields.put("route_country", "routeCountry");
		this.hashFields.put("item14", "item14");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("item5", "item5");
		this.hashFields.put("trsp_doc_no", "trspDocNo");
		this.hashFields.put("item7", "item7");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("s_cust_addr", "sCustAddr");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("load_loc_cd", "loadLocCd");
		this.hashFields.put("mvmt_ref_no", "mvmtRefNo");		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return item27
	 */
	public String getItem27() {
		return this.item27;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return nCustAddr
	 */
	public String getNCustAddr() {
		return this.nCustAddr;
	}
	
	/**
	 * Column Info
	 * @return item29
	 */
	public String getItem29() {
		return this.item29;
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
	 * @return pkgCount
	 */
	public String getPkgCount() {
		return this.pkgCount;
	}
	
	/**
	 * Column Info
	 * @return sealNbr
	 */
	public String getSealNbr() {
		return this.sealNbr;
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
	 * @return cCustAddr
	 */
	public String getCCustAddr() {
		return this.cCustAddr;
	}
	
	/**
	 * Column Info
	 * @return unloadLocCd
	 */
	public String getUnloadLocCd() {
		return this.unloadLocCd;
	}
	
	/**
	 * Column Info
	 * @return ddate
	 */
	public String getDdate() {
		return this.ddate;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
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
	 * @return crn
	 */
	public String getCrn() {
		return this.crn;
	}
	
	/**
	 * Column Info
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
	}
	
	/**
	 * Column Info
	 * @return pkgType
	 */
	public String getPkgType() {
		return this.pkgType;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return item30
	 */
	public String getItem30() {
		return this.item30;
	}
	
	/**
	 * Column Info
	 * @return cmShipMark
	 */
	public String getCmShipMark() {
		return this.cmShipMark;
	}
	
	/**
	 * Column Info
	 * @return routeCountry
	 */
	public String getRouteCountry() {
		return this.routeCountry;
	}
	
	/**
	 * Column Info
	 * @return item14
	 */
	public String getItem14() {
		return this.item14;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
	}
	
	/**
	 * Column Info
	 * @return item5
	 */
	public String getItem5() {
		return this.item5;
	}
	
	/**
	 * Column Info
	 * @return trspDocNo
	 */
	public String getTrspDocNo() {
		return this.trspDocNo;
	}
	
	/**
	 * Column Info
	 * @return item7
	 */
	public String getItem7() {
		return this.item7;
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
	 * @return sCustAddr
	 */
	public String getSCustAddr() {
		return this.sCustAddr;
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
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return loadLocCd
	 */
	public String getLoadLocCd() {
		return this.loadLocCd;
	}
	

	/**
	 * Column Info
	 * @return mvmtRefNo
	 */
	public String getMvmtRefNo() {
		return this.mvmtRefNo;
	}	
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param item27
	 */
	public void setItem27(String item27) {
		this.item27 = item27;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param nCustAddr
	 */
	public void setNCustAddr(String nCustAddr) {
		this.nCustAddr = nCustAddr;
	}
	
	/**
	 * Column Info
	 * @param item29
	 */
	public void setItem29(String item29) {
		this.item29 = item29;
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
	 * @param pkgCount
	 */
	public void setPkgCount(String pkgCount) {
		this.pkgCount = pkgCount;
	}
	
	/**
	 * Column Info
	 * @param sealNbr
	 */
	public void setSealNbr(String sealNbr) {
		this.sealNbr = sealNbr;
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
	 * @param cCustAddr
	 */
	public void setCCustAddr(String cCustAddr) {
		this.cCustAddr = cCustAddr;
	}
	
	/**
	 * Column Info
	 * @param unloadLocCd
	 */
	public void setUnloadLocCd(String unloadLocCd) {
		this.unloadLocCd = unloadLocCd;
	}
	
	/**
	 * Column Info
	 * @param ddate
	 */
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
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
	 * @param crn
	 */
	public void setCrn(String crn) {
		this.crn = crn;
	}
	
	/**
	 * Column Info
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
	}
	
	/**
	 * Column Info
	 * @param pkgType
	 */
	public void setPkgType(String pkgType) {
		this.pkgType = pkgType;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param item30
	 */
	public void setItem30(String item30) {
		this.item30 = item30;
	}
	
	/**
	 * Column Info
	 * @param cmShipMark
	 */
	public void setCmShipMark(String cmShipMark) {
		this.cmShipMark = cmShipMark;
	}
	
	/**
	 * Column Info
	 * @param routeCountry
	 */
	public void setRouteCountry(String routeCountry) {
		this.routeCountry = routeCountry;
	}
	
	/**
	 * Column Info
	 * @param item14
	 */
	public void setItem14(String item14) {
		this.item14 = item14;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
	
	/**
	 * Column Info
	 * @param item5
	 */
	public void setItem5(String item5) {
		this.item5 = item5;
	}
	
	/**
	 * Column Info
	 * @param trspDocNo
	 */
	public void setTrspDocNo(String trspDocNo) {
		this.trspDocNo = trspDocNo;
	}
	
	/**
	 * Column Info
	 * @param item7
	 */
	public void setItem7(String item7) {
		this.item7 = item7;
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
	 * @param sCustAddr
	 */
	public void setSCustAddr(String sCustAddr) {
		this.sCustAddr = sCustAddr;
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
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param loadLocCd
	 */
	public void setLoadLocCd(String loadLocCd) {
		this.loadLocCd = loadLocCd;
	}
	
	/**
	 * Column Info
	 * @param loadLocCd
	 */
	public void setMvmtRefNo(String mvmtRefNo) {
		this.mvmtRefNo = mvmtRefNo;
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
		setCCustNm(JSPUtil.getParameter(request, prefix + "c_cust_nm", ""));
		setItem27(JSPUtil.getParameter(request, prefix + "item27", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setNCustAddr(JSPUtil.getParameter(request, prefix + "n_cust_addr", ""));
		setItem29(JSPUtil.getParameter(request, prefix + "item29", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPkgCount(JSPUtil.getParameter(request, prefix + "pkg_count", ""));
		setSealNbr(JSPUtil.getParameter(request, prefix + "seal_nbr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCCustAddr(JSPUtil.getParameter(request, prefix + "c_cust_addr", ""));
		setUnloadLocCd(JSPUtil.getParameter(request, prefix + "unload_loc_cd", ""));
		setDdate(JSPUtil.getParameter(request, prefix + "ddate", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCrn(JSPUtil.getParameter(request, prefix + "crn", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setNCustNm(JSPUtil.getParameter(request, prefix + "n_cust_nm", ""));
		setPkgType(JSPUtil.getParameter(request, prefix + "pkg_type", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setItem30(JSPUtil.getParameter(request, prefix + "item30", ""));
		setCmShipMark(JSPUtil.getParameter(request, prefix + "cm_ship_mark", ""));
		setRouteCountry(JSPUtil.getParameter(request, prefix + "route_country", ""));
		setItem14(JSPUtil.getParameter(request, prefix + "item14", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setItem5(JSPUtil.getParameter(request, prefix + "item5", ""));
		setTrspDocNo(JSPUtil.getParameter(request, prefix + "trsp_doc_no", ""));
		setItem7(JSPUtil.getParameter(request, prefix + "item7", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSCustAddr(JSPUtil.getParameter(request, prefix + "s_cust_addr", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setLoadLocCd(JSPUtil.getParameter(request, prefix + "load_loc_cd", ""));
		setMvmtRefNo(JSPUtil.getParameter(request, prefix + "mvmt_ref_no", ""));		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProENSDownExcelVO[]
	 */
	public SitProENSDownExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProENSDownExcelVO[]
	 */
	public SitProENSDownExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProENSDownExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] item27 = (JSPUtil.getParameter(request, prefix	+ "item27", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] item29 = (JSPUtil.getParameter(request, prefix	+ "item29", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pkgCount = (JSPUtil.getParameter(request, prefix	+ "pkg_count", length));
			String[] sealNbr = (JSPUtil.getParameter(request, prefix	+ "seal_nbr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] unloadLocCd = (JSPUtil.getParameter(request, prefix	+ "unload_loc_cd", length));
			String[] ddate = (JSPUtil.getParameter(request, prefix	+ "ddate", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] crn = (JSPUtil.getParameter(request, prefix	+ "crn", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] pkgType = (JSPUtil.getParameter(request, prefix	+ "pkg_type", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] item30 = (JSPUtil.getParameter(request, prefix	+ "item30", length));
			String[] cmShipMark = (JSPUtil.getParameter(request, prefix	+ "cm_ship_mark", length));
			String[] routeCountry = (JSPUtil.getParameter(request, prefix	+ "route_country", length));
			String[] item14 = (JSPUtil.getParameter(request, prefix	+ "item14", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] item5 = (JSPUtil.getParameter(request, prefix	+ "item5", length));
			String[] trspDocNo = (JSPUtil.getParameter(request, prefix	+ "trsp_doc_no", length));
			String[] item7 = (JSPUtil.getParameter(request, prefix	+ "item7", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_cust_addr", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] loadLocCd = (JSPUtil.getParameter(request, prefix	+ "load_loc_cd", length));
			String[] mvmtRefNo = (JSPUtil.getParameter(request, prefix	+ "mvmt_ref_no", length));			
			
			for (int i = 0; i < length; i++) {
				model = new SitProENSDownExcelVO();
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (item27[i] != null)
					model.setItem27(item27[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (item29[i] != null)
					model.setItem29(item29[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pkgCount[i] != null)
					model.setPkgCount(pkgCount[i]);
				if (sealNbr[i] != null)
					model.setSealNbr(sealNbr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (unloadLocCd[i] != null)
					model.setUnloadLocCd(unloadLocCd[i]);
				if (ddate[i] != null)
					model.setDdate(ddate[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (crn[i] != null)
					model.setCrn(crn[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (pkgType[i] != null)
					model.setPkgType(pkgType[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (item30[i] != null)
					model.setItem30(item30[i]);
				if (cmShipMark[i] != null)
					model.setCmShipMark(cmShipMark[i]);
				if (routeCountry[i] != null)
					model.setRouteCountry(routeCountry[i]);
				if (item14[i] != null)
					model.setItem14(item14[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (item5[i] != null)
					model.setItem5(item5[i]);
				if (trspDocNo[i] != null)
					model.setTrspDocNo(trspDocNo[i]);
				if (item7[i] != null)
					model.setItem7(item7[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sCustAddr[i] != null)
					model.setSCustAddr(sCustAddr[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (loadLocCd[i] != null)
					model.setLoadLocCd(loadLocCd[i]);
				if (mvmtRefNo[i] != null)
					model.setMvmtRefNo(mvmtRefNo[i]);				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProENSDownExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProENSDownExcelVO[]
	 */
	public SitProENSDownExcelVO[] getSitProENSDownExcelVOs(){
		SitProENSDownExcelVO[] vos = (SitProENSDownExcelVO[])models.toArray(new SitProENSDownExcelVO[models.size()]);
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
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item27 = this.item27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item29 = this.item29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCount = this.pkgCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNbr = this.sealNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unloadLocCd = this.unloadLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddate = this.ddate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crn = this.crn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgType = this.pkgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item30 = this.item30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmShipMark = this.cmShipMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeCountry = this.routeCountry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item14 = this.item14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item5 = this.item5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDocNo = this.trspDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item7 = this.item7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustAddr = this.sCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadLocCd = this.loadLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRefNo = this.mvmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
