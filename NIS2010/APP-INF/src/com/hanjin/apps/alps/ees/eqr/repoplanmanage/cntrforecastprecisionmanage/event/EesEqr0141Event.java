/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0141Event.java
*@FileTitle : MTY Rail Arrival Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.MtyRailConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0141 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0141HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0141HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0141Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 검색 조건 처리  */
	private MtyRailConditionVO mtyRailConditionVO = null;
	
	public EesEqr0141Event(){}

	public MtyRailConditionVO getMtyRailConditionVO() {
		return mtyRailConditionVO;
	}

	public void setMtyRailConditionVO(MtyRailConditionVO mtyRailConditionVO) {
		this.mtyRailConditionVO = mtyRailConditionVO;
	}
}