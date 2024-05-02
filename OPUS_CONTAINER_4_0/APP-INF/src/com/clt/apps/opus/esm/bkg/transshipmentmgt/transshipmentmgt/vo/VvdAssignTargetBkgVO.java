/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VvdAssignTargetBkgVO.java
*@FileTitle : VvdAssignTargetBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.08 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VvdAssignTargetBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdAssignTargetBkgVO> models = new ArrayList<VvdAssignTargetBkgVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String st = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String nextPortYard = null;
	/* Column Info */
	private String nextPort = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String formerVvd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String opCd = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String tmnl = null;
	/* Column Info */
	private String nextTmnl = null;
	private String cntrQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VvdAssignTargetBkgVO() {}

	public VvdAssignTargetBkgVO(String ibflag, String pagerows, String blNo, String bkgNo, String cntrNo, String cntrTpszCd, String cntrWgt, String wgtUtCd, String polCd, String delCd, String nextPort, String nextPortYard, String formerVvd, String etb, String tmnl, String nextVvd, String opCd, String etd, String dcgoFlg, String rcFlg, String awkCgoFlg, String st, String rmk, String vslPrePstCd, String vslSeq, String nextTmnl, String cntrQty) {
		this.etb = etb;
		this.etd = etd;
		this.vslSeq = vslSeq;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.wgtUtCd = wgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.st = st;
		this.vslPrePstCd = vslPrePstCd;
		this.nextPortYard = nextPortYard;
		this.nextPort = nextPort;
		this.rmk = rmk;
		this.cntrWgt = cntrWgt;
		this.formerVvd = formerVvd;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.opCd = opCd;
		this.nextVvd = nextVvd;
		this.rcFlg = rcFlg;
		this.tmnl = tmnl;
		this.nextTmnl = nextTmnl;
		this.cntrQty = cntrQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("st", getSt());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("next_port_yard", getNextPortYard());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("former_vvd", getFormerVvd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("tmnl", getTmnl());
		this.hashColumns.put("next_tmnl", getNextTmnl());
		this.hashColumns.put("cntr_qty", getCntrQty());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("st", "st");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("next_port_yard", "nextPortYard");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("former_vvd", "formerVvd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("tmnl", "tmnl");
		this.hashFields.put("next_tmnl", "nextTmnl");
		this.hashFields.put("cntr_qty", "cntrQty");
		return this.hashFields;
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
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return st
	 */
	public String getSt() {
		return this.st;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return nextPortYard
	 */
	public String getNextPortYard() {
		return this.nextPortYard;
	}
	
	/**
	 * Column Info
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
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
	 * @return formerVvd
	 */
	public String getFormerVvd() {
		return this.formerVvd;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return opCd
	 */
	public String getOpCd() {
		return this.opCd;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
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
	 * @return tmnl
	 */
	public String getTmnl() {
		return this.tmnl;
	}
	
	/**
	 * Column Info
	 * @return nextTmnl
	 */
	public String getNextTmnl() {
		return this.nextTmnl;
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
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param st
	 */
	public void setSt(String st) {
		this.st = st;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param nextPortYard
	 */
	public void setNextPortYard(String nextPortYard) {
		this.nextPortYard = nextPortYard;
	}
	
	/**
	 * Column Info
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
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
	 * @param formerVvd
	 */
	public void setFormerVvd(String formerVvd) {
		this.formerVvd = formerVvd;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param opCd
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
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
	 * @param tmnl
	 */
	public void setTmnl(String tmnl) {
		this.tmnl = tmnl;
	}
	
	/**
	 * Column Info
	 * @param nextTmnl
	 */
	public void setNextTmnl(String nextTmnl) {
		this.nextTmnl = nextTmnl;
	}
	
	/**
	 * @return the cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}

	/**
	 * @param cntrQty the cntrQty to set
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEtb(JSPUtil.getParameter(request, "etb", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setVslSeq(JSPUtil.getParameter(request, "vsl_seq", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setSt(JSPUtil.getParameter(request, "st", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
		setNextPortYard(JSPUtil.getParameter(request, "next_port_yard", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
		setRmk(JSPUtil.getParameter(request, "rmk", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setFormerVvd(JSPUtil.getParameter(request, "former_vvd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOpCd(JSPUtil.getParameter(request, "op_cd", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setTmnl(JSPUtil.getParameter(request, "tmnl", ""));
		setNextTmnl(JSPUtil.getParameter(request,"next_tmnl"));
		setCntrQty(JSPUtil.getParameter(request,"cntr_qty"));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdAssignTargetBkgVO[]
	 */
	public VvdAssignTargetBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdAssignTargetBkgVO[]
	 */
	public VvdAssignTargetBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdAssignTargetBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] st = (JSPUtil.getParameter(request, prefix	+ "st", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] nextPortYard = (JSPUtil.getParameter(request, prefix	+ "next_port_yard", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] formerVvd = (JSPUtil.getParameter(request, prefix	+ "former_vvd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] tmnl = (JSPUtil.getParameter(request, prefix	+ "tmnl", length));
			String[] nextTmnl = (JSPUtil.getParameter(request, prefix	+ "next_tmnl", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new VvdAssignTargetBkgVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (st[i] != null)
					model.setSt(st[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (nextPortYard[i] != null)
					model.setNextPortYard(nextPortYard[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (formerVvd[i] != null)
					model.setFormerVvd(formerVvd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (opCd[i] != null)
					model.setOpCd(opCd[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (tmnl[i] != null)
					model.setTmnl(tmnl[i]);
				if (nextTmnl[i] != null)
					model.setNextTmnl(nextTmnl[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdAssignTargetBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdAssignTargetBkgVO[]
	 */
	public VvdAssignTargetBkgVO[] getVvdAssignTargetBkgVOs(){
		VvdAssignTargetBkgVO[] vos = (VvdAssignTargetBkgVO[])models.toArray(new VvdAssignTargetBkgVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st = this.st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPortYard = this.nextPortYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formerVvd = this.formerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnl = this.tmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextTmnl = this.nextTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
