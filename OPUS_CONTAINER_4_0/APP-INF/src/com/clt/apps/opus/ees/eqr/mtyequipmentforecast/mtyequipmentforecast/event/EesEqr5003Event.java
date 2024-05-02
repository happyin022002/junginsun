/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim5003Event.java
*@FileTitle : +/- Others Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event;

import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_5003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_5003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_5003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr5003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceOptionVO mtyBalanceOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MtyBalanceOptionVO[] mtyBalanceOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalRptOtrVO mtyBalRptOtrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MtyBalRptOtrVO[] mtyBalRptOtrVOs = null;

	public EesEqr5003Event(){}
	
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
	
	
	public void setMtyBalRptOtrVO(MtyBalRptOtrVO mtyBalRptOtrVO){
		this. mtyBalRptOtrVO = mtyBalRptOtrVO;
	}

	public void setMtyBalRptOtrVOS(MtyBalRptOtrVO[] mtyBalRptOtrVOs){
		if (mtyBalRptOtrVOs != null) {
			MtyBalRptOtrVO[] tmpVOs = new MtyBalRptOtrVO[mtyBalRptOtrVOs.length];
			System.arraycopy(mtyBalRptOtrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mtyBalRptOtrVOs = tmpVOs;
		}
	}
	public MtyBalRptOtrVO getMtyBalRptOtrVO(){
		return mtyBalRptOtrVO;
	}

	public MtyBalRptOtrVO[] getMtyBalRptOtrVOS(){
		MtyBalRptOtrVO[] tmpVOs = null;
		if (this.mtyBalRptOtrVOs != null) {
			tmpVOs = new MtyBalRptOtrVO[mtyBalRptOtrVOs.length];
			System.arraycopy(mtyBalRptOtrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
}