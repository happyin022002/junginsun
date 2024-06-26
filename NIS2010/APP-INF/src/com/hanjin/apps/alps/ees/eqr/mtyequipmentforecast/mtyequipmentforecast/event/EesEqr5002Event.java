/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim5002Event.java
*@FileTitle : MTY Repo In/ Out Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.11 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event;

import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_5002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_5002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_5002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr5002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceOptionVO mtyBalanceOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MtyBalanceOptionVO[] mtyBalanceOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceRepoListVO mtyBalanceRepoListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MtyBalanceRepoListVO[] mtyBalanceRepoListVOs = null;

	public EesEqr5002Event(){}
	
	public void setMtyBalanceOptionVO(MtyBalanceOptionVO mtyBalanceOptionVO){
		this. mtyBalanceOptionVO = mtyBalanceOptionVO;
	}

	public void setMtyBalanceOptionVOS(MtyBalanceOptionVO[] mtyBalanceOptionVOs){
		this. mtyBalanceOptionVOs = mtyBalanceOptionVOs;
	}
	public MtyBalanceOptionVO getMtyBalanceOptionVO(){
		return mtyBalanceOptionVO;
	}

	public MtyBalanceOptionVO[] getMtyBalanceOptionVOS(){
		return mtyBalanceOptionVOs;
	}
	
	
	public void setMtyBalanceRepoListVO(MtyBalanceRepoListVO mtyBalanceRepoListVO){
		this. mtyBalanceRepoListVO = mtyBalanceRepoListVO;
	}

	public void setMtyBalanceRepoListVOS(MtyBalanceRepoListVO[] mtyBalanceRepoListVOs){
		this. mtyBalanceRepoListVOs = mtyBalanceRepoListVOs;
	}
	public MtyBalanceRepoListVO getMtyBalanceRepoListVO(){
		return mtyBalanceRepoListVO;
	}

	public MtyBalanceRepoListVO[] getMtyBalanceRepoListVOS(){
		return mtyBalanceRepoListVOs;
	}	
}