/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0413Event.java
*@FileTitle : BKG/MVMT VL/VD Unmatch
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.18 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.ConCBookingVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0413 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0413HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0413HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0413Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConCBookingVO conCBookingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ConCBookingVO[] conCBookingVOs = null;

	public EesCtm0413Event(){}
	
	public void setConCBookingVO(ConCBookingVO conCBookingVO){
		this. conCBookingVO = conCBookingVO;
	}

	public void setConCBookingVOS(ConCBookingVO[] conCBookingVOs){
		if (conCBookingVOs != null) {
			ConCBookingVO[] tmpVOs = new ConCBookingVO[conCBookingVOs.length];
			System.arraycopy(conCBookingVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.conCBookingVOs = tmpVOs;
		}
	}

	public ConCBookingVO getConCBookingVO(){
		return conCBookingVO;
	}

	public ConCBookingVO[] getConCBookingVOS(){
		ConCBookingVO[] tmpVOs = null;
		if (this.conCBookingVOs != null) {
			tmpVOs = new ConCBookingVO[conCBookingVOs.length];
			System.arraycopy(conCBookingVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}