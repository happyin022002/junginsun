/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1046Event.java
*@FileTitle : +/- Others Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_1046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_1046HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1046Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceOptionVO mtyBalanceOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MtyBalanceOptionVO[] mtyBalanceOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalRptOtrVO mtyBalRptOtrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MtyBalRptOtrVO[] mtyBalRptOtrVOs = null;

	public EesEqr1046Event(){}
	
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
	
	
	public void setMtyBalRptOtrVO(MtyBalRptOtrVO mtyBalRptOtrVO){
		this. mtyBalRptOtrVO = mtyBalRptOtrVO;
	}

	public void setMtyBalRptOtrVOS(MtyBalRptOtrVO[] mtyBalRptOtrVOs){
		this. mtyBalRptOtrVOs = mtyBalRptOtrVOs;
	}
	public MtyBalRptOtrVO getMtyBalRptOtrVO(){
		return mtyBalRptOtrVO;
	}

	public MtyBalRptOtrVO[] getMtyBalRptOtrVOS(){
		return mtyBalRptOtrVOs;
	}	
}