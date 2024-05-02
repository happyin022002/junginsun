/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EtsEqr0001Event.java
*@FileTitle : ETS 연동 OffHire Return WebService
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.10 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0081HTMLAction 참조
 * @since J2EE 1.6
 */

public class EtsEqr0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** ETS 연동을 위한 입력 Value Object  */
	private ModifyFromTrsOffHireReturnVO modifyFromTrsOffHireReturnVO = null;

	public EtsEqr0001Event(){}
	
	/**
	 * ModifyFromTrsOffHireReturnVO 를 셋팅하기위한 생성자
	 *  
	 * @param ModifyFromTrsOffHireReturnVO modifyFromTrsOffHireReturnVO
	 */
	public EtsEqr0001Event(ModifyFromTrsOffHireReturnVO modifyFromTrsOffHireReturnVO){
		this.modifyFromTrsOffHireReturnVO = modifyFromTrsOffHireReturnVO;
	}

	/**
	 * ModifyFromTrsOffHireReturnVO GET 메소드
	 *  
	 * @return ModifyFromTrsOffHireReturnVO
	 */
	public ModifyFromTrsOffHireReturnVO getModifyFromTrsOffHireReturnVO() {
		return modifyFromTrsOffHireReturnVO;
	}

	/**
	 * ModifyFromTrsOffHireReturnVO SET 메소드
	 *  
	 * @param ModifyFromTrsOffHireReturnVO modifyFromTrsOffHireReturnVO
	 */
	public void setModifyFromTrsOffHireReturnVO(
			ModifyFromTrsOffHireReturnVO modifyFromTrsOffHireReturnVO) {
		this.modifyFromTrsOffHireReturnVO = modifyFromTrsOffHireReturnVO;
	}
	
	
}