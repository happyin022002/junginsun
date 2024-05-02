/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0057Event.java
*@FileTitle : Criteria of Out of Gauge Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_0057HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AwkCgoApplVO awkCgoApplVO = null;

	/** Table Value Object Multi Data 처리 */
	private AwkCgoApplVO[] awkCgoApplVOs = null;

	public EsmBkg0057Event(){}

	/**
	 * @param awkCgoApplVO the awkCgoApplVO to set
	 */
	public void setAwkCgoApplVO(AwkCgoApplVO awkCgoApplVO){
		this. awkCgoApplVO = awkCgoApplVO;
	}

	/**
	 * @param awkCgoApplVOs the awkCgoApplVOs to set
	 */
	public void setAwkCgoApplVOS(AwkCgoApplVO[] awkCgoApplVOs){
		this. awkCgoApplVOs = awkCgoApplVOs;
	}

	 /**
     * @return the awkCgoApplVO
     */
	public AwkCgoApplVO getAwkCgoApplVO(){
		return awkCgoApplVO;
	}

	 /**
     * @return the awkCgoApplVOs
     */
	public AwkCgoApplVO[] getAwkCgoApplVOS(){
		return awkCgoApplVOs;
	}

}