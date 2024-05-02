/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0027Event.java
*@FileTitle : Actual SKD Report Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.28 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * vop_vsk_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_vsk_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see vop_vsk_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVskSPPVSK0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VvdListByPortVO vvdListByPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VvdListByPortVO[] vvdListByPortVOs = null;
	
	private List<VvdListByPortVO> vvdListByPortVOS = null;

	public VopVskSPPVSK0001Event(){
		vvdListByPortVO = new VvdListByPortVO();
		vvdListByPortVOS = new ArrayList<VvdListByPortVO>();
	}

	/**
	 * @return the vvdListByPortVO
	 */
	public VvdListByPortVO getVvdListByPortVO() {
		return vvdListByPortVO;
	}

	/**
	 * @param VvdListByPortVO the VvdListByPortVO to set
	 */
	public void setVvdListByPortVO(VvdListByPortVO vvdListByPortVO) {
		this.vvdListByPortVO = vvdListByPortVO;
	}

	/**
	 * @return the actSkdMgtVOs
	 */
	public VvdListByPortVO[] getAVvdListByPortVOs() {
		VvdListByPortVO[] rtnVOs = null;
		if (this.vvdListByPortVOs != null) {
			rtnVOs = Arrays.copyOf(vvdListByPortVOs, vvdListByPortVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param actSkdMgtVOs the actSkdMgtVOs to set
	 */
	public void setVvdListByPortVOs(VvdListByPortVO[] vvdListByPortVOs) {
		if(vvdListByPortVOs != null){
			VvdListByPortVO[] tmpVOs = Arrays.copyOf(vvdListByPortVOs, vvdListByPortVOs.length);
			this.vvdListByPortVOs = tmpVOs;
		}
	}
}