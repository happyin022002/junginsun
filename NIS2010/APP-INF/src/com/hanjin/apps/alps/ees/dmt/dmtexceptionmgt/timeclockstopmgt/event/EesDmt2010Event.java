/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiDmt2010Event.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockStopParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_DMT_2010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_DMT_2010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see EES_DMT_2010HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt2010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TimeClockStopParmVO timeClockStopParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DmtTimeClockStopVO dmtTimeClockStopVO = null;

	public EesDmt2010Event(){}
	
	public void setTimeClockStopParmVO(TimeClockStopParmVO timeClockStopParmVO){
		this.timeClockStopParmVO = timeClockStopParmVO;
	}

	public void setDmtTimeClockStopVO(DmtTimeClockStopVO dmtTimeClockStopVO){
		this.dmtTimeClockStopVO = dmtTimeClockStopVO;
	}

	public TimeClockStopParmVO getTimeClockStopParmVO(){
		return timeClockStopParmVO;
	}

	public DmtTimeClockStopVO getDmtTimeClockStopVO(){
		return dmtTimeClockStopVO;
	}

}