/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0144Event.java
*@FileTitle : EesEqr0144Event
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.29
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.11.29 
* 1.0 Creation
* 2010.12.03 양봉준 [CHM-201007345-01] EES_EQR_0144 화면 신규 개발
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0144 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0144HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0144HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0144Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmptyRepoResultOptionVO emptyRepoResultOptionVO = null;

	public EesEqr0144Event(){}

	/**
	 * @return the emptyRepoResultOptionVO
	 */
	public EmptyRepoResultOptionVO getEmptyRepoResultOptionVO() {
		return emptyRepoResultOptionVO;
	}

	/**
	 * @param emptyRepoResultOptionVO the emptyRepoResultOptionVO to set
	 */
	public void setEmptyRepoResultOptionVO(EmptyRepoResultOptionVO emptyRepoResultOptionVO) {
		this.emptyRepoResultOptionVO = emptyRepoResultOptionVO;
	}

}