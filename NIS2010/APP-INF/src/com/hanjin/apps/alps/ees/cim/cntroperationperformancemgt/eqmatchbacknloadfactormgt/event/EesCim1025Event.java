/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1025Event.java
*@FileTitle : Location M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.17 문중철
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
 * UI_CIM_1025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_CIM_1025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author MUN JUNG CHEOL
 * @see UI_CIM_1025HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCim1025Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	String period = "";
	String froms = "";
	String tos = "";
	String from = "";
	String to = "";
	String locationBy = "";
	String location = "";	
	String inquiryLevel = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuantityByTypeSizeVO qUantityByTypeSizeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuantityByTypeSizeVO[] qUantityByTypeSizeVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MBSearchOptionInGereralVO mBSearchOptionInGereralVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MBSearchOptionInGereralVO[] mBSearchOptionInGereralVOs = null;

	public EesCim1025Event(){}
	
	public void setQuantityByTypeSizeVO(QuantityByTypeSizeVO qUantityByTypeSizeVO){
		this. qUantityByTypeSizeVO = qUantityByTypeSizeVO;
	}

	public void setQuantityByTypeSizeVOS(QuantityByTypeSizeVO[] qUantityByTypeSizeVOs){
		if (qUantityByTypeSizeVOs != null) {
			QuantityByTypeSizeVO[] tmpVOs = Arrays.copyOf(qUantityByTypeSizeVOs, qUantityByTypeSizeVOs.length);
			this.qUantityByTypeSizeVOs = tmpVOs;
		}
	}

	public QuantityByTypeSizeVO getQuantityByTypeSizeVO(){
		return qUantityByTypeSizeVO;
	}

	public QuantityByTypeSizeVO[] getQuantityByTypeSizeVOS(){
		QuantityByTypeSizeVO[] rtnVOs = null;
		if (this.qUantityByTypeSizeVOs != null) {
			rtnVOs = Arrays.copyOf(qUantityByTypeSizeVOs, qUantityByTypeSizeVOs.length);
		}
		return rtnVOs;
	}
	
	public void setMBSearchOptionInGereralVO(MBSearchOptionInGereralVO mBSearchOptionInGereralVO){
		this. mBSearchOptionInGereralVO = mBSearchOptionInGereralVO;
	}
	
	public void setMBSearchOptionInGereralVOS(MBSearchOptionInGereralVO[] qUantityByTypeSizeVOs){
//		this. mBSearchOptionInGereralVOs = mBSearchOptionInGereralVOs;
	}
	
	public MBSearchOptionInGereralVO getMBSearchOptionInGereralVO(){
		return mBSearchOptionInGereralVO;
	}
	
	public MBSearchOptionInGereralVO[] getMBSearchOptionInGereralVOS(){
		MBSearchOptionInGereralVO[] rtnVOs = null;
		if (this.mBSearchOptionInGereralVOs != null) {
			rtnVOs = Arrays.copyOf(mBSearchOptionInGereralVOs, mBSearchOptionInGereralVOs.length);
		}
		return rtnVOs;
	}
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TypeSizeSequenceVO typeSizeSequenceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TypeSizeSequenceVO[] typeSizeSequenceVOs = null;
	
	public void setTypeSizeSequenceVO(TypeSizeSequenceVO typeSizeSequenceVO){
		this. typeSizeSequenceVO = typeSizeSequenceVO;
	}

	public void setTypeSizeSequenceVOS(TypeSizeSequenceVO[] typeSizeSequenceVOs){
		if (typeSizeSequenceVOs != null) {
			TypeSizeSequenceVO[] tmpVOs = Arrays.copyOf(typeSizeSequenceVOs, typeSizeSequenceVOs.length);
			this.typeSizeSequenceVOs = tmpVOs;
		}
	}

	public TypeSizeSequenceVO getTypeSizeSequenceVO(){
		return typeSizeSequenceVO;
	}

	public TypeSizeSequenceVO[] getTypeSizeSequenceVOS(){
		TypeSizeSequenceVO[] rtnVOs = null;
		if (this.typeSizeSequenceVOs != null) {
			rtnVOs = Arrays.copyOf(typeSizeSequenceVOs, typeSizeSequenceVOs.length);
		}
		return rtnVOs;
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

}
