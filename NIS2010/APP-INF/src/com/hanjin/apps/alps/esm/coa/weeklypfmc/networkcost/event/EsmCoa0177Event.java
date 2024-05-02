/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmCoa0177Event.java
*@FileTitle : Lane Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.02.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.LaneTable1CycleVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_0177 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0177HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see ESM_COA_0177HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0177Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private LaneTable1CycleVO laneTable1CycleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LaneTable1CycleVO[] laneTable1CycleVOs = null;

	public EsmCoa0177Event(){}

	/**
	 * @return the laneTable1CycleVO
	 */
	public LaneTable1CycleVO getLaneTable1CycleVO() {
		return laneTable1CycleVO;
	}

	/**
	 * @param laneTable1CycleVO the laneTable1CycleVO to set
	 */
	public void setLaneTable1CycleVO(LaneTable1CycleVO laneTable1CycleVO) {
		this.laneTable1CycleVO = laneTable1CycleVO;
	}

	/**
	 * @return the laneTable1CycleVOs
	 */
	public LaneTable1CycleVO[] getLaneTable1CycleVOs() {
		return laneTable1CycleVOs;
	}

	/**
	 * @param laneTable1CycleVOs the laneTable1CycleVOs to set
	 */
	public void setLaneTable1CycleVOs(LaneTable1CycleVO[] laneTable1CycleVOs) {
		this.laneTable1CycleVOs = laneTable1CycleVOs;
	}

	
	
}