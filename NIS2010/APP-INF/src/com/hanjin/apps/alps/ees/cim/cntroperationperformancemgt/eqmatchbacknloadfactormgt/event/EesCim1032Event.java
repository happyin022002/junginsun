/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1032Event.java
*@FileTitle : Location M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.19 문중철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_CIM_1018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_CIM_1023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see UI_CIM_1023HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCim1032Event extends EventSupport {

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
	
	private String cargotype = "";
	
	private String company = "";
	
	private String tpsz = "";
	
	private String rdtype = "";
	
	private String enRoute = "";
	
	private String soc = "";
	
	private String inquiryLevel = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuantityByTypeSizeVO qUantityByTypeSizeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuantityByTypeSizeVO[] qUantityByTypeSizeVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MBSearchOptionInGereralVO mBSearchOptionInGereralVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MBSearchOptionInGereralVO[] mBSearchOptionInGereralVOs = null;
	
	public EesCim1032Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
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
	 * @param cntrTpszCd the cntrTpszCd to set
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
	 * @param locLevel the locLevel to set
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
	 * @param locCD the locCD to set
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
	 * @param period the period to set
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
	 * @param from the from to set
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
	 * @param to the to to set
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
	 * @param froms the froms to set
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
	 * @param tos the tos to set
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
	 * @param locationBy the locationBy to set
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
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the cargotype
	 */
	public String getCargotype() {
		return cargotype;
	}

	/**
	 * @param cargoType the cargoType to set
	 */
	public void setCargotype(String cargotype) {
		this.cargotype = cargotype;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
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
	 * @param tpsz the tpsz to set
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
	 * @param rdtype the rdtype to set
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
	 * @param enRoute the enRoute to set
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
	 * @param soc the soc to set
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
	 * @param uantityByTypeSizeVO the qUantityByTypeSizeVO to set
	 */
	public void setQUantityByTypeSizeVO(QuantityByTypeSizeVO uantityByTypeSizeVO) {
		qUantityByTypeSizeVO = uantityByTypeSizeVO;
	}

	/**
	 * @return the qUantityByTypeSizeVOs
	 */
	public QuantityByTypeSizeVO[] getQUantityByTypeSizeVOs() {
		QuantityByTypeSizeVO[] rtnVOs = null;
		if (this.qUantityByTypeSizeVOs != null) {
			rtnVOs = Arrays.copyOf(qUantityByTypeSizeVOs, qUantityByTypeSizeVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param uantityByTypeSizeVOs the qUantityByTypeSizeVOs to set
	 */
	public void setQUantityByTypeSizeVOs(QuantityByTypeSizeVO[] uantityByTypeSizeVOs) {
		if (uantityByTypeSizeVOs != null) {
			QuantityByTypeSizeVO[] tmpVOs = Arrays.copyOf(uantityByTypeSizeVOs, uantityByTypeSizeVOs.length);
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
	 * @param searchOptionInGereralVO the mBSearchOptionInGereralVO to set
	 */
	public void setMBSearchOptionInGereralVO(
			MBSearchOptionInGereralVO searchOptionInGereralVO) {
		mBSearchOptionInGereralVO = searchOptionInGereralVO;
	}

	/**
	 * @return the mBSearchOptionInGereralVOs
	 */
	public MBSearchOptionInGereralVO[] getMBSearchOptionInGereralVOs() {
		MBSearchOptionInGereralVO[] rtnVOs = null;
		if (this.mBSearchOptionInGereralVOs != null) {
			rtnVOs = Arrays.copyOf(mBSearchOptionInGereralVOs, mBSearchOptionInGereralVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param searchOptionInGereralVOs the mBSearchOptionInGereralVOs to set
	 */
	public void setMBSearchOptionInGereralVOs(
			MBSearchOptionInGereralVO[] searchOptionInGereralVOs) {
		if (searchOptionInGereralVOs != null) {
			MBSearchOptionInGereralVO[] tmpVOs = Arrays.copyOf(searchOptionInGereralVOs, searchOptionInGereralVOs.length);
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
	 * @param typeSizeSequenceVO the typeSizeSequenceVO to set
	 */
	public void setTypeSizeSequenceVO(TypeSizeSequenceVO typeSizeSequenceVO) {
		this.typeSizeSequenceVO = typeSizeSequenceVO;
	}

	/**
	 * @return the typeSizeSequenceVOs
	 */
	public TypeSizeSequenceVO[] getTypeSizeSequenceVOs() {
		TypeSizeSequenceVO[] rtnVOs = null;
		if (this.typeSizeSequenceVOs != null) {
			rtnVOs = Arrays.copyOf(typeSizeSequenceVOs, typeSizeSequenceVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param typeSizeSequenceVOs the typeSizeSequenceVOs to set
	 */
	public void setTypeSizeSequenceVOs(TypeSizeSequenceVO[] typeSizeSequenceVOs) {
		if (typeSizeSequenceVOs != null) {
			TypeSizeSequenceVO[] tmpVOs = Arrays.copyOf(typeSizeSequenceVOs, typeSizeSequenceVOs.length);
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
	 * @param inquiryLevel the inquiryLevel to set
	 */
	public void setInquiryLevel(String inquiryLevel) {
		this.inquiryLevel = inquiryLevel;
	}
	
	
	
}
