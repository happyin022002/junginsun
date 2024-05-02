/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVskESD0610001Event.java
*@FileTitle : VopVskESD0610001Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.01 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;
import java.util.List;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskNoonRptVO;

/**
 * JMS Receive(ESD061-0001)에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  SchedulePlanningOperationJMSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see SchedulePlanningOperationJMSProxy 참조
 * @since J2EE 1.4
 */
public class VopVskESD0610001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private VskNoonRptVO vskNoonRptVO = null;
	
	private VskNoonRptVO[] vskNoonRptVOs = null;
	
	private List<VskNoonRptVO> vskNoonRptVOlist = null;

	public VopVskESD0610001Event(){}

	/**
	 * @return the vskNoonRptVO
	 */
	public VskNoonRptVO getVskNoonRptVO() {
		return vskNoonRptVO;
	}

	/**
	 * @param vskNoonRptVO the vskNoonRptVO to set
	 */
	public void setVskNoonRptVO(VskNoonRptVO vskNoonRptVO) {
		this.vskNoonRptVO = vskNoonRptVO;
	}

	/**
	 * @return the vskNoonRptVOs
	 */
	public VskNoonRptVO[] getVskNoonRptVOs() {
		VskNoonRptVO[] rtnVOs = null;
		if (this.vskNoonRptVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskNoonRptVOs, this.vskNoonRptVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param vskNoonRptVOs the vskNoonRptVOs to set
	 */
	public void setVskNoonRptVOs(VskNoonRptVO[] vskNoonRptVOs) {
		if (vskNoonRptVOs != null) {
			VskNoonRptVO[] tmpVOs = Arrays.copyOf(vskNoonRptVOs, vskNoonRptVOs.length);
			this.vskNoonRptVOs = tmpVOs;
		} // end if
	}

	/**
	 * @return the vskNoonRptVOlist
	 */
	public List<VskNoonRptVO> getVskNoonRptVOlist() {
		return vskNoonRptVOlist;
	}

	/**
	 * @param vskNoonRptVOlist the vskNoonRptVOlist to set
	 */
	public void setVskNoonRptVOlist(List<VskNoonRptVO> vskNoonRptVOlist) {
		this.vskNoonRptVOlist = vskNoonRptVOlist;
	}


}