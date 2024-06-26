/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0419Event.java
*@FileTitle : VL/VD EDI Test Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.31 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.ConCBookingVO;


/**
 * EES_CTM_0419 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0419HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0419HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0419Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConCBookingVO conCBookingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ConCBookingVO[] conCBookingVOs = null;

	public EesCtm0419Event(){}
	
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