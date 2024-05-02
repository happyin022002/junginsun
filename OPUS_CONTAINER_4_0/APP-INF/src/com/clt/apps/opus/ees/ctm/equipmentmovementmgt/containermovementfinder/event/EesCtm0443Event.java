/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0443Event.java
*@FileTitle : Cargo Location message
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.18 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmCCLMVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0443 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0443HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0443HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0443Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmCCLMVO ctmCCLMVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CtmCCLMVO[] ctmCCLMVOs = null;

	public EesCtm0443Event(){}
	
	public void setCtmCCLMVO(CtmCCLMVO ctmCCLMVO){
		this. ctmCCLMVO = ctmCCLMVO;
	}

	public void setCtmCCLMVOS(CtmCCLMVO[] ctmCCLMVOs){
		if (ctmCCLMVOs != null) {
			CtmCCLMVO[] tmpVOs = new CtmCCLMVO[ctmCCLMVOs.length];
			System.arraycopy(ctmCCLMVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmCCLMVOs = tmpVOs;
		}
	}

	public CtmCCLMVO getCtmCCLMVO(){
		return ctmCCLMVO;
	}

	public CtmCCLMVO[] getCtmCCLMVOS(){
		CtmCCLMVO[] tmpVOs = null;
		if (this.ctmCCLMVOs != null) {
			tmpVOs = new CtmCCLMVO[ctmCCLMVOs.length];
			System.arraycopy(ctmCCLMVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}