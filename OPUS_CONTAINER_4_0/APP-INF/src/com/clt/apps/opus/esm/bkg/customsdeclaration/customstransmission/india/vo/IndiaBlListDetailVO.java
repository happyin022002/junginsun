/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaBlListDetailVO.java
*@FileTitle : IndiaBlListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.26 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndiaBlListDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndiaBlListDetailVO> models = new ArrayList<IndiaBlListDetailVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String idaLineNo = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String crrAgnCd = null;
	/* Column Info */
	private String newBlNo = null;
	/* Column Info */
	private String mkDesc = null;
	/* Column Info */
	private String nCustAddr = null;
	/* Column Info */
	private String podCdGubun = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String idaCstmsItmTpCd = null;
	/* Column Info */
	private String vslDeclDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String idaTrspCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String idaDeclVslNo = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String blDeclTpCd = null;
	/* Column Info */
	private String tmp0 = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String idaMrnLineOprCd = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String tmp4 = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String ibdNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String idaDestCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndiaBlListDetailVO() {}

	public IndiaBlListDetailVO(String ibflag, String pagerows, String callSgnNo, String skdVoyNo, String idaDeclVslNo, String vslDeclDt, String idaLineNo, String tmp0, String newBlNo, String blObrdDt, String polCd, String idaDestCd, String tmp1, String tmp2, String cCustNm, String cCustAddr, String nCustNm, String nCustAddr, String bkgCgoTpCd, String idaCstmsItmTpCd, String blDeclTpCd, String podCdGubun, String pckQty, String pckTpCd, String wgt, String wgtUtCd, String tmp3, String tmp4, String mkDesc, String cmdtDesc, String imdgUnNo, String imdgClssCd, String ibdNo, String crrAgnCd, String idaTrspCd, String idaMrnLineOprCd, String bdAreaCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.idaLineNo = idaLineNo;
		this.cCustNm = cCustNm;
		this.crrAgnCd = crrAgnCd;
		this.newBlNo = newBlNo;
		this.mkDesc = mkDesc;
		this.nCustAddr = nCustAddr;
		this.podCdGubun = podCdGubun;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cCustAddr = cCustAddr;
		this.wgt = wgt;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.nCustNm = nCustNm;
		this.pckTpCd = pckTpCd;
		this.imdgUnNo = imdgUnNo;
		this.idaCstmsItmTpCd = idaCstmsItmTpCd;
		this.vslDeclDt = vslDeclDt;
		this.callSgnNo = callSgnNo;
		this.idaTrspCd = idaTrspCd;
		this.skdVoyNo = skdVoyNo;
		this.idaDeclVslNo = idaDeclVslNo;
		this.bdAreaCd = bdAreaCd;
		this.blDeclTpCd = blDeclTpCd;
		this.tmp0 = tmp0;
		this.tmp2 = tmp2;
		this.idaMrnLineOprCd = idaMrnLineOprCd;
		this.tmp1 = tmp1;
		this.tmp4 = tmp4;
		this.cmdtDesc = cmdtDesc;
		this.tmp3 = tmp3;
		this.blObrdDt = blObrdDt;
		this.ibdNo = ibdNo;
		this.imdgClssCd = imdgClssCd;
		this.idaDestCd = idaDestCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("ida_line_no", getIdaLineNo());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("crr_agn_cd", getCrrAgnCd());
		this.hashColumns.put("new_bl_no", getNewBlNo());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("pod_cd_gubun", getPodCdGubun());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("ida_cstms_itm_tp_cd", getIdaCstmsItmTpCd());
		this.hashColumns.put("vsl_decl_dt", getVslDeclDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("ida_trsp_cd", getIdaTrspCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ida_decl_vsl_no", getIdaDeclVslNo());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("bl_decl_tp_cd", getBlDeclTpCd());
		this.hashColumns.put("tmp0", getTmp0());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("ida_mrn_line_opr_cd", getIdaMrnLineOprCd());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("tmp4", getTmp4());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("ibd_no", getIbdNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("ida_dest_cd", getIdaDestCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("ida_line_no", "idaLineNo");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("crr_agn_cd", "crrAgnCd");
		this.hashFields.put("new_bl_no", "newBlNo");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("pod_cd_gubun", "podCdGubun");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("ida_cstms_itm_tp_cd", "idaCstmsItmTpCd");
		this.hashFields.put("vsl_decl_dt", "vslDeclDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("ida_trsp_cd", "idaTrspCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ida_decl_vsl_no", "idaDeclVslNo");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("bl_decl_tp_cd", "blDeclTpCd");
		this.hashFields.put("tmp0", "tmp0");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("ida_mrn_line_opr_cd", "idaMrnLineOprCd");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("tmp4", "tmp4");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("ibd_no", "ibdNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("ida_dest_cd", "idaDestCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return idaLineNo
	 */
	public String getIdaLineNo() {
		return this.idaLineNo;
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
	 * @return crrAgnCd
	 */
	public String getCrrAgnCd() {
		return this.crrAgnCd;
	}
	
	/**
	 * Column Info
	 * @return newBlNo
	 */
	public String getNewBlNo() {
		return this.newBlNo;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
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
	 * @return podCdGubun
	 */
	public String getPodCdGubun() {
		return this.podCdGubun;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
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
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return idaCstmsItmTpCd
	 */
	public String getIdaCstmsItmTpCd() {
		return this.idaCstmsItmTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslDeclDt
	 */
	public String getVslDeclDt() {
		return this.vslDeclDt;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return idaTrspCd
	 */
	public String getIdaTrspCd() {
		return this.idaTrspCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return idaDeclVslNo
	 */
	public String getIdaDeclVslNo() {
		return this.idaDeclVslNo;
	}
	
	/**
	 * Column Info
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @return blDeclTpCd
	 */
	public String getBlDeclTpCd() {
		return this.blDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return tmp0
	 */
	public String getTmp0() {
		return this.tmp0;
	}
	
	/**
	 * Column Info
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return idaMrnLineOprCd
	 */
	public String getIdaMrnLineOprCd() {
		return this.idaMrnLineOprCd;
	}
	
	/**
	 * Column Info
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return tmp4
	 */
	public String getTmp4() {
		return this.tmp4;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
	}
	
	/**
	 * Column Info
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
	}
	
	/**
	 * Column Info
	 * @return ibdNo
	 */
	public String getIbdNo() {
		return this.ibdNo;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return idaDestCd
	 */
	public String getIdaDestCd() {
		return this.idaDestCd;
	}
	

	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param idaLineNo
	 */
	public void setIdaLineNo(String idaLineNo) {
		this.idaLineNo = idaLineNo;
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
	 * @param crrAgnCd
	 */
	public void setCrrAgnCd(String crrAgnCd) {
		this.crrAgnCd = crrAgnCd;
	}
	
	/**
	 * Column Info
	 * @param newBlNo
	 */
	public void setNewBlNo(String newBlNo) {
		this.newBlNo = newBlNo;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
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
	 * @param podCdGubun
	 */
	public void setPodCdGubun(String podCdGubun) {
		this.podCdGubun = podCdGubun;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
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
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param idaCstmsItmTpCd
	 */
	public void setIdaCstmsItmTpCd(String idaCstmsItmTpCd) {
		this.idaCstmsItmTpCd = idaCstmsItmTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslDeclDt
	 */
	public void setVslDeclDt(String vslDeclDt) {
		this.vslDeclDt = vslDeclDt;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param idaTrspCd
	 */
	public void setIdaTrspCd(String idaTrspCd) {
		this.idaTrspCd = idaTrspCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param idaDeclVslNo
	 */
	public void setIdaDeclVslNo(String idaDeclVslNo) {
		this.idaDeclVslNo = idaDeclVslNo;
	}
	
	/**
	 * Column Info
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @param blDeclTpCd
	 */
	public void setBlDeclTpCd(String blDeclTpCd) {
		this.blDeclTpCd = blDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param tmp0
	 */
	public void setTmp0(String tmp0) {
		this.tmp0 = tmp0;
	}
	
	/**
	 * Column Info
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param idaMrnLineOprCd
	 */
	public void setIdaMrnLineOprCd(String idaMrnLineOprCd) {
		this.idaMrnLineOprCd = idaMrnLineOprCd;
	}
	
	/**
	 * Column Info
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param tmp4
	 */
	public void setTmp4(String tmp4) {
		this.tmp4 = tmp4;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
	}
	
	/**
	 * Column Info
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
	}
	
	/**
	 * Column Info
	 * @param ibdNo
	 */
	public void setIbdNo(String ibdNo) {
		this.ibdNo = ibdNo;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param idaDestCd
	 */
	public void setIdaDestCd(String idaDestCd) {
		this.idaDestCd = idaDestCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setIdaLineNo(JSPUtil.getParameter(request, "ida_line_no", ""));
		setCCustNm(JSPUtil.getParameter(request, "c_cust_nm", ""));
		setCrrAgnCd(JSPUtil.getParameter(request, "crr_agn_cd", ""));
		setNewBlNo(JSPUtil.getParameter(request, "new_bl_no", ""));
		setMkDesc(JSPUtil.getParameter(request, "mk_desc", ""));
		setNCustAddr(JSPUtil.getParameter(request, "n_cust_addr", ""));
		setPodCdGubun(JSPUtil.getParameter(request, "pod_cd_gubun", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCCustAddr(JSPUtil.getParameter(request, "c_cust_addr", ""));
		setWgt(JSPUtil.getParameter(request, "wgt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setNCustNm(JSPUtil.getParameter(request, "n_cust_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setIdaCstmsItmTpCd(JSPUtil.getParameter(request, "ida_cstms_itm_tp_cd", ""));
		setVslDeclDt(JSPUtil.getParameter(request, "vsl_decl_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setIdaTrspCd(JSPUtil.getParameter(request, "ida_trsp_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setIdaDeclVslNo(JSPUtil.getParameter(request, "ida_decl_vsl_no", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setBlDeclTpCd(JSPUtil.getParameter(request, "bl_decl_tp_cd", ""));
		setTmp0(JSPUtil.getParameter(request, "tmp0", ""));
		setTmp2(JSPUtil.getParameter(request, "tmp2", ""));
		setIdaMrnLineOprCd(JSPUtil.getParameter(request, "ida_mrn_line_opr_cd", ""));
		setTmp1(JSPUtil.getParameter(request, "tmp1", ""));
		setTmp4(JSPUtil.getParameter(request, "tmp4", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setTmp3(JSPUtil.getParameter(request, "tmp3", ""));
		setBlObrdDt(JSPUtil.getParameter(request, "bl_obrd_dt", ""));
		setIbdNo(JSPUtil.getParameter(request, "ibd_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setIdaDestCd(JSPUtil.getParameter(request, "ida_dest_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaBlListDetailVO[]
	 */
	public IndiaBlListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaBlListDetailVO[]
	 */
	public IndiaBlListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndiaBlListDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] idaLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_line_no", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] crrAgnCd = (JSPUtil.getParameter(request, prefix	+ "crr_agn_cd", length));
			String[] newBlNo = (JSPUtil.getParameter(request, prefix	+ "new_bl_no", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] podCdGubun = (JSPUtil.getParameter(request, prefix	+ "pod_cd_gubun", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] idaCstmsItmTpCd = (JSPUtil.getParameter(request, prefix	+ "ida_cstms_itm_tp_cd", length));
			String[] vslDeclDt = (JSPUtil.getParameter(request, prefix	+ "vsl_decl_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] idaTrspCd = (JSPUtil.getParameter(request, prefix	+ "ida_trsp_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] idaDeclVslNo = (JSPUtil.getParameter(request, prefix	+ "ida_decl_vsl_no", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] blDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_decl_tp_cd", length));
			String[] tmp0 = (JSPUtil.getParameter(request, prefix	+ "tmp0", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] idaMrnLineOprCd = (JSPUtil.getParameter(request, prefix	+ "ida_mrn_line_opr_cd", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] tmp4 = (JSPUtil.getParameter(request, prefix	+ "tmp4", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] ibdNo = (JSPUtil.getParameter(request, prefix	+ "ibd_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] idaDestCd = (JSPUtil.getParameter(request, prefix	+ "ida_dest_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndiaBlListDetailVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (idaLineNo[i] != null)
					model.setIdaLineNo(idaLineNo[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (crrAgnCd[i] != null)
					model.setCrrAgnCd(crrAgnCd[i]);
				if (newBlNo[i] != null)
					model.setNewBlNo(newBlNo[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (podCdGubun[i] != null)
					model.setPodCdGubun(podCdGubun[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (idaCstmsItmTpCd[i] != null)
					model.setIdaCstmsItmTpCd(idaCstmsItmTpCd[i]);
				if (vslDeclDt[i] != null)
					model.setVslDeclDt(vslDeclDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (idaTrspCd[i] != null)
					model.setIdaTrspCd(idaTrspCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (idaDeclVslNo[i] != null)
					model.setIdaDeclVslNo(idaDeclVslNo[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (blDeclTpCd[i] != null)
					model.setBlDeclTpCd(blDeclTpCd[i]);
				if (tmp0[i] != null)
					model.setTmp0(tmp0[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (idaMrnLineOprCd[i] != null)
					model.setIdaMrnLineOprCd(idaMrnLineOprCd[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (tmp4[i] != null)
					model.setTmp4(tmp4[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (ibdNo[i] != null)
					model.setIbdNo(ibdNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (idaDestCd[i] != null)
					model.setIdaDestCd(idaDestCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndiaBlListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndiaBlListDetailVO[]
	 */
	public IndiaBlListDetailVO[] getIndiaBlListDetailVOs(){
		IndiaBlListDetailVO[] vos = (IndiaBlListDetailVO[])models.toArray(new IndiaBlListDetailVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaLineNo = this.idaLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAgnCd = this.crrAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBlNo = this.newBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCdGubun = this.podCdGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCstmsItmTpCd = this.idaCstmsItmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeclDt = this.vslDeclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTrspCd = this.idaTrspCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDeclVslNo = this.idaDeclVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDeclTpCd = this.blDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp0 = this.tmp0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaMrnLineOprCd = this.idaMrnLineOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp4 = this.tmp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdNo = this.ibdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDestCd = this.idaDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
