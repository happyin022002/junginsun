/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MxCntrVO.java
*@FileTitle : MxCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.21 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MxCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MxCntrVO> models = new ArrayList<MxCntrVO>();
	
	/* Column Info */
	private String bkh = null;
	/* Column Info */
	private String cntrown = null;
	/* Column Info */
	private String measureUnit = null;
	/* Column Info */
	private String cntrtrm = null;
	/* Column Info */
	private String bkwgt = null;
	/* Column Info */
	private String measure = null;
	/* Column Info */
	private String ovrw = null;
	/* Column Info */
	private String sealnbr = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovh = null;
	/* Column Info */
	private String cntrtrw = null;
	/* Column Info */
	private String ovr = null;
	/* Column Info */
	private String ovwgt = null;
	/* Column Info */
	private String ovwgtUnit = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String voidSlot = null;
	/* Column Info */
	private String cntrgwgt = null;
	/* Column Info */
	private String ovlw = null;
	/* Column Info */
	private String socind = null;
	/* Column Info */
	private String vent = null;
	/* Column Info */
	private String rfRemark = null;
	/* Column Info */
	private String cntrnbr = null;
	/* Column Info */
	private String pkg = null;
	/* Column Info */
	private String bkwgtu = null;
	/* Column Info */
	private String cntrwgt = null;
	/* Column Info */
	private String ovf = null;
	/* Column Info */
	private String cntrtype = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkw = null;
	/* Column Info */
	private String punit = null;
	/* Column Info */
	private String temp = null;
	/* Column Info */
	private String bkl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MxCntrVO() {}

	public MxCntrVO(String ibflag, String pagerows, String cntrnbr, String punit, String pkg, String cntrwgt, String cntrgwgt, String cntrtrw, String cntrtype, String sealnbr, String temp, String vent, String measure, String measureUnit, String rdtype, String rfRemark, String ovf, String ovr, String ovh, String ovlw, String ovrw, String ovwgtUnit, String ovwgt, String voidSlot, String socind, String bkwgt, String bkwgtu, String bkw, String bkh, String bkl, String cntrown, String cntrtrm, String cntrNo) {
		this.bkh = bkh;
		this.cntrown = cntrown;
		this.measureUnit = measureUnit;
		this.cntrtrm = cntrtrm;
		this.bkwgt = bkwgt;
		this.measure = measure;
		this.ovrw = ovrw;
		this.sealnbr = sealnbr;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ovh = ovh;
		this.cntrtrw = cntrtrw;
		this.ovr = ovr;
		this.ovwgt = ovwgt;
		this.ovwgtUnit = ovwgtUnit;
		this.rdtype = rdtype;
		this.voidSlot = voidSlot;
		this.cntrgwgt = cntrgwgt;
		this.ovlw = ovlw;
		this.socind = socind;
		this.vent = vent;
		this.rfRemark = rfRemark;
		this.cntrnbr = cntrnbr;
		this.pkg = pkg;
		this.bkwgtu = bkwgtu;
		this.cntrwgt = cntrwgt;
		this.ovf = ovf;
		this.cntrtype = cntrtype;
		this.cntrNo = cntrNo;
		this.bkw = bkw;
		this.punit = punit;
		this.temp = temp;
		this.bkl = bkl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkh", getBkh());
		this.hashColumns.put("cntrown", getCntrown());
		this.hashColumns.put("measure_unit", getMeasureUnit());
		this.hashColumns.put("cntrtrm", getCntrtrm());
		this.hashColumns.put("bkwgt", getBkwgt());
		this.hashColumns.put("measure", getMeasure());
		this.hashColumns.put("ovrw", getOvrw());
		this.hashColumns.put("sealnbr", getSealnbr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovh", getOvh());
		this.hashColumns.put("cntrtrw", getCntrtrw());
		this.hashColumns.put("ovr", getOvr());
		this.hashColumns.put("ovwgt", getOvwgt());
		this.hashColumns.put("ovwgt_unit", getOvwgtUnit());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("void_slot", getVoidSlot());
		this.hashColumns.put("cntrgwgt", getCntrgwgt());
		this.hashColumns.put("ovlw", getOvlw());
		this.hashColumns.put("socind", getSocind());
		this.hashColumns.put("vent", getVent());
		this.hashColumns.put("rf_remark", getRfRemark());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("pkg", getPkg());
		this.hashColumns.put("bkwgtu", getBkwgtu());
		this.hashColumns.put("cntrwgt", getCntrwgt());
		this.hashColumns.put("ovf", getOvf());
		this.hashColumns.put("cntrtype", getCntrtype());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkw", getBkw());
		this.hashColumns.put("punit", getPunit());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("bkl", getBkl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkh", "bkh");
		this.hashFields.put("cntrown", "cntrown");
		this.hashFields.put("measure_unit", "measureUnit");
		this.hashFields.put("cntrtrm", "cntrtrm");
		this.hashFields.put("bkwgt", "bkwgt");
		this.hashFields.put("measure", "measure");
		this.hashFields.put("ovrw", "ovrw");
		this.hashFields.put("sealnbr", "sealnbr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovh", "ovh");
		this.hashFields.put("cntrtrw", "cntrtrw");
		this.hashFields.put("ovr", "ovr");
		this.hashFields.put("ovwgt", "ovwgt");
		this.hashFields.put("ovwgt_unit", "ovwgtUnit");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("void_slot", "voidSlot");
		this.hashFields.put("cntrgwgt", "cntrgwgt");
		this.hashFields.put("ovlw", "ovlw");
		this.hashFields.put("socind", "socind");
		this.hashFields.put("vent", "vent");
		this.hashFields.put("rf_remark", "rfRemark");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("pkg", "pkg");
		this.hashFields.put("bkwgtu", "bkwgtu");
		this.hashFields.put("cntrwgt", "cntrwgt");
		this.hashFields.put("ovf", "ovf");
		this.hashFields.put("cntrtype", "cntrtype");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkw", "bkw");
		this.hashFields.put("punit", "punit");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("bkl", "bkl");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkh
	 */
	public String getBkh() {
		return this.bkh;
	}
	
	/**
	 * Column Info
	 * @return cntrown
	 */
	public String getCntrown() {
		return this.cntrown;
	}
	
	/**
	 * Column Info
	 * @return measureUnit
	 */
	public String getMeasureUnit() {
		return this.measureUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrtrm
	 */
	public String getCntrtrm() {
		return this.cntrtrm;
	}
	
	/**
	 * Column Info
	 * @return bkwgt
	 */
	public String getBkwgt() {
		return this.bkwgt;
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
	 * @return ovrw
	 */
	public String getOvrw() {
		return this.ovrw;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return cntrtrw
	 */
	public String getCntrtrw() {
		return this.cntrtrw;
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
	 * @return ovwgt
	 */
	public String getOvwgt() {
		return this.ovwgt;
	}
	
	/**
	 * Column Info
	 * @return ovwgtUnit
	 */
	public String getOvwgtUnit() {
		return this.ovwgtUnit;
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
	 * @return voidSlot
	 */
	public String getVoidSlot() {
		return this.voidSlot;
	}
	
	/**
	 * Column Info
	 * @return cntrgwgt
	 */
	public String getCntrgwgt() {
		return this.cntrgwgt;
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
	 * @return socind
	 */
	public String getSocind() {
		return this.socind;
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
	 * @return bkwgtu
	 */
	public String getBkwgtu() {
		return this.bkwgtu;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return bkw
	 */
	public String getBkw() {
		return this.bkw;
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
	 * @return bkl
	 */
	public String getBkl() {
		return this.bkl;
	}
	

	/**
	 * Column Info
	 * @param bkh
	 */
	public void setBkh(String bkh) {
		this.bkh = bkh;
	}
	
	/**
	 * Column Info
	 * @param cntrown
	 */
	public void setCntrown(String cntrown) {
		this.cntrown = cntrown;
	}
	
	/**
	 * Column Info
	 * @param measureUnit
	 */
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrtrm
	 */
	public void setCntrtrm(String cntrtrm) {
		this.cntrtrm = cntrtrm;
	}
	
	/**
	 * Column Info
	 * @param bkwgt
	 */
	public void setBkwgt(String bkwgt) {
		this.bkwgt = bkwgt;
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
	 * @param ovrw
	 */
	public void setOvrw(String ovrw) {
		this.ovrw = ovrw;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param cntrtrw
	 */
	public void setCntrtrw(String cntrtrw) {
		this.cntrtrw = cntrtrw;
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
	 * @param ovwgt
	 */
	public void setOvwgt(String ovwgt) {
		this.ovwgt = ovwgt;
	}
	
	/**
	 * Column Info
	 * @param ovwgtUnit
	 */
	public void setOvwgtUnit(String ovwgtUnit) {
		this.ovwgtUnit = ovwgtUnit;
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
	 * @param voidSlot
	 */
	public void setVoidSlot(String voidSlot) {
		this.voidSlot = voidSlot;
	}
	
	/**
	 * Column Info
	 * @param cntrgwgt
	 */
	public void setCntrgwgt(String cntrgwgt) {
		this.cntrgwgt = cntrgwgt;
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
	 * @param socind
	 */
	public void setSocind(String socind) {
		this.socind = socind;
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
	 * @param bkwgtu
	 */
	public void setBkwgtu(String bkwgtu) {
		this.bkwgtu = bkwgtu;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param bkw
	 */
	public void setBkw(String bkw) {
		this.bkw = bkw;
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
	 * @param bkl
	 */
	public void setBkl(String bkl) {
		this.bkl = bkl;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkh(JSPUtil.getParameter(request, "bkh", ""));
		setCntrown(JSPUtil.getParameter(request, "cntrown", ""));
		setMeasureUnit(JSPUtil.getParameter(request, "measure_unit", ""));
		setCntrtrm(JSPUtil.getParameter(request, "cntrtrm", ""));
		setBkwgt(JSPUtil.getParameter(request, "bkwgt", ""));
		setMeasure(JSPUtil.getParameter(request, "measure", ""));
		setOvrw(JSPUtil.getParameter(request, "ovrw", ""));
		setSealnbr(JSPUtil.getParameter(request, "sealnbr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOvh(JSPUtil.getParameter(request, "ovh", ""));
		setCntrtrw(JSPUtil.getParameter(request, "cntrtrw", ""));
		setOvr(JSPUtil.getParameter(request, "ovr", ""));
		setOvwgt(JSPUtil.getParameter(request, "ovwgt", ""));
		setOvwgtUnit(JSPUtil.getParameter(request, "ovwgt_unit", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setVoidSlot(JSPUtil.getParameter(request, "void_slot", ""));
		setCntrgwgt(JSPUtil.getParameter(request, "cntrgwgt", ""));
		setOvlw(JSPUtil.getParameter(request, "ovlw", ""));
		setSocind(JSPUtil.getParameter(request, "socind", ""));
		setVent(JSPUtil.getParameter(request, "vent", ""));
		setRfRemark(JSPUtil.getParameter(request, "rf_remark", ""));
		setCntrnbr(JSPUtil.getParameter(request, "cntrnbr", ""));
		setPkg(JSPUtil.getParameter(request, "pkg", ""));
		setBkwgtu(JSPUtil.getParameter(request, "bkwgtu", ""));
		setCntrwgt(JSPUtil.getParameter(request, "cntrwgt", ""));
		setOvf(JSPUtil.getParameter(request, "ovf", ""));
		setCntrtype(JSPUtil.getParameter(request, "cntrtype", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBkw(JSPUtil.getParameter(request, "bkw", ""));
		setPunit(JSPUtil.getParameter(request, "punit", ""));
		setTemp(JSPUtil.getParameter(request, "temp", ""));
		setBkl(JSPUtil.getParameter(request, "bkl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MxCntrVO[]
	 */
	public MxCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MxCntrVO[]
	 */
	public MxCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MxCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkh = (JSPUtil.getParameter(request, prefix	+ "bkh", length));
			String[] cntrown = (JSPUtil.getParameter(request, prefix	+ "cntrown", length));
			String[] measureUnit = (JSPUtil.getParameter(request, prefix	+ "measure_unit", length));
			String[] cntrtrm = (JSPUtil.getParameter(request, prefix	+ "cntrtrm", length));
			String[] bkwgt = (JSPUtil.getParameter(request, prefix	+ "bkwgt", length));
			String[] measure = (JSPUtil.getParameter(request, prefix	+ "measure", length));
			String[] ovrw = (JSPUtil.getParameter(request, prefix	+ "ovrw", length));
			String[] sealnbr = (JSPUtil.getParameter(request, prefix	+ "sealnbr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovh = (JSPUtil.getParameter(request, prefix	+ "ovh", length));
			String[] cntrtrw = (JSPUtil.getParameter(request, prefix	+ "cntrtrw", length));
			String[] ovr = (JSPUtil.getParameter(request, prefix	+ "ovr", length));
			String[] ovwgt = (JSPUtil.getParameter(request, prefix	+ "ovwgt", length));
			String[] ovwgtUnit = (JSPUtil.getParameter(request, prefix	+ "ovwgt_unit", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] voidSlot = (JSPUtil.getParameter(request, prefix	+ "void_slot", length));
			String[] cntrgwgt = (JSPUtil.getParameter(request, prefix	+ "cntrgwgt", length));
			String[] ovlw = (JSPUtil.getParameter(request, prefix	+ "ovlw", length));
			String[] socind = (JSPUtil.getParameter(request, prefix	+ "socind", length));
			String[] vent = (JSPUtil.getParameter(request, prefix	+ "vent", length));
			String[] rfRemark = (JSPUtil.getParameter(request, prefix	+ "rf_remark", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] pkg = (JSPUtil.getParameter(request, prefix	+ "pkg", length));
			String[] bkwgtu = (JSPUtil.getParameter(request, prefix	+ "bkwgtu", length));
			String[] cntrwgt = (JSPUtil.getParameter(request, prefix	+ "cntrwgt", length));
			String[] ovf = (JSPUtil.getParameter(request, prefix	+ "ovf", length));
			String[] cntrtype = (JSPUtil.getParameter(request, prefix	+ "cntrtype", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkw = (JSPUtil.getParameter(request, prefix	+ "bkw", length));
			String[] punit = (JSPUtil.getParameter(request, prefix	+ "punit", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] bkl = (JSPUtil.getParameter(request, prefix	+ "bkl", length));
			
			for (int i = 0; i < length; i++) {
				model = new MxCntrVO();
				if (bkh[i] != null)
					model.setBkh(bkh[i]);
				if (cntrown[i] != null)
					model.setCntrown(cntrown[i]);
				if (measureUnit[i] != null)
					model.setMeasureUnit(measureUnit[i]);
				if (cntrtrm[i] != null)
					model.setCntrtrm(cntrtrm[i]);
				if (bkwgt[i] != null)
					model.setBkwgt(bkwgt[i]);
				if (measure[i] != null)
					model.setMeasure(measure[i]);
				if (ovrw[i] != null)
					model.setOvrw(ovrw[i]);
				if (sealnbr[i] != null)
					model.setSealnbr(sealnbr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovh[i] != null)
					model.setOvh(ovh[i]);
				if (cntrtrw[i] != null)
					model.setCntrtrw(cntrtrw[i]);
				if (ovr[i] != null)
					model.setOvr(ovr[i]);
				if (ovwgt[i] != null)
					model.setOvwgt(ovwgt[i]);
				if (ovwgtUnit[i] != null)
					model.setOvwgtUnit(ovwgtUnit[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (voidSlot[i] != null)
					model.setVoidSlot(voidSlot[i]);
				if (cntrgwgt[i] != null)
					model.setCntrgwgt(cntrgwgt[i]);
				if (ovlw[i] != null)
					model.setOvlw(ovlw[i]);
				if (socind[i] != null)
					model.setSocind(socind[i]);
				if (vent[i] != null)
					model.setVent(vent[i]);
				if (rfRemark[i] != null)
					model.setRfRemark(rfRemark[i]);
				if (cntrnbr[i] != null)
					model.setCntrnbr(cntrnbr[i]);
				if (pkg[i] != null)
					model.setPkg(pkg[i]);
				if (bkwgtu[i] != null)
					model.setBkwgtu(bkwgtu[i]);
				if (cntrwgt[i] != null)
					model.setCntrwgt(cntrwgt[i]);
				if (ovf[i] != null)
					model.setOvf(ovf[i]);
				if (cntrtype[i] != null)
					model.setCntrtype(cntrtype[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkw[i] != null)
					model.setBkw(bkw[i]);
				if (punit[i] != null)
					model.setPunit(punit[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				if (bkl[i] != null)
					model.setBkl(bkl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMxCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MxCntrVO[]
	 */
	public MxCntrVO[] getMxCntrVOs(){
		MxCntrVO[] vos = (MxCntrVO[])models.toArray(new MxCntrVO[models.size()]);
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
		this.bkh = this.bkh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrown = this.cntrown .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measureUnit = this.measureUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtrm = this.cntrtrm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkwgt = this.bkwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measure = this.measure .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrw = this.ovrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealnbr = this.sealnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovh = this.ovh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtrw = this.cntrtrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovr = this.ovr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwgt = this.ovwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwgtUnit = this.ovwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidSlot = this.voidSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrgwgt = this.cntrgwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovlw = this.ovlw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socind = this.socind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vent = this.vent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRemark = this.rfRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg = this.pkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkwgtu = this.bkwgtu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrwgt = this.cntrwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovf = this.ovf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtype = this.cntrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkw = this.bkw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.punit = this.punit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkl = this.bkl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
