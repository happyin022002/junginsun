/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVskSpp0007Event.java
*@FileTitle : ETA sending (Auto-fax) Save
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.20
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.20 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendTgtVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ETA sending (Auto-fax) 저장
 *
 * @author Maria Chin
 * @see spp_vsk_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVskSPPVSK0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EtaSendTgtVO etaSendTgtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EtaSendTgtVO[] etaSendTgtVOs = null;
	
	public VopVskSPPVSK0007Event(){}

	public EtaSendTgtVO getEtaSendTgtVO() {
		return etaSendTgtVO;
	}

	public void setEtaSendTgtVO(EtaSendTgtVO etaSendTgtVO) {
		this.etaSendTgtVO = etaSendTgtVO;
	}

	public EtaSendTgtVO[] getEtaSendTgtVOs() {
		EtaSendTgtVO[] rtnVOs =  null;
		if(this.etaSendTgtVOs != null){
			rtnVOs = new EtaSendTgtVO[etaSendTgtVOs.length];
			System.arraycopy(etaSendTgtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return etaSendTgtVOs;
	}

	public void setEtaSendTgtVOs(EtaSendTgtVO[] etaSendTgtVOs) {
		if(etaSendTgtVOs != null){
			EtaSendTgtVO[] tmpVOs = new EtaSendTgtVO[etaSendTgtVOs.length];
			System.arraycopy(etaSendTgtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.etaSendTgtVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.etaSendTgtVOs = etaSendTgtVOs;
	}

}