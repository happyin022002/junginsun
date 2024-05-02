/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongSearchCntrDetailVO.java
*@FileTitle : HongKongSearchCntrDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.20 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.vo;

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
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HongKongSearchCntrDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HongKongSearchCntrDetailVO> models = new ArrayList<HongKongSearchCntrDetailVO>();
	
	/* Column Info */
	private String amendCntr = null;
	/* Column Info */
	private String ovrw = null;
	/* Column Info */
	private String measure = null;
	/* Column Info */
	private String munit = null;
	/* Column Info */
	private String tunit = null;
	/* Column Info */
	private String sealnbr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovh = null;
	/* Column Info */
	private String dgInd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovwgt = null;
	/* Column Info */
	private String ovr = null;
	/* Column Info */
	private String akInd = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String wunit = null;
	/* Column Info */
	private String rfdryInd = null;
	/* Column Info */
	private String stwgReq = null;
	/* Column Info */
	private String voidSlot = null;
	/* Column Info */
	private String ovlw = null;
	/* Column Info */
	private String fmInd = null;
	/* Column Info */
	private String vent = null;
	/* Column Info */
	private String rfRemark = null;
	/* Column Info */
	private String cntrnbr = null;
	/* Column Info */
	private String pkg = null;
	/* Column Info */
	private String bkInd = null;
	/* Column Info */
	private String cntrwgt = null;
	/* Column Info */
	private String ovf = null;
	/* Column Info */
	private String cntrtype = null;
	/* Column Info */
	private String rfInd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String punit = null;
	/* Column Info */
	private String temp = null;
	/* Column Info */
	private String customsDesc = null;
	/* Column Info */
	private String cmdtcd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HongKongSearchCntrDetailVO() {}

	public HongKongSearchCntrDetailVO(String ibflag, String pagerows, String cntrnbr, String punit, String pkg, String wunit, String cntrwgt, String cntrtype, String sealnbr, String fmInd, String rfInd, String dgInd, String akInd, String bkInd, String temp, String tunit, String vent, String munit, String measure, String rdtype, String cmdtDesc, String cmdtcd, String rfRemark, String rfdryInd, String ovf, String ovr, String ovh, String ovlw, String ovrw, String ovwgt, String voidSlot, String stwgReq, String amendCntr, String customsDesc, String cntrNo) {
		this.amendCntr = amendCntr;
		this.ovrw = ovrw;
		this.measure = measure;
		this.munit = munit;
		this.tunit = tunit;
		this.sealnbr = sealnbr;
		this.pagerows = pagerows;
		this.ovh = ovh;
		this.dgInd = dgInd;
		this.ibflag = ibflag;
		this.ovwgt = ovwgt;
		this.ovr = ovr;
		this.akInd = akInd;
		this.rdtype = rdtype;
		this.wunit = wunit;
		this.rfdryInd = rfdryInd;
		this.stwgReq = stwgReq;
		this.voidSlot = voidSlot;
		this.ovlw = ovlw;
		this.fmInd = fmInd;
		this.vent = vent;
		this.rfRemark = rfRemark;
		this.cntrnbr = cntrnbr;
		this.pkg = pkg;
		this.bkInd = bkInd;
		this.cntrwgt = cntrwgt;
		this.ovf = ovf;
		this.cntrtype = cntrtype;
		this.rfInd = rfInd;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.punit = punit;
		this.temp = temp;
		this.customsDesc = customsDesc;
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amend_cntr", getAmendCntr());
		this.hashColumns.put("ovrw", getOvrw());
		this.hashColumns.put("measure", getMeasure());
		this.hashColumns.put("munit", getMunit());
		this.hashColumns.put("tunit", getTunit());
		this.hashColumns.put("sealnbr", getSealnbr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovh", getOvh());
		this.hashColumns.put("dg_ind", getDgInd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovwgt", getOvwgt());
		this.hashColumns.put("ovr", getOvr());
		this.hashColumns.put("ak_ind", getAkInd());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("wunit", getWunit());
		this.hashColumns.put("rfdry_ind", getRfdryInd());
		this.hashColumns.put("stwg_req", getStwgReq());
		this.hashColumns.put("void_slot", getVoidSlot());
		this.hashColumns.put("ovlw", getOvlw());
		this.hashColumns.put("fm_ind", getFmInd());
		this.hashColumns.put("vent", getVent());
		this.hashColumns.put("rf_remark", getRfRemark());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("pkg", getPkg());
		this.hashColumns.put("bk_ind", getBkInd());
		this.hashColumns.put("cntrwgt", getCntrwgt());
		this.hashColumns.put("ovf", getOvf());
		this.hashColumns.put("cntrtype", getCntrtype());
		this.hashColumns.put("rf_ind", getRfInd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("punit", getPunit());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("customs_desc", getCustomsDesc());
		this.hashColumns.put("cmdtcd", getCmdtcd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amend_cntr", "amendCntr");
		this.hashFields.put("ovrw", "ovrw");
		this.hashFields.put("measure", "measure");
		this.hashFields.put("munit", "munit");
		this.hashFields.put("tunit", "tunit");
		this.hashFields.put("sealnbr", "sealnbr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovh", "ovh");
		this.hashFields.put("dg_ind", "dgInd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovwgt", "ovwgt");
		this.hashFields.put("ovr", "ovr");
		this.hashFields.put("ak_ind", "akInd");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("wunit", "wunit");
		this.hashFields.put("rfdry_ind", "rfdryInd");
		this.hashFields.put("stwg_req", "stwgReq");
		this.hashFields.put("void_slot", "voidSlot");
		this.hashFields.put("ovlw", "ovlw");
		this.hashFields.put("fm_ind", "fmInd");
		this.hashFields.put("vent", "vent");
		this.hashFields.put("rf_remark", "rfRemark");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("pkg", "pkg");
		this.hashFields.put("bk_ind", "bkInd");
		this.hashFields.put("cntrwgt", "cntrwgt");
		this.hashFields.put("ovf", "ovf");
		this.hashFields.put("cntrtype", "cntrtype");
		this.hashFields.put("rf_ind", "rfInd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("punit", "punit");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("customs_desc", "customsDesc");
		this.hashFields.put("cmdtcd", "cmdtcd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amendCntr
	 */
	public String getAmendCntr() {
		return this.amendCntr;
	}
	
	/**
	 * Column Info
	 * @return ovrw
	 */
	public String getOvrw() {
		return this.ovrw;
	}
	
	/**
	 * Column Info
	 * @return measure
	 */
	public String getMeasure() {
		return this.measure;
	}
	
	/**
	 * Column Info
	 * @return munit
	 */
	public String getMunit() {
		return this.munit;
	}
	
	/**
	 * Column Info
	 * @return tunit
	 */
	public String getTunit() {
		return this.tunit;
	}
	
	/**
	 * Column Info
	 * @return sealnbr
	 */
	public String getSealnbr() {
		return this.sealnbr;
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
	 * @return ovh
	 */
	public String getOvh() {
		return this.ovh;
	}
	
	/**
	 * Column Info
	 * @return dgInd
	 */
	public String getDgInd() {
		return this.dgInd;
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
	 * @return ovwgt
	 */
	public String getOvwgt() {
		return this.ovwgt;
	}
	
	/**
	 * Column Info
	 * @return ovr
	 */
	public String getOvr() {
		return this.ovr;
	}
	
	/**
	 * Column Info
	 * @return akInd
	 */
	public String getAkInd() {
		return this.akInd;
	}
	
	/**
	 * Column Info
	 * @return rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 * Column Info
	 * @return wunit
	 */
	public String getWunit() {
		return this.wunit;
	}
	
	/**
	 * Column Info
	 * @return rfdryInd
	 */
	public String getRfdryInd() {
		return this.rfdryInd;
	}
	
	/**
	 * Column Info
	 * @return stwgReq
	 */
	public String getStwgReq() {
		return this.stwgReq;
	}
	
	/**
	 * Column Info
	 * @return voidSlot
	 */
	public String getVoidSlot() {
		return this.voidSlot;
	}
	
	/**
	 * Column Info
	 * @return ovlw
	 */
	public String getOvlw() {
		return this.ovlw;
	}
	
	/**
	 * Column Info
	 * @return fmInd
	 */
	public String getFmInd() {
		return this.fmInd;
	}
	
	/**
	 * Column Info
	 * @return vent
	 */
	public String getVent() {
		return this.vent;
	}
	
	/**
	 * Column Info
	 * @return rfRemark
	 */
	public String getRfRemark() {
		return this.rfRemark;
	}
	
	/**
	 * Column Info
	 * @return cntrnbr
	 */
	public String getCntrnbr() {
		return this.cntrnbr;
	}
	
	/**
	 * Column Info
	 * @return pkg
	 */
	public String getPkg() {
		return this.pkg;
	}
	
	/**
	 * Column Info
	 * @return bkInd
	 */
	public String getBkInd() {
		return this.bkInd;
	}
	
	/**
	 * Column Info
	 * @return cntrwgt
	 */
	public String getCntrwgt() {
		return this.cntrwgt;
	}
	
	/**
	 * Column Info
	 * @return ovf
	 */
	public String getOvf() {
		return this.ovf;
	}
	
	/**
	 * Column Info
	 * @return cntrtype
	 */
	public String getCntrtype() {
		return this.cntrtype;
	}
	
	/**
	 * Column Info
	 * @return rfInd
	 */
	public String getRfInd() {
		return this.rfInd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return punit
	 */
	public String getPunit() {
		return this.punit;
	}
	
	/**
	 * Column Info
	 * @return temp
	 */
	public String getTemp() {
		return this.temp;
	}
	
	/**
	 * Column Info
	 * @return customsDesc
	 */
	public String getCustomsDesc() {
		return this.customsDesc;
	}
	
	/**
	 * Column Info
	 * @return cmdtcd
	 */
	public String getCmdtcd() {
		return this.cmdtcd;
	}
	

	/**
	 * Column Info
	 * @param amendCntr
	 */
	public void setAmendCntr(String amendCntr) {
		this.amendCntr = amendCntr;
	}
	
	/**
	 * Column Info
	 * @param ovrw
	 */
	public void setOvrw(String ovrw) {
		this.ovrw = ovrw;
	}
	
	/**
	 * Column Info
	 * @param measure
	 */
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	/**
	 * Column Info
	 * @param munit
	 */
	public void setMunit(String munit) {
		this.munit = munit;
	}
	
	/**
	 * Column Info
	 * @param tunit
	 */
	public void setTunit(String tunit) {
		this.tunit = tunit;
	}
	
	/**
	 * Column Info
	 * @param sealnbr
	 */
	public void setSealnbr(String sealnbr) {
		this.sealnbr = sealnbr;
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
	 * @param ovh
	 */
	public void setOvh(String ovh) {
		this.ovh = ovh;
	}
	
	/**
	 * Column Info
	 * @param dgInd
	 */
	public void setDgInd(String dgInd) {
		this.dgInd = dgInd;
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
	 * @param ovwgt
	 */
	public void setOvwgt(String ovwgt) {
		this.ovwgt = ovwgt;
	}
	
	/**
	 * Column Info
	 * @param ovr
	 */
	public void setOvr(String ovr) {
		this.ovr = ovr;
	}
	
	/**
	 * Column Info
	 * @param akInd
	 */
	public void setAkInd(String akInd) {
		this.akInd = akInd;
	}
	
	/**
	 * Column Info
	 * @param rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * Column Info
	 * @param wunit
	 */
	public void setWunit(String wunit) {
		this.wunit = wunit;
	}
	
	/**
	 * Column Info
	 * @param rfdryInd
	 */
	public void setRfdryInd(String rfdryInd) {
		this.rfdryInd = rfdryInd;
	}
	
	/**
	 * Column Info
	 * @param stwgReq
	 */
	public void setStwgReq(String stwgReq) {
		this.stwgReq = stwgReq;
	}
	
	/**
	 * Column Info
	 * @param voidSlot
	 */
	public void setVoidSlot(String voidSlot) {
		this.voidSlot = voidSlot;
	}
	
	/**
	 * Column Info
	 * @param ovlw
	 */
	public void setOvlw(String ovlw) {
		this.ovlw = ovlw;
	}
	
	/**
	 * Column Info
	 * @param fmInd
	 */
	public void setFmInd(String fmInd) {
		this.fmInd = fmInd;
	}
	
	/**
	 * Column Info
	 * @param vent
	 */
	public void setVent(String vent) {
		this.vent = vent;
	}
	
	/**
	 * Column Info
	 * @param rfRemark
	 */
	public void setRfRemark(String rfRemark) {
		this.rfRemark = rfRemark;
	}
	
	/**
	 * Column Info
	 * @param cntrnbr
	 */
	public void setCntrnbr(String cntrnbr) {
		this.cntrnbr = cntrnbr;
	}
	
	/**
	 * Column Info
	 * @param pkg
	 */
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	
	/**
	 * Column Info
	 * @param bkInd
	 */
	public void setBkInd(String bkInd) {
		this.bkInd = bkInd;
	}
	
	/**
	 * Column Info
	 * @param cntrwgt
	 */
	public void setCntrwgt(String cntrwgt) {
		this.cntrwgt = cntrwgt;
	}
	
	/**
	 * Column Info
	 * @param ovf
	 */
	public void setOvf(String ovf) {
		this.ovf = ovf;
	}
	
	/**
	 * Column Info
	 * @param cntrtype
	 */
	public void setCntrtype(String cntrtype) {
		this.cntrtype = cntrtype;
	}
	
	/**
	 * Column Info
	 * @param rfInd
	 */
	public void setRfInd(String rfInd) {
		this.rfInd = rfInd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param punit
	 */
	public void setPunit(String punit) {
		this.punit = punit;
	}
	
	/**
	 * Column Info
	 * @param temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	/**
	 * Column Info
	 * @param customsDesc
	 */
	public void setCustomsDesc(String customsDesc) {
		this.customsDesc = customsDesc;
	}
	
	/**
	 * Column Info
	 * @param cmdtcd
	 */
	public void setCmdtcd(String cmdtcd) {
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAmendCntr(JSPUtil.getParameter(request, "amend_cntr", ""));
		setOvrw(JSPUtil.getParameter(request, "ovrw", ""));
		setMeasure(JSPUtil.getParameter(request, "measure", ""));
		setMunit(JSPUtil.getParameter(request, "munit", ""));
		setTunit(JSPUtil.getParameter(request, "tunit", ""));
		setSealnbr(JSPUtil.getParameter(request, "sealnbr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOvh(JSPUtil.getParameter(request, "ovh", ""));
		setDgInd(JSPUtil.getParameter(request, "dg_ind", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOvwgt(JSPUtil.getParameter(request, "ovwgt", ""));
		setOvr(JSPUtil.getParameter(request, "ovr", ""));
		setAkInd(JSPUtil.getParameter(request, "ak_ind", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setWunit(JSPUtil.getParameter(request, "wunit", ""));
		setRfdryInd(JSPUtil.getParameter(request, "rfdry_ind", ""));
		setStwgReq(JSPUtil.getParameter(request, "stwg_req", ""));
		setVoidSlot(JSPUtil.getParameter(request, "void_slot", ""));
		setOvlw(JSPUtil.getParameter(request, "ovlw", ""));
		setFmInd(JSPUtil.getParameter(request, "fm_ind", ""));
		setVent(JSPUtil.getParameter(request, "vent", ""));
		setRfRemark(JSPUtil.getParameter(request, "rf_remark", ""));
		setCntrnbr(JSPUtil.getParameter(request, "cntrnbr", ""));
		setPkg(JSPUtil.getParameter(request, "pkg", ""));
		setBkInd(JSPUtil.getParameter(request, "bk_ind", ""));
		setCntrwgt(JSPUtil.getParameter(request, "cntrwgt", ""));
		setOvf(JSPUtil.getParameter(request, "ovf", ""));
		setCntrtype(JSPUtil.getParameter(request, "cntrtype", ""));
		setRfInd(JSPUtil.getParameter(request, "rf_ind", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPunit(JSPUtil.getParameter(request, "punit", ""));
		setTemp(JSPUtil.getParameter(request, "temp", ""));
		setCustomsDesc(JSPUtil.getParameter(request, "customs_desc", ""));
		setCmdtcd(JSPUtil.getParameter(request, "cmdtcd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HongKongSearchCntrDetailVO[]
	 */
	public HongKongSearchCntrDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HongKongSearchCntrDetailVO[]
	 */
	public HongKongSearchCntrDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HongKongSearchCntrDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amendCntr = (JSPUtil.getParameter(request, prefix	+ "amend_cntr", length));
			String[] ovrw = (JSPUtil.getParameter(request, prefix	+ "ovrw", length));
			String[] measure = (JSPUtil.getParameter(request, prefix	+ "measure", length));
			String[] munit = (JSPUtil.getParameter(request, prefix	+ "munit", length));
			String[] tunit = (JSPUtil.getParameter(request, prefix	+ "tunit", length));
			String[] sealnbr = (JSPUtil.getParameter(request, prefix	+ "sealnbr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovh = (JSPUtil.getParameter(request, prefix	+ "ovh", length));
			String[] dgInd = (JSPUtil.getParameter(request, prefix	+ "dg_ind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovwgt = (JSPUtil.getParameter(request, prefix	+ "ovwgt", length));
			String[] ovr = (JSPUtil.getParameter(request, prefix	+ "ovr", length));
			String[] akInd = (JSPUtil.getParameter(request, prefix	+ "ak_ind", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] wunit = (JSPUtil.getParameter(request, prefix	+ "wunit", length));
			String[] rfdryInd = (JSPUtil.getParameter(request, prefix	+ "rfdry_ind", length));
			String[] stwgReq = (JSPUtil.getParameter(request, prefix	+ "stwg_req", length));
			String[] voidSlot = (JSPUtil.getParameter(request, prefix	+ "void_slot", length));
			String[] ovlw = (JSPUtil.getParameter(request, prefix	+ "ovlw", length));
			String[] fmInd = (JSPUtil.getParameter(request, prefix	+ "fm_ind", length));
			String[] vent = (JSPUtil.getParameter(request, prefix	+ "vent", length));
			String[] rfRemark = (JSPUtil.getParameter(request, prefix	+ "rf_remark", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] pkg = (JSPUtil.getParameter(request, prefix	+ "pkg", length));
			String[] bkInd = (JSPUtil.getParameter(request, prefix	+ "bk_ind", length));
			String[] cntrwgt = (JSPUtil.getParameter(request, prefix	+ "cntrwgt", length));
			String[] ovf = (JSPUtil.getParameter(request, prefix	+ "ovf", length));
			String[] cntrtype = (JSPUtil.getParameter(request, prefix	+ "cntrtype", length));
			String[] rfInd = (JSPUtil.getParameter(request, prefix	+ "rf_ind", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] punit = (JSPUtil.getParameter(request, prefix	+ "punit", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] customsDesc = (JSPUtil.getParameter(request, prefix	+ "customs_desc", length));
			String[] cmdtcd = (JSPUtil.getParameter(request, prefix	+ "cmdtcd", length));
			
			for (int i = 0; i < length; i++) {
				model = new HongKongSearchCntrDetailVO();
				if (amendCntr[i] != null)
					model.setAmendCntr(amendCntr[i]);
				if (ovrw[i] != null)
					model.setOvrw(ovrw[i]);
				if (measure[i] != null)
					model.setMeasure(measure[i]);
				if (munit[i] != null)
					model.setMunit(munit[i]);
				if (tunit[i] != null)
					model.setTunit(tunit[i]);
				if (sealnbr[i] != null)
					model.setSealnbr(sealnbr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovh[i] != null)
					model.setOvh(ovh[i]);
				if (dgInd[i] != null)
					model.setDgInd(dgInd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovwgt[i] != null)
					model.setOvwgt(ovwgt[i]);
				if (ovr[i] != null)
					model.setOvr(ovr[i]);
				if (akInd[i] != null)
					model.setAkInd(akInd[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (wunit[i] != null)
					model.setWunit(wunit[i]);
				if (rfdryInd[i] != null)
					model.setRfdryInd(rfdryInd[i]);
				if (stwgReq[i] != null)
					model.setStwgReq(stwgReq[i]);
				if (voidSlot[i] != null)
					model.setVoidSlot(voidSlot[i]);
				if (ovlw[i] != null)
					model.setOvlw(ovlw[i]);
				if (fmInd[i] != null)
					model.setFmInd(fmInd[i]);
				if (vent[i] != null)
					model.setVent(vent[i]);
				if (rfRemark[i] != null)
					model.setRfRemark(rfRemark[i]);
				if (cntrnbr[i] != null)
					model.setCntrnbr(cntrnbr[i]);
				if (pkg[i] != null)
					model.setPkg(pkg[i]);
				if (bkInd[i] != null)
					model.setBkInd(bkInd[i]);
				if (cntrwgt[i] != null)
					model.setCntrwgt(cntrwgt[i]);
				if (ovf[i] != null)
					model.setOvf(ovf[i]);
				if (cntrtype[i] != null)
					model.setCntrtype(cntrtype[i]);
				if (rfInd[i] != null)
					model.setRfInd(rfInd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (punit[i] != null)
					model.setPunit(punit[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				if (customsDesc[i] != null)
					model.setCustomsDesc(customsDesc[i]);
				if (cmdtcd[i] != null)
					model.setCmdtcd(cmdtcd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHongKongSearchCntrDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HongKongSearchCntrDetailVO[]
	 */
	public HongKongSearchCntrDetailVO[] getHongKongSearchCntrDetailVOs(){
		HongKongSearchCntrDetailVO[] vos = (HongKongSearchCntrDetailVO[])models.toArray(new HongKongSearchCntrDetailVO[models.size()]);
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
		this.amendCntr = this.amendCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrw = this.ovrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measure = this.measure .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.munit = this.munit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tunit = this.tunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealnbr = this.sealnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovh = this.ovh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgInd = this.dgInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwgt = this.ovwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovr = this.ovr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akInd = this.akInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wunit = this.wunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfdryInd = this.rfdryInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgReq = this.stwgReq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidSlot = this.voidSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovlw = this.ovlw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmInd = this.fmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vent = this.vent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRemark = this.rfRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg = this.pkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkInd = this.bkInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrwgt = this.cntrwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovf = this.ovf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtype = this.cntrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfInd = this.rfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.punit = this.punit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsDesc = this.customsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtcd = this.cmdtcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
