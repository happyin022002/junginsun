/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpSpp0006Event.java
*@FileTitle : Canal Transit Schedule Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.23
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2011.11.23  Park Yeon-Jin
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event;

import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTransitScheduleVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * EXP_SPP_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EXP_SPP_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Yeon-Jin
 * @see EXP_SPP_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class ExpSpp0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CanalTransitScheduleVO canalTransitScheduleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CanalTransitScheduleVO[] canalTransitScheduleVOs = null;	
	
	public ExpSpp0006Event(){}

	/**
	 * @return the canalTransitScheduleVO
	 */
	public CanalTransitScheduleVO getCanalTransitScheduleVO() {
		return canalTransitScheduleVO;
	}

	/**
	 * @param canalTransitScheduleVO the canalTransitScheduleVO to set
	 */
	public void setCanalTransitScheduleVO(
			CanalTransitScheduleVO canalTransitScheduleVO) {
		this.canalTransitScheduleVO = canalTransitScheduleVO;
	}

	/**
	 * @return the canalTransitScheduleVOs
	 */
	public CanalTransitScheduleVO[] getCanalTransitScheduleVOs() {
		return canalTransitScheduleVOs;
	}

	/**
	 * @param canalTransitScheduleVOs the canalTransitScheduleVOs to set
	 */
	public void setCanalTransitScheduleVOs(
			CanalTransitScheduleVO[] canalTransitScheduleVOs) {
		this.canalTransitScheduleVOs = canalTransitScheduleVOs;
	}



}