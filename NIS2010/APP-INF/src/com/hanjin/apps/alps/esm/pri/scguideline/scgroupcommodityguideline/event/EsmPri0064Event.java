/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri0064Event.java
*@FileTitle : TPW Group Commodity Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.event;

import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.PriGriGrpCmdtVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;


/**
 * ESM_PRI_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0064HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScgGrpCmdtVO priScgGrpCmdtVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgGrpCmdtVO priSgGrpCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriGriGrpCmdtVO[] priGriGrpCmdtVOs = null;

	public EsmPri0064Event(){}

	/**
	 * @return the priScgGrpCmdtVO
	 */
	public PriScgGrpCmdtVO getPriScgGrpCmdtVO () {
		return priScgGrpCmdtVO;
	}

	/**
	 * @param priScgGrpCmdtVO the priScgGrpCmdtVO to set
	 */
	public void setPriScgGrpCmdtVO (PriScgGrpCmdtVO priScgGrpCmdtVO) {
		this.priScgGrpCmdtVO = priScgGrpCmdtVO;
	}

	/**
	 * @return the priSgGrpCmdtVO
	 */
	public PriSgGrpCmdtVO getPriSgGrpCmdtVO () {
		return priSgGrpCmdtVO;
	}

	/**
	 * @param priSgGrpCmdtVO the priSgGrpCmdtVO to set
	 */
	public void setPriSgGrpCmdtVO (PriSgGrpCmdtVO priSgGrpCmdtVO) {
		this.priSgGrpCmdtVO = priSgGrpCmdtVO;
	}

	/**
	 * @return the priGriGrpCmdtVOs
	 */
	public PriGriGrpCmdtVO[] getPriGriGrpCmdtVOS () {
		return priGriGrpCmdtVOs;
	}

	/**
	 * @param priGriGrpCmdtVOs the priGriGrpCmdtVOs to set
	 */
	public void setPriGriGrpCmdtVOS (PriGriGrpCmdtVO[] priGriGrpCmdtVOs) {
		this.priGriGrpCmdtVOs = priGriGrpCmdtVOs;
	}
	
}