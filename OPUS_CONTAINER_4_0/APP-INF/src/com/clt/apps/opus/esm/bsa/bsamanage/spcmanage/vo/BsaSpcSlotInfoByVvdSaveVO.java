/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BsaSpcSlotInfoByVvdSaveVO.java
*@FileTitle : BsaSpcSlotInfoByVvdSaveVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.13 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaSpcSlotInfoByVvdSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaSpcSlotInfoByVvdSaveVO> models = new ArrayList<BsaSpcSlotInfoByVvdSaveVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String sltSwapTeuCapa = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String spcOtrSwapFlg = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String n1stPortEtdDt = null;
	/* Column Info */
	private String spcCtrtSltCapa = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String rdoopjob = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String freeAddWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsaZrFlg = null;
	/* Column Info */
	private String freeAddTeuCapa = null;
	/* Column Info */
	private String n2ndFnlCoBsaCapa = null;
	/* Column Info */
	private String slsTeuCapa = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String vslLaneTpCd = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String header = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String crrBsaCapa = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String purTeuCapa = null;
	/* Column Info */
	private String bsaOpCd = null;
	/* Column Info */
	private String fnlCoBsaCapa = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String costYrwk = null;
	
	/* Column Info */
	private String creUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaSpcSlotInfoByVvdSaveVO() {}

	public BsaSpcSlotInfoByVvdSaveVO(String ibflag, String pagerows, String bsaZrFlg, String costYrwk, String trdCd, String subTrdCd, String slanCd, String rlaneCd, String vslLaneTpCd, String vslCd, String skdVoyNo, String skdDirCd, String vopCd, String crrCd, String bsaCapa, String fnlCoBsaCapa, String crrBsaCapa, String freeAddTeuCapa, String freeAddWgt, String n2ndFnlCoBsaCapa, String spcCtrtSltCapa, String spcOtrSwapFlg, String slsTeuCapa, String purTeuCapa, String sltSwapTeuCapa, String iocCd, String bsaOpCd, String n1stPortEtdDt, String header, String rdoopjob, String creUsrId) {
		this.vslCd = vslCd;
		this.sltSwapTeuCapa = sltSwapTeuCapa;
		this.trdCd = trdCd;
		this.spcOtrSwapFlg = spcOtrSwapFlg;
		this.rlaneCd = rlaneCd;
		this.n1stPortEtdDt = n1stPortEtdDt;
		this.spcCtrtSltCapa = spcCtrtSltCapa;
		this.crrCd = crrCd;
		this.rdoopjob = rdoopjob;
		this.pagerows = pagerows;
		this.freeAddWgt = freeAddWgt;
		this.ibflag = ibflag;
		this.bsaZrFlg = bsaZrFlg;
		this.freeAddTeuCapa = freeAddTeuCapa;
		this.n2ndFnlCoBsaCapa = n2ndFnlCoBsaCapa;
		this.slsTeuCapa = slsTeuCapa;
		this.iocCd = iocCd;
		this.vslLaneTpCd = vslLaneTpCd;
		this.vopCd = vopCd;
		this.skdVoyNo = skdVoyNo;
		this.header = header;
		this.skdDirCd = skdDirCd;
		this.crrBsaCapa = crrBsaCapa;
		this.bsaCapa = bsaCapa;
		this.slanCd = slanCd;
		this.purTeuCapa = purTeuCapa;
		this.bsaOpCd = bsaOpCd;
		this.fnlCoBsaCapa = fnlCoBsaCapa;
		this.subTrdCd = subTrdCd;
		this.costYrwk = costYrwk;
		
		this.creUsrId 		= creUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("slt_swap_teu_capa", getSltSwapTeuCapa());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("spc_otr_swap_flg", getSpcOtrSwapFlg());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("n1st_port_etd_dt", getN1stPortEtdDt());
		this.hashColumns.put("spc_ctrt_slt_capa", getSpcCtrtSltCapa());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("rdoopjob", getRdoopjob());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("free_add_wgt", getFreeAddWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa_zr_flg", getBsaZrFlg());
		this.hashColumns.put("free_add_teu_capa", getFreeAddTeuCapa());
		this.hashColumns.put("n2nd_fnl_co_bsa_capa", getN2ndFnlCoBsaCapa());
		this.hashColumns.put("sls_teu_capa", getSlsTeuCapa());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("vsl_lane_tp_cd", getVslLaneTpCd());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("crr_bsa_capa", getCrrBsaCapa());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pur_teu_capa", getPurTeuCapa());
		this.hashColumns.put("bsa_op_cd", getBsaOpCd());
		this.hashColumns.put("fnl_co_bsa_capa", getFnlCoBsaCapa());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("slt_swap_teu_capa", "sltSwapTeuCapa");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("spc_otr_swap_flg", "spcOtrSwapFlg");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("n1st_port_etd_dt", "n1stPortEtdDt");
		this.hashFields.put("spc_ctrt_slt_capa", "spcCtrtSltCapa");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("rdoopjob", "rdoopjob");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("free_add_wgt", "freeAddWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa_zr_flg", "bsaZrFlg");
		this.hashFields.put("free_add_teu_capa", "freeAddTeuCapa");
		this.hashFields.put("n2nd_fnl_co_bsa_capa", "n2ndFnlCoBsaCapa");
		this.hashFields.put("sls_teu_capa", "slsTeuCapa");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("vsl_lane_tp_cd", "vslLaneTpCd");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("header", "header");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("crr_bsa_capa", "crrBsaCapa");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pur_teu_capa", "purTeuCapa");
		this.hashFields.put("bsa_op_cd", "bsaOpCd");
		this.hashFields.put("fnl_co_bsa_capa", "fnlCoBsaCapa");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return sltSwapTeuCapa
	 */
	public String getSltSwapTeuCapa() {
		return this.sltSwapTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return spcOtrSwapFlg
	 */
	public String getSpcOtrSwapFlg() {
		return this.spcOtrSwapFlg;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPortEtdDt
	 */
	public String getN1stPortEtdDt() {
		return this.n1stPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return spcCtrtSltCapa
	 */
	public String getSpcCtrtSltCapa() {
		return this.spcCtrtSltCapa;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return rdoopjob
	 */
	public String getRdoopjob() {
		return this.rdoopjob;
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
	 * @return freeAddWgt
	 */
	public String getFreeAddWgt() {
		return this.freeAddWgt;
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
	 * @return bsaZrFlg
	 */
	public String getBsaZrFlg() {
		return this.bsaZrFlg;
	}
	
	/**
	 * Column Info
	 * @return freeAddTeuCapa
	 */
	public String getFreeAddTeuCapa() {
		return this.freeAddTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return n2ndFnlCoBsaCapa
	 */
	public String getN2ndFnlCoBsaCapa() {
		return this.n2ndFnlCoBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return slsTeuCapa
	 */
	public String getSlsTeuCapa() {
		return this.slsTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return vslLaneTpCd
	 */
	public String getVslLaneTpCd() {
		return this.vslLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
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
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return crrBsaCapa
	 */
	public String getCrrBsaCapa() {
		return this.crrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return purTeuCapa
	 */
	public String getPurTeuCapa() {
		return this.purTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return bsaOpCd
	 */
	public String getBsaOpCd() {
		return this.bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @return fnlCoBsaCapa
	 */
	public String getFnlCoBsaCapa() {
		return this.fnlCoBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param sltSwapTeuCapa
	 */
	public void setSltSwapTeuCapa(String sltSwapTeuCapa) {
		this.sltSwapTeuCapa = sltSwapTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param spcOtrSwapFlg
	 */
	public void setSpcOtrSwapFlg(String spcOtrSwapFlg) {
		this.spcOtrSwapFlg = spcOtrSwapFlg;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPortEtdDt
	 */
	public void setN1stPortEtdDt(String n1stPortEtdDt) {
		this.n1stPortEtdDt = n1stPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param spcCtrtSltCapa
	 */
	public void setSpcCtrtSltCapa(String spcCtrtSltCapa) {
		this.spcCtrtSltCapa = spcCtrtSltCapa;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param rdoopjob
	 */
	public void setRdoopjob(String rdoopjob) {
		this.rdoopjob = rdoopjob;
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
	 * @param freeAddWgt
	 */
	public void setFreeAddWgt(String freeAddWgt) {
		this.freeAddWgt = freeAddWgt;
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
	 * @param bsaZrFlg
	 */
	public void setBsaZrFlg(String bsaZrFlg) {
		this.bsaZrFlg = bsaZrFlg;
	}
	
	/**
	 * Column Info
	 * @param freeAddTeuCapa
	 */
	public void setFreeAddTeuCapa(String freeAddTeuCapa) {
		this.freeAddTeuCapa = freeAddTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param n2ndFnlCoBsaCapa
	 */
	public void setN2ndFnlCoBsaCapa(String n2ndFnlCoBsaCapa) {
		this.n2ndFnlCoBsaCapa = n2ndFnlCoBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param slsTeuCapa
	 */
	public void setSlsTeuCapa(String slsTeuCapa) {
		this.slsTeuCapa = slsTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param vslLaneTpCd
	 */
	public void setVslLaneTpCd(String vslLaneTpCd) {
		this.vslLaneTpCd = vslLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
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
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param crrBsaCapa
	 */
	public void setCrrBsaCapa(String crrBsaCapa) {
		this.crrBsaCapa = crrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param purTeuCapa
	 */
	public void setPurTeuCapa(String purTeuCapa) {
		this.purTeuCapa = purTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param bsaOpCd
	 */
	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @param fnlCoBsaCapa
	 */
	public void setFnlCoBsaCapa(String fnlCoBsaCapa) {
		this.fnlCoBsaCapa = fnlCoBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSltSwapTeuCapa(JSPUtil.getParameter(request, "slt_swap_teu_capa", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSpcOtrSwapFlg(JSPUtil.getParameter(request, "spc_otr_swap_flg", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setN1stPortEtdDt(JSPUtil.getParameter(request, "n1st_port_etd_dt", ""));
		setSpcCtrtSltCapa(JSPUtil.getParameter(request, "spc_ctrt_slt_capa", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setRdoopjob(JSPUtil.getParameter(request, "rdoOpJob", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFreeAddWgt(JSPUtil.getParameter(request, "free_add_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBsaZrFlg(JSPUtil.getParameter(request, "bsa_zr_flg", ""));
		setFreeAddTeuCapa(JSPUtil.getParameter(request, "free_add_teu_capa", ""));
		setN2ndFnlCoBsaCapa(JSPUtil.getParameter(request, "n2nd_fnl_co_bsa_capa", ""));
		setSlsTeuCapa(JSPUtil.getParameter(request, "sls_teu_capa", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setVslLaneTpCd(JSPUtil.getParameter(request, "vsl_lane_tp_cd", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setHeader(JSPUtil.getParameter(request, "header", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCrrBsaCapa(JSPUtil.getParameter(request, "crr_bsa_capa", ""));
		setBsaCapa(JSPUtil.getParameter(request, "bsa_capa", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setPurTeuCapa(JSPUtil.getParameter(request, "pur_teu_capa", ""));
		setBsaOpCd(JSPUtil.getParameter(request, "bsa_op_cd", ""));
		setFnlCoBsaCapa(JSPUtil.getParameter(request, "fnl_co_bsa_capa", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, "cost_yrwk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaSpcSlotInfoByVvdSaveVO[]
	 */
	public BsaSpcSlotInfoByVvdSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaSpcSlotInfoByVvdSaveVO[]
	 */
	public BsaSpcSlotInfoByVvdSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaSpcSlotInfoByVvdSaveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
		String[] arrcrr_cd =null;
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  		
  		setHeader(JSPUtil.getParameter(request, "header", ""));
  		setRdoopjob(JSPUtil.getParameter(request, "rdoOpJob", ""));
  		header = getHeader();
  		rdoopjob = getRdoopjob();
  		
  		arrcrr_cd = header.split("[|]");
  		  
		try {
			String[] pagerows 			= (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag 			= (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsaZrFlg 			= (JSPUtil.getParameter(request, prefix	+ "bsa_zr_flg", length));
			
			String[] costYrwk 			= (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			String[] trdCd 				= (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] subTrdCd 			= (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] slanCd 			= (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] rlaneCd 			= (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] vslLaneTpCd 		= (JSPUtil.getParameter(request, prefix	+ "vsl_lane_tp_cd", length));
			String[] vslCd 				= (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo 			= (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd 			= (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vopCd 				= (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] crrCd 				= (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] bsaCapa 			= (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] fnlCoBsaCapa 		= (JSPUtil.getParameter(request, prefix	+ "fnl_co_bsa_capa", length));
			String[] freeAddTeuCapa 	= (JSPUtil.getParameter(request, prefix	+ "free_add_teu_capa", length));
			String[] freeAddWgt 		= (JSPUtil.getParameter(request, prefix	+ "free_add_wgt", length));
			String[] n2ndFnlCoBsaCapa 	= (JSPUtil.getParameter(request, prefix	+ "n2nd_fnl_co_bsa_capa", length));
			String[] spcOtrSwapFlg 		= (JSPUtil.getParameter(request, prefix	+ "spc_otr_swap_flg", length));
			String[] iocCd 				= (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] bsaOpCd 			= (JSPUtil.getParameter(request, prefix	+ "bsa_op_cd", length));
			String[] n1stPortEtdDt 		= (JSPUtil.getParameter(request, prefix	+ "n1st_port_etd_dt", length));
			String[] creUsrId 			= (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
						
			for (int i = 0; i < length; i++) {
				model = new BsaSpcSlotInfoByVvdSaveVO();
				String crrBsaCapa_tmp 		= "";
				String spcCtrtSltCapa_tmp 	= "";
				String slsTeuCapa_tmp 		= "";
				String purTeuCapa_tmp 		= ""; 
				String sltSwapTeuCapa_tmp 	= "";
				
				if (ibflag[i] != null)					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)				model.setPagerows(pagerows[i]);
				
				if (bsaZrFlg[i] != null)				model.setBsaZrFlg(bsaZrFlg[i]);
				if (costYrwk[i] != null)				model.setCostYrwk(costYrwk[i]);
				if (trdCd[i] != null)					model.setTrdCd(trdCd[i]);	
				if (subTrdCd[i] != null)				model.setSubTrdCd(subTrdCd[i]);
				if (slanCd[i] != null)					model.setSlanCd(slanCd[i]);
				if (rlaneCd[i] != null)					model.setRlaneCd(rlaneCd[i]);
				
				if (vslLaneTpCd[i] != null)				model.setVslLaneTpCd(vslLaneTpCd[i]);
				if (vslCd[i] != null)					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)				model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)				model.setSkdDirCd(skdDirCd[i]);
				if (vopCd[i] != null)					model.setVopCd(vopCd[i]);
				if (crrCd[i] != null)					model.setCrrCd(crrCd[i]);
				if (bsaCapa[i] != null)					model.setBsaCapa(bsaCapa[i]);
				if (fnlCoBsaCapa[i] != null)			model.setFnlCoBsaCapa(fnlCoBsaCapa[i]);
				
				if (n2ndFnlCoBsaCapa[i] != null)		model.setN2ndFnlCoBsaCapa(n2ndFnlCoBsaCapa[i]);
				
				if (spcOtrSwapFlg[i] != null)			model.setSpcOtrSwapFlg(spcOtrSwapFlg[i]);
				if (freeAddWgt[i] != null)				model.setFreeAddWgt(freeAddWgt[i]);
				if (freeAddTeuCapa[i] != null)			model.setFreeAddTeuCapa(freeAddTeuCapa[i]);
				
				if (iocCd[i] != null)					model.setIocCd(iocCd[i]);
				if (bsaOpCd[i] != null)					model.setBsaOpCd(bsaOpCd[i]);
				if (n1stPortEtdDt[i] != null)			model.setN1stPortEtdDt(n1stPortEtdDt[i]);
				if (creUsrId[i] != null)				model.setCreUsrId(creUsrId[i]);
				 for (int j = 0; j < arrcrr_cd.length; j++) {
					 String col = arrcrr_cd[j];
					 String[] crrBsaCapa 		= (JSPUtil.getParameter(request, "c"+ col, length));
					 String[] spcCtrtSltCapa 	= (JSPUtil.getParameter(request, "s"+ col, length));
					 String[] slsTeuCapa 		= (JSPUtil.getParameter(request, "sls"+ col, length));
					 String[] purTeuCapa 		= (JSPUtil.getParameter(request, "pur"+ col, length));
					 String[] sltSwapTeuCapa 	= (JSPUtil.getParameter(request, "slt"+ col, length));
					 
					 crrBsaCapa_tmp 	= 	crrBsaCapa_tmp 		+ crrBsaCapa[i] 	+  "|";
					 spcCtrtSltCapa_tmp = 	spcCtrtSltCapa_tmp 	+ spcCtrtSltCapa[i]	+  "|";
					 slsTeuCapa_tmp 	= 	slsTeuCapa_tmp 		+ slsTeuCapa[i]		+  "|";
					 purTeuCapa_tmp 	= 	purTeuCapa_tmp 		+ purTeuCapa[i] 	+  "|";
					 sltSwapTeuCapa_tmp = 	sltSwapTeuCapa_tmp 	+ sltSwapTeuCapa[i]	+  "|";
					}
				 
				if(crrBsaCapa_tmp!=null)					model.setCrrBsaCapa(crrBsaCapa_tmp);
				if (spcCtrtSltCapa_tmp != null)				model.setSpcCtrtSltCapa(spcCtrtSltCapa_tmp);
				if (slsTeuCapa_tmp != null)					model.setSlsTeuCapa(slsTeuCapa_tmp);
				if (purTeuCapa_tmp != null)					model.setPurTeuCapa(purTeuCapa_tmp);
				if (sltSwapTeuCapa_tmp != null)				model.setSltSwapTeuCapa(sltSwapTeuCapa_tmp);
				
				if (rdoopjob != null)					model.setRdoopjob(rdoopjob);
				if (header != null)						model.setHeader(header);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaSpcSlotInfoByVvdSaveVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaSpcSlotInfoByVvdSaveVO[]
	 */
	public BsaSpcSlotInfoByVvdSaveVO[] getBsaSpcSlotInfoByVvdSaveVOs(){
		BsaSpcSlotInfoByVvdSaveVO[] vos = (BsaSpcSlotInfoByVvdSaveVO[])models.toArray(new BsaSpcSlotInfoByVvdSaveVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltSwapTeuCapa = this.sltSwapTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcOtrSwapFlg = this.spcOtrSwapFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortEtdDt = this.n1stPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrtSltCapa = this.spcCtrtSltCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdoopjob = this.rdoopjob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeAddWgt = this.freeAddWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaZrFlg = this.bsaZrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeAddTeuCapa = this.freeAddTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndFnlCoBsaCapa = this.n2ndFnlCoBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsTeuCapa = this.slsTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneTpCd = this.vslLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBsaCapa = this.crrBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purTeuCapa = this.purTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpCd = this.bsaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlCoBsaCapa = this.fnlCoBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
