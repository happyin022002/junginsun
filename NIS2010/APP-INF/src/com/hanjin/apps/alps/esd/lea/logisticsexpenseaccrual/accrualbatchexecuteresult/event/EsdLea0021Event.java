/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0021Event.java
*@FileTitle : Accrual Adjustment
*Open Issues :
*Change history : 
*@LastModifyDate : 2011.10.21
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.10.21 민정호
* 1.0 Creation
* 
* 2011.10.31 [CHM-201114105] [LEA] ALPS UI에 조정계수 입력화면 Accrual Adjustment 추가
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.AccrualAdjustmentVO;


/**
 * ESD_LEA_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AccrualAdjustmentVO accrualAdjustmentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AccrualAdjustmentVO[] accrualAdjustmentVOs = null;

	public EsdLea0021Event(){}
	
	public void setAccrualAdjustmentVO(AccrualAdjustmentVO accrualAdjustmentVO){
		this.accrualAdjustmentVO = accrualAdjustmentVO;
	}

	public void setAccrualAdjustmentVOS(AccrualAdjustmentVO[] accrualAdjustmentVOs){
		this.accrualAdjustmentVOs = accrualAdjustmentVOs;
	}

	public AccrualAdjustmentVO getAccrualAdjustmentVO(){
		return accrualAdjustmentVO;
	}

	public AccrualAdjustmentVO[] getAccrualAdjustmentVOS(){
		return accrualAdjustmentVOs;
	}

}