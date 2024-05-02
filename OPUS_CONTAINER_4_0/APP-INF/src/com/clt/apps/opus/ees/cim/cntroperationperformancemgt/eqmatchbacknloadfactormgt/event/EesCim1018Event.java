/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim1018Event.java
 *@FileTitle : Location M/B by Logistics-Wise
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.19
 *@LastModifier : 문중철
 *@LastVersion : 1.0
 * 2009.06.19 문중철
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_CIM_1018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_CIM_1023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Mun Jung Cheol
 * @see UI_CIM_1023HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCim1018Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String cntrTpszCd = "";

	private String locLevel = "";

	private String locCD = "";

	private String period = "";

	private String from = "";

	private String to = "";

	private String froms = "";

	private String tos = "";

	private String locationBy = "";

	private String location = "";

	private String cargoType = "";

	private String company = "";

	private String tpsz = "";

	private String rdtype = "";

	private String enRoute = "";

	private String soc = "";

	private String inquiryLevel = "";

	/** Table Value Object 조회 조건 및 단건 처리 */
	private QuantityByTypeSizeVO qUantityByTypeSizeVO = null;

	/** Table Value Object Multi Data 처리 */
	private QuantityByTypeSizeVO[] qUantityByTypeSizeVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private MBSearchOptionInGereralVO mBSearchOptionInGereralVO = null;

	/** Table Value Object Multi Data 처리 */
	private MBSearchOptionInGereralVO[] mBSearchOptionInGereralVOs = null;

	public EesCim1018Event() {
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private TypeSizeSequenceVO typeSizeSequenceVO = null;

	/** Table Value Object Multi Data 처리 */
	private TypeSizeSequenceVO[] typeSizeSequenceVOs = null;

	/**
	 * @return the cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	/**
	 * @param cntrTpszCd
	 *            the cntrTpszCd to set
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * @return the locLevel
	 */
	public String getLocLevel() {
		return locLevel;
	}

	/**
	 * @param locLevel
	 *            the locLevel to set
	 */
	public void setLocLevel(String locLevel) {
		this.locLevel = locLevel;
	}

	/**
	 * @return the locCD
	 */
	public String getLocCD() {
		return locCD;
	}

	/**
	 * @param locCD
	 *            the locCD to set
	 */
	public void setLocCD(String locCD) {
		this.locCD = locCD;
	}

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
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(String to) {
		this.to = to;
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
	 * @return the locationBy
	 */
	public String getLocationBy() {
		return locationBy;
	}

	/**
	 * @param locationBy
	 *            the locationBy to set
	 */
	public void setLocationBy(String locationBy) {
		this.locationBy = locationBy;
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
	 * @return the cargoType
	 */
	public String getCargoType() {
		return cargoType;
	}

	/**
	 * @param cargoType
	 *            the cargoType to set
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
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
	 * @return the enRoute
	 */
	public String getEnRoute() {
		return enRoute;
	}

	/**
	 * @param enRoute
	 *            the enRoute to set
	 */
	public void setEnRoute(String enRoute) {
		this.enRoute = enRoute;
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
			QuantityByTypeSizeVO[] quantityByTypeSizeVOs) {
		if (quantityByTypeSizeVOs != null) {
			QuantityByTypeSizeVO[] tmpVOs = new QuantityByTypeSizeVO[quantityByTypeSizeVOs.length];
			System.arraycopy(quantityByTypeSizeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.qUantityByTypeSizeVOs = tmpVOs;
		}

	}

	/**
	 * @return the mBSearchOptionInGereralVO
	 */
	public MBSearchOptionInGereralVO getMBSearchOptionInGereralVO() {
		return mBSearchOptionInGereralVO;
	}

	/**
	 * @param searchOptionInGereralVO
	 *            the mBSearchOptionInGereralVO to set
	 */
	public void setMBSearchOptionInGereralVO(
			MBSearchOptionInGereralVO searchOptionInGereralVO) {
		mBSearchOptionInGereralVO = searchOptionInGereralVO;
	}

	/**
	 * @return the mBSearchOptionInGereralVOs
	 */
	public MBSearchOptionInGereralVO[] getMBSearchOptionInGereralVOs() {
		MBSearchOptionInGereralVO[] tmpVOs = null;
		if (this.mBSearchOptionInGereralVOs != null) {
			tmpVOs = new MBSearchOptionInGereralVO[mBSearchOptionInGereralVOs.length];
			System.arraycopy(mBSearchOptionInGereralVOs, 0, tmpVOs, 0,
					tmpVOs.length);
		}
		return tmpVOs;

	}

	/**
	 * @param searchOptionInGereralVOs
	 *            the mBSearchOptionInGereralVOs to set
	 */
	public void setMBSearchOptionInGereralVOs(
			MBSearchOptionInGereralVO[] mBSearchOptionInGereralVOs) {
		if (mBSearchOptionInGereralVOs != null) {
			MBSearchOptionInGereralVO[] tmpVOs = new MBSearchOptionInGereralVO[mBSearchOptionInGereralVOs.length];
			System.arraycopy(mBSearchOptionInGereralVOs, 0, tmpVOs, 0,
					tmpVOs.length);
			this.mBSearchOptionInGereralVOs = tmpVOs;
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

}
