/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVskESD0620001Event.java
*@FileTitle : VopVskESD0620001Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.02 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;
import java.util.List;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskDepRptVO;

/**
 * JMS Receive(ESD062-0001)에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  SchedulePlanningOperationJMSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see SchedulePlanningOperationJMSProxy 참조
 * @since J2EE 1.4
 */
public class VopVskESD0620001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private VskDepRptVO vskDepRptVO = null;
	
	private VskDepRptVO[] vskDepRptVOs = null;
	
	private List<VskDepRptVO> vskDepRptVOlist = null;

	public VopVskESD0620001Event(){}

	/**
	 * @return the vskDepRptVO
	 */
	public VskDepRptVO getVskDepRptVO() {
		return vskDepRptVO;
	}

	/**
	 * @param vskDepRptVO the vskDepRptVO to set
	 */
	public void setVskDepRptVO(VskDepRptVO vskDepRptVO) {
		this.vskDepRptVO = vskDepRptVO;
	}

	/**
	 * @return the vskDepRptVOs
	 */
	public VskDepRptVO[] getVskDepRptVOs() {
		VskDepRptVO[] rtnVOs = null;
		if (this.vskDepRptVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskDepRptVOs, this.vskDepRptVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param vskDepRptVOs the vskDepRptVOs to set
	 */
	public void setVskDepRptVOs(VskDepRptVO[] vskDepRptVOs) {
		if (vskDepRptVOs != null) {
			VskDepRptVO[] tmpVOs = Arrays.copyOf(vskDepRptVOs, vskDepRptVOs.length);
			this.vskDepRptVOs = tmpVOs;
		} // end if
	}

	/**
	 * @return the vskDepRptVOlist
	 */
	public List<VskDepRptVO> getVskDepRptVOlist() {
		return vskDepRptVOlist;
	}

	/**
	 * @param vskDepRptVOlist the vskDepRptVOlist to set
	 */
	public void setVskDepRptVOlist(List<VskDepRptVO> vskDepRptVOlist) {
		this.vskDepRptVOlist = vskDepRptVOlist;
	}


}