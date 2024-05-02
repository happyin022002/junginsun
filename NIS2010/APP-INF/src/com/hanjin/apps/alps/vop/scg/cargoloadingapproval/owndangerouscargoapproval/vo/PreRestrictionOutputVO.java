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

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSppDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.hanjin.framework.component.common.AbstractValueObject;

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
	/*	Column Info	*/
	private  String	 pckChkRslt   =  null;
	 
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
	/**
	* Column Info
	* @param  pckChkRslt
	*/
	public void	setPckChkRslt( String	pckChkRslt ) {
		this.pckChkRslt =	pckChkRslt;
	}
 
	/**
	 * Column Info
	 * @return	pckChkRslt
	 */
	 public	String	getPckChkRslt() {
		 return	this.pckChkRslt;
	 } 
			
	/** Table Value Object Multi Data 처리 */
	private List<PreRestrictionInvalidReasonDetailVO> preRestrictionInvalidReasonDetailVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<PreRestrictionSppDetailVO> preRestrictionSppDetailVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<PreRestrictionRegulatoryVO> preRestrictionRegulatoryVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs = null;

	/** Table Value Object Multi Data 처리 */
	private  List<PreRestrictionMtdItemVO> preRestrictionMtdItemVOs = null;
	
	public void setPreRestrictionSegregationVOs(List<PreRestrictionSegregationVO> preRestrictionSegregationVOs){
		this. preRestrictionSegregationVOs = preRestrictionSegregationVOs;
	}
	
	public void setPreRestrictionVesselOperatorVOs(List<PreRestrictionVesselOperatorVO> preRestrictionVesselOperatorVOs){
		this. preRestrictionVesselOperatorVOs = preRestrictionVesselOperatorVOs;
	}
	
	public void setPreRestrictionInvalidReasonDetailVOs(List<PreRestrictionInvalidReasonDetailVO> preRestrictionInvalidReasonDetailVOs){
		this. preRestrictionInvalidReasonDetailVOs = preRestrictionInvalidReasonDetailVOs;
	}
	
	public void setPreRestrictionPortVOs(List<PreRestrictionPortVO> preRestrictionPortVOs){
		this. preRestrictionPortVOs = preRestrictionPortVOs;
	}
	
	public void setPreRestrictionSppDetailVOs(List<PreRestrictionSppDetailVO> preRestrictionSppDetailVOs){
		this. preRestrictionSppDetailVOs = preRestrictionSppDetailVOs;
	}
	
	public void setPreRestrictionRegulatoryVOs(List<PreRestrictionRegulatoryVO> preRestrictionRegulatoryVOs){
		this. preRestrictionRegulatoryVOs = preRestrictionRegulatoryVOs;
	}

	public List<PreRestrictionRegulatoryVO> getPreRestrictionRegulatoryVOs(){
		return preRestrictionRegulatoryVOs;
	}

	public List<PreRestrictionSppDetailVO> getPreRestrictionSppDetailVOs(){
		return preRestrictionSppDetailVOs;
	}

	public List<PreRestrictionInvalidReasonDetailVO> getPreRestrictionInvalidReasonDetailVOs(){
		return preRestrictionInvalidReasonDetailVOs;
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
		
	public void setScgPrnrAproRqstCgoVOs(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs){
		this. scgPrnrAproRqstCgoVOs = scgPrnrAproRqstCgoVOs;
	}

	public List<ScgPrnrAproRqstCgoVO> getScgPrnrAproRqstCgoVOs(){
		return scgPrnrAproRqstCgoVOs;
	}
	
	public void setPreRestrictionMtdItemVOs(List<PreRestrictionMtdItemVO> preRestrictionMtdItemVOs){
		this. preRestrictionMtdItemVOs = preRestrictionMtdItemVOs;
	}

	public List<PreRestrictionMtdItemVO> getPreRestrictionMtdItemVOs(){
		return preRestrictionMtdItemVOs;
	}
	
}
