/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6003Event.java
*@FileTitle : CMPB Guideline- MQC Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.22 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.mqcrangecmpbguideline.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriCmpbGlineMqcRngVO;


/**
 * ESM_PRI_6003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriCmpbGlineMqcRngVO[] priCmpbGlineMqcRngVOs = null;

	public EsmPri6004Event(){}
	
	public void setPriCmpbGlineMqcRngVO(PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO){
		this. priCmpbGlineMqcRngVO = priCmpbGlineMqcRngVO;
	}

	public void setPriCmpbGlineMqcRngVOS(PriCmpbGlineMqcRngVO[] priCmpbGlineMqcRngVOs){
		this. priCmpbGlineMqcRngVOs = priCmpbGlineMqcRngVOs;
	}

	public PriCmpbGlineMqcRngVO getPriCmpbGlineMqcRngVO(){
		return priCmpbGlineMqcRngVO;
	}

	public PriCmpbGlineMqcRngVO[] getPriCmpbGlineMqcRngVOS(){
		return priCmpbGlineMqcRngVOs;
	}

}