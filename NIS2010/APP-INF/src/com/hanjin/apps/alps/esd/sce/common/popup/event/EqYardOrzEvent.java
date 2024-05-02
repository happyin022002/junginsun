/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqYardOrzEvent.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.30 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.event;

import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.EQYARDManageConditionVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.EQYARDManageVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EsdSce114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EsdSce114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Shin Han Sung
 * @see EsdSce114HTMLAction 참조
 * @since J2EE 1.6
 */

public class EqYardOrzEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EQYARDManageVO eqYARDManageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EQYARDManageVO[] eqYARDManageVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EQYARDManageConditionVO eqYARDManageConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EQYARDManageConditionVO[] eqYARDManageConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComOfficeManagementVO comOfficeManagementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComOfficeManagementVO[] comOfficeManagementVOs = null;

	public EQYARDManageVO getEqYARDManageVO() {
		return eqYARDManageVO;
	}

	public void setEqYARDManageVO(EQYARDManageVO eqYARDManageVO) {
		this.eqYARDManageVO = eqYARDManageVO;
	}

	public EQYARDManageVO[] getEqYARDManageVOs() {
		return eqYARDManageVOs;
	}

	public void setEqYARDManageVOs(EQYARDManageVO[] eqYARDManageVOs) {
		this.eqYARDManageVOs = eqYARDManageVOs;
	}

	public EQYARDManageConditionVO getEqYARDManageConditionVO() {
		return eqYARDManageConditionVO;
	}

	public void setEqYARDManageConditionVO(
			EQYARDManageConditionVO eqYARDManageConditionVO) {
		this.eqYARDManageConditionVO = eqYARDManageConditionVO;
	}

	public EQYARDManageConditionVO[] getEqYARDManageConditionVOs() {
		return eqYARDManageConditionVOs;
	}

	public void setEqYARDManageConditionVOs(
			EQYARDManageConditionVO[] eqYARDManageConditionVOs) {
		this.eqYARDManageConditionVOs = eqYARDManageConditionVOs;
	}

	public EqYardOrzEvent(){}
	
	public void setComOfficeManagementVO(ComOfficeManagementVO comOfficeManagementVO){
		this. comOfficeManagementVO = comOfficeManagementVO;
	}

	public void setComOfficeManagementVOS(ComOfficeManagementVO[] comOfficeManagementVOs){
		this. comOfficeManagementVOs = comOfficeManagementVOs;
	}

	public ComOfficeManagementVO getComOfficeManagementVO(){
		return comOfficeManagementVO;
	}

	public ComOfficeManagementVO[] getComOfficeManagementVOS(){
		return comOfficeManagementVOs;
	}

}