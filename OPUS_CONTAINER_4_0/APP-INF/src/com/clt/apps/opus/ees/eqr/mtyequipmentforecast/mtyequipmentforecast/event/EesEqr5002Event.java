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
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event;

import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.clt.framework.support.layer.event.EventSupport;


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
	private MtyBalanceOptionVO[] mtyBalanceOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceRepoListVO mtyBalanceRepoListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MtyBalanceRepoListVO[] mtyBalanceRepoListVOs = null;

	public EesEqr5002Event(){}
	
	public void setMtyBalanceOptionVO(MtyBalanceOptionVO mtyBalanceOptionVO){
		this. mtyBalanceOptionVO = mtyBalanceOptionVO;
	}

	public void setMtyBalanceOptionVOS(MtyBalanceOptionVO[] mtyBalanceOptionVOs){
		if (mtyBalanceOptionVOs != null) {
			MtyBalanceOptionVO[] tmpVOs = new MtyBalanceOptionVO[mtyBalanceOptionVOs.length];
			System.arraycopy(mtyBalanceOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mtyBalanceOptionVOs = tmpVOs;
		}
	}
	public MtyBalanceOptionVO getMtyBalanceOptionVO(){
		return mtyBalanceOptionVO;
	}

	public MtyBalanceOptionVO[] getMtyBalanceOptionVOS(){
		MtyBalanceOptionVO[] tmpVOs = null;
		if (this.mtyBalanceOptionVOs != null) {
			tmpVOs = new MtyBalanceOptionVO[mtyBalanceOptionVOs.length];
			System.arraycopy(mtyBalanceOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setMtyBalanceRepoListVO(MtyBalanceRepoListVO mtyBalanceRepoListVO){
		this. mtyBalanceRepoListVO = mtyBalanceRepoListVO;
	}

	public void setMtyBalanceRepoListVOS(MtyBalanceRepoListVO[] mtyBalanceRepoListVOs){
		if (mtyBalanceRepoListVOs != null) {
			MtyBalanceRepoListVO[] tmpVOs = new MtyBalanceRepoListVO[mtyBalanceRepoListVOs.length];
			System.arraycopy(mtyBalanceRepoListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mtyBalanceRepoListVOs = tmpVOs;
		}
	}
	public MtyBalanceRepoListVO getMtyBalanceRepoListVO(){
		return mtyBalanceRepoListVO;
	}

	public MtyBalanceRepoListVO[] getMtyBalanceRepoListVOS(){
		MtyBalanceRepoListVO[] tmpVOs = null;
		if (this.mtyBalanceRepoListVOs != null) {
			tmpVOs = new MtyBalanceRepoListVO[mtyBalanceRepoListVOs.length];
			System.arraycopy(mtyBalanceRepoListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
}