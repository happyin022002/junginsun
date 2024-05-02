/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : FlatFilePartnerLineVO.java
 *@FileTitle : FlatFilePartnerLineVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.15 
 *@LastModifier : dongsoo
 *@LastVersion : 1.0 
 * 2014.10.15 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class FlatFilePartnerLineVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<FlatFilePartnerLineVO>  models =	new	ArrayList<FlatFilePartnerLineVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String bkgnbr = null;
	/*	Column Info	*/
	private String bkgDt = null;
	/*	Column Info	*/
	private String brac = null;
	/*	Column Info	*/
	private String refnbr = null;
	/*	Column Info	*/
	private String vslCallsign = null;
	/*	Column Info	*/
	private String vslLloydcode = null;
	/*	Column Info	*/
	private String vslFullname = null;
	/*	Column Info	*/
	private String vvdRefNo = null;
	/*	Column Info	*/
	private String consortVoy = null;
	/*	Column Info	*/
	private String polCd = null;
	/*	Column Info	*/
	private String polNm = null;
	/*	Column Info	*/
	private String podCd = null;
	/*	Column Info	*/
	private String podNm = null;
	/*	Column Info	*/
	private String pldCd = null;
	/*	Column Info	*/
	private String pldNm = null;
	/*	Column Info	*/
	private String rdtyp = null;
	/*	Column Info	*/
	private String partyTp = null;
	/*	Column Info	*/
	private String partyCd = null;
	/*	Column Info	*/
	private String cntrSeq = null;
	/*	Column Info	*/
	private String cntrNo = null;
	/*	Column Info	*/
	private String cntrTpsz = null;
	/*	Column Info	*/
	private String imex = null;
	/*	Column Info	*/
	private String itemSeq = null;
	/*	Column Info	*/
	private String dgRef = null;
	/*	Column Info	*/
	private String opkgQty = null;
	/*	Column Info	*/
	private String opkgTp = null;
	/*	Column Info	*/
	private String opkgDesc = null;
	/*	Column Info	*/
	private String mpkgQty = null;
	/*	Column Info	*/
	private String mpkgTp = null;
	/*	Column Info	*/
	private String mpkgDesc = null;
	/*	Column Info	*/
	private String ipkgQty = null;
	/*	Column Info	*/
	private String ipkgTp = null;
	/*	Column Info	*/
	private String ipkgDesc = null;
	/*	Column Info	*/
	private String hazCont = null;
	/*	Column Info	*/
	private String propShipNm = null;
	/*	Column Info	*/
	private String techNm = null;
	/*	Column Info	*/
	private String imoClass = null;
	/*	Column Info	*/
	private String imoPage = null;
	/*	Column Info	*/
	private String unNbr = null;
	/*	Column Info	*/
	private String unNbrSeq = null;
	/*	Column Info	*/
	private String cfrNbr = null;
	/*	Column Info	*/
	private String flash = null;
	/*	Column Info	*/
	private String flashUnit = null;
	/*	Column Info	*/
	private String pkgGroup = null;
	/*	Column Info	*/
	private String emsNbr = null;
	/*	Column Info	*/
	private String mfag = null;
	/*	Column Info	*/
	private String espn = null;
	/*	Column Info	*/
	private String pollutant = null;
	/*	Column Info	*/
	private String imoLimit = null;
	/*	Column Info	*/
	private String groswgt = null;
	/*	Column Info	*/
	private String grosswgtUnit = null;
	/*	Column Info	*/
	private String netwgt = null;
	/*	Column Info	*/
	private String netwgtUnit = null;
	/*	Column Info	*/
	private String vol = null;
	/*	Column Info	*/
	private String volUnit = null;
	/*	Column Info	*/
	private String remark = null;
	/*	Column Info	*/
	private String contact = null;
	/*	Column Info	*/
	private String phone = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public FlatFilePartnerLineVO(){}

	public FlatFilePartnerLineVO(String ibflag,String pagerows,String bkgnbr,String bkgDt,String brac,String refnbr,String vslCallsign,String vslLloydcode,String vslFullname,String vvdRefNo,String consortVoy,String polCd,String polNm,String podCd,String podNm,String pldCd,String pldNm,String rdtyp,String partyTp,String partyCd,String cntrSeq,String cntrNo,String cntrTpsz,String imex,String itemSeq,String dgRef,String opkgQty,String opkgTp,String opkgDesc,String mpkgQty,String mpkgTp,String mpkgDesc,String ipkgQty,String ipkgTp,String ipkgDesc,String hazCont,String propShipNm,String techNm,String imoClass,String imoPage,String unNbr,String unNbrSeq,String cfrNbr,String flash,String flashUnit,String pkgGroup,String emsNbr,String mfag,String espn,String pollutant,String imoLimit,String groswgt,String grosswgtUnit,String netwgt,String netwgtUnit,String vol,String volUnit,String remark,String contact,String phone)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.bkgnbr = bkgnbr;
		this.bkgDt = bkgDt;
		this.brac = brac;
		this.refnbr = refnbr;
		this.vslCallsign = vslCallsign;
		this.vslLloydcode = vslLloydcode;
		this.vslFullname = vslFullname;
		this.vvdRefNo = vvdRefNo;
		this.consortVoy = consortVoy;
		this.polCd = polCd;
		this.polNm = polNm;
		this.podCd = podCd;
		this.podNm = podNm;
		this.pldCd = pldCd;
		this.pldNm = pldNm;
		this.rdtyp = rdtyp;
		this.partyTp = partyTp;
		this.partyCd = partyCd;
		this.cntrSeq = cntrSeq;
		this.cntrNo = cntrNo;
		this.cntrTpsz = cntrTpsz;
		this.imex = imex;
		this.itemSeq = itemSeq;
		this.dgRef = dgRef;
		this.opkgQty = opkgQty;
		this.opkgTp = opkgTp;
		this.opkgDesc = opkgDesc;
		this.mpkgQty = mpkgQty;
		this.mpkgTp = mpkgTp;
		this.mpkgDesc = mpkgDesc;
		this.ipkgQty = ipkgQty;
		this.ipkgTp = ipkgTp;
		this.ipkgDesc = ipkgDesc;
		this.hazCont = hazCont;
		this.propShipNm = propShipNm;
		this.techNm = techNm;
		this.imoClass = imoClass;
		this.imoPage = imoPage;
		this.unNbr = unNbr;
		this.unNbrSeq = unNbrSeq;
		this.cfrNbr = cfrNbr;
		this.flash = flash;
		this.flashUnit = flashUnit;
		this.pkgGroup = pkgGroup;
		this.emsNbr = emsNbr;
		this.mfag = mfag;
		this.espn = espn;
		this.pollutant = pollutant;
		this.imoLimit = imoLimit;
		this.groswgt = groswgt;
		this.grosswgtUnit = grosswgtUnit;
		this.netwgt = netwgt;
		this.netwgtUnit = netwgtUnit;
		this.vol = vol;
		this.volUnit = volUnit;
		this.remark = remark;
		this.contact = contact;
		this.phone = phone;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkgnbr", getBkgnbr());
		this.hashColumns.put("bkg_dt", getBkgDt());
		this.hashColumns.put("brac", getBrac());
		this.hashColumns.put("refnbr", getRefnbr());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("vsl_lloydcode", getVslLloydcode());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("vvd_ref_no", getVvdRefNo());
		this.hashColumns.put("consort_voy", getConsortVoy());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("pld_cd", getPldCd());
		this.hashColumns.put("pld_nm", getPldNm());
		this.hashColumns.put("rdtyp", getRdtyp());
		this.hashColumns.put("party_tp", getPartyTp());
		this.hashColumns.put("party_cd", getPartyCd());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz", getCntrTpsz());
		this.hashColumns.put("imex", getImex());
		this.hashColumns.put("item_seq", getItemSeq());
		this.hashColumns.put("dg_ref", getDgRef());
		this.hashColumns.put("opkg_qty", getOpkgQty());
		this.hashColumns.put("opkg_tp", getOpkgTp());
		this.hashColumns.put("opkg_desc", getOpkgDesc());
		this.hashColumns.put("mpkg_qty", getMpkgQty());
		this.hashColumns.put("mpkg_tp", getMpkgTp());
		this.hashColumns.put("mpkg_desc", getMpkgDesc());
		this.hashColumns.put("ipkg_qty", getIpkgQty());
		this.hashColumns.put("ipkg_tp", getIpkgTp());
		this.hashColumns.put("ipkg_desc", getIpkgDesc());
		this.hashColumns.put("haz_cont", getHazCont());
		this.hashColumns.put("prop_ship_nm", getPropShipNm());
		this.hashColumns.put("tech_nm", getTechNm());
		this.hashColumns.put("imo_class", getImoClass());
		this.hashColumns.put("imo_page", getImoPage());
		this.hashColumns.put("un_nbr", getUnNbr());
		this.hashColumns.put("un_nbr_seq", getUnNbrSeq());
		this.hashColumns.put("cfr_nbr", getCfrNbr());
		this.hashColumns.put("flash", getFlash());
		this.hashColumns.put("flash_unit", getFlashUnit());
		this.hashColumns.put("pkg_group", getPkgGroup());
		this.hashColumns.put("ems_nbr", getEmsNbr());
		this.hashColumns.put("mfag", getMfag());
		this.hashColumns.put("espn", getEspn());
		this.hashColumns.put("pollutant", getPollutant());
		this.hashColumns.put("imo_limit", getImoLimit());
		this.hashColumns.put("groswgt", getGroswgt());
		this.hashColumns.put("grosswgt_unit", getGrosswgtUnit());
		this.hashColumns.put("netwgt", getNetwgt());
		this.hashColumns.put("netwgt_unit", getNetwgtUnit());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("vol_unit", getVolUnit());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("contact", getContact());
		this.hashColumns.put("phone", getPhone());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkgnbr", "bkgnbr");
		this.hashFields.put("bkg_dt", "bkgDt");
		this.hashFields.put("brac", "brac");
		this.hashFields.put("refnbr", "refnbr");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("vsl_lloydcode", "vslLloydcode");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("vvd_ref_no", "vvdRefNo");
		this.hashFields.put("consort_voy", "consortVoy");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("pld_cd", "pldCd");
		this.hashFields.put("pld_nm", "pldNm");
		this.hashFields.put("rdtyp", "rdtyp");
		this.hashFields.put("party_tp", "partyTp");
		this.hashFields.put("party_cd", "partyCd");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz", "cntrTpsz");
		this.hashFields.put("imex", "imex");
		this.hashFields.put("item_seq", "itemSeq");
		this.hashFields.put("dg_ref", "dgRef");
		this.hashFields.put("opkg_qty", "opkgQty");
		this.hashFields.put("opkg_tp", "opkgTp");
		this.hashFields.put("opkg_desc", "opkgDesc");
		this.hashFields.put("mpkg_qty", "mpkgQty");
		this.hashFields.put("mpkg_tp", "mpkgTp");
		this.hashFields.put("mpkg_desc", "mpkgDesc");
		this.hashFields.put("ipkg_qty", "ipkgQty");
		this.hashFields.put("ipkg_tp", "ipkgTp");
		this.hashFields.put("ipkg_desc", "ipkgDesc");
		this.hashFields.put("haz_cont", "hazCont");
		this.hashFields.put("prop_ship_nm", "propShipNm");
		this.hashFields.put("tech_nm", "techNm");
		this.hashFields.put("imo_class", "imoClass");
		this.hashFields.put("imo_page", "imoPage");
		this.hashFields.put("un_nbr", "unNbr");
		this.hashFields.put("un_nbr_seq", "unNbrSeq");
		this.hashFields.put("cfr_nbr", "cfrNbr");
		this.hashFields.put("flash", "flash");
		this.hashFields.put("flash_unit", "flashUnit");
		this.hashFields.put("pkg_group", "pkgGroup");
		this.hashFields.put("ems_nbr", "emsNbr");
		this.hashFields.put("mfag", "mfag");
		this.hashFields.put("espn", "espn");
		this.hashFields.put("pollutant", "pollutant");
		this.hashFields.put("imo_limit", "imoLimit");
		this.hashFields.put("groswgt", "groswgt");
		this.hashFields.put("grosswgt_unit", "grosswgtUnit");
		this.hashFields.put("netwgt", "netwgt");
		this.hashFields.put("netwgt_unit", "netwgtUnit");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("vol_unit", "volUnit");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("contact", "contact");
		this.hashFields.put("phone", "phone");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return bkgnbr
	 */
	public	String getBkgnbr() {
		return	this.bkgnbr;
	}

	/**
	 * Column Info
	 * @return bkgDt
	 */
	public	String getBkgDt() {
		return	this.bkgDt;
	}

	/**
	 * Column Info
	 * @return brac
	 */
	public	String getBrac() {
		return	this.brac;
	}

	/**
	 * Column Info
	 * @return refnbr
	 */
	public	String getRefnbr() {
		return	this.refnbr;
	}

	/**
	 * Column Info
	 * @return vslCallsign
	 */
	public	String getVslCallsign() {
		return	this.vslCallsign;
	}

	/**
	 * Column Info
	 * @return vslLloydcode
	 */
	public	String getVslLloydcode() {
		return	this.vslLloydcode;
	}

	/**
	 * Column Info
	 * @return vslFullname
	 */
	public	String getVslFullname() {
		return	this.vslFullname;
	}

	/**
	 * Column Info
	 * @return vvdRefNo
	 */
	public	String getVvdRefNo() {
		return	this.vvdRefNo;
	}

	/**
	 * Column Info
	 * @return consortVoy
	 */
	public	String getConsortVoy() {
		return	this.consortVoy;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public	String getPolCd() {
		return	this.polCd;
	}

	/**
	 * Column Info
	 * @return polNm
	 */
	public	String getPolNm() {
		return	this.polNm;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public	String getPodCd() {
		return	this.podCd;
	}

	/**
	 * Column Info
	 * @return podNm
	 */
	public	String getPodNm() {
		return	this.podNm;
	}

	/**
	 * Column Info
	 * @return pldCd
	 */
	public	String getPldCd() {
		return	this.pldCd;
	}

	/**
	 * Column Info
	 * @return pldNm
	 */
	public	String getPldNm() {
		return	this.pldNm;
	}

	/**
	 * Column Info
	 * @return rdtyp
	 */
	public	String getRdtyp() {
		return	this.rdtyp;
	}

	/**
	 * Column Info
	 * @return partyTp
	 */
	public	String getPartyTp() {
		return	this.partyTp;
	}

	/**
	 * Column Info
	 * @return partyCd
	 */
	public	String getPartyCd() {
		return	this.partyCd;
	}

	/**
	 * Column Info
	 * @return cntrSeq
	 */
	public	String getCntrSeq() {
		return	this.cntrSeq;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public	String getCntrNo() {
		return	this.cntrNo;
	}

	/**
	 * Column Info
	 * @return cntrTpsz
	 */
	public	String getCntrTpsz() {
		return	this.cntrTpsz;
	}

	/**
	 * Column Info
	 * @return imex
	 */
	public	String getImex() {
		return	this.imex;
	}

	/**
	 * Column Info
	 * @return itemSeq
	 */
	public	String getItemSeq() {
		return	this.itemSeq;
	}

	/**
	 * Column Info
	 * @return dgRef
	 */
	public	String getDgRef() {
		return	this.dgRef;
	}

	/**
	 * Column Info
	 * @return opkgQty
	 */
	public	String getOpkgQty() {
		return	this.opkgQty;
	}

	/**
	 * Column Info
	 * @return opkgTp
	 */
	public	String getOpkgTp() {
		return	this.opkgTp;
	}

	/**
	 * Column Info
	 * @return opkgDesc
	 */
	public	String getOpkgDesc() {
		return	this.opkgDesc;
	}

	/**
	 * Column Info
	 * @return mpkgQty
	 */
	public	String getMpkgQty() {
		return	this.mpkgQty;
	}

	/**
	 * Column Info
	 * @return mpkgTp
	 */
	public	String getMpkgTp() {
		return	this.mpkgTp;
	}

	/**
	 * Column Info
	 * @return mpkgDesc
	 */
	public	String getMpkgDesc() {
		return	this.mpkgDesc;
	}

	/**
	 * Column Info
	 * @return ipkgQty
	 */
	public	String getIpkgQty() {
		return	this.ipkgQty;
	}

	/**
	 * Column Info
	 * @return ipkgTp
	 */
	public	String getIpkgTp() {
		return	this.ipkgTp;
	}

	/**
	 * Column Info
	 * @return ipkgDesc
	 */
	public	String getIpkgDesc() {
		return	this.ipkgDesc;
	}

	/**
	 * Column Info
	 * @return hazCont
	 */
	public	String getHazCont() {
		return	this.hazCont;
	}

	/**
	 * Column Info
	 * @return propShipNm
	 */
	public	String getPropShipNm() {
		return	this.propShipNm;
	}

	/**
	 * Column Info
	 * @return techNm
	 */
	public	String getTechNm() {
		return	this.techNm;
	}

	/**
	 * Column Info
	 * @return imoClass
	 */
	public	String getImoClass() {
		return	this.imoClass;
	}

	/**
	 * Column Info
	 * @return imoPage
	 */
	public	String getImoPage() {
		return	this.imoPage;
	}

	/**
	 * Column Info
	 * @return unNbr
	 */
	public	String getUnNbr() {
		return	this.unNbr;
	}

	/**
	 * Column Info
	 * @return unNbrSeq
	 */
	public	String getUnNbrSeq() {
		return	this.unNbrSeq;
	}

	/**
	 * Column Info
	 * @return cfrNbr
	 */
	public	String getCfrNbr() {
		return	this.cfrNbr;
	}

	/**
	 * Column Info
	 * @return flash
	 */
	public	String getFlash() {
		return	this.flash;
	}

	/**
	 * Column Info
	 * @return flashUnit
	 */
	public	String getFlashUnit() {
		return	this.flashUnit;
	}

	/**
	 * Column Info
	 * @return pkgGroup
	 */
	public	String getPkgGroup() {
		return	this.pkgGroup;
	}

	/**
	 * Column Info
	 * @return emsNbr
	 */
	public	String getEmsNbr() {
		return	this.emsNbr;
	}

	/**
	 * Column Info
	 * @return mfag
	 */
	public	String getMfag() {
		return	this.mfag;
	}

	/**
	 * Column Info
	 * @return espn
	 */
	public	String getEspn() {
		return	this.espn;
	}

	/**
	 * Column Info
	 * @return pollutant
	 */
	public	String getPollutant() {
		return	this.pollutant;
	}

	/**
	 * Column Info
	 * @return imoLimit
	 */
	public	String getImoLimit() {
		return	this.imoLimit;
	}

	/**
	 * Column Info
	 * @return groswgt
	 */
	public	String getGroswgt() {
		return	this.groswgt;
	}

	/**
	 * Column Info
	 * @return grosswgtUnit
	 */
	public	String getGrosswgtUnit() {
		return	this.grosswgtUnit;
	}

	/**
	 * Column Info
	 * @return netwgt
	 */
	public	String getNetwgt() {
		return	this.netwgt;
	}

	/**
	 * Column Info
	 * @return netwgtUnit
	 */
	public	String getNetwgtUnit() {
		return	this.netwgtUnit;
	}

	/**
	 * Column Info
	 * @return vol
	 */
	public	String getVol() {
		return	this.vol;
	}

	/**
	 * Column Info
	 * @return volUnit
	 */
	public	String getVolUnit() {
		return	this.volUnit;
	}

	/**
	 * Column Info
	 * @return remark
	 */
	public	String getRemark() {
		return	this.remark;
	}

	/**
	 * Column Info
	 * @return contact
	 */
	public	String getContact() {
		return	this.contact;
	}

	/**
	 * Column Info
	 * @return phone
	 */
	public	String getPhone() {
		return	this.phone;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  bkgnbr
 	 */
	public void	setBkgnbr(String bkgnbr ) {
		this.bkgnbr =	bkgnbr;
	}
 	/**
	 * Column Info
	 * @param  bkgDt
 	 */
	public void	setBkgDt(String bkgDt ) {
		this.bkgDt =	bkgDt;
	}
 	/**
	 * Column Info
	 * @param  brac
 	 */
	public void	setBrac(String brac ) {
		this.brac =	brac;
	}
 	/**
	 * Column Info
	 * @param  refnbr
 	 */
	public void	setRefnbr(String refnbr ) {
		this.refnbr =	refnbr;
	}
 	/**
	 * Column Info
	 * @param  vslCallsign
 	 */
	public void	setVslCallsign(String vslCallsign ) {
		this.vslCallsign =	vslCallsign;
	}
 	/**
	 * Column Info
	 * @param  vslLloydcode
 	 */
	public void	setVslLloydcode(String vslLloydcode ) {
		this.vslLloydcode =	vslLloydcode;
	}
 	/**
	 * Column Info
	 * @param  vslFullname
 	 */
	public void	setVslFullname(String vslFullname ) {
		this.vslFullname =	vslFullname;
	}
 	/**
	 * Column Info
	 * @param  vvdRefNo
 	 */
	public void	setVvdRefNo(String vvdRefNo ) {
		this.vvdRefNo =	vvdRefNo;
	}
 	/**
	 * Column Info
	 * @param  consortVoy
 	 */
	public void	setConsortVoy(String consortVoy ) {
		this.consortVoy =	consortVoy;
	}
 	/**
	 * Column Info
	 * @param  polCd
 	 */
	public void	setPolCd(String polCd ) {
		this.polCd =	polCd;
	}
 	/**
	 * Column Info
	 * @param  polNm
 	 */
	public void	setPolNm(String polNm ) {
		this.polNm =	polNm;
	}
 	/**
	 * Column Info
	 * @param  podCd
 	 */
	public void	setPodCd(String podCd ) {
		this.podCd =	podCd;
	}
 	/**
	 * Column Info
	 * @param  podNm
 	 */
	public void	setPodNm(String podNm ) {
		this.podNm =	podNm;
	}
 	/**
	 * Column Info
	 * @param  pldCd
 	 */
	public void	setPldCd(String pldCd ) {
		this.pldCd =	pldCd;
	}
 	/**
	 * Column Info
	 * @param  pldNm
 	 */
	public void	setPldNm(String pldNm ) {
		this.pldNm =	pldNm;
	}
 	/**
	 * Column Info
	 * @param  rdtyp
 	 */
	public void	setRdtyp(String rdtyp ) {
		this.rdtyp =	rdtyp;
	}
 	/**
	 * Column Info
	 * @param  partyTp
 	 */
	public void	setPartyTp(String partyTp ) {
		this.partyTp =	partyTp;
	}
 	/**
	 * Column Info
	 * @param  partyCd
 	 */
	public void	setPartyCd(String partyCd ) {
		this.partyCd =	partyCd;
	}
 	/**
	 * Column Info
	 * @param  cntrSeq
 	 */
	public void	setCntrSeq(String cntrSeq ) {
		this.cntrSeq =	cntrSeq;
	}
 	/**
	 * Column Info
	 * @param  cntrNo
 	 */
	public void	setCntrNo(String cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 	/**
	 * Column Info
	 * @param  cntrTpsz
 	 */
	public void	setCntrTpsz(String cntrTpsz ) {
		this.cntrTpsz =	cntrTpsz;
	}
 	/**
	 * Column Info
	 * @param  imex
 	 */
	public void	setImex(String imex ) {
		this.imex =	imex;
	}
 	/**
	 * Column Info
	 * @param  itemSeq
 	 */
	public void	setItemSeq(String itemSeq ) {
		this.itemSeq =	itemSeq;
	}
 	/**
	 * Column Info
	 * @param  dgRef
 	 */
	public void	setDgRef(String dgRef ) {
		this.dgRef =	dgRef;
	}
 	/**
	 * Column Info
	 * @param  opkgQty
 	 */
	public void	setOpkgQty(String opkgQty ) {
		this.opkgQty =	opkgQty;
	}
 	/**
	 * Column Info
	 * @param  opkgTp
 	 */
	public void	setOpkgTp(String opkgTp ) {
		this.opkgTp =	opkgTp;
	}
 	/**
	 * Column Info
	 * @param  opkgDesc
 	 */
	public void	setOpkgDesc(String opkgDesc ) {
		this.opkgDesc =	opkgDesc;
	}
 	/**
	 * Column Info
	 * @param  mpkgQty
 	 */
	public void	setMpkgQty(String mpkgQty ) {
		this.mpkgQty =	mpkgQty;
	}
 	/**
	 * Column Info
	 * @param  mpkgTp
 	 */
	public void	setMpkgTp(String mpkgTp ) {
		this.mpkgTp =	mpkgTp;
	}
 	/**
	 * Column Info
	 * @param  mpkgDesc
 	 */
	public void	setMpkgDesc(String mpkgDesc ) {
		this.mpkgDesc =	mpkgDesc;
	}
 	/**
	 * Column Info
	 * @param  ipkgQty
 	 */
	public void	setIpkgQty(String ipkgQty ) {
		this.ipkgQty =	ipkgQty;
	}
 	/**
	 * Column Info
	 * @param  ipkgTp
 	 */
	public void	setIpkgTp(String ipkgTp ) {
		this.ipkgTp =	ipkgTp;
	}
 	/**
	 * Column Info
	 * @param  ipkgDesc
 	 */
	public void	setIpkgDesc(String ipkgDesc ) {
		this.ipkgDesc =	ipkgDesc;
	}
 	/**
	 * Column Info
	 * @param  hazCont
 	 */
	public void	setHazCont(String hazCont ) {
		this.hazCont =	hazCont;
	}
 	/**
	 * Column Info
	 * @param  propShipNm
 	 */
	public void	setPropShipNm(String propShipNm ) {
		this.propShipNm =	propShipNm;
	}
 	/**
	 * Column Info
	 * @param  techNm
 	 */
	public void	setTechNm(String techNm ) {
		this.techNm =	techNm;
	}
 	/**
	 * Column Info
	 * @param  imoClass
 	 */
	public void	setImoClass(String imoClass ) {
		this.imoClass =	imoClass;
	}
 	/**
	 * Column Info
	 * @param  imoPage
 	 */
	public void	setImoPage(String imoPage ) {
		this.imoPage =	imoPage;
	}
 	/**
	 * Column Info
	 * @param  unNbr
 	 */
	public void	setUnNbr(String unNbr ) {
		this.unNbr =	unNbr;
	}
 	/**
	 * Column Info
	 * @param  unNbrSeq
 	 */
	public void	setUnNbrSeq(String unNbrSeq ) {
		this.unNbrSeq =	unNbrSeq;
	}
 	/**
	 * Column Info
	 * @param  cfrNbr
 	 */
	public void	setCfrNbr(String cfrNbr ) {
		this.cfrNbr =	cfrNbr;
	}
 	/**
	 * Column Info
	 * @param  flash
 	 */
	public void	setFlash(String flash ) {
		this.flash =	flash;
	}
 	/**
	 * Column Info
	 * @param  flashUnit
 	 */
	public void	setFlashUnit(String flashUnit ) {
		this.flashUnit =	flashUnit;
	}
 	/**
	 * Column Info
	 * @param  pkgGroup
 	 */
	public void	setPkgGroup(String pkgGroup ) {
		this.pkgGroup =	pkgGroup;
	}
 	/**
	 * Column Info
	 * @param  emsNbr
 	 */
	public void	setEmsNbr(String emsNbr ) {
		this.emsNbr =	emsNbr;
	}
 	/**
	 * Column Info
	 * @param  mfag
 	 */
	public void	setMfag(String mfag ) {
		this.mfag =	mfag;
	}
 	/**
	 * Column Info
	 * @param  espn
 	 */
	public void	setEspn(String espn ) {
		this.espn =	espn;
	}
 	/**
	 * Column Info
	 * @param  pollutant
 	 */
	public void	setPollutant(String pollutant ) {
		this.pollutant =	pollutant;
	}
 	/**
	 * Column Info
	 * @param  imoLimit
 	 */
	public void	setImoLimit(String imoLimit ) {
		this.imoLimit =	imoLimit;
	}
 	/**
	 * Column Info
	 * @param  groswgt
 	 */
	public void	setGroswgt(String groswgt ) {
		this.groswgt =	groswgt;
	}
 	/**
	 * Column Info
	 * @param  grosswgtUnit
 	 */
	public void	setGrosswgtUnit(String grosswgtUnit ) {
		this.grosswgtUnit =	grosswgtUnit;
	}
 	/**
	 * Column Info
	 * @param  netwgt
 	 */
	public void	setNetwgt(String netwgt ) {
		this.netwgt =	netwgt;
	}
 	/**
	 * Column Info
	 * @param  netwgtUnit
 	 */
	public void	setNetwgtUnit(String netwgtUnit ) {
		this.netwgtUnit =	netwgtUnit;
	}
 	/**
	 * Column Info
	 * @param  vol
 	 */
	public void	setVol(String vol ) {
		this.vol =	vol;
	}
 	/**
	 * Column Info
	 * @param  volUnit
 	 */
	public void	setVolUnit(String volUnit ) {
		this.volUnit =	volUnit;
	}
 	/**
	 * Column Info
	 * @param  remark
 	 */
	public void	setRemark(String remark ) {
		this.remark =	remark;
	}
 	/**
	 * Column Info
	 * @param  contact
 	 */
	public void	setContact(String contact ) {
		this.contact =	contact;
	}
 	/**
	 * Column Info
	 * @param  phone
 	 */
	public void	setPhone(String phone ) {
		this.phone =	phone;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setBkgnbr(JSPUtil.getParameter(request,	prefix + "bkgnbr", ""));
		setBkgDt(JSPUtil.getParameter(request,	prefix + "bkg_dt", ""));
		setBrac(JSPUtil.getParameter(request,	prefix + "brac", ""));
		setRefnbr(JSPUtil.getParameter(request,	prefix + "refnbr", ""));
		setVslCallsign(JSPUtil.getParameter(request,	prefix + "vsl_callsign", ""));
		setVslLloydcode(JSPUtil.getParameter(request,	prefix + "vsl_lloydcode", ""));
		setVslFullname(JSPUtil.getParameter(request,	prefix + "vsl_fullname", ""));
		setVvdRefNo(JSPUtil.getParameter(request,	prefix + "vvd_ref_no", ""));
		setConsortVoy(JSPUtil.getParameter(request,	prefix + "consort_voy", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setPolNm(JSPUtil.getParameter(request,	prefix + "pol_nm", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setPodNm(JSPUtil.getParameter(request,	prefix + "pod_nm", ""));
		setPldCd(JSPUtil.getParameter(request,	prefix + "pld_cd", ""));
		setPldNm(JSPUtil.getParameter(request,	prefix + "pld_nm", ""));
		setRdtyp(JSPUtil.getParameter(request,	prefix + "rdtyp", ""));
		setPartyTp(JSPUtil.getParameter(request,	prefix + "party_tp", ""));
		setPartyCd(JSPUtil.getParameter(request,	prefix + "party_cd", ""));
		setCntrSeq(JSPUtil.getParameter(request,	prefix + "cntr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCntrTpsz(JSPUtil.getParameter(request,	prefix + "cntr_tpsz", ""));
		setImex(JSPUtil.getParameter(request,	prefix + "imex", ""));
		setItemSeq(JSPUtil.getParameter(request,	prefix + "item_seq", ""));
		setDgRef(JSPUtil.getParameter(request,	prefix + "dg_ref", ""));
		setOpkgQty(JSPUtil.getParameter(request,	prefix + "opkg_qty", ""));
		setOpkgTp(JSPUtil.getParameter(request,	prefix + "opkg_tp", ""));
		setOpkgDesc(JSPUtil.getParameter(request,	prefix + "opkg_desc", ""));
		setMpkgQty(JSPUtil.getParameter(request,	prefix + "mpkg_qty", ""));
		setMpkgTp(JSPUtil.getParameter(request,	prefix + "mpkg_tp", ""));
		setMpkgDesc(JSPUtil.getParameter(request,	prefix + "mpkg_desc", ""));
		setIpkgQty(JSPUtil.getParameter(request,	prefix + "ipkg_qty", ""));
		setIpkgTp(JSPUtil.getParameter(request,	prefix + "ipkg_tp", ""));
		setIpkgDesc(JSPUtil.getParameter(request,	prefix + "ipkg_desc", ""));
		setHazCont(JSPUtil.getParameter(request,	prefix + "haz_cont", ""));
		setPropShipNm(JSPUtil.getParameter(request,	prefix + "prop_ship_nm", ""));
		setTechNm(JSPUtil.getParameter(request,	prefix + "tech_nm", ""));
		setImoClass(JSPUtil.getParameter(request,	prefix + "imo_class", ""));
		setImoPage(JSPUtil.getParameter(request,	prefix + "imo_page", ""));
		setUnNbr(JSPUtil.getParameter(request,	prefix + "un_nbr", ""));
		setUnNbrSeq(JSPUtil.getParameter(request,	prefix + "un_nbr_seq", ""));
		setCfrNbr(JSPUtil.getParameter(request,	prefix + "cfr_nbr", ""));
		setFlash(JSPUtil.getParameter(request,	prefix + "flash", ""));
		setFlashUnit(JSPUtil.getParameter(request,	prefix + "flash_unit", ""));
		setPkgGroup(JSPUtil.getParameter(request,	prefix + "pkg_group", ""));
		setEmsNbr(JSPUtil.getParameter(request,	prefix + "ems_nbr", ""));
		setMfag(JSPUtil.getParameter(request,	prefix + "mfag", ""));
		setEspn(JSPUtil.getParameter(request,	prefix + "espn", ""));
		setPollutant(JSPUtil.getParameter(request,	prefix + "pollutant", ""));
		setImoLimit(JSPUtil.getParameter(request,	prefix + "imo_limit", ""));
		setGroswgt(JSPUtil.getParameter(request,	prefix + "groswgt", ""));
		setGrosswgtUnit(JSPUtil.getParameter(request,	prefix + "grosswgt_unit", ""));
		setNetwgt(JSPUtil.getParameter(request,	prefix + "netwgt", ""));
		setNetwgtUnit(JSPUtil.getParameter(request,	prefix + "netwgt_unit", ""));
		setVol(JSPUtil.getParameter(request,	prefix + "vol", ""));
		setVolUnit(JSPUtil.getParameter(request,	prefix + "vol_unit", ""));
		setRemark(JSPUtil.getParameter(request,	prefix + "remark", ""));
		setContact(JSPUtil.getParameter(request,	prefix + "contact", ""));
		setPhone(JSPUtil.getParameter(request,	prefix + "phone", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FlatFilePartnerLineVO[]
	 */
	public FlatFilePartnerLineVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FlatFilePartnerLineVO[]
	 */
	public FlatFilePartnerLineVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		FlatFilePartnerLineVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] bkgnbr =	(JSPUtil.getParameter(request, prefix +	"bkgnbr",	length));
			String[] bkgDt =	(JSPUtil.getParameter(request, prefix +	"bkg_dt",	length));
			String[] brac =	(JSPUtil.getParameter(request, prefix +	"brac",	length));
			String[] refnbr =	(JSPUtil.getParameter(request, prefix +	"refnbr",	length));
			String[] vslCallsign =	(JSPUtil.getParameter(request, prefix +	"vsl_callsign",	length));
			String[] vslLloydcode =	(JSPUtil.getParameter(request, prefix +	"vsl_lloydcode",	length));
			String[] vslFullname =	(JSPUtil.getParameter(request, prefix +	"vsl_fullname",	length));
			String[] vvdRefNo =	(JSPUtil.getParameter(request, prefix +	"vvd_ref_no",	length));
			String[] consortVoy =	(JSPUtil.getParameter(request, prefix +	"consort_voy",	length));
			String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd",	length));
			String[] polNm =	(JSPUtil.getParameter(request, prefix +	"pol_nm",	length));
			String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd",	length));
			String[] podNm =	(JSPUtil.getParameter(request, prefix +	"pod_nm",	length));
			String[] pldCd =	(JSPUtil.getParameter(request, prefix +	"pld_cd",	length));
			String[] pldNm =	(JSPUtil.getParameter(request, prefix +	"pld_nm",	length));
			String[] rdtyp =	(JSPUtil.getParameter(request, prefix +	"rdtyp",	length));
			String[] partyTp =	(JSPUtil.getParameter(request, prefix +	"party_tp",	length));
			String[] partyCd =	(JSPUtil.getParameter(request, prefix +	"party_cd",	length));
			String[] cntrSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_seq",	length));
			String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no",	length));
			String[] cntrTpsz =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz",	length));
			String[] imex =	(JSPUtil.getParameter(request, prefix +	"imex",	length));
			String[] itemSeq =	(JSPUtil.getParameter(request, prefix +	"item_seq",	length));
			String[] dgRef =	(JSPUtil.getParameter(request, prefix +	"dg_ref",	length));
			String[] opkgQty =	(JSPUtil.getParameter(request, prefix +	"opkg_qty",	length));
			String[] opkgTp =	(JSPUtil.getParameter(request, prefix +	"opkg_tp",	length));
			String[] opkgDesc =	(JSPUtil.getParameter(request, prefix +	"opkg_desc",	length));
			String[] mpkgQty =	(JSPUtil.getParameter(request, prefix +	"mpkg_qty",	length));
			String[] mpkgTp =	(JSPUtil.getParameter(request, prefix +	"mpkg_tp",	length));
			String[] mpkgDesc =	(JSPUtil.getParameter(request, prefix +	"mpkg_desc",	length));
			String[] ipkgQty =	(JSPUtil.getParameter(request, prefix +	"ipkg_qty",	length));
			String[] ipkgTp =	(JSPUtil.getParameter(request, prefix +	"ipkg_tp",	length));
			String[] ipkgDesc =	(JSPUtil.getParameter(request, prefix +	"ipkg_desc",	length));
			String[] hazCont =	(JSPUtil.getParameter(request, prefix +	"haz_cont",	length));
			String[] propShipNm =	(JSPUtil.getParameter(request, prefix +	"prop_ship_nm",	length));
			String[] techNm =	(JSPUtil.getParameter(request, prefix +	"tech_nm",	length));
			String[] imoClass =	(JSPUtil.getParameter(request, prefix +	"imo_class",	length));
			String[] imoPage =	(JSPUtil.getParameter(request, prefix +	"imo_page",	length));
			String[] unNbr =	(JSPUtil.getParameter(request, prefix +	"un_nbr",	length));
			String[] unNbrSeq =	(JSPUtil.getParameter(request, prefix +	"un_nbr_seq",	length));
			String[] cfrNbr =	(JSPUtil.getParameter(request, prefix +	"cfr_nbr",	length));
			String[] flash =	(JSPUtil.getParameter(request, prefix +	"flash",	length));
			String[] flashUnit =	(JSPUtil.getParameter(request, prefix +	"flash_unit",	length));
			String[] pkgGroup =	(JSPUtil.getParameter(request, prefix +	"pkg_group",	length));
			String[] emsNbr =	(JSPUtil.getParameter(request, prefix +	"ems_nbr",	length));
			String[] mfag =	(JSPUtil.getParameter(request, prefix +	"mfag",	length));
			String[] espn =	(JSPUtil.getParameter(request, prefix +	"espn",	length));
			String[] pollutant =	(JSPUtil.getParameter(request, prefix +	"pollutant",	length));
			String[] imoLimit =	(JSPUtil.getParameter(request, prefix +	"imo_limit",	length));
			String[] groswgt =	(JSPUtil.getParameter(request, prefix +	"groswgt",	length));
			String[] grosswgtUnit =	(JSPUtil.getParameter(request, prefix +	"grosswgt_unit",	length));
			String[] netwgt =	(JSPUtil.getParameter(request, prefix +	"netwgt",	length));
			String[] netwgtUnit =	(JSPUtil.getParameter(request, prefix +	"netwgt_unit",	length));
			String[] vol =	(JSPUtil.getParameter(request, prefix +	"vol",	length));
			String[] volUnit =	(JSPUtil.getParameter(request, prefix +	"vol_unit",	length));
			String[] remark =	(JSPUtil.getParameter(request, prefix +	"remark",	length));
			String[] contact =	(JSPUtil.getParameter(request, prefix +	"contact",	length));
			String[] phone =	(JSPUtil.getParameter(request, prefix +	"phone",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	FlatFilePartnerLineVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( bkgnbr[i] !=	null)
					model.setBkgnbr( bkgnbr[i]);
				if ( bkgDt[i] !=	null)
					model.setBkgDt( bkgDt[i]);
				if ( brac[i] !=	null)
					model.setBrac( brac[i]);
				if ( refnbr[i] !=	null)
					model.setRefnbr( refnbr[i]);
				if ( vslCallsign[i] !=	null)
					model.setVslCallsign( vslCallsign[i]);
				if ( vslLloydcode[i] !=	null)
					model.setVslLloydcode( vslLloydcode[i]);
				if ( vslFullname[i] !=	null)
					model.setVslFullname( vslFullname[i]);
				if ( vvdRefNo[i] !=	null)
					model.setVvdRefNo( vvdRefNo[i]);
				if ( consortVoy[i] !=	null)
					model.setConsortVoy( consortVoy[i]);
				if ( polCd[i] !=	null)
					model.setPolCd( polCd[i]);
				if ( polNm[i] !=	null)
					model.setPolNm( polNm[i]);
				if ( podCd[i] !=	null)
					model.setPodCd( podCd[i]);
				if ( podNm[i] !=	null)
					model.setPodNm( podNm[i]);
				if ( pldCd[i] !=	null)
					model.setPldCd( pldCd[i]);
				if ( pldNm[i] !=	null)
					model.setPldNm( pldNm[i]);
				if ( rdtyp[i] !=	null)
					model.setRdtyp( rdtyp[i]);
				if ( partyTp[i] !=	null)
					model.setPartyTp( partyTp[i]);
				if ( partyCd[i] !=	null)
					model.setPartyCd( partyCd[i]);
				if ( cntrSeq[i] !=	null)
					model.setCntrSeq( cntrSeq[i]);
				if ( cntrNo[i] !=	null)
					model.setCntrNo( cntrNo[i]);
				if ( cntrTpsz[i] !=	null)
					model.setCntrTpsz( cntrTpsz[i]);
				if ( imex[i] !=	null)
					model.setImex( imex[i]);
				if ( itemSeq[i] !=	null)
					model.setItemSeq( itemSeq[i]);
				if ( dgRef[i] !=	null)
					model.setDgRef( dgRef[i]);
				if ( opkgQty[i] !=	null)
					model.setOpkgQty( opkgQty[i]);
				if ( opkgTp[i] !=	null)
					model.setOpkgTp( opkgTp[i]);
				if ( opkgDesc[i] !=	null)
					model.setOpkgDesc( opkgDesc[i]);
				if ( mpkgQty[i] !=	null)
					model.setMpkgQty( mpkgQty[i]);
				if ( mpkgTp[i] !=	null)
					model.setMpkgTp( mpkgTp[i]);
				if ( mpkgDesc[i] !=	null)
					model.setMpkgDesc( mpkgDesc[i]);
				if ( ipkgQty[i] !=	null)
					model.setIpkgQty( ipkgQty[i]);
				if ( ipkgTp[i] !=	null)
					model.setIpkgTp( ipkgTp[i]);
				if ( ipkgDesc[i] !=	null)
					model.setIpkgDesc( ipkgDesc[i]);
				if ( hazCont[i] !=	null)
					model.setHazCont( hazCont[i]);
				if ( propShipNm[i] !=	null)
					model.setPropShipNm( propShipNm[i]);
				if ( techNm[i] !=	null)
					model.setTechNm( techNm[i]);
				if ( imoClass[i] !=	null)
					model.setImoClass( imoClass[i]);
				if ( imoPage[i] !=	null)
					model.setImoPage( imoPage[i]);
				if ( unNbr[i] !=	null)
					model.setUnNbr( unNbr[i]);
				if ( unNbrSeq[i] !=	null)
					model.setUnNbrSeq( unNbrSeq[i]);
				if ( cfrNbr[i] !=	null)
					model.setCfrNbr( cfrNbr[i]);
				if ( flash[i] !=	null)
					model.setFlash( flash[i]);
				if ( flashUnit[i] !=	null)
					model.setFlashUnit( flashUnit[i]);
				if ( pkgGroup[i] !=	null)
					model.setPkgGroup( pkgGroup[i]);
				if ( emsNbr[i] !=	null)
					model.setEmsNbr( emsNbr[i]);
				if ( mfag[i] !=	null)
					model.setMfag( mfag[i]);
				if ( espn[i] !=	null)
					model.setEspn( espn[i]);
				if ( pollutant[i] !=	null)
					model.setPollutant( pollutant[i]);
				if ( imoLimit[i] !=	null)
					model.setImoLimit( imoLimit[i]);
				if ( groswgt[i] !=	null)
					model.setGroswgt( groswgt[i]);
				if ( grosswgtUnit[i] !=	null)
					model.setGrosswgtUnit( grosswgtUnit[i]);
				if ( netwgt[i] !=	null)
					model.setNetwgt( netwgt[i]);
				if ( netwgtUnit[i] !=	null)
					model.setNetwgtUnit( netwgtUnit[i]);
				if ( vol[i] !=	null)
					model.setVol( vol[i]);
				if ( volUnit[i] !=	null)
					model.setVolUnit( volUnit[i]);
				if ( remark[i] !=	null)
					model.setRemark( remark[i]);
				if ( contact[i] !=	null)
					model.setContact( contact[i]);
				if ( phone[i] !=	null)
					model.setPhone( phone[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getFlatFilePartnerLineVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return FlatFilePartnerLineVO[]
	 */
	public FlatFilePartnerLineVO[]	 getFlatFilePartnerLineVOs(){
		FlatFilePartnerLineVO[] vos = (FlatFilePartnerLineVO[])models.toArray(new	FlatFilePartnerLineVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnbr =	this.bkgnbr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDt =	this.bkgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brac =	this.brac.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refnbr =	this.refnbr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign =	this.vslCallsign.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode =	this.vslLloydcode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname =	this.vslFullname.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRefNo =	this.vvdRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consortVoy =	this.consortVoy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm =	this.polNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm =	this.podNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pldCd =	this.pldCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pldNm =	this.pldNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtyp =	this.rdtyp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partyTp =	this.partyTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partyCd =	this.partyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq =	this.cntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpsz =	this.cntrTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imex =	this.imex.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemSeq =	this.itemSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRef =	this.dgRef.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opkgQty =	this.opkgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opkgTp =	this.opkgTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opkgDesc =	this.opkgDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mpkgQty =	this.mpkgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mpkgTp =	this.mpkgTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mpkgDesc =	this.mpkgDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipkgQty =	this.ipkgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipkgTp =	this.ipkgTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipkgDesc =	this.ipkgDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazCont =	this.hazCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propShipNm =	this.propShipNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.techNm =	this.techNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoClass =	this.imoClass.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoPage =	this.imoPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNbr =	this.unNbr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNbrSeq =	this.unNbrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrNbr =	this.cfrNbr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flash =	this.flash.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flashUnit =	this.flashUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgGroup =	this.pkgGroup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNbr =	this.emsNbr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfag =	this.mfag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.espn =	this.espn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pollutant =	this.pollutant.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoLimit =	this.imoLimit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groswgt =	this.groswgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grosswgtUnit =	this.grosswgtUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netwgt =	this.netwgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netwgtUnit =	this.netwgtUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol =	this.vol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volUnit =	this.volUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark =	this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contact =	this.contact.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phone =	this.phone.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}