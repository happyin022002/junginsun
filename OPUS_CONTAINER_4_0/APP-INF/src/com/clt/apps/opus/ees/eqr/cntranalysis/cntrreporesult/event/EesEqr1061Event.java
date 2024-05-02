/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0144Event.java
*@FileTitle : EesEqr0144Event
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.event;

import com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0144 PDTO(Data Transfer Object including Parameters)<br>
 * @author 
 * @see EES_EQR_1061HTMLAction 
 * @since J2EE 1.6
 */

public class EesEqr1061Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object   */
	private EmptyRepoResultOptionVO emptyRepoResultOptionVO = null;

	public EesEqr1061Event(){}

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