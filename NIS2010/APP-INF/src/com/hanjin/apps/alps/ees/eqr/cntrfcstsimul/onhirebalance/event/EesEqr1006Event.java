/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1006Event.java
*@FileTitle : On-Hire Status
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.05
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.05 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.OnhireStatusVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-sun Moon
 * @see EES_EQR_1006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OnhireStatusVO onhireStatusVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public OnhireStatusVO[] onhireStatusVOs = null;

	public EesEqr1006Event(){}
	
	public void setOnhireStatusVO(OnhireStatusVO onhireStatusVO){
		this. onhireStatusVO = onhireStatusVO;
	}

	public void setOnhireStatusVOS(OnhireStatusVO[] onhireStatusVOs){
		this. onhireStatusVOs = onhireStatusVOs;
	}

	public OnhireStatusVO getOnhireStatusVO(){
		return onhireStatusVO;
	}

	public OnhireStatusVO[] getOnhireStatusVOS(){
		return onhireStatusVOs;
	}

}