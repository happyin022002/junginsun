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
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.ConCBookingVO;


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
		this. conCBookingVOs = conCBookingVOs;
	}

	public ConCBookingVO getConCBookingVO(){
		return conCBookingVO;
	}

	public ConCBookingVO[] getConCBookingVOS(){
		return conCBookingVOs;
	}

}