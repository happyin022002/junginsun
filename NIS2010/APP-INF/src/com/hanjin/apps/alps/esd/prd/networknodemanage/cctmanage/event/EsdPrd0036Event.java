/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0036Event.java
 *@FileTitle : Yard별 CCT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-09
 *@LastModifier : Jeongseon An
 *@LastVersion : 1.0
 * 2009-06-08 Jeongseon An
 * 1.0 최초 생성
 * CSR: N200903040130 20090608 e-NIS CCT MGMT by Yard UI 수정 관련 PRD SKD Logic 보완
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.event;

import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeongseon An
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0036Event extends EventSupport{

	private NewCCTManageVO newCCTManageVO;
	private NewCCTManageVO[] newCCTManageVOs;

	/**
	 * @return the NewCCTManageVO
	 */
	public NewCCTManageVO getNewCCTManageVO(){
		return newCCTManageVO;
	}

	/**
	 * @param NewCCTManageVO the NewCCTManageVO to set
	 */
	public void setNewCCTManageVO(NewCCTManageVO NewCCTManageVO){
		this.newCCTManageVO = NewCCTManageVO;
	}

	/**
	 * @return the newCCTManageVOs
	 */
	public NewCCTManageVO[] getNewCCTManageVOs(){
		return newCCTManageVOs;
	}

	/**
	 * @param newCCTManageVOs the newCCTManageVOs to set
	 */
	public void setNewCCTManageVOs(NewCCTManageVO[] newCCTManageVOs){
		this.newCCTManageVOs = newCCTManageVOs;
	}
}
