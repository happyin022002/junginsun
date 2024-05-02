/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0024Event.java
*@FileTitle : VopVsk0024Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.09.09 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0024HTMLAction 참조
 * @since J2EE 1.5
 */
public class VopVsk0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CanalTransitTargetVvdVO canalTransitTargetVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CanalTransitTargetVvdVO[] canalTransitTargetVvdVOs = null;
	

	public VopVsk0024Event(){}
	
	

	/**
	 * @return CanalTransitTargetVvdVO
	 */
	public CanalTransitTargetVvdVO getCanalTransitTargetVvdVO() {
		return canalTransitTargetVvdVO;
	}
	
	/**
	 * @param CanalTransitTargetVvdVO canalTransitTargetVvdVO
	 */
	public void setCanalTransitTargetVvdVO(CanalTransitTargetVvdVO canalTransitTargetVvdVO) {
		this.canalTransitTargetVvdVO = canalTransitTargetVvdVO;
	}
	
	
		
	/**
	 * @return CanalTransitTargetVvdVO[] canalTransitTargetVvdVOs
	 */
	public CanalTransitTargetVvdVO[] getCanalTransitTargetVvdVOS() {
		CanalTransitTargetVvdVO[] rtnVOs =  null;
		if(this.canalTransitTargetVvdVOs != null){
			rtnVOs = new CanalTransitTargetVvdVO[canalTransitTargetVvdVOs.length];
			System.arraycopy(canalTransitTargetVvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return canalTransitTargetVvdVOs;
	}

	/**
	 * @param CanalTransitTargetVvdVO
	 */
	public void setCanalTransitTargetVvdVOS(CanalTransitTargetVvdVO[] canalTransitTargetVvdVOs) {
		if(canalTransitTargetVvdVOs != null){
			CanalTransitTargetVvdVO[] tmpVOs = new CanalTransitTargetVvdVO[canalTransitTargetVvdVOs.length];
			System.arraycopy(canalTransitTargetVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.canalTransitTargetVvdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.canalTransitTargetVvdVOs = canalTransitTargetVvdVOs;
	}
	

	
}