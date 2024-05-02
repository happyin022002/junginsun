/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ItemInfoVO.java
*@FileTitle : ItemInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class ItemInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ItemInfoVO> models = new ArrayList<ItemInfoVO>();
	
	/* Column Info */
	private String shippingRef = null;
	/* Column Info */
	private String consolNo = null;
	/* Column Info */
	private String flash = null;
	/* Column Info */
	private String imdgClass = null;
	/* Column Info */
	private String inpkgQty = null;
	/* Column Info */
	private String emsNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flashUnit = null;
	/* Column Info */
	private String inpkgTp = null;
	/* Column Info */
	private String dgCd = null;
	/* Column Info */
	private String neqwgtUnit = null;
	/* Column Info */
	private String netwgt = null;
	/* Column Info */
	private String netwgtUnit = null;
	/* Column Info */
	private String shippingName = null;
	/* Column Info */
	private String grosswgt = null;
	/* Column Info */
	private String mfag = null;
	/* Column Info */
	private String itemNo = null;
	/* Column Info */
	private String stowLoc = null;
	/* Column Info */
	private String storAge = null;
	/* Column Info */
	private String outpkgTp = null;
	/* Column Info */
	private String unNo = null;
	/* Column Info */
	private String pkgGroup = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String neqwgt = null;
	/* Column Info */
	private String party1 = null;
	/* Column Info */
	private String party2 = null;
	/* Column Info */
	private String party3 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String party4 = null;
	/* Column Info */
	private String party5 = null;
	/* Column Info */
	private String outpkgTpId = null;
	/* Column Info */
	private String grosswgtUnit = null;
	/* Column Info */
	private String outpkgQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ItemInfoVO() {}

	public ItemInfoVO(String ibflag, String pagerows, String consolNo, String shippingRef, String polCd, String podCd, String itemNo, String outpkgQty, String outpkgTpId, String outpkgTp, String inpkgQty, String inpkgTp, String storAge, String party1, String party2, String party3, String party4, String party5, String dgCd, String imdgClass, String unNo, String flash, String flashUnit, String pkgGroup, String emsNo, String mfag, String shippingName, String netwgtUnit, String netwgt, String grosswgtUnit, String grosswgt, String neqwgtUnit, String neqwgt, String cntrNo, String stowLoc) {
		this.shippingRef = shippingRef;
		this.consolNo = consolNo;
		this.flash = flash;
		this.imdgClass = imdgClass;
		this.inpkgQty = inpkgQty;
		this.emsNo = emsNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.flashUnit = flashUnit;
		this.inpkgTp = inpkgTp;
		this.dgCd = dgCd;
		this.neqwgtUnit = neqwgtUnit;
		this.netwgt = netwgt;
		this.netwgtUnit = netwgtUnit;
		this.shippingName = shippingName;
		this.grosswgt = grosswgt;
		this.mfag = mfag;
		this.itemNo = itemNo;
		this.stowLoc = stowLoc;
		this.storAge = storAge;
		this.outpkgTp = outpkgTp;
		this.unNo = unNo;
		this.pkgGroup = pkgGroup;
		this.podCd = podCd;
		this.neqwgt = neqwgt;
		this.party1 = party1;
		this.party2 = party2;
		this.party3 = party3;
		this.cntrNo = cntrNo;
		this.party4 = party4;
		this.party5 = party5;
		this.outpkgTpId = outpkgTpId;
		this.grosswgtUnit = grosswgtUnit;
		this.outpkgQty = outpkgQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shipping_ref", getShippingRef());
		this.hashColumns.put("consol_no", getConsolNo());
		this.hashColumns.put("flash", getFlash());
		this.hashColumns.put("imdg_class", getImdgClass());
		this.hashColumns.put("inpkg_qty", getInpkgQty());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flash_unit", getFlashUnit());
		this.hashColumns.put("inpkg_tp", getInpkgTp());
		this.hashColumns.put("dg_cd", getDgCd());
		this.hashColumns.put("neqwgt_unit", getNeqwgtUnit());
		this.hashColumns.put("netwgt", getNetwgt());
		this.hashColumns.put("netwgt_unit", getNetwgtUnit());
		this.hashColumns.put("shipping_name", getShippingName());
		this.hashColumns.put("grosswgt", getGrosswgt());
		this.hashColumns.put("mfag", getMfag());
		this.hashColumns.put("item_no", getItemNo());
		this.hashColumns.put("stow_loc", getStowLoc());
		this.hashColumns.put("stor_age", getStorAge());
		this.hashColumns.put("outpkg_tp", getOutpkgTp());
		this.hashColumns.put("un_no", getUnNo());
		this.hashColumns.put("pkg_group", getPkgGroup());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("neqwgt", getNeqwgt());
		this.hashColumns.put("party1", getParty1());
		this.hashColumns.put("party2", getParty2());
		this.hashColumns.put("party3", getParty3());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("party4", getParty4());
		this.hashColumns.put("party5", getParty5());
		this.hashColumns.put("outpkg_tp_id", getOutpkgTpId());
		this.hashColumns.put("grosswgt_unit", getGrosswgtUnit());
		this.hashColumns.put("outpkg_qty", getOutpkgQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shipping_ref", "shippingRef");
		this.hashFields.put("consol_no", "consolNo");
		this.hashFields.put("flash", "flash");
		this.hashFields.put("imdg_class", "imdgClass");
		this.hashFields.put("inpkg_qty", "inpkgQty");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flash_unit", "flashUnit");
		this.hashFields.put("inpkg_tp", "inpkgTp");
		this.hashFields.put("dg_cd", "dgCd");
		this.hashFields.put("neqwgt_unit", "neqwgtUnit");
		this.hashFields.put("netwgt", "netwgt");
		this.hashFields.put("netwgt_unit", "netwgtUnit");
		this.hashFields.put("shipping_name", "shippingName");
		this.hashFields.put("grosswgt", "grosswgt");
		this.hashFields.put("mfag", "mfag");
		this.hashFields.put("item_no", "itemNo");
		this.hashFields.put("stow_loc", "stowLoc");
		this.hashFields.put("stor_age", "storAge");
		this.hashFields.put("outpkg_tp", "outpkgTp");
		this.hashFields.put("un_no", "unNo");
		this.hashFields.put("pkg_group", "pkgGroup");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("neqwgt", "neqwgt");
		this.hashFields.put("party1", "party1");
		this.hashFields.put("party2", "party2");
		this.hashFields.put("party3", "party3");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("party4", "party4");
		this.hashFields.put("party5", "party5");
		this.hashFields.put("outpkg_tp_id", "outpkgTpId");
		this.hashFields.put("grosswgt_unit", "grosswgtUnit");
		this.hashFields.put("outpkg_qty", "outpkgQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shippingRef
	 */
	public String getShippingRef() {
		return this.shippingRef;
	}
	
	/**
	 * Column Info
	 * @return consolNo
	 */
	public String getConsolNo() {
		return this.consolNo;
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
	 * @return imdgClass
	 */
	public String getImdgClass() {
		return this.imdgClass;
	}
	
	/**
	 * Column Info
	 * @return inpkgQty
	 */
	public String getInpkgQty() {
		return this.inpkgQty;
	}
	
	/**
	 * Column Info
	 * @return emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
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
	 * @return flashUnit
	 */
	public String getFlashUnit() {
		return this.flashUnit;
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
	 * @return dgCd
	 */
	public String getDgCd() {
		return this.dgCd;
	}
	
	/**
	 * Column Info
	 * @return neqwgtUnit
	 */
	public String getNeqwgtUnit() {
		return this.neqwgtUnit;
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
	 * @return netwgtUnit
	 */
	public String getNetwgtUnit() {
		return this.netwgtUnit;
	}
	
	/**
	 * Column Info
	 * @return shippingName
	 */
	public String getShippingName() {
		return this.shippingName;
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
	 * @return mfag
	 */
	public String getMfag() {
		return this.mfag;
	}
	
	/**
	 * Column Info
	 * @return itemNo
	 */
	public String getItemNo() {
		return this.itemNo;
	}
	
	/**
	 * Column Info
	 * @return stowLoc
	 */
	public String getStowLoc() {
		return this.stowLoc;
	}
	
	/**
	 * Column Info
	 * @return storAge
	 */
	public String getStorAge() {
		return this.storAge;
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
	 * @return unNo
	 */
	public String getUnNo() {
		return this.unNo;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return neqwgt
	 */
	public String getNeqwgt() {
		return this.neqwgt;
	}
	
	/**
	 * Column Info
	 * @return party1
	 */
	public String getParty1() {
		return this.party1;
	}
	
	/**
	 * Column Info
	 * @return party2
	 */
	public String getParty2() {
		return this.party2;
	}
	
	/**
	 * Column Info
	 * @return party3
	 */
	public String getParty3() {
		return this.party3;
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
	 * @return party4
	 */
	public String getParty4() {
		return this.party4;
	}
	
	/**
	 * Column Info
	 * @return party5
	 */
	public String getParty5() {
		return this.party5;
	}
	
	/**
	 * Column Info
	 * @return outpkgTpId
	 */
	public String getOutpkgTpId() {
		return this.outpkgTpId;
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
	 * @return outpkgQty
	 */
	public String getOutpkgQty() {
		return this.outpkgQty;
	}
	

	/**
	 * Column Info
	 * @param shippingRef
	 */
	public void setShippingRef(String shippingRef) {
		this.shippingRef = shippingRef;
	}
	
	/**
	 * Column Info
	 * @param consolNo
	 */
	public void setConsolNo(String consolNo) {
		this.consolNo = consolNo;
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
	 * @param imdgClass
	 */
	public void setImdgClass(String imdgClass) {
		this.imdgClass = imdgClass;
	}
	
	/**
	 * Column Info
	 * @param inpkgQty
	 */
	public void setInpkgQty(String inpkgQty) {
		this.inpkgQty = inpkgQty;
	}
	
	/**
	 * Column Info
	 * @param emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
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
	 * @param flashUnit
	 */
	public void setFlashUnit(String flashUnit) {
		this.flashUnit = flashUnit;
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
	 * @param dgCd
	 */
	public void setDgCd(String dgCd) {
		this.dgCd = dgCd;
	}
	
	/**
	 * Column Info
	 * @param neqwgtUnit
	 */
	public void setNeqwgtUnit(String neqwgtUnit) {
		this.neqwgtUnit = neqwgtUnit;
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
	 * @param netwgtUnit
	 */
	public void setNetwgtUnit(String netwgtUnit) {
		this.netwgtUnit = netwgtUnit;
	}
	
	/**
	 * Column Info
	 * @param shippingName
	 */
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
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
	 * @param mfag
	 */
	public void setMfag(String mfag) {
		this.mfag = mfag;
	}
	
	/**
	 * Column Info
	 * @param itemNo
	 */
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	
	/**
	 * Column Info
	 * @param stowLoc
	 */
	public void setStowLoc(String stowLoc) {
		this.stowLoc = stowLoc;
	}
	
	/**
	 * Column Info
	 * @param storAge
	 */
	public void setStorAge(String storAge) {
		this.storAge = storAge;
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
	 * @param unNo
	 */
	public void setUnNo(String unNo) {
		this.unNo = unNo;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param neqwgt
	 */
	public void setNeqwgt(String neqwgt) {
		this.neqwgt = neqwgt;
	}
	
	/**
	 * Column Info
	 * @param party1
	 */
	public void setParty1(String party1) {
		this.party1 = party1;
	}
	
	/**
	 * Column Info
	 * @param party2
	 */
	public void setParty2(String party2) {
		this.party2 = party2;
	}
	
	/**
	 * Column Info
	 * @param party3
	 */
	public void setParty3(String party3) {
		this.party3 = party3;
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
	 * @param party4
	 */
	public void setParty4(String party4) {
		this.party4 = party4;
	}
	
	/**
	 * Column Info
	 * @param party5
	 */
	public void setParty5(String party5) {
		this.party5 = party5;
	}
	
	/**
	 * Column Info
	 * @param outpkgTpId
	 */
	public void setOutpkgTpId(String outpkgTpId) {
		this.outpkgTpId = outpkgTpId;
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
	 * @param outpkgQty
	 */
	public void setOutpkgQty(String outpkgQty) {
		this.outpkgQty = outpkgQty;
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
		setShippingRef(JSPUtil.getParameter(request, prefix + "shipping_ref", ""));
		setConsolNo(JSPUtil.getParameter(request, prefix + "consol_no", ""));
		setFlash(JSPUtil.getParameter(request, prefix + "flash", ""));
		setImdgClass(JSPUtil.getParameter(request, prefix + "imdg_class", ""));
		setInpkgQty(JSPUtil.getParameter(request, prefix + "inpkg_qty", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFlashUnit(JSPUtil.getParameter(request, prefix + "flash_unit", ""));
		setInpkgTp(JSPUtil.getParameter(request, prefix + "inpkg_tp", ""));
		setDgCd(JSPUtil.getParameter(request, prefix + "dg_cd", ""));
		setNeqwgtUnit(JSPUtil.getParameter(request, prefix + "neqwgt_unit", ""));
		setNetwgt(JSPUtil.getParameter(request, prefix + "netwgt", ""));
		setNetwgtUnit(JSPUtil.getParameter(request, prefix + "netwgt_unit", ""));
		setShippingName(JSPUtil.getParameter(request, prefix + "shipping_name", ""));
		setGrosswgt(JSPUtil.getParameter(request, prefix + "grosswgt", ""));
		setMfag(JSPUtil.getParameter(request, prefix + "mfag", ""));
		setItemNo(JSPUtil.getParameter(request, prefix + "item_no", ""));
		setStowLoc(JSPUtil.getParameter(request, prefix + "stow_loc", ""));
		setStorAge(JSPUtil.getParameter(request, prefix + "stor_age", ""));
		setOutpkgTp(JSPUtil.getParameter(request, prefix + "outpkg_tp", ""));
		setUnNo(JSPUtil.getParameter(request, prefix + "un_no", ""));
		setPkgGroup(JSPUtil.getParameter(request, prefix + "pkg_group", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setNeqwgt(JSPUtil.getParameter(request, prefix + "neqwgt", ""));
		setParty1(JSPUtil.getParameter(request, prefix + "party1", ""));
		setParty2(JSPUtil.getParameter(request, prefix + "party2", ""));
		setParty3(JSPUtil.getParameter(request, prefix + "party3", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setParty4(JSPUtil.getParameter(request, prefix + "party4", ""));
		setParty5(JSPUtil.getParameter(request, prefix + "party5", ""));
		setOutpkgTpId(JSPUtil.getParameter(request, prefix + "outpkg_tp_id", ""));
		setGrosswgtUnit(JSPUtil.getParameter(request, prefix + "grosswgt_unit", ""));
		setOutpkgQty(JSPUtil.getParameter(request, prefix + "outpkg_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ItemInfoVO[]
	 */
	public ItemInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ItemInfoVO[]
	 */
	public ItemInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ItemInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shippingRef = (JSPUtil.getParameter(request, prefix	+ "shipping_ref", length));
			String[] consolNo = (JSPUtil.getParameter(request, prefix	+ "consol_no", length));
			String[] flash = (JSPUtil.getParameter(request, prefix	+ "flash", length));
			String[] imdgClass = (JSPUtil.getParameter(request, prefix	+ "imdg_class", length));
			String[] inpkgQty = (JSPUtil.getParameter(request, prefix	+ "inpkg_qty", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flashUnit = (JSPUtil.getParameter(request, prefix	+ "flash_unit", length));
			String[] inpkgTp = (JSPUtil.getParameter(request, prefix	+ "inpkg_tp", length));
			String[] dgCd = (JSPUtil.getParameter(request, prefix	+ "dg_cd", length));
			String[] neqwgtUnit = (JSPUtil.getParameter(request, prefix	+ "neqwgt_unit", length));
			String[] netwgt = (JSPUtil.getParameter(request, prefix	+ "netwgt", length));
			String[] netwgtUnit = (JSPUtil.getParameter(request, prefix	+ "netwgt_unit", length));
			String[] shippingName = (JSPUtil.getParameter(request, prefix	+ "shipping_name", length));
			String[] grosswgt = (JSPUtil.getParameter(request, prefix	+ "grosswgt", length));
			String[] mfag = (JSPUtil.getParameter(request, prefix	+ "mfag", length));
			String[] itemNo = (JSPUtil.getParameter(request, prefix	+ "item_no", length));
			String[] stowLoc = (JSPUtil.getParameter(request, prefix	+ "stow_loc", length));
			String[] storAge = (JSPUtil.getParameter(request, prefix	+ "stor_age", length));
			String[] outpkgTp = (JSPUtil.getParameter(request, prefix	+ "outpkg_tp", length));
			String[] unNo = (JSPUtil.getParameter(request, prefix	+ "un_no", length));
			String[] pkgGroup = (JSPUtil.getParameter(request, prefix	+ "pkg_group", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] neqwgt = (JSPUtil.getParameter(request, prefix	+ "neqwgt", length));
			String[] party1 = (JSPUtil.getParameter(request, prefix	+ "party1", length));
			String[] party2 = (JSPUtil.getParameter(request, prefix	+ "party2", length));
			String[] party3 = (JSPUtil.getParameter(request, prefix	+ "party3", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] party4 = (JSPUtil.getParameter(request, prefix	+ "party4", length));
			String[] party5 = (JSPUtil.getParameter(request, prefix	+ "party5", length));
			String[] outpkgTpId = (JSPUtil.getParameter(request, prefix	+ "outpkg_tp_id", length));
			String[] grosswgtUnit = (JSPUtil.getParameter(request, prefix	+ "grosswgt_unit", length));
			String[] outpkgQty = (JSPUtil.getParameter(request, prefix	+ "outpkg_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new ItemInfoVO();
				if (shippingRef[i] != null)
					model.setShippingRef(shippingRef[i]);
				if (consolNo[i] != null)
					model.setConsolNo(consolNo[i]);
				if (flash[i] != null)
					model.setFlash(flash[i]);
				if (imdgClass[i] != null)
					model.setImdgClass(imdgClass[i]);
				if (inpkgQty[i] != null)
					model.setInpkgQty(inpkgQty[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flashUnit[i] != null)
					model.setFlashUnit(flashUnit[i]);
				if (inpkgTp[i] != null)
					model.setInpkgTp(inpkgTp[i]);
				if (dgCd[i] != null)
					model.setDgCd(dgCd[i]);
				if (neqwgtUnit[i] != null)
					model.setNeqwgtUnit(neqwgtUnit[i]);
				if (netwgt[i] != null)
					model.setNetwgt(netwgt[i]);
				if (netwgtUnit[i] != null)
					model.setNetwgtUnit(netwgtUnit[i]);
				if (shippingName[i] != null)
					model.setShippingName(shippingName[i]);
				if (grosswgt[i] != null)
					model.setGrosswgt(grosswgt[i]);
				if (mfag[i] != null)
					model.setMfag(mfag[i]);
				if (itemNo[i] != null)
					model.setItemNo(itemNo[i]);
				if (stowLoc[i] != null)
					model.setStowLoc(stowLoc[i]);
				if (storAge[i] != null)
					model.setStorAge(storAge[i]);
				if (outpkgTp[i] != null)
					model.setOutpkgTp(outpkgTp[i]);
				if (unNo[i] != null)
					model.setUnNo(unNo[i]);
				if (pkgGroup[i] != null)
					model.setPkgGroup(pkgGroup[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (neqwgt[i] != null)
					model.setNeqwgt(neqwgt[i]);
				if (party1[i] != null)
					model.setParty1(party1[i]);
				if (party2[i] != null)
					model.setParty2(party2[i]);
				if (party3[i] != null)
					model.setParty3(party3[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (party4[i] != null)
					model.setParty4(party4[i]);
				if (party5[i] != null)
					model.setParty5(party5[i]);
				if (outpkgTpId[i] != null)
					model.setOutpkgTpId(outpkgTpId[i]);
				if (grosswgtUnit[i] != null)
					model.setGrosswgtUnit(grosswgtUnit[i]);
				if (outpkgQty[i] != null)
					model.setOutpkgQty(outpkgQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getItemInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ItemInfoVO[]
	 */
	public ItemInfoVO[] getItemInfoVOs(){
		ItemInfoVO[] vos = (ItemInfoVO[])models.toArray(new ItemInfoVO[models.size()]);
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
		this.shippingRef = this.shippingRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consolNo = this.consolNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flash = this.flash .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClass = this.imdgClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpkgQty = this.inpkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flashUnit = this.flashUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpkgTp = this.inpkgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCd = this.dgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.neqwgtUnit = this.neqwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netwgt = this.netwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netwgtUnit = this.netwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shippingName = this.shippingName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grosswgt = this.grosswgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfag = this.mfag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemNo = this.itemNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stowLoc = this.stowLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.storAge = this.storAge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outpkgTp = this.outpkgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNo = this.unNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgGroup = this.pkgGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.neqwgt = this.neqwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.party1 = this.party1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.party2 = this.party2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.party3 = this.party3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.party4 = this.party4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.party5 = this.party5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outpkgTpId = this.outpkgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grosswgtUnit = this.grosswgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outpkgQty = this.outpkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
