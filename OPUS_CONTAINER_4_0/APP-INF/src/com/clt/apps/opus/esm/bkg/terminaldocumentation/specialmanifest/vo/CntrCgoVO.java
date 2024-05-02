/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CntrCgoVO.java
*@FileTitle : CntrCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.26
*@LastModifier :
*@LastVersion : 1.0
* 2011.05.26
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CntrCgoVO> models = new ArrayList<CntrCgoVO>();

	/* Column Info */
	private String flash = null;
	/* Column Info */
	private String outpkgDesc = null;
	/* Column Info */
	private String espn = null;
	/* Column Info */
	private String imoLimit = null;
	/* Column Info */
	private String inpkgQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String propShipNm = null;
	/* Column Info */
	private String flashUnit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imoComp = null;
	/* Column Info */
	private String inpkgTp = null;
	/* Column Info */
	private String itemNbr = null;
	/* Column Info */
	private String netwgtUnit = null;
	/* Column Info */
	private String netwgt = null;
	/* Column Info */
	private String unNbrSeq = null;
	/* Column Info */
	private String grosswgt = null;
	/* Column Info */
	private String hcdg = null;
	/* Column Info */
	private String imoClass = null;
	/* Column Info */
	private String unNbr = null;
	/* Column Info */
	private String mfag = null;
	/* Column Info */
	private String hazCont = null;
	/* Column Info */
	private String nwExplosive = null;
	/* Column Info */
	private String cntrnbr = null;
	/* Column Info */
	private String emsNbr = null;
	/* Column Info */
	private String outpkgTp = null;
	/* Column Info */
	private String subClass4 = null;
	/* Column Info */
	private String subClass3 = null;
	/* Column Info */
	private String pkgGroup = null;
	/* Column Info */
	private String imoPage = null;
	/* Column Info */
	private String subClass2 = null;
	/* Column Info */
	private String subClass1 = null;
	/* Column Info */
	private String pollutant = null;
	/* Column Info */
	private String pkgDesc = null;
	/* Column Info */
	private String nwExpUnit = null;
	/* Column Info */
	private String grosswgtUnit = null;
	/* Column Info */
	private String pkgQty = null;
	/* Column Info */
	private String outpkgQty = null;
	/* Column Info */
	private String pkgTp = null;
	/* Column Info */
	private String inpkgDesc = null;
	/* Column Info */
	private String stowpos = null;
	/* Column Info */
	private String diffRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CntrCgoVO() {}

	public CntrCgoVO(String ibflag, String pagerows, String outpkgDesc, String flash, String espn, String imoLimit, String inpkgQty, String propShipNm, String flashUnit, String inpkgTp, String imoComp, String itemNbr, String netwgtUnit, String netwgt, String unNbrSeq, String grosswgt, String hcdg, String imoClass, String unNbr, String mfag, String hazCont, String nwExplosive, String cntrnbr, String emsNbr, String outpkgTp, String imoPage, String pkgGroup, String pollutant, String pkgDesc, String nwExpUnit, String grosswgtUnit, String pkgQty, String stowpos, String inpkgDesc, String pkgTp, String outpkgQty, String subClass1, String subClass2, String subClass3, String subClass4, String diffRmk) {
		this.flash = flash;
		this.outpkgDesc = outpkgDesc;
		this.espn = espn;
		this.imoLimit = imoLimit;
		this.inpkgQty = inpkgQty;
		this.pagerows = pagerows;
		this.propShipNm = propShipNm;
		this.flashUnit = flashUnit;
		this.ibflag = ibflag;
		this.imoComp = imoComp;
		this.inpkgTp = inpkgTp;
		this.itemNbr = itemNbr;
		this.netwgtUnit = netwgtUnit;
		this.netwgt = netwgt;
		this.unNbrSeq = unNbrSeq;
		this.grosswgt = grosswgt;
		this.hcdg = hcdg;
		this.imoClass = imoClass;
		this.unNbr = unNbr;
		this.mfag = mfag;
		this.hazCont = hazCont;
		this.nwExplosive = nwExplosive;
		this.cntrnbr = cntrnbr;
		this.emsNbr = emsNbr;
		this.outpkgTp = outpkgTp;
		this.subClass4 = subClass4;
		this.subClass3 = subClass3;
		this.pkgGroup = pkgGroup;
		this.imoPage = imoPage;
		this.subClass2 = subClass2;
		this.subClass1 = subClass1;
		this.pollutant = pollutant;
		this.pkgDesc = pkgDesc;
		this.nwExpUnit = nwExpUnit;
		this.grosswgtUnit = grosswgtUnit;
		this.pkgQty = pkgQty;
		this.outpkgQty = outpkgQty;
		this.pkgTp = pkgTp;
		this.inpkgDesc = inpkgDesc;
		this.stowpos = stowpos;
		this.diffRmk = diffRmk;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flash", getFlash());
		this.hashColumns.put("outpkg_desc", getOutpkgDesc());
		this.hashColumns.put("espn", getEspn());
		this.hashColumns.put("imo_limit", getImoLimit());
		this.hashColumns.put("inpkg_qty", getInpkgQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prop_ship_nm", getPropShipNm());
		this.hashColumns.put("flash_unit", getFlashUnit());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imo_comp", getImoComp());
		this.hashColumns.put("inpkg_tp", getInpkgTp());
		this.hashColumns.put("item_nbr", getItemNbr());
		this.hashColumns.put("netwgt_unit", getNetwgtUnit());
		this.hashColumns.put("netwgt", getNetwgt());
		this.hashColumns.put("un_nbr_seq", getUnNbrSeq());
		this.hashColumns.put("grosswgt", getGrosswgt());
		this.hashColumns.put("hcdg", getHcdg());
		this.hashColumns.put("imo_class", getImoClass());
		this.hashColumns.put("un_nbr", getUnNbr());
		this.hashColumns.put("mfag", getMfag());
		this.hashColumns.put("haz_cont", getHazCont());
		this.hashColumns.put("nw_explosive", getNwExplosive());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("ems_nbr", getEmsNbr());
		this.hashColumns.put("outpkg_tp", getOutpkgTp());
		this.hashColumns.put("sub_class4", getSubClass4());
		this.hashColumns.put("sub_class3", getSubClass3());
		this.hashColumns.put("pkg_group", getPkgGroup());
		this.hashColumns.put("imo_page", getImoPage());
		this.hashColumns.put("sub_class2", getSubClass2());
		this.hashColumns.put("sub_class1", getSubClass1());
		this.hashColumns.put("pollutant", getPollutant());
		this.hashColumns.put("pkg_desc", getPkgDesc());
		this.hashColumns.put("nw_exp_unit", getNwExpUnit());
		this.hashColumns.put("grosswgt_unit", getGrosswgtUnit());
		this.hashColumns.put("pkg_qty", getPkgQty());
		this.hashColumns.put("outpkg_qty", getOutpkgQty());
		this.hashColumns.put("pkg_tp", getPkgTp());
		this.hashColumns.put("inpkg_desc", getInpkgDesc());
		this.hashColumns.put("stowpos", getStowpos());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flash", "flash");
		this.hashFields.put("outpkg_desc", "outpkgDesc");
		this.hashFields.put("espn", "espn");
		this.hashFields.put("imo_limit", "imoLimit");
		this.hashFields.put("inpkg_qty", "inpkgQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prop_ship_nm", "propShipNm");
		this.hashFields.put("flash_unit", "flashUnit");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imo_comp", "imoComp");
		this.hashFields.put("inpkg_tp", "inpkgTp");
		this.hashFields.put("item_nbr", "itemNbr");
		this.hashFields.put("netwgt_unit", "netwgtUnit");
		this.hashFields.put("netwgt", "netwgt");
		this.hashFields.put("un_nbr_seq", "unNbrSeq");
		this.hashFields.put("grosswgt", "grosswgt");
		this.hashFields.put("hcdg", "hcdg");
		this.hashFields.put("imo_class", "imoClass");
		this.hashFields.put("un_nbr", "unNbr");
		this.hashFields.put("mfag", "mfag");
		this.hashFields.put("haz_cont", "hazCont");
		this.hashFields.put("nw_explosive", "nwExplosive");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("ems_nbr", "emsNbr");
		this.hashFields.put("outpkg_tp", "outpkgTp");
		this.hashFields.put("sub_class4", "subClass4");
		this.hashFields.put("sub_class3", "subClass3");
		this.hashFields.put("pkg_group", "pkgGroup");
		this.hashFields.put("imo_page", "imoPage");
		this.hashFields.put("sub_class2", "subClass2");
		this.hashFields.put("sub_class1", "subClass1");
		this.hashFields.put("pollutant", "pollutant");
		this.hashFields.put("pkg_desc", "pkgDesc");
		this.hashFields.put("nw_exp_unit", "nwExpUnit");
		this.hashFields.put("grosswgt_unit", "grosswgtUnit");
		this.hashFields.put("pkg_qty", "pkgQty");
		this.hashFields.put("outpkg_qty", "outpkgQty");
		this.hashFields.put("pkg_tp", "pkgTp");
		this.hashFields.put("inpkg_desc", "inpkgDesc");
		this.hashFields.put("stowpos", "stowpos");
		this.hashFields.put("diff_rmk", "diffRmk");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return flash
	 */
	public String getFlash() {
		return this.flash;
	}

	/**
	 * Column Info
	 * @return outpkgDesc
	 */
	public String getOutpkgDesc() {
		return this.outpkgDesc;
	}

	/**
	 * Column Info
	 * @return espn
	 */
	public String getEspn() {
		return this.espn;
	}

	/**
	 * Column Info
	 * @return imoLimit
	 */
	public String getImoLimit() {
		return this.imoLimit;
	}

	/**
	 * Column Info
	 * @return inpkgQty
	 */
	public String getInpkgQty() {
		return this.inpkgQty;
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
	 * @return propShipNm
	 */
	public String getPropShipNm() {
		return this.propShipNm;
	}

	/**
	 * Column Info
	 * @return flashUnit
	 */
	public String getFlashUnit() {
		return this.flashUnit;
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
	 * @return imoComp
	 */
	public String getImoComp() {
		return this.imoComp;
	}

	/**
	 * Column Info
	 * @return inpkgTp
	 */
	public String getInpkgTp() {
		return this.inpkgTp;
	}

	/**
	 * Column Info
	 * @return itemNbr
	 */
	public String getItemNbr() {
		return this.itemNbr;
	}

	/**
	 * Column Info
	 * @return netwgtUnit
	 */
	public String getNetwgtUnit() {
		return this.netwgtUnit;
	}

	/**
	 * Column Info
	 * @return netwgt
	 */
	public String getNetwgt() {
		return this.netwgt;
	}

	/**
	 * Column Info
	 * @return unNbrSeq
	 */
	public String getUnNbrSeq() {
		return this.unNbrSeq;
	}

	/**
	 * Column Info
	 * @return grosswgt
	 */
	public String getGrosswgt() {
		return this.grosswgt;
	}

	/**
	 * Column Info
	 * @return hcdg
	 */
	public String getHcdg() {
		return this.hcdg;
	}

	/**
	 * Column Info
	 * @return imoClass
	 */
	public String getImoClass() {
		return this.imoClass;
	}

	/**
	 * Column Info
	 * @return unNbr
	 */
	public String getUnNbr() {
		return this.unNbr;
	}

	/**
	 * Column Info
	 * @return mfag
	 */
	public String getMfag() {
		return this.mfag;
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
	 * @return nwExplosive
	 */
	public String getNwExplosive() {
		return this.nwExplosive;
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
	 * @return emsNbr
	 */
	public String getEmsNbr() {
		return this.emsNbr;
	}

	/**
	 * Column Info
	 * @return outpkgTp
	 */
	public String getOutpkgTp() {
		return this.outpkgTp;
	}

	/**
	 * Column Info
	 * @return subClass4
	 */
	public String getSubClass4() {
		return this.subClass4;
	}

	/**
	 * Column Info
	 * @return subClass3
	 */
	public String getSubClass3() {
		return this.subClass3;
	}

	/**
	 * Column Info
	 * @return pkgGroup
	 */
	public String getPkgGroup() {
		return this.pkgGroup;
	}

	/**
	 * Column Info
	 * @return imoPage
	 */
	public String getImoPage() {
		return this.imoPage;
	}

	/**
	 * Column Info
	 * @return subClass2
	 */
	public String getSubClass2() {
		return this.subClass2;
	}

	/**
	 * Column Info
	 * @return subClass1
	 */
	public String getSubClass1() {
		return this.subClass1;
	}

	/**
	 * Column Info
	 * @return pollutant
	 */
	public String getPollutant() {
		return this.pollutant;
	}

	/**
	 * Column Info
	 * @return pkgDesc
	 */
	public String getPkgDesc() {
		return this.pkgDesc;
	}

	/**
	 * Column Info
	 * @return nwExpUnit
	 */
	public String getNwExpUnit() {
		return this.nwExpUnit;
	}

	/**
	 * Column Info
	 * @return grosswgtUnit
	 */
	public String getGrosswgtUnit() {
		return this.grosswgtUnit;
	}

	/**
	 * Column Info
	 * @return pkgQty
	 */
	public String getPkgQty() {
		return this.pkgQty;
	}

	/**
	 * Column Info
	 * @return outpkgQty
	 */
	public String getOutpkgQty() {
		return this.outpkgQty;
	}

	/**
	 * Column Info
	 * @return pkgTp
	 */
	public String getPkgTp() {
		return this.pkgTp;
	}

	/**
	 * Column Info
	 * @return inpkgDesc
	 */
	public String getInpkgDesc() {
		return this.inpkgDesc;
	}

	/**
	 * Column Info
	 * @return stowpos
	 */
	public String getStowpos() {
		return this.stowpos;
	}

	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}


	/**
	 * Column Info
	 * @param flash
	 */
	public void setFlash(String flash) {
		this.flash = flash;
	}

	/**
	 * Column Info
	 * @param outpkgDesc
	 */
	public void setOutpkgDesc(String outpkgDesc) {
		this.outpkgDesc = outpkgDesc;
	}

	/**
	 * Column Info
	 * @param espn
	 */
	public void setEspn(String espn) {
		this.espn = espn;
	}

	/**
	 * Column Info
	 * @param imoLimit
	 */
	public void setImoLimit(String imoLimit) {
		this.imoLimit = imoLimit;
	}

	/**
	 * Column Info
	 * @param inpkgQty
	 */
	public void setInpkgQty(String inpkgQty) {
		this.inpkgQty = inpkgQty;
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
	 * @param propShipNm
	 */
	public void setPropShipNm(String propShipNm) {
		this.propShipNm = propShipNm;
	}

	/**
	 * Column Info
	 * @param flashUnit
	 */
	public void setFlashUnit(String flashUnit) {
		this.flashUnit = flashUnit;
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
	 * @param imoComp
	 */
	public void setImoComp(String imoComp) {
		this.imoComp = imoComp;
	}

	/**
	 * Column Info
	 * @param inpkgTp
	 */
	public void setInpkgTp(String inpkgTp) {
		this.inpkgTp = inpkgTp;
	}

	/**
	 * Column Info
	 * @param itemNbr
	 */
	public void setItemNbr(String itemNbr) {
		this.itemNbr = itemNbr;
	}

	/**
	 * Column Info
	 * @param netwgtUnit
	 */
	public void setNetwgtUnit(String netwgtUnit) {
		this.netwgtUnit = netwgtUnit;
	}

	/**
	 * Column Info
	 * @param netwgt
	 */
	public void setNetwgt(String netwgt) {
		this.netwgt = netwgt;
	}

	/**
	 * Column Info
	 * @param unNbrSeq
	 */
	public void setUnNbrSeq(String unNbrSeq) {
		this.unNbrSeq = unNbrSeq;
	}

	/**
	 * Column Info
	 * @param grosswgt
	 */
	public void setGrosswgt(String grosswgt) {
		this.grosswgt = grosswgt;
	}

	/**
	 * Column Info
	 * @param hcdg
	 */
	public void setHcdg(String hcdg) {
		this.hcdg = hcdg;
	}

	/**
	 * Column Info
	 * @param imoClass
	 */
	public void setImoClass(String imoClass) {
		this.imoClass = imoClass;
	}

	/**
	 * Column Info
	 * @param unNbr
	 */
	public void setUnNbr(String unNbr) {
		this.unNbr = unNbr;
	}

	/**
	 * Column Info
	 * @param mfag
	 */
	public void setMfag(String mfag) {
		this.mfag = mfag;
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
	 * @param nwExplosive
	 */
	public void setNwExplosive(String nwExplosive) {
		this.nwExplosive = nwExplosive;
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
	 * @param emsNbr
	 */
	public void setEmsNbr(String emsNbr) {
		this.emsNbr = emsNbr;
	}

	/**
	 * Column Info
	 * @param outpkgTp
	 */
	public void setOutpkgTp(String outpkgTp) {
		this.outpkgTp = outpkgTp;
	}

	/**
	 * Column Info
	 * @param subClass4
	 */
	public void setSubClass4(String subClass4) {
		this.subClass4 = subClass4;
	}

	/**
	 * Column Info
	 * @param subClass3
	 */
	public void setSubClass3(String subClass3) {
		this.subClass3 = subClass3;
	}

	/**
	 * Column Info
	 * @param pkgGroup
	 */
	public void setPkgGroup(String pkgGroup) {
		this.pkgGroup = pkgGroup;
	}

	/**
	 * Column Info
	 * @param imoPage
	 */
	public void setImoPage(String imoPage) {
		this.imoPage = imoPage;
	}

	/**
	 * Column Info
	 * @param subClass2
	 */
	public void setSubClass2(String subClass2) {
		this.subClass2 = subClass2;
	}

	/**
	 * Column Info
	 * @param subClass1
	 */
	public void setSubClass1(String subClass1) {
		this.subClass1 = subClass1;
	}

	/**
	 * Column Info
	 * @param pollutant
	 */
	public void setPollutant(String pollutant) {
		this.pollutant = pollutant;
	}

	/**
	 * Column Info
	 * @param pkgDesc
	 */
	public void setPkgDesc(String pkgDesc) {
		this.pkgDesc = pkgDesc;
	}

	/**
	 * Column Info
	 * @param nwExpUnit
	 */
	public void setNwExpUnit(String nwExpUnit) {
		this.nwExpUnit = nwExpUnit;
	}

	/**
	 * Column Info
	 * @param grosswgtUnit
	 */
	public void setGrosswgtUnit(String grosswgtUnit) {
		this.grosswgtUnit = grosswgtUnit;
	}

	/**
	 * Column Info
	 * @param pkgQty
	 */
	public void setPkgQty(String pkgQty) {
		this.pkgQty = pkgQty;
	}

	/**
	 * Column Info
	 * @param outpkgQty
	 */
	public void setOutpkgQty(String outpkgQty) {
		this.outpkgQty = outpkgQty;
	}

	/**
	 * Column Info
	 * @param pkgTp
	 */
	public void setPkgTp(String pkgTp) {
		this.pkgTp = pkgTp;
	}

	/**
	 * Column Info
	 * @param inpkgDesc
	 */
	public void setInpkgDesc(String inpkgDesc) {
		this.inpkgDesc = inpkgDesc;
	}

	/**
	 * Column Info
	 * @param stowpos
	 */
	public void setStowpos(String stowpos) {
		this.stowpos = stowpos;
	}

	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
		setFlash(JSPUtil.getParameter(request, prefix + "flash", ""));
		setOutpkgDesc(JSPUtil.getParameter(request, prefix + "outpkg_desc", ""));
		setEspn(JSPUtil.getParameter(request, prefix + "espn", ""));
		setImoLimit(JSPUtil.getParameter(request, prefix + "imo_limit", ""));
		setInpkgQty(JSPUtil.getParameter(request, prefix + "inpkg_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPropShipNm(JSPUtil.getParameter(request, prefix + "prop_ship_nm", ""));
		setFlashUnit(JSPUtil.getParameter(request, prefix + "flash_unit", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImoComp(JSPUtil.getParameter(request, prefix + "imo_comp", ""));
		setInpkgTp(JSPUtil.getParameter(request, prefix + "inpkg_tp", ""));
		setItemNbr(JSPUtil.getParameter(request, prefix + "item_nbr", ""));
		setNetwgtUnit(JSPUtil.getParameter(request, prefix + "netwgt_unit", ""));
		setNetwgt(JSPUtil.getParameter(request, prefix + "netwgt", ""));
		setUnNbrSeq(JSPUtil.getParameter(request, prefix + "un_nbr_seq", ""));
		setGrosswgt(JSPUtil.getParameter(request, prefix + "grosswgt", ""));
		setHcdg(JSPUtil.getParameter(request, prefix + "hcdg", ""));
		setImoClass(JSPUtil.getParameter(request, prefix + "imo_class", ""));
		setUnNbr(JSPUtil.getParameter(request, prefix + "un_nbr", ""));
		setMfag(JSPUtil.getParameter(request, prefix + "mfag", ""));
		setHazCont(JSPUtil.getParameter(request, prefix + "haz_cont", ""));
		setNwExplosive(JSPUtil.getParameter(request, prefix + "nw_explosive", ""));
		setCntrnbr(JSPUtil.getParameter(request, prefix + "cntrnbr", ""));
		setEmsNbr(JSPUtil.getParameter(request, prefix + "ems_nbr", ""));
		setOutpkgTp(JSPUtil.getParameter(request, prefix + "outpkg_tp", ""));
		setSubClass4(JSPUtil.getParameter(request, prefix + "sub_class4", ""));
		setSubClass3(JSPUtil.getParameter(request, prefix + "sub_class3", ""));
		setPkgGroup(JSPUtil.getParameter(request, prefix + "pkg_group", ""));
		setImoPage(JSPUtil.getParameter(request, prefix + "imo_page", ""));
		setSubClass2(JSPUtil.getParameter(request, prefix + "sub_class2", ""));
		setSubClass1(JSPUtil.getParameter(request, prefix + "sub_class1", ""));
		setPollutant(JSPUtil.getParameter(request, prefix + "pollutant", ""));
		setPkgDesc(JSPUtil.getParameter(request, prefix + "pkg_desc", ""));
		setNwExpUnit(JSPUtil.getParameter(request, prefix + "nw_exp_unit", ""));
		setGrosswgtUnit(JSPUtil.getParameter(request, prefix + "grosswgt_unit", ""));
		setPkgQty(JSPUtil.getParameter(request, prefix + "pkg_qty", ""));
		setOutpkgQty(JSPUtil.getParameter(request, prefix + "outpkg_qty", ""));
		setPkgTp(JSPUtil.getParameter(request, prefix + "pkg_tp", ""));
		setInpkgDesc(JSPUtil.getParameter(request, prefix + "inpkg_desc", ""));
		setStowpos(JSPUtil.getParameter(request, prefix + "stowpos", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrCgoVO[]
	 */
	public CntrCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CntrCgoVO[]
	 */
	public CntrCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrCgoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] flash = (JSPUtil.getParameter(request, prefix	+ "flash", length));
			String[] outpkgDesc = (JSPUtil.getParameter(request, prefix	+ "outpkg_desc", length));
			String[] espn = (JSPUtil.getParameter(request, prefix	+ "espn", length));
			String[] imoLimit = (JSPUtil.getParameter(request, prefix	+ "imo_limit", length));
			String[] inpkgQty = (JSPUtil.getParameter(request, prefix	+ "inpkg_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] propShipNm = (JSPUtil.getParameter(request, prefix	+ "prop_ship_nm", length));
			String[] flashUnit = (JSPUtil.getParameter(request, prefix	+ "flash_unit", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imoComp = (JSPUtil.getParameter(request, prefix	+ "imo_comp", length));
			String[] inpkgTp = (JSPUtil.getParameter(request, prefix	+ "inpkg_tp", length));
			String[] itemNbr = (JSPUtil.getParameter(request, prefix	+ "item_nbr", length));
			String[] netwgtUnit = (JSPUtil.getParameter(request, prefix	+ "netwgt_unit", length));
			String[] netwgt = (JSPUtil.getParameter(request, prefix	+ "netwgt", length));
			String[] unNbrSeq = (JSPUtil.getParameter(request, prefix	+ "un_nbr_seq", length));
			String[] grosswgt = (JSPUtil.getParameter(request, prefix	+ "grosswgt", length));
			String[] hcdg = (JSPUtil.getParameter(request, prefix	+ "hcdg", length));
			String[] imoClass = (JSPUtil.getParameter(request, prefix	+ "imo_class", length));
			String[] unNbr = (JSPUtil.getParameter(request, prefix	+ "un_nbr", length));
			String[] mfag = (JSPUtil.getParameter(request, prefix	+ "mfag", length));
			String[] hazCont = (JSPUtil.getParameter(request, prefix	+ "haz_cont", length));
			String[] nwExplosive = (JSPUtil.getParameter(request, prefix	+ "nw_explosive", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] emsNbr = (JSPUtil.getParameter(request, prefix	+ "ems_nbr", length));
			String[] outpkgTp = (JSPUtil.getParameter(request, prefix	+ "outpkg_tp", length));
			String[] subClass4 = (JSPUtil.getParameter(request, prefix	+ "sub_class4", length));
			String[] subClass3 = (JSPUtil.getParameter(request, prefix	+ "sub_class3", length));
			String[] pkgGroup = (JSPUtil.getParameter(request, prefix	+ "pkg_group", length));
			String[] imoPage = (JSPUtil.getParameter(request, prefix	+ "imo_page", length));
			String[] subClass2 = (JSPUtil.getParameter(request, prefix	+ "sub_class2", length));
			String[] subClass1 = (JSPUtil.getParameter(request, prefix	+ "sub_class1", length));
			String[] pollutant = (JSPUtil.getParameter(request, prefix	+ "pollutant", length));
			String[] pkgDesc = (JSPUtil.getParameter(request, prefix	+ "pkg_desc", length));
			String[] nwExpUnit = (JSPUtil.getParameter(request, prefix	+ "nw_exp_unit", length));
			String[] grosswgtUnit = (JSPUtil.getParameter(request, prefix	+ "grosswgt_unit", length));
			String[] pkgQty = (JSPUtil.getParameter(request, prefix	+ "pkg_qty", length));
			String[] outpkgQty = (JSPUtil.getParameter(request, prefix	+ "outpkg_qty", length));
			String[] pkgTp = (JSPUtil.getParameter(request, prefix	+ "pkg_tp", length));
			String[] inpkgDesc = (JSPUtil.getParameter(request, prefix	+ "inpkg_desc", length));
			String[] stowpos = (JSPUtil.getParameter(request, prefix	+ "stowpos", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));

			for (int i = 0; i < length; i++) {
				model = new CntrCgoVO();
				if (flash[i] != null)
					model.setFlash(flash[i]);
				if (outpkgDesc[i] != null)
					model.setOutpkgDesc(outpkgDesc[i]);
				if (espn[i] != null)
					model.setEspn(espn[i]);
				if (imoLimit[i] != null)
					model.setImoLimit(imoLimit[i]);
				if (inpkgQty[i] != null)
					model.setInpkgQty(inpkgQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (propShipNm[i] != null)
					model.setPropShipNm(propShipNm[i]);
				if (flashUnit[i] != null)
					model.setFlashUnit(flashUnit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imoComp[i] != null)
					model.setImoComp(imoComp[i]);
				if (inpkgTp[i] != null)
					model.setInpkgTp(inpkgTp[i]);
				if (itemNbr[i] != null)
					model.setItemNbr(itemNbr[i]);
				if (netwgtUnit[i] != null)
					model.setNetwgtUnit(netwgtUnit[i]);
				if (netwgt[i] != null)
					model.setNetwgt(netwgt[i]);
				if (unNbrSeq[i] != null)
					model.setUnNbrSeq(unNbrSeq[i]);
				if (grosswgt[i] != null)
					model.setGrosswgt(grosswgt[i]);
				if (hcdg[i] != null)
					model.setHcdg(hcdg[i]);
				if (imoClass[i] != null)
					model.setImoClass(imoClass[i]);
				if (unNbr[i] != null)
					model.setUnNbr(unNbr[i]);
				if (mfag[i] != null)
					model.setMfag(mfag[i]);
				if (hazCont[i] != null)
					model.setHazCont(hazCont[i]);
				if (nwExplosive[i] != null)
					model.setNwExplosive(nwExplosive[i]);
				if (cntrnbr[i] != null)
					model.setCntrnbr(cntrnbr[i]);
				if (emsNbr[i] != null)
					model.setEmsNbr(emsNbr[i]);
				if (outpkgTp[i] != null)
					model.setOutpkgTp(outpkgTp[i]);
				if (subClass4[i] != null)
					model.setSubClass4(subClass4[i]);
				if (subClass3[i] != null)
					model.setSubClass3(subClass3[i]);
				if (pkgGroup[i] != null)
					model.setPkgGroup(pkgGroup[i]);
				if (imoPage[i] != null)
					model.setImoPage(imoPage[i]);
				if (subClass2[i] != null)
					model.setSubClass2(subClass2[i]);
				if (subClass1[i] != null)
					model.setSubClass1(subClass1[i]);
				if (pollutant[i] != null)
					model.setPollutant(pollutant[i]);
				if (pkgDesc[i] != null)
					model.setPkgDesc(pkgDesc[i]);
				if (nwExpUnit[i] != null)
					model.setNwExpUnit(nwExpUnit[i]);
				if (grosswgtUnit[i] != null)
					model.setGrosswgtUnit(grosswgtUnit[i]);
				if (pkgQty[i] != null)
					model.setPkgQty(pkgQty[i]);
				if (outpkgQty[i] != null)
					model.setOutpkgQty(outpkgQty[i]);
				if (pkgTp[i] != null)
					model.setPkgTp(pkgTp[i]);
				if (inpkgDesc[i] != null)
					model.setInpkgDesc(inpkgDesc[i]);
				if (stowpos[i] != null)
					model.setStowpos(stowpos[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrCgoVO[]
	 */
	public CntrCgoVO[] getCntrCgoVOs(){
		CntrCgoVO[] vos = (CntrCgoVO[])models.toArray(new CntrCgoVO[models.size()]);
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
		this.flash = this.flash .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outpkgDesc = this.outpkgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.espn = this.espn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoLimit = this.imoLimit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpkgQty = this.inpkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propShipNm = this.propShipNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flashUnit = this.flashUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoComp = this.imoComp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpkgTp = this.inpkgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemNbr = this.itemNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netwgtUnit = this.netwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netwgt = this.netwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNbrSeq = this.unNbrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grosswgt = this.grosswgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdg = this.hcdg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoClass = this.imoClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNbr = this.unNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfag = this.mfag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazCont = this.hazCont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nwExplosive = this.nwExplosive .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNbr = this.emsNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outpkgTp = this.outpkgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subClass4 = this.subClass4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subClass3 = this.subClass3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgGroup = this.pkgGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoPage = this.imoPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subClass2 = this.subClass2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subClass1 = this.subClass1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pollutant = this.pollutant .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgDesc = this.pkgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nwExpUnit = this.nwExpUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grosswgtUnit = this.grosswgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgQty = this.pkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outpkgQty = this.outpkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgTp = this.pkgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpkgDesc = this.inpkgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stowpos = this.stowpos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
