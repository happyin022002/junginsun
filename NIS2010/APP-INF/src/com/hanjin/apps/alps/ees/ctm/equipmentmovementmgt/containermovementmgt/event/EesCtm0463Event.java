/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesCtm0463Event.java
*@FileTitle : Modified event date history Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.01
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.11.01 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.EventDateUpdateHistoryParmVO;


/**
 * ees_ctm_0463 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_ctm_0463HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see ees_ctm_0463HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0463Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EventDateUpdateHistoryParmVO eventDateUpdateHistoryParmVO = null;

	public EesCtm0463Event(){}

	public void setEventDateUpdateHistoryParmVO(EventDateUpdateHistoryParmVO eventDateUpdateHistoryParmVO){
		this. eventDateUpdateHistoryParmVO = eventDateUpdateHistoryParmVO;
	}

	public EventDateUpdateHistoryParmVO getEventDateUpdateHistoryParmVO(){
		return eventDateUpdateHistoryParmVO;
	}

}