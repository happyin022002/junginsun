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
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationInputVO;
import com.clt.framework.support.layer.event.EventSupport;


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

	public void setSegregationSimulationInputVOS(SegregationSimulationInputVO[] segregationSimulationInputVOs){
		if(segregationSimulationInputVOs != null){
			SegregationSimulationInputVO[] tmpVOs = Arrays.copyOf(segregationSimulationInputVOs, segregationSimulationInputVOs.length);
			this.segregationSimulationInputVOs = tmpVOs;
		}
	}

	public SegregationSimulationInputVO getSegregationSimulationInputVO(){
		return segregationSimulationInputVO;
	}

	public SegregationSimulationInputVO[] getSegregationSimulationInputVOS(){
		SegregationSimulationInputVO[] rtnVOs = null;
		if (this.segregationSimulationInputVOs != null) {
			rtnVOs = Arrays.copyOf(segregationSimulationInputVOs, segregationSimulationInputVOs.length);
		}
		return rtnVOs;
	}

}