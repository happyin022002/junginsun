/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductcatalogInternalDetailVO.java
*@FileTitle : ProductcatalogInternalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.10.19 노승배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo;

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
 * @author 노승배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ProductCatalogInternalDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ProductCatalogInternalDetailVO> models = new ArrayList<ProductCatalogInternalDetailVO>();
	
	/* Column Info */
	private String genAvalSpc = null;
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String mtyYdFlg = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String pctlSeq = null;
	/* Column Info */
	private String remarkImg = null;
	/* Column Info */
	private String nodeLink = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String oTMode = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String pctlWtrDivCd = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String flRtCyPctlSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String transSt = null;
	/* Column Info */
	private String arrTime = null;
	/* Column Info */
	private String destNodCd = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String deliveryDt = null;
	/* Column Info */
	private String depTime = null;
	/* Column Info */
	private String iTMode = null;
	/* Column Info */
	private String vvdGb = null;
	/* Column Info */
	private String nodLnkDivCd = null;
	/* Column Info */
	private String doorDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String d7AvalSpc = null;
	/* Column Info */
	private String fmtTzDwllTm = null;
	/* Column Info */
	private String orgNodCd = null;
	/* Column Info */
	private String rfAvalSpc = null;
	/* Column Info */
	private String loadDtPctlSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ProductCatalogInternalDetailVO() {}

	public ProductCatalogInternalDetailVO(String ibflag, String pagerows, String nodeLink, String transSt, String trspModCd, String fmtTzDwllTm, String arrTime, String depTime, String vvd, String remarkImg, String remark, String genAvalSpc, String d7AvalSpc, String rfAvalSpc, String pctlNo, String pctlSeq, String vslSlanCd, String routOrgNodCd, String routDestNodCd, String vvdGb, String etd, String etb, String orgNodCd, String destNodCd, String pctlWtrDivCd, String nodLnkDivCd, String mtyYdFlg, String doorDt, String deliveryDt, String oTMode, String iTMode, String loadDtPctlSeq, String flRtCyPctlSeq) {
		this.genAvalSpc = genAvalSpc;
		this.etb = etb;
		this.mtyYdFlg = mtyYdFlg;
		this.remark = remark;
		this.etd = etd;
		this.pctlSeq = pctlSeq;
		this.remarkImg = remarkImg;
		this.nodeLink = nodeLink;
		this.routOrgNodCd = routOrgNodCd;
		this.oTMode = oTMode;
		this.vslSlanCd = vslSlanCd;
		this.pctlWtrDivCd = pctlWtrDivCd;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.flRtCyPctlSeq = flRtCyPctlSeq;
		this.ibflag = ibflag;
		this.transSt = transSt;
		this.arrTime = arrTime;
		this.destNodCd = destNodCd;
		this.routDestNodCd = routDestNodCd;
		this.deliveryDt = deliveryDt;
		this.depTime = depTime;
		this.iTMode = iTMode;
		this.vvdGb = vvdGb;
		this.nodLnkDivCd = nodLnkDivCd;
		this.doorDt = doorDt;
		this.vvd = vvd;
		this.d7AvalSpc = d7AvalSpc;
		this.fmtTzDwllTm = fmtTzDwllTm;
		this.orgNodCd = orgNodCd;
		this.rfAvalSpc = rfAvalSpc;
		this.loadDtPctlSeq = loadDtPctlSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gen_aval_spc", getGenAvalSpc());
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("mty_yd_flg", getMtyYdFlg());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("pctl_seq", getPctlSeq());
		this.hashColumns.put("remark_img", getRemarkImg());
		this.hashColumns.put("node_link", getNodeLink());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("o_t_mode", getOTMode());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pctl_wtr_div_cd", getPctlWtrDivCd());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("fl_rt_cy_pctl_seq", getFlRtCyPctlSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trans_st", getTransSt());
		this.hashColumns.put("arr_time", getArrTime());
		this.hashColumns.put("dest_nod_cd", getDestNodCd());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("delivery_dt", getDeliveryDt());
		this.hashColumns.put("dep_time", getDepTime());
		this.hashColumns.put("i_t_mode", getITMode());
		this.hashColumns.put("vvd_gb", getVvdGb());
		this.hashColumns.put("nod_lnk_div_cd", getNodLnkDivCd());
		this.hashColumns.put("door_dt", getDoorDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("d7_aval_spc", getD7AvalSpc());
		this.hashColumns.put("fmt_tz_dwll_tm", getFmtTzDwllTm());
		this.hashColumns.put("org_nod_cd", getOrgNodCd());
		this.hashColumns.put("rf_aval_spc", getRfAvalSpc());
		this.hashColumns.put("load_dt_pctl_seq", getLoadDtPctlSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gen_aval_spc", "genAvalSpc");
		this.hashFields.put("etb", "etb");
		this.hashFields.put("mty_yd_flg", "mtyYdFlg");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("pctl_seq", "pctlSeq");
		this.hashFields.put("remark_img", "remarkImg");
		this.hashFields.put("node_link", "nodeLink");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("o_t_mode", "oTMode");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pctl_wtr_div_cd", "pctlWtrDivCd");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("fl_rt_cy_pctl_seq", "flRtCyPctlSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trans_st", "transSt");
		this.hashFields.put("arr_time", "arrTime");
		this.hashFields.put("dest_nod_cd", "destNodCd");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("delivery_dt", "deliveryDt");
		this.hashFields.put("dep_time", "depTime");
		this.hashFields.put("i_t_mode", "iTMode");
		this.hashFields.put("vvd_gb", "vvdGb");
		this.hashFields.put("nod_lnk_div_cd", "nodLnkDivCd");
		this.hashFields.put("door_dt", "doorDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("d7_aval_spc", "d7AvalSpc");
		this.hashFields.put("fmt_tz_dwll_tm", "fmtTzDwllTm");
		this.hashFields.put("org_nod_cd", "orgNodCd");
		this.hashFields.put("rf_aval_spc", "rfAvalSpc");
		this.hashFields.put("load_dt_pctl_seq", "loadDtPctlSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return genAvalSpc
	 */
	public String getGenAvalSpc() {
		return this.genAvalSpc;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}
	
	/**
	 * Column Info
	 * @return mtyYdFlg
	 */
	public String getMtyYdFlg() {
		return this.mtyYdFlg;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return pctlSeq
	 */
	public String getPctlSeq() {
		return this.pctlSeq;
	}
	
	/**
	 * Column Info
	 * @return remarkImg
	 */
	public String getRemarkImg() {
		return this.remarkImg;
	}
	
	/**
	 * Column Info
	 * @return nodeLink
	 */
	public String getNodeLink() {
		return this.nodeLink;
	}
	
	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return oTMode
	 */
	public String getOTMode() {
		return this.oTMode;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return pctlWtrDivCd
	 */
	public String getPctlWtrDivCd() {
		return this.pctlWtrDivCd;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return flRtCyPctlSeq
	 */
	public String getFlRtCyPctlSeq() {
		return this.flRtCyPctlSeq;
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
	 * @return transSt
	 */
	public String getTransSt() {
		return this.transSt;
	}
	
	/**
	 * Column Info
	 * @return arrTime
	 */
	public String getArrTime() {
		return this.arrTime;
	}
	
	/**
	 * Column Info
	 * @return destNodCd
	 */
	public String getDestNodCd() {
		return this.destNodCd;
	}
	
	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return deliveryDt
	 */
	public String getDeliveryDt() {
		return this.deliveryDt;
	}
	
	/**
	 * Column Info
	 * @return depTime
	 */
	public String getDepTime() {
		return this.depTime;
	}
	
	/**
	 * Column Info
	 * @return iTMode
	 */
	public String getITMode() {
		return this.iTMode;
	}
	
	/**
	 * Column Info
	 * @return vvdGb
	 */
	public String getVvdGb() {
		return this.vvdGb;
	}
	
	/**
	 * Column Info
	 * @return nodLnkDivCd
	 */
	public String getNodLnkDivCd() {
		return this.nodLnkDivCd;
	}
	
	/**
	 * Column Info
	 * @return doorDt
	 */
	public String getDoorDt() {
		return this.doorDt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return d7AvalSpc
	 */
	public String getD7AvalSpc() {
		return this.d7AvalSpc;
	}
	
	/**
	 * Column Info
	 * @return fmtTzDwllTm
	 */
	public String getFmtTzDwllTm() {
		return this.fmtTzDwllTm;
	}
	
	/**
	 * Column Info
	 * @return orgNodCd
	 */
	public String getOrgNodCd() {
		return this.orgNodCd;
	}
	
	/**
	 * Column Info
	 * @return rfAvalSpc
	 */
	public String getRfAvalSpc() {
		return this.rfAvalSpc;
	}
	
	/**
	 * Column Info
	 * @return loadDtPctlSeq
	 */
	public String getLoadDtPctlSeq() {
		return this.loadDtPctlSeq;
	}
	

	/**
	 * Column Info
	 * @param genAvalSpc
	 */
	public void setGenAvalSpc(String genAvalSpc) {
		this.genAvalSpc = genAvalSpc;
	}
	
	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}
	
	/**
	 * Column Info
	 * @param mtyYdFlg
	 */
	public void setMtyYdFlg(String mtyYdFlg) {
		this.mtyYdFlg = mtyYdFlg;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param pctlSeq
	 */
	public void setPctlSeq(String pctlSeq) {
		this.pctlSeq = pctlSeq;
	}
	
	/**
	 * Column Info
	 * @param remarkImg
	 */
	public void setRemarkImg(String remarkImg) {
		this.remarkImg = remarkImg;
	}
	
	/**
	 * Column Info
	 * @param nodeLink
	 */
	public void setNodeLink(String nodeLink) {
		this.nodeLink = nodeLink;
	}
	
	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param oTMode
	 */
	public void setOTMode(String oTMode) {
		this.oTMode = oTMode;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param pctlWtrDivCd
	 */
	public void setPctlWtrDivCd(String pctlWtrDivCd) {
		this.pctlWtrDivCd = pctlWtrDivCd;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
	 * @param flRtCyPctlSeq
	 */
	public void setFlRtCyPctlSeq(String flRtCyPctlSeq) {
		this.flRtCyPctlSeq = flRtCyPctlSeq;
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
	 * @param transSt
	 */
	public void setTransSt(String transSt) {
		this.transSt = transSt;
	}
	
	/**
	 * Column Info
	 * @param arrTime
	 */
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	
	/**
	 * Column Info
	 * @param destNodCd
	 */
	public void setDestNodCd(String destNodCd) {
		this.destNodCd = destNodCd;
	}
	
	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param deliveryDt
	 */
	public void setDeliveryDt(String deliveryDt) {
		this.deliveryDt = deliveryDt;
	}
	
	/**
	 * Column Info
	 * @param depTime
	 */
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	
	/**
	 * Column Info
	 * @param iTMode
	 */
	public void setITMode(String iTMode) {
		this.iTMode = iTMode;
	}
	
	/**
	 * Column Info
	 * @param vvdGb
	 */
	public void setVvdGb(String vvdGb) {
		this.vvdGb = vvdGb;
	}
	
	/**
	 * Column Info
	 * @param nodLnkDivCd
	 */
	public void setNodLnkDivCd(String nodLnkDivCd) {
		this.nodLnkDivCd = nodLnkDivCd;
	}
	
	/**
	 * Column Info
	 * @param doorDt
	 */
	public void setDoorDt(String doorDt) {
		this.doorDt = doorDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param d7AvalSpc
	 */
	public void setD7AvalSpc(String d7AvalSpc) {
		this.d7AvalSpc = d7AvalSpc;
	}
	
	/**
	 * Column Info
	 * @param fmtTzDwllTm
	 */
	public void setFmtTzDwllTm(String fmtTzDwllTm) {
		this.fmtTzDwllTm = fmtTzDwllTm;
	}
	
	/**
	 * Column Info
	 * @param orgNodCd
	 */
	public void setOrgNodCd(String orgNodCd) {
		this.orgNodCd = orgNodCd;
	}
	
	/**
	 * Column Info
	 * @param rfAvalSpc
	 */
	public void setRfAvalSpc(String rfAvalSpc) {
		this.rfAvalSpc = rfAvalSpc;
	}
	
	/**
	 * Column Info
	 * @param loadDtPctlSeq
	 */
	public void setLoadDtPctlSeq(String loadDtPctlSeq) {
		this.loadDtPctlSeq = loadDtPctlSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGenAvalSpc(JSPUtil.getParameter(request, "gen_aval_spc", ""));
		setEtb(JSPUtil.getParameter(request, "etb", ""));
		setMtyYdFlg(JSPUtil.getParameter(request, "mty_yd_flg", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setPctlSeq(JSPUtil.getParameter(request, "pctl_seq", ""));
		setRemarkImg(JSPUtil.getParameter(request, "remark_img", ""));
		setNodeLink(JSPUtil.getParameter(request, "node_link", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setOTMode(JSPUtil.getParameter(request, "o_t_mode", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setPctlWtrDivCd(JSPUtil.getParameter(request, "pctl_wtr_div_cd", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setFlRtCyPctlSeq(JSPUtil.getParameter(request, "fl_rt_cy_pctl_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTransSt(JSPUtil.getParameter(request, "trans_st", ""));
		setArrTime(JSPUtil.getParameter(request, "arr_time", ""));
		setDestNodCd(JSPUtil.getParameter(request, "dest_nod_cd", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setDeliveryDt(JSPUtil.getParameter(request, "delivery_dt", ""));
		setDepTime(JSPUtil.getParameter(request, "dep_time", ""));
		setITMode(JSPUtil.getParameter(request, "i_t_mode", ""));
		setVvdGb(JSPUtil.getParameter(request, "vvd_gb", ""));
		setNodLnkDivCd(JSPUtil.getParameter(request, "nod_lnk_div_cd", ""));
		setDoorDt(JSPUtil.getParameter(request, "door_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setD7AvalSpc(JSPUtil.getParameter(request, "d7_aval_spc", ""));
		setFmtTzDwllTm(JSPUtil.getParameter(request, "fmt_tz_dwll_tm", ""));
		setOrgNodCd(JSPUtil.getParameter(request, "org_nod_cd", ""));
		setRfAvalSpc(JSPUtil.getParameter(request, "rf_aval_spc", ""));
		setLoadDtPctlSeq(JSPUtil.getParameter(request, "load_dt_pctl_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProductcatalogInternalDetailVO[]
	 */
	public ProductCatalogInternalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProductcatalogInternalDetailVO[]
	 */
	public ProductCatalogInternalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProductCatalogInternalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] genAvalSpc = (JSPUtil.getParameter(request, prefix	+ "gen_aval_spc", length));
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] mtyYdFlg = (JSPUtil.getParameter(request, prefix	+ "mty_yd_flg", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] pctlSeq = (JSPUtil.getParameter(request, prefix	+ "pctl_seq", length));
			String[] remarkImg = (JSPUtil.getParameter(request, prefix	+ "remark_img", length));
			String[] nodeLink = (JSPUtil.getParameter(request, prefix	+ "node_link", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] oTMode = (JSPUtil.getParameter(request, prefix	+ "o_t_mode", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pctlWtrDivCd = (JSPUtil.getParameter(request, prefix	+ "pctl_wtr_div_cd", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] flRtCyPctlSeq = (JSPUtil.getParameter(request, prefix	+ "fl_rt_cy_pctl_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] transSt = (JSPUtil.getParameter(request, prefix	+ "trans_st", length));
			String[] arrTime = (JSPUtil.getParameter(request, prefix	+ "arr_time", length));
			String[] destNodCd = (JSPUtil.getParameter(request, prefix	+ "dest_nod_cd", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] deliveryDt = (JSPUtil.getParameter(request, prefix	+ "delivery_dt", length));
			String[] depTime = (JSPUtil.getParameter(request, prefix	+ "dep_time", length));
			String[] iTMode = (JSPUtil.getParameter(request, prefix	+ "i_t_mode", length));
			String[] vvdGb = (JSPUtil.getParameter(request, prefix	+ "vvd_gb", length));
			String[] nodLnkDivCd = (JSPUtil.getParameter(request, prefix	+ "nod_lnk_div_cd", length));
			String[] doorDt = (JSPUtil.getParameter(request, prefix	+ "door_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] d7AvalSpc = (JSPUtil.getParameter(request, prefix	+ "d7_aval_spc", length));
			String[] fmtTzDwllTm = (JSPUtil.getParameter(request, prefix	+ "fmt_tz_dwll_tm", length));
			String[] orgNodCd = (JSPUtil.getParameter(request, prefix	+ "org_nod_cd", length));
			String[] rfAvalSpc = (JSPUtil.getParameter(request, prefix	+ "rf_aval_spc", length));
			String[] loadDtPctlSeq = (JSPUtil.getParameter(request, prefix	+ "load_dt_pctl_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new ProductCatalogInternalDetailVO();
				if (genAvalSpc[i] != null)
					model.setGenAvalSpc(genAvalSpc[i]);
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (mtyYdFlg[i] != null)
					model.setMtyYdFlg(mtyYdFlg[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (pctlSeq[i] != null)
					model.setPctlSeq(pctlSeq[i]);
				if (remarkImg[i] != null)
					model.setRemarkImg(remarkImg[i]);
				if (nodeLink[i] != null)
					model.setNodeLink(nodeLink[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (oTMode[i] != null)
					model.setOTMode(oTMode[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pctlWtrDivCd[i] != null)
					model.setPctlWtrDivCd(pctlWtrDivCd[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (flRtCyPctlSeq[i] != null)
					model.setFlRtCyPctlSeq(flRtCyPctlSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (transSt[i] != null)
					model.setTransSt(transSt[i]);
				if (arrTime[i] != null)
					model.setArrTime(arrTime[i]);
				if (destNodCd[i] != null)
					model.setDestNodCd(destNodCd[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (deliveryDt[i] != null)
					model.setDeliveryDt(deliveryDt[i]);
				if (depTime[i] != null)
					model.setDepTime(depTime[i]);
				if (iTMode[i] != null)
					model.setITMode(iTMode[i]);
				if (vvdGb[i] != null)
					model.setVvdGb(vvdGb[i]);
				if (nodLnkDivCd[i] != null)
					model.setNodLnkDivCd(nodLnkDivCd[i]);
				if (doorDt[i] != null)
					model.setDoorDt(doorDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (d7AvalSpc[i] != null)
					model.setD7AvalSpc(d7AvalSpc[i]);
				if (fmtTzDwllTm[i] != null)
					model.setFmtTzDwllTm(fmtTzDwllTm[i]);
				if (orgNodCd[i] != null)
					model.setOrgNodCd(orgNodCd[i]);
				if (rfAvalSpc[i] != null)
					model.setRfAvalSpc(rfAvalSpc[i]);
				if (loadDtPctlSeq[i] != null)
					model.setLoadDtPctlSeq(loadDtPctlSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProductcatalogInternalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ProductcatalogInternalDetailVO[]
	 */
	public ProductCatalogInternalDetailVO[] getProductcatalogInternalDetailVOs(){
		ProductCatalogInternalDetailVO[] vos = (ProductCatalogInternalDetailVO[])models.toArray(new ProductCatalogInternalDetailVO[models.size()]);
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
		this.genAvalSpc = this.genAvalSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyYdFlg = this.mtyYdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlSeq = this.pctlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remarkImg = this.remarkImg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeLink = this.nodeLink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oTMode = this.oTMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlWtrDivCd = this.pctlWtrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flRtCyPctlSeq = this.flRtCyPctlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transSt = this.transSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTime = this.arrTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNodCd = this.destNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deliveryDt = this.deliveryDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depTime = this.depTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iTMode = this.iTMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdGb = this.vvdGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodLnkDivCd = this.nodLnkDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doorDt = this.doorDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7AvalSpc = this.d7AvalSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTzDwllTm = this.fmtTzDwllTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgNodCd = this.orgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfAvalSpc = this.rfAvalSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadDtPctlSeq = this.loadDtPctlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
