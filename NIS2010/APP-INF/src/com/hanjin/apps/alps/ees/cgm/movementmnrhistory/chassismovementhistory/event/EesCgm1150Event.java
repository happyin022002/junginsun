/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EesCgm1150Event.java
*@FileTitle : Shipper's Chassis Movement Management
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.26
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.26 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.event;


import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.ShipCHSMvmtMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1150 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1150HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_CGM_1150HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1150Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ShipCHSMvmtMGTVO shipCHSMvmtMGTVO = null;

	/** Table Value Object Multi Data 처리 */
	private ShipCHSMvmtMGTVO[] shipCHSMvmtMGTVOs = null;

	/**
	 * @return the shipCHSMvmtMGTVO
	 */
	public ShipCHSMvmtMGTVO getShipCHSMvmtMGTVO() {
		return shipCHSMvmtMGTVO;
	}

	/**
	 * @param shipCHSMvmtMGTVO the shipCHSMvmtMGTVO to set
	 */
	public void setShipCHSMvmtMGTVO(ShipCHSMvmtMGTVO shipCHSMvmtMGTVO) {
		this.shipCHSMvmtMGTVO = shipCHSMvmtMGTVO;
	}

	/**
	 * @return the shipCHSMvmtMGTVOs
	 */
	public ShipCHSMvmtMGTVO[] getShipCHSMvmtMGTVOs() {
		return shipCHSMvmtMGTVOs;
	}

	/**
	 * @param shipCHSMvmtMGTVOs the shipCHSMvmtMGTVOs to set
	 */
	public void setShipCHSMvmtMGTVOs(ShipCHSMvmtMGTVO[] shipCHSMvmtMGTVOs) {
		this.shipCHSMvmtMGTVOs = shipCHSMvmtMGTVOs;
	}
}