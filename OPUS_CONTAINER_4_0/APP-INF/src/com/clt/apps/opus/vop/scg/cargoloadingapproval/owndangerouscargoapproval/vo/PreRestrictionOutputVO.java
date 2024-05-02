/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreRestrictionOutputVO.java
*@FileTitle : PreRestrictionOutputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.23 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

import java.util.List;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreRestrictionOutputVO {

	private static final long serialVersionUID = 1L;
	
	public PreRestrictionOutputVO(){}
	
	/* Column Info */
	private boolean segChkRslt = false;	
	/* Column Info */
	private boolean vslChkRslt = false;	
	/* Column Info */
	private boolean prtChkRslt = false;
	
	/** Table Value Object Multi Data 처리 */
	private List<PreRestrictionSegregationVO> preRestrictionSegregationVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<PreRestrictionVesselOperatorVO> preRestrictionVesselOperatorVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<PreRestrictionPortVO> preRestrictionPortVOs = null;
	
	/**
	 * Column Info
	 * @return segChkRslt
	 */
	public boolean getSegChkRslt() {
		return this.segChkRslt;
	}
	
	/**
	 * Column Info
	 * @return vslChkRslt
	 */
	public boolean getVslChkRslt() {
		return this.vslChkRslt;
	}
	
	/**
	 * Column Info
	 * @return prtChkRslt
	 */
	public boolean getPrtChkRslt() {
		return this.prtChkRslt;
	}
	
	public void setPreRestrictionSegregationVOs(List<PreRestrictionSegregationVO> preRestrictionSegregationVOs){
		this. preRestrictionSegregationVOs = preRestrictionSegregationVOs;
	}
	
	public void setPreRestrictionVesselOperatorVOs(List<PreRestrictionVesselOperatorVO> preRestrictionVesselOperatorVOs){
		this. preRestrictionVesselOperatorVOs = preRestrictionVesselOperatorVOs;
	}
	
	public void setPreRestrictionPortVOs(List<PreRestrictionPortVO> preRestrictionPortVOs){
		this. preRestrictionPortVOs = preRestrictionPortVOs;
	}
	
	/**
	 * Column Info
	 * @param segChkRslt
	 */
	public void setSegChkRslt(boolean segChkRslt) {
		this.segChkRslt = segChkRslt;
	}
	
	/**
	 * Column Info
	 * @param vslChkRslt
	 */
	public void setVslChkRslt(boolean vslChkRslt) {
		this.vslChkRslt = vslChkRslt;
	}
	
	/**
	 * Column Info
	 * @param prtChkRslt
	 */
	public void setPrtChkRslt(boolean prtChkRslt) {
		this.prtChkRslt = prtChkRslt;
	}

	public List<PreRestrictionSegregationVO> getPreRestrictionSegregationVOs(){
		return preRestrictionSegregationVOs;
	}
	
	public List<PreRestrictionVesselOperatorVO> getPreRestrictionVesselOperatorVOs(){
		return preRestrictionVesselOperatorVOs;
	}
	
	public List<PreRestrictionPortVO> getPreRestrictionPortVOs(){
		return preRestrictionPortVOs;
	}
	
}
