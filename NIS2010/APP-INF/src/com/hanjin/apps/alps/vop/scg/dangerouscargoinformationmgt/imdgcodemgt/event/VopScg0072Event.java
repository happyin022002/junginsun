/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0072Event.java
*@FileTitle : Segregation Simulation in a CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.27 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationInputVO;


/**
 * VOP_SCG_0072 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0072HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Uk
 * @see VOP_SCG_0072HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0072Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SegregationSimulationInputVO segregationSimulationInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SegregationSimulationInputVO[] segregationSimulationInputVOs = null;

	public VopScg0072Event(){}
	
	public void setSegregationSimulationInputVO(SegregationSimulationInputVO segregationSimulationInputVO){
		this. segregationSimulationInputVO = segregationSimulationInputVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setSegregationSimulationInputVOS(SegregationSimulationInputVO[] segregationSimulationInputVOs){
		if (segregationSimulationInputVOs != null) {
			SegregationSimulationInputVO[] tmpVOs = new SegregationSimulationInputVO[segregationSimulationInputVOs.length];
			System.arraycopy(segregationSimulationInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.segregationSimulationInputVOs = tmpVOs;
		}
	}

	public SegregationSimulationInputVO getSegregationSimulationInputVO(){
		return segregationSimulationInputVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public SegregationSimulationInputVO[] getSegregationSimulationInputVOS(){
		SegregationSimulationInputVO[] rtnVOs = null;
		if (this.segregationSimulationInputVOs != null) {
			rtnVOs = new SegregationSimulationInputVO[segregationSimulationInputVOs.length];
			System.arraycopy(segregationSimulationInputVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}