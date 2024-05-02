/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0003Event.java
*@FileTitle : Representative Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.18 조인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.account.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.bcm.ccd.commoncode.account.vo.RepChargeVO;


/**
 * BCM_CCD_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Charge Code */
	private String repChgCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepChargeVO repChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RepChargeVO[] repChgVOs = null;

	public BcmCcd0003Event(){}

	public void setRepChargeVO(RepChargeVO repChgVO){
		this. repChgVO = repChgVO;
	}
	
	public void setRepChargeVOS(RepChargeVO[] repChgVOs){
		if(repChgVOs != null){
			RepChargeVO[] tmpVOs = java.util.Arrays.copyOf(repChgVOs, repChgVOs.length);
			this.repChgVOs = tmpVOs;
		}
	}

	public RepChargeVO getRepChargeVO(){
		return repChgVO;
	}

	public RepChargeVO[] getRepChargeVOS(){
		RepChargeVO[] rtnVOs = null;
		if (this.repChgVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(repChgVOs, repChgVOs.length);
		}
		return rtnVOs;
	}

	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
	}
	
	public String getRepChgCd() {
		return repChgCd;
	}
}