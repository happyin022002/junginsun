/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa9001Event.java
*@FileTitle : Week Copy
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2014-06-18 CHOI DUK WOO 
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.common.event;

import com.hanjin.apps.alps.esm.coa.common.vo.WeekCopyVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_COA_9001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_9001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Duk Woo
 * @see ESM_COA_9001HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa9001Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private WeekCopyVO weekCopyVO = null;	
	
	/** Constructor */
	public EsmCoa9001Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa9001Event";
	}

	public WeekCopyVO getWeekCopyVO() {
		return weekCopyVO;
	}

	public void setWeekCopyVO(WeekCopyVO weekCopyVO) {
		this.weekCopyVO = weekCopyVO;
	}

	
}
