/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0246Event.java
*@FileTitle : VopVsk0246Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.09.10 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0246 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0246HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0246HTMLAction 참조
 * @since J2EE 1.5
 */
public class VopVsk0246Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CanalBnkSavVO canalBnkSavVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CanalBnkSavVO[] canalBnkSavVOs = null;

	public VopVsk0246Event(){}

	/**
	 * @return CanalBnkSavVO
	 */
	public CanalBnkSavVO getCanalBnkSavVO() {
		return canalBnkSavVO;
	}

	/**
	 * @param canalBnkSavVO 
	 */
	public void setCanalBnkSavVO(CanalBnkSavVO canalBnkSavVO) {
		this.canalBnkSavVO = canalBnkSavVO;
	}

	/**
	 * @return CanalBnkSavVO[] 
	 */
	public CanalBnkSavVO[] getCanalBnkSavVOS() {
		CanalBnkSavVO[] rtnVOs =  null;
		if(this.canalBnkSavVOs != null){
			rtnVOs = new CanalBnkSavVO[canalBnkSavVOs.length];
			System.arraycopy(canalBnkSavVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return canalBnkSavVOs;
	}

	/**
	 * @param canalBnkSavVOs
	 */
	public void setCanalBnkSavVOS(CanalBnkSavVO[] canalBnkSavVOs) {
		if(canalBnkSavVOs != null){
			CanalBnkSavVO[] tmpVOs = new CanalBnkSavVO[canalBnkSavVOs.length];
			System.arraycopy(canalBnkSavVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.canalBnkSavVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.canalBnkSavVOs = canalBnkSavVOs;
	}
	
}