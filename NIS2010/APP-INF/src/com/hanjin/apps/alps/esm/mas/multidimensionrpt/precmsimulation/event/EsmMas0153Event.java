/*=========================================================

*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0153Event.java
*@FileTitle : Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.15 송호진
* 1.0 Creation
* 2012.02.20 김종준 [CHM-201216268-01] [MAS] Pre CM/OP 화면 Backandjob로 조회로  로직 변경
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.PreCMSimulationCostVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.PreCMSimulationRoutVO;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;


/**
 * ESM_MAS_0153 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0153HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_MAS_0153HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0153Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PreCMSimulationCostVO preCMSimulationCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PreCMSimulationCostVO[] preCMSimulationCostVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PreCMSimulationRoutVO preCMSimulationRoutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PreCMSimulationRoutVO[] preCMSimulationRoutVOs = null;

	private SearchCondition0153VO searchCondition0153VO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	
	
	public EsmMas0153Event(){}
	
	public void setPreCMSimulationCostVO(PreCMSimulationCostVO preCMSimulationCostVO){
		this. preCMSimulationCostVO = preCMSimulationCostVO;
	}

	public void setPreCMSimulationCostVOS(PreCMSimulationCostVO[] preCMSimulationCostVOs){
		this. preCMSimulationCostVOs = preCMSimulationCostVOs;
	}

	public void setPreCMSimulationRoutVO(PreCMSimulationRoutVO preCMSimulationRoutVO){
		this. preCMSimulationRoutVO = preCMSimulationRoutVO;
	}

	public void setPreCMSimulationRoutVOS(PreCMSimulationRoutVO[] preCMSimulationRoutVOs){
		this. preCMSimulationRoutVOs = preCMSimulationRoutVOs;
	}

	/**
	 * @return the comBakEndJbVO
	 */
	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}
	
	
	public PreCMSimulationCostVO getPreCMSimulationCostVO(){
		return preCMSimulationCostVO;
	}

	public PreCMSimulationCostVO[] getPreCMSimulationCostVOS(){
		return preCMSimulationCostVOs;
	}

	public PreCMSimulationRoutVO getPreCMSimulationRoutVO(){
		return preCMSimulationRoutVO;
	}

	public PreCMSimulationRoutVO[] getPreCMSimulationRoutVOS(){
		return preCMSimulationRoutVOs;
	}

	public SearchCondition0153VO getSearchCondition0153VO() {
		return searchCondition0153VO;
	}

	public void setSearchCondition0153VO(SearchCondition0153VO searchCondition0153VO) {
		this.searchCondition0153VO = searchCondition0153VO;
	}
	
	/**
	 * @param comBakEndJbVO the comBakEndJbVO to set
	 */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}	
}