/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExCntrTransmitCntrDgInfoVO.java
*@FileTitle : ExCntrTransmitCntrDgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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

public class ExCntrTransmitCntrDgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExCntrTransmitCntrDgInfoVO> models = new ArrayList<ExCntrTransmitCntrDgInfoVO>();
	
	/* Column Info */
	private String phone = null;
	/* Column Info */
	private String nwgtUnit = null;
	/* Column Info */
	private String labelCd = null;
	/* Column Info */
	private String mea = null;
	/* Column Info */
	private String gwgt = null;
	/* Column Info */
	private String marPoll = null;
	/* Column Info */
	private String flshUnit = null;
	/* Column Info */
	private String unnbr = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gwgtUnit = null;
	/* Column Info */
	private String page = null;
	/* Column Info */
	private String meaUnit = null;
	/* Column Info */
	private String mfag2 = null;
	/* Column Info */
	private String mfag1 = null;
	/* Column Info */
	private String dgRemark = null;
	/* Column Info */
	private String hazCont = null;
	/* Column Info */
	private String pkggrp = null;
	/* Column Info */
	private String nwgt = null;
	/* Column Info */
	private String emsno = null;
	/* Column Info */
	private String flshTemp = null;
	/* Column Info */
	private String dclass = null;
	/* Column Info */
	private String dPkgunit = null;
	/* Column Info */
	private String label = null;
	/* Column Info */
	private String psacls = null;
	/* Column Info */
	private String dgDesc = null;
	/* Column Info */
	private String labelDesc = null;
	/* Column Info */
	private String dPkg = null;
	/* Column Info */
	private String stwg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExCntrTransmitCntrDgInfoVO() {}

	public ExCntrTransmitCntrDgInfoVO(String ibflag, String pagerows, String unnbr, String dclass, String dgDesc, String phone, String page, String flshTemp, String flshUnit, String dgRemark, String emsno, String psacls, String pkggrp, String mfag1, String mfag2, String marPoll, String labelCd, String labelDesc, String dPkg, String dPkgunit, String nwgt, String nwgtUnit, String gwgt, String gwgtUnit, String mea, String meaUnit, String hazCont, String stwg, String label) {
		this.phone = phone;
		this.nwgtUnit = nwgtUnit;
		this.labelCd = labelCd;
		this.mea = mea;
		this.gwgt = gwgt;
		this.marPoll = marPoll;
		this.flshUnit = flshUnit;
		this.unnbr = unnbr;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.gwgtUnit = gwgtUnit;
		this.page = page;
		this.meaUnit = meaUnit;
		this.mfag2 = mfag2;
		this.mfag1 = mfag1;
		this.dgRemark = dgRemark;
		this.hazCont = hazCont;
		this.pkggrp = pkggrp;
		this.nwgt = nwgt;
		this.emsno = emsno;
		this.flshTemp = flshTemp;
		this.dclass = dclass;
		this.dPkgunit = dPkgunit;
		this.label = label;
		this.psacls = psacls;
		this.dgDesc = dgDesc;
		this.labelDesc = labelDesc;
		this.dPkg = dPkg;
		this.stwg = stwg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phone", getPhone());
		this.hashColumns.put("nwgt_unit", getNwgtUnit());
		this.hashColumns.put("label_cd", getLabelCd());
		this.hashColumns.put("mea", getMea());
		this.hashColumns.put("gwgt", getGwgt());
		this.hashColumns.put("mar_poll", getMarPoll());
		this.hashColumns.put("flsh_unit", getFlshUnit());
		this.hashColumns.put("unnbr", getUnnbr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gwgt_unit", getGwgtUnit());
		this.hashColumns.put("page", getPage());
		this.hashColumns.put("mea_unit", getMeaUnit());
		this.hashColumns.put("mfag2", getMfag2());
		this.hashColumns.put("mfag1", getMfag1());
		this.hashColumns.put("dg_remark", getDgRemark());
		this.hashColumns.put("haz_cont", getHazCont());
		this.hashColumns.put("pkggrp", getPkggrp());
		this.hashColumns.put("nwgt", getNwgt());
		this.hashColumns.put("emsno", getEmsno());
		this.hashColumns.put("flsh_temp", getFlshTemp());
		this.hashColumns.put("dclass", getDclass());
		this.hashColumns.put("d_pkgunit", getDPkgunit());
		this.hashColumns.put("label", getLabel());
		this.hashColumns.put("psacls", getPsacls());
		this.hashColumns.put("dg_desc", getDgDesc());
		this.hashColumns.put("label_desc", getLabelDesc());
		this.hashColumns.put("d_pkg", getDPkg());
		this.hashColumns.put("stwg", getStwg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phone", "phone");
		this.hashFields.put("nwgt_unit", "nwgtUnit");
		this.hashFields.put("label_cd", "labelCd");
		this.hashFields.put("mea", "mea");
		this.hashFields.put("gwgt", "gwgt");
		this.hashFields.put("mar_poll", "marPoll");
		this.hashFields.put("flsh_unit", "flshUnit");
		this.hashFields.put("unnbr", "unnbr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gwgt_unit", "gwgtUnit");
		this.hashFields.put("page", "page");
		this.hashFields.put("mea_unit", "meaUnit");
		this.hashFields.put("mfag2", "mfag2");
		this.hashFields.put("mfag1", "mfag1");
		this.hashFields.put("dg_remark", "dgRemark");
		this.hashFields.put("haz_cont", "hazCont");
		this.hashFields.put("pkggrp", "pkggrp");
		this.hashFields.put("nwgt", "nwgt");
		this.hashFields.put("emsno", "emsno");
		this.hashFields.put("flsh_temp", "flshTemp");
		this.hashFields.put("dclass", "dclass");
		this.hashFields.put("d_pkgunit", "dPkgunit");
		this.hashFields.put("label", "label");
		this.hashFields.put("psacls", "psacls");
		this.hashFields.put("dg_desc", "dgDesc");
		this.hashFields.put("label_desc", "labelDesc");
		this.hashFields.put("d_pkg", "dPkg");
		this.hashFields.put("stwg", "stwg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return phone
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Column Info
	 * @return nwgtUnit
	 */
	public String getNwgtUnit() {
		return this.nwgtUnit;
	}
	
	/**
	 * Column Info
	 * @return labelCd
	 */
	public String getLabelCd() {
		return this.labelCd;
	}
	
	/**
	 * Column Info
	 * @return mea
	 */
	public String getMea() {
		return this.mea;
	}
	
	/**
	 * Column Info
	 * @return gwgt
	 */
	public String getGwgt() {
		return this.gwgt;
	}
	
	/**
	 * Column Info
	 * @return marPoll
	 */
	public String getMarPoll() {
		return this.marPoll;
	}
	
	/**
	 * Column Info
	 * @return flshUnit
	 */
	public String getFlshUnit() {
		return this.flshUnit;
	}
	
	/**
	 * Column Info
	 * @return unnbr
	 */
	public String getUnnbr() {
		return this.unnbr;
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
	 * @return gwgtUnit
	 */
	public String getGwgtUnit() {
		return this.gwgtUnit;
	}
	
	/**
	 * Column Info
	 * @return page
	 */
	public String getPage() {
		return this.page;
	}
	
	/**
	 * Column Info
	 * @return meaUnit
	 */
	public String getMeaUnit() {
		return this.meaUnit;
	}
	
	/**
	 * Column Info
	 * @return mfag2
	 */
	public String getMfag2() {
		return this.mfag2;
	}
	
	/**
	 * Column Info
	 * @return mfag1
	 */
	public String getMfag1() {
		return this.mfag1;
	}
	
	/**
	 * Column Info
	 * @return dgRemark
	 */
	public String getDgRemark() {
		return this.dgRemark;
	}
	
	/**
	 * Column Info
	 * @return hazCont
	 */
	public String getHazCont() {
		return this.hazCont;
	}
	
	/**
	 * Column Info
	 * @return pkggrp
	 */
	public String getPkggrp() {
		return this.pkggrp;
	}
	
	/**
	 * Column Info
	 * @return nwgt
	 */
	public String getNwgt() {
		return this.nwgt;
	}
	
	/**
	 * Column Info
	 * @return emsno
	 */
	public String getEmsno() {
		return this.emsno;
	}
	
	/**
	 * Column Info
	 * @return flshTemp
	 */
	public String getFlshTemp() {
		return this.flshTemp;
	}
	
	/**
	 * Column Info
	 * @return dclass
	 */
	public String getDclass() {
		return this.dclass;
	}
	
	/**
	 * Column Info
	 * @return dPkgunit
	 */
	public String getDPkgunit() {
		return this.dPkgunit;
	}
	
	/**
	 * Column Info
	 * @return label
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Column Info
	 * @return psacls
	 */
	public String getPsacls() {
		return this.psacls;
	}
	
	/**
	 * Column Info
	 * @return dgDesc
	 */
	public String getDgDesc() {
		return this.dgDesc;
	}
	
	/**
	 * Column Info
	 * @return labelDesc
	 */
	public String getLabelDesc() {
		return this.labelDesc;
	}
	
	/**
	 * Column Info
	 * @return dPkg
	 */
	public String getDPkg() {
		return this.dPkg;
	}
	
	/**
	 * Column Info
	 * @return stwg
	 */
	public String getStwg() {
		return this.stwg;
	}
	

	/**
	 * Column Info
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Column Info
	 * @param nwgtUnit
	 */
	public void setNwgtUnit(String nwgtUnit) {
		this.nwgtUnit = nwgtUnit;
	}
	
	/**
	 * Column Info
	 * @param labelCd
	 */
	public void setLabelCd(String labelCd) {
		this.labelCd = labelCd;
	}
	
	/**
	 * Column Info
	 * @param mea
	 */
	public void setMea(String mea) {
		this.mea = mea;
	}
	
	/**
	 * Column Info
	 * @param gwgt
	 */
	public void setGwgt(String gwgt) {
		this.gwgt = gwgt;
	}
	
	/**
	 * Column Info
	 * @param marPoll
	 */
	public void setMarPoll(String marPoll) {
		this.marPoll = marPoll;
	}
	
	/**
	 * Column Info
	 * @param flshUnit
	 */
	public void setFlshUnit(String flshUnit) {
		this.flshUnit = flshUnit;
	}
	
	/**
	 * Column Info
	 * @param unnbr
	 */
	public void setUnnbr(String unnbr) {
		this.unnbr = unnbr;
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
	 * @param gwgtUnit
	 */
	public void setGwgtUnit(String gwgtUnit) {
		this.gwgtUnit = gwgtUnit;
	}
	
	/**
	 * Column Info
	 * @param page
	 */
	public void setPage(String page) {
		this.page = page;
	}
	
	/**
	 * Column Info
	 * @param meaUnit
	 */
	public void setMeaUnit(String meaUnit) {
		this.meaUnit = meaUnit;
	}
	
	/**
	 * Column Info
	 * @param mfag2
	 */
	public void setMfag2(String mfag2) {
		this.mfag2 = mfag2;
	}
	
	/**
	 * Column Info
	 * @param mfag1
	 */
	public void setMfag1(String mfag1) {
		this.mfag1 = mfag1;
	}
	
	/**
	 * Column Info
	 * @param dgRemark
	 */
	public void setDgRemark(String dgRemark) {
		this.dgRemark = dgRemark;
	}
	
	/**
	 * Column Info
	 * @param hazCont
	 */
	public void setHazCont(String hazCont) {
		this.hazCont = hazCont;
	}
	
	/**
	 * Column Info
	 * @param pkggrp
	 */
	public void setPkggrp(String pkggrp) {
		this.pkggrp = pkggrp;
	}
	
	/**
	 * Column Info
	 * @param nwgt
	 */
	public void setNwgt(String nwgt) {
		this.nwgt = nwgt;
	}
	
	/**
	 * Column Info
	 * @param emsno
	 */
	public void setEmsno(String emsno) {
		this.emsno = emsno;
	}
	
	/**
	 * Column Info
	 * @param flshTemp
	 */
	public void setFlshTemp(String flshTemp) {
		this.flshTemp = flshTemp;
	}
	
	/**
	 * Column Info
	 * @param dclass
	 */
	public void setDclass(String dclass) {
		this.dclass = dclass;
	}
	
	/**
	 * Column Info
	 * @param dPkgunit
	 */
	public void setDPkgunit(String dPkgunit) {
		this.dPkgunit = dPkgunit;
	}
	
	/**
	 * Column Info
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Column Info
	 * @param psacls
	 */
	public void setPsacls(String psacls) {
		this.psacls = psacls;
	}
	
	/**
	 * Column Info
	 * @param dgDesc
	 */
	public void setDgDesc(String dgDesc) {
		this.dgDesc = dgDesc;
	}
	
	/**
	 * Column Info
	 * @param labelDesc
	 */
	public void setLabelDesc(String labelDesc) {
		this.labelDesc = labelDesc;
	}
	
	/**
	 * Column Info
	 * @param dPkg
	 */
	public void setDPkg(String dPkg) {
		this.dPkg = dPkg;
	}
	
	/**
	 * Column Info
	 * @param stwg
	 */
	public void setStwg(String stwg) {
		this.stwg = stwg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPhone(JSPUtil.getParameter(request, "phone", ""));
		setNwgtUnit(JSPUtil.getParameter(request, "nwgt_unit", ""));
		setLabelCd(JSPUtil.getParameter(request, "label_cd", ""));
		setMea(JSPUtil.getParameter(request, "mea", ""));
		setGwgt(JSPUtil.getParameter(request, "gwgt", ""));
		setMarPoll(JSPUtil.getParameter(request, "mar_poll", ""));
		setFlshUnit(JSPUtil.getParameter(request, "flsh_unit", ""));
		setUnnbr(JSPUtil.getParameter(request, "unnbr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGwgtUnit(JSPUtil.getParameter(request, "gwgt_unit", ""));
		setPage(JSPUtil.getParameter(request, "page", ""));
		setMeaUnit(JSPUtil.getParameter(request, "mea_unit", ""));
		setMfag2(JSPUtil.getParameter(request, "mfag2", ""));
		setMfag1(JSPUtil.getParameter(request, "mfag1", ""));
		setDgRemark(JSPUtil.getParameter(request, "dg_remark", ""));
		setHazCont(JSPUtil.getParameter(request, "haz_cont", ""));
		setPkggrp(JSPUtil.getParameter(request, "pkggrp", ""));
		setNwgt(JSPUtil.getParameter(request, "nwgt", ""));
		setEmsno(JSPUtil.getParameter(request, "emsno", ""));
		setFlshTemp(JSPUtil.getParameter(request, "flsh_temp", ""));
		setDclass(JSPUtil.getParameter(request, "dclass", ""));
		setDPkgunit(JSPUtil.getParameter(request, "d_pkgunit", ""));
		setLabel(JSPUtil.getParameter(request, "label", ""));
		setPsacls(JSPUtil.getParameter(request, "psacls", ""));
		setDgDesc(JSPUtil.getParameter(request, "dg_desc", ""));
		setLabelDesc(JSPUtil.getParameter(request, "label_desc", ""));
		setDPkg(JSPUtil.getParameter(request, "d_pkg", ""));
		setStwg(JSPUtil.getParameter(request, "stwg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExCntrTransmitCntrDgInfoVO[]
	 */
	public ExCntrTransmitCntrDgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExCntrTransmitCntrDgInfoVO[]
	 */
	public ExCntrTransmitCntrDgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExCntrTransmitCntrDgInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] phone = (JSPUtil.getParameter(request, prefix	+ "phone", length));
			String[] nwgtUnit = (JSPUtil.getParameter(request, prefix	+ "nwgt_unit", length));
			String[] labelCd = (JSPUtil.getParameter(request, prefix	+ "label_cd", length));
			String[] mea = (JSPUtil.getParameter(request, prefix	+ "mea", length));
			String[] gwgt = (JSPUtil.getParameter(request, prefix	+ "gwgt", length));
			String[] marPoll = (JSPUtil.getParameter(request, prefix	+ "mar_poll", length));
			String[] flshUnit = (JSPUtil.getParameter(request, prefix	+ "flsh_unit", length));
			String[] unnbr = (JSPUtil.getParameter(request, prefix	+ "unnbr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gwgtUnit = (JSPUtil.getParameter(request, prefix	+ "gwgt_unit", length));
			String[] page = (JSPUtil.getParameter(request, prefix	+ "page", length));
			String[] meaUnit = (JSPUtil.getParameter(request, prefix	+ "mea_unit", length));
			String[] mfag2 = (JSPUtil.getParameter(request, prefix	+ "mfag2", length));
			String[] mfag1 = (JSPUtil.getParameter(request, prefix	+ "mfag1", length));
			String[] dgRemark = (JSPUtil.getParameter(request, prefix	+ "dg_remark", length));
			String[] hazCont = (JSPUtil.getParameter(request, prefix	+ "haz_cont", length));
			String[] pkggrp = (JSPUtil.getParameter(request, prefix	+ "pkggrp", length));
			String[] nwgt = (JSPUtil.getParameter(request, prefix	+ "nwgt", length));
			String[] emsno = (JSPUtil.getParameter(request, prefix	+ "emsno", length));
			String[] flshTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_temp", length));
			String[] dclass = (JSPUtil.getParameter(request, prefix	+ "dclass", length));
			String[] dPkgunit = (JSPUtil.getParameter(request, prefix	+ "d_pkgunit", length));
			String[] label = (JSPUtil.getParameter(request, prefix	+ "label", length));
			String[] psacls = (JSPUtil.getParameter(request, prefix	+ "psacls", length));
			String[] dgDesc = (JSPUtil.getParameter(request, prefix	+ "dg_desc", length));
			String[] labelDesc = (JSPUtil.getParameter(request, prefix	+ "label_desc", length));
			String[] dPkg = (JSPUtil.getParameter(request, prefix	+ "d_pkg", length));
			String[] stwg = (JSPUtil.getParameter(request, prefix	+ "stwg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExCntrTransmitCntrDgInfoVO();
				if (phone[i] != null)
					model.setPhone(phone[i]);
				if (nwgtUnit[i] != null)
					model.setNwgtUnit(nwgtUnit[i]);
				if (labelCd[i] != null)
					model.setLabelCd(labelCd[i]);
				if (mea[i] != null)
					model.setMea(mea[i]);
				if (gwgt[i] != null)
					model.setGwgt(gwgt[i]);
				if (marPoll[i] != null)
					model.setMarPoll(marPoll[i]);
				if (flshUnit[i] != null)
					model.setFlshUnit(flshUnit[i]);
				if (unnbr[i] != null)
					model.setUnnbr(unnbr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gwgtUnit[i] != null)
					model.setGwgtUnit(gwgtUnit[i]);
				if (page[i] != null)
					model.setPage(page[i]);
				if (meaUnit[i] != null)
					model.setMeaUnit(meaUnit[i]);
				if (mfag2[i] != null)
					model.setMfag2(mfag2[i]);
				if (mfag1[i] != null)
					model.setMfag1(mfag1[i]);
				if (dgRemark[i] != null)
					model.setDgRemark(dgRemark[i]);
				if (hazCont[i] != null)
					model.setHazCont(hazCont[i]);
				if (pkggrp[i] != null)
					model.setPkggrp(pkggrp[i]);
				if (nwgt[i] != null)
					model.setNwgt(nwgt[i]);
				if (emsno[i] != null)
					model.setEmsno(emsno[i]);
				if (flshTemp[i] != null)
					model.setFlshTemp(flshTemp[i]);
				if (dclass[i] != null)
					model.setDclass(dclass[i]);
				if (dPkgunit[i] != null)
					model.setDPkgunit(dPkgunit[i]);
				if (label[i] != null)
					model.setLabel(label[i]);
				if (psacls[i] != null)
					model.setPsacls(psacls[i]);
				if (dgDesc[i] != null)
					model.setDgDesc(dgDesc[i]);
				if (labelDesc[i] != null)
					model.setLabelDesc(labelDesc[i]);
				if (dPkg[i] != null)
					model.setDPkg(dPkg[i]);
				if (stwg[i] != null)
					model.setStwg(stwg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExCntrTransmitCntrDgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExCntrTransmitCntrDgInfoVO[]
	 */
	public ExCntrTransmitCntrDgInfoVO[] getExCntrTransmitCntrDgInfoVOs(){
		ExCntrTransmitCntrDgInfoVO[] vos = (ExCntrTransmitCntrDgInfoVO[])models.toArray(new ExCntrTransmitCntrDgInfoVO[models.size()]);
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
		this.phone = this.phone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nwgtUnit = this.nwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.labelCd = this.labelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mea = this.mea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwgt = this.gwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marPoll = this.marPoll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshUnit = this.flshUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unnbr = this.unnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwgtUnit = this.gwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.page = this.page .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meaUnit = this.meaUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfag2 = this.mfag2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfag1 = this.mfag1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRemark = this.dgRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazCont = this.hazCont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkggrp = this.pkggrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nwgt = this.nwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsno = this.emsno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshTemp = this.flshTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dclass = this.dclass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkgunit = this.dPkgunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.label = this.label .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psacls = this.psacls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgDesc = this.dgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.labelDesc = this.labelDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkg = this.dPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg = this.stwg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
