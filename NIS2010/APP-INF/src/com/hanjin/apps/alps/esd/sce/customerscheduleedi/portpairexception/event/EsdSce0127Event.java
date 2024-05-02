/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsdSce0123Event.java
*@FileTitle : Edi 323 Adjustment 관리 pop up 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.02
*@LastModifier : 박은정
*@LastVersion : 1.0
* 2013.10.02 박은정
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.CustomerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.Edi323AdjustmentLaneVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_SCE_127 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_127HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Eunjung
 * @see ESD_SCE_127HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdSce0127Event  extends EventSupport {

	

	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private Edi323AdjustmentLaneVO edi323AdjustmentLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private Edi323AdjustmentLaneVO[] edi323AdjustmentLaneVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerVO customerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerVO[] customerVOs = null;
	
	
	
	/**
	 * @return the customerVO
	 */
	public CustomerVO getCustomerVO() {
		return customerVO;
	}
	
	/**
	 * @param customerVO the customerVO to set
	 */
	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}

	/**
	 * @return the customerVOs
	 */
	public CustomerVO[] getCustomerVOs() {
		return customerVOs;
	}

	/**
	 * @param customerVOs the customerVOs to set
	 */
	public void setCustomerVOs(CustomerVO[] customerVOs) {
		this.customerVOs = customerVOs;
	}

	/**
	 * @return the edi323AdjustmentLaneVO
	 */
	public Edi323AdjustmentLaneVO getEdi323AdjustmentLaneVO() {
		return edi323AdjustmentLaneVO;
	}

	/**
	 * @param edi323AdjustmentLaneVO the edi323AdjustmentLaneVO to set
	 */
	public void setEdi323AdjustmentLaneVO(
			Edi323AdjustmentLaneVO edi323AdjustmentLaneVO) {
		this.edi323AdjustmentLaneVO = edi323AdjustmentLaneVO;
	}

	/**
	 * @return the edi323AdjustmentLaneVOs
	 */
	public Edi323AdjustmentLaneVO[] getEdi323AdjustmentLaneVOs() {
		return edi323AdjustmentLaneVOs;
	}

	/**
	 * @param edi323AdjustmentLaneVOs the edi323AdjustmentLaneVOs to set
	 */
	public void setEdi323AdjustmentLaneVOs(
			Edi323AdjustmentLaneVO[] edi323AdjustmentLaneVOs) {
		this.edi323AdjustmentLaneVOs = edi323AdjustmentLaneVOs;
	}

	
	
	
	
}
