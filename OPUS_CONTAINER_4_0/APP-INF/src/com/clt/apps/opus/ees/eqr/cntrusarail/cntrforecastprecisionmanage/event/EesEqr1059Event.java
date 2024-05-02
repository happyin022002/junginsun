/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0142Event.java
*@FileTitle : MTY Rail Trans Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.event;

import com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.vo.MtyRailConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0142 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0142HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_1059HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1059Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 검색 조건 처리  */
	private MtyRailConditionVO mtyRailConditionVO = null;
	
	public EesEqr1059Event(){}

	public MtyRailConditionVO getMtyRailConditionVO() {
		return mtyRailConditionVO;
	}

	public void setMtyRailConditionVO(MtyRailConditionVO mtyRailConditionVO) {
		this.mtyRailConditionVO = mtyRailConditionVO;
	}

}