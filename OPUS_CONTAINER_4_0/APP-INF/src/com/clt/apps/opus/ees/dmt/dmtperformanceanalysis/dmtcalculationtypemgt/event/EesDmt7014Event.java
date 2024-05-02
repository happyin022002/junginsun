/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EesDmt7014Event.java
*@FileTitle : Tariff Type Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 오요한
*@LastVersion : 1.0
* 2012.04.16 오요한
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.WeekendVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_7014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang Hyo Keun
 * @see EES_DMT_7014HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt7014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private WeekendVO weekendVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private WeekendVO[] weekendVOs = null;

	public EesDmt7014Event(){}
	
	public void setWeekendVO(WeekendVO weekendVO){
		this. weekendVO = weekendVO;
	}

	public void setWeekendVOS(WeekendVO[] weekendVOs){
		if (weekendVOs != null) {
			WeekendVO[] tmpVOs = new WeekendVO[weekendVOs.length];
			System.arraycopy(weekendVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.weekendVOs = tmpVOs;
		}
	}

	public WeekendVO getWeekendVO(){
		return weekendVO;
	}

	public WeekendVO[] getweekendVOS(){
		WeekendVO[] tmpVOs = null;
		if (this.weekendVOs != null) {
			tmpVOs = new WeekendVO[weekendVOs.length];
			System.arraycopy(weekendVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}