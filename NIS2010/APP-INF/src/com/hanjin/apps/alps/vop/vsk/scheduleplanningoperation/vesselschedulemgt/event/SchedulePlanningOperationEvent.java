/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SchedulePlanningOperationEvent.java
*@FileTitle : SchedulePlanningOperationEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.09.02 함대성
* 1.0 Creation
* 
* History
* 2015.07.20 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskCustSkdEdiSetVO;

/**
 * JMS Receive(ESD062-0001)에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  SchedulePlanningOperationJMSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ds Ham
 * @see SchedulePlanningOperationJMSProxy 참조
 * @since J2EE 1.4
 */
public class SchedulePlanningOperationEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private VskCustSkdEdiSetVO vskCustSkdEdiSetVO = null;
	
	private VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs = null;
	
	private List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOlist = null;

	public SchedulePlanningOperationEvent(){}

	/**
	 * @return the vskCustSkdEdiSetVO
	 */
	public VskCustSkdEdiSetVO getVskCustSkdEdiSetVO() {
		return vskCustSkdEdiSetVO;
	}

	/**
	 * @param vskCustSkdEdiSetVO the vskCustSkdEdiSetVO to set
	 */
	public void setVskCustSkdEdiSetVO(VskCustSkdEdiSetVO vskCustSkdEdiSetVO) {
		this.vskCustSkdEdiSetVO = vskCustSkdEdiSetVO;
	}

	/**
	 * @return the vskCustSkdEdiSetVOs
	 */
	public VskCustSkdEdiSetVO[] getVskCustSkdEdiSetVOs() {
//		return vskCustSkdEdiSetVOs;
		VskCustSkdEdiSetVO[] rtnVOs = null;
		if (this.vskCustSkdEdiSetVOs != null) {
			rtnVOs = new VskCustSkdEdiSetVO[vskCustSkdEdiSetVOs.length];
			System.arraycopy(vskCustSkdEdiSetVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param vskCustSkdEdiSetVOs the vskCustSkdEdiSetVOs to set
	 */
	public void setVskCustSkdEdiSetVOs(VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs) {
//		this.vskCustSkdEdiSetVOs = vskCustSkdEdiSetVOs;
		if (vskCustSkdEdiSetVOs != null) {
			VskCustSkdEdiSetVO[] tmpVOs = new VskCustSkdEdiSetVO[vskCustSkdEdiSetVOs.length];
			System.arraycopy(vskCustSkdEdiSetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskCustSkdEdiSetVOs = tmpVOs;
		}
	}

	/**
	 * @return the vskCustSkdEdiSetVOlist
	 */
	public List<VskCustSkdEdiSetVO> getVskCustSkdEdiSetVOlist() {
		return vskCustSkdEdiSetVOlist;
	}

	/**
	 * @param vskCustSkdEdiSetVOlist the vskCustSkdEdiSetVOlist to set
	 */
	public void setVskCustSkdEdiSetVOlist(List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOlist) {
		this.vskCustSkdEdiSetVOlist = vskCustSkdEdiSetVOlist;
	}

}