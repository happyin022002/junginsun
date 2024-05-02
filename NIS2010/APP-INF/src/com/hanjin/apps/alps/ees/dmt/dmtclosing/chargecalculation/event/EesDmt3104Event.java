/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3104Event.java
*@FileTitle : Exemption Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.16
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.08.16 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivFileVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchChargeDeletionContainerMovementOcDtVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchInactiveCheckVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun 
 * @see EES_DMT_3104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeCalculationContainerVO chargeCalculationContainerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDeleteMultiReasonListVO searchDeleteMultiReasonListVO = null;
		
	private ChargeInactivDetailVO[] chargeInactivDetailVOs = null;	

	private ChargeInactivDetailVO chargeInactivDetailVO = null;
	
	/////////////////////////////////////////////////////////////////////
	// File Logic 변경으로 인해 추가
	private ChargeInactivFileVO chargeInactivFileVO = null; // Eidt Point
	
	/**
	 * @return the chargeInactivFileVO
	 */
	public ChargeInactivFileVO getChargeInactivFileVO() {
		return chargeInactivFileVO;
	}

	/**
	 * @param chargeInactivFileVO the chargeInactivFileVO to set
	 */
	public void setChargeInactivFileVO(ChargeInactivFileVO chargeInactivFileVO) {
		this.chargeInactivFileVO = chargeInactivFileVO;
	}
	////////////////////////////////////////////////////////////////////
	
	private ChargeInactivFileVO[] chargeInactivFileVOs = null;

	private SearchInactiveCheckVO searchInactiveCheckVO = null;
	
	// SLIKRG 코드에서의 OP_DT 조회를 위해 추가 (2016.08.31 Won Ki Eo)
	private SearchChargeDeletionContainerMovementOcDtVO searchChargeDeletionContainerMovementOcDtVO = null;


	public EesDmt3104Event(){}
	
	public void setChargeCalculationContainerVO(ChargeCalculationContainerVO chargeCalculationContainerVO){
		this. chargeCalculationContainerVO = chargeCalculationContainerVO;
	}
	public void setChargeCalculationContainerVOS(ChargeCalculationContainerVO[] chargeCalculationContainerVOs){
		if (chargeCalculationContainerVOs != null) {
			this.chargeCalculationContainerVOs = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			
			for (int i=0; i<chargeCalculationContainerVOs.length; i++) {
				this.chargeCalculationContainerVOs[i] = chargeCalculationContainerVOs[i];
			}
		}
	}
	public void setSearchDeleteMultiReasonListVO(SearchDeleteMultiReasonListVO searchDeleteMultiReasonListVO){
		this.searchDeleteMultiReasonListVO = searchDeleteMultiReasonListVO;

	}
	public ChargeCalculationContainerVO getChargeCalculationContainerVO(){
		return chargeCalculationContainerVO;
	}
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOS(){
		ChargeCalculationContainerVO[] ret = null;
		
		if (this.chargeCalculationContainerVOs != null) {
			ret = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			
			for (int i=0; i<chargeCalculationContainerVOs.length; i++) {
				ret[i] = this.chargeCalculationContainerVOs[i];
			}
		}
		return ret;			
	}
	public SearchDeleteMultiReasonListVO getSearchDeleteMultiReasonListVO(){
		return searchDeleteMultiReasonListVO;
	}

	public void setChargeInactivFileVOS(ChargeInactivFileVO[] chargeInactivFileVOs){
		if (chargeInactivFileVOs != null) {
			this.chargeInactivFileVOs = new ChargeInactivFileVO[chargeInactivFileVOs.length];
			
			for (int i=0; i<chargeInactivFileVOs.length; i++) {
				this.chargeInactivFileVOs[i] = chargeInactivFileVOs[i];
			}
		}
	}
	public ChargeInactivFileVO[] getChargeInactivFileVOS(){
		ChargeInactivFileVO[] ret = null;
		
		if (this.chargeInactivFileVOs != null) {
			ret = new ChargeInactivFileVO[chargeInactivFileVOs.length];
			
			for (int i=0; i<chargeInactivFileVOs.length; i++) {
				ret[i] = this.chargeInactivFileVOs[i];
			}
		}
		return ret;			
	}
	

	public void setChargeInactivDetailVOS(ChargeInactivDetailVO[] chargeInactivDetailVOs){
		if (chargeInactivDetailVOs != null) {
			this.chargeInactivDetailVOs = new ChargeInactivDetailVO[chargeInactivDetailVOs.length];
			
			for (int i=0; i<chargeInactivDetailVOs.length; i++) {
				this.chargeInactivDetailVOs[i] = chargeInactivDetailVOs[i];
			}
		}
	}
	public ChargeInactivDetailVO[] getChargeInactivDetailVOS(){
		ChargeInactivDetailVO[] ret = null;
		
		if (this.chargeInactivDetailVOs != null) {
			ret = new ChargeInactivDetailVO[chargeInactivDetailVOs.length];
			
			for (int i=0; i<chargeInactivDetailVOs.length; i++) {
				ret[i] = this.chargeInactivDetailVOs[i];
			}
		}
		return ret;			
	}

	public ChargeInactivDetailVO getChargeInactivDetailVO() {
		return chargeInactivDetailVO;
	}

	public void setChargeInactivDetailVO(ChargeInactivDetailVO chargeInactivDetailVO) {
		this.chargeInactivDetailVO = chargeInactivDetailVO;
	}

	public SearchInactiveCheckVO getSearchInactiveCheckVO() {
		return searchInactiveCheckVO;
	}

	public void setSearchInactiveCheckVO(SearchInactiveCheckVO searchInactiveCheckVO) {
		this.searchInactiveCheckVO = searchInactiveCheckVO;
	}
	
	/**
	 * @return the searchChargeDeletionContainerMovementOcDtVO
	 */
	public SearchChargeDeletionContainerMovementOcDtVO getSearchChargeDeletionContainerMovementOcDtVO() {
		return searchChargeDeletionContainerMovementOcDtVO;
	}

	/**
	 * @param searchChargeDeletionContainerMovementOcDtVO the searchChargeDeletionContainerMovementOcDtVO to set
	 */
	public void setSearchChargeDeletionContainerMovementOcDtVO(
			SearchChargeDeletionContainerMovementOcDtVO searchChargeDeletionContainerMovementOcDtVO) {
		this.searchChargeDeletionContainerMovementOcDtVO = searchChargeDeletionContainerMovementOcDtVO;
	}
	
	
}