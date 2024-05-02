/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0003Event.java
*@FileTitle : Charge Deduction User Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.14
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.14 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event;

import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.ChargeDdtSetVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeDdtSetVO chargeDdtSetVO = null;

	/** Table Value Object Multi Data 처리 */
	private ChargeDdtSetVO[] chargeDdtSetVOs = null;

	/** Table Value Object Multi Data 처리 */
	private ChargeDdtSetVO[] chargeDdtSetRepChgVOs = null;

	/** Table Value Object Multi Data 처리 */
	private ChargeDdtSetVO[] chargeDdtSetChargeVOs = null;

	public EsmAcm0003Event() {}

	public ChargeDdtSetVO getChargeDdtSetVO() {
		return chargeDdtSetVO;
	}

	public void setChargeDdtSetVO(ChargeDdtSetVO chargeDdtSetVO) {
		this.chargeDdtSetVO = chargeDdtSetVO;
	}

	public ChargeDdtSetVO[] getChargeDdtSetVOs() {
		return chargeDdtSetVOs;
	}

	public void setChargeDdtSetVOs(ChargeDdtSetVO[] chargeDdtSetVOs) {
		this.chargeDdtSetVOs = chargeDdtSetVOs;
	}

	public ChargeDdtSetVO[] getChargeDdtSetRepChgVOs() {
		return chargeDdtSetRepChgVOs;
	}

	public void setChargeDdtSetRepChgVOs(ChargeDdtSetVO[] chargeDdtSetRepChgVOs) {
		this.chargeDdtSetRepChgVOs = chargeDdtSetRepChgVOs;
	}

	public ChargeDdtSetVO[] getChargeDdtSetChargeVOs() {
		return chargeDdtSetChargeVOs;
	}

	public void setChargeDdtSetChargeVOs(ChargeDdtSetVO[] chargeDdtSetChargeVOs) {
		this.chargeDdtSetChargeVOs = chargeDdtSetChargeVOs;
	}

}