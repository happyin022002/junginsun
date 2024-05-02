/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim1029Event.java
 *@FileTitle : Cargo Flow Map
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.24
 *@LastModifier : 문중철
 *@LastVersion : 1.0
 * 2009.06.24 문중철
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByFromToVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_CIM_1018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_CIM_1029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Mun Jung Cheol
 * @see UI_CIM_1023HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCim1029Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String period = "";
	private String froms = "";
	private String tos = "";
	private String fromz = "";
	private String toz = "";
	private String inquiryLevel = "";
	private String tpsz = "";
	private String rdtype = "";
	private String directionWise = "";
	private String startz = "";
	private String locCnty = "";
	private String location = "";
	private String country = "";
	private String end11 = "";
	private String end12 = "";
	private String end20 = "";
	private String end30 = "";
	private String end40 = "";
	private String end50 = "";
	private String end60 = "";
	private String soc = "";
	private String company = "";
	private String inquiryWise2 = "";
	private String inquiryWise1 = "";

	/** Table Value Object 조회 조건 및 단건 처리 */
	private QuantityByTypeSizeVO qUantityByTypeSizeVO = null;

	/** Table Value Object Multi Data 처리 */
	private QuantityByTypeSizeVO[] qUantityByTypeSizeVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private SearchOptionByFromToVO searchOptionByFromToVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchOptionByFromToVO[] searchOptionByFromToVOs = null;

	public EesCim1029Event() {
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private TypeSizeSequenceVO typeSizeSequenceVO = null;

	/** Table Value Object Multi Data 처리 */
	private TypeSizeSequenceVO[] typeSizeSequenceVOs = null;

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * @return the froms
	 */
	public String getFroms() {
		return froms;
	}

	/**
	 * @param froms
	 *            the froms to set
	 */
	public void setFroms(String froms) {
		this.froms = froms;
	}

	/**
	 * @return the tos
	 */
	public String getTos() {
		return tos;
	}

	/**
	 * @param tos
	 *            the tos to set
	 */
	public void setTos(String tos) {
		this.tos = tos;
	}

	/**
	 * @return the fromz
	 */
	public String getFromz() {
		return fromz;
	}

	/**
	 * @param fromz
	 *            the fromz to set
	 */
	public void setFromz(String fromz) {
		this.fromz = fromz;
	}

	/**
	 * @return the toz
	 */
	public String getToz() {
		return toz;
	}

	/**
	 * @param toz
	 *            the toz to set
	 */
	public void setToz(String toz) {
		this.toz = toz;
	}

	/**
	 * @return the inquiryLevel
	 */
	public String getInquiryLevel() {
		return inquiryLevel;
	}

	/**
	 * @param inquiryLevel
	 *            the inquiryLevel to set
	 */
	public void setInquiryLevel(String inquiryLevel) {
		this.inquiryLevel = inquiryLevel;
	}

	/**
	 * @return the tpsz
	 */
	public String getTpsz() {
		return tpsz;
	}

	/**
	 * @param tpsz
	 *            the tpsz to set
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}

	/**
	 * @return the rdtype
	 */
	public String getRdtype() {
		return rdtype;
	}

	/**
	 * @param rdtype
	 *            the rdtype to set
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}

	/**
	 * @return the directionWise
	 */
	public String getDirectionWise() {
		return directionWise;
	}

	/**
	 * @param directionWise
	 *            the directionWise to set
	 */
	public void setDirectionWise(String directionWise) {
		this.directionWise = directionWise;
	}

	/**
	 * @return the startz
	 */
	public String getStartz() {
		return startz;
	}

	/**
	 * @param startz
	 *            the startz to set
	 */
	public void setStartz(String startz) {
		this.startz = startz;
	}

	/**
	 * @return the locCnty
	 */
	public String getLocCnty() {
		return locCnty;
	}

	/**
	 * @param locCnty
	 *            the locCnty to set
	 */
	public void setLocCnty(String locCnty) {
		this.locCnty = locCnty;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the end11
	 */
	public String getEnd11() {
		return end11;
	}

	/**
	 * @param end11
	 *            the end11 to set
	 */
	public void setEnd11(String end11) {
		this.end11 = end11;
	}

	/**
	 * @return the end12
	 */
	public String getEnd12() {
		return end12;
	}

	/**
	 * @param end12
	 *            the end12 to set
	 */
	public void setEnd12(String end12) {
		this.end12 = end12;
	}

	/**
	 * @return the end20
	 */
	public String getEnd20() {
		return end20;
	}

	/**
	 * @param end20
	 *            the end20 to set
	 */
	public void setEnd20(String end20) {
		this.end20 = end20;
	}

	/**
	 * @return the end30
	 */
	public String getEnd30() {
		return end30;
	}

	/**
	 * @param end30
	 *            the end30 to set
	 */
	public void setEnd30(String end30) {
		this.end30 = end30;
	}

	/**
	 * @return the end40
	 */
	public String getEnd40() {
		return end40;
	}

	/**
	 * @param end40
	 *            the end40 to set
	 */
	public void setEnd40(String end40) {
		this.end40 = end40;
	}

	/**
	 * @return the end50
	 */
	public String getEnd50() {
		return end50;
	}

	/**
	 * @param end50
	 *            the end50 to set
	 */
	public void setEnd50(String end50) {
		this.end50 = end50;
	}

	/**
	 * @return the end60
	 */
	public String getEnd60() {
		return end60;
	}

	/**
	 * @param end60
	 *            the end60 to set
	 */
	public void setEnd60(String end60) {
		this.end60 = end60;
	}

	/**
	 * @return the soc
	 */
	public String getSoc() {
		return soc;
	}

	/**
	 * @param soc
	 *            the soc to set
	 */
	public void setSoc(String soc) {
		this.soc = soc;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the inquiryWise2
	 */
	public String getInquiryWise2() {
		return inquiryWise2;
	}

	/**
	 * @param inquiryWise2
	 *            the inquiryWise2 to set
	 */
	public void setInquiryWise2(String inquiryWise2) {
		this.inquiryWise2 = inquiryWise2;
	}

	/**
	 * @return the inquiryWise1
	 */
	public String getInquiryWise1() {
		return inquiryWise1;
	}

	/**
	 * @param inquiryWise1
	 *            the inquiryWise1 to set
	 */
	public void setInquiryWise1(String inquiryWise1) {
		this.inquiryWise1 = inquiryWise1;
	}

	/**
	 * @return the qUantityByTypeSizeVO
	 */
	public QuantityByTypeSizeVO getQUantityByTypeSizeVO() {
		return qUantityByTypeSizeVO;
	}

	/**
	 * @param uantityByTypeSizeVO
	 *            the qUantityByTypeSizeVO to set
	 */
	public void setQUantityByTypeSizeVO(QuantityByTypeSizeVO uantityByTypeSizeVO) {
		qUantityByTypeSizeVO = uantityByTypeSizeVO;
	}

	/**
	 * @return the qUantityByTypeSizeVOs
	 */
	public QuantityByTypeSizeVO[] getQUantityByTypeSizeVOs() {
		QuantityByTypeSizeVO[] tmpVOs = null;
		if (this.qUantityByTypeSizeVOs != null) {
			tmpVOs = new QuantityByTypeSizeVO[qUantityByTypeSizeVOs.length];
			System.arraycopy(qUantityByTypeSizeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param uantityByTypeSizeVOs
	 *            the qUantityByTypeSizeVOs to set
	 */
	public void setQUantityByTypeSizeVOs(
			QuantityByTypeSizeVO[] qUantityByTypeSizeVOs) {
		if (qUantityByTypeSizeVOs != null) {
			QuantityByTypeSizeVO[] tmpVOs = new QuantityByTypeSizeVO[qUantityByTypeSizeVOs.length];
			System.arraycopy(qUantityByTypeSizeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.qUantityByTypeSizeVOs = tmpVOs;
		}
	}

	/**
	 * @return the searchOptionByFromToVO
	 */
	public SearchOptionByFromToVO getSearchOptionByFromToVO() {
		return searchOptionByFromToVO;
	}

	/**
	 * @param searchOptionByFromToVO
	 *            the searchOptionByFromToVO to set
	 */
	public void setSearchOptionByFromToVO(
			SearchOptionByFromToVO searchOptionByFromToVO) {
		this.searchOptionByFromToVO = searchOptionByFromToVO;
	}

	/**
	 * @return the searchOptionByFromToVOs
	 */
	public SearchOptionByFromToVO[] getSearchOptionByFromToVOs() {
		SearchOptionByFromToVO[] tmpVOs = null;
		if (this.searchOptionByFromToVOs != null) {
			tmpVOs = new SearchOptionByFromToVO[searchOptionByFromToVOs.length];
			System.arraycopy(searchOptionByFromToVOs, 0, tmpVOs, 0,
					tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param searchOptionByFromToVOs
	 *            the searchOptionByFromToVOs to set
	 */
	public void setSearchOptionByFromToVOs(
			SearchOptionByFromToVO[] searchOptionByFromToVOs) {
		if (searchOptionByFromToVOs != null) {
			SearchOptionByFromToVO[] tmpVOs = new SearchOptionByFromToVO[searchOptionByFromToVOs.length];
			System.arraycopy(searchOptionByFromToVOs, 0, tmpVOs, 0,
					tmpVOs.length);
			this.searchOptionByFromToVOs = tmpVOs;
		}
	}

	/**
	 * @return the typeSizeSequenceVO
	 */
	public TypeSizeSequenceVO getTypeSizeSequenceVO() {
		return typeSizeSequenceVO;
	}

	/**
	 * @param typeSizeSequenceVO
	 *            the typeSizeSequenceVO to set
	 */
	public void setTypeSizeSequenceVO(TypeSizeSequenceVO typeSizeSequenceVO) {
		this.typeSizeSequenceVO = typeSizeSequenceVO;
	}

	/**
	 * @return the typeSizeSequenceVOs
	 */
	public TypeSizeSequenceVO[] getTypeSizeSequenceVOs() {
		TypeSizeSequenceVO[] tmpVOs = null;
		if (this.typeSizeSequenceVOs != null) {
			tmpVOs = new TypeSizeSequenceVO[typeSizeSequenceVOs.length];
			System.arraycopy(typeSizeSequenceVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param typeSizeSequenceVOs
	 *            the typeSizeSequenceVOs to set
	 */
	public void setTypeSizeSequenceVOs(TypeSizeSequenceVO[] typeSizeSequenceVOs) {
		if (typeSizeSequenceVOs != null) {
			TypeSizeSequenceVO[] tmpVOs = new TypeSizeSequenceVO[typeSizeSequenceVOs.length];
			System.arraycopy(typeSizeSequenceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.typeSizeSequenceVOs = tmpVOs;
		}
	}

}
