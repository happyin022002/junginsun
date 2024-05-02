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
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.ChargeDdtSetVO;
import com.clt.framework.support.layer.event.EventSupport;


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
		ChargeDdtSetVO[] rtnVOs = null;
		if (this.chargeDdtSetVOs != null) {
			rtnVOs = Arrays.copyOf(chargeDdtSetVOs, chargeDdtSetVOs.length);
		}
		return rtnVOs;
	}

	public void setChargeDdtSetVOs(ChargeDdtSetVO[] chargeDdtSetVOs) {
		if(chargeDdtSetVOs != null){
			ChargeDdtSetVO[] tmpVOs = Arrays.copyOf(chargeDdtSetVOs, chargeDdtSetVOs.length);
			this.chargeDdtSetVOs  = tmpVOs;
		}
	}

	public ChargeDdtSetVO[] getChargeDdtSetRepChgVOs() {
		ChargeDdtSetVO[] rtnVOs = null;
		if (this.chargeDdtSetRepChgVOs != null) {
			rtnVOs = Arrays.copyOf(chargeDdtSetRepChgVOs, chargeDdtSetRepChgVOs.length);
		}
		return rtnVOs;
	}

	public void setChargeDdtSetRepChgVOs(ChargeDdtSetVO[] chargeDdtSetRepChgVOs) {
		if(chargeDdtSetRepChgVOs != null){
			ChargeDdtSetVO[] tmpVOs = Arrays.copyOf(chargeDdtSetRepChgVOs, chargeDdtSetRepChgVOs.length);
			this.chargeDdtSetRepChgVOs  = tmpVOs;
		}
	}

	public ChargeDdtSetVO[] getChargeDdtSetChargeVOs() {
		ChargeDdtSetVO[] rtnVOs = null;
		if (this.chargeDdtSetChargeVOs != null) {
			rtnVOs = Arrays.copyOf(chargeDdtSetChargeVOs, chargeDdtSetChargeVOs.length);
		}
		return rtnVOs;
	}

	public void setChargeDdtSetChargeVOs(ChargeDdtSetVO[] chargeDdtSetChargeVOs) {
		if(chargeDdtSetChargeVOs != null){
			ChargeDdtSetVO[] tmpVOs = Arrays.copyOf(chargeDdtSetChargeVOs, chargeDdtSetChargeVOs.length);
			this.chargeDdtSetChargeVOs  = tmpVOs;
		}
	}

}