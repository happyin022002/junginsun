/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0247Event.java
*@FileTitle : Disposal Equipment Detail list
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.11.23 장준우
* 1.0 Creation
* ==========================================================
* 2010.11.30 남궁진호 [CHM-201007441_01] Disposal Performance 화면에서 장비별 Detail 내역을 팝업으로 조회
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalResultEquipmentVO;


/**
 * EES_MNR_0247 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0247HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see ees_mnr_0247HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0247Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalResultEquipmentVO disposalResultEquipmentVO = null;

	public EesMnr0247Event(){}

	/**
	 * @return the disposalResultEquipmentVO
	 */
	public DisposalResultEquipmentVO getDisposalResultEquipmentVO() {
		return disposalResultEquipmentVO;
	}

	/**
	 * @param disposalResultEquipmentVO the disposalResultEquipmentVO to set
	 */
	public void setDisposalResultEquipmentVO(DisposalResultEquipmentVO disposalResultEquipmentVO) {
		this.disposalResultEquipmentVO = disposalResultEquipmentVO;
	}
}