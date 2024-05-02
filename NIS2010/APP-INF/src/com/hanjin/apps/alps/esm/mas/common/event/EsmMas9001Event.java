/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas9001Event.java
*@FileTitle : Week Copy
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2014-06-18 CHOI DUK WOO 
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.event;

import com.hanjin.apps.alps.esm.mas.common.vo.WeekCopyVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_9001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_9001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Duk Woo
 * @see ESM_MAS_9001HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas9001Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private WeekCopyVO weekCopyVO = null;	
	
	/** Constructor */
	public EsmMas9001Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas9001Event";
	}

	public WeekCopyVO getWeekCopyVO() {
		return weekCopyVO;
	}

	public void setWeekCopyVO(WeekCopyVO weekCopyVO) {
		this.weekCopyVO = weekCopyVO;
	}

	
}
