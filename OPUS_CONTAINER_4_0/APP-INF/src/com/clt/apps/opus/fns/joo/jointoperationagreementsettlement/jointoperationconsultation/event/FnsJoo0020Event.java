/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0020Event.java
*@FileTitle : AR CSR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.08.06 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0020HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SlipProcessVO slipProcessVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SlipProcessVO[] slipProcessVOs = null;

	public FnsJoo0020Event(){}
	
	public void setSlipProcessVO(SlipProcessVO slipProcessVO){
		this. slipProcessVO = slipProcessVO;
	}

	public void setSlipProcessVOS(SlipProcessVO[] slipProcessVOs){
		if (slipProcessVOs != null) {
			SlipProcessVO[] tmpVOs = new SlipProcessVO[slipProcessVOs.length];
			System.arraycopy(slipProcessVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.slipProcessVOs = tmpVOs;
		}
	}

	public SlipProcessVO getSlipProcessVO(){
		return slipProcessVO;
	}

	public SlipProcessVO[] getSlipProcessVOS(){
		SlipProcessVO[] tmpVOs = null;
		if (this.slipProcessVOs != null) {
			tmpVOs = new SlipProcessVO[slipProcessVOs.length];
			System.arraycopy(slipProcessVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}